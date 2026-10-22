package au;

import kotlinx.metadata.internal.metadata.ProtoBuf$Type;
import kotlinx.metadata.internal.metadata.ProtoBuf$ValueParameter;
import kotlinx.metadata.internal.metadata.a0;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends kotlinx.metadata.internal.protobuf.n implements u {
    public int d;
    public int e;
    public int f;
    public ProtoBuf$Type g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ProtoBuf$Type f778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f779j;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$ValueParameter.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$ValueParameter r5 = h();
        if (r5.isInitialized() == false) goto L6;
        return r5;
    L6:
        throw new UninitializedMessageException(r5);
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ z buildPartial() {
        return h();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m c(GeneratedMessageLite r5) {
        i((ProtoBuf$ValueParameter) r5);
        return this;
    }

    public final Object clone() {
        t r5 = new t();
        r5.g = ProtoBuf$Type.getDefaultInstance();
        r5.f778i = ProtoBuf$Type.getDefaultInstance();
        r5.i(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    public final ProtoBuf$ValueParameter h() {
        ProtoBuf$ValueParameter r5 = new ProtoBuf$ValueParameter(this, null);
        int r10 = this.d;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$ValueParameter.access$18102(r5, this.e);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$ValueParameter.access$18202(r5, this.f);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$ValueParameter.access$18302(r5, this.g);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 8;
    L15:
        ProtoBuf$ValueParameter.access$18402(r5, this.f777h);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 16;
    L18:
        ProtoBuf$ValueParameter.access$18502(r5, this.f778i);
        if ((r10 & 32) != 32) goto L21;
        r11 = r11 | 32;
    L21:
        ProtoBuf$ValueParameter.access$18602(r5, this.f779j);
        ProtoBuf$ValueParameter.access$18702(r5, r11);
        return r5;
    }

    public final void i(ProtoBuf$ValueParameter r5) {
        if (r5 != ProtoBuf$ValueParameter.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasFlags() == false) goto L9;
        int r10 = r5.getFlags();
        this.d |= 1;
        this.e = r10;
    L9:
        if (r5.hasName() == false) goto L12;
        int r11 = r5.getName();
        this.d |= 2;
        this.f = r11;
    L12:
        if (r5.hasType() == false) goto L21;
        ProtoBuf$Type r12 = r5.getType();
        if ((this.d & 4) == 4) goto L16;
    L18:
        this.g = r12;
    L19:
        this.d |= 4;
        goto L21
    L16:
        if (this.g == ProtoBuf$Type.getDefaultInstance()) goto L18;
        a0 r13 = ProtoBuf$Type.newBuilder(this.g);
        r13.i(r12);
        this.g = r13.h();
    L21:
        if (r5.hasTypeId() == false) goto L24;
        int r14 = r5.getTypeId();
        this.d |= 8;
        this.f777h = r14;
    L24:
        if (r5.hasVarargElementType() == false) goto L33;
        ProtoBuf$Type r15 = r5.getVarargElementType();
        if ((this.d & 16) == 16) goto L28;
    L30:
        this.f778i = r15;
    L31:
        this.d |= 16;
        goto L33
    L28:
        if (this.f778i == ProtoBuf$Type.getDefaultInstance()) goto L30;
        a0 r16 = ProtoBuf$Type.newBuilder(this.f778i);
        r16.i(r15);
        this.f778i = r16.h();
    L33:
        if (r5.hasVarargElementTypeId() == false) goto L35;
        int r17 = r5.getVarargElementTypeId();
        this.d |= 32;
        this.f779j = r17;
    L35:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$ValueParameter.access$18800(r5));
    }

    public final void j(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$ValueParameter r11 = null;
        i((ProtoBuf$ValueParameter) ProtoBuf$ValueParameter.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$ValueParameter r12 = (ProtoBuf$ValueParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L11
    L11:
        th = th;
        r11 = r12;
    L13:
        if (r11 == null) goto L15;
        i(r11);
    L15:
        throw th;
    L6:
        th = th;
        goto L13
    }
}
