package kotlinx.metadata.internal.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends kotlinx.metadata.internal.protobuf.m implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19116c;
    public List d;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$Annotation r5 = f();
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
        g((ProtoBuf$Annotation) r5);
        return this;
    }

    public final Object clone() {
        h r5 = new h();
        r5.d = Collections.emptyList();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$Annotation f() {
        ProtoBuf$Annotation r5 = new ProtoBuf$Annotation(this, null);
        int r10 = 1;
        if ((this.f19115b & 1) == 1) goto L6;
        r10 = 0;
    L6:
        ProtoBuf$Annotation.access$4402(r5, this.f19116c);
        if ((this.f19115b & 2) != 2) goto L9;
        this.d = Collections.unmodifiableList(this.d);
        this.f19115b &= -3;
    L9:
        ProtoBuf$Annotation.access$4502(r5, this.d);
        ProtoBuf$Annotation.access$4602(r5, r10);
        return r5;
    }

    public final void g(ProtoBuf$Annotation r5) {
        if (r5 != ProtoBuf$Annotation.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasId() == false) goto L9;
        int r10 = r5.getId();
        this.f19115b |= 1;
        this.f19116c = r10;
    L9:
        if (ProtoBuf$Annotation.access$4500(r5).isEmpty() == false) goto L11;
    L17:
        this.f19190a = this.f19190a.c(ProtoBuf$Annotation.access$4700(r5));
        return;
    L11:
        if (this.d.isEmpty() == false) goto L14;
        this.d = ProtoBuf$Annotation.access$4500(r5);
        this.f19115b &= -3;
        goto L17
    L14:
        if ((this.f19115b & 2) == 2) goto L16;
        this.d = new ArrayList(this.d);
        this.f19115b |= 2;
    L16:
        this.d.addAll(ProtoBuf$Annotation.access$4500(r5));
        goto L17
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Annotation r11 = null;
        g((ProtoBuf$Annotation) ProtoBuf$Annotation.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Annotation r12 = (ProtoBuf$Annotation) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
