package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$TypeTable;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends kotlinx.metadata.internal.protobuf.m implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f776c;
    public int d;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$TypeTable r5 = f();
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
        g((ProtoBuf$TypeTable) r5);
        return this;
    }

    public final Object clone() {
        s r5 = new s();
        r5.f776c = Collections.emptyList();
        r5.d = -1;
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$TypeTable f() {
        ProtoBuf$TypeTable r5 = new ProtoBuf$TypeTable(this, null);
        int r10 = this.f775b;
        int r11 = 1;
        if ((r10 & 1) != 1) goto L5;
        this.f776c = Collections.unmodifiableList(this.f776c);
        this.f775b &= -2;
    L5:
        ProtoBuf$TypeTable.access$12802(r5, this.f776c);
        if ((r10 & 2) == 2) goto L9;
        r11 = 0;
    L9:
        ProtoBuf$TypeTable.access$12902(r5, this.d);
        ProtoBuf$TypeTable.access$13002(r5, r11);
        return r5;
    }

    public final void g(ProtoBuf$TypeTable r5) {
        if (r5 != ProtoBuf$TypeTable.getDefaultInstance()) goto L6;
        return;
    L6:
        if (ProtoBuf$TypeTable.access$12800(r5).isEmpty() == true) goto L15;
        if (this.f776c.isEmpty() == false) goto L11;
        this.f776c = ProtoBuf$TypeTable.access$12800(r5);
        this.f775b &= -2;
        goto L15
    L11:
        if ((this.f775b & 1) == 1) goto L13;
        this.f776c = new ArrayList(this.f776c);
        this.f775b |= 1;
    L13:
        this.f776c.addAll(ProtoBuf$TypeTable.access$12800(r5));
    L15:
        if (r5.hasFirstNullable() == false) goto L17;
        int r10 = r5.getFirstNullable();
        this.f775b |= 2;
        this.d = r10;
    L17:
        this.f19190a = this.f19190a.c(ProtoBuf$TypeTable.access$13100(r5));
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$TypeTable r11 = null;
        g((ProtoBuf$TypeTable) ProtoBuf$TypeTable.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$TypeTable r12 = (ProtoBuf$TypeTable) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
