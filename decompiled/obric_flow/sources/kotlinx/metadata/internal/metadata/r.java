package kotlinx.metadata.internal.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends kotlinx.metadata.internal.protobuf.m implements kotlinx.metadata.internal.protobuf.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f19138c;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$QualifiedNameTable r5 = f();
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
        g((ProtoBuf$QualifiedNameTable) r5);
        return this;
    }

    public final Object clone() {
        r r5 = new r();
        r5.f19138c = Collections.emptyList();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$QualifiedNameTable f() {
        ProtoBuf$QualifiedNameTable r5 = new ProtoBuf$QualifiedNameTable(this, null);
        if ((this.f19137b & 1) != 1) goto L5;
        this.f19138c = Collections.unmodifiableList(this.f19138c);
        this.f19137b &= -2;
    L5:
        ProtoBuf$QualifiedNameTable.access$1602(r5, this.f19138c);
        return r5;
    }

    public final void g(ProtoBuf$QualifiedNameTable r5) {
        if (r5 != ProtoBuf$QualifiedNameTable.getDefaultInstance()) goto L6;
        return;
    L6:
        if (ProtoBuf$QualifiedNameTable.access$1600(r5).isEmpty() == false) goto L8;
    L14:
        this.f19190a = this.f19190a.c(ProtoBuf$QualifiedNameTable.access$1700(r5));
        return;
    L8:
        if (this.f19138c.isEmpty() == false) goto L11;
        this.f19138c = ProtoBuf$QualifiedNameTable.access$1600(r5);
        this.f19137b &= -2;
        goto L14
    L11:
        if ((this.f19137b & 1) == 1) goto L13;
        this.f19138c = new ArrayList(this.f19138c);
        this.f19137b |= 1;
    L13:
        this.f19138c.addAll(ProtoBuf$QualifiedNameTable.access$1600(r5));
        goto L14
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$QualifiedNameTable r11 = null;
        g((ProtoBuf$QualifiedNameTable) ProtoBuf$QualifiedNameTable.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$QualifiedNameTable r12 = (ProtoBuf$QualifiedNameTable) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
