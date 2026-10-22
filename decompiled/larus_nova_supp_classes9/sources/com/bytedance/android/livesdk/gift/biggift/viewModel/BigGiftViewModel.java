package com.bytedance.android.livesdk.gift.biggift.viewModel;

import android.os.SystemClock;
import android.os.Vibrator;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.configmodel.GiftAfterSendConfig;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftSendPreCheckService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.e0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.GiftTransactionReqCount;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.p;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.q2;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.i;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.k;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import oc6.n;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BigGiftViewModel implements o, n {
    public t a;
    public com.bytedance.android.livesdk.gift.model.n b;
    public final NextLiveData<com.bytedance.android.livesdk.gift.biggift.viewModel.a> c;
    public final com.bytedance.android.livesdk.gift.biggift.c d;
    public final NextLiveData<Map<String, Object>> e;
    public final NextLiveData<Long> f;
    public final NextLiveData<Pair<Long, Boolean>> g;
    public final CompositeDisposable h;
    public String i;
    public long j;
    public int k;
    public final GiftSendPreCheckService l;
    public final com.bytedance.android.livesdk.gift.platform.core.scope.service.n m;
    public final d0 n;
    public final GiftExtraRepo o;
    public final q2 p;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void a() {
        t r1 = this.a;
        if (r1 == null) goto L15;
        b0 r2 = r1.i();
        if (r2 == null) goto L19;
        Long r3 = this.o.s(r2.b);
        if (r3 == null) goto L16;
        long r4 = r3.longValue();
        c();
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r5 == null) goto L17;
        k<e0> r6 = r5.getOpenBigGiftDialogEvent();
        if (r6 == null) goto L18;
        r6.post(new e0(r4, 0, 1, null, null, null, r2.m, r2.f(), null, null, false, 0, 0, null, null, false, null, null, null, null, null, false, false, r2.P, r2.Q, null, false, null, null, null, null, null, BigGiftViewModel$continueSendOriginGift$1.INSTANCE, -50331848, 1));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L19:
        return;
    }

    public final void c() {
        if (this.c.getValue() == null) goto L21;
        Object r0 = this.c.getValue();
        Intrinsics.checkNotNull(r0);
        if (((com.bytedance.android.livesdk.gift.biggift.viewModel.a) r0).b <= 1) goto L21;
        t r1 = this.a;
        if (r1 == null) goto L21;
        b0 r2 = r1.i();
        if (r2 == null) goto L21;
        if (r2.r == true) goto L15;
        String r3 = String.valueOf(r2.b);
    L17:
        if (r2.r == false) goto L19;
        String r4 = String.valueOf(r2.b);
    L20:
        this.p.bh().onNext(new q2.a(r3, r4, this.k, ((dy1.a) com.bytedance.android.livesdk.gift.biggift.b.d.getValue(null, com.bytedance.android.livesdk.gift.biggift.b.a[2])).a(), 0, null, 48));
        goto L21
    L19:
        r4 = null;
        goto L20
    L15:
        r3 = null;
    L21:
        this.k = 0;
        t r5 = this.a;
        if (r5 == null) goto L24;
        r5.finish();
    L24:
        this.a = null;
        NextLiveData<com.bytedance.android.livesdk.gift.biggift.viewModel.a> r6 = this.c;
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r7 = (com.bytedance.android.livesdk.gift.biggift.viewModel.a) r6.getValue();
        if (r7 == null) goto L27;
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r8 = com.bytedance.android.livesdk.gift.biggift.viewModel.a.a(r7, CurrentState.DisMiss, 0, 0, null, 60);
    L28:
        r6.setValue(r8);
        this.f.setValue(null);
        this.g.setValue(null);
        return;
    L27:
        r8 = null;
        goto L28
    }

    public final void onStop() {
        this.h.dispose();
    }

    public final void triggerDeviceImpact() {
        Object r0 = s1.getContext().getSystemService("vibrator");
        if (r0 == null) goto L7;
        ((Vibrator) r0).vibrate(50);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    }

    public static /* synthetic */ void g(BigGiftViewModel r2) {
        r2.f(1, false);
    }

    public final void d(HashMap<String, String> r4) {
        r4.put("trigger_gift_id", String.valueOf(this.j));
        r4.put("event_session_id", this.i);
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.putAll(r4);
        m r5 = new m();
        r5.b(LogCommon.LIVE_SHARE_LOG);
        r5.b(LogCommon.ROOM);
        r5.b(LogCommon.RECOMMEND_SOURCE_LOG);
        i r2 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r2, "pageSourceLog");
        List r3 = r5.a;
        ArrayList r6 = (ArrayList) r3;
        r6.add(r2.a);
        List r7 = r0.b;
        ArrayList r8 = (ArrayList) r7;
        r8.addAll(r5.a);
        cy0.e.a.getClass();
        j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("livesdk_gift_combo_element_click", r0.a, r0.b);
    }

    public final void onChangeGift(long r61) {
        h1 r2 = GiftManagerKt.j(r61, null);
        if (r2 == null) goto L39;
        long r5 = r2.getId();
        t r3 = this.a;
        if (r3 == null) goto L10;
        b0 r4 = r3.i();
        if (r4 == null) goto L10;
        if (r5 != r4.b) goto L10;
        return;
    L10:
        Pair r6 = (Pair) this.g.getValue();
        long r7 = 1;
        if (r6 != null) goto L13;
    L14:
        this.g.postValue(new Pair(1L, Boolean.FALSE));
    L15:
        HashMap<String, String> r8 = new HashMap();
        t r9 = this.a;
        if (r9 == null) goto L20;
        b0 r10 = r9.i();
        if (r10 == null) goto L20;
        long r11 = r10.b;
    L21:
        r8.put("gift_id", String.valueOf(r11));
        Pair r13 = (Pair) this.g.getValue();
        if (r13 == null) goto L26;
        Long r14 = (Long) r13.getFirst();
        if (r14 == null) goto L26;
        r7 = r14.longValue();
    L26:
        r8.put("gift_cnt", String.valueOf(r7));
        h2 r15 = GiftManagerKt.l(r11);
        if (r15 == null) goto L29;
        int r16 = r15.getDiamondCount();
    L30:
        r8.put("gift_price", String.valueOf(r16));
        r8.put("element_name", "continue_gift");
        r8.put("switch_gift_id", String.valueOf(r61));
        d(r8);
        this.f.postValue(Long.valueOf(r61));
        t r17 = this.a;
        if (r17 == null) goto L41;
        b0 r18 = r17.i();
        if (r18 == null) goto L42;
        SendGiftSource r19 = r18.c;
        int r20 = r18.g;
        String r110 = r18.h;
        String r111 = r18.i;
        int r21 = r18.J;
        int r23 = r18.f;
        SendGiftStrategy r24 = r18.p;
        Map<String, String> r25 = r18.Y;
        List<IBaseUser> r26 = r18.w;
        b0 r59 = new b0(r61, r19, r18.d, null, r23, r20, r110, r111, null, null, 0, null, null, false, r24, 0, false, null, 0, r18.u, r18.v, r26, r18.x, 0, null, null, null, null, null, null, r18.F, null, r21, 0, null, null, false, null, null, null, null, null, null, false, null, null, r25, null, 0, null, null, -1081622776, 8257531);
        t r1 = this.a;
        if (r1 == null) goto L37;
        r1.finish();
    L37:
        this.b = null;
        h(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(r59), false);
        return;
    L42:
        return;
    L41:
        return;
    L29:
        r16 = 0;
    L20:
        r11 = 0;
        goto L21
    L13:
        if (((Number) r6.getFirst()).longValue() == 1) goto L15;
    }

    public final void onClickCombo(long r27) {
        long r1 = 0;
        if (r27 <= 0) goto L40;
        NextLiveData<Pair<Long, Boolean>> r3 = this.g;
        if (r3 == null) goto L11;
        Pair r4 = (Pair) r3.getValue();
        if (r4 == null) goto L11;
        Long r5 = (Long) r4.getFirst();
        if (r5 == null) goto L11;
        long r6 = r5.longValue();
    L13:
        if (r27 == r6) goto L41;
        HashMap<String, String> r7 = new HashMap();
        t r8 = this.a;
        if (r8 == null) goto L19;
        b0 r9 = r8.i();
        if (r9 == null) goto L19;
        r1 = r9.b;
    L19:
        r7.put("gift_id", String.valueOf(r1));
        Integer r10 = (Pair) this.g.getValue();
        if (r10 != null) goto L23;
        r10 = 1;
    L23:
        r7.put("gift_cnt", r10.toString());
        h2 r2 = GiftManagerKt.l(r1);
        if (r2 == null) goto L26;
        int r11 = r2.getDiamondCount();
    L27:
        r7.put("gift_price", String.valueOf(r11));
        r7.put("element_name", "continue_num");
        r7.put("switch_num", String.valueOf(r27));
        d(r7);
        this.g.postValue(new Pair(Long.valueOf(r27), Boolean.TRUE));
        if (r27 <= 1) goto L30;
        int r13 = 1;
    L31:
        t r14 = this.a;
        if (r14 == null) goto L42;
        b0 r15 = r14.i();
        if (r15 == null) goto L43;
        b0 r16 = b0.b(r15, 0, null, r13, null, null, null, null, null, null, 0, 0, null, null, -17, 8388607);
        t r17 = this.a;
        if (r17 == null) goto L38;
        r17.finish();
    L38:
        h(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(r16), false);
        return;
    L43:
        return;
    L42:
        return;
    L30:
        r13 = 5;
        goto L31
    L26:
        r11 = 0;
        goto L27
    L41:
        return;
    L11:
        r6 = 1;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int f(int r27, boolean r28) {
        int r3 = 0;
        if (r28 == true) goto L26;
        d0 r4 = this.n;
        if (r4 != null) goto L7;
    L9:
        HashMap<String, String> r5 = new HashMap();
        t r6 = this.a;
        if (r6 == null) goto L14;
        b0 r7 = r6.i();
        if (r7 == null) goto L14;
        long r8 = r7.b;
    L15:
        r5.put("gift_id", String.valueOf(r8));
        Pair r9 = (Pair) this.g.getValue();
        if (r9 == null) goto L20;
        Long r10 = (Long) r9.getFirst();
        if (r10 == null) goto L20;
        long r11 = r10.longValue();
    L21:
        r5.put("gift_cnt", String.valueOf(r11));
        h2 r13 = GiftManagerKt.l(r8);
        if (r13 == null) goto L24;
        int r14 = r13.getDiamondCount();
    L25:
        r5.put("gift_price", String.valueOf(r14));
        r5.put("element_name", "continue_button");
        d(r5);
        goto L26
    L24:
        r14 = 0;
    L20:
        r11 = 1;
    L14:
        r8 = 0;
        goto L15
    L7:
        if (com.bytedance.android.livesdk.gift.platform.business.b.c().a().getType() != GiftAfterSendConfig.FePageConfigType.DURATION_TYPE.getType()) goto L9;
        r4.c();
    L26:
        GiftSendPreCheckService r15 = this.l;
        t r16 = this.a;
        Object r17 = null;
        if (r16 == null) goto L32;
        b0 r18 = r16.i();
        if (r18 == null) goto L32;
        IBaseUser r19 = r18.f();
        if (r19 == null) goto L32;
    L40:
        if (r19 != null) goto L42;
        r19 = (IBaseUser) f.c(IBaseUser.class);
    L42:
        t r20 = this.a;
        if (r20 == null) goto L47;
        b0 r21 = r20.i();
        if (r21 == null) goto L47;
        ReceiverType r23 = r21.u;
    L48:
        t r24 = this.a;
        if (r24 == null) goto L53;
        b0 r25 = r24.i();
        if (r25 == null) goto L53;
        List<IBaseUser> r26 = r25.w;
    L54:
        int r29 = r15.d(r19, r23, r26);
        if (r29 == 0) goto L127;
        t r30 = this.a;
        if (r30 == null) goto L61;
        b0 r31 = r30.i();
        if (r31 == null) goto L61;
        long r33 = r31.b;
    L62:
        h.Q(r29, r33, 0);
        t r34 = this.a;
        if (r34 == null) goto L65;
        b0 r35 = r34.i();
    L66:
        String r210 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        boolean r36 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        if (r35 == null) goto L69;
        long r37 = r35.b;
    L70:
        if (r35 == null) goto L72;
        long r110 = r35.b;
    L73:
        if (r35 == null) goto L75;
        boolean r111 = r35.r;
    L76:
        if (r35 == null) goto L78;
        long r112 = r35.d();
    L80:
        if (r210 != null) goto L82;
        String r113 = BuildConfig.FLAVOR;
    L83:
        if (r35 == null) goto L85;
        String r114 = r35.c();
    L86:
        if (r35 == null) goto L88;
        String r211 = r35.g();
    L89:
        if (r35 == null) goto L91;
        long r212 = r35.e();
    L92:
        if (r35 == null) goto L94;
        int r213 = r35.J;
    L95:
        com.bytedance.android.livesdk.gift.platform.core.d0.p(r37, r110, r111, r112, r29, BuildConfig.FLAVOR, r113, r114, r211, r212, r213);
        if (r35 == null) goto L98;
        long r38 = r35.b;
    L99:
        if (r35 == null) goto L101;
        long r115 = r35.b;
    L102:
        if (r35 == null) goto L104;
        boolean r116 = r35.r;
    L105:
        if (r35 == null) goto L107;
        long r117 = r35.d();
    L109:
        if (r210 != null) goto L111;
        String r118 = BuildConfig.FLAVOR;
    L112:
        if (r35 == null) goto L114;
        String r119 = r35.c();
    L115:
        if (r35 == null) goto L117;
        String r214 = r35.g();
    L118:
        if (r35 == null) goto L120;
        long r215 = r35.e();
    L121:
        if (r35 == null) goto L123;
        int r216 = r35.J;
    L124:
        com.bytedance.android.livesdk.gift.platform.core.d0.q(r38, r115, r116, r117, r29, BuildConfig.FLAVOR, r118, r119, r214, r215, r216);
        jy0.b.c("BigGiftViewModel", "isPreCheckSendGift false", null, 4);
        return GiftTransactionReqCount.TransactionBlock.getValue();
    L123:
        r216 = 0;
        goto L124
    L120:
        r215 = 0;
        goto L121
    L117:
        r214 = BuildConfig.FLAVOR;
        goto L118
    L114:
        r119 = BuildConfig.FLAVOR;
        goto L115
    L111:
        r118 = r210;
        goto L112
    L107:
        r117 = 0;
        goto L109
    L104:
        r116 = false;
        goto L105
    L101:
        r115 = 0;
        goto L102
    L98:
        r38 = 0;
        goto L99
    L94:
        r213 = 0;
        goto L95
    L91:
        r212 = 0;
        goto L92
    L88:
        r211 = BuildConfig.FLAVOR;
        goto L89
    L85:
        r114 = BuildConfig.FLAVOR;
        goto L86
    L82:
        r113 = r210;
        goto L83
    L78:
        r112 = 0;
        goto L80
    L75:
        r111 = false;
        goto L76
    L72:
        r110 = 0;
        goto L73
    L69:
        r37 = 0;
        goto L70
    L65:
        r35 = null;
    L61:
        r33 = 0;
        goto L62
    L127:
        if (this.a != null) goto L129;
        jy0.b.c("BigGiftViewModel", "giftTransaction is null, send failed", null, 4);
    L129:
        com.bytedance.android.livesdk.gift.biggift.c r1 = this.d;
        r1.getClass();
        if (((com.bytedance.android.livesdk.gift.biggift.a) com.bytedance.android.livesdk.gift.biggift.d.b.getValue(null, com.bytedance.android.livesdk.gift.biggift.d.a[0])).b() == false) goto L141;
        long r39 = SystemClock.elapsedRealtime();
        long r40 = r39 - ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    L134:
        if (r1.a.isEmpty() == true) goto L138;
        if (((Number) r1.a.getFirst()).longValue() >= r40) goto L138;
        r1.a.popFirst();
    L138:
        r1.a.addLast(Long.valueOf(r39));
        if (r1.a.size() <= ((com.bytedance.android.livesdk.gift.biggift.a) com.bytedance.android.livesdk.gift.biggift.d.b.getValue(null, com.bytedance.android.livesdk.gift.biggift.d.a[0])).a()) goto L141;
        boolean r2 = true;
    L142:
        if (r2 == false) goto L151;
        ToastUtil.b("连击速度过快，请稍后重试", 0);
        c();
        t r41 = this.a;
        if (r41 == null) goto L148;
        b0 r43 = r41.i();
        if (r43 == null) goto L148;
        long r44 = r43.b;
    L149:
        h.Q(106, r44, 0);
        return 106;
    L148:
        r44 = 0;
        goto L149
    L151:
        Pair r45 = (Pair) this.g.getValue();
        if (r45 == null) goto L156;
        Long r46 = (Long) r45.getFirst();
        if (r46 == null) goto L156;
        int r47 = (int) r46.longValue();
    L157:
        t r48 = this.a;
        if (r48 == null) goto L160;
        Integer r49 = Integer.valueOf(r48.d(r47));
    L161:
        t r50 = this.a;
        if (r50 != null) goto L164;
    L194:
        if (r49 == null) goto L197;
        return r49.intValue();
    L197:
        return GiftTransactionReqCount.TransactionNull.getValue();
    L164:
        if (r50.isDisposed() == true) goto L194;
        NextLiveData<com.bytedance.android.livesdk.gift.biggift.viewModel.a> r51 = this.c;
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r53 = (com.bytedance.android.livesdk.gift.biggift.viewModel.a) r51.getValue();
        if (r53 == null) goto L193;
        CurrentState r54 = CurrentState.Combo;
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r55 = (com.bytedance.android.livesdk.gift.biggift.viewModel.a) this.c.getValue();
        if (r55 == null) goto L170;
        int r56 = r55.b;
    L171:
        int r57 = r56 + r47;
        t r58 = this.a;
        if (r58 == null) goto L176;
        p r59 = r58.a();
        if (r59 == null) goto L176;
        int r120 = r59.b;
    L177:
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r60 = (com.bytedance.android.livesdk.gift.biggift.viewModel.a) this.c.getValue();
        if (r60 == null) goto L192;
        e r61 = r60.d;
        if (r61 == null) goto L192;
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r63 = (com.bytedance.android.livesdk.gift.biggift.viewModel.a) this.c.getValue();
        if (r63 == null) goto L186;
        e r64 = r63.d;
        if (r64 == null) goto L186;
        int r65 = r64.b;
    L187:
        int r66 = r65 - 1;
        if (r66 <= 0) goto L191;
        r3 = r66;
    L191:
        q3 r67 = r61.a;
        Intrinsics.checkNotNullParameter(r67, "info");
        r17 = new e(r67, r3);
    L186:
        r65 = 0;
    L192:
        r17 = com.bytedance.android.livesdk.gift.biggift.viewModel.a.a(r53, r54, r57, r120, r17, 48);
    L176:
        r120 = 0;
        goto L177
    L170:
        r56 = 0;
    L193:
        r51.setValue(r17);
        goto L194
    L160:
        r49 = null;
    L156:
        r47 = r27;
    L141:
        r2 = false;
    L53:
        r26 = null;
    L47:
        r23 = null;
    L32:
        com.bytedance.android.livesdk.revenue.room.a r68 = g02.a.d();
        if (r68 == null) goto L39;
        com.bytedance.live.datacontext.m r69 = r68.getRoom();
        if (r69 == null) goto L39;
        IRoom r70 = (IRoom) r69.getValue();
        if (r70 == null) goto L39;
        r19 = r70.getOwner();
    L39:
        r19 = null;
        goto L40
    }

    public final void h(GiftTransaction r9, boolean r10) {
        if (r10 == false) goto L9;
        if (r9 == null) goto L7;
        b0 r11 = r9.x;
        if (r11 == null) goto L7;
        long r0 = r11.b;
    L8:
        this.j = r0;
    L7:
        r0 = 0;
    L9:
        if (r9 == null) goto L13;
        b0 r13 = r9.x;
        if (r13 == null) goto L13;
        r13.a = String.valueOf(System.currentTimeMillis());
    L13:
        this.a = r9;
        if (r9 == null) goto L16;
        r9.h(new b(this));
    L16:
        if (r9 == null) goto L24;
        Observable<ExtraResponse<p2, ? extends Extra>> r14 = r9.getObservable();
        if (r14 == null) goto L24;
        Observable r15 = r14.observeOn(AndroidSchedulers.mainThread());
        if (r15 == null) goto L24;
        Disposable r16 = r15.subscribe(new c(this), d.a);
        if (r16 == null) goto L24;
        RxUtilKt.c(r16, this.h);
    L24:
        NextLiveData<com.bytedance.android.livesdk.gift.biggift.viewModel.a> r17 = this.c;
        CurrentState r1 = CurrentState.Init;
        t r2 = this.a;
        if (r2 == null) goto L43;
        b0 r3 = r2.i();
        if (r3 == null) goto L43;
        Long r4 = this.o.s(r3.b);
        if (r4 == null) goto L43;
        t r5 = this.a;
        if (r5 == null) goto L35;
        b0 r6 = r5.i();
        if (r6 == null) goto L35;
        int r7 = r6.l;
    L36:
        if (r7 != 0) goto L43;
        g0 r8 = this.o.q(r4.longValue());
        if (r8 == null) goto L43;
        q3 r18 = r8.getSubscribeGiftPackInfo();
        if (r18 == null) goto L43;
        e r19 = new e(r18, r18.getLeftScores());
    L44:
        t r20 = this.a;
        if (r20 == null) goto L53;
        b0 r21 = r20.i();
        if (r21 == null) goto L53;
        long r23 = r21.b;
        t r24 = this.a;
        if (r24 == null) goto L53;
        b0 r25 = r24.i();
        if (r25 == null) goto L53;
        l1 r26 = this.o.o(r25.l, r23);
    L54:
        r17.setValue(new com.bytedance.android.livesdk.gift.biggift.viewModel.a(r1, 0, 0, r19, r26, this.b));
        return;
    L53:
        r26 = null;
    L35:
        r7 = 0;
    L43:
        r19 = null;
        goto L44
    }

    public BigGiftViewModel(GiftSendPreCheckService r8, com.bytedance.android.livesdk.gift.platform.core.scope.service.n r9, d0 r10, GiftExtraRepo r11, q2 r13) {
        Intrinsics.checkNotNullParameter(r8, "giftSendPreCheckService");
        Intrinsics.checkNotNullParameter(r9, "dialogAfterSendService");
        Intrinsics.checkNotNullParameter(r10, "fePageAfterSendService");
        Intrinsics.checkNotNullParameter(r11, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r13, "carnivalInRoomMessageService");
        this.l = r8;
        this.m = r9;
        this.n = r10;
        this.o = r11;
        this.p = r13;
        NextLiveData<com.bytedance.android.livesdk.gift.biggift.viewModel.a> r14 = new NextLiveData();
        this.c = r14;
        this.d = new com.bytedance.android.livesdk.gift.biggift.c();
        this.e = new NextLiveData();
        this.f = new NextLiveData();
        this.g = new NextLiveData();
        this.h = new CompositeDisposable();
        this.i = BuildConfig.FLAVOR;
        r14.setValue(new com.bytedance.android.livesdk.gift.biggift.viewModel.a(CurrentState.Init, 0, 0, null, null, null));
    }
}
