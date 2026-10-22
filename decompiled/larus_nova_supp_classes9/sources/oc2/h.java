package oc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.FlowLikeFeatureLevel;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends oc2.a<f32.d, FlowLikeFeatureLevel> {
    public final DegradeFeature f;
    public final List<b> g;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((b) r2).c.getLevel()), Integer.valueOf(((b) r1).c.getLevel()));
        }
    }

    public static final class b {
        public final DegradeScene a;
        public final DegradeSceneLevel b;
        public final FlowLikeFeatureLevel c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L12;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            DegradeScene r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            DegradeSceneLevel r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            FlowLikeFeatureLevel r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "FlowLikeDegradeProjection(degradeScene=" + this.a + ", degradeSceneLevel=" + this.b + ", degradeFeatureLevel=" + this.c + ")";
        }

        public b(DegradeScene r2, DegradeSceneLevel r3, FlowLikeFeatureLevel r4) {
            Intrinsics.checkNotNullParameter(r2, "degradeScene");
            Intrinsics.checkNotNullParameter(r3, "degradeSceneLevel");
            Intrinsics.checkNotNullParameter(r4, "degradeFeatureLevel");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    @Override // oc2.a
    public final Enum e() {
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        b r2 = (b) r1;
        if (Intrinsics.areEqual(this.e.b(r2.a), r2.b) == false) goto L4;
    L9:
        b r3 = (b) r1;
        if (r3 == null) goto L14;
        FlowLikeFeatureLevel r4 = r3.c;
        if (r4 == null) goto L14;
        return r4;
    L14:
        return FlowLikeFeatureLevel.LEVEL_DEFAULT;
    L8:
        r1 = null;
        goto L9
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r17) {
        FlowLikeFeatureLevel r0 = (FlowLikeFeatureLevel) r17;
        Intrinsics.checkNotNullParameter(r0, "level");
        int r1 = i.a[r0.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return new f32.d(false, false, 0, false, 15);
    L17:
        return new f32.d(true, false, 0, false, 14);
    L18:
        return new f32.d(false, true, 800, false, 9);
    L19:
        return new f32.d(false, false, 800, false, 11);
    L15:
        return new f32.d(false, false, 400, false, 11);
    }

    public h(FlowLikeFeatureLevel r4, com.bytedance.android.livesdk.interactivity.b r5) {
        Intrinsics.checkNotNullParameter(r4, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r5, "statusHolder");
        super(r4, r5);
        this.f = DegradeFeature.FLOW_LIKE;
        DegradeScene r0 = DegradeScene.STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE;
        this.g = CollectionsKt.sortedWith(CollectionsKt.mutableListOf(new b[]{new b(r0, DegradeSceneLevel.PlatformFlowLikeDegradeLevel.LEVEL_ONE, FlowLikeFeatureLevel.LEVEL_ONE), new b(r0, DegradeSceneLevel.PlatformFlowLikeDegradeLevel.LEVEL_TWO, FlowLikeFeatureLevel.LEVEL_TWO), new b(r0, DegradeSceneLevel.PlatformFlowLikeDegradeLevel.LEVEL_THREE, FlowLikeFeatureLevel.LEVEL_THREE), new b(DegradeScene.ECOM, DegradeSceneLevel.Ecom.HAPPEN, FlowLikeFeatureLevel.LEVEL_FOUR)}), new a());
    }
}
