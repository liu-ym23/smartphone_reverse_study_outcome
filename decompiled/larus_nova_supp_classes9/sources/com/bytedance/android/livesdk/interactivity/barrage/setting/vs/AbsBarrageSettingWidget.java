package com.bytedance.android.livesdk.interactivity.barrage.setting.vs;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xs2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/AbsBarrageSettingWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsBarrageSettingWidget extends LiveRecyclableWidget {
    public BarrageSetting a;
    public final a b;

    public interface a {
        void X50(BarrageSetting r1);
    }

    public void yq(boolean r1) {
    }

    public final void wq() {
        b.a().post(new q22.b(this.a));
    }

    public void xq(BarrageSetting r2) {
        Intrinsics.checkNotNullParameter(r2, "barrageSetting");
        this.a = r2;
    }

    public AbsBarrageSettingWidget(BarrageSetting r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "mBarrageSetting");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }
}
