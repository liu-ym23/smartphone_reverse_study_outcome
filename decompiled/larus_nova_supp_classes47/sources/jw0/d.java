package jw0;

import android.view.View;
import android.widget.ToggleButton;
import com.bytedance.android.live.recharge.exchange.saas.CashExchangeDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ CashExchangeDialog a;

    public d(CashExchangeDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ToggleButton r4 = this.a.g;
        if (r4 == null) goto L12;
        boolean r0 = true;
        if (r4 != null) goto L7;
    L10:
        r4.setChecked(r0);
        return;
    L7:
        if (r4.isChecked() != true) goto L10;
        r0 = false;
        goto L10
    }
}
