package com.bytedance.android.live.effect.beauty;

import android.view.View;
import com.bytedance.android.live.effect.template.BeautifyTemplate;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ LiveBeautifyFragmentNew a;
    public final /* synthetic */ BeautifyTemplate.BeautifyContentType b;

    public h(LiveBeautifyFragmentNew r1, BeautifyTemplate.BeautifyContentType r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        LiveBeautifyFragmentNew r4 = this.a;
        BeautifyTemplate.BeautifyContentType r0 = this.b;
        Map<BeautifyTemplate.BeautifyContentType, Integer> r1 = LiveBeautifyFragmentNew.A;
        r4.V90(r0);
        this.a.W90();
    }
}
