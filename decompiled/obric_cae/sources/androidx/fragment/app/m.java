package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.l0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class m extends ComponentActivity implements androidx.core.app.a.d {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final androidx.lifecycle.n mFragmentLifecycleRegistry;
    final p mFragments;
    boolean mResumed;
    boolean mStopped;

    public class a implements androidx.savedstate.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f2030a;

        public a(m r8) {
            this.f2030a = r8;
        }

        @Override // androidx.savedstate.a.b
        public final Bundle a() {
            Bundle r8 = new Bundle();
            m r10 = this.f2030a;
            r10.markFragmentsCreated();
            r10.mFragmentLifecycleRegistry.f(androidx.lifecycle.h.a.ON_STOP);
            Parcelable r11 = r10.mFragments.f2040a.f2045n.Q();
            if (r11 == null) goto L5;
            r8.putParcelable(m.FRAGMENTS_TAG, r11);
        L5:
            return r8;
        }
    }

    public class b implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f2031a;

        public b(m r8) {
            this.f2031a = r8;
        }

        @Override // a.b
        public final void a(Context r8) {
            m r10 = this.f2031a;
            r<?> r11 = r10.mFragments.f2040a;
            r11.f2045n.c(r11, r11, null);
            Bundle r12 = r10.getSavedStateRegistry().a(m.FRAGMENTS_TAG);
            if (r12 == null) goto L9;
            Parcelable r13 = r12.getParcelable(m.FRAGMENTS_TAG);
            r<?> r14 = r10.mFragments.f2040a;
            if ((r14 instanceof l0) == false) goto L8;
            r14.f2045n.P(r13);
            return;
        L8:
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
    }

    public class c extends r<m> implements l0, androidx.activity.w, androidx.activity.result.f, w {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ m f2032o;

        public c(m r8) {
            this.f2032o = r8;
            super(r8);
        }

        @Override // androidx.fragment.app.w
        public final void a(Fragment r8) {
            this.f2032o.onAttachFragment(r8);
        }

        @Override // androidx.fragment.app.o
        public final View b(int r8) {
            return this.f2032o.findViewById(r8);
        }

        @Override // androidx.fragment.app.o
        public final boolean c() {
            Window r8 = this.f2032o.getWindow();
            if (r8 != null) goto L5;
        L7:
            return false;
        L5:
            if (r8.peekDecorView() == null) goto L7;
            return true;
        }

        @Override // androidx.fragment.app.r
        public final m d() {
            return this.f2032o;
        }

        @Override // androidx.fragment.app.r
        public final LayoutInflater e() {
            m r8 = this.f2032o;
            return r8.getLayoutInflater().cloneInContext(r8);
        }

        @Override // androidx.fragment.app.r
        public final boolean f(String r8) {
            int r10 = androidx.core.app.a.f1587c;
            if (f0.a.a() == true) goto L8;
            if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r8) == false) goto L8;
            return false;
        L8:
            return androidx.core.app.a.c.c(this.f2032o, r8);
        }

        @Override // androidx.fragment.app.r
        public final void g() {
            this.f2032o.supportInvalidateOptionsMenu();
        }

        @Override // androidx.activity.result.f
        public final androidx.activity.result.e getActivityResultRegistry() {
            return this.f2032o.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.m
        public final androidx.lifecycle.h getLifecycle() {
            return this.f2032o.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.w
        public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.f2032o.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.l0
        public final androidx.lifecycle.k0 getViewModelStore() {
            return this.f2032o.getViewModelStore();
        }
    }

    public m() {
        this.mFragments = new p(new c(this));
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.n(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().e(FRAGMENTS_TAG, new a(this));
        addOnContextAvailableListener(new b(this));
    }

    private static boolean markState(FragmentManager r8, androidx.lifecycle.h.b r10) {
        Iterator<Fragment> r11 = r8.f1864c.f().iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L25;
        Fragment r13 = r11.next();
        if (r13 == null) goto L4;
        if (r13.getHost() == null) goto L11;
        r12 = r12 | markState(r13.getChildFragmentManager(), r10);
    L11:
        g0 r14 = r13.mViewLifecycleOwner;
        if (r14 == null) goto L20;
        r14.b();
        if (r14.f1965b.f2178c.compareTo(androidx.lifecycle.h.b.f2160n) < 0) goto L16;
        boolean r15 = true;
    L17:
        if (r15 == false) goto L20;
        r13.mViewLifecycleOwner.f1965b.h(r10);
        r12 = true;
        goto L20
    L16:
        r15 = false;
    L20:
        if (r13.mLifecycleRegistry.f2178c.compareTo(androidx.lifecycle.h.b.f2160n) < 0) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L4;
        r13.mLifecycleRegistry.h(r10);
        r12 = true;
        goto L4
    L22:
        r16 = false;
        goto L23
    L25:
        return r12;
    }

    public final View dispatchFragmentsOnCreateView(View r8, String r10, Context r11, AttributeSet r12) {
        return this.mFragments.f2040a.f2045n.f1867f.onCreateView(r8, r10, r11, r12);
    }

    @Override // android.app.Activity
    public void dump(String r8, FileDescriptor r10, PrintWriter r11, String[] r12) {
        super.dump(r8, r10, r11, r12);
        r11.print(r8);
        r11.print("Local FragmentActivity ");
        r11.print(Integer.toHexString(System.identityHashCode(this)));
        r11.println(" State:");
        String r13 = r8 + "  ";
        r11.print(r13);
        r11.print("mCreated=");
        r11.print(this.mCreated);
        r11.print(" mResumed=");
        r11.print(this.mResumed);
        r11.print(" mStopped=");
        r11.print(this.mStopped);
        if (getApplication() == null) goto L5;
        u0.a.a(this).b(r13, r11);
    L5:
        this.mFragments.f2040a.f2045n.u(r8, r10, r11, r12);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.f2040a.f2045n;
    }

    @Deprecated
    public u0.a getSupportLoaderManager() {
        return u0.a.a(this);
    }

    public void markFragmentsCreated() {
    L3:
        if (markState(getSupportFragmentManager(), androidx.lifecycle.h.b.f2159m) == true) goto L3;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r8, int r10, Intent r11) {
        this.mFragments.a();
        super.onActivityResult(r8, r10, r11);
    }

    @Deprecated
    public void onAttachFragment(Fragment r8) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r8) {
        this.mFragments.a();
        super.onConfigurationChanged(r8);
        this.mFragments.f2040a.f2045n.i(r8);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.h.a.ON_CREATE);
        u r10 = this.mFragments.f2040a.f2045n;
        r10.A = false;
        r10.B = false;
        r10.H.f2057i = false;
        r10.t(1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r8, Menu r10) {
        if (r8 != 0) goto L6;
        boolean r11 = super.onCreatePanelMenu(r8, r10);
        p r12 = this.mFragments;
        MenuInflater r13 = getMenuInflater();
        return r12.f2040a.f2045n.k(r10, r13) | r11;
    L6:
        return super.onCreatePanelMenu(r8, r10);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View r8, String r10, Context r11, AttributeSet r12) {
        View r13 = dispatchFragmentsOnCreateView(r8, r10, r11, r12);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return super.onCreateView(r8, r10, r11, r12);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f2040a.f2045n.l();
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.h.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.f2040a.f2045n.m();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r8, MenuItem r10) {
        if (super.onMenuItemSelected(r8, r10) == false) goto L6;
        return true;
    L6:
        if (r8 == 0) goto L14;
        if (r8 == 6) goto L12;
        return false;
    L12:
        return this.mFragments.f2040a.f2045n.j(r10);
    L14:
        return this.mFragments.f2040a.f2045n.o(r10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean r8) {
        this.mFragments.f2040a.f2045n.n(r8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent r8) {
        this.mFragments.a();
        super.onNewIntent(r8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r8, Menu r10) {
        if (r8 != 0) goto L4;
        this.mFragments.f2040a.f2045n.p(r10);
    L4:
        super.onPanelClosed(r8, r10);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f2040a.f2045n.t(5);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.h.a.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean r8) {
        this.mFragments.f2040a.f2045n.r(r8);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View r8, Menu r10) {
        return super.onPreparePanel(0, r8, r10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r8, View r10, Menu r11) {
        if (r8 != 0) goto L6;
        boolean r12 = onPrepareOptionsPanel(r10, r11);
        return this.mFragments.f2040a.f2045n.s(r11) | r12;
    L6:
        return super.onPreparePanel(r8, r10, r11);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r8, String[] r10, int[] r11) {
        this.mFragments.a();
        super.onRequestPermissionsResult(r8, r10, r11);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f2040a.f2045n.x(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.h.a.ON_RESUME);
        u r8 = this.mFragments.f2040a.f2045n;
        r8.A = false;
        r8.B = false;
        r8.H.f2057i = false;
        r8.t(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (this.mCreated == true) goto L5;
        this.mCreated = true;
        u r8 = this.mFragments.f2040a.f2045n;
        r8.A = false;
        r8.B = false;
        r8.H.f2057i = false;
        r8.t(4);
    L5:
        this.mFragments.f2040a.f2045n.x(true);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.h.a.ON_START);
        u r10 = this.mFragments.f2040a.f2045n;
        r10.A = false;
        r10.B = false;
        r10.H.f2057i = false;
        r10.t(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        u r8 = this.mFragments.f2040a.f2045n;
        r8.B = true;
        r8.H.f2057i = true;
        r8.t(4);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.h.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(androidx.core.app.r r8) {
        int r10 = androidx.core.app.a.f1587c;
        androidx.core.app.a.b.c(this, null);
    }

    public void setExitSharedElementCallback(androidx.core.app.r r8) {
        int r10 = androidx.core.app.a.f1587c;
        androidx.core.app.a.b.d(this, null);
    }

    public void startActivityFromFragment(Fragment r8, @SuppressLint({"UnknownNullness"}) Intent r10, int r11) {
        startActivityFromFragment(r8, r10, r11, null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment r10, @SuppressLint({"UnknownNullness"}) IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) {
        if (r12 != (-1)) goto L6;
        int r8 = androidx.core.app.a.f1587c;
        androidx.core.app.a.C0010a.c(this, r11, r12, r13, r14, r15, r16, r17);
        return;
    L6:
        r10.startIntentSenderForResult(r11, r12, r13, r14, r15, r16, r17);
    }

    public void supportFinishAfterTransition() {
        int r8 = androidx.core.app.a.f1587c;
        androidx.core.app.a.b.a(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        int r8 = androidx.core.app.a.f1587c;
        androidx.core.app.a.b.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        int r8 = androidx.core.app.a.f1587c;
        androidx.core.app.a.b.e(this);
    }

    @Override // androidx.core.app.a.d
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int r8) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String r8, Context r10, AttributeSet r11) {
        View r12 = dispatchFragmentsOnCreateView(null, r8, r10, r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return super.onCreateView(r8, r10, r11);
    }

    public void startActivityFromFragment(Fragment r8, @SuppressLint({"UnknownNullness"}) Intent r10, int r11, Bundle r12) {
        if (r11 != (-1)) goto L6;
        int r13 = androidx.core.app.a.f1587c;
        androidx.core.app.a.C0010a.b(this, r10, -1, r12);
        return;
    L6:
        r8.startActivityForResult(r10, r11, r12);
    }

    public m(int r8) {
        super(r8);
        this.mFragments = new p(new c(this));
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.n(this);
        this.mStopped = true;
        init();
    }
}
