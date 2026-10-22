package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 extends k {
    public final boolean A;
    public String B;
    public final boolean C;
    public final boolean D;
    public final long f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final long k;
    public final String l;
    public final int m;
    public final String n;
    public final boolean o;
    public final String p;
    public final int q;
    public int r;
    public final boolean s;
    public final boolean t;
    public final int u;
    public final e0 v;
    public final Map<String, String> w;
    public final boolean x;
    public Boolean y;
    public final JSONObject z;

    public static final class a {
    }

    static {
    }

    public f0() {
        throw null;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.k
    public final JSONObject a() {
        JSONObject r0 = super.a();
        r0.put("schema", this.h);
        r0.put("mode", this.k);
        r0.put("developer", this.p);
        r0.put("current_game_identifer", this.l);
        r0.put("current_game_version", this.g);
        r0.put("business_type", this.q);
        r0.put("game_category", this.n);
        return r0.put("hide_user_entrance", this.x);
    }

    public f0(long r29, String r31, long r32, long r34, String r36, String r37, String r38, String r39, long r41, String r42, int r43, String r44, boolean r45, String r46, int r47, int r48, boolean r49, boolean r51, int r52, Map r53, boolean r54, Boolean r55, JSONObject r56, boolean r57, String r58, boolean r59, boolean r510, int r61) {
        long r5 = 0;
        if ((r61 & 4) == 0) goto L5;
        long r7 = 0;
    L7:
        if ((r61 & 8) == 0) goto L9;
        long r9 = 0;
    L11:
        if ((r61 & 64) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r61 & 128) == 0) goto L17;
        String r12 = "";
    L19:
        if ((r61 & 256) != 0) goto L23;
        r5 = r41;
    L23:
        if ((r61 & 512) == 0) goto L25;
        String r13 = "";
    L27:
        if ((r61 & RomUtils.SZ) == 0) goto L29;
        int r14 = 0;
    L31:
        if ((r61 & 2048) == 0) goto L33;
        String r15 = null;
    L35:
        if ((r61 & 4096) == 0) goto L37;
        boolean r11 = false;
    L38:
        boolean r35 = r11;
        if ((r61 & IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == 0) goto L41;
        String r16 = "";
    L42:
        String r33 = r15;
        if ((r61 & 16384) == 0) goto L45;
        int r17 = 0;
    L47:
        if ((r61 & 32768) == 0) goto L49;
        int r18 = 1;
    L51:
        if ((r61 & 65536) == 0) goto L53;
        boolean r19 = false;
    L55:
        if ((r61 & 131072) == 0) goto L57;
        boolean r110 = false;
    L59:
        if ((r61 & 262144) == 0) goto L61;
        int r21 = 0;
    L63:
        if ((r61 & 4194304) == 0) goto L65;
        Map r22 = null;
    L67:
        if ((r61 & 16777216) == 0) goto L69;
        boolean r23 = false;
    L71:
        if ((r61 & 33554432) == 0) goto L73;
        Boolean r24 = null;
    L75:
        if ((r61 & 67108864) == 0) goto L77;
        JSONObject r25 = null;
    L79:
        if ((r61 & 134217728) == 0) goto L81;
        boolean r26 = false;
    L83:
        if ((r61 & 268435456) == 0) goto L85;
        String r27 = null;
    L87:
        if ((r61 & 536870912) == 0) goto L89;
        boolean r28 = false;
    L91:
        if ((r61 & 1073741824) == 0) goto L93;
        boolean r111 = false;
    L94:
        Intrinsics.checkNotNullParameter(r31, "appVersion");
        Intrinsics.checkNotNullParameter(r36, "appId");
        Intrinsics.checkNotNullParameter(r37, "schema");
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r12, "iconUrl");
        Intrinsics.checkNotNullParameter(r13, "gameIdentifier");
        Intrinsics.checkNotNullParameter(r16, "developer");
        super(r36, r7, r9, r9);
        this.f = r29;
        this.g = r31;
        this.h = r37;
        this.i = r4;
        this.j = r12;
        this.k = r5;
        this.l = r13;
        this.m = r14;
        this.n = r33;
        this.o = r35;
        this.p = r16;
        this.q = r17;
        this.r = r18;
        this.s = r19;
        this.t = r110;
        this.u = r21;
        this.v = null;
        this.w = r22;
        this.x = r23;
        this.y = r24;
        this.z = r25;
        this.A = r26;
        this.B = r27;
        this.C = r28;
        this.D = r111;
        return;
    L93:
        r111 = r510;
        goto L94
    L89:
        r28 = r59;
        goto L91
    L85:
        r27 = r58;
        goto L87
    L81:
        r26 = r57;
        goto L83
    L77:
        r25 = r56;
        goto L79
    L73:
        r24 = r55;
        goto L75
    L69:
        r23 = r54;
        goto L71
    L65:
        r22 = r53;
        goto L67
    L61:
        r21 = r52;
        goto L63
    L57:
        r110 = r51;
        goto L59
    L53:
        r19 = r49;
        goto L55
    L49:
        r18 = r48;
        goto L51
    L45:
        r17 = r47;
        goto L47
    L41:
        r16 = r46;
        goto L42
    L37:
        r11 = r45;
        goto L38
    L33:
        r15 = r44;
        goto L35
    L29:
        r14 = r43;
        goto L31
    L25:
        r13 = r42;
        goto L27
    L17:
        r12 = r39;
        goto L19
    L13:
        r4 = r38;
        goto L15
    L9:
        r9 = r34;
        goto L11
    L5:
        r7 = r32;
        goto L7
    }
}
