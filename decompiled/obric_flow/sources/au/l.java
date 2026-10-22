package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$Package;
import kotlinx.metadata.internal.metadata.ProtoBuf$TypeTable;
import kotlinx.metadata.internal.metadata.ProtoBuf$VersionRequirementTable;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends kotlinx.metadata.internal.protobuf.n {
    public int d;
    public List e;
    public List f;
    public List g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProtoBuf$TypeTable f753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ProtoBuf$VersionRequirementTable f754i;

    public static l i() {
        l r5 = new l();
        r5.e = Collections.emptyList();
        r5.f = Collections.emptyList();
        r5.g = Collections.emptyList();
        r5.f753h = ProtoBuf$TypeTable.getDefaultInstance();
        r5.f754i = ProtoBuf$VersionRequirementTable.getDefaultInstance();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$Package.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$Package r5 = h();
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
        j((ProtoBuf$Package) r5);
        return this;
    }

    public final Object clone() {
        l r5 = i();
        r5.j(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    public final ProtoBuf$Package h() {
        ProtoBuf$Package r5 = new ProtoBuf$Package(this, null);
        int r10 = this.d;
        int r11 = 1;
        if ((r10 & 1) != 1) goto L5;
        this.e = Collections.unmodifiableList(this.e);
        this.d &= -2;
    L5:
        ProtoBuf$Package.access$11802(r5, this.e);
        if ((this.d & 2) != 2) goto L8;
        this.f = Collections.unmodifiableList(this.f);
        this.d &= -3;
    L8:
        ProtoBuf$Package.access$11902(r5, this.f);
        if ((this.d & 4) != 4) goto L11;
        this.g = Collections.unmodifiableList(this.g);
        this.d &= -5;
    L11:
        ProtoBuf$Package.access$12002(r5, this.g);
        if ((r10 & 8) == 8) goto L15;
        r11 = 0;
    L15:
        ProtoBuf$Package.access$12102(r5, this.f753h);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 2;
    L18:
        ProtoBuf$Package.access$12202(r5, this.f754i);
        ProtoBuf$Package.access$12302(r5, r11);
        return r5;
    }

    public final void j(ProtoBuf$Package r5) {
        if (r5 != ProtoBuf$Package.getDefaultInstance()) goto L6;
        return;
    L6:
        if (ProtoBuf$Package.access$11800(r5).isEmpty() == true) goto L15;
        if (this.e.isEmpty() == false) goto L11;
        this.e = ProtoBuf$Package.access$11800(r5);
        this.d &= -2;
        goto L15
    L11:
        if ((this.d & 1) == 1) goto L13;
        this.e = new ArrayList(this.e);
        this.d |= 1;
    L13:
        this.e.addAll(ProtoBuf$Package.access$11800(r5));
    L15:
        if (ProtoBuf$Package.access$11900(r5).isEmpty() == true) goto L24;
        if (this.f.isEmpty() == false) goto L20;
        this.f = ProtoBuf$Package.access$11900(r5);
        this.d &= -3;
        goto L24
    L20:
        if ((this.d & 2) == 2) goto L22;
        this.f = new ArrayList(this.f);
        this.d |= 2;
    L22:
        this.f.addAll(ProtoBuf$Package.access$11900(r5));
    L24:
        if (ProtoBuf$Package.access$12000(r5).isEmpty() == true) goto L33;
        if (this.g.isEmpty() == false) goto L29;
        this.g = ProtoBuf$Package.access$12000(r5);
        this.d &= -5;
        goto L33
    L29:
        if ((this.d & 4) == 4) goto L31;
        this.g = new ArrayList(this.g);
        this.d |= 4;
    L31:
        this.g.addAll(ProtoBuf$Package.access$12000(r5));
    L33:
        if (r5.hasTypeTable() == false) goto L42;
        ProtoBuf$TypeTable r10 = r5.getTypeTable();
        if ((this.d & 8) == 8) goto L37;
    L39:
        this.f753h = r10;
    L40:
        this.d |= 8;
        goto L42
    L37:
        if (this.f753h == ProtoBuf$TypeTable.getDefaultInstance()) goto L39;
        s r11 = ProtoBuf$TypeTable.newBuilder(this.f753h);
        r11.g(r10);
        this.f753h = r11.f();
    L42:
        if (r5.hasVersionRequirementTable() == false) goto L50;
        ProtoBuf$VersionRequirementTable r12 = r5.getVersionRequirementTable();
        if ((this.d & 16) == 16) goto L46;
    L48:
        this.f754i = r12;
    L49:
        this.d |= 16;
        goto L50
    L46:
        if (this.f754i == ProtoBuf$VersionRequirementTable.getDefaultInstance()) goto L48;
        v r13 = ProtoBuf$VersionRequirementTable.newBuilder(this.f754i);
        r13.g(r12);
        this.f754i = r13.f();
    L50:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$Package.access$12400(r5));
    }

    public final void k(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Package r11 = null;
        j((ProtoBuf$Package) ProtoBuf$Package.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Package r12 = (ProtoBuf$Package) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
