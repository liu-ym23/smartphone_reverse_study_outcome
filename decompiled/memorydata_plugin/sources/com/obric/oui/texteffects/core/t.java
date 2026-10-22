package com.obric.oui.texteffects.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/texteffects/core/PropertyTrack;", "", "property", "Lcom/obric/oui/texteffects/core/EffectProperty;", "keyframes", "", "Lcom/obric/oui/texteffects/core/Keyframe;", "easing", "Lcom/obric/oui/texteffects/core/EasingSpec;", "(Lcom/obric/oui/texteffects/core/EffectProperty;Ljava/util/List;Lcom/obric/oui/texteffects/core/EasingSpec;)V", "getEasing", "()Lcom/obric/oui/texteffects/core/EasingSpec;", "getKeyframes", "()Ljava/util/List;", "getProperty", "()Lcom/obric/oui/texteffects/core/EffectProperty;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EffectProperty f14638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<q> f14639b;
    private final i c;

    public t(EffectProperty r3, List<q> r4, i r5) {
        List<q> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "property");
        Intrinsics.checkNotNullParameter(r6, "keyframes");
        Intrinsics.checkNotNullParameter(r5, "easing");
        this.f14638a = r3;
        this.f14639b = r6;
        this.c = r5;
    }

    public final EffectProperty a() {
        return this.f14638a;
    }

    public final List<q> b() {
        return this.f14639b;
    }

    public final i c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, t.class) == true) goto L8;
        return false;
    L8:
        t r6 = (t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.memorydata.plugin");
        if (this.f14638a == r6.f14638a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14639b, r6.f14639b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f14638a.hashCode() * 31) + this.f14639b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PropertyTrack(property=" + this.f14638a + ", keyframes=" + this.f14639b + ", easing=" + this.c + ')';
    }
}
