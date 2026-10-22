package jw0;

import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.bytedance.android.live.recharge.exchange.saas.CashExchangeDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ CashExchangeDialog a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public e(CashExchangeDialog r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r8, boolean r9) {
        int r10 = h.a;
        long r12 = this.b;
        long r2 = this.c;
        long r0 = r12 + r2;
        CashExchangeDialog r13 = this.a;
        int r4 = r13.k;
        ToggleButton r14 = r13.g;
        if (r14 == null) goto L5;
        Boolean r15 = Boolean.valueOf(r14.isChecked());
    L6:
        h.c(r0, r2, r4, 3, r15);
        return;
    L5:
        r15 = null;
        goto L6
    }
}
