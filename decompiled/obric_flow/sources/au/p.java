package au;

import kotlinx.metadata.internal.metadata.ProtoBuf$StringTable;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends kotlinx.metadata.internal.protobuf.m implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kotlinx.metadata.internal.protobuf.v f768c;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$StringTable r5 = f();
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
        g((ProtoBuf$StringTable) r5);
        return this;
    }

    public final Object clone() {
        p r5 = new p();
        r5.f768c = kotlinx.metadata.internal.protobuf.u.f19207b;
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$StringTable f() {
        ProtoBuf$StringTable r5 = new ProtoBuf$StringTable(this, null);
        if ((this.f767b & 1) != 1) goto L5;
        this.f768c = this.f768c.getUnmodifiableView();
        this.f767b &= -2;
    L5:
        ProtoBuf$StringTable.access$302(r5, this.f768c);
        return r5;
    }

    public final void g(ProtoBuf$StringTable r5) {
        if (r5 != ProtoBuf$StringTable.getDefaultInstance()) goto L6;
        return;
    L6:
        if (ProtoBuf$StringTable.access$300(r5).isEmpty() == false) goto L8;
    L14:
        this.f19190a = this.f19190a.c(ProtoBuf$StringTable.access$400(r5));
        return;
    L8:
        if (this.f768c.isEmpty() == false) goto L11;
        this.f768c = ProtoBuf$StringTable.access$300(r5);
        this.f767b &= -2;
        goto L14
    L11:
        if ((this.f767b & 1) == 1) goto L13;
        this.f768c = new kotlinx.metadata.internal.protobuf.u(this.f768c);
        this.f767b |= 1;
    L13:
        this.f768c.addAll(ProtoBuf$StringTable.access$300(r5));
        goto L14
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$StringTable r11 = null;
        g((ProtoBuf$StringTable) ProtoBuf$StringTable.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$StringTable r12 = (ProtoBuf$StringTable) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
