package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$Property;
import kotlinx.metadata.internal.metadata.ProtoBuf$Type;
import kotlinx.metadata.internal.metadata.ProtoBuf$ValueParameter;
import kotlinx.metadata.internal.metadata.a0;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends kotlinx.metadata.internal.protobuf.n implements o {
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProtoBuf$Type f756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ProtoBuf$Type f759k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f760l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f761m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f762n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ProtoBuf$ValueParameter f763o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f764p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f765q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f766r;

    public static n i() {
        n r5 = new n();
        r5.e = 518;
        r5.f = 2054;
        r5.f756h = ProtoBuf$Type.getDefaultInstance();
        r5.f758j = Collections.emptyList();
        r5.f759k = ProtoBuf$Type.getDefaultInstance();
        r5.f761m = Collections.emptyList();
        r5.f762n = Collections.emptyList();
        r5.f763o = ProtoBuf$ValueParameter.getDefaultInstance();
        r5.f766r = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$Property.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$Property r5 = h();
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
        j((ProtoBuf$Property) r5);
        return this;
    }

    public final Object clone() {
        n r5 = i();
        r5.j(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    public final ProtoBuf$Property h() {
        ProtoBuf$Property r5 = new ProtoBuf$Property(this, null);
        int r10 = this.d;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$Property.access$16202(r5, this.e);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$Property.access$16302(r5, this.f);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$Property.access$16402(r5, this.g);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 8;
    L15:
        ProtoBuf$Property.access$16502(r5, this.f756h);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 16;
    L18:
        ProtoBuf$Property.access$16602(r5, this.f757i);
        if ((this.d & 32) != 32) goto L21;
        this.f758j = Collections.unmodifiableList(this.f758j);
        this.d &= -33;
    L21:
        ProtoBuf$Property.access$16702(r5, this.f758j);
        if ((r10 & 64) != 64) goto L24;
        r11 = r11 | 32;
    L24:
        ProtoBuf$Property.access$16802(r5, this.f759k);
        if ((r10 & 128) != 128) goto L27;
        r11 = r11 | 64;
    L27:
        ProtoBuf$Property.access$16902(r5, this.f760l);
        if ((this.d & 256) != 256) goto L30;
        this.f761m = Collections.unmodifiableList(this.f761m);
        this.d &= -257;
    L30:
        ProtoBuf$Property.access$17002(r5, this.f761m);
        if ((this.d & 512) != 512) goto L33;
        this.f762n = Collections.unmodifiableList(this.f762n);
        this.d &= -513;
    L33:
        ProtoBuf$Property.access$17102(r5, this.f762n);
        if ((r10 & 1024) != 1024) goto L36;
        r11 = r11 | 128;
    L36:
        ProtoBuf$Property.access$17202(r5, this.f763o);
        if ((r10 & 2048) != 2048) goto L39;
        r11 = r11 | 256;
    L39:
        ProtoBuf$Property.access$17302(r5, this.f764p);
        if ((r10 & 4096) != 4096) goto L42;
        r11 = r11 | 512;
    L42:
        ProtoBuf$Property.access$17402(r5, this.f765q);
        if ((this.d & 8192) != 8192) goto L45;
        this.f766r = Collections.unmodifiableList(this.f766r);
        this.d &= -8193;
    L45:
        ProtoBuf$Property.access$17502(r5, this.f766r);
        ProtoBuf$Property.access$17602(r5, r11);
        return r5;
    }

    public final void j(ProtoBuf$Property r5) {
        if (r5 != ProtoBuf$Property.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasFlags() == false) goto L9;
        int r10 = r5.getFlags();
        this.d |= 1;
        this.e = r10;
    L9:
        if (r5.hasOldFlags() == false) goto L12;
        int r11 = r5.getOldFlags();
        this.d |= 2;
        this.f = r11;
    L12:
        if (r5.hasName() == false) goto L15;
        int r12 = r5.getName();
        this.d |= 4;
        this.g = r12;
    L15:
        if (r5.hasReturnType() == false) goto L24;
        ProtoBuf$Type r13 = r5.getReturnType();
        if ((this.d & 8) == 8) goto L19;
    L21:
        this.f756h = r13;
    L22:
        this.d |= 8;
        goto L24
    L19:
        if (this.f756h == ProtoBuf$Type.getDefaultInstance()) goto L21;
        a0 r14 = ProtoBuf$Type.newBuilder(this.f756h);
        r14.i(r13);
        this.f756h = r14.h();
    L24:
        if (r5.hasReturnTypeId() == false) goto L27;
        int r15 = r5.getReturnTypeId();
        this.d |= 16;
        this.f757i = r15;
    L27:
        if (ProtoBuf$Property.access$16700(r5).isEmpty() == true) goto L36;
        if (this.f758j.isEmpty() == false) goto L32;
        this.f758j = ProtoBuf$Property.access$16700(r5);
        this.d &= -33;
        goto L36
    L32:
        if ((this.d & 32) == 32) goto L34;
        this.f758j = new ArrayList(this.f758j);
        this.d |= 32;
    L34:
        this.f758j.addAll(ProtoBuf$Property.access$16700(r5));
    L36:
        if (r5.hasReceiverType() == false) goto L45;
        ProtoBuf$Type r16 = r5.getReceiverType();
        if ((this.d & 64) == 64) goto L40;
    L42:
        this.f759k = r16;
    L43:
        this.d |= 64;
        goto L45
    L40:
        if (this.f759k == ProtoBuf$Type.getDefaultInstance()) goto L42;
        a0 r17 = ProtoBuf$Type.newBuilder(this.f759k);
        r17.i(r16);
        this.f759k = r17.h();
    L45:
        if (r5.hasReceiverTypeId() == false) goto L48;
        int r18 = r5.getReceiverTypeId();
        this.d |= 128;
        this.f760l = r18;
    L48:
        if (ProtoBuf$Property.access$17000(r5).isEmpty() == true) goto L57;
        if (this.f761m.isEmpty() == false) goto L53;
        this.f761m = ProtoBuf$Property.access$17000(r5);
        this.d &= -257;
        goto L57
    L53:
        if ((this.d & 256) == 256) goto L55;
        this.f761m = new ArrayList(this.f761m);
        this.d |= 256;
    L55:
        this.f761m.addAll(ProtoBuf$Property.access$17000(r5));
    L57:
        if (ProtoBuf$Property.access$17100(r5).isEmpty() == true) goto L66;
        if (this.f762n.isEmpty() == false) goto L62;
        this.f762n = ProtoBuf$Property.access$17100(r5);
        this.d &= -513;
        goto L66
    L62:
        if ((this.d & 512) == 512) goto L64;
        this.f762n = new ArrayList(this.f762n);
        this.d |= 512;
    L64:
        this.f762n.addAll(ProtoBuf$Property.access$17100(r5));
    L66:
        if (r5.hasSetterValueParameter() == false) goto L75;
        ProtoBuf$ValueParameter r19 = r5.getSetterValueParameter();
        if ((this.d & 1024) == 1024) goto L70;
    L72:
        this.f763o = r19;
    L73:
        this.d |= 1024;
        goto L75
    L70:
        if (this.f763o == ProtoBuf$ValueParameter.getDefaultInstance()) goto L72;
        t r20 = ProtoBuf$ValueParameter.newBuilder(this.f763o);
        r20.i(r19);
        this.f763o = r20.h();
    L75:
        if (r5.hasGetterFlags() == false) goto L78;
        int r21 = r5.getGetterFlags();
        this.d |= 2048;
        this.f764p = r21;
    L78:
        if (r5.hasSetterFlags() == false) goto L81;
        int r22 = r5.getSetterFlags();
        this.d |= 4096;
        this.f765q = r22;
    L81:
        if (ProtoBuf$Property.access$17500(r5).isEmpty() == false) goto L83;
    L89:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$Property.access$17700(r5));
        return;
    L83:
        if (this.f766r.isEmpty() == false) goto L86;
        this.f766r = ProtoBuf$Property.access$17500(r5);
        this.d &= -8193;
        goto L89
    L86:
        if ((this.d & 8192) == 8192) goto L88;
        this.f766r = new ArrayList(this.f766r);
        this.d |= 8192;
    L88:
        this.f766r.addAll(ProtoBuf$Property.access$17500(r5));
        goto L89
    }

    public final void k(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Property r11 = null;
        j((ProtoBuf$Property) ProtoBuf$Property.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Property r12 = (ProtoBuf$Property) e.getUnfinishedMessage();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L11
    L11:
        th = th;
        r11 = r12;
    L13:
        if (r11 == null) goto L15;
        j(r11);
    L15:
        throw th;
    L6:
        th = th;
        goto L13
    }
}
