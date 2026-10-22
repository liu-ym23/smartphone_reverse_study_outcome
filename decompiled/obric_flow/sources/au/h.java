package au;

import kotlinx.metadata.internal.metadata.ProtoBuf$EnumEntry;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends kotlinx.metadata.internal.protobuf.n implements i {
    public int d;
    public int e;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$EnumEntry.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$EnumEntry r5 = h();
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
        i((ProtoBuf$EnumEntry) r5);
        return this;
    }

    public final Object clone() {
        h r5 = new h();
        r5.i(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    public final ProtoBuf$EnumEntry h() {
        ProtoBuf$EnumEntry r5 = new ProtoBuf$EnumEntry(this, null);
        int r10 = 1;
        if ((this.d & 1) == 1) goto L6;
        r10 = 0;
    L6:
        ProtoBuf$EnumEntry.access$20602(r5, this.e);
        ProtoBuf$EnumEntry.access$20702(r5, r10);
        return r5;
    }

    public final void i(ProtoBuf$EnumEntry r5) {
        if (r5 != ProtoBuf$EnumEntry.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasName() == false) goto L8;
        int r10 = r5.getName();
        this.d |= 1;
        this.e = r10;
    L8:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$EnumEntry.access$20800(r5));
    }

    public final void j(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$EnumEntry r11 = null;
        i((ProtoBuf$EnumEntry) ProtoBuf$EnumEntry.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$EnumEntry r12 = (ProtoBuf$EnumEntry) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
