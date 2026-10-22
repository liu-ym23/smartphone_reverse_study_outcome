package j0;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewParent f8403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewParent f8404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f8405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f8407e;

    public m(View r8) {
        this.f8405c = r8;
    }

    public final boolean a(float r8, float r10, boolean r11) {
        if (this.f8406d == false) goto L14;
        ViewParent r12 = f(0);
        if (r12 != null) goto L12;
        return false;
    L12:
        return e0.a(r12, this.f8405c, r8, r10, r11);
    L9:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r12 + " does not implement interface method onNestedFling", e);
        return false;
    L14:
        return false;
    }

    public final boolean b(float r8, float r10) {
        if (this.f8406d == false) goto L14;
        ViewParent r11 = f(0);
        if (r11 != null) goto L12;
        return false;
    L12:
        return e0.b(r11, this.f8405c, r8, r10);
    L9:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r11 + " does not implement interface method onNestedPreFling", e);
        return false;
    L14:
        return false;
    }

    public final boolean c(int r14, int r15, int[] r16, int[] r17, int r18) {
        if (this.f8406d == false) goto L41;
        ViewParent r8 = f(r18);
        if (r8 != null) goto L8;
        return false;
    L8:
        if (r14 != 0) goto L13;
        if (r15 != 0) goto L13;
        if (r17 == null) goto L42;
        r17[0] = 0;
        r17[1] = 0;
        return false;
    L42:
        return false;
    L13:
        View r10 = this.f8405c;
        if (r17 == null) goto L16;
        r10.getLocationInWindow(r17);
        int r11 = r17[0];
        int r12 = r17[1];
        int r13 = r11;
    L17:
        if (r16 == null) goto L19;
        int[] r19 = r16;
    L23:
        r19[0] = 0;
        r19[1] = 0;
        View r20 = this.f8405c;
        if ((r8 instanceof n) == false) goto L26;
        ((n) r8).k(r20, r14, r15, r19, r18);
    L31:
        if (r17 == null) goto L34;
        r10.getLocationInWindow(r17);
        r17[0] = r17[0] - r13;
        r17[1] = r17[1] - r12;
    L34:
        if (r19[0] != 0) goto L38;
        if (r19[1] != 0) goto L38;
        return false;
    L38:
        return true;
    L26:
        if (r18 != 0) goto L31;
        e0.c(r8, r20, r14, r15, r19);     // Catch: AbstractMethodError -> L29
    L29:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r8 + " does not implement interface method onNestedPreScroll", e);
        goto L31
    L19:
        if (this.f8407e != null) goto L21;
        this.f8407e = new int[2];
    L21:
        r19 = this.f8407e;
        goto L23
    L16:
        r13 = 0;
        r12 = 0;
        goto L17
    L41:
        return false;
    }

    public final void d(int r10, int r11, int r12, int[] r13) {
        e(0, r10, 0, r11, null, r12, r13);
    }

    public final boolean e(int r16, int r17, int r18, int r19, int[] r20, int r21, int[] r22) {
        if (this.f8406d == false) goto L40;
        ViewParent r8 = f(r21);
        if (r8 != null) goto L8;
        return false;
    L8:
        if (r16 != 0) goto L15;
        if (r17 != 0) goto L15;
        if (r18 != 0) goto L15;
        if (r19 != 0) goto L15;
        if (r20 == null) goto L40;
        r20[0] = 0;
        r20[1] = 0;
    L15:
        View r11 = this.f8405c;
        if (r20 == null) goto L18;
        r11.getLocationInWindow(r20);
        int r12 = r20[0];
        int r13 = r20[1];
    L19:
        if (r22 == null) goto L21;
        int[] r14 = r22;
    L25:
        View r10 = this.f8405c;
        if ((r8 instanceof o) == false) goto L28;
        ((o) r8).m(r10, r16, r17, r18, r19, r21, r14);
    L37:
        if (r20 == null) goto L39;
        r11.getLocationInWindow(r20);
        r20[0] = r20[0] - r12;
        r20[1] = r20[1] - r13;
    L39:
        return true;
    L28:
        r14[0] = r14[0] + r18;
        r14[1] = r14[1] + r19;
        if ((r8 instanceof n) == false) goto L31;
        ((n) r8).n(r10, r16, r17, r18, r19, r21);
        goto L37
    L31:
        if (r21 != 0) goto L37;
        e0.d(r8, r10, r16, r17, r18, r19);     // Catch: AbstractMethodError -> L35
    L35:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r8 + " does not implement interface method onNestedScroll", e);
        goto L37
    L21:
        if (this.f8407e != null) goto L23;
        this.f8407e = new int[2];
    L23:
        int[] r15 = this.f8407e;
        r15[0] = 0;
        r15[1] = 0;
        r14 = r15;
        goto L25
    L18:
        r12 = 0;
        r13 = 0;
    L40:
        return false;
    }

    public final ViewParent f(int r8) {
        if (r8 == 0) goto L10;
        if (r8 == 1) goto L8;
        return null;
    L8:
        return this.f8404b;
    L10:
        return this.f8403a;
    }

    public final boolean g(int r12, int r13) {
        if (f(r13) == null) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L9;
        return true;
    L9:
        if (this.f8406d == false) goto L39;
        View r10 = this.f8405c;
        ViewParent r11 = r10.getParent();
        View r14 = r10;
    L11:
        if (r11 == null) goto L39;
        boolean r15 = r11 instanceof n;
        if (r15 == false) goto L15;
        boolean r16 = ((n) r11).o(r14, r10, r12, r13);
    L21:
        if (r16 == true) goto L22;
        if ((r11 instanceof View) == false) goto L38;
        r14 = r11;
    L38:
        r11 = r11.getParent();
        goto L11
    L22:
        if (r13 == 0) goto L26;
        if (r13 != 1) goto L27;
        this.f8404b = r11;
    L27:
        if (r15 == false) goto L29;
        ((n) r11).i(r14, r10, r12, r13);
    L34:
        return true;
    L29:
        if (r13 != 0) goto L34;
        e0.e(r11, r14, r10, r12);     // Catch: AbstractMethodError -> L32
    L32:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r11 + " does not implement interface method onNestedScrollAccepted", e);
        goto L34
    L26:
        this.f8403a = r11;
        goto L27
    L15:
        if (r13 == 0) goto L40;
    L20:
        r16 = false;
        goto L21
    L40:
        r16 = e0.f(r11, r14, r10, r12);     // Catch: AbstractMethodError -> L18
    L18:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r11 + " does not implement interface method onStartNestedScroll", e);
    L39:
        return false;
    L5:
        r8 = false;
        goto L6
    }

    public final void h(int r8) {
        ViewParent r10 = f(r8);
        if (r10 == null) goto L22;
        boolean r11 = r10 instanceof n;
        View r12 = this.f8405c;
        if (r11 == false) goto L7;
        ((n) r10).j(r12, r8);
    L13:
        if (r8 != 0) goto L15;
        this.f8403a = null;
        return;
    L15:
        if (r8 != 1) goto L24;
        this.f8404b = null;
        return;
    L24:
        return;
    L7:
        if (r8 != 0) goto L13;
        e0.g(r10, r12);     // Catch: AbstractMethodError -> L10
    L10:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r10 + " does not implement interface method onStopNestedScroll", e);
        goto L13
    }
}
