package d11;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final int a;
    public final long b;
    public final long c;
    public final String d;
    public final String e;
    public final int f;
    public final String g;
    public final String h;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L22;
        c r7 = (c) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.d;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = r5.hashCode();
    L6:
        int r8 = (r4 + r7) * 31;
        String r9 = this.e;
        if (r9 == null) goto L9;
        int r10 = r9.hashCode();
    L10:
        int r12 = (((r8 + r10) * 31) + this.f) * 31;
        String r13 = this.g;
        if (r13 == null) goto L13;
        int r14 = r13.hashCode();
    L14:
        int r15 = (r12 + r14) * 31;
        String r16 = this.h;
        if (r16 == null) goto L18;
        r6 = r16.hashCode();
    L18:
        return r15 + r6;
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
        return "CancelParams(scene=" + this.a + ", channelId=" + this.b + ", toRoomId=" + this.c + ", toUserId=" + this.d + ", secToUserId=" + this.e + ", cancelType=" + this.f + ", reqSrc=" + this.g + ", inviteeUserIds=" + this.h + ")";
    }

    public final i a() {
        Class r0 = i.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r3 = r1.putIfAbsent(r0, r2);
        if (r3 == null) goto L12;
        r2 = r3;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L24;
        i r5 = (i) r4;
        r5.setChannelId(this.b);
        r5.f(this.c);
        String r6 = this.d;
        String r7 = "";
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r5.setToOpenId(r6);
        String r8 = this.e;
        if (r8 == null) goto L21;
        r7 = r8;
    L21:
        r5.g(r7);
        r5.setScene(this.a);
        r5.n0(this.f);
        r5.J2(this.g);
        return r5;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.params.ServerCancelParams");
    }

    public c(int r13, long r14, long r16, String r18, String r19, int r20, String r22) {
        Intrinsics.checkNotNullParameter(r22, "reqSrc");
        this(r13, r14, r16, r18, r19, r20, r22, null);
    }

    public c(int r2, long r3, long r5, String r7, String r8, int r9, String r10, String r12) {
        Intrinsics.checkNotNullParameter(r10, "reqSrc");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r12;
    }
}
