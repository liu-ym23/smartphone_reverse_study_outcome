package com.bytedance.android.live.revenue.service.recharge;

import android.content.Context;
import com.bytedance.android.live.recharge.RechargeService;
import com.bytedance.android.live.recharge.i;
import com.bytedance.android.live.recharge.m;
import com.bytedance.android.live.recharge.model.d;
import com.bytedance.android.live.recharge.q0;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.scope.o;
import i57.e;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\f\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J2\u0010\u000f\u001a\u001a\u0012\b\u0012\u00060\u0004j\u0002`\u00050\rj\f\u0012\b\u0012\u00060\u0004j\u0002`\u0005`\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u001c\u0010\u0019\u001a\u00020\t2\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b2\u0006\u0010\u0018\u001a\u00020\u001dH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/revenue/service/recharge/RechargeServiceKt;", "Lcom/bytedance/android/live/recharge/RechargeService;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/android/live/recharge/i;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getAvailableDiamonds", "", "entrance", "", "refreshAvailableDiamonds", "", "refresh", "Lio/reactivex/Observable;", "Lcom/bytedance/revenue/platform/api/core/rx/Observable;", "observeAvailableDiamonds", "Lpy/l;", "getCoinImage", "onStart", "onStop", "getCoinCurrency", "Li57/a;", "aioCallContext", "Lcom/bytedance/android/live/recharge/m;", "param", "openRechargeDialog", "Landroid/content/Context;", "Lcom/bytedance/revenue/platform/api/core/android/AndroidContext;", "context", "Lcom/bytedance/android/live/recharge/q0;", "<init>", "()V", "revenue-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RechargeServiceKt extends RechargeService implements o, i {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3) {
            Long r4 = (Long) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            return Long.valueOf(r4.longValue());
        }
    }

    public void onStart() {
    }

    public void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.i
    public long getAvailableDiamonds() {
        return rechargeCenter().getAvailableDiamonds();
    }

    @Override // com.bytedance.android.live.recharge.i
    public String getCoinCurrency() {
        return r3.b();
    }

    @Override // com.bytedance.android.live.recharge.i
    public l getCoinImage() {
        return r3.a();
    }

    public RechargeServiceKt() {
    }

    @Override // com.bytedance.android.live.recharge.i
    public void refreshAvailableDiamonds(String r2) {
        rechargeCenter().sync(r2);
    }

    @Override // com.bytedance.android.live.recharge.i
    public Observable<Long> observeAvailableDiamonds(boolean r1, String r2) {
        if (r1 == false) goto L5;
        rechargeCenter().sync(r2);
    L5:
        return rechargeCenter().observeWallet().map(a.a);
    }

    @Override // com.bytedance.android.live.recharge.i
    public void openRechargeDialog(Context r20, q0 r22) {
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r22, "param");
        showRechargeDialogFragment(r20, new d(true, r22.a, null, 0, false, 0, 0, null, null, null, null, null, null, 32764), null);
    }

    @Override // com.bytedance.android.live.recharge.i
    public void openRechargeDialog(i57.a r3, m r4) {
        Intrinsics.checkNotNullParameter(r3, "aioCallContext");
        Intrinsics.checkNotNullParameter(r4, "param");
        Context r5 = (Context) r3.a(e.f.a());
        if (r5 == null) goto L6;
        r4.getClass();
        openRechargeDialog(r5, new q0(r4.a(), 216));
        return;
    }
}
