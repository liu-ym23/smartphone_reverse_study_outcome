package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments;
    boolean mResumed;
    boolean mStopped;

    class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, FragmentOnAttachListener {
        final /* synthetic */ FragmentActivity this$0;

        public HostCallbacks(FragmentActivity r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // androidx.activity.result.ActivityResultRegistryOwner
        @NonNull
        public ActivityResultRegistry getActivityResultRegistry() {
            return this.this$0.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.LifecycleOwner
        @NonNull
        public Lifecycle getLifecycle() {
            return this.this$0.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        @NonNull
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.this$0.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        @NonNull
        public ViewModelStore getViewModelStore() {
            return this.this$0.getViewModelStore();
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public void onAttachFragment(@NonNull FragmentManager r10, @NonNull Fragment r11) {
            this.this$0.onAttachFragment(r11);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onDump(@NonNull String r10, @Nullable FileDescriptor r11, @NonNull PrintWriter r12, @Nullable String[] r13) {
            this.this$0.dump(r10, r11, r12, r13);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        @Nullable
        public View onFindViewById(int r10) {
            return this.this$0.findViewById(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.fragment.app.FragmentHostCallback
        public FragmentActivity onGetHost() {
            return this.this$0;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public /* bridge */ /* synthetic */ FragmentActivity onGetHost() {
            return onGetHost();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        @NonNull
        public LayoutInflater onGetLayoutInflater() {
            return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public int onGetWindowAnimations() {
            Window r10 = this.this$0.getWindow();
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            Window r10 = this.this$0.getWindow();
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.peekDecorView() == null) goto L7;
            return true;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onHasWindowAnimations() {
            if (this.this$0.getWindow() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldSaveFragmentState(@NonNull Fragment r10) {
            return !this.this$0.isFinishing();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldShowRequestPermissionRationale(@NonNull String r10) {
            return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, r10);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onSupportInvalidateOptionsMenu() {
            this.this$0.supportInvalidateOptionsMenu();
        }
    }

    public FragmentActivity() {
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    @ContentView
    public FragmentActivity(@LayoutRes int r10) {
        super(r10);
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().registerSavedStateProvider(FRAGMENTS_TAG, new AnonymousClass1(this));
        addOnContextAvailableListener(new AnonymousClass2(this));
    }

    private static boolean markState(FragmentManager r10, Lifecycle.State r11) {
        Iterator<Fragment> r12 = r10.getFragments().iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L19;
        Fragment r14 = r12.next();
        if (r14 == null) goto L4;
        if (r14.getHost() == null) goto L11;
        r13 = r13 | markState(r14.getChildFragmentManager(), r11);
    L11:
        FragmentViewLifecycleOwner r15 = r14.mViewLifecycleOwner;
        if (r15 == null) goto L17;
        if (r15.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L17;
        r14.mViewLifecycleOwner.setCurrentState(r11);
        r13 = true;
    L17:
        if (r14.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
        r14.mLifecycleRegistry.setCurrentState(r11);
        r13 = true;
        goto L4
    L19:
        return r13;
    }

    @Nullable
    final View dispatchFragmentsOnCreateView(@Nullable View r10, @NonNull String r11, @NonNull Context r12, @NonNull AttributeSet r13) {
        return this.mFragments.onCreateView(r10, r11, r12, r13);
    }

    @Override // android.app.Activity
    public void dump(@NonNull String r10, @Nullable FileDescriptor r11, @NonNull PrintWriter r12, @Nullable String[] r13) {
        super.dump(r10, r11, r12, r13);
        r12.print(r10);
        r12.print("Local FragmentActivity ");
        r12.print(Integer.toHexString(System.identityHashCode(this)));
        r12.println(" State:");
        String r14 = r10 + "  ";
        r12.print(r14);
        r12.print("mCreated=");
        r12.print(this.mCreated);
        r12.print(" mResumed=");
        r12.print(this.mResumed);
        r12.print(" mStopped=");
        r12.print(this.mStopped);
        if (getApplication() == null) goto L5;
        LoaderManager.getInstance(this).dump(r14, r11, r12, r13);
    L5:
        this.mFragments.getSupportFragmentManager().dump(r10, r11, r12, r13);
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @NonNull
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    void markFragmentsCreated() {
    L3:
        if (markState(getSupportFragmentManager(), Lifecycle.State.CREATED) == true) goto L3;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    protected void onActivityResult(int r10, int r11, @Nullable Intent r12) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(r10, r11, r12);
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment r10) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration r10) {
        this.mFragments.noteStateNotSaved();
        super.onConfigurationChanged(r10);
        this.mFragments.dispatchConfigurationChanged(r10);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r10, @NonNull Menu r11) {
        if (r10 != 0) goto L6;
        boolean r12 = super.onCreatePanelMenu(r10, r11);
        return this.mFragments.dispatchCreateOptionsMenu(r11, getMenuInflater()) | r12;
    L6:
        return super.onCreatePanelMenu(r10, r11);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View r10, @NonNull String r11, @NonNull Context r12, @NonNull AttributeSet r13) {
        View r14 = dispatchFragmentsOnCreateView(r10, r11, r12, r13);
        if (r14 == null) goto L5;
        return r14;
    L5:
        return super.onCreateView(r10, r11, r12, r13);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String r10, @NonNull Context r11, @NonNull AttributeSet r12) {
        View r13 = dispatchFragmentsOnCreateView(null, r10, r11, r12);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return super.onCreateView(r10, r11, r12);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r10, @NonNull MenuItem r11) {
        if (super.onMenuItemSelected(r10, r11) == false) goto L6;
        return true;
    L6:
        if (r10 == 0) goto L14;
        if (r10 == 6) goto L12;
        return false;
    L12:
        return this.mFragments.dispatchContextItemSelected(r11);
    L14:
        return this.mFragments.dispatchOptionsItemSelected(r11);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean r10) {
        this.mFragments.dispatchMultiWindowModeChanged(r10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent r10) {
        this.mFragments.noteStateNotSaved();
        super.onNewIntent(r10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r10, @NonNull Menu r11) {
        if (r10 != 0) goto L4;
        this.mFragments.dispatchOptionsMenuClosed(r11);
    L4:
        super.onPanelClosed(r10, r11);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r10) {
        this.mFragments.dispatchPictureInPictureModeChanged(r10);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    protected boolean onPrepareOptionsPanel(@Nullable View r10, @NonNull Menu r11) {
        return super.onPreparePanel(0, r10, r11);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r10, @Nullable View r11, @NonNull Menu r12) {
        if (r10 != 0) goto L6;
        boolean r13 = onPrepareOptionsPanel(r11, r12);
        return this.mFragments.dispatchPrepareOptionsMenu(r12) | r13;
    L6:
        return super.onPreparePanel(r10, r11, r12);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onRequestPermissionsResult(int r10, @NonNull String[] r11, @NonNull int[] r12) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(r10, r11, r12);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.mFragments.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.mFragments.noteStateNotSaved();
        super.onStart();
        this.mStopped = false;
        if (this.mCreated == true) goto L5;
        this.mCreated = true;
        this.mFragments.dispatchActivityCreated();
    L5:
        this.mFragments.execPendingActions();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.mFragments.dispatchStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback r10) {
        ActivityCompat.setEnterSharedElementCallback(this, r10);
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback r10) {
        ActivityCompat.setExitSharedElementCallback(this, r10);
    }

    public void startActivityFromFragment(@NonNull Fragment r10, @SuppressLint({"UnknownNullness"}) Intent r11, int r12) {
        startActivityFromFragment(r10, r11, r12, null);
    }

    public void startActivityFromFragment(@NonNull Fragment r10, @SuppressLint({"UnknownNullness"}) Intent r11, int r12, @Nullable Bundle r13) {
        if (r12 != (-1)) goto L6;
        ActivityCompat.startActivityForResult(this, r11, -1, r13);
        return;
    L6:
        r10.startActivityForResult(r11, r12, r13);
    }

    @Deprecated
    public void startIntentSenderFromFragment(@NonNull Fragment r10, @SuppressLint({"UnknownNullness"}) IntentSender r11, int r12, @Nullable Intent r13, int r14, int r15, int r16, @Nullable Bundle r17) {
        if (r12 != (-1)) goto L6;
        ActivityCompat.startIntentSenderForResult(this, r11, r12, r13, r14, r15, r16, r17);
        return;
    L6:
        r10.startIntentSenderForResult(r11, r12, r13, r14, r15, r16, r17);
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int r10) {
    }
}
