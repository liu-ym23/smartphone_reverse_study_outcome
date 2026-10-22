package wa;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.next.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c implements b<f, Boolean> {
    public final PredictElementType a;

    public c() {
        this.a = PredictElementType.SceneRepeat;
    }

    @Override // wa.b
    public final PredictElementType b() {
        return this.a;
    }
}
