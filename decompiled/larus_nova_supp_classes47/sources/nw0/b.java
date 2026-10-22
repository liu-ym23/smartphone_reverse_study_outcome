package nw0;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.util.d;
import com.bytedance.android.live.recharge.utils.f;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.CoinConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import j40.m;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import pa0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(Object r19) {
        a r2 = this.a;
        ExchangeInfo r0 = ((e) r19).a();
        Context r3 = r2.j;
        int r6 = 0;
        if (r3 == null) goto L19;
        if (d.b(r3) == false) goto L12;
        View r1 = r2.e;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
    L9:
        TextView r4 = r2.g;
        if (r4 == null) goto L91;
        r4.setVisibility(8);
        return;
    L91:
        return;
    L12:
        int r5 = ((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getExchangeDiamond();
        if (r2.c == true) goto L15;
        int r7 = gx0.b.a;
        Integer r8 = Integer.valueOf(r5);
        HashMap r9 = new HashMap();
        r9.put("request_page", "gift_entrance");
        r9.put("charge_reason", "exchange_diamond");
        r9.put("available_exchange_diamond", String.valueOf(r8));
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r10 = f.a;
        f.d("livesdk_exchange_entrance_show", r9, new Class[]{IRoom.class, x.class});
        r2.c = true;
    L15:
        View r12 = r2.e;
        if (r12 == null) goto L19;
        r12.setVisibility(0);
    L19:
        if (r0.getExchangeBalance() != (-1)) goto L21;
        int r13 = 0;
    L23:
        if (r0.getGoldBalance() != (-1)) goto L25;
        int r14 = 0;
    L27:
        if (com.bytedance.android.live.recharge.util.e.a() == 0) goto L32;
        if (r0.getHideCombineExchange() == true) goto L32;
        r13 = r13 + r14;
    L32:
        if (r2.i != 1) goto L34;
        r2.g.setText(s1.C(2131915533, new Object[]{Long.valueOf(((long) r13) / 10), r3.b()}));
    L36:
        if ((r2.e instanceof TextView) == false) goto L39;
        com.bytedance.android.livesdk.r3.a(r2.e, ((TextView) r2.e).getText().toString() + r2.g.getText());
    L39:
        if (com.bytedance.android.live.recharge.util.e.a() != 0) goto L41;
    L50:
        com.bytedance.android.live.recharge.util.a r15 = com.bytedance.android.live.recharge.util.a.i;
        r15.getClass();
        if (((Boolean) com.bytedance.android.live.recharge.util.a.c.getValue(r15, com.bytedance.android.live.recharge.util.a.a[1])).booleanValue() == true) goto L56;
        ViewUtilsKt.e(r2.g);
        Function1<Integer, Unit> r16 = r2.h;
        if (r16 == null) goto L63;
        Unit r17 = (Unit) r16.invoke(8);
    L63:
        com.bytedance.tools.kcp.spongepreference.runtime.a r18 = lw0.a.d;
        KProperty[] r20 = lw0.a.a;
        if (((Boolean) r18.getValue(null, r20[2])).booleanValue() == true) goto L87;
        View r22 = LayoutInflater.from(r2.j).inflate(2131566656, null);
        TextView r23 = (TextView) r22.findViewById(2131389480);
        boolean r110 = ((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getHideCombineExchange();
        r23.setText(s1.C(2131915517, new Object[]{r3.c()}));
        if (com.bytedance.android.live.recharge.util.e.a() == 0) goto L70;
        if (r110 == true) goto L70;
        r23.setText(s1.C(2131915516, new Object[]{r3.c()}));
    L70:
        HSImageView r24 = r22.findViewById(2131389479);
        if (((CoinConfig) m.a.getValue()).isNew() == false) goto L73;
        a1.m(r24, 2131250172);
    L74:
        yo2.e r111 = new yo2.e(r2.j);
        ((yo2.d) r111).d = r22;
        ((yo2.d) r111).e = 0;
        ((yo2.d) r111).l = true;
        long r112 = 5;
        ((yo2.d) r111).m = r112;
        ((yo2.d) r111).v = true;
        r111.a();
        r2.a = r111;
        View r113 = r2.e;
        if (r113 == null) goto L87;
        if (r2.i != 1) goto L80;
        r6 = s1.f(16.0f);
    L80:
        if (r2.i != 1) goto L82;
        int r25 = s1.f(36.0f);
    L83:
        r111.i(r113, 1, 0, r6, r25);
        if (((Boolean) j.d.getValue(null, j.a[2])).booleanValue() == true) goto L86;
        r2.b.add(Observable.timer(r112, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r2), RxUtil.getNoOpThrowable()));
    L86:
        r18.setValue(null, r20[2], Boolean.TRUE);
        goto L87
    L82:
        r25 = -s1.f(4.0f);
        goto L83
    L73:
        a1.m(r24, 2131250171);
    L87:
        Function1<Integer, Unit> r26 = r2.h;
        if (r26 == null) goto L93;
        Unit r27 = (Unit) r26.invoke(200);
        return;
    L93:
        return;
    L56:
        if (r0.getExchangeDiamond() > 0) goto L60;
        ViewUtilsKt.e(r2.g);
        Function1<Integer, Unit> r28 = r2.h;
        if (r28 == null) goto L63;
        Unit r29 = (Unit) r28.invoke(8);
        goto L63
    L60:
        ViewUtilsKt.f(r2.g);
        Function1<Integer, Unit> r30 = r2.h;
        if (r30 == null) goto L63;
        Unit r32 = (Unit) r30.invoke(0);
        goto L63
    L41:
        if (r0.getHideCombineExchange() == true) goto L50;
        if (r13 >= 10) goto L47;
        ViewUtilsKt.e(r2.g);
        Function1<Integer, Unit> r33 = r2.h;
        if (r33 == null) goto L63;
        Unit r34 = (Unit) r33.invoke(8);
        goto L63
    L47:
        ViewUtilsKt.f(r2.g);
        Function1<Integer, Unit> r35 = r2.h;
        if (r35 == null) goto L63;
        Unit r36 = (Unit) r35.invoke(0);
        goto L63
    L34:
        r2.g.setText(s1.C(2131915532, new Object[]{Long.valueOf(((long) r13) / 10), r3.b()}));
        goto L36
    L25:
        r14 = r0.getGoldBalance();
        goto L27
    L21:
        r13 = r0.getExchangeBalance();
        goto L23
    }
}
