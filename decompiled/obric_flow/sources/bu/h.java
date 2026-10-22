package bu;

import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$JvmFieldSignature;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$JvmPropertySignature;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends m implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JvmProtoBuf$JvmFieldSignature f997c;
    public JvmProtoBuf$JvmMethodSignature d;
    public JvmProtoBuf$JvmMethodSignature e;
    public JvmProtoBuf$JvmMethodSignature f;
    public JvmProtoBuf$JvmMethodSignature g;

    public static h g() {
        h r5 = new h();
        r5.f997c = JvmProtoBuf$JvmFieldSignature.getDefaultInstance();
        r5.d = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        r5.e = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        r5.f = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        r5.g = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        i(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        JvmProtoBuf$JvmPropertySignature r5 = f();
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
        h((JvmProtoBuf$JvmPropertySignature) r5);
        return this;
    }

    public final Object clone() {
        h r5 = g();
        r5.h(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        i(r5, r10);
        return this;
    }

    public final JvmProtoBuf$JvmPropertySignature f() {
        JvmProtoBuf$JvmPropertySignature r5 = new JvmProtoBuf$JvmPropertySignature(this, null);
        int r10 = this.f996b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        JvmProtoBuf$JvmPropertySignature.access$3402(r5, this.f997c);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        JvmProtoBuf$JvmPropertySignature.access$3502(r5, this.d);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        JvmProtoBuf$JvmPropertySignature.access$3602(r5, this.e);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 8;
    L15:
        JvmProtoBuf$JvmPropertySignature.access$3702(r5, this.f);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 16;
    L18:
        JvmProtoBuf$JvmPropertySignature.access$3802(r5, this.g);
        JvmProtoBuf$JvmPropertySignature.access$3902(r5, r11);
        return r5;
    }

    public final void h(JvmProtoBuf$JvmPropertySignature r5) {
        if (r5 != JvmProtoBuf$JvmPropertySignature.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasField() == false) goto L15;
        JvmProtoBuf$JvmFieldSignature r10 = r5.getField();
        if ((this.f996b & 1) == 1) goto L10;
    L12:
        this.f997c = r10;
    L13:
        this.f996b |= 1;
        goto L15
    L10:
        if (this.f997c == JvmProtoBuf$JvmFieldSignature.getDefaultInstance()) goto L12;
        f r11 = JvmProtoBuf$JvmFieldSignature.newBuilder(this.f997c);
        r11.g(r10);
        this.f997c = r11.f();
    L15:
        if (r5.hasSyntheticMethod() == false) goto L24;
        JvmProtoBuf$JvmMethodSignature r12 = r5.getSyntheticMethod();
        if ((this.f996b & 2) == 2) goto L19;
    L21:
        this.d = r12;
    L22:
        this.f996b |= 2;
        goto L24
    L19:
        if (this.d == JvmProtoBuf$JvmMethodSignature.getDefaultInstance()) goto L21;
        g r13 = JvmProtoBuf$JvmMethodSignature.newBuilder(this.d);
        r13.g(r12);
        this.d = r13.f();
    L24:
        if (r5.hasGetter() == false) goto L33;
        JvmProtoBuf$JvmMethodSignature r14 = r5.getGetter();
        if ((this.f996b & 4) == 4) goto L28;
    L30:
        this.e = r14;
    L31:
        this.f996b |= 4;
        goto L33
    L28:
        if (this.e == JvmProtoBuf$JvmMethodSignature.getDefaultInstance()) goto L30;
        g r15 = JvmProtoBuf$JvmMethodSignature.newBuilder(this.e);
        r15.g(r14);
        this.e = r15.f();
    L33:
        if (r5.hasSetter() == false) goto L42;
        JvmProtoBuf$JvmMethodSignature r16 = r5.getSetter();
        if ((this.f996b & 8) == 8) goto L37;
    L39:
        this.f = r16;
    L40:
        this.f996b |= 8;
        goto L42
    L37:
        if (this.f == JvmProtoBuf$JvmMethodSignature.getDefaultInstance()) goto L39;
        g r17 = JvmProtoBuf$JvmMethodSignature.newBuilder(this.f);
        r17.g(r16);
        this.f = r17.f();
    L42:
        if (r5.hasDelegateMethod() == false) goto L50;
        JvmProtoBuf$JvmMethodSignature r18 = r5.getDelegateMethod();
        if ((this.f996b & 16) == 16) goto L46;
    L48:
        this.g = r18;
    L49:
        this.f996b |= 16;
        goto L50
    L46:
        if (this.g == JvmProtoBuf$JvmMethodSignature.getDefaultInstance()) goto L48;
        g r19 = JvmProtoBuf$JvmMethodSignature.newBuilder(this.g);
        r19.g(r18);
        this.g = r19.f();
    L50:
        this.f19190a = this.f19190a.c(JvmProtoBuf$JvmPropertySignature.access$4000(r5));
    }

    public final void i(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        JvmProtoBuf$JvmPropertySignature r11 = null;
        h((JvmProtoBuf$JvmPropertySignature) JvmProtoBuf$JvmPropertySignature.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        JvmProtoBuf$JvmPropertySignature r12 = (JvmProtoBuf$JvmPropertySignature) e.getUnfinishedMessage();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L11
    L11:
        th = th;
        r11 = r12;
    L13:
        if (r11 == null) goto L15;
        h(r11);
    L15:
        throw th;
    L6:
        th = th;
        goto L13
    }
}
