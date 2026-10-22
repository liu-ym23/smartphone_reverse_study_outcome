package com.bytedance.android.live.recharge.exchange.repo;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.exchange.model.AutoExchangeStatus;
import com.bytedance.android.live.recharge.exchange.model.GetAutoExchangeStatusResult;
import com.bytedance.android.live.recharge.exchange.model.ReqFrom;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.badger.collect.impl.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/repo/ExchangeStatusRepository;", "Landroidx/lifecycle/ViewModel;", "()V", "_switchStatus", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "switchObserver", "Lio/reactivex/Observable;", "curVal", "fetchExchangeStatus", "reqFrom", "isAlreadySync", "", BuildConfig.BUILD_TYPE, "", "syncExchangeStatus", "enable", "updateExchangeStatus", "userLogin", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExchangeStatusRepository extends ViewModel {
    private final PropertyOwner<Integer> _switchStatus;
    private final CompositeDisposable cd;
    private final Observable<Integer> switchObserver;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ExchangeStatusRepository a;
        public final /* synthetic */ int b;

        public a(ExchangeStatusRepository r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ExchangeStatusRepository.access$get_switchStatus$p(this.a).a(Integer.valueOf(((GetAutoExchangeStatusResult) ((ExtraResponse) r3).data).getSwitchStatus()));
            if (((Number) ExchangeStatusRepository.access$get_switchStatus$p(this.a).a).intValue() != AutoExchangeStatus.UnSync.getValue()) goto L7;
            int r4 = this.b;
            ReqFrom r0 = ReqFrom.GiftPanel;
            if (r4 != r0.getValue()) goto L7;
            this.a.syncExchangeStatus(r0.getValue(), com.bytedance.android.live.recharge.util.d.a());
        L7:
            int r5 = v.a;
            v.e("ttlive_exchange", "fetchExchangeStatus success,status: " + ((Number) ExchangeStatusRepository.access$get_switchStatus$p(this.a).a).intValue() + ' ');
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            int r0 = v.a;
            v.b("ttlive_exchange", "fetchExchangeStatus fail,throwable: " + ((Throwable) r3) + ' ', null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ExchangeStatusRepository a;

        public c(ExchangeStatusRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CompositeDisposable r0 = ExchangeStatusRepository.access$getCd$p(this.a);
            r0.add((Disposable) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ExchangeStatusRepository a;
        public final /* synthetic */ boolean b;

        public d(ExchangeStatusRepository r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            PropertyOwner r4 = ExchangeStatusRepository.access$get_switchStatus$p(this.a);
            if (this.b == false) goto L5;
            AutoExchangeStatus r0 = AutoExchangeStatus.Open;
        L6:
            r4.a(Integer.valueOf(r0.getValue()));
            return;
        L5:
            r0 = AutoExchangeStatus.Closed;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            int r0 = v.a;
            v.b("ttlive_exchange", "syncExchangeStatus fail,throwable: " + ((Throwable) r3) + ' ', null);
        }
    }

    private final boolean userLogin() {
        return ((l01.d) f.a(l01.d.class)).isLogin();
    }

    public final int curVal() {
        return ((Number) this._switchStatus.a).intValue();
    }

    public final boolean isAlreadySync() {
        if (((Number) this._switchStatus.a).intValue() != AutoExchangeStatus.Open.getValue()) goto L5;
    L8:
        return true;
    L5:
        if (((Number) this._switchStatus.a).intValue() == AutoExchangeStatus.Closed.getValue()) goto L8;
        return false;
    }

    public final void release() {
        this.cd.clear();
    }

    public ExchangeStatusRepository() {
        this.cd = new CompositeDisposable();
        PropertyOwner<Integer> r0 = new PropertyOwner(Integer.valueOf(AutoExchangeStatus.UnKnown.getValue()));
        this._switchStatus = r0;
        this.switchObserver = r0.doOnSubscribe(new c(this));
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(ExchangeStatusRepository r0) {
        return r0.cd;
    }

    public static final /* synthetic */ PropertyOwner access$get_switchStatus$p(ExchangeStatusRepository r0) {
        return r0._switchStatus;
    }

    public final Observable<Integer> fetchExchangeStatus(int r12) {
        if (userLogin() == true) goto L6;
        return null;
    L6:
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        RxUtilKt.c(((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/growth/income_exchange/get_auto_exchange_status/", TypesJVMKt.getJavaType(Reflection.typeOf(GetAutoExchangeStatusResult.class)), Extra.class, r1.d, r1.a, r1.b, r1.c).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r12), b.a), this.cd);
        return this.switchObserver;
    }

    public final void updateExchangeStatus(boolean r2) {
        PropertyOwner<Integer> r0 = this._switchStatus;
        if (r2 == false) goto L5;
        AutoExchangeStatus r3 = AutoExchangeStatus.Open;
    L6:
        r0.a(Integer.valueOf(r3.getValue()));
        return;
    L5:
        r3 = AutoExchangeStatus.Closed;
        goto L6
    }

    public final void syncExchangeStatus(int r14, boolean r15) {
        if (userLogin() == true) goto L5;
        return;
    L5:
        tz0.b r0 = tz0.b.a;
        uz0.e r1 = new uz0.e();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r16 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("req_from", "$this$setTo");
        if (r16 == null) goto L8;
        r2.put("req_from", r16);
    L8:
        if (r15 == false) goto L10;
        AutoExchangeStatus r17 = AutoExchangeStatus.Open;
    L11:
        String r18 = Integer.valueOf(r17.getValue()).toString();
        Intrinsics.checkNotNullParameter("status", "$this$setTo");
        if (r18 == null) goto L14;
        r2.put("status", r18);
    L14:
        x.a(r1, false);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        RxUtilKt.c(((INetworkService) f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/growth/income_exchange/set_auto_exchange_status/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.network.response.a.class)), Extra.class, r1.d, r1.a, r1.b, r1.c, r1.e, r1.f, r1.g).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r15), e.a), this.cd);
        return;
    L10:
        r17 = AutoExchangeStatus.Closed;
        goto L11
    }

    public static /* synthetic */ Observable fetchExchangeStatus$default(ExchangeStatusRepository r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = ReqFrom.UnKnown.getValue();
    L6:
        return r0.fetchExchangeStatus(r1);
    }

    public static /* synthetic */ void syncExchangeStatus$default(ExchangeStatusRepository r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = ReqFrom.UnKnown.getValue();
    L5:
        r0.syncExchangeStatus(r1, r2);
    }
}
