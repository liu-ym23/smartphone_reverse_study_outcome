package d11;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final int e;
    public final String f;
    public final String g;
    public final Boolean h;
    public final Integer i;
    public final a j;
    public final String k;
    public final String l;
    public final String m;
    public final m n;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof g) == false) goto L34;
        g r7 = (g) r6;
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
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r7.n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.d;
        int r4 = (((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.e) * 31;
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
        Boolean r13 = this.h;
        if (r13 == null) goto L13;
        int r14 = r13.hashCode();
    L14:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.i;
        if (r16 == null) goto L17;
        int r17 = r16.hashCode();
    L18:
        int r18 = (r15 + r17) * 31;
        a r19 = this.j;
        if (r19 == null) goto L21;
        int r20 = r19.hashCode();
    L22:
        int r22 = (r18 + r20) * 31;
        String r23 = this.k;
        if (r23 == null) goto L25;
        int r24 = r23.hashCode();
    L26:
        int r25 = (r22 + r24) * 31;
        String r26 = this.l;
        if (r26 == null) goto L29;
        int r27 = r26.hashCode();
    L30:
        int r28 = (r25 + r27) * 31;
        String r29 = this.m;
        if (r29 == null) goto L33;
        int r30 = r29.hashCode();
    L34:
        int r32 = (r28 + r30) * 31;
        m r33 = this.n;
        if (r33 == null) goto L38;
        r6 = r33.hashCode();
    L38:
        return r32 + r6;
    L33:
        r30 = 0;
        goto L34
    L29:
        r27 = 0;
        goto L30
    L25:
        r24 = 0;
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
        return "ReplyParams(scene=" + this.a + ", bizType=" + this.b + ", channelId=" + this.c + ", roomId=" + this.d + ", replyStats=" + this.e + ", inviteUserId=" + this.f + ", secInviteUserId=" + this.g + ", auto=" + this.h + ", multiPkMode=" + this.i + ", anchorParams=" + this.j + ", clientAttachInfoStr=" + this.k + ", gameAppId=" + this.l + ", battleAttachedInfoStr=" + this.m + ", streamInfoParams=" + this.n + ")";
    }

    public final l a() {
        Class r0 = l.class.getAnnotation(JsonAdapter.class).value();
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
        if (r5 == null) goto L47;
        l r6 = (l) r5;
        r6.setChannelId(this.c);
        r6.F8(this.e);
        r6.setRoomId(this.d);
        r6.setBizType(this.b);
        String r7 = this.f;
        String r8 = "";
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        r6.R7(r7);
        String r9 = this.g;
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        r6.k7(r9);
        r6.setScene(this.a);
        Integer r10 = this.i;
        if (r10 == null) goto L23;
        r3 = r10.intValue();
    L23:
        r6.J(r3);
        r6.p4(this.j.i);
        r6.setMatchType(this.j.a);
        String r12 = this.k;
        if (r12 == null) goto L27;
        r8 = r12;
    L27:
        r6.h(r8);
        r6.n(this.l);
        m r13 = this.n;
        long r14 = 0;
        if (r13 == null) goto L32;
        Integer r15 = r13.a;
        if (r15 == null) goto L32;
        long r16 = r15.intValue();
    L33:
        r6.F(r16);
        m r17 = this.n;
        if (r17 == null) goto L38;
        Integer r18 = r17.b;
        if (r18 == null) goto L38;
        long r19 = r18.intValue();
    L39:
        r6.E(r19);
        m r20 = this.n;
        if (r20 == null) goto L44;
        Integer r22 = r20.c;
        if (r22 == null) goto L44;
        r14 = r22.intValue();
    L44:
        r6.B(r14);
        return r6;
    L38:
        r19 = 0;
    L32:
        r16 = 0;
        goto L33
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.params.ServerReplyParams");
    }

    public g(int r6, int r7, long r8, long r10, int r12, String r13, String r14, Boolean r15, Integer r16, a r17, String r18, String r19, String r20, m r22) {
        Intrinsics.checkNotNullParameter(r17, "anchorParams");
        Intrinsics.checkNotNullParameter(r19, "gameAppId");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r10;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r22;
    }

    public /* synthetic */ g(int r30, int r32, long r33, long r34, int r36, String r37, String r38, Boolean r39, Integer r40, a r42, String r43, String r44, String r45, m r46, int r47) {
        if ((r47 & 128) == 0) goto L5;
        Boolean r13 = null;
    L7:
        if ((r47 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L9;
        Integer r14 = null;
    L11:
        if ((r47 & 512) == 0) goto L13;
        a r15 = new a(0, 0, 0, null, false, false, false, null, 0, null, null, null, 4095);
    L15:
        if ((r47 & 1024) == 0) goto L17;
        String r16 = null;
    L19:
        if ((r47 & 2048) == 0) goto L21;
        String r17 = "";
    L23:
        if ((r47 & 4096) == 0) goto L25;
        String r18 = null;
    L27:
        if ((r47 & 8192) == 0) goto L29;
        m r19 = null;
    L30:
        this(r30, r32, r33, r34, r36, r37, r38, r13, r14, r15, r16, r17, r18, r19);
        return;
    L29:
        r19 = r46;
        goto L30
    L25:
        r18 = r45;
        goto L27
    L21:
        r17 = r44;
        goto L23
    L17:
        r16 = r43;
        goto L19
    L13:
        r15 = r42;
        goto L15
    L9:
        r14 = r40;
        goto L11
    L5:
        r13 = r39;
        goto L7
    }
}
