package kotlinx.metadata.internal.metadata;

import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends kotlinx.metadata.internal.protobuf.m implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19140c;
    public int d;
    public ProtoBuf$QualifiedNameTable.QualifiedName.Kind e;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$QualifiedNameTable.QualifiedName r5 = f();
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
        g((ProtoBuf$QualifiedNameTable.QualifiedName) r5);
        return this;
    }

    public final Object clone() {
        t r5 = new t();
        r5.f19140c = -1;
        r5.e = ProtoBuf$QualifiedNameTable.QualifiedName.Kind.PACKAGE;
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$QualifiedNameTable.QualifiedName f() {
        ProtoBuf$QualifiedNameTable.QualifiedName r5 = new ProtoBuf$QualifiedNameTable.QualifiedName(this, null);
        int r10 = this.f19139b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$QualifiedNameTable.QualifiedName.access$902(r5, this.f19140c);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$QualifiedNameTable.QualifiedName.access$1002(r5, this.d);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$QualifiedNameTable.QualifiedName.access$1102(r5, this.e);
        ProtoBuf$QualifiedNameTable.QualifiedName.access$1202(r5, r11);
        return r5;
    }

    public final void g(ProtoBuf$QualifiedNameTable.QualifiedName r5) {
        if (r5 != ProtoBuf$QualifiedNameTable.QualifiedName.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasParentQualifiedName() == false) goto L9;
        int r10 = r5.getParentQualifiedName();
        this.f19139b |= 1;
        this.f19140c = r10;
    L9:
        if (r5.hasShortName() == false) goto L12;
        int r11 = r5.getShortName();
        this.f19139b |= 2;
        this.d = r11;
    L12:
        if (r5.hasKind() == false) goto L14;
        ProtoBuf$QualifiedNameTable.QualifiedName.Kind r12 = r5.getKind();
        r12.getClass();
        this.f19139b |= 4;
        this.e = r12;
    L14:
        this.f19190a = this.f19190a.c(ProtoBuf$QualifiedNameTable.QualifiedName.access$1300(r5));
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$QualifiedNameTable.QualifiedName r11 = null;
        g((ProtoBuf$QualifiedNameTable.QualifiedName) ProtoBuf$QualifiedNameTable.QualifiedName.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$QualifiedNameTable.QualifiedName r12 = (ProtoBuf$QualifiedNameTable.QualifiedName) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
