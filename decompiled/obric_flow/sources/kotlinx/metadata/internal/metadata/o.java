package kotlinx.metadata.internal.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends kotlinx.metadata.internal.protobuf.m implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19134c;
    public int d;
    public ProtoBuf$Expression.ConstantValue e;
    public ProtoBuf$Type f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f19135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f19136i;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$Expression r5 = f();
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
        g((ProtoBuf$Expression) r5);
        return this;
    }

    public final Object clone() {
        o r5 = new o();
        r5.e = ProtoBuf$Expression.ConstantValue.TRUE;
        r5.f = ProtoBuf$Type.getDefaultInstance();
        r5.f19135h = Collections.emptyList();
        r5.f19136i = Collections.emptyList();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$Expression f() {
        ProtoBuf$Expression r5 = new ProtoBuf$Expression(this, null);
        int r10 = this.f19133b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$Expression.access$25102(r5, this.f19134c);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$Expression.access$25202(r5, this.d);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$Expression.access$25302(r5, this.e);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 8;
    L15:
        ProtoBuf$Expression.access$25402(r5, this.f);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 16;
    L18:
        ProtoBuf$Expression.access$25502(r5, this.g);
        if ((this.f19133b & 32) != 32) goto L21;
        this.f19135h = Collections.unmodifiableList(this.f19135h);
        this.f19133b &= -33;
    L21:
        ProtoBuf$Expression.access$25602(r5, this.f19135h);
        if ((this.f19133b & 64) != 64) goto L24;
        this.f19136i = Collections.unmodifiableList(this.f19136i);
        this.f19133b &= -65;
    L24:
        ProtoBuf$Expression.access$25702(r5, this.f19136i);
        ProtoBuf$Expression.access$25802(r5, r11);
        return r5;
    }

    public final void g(ProtoBuf$Expression r5) {
        if (r5 != ProtoBuf$Expression.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasFlags() == false) goto L9;
        int r10 = r5.getFlags();
        this.f19133b |= 1;
        this.f19134c = r10;
    L9:
        if (r5.hasValueParameterReference() == false) goto L12;
        int r11 = r5.getValueParameterReference();
        this.f19133b |= 2;
        this.d = r11;
    L12:
        if (r5.hasConstantValue() == false) goto L15;
        ProtoBuf$Expression.ConstantValue r12 = r5.getConstantValue();
        r12.getClass();
        this.f19133b |= 4;
        this.e = r12;
    L15:
        if (r5.hasIsInstanceType() == false) goto L24;
        ProtoBuf$Type r13 = r5.getIsInstanceType();
        if ((this.f19133b & 8) == 8) goto L19;
    L21:
        this.f = r13;
    L22:
        this.f19133b |= 8;
        goto L24
    L19:
        if (this.f == ProtoBuf$Type.getDefaultInstance()) goto L21;
        a0 r14 = ProtoBuf$Type.newBuilder(this.f);
        r14.i(r13);
        this.f = r14.h();
    L24:
        if (r5.hasIsInstanceTypeId() == false) goto L27;
        int r15 = r5.getIsInstanceTypeId();
        this.f19133b |= 16;
        this.g = r15;
    L27:
        if (ProtoBuf$Expression.access$25600(r5).isEmpty() == true) goto L36;
        if (this.f19135h.isEmpty() == false) goto L32;
        this.f19135h = ProtoBuf$Expression.access$25600(r5);
        this.f19133b &= -33;
        goto L36
    L32:
        if ((this.f19133b & 32) == 32) goto L34;
        this.f19135h = new ArrayList(this.f19135h);
        this.f19133b |= 32;
    L34:
        this.f19135h.addAll(ProtoBuf$Expression.access$25600(r5));
    L36:
        if (ProtoBuf$Expression.access$25700(r5).isEmpty() == false) goto L38;
    L44:
        this.f19190a = this.f19190a.c(ProtoBuf$Expression.access$25900(r5));
        return;
    L38:
        if (this.f19136i.isEmpty() == false) goto L41;
        this.f19136i = ProtoBuf$Expression.access$25700(r5);
        this.f19133b &= -65;
        goto L44
    L41:
        if ((this.f19133b & 64) == 64) goto L43;
        this.f19136i = new ArrayList(this.f19136i);
        this.f19133b |= 64;
    L43:
        this.f19136i.addAll(ProtoBuf$Expression.access$25700(r5));
        goto L44
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Expression r11 = null;
        g((ProtoBuf$Expression) ProtoBuf$Expression.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Expression r12 = (ProtoBuf$Expression) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
