package fx0;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@XBridgeMethod(biz = "webcast", name = "showIncomeExchangeDialog")
public final class b extends com.bytedance.ies.web.jsbridge2.f<C0240b, c> {
    public static final /* synthetic */ int b = 0;
    public Disposable a;

    public static final class a {
    }

    /* JADX INFO: renamed from: fx0.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lfx0/b$b;", "", "", "diamond", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "topImage", "b", "setTopImage", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C0240b {

        @SerializedName("diamond")
        private Long diamond;

        @SerializedName("topImage")
        private String topImage;

        @SerializedName("type")
        private String type;

        public C0240b() {
        }

        public final Long a() {
            return this.diamond;
        }

        public final String b() {
            return this.topImage;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lfx0/b$c;", "", "", "result", "Ljava/lang/String;", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c {

        @SerializedName("result")
        private String result;

        public final void setResult(String r1) {
            this.result = r1;
        }

        public c(int r2, Throwable r3) {
            if ((r3 instanceof ApiServerException) == false) goto L5;
            String r4 = String.valueOf(((ApiServerException) r3).getErrorCode());
        L6:
            this.result = r4;
            return;
        L5:
            r4 = String.valueOf(r2);
            goto L6
        }
    }

    static {
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.a;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.a;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public b() {
    }

    public final void invoke(Object r9, CallContext r10) {
        C0240b r2 = (C0240b) r9;
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        String r12 = r2.b();
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L14;
        py.k r14 = (py.k) vh7.f.c(py.k.class);
        ArrayList r0 = new ArrayList();
        String r1 = r2.b();
        if (r1 == null) goto L13;
        r0.add(r1);
    L13:
        Unit r3 = Unit.INSTANCE;
        r14.setUrls(r0);
    L15:
        py.k r6 = r14;
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        ExchangeTraceGiftSource r15 = ExchangeTraceGiftSource.EXCHANGE_SOURCE_OTHER;
        r4.element = r15;
        String r5 = r2.getType();
        if (r5 != null) goto L19;
    L36:
        r4.element = r15;
        ExchangeType r16 = ExchangeType.EXCHANGE_TYPE_GIFT;
    L37:
        ExchangeType r7 = r16;
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("exchange");
        this.a = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r2, r4, r10, r7, r6), new e(this));
        return;
    L19:
        switch(r5.hashCode()) {
            case 49: goto L34;
            case 50: goto L31;
            case 51: goto L28;
            case 52: goto L25;
            case 53: goto L22;
            default: goto L36;
        };
    L22:
        if (r5.equals("5") == false) goto L36;
        r4.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_LOTTERY_FANS_CLUB;
        r16 = ExchangeType.EXCHANGE_TYPE_LOTTERY_JOIN_FANS;
        goto L37
    L25:
        if (r5.equals("4") == false) goto L36;
        r4.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_FANS_CLUB_SEND_GIFT;
        r16 = ExchangeType.EXCHANGE_TYPE_FANS_SEND_GIFT;
        goto L37
    L28:
        if (r5.equals("3") == false) goto L36;
        r4.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_LOTTERY;
        r16 = ExchangeType.EXCHANGE_TYPE_LOTTERY;
        goto L37
    L31:
        if (r5.equals("2") == false) goto L36;
        r4.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_RED_PACKET;
        r16 = ExchangeType.EXCHANGE_TYPE_RED_PACKET;
        goto L37
    L34:
        if (r5.equals(DataType.TRUE) == false) goto L36;
        r4.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_FANS_CLUB;
        r16 = ExchangeType.EXCHANGE_TYPE_FANS;
        goto L37
    L14:
        r14 = null;
        goto L15
    L5:
        if (StringsKt.isBlank(r12) == true) goto L8;
        r13 = false;
        goto L9
    }
}
