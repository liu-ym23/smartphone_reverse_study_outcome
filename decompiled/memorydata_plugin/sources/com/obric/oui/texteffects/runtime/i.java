package com.obric.oui.texteffects.runtime;

import com.obric.oui.texteffects.core.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/texteffects/runtime/TextEffectPlayRequest;", "", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "effectName", "", "restart", "", "finalText", "", "(Lcom/obric/oui/texteffects/core/TextEffectSpec;Ljava/lang/String;ZLjava/lang/CharSequence;)V", "getEffectName", "()Ljava/lang/String;", "getFinalText", "()Ljava/lang/CharSequence;", "getRestart", "()Z", "getSpec", "()Lcom/obric/oui/texteffects/core/TextEffectSpec;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f14699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14700b;
    private final boolean c;
    private final CharSequence d;

    public i(u r3, String r4, boolean r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "spec");
        Intrinsics.checkNotNullParameter(r4, "effectName");
        this.f14699a = r3;
        this.f14700b = r4;
        this.c = r5;
        this.d = r7;
    }

    public final u a() {
        return this.f14699a;
    }

    public final String b() {
        return this.f14700b;
    }

    public final boolean c() {
        return this.c;
    }

    public final CharSequence d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14699a, r6.f14699a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14700b, r6.f14700b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r0 = ((this.f14699a.hashCode() * 31) + this.f14700b.hashCode()) * 31;
        boolean r1 = this.c;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (r0 + r2) * 31;
        CharSequence r4 = this.d;
        if (r4 != null) goto L8;
        int r5 = 0;
    L10:
        return r3 + r5;
    L8:
        r5 = r4.hashCode();
        goto L10
    }

    public String toString() {
        return "TextEffectPlayRequest(spec=" + this.f14699a + ", effectName=" + this.f14700b + ", restart=" + this.c + ", finalText=" + this.d + ')';
    }
}
