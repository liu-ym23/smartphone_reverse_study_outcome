package d11;

import com.bytedance.android.live.saas.middleware.alog.config.ALogDefaultConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final String A;
    public final HashMap<String, String> B;
    public final m C;
    public final int a;
    public final long b;
    public final long c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;
    public IRoom h;
    public final int i;
    public final String j;
    public final int k;
    public final String l;
    public final long m;
    public final int n;
    public final Integer o;
    public final int p;
    public final List<String> q;
    public final String r;
    public final String s;
    public final String t;
    public final int u;
    public final int v;
    public final long w;
    public final String x;
    public final String y;
    public final String z;

    public d() {
        throw null;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L64;
        d r7 = (d) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (this.m == r7.m) goto L32;
        return false;
    L32:
        if (this.n == r7.n) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r7.o) == true) goto L36;
        return false;
    L36:
        if (this.p == r7.p) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r7.q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.r, r7.r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.s, r7.s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.t, r7.t) == true) goto L46;
        return false;
    L46:
        if (this.u == r7.u) goto L48;
        return false;
    L48:
        if (this.v == r7.v) goto L50;
        return false;
    L50:
        if (this.w == r7.w) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.x, r7.x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.y, r7.y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.z, r7.z) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.A, r7.A) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.B, r7.B) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r7.C) == true) goto L97;
        return false;
    L97:
        return true;
    L64:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31) + this.e) * 31;
        String r5 = this.f;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = r5.hashCode();
    L6:
        int r8 = (r4 + r7) * 31;
        String r9 = this.g;
        if (r9 == null) goto L9;
        int r10 = r9.hashCode();
    L10:
        int r12 = (r8 + r10) * 31;
        IRoom r13 = this.h;
        if (r13 == null) goto L13;
        int r14 = r13.hashCode();
    L14:
        int r15 = (((r12 + r14) * 31) + this.i) * 31;
        String r16 = this.j;
        if (r16 == null) goto L17;
        int r17 = r16.hashCode();
    L18:
        int r18 = (((r15 + r17) * 31) + this.k) * 31;
        String r19 = this.l;
        if (r19 == null) goto L21;
        int r20 = r19.hashCode();
    L22:
        long r22 = this.m;
        int r23 = (((((r18 + r20) * 31) + ((int) (r22 ^ (r22 >>> 32)))) * 31) + this.n) * 31;
        Integer r24 = this.o;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (((r23 + r25) * 31) + this.p) * 31;
        List<String> r27 = this.q;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        String r30 = this.r;
        if (r30 == null) goto L33;
        int r32 = r30.hashCode();
    L34:
        int r33 = (r29 + r32) * 31;
        String r34 = this.s;
        if (r34 == null) goto L37;
        int r35 = r34.hashCode();
    L38:
        int r36 = (r33 + r35) * 31;
        String r37 = this.t;
        if (r37 == null) goto L41;
        int r38 = r37.hashCode();
    L42:
        int r39 = (((((r36 + r38) * 31) + this.u) * 31) + this.v) * 31;
        long r40 = this.w;
        int r42 = (r39 + ((int) (r40 ^ (r40 >>> 32)))) * 31;
        String r43 = this.x;
        if (r43 == null) goto L45;
        int r44 = r43.hashCode();
    L46:
        int r45 = (r42 + r44) * 31;
        String r46 = this.y;
        if (r46 == null) goto L49;
        int r47 = r46.hashCode();
    L50:
        int r48 = (r45 + r47) * 31;
        String r49 = this.z;
        if (r49 == null) goto L53;
        int r50 = r49.hashCode();
    L54:
        int r52 = (r48 + r50) * 31;
        String r53 = this.A;
        if (r53 == null) goto L57;
        int r54 = r53.hashCode();
    L58:
        int r55 = (r52 + r54) * 31;
        HashMap<String, String> r56 = this.B;
        if (r56 == null) goto L61;
        int r57 = r56.hashCode();
    L62:
        int r58 = (r55 + r57) * 31;
        m r59 = this.C;
        if (r59 == null) goto L66;
        r6 = r59.hashCode();
    L66:
        return r58 + r6;
    L61:
        r57 = 0;
        goto L62
    L57:
        r54 = 0;
        goto L58
    L53:
        r50 = 0;
        goto L54
    L49:
        r47 = 0;
        goto L50
    L45:
        r44 = 0;
        goto L46
    L41:
        r38 = 0;
        goto L42
    L37:
        r35 = 0;
        goto L38
    L33:
        r32 = 0;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r20 = 0;
        goto L22
    L17:
        r17 = 0;
        goto L18
    L13:
        r14 = 0;
        goto L14
    L9:
        r10 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public final String toString() {
        return "InviteParams(scene=" + this.a + ", roomId=" + this.b + ", toRoomId=" + this.c + ", inviteType=" + this.d + ", matchType=" + this.e + ", toUserId=" + this.f + ", secToUserId=" + this.g + ", targetRoom=" + this.h + ", bizType=" + this.i + ", theme=" + this.j + ", duration=" + this.k + ", activityName=" + this.l + ", matchSubType=" + this.m + ", inviteSource=" + this.n + ", multiPkMode=" + this.o + ", inviteeScene=" + this.p + ", inviteeUserIds=" + this.q + ", battleConfigSettingStr=" + this.r + ", panelType=" + this.s + ", battleAttachedInfo=" + this.t + ", inviterRoomStatus=" + this.u + ", inviteIndex=" + this.v + ", stayDuration=" + this.w + ", requestID=" + this.x + ", clientAttachedInfo=" + this.y + ", openGameAppId=" + this.z + ", serverAttachedInfo=" + this.A + ", logMap=" + this.B + ", streamInfoParams=" + this.C + ")";
    }

    public final j a(long r13) {
        Class r0 = j.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        int r3 = 0;
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r4 = r1.putIfAbsent(r0, r2);
        if (r4 == null) goto L12;
        r2 = r4;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r5 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r5 == null) goto L61;
        j r6 = (j) r5;
        r6.setRoomId(this.b);
        r6.f(this.c);
        String r7 = this.f;
        long r8 = 0;
        if (r7 == null) goto L19;
        Long r9 = StringsKt.toLongOrNull(r7);
        if (r9 == null) goto L19;
        long r10 = r9.longValue();
    L20:
        r6.setToUserId(r10);
        r6.s8(String.valueOf(this.e));
        r6.setDuration(this.k);
        String r12 = this.j;
        String r14 = "";
        if (r12 != null) goto L23;
        r12 = "";
    L23:
        r6.setTheme(r12);
        String r15 = this.g;
        if (r15 != null) goto L26;
        r15 = "";
    L26:
        r6.g(r15);
        r6.A7(this.d);
        r6.setScene(this.a);
        r6.e1(this.l);
        r6.d9((int) this.m);
        r6.k3(this.n);
        Integer r16 = this.o;
        if (r16 == null) goto L29;
        r3 = r16.intValue();
    L29:
        r6.J(r3);
        r6.m7(this.p);
        String r17 = this.r;
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        r6.d8(r17);
        r6.p9(this.u);
        String r18 = this.t;
        if (r18 != null) goto L35;
        r18 = "";
    L35:
        r6.setBattleAttachedInfo(r18);
        r6.h(this.y);
        r6.n(this.z);
        r6.setChannelId(r13);
        r6.setBizType(this.i);
        m r19 = this.C;
        if (r19 == null) goto L49;
        Integer r110 = r19.a;
        if (r110 == null) goto L40;
        long r20 = r110.intValue();
    L41:
        r6.F(r20);
        Integer r111 = r19.b;
        if (r111 == null) goto L44;
        long r22 = r111.intValue();
    L45:
        r6.E(r22);
        Integer r112 = r19.c;
        if (r112 == null) goto L48;
        r8 = r112.intValue();
    L48:
        r6.B(r8);
        goto L49
    L44:
        r22 = 0;
        goto L45
    L40:
        r20 = 0;
    L49:
        String r113 = this.f;
        if (r113 != null) goto L52;
        r113 = "";
    L52:
        r6.setToOpenId(r113);
        List<String> r114 = this.q;
        if (r114 == null) goto L58;
        String r115 = CollectionsKt.joinToString$default(r114, ",", null, null, 0, null, null, 62, null);
        if (r115 == null) goto L58;
        r14 = r115;
    L58:
        r6.G4(r14);
        return r6;
    L19:
        r10 = 0;
        goto L20
    L61:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.params.ServerInviteParams");
    }

    public d(int r26, long r27, long r29, int r32, int r33, String r34, String r35, IRoom r36, int r37, String r38, int r39, String r310, long r40, int r42, Integer r43, int r44, List r45, String r46, String r47, String r48, int r49, int r50, long r52, String r53, String r54, String r55, HashMap r56, m r57, int r58) {
        if ((r58 & 512) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r58 & 1024) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r58 & 2048) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r58 & 4096) == 0) goto L17;
        long r10 = 0;
    L19:
        if ((r58 & 8192) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r58 & 16384) == 0) goto L25;
        Integer r12 = null;
    L27:
        if ((32768 & r58) == 0) goto L29;
        int r14 = 0;
    L31:
        if ((65536 & r58) == 0) goto L33;
        List r15 = null;
    L35:
        if ((r58 & 131072) == 0) goto L37;
        String r5 = "";
    L39:
        if ((r58 & 262144) == 0) goto L41;
        String r8 = null;
    L43:
        if ((524288 & r58) == 0) goto L45;
        String r9 = "";
    L47:
        if ((r58 & 1048576) == 0) goto L49;
        int r13 = 0;
    L51:
        if ((r58 & ALogDefaultConfig.ALOG_ZONE_SIZE) == 0) goto L53;
        int r3 = 0;
    L55:
        if ((r58 & 4194304) == 0) goto L57;
        long r18 = 0;
    L59:
        if ((r58 & 8388608) == 0) goto L61;
        String r16 = r3;
    L63:
        if ((r58 & 16777216) == 0) goto L65;
        String r17 = r3;
    L67:
        if ((r58 & 33554432) == 0) goto L69;
        String r19 = r3;
    L71:
        if ((r58 & 67108864) == 0) goto L73;
        String r20 = "";
    L75:
        if ((r58 & 134217728) == 0) goto L77;
        HashMap r23 = null;
    L79:
        if ((r58 & 268435456) == 0) goto L81;
        m r22 = null;
    L82:
        Intrinsics.checkNotNullParameter(r6, "activityName");
        Intrinsics.checkNotNullParameter(r16, "requestID");
        Intrinsics.checkNotNullParameter(r17, "clientAttachedInfo");
        Intrinsics.checkNotNullParameter(r19, "openGameAppId");
        Intrinsics.checkNotNullParameter(r20, "serverAttachedInfo");
        this.a = r26;
        this.b = r27;
        this.c = r29;
        this.d = r32;
        this.e = r33;
        this.f = r34;
        this.g = r35;
        this.h = r36;
        this.i = r37;
        this.j = r2;
        this.k = r4;
        this.l = r6;
        this.m = r10;
        this.n = r7;
        this.o = r12;
        this.p = r14;
        this.q = r15;
        this.r = r5;
        this.s = r8;
        this.t = r9;
        this.u = r13;
        this.v = r3;
        this.w = r18;
        this.x = r16;
        this.y = r17;
        this.z = r19;
        this.A = r20;
        this.B = r23;
        this.C = r22;
        return;
    L81:
        r22 = r57;
        goto L82
    L77:
        r23 = r56;
        goto L79
    L73:
        r20 = null;
        goto L75
    L69:
        r19 = r55;
        goto L71
    L65:
        r17 = r54;
        goto L67
    L61:
        r16 = r53;
        goto L63
    L57:
        r18 = r52;
        goto L59
    L53:
        r3 = r50;
        goto L55
    L49:
        r13 = r49;
        goto L51
    L45:
        r9 = r48;
        goto L47
    L41:
        r8 = r47;
        goto L43
    L37:
        r5 = r46;
        goto L39
    L33:
        r15 = r45;
        goto L35
    L29:
        r14 = r44;
        goto L31
    L25:
        r12 = r43;
        goto L27
    L21:
        r7 = r42;
        goto L23
    L17:
        r10 = r40;
        goto L19
    L13:
        r6 = r310;
        goto L15
    L9:
        r4 = r39;
        goto L11
    L5:
        r2 = r38;
        goto L7
    }
}
