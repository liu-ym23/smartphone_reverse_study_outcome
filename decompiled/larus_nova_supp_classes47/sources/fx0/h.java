package fx0;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.event.v;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements n56.c {
    public final WeakReference<Context> a;
    public final n56.a b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            v r5 = (v) r4;
            JSONObject r6 = new JSONObject();
            r6.put(Constants.OperatorKey.CODE, 1);
            r6.put("current_diamond", ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getAvailableDiamonds());
            n56.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.f("h5_live_recharge", r6);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public h(WeakReference<Context> r1, n56.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public void call(n56.f r32, JSONObject r33) {
        if (r33 == null) goto L50;
        if (r32 == null) goto L6;
        JSONObject r4 = r32.d;
    L7:
        if (r4 == null) goto L51;
        JSONObject r5 = r32.d;
        String r6 = "";
        if (r5 != null) goto L12;
        String r12 = "H5";
        String r13 = r12;
        int r10 = 1;
    L19:
        String r3 = "";
        String r7 = r3;
        String r14 = "H5";
        long r22 = 0;
        long r24 = 0;
        long r26 = 0;
        long r28 = 0;
    L20:
        String r15 = r13;
        String r16 = r12;
        int r17 = r10;
        Observable r8 = xs2.b.a().b(v.class).compose(RxUtil.rxSchedulerHelper());
        WeakReference<Context> r9 = this.a;
        if (r9 == null) goto L23;
        Context r18 = r9.get();
    L24:
        ((ObservableSubscribeProxy) r8.as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(r18)))).subscribe(new b(this), c.a);
        x2 r19 = new x2(r17, r16, r15, r14, 0);
        long r110 = r28;
        if (r110 <= 0) goto L27;
        r19.g = r110;
    L27:
        long r111 = r22;
        if (r111 <= 0) goto L30;
        r19.h = r111;
    L30:
        long r112 = r24;
        if (r112 <= 0) goto L33;
        r19.i = r112;
    L33:
        long r113 = r26;
        if (r113 <= 0) goto L37;
        r19.k = r113;
    L37:
        if (TextUtils.isEmpty(r3) == true) goto L40;
        r19.l = r3;
    L40:
        if (TextUtils.isEmpty(r7) == true) goto L42;
        r19.o = r7;
    L42:
        String r1 = r32.g;
        if (r1 == null) goto L48;
        String r2 = UriProtector.parse(r1).getPath();
        if (r2 == null) goto L48;
        r6 = r2;
    L48:
        r19.s = r6;
        r19.r = "OpenLiveRechargeJavaMethod";
        xs2.b.a().post(r19);
        r33.put(Constants.OperatorKey.CODE, 1);
        return;
    L23:
        r18 = null;
        goto L24
    L12:
        if (TextUtils.equals("new_page", r5.optString("type", "")) == false) goto L14;
        r10 = 2;
    L15:
        r12 = r5.optString("enter_from", "H5");
        r13 = r5.optString("click_type", "H5");
        JSONObject r20 = r5.optJSONObject("args");
        if (r20 == null) goto L19;
        String r23 = r20.optString("charge_reason", "H5");
        r20.optInt("charge_type");
        long r114 = r20.optLong("previous_gift_id", 0);
        long r115 = r20.optLong("previous_gift_money", 0);
        long r116 = r20.optLong("previous_pay_money", 0);
        long r25 = r20.optLong("money_diff", 0);
        r3 = r20.optString("previous_gift_type", "");
        r7 = r20.optString("request_page", "");
        r22 = r114;
        r24 = r115;
        r26 = r116;
        r28 = r25;
        r14 = r23;
        goto L20
    L14:
        r10 = 1;
        goto L15
    L51:
        return;
    L6:
        r4 = null;
        goto L7
    }
}
