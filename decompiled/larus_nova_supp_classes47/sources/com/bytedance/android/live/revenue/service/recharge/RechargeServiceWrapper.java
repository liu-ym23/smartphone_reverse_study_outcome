package com.bytedance.android.live.revenue.service.recharge;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.live.recharge.RechargeService;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.recharge.k;
import com.bytedance.android.live.recharge.model.d;
import com.bytedance.android.live.recharge.s0;
import com.bytedance.android.live.revenue.service.base.RevenueExposedWrapperBase;
import com.bytedance.android.livesdkapi.depend.live.IRechargeListener;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.w2;
import zv0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/revenue/service/recharge/RechargeServiceWrapper;", "Lcom/bytedance/android/live/revenue/service/base/RevenueExposedWrapperBase;", "Lcom/bytedance/android/live/recharge/IRechargeService;", "Lcom/bytedance/android/live/recharge/IRechargeServiceExternal;", "Lzv0/f;", "rechargeCenter", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService$IFactory;", "getRechargeJsFactory", "Lcom/bytedance/android/live/recharge/exchange/IAutoExchangeService;", "getExchangeUtils", "Landroid/content/Context;", "context", "Lcom/bytedance/android/live/recharge/model/d;", "params", "Lcom/bytedance/android/livesdkapi/depend/live/IRechargeListener;", "rechargeListener", "Landroidx/fragment/app/DialogFragment;", "showRechargeDialogFragment", "Landroid/os/Bundle;", "bundle", "", "isRechargeDialogShowing", "Lcom/bytedance/android/live/ai/api/model/RechargeCurrentCacheData;", "getCurrentRechargeCacheDataObject", "", "clearCurrentRechargeCacheDataObject", "", "reqFrom", "fetchAutoExchangeStatus", "Lzv0/a;", "getCJExternalService", "Lzg1/w2;", "event", "showPayCancelChargePanel", "<init>", "()V", "revenue-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RechargeServiceWrapper extends RevenueExposedWrapperBase<IRechargeService> implements IRechargeServiceExternal {

    public static final class a implements IJsMethodsProvideService.IFactory {
        public final /* synthetic */ RechargeServiceWrapper a;

        public a(RechargeServiceWrapper r1) {
            this.a = r1;
        }

        public final Map<String, n56.c> buildMethods(WeakReference<Context> r2, n56.a r3) {
            ((s0) this.a.getRealInstance().getRechargeJsFactory()).getClass();
            return RechargeService.g(r2, r3);
        }
    }

    public static final class b implements k.a {
        public final /* synthetic */ IRechargeListener a;

        @Override // com.bytedance.android.live.recharge.k.a
        public final /* synthetic */ void a() {
        }

        public b(IRechargeListener r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.recharge.k.a
        public final void b(int r7, int r8, long r9) {
            IRechargeListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onRechargeState(r7, r8, r9, null);
            return;
        }
    }

    public static final class c implements k.a {
        public final /* synthetic */ IRechargeListener a;

        @Override // com.bytedance.android.live.recharge.k.a
        public final /* synthetic */ void a() {
        }

        public c(IRechargeListener r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.recharge.k.a
        public final void b(int r7, int r8, long r9) {
            IRechargeListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onRechargeState(r7, r8, r9, null);
            return;
        }
    }

    public RechargeServiceWrapper() {
        super(IRechargeService.class);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public IJsMethodsProvideService.IFactory getRechargeJsFactory() {
        return new a(this);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public void clearCurrentRechargeCacheDataObject() {
        getRealInstance().clearCurrentRechargeCacheDataObject();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public zv0.a getCJExternalService() {
        return getRealInstance().getCJExternalService();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public RechargeCurrentCacheData getCurrentRechargeCacheDataObject() {
        return getRealInstance().getCurrentRechargeCacheDataObject();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public IAutoExchangeService getExchangeUtils() {
        return getRealInstance().getExchangeUtils();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public boolean isRechargeDialogShowing() {
        return getRealInstance().isRechargeDialogShowing();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public f rechargeCenter() {
        return getRealInstance().rechargeCenter();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public void fetchAutoExchangeStatus(int r2) {
        getRealInstance().fetchAutoExchangeStatus(r2);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public void showPayCancelChargePanel(Context r2, w2 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        getRealInstance().showPayCancelChargePanel(r2, r3);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public DialogFragment showRechargeDialogFragment(Context r3, Bundle r4, IRechargeListener r5) {
        return getRealInstance().showRechargeDialogFragment(r3, r4, new c(r5));
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public DialogFragment showRechargeDialogFragment(Context r3, d r4, IRechargeListener r5) {
        return getRealInstance().showRechargeDialogFragment(r3, r4, new b(r5));
    }
}
