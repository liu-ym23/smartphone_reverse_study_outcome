package z52;

import android.widget.RadioGroup;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import zg1.e3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r4, int r5) {
        if (r5 != 2131378246) goto L5;
        this.a.a(true);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r6 = l42.a.g;
        Boolean r2 = Boolean.TRUE;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r2);
        xs2.b.a().post(new e3(true, 0, "setting_landscape_dialog"));
    L15:
        b r7 = this.a;
        r7.e(r7.y);
        xs2.b.a().post(new q22.b(this.a.y));
        return;
    L5:
        this.a.b();
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r8 = l42.a.g;
        Boolean r3 = Boolean.FALSE;
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r3);
        xs2.b.a().post(new e3(false, 0, "setting_landscape_dialog"));
        this.a.y.setNeedRollback(false);
        if (r5 != 2131378250) goto L9;
        this.a.y.setBarrageArea(BarrageSettingArea.TOP);
    L14:
        b r9 = this.a;
        r9.d(r9.y);
        goto L15
    L9:
        if (r5 != 2131378249) goto L12;
        this.a.y.setBarrageArea(BarrageSettingArea.HALF);
        goto L14
    L12:
        if (r5 != 2131378248) goto L14;
        this.a.y.setBarrageArea(BarrageSettingArea.FULL);
        goto L14
    }
}
