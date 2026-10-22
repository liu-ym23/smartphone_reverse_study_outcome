package com.obric.oui.texteffects.core;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/texteffects/core/AnimatedFloatSpec;", "", "keyframes", "", "Lcom/obric/oui/texteffects/core/Keyframe;", "easing", "Lcom/obric/oui/texteffects/core/EasingSpec;", "(Ljava/util/List;Lcom/obric/oui/texteffects/core/EasingSpec;)V", "getEasing", "()Lcom/obric/oui/texteffects/core/EasingSpec;", "getKeyframes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0781a f14583a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<q> f14584b;
    private final i c;

    /* JADX INFO: renamed from: com.obric.oui.texteffects.core.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/texteffects/core/AnimatedFloatSpec$Companion;", "", "()V", "constant", "Lcom/obric/oui/texteffects/core/AnimatedFloatSpec;", EventBody.KEY_VALUE, "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0781a {
        private C0781a() {
        }

        public /* synthetic */ C0781a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final a a(float r6) {
            return new a(CollectionsKt.listOf(new q(0, (m) ZeusTransformUtils.preCheckCast(new m.b(r6), m.class, "com.obric.memorydata.plugin"))), (i) ZeusTransformUtils.preCheckCast(i.c.f14603a, i.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f14583a = new C0781a(null);
    }

    public a(List<q> r3, i r4) {
        List<q> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "keyframes");
        Intrinsics.checkNotNullParameter(r4, "easing");
        this.f14584b = r5;
        this.c = r4;
    }

    public final List<q> a() {
        return this.f14584b;
    }

    public final i b() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14584b, r6.f14584b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f14584b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "AnimatedFloatSpec(keyframes=" + this.f14584b + ", easing=" + this.c + ')';
    }
}
