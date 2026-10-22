package kotlinx.metadata.internal.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends kotlinx.metadata.internal.protobuf.n implements b0 {
    public int d;
    public List e;
    public boolean f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProtoBuf$Type f19088h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19089i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f19090j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19091k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19092l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19093m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ProtoBuf$Type f19094n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f19095o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ProtoBuf$Type f19096p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f19097q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f19098r;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$Type.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$Type r5 = h();
        if (r5.isInitialized() == false) goto L6;
        return r5;
    L6:
        throw new UninitializedMessageException(r5);
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z buildPartial() {
        return h();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m c(GeneratedMessageLite r5) {
        i((ProtoBuf$Type) r5);
        return this;
    }

    public final Object clone() {
        a0 r5 = new a0();
        r5.e = Collections.emptyList();
        r5.f19088h = ProtoBuf$Type.getDefaultInstance();
        r5.f19094n = ProtoBuf$Type.getDefaultInstance();
        r5.f19096p = ProtoBuf$Type.getDefaultInstance();
        r5.i(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    public final ProtoBuf$Type h() {
        ProtoBuf$Type r5 = new ProtoBuf$Type(this, null);
        int r10 = this.d;
        int r11 = 1;
        if ((r10 & 1) != 1) goto L5;
        this.e = Collections.unmodifiableList(this.e);
        this.d &= -2;
    L5:
        ProtoBuf$Type.access$5902(r5, this.e);
        if ((r10 & 2) == 2) goto L9;
        r11 = 0;
    L9:
        ProtoBuf$Type.access$6002(r5, this.f);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 2;
    L12:
        ProtoBuf$Type.access$6102(r5, this.g);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 4;
    L15:
        ProtoBuf$Type.access$6202(r5, this.f19088h);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 8;
    L18:
        ProtoBuf$Type.access$6302(r5, this.f19089i);
        if ((r10 & 32) != 32) goto L21;
        r11 = r11 | 16;
    L21:
        ProtoBuf$Type.access$6402(r5, this.f19090j);
        if ((r10 & 64) != 64) goto L24;
        r11 = r11 | 32;
    L24:
        ProtoBuf$Type.access$6502(r5, this.f19091k);
        if ((r10 & 128) != 128) goto L27;
        r11 = r11 | 64;
    L27:
        ProtoBuf$Type.access$6602(r5, this.f19092l);
        if ((r10 & 256) != 256) goto L30;
        r11 = r11 | 128;
    L30:
        ProtoBuf$Type.access$6702(r5, this.f19093m);
        if ((r10 & 512) != 512) goto L33;
        r11 = r11 | 256;
    L33:
        ProtoBuf$Type.access$6802(r5, this.f19094n);
        if ((r10 & 1024) != 1024) goto L36;
        r11 = r11 | 512;
    L36:
        ProtoBuf$Type.access$6902(r5, this.f19095o);
        if ((r10 & 2048) != 2048) goto L39;
        r11 = r11 | 1024;
    L39:
        ProtoBuf$Type.access$7002(r5, this.f19096p);
        if ((r10 & 4096) != 4096) goto L42;
        r11 = r11 | 2048;
    L42:
        ProtoBuf$Type.access$7102(r5, this.f19097q);
        if ((r10 & 8192) != 8192) goto L45;
        r11 = r11 | 4096;
    L45:
        ProtoBuf$Type.access$7202(r5, this.f19098r);
        ProtoBuf$Type.access$7302(r5, r11);
        return r5;
    }

    public final a0 i(ProtoBuf$Type r5) {
        if (r5 != ProtoBuf$Type.getDefaultInstance()) goto L6;
        return this;
    L6:
        if (ProtoBuf$Type.access$5900(r5).isEmpty() == true) goto L15;
        if (this.e.isEmpty() == false) goto L11;
        this.e = ProtoBuf$Type.access$5900(r5);
        this.d &= -2;
        goto L15
    L11:
        if ((this.d & 1) == 1) goto L13;
        this.e = new ArrayList(this.e);
        this.d |= 1;
    L13:
        this.e.addAll(ProtoBuf$Type.access$5900(r5));
    L15:
        if (r5.hasNullable() == false) goto L18;
        boolean r10 = r5.getNullable();
        this.d |= 2;
        this.f = r10;
    L18:
        if (r5.hasFlexibleTypeCapabilitiesId() == false) goto L21;
        int r11 = r5.getFlexibleTypeCapabilitiesId();
        this.d |= 4;
        this.g = r11;
    L21:
        if (r5.hasFlexibleUpperBound() == false) goto L30;
        ProtoBuf$Type r12 = r5.getFlexibleUpperBound();
        if ((this.d & 8) == 8) goto L25;
    L27:
        this.f19088h = r12;
    L28:
        this.d |= 8;
        goto L30
    L25:
        if (this.f19088h == ProtoBuf$Type.getDefaultInstance()) goto L27;
        a0 r13 = ProtoBuf$Type.newBuilder(this.f19088h);
        r13.i(r12);
        this.f19088h = r13.h();
    L30:
        if (r5.hasFlexibleUpperBoundId() == false) goto L33;
        int r14 = r5.getFlexibleUpperBoundId();
        this.d |= 16;
        this.f19089i = r14;
    L33:
        if (r5.hasClassName() == false) goto L36;
        int r15 = r5.getClassName();
        this.d |= 32;
        this.f19090j = r15;
    L36:
        if (r5.hasTypeParameter() == false) goto L39;
        int r16 = r5.getTypeParameter();
        this.d |= 64;
        this.f19091k = r16;
    L39:
        if (r5.hasTypeParameterName() == false) goto L42;
        int r17 = r5.getTypeParameterName();
        this.d |= 128;
        this.f19092l = r17;
    L42:
        if (r5.hasTypeAliasName() == false) goto L45;
        int r18 = r5.getTypeAliasName();
        this.d |= 256;
        this.f19093m = r18;
    L45:
        if (r5.hasOuterType() == false) goto L54;
        ProtoBuf$Type r19 = r5.getOuterType();
        if ((this.d & 512) == 512) goto L49;
    L51:
        this.f19094n = r19;
    L52:
        this.d |= 512;
        goto L54
    L49:
        if (this.f19094n == ProtoBuf$Type.getDefaultInstance()) goto L51;
        a0 r20 = ProtoBuf$Type.newBuilder(this.f19094n);
        r20.i(r19);
        this.f19094n = r20.h();
    L54:
        if (r5.hasOuterTypeId() == false) goto L57;
        int r21 = r5.getOuterTypeId();
        this.d |= 1024;
        this.f19095o = r21;
    L57:
        if (r5.hasAbbreviatedType() == false) goto L66;
        ProtoBuf$Type r22 = r5.getAbbreviatedType();
        if ((this.d & 2048) == 2048) goto L61;
    L63:
        this.f19096p = r22;
    L64:
        this.d |= 2048;
        goto L66
    L61:
        if (this.f19096p == ProtoBuf$Type.getDefaultInstance()) goto L63;
        a0 r23 = ProtoBuf$Type.newBuilder(this.f19096p);
        r23.i(r22);
        this.f19096p = r23.h();
    L66:
        if (r5.hasAbbreviatedTypeId() == false) goto L69;
        int r24 = r5.getAbbreviatedTypeId();
        this.d |= 4096;
        this.f19097q = r24;
    L69:
        if (r5.hasFlags() == false) goto L71;
        int r25 = r5.getFlags();
        this.d |= 8192;
        this.f19098r = r25;
    L71:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$Type.access$7400(r5));
        return this;
    }

    public final void j(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Type r11 = null;
        i((ProtoBuf$Type) ProtoBuf$Type.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Type r12 = (ProtoBuf$Type) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
