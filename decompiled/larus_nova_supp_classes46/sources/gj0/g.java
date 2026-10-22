package gj0;

import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.starwish.StarWishWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements xh0.e {
    public g() {
    }

    @Override // xh0.e
    public final ne0.d a(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return null;
    }

    @Override // xh0.e
    public final Widget b(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        i.a("StarWishPlugin", "createWidget");
        return new StarWishWidget();
    }

    @Override // xh0.e
    public final boolean c(SceneType r3) {
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        i.a("StarWishPlugin", "isEnable sceneType ：" + r3);
        return true;
    }
}
