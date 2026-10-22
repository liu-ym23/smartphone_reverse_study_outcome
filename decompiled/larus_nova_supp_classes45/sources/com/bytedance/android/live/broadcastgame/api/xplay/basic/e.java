package com.bytedance.android.live.broadcastgame.api.xplay.basic;

import android.content.Context;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final Map<String, Object> g;
    public final Map<String, Object> h;
    public final Map<String, Object> i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final int n;
    public final boolean o;
    public final int p;
    public final boolean q;
    public final boolean r;
    public final List<String> s;
    public final boolean t;
    public final Context u;
    public final JSONArray v;
    public final int w;
    public final boolean x;
    public final boolean y;

    public e() {
        this(null, null, 0, 0, 0, 0, null, null, false, false, false, false, false, false, null, false, null, null, 33554431);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L56;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
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
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
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
        if (this.l == r4.l) goto L30;
        return false;
    L30:
        if (this.m == r4.m) goto L32;
        return false;
    L32:
        if (this.n == r4.n) goto L34;
        return false;
    L34:
        if (this.o == r4.o) goto L36;
        return false;
    L36:
        if (this.p == r4.p) goto L38;
        return false;
    L38:
        if (this.q == r4.q) goto L40;
        return false;
    L40:
        if (this.r == r4.r) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.s, r4.s) == true) goto L44;
        return false;
    L44:
        if (this.t == r4.t) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.u, r4.u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.v, r4.v) == true) goto L50;
        return false;
    L50:
        if (this.w == r4.w) goto L52;
        return false;
    L52:
        if (this.x == r4.x) goto L54;
        return false;
    L54:
        if (this.y == r4.y) goto L85;
        return false;
    L85:
        return true;
    L56:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48, types: [int] */
    /* JADX WARN: Type inference failed for: r0v50, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((((((((r3 + r5) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        Map<String, Object> r7 = this.g;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r11 = this.h;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Map<String, Object> r14 = this.i;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.j;
        ?? r18 = 1;
        ?? r19 = r17;
        if (r17 == false) goto L25;
        r19 = 1;
    L25:
        int r21 = (r16 + r19) * 31;
        boolean r22 = this.k;
        ?? r23 = r22;
        if (r22 == false) goto L28;
        r23 = 1;
    L28:
        int r24 = (r21 + r23) * 31;
        boolean r25 = this.l;
        ?? r26 = r25;
        if (r25 == false) goto L31;
        r26 = 1;
    L31:
        int r27 = (r24 + r26) * 31;
        boolean r28 = this.m;
        ?? r29 = r28;
        if (r28 == false) goto L34;
        r29 = 1;
    L34:
        int r31 = (((r27 + r29) * 31) + this.n) * 31;
        boolean r32 = this.o;
        ?? r33 = r32;
        if (r32 == false) goto L37;
        r33 = 1;
    L37:
        int r34 = (((r31 + r33) * 31) + this.p) * 31;
        boolean r35 = this.q;
        ?? r36 = r35;
        if (r35 == false) goto L40;
        r36 = 1;
    L40:
        int r37 = (r34 + r36) * 31;
        boolean r38 = this.r;
        ?? r39 = r38;
        if (r38 == false) goto L43;
        r39 = 1;
    L43:
        int r41 = (r37 + r39) * 31;
        List<String> r42 = this.s;
        if (r42 == null) goto L46;
        int r43 = r42.hashCode();
    L47:
        int r44 = (r41 + r43) * 31;
        boolean r45 = this.t;
        ?? r46 = r45;
        if (r45 == false) goto L50;
        r46 = 1;
    L50:
        int r47 = (r44 + r46) * 31;
        Context r48 = this.u;
        if (r48 == null) goto L53;
        int r49 = r48.hashCode();
    L54:
        int r51 = (r47 + r49) * 31;
        JSONArray r52 = this.v;
        if (r52 == null) goto L57;
        r1 = r52.hashCode();
    L57:
        int r53 = (((r51 + r1) * 31) + this.w) * 31;
        boolean r54 = this.x;
        ?? r55 = r54;
        if (r54 == false) goto L60;
        r55 = 1;
    L60:
        int r56 = (r53 + r55) * 31;
        boolean r57 = this.y;
        if (r57 == true) goto L65;
        r18 = r57;
    L65:
        return r56 + r18;
    L53:
        r49 = 0;
        goto L54
    L46:
        r43 = 0;
        goto L47
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "XplayBasicStartParams(gameId=" + this.a + ", channel=" + this.b + ", displayWidth=" + this.c + ", displayHeight=" + this.d + ", widthRatio=" + this.e + ", heightRatio=" + this.f + ", extraToGame=" + this.g + ", extraToServer=" + this.h + ", monitorCommonParams=" + this.i + ", enableRTCMulti=" + this.j + ", muteAudioPlayback=" + this.k + ", enableVideoFrame=" + this.l + ", enableAudioFrame=" + this.m + ", renderBackgroundColor=" + this.n + ", isUseTextureView=" + this.o + ", videoFrameFormat=" + this.p + ", enableFrameSEIData=" + this.q + ", enableExternalRender=" + this.r + ", cloudPlayers=" + this.s + ", useApplicationContext=" + this.t + ", applicationContext=" + this.u + ", videoSimulcast=" + this.v + ", roomGuestType=" + this.w + ", isPodMergeStream=" + this.x + ", disableAudioFocus=" + this.y + ")";
    }

    public e(String r22, String r23, int r24, int r25, int r26, int r27, Map r28, Map r29, boolean r31, boolean r32, boolean r33, boolean r34, boolean r35, boolean r36, List r37, boolean r38, Context r39, JSONArray r310, int r41) {
        String r3 = "";
        if ((r41 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r41 & 2) != 0) goto L11;
        r3 = r23;
    L11:
        if ((r41 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r41 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r41 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r41 & 32) == 0) goto L25;
        int r8 = 0;
    L27:
        if ((r41 & 64) == 0) goto L29;
        Map r9 = new LinkedHashMap();
    L31:
        if ((r41 & 128) == 0) goto L33;
        Map r11 = new LinkedHashMap();
    L35:
        if ((r41 & 256) == 0) goto L37;
        LinkedHashMap r12 = new LinkedHashMap();
    L39:
        if ((r41 & 512) == 0) goto L41;
        boolean r13 = false;
    L43:
        if ((r41 & RomUtils.SZ) == 0) goto L45;
        boolean r14 = false;
    L47:
        if ((r41 & 2048) == 0) goto L49;
        boolean r15 = false;
    L51:
        if ((r41 & 16384) == 0) goto L53;
        boolean r16 = false;
    L55:
        if ((r41 & 65536) == 0) goto L57;
        boolean r17 = false;
    L59:
        if ((r41 & 131072) == 0) goto L61;
        boolean r18 = false;
    L63:
        if ((r41 & 262144) == 0) goto L65;
        List r5 = new ArrayList();
    L67:
        if ((r41 & 524288) == 0) goto L69;
        boolean r19 = false;
    L71:
        if ((r41 & 1048576) == 0) goto L73;
        Context r21 = null;
    L75:
        if ((r41 & 2097152) == 0) goto L77;
        JSONArray r1 = null;
    L78:
        Intrinsics.checkNotNullParameter(r2, "gameId");
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r9, "extraToGame");
        Intrinsics.checkNotNullParameter(r11, "extraToServer");
        Intrinsics.checkNotNullParameter(r12, "monitorCommonParams");
        Intrinsics.checkNotNullParameter(r5, "cloudPlayers");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = false;
        this.n = 0;
        this.o = r16;
        this.p = 0;
        this.q = r17;
        this.r = r18;
        this.s = r5;
        this.t = r19;
        this.u = r21;
        this.v = r1;
        this.w = 0;
        this.x = false;
        this.y = false;
        return;
    L77:
        r1 = r310;
        goto L78
    L73:
        r21 = r39;
        goto L75
    L69:
        r19 = r38;
        goto L71
    L65:
        r5 = r37;
        goto L67
    L61:
        r18 = r36;
        goto L63
    L57:
        r17 = r35;
        goto L59
    L53:
        r16 = r34;
        goto L55
    L49:
        r15 = r33;
        goto L51
    L45:
        r14 = r32;
        goto L47
    L41:
        r13 = r31;
        goto L43
    L37:
        r12 = null;
        goto L39
    L33:
        r11 = r29;
        goto L35
    L29:
        r9 = r28;
        goto L31
    L25:
        r8 = r27;
        goto L27
    L21:
        r7 = r26;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L5:
        r2 = r22;
        goto L7
    }
}
