package kotlinx.metadata.internal.metadata.jvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.f;
import kotlinx.metadata.internal.protobuf.i;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends m implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f19127c;
    public List d;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ m b(f r5, i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final z build() {
        JvmProtoBuf$StringTableTypes r5 = f();
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
        g((JvmProtoBuf$StringTableTypes) r5);
        return this;
    }

    public final Object clone() {
        a r5 = new a();
        r5.f19127c = Collections.emptyList();
        r5.d = Collections.emptyList();
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ y d(f r5, i r10) {
        h(r5, r10);
        return this;
    }

    public final JvmProtoBuf$StringTableTypes f() {
        JvmProtoBuf$StringTableTypes r5 = new JvmProtoBuf$StringTableTypes(this, null);
        if ((this.f19126b & 1) != 1) goto L5;
        this.f19127c = Collections.unmodifiableList(this.f19127c);
        this.f19126b &= -2;
    L5:
        JvmProtoBuf$StringTableTypes.access$1402(r5, this.f19127c);
        if ((this.f19126b & 2) != 2) goto L8;
        this.d = Collections.unmodifiableList(this.d);
        this.f19126b &= -3;
    L8:
        JvmProtoBuf$StringTableTypes.access$1502(r5, this.d);
        return r5;
    }

    public final void g(JvmProtoBuf$StringTableTypes r5) {
        if (r5 != JvmProtoBuf$StringTableTypes.getDefaultInstance()) goto L6;
        return;
    L6:
        if (JvmProtoBuf$StringTableTypes.access$1400(r5).isEmpty() == true) goto L15;
        if (this.f19127c.isEmpty() == false) goto L11;
        this.f19127c = JvmProtoBuf$StringTableTypes.access$1400(r5);
        this.f19126b &= -2;
        goto L15
    L11:
        if ((this.f19126b & 1) == 1) goto L13;
        this.f19127c = new ArrayList(this.f19127c);
        this.f19126b |= 1;
    L13:
        this.f19127c.addAll(JvmProtoBuf$StringTableTypes.access$1400(r5));
    L15:
        if (JvmProtoBuf$StringTableTypes.access$1500(r5).isEmpty() == false) goto L17;
    L23:
        this.f19190a = this.f19190a.c(JvmProtoBuf$StringTableTypes.access$1600(r5));
        return;
    L17:
        if (this.d.isEmpty() == false) goto L20;
        this.d = JvmProtoBuf$StringTableTypes.access$1500(r5);
        this.f19126b &= -3;
        goto L23
    L20:
        if ((this.f19126b & 2) == 2) goto L22;
        this.d = new ArrayList(this.d);
        this.f19126b |= 2;
    L22:
        this.d.addAll(JvmProtoBuf$StringTableTypes.access$1500(r5));
        goto L23
    }

    public final void h(f r5, i r10) {
        JvmProtoBuf$StringTableTypes r11 = null;
        g((JvmProtoBuf$StringTableTypes) JvmProtoBuf$StringTableTypes.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        JvmProtoBuf$StringTableTypes r12 = (JvmProtoBuf$StringTableTypes) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
