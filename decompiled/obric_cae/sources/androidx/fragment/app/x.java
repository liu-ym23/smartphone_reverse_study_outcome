package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.l0;
import com.obric.cae.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f2058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f2059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f2060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2062e;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2063a;

        public a(View r8) {
            this.f2063a = r8;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r8) {
            View r10 = this.f2063a;
            r10.removeOnAttachStateChangeListener(this);
            WeakHashMap<View, j0.h0> r11 = j0.w.f8437a;
            j0.w.h.c(r10);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r8) {
        }
    }

    public x(t r8, y r10, Fragment r11) {
        this.f2061d = false;
        this.f2062e = -1;
        this.f2058a = r8;
        this.f2059b = r10;
        this.f2060c = r11;
    }

    public final void a() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L5;
        Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + r10);
    L5:
        r10.performActivityCreated(r10.mSavedFragmentState);
        this.f2058a.a(false);
    }

    public final void b() {
        y r8 = this.f2059b;
        r8.getClass();
        Fragment r10 = this.f2060c;
        ViewGroup r11 = r10.mContainer;
        int r12 = -1;
        if (r11 == null) goto L20;
        ArrayList<Fragment> r13 = r8.f2064a;
        int r14 = r13.indexOf(r10);
        int r15 = r14 - 1;
    L6:
        if (r15 < 0) goto L13;
        Fragment r16 = r13.get(r15);
        if (r16.mContainer != r11) goto L12;
        View r17 = r16.mView;
        if (r17 == null) goto L12;
        r12 = r11.indexOfChild(r17) + 1;
    L12:
        r15 = r15 - 1;
    L13:
        r14 = r14 + 1;
        if (r14 >= r13.size()) goto L20;
        Fragment r18 = r13.get(r14);
        if (r18.mContainer != r11) goto L13;
        View r19 = r18.mView;
        if (r19 == null) goto L13;
        r12 = r11.indexOfChild(r19);
    L20:
        r10.mContainer.addView(r10.mView, r12);
    }

    public final void c() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L5;
        Log.d("FragmentManager", "moveto ATTACHED: " + r10);
    L5:
        Fragment r11 = r10.mTarget;
        x r12 = null;
        y r13 = this.f2059b;
        if (r11 == null) goto L12;
        x r14 = r13.f2065b.get(r11.mWho);
        if (r14 == null) goto L11;
        r10.mTargetWho = r10.mTarget.mWho;
        r10.mTarget = null;
        r12 = r14;
    L19:
        if (r12 == null) goto L21;
        r12.k();
    L21:
        FragmentManager r15 = r10.mFragmentManager;
        r10.mHost = r15.f1877p;
        r10.mParentFragment = r15.f1879r;
        t r16 = this.f2058a;
        r16.g(false);
        r10.performAttach();
        r16.b(false);
        return;
    L11:
        throw new IllegalStateException("Fragment " + r10 + " declared target fragment " + r10.mTarget + " that does not belong to this FragmentManager!");
    L12:
        String r17 = r10.mTargetWho;
        if (r17 == null) goto L19;
        r12 = r13.f2065b.get(r17);
        if (r12 != null) goto L19;
        StringBuilder r18 = new StringBuilder("Fragment ");
        r18.append(r10);
        r18.append(" declared target fragment ");
        throw new IllegalStateException(android.aimedia.a.i(r18, r10.mTargetWho, " that does not belong to this FragmentManager!"));
    }

    public final int d() {
        Fragment r8 = this.f2060c;
        if (r8.mFragmentManager == null) goto L5;
        int r10 = this.f2062e;
        int r11 = r8.mMaxState.ordinal();
        if (r11 == 1) goto L14;
        if (r11 == 2) goto L13;
        if (r11 == 3) goto L12;
        if (r11 == 4) goto L16;
        r10 = Math.min(r10, -1);
    L16:
        if (r8.mFromLayout == false) goto L28;
        boolean r12 = r8.mInLayout;
        int r13 = this.f2062e;
        if (r12 == false) goto L24;
        r10 = Math.max(r13, 2);
        View r14 = r8.mView;
        if (r14 == null) goto L28;
        if (r14.getParent() != null) goto L28;
        r10 = Math.min(r10, 2);
        goto L28
    L24:
        if (r13 >= 4) goto L26;
        r10 = Math.min(r10, r8.mState);
        goto L28
    L26:
        r10 = Math.min(r10, 1);
    L28:
        if (r8.mAdded == true) goto L30;
        r10 = Math.min(r10, 1);
    L30:
        ViewGroup r15 = r8.mContainer;
        i0.d.b r16 = null;
        i0.d r17 = null;
        if (r15 == null) goto L51;
        i0 r18 = i0.f(r15, r8.getParentFragmentManager());
        r18.getClass();
        i0.d r19 = r18.d(r8);
        if (r19 == null) goto L35;
        i0.d.b r20 = r19.f1984b;
    L36:
        Iterator<i0.d> r110 = r18.f1975c.iterator();
    L38:
        if (r110.hasNext() == false) goto L44;
        i0.d r111 = r110.next();
        if (r111.f1985c.equals(r8) == false) goto L38;
        if (r111.f1988f == true) goto L38;
        r17 = r111;
    L44:
        if (r17 == null) goto L49;
        if (r20 != null) goto L47;
    L48:
        r16 = r17.f1984b;
        goto L51
    L47:
        if (r20 == i0.d.b.f1991a) goto L48;
    L49:
        r16 = r20;
        goto L51
    L35:
        r20 = null;
    L51:
        if (r16 != i0.d.b.f1992b) goto L54;
        r10 = Math.min(r10, 6);
    L63:
        if (r8.mDeferStart == false) goto L68;
        if (r8.mState >= 5) goto L68;
        r10 = Math.min(r10, 4);
    L68:
        if (FragmentManager.G(2) == false) goto L70;
        Log.v("FragmentManager", "computeExpectedState() of " + r10 + " for " + r8);
    L70:
        return r10;
    L54:
        if (r16 != i0.d.b.f1993m) goto L57;
        r10 = Math.max(r10, 3);
        goto L63
    L57:
        if (r8.mRemoving == false) goto L63;
        if (r8.isInBackStack() == false) goto L61;
        r10 = Math.min(r10, 1);
        goto L63
    L61:
        r10 = Math.min(r10, -1);
        goto L63
    L12:
        r10 = Math.min(r10, 5);
        goto L16
    L13:
        r10 = Math.min(r10, 1);
        goto L16
    L14:
        r10 = Math.min(r10, 0);
        goto L16
    L5:
        return r8.mState;
    }

    public final void e() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L6;
        Log.d("FragmentManager", "moveto CREATED: " + r10);
    L6:
        if (r10.mIsCreated == true) goto L8;
        t r11 = this.f2058a;
        r11.h(false);
        r10.performCreate(r10.mSavedFragmentState);
        r11.c(false);
        return;
    L8:
        r10.restoreChildFragmentState(r10.mSavedFragmentState);
        r10.mState = 1;
    }

    public final void f() {
        Fragment r8 = this.f2060c;
        if (r8.mFromLayout == false) goto L6;
        return;
    L6:
        if (FragmentManager.G(3) == false) goto L8;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + r8);
    L8:
        LayoutInflater r10 = r8.performGetLayoutInflater(r8.mSavedFragmentState);
        ViewGroup r11 = r8.mContainer;
        if (r11 != null) goto L28;
        int r12 = r8.mContainerId;
        if (r12 != 0) goto L14;
        r11 = null;
        goto L28
    L14:
        if (r12 == (-1)) goto L26;
        r11 = (ViewGroup) r8.mFragmentManager.f1878q.b(r12);
        if (r11 != null) goto L28;
        if (r8.mRestored == true) goto L28;
        String r13 = r8.getResources().getResourceName(r8.mContainerId);     // Catch: Resources.NotFoundException -> L22
    L24:
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(r8.mContainerId) + " (" + r13 + ") for fragment " + r8);
    L22:
        r13 = "unknown";
        goto L24
    L26:
        throw new IllegalArgumentException(android.aimedia.a.e("Cannot create fragment ", r8, " for a container view with no id"));
    L28:
        r8.mContainer = r11;
        r8.performCreateView(r10, r11, r8.mSavedFragmentState);
        View r14 = r8.mView;
        if (r14 == null) goto L49;
        r14.setSaveFromParentEnabled(false);
        r8.mView.setTag(R.id.fragment_container_view_tag, r8);
        if (r11 == null) goto L34;
        b();
    L34:
        if (r8.mHidden == false) goto L36;
        r8.mView.setVisibility(8);
    L36:
        View r15 = r8.mView;
        WeakHashMap<View, j0.h0> r16 = j0.w.f8437a;
        if (j0.w.g.b(r15) == false) goto L39;
        j0.w.h.c(r8.mView);
    L40:
        r8.performViewCreated();
        this.f2058a.m(false);
        int r17 = r8.mView.getVisibility();
        r8.setPostOnViewCreatedAlpha(r8.mView.getAlpha());
        if (r8.mContainer == null) goto L49;
        if (r17 != 0) goto L49;
        View r18 = r8.mView.findFocus();
        if (r18 == null) goto L48;
        r8.setFocusedView(r18);
        if (FragmentManager.G(2) == false) goto L48;
        Log.v("FragmentManager", "requestFocus: Saved focused view " + r18 + " for Fragment " + r8);
    L48:
        r8.mView.setAlpha(0.0f);
        goto L49
    L39:
        View r19 = r8.mView;
        r19.addOnAttachStateChangeListener(new a(r19));
    L49:
        r8.mState = 2;
    }

    public final void g() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L5;
        Log.d("FragmentManager", "movefrom CREATED: " + r10);
    L5:
        boolean r11 = true;
        if (r10.mRemoving == true) goto L8;
    L10:
        boolean r12 = false;
    L11:
        y r13 = this.f2059b;
        if (r12 == true) goto L22;
        v r14 = r13.f2066c;
        if (r14.f2052d.containsKey(r10.mWho) == true) goto L17;
    L15:
        boolean r15 = true;
    L19:
        if (r15 == true) goto L22;
        boolean r16 = false;
    L23:
        if (r16 == false) goto L53;
        r<?> r17 = r10.mHost;
        if ((r17 instanceof l0) == false) goto L27;
        r11 = r13.f2066c.f2056h;
    L30:
        if (r12 == true) goto L32;
        if (r11 == true) goto L32;
    L41:
        r10.performDestroy();
        this.f2058a.d(false);
        Iterator r18 = r13.d().iterator();
    L43:
        if (r18.hasNext() == false) goto L49;
        x r19 = (x) r18.next();
        if (r19 == null) goto L43;
        String r20 = r10.mWho;
        Fragment r21 = r19.f2060c;
        if (r20.equals(r21.mTargetWho) == false) goto L43;
        r21.mTarget = r10;
        r21.mTargetWho = null;
        goto L43
    L49:
        String r22 = r10.mTargetWho;
        if (r22 == null) goto L52;
        r10.mTarget = r13.b(r22);
    L52:
        r13.h(this);
        return;
    L32:
        v r23 = r13.f2066c;
        r23.getClass();
        if (FragmentManager.G(3) == false) goto L35;
        Log.d("FragmentManager", "Clearing non-config state for " + r10);
    L35:
        HashMap<String, v> r24 = r23.f2053e;
        v r25 = r24.get(r10.mWho);
        if (r25 == null) goto L38;
        r25.b();
        r24.remove(r10.mWho);
    L38:
        HashMap<String, androidx.lifecycle.k0> r26 = r23.f2054f;
        androidx.lifecycle.k0 r27 = r26.get(r10.mWho);
        if (r27 == null) goto L41;
        r27.a();
        r26.remove(r10.mWho);
        goto L41
    L27:
        Context r28 = r17.f2043b;
        if ((r28 instanceof Activity) == false) goto L30;
        r11 = true ^ ((Activity) r28).isChangingConfigurations();
        goto L30
    L53:
        String r110 = r10.mTargetWho;
        if (r110 == null) goto L60;
        Fragment r111 = r13.b(r110);
        if (r111 == null) goto L60;
        if (r111.mRetainInstance == false) goto L60;
        r10.mTarget = r111;
    L60:
        r10.mState = 0;
        return;
    L17:
        if (r14.f2055g == false) goto L15;
        r15 = r14.f2056h;
    L22:
        r16 = true;
        goto L23
    L8:
        if (r10.isInBackStack() == true) goto L10;
        r12 = true;
        goto L11
    }

    public final void h() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L5;
        Log.d("FragmentManager", "movefrom CREATE_VIEW: " + r10);
    L5:
        ViewGroup r11 = r10.mContainer;
        if (r11 == null) goto L10;
        View r12 = r10.mView;
        if (r12 == null) goto L10;
        r11.removeView(r12);
    L10:
        r10.performDestroyView();
        this.f2058a.n(false);
        r10.mContainer = null;
        r10.mView = null;
        r10.mViewLifecycleOwner = null;
        r10.mViewLifecycleOwnerLiveData.i(null);
        r10.mInLayout = false;
    }

    public final void i() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L5;
        Log.d("FragmentManager", "movefrom ATTACHED: " + r10);
    L5:
        r10.performDetach();
        boolean r11 = false;
        this.f2058a.e(false);
        r10.mState = -1;
        r10.mHost = null;
        r10.mParentFragment = null;
        r10.mFragmentManager = null;
        boolean r12 = true;
        if (r10.mRemoving == true) goto L8;
    L10:
        if (r11 == true) goto L19;
        v r13 = this.f2059b.f2066c;
        if (r13.f2052d.containsKey(r10.mWho) == true) goto L15;
    L17:
        if (r12 == true) goto L19;
        return;
    L15:
        if (r13.f2055g == false) goto L17;
        r12 = r13.f2056h;
    L19:
        if (FragmentManager.G(3) == false) goto L21;
        Log.d("FragmentManager", "initState called for fragment: " + r10);
    L21:
        r10.initState();
        return;
    L8:
        if (r10.isInBackStack() == true) goto L10;
        r11 = true;
        goto L10
    }

    public final void j() {
        Fragment r8 = this.f2060c;
        if (r8.mFromLayout == true) goto L5;
        return;
    L5:
        if (r8.mInLayout == true) goto L7;
        return;
    L7:
        if (r8.mPerformedCreateView == false) goto L9;
        return;
    L9:
        if (FragmentManager.G(3) == false) goto L11;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + r8);
    L11:
        r8.performCreateView(r8.performGetLayoutInflater(r8.mSavedFragmentState), null, r8.mSavedFragmentState);
        View r10 = r8.mView;
        if (r10 == null) goto L21;
        r10.setSaveFromParentEnabled(false);
        r8.mView.setTag(R.id.fragment_container_view_tag, r8);
        if (r8.mHidden == false) goto L16;
        r8.mView.setVisibility(8);
    L16:
        r8.performViewCreated();
        this.f2058a.m(false);
        r8.mState = 2;
        return;
    }

    public final void k() {
        boolean r8 = this.f2061d;
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L88;
        if (FragmentManager.G(2) == false) goto L130;
        Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + r10);
        return;
    L130:
        return;
    L88:
        this.f2061d = true;     // Catch: Throwable -> L85
    L10:
        int r11 = d();     // Catch: Throwable -> L85
        int r12 = r10.mState;     // Catch: Throwable -> L85
        if (r11 == r12) goto L60;
        if (r11 > r12) goto L14;
        switch((r12 - 1)) {
            case -1: goto L58;
            case 0: goto L57;
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L10;
        };     // Catch: Throwable -> L85
    L35:
        l();     // Catch: Throwable -> L85
        goto L10
    L36:
        r10.mState = 5;     // Catch: Throwable -> L85
        goto L10
    L37:
        q();     // Catch: Throwable -> L85
        goto L10
    L39:
        if (FragmentManager.G(3) == false) goto L42;
        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + r10);     // Catch: Throwable -> L85
    L42:
        if (r10.mView == null) goto L47;
        if (r10.mSavedViewState != null) goto L47;
        o();     // Catch: Throwable -> L85
    L47:
        if (r10.mView == null) goto L54;
        ViewGroup r13 = r10.mContainer;     // Catch: Throwable -> L85
        if (r13 == null) goto L54;
        i0 r14 = i0.f(r13, r10.getParentFragmentManager());     // Catch: Throwable -> L85
        r14.getClass();     // Catch: Throwable -> L85
        if (FragmentManager.G(2) == false) goto L53;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + r10);     // Catch: Throwable -> L85
    L53:
        r14.a(i0.d.c.f1995a, i0.d.b.f1993m, this);     // Catch: Throwable -> L85
    L54:
        r10.mState = 3;     // Catch: Throwable -> L85
        goto L10
    L55:
        r10.mInLayout = false;     // Catch: Throwable -> L85
        r10.mState = 2;     // Catch: Throwable -> L85
        goto L10
    L56:
        h();     // Catch: Throwable -> L85
        r10.mState = 1;     // Catch: Throwable -> L85
        goto L10
    L57:
        g();     // Catch: Throwable -> L85
        goto L10
    L58:
        i();     // Catch: Throwable -> L85
        goto L10
    L14:
        switch((r12 + 1)) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            default: goto L10;
        };     // Catch: Throwable -> L85
    L16:
        n();     // Catch: Throwable -> L85
        goto L10
    L17:
        r10.mState = 6;     // Catch: Throwable -> L85
        goto L10
    L18:
        p();     // Catch: Throwable -> L85
        goto L10
    L20:
        if (r10.mView == null) goto L27;
        ViewGroup r15 = r10.mContainer;     // Catch: Throwable -> L85
        if (r15 == null) goto L27;
        i0 r16 = i0.f(r15, r10.getParentFragmentManager());     // Catch: Throwable -> L85
        i0.d.c r17 = i0.d.c.b(r10.mView.getVisibility());     // Catch: Throwable -> L85
        r16.getClass();     // Catch: Throwable -> L85
        if (FragmentManager.G(2) == false) goto L26;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + r10);     // Catch: Throwable -> L85
    L26:
        r16.a(r17, i0.d.b.f1992b, this);     // Catch: Throwable -> L85
    L27:
        r10.mState = 4;     // Catch: Throwable -> L85
        goto L10
    L28:
        a();     // Catch: Throwable -> L85
        goto L10
    L29:
        j();     // Catch: Throwable -> L85
        f();     // Catch: Throwable -> L85
        goto L10
    L30:
        e();     // Catch: Throwable -> L85
        goto L10
    L31:
        c();     // Catch: Throwable -> L85
        goto L10
    L60:
        if (r10.mHiddenChanged == true) goto L62;
    L83:
        this.f2061d = false;
        return;
    L62:
        if (r10.mView == null) goto L75;
        ViewGroup r18 = r10.mContainer;     // Catch: Throwable -> L85
        if (r18 == null) goto L75;
        i0 r19 = i0.f(r18, r10.getParentFragmentManager());     // Catch: Throwable -> L85
        if (r10.mHidden == false) goto L71;
        r19.getClass();     // Catch: Throwable -> L85
        if (FragmentManager.G(2) == false) goto L70;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + r10);     // Catch: Throwable -> L85
    L70:
        r19.a(i0.d.c.f1997m, i0.d.b.f1991a, this);     // Catch: Throwable -> L85
        goto L75
    L71:
        r19.getClass();     // Catch: Throwable -> L85
        if (FragmentManager.G(2) == false) goto L74;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + r10);     // Catch: Throwable -> L85
    L74:
        r19.a(i0.d.c.f1996b, i0.d.b.f1991a, this);     // Catch: Throwable -> L85
    L75:
        FragmentManager r20 = r10.mFragmentManager;     // Catch: Throwable -> L85
        if (r20 != null) goto L78;
    L82:
        r10.mHiddenChanged = false;     // Catch: Throwable -> L85
        r10.onHiddenChanged(r10.mHidden);     // Catch: Throwable -> L85
        goto L83
    L78:
        if (r10.mAdded == false) goto L82;
        if (FragmentManager.H(r10) == false) goto L82;
        r20.f1887z = true;     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        this.f2061d = false;
        throw th;
    }

    public final void l() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L5;
        Log.d("FragmentManager", "movefrom RESUMED: " + r10);
    L5:
        r10.performPause();
        this.f2058a.f(false);
    }

    public final void m(ClassLoader r8) {
        Fragment r10 = this.f2060c;
        Bundle r11 = r10.mSavedFragmentState;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setClassLoader(r8);
        r10.mSavedViewState = r10.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        r10.mSavedViewRegistryState = r10.mSavedFragmentState.getBundle("android:view_registry_state");
        r10.mTargetWho = r10.mSavedFragmentState.getString("android:target_state");
        if (r10.mTargetWho == null) goto L8;
        r10.mTargetRequestCode = r10.mSavedFragmentState.getInt("android:target_req_state", 0);
    L8:
        Boolean r12 = r10.mSavedUserVisibleHint;
        if (r12 == null) goto L11;
        r10.mUserVisibleHint = r12.booleanValue();
        r10.mSavedUserVisibleHint = null;
    L13:
        if (r10.mUserVisibleHint == true) goto L16;
        r10.mDeferStart = true;
        return;
    L16:
        return;
    L11:
        r10.mUserVisibleHint = r10.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        goto L13
    }

    public final void n() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L5;
        Log.d("FragmentManager", "moveto RESUMED: " + r10);
    L5:
        View r11 = r10.getFocusedView();
        if (r11 != null) goto L8;
    L25:
        r10.setFocusedView(null);
        r10.performResume();
        this.f2058a.i(false);
        r10.mSavedFragmentState = null;
        r10.mSavedViewState = null;
        r10.mSavedViewRegistryState = null;
        return;
    L8:
        if (r11 == r10.mView) goto L14;
        ViewParent r12 = r11.getParent();
    L11:
        if (r12 == null) goto L16;
        if (r12 == r10.mView) goto L14;
        r12 = r12.getParent();
        goto L11
    L16:
        boolean r13 = false;
    L17:
        if (r13 == false) goto L25;
        boolean r14 = r11.requestFocus();
        if (FragmentManager.G(2) == false) goto L25;
        StringBuilder r15 = new StringBuilder("requestFocus: Restoring focused view ");
        r15.append(r11);
        r15.append(" ");
        if (r14 == false) goto L23;
        String r16 = "succeeded";
    L24:
        r15.append(r16);
        r15.append(" on Fragment ");
        r15.append(r10);
        r15.append(" resulting in focused view ");
        r15.append(r10.mView.findFocus());
        Log.v("FragmentManager", r15.toString());
        goto L25
    L23:
        r16 = "failed";
    L14:
        r13 = true;
        goto L17
    }

    public final void o() {
        Fragment r8 = this.f2060c;
        if (r8.mView != null) goto L5;
        return;
    L5:
        SparseArray<Parcelable> r10 = new SparseArray();
        r8.mView.saveHierarchyState(r10);
        if (r10.size() <= 0) goto L8;
        r8.mSavedViewState = r10;
    L8:
        Bundle r11 = new Bundle();
        r8.mViewLifecycleOwner.f1966m.c(r11);
        if (r11.isEmpty() == true) goto L12;
        r8.mSavedViewRegistryState = r11;
        return;
    }

    public final void p() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L5;
        Log.d("FragmentManager", "moveto STARTED: " + r10);
    L5:
        r10.performStart();
        this.f2058a.k(false);
    }

    public final void q() {
        boolean r8 = FragmentManager.G(3);
        Fragment r10 = this.f2060c;
        if (r8 == false) goto L5;
        Log.d("FragmentManager", "movefrom STARTED: " + r10);
    L5:
        r10.performStop();
        this.f2058a.l(false);
    }

    public x(t r8, y r10, Fragment r11, FragmentState r12) {
        this.f2061d = false;
        this.f2062e = -1;
        this.f2058a = r8;
        this.f2059b = r10;
        this.f2060c = r11;
        r11.mSavedViewState = null;
        r11.mSavedViewRegistryState = null;
        r11.mBackStackNesting = 0;
        r11.mInLayout = false;
        r11.mAdded = false;
        Fragment r13 = r11.mTarget;
        if (r13 == null) goto L5;
        String r14 = r13.mWho;
    L6:
        r11.mTargetWho = r14;
        r11.mTarget = null;
        Bundle r15 = r12.f1921w;
        if (r15 != null) goto L10;
        r15 = new Bundle();
    L10:
        r11.mSavedFragmentState = r15;
        return;
    L5:
        r14 = null;
        goto L6
    }

    public x(t r8, y r10, ClassLoader r11, q r12, FragmentState r13) {
        this.f2061d = false;
        this.f2062e = -1;
        this.f2058a = r8;
        this.f2059b = r10;
        Fragment r14 = Fragment.instantiate(((FragmentManager.e) r12).f1893b.f1877p.f2043b, r13.f1909a, null);
        this.f2060c = r14;
        Bundle r15 = r13.f1918t;
        if (r15 == null) goto L5;
        r15.setClassLoader(r11);
    L5:
        r14.setArguments(r15);
        r14.mWho = r13.f1910b;
        r14.mFromLayout = r13.f1911m;
        r14.mRestored = true;
        r14.mFragmentId = r13.f1912n;
        r14.mContainerId = r13.f1913o;
        r14.mTag = r13.f1914p;
        r14.mRetainInstance = r13.f1915q;
        r14.mRemoving = r13.f1916r;
        r14.mDetached = r13.f1917s;
        r14.mHidden = r13.f1919u;
        r14.mMaxState = androidx.lifecycle.h.b.values()[r13.f1920v];
        Bundle r16 = r13.f1921w;
        if (r16 != null) goto L9;
        r16 = new Bundle();
    L9:
        r14.mSavedFragmentState = r16;
        if (FragmentManager.G(2) == false) goto L13;
        Log.v("FragmentManager", "Instantiated fragment " + r14);
        return;
    }
}
