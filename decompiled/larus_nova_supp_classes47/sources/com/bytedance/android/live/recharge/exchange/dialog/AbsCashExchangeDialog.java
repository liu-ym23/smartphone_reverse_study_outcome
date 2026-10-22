package com.bytedance.android.live.recharge.exchange.dialog;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.recharge.model.ExchangeType;
import java.util.Map;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/dialog/AbsCashExchangeDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsCashExchangeDialog extends AppCompatDialog {
    public abstract void I0(ExchangeType r1, k r2, long r3, String r5, boolean r6, Map<String, String> r7, zv0.e r8);

    public AbsCashExchangeDialog(Context r2) {
        super(r2, 2131954708);
    }
}
