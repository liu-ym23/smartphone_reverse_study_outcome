package bu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf$PackageParts;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.p0;
import kotlinx.metadata.internal.protobuf.u;
import kotlinx.metadata.internal.protobuf.v;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends m implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f989c;
    public v d;
    public List e;
    public v f;
    public v g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f990h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f991i;

    public static c g() {
        c r5 = new c();
        r5.f989c = "";
        p0 r10 = u.f19207b;
        r5.d = r10;
        r5.e = Collections.emptyList();
        r5.f = r10;
        r5.g = r10;
        r5.f990h = Collections.emptyList();
        r5.f991i = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        i(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        JvmModuleProtoBuf$PackageParts r5 = f();
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
    public final /* bridge */ /* synthetic */ m c(GeneratedMessageLite r5) {
        h((JvmModuleProtoBuf$PackageParts) r5);
        return this;
    }

    public final Object clone() {
        c r5 = g();
        r5.h(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        i(r5, r10);
        return this;
    }

    public final JvmModuleProtoBuf$PackageParts f() {
        JvmModuleProtoBuf$PackageParts r5 = new JvmModuleProtoBuf$PackageParts(this, null);
        int r10 = 1;
        if ((this.f988b & 1) == 1) goto L6;
        r10 = 0;
    L6:
        JvmModuleProtoBuf$PackageParts.access$1502(r5, this.f989c);
        if ((this.f988b & 2) != 2) goto L9;
        this.d = this.d.getUnmodifiableView();
        this.f988b &= -3;
    L9:
        JvmModuleProtoBuf$PackageParts.access$1602(r5, this.d);
        if ((this.f988b & 4) != 4) goto L12;
        this.e = Collections.unmodifiableList(this.e);
        this.f988b &= -5;
    L12:
        JvmModuleProtoBuf$PackageParts.access$1702(r5, this.e);
        if ((this.f988b & 8) != 8) goto L15;
        this.f = this.f.getUnmodifiableView();
        this.f988b &= -9;
    L15:
        JvmModuleProtoBuf$PackageParts.access$1802(r5, this.f);
        if ((this.f988b & 16) != 16) goto L18;
        this.g = this.g.getUnmodifiableView();
        this.f988b &= -17;
    L18:
        JvmModuleProtoBuf$PackageParts.access$1902(r5, this.g);
        if ((this.f988b & 32) != 32) goto L21;
        this.f990h = Collections.unmodifiableList(this.f990h);
        this.f988b &= -33;
    L21:
        JvmModuleProtoBuf$PackageParts.access$2002(r5, this.f990h);
        if ((this.f988b & 64) != 64) goto L24;
        this.f991i = Collections.unmodifiableList(this.f991i);
        this.f988b &= -65;
    L24:
        JvmModuleProtoBuf$PackageParts.access$2102(r5, this.f991i);
        JvmModuleProtoBuf$PackageParts.access$2202(r5, r10);
        return r5;
    }

    public final void h(JvmModuleProtoBuf$PackageParts r5) {
        if (r5 != JvmModuleProtoBuf$PackageParts.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasPackageFqName() == false) goto L9;
        this.f988b |= 1;
        this.f989c = JvmModuleProtoBuf$PackageParts.access$1500(r5);
    L9:
        if (JvmModuleProtoBuf$PackageParts.access$1600(r5).isEmpty() == true) goto L18;
        if (this.d.isEmpty() == false) goto L14;
        this.d = JvmModuleProtoBuf$PackageParts.access$1600(r5);
        this.f988b &= -3;
        goto L18
    L14:
        if ((this.f988b & 2) == 2) goto L16;
        this.d = new u(this.d);
        this.f988b |= 2;
    L16:
        this.d.addAll(JvmModuleProtoBuf$PackageParts.access$1600(r5));
    L18:
        if (JvmModuleProtoBuf$PackageParts.access$1700(r5).isEmpty() == true) goto L27;
        if (this.e.isEmpty() == false) goto L23;
        this.e = JvmModuleProtoBuf$PackageParts.access$1700(r5);
        this.f988b &= -5;
        goto L27
    L23:
        if ((this.f988b & 4) == 4) goto L25;
        this.e = new ArrayList(this.e);
        this.f988b |= 4;
    L25:
        this.e.addAll(JvmModuleProtoBuf$PackageParts.access$1700(r5));
    L27:
        if (JvmModuleProtoBuf$PackageParts.access$1800(r5).isEmpty() == true) goto L36;
        if (this.f.isEmpty() == false) goto L32;
        this.f = JvmModuleProtoBuf$PackageParts.access$1800(r5);
        this.f988b &= -9;
        goto L36
    L32:
        if ((this.f988b & 8) == 8) goto L34;
        this.f = new u(this.f);
        this.f988b |= 8;
    L34:
        this.f.addAll(JvmModuleProtoBuf$PackageParts.access$1800(r5));
    L36:
        if (JvmModuleProtoBuf$PackageParts.access$1900(r5).isEmpty() == true) goto L45;
        if (this.g.isEmpty() == false) goto L41;
        this.g = JvmModuleProtoBuf$PackageParts.access$1900(r5);
        this.f988b &= -17;
        goto L45
    L41:
        if ((this.f988b & 16) == 16) goto L43;
        this.g = new u(this.g);
        this.f988b |= 16;
    L43:
        this.g.addAll(JvmModuleProtoBuf$PackageParts.access$1900(r5));
    L45:
        if (JvmModuleProtoBuf$PackageParts.access$2000(r5).isEmpty() == true) goto L54;
        if (this.f990h.isEmpty() == false) goto L50;
        this.f990h = JvmModuleProtoBuf$PackageParts.access$2000(r5);
        this.f988b &= -33;
        goto L54
    L50:
        if ((this.f988b & 32) == 32) goto L52;
        this.f990h = new ArrayList(this.f990h);
        this.f988b |= 32;
    L52:
        this.f990h.addAll(JvmModuleProtoBuf$PackageParts.access$2000(r5));
    L54:
        if (JvmModuleProtoBuf$PackageParts.access$2100(r5).isEmpty() == false) goto L56;
    L62:
        this.f19190a = this.f19190a.c(JvmModuleProtoBuf$PackageParts.access$2300(r5));
        return;
    L56:
        if (this.f991i.isEmpty() == false) goto L59;
        this.f991i = JvmModuleProtoBuf$PackageParts.access$2100(r5);
        this.f988b &= -65;
        goto L62
    L59:
        if ((this.f988b & 64) == 64) goto L61;
        this.f991i = new ArrayList(this.f991i);
        this.f988b |= 64;
    L61:
        this.f991i.addAll(JvmModuleProtoBuf$PackageParts.access$2100(r5));
        goto L62
    }

    public final void i(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        JvmModuleProtoBuf$PackageParts r11 = null;
        h((JvmModuleProtoBuf$PackageParts) JvmModuleProtoBuf$PackageParts.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        JvmModuleProtoBuf$PackageParts r12 = (JvmModuleProtoBuf$PackageParts) e.getUnfinishedMessage();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L11
    L11:
        th = th;
        r11 = r12;
    L13:
        if (r11 == null) goto L15;
        h(r11);
    L15:
        throw th;
    L6:
        th = th;
        goto L13
    }
}
