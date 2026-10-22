package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$Contract;
import kotlinx.metadata.internal.metadata.ProtoBuf$Function;
import kotlinx.metadata.internal.metadata.ProtoBuf$Type;
import kotlinx.metadata.internal.metadata.ProtoBuf$TypeTable;
import kotlinx.metadata.internal.metadata.a0;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends kotlinx.metadata.internal.protobuf.n implements k {
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProtoBuf$Type f742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ProtoBuf$Type f745k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f746l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f747m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f748n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f749o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ProtoBuf$TypeTable f750p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List f751q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ProtoBuf$Contract f752r;

    public static j i() {
        j r5 = new j();
        r5.e = 6;
        r5.f = 6;
        r5.f742h = ProtoBuf$Type.getDefaultInstance();
        r5.f744j = Collections.emptyList();
        r5.f745k = ProtoBuf$Type.getDefaultInstance();
        r5.f747m = Collections.emptyList();
        r5.f748n = Collections.emptyList();
        r5.f749o = Collections.emptyList();
        r5.f750p = ProtoBuf$TypeTable.getDefaultInstance();
        r5.f751q = Collections.emptyList();
        r5.f752r = ProtoBuf$Contract.getDefaultInstance();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$Function.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$Function r5 = h();
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
        j((ProtoBuf$Function) r5);
        return this;
    }

    public final Object clone() {
        j r5 = i();
        r5.j(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    public final ProtoBuf$Function h() {
        ProtoBuf$Function r5 = new ProtoBuf$Function(this, null);
        int r10 = this.d;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$Function.access$14302(r5, this.e);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$Function.access$14402(r5, this.f);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$Function.access$14502(r5, this.g);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 8;
    L15:
        ProtoBuf$Function.access$14602(r5, this.f742h);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 16;
    L18:
        ProtoBuf$Function.access$14702(r5, this.f743i);
        if ((this.d & 32) != 32) goto L21;
        this.f744j = Collections.unmodifiableList(this.f744j);
        this.d &= -33;
    L21:
        ProtoBuf$Function.access$14802(r5, this.f744j);
        if ((r10 & 64) != 64) goto L24;
        r11 = r11 | 32;
    L24:
        ProtoBuf$Function.access$14902(r5, this.f745k);
        if ((r10 & 128) != 128) goto L27;
        r11 = r11 | 64;
    L27:
        ProtoBuf$Function.access$15002(r5, this.f746l);
        if ((this.d & 256) != 256) goto L30;
        this.f747m = Collections.unmodifiableList(this.f747m);
        this.d &= -257;
    L30:
        ProtoBuf$Function.access$15102(r5, this.f747m);
        if ((this.d & 512) != 512) goto L33;
        this.f748n = Collections.unmodifiableList(this.f748n);
        this.d &= -513;
    L33:
        ProtoBuf$Function.access$15202(r5, this.f748n);
        if ((this.d & 1024) != 1024) goto L36;
        this.f749o = Collections.unmodifiableList(this.f749o);
        this.d &= -1025;
    L36:
        ProtoBuf$Function.access$15302(r5, this.f749o);
        if ((r10 & 2048) != 2048) goto L39;
        r11 = r11 | 128;
    L39:
        ProtoBuf$Function.access$15402(r5, this.f750p);
        if ((this.d & 4096) != 4096) goto L42;
        this.f751q = Collections.unmodifiableList(this.f751q);
        this.d &= -4097;
    L42:
        ProtoBuf$Function.access$15502(r5, this.f751q);
        if ((r10 & 8192) != 8192) goto L45;
        r11 = r11 | 256;
    L45:
        ProtoBuf$Function.access$15602(r5, this.f752r);
        ProtoBuf$Function.access$15702(r5, r11);
        return r5;
    }

    public final void j(ProtoBuf$Function r5) {
        if (r5 != ProtoBuf$Function.getDefaultInstance()) goto L6;
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
        this.f742h = r13;
    L22:
        this.d |= 8;
        goto L24
    L19:
        if (this.f742h == ProtoBuf$Type.getDefaultInstance()) goto L21;
        a0 r14 = ProtoBuf$Type.newBuilder(this.f742h);
        r14.i(r13);
        this.f742h = r14.h();
    L24:
        if (r5.hasReturnTypeId() == false) goto L27;
        int r15 = r5.getReturnTypeId();
        this.d |= 16;
        this.f743i = r15;
    L27:
        if (ProtoBuf$Function.access$14800(r5).isEmpty() == true) goto L36;
        if (this.f744j.isEmpty() == false) goto L32;
        this.f744j = ProtoBuf$Function.access$14800(r5);
        this.d &= -33;
        goto L36
    L32:
        if ((this.d & 32) == 32) goto L34;
        this.f744j = new ArrayList(this.f744j);
        this.d |= 32;
    L34:
        this.f744j.addAll(ProtoBuf$Function.access$14800(r5));
    L36:
        if (r5.hasReceiverType() == false) goto L45;
        ProtoBuf$Type r16 = r5.getReceiverType();
        if ((this.d & 64) == 64) goto L40;
    L42:
        this.f745k = r16;
    L43:
        this.d |= 64;
        goto L45
    L40:
        if (this.f745k == ProtoBuf$Type.getDefaultInstance()) goto L42;
        a0 r17 = ProtoBuf$Type.newBuilder(this.f745k);
        r17.i(r16);
        this.f745k = r17.h();
    L45:
        if (r5.hasReceiverTypeId() == false) goto L48;
        int r18 = r5.getReceiverTypeId();
        this.d |= 128;
        this.f746l = r18;
    L48:
        if (ProtoBuf$Function.access$15100(r5).isEmpty() == true) goto L57;
        if (this.f747m.isEmpty() == false) goto L53;
        this.f747m = ProtoBuf$Function.access$15100(r5);
        this.d &= -257;
        goto L57
    L53:
        if ((this.d & 256) == 256) goto L55;
        this.f747m = new ArrayList(this.f747m);
        this.d |= 256;
    L55:
        this.f747m.addAll(ProtoBuf$Function.access$15100(r5));
    L57:
        if (ProtoBuf$Function.access$15200(r5).isEmpty() == true) goto L66;
        if (this.f748n.isEmpty() == false) goto L62;
        this.f748n = ProtoBuf$Function.access$15200(r5);
        this.d &= -513;
        goto L66
    L62:
        if ((this.d & 512) == 512) goto L64;
        this.f748n = new ArrayList(this.f748n);
        this.d |= 512;
    L64:
        this.f748n.addAll(ProtoBuf$Function.access$15200(r5));
    L66:
        if (ProtoBuf$Function.access$15300(r5).isEmpty() == true) goto L75;
        if (this.f749o.isEmpty() == false) goto L71;
        this.f749o = ProtoBuf$Function.access$15300(r5);
        this.d &= -1025;
        goto L75
    L71:
        if ((this.d & 1024) == 1024) goto L73;
        this.f749o = new ArrayList(this.f749o);
        this.d |= 1024;
    L73:
        this.f749o.addAll(ProtoBuf$Function.access$15300(r5));
    L75:
        if (r5.hasTypeTable() == false) goto L84;
        ProtoBuf$TypeTable r19 = r5.getTypeTable();
        if ((this.d & 2048) == 2048) goto L79;
    L81:
        this.f750p = r19;
    L82:
        this.d |= 2048;
        goto L84
    L79:
        if (this.f750p == ProtoBuf$TypeTable.getDefaultInstance()) goto L81;
        s r20 = ProtoBuf$TypeTable.newBuilder(this.f750p);
        r20.g(r19);
        this.f750p = r20.f();
    L84:
        if (ProtoBuf$Function.access$15500(r5).isEmpty() == true) goto L93;
        if (this.f751q.isEmpty() == false) goto L89;
        this.f751q = ProtoBuf$Function.access$15500(r5);
        this.d &= -4097;
        goto L93
    L89:
        if ((this.d & 4096) == 4096) goto L91;
        this.f751q = new ArrayList(this.f751q);
        this.d |= 4096;
    L91:
        this.f751q.addAll(ProtoBuf$Function.access$15500(r5));
    L93:
        if (r5.hasContract() == false) goto L101;
        ProtoBuf$Contract r21 = r5.getContract();
        if ((this.d & 8192) == 8192) goto L97;
    L99:
        this.f752r = r21;
    L100:
        this.d |= 8192;
        goto L101
    L97:
        if (this.f752r == ProtoBuf$Contract.getDefaultInstance()) goto L99;
        g r22 = ProtoBuf$Contract.newBuilder(this.f752r);
        r22.g(r21);
        this.f752r = r22.f();
    L101:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$Function.access$15800(r5));
    }

    public final void k(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Function r11 = null;
        j((ProtoBuf$Function) ProtoBuf$Function.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Function r12 = (ProtoBuf$Function) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
