package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$VersionRequirementTable;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends kotlinx.metadata.internal.protobuf.m implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f781c;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$VersionRequirementTable r5 = f();
        if (r5.isInitialized() == false) goto L6;
        return r5;
    L6:
        throw new UninitializedMessageException(r5);
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ z buildPartial() {
        return f();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m c(GeneratedMessageLite r5) {
        g((ProtoBuf$VersionRequirementTable) r5);
        return this;
    }

    public final Object clone() {
        v r5 = new v();
        r5.f781c = Collections.emptyList();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$VersionRequirementTable f() {
        ProtoBuf$VersionRequirementTable r5 = new ProtoBuf$VersionRequirementTable(this, null);
        if ((this.f780b & 1) != 1) goto L5;
        this.f781c = Collections.unmodifiableList(this.f781c);
        this.f780b &= -2;
    L5:
        ProtoBuf$VersionRequirementTable.access$22302(r5, this.f781c);
        return r5;
    }

    public final void g(ProtoBuf$VersionRequirementTable r5) {
        if (r5 != ProtoBuf$VersionRequirementTable.getDefaultInstance()) goto L6;
        return;
    L6:
        if (ProtoBuf$VersionRequirementTable.access$22300(r5).isEmpty() == false) goto L8;
    L14:
        this.f19190a = this.f19190a.c(ProtoBuf$VersionRequirementTable.access$22400(r5));
        return;
    L8:
        if (this.f781c.isEmpty() == false) goto L11;
        this.f781c = ProtoBuf$VersionRequirementTable.access$22300(r5);
        this.f780b &= -2;
        goto L14
    L11:
        if ((this.f780b & 1) == 1) goto L13;
        this.f781c = new ArrayList(this.f781c);
        this.f780b |= 1;
    L13:
        this.f781c.addAll(ProtoBuf$VersionRequirementTable.access$22300(r5));
        goto L14
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$VersionRequirementTable r11 = null;
        g((ProtoBuf$VersionRequirementTable) ProtoBuf$VersionRequirementTable.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$VersionRequirementTable r12 = (ProtoBuf$VersionRequirementTable) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
