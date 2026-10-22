package i90;

import android.view.View;
import com.bytedance.android.live.effect.adapter.LiveBeautyTemplateAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ LiveBeautyTemplateAdapter a;
    public final /* synthetic */ int b;

    public a(LiveBeautyTemplateAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        int r4 = this.b;
        LiveBeautyTemplateAdapter r0 = this.a;
        if (r4 != r0.e) goto L5;
        return;
    L5:
        LiveBeautyTemplateAdapter.b r1 = r0.f;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r0.g == false) goto L12;
        r1.onItemClick(r4);
        return;
    }
}
