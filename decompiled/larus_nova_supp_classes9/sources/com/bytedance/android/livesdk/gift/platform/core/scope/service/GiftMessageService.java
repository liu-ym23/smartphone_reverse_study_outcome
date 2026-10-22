package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.livesdk.gift.configmodel.RevGiftConsumerRemindConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager;
import com.bytedance.android.livesdk.gift.platform.business.tray2.VSGiftMessageManager;
import com.bytedance.android.livesdk.gift.platform.core.interceptor.AssetsInterceptorNew;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftEffectManager;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftFrequencyUtils;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdk.message.model.GiftLiteDisplayEffect;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.l7;
import com.bytedance.android.livesdk.message.model.n6;
import com.bytedance.android.livesdk.message.model.o6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.q7;
import com.bytedance.android.livesdk.message.model.q8;
import com.bytedance.android.livesdk.message.model.r7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/GiftMessageService;", "Lcom/bytedance/android/scope/o;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftMessageService implements com.bytedance.android.scope.o, Observer<KVData> {
    public static final /* synthetic */ int M = 0;
    public final yz0.l A;
    public final AssetsService B;
    public final GiftExtraRepo C;
    public final yz0.k D;
    public final AssetsInterceptorNew E;
    public final i3 F;
    public final z2 G;
    public final f1 H;
    public final ez0.b I;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.i0 J;
    public final FastGiftRecommendService K;
    public final b2 L;
    public final NextLiveData<i6> a;
    public final NextLiveData<k6> b;
    public final NextLiveData<q8> c;
    public final NextLiveData<gm2.g> d;
    public final NextLiveData<o7> e;
    public final NextLiveData<o7> f;
    public final NextLiveData<o7> g;
    public final NextLiveData<Long> h;
    public final IRoom i;
    public final Boolean j;
    public o1 k;
    public p1 l;
    public q1 m;
    public Disposable n;
    public r1 o;
    public int p;
    public l7 q;
    public boolean r;
    public final CompositeDisposable s;
    public final com.bytedance.android.livesdk.gift.configmodel.i0 t;
    public CompositeDisposable u;
    public final Context v;
    public final DataCenter w;
    public final r0 x;
    public final OpenDialogService y;
    public final com.bytedance.android.livesdk.gift.platform.business.tray2.e z;

    public static final class a {
    }

    public static final class b implements Function1<com.bytedance.android.livesdk.gift.platform.core.utils.recorder.h, Unit> {
        public final /* synthetic */ o7 a;

        public b(o7 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5) {
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.h r6 = (com.bytedance.android.livesdk.gift.platform.core.utils.recorder.h) r5;
            Intrinsics.checkNotNullParameter(r6, "record");
            String r0 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.f.a(this.a);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r0, "<set-?>");
            r6.e = r0;
            String r1 = String.valueOf(this.a.getGiftId());
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r6.a = r1;
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<com.bytedance.android.livesdk.gift.platform.core.utils.recorder.h, Unit> {
        public final /* synthetic */ o7 a;

        public c(o7 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5) {
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.h r6 = (com.bytedance.android.livesdk.gift.platform.core.utils.recorder.h) r5;
            Intrinsics.checkNotNullParameter(r6, "record");
            String r0 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.f.a(this.a);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r0, "<set-?>");
            r6.e = r0;
            String r1 = String.valueOf(this.a.getGiftId());
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r6.a = r1;
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void a() {
        Disposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.n = Completable.timer(this.p, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.o);
    }

    public final boolean d() {
        IRoom r0 = this.i;
        if (r0 == null) goto L5;
        boolean r1 = r0.isMediaRoom();
    L7:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L9;
        return false;
    L9:
        if (com.bytedance.android.live.revenue.common.d0.a(this.j.booleanValue(), r1) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = false;
        goto L7
    }

    public final void j() {
        CompositeDisposable r0 = this.u;
        if (r0 == null) goto L34;
        Intrinsics.checkNotNull(r0);
        if (r0.isDisposed() == true) goto L46;
        CompositeDisposable r1 = this.u;
        Intrinsics.checkNotNull(r1);
        r1.dispose();
        this.u = null;
        GiftTrayMessageManager r2 = GiftTrayMessageManager.r;
        GiftTrayMessageManager r3 = GiftTrayMessageManager.a.a();
        List<NormalGiftMessage> r4 = r3.c;
        ArrayList r5 = new ArrayList();
        Iterator r6 = ((ArrayList) r4).iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();
        if (((NormalGiftMessage) r7).P == false) goto L8;
        r5.add(r7);
        goto L8
    L13:
        if ((!r5.isEmpty()) == false) goto L18;
        Iterator r8 = r5.iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        NormalGiftMessage r9 = (NormalGiftMessage) r8.next();
        r9.Q = true;
        r3.i(r9, false);
    L18:
        NormalGiftMessage r10 = r3.g;
        if (r10 == null) goto L23;
        Intrinsics.checkNotNull(r10);
        if (r10.P == false) goto L23;
        NormalGiftMessage r11 = r3.g;
        Intrinsics.checkNotNull(r11);
        r11.Q = true;
    L23:
        NormalGiftMessage r13 = r3.h;
        if (r13 == null) goto L28;
        Intrinsics.checkNotNull(r13);
        if (r13.P == false) goto L28;
        NormalGiftMessage r14 = r3.h;
        Intrinsics.checkNotNull(r14);
        r14.Q = true;
    L28:
        this.h.setValue(Long.valueOf(System.currentTimeMillis()));
        Iterator r15 = ((HashMap) com.bytedance.android.livesdk.gift.platform.core.manager.a.b().a).values().iterator();
    L30:
        if (r15.hasNext() == false) goto L47;
        ca0.b r16 = (ca0.b) r15.next();
        if (r16 == null) goto L30;
        r16.a();
        goto L30
    L47:
        return;
    L46:
        return;
    }

    public final void onStart() {
        yz0.l r0 = this.A;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.B, false, 6).subscribe(new n1(new GiftMessageService$initListener$1(this))), this.s);
        RxUtilKt.c(yz0.h.a.a(this.A, com.bytedance.android.live.revenue.common.message.b.C, false, 6).subscribe(new n1(new GiftMessageService$initListener$2(this))), this.s);
        RxUtilKt.c(yz0.h.a.a(this.A, com.bytedance.android.live.revenue.common.message.b.D, false, 6).subscribe(new n1(new GiftMessageService$initListener$3(this))), this.s);
        RxUtilKt.c(yz0.h.a.a(this.A, com.bytedance.android.live.revenue.common.message.b.E, false, 6).subscribe(new n1(new GiftMessageService$initListener$4(this))), this.s);
        RxUtilKt.c(yz0.h.a.a(this.A, com.bytedance.android.live.revenue.common.message.b.F, false, 6).subscribe(new n1(new GiftMessageService$initListener$5(this))), this.s);
        RxUtilKt.c(yz0.h.a.a(this.A, com.bytedance.android.live.revenue.common.message.b.G, false, 6).subscribe(new n1(new GiftMessageService$initListener$6(this))), this.s);
        RxUtilKt.c(yz0.h.a.a(this.A, com.bytedance.android.live.revenue.common.message.b.H, false, 6).subscribe(new n1(new GiftMessageService$initListener$7(this))), this.s);
        RxUtilKt.c(yz0.h.a.a(this.A, com.bytedance.android.live.revenue.common.message.b.J, false, 6).subscribe(new n1(new GiftMessageService$initListener$8(this))), this.s);
        RxUtilKt.c(yz0.h.a.a(this.A, com.bytedance.android.live.revenue.common.message.b.k, false, 6).subscribe(new n1(new GiftMessageService$initListener$9(this))), this.s);
        this.w.observe("cmd_show_special_group_gift", this).observe("cmd_show_notify_special_gift", this);
        if (this.j.booleanValue() == true) goto L5;
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.G0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[83])).booleanValue() == false) goto L9;
        jy0.b.c("GiftMessageService", "onRtcRoomStart", null, 4);
        this.A.J0(new GiftMessageService$onRtcRoomStart$1(this));
        return;
    }

    public final void onStop() {
        this.w.removeObserver(this);
        Disposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.s.dispose();
        if (this.j.booleanValue() == true) goto L8;
        return;
    L8:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.G0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[83])).booleanValue() == false) goto L12;
        jy0.b.c("GiftMessageService", "onRtcRoomStop", null, 4);
        this.A.f0(new GiftMessageService$onRtcRoomStop$1(this));
        j();
        return;
    }

    public final void c(com.bytedance.android.livesdk.gift.model.a2 r4) {
        if (r4 == null) goto L5;
        String r0 = String.valueOf(r4.getStrategyType());
        if (r0 == null) goto L5;
    L6:
        jy0.b.a("Darwin Debug handleGiftSortStrategy ", r0);
        if (r4 != null) goto L9;
        return;
    L9:
        int r1 = r4.getStrategyType();
        if (r1 != 1) goto L12;
        this.H.g(CollectionsKt.listOf(r4));
        this.K.c(CollectionsKt.listOf(r4));
        this.L.a(r4.getScene(), r4.getEventTrack());
        return;
    L12:
        if (r1 == 2) goto L15;
        return;
    L15:
        if (r4.getUpdateType() != 1) goto L19;
        o(15);
        return;
    L19:
        return;
    L5:
        r0 = BuildConfig.FLAVOR;
        goto L6
    }

    public final void h(yh6.c r23) {
        Intrinsics.checkNotNullParameter(r23, "message");
        boolean r2 = r23 instanceof r7;
        String r3 = BuildConfig.FLAVOR;
        Object r6 = null;
        boolean r7 = true;
        if (r2 == false) goto L52;
        r7 r1 = (r7) r23;
        Intrinsics.checkNotNullParameter(r1, "$this$updateAssetIds");
        km2.a r8 = r1.castToOrNull(km2.a.class);
        if (r8 == null) goto L7;
        List r9 = r8.getUpdateAssetIds();
    L9:
        if (r9 != null) goto L11;
    L17:
        int r4 = r1.getUpdateType();
        if (this.i == null) goto L41;
        if (r4 == 2) goto L22;
        if (r4 != 1) goto L41;
        o(5);
        goto L41
    L22:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L31;
        long r10 = this.i.getId();
        boolean r13 = this.j.booleanValue();
        IBaseUser r5 = this.i.getOwner();
        if (r5 == null) goto L29;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        String r11 = r5.getCastSecUid();
        if (r11 == null) goto L29;
        String r14 = r11;
    L30:
        GiftListRepo.j(null, r10, 5, r13, r14, (int) this.i.getRoomLayout());
    L29:
        r14 = BuildConfig.FLAVOR;
        goto L30
    L31:
        long r16 = this.i.getId();
        boolean r19 = this.j.booleanValue();
        IBaseUser r15 = this.i.getOwner();
        if (r15 == null) goto L37;
        Intrinsics.checkNotNullParameter(r15, "$this$secUidExt");
        String r17 = r15.getCastSecUid();
        if (r17 == null) goto L37;
        String r20 = r17;
    L38:
        GiftManagerKt.I(null, r16, 5, r19, r20);
    L37:
        r20 = BuildConfig.FLAVOR;
    L41:
        km2.a r18 = r1.castTo(km2.a.class);
        if (r18 == null) goto L358;
        List r21 = r18.getUpdateGiftIds();
        if (r21 != null) goto L46;
        return;
    L46:
        if ((!r21.isEmpty()) == true) goto L49;
        r21 = null;
    L49:
        if (r21 == null) goto L360;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0.a.a(this.C, r21, "updateGiftList", null, 12);
        return;
    L360:
        return;
    L358:
        return;
    L11:
        if ((!r9.isEmpty()) != true) goto L17;
        AssetsService r24 = this.B;
        boolean r25 = this.j.booleanValue();
        Intrinsics.checkNotNullParameter(r1, "$this$updateAssetIds");
        km2.a r26 = r1.castToOrNull(km2.a.class);
        if (r26 == null) goto L15;
        List<Long> r27 = r26.getUpdateAssetIds();
    L16:
        r24.ji(5, r25, r27, "GiftMessageService");
        goto L41
    L15:
        r27 = null;
        goto L16
    L7:
        r9 = null;
        goto L9
    L52:
        if ((r23 instanceof q7) == false) goto L94;
        q7 r28 = (q7) r23;
        Intrinsics.checkNotNullParameter(r28, "giftSortMessage");
        jy0.b.a("Darwin Debug handleGiftSortMsg ", String.valueOf(r28.getMsgType()));
        long r29 = r28.getMsgType();
        if (r29 != 1) goto L65;
        if (com.bytedance.android.livesdk.gift.platform.business.b.h().b() == false) goto L362;
        LinkedHashMap r30 = new LinkedHashMap();
        r30.put("preload_with_intelligence", "2");
        i12.e r31 = i12.o.b();
        if (r31 == null) goto L60;
        Object r33 = com.bytedance.android.scope.m.e.d(r31, GiftListPreLoadService.class);
    L61:
        GiftListPreLoadService r34 = (GiftListPreLoadService) r33;
        if (r34 == null) goto L363;
        ReadOnlyProperty r35 = GiftListPreLoadService.i;
        r34.a(16, null, r30);
        return;
    L363:
        return;
    L60:
        r33 = null;
        goto L61
    L362:
        return;
    L65:
        if (r29 != 2) goto L78;
        if (ay1.b.u() >= r28.getMinConsumeLevel()) goto L69;
        return;
    L69:
        if (com.bytedance.android.livesdk.gift.platform.business.b.h().b() == false) goto L366;
        LinkedHashMap r36 = new LinkedHashMap();
        r36.put("preload_with_intelligence", "3");
        i12.e r37 = i12.o.b();
        if (r37 == null) goto L73;
        Object r38 = com.bytedance.android.scope.m.e.d(r37, GiftListPreLoadService.class);
    L74:
        GiftListPreLoadService r39 = (GiftListPreLoadService) r38;
        if (r39 == null) goto L367;
        ReadOnlyProperty r40 = GiftListPreLoadService.i;
        r39.a(16, null, r36);
        return;
    L367:
        return;
    L73:
        r38 = null;
        goto L74
    L366:
        return;
    L78:
        if (r29 != 3) goto L81;
        c(r28.getSceneInsertStrategy());
        return;
    L81:
        if (r29 == 4) goto L83;
        return;
    L83:
        if (ay1.b.u() >= r28.getMinConsumeLevel()) goto L85;
    L92:
        c(r28.getSceneInsertStrategy());
        return;
    L85:
        if (com.bytedance.android.livesdk.gift.platform.business.b.h().b() == false) goto L92;
        LinkedHashMap r41 = new LinkedHashMap();
        r41.put("preload_with_intelligence", "4");
        i12.e r43 = i12.o.b();
        if (r43 == null) goto L89;
        r6 = com.bytedance.android.scope.m.e.d(r43, GiftListPreLoadService.class);
    L89:
        GiftListPreLoadService r44 = (GiftListPreLoadService) r6;
        if (r44 == null) goto L371;
        r44.a(16, new m1(this, r28), r41);
        return;
    L371:
        return;
    L94:
        if ((r23 instanceof o7) == false) goto L277;
        z2 r45 = this.G;
        o7 r46 = (o7) r23;
        r45.getClass();
        Intrinsics.checkNotNullParameter(r46, "msg");
        List r47 = r46.getSeriesGiftData();
        if (r47 != null) goto L98;
    L111:
        final LinkedHashMap r48 = new LinkedHashMap();
        final ArrayList r49 = new ArrayList();
        if (r46.getClientGiftSource() == 1) goto L114;
    L116:
        com.bytedance.android.livesdk.gift.model.h1 r110 = r45.f.findGiftById(r46.getGiftId());
    L117:
        if (r110 == null) goto L127;
        Iterator r111 = ((ArrayList) r45.c).iterator();
    L121:
        if (r111.hasNext() == false) goto L124;
        ((f12.a) r111.next()).a(r46, r110, new InteractEffectService$sendGiftMessageToEffect$2(r49, r48));
        goto L121
    L124:
        if ((!r49.isEmpty()) == false) goto L127;
        r45.a(r48, r49);
    L127:
        if (this.j.booleanValue() == false) goto L179;
        IRoom r50 = this.i;
        if (r50 == null) goto L179;
        String r51 = r50.getAnchorId();
        if (r51 == null) goto L179;
        if ((!r46.getToUserIdStrings().isEmpty()) == false) goto L138;
        Boolean r53 = Boolean.valueOf(r46.getToUserIdStrings().contains(r51));
    L146:
        if (r53.booleanValue() == false) goto L179;
        List r54 = r46.getSeriesGiftData();
        if (r54 != null) goto L151;
    L154:
        boolean r55 = true;
    L156:
        if ((!r55) == false) goto L171;
        if (r46.getRepeatEnd() == 1) goto L179;
        List r56 = r46.getSeriesGiftData();
        if (r56 == null) goto L179;
        Iterator r57 = r56.iterator();
    L163:
        if (r57.hasNext() == false) goto L179;
        com.bytedance.android.livesdk.gift.model.h1 r58 = ((com.bytedance.android.livesdk.gift.model.n3) r57.next()).getGift();
        IBaseUser r59 = r46.getFromUser();
        if (r59 == null) goto L168;
        String r60 = r59.getUserId();
        if (r60 == null) goto L168;
    L169:
        n(r58, 1, r60);
    L168:
        r60 = BuildConfig.FLAVOR;
        goto L169
    L171:
        if (r46.getRepeatEnd() != 1) goto L179;
        com.bytedance.android.livesdk.gift.model.h2 r61 = com.bytedance.android.livesdk.gift.platform.core.utils.u.f(r46);
        long r63 = r46.getRepeatCount();
        IBaseUser r112 = r46.getFromUser();
        if (r112 == null) goto L178;
        String r113 = r112.getUserId();
        if (r113 == null) goto L178;
        r3 = r113;
    L178:
        n(r61, r63, r3);
        goto L179
    L151:
        if (r54.isEmpty() == true) goto L154;
        r55 = false;
        goto L156
    L138:
        if (r46.getToUser() == null) goto L144;
        IBaseUser r64 = r46.getToUser();
        if (r64 == null) goto L142;
        String r65 = r64.getIdString();
    L143:
        r53 = Boolean.valueOf(Intrinsics.areEqual(r65, r51));
        goto L146
    L142:
        r65 = null;
        goto L143
    L144:
        r53 = this.j;
    L179:
        List r66 = r46.getSeriesGiftData();
        if (r66 != null) goto L182;
    L185:
        boolean r67 = true;
    L187:
        if ((!r67) == false) goto L219;
        k(r46);
        List r68 = r46.getSeriesGiftData();
        List r69 = r68;
        if (r69 != null) goto L191;
    L194:
        boolean r70 = true;
    L195:
        if (r70 == true) goto L218;
        r46.setBannedDisplayEffects(4);
        GiftFrequencyUtils.a(r46, null);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L199;
    L201:
        boolean r71 = false;
    L202:
        g(r46, r71);
        int r73 = r68.size();
        int r74 = 0;
    L203:
        if (r74 >= r73) goto L357;
        int r75 = com.bytedance.android.livesdk.gift.platform.core.utils.m.a;
        com.bytedance.android.livesdk.gift.model.n3 r76 = (com.bytedance.android.livesdk.gift.model.n3) ListProtector.get(r68, r74);
        Intrinsics.checkNotNullParameter(r76, "seriesPlayGift");
        Intrinsics.checkNotNullParameter(r46, "baseMessage");
        com.bytedance.android.livesdk.gift.model.h1 r77 = r76.getGift();
        if (r77 == null) goto L207;
        o7 r78 = com.bytedance.android.livesdk.gift.platform.core.utils.m.a(r46);
        r78.setGiftId(r77.getId());
        r78.setGift(r77);
        r78.setSendTogetherInfo(r76.getSendTogetherInfo());
        r78.setDiyItemInfoList(r76.getDiyItemInfo());
        r78.setAnchorGift(r76.getAnchorGift());
        r78.setAssetEffectMixInfo(r76.getAssetEffectMixInfo());
    L208:
        if (r78 == null) goto L217;
        r78.setBannedDisplayEffects(2);
        GiftFrequencyUtils.a(r78, null);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L213;
    L215:
        boolean r79 = false;
    L216:
        g(r78, r79);
        goto L217
    L213:
        if (this.x.b == false) goto L215;
        r79 = true;
    L217:
        r74 = r74 + 1;
        goto L203
    L207:
        r78 = null;
        goto L208
    L357:
        return;
    L199:
        if (this.x.b == false) goto L201;
        r71 = true;
        goto L202
    L218:
        return;
    L191:
        if (r69.isEmpty() == true) goto L194;
        r70 = false;
        goto L195
    L219:
        com.bytedance.android.livesdk.gift.model.h2 r80 = com.bytedance.android.livesdk.gift.platform.core.utils.u.f(r46);
        if (r80 == null) goto L228;
        boolean r81 = this.B.r;
        Intrinsics.checkNotNullParameter(r80, "$this$enableImageFormatOpt");
        if ((r80 instanceof com.bytedance.android.livesdk.gift.model.h1) == true) goto L224;
        com.bytedance.android.livesdk.gift.model.h2 r83 = null;
    L225:
        com.bytedance.android.livesdk.gift.model.h1 r84 = (com.bytedance.android.livesdk.gift.model.h1) r83;
        if (r84 == null) goto L228;
        r84.enableImageFormatOpt(r81);
        goto L228
    L224:
        r83 = r80;
    L228:
        if (r80 == null) goto L243;
        if (w12.b.a() == true) goto L232;
    L234:
        boolean r85 = false;
    L235:
        Intrinsics.checkNotNullParameter(r80, "$this$enableDomainOpt");
        if ((r80 instanceof com.bytedance.android.livesdk.gift.model.h1) == true) goto L238;
        com.bytedance.android.livesdk.gift.model.h2 r86 = null;
    L239:
        com.bytedance.android.livesdk.gift.model.h1 r87 = (com.bytedance.android.livesdk.gift.model.h1) r86;
        if (r87 == null) goto L243;
        r87.enableDomainOpt(r85);
        goto L243
    L238:
        r86 = r80;
        goto L239
    L232:
        if (this.t.Z1() == false) goto L234;
        r85 = true;
    L243:
        if (this.t.Z1() == true) goto L245;
    L250:
        if (r80 != null) goto L252;
    L254:
        boolean r88 = false;
    L255:
        if (r88 == false) goto L257;
        k(r46);
    L257:
        if (r88 == false) goto L265;
        if (b02.a.c(r46) == false) goto L261;
    L263:
        f((int) r46.getCount(), r46);
        return;
    L261:
        if (r46.getGroupCount() <= 1) goto L263;
        f((int) r46.getGroupCount(), r46);
        return;
    L265:
        if (((Boolean) this.w.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L267;
    L269:
        GiftFrequencyUtils.a(r46, null);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L272;
    L274:
        r7 = false;
    L275:
        g(r46, r7);
        return;
    L272:
        if (this.x.b == false) goto L274;
    L267:
        if (this.r == false) goto L269;
        return;
    L252:
        if (l0.d(r80) != true) goto L254;
        r88 = true;
        goto L255
    L245:
        if (w12.b.a() == false) goto L250;
        if (r80 == null) goto L250;
        py.k r89 = r80.getImage();
        if (r89 == null) goto L250;
        GiftListRepo r90 = GiftListRepo.k;
        boolean r91 = this.t.T0();
        r90.getClass();
        GiftListRepo.m(r89, r91);
        goto L250
    L182:
        if (r66.isEmpty() == true) goto L185;
        r67 = false;
        goto L187
    L114:
        if (r46.getGift() == null) goto L116;
        r110 = r46.getGift();
        goto L117
    L98:
        if ((!r47.isEmpty()) == false) goto L111;
        Iterator r93 = r47.iterator();
    L101:
        if (r93.hasNext() == false) goto L127;
        com.bytedance.android.livesdk.gift.model.h1 r94 = ((com.bytedance.android.livesdk.gift.model.n3) r93.next()).getGift();
        if (r94 == null) goto L101;
        final LinkedHashMap r114 = new LinkedHashMap();
        final ArrayList r115 = new ArrayList();
        Iterator r116 = ((ArrayList) r45.c).iterator();
    L106:
        if (r116.hasNext() == false) goto L109;
        ((f12.a) r116.next()).a(r46, r94, new InteractEffectService$sendGiftMessageToEffect$1$1$1$1(r115, r114));
        goto L106
    L109:
        if ((!r115.isEmpty()) == false) goto L101;
        r45.a(r114, r115);
        goto L101
    L277:
        if ((r23 instanceof k6) == false) goto L285;
        k6 r95 = (k6) r23;
        boolean r96 = GiftEffectManager.a;
        if (GiftEffectManager.b(r95, this.i) == false) goto L282;
        return;
    L282:
        if (this.r == true) goto L377;
        this.b.setValue(r95);
        return;
    L377:
        return;
    L285:
        if ((r23 instanceof o6) == false) goto L309;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.p() == false) goto L291;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftMessageService", "BindingGiftMessage isVS , ignore : " + r23);
        return;
    L291:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.g.l.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[9])).booleanValue() == true) goto L293;
    L298:
        o6 r97 = (o6) r23;
        if (r97.getGiftMessage() == null) goto L307;
        Lazy r98 = GiftFrequencyUtils.a;
        o7 r99 = r97.getGiftMessage();
        Intrinsics.checkNotNull(r99);
        GiftFrequencyUtils.a(r99, null);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L303;
    L305:
        r7 = false;
    L306:
        g(r99, r7);
        return;
    L303:
        if (this.x.b == false) goto L305;
    L307:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftMessageService", "BindingGiftMessage giftMessage is null, ignore : " + r23);
        return;
    L293:
        if (((Boolean) ay1.b.a0.getValue(null, ay1.b.a[64])).booleanValue() == false) goto L298;
        if (((o6) r23).getGiftMessage() != null) goto L298;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftMessageService", "BindingGiftMessage optimize enable, ignore : " + r23);
        return;
    L309:
        if ((r23 instanceof i6) == false) goto L312;
        this.a.setValue((i6) r23);
        return;
    L312:
        if ((r23 instanceof l7) == false) goto L330;
        l7 r100 = (l7) r23;
        ReadOnlyProperty r101 = com.bytedance.android.livesdk.gift.platform.core.h.M;
        KProperty[] r102 = com.bytedance.android.livesdk.gift.platform.core.h.a;
        if (((RevGiftConsumerRemindConfig) r101.getValue(null, r102[37])).getEnabled() == false) goto L388;
        this.p = ((RevGiftConsumerRemindConfig) r101.getValue(null, r102[37])).getDelay();
        this.q = r100;
        if (this.k != null) goto L320;
        this.k = new o1(this);
        this.l = new p1(this);
        this.m = new q1(this);
        this.o = new r1(this);
    L320:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.g() == false) goto L322;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.n(this.l);
        return;
    L322:
        o1 r103 = this.k;
        i12.e r104 = i12.o.b();
        if (r104 == null) goto L325;
        r6 = com.bytedance.android.scope.m.e.d(r104, r3.class);
    L325:
        r3 r105 = (r3) r6;
        if (r105 == null) goto L328;
        r105.d = r103;
    L328:
        a();
        return;
    L388:
        return;
    L330:
        if ((r23 instanceof q8) == false) goto L335;
        q8 r106 = (q8) r23;
        if (r106.getBannedDisplayEffects() == GiftLiteDisplayEffect.LiteEffect.getValue()) goto L384;
        this.c.setValue(r106);
        return;
    L384:
        return;
    L335:
        if ((r23 instanceof n6) == false) goto L340;
        n6 r107 = (n6) r23;
        IRoom r108 = this.i;
        if (r108 == null) goto L389;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0.b(r108.getId());
        i3 r109 = this.F;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r107, "msg");
        ((ArrayList) r109.a).add(r107);
        r109.a();
        return;
    L389:
        return;
    L340:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftMessageService", "unknown message type ignore : " + r23);
    }

    public final void i(boolean r4) {
        if (r4 == false) goto L5;
        jy0.b.c("GiftMessageService", "onRtcRoomConnected", null, 4);
        j();
        this.u = new CompositeDisposable();
        yz0.l r5 = this.A;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(r5.nh(com.bytedance.android.live.revenue.common.message.b.D).subscribe(new n1(new GiftMessageService$onRtcRoomConnected$1(this))), this.u);
        return;
    L5:
        jy0.b.c("GiftMessageService", "onRtcRoomDisconnected", null, 4);
        j();
    }

    public final void k(o7 r9) {
        com.bytedance.android.livesdk.gift.model.h2 r0 = com.bytedance.android.livesdk.gift.platform.core.utils.u.f(r9);
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getType());
    L6:
        GiftType r2 = GiftManagerKt.u(r1);
        boolean r3 = false;
        if (r2 != GiftType.MIDDLE_GIFT) goto L9;
    L24:
        p02.a r4 = new p02.a();
        if (r0 != null) goto L27;
        r0 = (com.bytedance.android.livesdk.gift.model.h2) vh7.f.c(com.bytedance.android.livesdk.gift.model.h1.class);
    L27:
        IBaseUser r5 = com.bytedance.android.livesdk.gift.platform.core.utils.u.a();
        if (r5 != null) goto L30;
        r5 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L30:
        NormalGiftMessage r10 = r4.a(r9, r0, r5, r3);
        if (r10.v == false) goto L34;
        com.bytedance.android.livesdk.gift.platform.core.d0.m(r10);
        return;
    L34:
        return;
    L9:
        if (r2 == GiftType.SPECIAL_GIFT) goto L24;
        if (r2 == GiftType.STICKER_GIFT) goto L24;
        if (r2 == GiftType.INTERACT_GIFT) goto L24;
        if (r2 == GiftType.UNKNOWN) goto L24;
        if (r2 != GiftType.MULTI_INTERACT) goto L23;
        Intrinsics.checkNotNullParameter(r9, "$this$trayFromServer");
        if ((r9.getForceDisplayEffects() & 2) == 0) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L24;
    L21:
        r6 = false;
    L23:
        r3 = true;
        goto L24
    L5:
        r1 = null;
        goto L6
    }

    public final void o(int r18) {
        DataCenter r1 = this.w;
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.get("data_is_anchor", Boolean.FALSE);
        if (r2 == null) goto L7;
        boolean r9 = r2.booleanValue();
    L8:
        IRoom r3 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r3 != null) goto L11;
        return;
    L11:
        n01.a r4 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        int r7 = com.bytedance.android.livesdk.gift.platform.core.utils.u.c(this.J.a());
        i12.d r5 = i12.m.e2.a();
        if (r5 == null) goto L14;
        Object r6 = com.bytedance.android.scope.m.e.d(r5, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class);
    L15:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r8 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r6;
        if (r8 == null) goto L19;
        IBaseUser r10 = r8.a;
        if (r10 == null) goto L19;
    L20:
        if (r10 != null) goto L23;
        r10 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L23:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.m(r10) == false) goto L45;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L35;
        long r11 = r3.getId();
        long r13 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r10)).longValue();
        if (r3.getOwner() == null) goto L29;
        IBaseUser r14 = r3.getOwner();
        Intrinsics.checkNotNull(r14);
        String r15 = com.bytedance.android.live.base.model.user.o.a(r14);
    L30:
        Intrinsics.checkNotNullParameter(r10, "$this$secUidExt");
        String r16 = r10.getCastSecUid();
        if (r4 == null) goto L33;
        Episode r17 = r4.jf();
    L34:
        GiftListRepo.i(null, r11, r13, r7, r18, r9, r15, r16, r17);
        return;
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = BuildConfig.FLAVOR;
        goto L30
    L35:
        GiftManagerKt r19 = GiftManagerKt.z;
        long r110 = r3.getId();
        long r111 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r10)).longValue();
        if (r3.getOwner() == null) goto L38;
        IBaseUser r20 = r3.getOwner();
        Intrinsics.checkNotNull(r20);
        String r21 = com.bytedance.android.live.base.model.user.o.a(r20);
    L39:
        Intrinsics.checkNotNullParameter(r10, "$this$secUidExt");
        String r112 = r10.getCastSecUid();
        if (r4 == null) goto L42;
        Episode r113 = r4.jf();
    L43:
        r19.getClass();
        GiftManagerKt.J(null, r110, r111, r7, r18, r9, r21, r112, r113);
        return;
    L42:
        r113 = null;
        goto L43
    L38:
        r21 = BuildConfig.FLAVOR;
        goto L39
    L45:
        if (r3.getOwner() == null) goto L47;
        IBaseUser r23 = r3.getOwner();
        Intrinsics.checkNotNull(r23);
        String r114 = com.bytedance.android.live.base.model.user.o.a(r23);
    L49:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L55;
        long r24 = r3.getId();
        long r115 = r3.getId();
        if (r4 == null) goto L53;
        Episode r25 = r4.jf();
    L54:
        GiftListRepo.i(null, r24, r115, r7, r18, r9, r114, r114, r25);
        return;
    L53:
        r25 = null;
        goto L54
    L55:
        GiftManagerKt r26 = GiftManagerKt.z;
        long r116 = r3.getId();
        long r117 = r3.getId();
        if (r4 == null) goto L58;
        Episode r27 = r4.jf();
    L59:
        r26.getClass();
        GiftManagerKt.J(null, r116, r117, r7, r18, r9, r114, r114, r27);
        return;
    L58:
        r27 = null;
        goto L59
    L47:
        r114 = BuildConfig.FLAVOR;
    L19:
        r10 = this.D.getRoom().getOwner();
        goto L20
    L14:
        r6 = null;
    L7:
        r9 = false;
        goto L8
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.getKey().length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L43;
        String r1 = r8.getKey();
        int r3 = r1.hashCode();
        Long r5 = null;
        if (r3 == (-1328547149)) goto L29;
        if (r3 == 1055337807) goto L16;
        return;
    L16:
        if (r1.equals("cmd_show_notify_special_gift") == false) goto L40;
        o7 r9 = (o7) r8.getData();
        if (r9 == null) goto L20;
        Long r2 = Long.valueOf(r9.getGiftId());
    L21:
        String r4 = String.valueOf(r2);
        if (r9 == null) goto L24;
        r5 = Long.valueOf(r9.getMessageId());
    L24:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.z("处理直播间跳转mock的礼物动画", r4, String.valueOf(r5));
        if (r9 == null) goto L45;
        r9.setUrgent(true);
        g(r9, false);
        return;
    L45:
        return;
    L20:
        r2 = null;
        goto L21
    L40:
        return;
    L29:
        if (r1.equals("cmd_show_special_group_gift") == false) goto L42;
        o7 r10 = (o7) r8.getData();
        if (r10 == null) goto L33;
        Long r6 = Long.valueOf(r10.getGiftId());
    L34:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.z("处理小礼物的连发特效", String.valueOf(r6), null);
        if (r10 == null) goto L46;
        r10.setUrgent(true);
        g(r10, false);
        return;
    L46:
        return;
    L33:
        r6 = null;
        goto L34
    L42:
        return;
    L43:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void f(int r11, o7 r13) {
        int r1 = Math.max(r11, 1);
        long r2 = r13.getTotalCount();
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L11;
        Lazy r6 = GiftFrequencyUtils.a;
        GiftFrequencyUtils.a(r13, Long.valueOf(((r2 - ((long) r11)) + ((long) r5)) + 1));
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L7;
    L9:
        boolean r7 = false;
    L10:
        g(r13, r7);
        r5 = r5 + 1;
        goto L3
    L7:
        if (this.x.b == false) goto L9;
        r7 = true;
        goto L10
    }

    public final void g(o7 r14, boolean r15) {
        com.bytedance.android.live.base.model.message.m0 r0 = r14.getCommonData();
        if (r0 == null) goto L5;
        Object r1 = Long.valueOf(r0.getMessageId());
    L6:
        IRoom r2 = this.i;
        long r3 = 0;
        if (r2 == null) goto L20;
        if (r2.getOwner() == null) goto L20;
        if (r14.getToUser() == null) goto L17;
        IBaseUser r4 = r14.getToUser();
        Intrinsics.checkNotNull(r4);
        if (Intrinsics.areEqual(r4.getIdString(), BuildConfig.FLAVOR) == true) goto L17;
        IBaseUser r5 = r14.getToUser();
        Intrinsics.checkNotNull(r5);
        String r6 = r5.getIdString();
        IBaseUser r7 = this.i.getOwner();
        Intrinsics.checkNotNull(r7);
        if (Intrinsics.areEqual(r6, r7.getIdString()) == false) goto L20;
    L17:
        if (r14.getRoomFanTicketCount() <= 0) goto L20;
        this.w.put("data_current_room_ticket_count", Long.valueOf(r14.getRoomFanTicketCount()));
    L20:
        if (r15 == true) goto L22;
    L27:
        com.bytedance.android.livesdk.gift.model.h2 r16 = com.bytedance.android.livesdk.gift.platform.core.utils.u.f(r14);
        if (r16 != null) goto L34;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftMessageService", "用户本地没有该礼物， giftMessageId = " + r14.getMessageId() + ", giftId = " + r14.getGiftId() + ", logId = " + r14.getLogId());
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a r17 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d;
        if (r1 != null) goto L32;
        r1 = BuildConfig.FLAVOR;
    L32:
        Long r18 = Long.valueOf(r14.getGiftId());
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d r8 = new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.RESOURCE_ERROR, "GiftMessageService gift is null");
        r17.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.a(r1, "GiftMessageService gift null", r18, r8);
        return;
    L34:
        GiftType r19 = GiftManagerKt.u(Integer.valueOf(r16.getType()));
        if (r19 != GiftType.UNKNOWN) goto L37;
        boolean r9 = true;
    L38:
        r14.setUnKnowGift(r9);
        r14.setGiftTimeStamp(System.currentTimeMillis());
        ca0.b r10 = com.bytedance.android.livesdk.gift.platform.core.manager.a.b().a(r19);
        if (r10 == null) goto L54;
        com.bytedance.android.livesdk.gift.model.h2 r11 = com.bytedance.android.livesdk.gift.platform.core.utils.u.f(r14);
        if (r11 == null) goto L44;
        long r13 = (r14.getComboCount() * r14.getGroupCount()) * ((long) r11.getDiamondCount());
    L45:
        r14.setTotalMoney(r13);
        if (b02.a.c(r14) == false) goto L51;
        long r20 = r14.getGroupCount();
    L49:
        if (r3 >= r20) goto L52;
        r10.n(r14);
        r3 = r3 + 1;
    L52:
        r10.q();
        goto L54
    L51:
        r10.n(r14);
        goto L52
    L44:
        r13 = 0;
    L54:
        if (GiftEffectManager.b(r14, this.i) == false) goto L57;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftMessageService", "[interceptedGiftMsg] message: " + r14);
        return;
    L57:
        r14.setTimeStampMap(1, com.bytedance.live.kmp.util.e.b());
        switch(l1.a[r19.ordinal()]) {
            case 1: goto L67;
            case 2: goto L67;
            case 3: goto L67;
            case 4: goto L67;
            case 5: goto L67;
            case 6: goto L67;
            case 7: goto L67;
            case 8: goto L67;
            case 9: goto L61;
            case 10: goto L61;
            case 11: goto L61;
            case 12: goto L61;
            case 13: goto L61;
            default: goto L91;
        };
    L91:
        return;
    L61:
        if (d() == false) goto L63;
        this.f.setValue(r14);
        return;
    L63:
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.b r110 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.a;
        Intrinsics.checkNotNull(r1);
        r110.g(r1, "onGiftMessage", new c(r14));
        if (this.r == true) goto L85;
        this.g.setValue(r14);
        return;
    L85:
        return;
    L67:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.n() == false) goto L70;
        Lazy r111 = VSGiftMessageManager.e;
        VSGiftMessageManager.a.a().a(r14, com.bytedance.android.livesdk.gift.platform.core.utils.u.a());
        return;
    L70:
        if (d() == true) goto L79;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g r112 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b;
        if (r1 != null) goto L74;
        r1 = BuildConfig.FLAVOR;
    L74:
        r112.g(r1, "onGiftMessage ", new b(r14));
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.l.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[10])).booleanValue() == false) goto L77;
        this.z.a(r14);
        return;
    L77:
        GiftTrayMessageManager r113 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().h(r14);
        return;
    L79:
        if (d() == false) goto L81;
        this.f.setValue(r14);
        return;
    L81:
        this.e.setValue(r14);
        return;
    L37:
        r9 = false;
        goto L38
    L22:
        if (r14.isLocal() == true) goto L27;
        if (r14.getRepeatEnd() == 1) goto L27;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftMessageService", "disableNonSelfGift && !message.isLocal && (message.getRepeatEnd() != 1)) messageId: " + r14.getMessageId() + ", " + r14.getGiftId());
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void n(com.bytedance.android.livesdk.gift.model.h2 r5, long r6, String r8) {
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L5;
        long r1 = r5.getId();
    L6:
        r0.put("gift_id", r1);
        r0.put("gift_count", r6);
        if (r5 == null) goto L9;
        int r7 = r5.getDiamondCount();
    L10:
        r0.put("gift_price", r7);
        r0.put("from_user_id", r8);
        this.I.p2(r0);
        return;
    L9:
        r7 = 0;
        goto L10
    L5:
        r1 = -1;
        goto L6
    }

    public GiftMessageService(Context r17, DataCenter r18, r0 r19, OpenDialogService r20, com.bytedance.android.livesdk.gift.platform.business.tray2.e r21, yz0.l r23, AssetsService r24, GiftExtraRepo r25, yz0.k r26, AssetsInterceptorNew r27, i3 r28, z2 r29, f1 r210, ez0.b r30, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.i0 r31, FastGiftRecommendService r33, b2 r34) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        Intrinsics.checkNotNullParameter(r19, "giftEventService");
        Intrinsics.checkNotNullParameter(r20, "OpenDialogService");
        Intrinsics.checkNotNullParameter(r21, "giftTrayMessageService");
        Intrinsics.checkNotNullParameter(r23, "roomMessageService");
        Intrinsics.checkNotNullParameter(r24, "assetsService");
        Intrinsics.checkNotNullParameter(r25, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r26, "roomDataService");
        Intrinsics.checkNotNullParameter(r27, "assetsInterceptorNew");
        Intrinsics.checkNotNullParameter(r28, "pkBattlePropCardService");
        Intrinsics.checkNotNullParameter(r29, "interactEffectService");
        Intrinsics.checkNotNullParameter(r210, "giftListSortService");
        Intrinsics.checkNotNullParameter(r30, "revInteractEffectService");
        Intrinsics.checkNotNullParameter(r31, "receiverService");
        Intrinsics.checkNotNullParameter(r33, "fastGiftRecommendService");
        Intrinsics.checkNotNullParameter(r34, "giftRecommendLogService");
        this.v = r17;
        this.w = r18;
        this.x = r19;
        this.y = r20;
        this.z = r21;
        this.A = r23;
        this.B = r24;
        this.C = r25;
        this.D = r26;
        this.E = r27;
        this.F = r28;
        this.G = r29;
        this.H = r210;
        this.I = r30;
        this.J = r31;
        this.K = r33;
        this.L = r34;
        this.a = new NextLiveData();
        this.b = new NextLiveData();
        this.c = new NextLiveData();
        this.d = new NextLiveData();
        this.e = new NextLiveData();
        this.f = new NextLiveData();
        this.g = new NextLiveData();
        this.h = new NextLiveData();
        this.i = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        this.j = (Boolean) r18.get("data_is_anchor", Boolean.FALSE);
        this.s = new CompositeDisposable();
        this.t = com.bytedance.android.livesdk.gift.platform.business.i.h();
    }
}
