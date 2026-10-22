package d11;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final int a;
    public final long b;
    public final int c;
    public final long d;
    public final String e;
    public final String f;
    public final String g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L20;
        f r7 = (f) r6;
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
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c) * 31;
        long r3 = this.d;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.e;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = r5.hashCode();
    L6:
        int r8 = (r4 + r7) * 31;
        String r9 = this.f;
        if (r9 == null) goto L9;
        int r10 = r9.hashCode();
    L10:
        int r12 = (r8 + r10) * 31;
        String r13 = this.g;
        if (r13 == null) goto L14;
        r6 = r13.hashCode();
    L14:
        return r12 + r6;
    L9:
        r10 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public final String toString() {
        return "PermitParams(scene=" + this.a + ", channelId=" + this.b + ", permitStatus=" + this.c + ", roomId=" + this.d + ", applyUserId=" + this.e + ", applyAnchorSecId=" + this.f + ", applyFromInteractId=" + this.g + ")";
    }

    public final k a() {
        Class r0 = k.class.getAnnotation(JsonAdapter.class).value();
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
        k r5 = (k) r4;
        r5.setChannelId(this.b);
        r5.l7(this.c);
        r5.setRoomId(this.d);
        String r6 = this.e;
        String r7 = "";
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r5.k4(r6);
        String r8 = this.f;
        if (r8 == null) goto L21;
        r7 = r8;
    L21:
        r5.D6(r7);
        r5.setScene(this.a);
        return r5;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.params.ServerPermitParams");
    }

    public f(int r1, long r2, int r4, long r5, String r7, String r8, String r9) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
