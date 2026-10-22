package zp9;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.community.impl.adapter.LoadingItemDecoration;
import com.larus.community.impl.detail.StaggeredGridItemDecoration;
import com.larus.platform.api.creation.TabItemInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final String A;
    public final String B;
    public final String C;
    public final String D;
    public final boolean a;
    public final boolean b;
    public final String c;
    public final boolean d;
    public final g e;
    public final Integer f;
    public final Integer g;
    public final Integer h;
    public final boolean i;
    public final TabItemInfo j;
    public final Integer k;
    public final boolean l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final boolean p;
    public final String q;
    public final boolean r;
    public final RecyclerView.ItemDecoration s;
    public final RecyclerView.ItemDecoration t;
    public final boolean u;
    public final boolean v;
    public final Integer w;
    public final Boolean x;
    public final Integer y;
    public final Boolean z;

    public f(boolean r33, boolean r34, String r35, boolean r36, g r37, Integer r38, Integer r39, Integer r40, boolean r41, TabItemInfo r42, Integer r43, boolean r44, Integer r45, Integer r46, Integer r47, boolean r48, String r49, boolean r50, StaggeredGridItemDecoration r51, LoadingItemDecoration r52, boolean r53, boolean r54, Integer r55, Boolean r56, Integer r57, Boolean r58, String r59, String r60, String r61, String r62, int r63) {
        if ((r63 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r63 & 2) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r63 & 8) == 0) goto L13;
        boolean r7 = false;
    L15:
        if ((r63 & 32) == 0) goto L17;
        Integer r8 = null;
    L19:
        if ((r63 & 64) == 0) goto L21;
        Integer r10 = null;
    L23:
        if ((r63 & 128) == 0) goto L25;
        Integer r11 = null;
    L27:
        if ((r63 & 256) == 0) goto L29;
        boolean r12 = false;
    L31:
        if ((r63 & 512) == 0) goto L33;
        TabItemInfo r13 = null;
    L35:
        if ((r63 & 1024) == 0) goto L37;
        Integer r14 = null;
    L39:
        if ((r63 & 2048) == 0) goto L41;
        boolean r15 = false;
    L43:
        if ((r63 & 4096) == 0) goto L45;
        Integer r5 = null;
    L47:
        if ((r63 & 8192) == 0) goto L49;
        Integer r9 = null;
    L50:
        Integer r310 = r9;
        if ((r63 & 16384) == 0) goto L53;
        Integer r16 = null;
    L55:
        if ((r63 & 32768) == 0) goto L57;
        boolean r19 = true;
    L59:
        if ((r63 & 65536) == 0) goto L61;
        String r20 = null;
    L63:
        if ((r63 & 131072) == 0) goto L65;
        boolean r21 = true;
    L67:
        if ((r63 & 262144) == 0) goto L69;
        StaggeredGridItemDecoration r22 = null;
    L71:
        if ((r63 & 524288) == 0) goto L73;
        LoadingItemDecoration r23 = null;
    L75:
        if ((r63 & 1048576) == 0) goto L77;
        boolean r24 = false;
    L79:
        if ((r63 & 2097152) == 0) goto L81;
        boolean r25 = false;
    L83:
        if ((r63 & 4194304) == 0) goto L85;
        Integer r26 = null;
    L87:
        if ((r63 & 8388608) == 0) goto L89;
        Boolean r27 = Boolean.FALSE;
    L91:
        if ((r63 & 16777216) == 0) goto L93;
        Integer r28 = null;
    L95:
        if ((r63 & 33554432) == 0) goto L97;
        Boolean r29 = Boolean.FALSE;
    L99:
        if ((r63 & 67108864) == 0) goto L101;
        String r17 = "ugc_video";
    L103:
        if ((r63 & 134217728) == 0) goto L105;
        String r18 = "message_card";
    L107:
        if ((r63 & 268435456) == 0) goto L109;
        String r110 = "ugc_video";
    L111:
        if ((r63 & 536870912) == 0) goto L113;
        String r3 = "immersive_preview";
    L114:
        Intrinsics.checkNotNullParameter(r35, "fpsTrackerTag");
        Intrinsics.checkNotNullParameter(r37, "trackParams");
        Intrinsics.checkNotNullParameter(r17, "videoEngineTag");
        Intrinsics.checkNotNullParameter(r18, "videoEngineSubTag");
        Intrinsics.checkNotNullParameter(r110, "detailVideoEngineTag");
        Intrinsics.checkNotNullParameter(r3, "detailVideoEngineSubTag");
        this.a = r4;
        this.b = r6;
        this.c = r35;
        this.d = r7;
        this.e = r37;
        this.f = r8;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r5;
        this.n = r310;
        this.o = r16;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r23;
        this.u = r24;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        this.y = r28;
        this.z = r29;
        this.A = r17;
        this.B = r18;
        this.C = r110;
        this.D = r3;
        return;
    L113:
        r3 = r62;
        goto L114
    L109:
        r110 = r61;
        goto L111
    L105:
        r18 = r60;
        goto L107
    L101:
        r17 = r59;
        goto L103
    L97:
        r29 = r58;
        goto L99
    L93:
        r28 = r57;
        goto L95
    L89:
        r27 = r56;
        goto L91
    L85:
        r26 = r55;
        goto L87
    L81:
        r25 = r54;
        goto L83
    L77:
        r24 = r53;
        goto L79
    L73:
        r23 = r52;
        goto L75
    L69:
        r22 = r51;
        goto L71
    L65:
        r21 = r50;
        goto L67
    L61:
        r20 = r49;
        goto L63
    L57:
        r19 = r48;
        goto L59
    L53:
        r16 = r47;
        goto L55
    L49:
        r9 = r46;
        goto L50
    L45:
        r5 = r45;
        goto L47
    L41:
        r15 = r44;
        goto L43
    L37:
        r14 = r43;
        goto L39
    L33:
        r13 = r42;
        goto L35
    L29:
        r12 = r41;
        goto L31
    L25:
        r11 = r40;
        goto L27
    L21:
        r10 = r39;
        goto L23
    L17:
        r8 = r38;
        goto L19
    L13:
        r7 = r36;
        goto L15
    L9:
        r6 = r34;
        goto L11
    L5:
        r4 = r33;
        goto L7
    }
}
