package bx8;

import android.content.Context;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeWithContextInterface;
import com.larus.caijing_pay.impl.config.CJHostRouterServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d implements TTCJPayOpenSchemeWithContextInterface {
    public final /* synthetic */ CJHostRouterServiceImpl a;

    public /* synthetic */ d(CJHostRouterServiceImpl r1) {
        this.a = r1;
    }

    public final void openScheme(Context r2, String r3) {
        CJHostRouterServiceImpl.F2(this.a, r2, r3);
    }
}
