package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.b0;
import androidx.lifecycle.e0;
import androidx.lifecycle.i0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.y;
import com.obric.cae.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.e implements l0, androidx.lifecycle.f, z0.c, w, androidx.activity.result.f {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final androidx.activity.result.e mActivityResultRegistry;
    private int mContentLayoutId;
    final a.a mContextAwareHelper;
    private i0.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final m mFullyDrawnReporter;
    private final androidx.lifecycle.n mLifecycleRegistry;
    private final j0.i mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<i0.a<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<i0.a<androidx.core.app.f>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<i0.a<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<i0.a<androidx.core.app.p>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<i0.a<Integer>> mOnTrimMemoryListeners;
    final e mReportFullyDrawnExecutor;
    final z0.b mSavedStateRegistryController;
    private k0 mViewModelStore;

    public class a extends androidx.activity.result.e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f440h;

        public a(ComponentActivity r8) {
            this.f440h = r8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.activity.result.e
        public final void b(int r10, b.a r11, Object r12) {
            ComponentActivity r8 = this.f440h;
            b.a.C0027a r13 = r11.b(r8, r12);
            if (r13 == null) goto L6;
            new Handler(Looper.getMainLooper()).post(new h(this, r10, r13));
            return;
        L6:
            Intent r14 = r11.a(r8, r12);
            if (r14.getExtras() == null) goto L12;
            if (r14.getExtras().getClassLoader() != null) goto L12;
            r14.setExtrasClassLoader(r8.getClassLoader());
        L12:
            if (r14.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE") == false) goto L14;
            Bundle r15 = r14.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            r14.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            Bundle r16 = r15;
        L16:
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(r14.getAction()) == false) goto L53;
            String[] r17 = r14.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int r18 = 0;
            if (r17 != null) goto L20;
            r17 = new String[0];
        L20:
            int r19 = androidx.core.app.a.f1587c;
            HashSet r110 = new HashSet();
            int r20 = 0;
        L22:
            if (r20 >= r17.length) goto L33;
            if (TextUtils.isEmpty(r17[r20]) == true) goto L32;
            if (f0.a.a() == true) goto L30;
            if (TextUtils.equals(r17[r20], "android.permission.POST_NOTIFICATIONS") == false) goto L30;
            r110.add(Integer.valueOf(r20));
        L30:
            r20 = r20 + 1;
            goto L22
        L32:
            throw new IllegalArgumentException(android.aimedia.a.i(new StringBuilder("Permission request for permissions "), Arrays.toString(r17), " must not contain null or empty values"));
        L33:
            int r21 = r110.size();
            if (r21 <= 0) goto L36;
            String[] r22 = new String[r17.length - r21];
        L37:
            if (r21 <= 0) goto L49;
            if (r21 == r17.length) goto L73;
            int r23 = 0;
        L43:
            if (r18 >= r17.length) goto L49;
            if (r110.contains(Integer.valueOf(r18)) == true) goto L47;
            r22[r23] = r17[r18];
            r23 = r23 + 1;
        L47:
            r18 = r18 + 1;
            goto L43
        L73:
            return;
        L49:
            if ((r8 instanceof androidx.core.app.a.d) == false) goto L51;
            ((androidx.core.app.a.d) r8).validateRequestPermissionsRequestCode(r10);
        L51:
            androidx.core.app.a.c.b(r8, r17, r10);
            return;
        L36:
            r22 = r17;
            goto L37
        L53:
            if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(r14.getAction()) == false) goto L59;
            IntentSenderRequest r111 = (IntentSenderRequest) r14.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            IntentSender r24 = r111.f511a;     // Catch: IntentSender.SendIntentException -> L57
            Intent r25 = r111.f512b;     // Catch: IntentSender.SendIntentException -> L57
            int r26 = r111.f513m;     // Catch: IntentSender.SendIntentException -> L57
            int r27 = r111.f514n;     // Catch: IntentSender.SendIntentException -> L57
            int r112 = androidx.core.app.a.f1587c;     // Catch: IntentSender.SendIntentException -> L57
            androidx.core.app.a.C0010a.c(r8, r24, r10, r25, r26, r27, 0, r16);     // Catch: IntentSender.SendIntentException -> L57
            return;
        L57:
            e = move-exception;
            new Handler(Looper.getMainLooper()).post(new i(this, r10, e));
            return;
        L59:
            int r28 = androidx.core.app.a.f1587c;
            androidx.core.app.a.C0010a.b(r8, r14, r10, r16);
            return;
        L14:
            r16 = null;
            goto L16
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f441a;

        public b(ComponentActivity r8) {
            this.f441a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.access$001(this.f441a);     // Catch: NullPointerException -> L4 IllegalStateException -> L9
        L16:
            return;
        L9:
            e = move-exception;
            if (TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState") == false) goto L13;
            return;
        L13:
            throw e;
        L4:
            e = move-exception;
            if (TextUtils.equals(e.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference") == true) goto L17;
            throw e;
        }
    }

    public static class c {
        public static OnBackInvokedDispatcher a(Activity r8) {
            return r8.getOnBackInvokedDispatcher();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k0 f443b;

        public d() {
        }
    }

    public interface e extends Executor {
        void w(View r8);
    }

    public class f implements e, ViewTreeObserver.OnDrawListener, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f445b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f446m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f447n;

        public f(ComponentActivity r8) {
            this.f447n = r8;
            this.f444a = SystemClock.uptimeMillis() + 10000;
            this.f446m = false;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r8) {
            this.f445b = r8;
            View r10 = this.f447n.getWindow().getDecorView();
            if (this.f446m == true) goto L5;
            r10.postOnAnimation(new j(this, 0));
            return;
        L5:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
            r10.invalidate();
            return;
        L7:
            r10.postInvalidate();
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            Runnable r8 = this.f445b;
            if (r8 == null) goto L14;
            r8.run();
            this.f445b = null;
            m r10 = this.f447n.mFullyDrawnReporter;
            Object r11 = r10.f495b;
            monitor-enter(r11);
            boolean r12 = r10.f496c;     // Catch: Throwable -> L10
            monitor-exit(r11);
            if (r12 == false) goto L19;
        L15:
            this.f446m = false;
            this.f447n.getWindow().getDecorView().post(this);
            return;
        L19:
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            if (SystemClock.uptimeMillis() > this.f444a) goto L15;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f447n.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.e
        public final void w(View r8) {
            if (this.f446m == true) goto L6;
            this.f446m = true;
            r8.getViewTreeObserver().addOnDrawListener(this);
            return;
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.activity.e] */
    public ComponentActivity() {
        this.mContextAwareHelper = new a.a();
        final int r8 = 0;
        this.mMenuHostHelper = new j0.i(new androidx.activity.d(this, r8));
        this.mLifecycleRegistry = new androidx.lifecycle.n(this);
        z0.b r10 = z0.b.a.a(this);
        this.mSavedStateRegistryController = r10;
        this.mOnBackPressedDispatcher = null;
        e r11 = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = r11;
        this.mFullyDrawnReporter = new m(r11, new androidx.activity.e(this, r8));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new a(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) goto L7;
        getLifecycle().a(new AnonymousClass2(this));
        getLifecycle().a(new AnonymousClass3(this));
        getLifecycle().a(new AnonymousClass4(this));
        r10.a();
        b0.b(this);
        getSavedStateRegistry().e(ACTIVITY_RESULT_TAG, new androidx.activity.f(this, r8));
        addOnContextAvailableListener(new g(this));
        return;
    L7:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public static /* synthetic */ Bundle a(ComponentActivity r8) {
        return r8.lambda$new$1();
    }

    public static /* synthetic */ void access$001(ComponentActivity r8) {
        super.onBackPressed();
    }

    public static /* synthetic */ OnBackPressedDispatcher access$100(ComponentActivity r8) {
        return r8.mOnBackPressedDispatcher;
    }

    public static /* synthetic */ void b(ComponentActivity r8, Context r10) {
        r8.lambda$new$2(r10);
    }

    public static /* synthetic */ xd.j c(ComponentActivity r8) {
        return r8.lambda$new$0();
    }

    private e createFullyDrawnExecutor() {
        return new f(this);
    }

    private /* synthetic */ xd.j lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    private Bundle lambda$new$1() {
        Bundle r8 = new Bundle();
        androidx.activity.result.e r10 = this.mActivityResultRegistry;
        r10.getClass();
        HashMap r11 = r10.f523b;
        r8.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(r11.values()));
        r8.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(r11.keySet()));
        r8.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(r10.f525d));
        r8.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) r10.f528g.clone());
        return r8;
    }

    private void lambda$new$2(Context r10) {
        Bundle r11 = getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (r11 == null) goto L17;
        androidx.activity.result.e r8 = this.mActivityResultRegistry;
        r8.getClass();
        ArrayList<Integer> r12 = r11.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> r13 = r11.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (r13 == null) goto L22;
        if (r12 == null) goto L23;
        r8.f525d = r11.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        Bundle r14 = r11.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        Bundle r15 = r8.f528g;
        r15.putAll(r14);
        int r16 = 0;
    L10:
        if (r16 >= r13.size()) goto L24;
        String r17 = r13.get(r16);
        HashMap r18 = r8.f523b;
        boolean r19 = r18.containsKey(r17);
        HashMap r20 = r8.f522a;
        if (r19 == false) goto L16;
        Integer r21 = (Integer) r18.remove(r17);
        if (r15.containsKey(r17) == true) goto L16;
        r20.remove(r21);
    L16:
        int r22 = r12.get(r16).intValue();
        String r23 = r13.get(r16);
        r20.put(Integer.valueOf(r22), r23);
        r18.put(r23, Integer.valueOf(r22));
        r16 = r16 + 1;
        goto L10
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r8, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r10) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.w(getWindow().getDecorView());
        super.addContentView(r8, r10);
    }

    public void addMenuProvider(j0.k r8) {
        j0.i r10 = this.mMenuHostHelper;
        r10.f8390b.add(r8);
        r10.f8389a.run();
    }

    public final void addOnConfigurationChangedListener(i0.a<Configuration> r8) {
        this.mOnConfigurationChangedListeners.add(r8);
    }

    public final void addOnContextAvailableListener(a.b r8) {
        a.a r10 = this.mContextAwareHelper;
        r10.getClass();
        he.i.f(r8, "listener");
        Context r11 = r10.f1b;
        if (r11 == null) goto L5;
        r8.a(r11);
    L5:
        r10.f0a.add(r8);
    }

    public final void addOnMultiWindowModeChangedListener(i0.a<androidx.core.app.f> r8) {
        this.mOnMultiWindowModeChangedListeners.add(r8);
    }

    public final void addOnNewIntentListener(i0.a<Intent> r8) {
        this.mOnNewIntentListeners.add(r8);
    }

    public final void addOnPictureInPictureModeChangedListener(i0.a<androidx.core.app.p> r8) {
        this.mOnPictureInPictureModeChangedListeners.add(r8);
    }

    public final void addOnTrimMemoryListener(i0.a<Integer> r8) {
        this.mOnTrimMemoryListeners.add(r8);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        d r8 = (d) getLastNonConfigurationInstance();
        if (r8 == null) goto L8;
        this.mViewModelStore = r8.f443b;
    L8:
        if (this.mViewModelStore != null) goto L12;
        this.mViewModelStore = new k0();
        return;
    L12:
        return;
    }

    @Override // androidx.activity.result.f
    public final androidx.activity.result.e getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.f
    public t0.a getDefaultViewModelCreationExtras() {
        t0.d r8 = new t0.d();
        Application r10 = getApplication();
        LinkedHashMap r11 = r8.f12206a;
        if (r10 == null) goto L5;
        r11.put(i0.a.C0017a.C0018a.f2171a, getApplication());
    L5:
        r11.put(b0.f2133a, this);
        r11.put(b0.f2134b, this);
        if (getIntent() != null) goto L8;
    L10:
        return r8;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r11.put(b0.f2135c, getIntent().getExtras());
        goto L10
    }

    public i0.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r8 = getApplication();
        if (getIntent() == null) goto L7;
        Bundle r10 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new e0(r8, this, r10);
        goto L10
    L7:
        r10 = null;
    L10:
        return this.mDefaultFactory;
    }

    public m getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        d r8 = (d) getLastNonConfigurationInstance();
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f442a;
    }

    @Override // androidx.core.app.e, androidx.lifecycle.m
    public androidx.lifecycle.h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.w
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher != null) goto L6;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new b(this));
        getLifecycle().a(new AnonymousClass6(this));
    L6:
        return this.mOnBackPressedDispatcher;
    }

    @Override // z0.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f14170b;
    }

    @Override // androidx.lifecycle.l0
    public k0 getViewModelStore() {
        if (getApplication() == null) goto L7;
        ensureViewModelStore();
        return this.mViewModelStore;
    L7:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        View r8 = getWindow().getDecorView();
        he.i.f(r8, "<this>");
        r8.setTag(R.id.view_tree_lifecycle_owner, this);
        View r10 = getWindow().getDecorView();
        he.i.f(r10, "<this>");
        r10.setTag(R.id.view_tree_view_model_store_owner, this);
        View r11 = getWindow().getDecorView();
        he.i.f(r11, "<this>");
        r11.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View r12 = getWindow().getDecorView();
        he.i.f(r12, "<this>");
        r12.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View r13 = getWindow().getDecorView();
        he.i.f(r13, "<this>");
        r13.setTag(R.id.report_drawn, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int r8, int r10, Intent r11) {
        if (this.mActivityResultRegistry.a(r8, r10, r11) == true) goto L6;
        super.onActivityResult(r8, r10, r11);
        return;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        Iterator<i0.a<Configuration>> r10 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().accept(r8);
        goto L4
    }

    @Override // androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        this.mSavedStateRegistryController.b(r8);
        a.a r10 = this.mContextAwareHelper;
        r10.getClass();
        r10.f1b = this;
        Iterator r11 = r10.f0a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((a.b) r11.next()).a(this);
        goto L4
    L6:
        super.onCreate(r8);
        int r12 = y.f2204b;
        y.b.b(this);
        int r13 = this.mContentLayoutId;
        if (r13 == 0) goto L11;
        setContentView(r13);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r8, Menu r10) {
        if (r8 != 0) goto L7;
        super.onCreatePanelMenu(r8, r10);
        j0.i r11 = this.mMenuHostHelper;
        getMenuInflater();
        Iterator<j0.k> r12 = r11.f8390b.iterator();
    L5:
        if (r12.hasNext() == false) goto L10;
        r12.next().a();
        goto L5
    L10:
        return true;
    L7:
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r8, MenuItem r10) {
        if (super.onMenuItemSelected(r8, r10) == false) goto L6;
        return true;
    L6:
        if (r8 != 0) goto L15;
        Iterator<j0.k> r11 = this.mMenuHostHelper.f8390b.iterator();
    L9:
        if (r11.hasNext() == false) goto L14;
        if (r11.next().b() == false) goto L9;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r8) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<i0.a<androidx.core.app.f>> r10 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().accept(new androidx.core.app.f(r8));
        goto L7
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent r8) {
        super.onNewIntent(r8);
        Iterator<i0.a<Intent>> r10 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().accept(r8);
        goto L4
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r8, Menu r10) {
        Iterator<j0.k> r11 = this.mMenuHostHelper.f8390b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().getClass();
        goto L4
    L6:
        super.onPanelClosed(r8, r10);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r8) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<i0.a<androidx.core.app.p>> r10 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().accept(new androidx.core.app.p(r8));
        goto L7
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r8, View r10, Menu r11) {
        if (r8 != 0) goto L7;
        super.onPreparePanel(r8, r10, r11);
        Iterator<j0.k> r12 = this.mMenuHostHelper.f8390b.iterator();
    L5:
        if (r12.hasNext() == false) goto L10;
        r12.next().getClass();
        goto L5
    L10:
        return true;
    L7:
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int r8, String[] r10, int[] r11) {
        if (this.mActivityResultRegistry.a(r8, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", r10).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", r11)) == true) goto L6;
        super.onRequestPermissionsResult(r8, r10, r11);
        return;
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object r8 = onRetainCustomNonConfigurationInstance();
        k0 r10 = this.mViewModelStore;
        if (r10 != null) goto L7;
        d r11 = (d) getLastNonConfigurationInstance();
        if (r11 == null) goto L7;
        r10 = r11.f443b;
    L7:
        if (r10 != null) goto L11;
        if (r8 != null) goto L11;
        return null;
    L11:
        d r12 = new d();
        r12.f442a = r8;
        r12.f443b = r10;
        return r12;
    }

    @Override // androidx.core.app.e, android.app.Activity
    public void onSaveInstanceState(Bundle r8) {
        androidx.lifecycle.h r10 = getLifecycle();
        if ((r10 instanceof androidx.lifecycle.n) == false) goto L5;
        ((androidx.lifecycle.n) r10).h(androidx.lifecycle.h.b.f2159m);
    L5:
        super.onSaveInstanceState(r8);
        this.mSavedStateRegistryController.c(r8);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int r8) {
        super.onTrimMemory(r8);
        Iterator<i0.a<Integer>> r10 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().accept(Integer.valueOf(r8));
        goto L4
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.f1b;
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> r8, androidx.activity.result.a<O> r10) {
        return registerForActivityResult(r8, this.mActivityResultRegistry, r10);
    }

    public void removeMenuProvider(j0.k r8) {
        this.mMenuHostHelper.a(r8);
    }

    public final void removeOnConfigurationChangedListener(i0.a<Configuration> r8) {
        this.mOnConfigurationChangedListeners.remove(r8);
    }

    public final void removeOnContextAvailableListener(a.b r8) {
        a.a r10 = this.mContextAwareHelper;
        r10.getClass();
        he.i.f(r8, "listener");
        r10.f0a.remove(r8);
    }

    public final void removeOnMultiWindowModeChangedListener(i0.a<androidx.core.app.f> r8) {
        this.mOnMultiWindowModeChangedListeners.remove(r8);
    }

    public final void removeOnNewIntentListener(i0.a<Intent> r8) {
        this.mOnNewIntentListeners.remove(r8);
    }

    public final void removeOnPictureInPictureModeChangedListener(i0.a<androidx.core.app.p> r8) {
        this.mOnPictureInPictureModeChangedListeners.remove(r8);
    }

    public final void removeOnTrimMemoryListener(i0.a<Integer> r8) {
        this.mOnTrimMemoryListeners.remove(r8);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
    L16:
        th = move-exception;
        Trace.endSection();
        throw th;
    L3:
        if (e1.a.a() == false) goto L5;
        Trace.beginSection("reportFullyDrawn() for ComponentActivity");     // Catch: Throwable -> L16
    L5:
        super.reportFullyDrawn();     // Catch: Throwable -> L16
        m r8 = this.mFullyDrawnReporter;     // Catch: Throwable -> L16
        Object r10 = r8.f495b;     // Catch: Throwable -> L16
        monitor-enter(r10);     // Catch: Throwable -> L16
        r8.f496c = true;     // Catch: Throwable -> L18
        Iterator r11 = r8.f497d.iterator();     // Catch: Throwable -> L18
    L10:
        if (r11.hasNext() == false) goto L12;
        ((ge.a) r11.next()).f();     // Catch: Throwable -> L18
        goto L10
    L12:
        r8.f497d.clear();     // Catch: Throwable -> L18
        xd.j r12 = xd.j.f13877a;     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L16
        Trace.endSection();
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    }

    @Override // android.app.Activity
    public void setContentView(int r8) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.w(getWindow().getDecorView());
        super.setContentView(r8);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent r8, int r10) {
        super.startActivityForResult(r8, r10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender r8, int r10, Intent r11, int r12, int r13, int r14) {
        super.startIntentSenderForResult(r8, r10, r11, r12, r13, r14);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r8, Configuration r10) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r8, r10);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<i0.a<androidx.core.app.f>> r11 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().accept(new androidx.core.app.f(r8, r10));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r8, Configuration r10) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r8, r10);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<i0.a<androidx.core.app.p>> r11 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().accept(new androidx.core.app.p(r8, r10));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> r8, androidx.activity.result.e r10, androidx.activity.result.a<O> r11) {
        return r10.c("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r8, r11);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r8) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.w(getWindow().getDecorView());
        super.setContentView(r8);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent r8, int r10, Bundle r11) {
        super.startActivityForResult(r8, r10, r11);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender r8, int r10, Intent r11, int r12, int r13, int r14, Bundle r15) {
        super.startIntentSenderForResult(r8, r10, r11, r12, r13, r14, r15);
    }

    public ComponentActivity(int r8) {
        this();
        this.mContentLayoutId = r8;
    }

    public void addMenuProvider(final j0.k r8, androidx.lifecycle.m r10) {
        final j0.i r11 = this.mMenuHostHelper;
        r11.f8390b.add(r8);
        r11.f8389a.run();
        androidx.lifecycle.h r12 = r10.getLifecycle();
        HashMap r13 = r11.f8391c;
        j0.i.a r14 = (j0.i.a) r13.remove(r8);
        if (r14 == null) goto L5;
        r14.f8392a.c(r14.f8393b);
        r14.f8393b = null;
    L5:
        r13.put(r8, new j0.i.a(r12, new j0.g(r11, r8)));
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r8, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r10) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.w(getWindow().getDecorView());
        super.setContentView(r8, r10);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(final j0.k r8, androidx.lifecycle.m r10, final androidx.lifecycle.h.b r11) {
        final j0.i r12 = this.mMenuHostHelper;
        r12.getClass();
        androidx.lifecycle.h r13 = r10.getLifecycle();
        HashMap r14 = r12.f8391c;
        j0.i.a r15 = (j0.i.a) r14.remove(r8);
        if (r15 == null) goto L5;
        r15.f8392a.c(r15.f8393b);
        r15.f8393b = null;
    L5:
        r14.put(r8, new j0.i.a(r13, new j0.h(r12, r11, r8)));
    }
}
