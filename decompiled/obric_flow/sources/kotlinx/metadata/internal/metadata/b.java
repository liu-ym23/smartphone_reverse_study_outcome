package kotlinx.metadata.internal.metadata;

import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends kotlinx.metadata.internal.protobuf.m implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19100c;
    public ProtoBuf$Annotation.Argument.Value d;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$Annotation.Argument r5 = f();
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
        g((ProtoBuf$Annotation.Argument) r5);
        return this;
    }

    public final Object clone() {
        b r5 = new b();
        r5.d = ProtoBuf$Annotation.Argument.Value.getDefaultInstance();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$Annotation.Argument f() {
        ProtoBuf$Annotation.Argument r5 = new ProtoBuf$Annotation.Argument(this, null);
        int r10 = this.f19099b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$Annotation.Argument.access$3802(r5, this.f19100c);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$Annotation.Argument.access$3902(r5, this.d);
        ProtoBuf$Annotation.Argument.access$4002(r5, r11);
        return r5;
    }

    public final void g(ProtoBuf$Annotation.Argument r5) {
        if (r5 != ProtoBuf$Annotation.Argument.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasNameId() == false) goto L9;
        int r10 = r5.getNameId();
        this.f19099b |= 1;
        this.f19100c = r10;
    L9:
        if (r5.hasValue() == false) goto L17;
        ProtoBuf$Annotation.Argument.Value r11 = r5.getValue();
        if ((this.f19099b & 2) == 2) goto L13;
    L15:
        this.d = r11;
    L16:
        this.f19099b |= 2;
        goto L17
    L13:
        if (this.d == ProtoBuf$Annotation.Argument.Value.getDefaultInstance()) goto L15;
        d r12 = ProtoBuf$Annotation.Argument.Value.newBuilder(this.d);
        r12.g(r11);
        this.d = r12.f();
    L17:
        this.f19190a = this.f19190a.c(ProtoBuf$Annotation.Argument.access$4100(r5));
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Annotation.Argument r11 = null;
        g((ProtoBuf$Annotation.Argument) ProtoBuf$Annotation.Argument.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Annotation.Argument r12 = (ProtoBuf$Annotation.Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
