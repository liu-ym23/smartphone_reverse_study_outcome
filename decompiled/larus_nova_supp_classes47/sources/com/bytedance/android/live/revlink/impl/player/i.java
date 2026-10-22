package com.bytedance.android.live.revlink.impl.player;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements c {
    public Function0<Unit> a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public LiveMode o;
    public Function1<? super b, Unit> p;
    public k31.a q;
    public k31.k r;

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void h(Function1<? super b, Unit> r1) {
        throw null;
    }

    public final String toString() {
        return "RevenueLayoutContext(_requestLayout=" + this.a + ", _cacheInvalid=" + this.b + ", _isLiveTypeAudio=" + this.c + ", _isPcVrRoom=" + this.e + ", _isPad=" + this.f + ", _isFoldScreenFullType=" + this.g + ", _isPortrait=" + this.h + ", _isPreview=" + this.i + ", _containerWidth=" + this.j + ", _containerHeight=" + this.k + ", _tmpContainerHeight=" + this.l + ", _videoWidth=" + this.m + ", _videoHeight=" + this.n + ", _streamType=" + this.o + ", _componentsOption=" + this.q + ", _statusBarOption=" + this.r + ')';
    }

    public i() {
        this.b = true;
        this.h = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void a(int r2) {
        if (this.k != r2) goto L5;
        return;
    L5:
        this.k = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void c(boolean r2) {
        if (this.f != r2) goto L5;
        return;
    L5:
        this.f = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void d(boolean r2) {
        if (this.h != r2) goto L5;
        return;
    L5:
        this.h = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void f(int r2) {
        if (this.m != r2) goto L5;
        return;
    L5:
        this.m = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void g(boolean r2) {
        if (this.d != r2) goto L5;
        return;
    L5:
        this.d = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void i(k31.a r8) {
        k31.a r0 = this.q;
        Integer r1 = null;
        if (r0 == null) goto L5;
        k31.g r2 = r0.a;
    L6:
        if (r8 == null) goto L8;
        k31.g r3 = r8.a;
    L9:
        if (r2 == null) goto L11;
        Boolean r4 = Boolean.valueOf(r2.a);
    L12:
        if (r3 == null) goto L14;
        Boolean r5 = Boolean.valueOf(r3.a);
    L15:
        boolean r6 = Intrinsics.areEqual(r4, r5);
        boolean r7 = false;
        if (r6 == false) goto L26;
        if (r2 == null) goto L19;
        Integer r9 = r2.b;
    L20:
        if (r3 == null) goto L22;
        Integer r10 = r3.b;
    L24:
        if (Intrinsics.areEqual(r9, r10) == false) goto L26;
        boolean r12 = true;
    L27:
        if (r12 == false) goto L53;
        if (r0 == null) goto L30;
        k31.n r13 = r0.b;
    L31:
        if (r8 == null) goto L33;
        k31.n r14 = r8.b;
    L34:
        if (r13 == null) goto L36;
        Boolean r15 = Boolean.valueOf(r13.a);
    L37:
        if (r14 == null) goto L39;
        Boolean r16 = Boolean.valueOf(r14.a);
    L41:
        if (Intrinsics.areEqual(r15, r16) == false) goto L50;
        if (r13 == null) goto L44;
        Integer r17 = Integer.valueOf(r13.b);
    L45:
        if (r14 == null) goto L48;
        r1 = Integer.valueOf(r14.b);
    L48:
        if (Intrinsics.areEqual(r17, r1) == false) goto L50;
        boolean r18 = true;
    L51:
        if (r18 == false) goto L53;
        r7 = true;
        goto L53
    L44:
        r17 = null;
    L50:
        r18 = false;
        goto L51
    L39:
        r16 = null;
        goto L41
    L36:
        r15 = null;
        goto L37
    L33:
        r14 = null;
        goto L34
    L30:
        r13 = null;
    L53:
        if (r7 == false) goto L55;
        return;
    L55:
        this.q = r8;
        this.b = true;
        return;
    L22:
        r10 = null;
        goto L24
    L19:
        r9 = null;
    L26:
        r12 = false;
        goto L27
    L14:
        r5 = null;
        goto L15
    L11:
        r4 = null;
        goto L12
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void j(int r2) {
        if (this.j != r2) goto L5;
        return;
    L5:
        this.j = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void k(boolean r2) {
        if (this.g != r2) goto L5;
        return;
    L5:
        this.g = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void n(boolean r2) {
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void o(boolean r2) {
        if (this.i != r2) goto L5;
        return;
    L5:
        this.i = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void q(boolean r2) {
        if (this.c != r2) goto L5;
        return;
    L5:
        this.c = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void s(LiveMode r2) {
        if (this.o != r2) goto L5;
        return;
    L5:
        this.o = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void w(int r2) {
        if (this.n != r2) goto L5;
        return;
    L5:
        this.n = r2;
        this.b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void x(k31.k r5) {
        k31.k r0 = this.r;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.a);
    L6:
        if (r5 == null) goto L8;
        Boolean r3 = Boolean.valueOf(r5.a);
    L10:
        if (Intrinsics.areEqual(r2, r3) == false) goto L19;
        if (r0 == null) goto L13;
        Integer r4 = Integer.valueOf(r0.b);
    L14:
        if (r5 == null) goto L17;
        r1 = Integer.valueOf(r5.b);
    L17:
        if (Intrinsics.areEqual(r4, r1) == false) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
        return;
    L22:
        this.r = r5;
        this.b = true;
        return;
    L13:
        r4 = null;
    L19:
        r6 = false;
        goto L20
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
