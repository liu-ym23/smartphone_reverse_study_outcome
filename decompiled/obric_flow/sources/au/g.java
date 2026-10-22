package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$Contract;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends kotlinx.metadata.internal.protobuf.m implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f741c;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$Contract r5 = f();
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
        g((ProtoBuf$Contract) r5);
        return this;
    }

    public final Object clone() {
        g r5 = new g();
        r5.f741c = Collections.emptyList();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$Contract f() {
        ProtoBuf$Contract r5 = new ProtoBuf$Contract(this, null);
        if ((this.f740b & 1) != 1) goto L5;
        this.f741c = Collections.unmodifiableList(this.f741c);
        this.f740b &= -2;
    L5:
        ProtoBuf$Contract.access$23702(r5, this.f741c);
        return r5;
    }

    public final void g(ProtoBuf$Contract r5) {
        if (r5 != ProtoBuf$Contract.getDefaultInstance()) goto L6;
        return;
    L6:
        if (ProtoBuf$Contract.access$23700(r5).isEmpty() == false) goto L8;
    L14:
        this.f19190a = this.f19190a.c(ProtoBuf$Contract.access$23800(r5));
        return;
    L8:
        if (this.f741c.isEmpty() == false) goto L11;
        this.f741c = ProtoBuf$Contract.access$23700(r5);
        this.f740b &= -2;
        goto L14
    L11:
        if ((this.f740b & 1) == 1) goto L13;
        this.f741c = new ArrayList(this.f741c);
        this.f740b |= 1;
    L13:
        this.f741c.addAll(ProtoBuf$Contract.access$23700(r5));
        goto L14
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Contract r11 = null;
        g((ProtoBuf$Contract) ProtoBuf$Contract.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Contract r12 = (ProtoBuf$Contract) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
