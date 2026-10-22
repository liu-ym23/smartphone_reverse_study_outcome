package kotlinx.metadata.internal.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.UninitializedMessageException;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends kotlinx.metadata.internal.protobuf.m implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProtoBuf$Effect.EffectType f19132c;
    public List d;
    public ProtoBuf$Expression e;
    public ProtoBuf$Effect.InvocationKind f;

    @Override // kotlinx.metadata.internal.protobuf.m
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.m b(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final kotlinx.metadata.internal.protobuf.z build() {
        ProtoBuf$Effect r5 = f();
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
        g((ProtoBuf$Effect) r5);
        return this;
    }

    public final Object clone() {
        k r5 = new k();
        r5.f19132c = ProtoBuf$Effect.EffectType.RETURNS_CONSTANT;
        r5.d = Collections.emptyList();
        r5.e = ProtoBuf$Expression.getDefaultInstance();
        r5.f = ProtoBuf$Effect.InvocationKind.AT_MOST_ONCE;
        r5.g(f());
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.y
    public final /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y d(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        h(r5, r10);
        return this;
    }

    public final ProtoBuf$Effect f() {
        ProtoBuf$Effect r5 = new ProtoBuf$Effect(this, null);
        int r10 = this.f19131b;
        int r11 = 1;
        if ((r10 & 1) == 1) goto L6;
        r11 = 0;
    L6:
        ProtoBuf$Effect.access$24202(r5, this.f19132c);
        if ((this.f19131b & 2) != 2) goto L9;
        this.d = Collections.unmodifiableList(this.d);
        this.f19131b &= -3;
    L9:
        ProtoBuf$Effect.access$24302(r5, this.d);
        if ((r10 & 4) != 4) goto L12;
        r11 = r11 | 2;
    L12:
        ProtoBuf$Effect.access$24402(r5, this.e);
        if ((r10 & 8) != 8) goto L15;
        r11 = r11 | 4;
    L15:
        ProtoBuf$Effect.access$24502(r5, this.f);
        ProtoBuf$Effect.access$24602(r5, r11);
        return r5;
    }

    public final void g(ProtoBuf$Effect r5) {
        if (r5 != ProtoBuf$Effect.getDefaultInstance()) goto L6;
        return;
    L6:
        if (r5.hasEffectType() == false) goto L9;
        ProtoBuf$Effect.EffectType r10 = r5.getEffectType();
        r10.getClass();
        this.f19131b |= 1;
        this.f19132c = r10;
    L9:
        if (ProtoBuf$Effect.access$24300(r5).isEmpty() == true) goto L18;
        if (this.d.isEmpty() == false) goto L14;
        this.d = ProtoBuf$Effect.access$24300(r5);
        this.f19131b &= -3;
        goto L18
    L14:
        if ((this.f19131b & 2) == 2) goto L16;
        this.d = new ArrayList(this.d);
        this.f19131b |= 2;
    L16:
        this.d.addAll(ProtoBuf$Effect.access$24300(r5));
    L18:
        if (r5.hasConclusionOfConditionalEffect() == false) goto L27;
        ProtoBuf$Expression r11 = r5.getConclusionOfConditionalEffect();
        if ((this.f19131b & 4) == 4) goto L22;
    L24:
        this.e = r11;
    L25:
        this.f19131b |= 4;
        goto L27
    L22:
        if (this.e == ProtoBuf$Expression.getDefaultInstance()) goto L24;
        o r12 = ProtoBuf$Expression.newBuilder(this.e);
        r12.g(r11);
        this.e = r12.f();
    L27:
        if (r5.hasKind() == false) goto L29;
        ProtoBuf$Effect.InvocationKind r13 = r5.getKind();
        r13.getClass();
        this.f19131b |= 8;
        this.f = r13;
    L29:
        this.f19190a = this.f19190a.c(ProtoBuf$Effect.access$24700(r5));
    }

    public final void h(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        ProtoBuf$Effect r11 = null;
        g((ProtoBuf$Effect) ProtoBuf$Effect.PARSER.a(r5, r10));
        return;
    L8:
        e = move-exception;
        ProtoBuf$Effect r12 = (ProtoBuf$Effect) e.getUnfinishedMessage();     // Catch: Throwable -> L6
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
