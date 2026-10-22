package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$Class;
import kotlinx.metadata.internal.metadata.ProtoBuf$Type;
import kotlinx.metadata.internal.metadata.ProtoBuf$TypeTable;
import kotlinx.metadata.internal.metadata.ProtoBuf$VersionRequirementTable;
import kotlinx.metadata.internal.metadata.a0;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends kotlinx.metadata.internal.protobuf.n implements d {
    public List A;
    public ProtoBuf$VersionRequirementTable B;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f727m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f730p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List f731q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f732r;
    public List s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f733t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ProtoBuf$Type f734u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f735v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List f736w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List f737x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List f738y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ProtoBuf$TypeTable f739z;

    public static c i() {
        c r5 = new c();
        r5.e = 6;
        r5.f722h = Collections.emptyList();
        r5.f723i = Collections.emptyList();
        r5.f724j = Collections.emptyList();
        r5.f725k = Collections.emptyList();
        r5.f726l = Collections.emptyList();
        r5.f727m = Collections.emptyList();
        r5.f728n = Collections.emptyList();
        r5.f729o = Collections.emptyList();
        r5.f730p = Collections.emptyList();
        r5.f731q = Collections.emptyList();
        r5.f732r = Collections.emptyList();
        r5.s = Collections.emptyList();
        r5.f734u = ProtoBuf$Type.getDefaultInstance();
        r5.f736w = Collections.emptyList();
        r5.f737x = Collections.emptyList();
        r5.f738y = Collections.emptyList();
        r5.f739z = ProtoBuf$TypeTable.getDefaultInstance();
        r5.A = Collections.emptyList();
        r5.B = ProtoBuf$VersionRequirementTable.getDefaultInstance();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$Class.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$Class r5 = h();
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
        j((ProtoBuf$Class) r5);
        return this;
    }

    public final Object clone() {
        c r5 = i();
        r5.j(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    public final ProtoBuf$Class h() {
        ProtoBuf$Class r5 = new ProtoBuf$Class(this, null);
        int r10 = this.d;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$Class.access$8902(r5, this.e);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$Class.access$9002(r5, this.f);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$Class.access$9102(r5, this.g);
        if ((this.d & 8) != 8) goto L15;
        this.f722h = Collections.unmodifiableList(this.f722h);
        this.d &= -9;
    L15:
        ProtoBuf$Class.access$9202(r5, this.f722h);
        if ((this.d & 16) != 16) goto L18;
        this.f723i = Collections.unmodifiableList(this.f723i);
        this.d &= -17;
    L18:
        ProtoBuf$Class.access$9302(r5, this.f723i);
        if ((this.d & 32) != 32) goto L21;
        this.f724j = Collections.unmodifiableList(this.f724j);
        this.d &= -33;
    L21:
        ProtoBuf$Class.access$9402(r5, this.f724j);
        if ((this.d & 64) != 64) goto L24;
        this.f725k = Collections.unmodifiableList(this.f725k);
        this.d &= -65;
    L24:
        ProtoBuf$Class.access$9502(r5, this.f725k);
        if ((this.d & 128) != 128) goto L27;
        this.f726l = Collections.unmodifiableList(this.f726l);
        this.d &= -129;
    L27:
        ProtoBuf$Class.access$9602(r5, this.f726l);
        if ((this.d & 256) != 256) goto L30;
        this.f727m = Collections.unmodifiableList(this.f727m);
        this.d &= -257;
    L30:
        ProtoBuf$Class.access$9702(r5, this.f727m);
        if ((this.d & 512) != 512) goto L33;
        this.f728n = Collections.unmodifiableList(this.f728n);
        this.d &= -513;
    L33:
        ProtoBuf$Class.access$9802(r5, this.f728n);
        if ((this.d & 1024) != 1024) goto L36;
        this.f729o = Collections.unmodifiableList(this.f729o);
        this.d &= -1025;
    L36:
        ProtoBuf$Class.access$9902(r5, this.f729o);
        if ((this.d & 2048) != 2048) goto L39;
        this.f730p = Collections.unmodifiableList(this.f730p);
        this.d &= -2049;
    L39:
        ProtoBuf$Class.access$10002(r5, this.f730p);
        if ((this.d & 4096) != 4096) goto L42;
        this.f731q = Collections.unmodifiableList(this.f731q);
        this.d &= -4097;
    L42:
        ProtoBuf$Class.access$10102(r5, this.f731q);
        if ((this.d & 8192) != 8192) goto L45;
        this.f732r = Collections.unmodifiableList(this.f732r);
        this.d &= -8193;
    L45:
        ProtoBuf$Class.access$10202(r5, this.f732r);
        if ((this.d & 16384) != 16384) goto L48;
        this.s = Collections.unmodifiableList(this.s);
        this.d &= -16385;
    L48:
        ProtoBuf$Class.access$10302(r5, this.s);
        if ((r10 & 32768) != 32768) goto L51;
        r11 = r11 | 8;
    L51:
        ProtoBuf$Class.access$10402(r5, this.f733t);
        if ((r10 & 65536) != 65536) goto L54;
        r11 = r11 | 16;
    L54:
        ProtoBuf$Class.access$10502(r5, this.f734u);
        if ((r10 & 131072) != 131072) goto L57;
        r11 = r11 | 32;
    L57:
        ProtoBuf$Class.access$10602(r5, this.f735v);
        if ((this.d & 262144) != 262144) goto L60;
        this.f736w = Collections.unmodifiableList(this.f736w);
        this.d &= -262145;
    L60:
        ProtoBuf$Class.access$10702(r5, this.f736w);
        if ((this.d & 524288) != 524288) goto L63;
        this.f737x = Collections.unmodifiableList(this.f737x);
        this.d &= -524289;
    L63:
        ProtoBuf$Class.access$10802(r5, this.f737x);
        if ((this.d & 1048576) != 1048576) goto L66;
        this.f738y = Collections.unmodifiableList(this.f738y);
        this.d &= -1048577;
    L66:
        ProtoBuf$Class.access$10902(r5, this.f738y);
        if ((r10 & 2097152) != 2097152) goto L69;
        r11 = r11 | 64;
    L69:
        ProtoBuf$Class.access$11002(r5, this.f739z);
        if ((this.d & 4194304) != 4194304) goto L72;
        this.A = Collections.unmodifiableList(this.A);
        this.d &= -4194305;
    L72:
        ProtoBuf$Class.access$11102(r5, this.A);
        if ((r10 & 8388608) != 8388608) goto L75;
        r11 = r11 | 128;
    L75:
        ProtoBuf$Class.access$11202(r5, this.B);
        ProtoBuf$Class.access$11302(r5, r11);
        return r5;
    }

    public final c j(ProtoBuf$Class r5) {
        if (r5 != ProtoBuf$Class.getDefaultInstance()) goto L6;
        return this;
    L6:
        if (r5.hasFlags() == false) goto L9;
        int r10 = r5.getFlags();
        this.d |= 1;
        this.e = r10;
    L9:
        if (r5.hasFqName() == false) goto L12;
        int r11 = r5.getFqName();
        this.d |= 2;
        this.f = r11;
    L12:
        if (r5.hasCompanionObjectName() == false) goto L15;
        int r12 = r5.getCompanionObjectName();
        this.d |= 4;
        this.g = r12;
    L15:
        if (ProtoBuf$Class.access$9200(r5).isEmpty() == true) goto L24;
        if (this.f722h.isEmpty() == false) goto L20;
        this.f722h = ProtoBuf$Class.access$9200(r5);
        this.d &= -9;
        goto L24
    L20:
        if ((this.d & 8) == 8) goto L22;
        this.f722h = new ArrayList(this.f722h);
        this.d |= 8;
    L22:
        this.f722h.addAll(ProtoBuf$Class.access$9200(r5));
    L24:
        if (ProtoBuf$Class.access$9300(r5).isEmpty() == true) goto L33;
        if (this.f723i.isEmpty() == false) goto L29;
        this.f723i = ProtoBuf$Class.access$9300(r5);
        this.d &= -17;
        goto L33
    L29:
        if ((this.d & 16) == 16) goto L31;
        this.f723i = new ArrayList(this.f723i);
        this.d |= 16;
    L31:
        this.f723i.addAll(ProtoBuf$Class.access$9300(r5));
    L33:
        if (ProtoBuf$Class.access$9400(r5).isEmpty() == true) goto L42;
        if (this.f724j.isEmpty() == false) goto L38;
        this.f724j = ProtoBuf$Class.access$9400(r5);
        this.d &= -33;
        goto L42
    L38:
        if ((this.d & 32) == 32) goto L40;
        this.f724j = new ArrayList(this.f724j);
        this.d |= 32;
    L40:
        this.f724j.addAll(ProtoBuf$Class.access$9400(r5));
    L42:
        if (ProtoBuf$Class.access$9500(r5).isEmpty() == true) goto L51;
        if (this.f725k.isEmpty() == false) goto L47;
        this.f725k = ProtoBuf$Class.access$9500(r5);
        this.d &= -65;
        goto L51
    L47:
        if ((this.d & 64) == 64) goto L49;
        this.f725k = new ArrayList(this.f725k);
        this.d |= 64;
    L49:
        this.f725k.addAll(ProtoBuf$Class.access$9500(r5));
    L51:
        if (ProtoBuf$Class.access$9600(r5).isEmpty() == true) goto L60;
        if (this.f726l.isEmpty() == false) goto L56;
        this.f726l = ProtoBuf$Class.access$9600(r5);
        this.d &= -129;
        goto L60
    L56:
        if ((this.d & 128) == 128) goto L58;
        this.f726l = new ArrayList(this.f726l);
        this.d |= 128;
    L58:
        this.f726l.addAll(ProtoBuf$Class.access$9600(r5));
    L60:
        if (ProtoBuf$Class.access$9700(r5).isEmpty() == true) goto L69;
        if (this.f727m.isEmpty() == false) goto L65;
        this.f727m = ProtoBuf$Class.access$9700(r5);
        this.d &= -257;
        goto L69
    L65:
        if ((this.d & 256) == 256) goto L67;
        this.f727m = new ArrayList(this.f727m);
        this.d |= 256;
    L67:
        this.f727m.addAll(ProtoBuf$Class.access$9700(r5));
    L69:
        if (ProtoBuf$Class.access$9800(r5).isEmpty() == true) goto L78;
        if (this.f728n.isEmpty() == false) goto L74;
        this.f728n = ProtoBuf$Class.access$9800(r5);
        this.d &= -513;
        goto L78
    L74:
        if ((this.d & 512) == 512) goto L76;
        this.f728n = new ArrayList(this.f728n);
        this.d |= 512;
    L76:
        this.f728n.addAll(ProtoBuf$Class.access$9800(r5));
    L78:
        if (ProtoBuf$Class.access$9900(r5).isEmpty() == true) goto L87;
        if (this.f729o.isEmpty() == false) goto L83;
        this.f729o = ProtoBuf$Class.access$9900(r5);
        this.d &= -1025;
        goto L87
    L83:
        if ((this.d & 1024) == 1024) goto L85;
        this.f729o = new ArrayList(this.f729o);
        this.d |= 1024;
    L85:
        this.f729o.addAll(ProtoBuf$Class.access$9900(r5));
    L87:
        if (ProtoBuf$Class.access$10000(r5).isEmpty() == true) goto L96;
        if (this.f730p.isEmpty() == false) goto L92;
        this.f730p = ProtoBuf$Class.access$10000(r5);
        this.d &= -2049;
        goto L96
    L92:
        if ((this.d & 2048) == 2048) goto L94;
        this.f730p = new ArrayList(this.f730p);
        this.d |= 2048;
    L94:
        this.f730p.addAll(ProtoBuf$Class.access$10000(r5));
    L96:
        if (ProtoBuf$Class.access$10100(r5).isEmpty() == true) goto L105;
        if (this.f731q.isEmpty() == false) goto L101;
        this.f731q = ProtoBuf$Class.access$10100(r5);
        this.d &= -4097;
        goto L105
    L101:
        if ((this.d & 4096) == 4096) goto L103;
        this.f731q = new ArrayList(this.f731q);
        this.d |= 4096;
    L103:
        this.f731q.addAll(ProtoBuf$Class.access$10100(r5));
    L105:
        if (ProtoBuf$Class.access$10200(r5).isEmpty() == true) goto L114;
        if (this.f732r.isEmpty() == false) goto L110;
        this.f732r = ProtoBuf$Class.access$10200(r5);
        this.d &= -8193;
        goto L114
    L110:
        if ((this.d & 8192) == 8192) goto L112;
        this.f732r = new ArrayList(this.f732r);
        this.d |= 8192;
    L112:
        this.f732r.addAll(ProtoBuf$Class.access$10200(r5));
    L114:
        if (ProtoBuf$Class.access$10300(r5).isEmpty() == true) goto L123;
        if (this.s.isEmpty() == false) goto L119;
        this.s = ProtoBuf$Class.access$10300(r5);
        this.d &= -16385;
        goto L123
    L119:
        if ((this.d & 16384) == 16384) goto L121;
        this.s = new ArrayList(this.s);
        this.d |= 16384;
    L121:
        this.s.addAll(ProtoBuf$Class.access$10300(r5));
    L123:
        if (r5.hasInlineClassUnderlyingPropertyName() == false) goto L126;
        int r13 = r5.getInlineClassUnderlyingPropertyName();
        this.d |= 32768;
        this.f733t = r13;
    L126:
        if (r5.hasInlineClassUnderlyingType() == false) goto L135;
        ProtoBuf$Type r14 = r5.getInlineClassUnderlyingType();
        if ((this.d & 65536) == 65536) goto L130;
    L132:
        this.f734u = r14;
    L133:
        this.d |= 65536;
        goto L135
    L130:
        if (this.f734u == ProtoBuf$Type.getDefaultInstance()) goto L132;
        a0 r15 = ProtoBuf$Type.newBuilder(this.f734u);
        r15.i(r14);
        this.f734u = r15.h();
    L135:
        if (r5.hasInlineClassUnderlyingTypeId() == false) goto L138;
        int r16 = r5.getInlineClassUnderlyingTypeId();
        this.d |= 131072;
        this.f735v = r16;
    L138:
        if (ProtoBuf$Class.access$10700(r5).isEmpty() == true) goto L147;
        if (this.f736w.isEmpty() == false) goto L143;
        this.f736w = ProtoBuf$Class.access$10700(r5);
        this.d &= -262145;
        goto L147
    L143:
        if ((this.d & 262144) == 262144) goto L145;
        this.f736w = new ArrayList(this.f736w);
        this.d |= 262144;
    L145:
        this.f736w.addAll(ProtoBuf$Class.access$10700(r5));
    L147:
        if (ProtoBuf$Class.access$10800(r5).isEmpty() == true) goto L156;
        if (this.f737x.isEmpty() == false) goto L152;
        this.f737x = ProtoBuf$Class.access$10800(r5);
        this.d &= -524289;
        goto L156
    L152:
        if ((this.d & 524288) == 524288) goto L154;
        this.f737x = new ArrayList(this.f737x);
        this.d |= 524288;
    L154:
        this.f737x.addAll(ProtoBuf$Class.access$10800(r5));
    L156:
        if (ProtoBuf$Class.access$10900(r5).isEmpty() == true) goto L165;
        if (this.f738y.isEmpty() == false) goto L161;
        this.f738y = ProtoBuf$Class.access$10900(r5);
        this.d &= -1048577;
        goto L165
    L161:
        if ((this.d & 1048576) == 1048576) goto L163;
        this.f738y = new ArrayList(this.f738y);
        this.d |= 1048576;
    L163:
        this.f738y.addAll(ProtoBuf$Class.access$10900(r5));
    L165:
        if (r5.hasTypeTable() == false) goto L174;
        ProtoBuf$TypeTable r17 = r5.getTypeTable();
        if ((this.d & 2097152) == 2097152) goto L169;
    L171:
        this.f739z = r17;
    L172:
        this.d |= 2097152;
        goto L174
    L169:
        if (this.f739z == ProtoBuf$TypeTable.getDefaultInstance()) goto L171;
        s r18 = ProtoBuf$TypeTable.newBuilder(this.f739z);
        r18.g(r17);
        this.f739z = r18.f();
    L174:
        if (ProtoBuf$Class.access$11100(r5).isEmpty() == true) goto L183;
        if (this.A.isEmpty() == false) goto L179;
        this.A = ProtoBuf$Class.access$11100(r5);
        this.d &= -4194305;
        goto L183
    L179:
        if ((this.d & 4194304) == 4194304) goto L181;
        this.A = new ArrayList(this.A);
        this.d |= 4194304;
    L181:
        this.A.addAll(ProtoBuf$Class.access$11100(r5));
    L183:
        if (r5.hasVersionRequirementTable() == false) goto L191;
        ProtoBuf$VersionRequirementTable r19 = r5.getVersionRequirementTable();
        if ((this.d & 8388608) == 8388608) goto L187;
    L189:
        this.B = r19;
    L190:
        this.d |= 8388608;
        goto L191
    L187:
        if (this.B == ProtoBuf$VersionRequirementTable.getDefaultInstance()) goto L189;
        v r20 = ProtoBuf$VersionRequirementTable.newBuilder(this.B);
        r20.g(r19);
        this.B = r20.f();
    L191:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$Class.access$11400(r5));
        return this;
    }

    public final void k(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Class r11 = null;
        j((ProtoBuf$Class) ProtoBuf$Class.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Class r12 = (ProtoBuf$Class) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
