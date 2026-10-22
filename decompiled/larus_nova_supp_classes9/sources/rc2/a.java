package rc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeDimension;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l61.b;
import l61.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements g61.a {
    public final DegradeScene a;
    public final b b;
    public final pc2.b c;

    public final boolean a() {
        this.c.a(new e32.a(this.a, DegradeSceneLevel.AudienceExpLevel.Normal, DegradeDimension.GLOBAL), MapsKt.mapOf(new Pair[]{TuplesKt.to("expBizSceneType", this.b.getType().name()), TuplesKt.to("expBizSceneLevel", this.b.getLevel().name())}));
        return false;
    }

    public final boolean b() {
        this.c.a(new e32.a(this.a, DegradeSceneLevel.AudienceExpLevel.Degrade, DegradeDimension.GLOBAL), MapsKt.mapOf(new Pair[]{TuplesKt.to("expBizSceneType", this.b.getType().name()), TuplesKt.to("expBizSceneLevel", this.b.getLevel().name())}));
        return false;
    }

    public final boolean c() {
        this.c.a(new e32.a(this.a, DegradeSceneLevel.AudienceExpLevel.Enhance, DegradeDimension.GLOBAL), MapsKt.mapOf(new Pair[]{TuplesKt.to("expBizSceneType", this.b.getType().name()), TuplesKt.to("expBizSceneLevel", this.b.getLevel().name())}));
        return false;
    }

    public a(DegradeScene r2, d.a r3, pc2.b r4) {
        Intrinsics.checkNotNullParameter(r2, "degradeScene");
        Intrinsics.checkNotNullParameter(r3, "expScene");
        Intrinsics.checkNotNullParameter(r4, "degradeRequester");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
