package bu;

import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends m implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f995c;
    public int d;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        JvmProtoBuf$JvmMethodSignature r5 = f();
        if (r5.isInitialized() == false) goto L6;
        return r5;
    L6:
        throw new UninitializedMessageException(r5);
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ z buildPartial() {
        return f();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ m c(GeneratedMessageLite r5) {
        g((JvmProtoBuf$JvmMethodSignature) r5);
        return this;
    }

    public final Object clone() {
        g r5 = new g();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final JvmProtoBuf$JvmMethodSignature f() {
        JvmProtoBuf$JvmMethodSignature r5 = new JvmProtoBuf$JvmMethodSignature(this, null);
        int r10 = this.f994b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        JvmProtoBuf$JvmMethodSignature.access$2002(r5, this.f995c);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        JvmProtoBuf$JvmMethodSignature.access$2102(r5, this.d);
        JvmProtoBuf$JvmMethodSignature.access$2202(r5, r11);
        return r5;
    }

    public final void g(JvmProtoBuf$JvmMethodSignature r5) {
        if (r5 != JvmProtoBuf$JvmMethodSignature.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasName() == false) goto L9;
        int r10 = r5.getName();
        this.f994b |= 1;
        this.f995c = r10;
    L9:
        if (r5.hasDesc() == false) goto L11;
        int r11 = r5.getDesc();
        this.f994b |= 2;
        this.d = r11;
    L11:
        this.f19190a = this.f19190a.c(JvmProtoBuf$JvmMethodSignature.access$2300(r5));
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        JvmProtoBuf$JvmMethodSignature r11 = null;
        g((JvmProtoBuf$JvmMethodSignature) JvmProtoBuf$JvmMethodSignature.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        JvmProtoBuf$JvmMethodSignature r12 = (JvmProtoBuf$JvmMethodSignature) e.getUnfinishedMessage();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L11
    L11:
        th = th;
        r11 = r12;
    L13:
        if (r11 == null) goto L15;
        g(r11);
    L15:
        throw th;
    L6:
        th = th;
        goto L13
    }
}
