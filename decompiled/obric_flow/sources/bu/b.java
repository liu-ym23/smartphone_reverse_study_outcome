package bu;

import au.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$QualifiedNameTable;
import kotlinx.metadata.internal.metadata.ProtoBuf$StringTable;
import kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf$Module;
import kotlinx.metadata.internal.metadata.r;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.u;
import kotlinx.metadata.internal.protobuf.v;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends m implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f985c;
    public List d;
    public v e;
    public ProtoBuf$StringTable f;
    public ProtoBuf$QualifiedNameTable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f987i;

    public static b g() {
        b r5 = new b();
        r5.f985c = Collections.emptyList();
        r5.d = Collections.emptyList();
        r5.e = u.f19207b;
        r5.f = ProtoBuf$StringTable.getDefaultInstance();
        r5.g = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        r5.f986h = Collections.emptyList();
        r5.f987i = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        i(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        JvmModuleProtoBuf$Module r5 = f();
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
        h((JvmModuleProtoBuf$Module) r5);
        return this;
    }

    public final Object clone() {
        b r5 = g();
        r5.h(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        i(r5, r10);
        return this;
    }

    public final JvmModuleProtoBuf$Module f() {
        JvmModuleProtoBuf$Module r5 = new JvmModuleProtoBuf$Module(this, null);
        int r10 = this.f984b;
        int r11 = 1;
        if ((r10 & 1) != 1) goto L5;
        this.f985c = Collections.unmodifiableList(this.f985c);
        this.f984b &= -2;
    L5:
        JvmModuleProtoBuf$Module.access$302(r5, this.f985c);
        if ((this.f984b & 2) != 2) goto L8;
        this.d = Collections.unmodifiableList(this.d);
        this.f984b &= -3;
    L8:
        JvmModuleProtoBuf$Module.access$402(r5, this.d);
        if ((this.f984b & 4) != 4) goto L11;
        this.e = this.e.getUnmodifiableView();
        this.f984b &= -5;
    L11:
        JvmModuleProtoBuf$Module.access$502(r5, this.e);
        if ((r10 & 8) == 8) goto L15;
        r11 = 0;
    L15:
        JvmModuleProtoBuf$Module.access$602(r5, this.f);
        if ((r10 & 16) != 16) goto L18;
        r11 = r11 | 2;
    L18:
        JvmModuleProtoBuf$Module.access$702(r5, this.g);
        if ((this.f984b & 32) != 32) goto L21;
        this.f986h = Collections.unmodifiableList(this.f986h);
        this.f984b &= -33;
    L21:
        JvmModuleProtoBuf$Module.access$802(r5, this.f986h);
        if ((this.f984b & 64) != 64) goto L24;
        this.f987i = Collections.unmodifiableList(this.f987i);
        this.f984b &= -65;
    L24:
        JvmModuleProtoBuf$Module.access$902(r5, this.f987i);
        JvmModuleProtoBuf$Module.access$1002(r5, r11);
        return r5;
    }

    public final void h(JvmModuleProtoBuf$Module r5) {
        if (r5 != JvmModuleProtoBuf$Module.getDefaultInstance()) goto L6;
        return;
    L6:
        if (JvmModuleProtoBuf$Module.access$300(r5).isEmpty() == true) goto L15;
        if (this.f985c.isEmpty() == false) goto L11;
        this.f985c = JvmModuleProtoBuf$Module.access$300(r5);
        this.f984b &= -2;
        goto L15
    L11:
        if ((this.f984b & 1) == 1) goto L13;
        this.f985c = new ArrayList(this.f985c);
        this.f984b |= 1;
    L13:
        this.f985c.addAll(JvmModuleProtoBuf$Module.access$300(r5));
    L15:
        if (JvmModuleProtoBuf$Module.access$400(r5).isEmpty() == true) goto L24;
        if (this.d.isEmpty() == false) goto L20;
        this.d = JvmModuleProtoBuf$Module.access$400(r5);
        this.f984b &= -3;
        goto L24
    L20:
        if ((this.f984b & 2) == 2) goto L22;
        this.d = new ArrayList(this.d);
        this.f984b |= 2;
    L22:
        this.d.addAll(JvmModuleProtoBuf$Module.access$400(r5));
    L24:
        if (JvmModuleProtoBuf$Module.access$500(r5).isEmpty() == true) goto L33;
        if (this.e.isEmpty() == false) goto L29;
        this.e = JvmModuleProtoBuf$Module.access$500(r5);
        this.f984b &= -5;
        goto L33
    L29:
        if ((this.f984b & 4) == 4) goto L31;
        this.e = new u(this.e);
        this.f984b |= 4;
    L31:
        this.e.addAll(JvmModuleProtoBuf$Module.access$500(r5));
    L33:
        if (r5.hasStringTable() == false) goto L42;
        ProtoBuf$StringTable r10 = r5.getStringTable();
        if ((this.f984b & 8) == 8) goto L37;
    L39:
        this.f = r10;
    L40:
        this.f984b |= 8;
        goto L42
    L37:
        if (this.f == ProtoBuf$StringTable.getDefaultInstance()) goto L39;
        p r11 = ProtoBuf$StringTable.newBuilder(this.f);
        r11.g(r10);
        this.f = r11.f();
    L42:
        if (r5.hasQualifiedNameTable() == false) goto L51;
        ProtoBuf$QualifiedNameTable r12 = r5.getQualifiedNameTable();
        if ((this.f984b & 16) == 16) goto L46;
    L48:
        this.g = r12;
    L49:
        this.f984b |= 16;
        goto L51
    L46:
        if (this.g == ProtoBuf$QualifiedNameTable.getDefaultInstance()) goto L48;
        r r13 = ProtoBuf$QualifiedNameTable.newBuilder(this.g);
        r13.g(r12);
        this.g = r13.f();
    L51:
        if (JvmModuleProtoBuf$Module.access$800(r5).isEmpty() == true) goto L60;
        if (this.f986h.isEmpty() == false) goto L56;
        this.f986h = JvmModuleProtoBuf$Module.access$800(r5);
        this.f984b &= -33;
        goto L60
    L56:
        if ((this.f984b & 32) == 32) goto L58;
        this.f986h = new ArrayList(this.f986h);
        this.f984b |= 32;
    L58:
        this.f986h.addAll(JvmModuleProtoBuf$Module.access$800(r5));
    L60:
        if (JvmModuleProtoBuf$Module.access$900(r5).isEmpty() == false) goto L62;
    L68:
        this.f19190a = this.f19190a.c(JvmModuleProtoBuf$Module.access$1100(r5));
        return;
    L62:
        if (this.f987i.isEmpty() == false) goto L65;
        this.f987i = JvmModuleProtoBuf$Module.access$900(r5);
        this.f984b &= -65;
        goto L68
    L65:
        if ((this.f984b & 64) == 64) goto L67;
        this.f987i = new ArrayList(this.f987i);
        this.f984b |= 64;
    L67:
        this.f987i.addAll(JvmModuleProtoBuf$Module.access$900(r5));
        goto L68
    }

    public final void i(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        JvmModuleProtoBuf$Module r11 = null;
        h((JvmModuleProtoBuf$Module) JvmModuleProtoBuf$Module.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        JvmModuleProtoBuf$Module r12 = (JvmModuleProtoBuf$Module) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
