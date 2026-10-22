package a62;

import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.BarrageSettingFontSizeWidget;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements ov2.a {
    public final /* synthetic */ BarrageSettingFontSizeWidget a;

    public final void a() {
    }

    public final void d(RangeSeekBar r1, float r2) {
    }

    public final void b() {
        BarrageSettingFontSizeWidget r0 = this.a;
        r0.b.X50(r0.a);
        this.a.wq();
    }

    public f(BarrageSettingFontSizeWidget r1) {
        this.a = r1;
    }

    public final void c(RangeSeekBar r4, int r5, boolean r6) {
        if (r6 == false) goto L4;
        return;
    L4:
        if (r4 == null) goto L6;
        int r7 = r4.getStepCount();
    L7:
        if (r7 <= 0) goto L30;
        this.a.getClass();
        if (r5 == 0) goto L15;
        if (r5 == 1) goto L14;
        if (r5 == 2) goto L13;
        BarrageSettingFont r8 = BarrageSettingFont.MID;
    L16:
        TextView r0 = this.a.d;
        if (r0 == null) goto L28;
        int r1 = e.a[r8.ordinal()];
        if (r1 == 1) goto L26;
        if (r1 != 2) goto L22;
    L25:
        String r9 = "中号";
    L27:
        r0.setText(r9);
        goto L28
    L22:
        if (r1 != 3) goto L25;
        r9 = "大号";
        goto L27
    L26:
        r9 = "小号";
    L28:
        this.a.a.setFontSize(r8);
        return;
    L13:
        r8 = BarrageSettingFont.BIG;
        goto L16
    L14:
        r8 = BarrageSettingFont.MID;
        goto L16
    L15:
        r8 = BarrageSettingFont.SMALL;
        goto L16
    L30:
        return;
    L6:
        r7 = 0;
        goto L7
    }
}
