package kotlinx.metadata.internal.metadata;

import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends kotlinx.metadata.internal.protobuf.m implements z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProtoBuf$Type.Argument.Projection f19142c;
    public ProtoBuf$Type d;
    public int e;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$Type.Argument r5 = f();
        if (r5.isInitialized() == false) goto L6;
        return r5;
    L6:
        throw new UninitializedMessageException(r5);
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z buildPartial() {
        return f();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m c(GeneratedMessageLite r5) {
        g((ProtoBuf$Type.Argument) r5);
        return this;
    }

    public final Object clone() {
        x r5 = new x();
        r5.f19142c = ProtoBuf$Type.Argument.Projection.INV;
        r5.d = ProtoBuf$Type.getDefaultInstance();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$Type.Argument f() {
        ProtoBuf$Type.Argument r5 = new ProtoBuf$Type.Argument(this, null);
        int r10 = this.f19141b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$Type.Argument.access$5202(r5, this.f19142c);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$Type.Argument.access$5302(r5, this.d);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$Type.Argument.access$5402(r5, this.e);
        ProtoBuf$Type.Argument.access$5502(r5, r11);
        return r5;
    }

    public final void g(ProtoBuf$Type.Argument r5) {
        if (r5 != ProtoBuf$Type.Argument.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasProjection() == false) goto L9;
        ProtoBuf$Type.Argument.Projection r10 = r5.getProjection();
        r10.getClass();
        this.f19141b |= 1;
        this.f19142c = r10;
    L9:
        if (r5.hasType() == false) goto L18;
        ProtoBuf$Type r11 = r5.getType();
        if ((this.f19141b & 2) == 2) goto L13;
    L15:
        this.d = r11;
    L16:
        this.f19141b |= 2;
        goto L18
    L13:
        if (this.d == ProtoBuf$Type.getDefaultInstance()) goto L15;
        a0 r12 = ProtoBuf$Type.newBuilder(this.d);
        r12.i(r11);
        this.d = r12.h();
    L18:
        if (r5.hasTypeId() == false) goto L20;
        int r13 = r5.getTypeId();
        this.f19141b |= 4;
        this.e = r13;
    L20:
        this.f19190a = this.f19190a.c(ProtoBuf$Type.Argument.access$5600(r5));
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Type.Argument r11 = null;
        g((ProtoBuf$Type.Argument) ProtoBuf$Type.Argument.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Type.Argument r12 = (ProtoBuf$Type.Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
