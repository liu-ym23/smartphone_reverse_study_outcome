package a62;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.BarrageSettingBlockWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ BarrageSettingBlockWidget a;

    public d(BarrageSettingBlockWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ImageView r3 = this.a.f;
        if (r3 == null) goto L6;
        boolean r0 = !r3.isSelected();
        r3.setSelected(r0);
        this.a.a.setCarnivalBarrageOpen(r0);
        BarrageSettingBlockWidget r4 = this.a;
        r4.b.X50(r4.a);
        this.a.wq();
        return;
    }
}
