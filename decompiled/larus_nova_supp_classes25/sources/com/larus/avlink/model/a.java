package com.larus.avlink.model;

import b49.h;
import com.larus.avlink.e.DoraImageEvent;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import z98.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public Integer A;
    public Long B;
    public int C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public String H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public final Map<DoraImageEvent, d> M;
    public DoraImageEvent N;
    public Integer a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public final String g;
    public int h;
    public long i;
    public int j;
    public int k;
    public final List<byte[]> l;
    public int m;
    public Integer n;
    public Long o;
    public boolean p;
    public Boolean q;
    public int r;
    public String s;
    public Long t;
    public Long u;
    public Long v;
    public Long w;
    public String x;
    public Map<String, ? extends Object> y;
    public boolean z;

    public a() {
        this(null, 0, 0, 0, 0, null, null, null, -1, 63);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r9.r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r9.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r9.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r9.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r9.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r9.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r9.y) == true) goto L84;
        return false;
    L84:
        if (this.z == r9.z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r9.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r9.B) == true) goto L93;
        return false;
    L93:
        if (this.C == r9.C) goto L96;
        return false;
    L96:
        if (this.D == r9.D) goto L99;
        return false;
    L99:
        if (this.E == r9.E) goto L102;
        return false;
    L102:
        if (this.F == r9.F) goto L105;
        return false;
    L105:
        if (this.G == r9.G) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r9.H) == true) goto L111;
        return false;
    L111:
        if (this.I == r9.I) goto L114;
        return false;
    L114:
        if (this.J == r9.J) goto L117;
        return false;
    L117:
        if (this.K == r9.K) goto L120;
        return false;
    L120:
        if (this.L == r9.L) goto L122;
        return false;
    L122:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((((((r2 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        String r4 = this.g;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.h) * 31;
        long r7 = this.i;
        int r8 = (((((((((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.j) * 31) + this.k) * 31) + this.l.hashCode()) * 31) + this.m) * 31;
        Integer r9 = this.n;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        Long r12 = this.o;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        int r15 = 1231;
        if (this.p == false) goto L21;
        int r16 = 1231;
    L22:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.q;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (((((r17 + r19) * 31) + this.r) * 31) + this.s.hashCode()) * 31;
        Long r21 = this.t;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        Long r24 = this.u;
        if (r24 != null) goto L33;
        int r25 = 0;
    L34:
        int r26 = (r23 + r25) * 31;
        Long r27 = this.v;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        Long r30 = this.w;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        String r33 = this.x;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        Map<String, ? extends Object> r36 = this.y;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        if (this.z == false) goto L53;
        int r39 = 1231;
    L54:
        int r40 = (r38 + r39) * 31;
        Integer r41 = this.A;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        Long r44 = this.B;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (((((((((r43 + r45) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F) * 31;
        if (this.G == false) goto L65;
        int r47 = 1231;
    L66:
        int r48 = (r46 + r47) * 31;
        String r49 = this.H;
        if (r49 == null) goto L70;
        r1 = r49.hashCode();
    L70:
        int r50 = (r48 + r1) * 31;
        if (this.I == false) goto L73;
        int r51 = 1231;
    L74:
        int r52 = (r50 + r51) * 31;
        if (this.J == false) goto L77;
        int r53 = 1231;
    L78:
        int r54 = (r52 + r53) * 31;
        if (this.K == true) goto L83;
        r15 = 1237;
    L83:
        return ((r54 + r15) * 31) + this.L;
    L77:
        r53 = 1237;
        goto L78
    L73:
        r51 = 1237;
        goto L74
    L65:
        r47 = 1237;
        goto L66
    L61:
        r45 = r44.hashCode();
        goto L62
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = 1237;
        goto L54
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r28 = r27.hashCode();
        goto L38
    L33:
        r25 = r24.hashCode();
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = 1237;
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final List<h> a() {
        Integer r0 = this.a;
        if (r0 == null) goto L24;
        int r1 = r0.intValue();
        List r2 = CollectionsKt.filterNotNull(this.l);
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r13 = r2.iterator();
    L6:
        if (r13.hasNext() == false) goto L22;
        byte[] r3 = (byte[]) r13.next();
        int r4 = this.b;
        int r5 = this.c;
        int r6 = this.D;
        ServerSide.a r7 = ServerSide.Companion;
        Integer r8 = Integer.valueOf(this.h);
        r7.getClass();
        if (r8 == null) goto L13;
        int r9 = 1;
        if (r8.intValue() != 1) goto L13;
    L17:
        int r10 = this.C;
        int r11 = this.m;
        Long r14 = this.o;
        if (r14 == null) goto L20;
        long r15 = r14.longValue();
    L21:
        r12.add(new h(r1, r3, r4, r5, r6, r9, r10, r11, r15));
        goto L6
    L20:
        r15 = 0;
    L13:
        if (r8 == null) goto L16;
        r8.intValue();
    L16:
        r9 = 0;
        goto L17
    L22:
        return r12;
    L24:
        return CollectionsKt.emptyList();
    }

    public final String toString() {
        return "DoraPicModel(imageUUid=" + this.a + ", width=" + this.b + ", height=" + this.c + ", qualityValue=" + this.d + ", definitionValue=" + this.e + ", isLiveAI=" + this.f + ", localImageId=" + this.g + ", serverSide=" + this.h + ", size=" + this.i + ", wkrId=" + this.j + ", imageCount=" + this.k + ", imageMode=" + this.m + ", intentMode=" + this.n + ", imageCreateTime=" + this.o + ", hasOcr=" + this.p + ", ocrDetectionRes=" + this.q + ", imageUploadChannel=" + this.r + ", imageUploadId='" + this.s + "', ocrStartTime=" + this.t + ", ocrTransmitFinishTime=" + this.u + ", ocrUploadStartTime=" + this.v + ", ocrUploadFinishTime=" + this.w + ", ocrData=" + this.x + ", ocrUploaded=" + this.z + ", ocrStatus=" + this.A + ", ocrDuration=" + this.B + ", linkType=" + this.C + ", format=" + this.D + ", cameraOutputStrategy=" + this.E + ", ocrTextLines=" + this.F + ", hasSendImage=" + this.G + ", messageId=" + this.H + ", ledBlocked=" + this.I + ", asrEnd=" + this.J + ", blockedConsumed=" + this.K + ", currentState=" + this.N + ", imageEventState=" + this.M + ')';
    }

    public final Long b(DoraImageEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        d r4 = this.M.get(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r4.b);
    }

    public final void c(DoraImageEvent r4, boolean r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "event");
        FLogger.a.i("DoraPicModel", "updateImageState: event is " + r4 + ", success is " + r5 + ", timeStamp is " + r6);
        this.M.put(r4, new d(r5, r6));
        if (r4.compareTo(this.N) <= 0) goto L6;
        this.N = r4;
        return;
    }

    public a(Integer r17, int r18, int r19, int r20, int r21, Integer r22, Long r23, String r24, int r25, int r26) {
        if ((r25 & 1) == 0) goto L5;
        Integer r2 = null;
    L7:
        if ((r25 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r25 & 4) == 0) goto L13;
        int r6 = 0;
    L15:
        if ((r25 & 128) == 0) goto L17;
        int r7 = 1;
    L19:
        if ((r25 & 2048) == 0) goto L21;
        CopyOnWriteArrayList r9 = new CopyOnWriteArrayList();
    L23:
        if ((r25 & 4096) == 0) goto L25;
        int r10 = 0;
    L27:
        if ((r25 & 8192) == 0) goto L29;
        Integer r11 = null;
    L31:
        if ((262144 & r25) == 0) goto L33;
        String r12 = "";
    L35:
        if ((r25 & 524288) == 0) goto L37;
        Long r1 = null;
    L39:
        if ((r26 & 2) == 0) goto L41;
        String r14 = null;
    L42:
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r12, "imageUploadId");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = r7;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = r9;
        this.m = r10;
        this.n = r11;
        this.o = null;
        this.p = false;
        this.q = null;
        this.r = 0;
        this.s = r12;
        this.t = r1;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = false;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = false;
        this.H = r14;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(DoraImageEvent.TAKE_PHOTO_CMD_SEND, null), TuplesKt.to(DoraImageEvent.IMAGE_TAKE_START, null), TuplesKt.to(DoraImageEvent.IMAGE_TRANS_START, null), TuplesKt.to(DoraImageEvent.IMAGE_TRANS_FINISH, null), TuplesKt.to(DoraImageEvent.IMAGE_UPLOAD_START, null), TuplesKt.to(DoraImageEvent.IMAGE_UPLOAD_FINISH, null)});
        this.N = DoraImageEvent.UNKNOWN;
        return;
    L41:
        r14 = r24;
        goto L42
    L37:
        r1 = r23;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = r22;
        goto L31
    L25:
        r10 = r21;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
