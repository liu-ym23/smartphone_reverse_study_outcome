package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$Constructor;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends kotlinx.metadata.internal.protobuf.n implements f {
    public int d;
    public int e;
    public List f;
    public List g;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$Constructor.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$Constructor r5 = h();
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
        i((ProtoBuf$Constructor) r5);
        return this;
    }

    public final Object clone() {
        e r5 = new e();
        r5.e = 6;
        r5.f = Collections.emptyList();
        r5.g = Collections.emptyList();
        r5.i(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    public final ProtoBuf$Constructor h() {
        ProtoBuf$Constructor r5 = new ProtoBuf$Constructor(this, null);
        int r10 = 1;
        if ((this.d & 1) == 1) goto L6;
        r10 = 0;
    L6:
        ProtoBuf$Constructor.access$13502(r5, this.e);
        if ((this.d & 2) != 2) goto L9;
        this.f = Collections.unmodifiableList(this.f);
        this.d &= -3;
    L9:
        ProtoBuf$Constructor.access$13602(r5, this.f);
        if ((this.d & 4) != 4) goto L12;
        this.g = Collections.unmodifiableList(this.g);
        this.d &= -5;
    L12:
        ProtoBuf$Constructor.access$13702(r5, this.g);
        ProtoBuf$Constructor.access$13802(r5, r10);
        return r5;
    }

    public final void i(ProtoBuf$Constructor r5) {
        if (r5 != ProtoBuf$Constructor.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasFlags() == false) goto L9;
        int r10 = r5.getFlags();
        this.d |= 1;
        this.e = r10;
    L9:
        if (ProtoBuf$Constructor.access$13600(r5).isEmpty() == true) goto L18;
        if (this.f.isEmpty() == false) goto L14;
        this.f = ProtoBuf$Constructor.access$13600(r5);
        this.d &= -3;
        goto L18
    L14:
        if ((this.d & 2) == 2) goto L16;
        this.f = new ArrayList(this.f);
        this.d |= 2;
    L16:
        this.f.addAll(ProtoBuf$Constructor.access$13600(r5));
    L18:
        if (ProtoBuf$Constructor.access$13700(r5).isEmpty() == false) goto L20;
    L26:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$Constructor.access$13900(r5));
        return;
    L20:
        if (this.g.isEmpty() == false) goto L23;
        this.g = ProtoBuf$Constructor.access$13700(r5);
        this.d &= -5;
        goto L26
    L23:
        if ((this.d & 4) == 4) goto L25;
        this.g = new ArrayList(this.g);
        this.d |= 4;
    L25:
        this.g.addAll(ProtoBuf$Constructor.access$13700(r5));
        goto L26
    }

    public final void j(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Constructor r11 = null;
        i((ProtoBuf$Constructor) ProtoBuf$Constructor.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Constructor r12 = (ProtoBuf$Constructor) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
