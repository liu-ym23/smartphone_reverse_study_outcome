package wa;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.next.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class d implements b<g, String> {
    public final PredictElementType a;

    public d() {
        this.a = PredictElementType.SceneId;
    }

    @Override // wa.b
    public final PredictElementType b() {
        return this.a;
    }
}
