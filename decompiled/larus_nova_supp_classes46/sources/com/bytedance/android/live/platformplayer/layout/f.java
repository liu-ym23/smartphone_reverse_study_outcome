package com.bytedance.android.live.platformplayer.layout;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public ILivePlayerScene i;
    public int j;
    public int k;
    public IRoom l;
    public DataCenter m;
    public LiveMode n;
    public IBaseStreamUrl o;
    public ILivePlayerClient p;
    public int q;
    public Function1<? super e, Unit> r;
    public Function0<a> s;
    public Function0<a> t;
    public Context u;
    public c v;
    public BottomContainerSize w;
    public TranslationAndScaleProperty x;

    public f() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L54;
        f r4 = (f) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (this.j == r4.j) goto L26;
        return false;
    L26:
        if (this.k == r4.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L38;
        return false;
    L38:
        if (this.q == r4.q) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.r, r4.r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.s, r4.s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.t, r4.t) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.u, r4.u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.v, r4.v) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.w, r4.w) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.x, r4.x) == true) goto L82;
        return false;
    L82:
        return true;
    L54:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        if (r10 == true) goto L15;
        r1 = r10;
    L15:
        int r11 = (((((((((r9 + r1) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31;
        ILivePlayerScene r12 = this.i;
        int r13 = 0;
        if (r12 == null) goto L18;
        int r14 = r12.hashCode();
    L19:
        int r15 = (((((r11 + r14) * 31) + this.j) * 31) + this.k) * 31;
        IRoom r16 = this.l;
        if (r16 == null) goto L22;
        int r17 = r16.hashCode();
    L23:
        int r18 = (r15 + r17) * 31;
        DataCenter r19 = this.m;
        if (r19 == null) goto L26;
        int r20 = r19.hashCode();
    L27:
        int r21 = (r18 + r20) * 31;
        LiveMode r22 = this.n;
        if (r22 == null) goto L30;
        int r23 = r22.hashCode();
    L31:
        int r24 = (r21 + r23) * 31;
        IBaseStreamUrl r25 = this.o;
        if (r25 == null) goto L34;
        int r26 = r25.hashCode();
    L35:
        int r27 = (r24 + r26) * 31;
        ILivePlayerClient r28 = this.p;
        if (r28 == null) goto L38;
        int r29 = r28.hashCode();
    L39:
        int r30 = (((r27 + r29) * 31) + this.q) * 31;
        Function1<? super e, Unit> r31 = this.r;
        if (r31 == null) goto L42;
        int r32 = r31.hashCode();
    L43:
        int r33 = (r30 + r32) * 31;
        Function0<a> r34 = this.s;
        if (r34 == null) goto L46;
        int r35 = r34.hashCode();
    L47:
        int r36 = (r33 + r35) * 31;
        Function0<a> r37 = this.t;
        if (r37 == null) goto L50;
        int r38 = r37.hashCode();
    L51:
        int r39 = (r36 + r38) * 31;
        Context r40 = this.u;
        if (r40 == null) goto L54;
        int r41 = r40.hashCode();
    L55:
        int r42 = (r39 + r41) * 31;
        c r43 = this.v;
        if (r43 == null) goto L58;
        int r44 = r43.hashCode();
    L59:
        int r45 = (r42 + r44) * 31;
        BottomContainerSize r46 = this.w;
        if (r46 == null) goto L62;
        int r47 = r46.hashCode();
    L63:
        int r48 = (r45 + r47) * 31;
        TranslationAndScaleProperty r49 = this.x;
        if (r49 == null) goto L67;
        r13 = r49.hashCode();
    L67:
        return r48 + r13;
    L62:
        r47 = 0;
        goto L63
    L58:
        r44 = 0;
        goto L59
    L54:
        r41 = 0;
        goto L55
    L50:
        r38 = 0;
        goto L51
    L46:
        r35 = 0;
        goto L47
    L42:
        r32 = 0;
        goto L43
    L38:
        r29 = 0;
        goto L39
    L34:
        r26 = 0;
        goto L35
    L30:
        r23 = 0;
        goto L31
    L26:
        r20 = 0;
        goto L27
    L22:
        r17 = 0;
        goto L23
    L18:
        r14 = 0;
        goto L19
    }

    public final String toString() {
        return "LivePlayerLayoutContext(isPad=" + this.a + ", isFoldScreen=" + this.b + ", isFoldScreenFullType=" + this.c + ", isPortrait=" + this.d + ", screenWidth=" + this.e + ", screenHeight=" + this.f + ", videoWidth=" + this.g + ", videoHeight=" + this.h + ", useScene=" + this.i + ", containerWidth=" + this.j + ", containerHeight=" + this.k + ", room=" + this.l + ", dataCenter=" + this.m + ", streamType=" + this.n + ", streamUrl=" + this.o + ", playerClient=" + this.p + ", topViewHeightPx=" + this.q + ", previewDataEvent=" + this.r + ", extraPreviewLayoutDataFunc=" + this.s + ", extraInRoomLayoutDataFunc=" + this.t + ", activityContext=" + this.u + ", previewPlayerPosition=" + this.v + ", bottomContainerSize=" + this.w + ", translationAndScale=" + this.x + ")";
    }

    public f(Object r3) {
        ILivePlayerScene r4 = ILivePlayerScene.Companion.preview();
        LiveMode r0 = LiveMode.VIDEO;
        Intrinsics.checkNotNullParameter(r4, "useScene");
        Intrinsics.checkNotNullParameter(r0, "streamType");
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = true;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = r4;
        this.j = -1;
        this.k = -1;
        this.l = null;
        this.m = null;
        this.n = r0;
        this.o = null;
        this.p = null;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
    }
}
