package kotlinx.metadata.internal.metadata;

import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends kotlinx.metadata.internal.protobuf.m implements i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19113c;
    public int d;
    public ProtoBuf$VersionRequirement.Level e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProtoBuf$VersionRequirement.VersionKind f19114h;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$VersionRequirement r5 = f();
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
        g((ProtoBuf$VersionRequirement) r5);
        return this;
    }

    public final Object clone() {
        f0 r5 = new f0();
        r5.e = ProtoBuf$VersionRequirement.Level.ERROR;
        r5.f19114h = ProtoBuf$VersionRequirement.VersionKind.LANGUAGE_VERSION;
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$VersionRequirement f() {
        ProtoBuf$VersionRequirement r5 = new ProtoBuf$VersionRequirement(this, null);
        int r10 = this.f19112b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$VersionRequirement.access$21202(r5, this.f19113c);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$VersionRequirement.access$21302(r5, this.d);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$VersionRequirement.access$21402(r5, this.e);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 8;
    L15:
        ProtoBuf$VersionRequirement.access$21502(r5, this.f);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 16;
    L18:
        ProtoBuf$VersionRequirement.access$21602(r5, this.g);
        if ((r10 & 32) != 32) goto L21;
        r11 = r11 | 32;
    L21:
        ProtoBuf$VersionRequirement.access$21702(r5, this.f19114h);
        ProtoBuf$VersionRequirement.access$21802(r5, r11);
        return r5;
    }

    public final void g(ProtoBuf$VersionRequirement r5) {
        if (r5 != ProtoBuf$VersionRequirement.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasVersion() == false) goto L9;
        int r10 = r5.getVersion();
        this.f19112b |= 1;
        this.f19113c = r10;
    L9:
        if (r5.hasVersionFull() == false) goto L12;
        int r11 = r5.getVersionFull();
        this.f19112b |= 2;
        this.d = r11;
    L12:
        if (r5.hasLevel() == false) goto L15;
        ProtoBuf$VersionRequirement.Level r12 = r5.getLevel();
        r12.getClass();
        this.f19112b |= 4;
        this.e = r12;
    L15:
        if (r5.hasErrorCode() == false) goto L18;
        int r13 = r5.getErrorCode();
        this.f19112b |= 8;
        this.f = r13;
    L18:
        if (r5.hasMessage() == false) goto L21;
        int r14 = r5.getMessage();
        this.f19112b |= 16;
        this.g = r14;
    L21:
        if (r5.hasVersionKind() == false) goto L23;
        ProtoBuf$VersionRequirement.VersionKind r15 = r5.getVersionKind();
        r15.getClass();
        this.f19112b |= 32;
        this.f19114h = r15;
    L23:
        this.f19190a = this.f19190a.c(ProtoBuf$VersionRequirement.access$21900(r5));
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$VersionRequirement r11 = null;
        g((ProtoBuf$VersionRequirement) ProtoBuf$VersionRequirement.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$VersionRequirement r12 = (ProtoBuf$VersionRequirement) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
