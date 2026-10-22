package com.bytedance.android.live.recharge;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.utility.ServiceLookup;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zg1.w2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.recharge.RechargeServiceKt")
public interface IRechargeService extends k, dy0.c, IService {
    /* synthetic */ void clearCurrentRechargeCacheDataObject();

    @Override // com.bytedance.android.live.recharge.k
    /* synthetic */ void fetchAutoExchangeStatus(int r1);

    /* synthetic */ zv0.a getCJExternalService();

    zv0.b getCashExchangeDelegate(View r1, List<View> r2, TextView r3, Function1<Integer, Unit> r4, int r5, Context r6);

    @Override // com.bytedance.android.live.recharge.k
    /* synthetic */ RechargeCurrentCacheData getCurrentRechargeCacheDataObject();

    /* synthetic */ IAutoExchangeService getExchangeUtils();

    /* synthetic */ k.b getRechargeJsFactory();

    @Override // com.bytedance.android.live.recharge.k
    /* synthetic */ Object getRechargeLynxBehavior();

    /* synthetic */ boolean isRechargeDialogShowing();

    @Override // com.bytedance.android.live.recharge.k
    /* synthetic */ zv0.f rechargeCenter();

    /* synthetic */ void showPayCancelChargePanel(Context r1, w2 r2);

    /* synthetic */ DialogFragment showRechargeDialogFragment(Context r1, Bundle r2, k.a r3);

    /* synthetic */ DialogFragment showRechargeDialogFragment(Context r1, com.bytedance.android.live.recharge.model.d r2, k.a r3);
}
