package com.bytedance.android.live.recharge;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.live.IRechargeListener;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import zg1.w2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.recharge.RechargeServiceWrapper")
public interface IRechargeServiceExternal extends IService {
    void clearCurrentRechargeCacheDataObject();

    void fetchAutoExchangeStatus(int r1);

    zv0.a getCJExternalService();

    RechargeCurrentCacheData getCurrentRechargeCacheDataObject();

    IAutoExchangeService getExchangeUtils();

    IJsMethodsProvideService.IFactory getRechargeJsFactory();

    boolean isRechargeDialogShowing();

    zv0.f rechargeCenter();

    void showPayCancelChargePanel(Context r1, w2 r2);

    DialogFragment showRechargeDialogFragment(Context r1, Bundle r2, IRechargeListener r3);

    DialogFragment showRechargeDialogFragment(Context r1, com.bytedance.android.live.recharge.model.d r2, IRechargeListener r3);
}
