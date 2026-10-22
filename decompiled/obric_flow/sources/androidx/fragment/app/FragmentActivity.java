package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
import androidx.core.app.ActivityCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments;
    boolean mResumed;
    boolean mStopped;

    public class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements OnConfigurationChangedProvider, OnTrimMemoryProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener, MenuHost {
        final /* synthetic */ FragmentActivity this$0;

        public HostCallbacks(FragmentActivity r5) {
            this.this$0 = r5;
            super(r5);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(@NonNull MenuProvider r5) {
            this.this$0.addMenuProvider(r5);
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> r5) {
            this.this$0.addOnConfigurationChangedListener(r5);
        }

        @Override // androidx.core.app.OnMultiWindowModeChangedProvider
        public void addOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> r5) {
            this.this$0.addOnMultiWindowModeChangedListener(r5);
        }

        @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
        public void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> r5) {
            this.this$0.addOnPictureInPictureModeChangedListener(r5);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void addOnTrimMemoryListener(@NonNull Consumer<Integer> r5) {
            this.this$0.addOnTrimMemoryListener(r5);
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

        @Override // androidx.savedstate.SavedStateRegistryOwner
        @NonNull
        public SavedStateRegistry getSavedStateRegistry() {
            return this.this$0.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        @NonNull
        public ViewModelStore getViewModelStore() {
            return this.this$0.getViewModelStore();
        }

        @Override // androidx.core.view.MenuHost
        public void invalidateMenu() {
            this.this$0.invalidateMenu();
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public void onAttachFragment(@NonNull FragmentManager r5, @NonNull Fragment r10) {
            this.this$0.onAttachFragment(r10);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onDump(@NonNull String r5, @Nullable FileDescriptor r10, @NonNull PrintWriter r11, @Nullable String[] r12) {
            this.this$0.dump(r5, r10, r11, r12);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        @Nullable
        public View onFindViewById(int r5) {
            return this.this$0.findViewById(r5);
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
            Window r5 = this.this$0.getWindow();
            if (r5 != null) goto L6;
            return 0;
        L6:
            return r5.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            Window r5 = this.this$0.getWindow();
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if (r5.peekDecorView() == null) goto L7;
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
        public boolean onShouldSaveFragmentState(@NonNull Fragment r5) {
            return !this.this$0.isFinishing();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldShowRequestPermissionRationale(@NonNull String r5) {
            return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, r5);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onSupportInvalidateOptionsMenu() {
            invalidateMenu();
        }

        @Override // androidx.core.view.MenuHost
        public void removeMenuProvider(@NonNull MenuProvider r5) {
            this.this$0.removeMenuProvider(r5);
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> r5) {
            this.this$0.removeOnConfigurationChangedListener(r5);
        }

        @Override // androidx.core.app.OnMultiWindowModeChangedProvider
        public void removeOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> r5) {
            this.this$0.removeOnMultiWindowModeChangedListener(r5);
        }

        @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
        public void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> r5) {
            this.this$0.removeOnPictureInPictureModeChangedListener(r5);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void removeOnTrimMemoryListener(@NonNull Consumer<Integer> r5) {
            this.this$0.removeOnTrimMemoryListener(r5);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(@NonNull MenuProvider r5, @NonNull LifecycleOwner r10) {
            this.this$0.addMenuProvider(r5, r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.fragment.app.FragmentHostCallback
        public FragmentActivity onGetHost() {
            return this.this$0;
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(@NonNull MenuProvider r5, @NonNull LifecycleOwner r10, @NonNull Lifecycle.State r11) {
            this.this$0.addMenuProvider(r5, r10, r11);
        }
    }

    public FragmentActivity() {
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    public static /* synthetic */ void d(FragmentActivity r5, Context r10) {
        r5.lambda$init$3(r10);
    }

    public static /* synthetic */ void e(FragmentActivity r5, Configuration r10) {
        r5.lambda$init$1(r10);
    }

    public static /* synthetic */ Bundle f(FragmentActivity r5) {
        return r5.lambda$init$0();
    }

    public static /* synthetic */ void g(FragmentActivity r5, Intent r10) {
        r5.lambda$init$2(r10);
    }

    private void init() {
        getSavedStateRegistry().registerSavedStateProvider(LIFECYCLE_TAG, new f(this, 0));
        final int r5 = 0;
        addOnConfigurationChangedListener(new g(this, r5));
        final int r10 = 1;
        addOnNewIntentListener(new g(this, r10));
        addOnContextAvailableListener(new h(this));
    }

    private /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    private /* synthetic */ void lambda$init$1(Configuration r5) {
        this.mFragments.noteStateNotSaved();
    }

    private /* synthetic */ void lambda$init$2(Intent r5) {
        this.mFragments.noteStateNotSaved();
    }

    private /* synthetic */ void lambda$init$3(Context r5) {
        this.mFragments.attachHost(null);
    }

    private static boolean markState(FragmentManager r5, Lifecycle.State r10) {
        Iterator<Fragment> r11 = r5.getFragments().iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L19;
        Fragment r13 = r11.next();
        if (r13 == null) goto L4;
        if (r13.getHost() == null) goto L11;
        r12 = r12 | markState(r13.getChildFragmentManager(), r10);
    L11:
        FragmentViewLifecycleOwner r14 = r13.mViewLifecycleOwner;
        if (r14 == null) goto L17;
        if (r14.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L17;
        r13.mViewLifecycleOwner.setCurrentState(r10);
        r12 = true;
    L17:
        if (r13.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
        r13.mLifecycleRegistry.setCurrentState(r10);
        r12 = true;
        goto L4
    L19:
        return r12;
    }

    @Nullable
    public final View dispatchFragmentsOnCreateView(@Nullable View r5, @NonNull String r10, @NonNull Context r11, @NonNull AttributeSet r12) {
        return this.mFragments.onCreateView(r5, r10, r11, r12);
    }

    @Override // android.app.Activity
    public void dump(@NonNull String r5, @Nullable FileDescriptor r10, @NonNull PrintWriter r11, @Nullable String[] r12) {
        super.dump(r5, r10, r11, r12);
        if (shouldDumpInternalState(r12) == true) goto L5;
        return;
    L5:
        r11.print(r5);
        r11.print("Local FragmentActivity ");
        r11.print(Integer.toHexString(System.identityHashCode(this)));
        r11.println(" State:");
        String r13 = r5 + "  ";
        r11.print(r13);
        r11.print("mCreated=");
        r11.print(this.mCreated);
        r11.print(" mResumed=");
        r11.print(this.mResumed);
        r11.print(" mStopped=");
        r11.print(this.mStopped);
        if (getApplication() == null) goto L8;
        LoaderManager.getInstance(this).dump(r13, r10, r11, r12);
    L8:
        this.mFragments.getSupportFragmentManager().dump(r5, r10, r11, r12);
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

    public void markFragmentsCreated() {
    L3:
        if (markState(getSupportFragmentManager(), Lifecycle.State.CREATED) == true) goto L3;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onActivityResult(int r5, int r10, @Nullable Intent r11) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(r5, r10, r11);
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment r5) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View r5, @NonNull String r10, @NonNull Context r11, @NonNull AttributeSet r12) {
        View r13 = dispatchFragmentsOnCreateView(r5, r10, r11, r12);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return super.onCreateView(r5, r10, r11, r12);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r5, @NonNull MenuItem r10) {
        if (super.onMenuItemSelected(r5, r10) == false) goto L7;
        return true;
    L7:
        if (r5 == 6) goto L9;
        return false;
    L9:
        return this.mFragments.dispatchContextItemSelected(r10);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onRequestPermissionsResult(int r5, @NonNull String[] r10, @NonNull int[] r11) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(r5, r10, r11);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    @Override // android.app.Activity
    public void onStart() {
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
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback r5) {
        ActivityCompat.setEnterSharedElementCallback(this, r5);
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback r5) {
        ActivityCompat.setExitSharedElementCallback(this, r5);
    }

    public void startActivityFromFragment(@NonNull Fragment r5, @NonNull Intent r10, int r11) {
        startActivityFromFragment(r5, r10, r11, null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(@NonNull Fragment r10, @NonNull IntentSender r11, int r12, @Nullable Intent r13, int r14, int r15, int r16, @Nullable Bundle r17) throws IntentSender.SendIntentException {
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
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int r5) {
    }

    public void startActivityFromFragment(@NonNull Fragment r5, @NonNull Intent r10, int r11, @Nullable Bundle r12) {
        if (r11 != (-1)) goto L6;
        ActivityCompat.startActivityForResult(this, r10, -1, r12);
        return;
    L6:
        r5.startActivityForResult(r10, r11, r12);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String r5, @NonNull Context r10, @NonNull AttributeSet r11) {
        View r12 = dispatchFragmentsOnCreateView(null, r5, r10, r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return super.onCreateView(r5, r10, r11);
    }

    @ContentView
    public FragmentActivity(@LayoutRes int r5) {
        super(r5);
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }
}
