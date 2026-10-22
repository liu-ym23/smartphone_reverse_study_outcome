package kotlinx.metadata.internal.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends kotlinx.metadata.internal.protobuf.n implements e0 {
    public int d;
    public int e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProtoBuf$TypeParameter.Variance f19101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f19102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f19103j;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$TypeParameter.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$TypeParameter r5 = h();
        if (r5.isInitialized() == false) goto L6;
        return r5;
    L6:
        throw new UninitializedMessageException(r5);
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z buildPartial() {
        return h();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m c(GeneratedMessageLite r5) {
        i((ProtoBuf$TypeParameter) r5);
        return this;
    }

    public final Object clone() {
        c0 r5 = new c0();
        r5.f19101h = ProtoBuf$TypeParameter.Variance.INV;
        r5.f19102i = Collections.emptyList();
        r5.f19103j = Collections.emptyList();
        r5.i(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    public final ProtoBuf$TypeParameter h() {
        ProtoBuf$TypeParameter r5 = new ProtoBuf$TypeParameter(this, null);
        int r10 = this.d;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$TypeParameter.access$7802(r5, this.e);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$TypeParameter.access$7902(r5, this.f);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$TypeParameter.access$8002(r5, this.g);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 8;
    L15:
        ProtoBuf$TypeParameter.access$8102(r5, this.f19101h);
        if ((this.d & 16) != 16) goto L18;
        this.f19102i = Collections.unmodifiableList(this.f19102i);
        this.d &= -17;
    L18:
        ProtoBuf$TypeParameter.access$8202(r5, this.f19102i);
        if ((this.d & 32) != 32) goto L21;
        this.f19103j = Collections.unmodifiableList(this.f19103j);
        this.d &= -33;
    L21:
        ProtoBuf$TypeParameter.access$8302(r5, this.f19103j);
        ProtoBuf$TypeParameter.access$8402(r5, r11);
        return r5;
    }

    public final void i(ProtoBuf$TypeParameter r5) {
        if (r5 != ProtoBuf$TypeParameter.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasId() == false) goto L9;
        int r10 = r5.getId();
        this.d |= 1;
        this.e = r10;
    L9:
        if (r5.hasName() == false) goto L12;
        int r11 = r5.getName();
        this.d |= 2;
        this.f = r11;
    L12:
        if (r5.hasReified() == false) goto L15;
        boolean r12 = r5.getReified();
        this.d |= 4;
        this.g = r12;
    L15:
        if (r5.hasVariance() == false) goto L18;
        ProtoBuf$TypeParameter.Variance r13 = r5.getVariance();
        r13.getClass();
        this.d |= 8;
        this.f19101h = r13;
    L18:
        if (ProtoBuf$TypeParameter.access$8200(r5).isEmpty() == true) goto L27;
        if (this.f19102i.isEmpty() == false) goto L23;
        this.f19102i = ProtoBuf$TypeParameter.access$8200(r5);
        this.d &= -17;
        goto L27
    L23:
        if ((this.d & 16) == 16) goto L25;
        this.f19102i = new ArrayList(this.f19102i);
        this.d |= 16;
    L25:
        this.f19102i.addAll(ProtoBuf$TypeParameter.access$8200(r5));
    L27:
        if (ProtoBuf$TypeParameter.access$8300(r5).isEmpty() == false) goto L29;
    L35:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$TypeParameter.access$8500(r5));
        return;
    L29:
        if (this.f19103j.isEmpty() == false) goto L32;
        this.f19103j = ProtoBuf$TypeParameter.access$8300(r5);
        this.d &= -33;
        goto L35
    L32:
        if ((this.d & 32) == 32) goto L34;
        this.f19103j = new ArrayList(this.f19103j);
        this.d |= 32;
    L34:
        this.f19103j.addAll(ProtoBuf$TypeParameter.access$8300(r5));
        goto L35
    }

    public final void j(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$TypeParameter r11 = null;
        i((ProtoBuf$TypeParameter) ProtoBuf$TypeParameter.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$TypeParameter r12 = (ProtoBuf$TypeParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
