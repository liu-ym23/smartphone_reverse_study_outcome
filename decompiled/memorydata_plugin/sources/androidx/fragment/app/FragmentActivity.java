package androidx.fragment.app;

import android.app.Application;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, OnConfigurationChangedProvider, OnTrimMemoryProvider, MenuHost, FragmentOnAttachListener, ViewModelStoreOwner, SavedStateRegistryOwner {
        final /* synthetic */ FragmentActivity this$0;

        public HostCallbacks(FragmentActivity r3) {
            FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
            this.this$0 = r4;
            super(r4);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(MenuProvider r3) {
            MenuProvider r4 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
            this.this$0.addMenuProvider(r4);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(MenuProvider r3, LifecycleOwner r4) {
            MenuProvider r5 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
            LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
            this.this$0.addMenuProvider(r5, r6);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(MenuProvider r3, LifecycleOwner r4, Lifecycle.State r5) {
            MenuProvider r6 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
            LifecycleOwner r7 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
            this.this$0.addMenuProvider(r6, r7, r5);
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void addOnConfigurationChangedListener(Consumer<Configuration> r3) {
            Consumer<Configuration> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            this.this$0.addOnConfigurationChangedListener(r4);
        }

        @Override // androidx.core.app.OnMultiWindowModeChangedProvider
        public void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r3) {
            Consumer<MultiWindowModeChangedInfo> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            this.this$0.addOnMultiWindowModeChangedListener(r4);
        }

        @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
        public void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r3) {
            Consumer<PictureInPictureModeChangedInfo> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            this.this$0.addOnPictureInPictureModeChangedListener(r4);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void addOnTrimMemoryListener(Consumer<Integer> r3) {
            Consumer<Integer> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            this.this$0.addOnTrimMemoryListener(r4);
        }

        @Override // androidx.activity.result.ActivityResultRegistryOwner
        public ActivityResultRegistry getActivityResultRegistry() {
            return this.this$0.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return this.this$0.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.this$0.getOnBackPressedDispatcher();
        }

        @Override // androidx.savedstate.SavedStateRegistryOwner
        public SavedStateRegistry getSavedStateRegistry() {
            return this.this$0.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        public ViewModelStore getViewModelStore() {
            return this.this$0.getViewModelStore();
        }

        @Override // androidx.core.view.MenuHost
        public void invalidateMenu() {
            this.this$0.invalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public void onAttachFragment(FragmentManager r1, Fragment r2) {
            this.this$0.onAttachFragment(r2);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onDump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
            this.this$0.dump(r1, r2, r3, r4);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public View onFindViewById(int r1) {
            return this.this$0.findViewById(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.fragment.app.FragmentHostCallback
        public FragmentActivity onGetHost() {
            return this.this$0;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public /* synthetic */ FragmentActivity onGetHost() {
            return (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(onGetHost(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public LayoutInflater onGetLayoutInflater() {
            return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public int onGetWindowAnimations() {
            Window r0 = this.this$0.getWindow();
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            Window r0 = this.this$0.getWindow();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.peekDecorView() == null) goto L7;
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
        public boolean onShouldSaveFragmentState(Fragment r1) {
            return !this.this$0.isFinishing();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldShowRequestPermissionRationale(String r1) {
            return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, r1);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onSupportInvalidateOptionsMenu() {
            invalidateMenu();
        }

        @Override // androidx.core.view.MenuHost
        public void removeMenuProvider(MenuProvider r3) {
            MenuProvider r4 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
            this.this$0.removeMenuProvider(r4);
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void removeOnConfigurationChangedListener(Consumer<Configuration> r3) {
            Consumer<Configuration> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            this.this$0.removeOnConfigurationChangedListener(r4);
        }

        @Override // androidx.core.app.OnMultiWindowModeChangedProvider
        public void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r3) {
            Consumer<MultiWindowModeChangedInfo> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            this.this$0.removeOnMultiWindowModeChangedListener(r4);
        }

        @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
        public void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r3) {
            Consumer<PictureInPictureModeChangedInfo> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            this.this$0.removeOnPictureInPictureModeChangedListener(r4);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void removeOnTrimMemoryListener(Consumer<Integer> r3) {
            Consumer<Integer> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            this.this$0.removeOnTrimMemoryListener(r4);
        }
    }

    public FragmentActivity() {
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    public FragmentActivity(int r1) {
        super(r1);
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().registerSavedStateProvider(LIFECYCLE_TAG, new $$Lambda$FragmentActivity$t3WwJ1XbNlapyNW0l552nMkkXdo(this));
        addOnConfigurationChangedListener(new $$Lambda$FragmentActivity$UpIcD_fWrvv5DXXVvwmRJ3bKrA(this));
        addOnNewIntentListener(new $$Lambda$FragmentActivity$SP1hanWdTqO_BoGCQWOxhjR39jQ(this));
        addOnContextAvailableListener(new $$Lambda$FragmentActivity$euPNEtWNfVdMY89Jt5kWt_WEHqw(this));
    }

    private static boolean markState(FragmentManager r5, Lifecycle.State r6) {
        Iterator<Fragment> r7 = r5.getFragments().iterator();
        boolean r0 = false;
    L4:
        if (r7.hasNext() == false) goto L19;
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(r7.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        if (r1.getHost() == null) goto L12;
        r0 = r0 | markState(r1.getChildFragmentManager(), r6);
    L12:
        if (r1.mViewLifecycleOwner == null) goto L17;
        if (r1.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L17;
        r1.mViewLifecycleOwner.setCurrentState(r6);
        r0 = true;
    L17:
        if (r1.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
        r1.mLifecycleRegistry.setCurrentState(r6);
        r0 = true;
        goto L4
    L19:
        return r0;
    }

    final View dispatchFragmentsOnCreateView(View r3, String r4, Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        return this.mFragments.onCreateView(r3, r4, r7, r8);
    }

    public void dump(String r5, FileDescriptor r6, PrintWriter r7, String[] r8) {
        super.dump(r5, r6, r7, r8);
        if (shouldDumpInternalState(r8) == true) goto L5;
        return;
    L5:
        r7.print(r5);
        r7.print("Local FragmentActivity ");
        r7.print(Integer.toHexString(System.identityHashCode(this)));
        r7.println(" State:");
        String r0 = r5 + "  ";
        r7.print(r0);
        r7.print("mCreated=");
        r7.print(this.mCreated);
        r7.print(" mResumed=");
        r7.print(this.mResumed);
        r7.print(" mStopped=");
        r7.print(this.mStopped);
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) == null) goto L8;
        LoaderManager.getInstance(this).dump(r0, r6, r7, r8);
    L8:
        this.mFragments.getSupportFragmentManager().dump(r5, r6, r7, r8);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public /* synthetic */ Bundle lambda$init$0$FragmentActivity() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    public /* synthetic */ void lambda$init$1$FragmentActivity(Configuration r1) {
        this.mFragments.noteStateNotSaved();
    }

    public /* synthetic */ void lambda$init$2$FragmentActivity(Intent r1) {
        this.mFragments.noteStateNotSaved();
    }

    public /* synthetic */ void lambda$init$3$FragmentActivity(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mFragments.attachHost(null);
    }

    void markFragmentsCreated() {
    L3:
        if (markState(getSupportFragmentManager(), Lifecycle.State.CREATED) == true) goto L3;
    }

    @Override // androidx.activity.ComponentActivity
    public void onActivityResult(int r2, int r3, Intent r4) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(r2, r3, r4);
    }

    @Deprecated
    public void onAttachFragment(Fragment r1) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    public View onCreateView(View r3, String r4, Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        View r0 = dispatchFragmentsOnCreateView(r3, r4, r7, r8);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.onCreateView(r3, r4, r7, r8);
    }

    public View onCreateView(String r3, Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        View r0 = dispatchFragmentsOnCreateView(null, r3, r6, r7);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.onCreateView(r3, r6, r7);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity
    public boolean onMenuItemSelected(int r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        if (super.onMenuItemSelected(r3, r5) == false) goto L7;
        return true;
    L7:
        if (r3 == 6) goto L9;
        return false;
    L9:
        return this.mFragments.dispatchContextItemSelected(r5);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(r2, r3, r4);
    }

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

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnterSharedElementCallback(SharedElementCallback r1) {
        ActivityCompat.setEnterSharedElementCallback(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setExitSharedElementCallback(SharedElementCallback r1) {
        ActivityCompat.setExitSharedElementCallback(this, r1);
    }

    public void startActivityFromFragment(Fragment r2, Intent r3, int r4) {
        startActivityFromFragment(r2, r3, r4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4, Bundle r5) {
        if (r4 != (-1)) goto L6;
        ActivityCompat.startActivityForResult(this, r3, -1, r5);
        return;
    L6:
        ZeusTransformUtils.startActivityForResult(r2, r3, r4, r5, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void startIntentSenderFromFragment(Fragment r10, IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) {
        if (r12 != (-1)) goto L6;
        ActivityCompat.startIntentSenderForResult(this, r11, r12, r13, r14, r15, r16, r17);
        return;
    L6:
        r10.startIntentSenderForResult(r11, r12, r13, r14, r15, r16, r17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int r1) {
    }
}
