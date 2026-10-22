package kotlinx.metadata.internal.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends kotlinx.metadata.internal.protobuf.m implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProtoBuf$Annotation.Argument.Value.Type f19105c;
    public long d;
    public float e;
    public double f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ProtoBuf$Annotation f19108j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f19109k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19110l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19111m;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$Annotation.Argument.Value r5 = f();
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
        g((ProtoBuf$Annotation.Argument.Value) r5);
        return this;
    }

    public final Object clone() {
        d r5 = new d();
        r5.f19105c = ProtoBuf$Annotation.Argument.Value.Type.BYTE;
        r5.f19108j = ProtoBuf$Annotation.getDefaultInstance();
        r5.f19109k = Collections.emptyList();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$Annotation.Argument.Value f() {
        ProtoBuf$Annotation.Argument.Value r5 = new ProtoBuf$Annotation.Argument.Value(this, null);
        int r10 = this.f19104b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$Annotation.Argument.Value.access$2302(r5, this.f19105c);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$Annotation.Argument.Value.access$2402(r5, this.d);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$Annotation.Argument.Value.access$2502(r5, this.e);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 8;
    L15:
        ProtoBuf$Annotation.Argument.Value.access$2602(r5, this.f);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 16;
    L18:
        ProtoBuf$Annotation.Argument.Value.access$2702(r5, this.g);
        if ((r10 & 32) != 32) goto L21;
        r11 = r11 | 32;
    L21:
        ProtoBuf$Annotation.Argument.Value.access$2802(r5, this.f19106h);
        if ((r10 & 64) != 64) goto L24;
        r11 = r11 | 64;
    L24:
        ProtoBuf$Annotation.Argument.Value.access$2902(r5, this.f19107i);
        if ((r10 & 128) != 128) goto L27;
        r11 = r11 | 128;
    L27:
        ProtoBuf$Annotation.Argument.Value.access$3002(r5, this.f19108j);
        if ((this.f19104b & 256) != 256) goto L30;
        this.f19109k = Collections.unmodifiableList(this.f19109k);
        this.f19104b &= -257;
    L30:
        ProtoBuf$Annotation.Argument.Value.access$3102(r5, this.f19109k);
        if ((r10 & 512) != 512) goto L33;
        r11 = r11 | 256;
    L33:
        ProtoBuf$Annotation.Argument.Value.access$3202(r5, this.f19110l);
        if ((r10 & 1024) != 1024) goto L36;
        r11 = r11 | 512;
    L36:
        ProtoBuf$Annotation.Argument.Value.access$3302(r5, this.f19111m);
        ProtoBuf$Annotation.Argument.Value.access$3402(r5, r11);
        return r5;
    }

    public final void g(ProtoBuf$Annotation.Argument.Value r5) {
        if (r5 != ProtoBuf$Annotation.Argument.Value.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasType() == false) goto L9;
        ProtoBuf$Annotation.Argument.Value.Type r10 = r5.getType();
        r10.getClass();
        this.f19104b |= 1;
        this.f19105c = r10;
    L9:
        if (r5.hasIntValue() == false) goto L12;
        long r11 = r5.getIntValue();
        this.f19104b |= 2;
        this.d = r11;
    L12:
        if (r5.hasFloatValue() == false) goto L15;
        float r12 = r5.getFloatValue();
        this.f19104b |= 4;
        this.e = r12;
    L15:
        if (r5.hasDoubleValue() == false) goto L18;
        double r13 = r5.getDoubleValue();
        this.f19104b |= 8;
        this.f = r13;
    L18:
        if (r5.hasStringValue() == false) goto L21;
        int r14 = r5.getStringValue();
        this.f19104b |= 16;
        this.g = r14;
    L21:
        if (r5.hasClassId() == false) goto L24;
        int r15 = r5.getClassId();
        this.f19104b |= 32;
        this.f19106h = r15;
    L24:
        if (r5.hasEnumValueId() == false) goto L27;
        int r16 = r5.getEnumValueId();
        this.f19104b |= 64;
        this.f19107i = r16;
    L27:
        if (r5.hasAnnotation() == false) goto L36;
        ProtoBuf$Annotation r17 = r5.getAnnotation();
        if ((this.f19104b & 128) == 128) goto L31;
    L33:
        this.f19108j = r17;
    L34:
        this.f19104b |= 128;
        goto L36
    L31:
        if (this.f19108j == ProtoBuf$Annotation.getDefaultInstance()) goto L33;
        h r18 = ProtoBuf$Annotation.newBuilder(this.f19108j);
        r18.g(r17);
        this.f19108j = r18.f();
    L36:
        if (ProtoBuf$Annotation.Argument.Value.access$3100(r5).isEmpty() == true) goto L45;
        if (this.f19109k.isEmpty() == false) goto L41;
        this.f19109k = ProtoBuf$Annotation.Argument.Value.access$3100(r5);
        this.f19104b &= -257;
        goto L45
    L41:
        if ((this.f19104b & 256) == 256) goto L43;
        this.f19109k = new ArrayList(this.f19109k);
        this.f19104b |= 256;
    L43:
        this.f19109k.addAll(ProtoBuf$Annotation.Argument.Value.access$3100(r5));
    L45:
        if (r5.hasArrayDimensionCount() == false) goto L48;
        int r19 = r5.getArrayDimensionCount();
        this.f19104b |= 512;
        this.f19110l = r19;
    L48:
        if (r5.hasFlags() == false) goto L50;
        int r20 = r5.getFlags();
        this.f19104b |= 1024;
        this.f19111m = r20;
    L50:
        this.f19190a = this.f19190a.c(ProtoBuf$Annotation.Argument.Value.access$3500(r5));
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Annotation.Argument.Value r11 = null;
        g((ProtoBuf$Annotation.Argument.Value) ProtoBuf$Annotation.Argument.Value.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Annotation.Argument.Value r12 = (ProtoBuf$Annotation.Argument.Value) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
