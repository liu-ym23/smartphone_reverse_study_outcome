package com.obric.oui.texteffects.core;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/texteffects/core/Keyframe;", "", "timeMs", "", EventBody.KEY_VALUE, "Lcom/obric/oui/texteffects/core/EffectValue;", "(JLcom/obric/oui/texteffects/core/EffectValue;)V", "getTimeMs", "()J", "getValue", "()Lcom/obric/oui/texteffects/core/EffectValue;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f14631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f14632b;

    public q(long r2, m r4) {
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        this.f14631a = r2;
        this.f14632b = r4;
    }

    public final long a() {
        return this.f14631a;
    }

    public final m b() {
        return this.f14632b;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, q.class) == true) goto L8;
        return false;
    L8:
        q r10 = (q) ZeusTransformUtils.preCheckCast(r9, q.class, "com.obric.memorydata.plugin");
        if (this.f14631a == r10.f14631a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14632b, r10.f14632b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f14631a) * 31) + this.f14632b.hashCode();
    }

    public String toString() {
        return "Keyframe(timeMs=" + this.f14631a + ", value=" + this.f14632b + ')';
    }
}
