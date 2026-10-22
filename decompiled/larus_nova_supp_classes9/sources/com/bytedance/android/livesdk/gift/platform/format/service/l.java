package com.bytedance.android.livesdk.gift.platform.format.service;

import am2.f0;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.MinorExtra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.s0;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.NetworkUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements ca0.d, o {
    public final CompositeDisposable a;
    public WeakReference<Context> b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ l a;
        public final /* synthetic */ long b;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.format.service.a c;

        public a(l r1, long r2, com.bytedance.android.livesdk.gift.platform.format.service.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r23) {
            ExtraResponse r1 = (ExtraResponse) r23;
            long r9 = com.bytedance.live.kmp.util.e.b();
            l r2 = this.a;
            p2 r3 = (p2) r1.data;
            long r5 = this.b;
            r2.getClass();
            String r4 = v12.f.a;
            String r6 = r3.getTraceId();
            String r11 = "0";
            if (r6 != null) goto L5;
            String r7 = "0";
        L6:
            String r8 = r3.getLogId();
            if (r8 != null) goto L9;
            String r10 = "0";
        L10:
            v12.f.R(r3, r7, r10, r5, r9);
            c0 r13 = c0.a;
            long r14 = this.c.a;
            String r15 = ((p2) r1.data).getLogId();
            IBaseUser r16 = vh7.f.c(IBaseUser.class);
            r16.setIdString(this.c.d.toString());
            Unit r17 = Unit.INSTANCE;
            c0.l(r14, 0, r15, r9, r16);
            jc1.k.n(IRechargeService.class).rechargeCenter().sync("format send gift success");
            mz0.n r18 = new mz0.n();
            Map r19 = r18.a;
            Intrinsics.checkNotNullParameter(r19, "map");
            Map<String, String> r20 = this.c.i;
            if (r20 != null) goto L13;
            this.a.getClass();
            r20 = null;
        L13:
            if (r20 != null) goto L15;
            r20 = MapsKt.emptyMap();
        L15:
            Intrinsics.checkNotNullParameter(r20, "map");
            r19.putAll(r20);
            String r21 = this.c.f;
            Intrinsics.checkNotNullParameter("gift_source", "key");
            Intrinsics.checkNotNullParameter(r21, "value");
            r19.put("gift_source", r21);
            String r24 = this.c.h;
            Intrinsics.checkNotNullParameter("gift_show_from", "key");
            Intrinsics.checkNotNullParameter(r24, "value");
            r19.put("gift_show_from", r24);
            h1 r25 = ((p2) r1.data).getGift();
            if (r25 == null) goto L21;
            String r26 = String.valueOf(r25.getDiamondCount());
            if (r26 == null) goto L21;
            r11 = r26;
        L21:
            Intrinsics.checkNotNullParameter("money_per_unit", "key");
            Intrinsics.checkNotNullParameter(r11, "value");
            r19.put("money_per_unit", r11);
            mz0.m r27 = new mz0.m();
            h1 r28 = ((p2) r1.data).getGift();
            if (r28 == null) goto L24;
            int r29 = r28.getDiamondCount();
        L25:
            long r110 = ((p2) r1.data).getPropId();
            l2 r111 = ((p2) r1.data).getProp();
            ((p2) r1.data).getSendType();
            long r112 = this.c.c;
            r27.d(new f0(((p2) r1.data).getGiftId(), r28, r110, r111, r112, r112, 1, r29));
            ((ArrayList) r18.b).addAll(r27.a);
            cy0.e.a.getClass();
            cy0.j r30 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r31 = com.bytedance.android.scope.m.b(r30).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r31);
            ((f80.a) r31).w3("livesdk_send_gift", r18.a, r18.b);
            return;
        L24:
            r29 = 0;
            goto L25
        L9:
            r10 = r8;
            goto L10
        L5:
            r7 = r6;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ l a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.format.service.a c;

        public b(l r1, String r2, com.bytedance.android.livesdk.gift.platform.format.service.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            CustomApiServerException r5 = (Throwable) r4;
            if ((r5 instanceof CustomApiServerException) == false) goto L15;
            CustomApiServerException r0 = r5;
            String r1 = r0.getTraceId();
            if (r1 != null) goto L7;
        L10:
            boolean r2 = true;
        L11:
            if (r2 == false) goto L13;
            String r3 = this.b;
        L14:
            l.a(this.a, r5, this.c, r3);
            return;
        L13:
            r3 = r0.getTraceId();
            goto L14
        L7:
            if (r1.length() == 0) goto L10;
            r2 = false;
            goto L11
        L15:
            l.a(this.a, r5, this.c, this.b);
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (p2) r3.data;
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ l a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;
        public final /* synthetic */ String i;
        public final /* synthetic */ Map j;

        public d(l r1, long r2, Context r4, int r5, String r6, String r7, String r8, int r9, String r10, Map r11) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
        }

        public final Object apply(Object r15) {
            ExtraResponse r16 = (ExtraResponse) r15;
            Intrinsics.checkNotNullParameter(r16, "it");
            List<h1> r17 = ((s0) r16.data).getGiftList();
            if (r17 == null) goto L11;
            Iterator<T> r18 = r17.iterator();
        L6:
            if (r18.hasNext() == false) goto L11;
            h1 r0 = (h1) r18.next();
            long r1 = r0.getId();
            long r4 = this.b;
            if (r1 != r4) goto L6;
            return this.a.g(this.c, new com.bytedance.android.livesdk.gift.platform.format.service.a(r4, r0.getDiamondCount(), this.d, this.e, this.f, this.g, this.h, this.i, this.j));
        L11:
            return Observable.error(new IllegalStateException("gift isn't exist"));
        }
    }

    public final void onStart() {
        this.a.add(com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).O3(r12.b.a));
    }

    public final void onStop() {
        this.a.dispose();
        this.a.clear();
    }

    public l() {
        this.a = new CompositeDisposable();
    }

    public final void f(com.bytedance.android.livesdk.gift.platform.format.service.a r33) {
        ToastUtil.a(2131922445, 0);
        long r4 = jc1.k.n(IRechargeService.class).rechargeCenter().getAvailableDiamonds();
        int r2 = r33.b;
        long r10 = r33.c * r2;
        long r5 = r10 - r4;
        if (r5 >= 0) goto L5;
        long r20 = 0;
    L6:
        long r13 = r33.a;
        long r1 = r2;
        Unit r6 = Unit.INSTANCE;
        if (TextUtils.isEmpty("gift") == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty("gift_no_balance") == false) goto L12;
        return;
    L12:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).interceptOperation("recharge") == true) goto L51;
        com.bytedance.android.live.recharge.model.a r7 = new com.bytedance.android.live.recharge.model.a(0);
        if (com.bytedance.android.livesdk.gift.platform.core.g.a() != com.bytedance.android.livesdk.gift.platform.core.g.e) goto L37;
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = null;
        WeakReference<Context> r9 = this.b;
        if (r9 == null) goto L47;
        FragmentActivity r11 = (Context) r9.get();
        if (r11 != null) goto L22;
        return;
    L22:
        if ((r11 instanceof FragmentActivity) == false) goto L25;
        r8.element = r11;
    L25:
        if (((FragmentActivity) r8.element) != null) goto L28;
        return;
    L28:
        if (TextUtils.equals("gift_recharge", "gift_no_balance") == false) goto L30;
        String r3 = "click";
    L31:
        String r26 = r3;
        if (r20 <= 0) goto L34;
        boolean r25 = true;
    L35:
        final com.bytedance.android.live.recharge.model.d r14 = new com.bytedance.android.live.recharge.model.d(true, "gift", null, r20, r25, 0, 0, "gift_no_balance", r26, new com.bytedance.android.live.recharge.model.b(BuildConfig.FLAVOR, "single_gift", r10, r1, r13, 1, r7, 128), null, null, null, 31844);
        v02.b.a(0, false, new FormatSendGiftService$showRechargeDialog$1(r8, r14), 7);
        goto L47
    L34:
        r25 = false;
        goto L35
    L30:
        r3 = "call";
    L47:
        return;
    L37:
        WeakReference<Context> r15 = this.b;
        if (r15 == null) goto L48;
        Context r16 = r15.get();
        if (r16 != null) goto L43;
        return;
    L43:
        if ((r16 instanceof Activity) == false) goto L49;
        vh6.c.b(wh6.a.class).openWallet((Activity) r16);
        return;
    L49:
        return;
    L48:
        return;
    L51:
        return;
    L5:
        r20 = r5;
        goto L6
    }

    public final Observable<p2> g(Context r30, com.bytedance.android.livesdk.gift.platform.format.service.a r31) {
        Intrinsics.checkNotNullParameter(r30, "context");
        Intrinsics.checkNotNullParameter(r31, "giftInfo");
        this.b = new WeakReference(r30);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == true) goto L6;
        ToastUtil.a(2131916005, 0);
    L15:
        boolean r1 = false;
    L17:
        if (r1 == false) goto L19;
        String r2 = v12.f.f();
        long r5 = com.bytedance.live.kmp.util.e.b();
        v12.f.P(r2, new v12.g(r31.a, SendGiftSource.Format, r31.d.toString(), "0", 0, 0, false, SendGiftStrategy.ONLY_SEND_ONCE, 1, false, 0, 4096, false, BuildConfig.FLAVOR, null, null, null, null, null));
        tz0.b r3 = tz0.b.a;
        uz0.e r7 = new uz0.e();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r7, "$this$beforeConfigureRequest");
        Map r4 = ((uz0.a) r7).b;
        Intrinsics.checkNotNullParameter(r4, "queriesMap");
        Integer r6 = 0;
        String r8 = r6.toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r8 == null) goto L23;
        r4.put("room_id", r8);
    L23:
        Map r9 = r7.e;
        Intrinsics.checkNotNullParameter(r9, "fieldsMap");
        String r10 = Long.valueOf(r31.a).toString();
        Intrinsics.checkNotNullParameter("gift_id", "$this$setTo");
        if (r10 == null) goto L26;
        r9.put("gift_id", r10);
    L26:
        String r11 = Integer.valueOf(r31.c).toString();
        Intrinsics.checkNotNullParameter("count", "$this$setTo");
        if (r11 == null) goto L29;
        r9.put("count", r11);
    L29:
        String r13 = r31.d;
        Intrinsics.checkNotNullParameter("to_user_id", "$this$setTo");
        if (r13 == null) goto L32;
        r9.put("to_user_id", r13);
    L32:
        String r14 = Integer.valueOf(r31.g).toString();
        Intrinsics.checkNotNullParameter("buff_level", "$this$setTo");
        if (r14 == null) goto L35;
        r9.put("buff_level", r14);
    L35:
        Integer r15 = 4096;
        String r16 = r15.toString();
        Intrinsics.checkNotNullParameter("send_scene", "$this$setTo");
        if (r16 == null) goto L38;
        r9.put("send_scene", r16);
    L38:
        JSONObject r17 = new JSONObject();
        r17.put("ds_alert_controller", 1);
        String r18 = r17.toString();
        Intrinsics.checkNotNullParameter("extra", "$this$setTo");
        if (r18 == null) goto L41;
        r9.put("extra", r18);
    L41:
        Map r19 = ((uz0.a) r7).a;
        Intrinsics.checkNotNullParameter(r19, "headersMap");
        Intrinsics.checkNotNullParameter("rpc-persist-webcast-trace-id", "$this$setTo");
        Intrinsics.checkNotNullParameter(r2, "value");
        r19.put("rpc-persist-webcast-trace-id", r2);
        r7.a(new com.bytedance.android.livesdk.gift.platform.core.interceptor.a());
        Intrinsics.checkNotNullParameter(r7, "$this$afterConfigureRequest");
        return com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/gift/send/", TypesJVMKt.getJavaType(Reflection.typeOf(p2.class)), MinorExtra.class, ((uz0.a) r7).d, ((uz0.a) r7).a, ((uz0.a) r7).b, ((uz0.a) r7).c, r7.e, r7.f, r7.g).compose(RxUtil.rxSchedulerHelper()).doOnNext(new a(this, r5, r31)).doOnError(new b(this, r2, r31)).map(c.a);
    L19:
        return Observable.error(new IllegalStateException("preCheck not pass"));
    L6:
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L13;
        final Bundle r20 = new Bundle();
        WeakReference<Context> r21 = this.b;
        if (r21 == null) goto L15;
        Context r23 = r21.get();
        if (r23 == null) goto L15;
        final String r24 = "live_detail";
        this.a.add(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).z4(r23, new FormatSendGiftService$preCheck$$inlined$let$lambda$1(this, r24, r20)).subscribe(j.a, k.a));
        goto L15
    L13:
        if (vh6.c.b(wh6.a.class).isNeedProtectUnderage() == false) goto L16;
        ToastUtil.a(2131919796, 0);
        goto L15
    L16:
        r1 = true;
        goto L17
    }

    public static final void a(l r7, Throwable r8, com.bytedance.android.livesdk.gift.platform.format.service.a r9, String r10) {
        r7.getClass();
        int r0 = r9.c;
        JSONObject r1 = new JSONObject();
        r1.put("count", r0);
        r1.put("throwable", r8.getMessage());
        String r2 = v12.f.a;
        if (r10 != null) goto L5;
        r10 = "0";
    L5:
        v12.f.Q(r10, r1);
        if ((r8 instanceof Exception) == true) goto L8;
        r8 = null;
    L8:
        ApiServerException r11 = (Exception) r8;
        if (r11 == null) goto L23;
        c0 r3 = c0.a;
        long r4 = r9.a;
        IBaseUser r6 = (IBaseUser) vh7.f.c(IBaseUser.class);
        r6.setIdString(r9.d.toString());
        Unit r13 = Unit.INSTANCE;
        r3.k(r4, 0, r11, r6);
        if ((r11 instanceof ApiServerException) == true) goto L13;
        ToastUtil.a(2131922449, 0);
        return;
    L13:
        if (r11.getErrorCode() == 40001) goto L20;
        WeakReference<Context> r14 = r7.b;
        if (r14 == null) goto L18;
        Context r15 = r14.get();
        if (r15 == null) goto L18;
    L19:
        com.bytedance.android.live.revenue.common.k.a(r15, r11);
        return;
    L18:
        r15 = com.bytedance.live.kmp.util.c.a.getContext();
        goto L19
    L20:
        r7.f(r9);
        return;
    }

    public final Observable<p2> n(Context r26, long r27, int r29, String r30, int r31, String r33, String r34, int r35, String r36, Map<String, String> r37) {
        Intrinsics.checkNotNullParameter(r26, "context");
        Intrinsics.checkNotNullParameter(r30, "toUserId");
        Intrinsics.checkNotNullParameter(r33, "requestPage");
        Intrinsics.checkNotNullParameter(r34, "giftSourceLog");
        Intrinsics.checkNotNullParameter(r36, "giftShowFrom");
        if (r31 > 0) goto L16;
        tz0.b r1 = tz0.b.a;
        uz0.c r2 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map r3 = ((uz0.a) r2).b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        String r0 = CollectionsKt.joinToString$default(CollectionsKt.mutableListOf(new String[]{String.valueOf(r27)}), ",", null, null, 0, null, null, 62, null);
        Intrinsics.checkNotNullParameter("gift_ids", "$this$setTo");
        if (r0 == null) goto L7;
        r3.put("gift_ids", r0);
    L7:
        Long r4 = 0L;
        String r5 = r4.toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r5 == null) goto L10;
        r3.put("room_id", r5);
    L10:
        Integer r6 = 3;
        String r7 = r6.toString();
        Intrinsics.checkNotNullParameter("fetch_from", "$this$setTo");
        if (r7 == null) goto L13;
        r3.put("fetch_from", r7);
    L13:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(r1.b(), "/webcast/gift/detail/", TypesJVMKt.getJavaType(Reflection.typeOf(s0.class)), Extra.class, ((uz0.a) r2).d, ((uz0.a) r2).a, ((uz0.a) r2).b, ((uz0.a) r2).c).compose(RxUtil.rxSchedulerHelper()).flatMap(new d(this, r27, r26, r29, r30, r33, r34, r35, r36, r37));
    L16:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.c.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.c.a[0])).booleanValue() == false) goto L24;
        if (jc1.k.n(IRechargeService.class).rechargeCenter().isSyncWalletInfoSuccess() == false) goto L24;
        if (jc1.k.n(IRechargeService.class).rechargeCenter().getAvailableDiamonds() >= (r31 * r29)) goto L24;
        this.b = new WeakReference(r26);
        f(new com.bytedance.android.livesdk.gift.platform.format.service.a(r27, r31, r29, r30, r33, r34, r35, r36, r37));
        return Observable.error(new IllegalStateException("money not enough"));
    L24:
        return g(r26, new com.bytedance.android.livesdk.gift.platform.format.service.a(r27, r31, r29, r30, r33, r34, r35, r36, r37));
    }
}
