package a62;

import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.BarrageSettingAlphaWidget;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements ov2.a {
    public final /* synthetic */ BarrageSettingAlphaWidget a;

    public final void a() {
    }

    public final void c(RangeSeekBar r1, int r2, boolean r3) {
    }

    public final void b() {
        BarrageSettingAlphaWidget r0 = this.a;
        r0.b.X50(r0.a);
        this.a.wq();
    }

    public a(BarrageSettingAlphaWidget r1) {
        this.a = r1;
    }

    public final void d(RangeSeekBar r3, float r4) {
        if (r3 == null) goto L4;
        int r5 = r3.getStepCount();
    L5:
        if (r5 > 0) goto L11;
        BarrageSettingAlphaWidget r6 = this.a;
        int r0 = BarrageSettingAlphaWidget.e;
        r6.getClass();
        int r7 = MathKt.roundToInt((((int) r4) * 0.8f) + 20.0f);
        TextView r8 = this.a.d;
        if (r8 == null) goto L9;
        r8.setText(String.valueOf(r7) + "%");
    L9:
        this.a.a.setAlpha(r7);
        return;
    L11:
        return;
    L4:
        r5 = 0;
        goto L5
    }
}
