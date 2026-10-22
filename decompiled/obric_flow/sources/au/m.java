package au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$Package;
import kotlinx.metadata.internal.metadata.ProtoBuf$PackageFragment;
import kotlinx.metadata.internal.metadata.ProtoBuf$QualifiedNameTable;
import kotlinx.metadata.internal.metadata.ProtoBuf$StringTable;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends kotlinx.metadata.internal.protobuf.n {
    public int d;
    public ProtoBuf$StringTable e;
    public ProtoBuf$QualifiedNameTable f;
    public ProtoBuf$Package g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f755h;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final GeneratedMessageLite a() {
        return ProtoBuf$PackageFragment.getDefaultInstance();
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        ProtoBuf$PackageFragment r5 = h();
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
        i((ProtoBuf$PackageFragment) r5);
        return this;
    }

    public final Object clone() {
        m r5 = new m();
        r5.e = ProtoBuf$StringTable.getDefaultInstance();
        r5.f = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        r5.g = ProtoBuf$Package.getDefaultInstance();
        r5.f755h = Collections.emptyList();
        r5.i(h());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        j(r5, r10);
        return this;
    }

    public final ProtoBuf$PackageFragment h() {
        ProtoBuf$PackageFragment r5 = new ProtoBuf$PackageFragment(this, null);
        int r10 = this.d;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$PackageFragment.access$22802(r5, this.e);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        ProtoBuf$PackageFragment.access$22902(r5, this.f);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        ProtoBuf$PackageFragment.access$23002(r5, this.g);
        if ((this.d & 8) != 8) goto L15;
        this.f755h = Collections.unmodifiableList(this.f755h);
        this.d &= -9;
    L15:
        ProtoBuf$PackageFragment.access$23102(r5, this.f755h);
        ProtoBuf$PackageFragment.access$23202(r5, r11);
        return r5;
    }

    public final void i(ProtoBuf$PackageFragment r5) {
        if (r5 != ProtoBuf$PackageFragment.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasStrings() == false) goto L15;
        ProtoBuf$StringTable r10 = r5.getStrings();
        if ((this.d & 1) == 1) goto L10;
    L12:
        this.e = r10;
    L13:
        this.d |= 1;
        goto L15
    L10:
        if (this.e == ProtoBuf$StringTable.getDefaultInstance()) goto L12;
        p r11 = ProtoBuf$StringTable.newBuilder(this.e);
        r11.g(r10);
        this.e = r11.f();
    L15:
        if (r5.hasQualifiedNames() == false) goto L24;
        ProtoBuf$QualifiedNameTable r12 = r5.getQualifiedNames();
        if ((this.d & 2) == 2) goto L19;
    L21:
        this.f = r12;
    L22:
        this.d |= 2;
        goto L24
    L19:
        if (this.f == ProtoBuf$QualifiedNameTable.getDefaultInstance()) goto L21;
        kotlinx.metadata.internal.metadata.r r13 = ProtoBuf$QualifiedNameTable.newBuilder(this.f);
        r13.g(r12);
        this.f = r13.f();
    L24:
        if (r5.hasPackage() == false) goto L33;
        ProtoBuf$Package r14 = r5.getPackage();
        if ((this.d & 4) == 4) goto L28;
    L30:
        this.g = r14;
    L31:
        this.d |= 4;
        goto L33
    L28:
        if (this.g == ProtoBuf$Package.getDefaultInstance()) goto L30;
        l r15 = ProtoBuf$Package.newBuilder(this.g);
        r15.j(r14);
        this.g = r15.h();
    L33:
        if (ProtoBuf$PackageFragment.access$23100(r5).isEmpty() == false) goto L35;
    L41:
        g(r5);
        this.f19190a = this.f19190a.c(ProtoBuf$PackageFragment.access$23300(r5));
        return;
    L35:
        if (this.f755h.isEmpty() == false) goto L38;
        this.f755h = ProtoBuf$PackageFragment.access$23100(r5);
        this.d &= -9;
        goto L41
    L38:
        if ((this.d & 8) == 8) goto L40;
        this.f755h = new ArrayList(this.f755h);
        this.d |= 8;
    L40:
        this.f755h.addAll(ProtoBuf$PackageFragment.access$23100(r5));
        goto L41
    }

    public final void j(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$PackageFragment r11 = null;
        i((ProtoBuf$PackageFragment) ProtoBuf$PackageFragment.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$PackageFragment r12 = (ProtoBuf$PackageFragment) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
