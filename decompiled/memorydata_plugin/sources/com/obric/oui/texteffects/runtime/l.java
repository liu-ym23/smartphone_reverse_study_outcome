package com.obric.oui.texteffects.runtime;

import com.obric.oui.texteffects.core.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J3\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/obric/oui/texteffects/runtime/TextEffectSession;", "", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "effectName", "", "finalText", "", "playTimeMs", "", "(Lcom/obric/oui/texteffects/core/TextEffectSpec;Ljava/lang/String;Ljava/lang/CharSequence;J)V", "getEffectName", "()Ljava/lang/String;", "getFinalText", "()Ljava/lang/CharSequence;", "setFinalText", "(Ljava/lang/CharSequence;)V", "getPlayTimeMs", "()J", "setPlayTimeMs", "(J)V", "getSpec", "()Lcom/obric/oui/texteffects/core/TextEffectSpec;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f14707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14708b;
    private CharSequence c;
    private long d;

    public l(u r3, String r4, CharSequence r5, long r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "spec");
        Intrinsics.checkNotNullParameter(r4, "effectName");
        this.f14707a = r3;
        this.f14708b = r4;
        this.c = r7;
        this.d = r6;
    }

    public /* synthetic */ l(u r7, String r8, CharSequence r9, long r10, int r12, DefaultConstructorMarker r13) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r12 & 8) == 0) goto L5;
        r10 = 0;
    L5:
        this(r7, r8, r3, r10);
    }

    public final u a() {
        return this.f14707a;
    }

    public final void a(long r1) {
        this.d = r1;
    }

    public final void a(CharSequence r3) {
        this.c = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public final String b() {
        return this.f14708b;
    }

    public final CharSequence c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, l.class) == true) goto L8;
        return false;
    L8:
        l r8 = (l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14707a, r8.f14707a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14708b, r8.f14708b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r8.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f14707a.hashCode() * 31) + this.f14708b.hashCode()) * 31;
        CharSequence r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.d);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "TextEffectSession(spec=" + this.f14707a + ", effectName=" + this.f14708b + ", finalText=" + this.c + ", playTimeMs=" + this.d + ')';
    }
}
