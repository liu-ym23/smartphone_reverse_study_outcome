package com.bytedance.android.live.recharge.widget;

import android.widget.TextView;
import com.android.ttcjpaysdk.base.service.PayMsg;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.StringUtils;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ p a;

    public n(p r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Map r6 = (Map) r5;
        RechargeNoPasswordWidget r0 = this.a.a;
        int r1 = RechargeNoPasswordWidget.O;
        r0.getClass();
        PayMsg r2 = PayMsg.PAY_AMOUNT;
        if (StringUtils.isEmpty((String) r6.get(r2)) == false) goto L5;
        String r7 = "";
    L10:
        TextView r3 = r0.q;
        if (r3 == null) goto L14;
        r3.setText(s1.C(2131921897, new Object[]{r7 + 20803}));
        return;
    L14:
        return;
    L5:
        StringBuilder r4 = new StringBuilder(" ");
        String r8 = (String) r6.get(r2);
        if (r8 == null) goto L8;
        String r9 = StringsKt.trim(r8).toString();
    L9:
        r4.append(r9);
        r7 = r4.toString();
        goto L10
    L8:
        r9 = null;
        goto L9
    }
}
