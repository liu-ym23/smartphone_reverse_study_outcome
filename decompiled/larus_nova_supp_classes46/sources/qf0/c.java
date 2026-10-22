package qf0;

import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenuebase.e;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import ne0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends e {

    public static final class a implements d {
        public a() {
        }

        @Override // ne0.d
        public final void a(HashMap<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "stateMapping");
        }

        @Override // ne0.d
        public final void b() {
        }
    }

    @Override // xh0.e
    public final boolean c(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return true;
    }

    public c() {
    }

    @Override // xh0.e
    public final d a(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return new a();
    }

    @Override // xh0.e
    public final Widget b(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return new InteractiveSongWidget();
    }
}
