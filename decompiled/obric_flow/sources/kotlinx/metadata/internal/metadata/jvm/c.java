package kotlinx.metadata.internal.metadata.jvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.f;
import kotlinx.metadata.internal.protobuf.i;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends m implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19129c;
    public int d;
    public Object e;
    public JvmProtoBuf$StringTableTypes.Record.Operation f;
    public List g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f19130h;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ m b(f r5, i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        JvmProtoBuf$StringTableTypes.Record r5 = f();
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
        g((JvmProtoBuf$StringTableTypes.Record) r5);
        return this;
    }

    public final Object clone() {
        c r5 = new c();
        r5.f19129c = 1;
        r5.e = "";
        r5.f = JvmProtoBuf$StringTableTypes.Record.Operation.NONE;
        r5.g = Collections.emptyList();
        r5.f19130h = Collections.emptyList();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(f r5, i r10) {
        h(r5, r10);
        return this;
    }

    public final JvmProtoBuf$StringTableTypes.Record f() {
        JvmProtoBuf$StringTableTypes.Record r5 = new JvmProtoBuf$StringTableTypes.Record(this, null);
        int r10 = this.f19128b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        JvmProtoBuf$StringTableTypes.Record.access$402(r5, this.f19129c);
        if ((r10 & 2) != 2) goto L9;
        r11 = r11 | 2;
    L9:
        JvmProtoBuf$StringTableTypes.Record.access$502(r5, this.d);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 4;
    L12:
        JvmProtoBuf$StringTableTypes.Record.access$602(r5, this.e);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 8;
    L15:
        JvmProtoBuf$StringTableTypes.Record.access$702(r5, this.f);
        if ((this.f19128b & 16) != 16) goto L18;
        this.g = Collections.unmodifiableList(this.g);
        this.f19128b &= -17;
    L18:
        JvmProtoBuf$StringTableTypes.Record.access$802(r5, this.g);
        if ((this.f19128b & 32) != 32) goto L21;
        this.f19130h = Collections.unmodifiableList(this.f19130h);
        this.f19128b &= -33;
    L21:
        JvmProtoBuf$StringTableTypes.Record.access$902(r5, this.f19130h);
        JvmProtoBuf$StringTableTypes.Record.access$1002(r5, r11);
        return r5;
    }

    public final void g(JvmProtoBuf$StringTableTypes.Record r5) {
        if (r5 != JvmProtoBuf$StringTableTypes.Record.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasRange() == false) goto L9;
        int r10 = r5.getRange();
        this.f19128b |= 1;
        this.f19129c = r10;
    L9:
        if (r5.hasPredefinedIndex() == false) goto L12;
        int r11 = r5.getPredefinedIndex();
        this.f19128b |= 2;
        this.d = r11;
    L12:
        if (r5.hasString() == false) goto L15;
        this.f19128b |= 4;
        this.e = JvmProtoBuf$StringTableTypes.Record.access$600(r5);
    L15:
        if (r5.hasOperation() == false) goto L18;
        JvmProtoBuf$StringTableTypes.Record.Operation r12 = r5.getOperation();
        r12.getClass();
        this.f19128b |= 8;
        this.f = r12;
    L18:
        if (JvmProtoBuf$StringTableTypes.Record.access$800(r5).isEmpty() == true) goto L27;
        if (this.g.isEmpty() == false) goto L23;
        this.g = JvmProtoBuf$StringTableTypes.Record.access$800(r5);
        this.f19128b &= -17;
        goto L27
    L23:
        if ((this.f19128b & 16) == 16) goto L25;
        this.g = new ArrayList(this.g);
        this.f19128b |= 16;
    L25:
        this.g.addAll(JvmProtoBuf$StringTableTypes.Record.access$800(r5));
    L27:
        if (JvmProtoBuf$StringTableTypes.Record.access$900(r5).isEmpty() == false) goto L29;
    L35:
        this.f19190a = this.f19190a.c(JvmProtoBuf$StringTableTypes.Record.access$1100(r5));
        return;
    L29:
        if (this.f19130h.isEmpty() == false) goto L32;
        this.f19130h = JvmProtoBuf$StringTableTypes.Record.access$900(r5);
        this.f19128b &= -33;
        goto L35
    L32:
        if ((this.f19128b & 32) == 32) goto L34;
        this.f19130h = new ArrayList(this.f19130h);
        this.f19128b |= 32;
    L34:
        this.f19130h.addAll(JvmProtoBuf$StringTableTypes.Record.access$900(r5));
        goto L35
    }

    public final void h(f r5, i r10) {
        JvmProtoBuf$StringTableTypes.Record r11 = null;
        g((JvmProtoBuf$StringTableTypes.Record) JvmProtoBuf$StringTableTypes.Record.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        JvmProtoBuf$StringTableTypes.Record r12 = (JvmProtoBuf$StringTableTypes.Record) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
