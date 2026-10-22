package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$Type;
import kotlinx.metadata.internal.metadata.ProtoBuf$TypeAlias;
import kotlinx.metadata.internal.metadata.a0;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends kotlinx.metadata.internal.protobuf.n implements r {
    public int d;
    public int e;
    public int f;
    public List g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProtoBuf$Type f769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ProtoBuf$Type f771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f772k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f774m;

    public static q i() {
        q r5 = new q();
        r5.e = 6;
        r5.g = Collections.emptyList();
        r5.f769h = ProtoBuf$Type.getDefaultInstance();
        r5.f771j = ProtoBuf$Type.getDefaultInstance();
        r5.f773l = Collections.emptyList();
        r5.f774m = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$TypeAlias.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$TypeAlias r5 = h();
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
        j((ProtoBuf$TypeAlias) r5);
        return this;
    }

    public final Object clone() {
        q r5 = i();
        r5.j(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        k(r5, r10);
        return this;
    }

    public final ProtoBuf$TypeAlias h() {
        ProtoBuf$TypeAlias r5 = new ProtoBuf$TypeAlias(this, null);
        int r10 = this.d;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$TypeAlias.access$19202(r5, this.e);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$TypeAlias.access$19302(r5, this.f);
        if ((this.d & 4) != 4) goto L12;
        this.g = Collections.unmodifiableList(this.g);
        this.d &= -5;
    L12:
        ProtoBuf$TypeAlias.access$19402(r5, this.g);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 4;
    L15:
        ProtoBuf$TypeAlias.access$19502(r5, this.f769h);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 8;
    L18:
        ProtoBuf$TypeAlias.access$19602(r5, this.f770i);
        if ((r10 & 32) != 32) goto L21;
        r11 = r11 | 16;
    L21:
        ProtoBuf$TypeAlias.access$19702(r5, this.f771j);
        if ((r10 & 64) != 64) goto L24;
        r11 = r11 | 32;
    L24:
        ProtoBuf$TypeAlias.access$19802(r5, this.f772k);
        if ((this.d & 128) != 128) goto L27;
        this.f773l = Collections.unmodifiableList(this.f773l);
        this.d &= -129;
    L27:
        ProtoBuf$TypeAlias.access$19902(r5, this.f773l);
        if ((this.d & 256) != 256) goto L30;
        this.f774m = Collections.unmodifiableList(this.f774m);
        this.d &= -257;
    L30:
        ProtoBuf$TypeAlias.access$20002(r5, this.f774m);
        ProtoBuf$TypeAlias.access$20102(r5, r11);
        return r5;
    }

    public final void j(ProtoBuf$TypeAlias r5) {
        if (r5 != ProtoBuf$TypeAlias.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasFlags() == false) goto L9;
        int r10 = r5.getFlags();
        this.d |= 1;
        this.e = r10;
    L9:
        if (r5.hasName() == false) goto L12;
        int r11 = r5.getName();
        this.d |= 2;
        this.f = r11;
    L12:
        if (ProtoBuf$TypeAlias.access$19400(r5).isEmpty() == true) goto L21;
        if (this.g.isEmpty() == false) goto L17;
        this.g = ProtoBuf$TypeAlias.access$19400(r5);
        this.d &= -5;
        goto L21
    L17:
        if ((this.d & 4) == 4) goto L19;
        this.g = new ArrayList(this.g);
        this.d |= 4;
    L19:
        this.g.addAll(ProtoBuf$TypeAlias.access$19400(r5));
    L21:
        if (r5.hasUnderlyingType() == false) goto L30;
        ProtoBuf$Type r12 = r5.getUnderlyingType();
        if ((this.d & 8) == 8) goto L25;
    L27:
        this.f769h = r12;
    L28:
        this.d |= 8;
        goto L30
    L25:
        if (this.f769h == ProtoBuf$Type.getDefaultInstance()) goto L27;
        a0 r13 = ProtoBuf$Type.newBuilder(this.f769h);
        r13.i(r12);
        this.f769h = r13.h();
    L30:
        if (r5.hasUnderlyingTypeId() == false) goto L33;
        int r14 = r5.getUnderlyingTypeId();
        this.d |= 16;
        this.f770i = r14;
    L33:
        if (r5.hasExpandedType() == false) goto L42;
        ProtoBuf$Type r15 = r5.getExpandedType();
        if ((this.d & 32) == 32) goto L37;
    L39:
        this.f771j = r15;
    L40:
        this.d |= 32;
        goto L42
    L37:
        if (this.f771j == ProtoBuf$Type.getDefaultInstance()) goto L39;
        a0 r16 = ProtoBuf$Type.newBuilder(this.f771j);
        r16.i(r15);
        this.f771j = r16.h();
    L42:
        if (r5.hasExpandedTypeId() == false) goto L45;
        int r17 = r5.getExpandedTypeId();
        this.d |= 64;
        this.f772k = r17;
    L45:
        if (ProtoBuf$TypeAlias.access$19900(r5).isEmpty() == true) goto L54;
        if (this.f773l.isEmpty() == false) goto L50;
        this.f773l = ProtoBuf$TypeAlias.access$19900(r5);
        this.d &= -129;
        goto L54
    L50:
        if ((this.d & 128) == 128) goto L52;
        this.f773l = new ArrayList(this.f773l);
        this.d |= 128;
    L52:
        this.f773l.addAll(ProtoBuf$TypeAlias.access$19900(r5));
    L54:
        if (ProtoBuf$TypeAlias.access$20000(r5).isEmpty() == false) goto L56;
    L62:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$TypeAlias.access$20200(r5));
        return;
    L56:
        if (this.f774m.isEmpty() == false) goto L59;
        this.f774m = ProtoBuf$TypeAlias.access$20000(r5);
        this.d &= -257;
        goto L62
    L59:
        if ((this.d & 256) == 256) goto L61;
        this.f774m = new ArrayList(this.f774m);
        this.d |= 256;
    L61:
        this.f774m.addAll(ProtoBuf$TypeAlias.access$20000(r5));
        goto L62
    }

    public final void k(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$TypeAlias r11 = null;
        j((ProtoBuf$TypeAlias) ProtoBuf$TypeAlias.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$TypeAlias r12 = (ProtoBuf$TypeAlias) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
