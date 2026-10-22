package a20;

import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public final OpenFeatureIconCallbackFrom a;
    public final OpenFeatureIconCallbackType b;

    public final OpenFeatureIconCallbackType getType() {
        return this.b;
    }

    public m(OpenFeatureIconCallbackFrom r2, OpenFeatureIconCallbackType r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r2;
        this.b = r3;
    }
}
