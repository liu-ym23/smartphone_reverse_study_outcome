package z52;

import android.widget.RadioGroup;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r2, int r3) {
        if (r3 != 2131378243) goto L6;
        this.a.y.setFontSize(BarrageSettingFont.SMALL);
    L11:
        b r4 = this.a;
        r4.e(r4.y);
        xs2.b.a().post(new q22.b(this.a.y));
        return;
    L6:
        if (r3 != 2131378242) goto L9;
        this.a.y.setFontSize(BarrageSettingFont.MID);
        goto L11
    L9:
        if (r3 != 2131378241) goto L11;
        this.a.y.setFontSize(BarrageSettingFont.BIG);
        goto L11
    }
}
