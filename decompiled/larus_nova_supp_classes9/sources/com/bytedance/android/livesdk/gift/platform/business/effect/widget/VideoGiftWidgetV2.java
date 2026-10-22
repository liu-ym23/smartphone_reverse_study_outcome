package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.GiftRecyclableWidget;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.revenue.model.extension.main.IMainGiftRoom;
import com.bytedance.android.livesdk.config.bz;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.VideoGiftView;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.f;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.VideoGiftMsgManagerV2;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.GiftMsgConsumeDispatcher;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.g;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftEffectManager;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.j3;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.q8;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdk.revenue.experience.RevExpBizScene;
import com.bytedance.android.livesdk.revenue.interact.animation.ScriptInfo;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.depend.live.gift.SuperResolutionModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import i12.o;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import mz0.i;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/VideoGiftWidgetV2;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseVideoGiftWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/tray2/manager/g;", "Lcom/bytedance/android/livesdk/gift/platform/business/tray2/manager/dispatcher/b;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoGiftWidgetV2 extends BaseVideoGiftWidget implements g, com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b<NormalGiftMessage> {
    public static final VideoGiftMsgManagerV2 S = null;
    public static final GiftMsgConsumeDispatcher T = null;
    public final VideoGiftMsgManagerV2 J;
    public final com.bytedance.android.livesdk.gift.platform.business.tray2.manager.d K;
    public final GiftMsgConsumeDispatcher L;
    public final List<String> M;
    public final List<NormalGiftMessage> N;
    public final int O;
    public final int P;
    public final boolean Q;
    public final CompositeDisposable R;

    public static final class a {
        public static GiftMsgConsumeDispatcher a() {
            GiftMsgConsumeDispatcher r0 = VideoGiftWidgetV2.T;
            if (r0.b == null) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L10;
            VideoGiftMsgManagerV2 r2 = VideoGiftWidgetV2.S;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r2, "giftManager");
            r0.b = r2;
            if (r2 == null) goto L10;
            r2.j(r0, 3);
        L10:
            return r0;
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class b implements f.a {
        public final /* synthetic */ VideoGiftWidgetV2 a;

        public b(VideoGiftWidgetV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.player.f.a
        public final boolean a() {
            if (this.a.K.g() <= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VideoGiftWidgetV2 a;

        public c(VideoGiftWidgetV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            i02.d r6 = (i02.d) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r0 == null) goto L7;
            n<i02.a> r1 = r0.getCurrentSendTogetherInfo();
            if (r1 == null) goto L7;
            r1.setValue(new i02.a(r6.a, r6.b, Integer.valueOf(r6.c)));
        L7:
            GiftMsgConsumeDispatcher r7 = this.a.L;
            if ((r7 instanceof GiftMsgConsumeDispatcher) == false) goto L13;
            if (r7 == null) goto L12;
            com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r7.a, "change from jsb");
            r7.a();
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.GiftMsgConsumeDispatcher");
        }
    }

    public static final class d implements j3 {
        public final /* synthetic */ VideoGiftWidgetV2 a;
        public final /* synthetic */ NormalGiftMessage b;
        public final /* synthetic */ long c;

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.j3
        public final void onFailed() {
            String r0 = this.a.b;
            StringBuilder r1 = new StringBuilder("资源下载失败，丢弃此消息，消息id ");
            NormalGiftMessage r2 = this.b;
            if (r2 == null) goto L5;
            Long r3 = Long.valueOf(r2.a);
        L6:
            r1.append(r3);
            com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r0, r1.toString());
            if (this.b == null) goto L9;
            long r4 = System.currentTimeMillis() - this.c;
            String r5 = v12.f.a;
            v12.f.H(this.b, false, r4);
        L9:
            NormalGiftMessage r6 = this.b;
            if (r6 != null) goto L12;
        L14:
            this.a.hr(this.b, IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
            return;
        L12:
            if (r6.P != true) goto L14;
            ((ArrayList) this.a.N).remove(r6);
            goto L14
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.j3
        public final void onSuccess() {
            if (this.b == null) goto L5;
            long r2 = System.currentTimeMillis() - this.c;
            String r0 = v12.f.a;
            v12.f.H(this.b, true, r2);
        L5:
            NormalGiftMessage r1 = this.b;
            if (r1 != null) goto L8;
        L12:
            this.a.J.n(this.b);
            return;
        L8:
            if (r1.P != true) goto L12;
            ((ArrayList) this.a.N).remove(r1);
            if (this.b.Q == false) goto L12;
        }

        public d(VideoGiftWidgetV2 r1, NormalGiftMessage r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.y
    @Deprecated(message = "此方法弃用，后续老队列删除时此方法可删,使用 onConsumeMessage(NormalGiftMessage)方法代替")
    public final boolean Lc(NormalGiftMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b
    public final void ei() {
        this.l = false;
    }

    static {
        S = new VideoGiftMsgManagerV2();
        T = new GiftMsgConsumeDispatcher();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Cq() {
        this.J.f.clear();
        this.K.f.clear();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Eq() {
        this.J.m();
        Iterator r0 = ((ArrayList) this.N).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((NormalGiftMessage) r0.next()).Q = true;
        goto L4
    L6:
        ((ArrayList) this.N).clear();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final f.a Gq() {
        return new b(this);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Mq() {
        GiftMsgConsumeDispatcher r0 = this.L;
        VideoGiftMsgManagerV2 r1 = this.J;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "giftManager");
        r0.b = r1;
        if (r1 == null) goto L5;
        r1.j(r0, 3);
    L5:
        GiftMsgConsumeDispatcher r2 = this.L;
        r2.getClass();
        Intrinsics.checkNotNullParameter(this, "consumer");
        r2.c.put(0, this);
        this.K.j(this, this.O);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void ar() {
        this.J.k();
        this.K.k();
        S.k();
        T.d(this);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b
    public final boolean isIdle() {
        return !this.l;
    }

    public final void kr() {
        if ((!this.l) == true) goto L5;
        return;
    L5:
        this.l = true;
        System.currentTimeMillis();
        i02.b r0 = or();
        if (r0.a == true) goto L15;
        this.l = false;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.b, "consumeNextMessage not trigger playing effect ,set isPlayingEffectGift to false");
        if (r0.b == true) goto L10;
        this.L.c();
        return;
    L10:
        com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f<NormalGiftMessage> r1 = this.L.b;
        if (r1 == null) goto L13;
        r1.e();
    L13:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.b, "EffectPaused!! consumeResult " + r0 + " not trigger playing effect ");
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.g
    public final boolean og() {
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.b, "onNewMessageArrived");
        kr();
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void onUnload() {
        e.d.getClass();
        e.a.C0075a.e.c.c();
        this.R.clear();
        super.onUnload();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final i02.b or() {
        if (this.e != null) goto L5;
    L278:
        boolean r2 = false;
        JSONObject r1 = new JSONObject();
        if (this.e != null) goto L281;
        boolean r5 = true;
    L282:
        r1.put("mVideoGiftView", r5);
        if (this.d != null) goto L285;
        r2 = true;
    L285:
        r1.put("mRoom", r2);
        IRoom r3 = this.d;
        if (r3 == null) goto L292;
        r1.put("roomId", r3.getIdStr());
        IRoom r4 = this.d;
        if (r4 == null) goto L290;
        String r6 = r4.getAnchorId();
    L291:
        r1.put("roomOwner", r6);
        goto L292
    L290:
        r6 = null;
    L292:
        int r7 = i02.b.e;
        return i02.b.a.a(-1);
    L281:
        r5 = false;
        goto L282
    L5:
        if (this.d == null) goto L278;
        final EffectMessage r8 = this.K.p();
        if (r8 == null) goto L10;
        r8.a(5, com.bytedance.live.kmp.util.e.b());
    L10:
        if (r8 != null) goto L13;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.b, "no more EffectMessage");
        int r9 = i02.b.e;
        return i02.b.a.a(-1);
    L13:
        com.bytedance.android.livesdk.gift.model.j3 r10 = r8.E;
        if (r10 != null) goto L16;
    L19:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "consumeEffect " + r8.l + " emgr_count: " + this.K.g() + " gmgr_count: " + this.J.g());
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.consume_effect_message, r8.a, r8.l, r8.b);
        this.o = r8;
        com.bytedance.android.live.core.resources.e r11 = this.c.G1(r8.b);
        String r13 = "error";
        if (r11 != null) goto L27;
        String r14 = String.valueOf(r8.l);
        String r15 = String.valueOf(r8.a);
        EffectMessage r16 = this.o;
        if (r16 == null) goto L24;
        Intrinsics.checkNotNull(r16);
        String r17 = r16.n;
    L25:
        h.x("特效列表找不到该Id", r14, r15, BuildConfig.FLAVOR, r17);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, r8.b + " assets is null !!!,tryConsumeEffectMessage next");
        JSONObject r18 = new JSONObject();
        r18.put("error", r8.b + " assets is null !!!,tryConsumeEffectMessage next");
        v12.f.S(r8, r18);
        return or();
    L24:
        r17 = BuildConfig.FLAVOR;
        goto L25
    L27:
        e.d.getClass();
        e.a.C0075a r19 = e.a.C0075a.e;
        r19.c.g(Long.valueOf(r8.a), "consume effect msg get assets" + r8.b, new VideoGiftWidgetV2$tryConsumeEffectMessage$1(r8));
        Intrinsics.checkNotNullParameter(r8, "msg");
        int r110 = g02.a.a(r8);
        if (r110 != 0) goto L30;
        boolean r111 = false;
    L42:
        if (r111 == false) goto L45;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "resource type not match" + r8.b);
        r19.c.a(Long.valueOf(r8.a), "resource type not match " + r8.l + ' ' + r8.b, new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.RESOURCE_ERROR, "resource type not match"));
        JSONObject r20 = new JSONObject();
        StringBuilder r21 = new StringBuilder("resource type not match");
        r21.append(r8.b);
        r20.put("error", r21.toString());
        v12.f.S(r8, r20);
        return or();
    L45:
        Intrinsics.checkNotNullParameter(r8, "msg");
        Intrinsics.checkNotNullParameter(r11, "assets");
        String r112 = " aid:";
        if (this.j == true) goto L49;
        r19.c.d(Long.valueOf(r8.a), "effect switch close and drop this message");
        int r23 = i02.b.e;
        i02.b r24 = new i02.b(false, true, false, 13);
    L53:
        r13 = "error";
        r112 = " aid:";
    L266:
        if (r24.a == true) goto L276;
        e.d.getClass();
        e.a.C0075a r25 = e.a.C0075a.e;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g r26 = r25.c;
        Long r27 = Long.valueOf(r8.a);
        StringBuilder r28 = new StringBuilder("onPlayEffectGift ");
        r28.append(r24);
        r28.append(" giftId:");
        r28.append(r8.l);
        String r29 = r112;
        r28.append(r29);
        r28.append(r11.getId());
        r26.a(r27, r28.toString(), new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.NORMAL_ERROR, "not trigger onPlayEffectGift"));
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "not onPlayEffectGift " + r24 + ", " + r8.l + ' ' + r11.getId() + " ,tryConsumeEffectMessage next");
        if (r24.b == true) goto L270;
        JSONObject r30 = new JSONObject();
        r30.put("result", r24.d);
        r30.put(r13, "isEffectPaused onPlayEffectGift giftId:" + r8.l + r29 + r11.getId());
        v12.f.S(r8, r30);
        return or();
    L270:
        if (r24.c == false) goto L272;
        this.K.f.putFirst((T) r8);
    L272:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.b, "onPlayEffectGift effect paused; " + r24 + ", " + r8.l + ' ' + r11.getId() + " effect count:" + this.K.g());
        r25.c.d(Long.valueOf(r8.a), "effect paused,reenter queue");
        JSONObject r31 = new JSONObject();
        r31.put("result", r24.d);
        r31.put("queuesize", this.K.g());
        r31.put(r13, "not onPlayEffectGift effect paused,reenter queue giftId:" + r8.l + r29 + r11.getId());
        v12.f.S(r8, r31);
        return r24;
    L276:
        e.d.getClass();
        e.a.C0075a.e.c.d(Long.valueOf(r8.a), "trigger play success");
        JSONObject r33 = new JSONObject();
        r33.put("result", r24.d);
        r33.put(r13, "trigger play success");
        v12.f.S(r8, r33);
        int r34 = i02.b.e;
        return new i02.b(true, false, false, 0);
    L49:
        if (this.q == false) goto L51;
    L54:
        j r113 = ((GiftRecyclableWidget) this).a;
        if (r113 == null) goto L62;
        com.bytedance.android.livesdk.gift.platform.core.scope.service.d r114 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.d) m.e.d(r113, com.bytedance.android.livesdk.gift.platform.core.scope.service.d.class);
        if (r114 == null) goto L62;
        Map<Long, iy1.a> r115 = r8.e;
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.c().isEmpty() == true) goto L62;
        Single.create(new com.bytedance.android.livesdk.gift.platform.core.scope.service.e(r114, r11, r115)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
    L62:
        r8.a(10, com.bytedance.live.kmp.util.e.b());
        r19.c.d(Long.valueOf(r8.a), "onPlayEffectGift resourceType:" + r11.getResourceType() + " aid:" + r11.getId());
        ConcurrentHashMap<String, Map<String, Long>> r35 = v12.e.a;
        Intrinsics.checkNotNullParameter(r8, "effectMessage");
        if (com.bytedance.android.livesdk.gift.platform.core.h.p() == false) goto L105;
        if (r8.w == false) goto L105;
        String r36 = r8.y;
        if (r36 != null) goto L70;
    L73:
        boolean r37 = true;
    L74:
        if (r37 == true) goto L105;
        Intrinsics.checkNotNullParameter(r8, "effectMessage");
        if (com.bytedance.android.livesdk.gift.platform.core.h.p() == false) goto L105;
        if (r8.C == null) goto L105;
        if (r8.w == false) goto L105;
        long r116 = v12.e.e(r8.y, "send_success");
        if (r116 == 0) goto L105;
        long r117 = r116 - r8.x;
        HashMap r38 = new HashMap();
        r38.put("send_callback", String.valueOf(r117));
        v12.e.a(r38, r8);
        mz0.n r39 = new mz0.n();
        Map r40 = r39.a;
        Intrinsics.checkNotNullParameter(r40, "map");
        Intrinsics.checkNotNullParameter(r38, "map");
        r40.putAll(r38);
        cy0.e.a.getClass();
        cy0.j r41 = cy0.e.a.a;
        m.e.getClass();
        Object r43 = m.b(r41).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r43);
        ((i) ((f80.a) r43)).w3("livesdk_rd_gift_send_time", r39.a, r39.b);
        JSONObject r44 = new JSONObject();
        String r45 = (String) r38.get("free_display");
        if (r45 != null) goto L91;
        r45 = "-1";
    L91:
        r44.put("free_display", r45);
        h1 r46 = r8.C;
        if (r46 == null) goto L94;
        int r47 = r46.getType();
    L95:
        r44.put("gift_type", r47);
        r44.put("asset_type", r8.f);
        JSONObject r48 = new JSONObject(r38);
        boolean r49 = d0.a;
        Intrinsics.checkNotNullParameter(r44, "category");
        Intrinsics.checkNotNullParameter(r48, "metrics");
        String r210 = z.a("ttlive_send_gift_time_status");
        JSONObject r50 = new JSONObject();
        JSONObject r51 = new JSONObject();
        JSONObject r53 = new JSONObject();
        Intrinsics.checkNotNullParameter(r53, "extra");
        Intrinsics.checkNotNullParameter(r51, "metric");
        EventModule r118 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r118, "eventModule");
        String r211 = r118.getValue();
        Intrinsics.checkNotNullParameter(r50, "map");
        Iterator<String> r119 = r44.keys();
    L97:
        if (r119.hasNext() == false) goto L99;
        String r120 = r119.next();
        Iterator<String> r121 = r119;
        Object r122 = r44.get(r120);
        Intrinsics.checkNotNullParameter(r120, "key");
        Intrinsics.checkNotNullParameter(r122, "value");
        r50.put(r120, r122);
        r119 = r121;
        goto L97
    L99:
        Intrinsics.checkNotNullParameter(r51, "map");
        Iterator<String> r54 = r48.keys();
    L101:
        if (r54.hasNext() == false) goto L103;
        String r123 = r54.next();
        Object r124 = r48.get(r123);
        Intrinsics.checkNotNullParameter(r123, "key");
        Intrinsics.checkNotNullParameter(r124, "value");
        r51.put(r123, r124);
        goto L101
    L103:
        cy0.e.a.getClass();
        cy0.j r55 = cy0.e.a.a;
        m.e.getClass();
        Object r56 = m.b(r55).b(n97.a.class);
        Intrinsics.checkNotNull(r56);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r56)).g(r210, r211, "bussiness_api_call", r50, r51, r53);
        goto L105
    L94:
        r47 = 0;
        goto L95
    L70:
        if (r36.length() == 0) goto L73;
        r37 = false;
    L105:
        int r57 = i02.b.e;
        if (r11.getResourceType() != 4) goto L113;
        long r58 = r11.getId();
        String r59 = r8.d;
        if (r59 != null) goto L110;
        r59 = BuildConfig.FLAVOR;
    L110:
        mr(r58, r59);
        r24 = lr(r8, r11);
    L166:
        k r60 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r60 == null) goto L181;
        IRoom r61 = r60.getRoom();
        if (r61 == null) goto L181;
        IMainGiftRoom r63 = (IMainGiftRoom) r61.castToOrNull(IMainGiftRoom.class);
        if (r63 == null) goto L181;
        com.bytedance.android.live.revenue.model.extension.main.c r64 = r63.getOthers();
        if (r64 == null) goto L181;
        com.bytedance.android.live.revenue.model.extension.main.a r65 = r64.getEnterGiftAnimation();
        if (r65 == null) goto L181;
        if (r11.getId() != r65.getGiftEffectId()) goto L181;
        if (r24.a == false) goto L181;
        int r66 = com.bytedance.android.livesdk.gift.platform.core.utils.a.a;
        long r67 = r11.getId();
        com.bytedance.tools.kcp.spongepreference.runtime.a r68 = com.bytedance.android.livesdk.gift.platform.core.utils.b.b;
        KProperty[] r125 = com.bytedance.android.livesdk.gift.platform.core.utils.b.a;
        Set r126 = CollectionsKt.toMutableSet((Set) r68.getValue(null, r125[0]));
        r126.add(String.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        Long r127 = null;
        r68.setValue(null, r125[0], r126);
        mz0.n r69 = new mz0.n();
        Map r128 = r69.a;
        Intrinsics.checkNotNullParameter(r128, "map");
        String r70 = String.valueOf(r67);
        Intrinsics.checkNotNullParameter("animation_id", "key");
        Intrinsics.checkNotNullParameter(r70, r12);
        r128.put("animation_id", r70);
        Intrinsics.checkNotNullParameter("channel_type", "key");
        Intrinsics.checkNotNullParameter("gift", "value");
        r128.put("channel_type", "gift");
        mz0.m r71 = new mz0.m();
        r71.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r73 = ((kr2.a) vh6.c.b(kr2.a.class)).ud();
        Intrinsics.checkNotNullParameter(r73, "pageSourceLog");
        ((ArrayList) r71.a).add(r73.a);
        ((ArrayList) r69.b).addAll(r71.a);
        cy0.e.a.getClass();
        cy0.j r74 = cy0.e.a.a;
        m.e.getClass();
        Object r75 = m.b(r74).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r75);
        ((i) ((f80.a) r75)).w3("livesdk_consumer_assistant_animation_show", r69.a, r69.b);
    L182:
        String r76 = v12.f.a;
        v12.f.z(r8, r11, r24.d);
        if (r8.w == false) goto L200;
        i12.e r77 = o.b();
        if (r77 == null) goto L187;
        Object r129 = m.e.d(r77, GiftDataStorageService.class);
    L188:
        GiftDataStorageService r130 = (GiftDataStorageService) r129;
        if (r130 == null) goto L200;
        Integer r78 = Integer.valueOf(r8.u);
        if (r78 != null) goto L194;
    L195:
        if (r78 == null) goto L200;
        if (r78.intValue() != 13) goto L200;
    L199:
        r130.f++;
        goto L200
    L194:
        if (r78.intValue() == 2) goto L199;
    L187:
        r129 = r127;
    L200:
        boolean r79 = r24.a;
        if (r79 == true) goto L220;
        if (r11.getResourceType() != 4) goto L213;
        String r80 = r8.d;
        if (r80 != null) goto L207;
    L210:
        boolean r131 = true;
    L211:
        if (r131 == false) goto L213;
        boolean r81 = false;
        Aq(r8, 7, false);
    L215:
        if (r11.getResourceType() == 4) goto L224;
        int r83 = r24.d;
        if (r83 == 6) goto L224;
        Aq(r8, r83, r81);
    L224:
        boolean r84 = d0.a;
        Intrinsics.checkNotNullParameter(r8, "msg");
        Intrinsics.checkNotNullParameter(r11, "assets");
        if (r8.w == false) goto L240;
        LinkedHashMap r85 = new LinkedHashMap();
        r85.put("gift_id", Long.valueOf(r8.l));
        r85.put("asset_id", Long.valueOf(r11.getId()));
        List<n3> r86 = r8.P;
        if (r86 == null) goto L239;
        ArrayList r132 = new ArrayList();
        Iterator<T> r87 = r86.iterator();
    L231:
        if (r87.hasNext() == false) goto L238;
        h1 r133 = ((n3) r87.next()).getGift();
        if (r133 == null) goto L235;
        Long r134 = Long.valueOf(r133.getId());
    L236:
        if (r134 == null) goto L231;
        r132.add(r134);
        goto L231
    L235:
        r134 = r127;
        goto L236
    L238:
        r85.put("series_gift_ids", r132);
    L239:
        boolean r88 = com.bytedance.android.live.revenue.core.util.h.a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.GIFT_EFFECT, r85, r8.y);
    L240:
        boolean r89 = d0.a;
        Intrinsics.checkNotNullParameter(r8, "msg");
        Intrinsics.checkNotNullParameter(r11, "assets");
        if (r8.w == true) goto L266;
        k r90 = d0.b();
        if (r90 == null) goto L266;
        if (r90.isAnchor() != true) goto L266;
        LinkedHashMap r91 = new LinkedHashMap();
        r91.put("gift_id", Long.valueOf(r8.l));
        r91.put("asset_id", Long.valueOf(r11.getId()));
        IBaseUser r93 = r8.i;
        if (r93 == null) goto L252;
        String r94 = r93.getIdString();
        if (r94 == null) goto L252;
        r91.put("from_user_id", r94);
    L252:
        List<n3> r95 = r8.P;
        if (r95 == null) goto L264;
        ArrayList r96 = new ArrayList();
        Iterator<T> r97 = r95.iterator();
    L256:
        if (r97.hasNext() == false) goto L263;
        h1 r98 = ((n3) r97.next()).getGift();
        if (r98 == null) goto L260;
        Long r135 = Long.valueOf(r98.getId());
    L261:
        if (r135 == null) goto L256;
        r96.add(r135);
        goto L256
    L260:
        r135 = r127;
        goto L261
    L263:
        r91.put("series_gift_ids", r96);
    L264:
        boolean r99 = com.bytedance.android.live.revenue.core.util.h.a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.ANCHOR_GIFT_EFFECT, r91, r8.y);
        goto L266
    L207:
        if (r80.length() == 0) goto L210;
        r131 = false;
    L213:
        r81 = false;
        goto L215
    L220:
        if (r79 == false) goto L224;
        if (r11.getResourceType() == 4) goto L224;
        Aq(r8, 0, true);
    L181:
        r127 = null;
        goto L182
    L113:
        if (this.h.containsKey(Integer.valueOf(r11.getResourceType())) == false) goto L124;
        long r100 = r11.getId();
        String r101 = r8.d;
        if (r101 != null) goto L117;
        r101 = r7;
    L117:
        mr(r100, r101);
        com.bytedance.android.livesdk.gift.platform.business.effect.player.a r102 = (com.bytedance.android.livesdk.gift.platform.business.effect.player.a) ((LinkedHashMap) this.h).get(Integer.valueOf(r11.getResourceType()));
        if (r102 == null) goto L121;
        r24 = r102.a(r8, r11);
        if (r24 == null) goto L121;
    L122:
        String r103 = v12.f.a;
        v12.f.n(r8, r11, Integer.valueOf(r24.d));
    L121:
        r24 = i02.b.a.a(-1);
        goto L122
    L124:
        if (r11.getResourceType() != 15) goto L165;
        long r104 = r11.getId();
        String r136 = r8.d;
        if (r136 != null) goto L128;
        r136 = r7;
    L128:
        mr(r104, r136);
        String r105 = r8.d;
        if (r105 != null) goto L131;
        r105 = r7;
    L131:
        Intrinsics.checkNotNullParameter(r105, "path");
        String r106 = File.separator;
        if (r105.endsWith(r106) == false) goto L134;
        String r107 = r105.concat("interact_script.json");
    L135:
        if (r107 == null) goto L139;
        String r108 = m02.b.b(r107);
        if (r108 == null) goto L139;
        ScriptInfo r109 = (ScriptInfo) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r108, ScriptInfo.class);
    L141:
        if (r109 != null) goto L147;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r11.getLynxSchema()) == true) goto L147;
        r24 = lr(r8, r11);
    L147:
        if (TextUtils.isEmpty(r8.d) == true) goto L149;
    L151:
        dr(r109, r11, new VideoGiftWidgetV2$playInteractEffects$1(this));
        JSONObject r137 = new JSONObject();
        if (v12.f.c(r8) == false) goto L164;
        r137.put("canshow", this.j);
        r137.put("reason", this.k);
        r137.put("assetId", r11.getId());
        VideoGiftView r138 = this.e;
        if (r138 == null) goto L156;
        String r139 = r138.getPlayerType();
    L157:
        r137.put("playerType", r139);
        Intrinsics.checkNotNullParameter(r8, "effectMessage");
        Intrinsics.checkNotNullParameter(r137, "extra");
        if (v12.f.c(r8) == false) goto L164;
        r137.put("play_type", "interact");
        v12.f.I(r8, r137);
        String r140 = r8.y;
        if (r140 != null) goto L163;
        r140 = "0";
    L163:
        v12.f.t("effect_play_begin", r140, r137);
        goto L164
    L156:
        r139 = null;
    L164:
        Bq(r8, -1);
        r24 = new i02.b(true);
        goto L166
    L149:
        if (TextUtils.isEmpty(r11.getLynxSchema()) == false) goto L151;
        r24 = i02.b.a.a(7);
    L139:
        r109 = null;
        goto L141
    L134:
        r107 = r105 + r106 + "interact_script.json";
        goto L135
    L165:
        br(r8);
        BaseVideoGiftWidget.cr(r8, r11);
        e.d.getClass();
        e.a.C0075a.e.c.a(Long.valueOf(r8.a), " assets type err aid:" + r11.getId(), new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.RESOURCE_ERROR, "onPlay assets type err"));
        r24 = i02.b.a.a(-1);
        goto L166
    L51:
        if (((Boolean) bz.a.getValue()).booleanValue() == false) goto L54;
        r19.c.d(Long.valueOf(r8.a), "landscape scene and drop this message");
        int r141 = i02.b.e;
        r24 = new i02.b(false, true, false, 14);
        goto L53
    L30:
        if (r110 == 1) goto L37;
        if (r110 == 2) goto L34;
    L39:
        r111 = true;
        goto L42
    L34:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.m.h(r8) == false) goto L39;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "recycle resource" + r8.b);
        this.K.n(r8);
        goto L39
    L37:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.m.g(r8) == false) goto L39;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "recycle resource" + r8.b);
        this.K.n(r8);
        goto L39
    L16:
        if (r10.getEndTime() >= (com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW))) goto L19;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.b, "该条一起送消息过期丢弃，message id is " + r8.a + ", isLocal is " + r8.w);
        return or();
    }

    public VideoGiftWidgetV2() {
        this.J = S;
        this.K = new com.bytedance.android.livesdk.gift.platform.business.tray2.manager.d(this.c);
        this.L = a.a();
        this.M = new ArrayList();
        this.N = new ArrayList();
        this.O = 1;
        Intrinsics.checkNotNullParameter("VideoGiftWidgetV2", "<set-?>");
        this.b = "VideoGiftWidgetV2";
        this.P = ((Number) com.bytedance.android.livesdk.gift.platform.core.h.G.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[31])).intValue();
        this.Q = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.Q.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[41])).booleanValue();
        this.R = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Fq() {
        kr();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.g
    public final void Ge(Message r5) {
        String r0 = this.b;
        StringBuilder r1 = new StringBuilder("onConsumeTimeout type ");
        Object r2 = null;
        if (r5 == null) goto L5;
        Integer r3 = Integer.valueOf(r5.arg1);
    L6:
        r1.append(r3);
        r1.append(" msgId:");
        if (r5 == null) goto L9;
        Object r6 = r5.obj;
    L11:
        if ((r6 instanceof Map) == true) goto L13;
        r6 = null;
    L13:
        Map r7 = (Map) r6;
        if (r7 == null) goto L16;
        r2 = r7.get("msgId");
    L16:
        r1.append(r2);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r0, r1.toString());
        og();
        return;
    L9:
        r6 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Sq(k6 r4) {
        Intrinsics.checkNotNullParameter(r4, "assetsMessage");
        if (isViewValid() == true) goto L6;
        v12.f.B("receiveAssetMessage view invalide");
        return;
    L6:
        e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g r0 = e.a.C0075a.e.c;
        Long r1 = qj.a(r4);
        if (r1 == null) goto L9;
        long r2 = r1.longValue();
    L10:
        r0.d(Long.valueOf(r2), "receiveAssetMessage ");
        List r3 = r4.getRequiredAssets();
        if (r3 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
    L21:
        GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r6 == null) goto L28;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.tray2.k> r7 = r6.getMessageDispatcher();
        if (r7 == null) goto L28;
        com.bytedance.android.livesdk.gift.platform.business.tray2.k r8 = (com.bytedance.android.livesdk.gift.platform.business.tray2.k) r7.getValue();
        if (r8 == null) goto L28;
        NormalGiftMessage r9 = r8.a(r4);
    L29:
        this.J.n(r9);
        return;
    L28:
        r9 = null;
        goto L29
    L19:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.a() == true) goto L21;
        return;
    L13:
        if (r3.isEmpty() == true) goto L16;
        r5 = false;
        goto L17
    L9:
        r2 = 0;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Tq(i6 r2) {
        Intrinsics.checkNotNullParameter(r2, "assetsUtilMessage");
        if (isViewValid() == true) goto L6;
        v12.f.B("receiveAssetUtilMessage view invalide");
        return;
    L6:
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.tray2.k> r1 = r0.getMessageDispatcher();
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.gift.platform.business.tray2.k r3 = (com.bytedance.android.livesdk.gift.platform.business.tray2.k) r1.getValue();
        if (r3 == null) goto L13;
        NormalGiftMessage r4 = r3.a(r2);
    L14:
        this.J.n(r4);
        return;
    L13:
        r4 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Wq(q8 r7) {
        Intrinsics.checkNotNullParameter(r7, "lightMessage");
        if (isViewValid() == true) goto L6;
        v12.f.B("receiveLightMessage view invalide");
        return;
    L6:
        e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g r0 = e.a.C0075a.e.c;
        Long r1 = qj.a(r7);
        Intrinsics.checkNotNull(r1);
        r0.d(r1, "receiveLightMessage ");
        long r2 = r7.getCount();
        long r3 = 0;
    L8:
        if (r3 >= r2) goto L18;
        GiftContext r4 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r4 == null) goto L16;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.tray2.k> r5 = r4.getMessageDispatcher();
        if (r5 == null) goto L16;
        com.bytedance.android.livesdk.gift.platform.business.tray2.k r6 = (com.bytedance.android.livesdk.gift.platform.business.tray2.k) r5.getValue();
        if (r6 == null) goto L16;
        NormalGiftMessage r8 = r6.a(r7);
    L17:
        nr(r8);
        r3 = r3 + 1;
    L16:
        r8 = null;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Yq(gm2.g r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.getGiftMessage() != null) goto L7;
        v12.f.B("receiveMockLocalGiftMessage giftMessage is null");
        return;
    L7:
        if (isViewValid() == true) goto L10;
        v12.f.B("receiveMockLocalGiftMessage view invalide");
        return;
    L10:
        gm2.d r0 = r5.getGiftMessage();
        if (r0 != null) goto L13;
        return;
    L13:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r0.getTraceId()) == false) goto L26;
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L21;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.tray2.k> r2 = r1.getMessageDispatcher();
        if (r2 == null) goto L21;
        com.bytedance.android.livesdk.gift.platform.business.tray2.k r3 = (com.bytedance.android.livesdk.gift.platform.business.tray2.k) r2.getValue();
        if (r3 == null) goto L21;
        NormalGiftMessage r4 = r3.a(r0);
    L23:
        if (r4 == null) goto L25;
        r4.i = true;
    L25:
        List<String> r6 = this.M;
        String r7 = r0.getTraceId();
        Intrinsics.checkNotNull(r7);
        ((ArrayList) r6).add(r7);
        String r8 = v12.f.a;
        v12.f.M(r5.getGiftMessage(), ((Widget) this).isViewValid, true);
        nr(r4);
        return;
    L21:
        r4 = null;
        goto L23
    L26:
        v12.f.B("receiveMockLocalGiftMessage traceId is null");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Zq(o7 r11) {
        boolean r2 = false;
        if (this.P <= 0) goto L23;
        if (r11 != null) goto L6;
    L7:
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        k r4 = com.bytedance.android.live.revenue.core.util.f.d(r0.a(), k.class);
        if (r4 == null) goto L10;
        long r5 = r4.getEnterRoomTime();
    L12:
        if ((System.currentTimeMillis() - r5) >= this.P) goto L23;
        k r1 = com.bytedance.android.live.revenue.core.util.f.d(r0.a(), k.class);
        if (r1 != null) goto L16;
    L18:
        boolean r3 = false;
    L19:
        float r6 = z0.b(r3);
        if (r6 > ((Number) com.bytedance.android.livesdk.gift.platform.core.h.P.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[40])).floatValue()) goto L23;
        h.o(r6, r3);
        String r7 = v12.f.a;
        v12.f.N(r11, ((Widget) this).isViewValid, 1);
        return;
    L16:
        if (r1.isAnchor() != true) goto L18;
        r3 = true;
        goto L19
    L10:
        r5 = System.currentTimeMillis();
        goto L12
    L6:
        if (r11.isLocal() != true) goto L7;
    L23:
        com.bytedance.android.livesdk.revenue.experience.c r8 = vh6.c.b(com.bytedance.android.livesdk.revenue.experience.c.class);
        if (r8 == null) goto L39;
        com.bytedance.android.livesdk.revenue.experience.f r9 = r8.Mg(((Widget) this).dataCenter, RevExpBizScene.DEGRADE_BUSINESS_REVENUE_GIFT_VIDEO);
        if (r9 == null) goto L39;
        if (r9.a != true) goto L39;
        if (r11 != null) goto L31;
    L32:
        k r10 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r10 != null) goto L35;
    L37:
        h.o(z0.b(r2), r2);
        String r13 = v12.f.a;
        v12.f.N(r11, ((Widget) this).isViewValid, 2);
        return;
    L35:
        if (r10.isAnchor() != true) goto L37;
        r2 = true;
        goto L37
    L31:
        if (r11.isLocal() != true) goto L32;
    L39:
        com.bytedance.android.livesdk.revenue.service.performance.d r14 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class);
        if (r14 != null) goto L42;
    L43:
        if (r11 != null) goto L45;
    L95:
        k r15 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r15 != null) goto L98;
    L100:
        h.o(z0.b(r2), r2);
        String r16 = v12.f.a;
        v12.f.N(r11, ((Widget) this).isViewValid, 3);
        return;
    L98:
        if (r15.isAnchor() != true) goto L100;
        r2 = true;
        goto L100
    L45:
        if (r11.isLocal() != true) goto L95;
    L47:
        boolean r17 = isViewValid();
        if (r17 == true) goto L53;
        if (r11 == null) goto L51;
        long r18 = r11.getMessageId();
        e.d.getClass();
        e.a.C0075a.e.c.a(Long.valueOf(r18), this.b + " receiveVideoGiftMessage not ViewValid", new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.OBJECT_NULL, this.b + " View not Valid"));
    L51:
        v12.f.N(r11, r17, 4);
        return;
    L53:
        if (r11 == null) goto L55;
        long r19 = r11.getMessageId();
        e.d.getClass();
        e.a.C0075a.e.c.d(Long.valueOf(r19), this.b + " receiveVideoGiftMessage");
    L55:
        if (r11 != null) goto L58;
        v12.f.B("receiveVideoGiftMessage giftMessage is null");
        return;
    L58:
        i12.e r20 = o.b();
        if (r20 == null) goto L61;
        Object r21 = m.e.d(r20, com.bytedance.android.livesdk.gift.platform.business.tray2.e.class);
    L62:
        com.bytedance.android.livesdk.gift.platform.business.tray2.e r23 = (com.bytedance.android.livesdk.gift.platform.business.tray2.e) r21;
        if (r23 == null) goto L65;
        r23.a(r11);
    L65:
        GiftContext r24 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r24 == null) goto L72;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.tray2.k> r25 = r24.getMessageDispatcher();
        if (r25 == null) goto L72;
        com.bytedance.android.livesdk.gift.platform.business.tray2.k r26 = (com.bytedance.android.livesdk.gift.platform.business.tray2.k) r25.getValue();
        if (r26 == null) goto L72;
        NormalGiftMessage r27 = r26.a(r11);
    L73:
        if (r27 != null) goto L75;
    L77:
        v12.f.M(r11, r17, false);
        if (b02.a.c(r11) == false) goto L93;
        long r28 = r11.getGroupCount();
        long r29 = 0;
    L81:
        if (r29 >= r28) goto L105;
        GiftContext r30 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r30 == null) goto L91;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.tray2.k> r31 = r30.getMessageDispatcher();
        if (r31 == null) goto L91;
        com.bytedance.android.livesdk.gift.platform.business.tray2.k r33 = (com.bytedance.android.livesdk.gift.platform.business.tray2.k) r31.getValue();
        if (r33 == null) goto L91;
        NormalGiftMessage r34 = r33.a(r11);
        if (r34 == null) goto L91;
        r34.K = true;
    L92:
        nr(r34);
        r29 = r29 + 1;
    L91:
        r34 = null;
        goto L92
    L105:
        return;
    L93:
        nr(r27);
        return;
    L75:
        if (r27.p != true) goto L77;
        return;
    L72:
        r27 = null;
        goto L73
    L61:
        r21 = null;
        goto L62
    L42:
        if (r14.canLoad(532) == true) goto L47;
        goto L43
    }

    public final int jr(NormalGiftMessage r13) {
        EffectMessage r1 = null;
        if ((r13.t instanceof q8) == false) goto L5;
    L8:
        Intrinsics.checkNotNullParameter(r13, "normalMessage");
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.consume_message, r13.a, r13.b, r13.getAssetId());
        com.bytedance.android.livesdk.gift.platform.business.tray2.manager.d r0 = this.K;
        int r2 = com.bytedance.android.livesdk.gift.platform.core.utils.m.a;
        IRoom r3 = this.d;
        if (r3 == null) goto L11;
        IBaseUser r4 = r3.getOwner();
    L12:
        Intrinsics.checkNotNullParameter(r13, "msg");
        gm2.d r5 = r13.t;
        boolean r6 = false;
        if ((r5 instanceof o7) == false) goto L16;
        r13.r().setMaps(r13.j);
        r1 = com.bytedance.android.livesdk.gift.platform.core.utils.m.b(r13, r4);
    L37:
        Map<Long, iy1.a> r7 = r13.A;
        if (r7 == null) goto L41;
        if (r1 == null) goto L41;
        r1.e = r7;
    L41:
        String r8 = r13.O;
        if (r8 != null) goto L44;
    L51:
        if (r1 == null) goto L56;
        int r14 = r13.B;
        if (r1.I != (-1)) goto L56;
        r1.I = r14;
    L56:
        return r0.n(r1);
    L44:
        if (r8.length() <= 0) goto L46;
        r6 = true;
    L46:
        if (r6 == false) goto L51;
        if (r1 == null) goto L49;
        r1.d = r13.O;
    L49:
        if (r1 == null) goto L51;
        r1.f = r13.N;
        goto L51
    L16:
        if ((r5 instanceof k6) == false) goto L19;
        k6 r9 = r13.o();
        r9.setMaps(r13.j);
        r1 = com.bytedance.android.livesdk.gift.platform.core.utils.m.d(r9);
        goto L37
    L19:
        if (r13.n() == null) goto L22;
        i6 r10 = r13.n();
        r10.setMaps(r13.j);
        r1 = com.bytedance.android.livesdk.gift.platform.core.utils.m.c(r10);
        goto L37
    L22:
        if ((r13.t instanceof q8) == false) goto L37;
        q8 r11 = r13.s();
        r11.setMaps(r13.j);
        Long r15 = qj.a(r11);
        long r16 = 0;
        if (r15 == null) goto L29;
        if (r15.longValue() == 0) goto L37;
    L29:
        if (r11.getGift() == null) goto L37;
        h1 r17 = r11.getGift();
        if (r17 == null) goto L37;
        String r18 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).H0(r17.getPrimaryEffectId());
        EffectMessage r19 = new EffectMessage();
        Long r20 = qj.a(r11);
        if (r20 == null) goto L36;
        r16 = r20.longValue();
    L36:
        r19.a = r16;
        r19.b = r17.getPrimaryEffectId();
        r19.d = r18;
        r19.g = true;
        ((HashMap) r19.B).putAll(r11.getMaps());
        r19.n = r11.getLogId();
        r19.w = false;
        r19.z = r11.getCommonData();
        r19.s = r11.getDiyItemInfo();
        r19.l = r17.getId();
        r19.L = 3;
        r1 = r19;
        goto L37
    L11:
        r4 = null;
        goto L12
    L5:
        if (GiftEffectManager.b(r13, null) == false) goto L8;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.b, "onConsumeMessage: not consume,because of interceptGiftMsg " + r13);
        e.d.getClass();
        e.a.C0075a.e.c.d(Long.valueOf(r13.a), "dispatchToEffectMsgManager interceptGiftMsg ");
        return 5;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b
    public final boolean lh(NormalGiftMessage r7) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        Intrinsics.checkNotNullParameter(r7, "msg");
        e.d.getClass();
        e.a.C0075a r0 = e.a.C0075a.e;
        r0.c.g(Long.valueOf(r7.a), "onConsumeCGiftMessage ", VideoGiftWidgetV2$onConsumeCGiftMessage$1.INSTANCE);
        String r1 = v12.f.a;
        boolean r2 = true;
        v12.f.w(r7, !this.l);
        if ((!this.l) == true) goto L5;
        r0.c.d(Long.valueOf(r7.a), "isEffectPlayDone: false");
        return false;
    L5:
        com.bytedance.android.livesdk.revenue.service.interact.d r3 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        if (r3 == null) goto L8;
        Integer r4 = Integer.valueOf(r3.getCurrentScene());
    L9:
        int r5 = r4.intValue();
        if ((r7.t instanceof q8) == false) goto L29;
        if (r5 == 1) goto L29;
        if (r5 == 7) goto L29;
        r0.c.d(Long.valueOf(r7.a), "skip lightMessage when not in PK scene");
        return false;
    L29:
        int r6 = jr(r7);     // Catch: Exception -> L17
        String r8 = BuildConfig.FLAVOR;
    L19:
        v12.f.h(r7, r6, r8);
        if (r6 != 0) goto L22;
    L24:
        if (r6 == 0) goto L28;
        r2 = false;
    L28:
        return r2;
    L22:
        if (r6 == 4) goto L24;
        hr(r7, r6);
    L17:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "onConsumeMessage " + e.getMessage());
        r8 = e.getMessage();
        r6 = -1;
        goto L19
    L8:
        r4 = null;
        goto L9
    }

    public final void nr(NormalGiftMessage r10) {
        Object r0 = null;
        if (r10 == null) goto L25;
        if (r10.v != true) goto L25;
        if (r10.i == true) goto L25;
        o7 r2 = r10.r();
        if (r2 == null) goto L11;
        String r3 = r2.getTraceId();
    L13:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r3) == false) goto L25;
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().getEnable() == false) goto L25;
        if (CollectionsKt.contains(this.M, r3) == false) goto L25;
        List<String> r11 = this.M;
        if (r11 == null) goto L23;
        TypeIntrinsics.asMutableCollection(r11).remove(r3);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L11:
        r3 = null;
    L25:
        if ((!this.l) == false) goto L28;
        if (r10 == null) goto L30;
        r10.setTimeStampMap(13, 1);
    L30:
        if (r10 == null) goto L32;
        r10.setTimeStampMap(2, com.bytedance.live.kmp.util.e.b());
    L32:
        i12.e r4 = o.b();
        if (r4 == null) goto L35;
        Object r5 = m.e.d(r4, g3.class);
    L36:
        g3 r6 = (g3) r5;
        if (r6 == null) goto L92;
        boolean r7 = false;
        if (r10 != null) goto L42;
    L81:
        if (r7 != true) goto L92;
        if (r10 != null) goto L84;
    L86:
        long r1 = System.currentTimeMillis();
        i12.e r8 = o.b();
        if (r8 == null) goto L89;
        r0 = m.e.d(r8, g3.class);
    L89:
        g3 r9 = (g3) r0;
        if (r9 == null) goto L94;
        r9.c(r10, new d(this, r10, r1));
        return;
    L94:
        return;
    L84:
        if (r10.P != true) goto L86;
        ((ArrayList) this.N).add(r10);
        goto L86
    L42:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.d().b() == false) goto L71;
        if ((r10.t instanceof q8) == true) goto L79;
        o7 r13 = r10.r();
        if (r13 == null) goto L81;
        List<n3> r14 = r10.F;
        if (r14 != null) goto L52;
    L55:
        boolean r15 = true;
    L56:
        if (r15 == false) goto L79;
        h2 r16 = u.f(r13);
        if (r16 == null) goto L81;
        com.bytedance.android.live.core.resources.e r17 = r6.c.G1(r16.getPrimaryEffectId());
        if (r17 == null) goto L81;
        if (r17.getResourceType() != 11) goto L68;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("SendTogetherService", "pre download asset, message id is " + r13.getMessageId());
        goto L79
    L68:
        if (r10.D == null) goto L71;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("SendTogetherService", "pre download send together asset, message id is " + r13.getMessageId());
        goto L79
    L52:
        if (r14.isEmpty() == true) goto L55;
        r15 = false;
    L79:
        r7 = true;
    L71:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.d().a() == false) goto L80;
        k r18 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r18 != null) goto L75;
    L77:
        boolean r19 = false;
    L78:
        if (r19 == false) goto L80;
    L75:
        if (r18.isAnchor() != true) goto L77;
        r19 = true;
    L80:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r6.a, "不拦截此消息进行前置特效消息下载");
    L92:
        this.J.n(r10);
        return;
    L35:
        r5 = null;
        goto L36
    L28:
        if (r10 == null) goto L30;
        r10.setTimeStampMap(13, 0);
        goto L30
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void onLoad(Object[] r3) {
        super.onLoad(r3);
        GiftContext r4 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.k<i02.d> r5 = r4.getSendTogetherSlotChangeEvent();
        if (r5 == null) goto L11;
        PublishSubject r6 = r5.onEvent();
        if (r6 == null) goto L11;
        ObservableSubscribeProxy r7 = (ObservableSubscribeProxy) r6.as(AutoDispose.bind(this));
        if (r7 == null) goto L11;
        r7.subscribe(new c(this));
    L11:
        com.bytedance.android.livesdk.revenue.experience.c r8 = vh6.c.b(com.bytedance.android.livesdk.revenue.experience.c.class);
        if (r8 == null) goto L17;
        Disposable r9 = r8.Vi(RevExpBizScene.DEGRADE_BUSINESS_REVENUE_GIFT_VIDEO, new com.bytedance.android.livesdk.gift.platform.business.effect.widget.d());
        if (r9 == null) goto L18;
        RxUtilKt.c(r9, this.R);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b
    public final void pg(NormalGiftMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void hr(NormalGiftMessage r30, int r31) {
        if (r30 != null) goto L5;
        return;
    L5:
        Long r1 = r30.j.get(6);
        if (r1 == null) goto L8;
        long r4 = r1.longValue();
    L9:
        Long r2 = r30.j.get(7);
        if (r2 == null) goto L12;
        long r6 = r2.longValue();
    L13:
        long r13 = r6 - r4;
        boolean r7 = false;
        if (r30.b <= 0) goto L16;
        boolean r14 = true;
    L17:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L22;
        Boolean r5 = (Boolean) r3.get("data_is_anchor", Boolean.FALSE);
        if (r5 == null) goto L22;
        boolean r26 = r5.booleanValue();
    L23:
        IBaseUser r8 = r30.e;
        if (r8 == null) goto L26;
        String r9 = r8.getIdString();
    L27:
        IBaseUser r10 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b();
        List<String> r11 = r30.C;
        if (r11 != null) goto L30;
    L33:
        boolean r15 = true;
    L34:
        if (r15 == true) goto L36;
        boolean r27 = r30.C.contains(r10.getIdString());
    L37:
        boolean r28 = Intrinsics.areEqual(r10.getIdString(), r9);
        h2 r16 = u.f(r30.r());
        int r17 = j02.a.a;
        if (r16 == null) goto L40;
        long r18 = r16.getPrimaryEffectId();
    L41:
        int r19 = r30.N;
        long r20 = r30.a;
        int r21 = r30.B;
        List<n3> r110 = r30.F;
        if (r110 != null) goto L44;
    L45:
        r7 = true;
    L46:
        boolean r23 = !r7;
        long r0 = r30.b;
        if (r16 == null) goto L49;
        int r24 = r16.getType();
    L50:
        j02.a.a(r18, r19, r31, r13, r14, r20, r21, r27, r28, r23, r0, r24);
        c0 r25 = c0.a;
        if (r16 == null) goto L53;
        long r111 = r16.getPrimaryEffectId();
    L54:
        c0.b(false, r111, BuildConfig.FLAVOR, r31, "download asset failed", -1, null, null, null, null, r26, r27, r28);
        return;
    L53:
        r111 = -1;
        goto L54
    L49:
        r24 = -1;
        goto L50
    L44:
        if (r110.isEmpty() == false) goto L46;
    L40:
        r18 = -1;
        goto L41
    L36:
        r27 = r26;
        goto L37
    L30:
        if (r11.isEmpty() == true) goto L33;
        r15 = false;
        goto L34
    L26:
        r9 = null;
    L22:
        r26 = false;
        goto L23
    L16:
        r14 = false;
        goto L17
    L12:
        r6 = 0;
        goto L13
    L8:
        r4 = 0;
        goto L9
    }

    public final i02.b lr(EffectMessage r21, com.bytedance.android.live.core.resources.e r23) {
        Intrinsics.checkNotNullParameter(r21, "msg");
        Intrinsics.checkNotNullParameter(r23, "assets");
        e.d.getClass();
        e.a.C0075a r2 = e.a.C0075a.e;
        r2.c.d(Long.valueOf(r21.a), "playMp4Effect ");
        if (TextUtils.isEmpty(r21.d) == false) goto L6;
        fr(r21);
        r2.c.a(Long.valueOf(r21.a), "playMp4Effect err, " + r21.l + ' ' + r21.b, new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.RESOURCE_ERROR, "mp4 resource local path empty"));
        int r1 = i02.b.e;
        return i02.b.a.a(7);
    L6:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.b, "ConsumeEffectMessage(), giftId = " + r21.l);
        m02.i r4 = this.m;
        long r7 = r21.b;
        r4.getClass();
        r4.a = jc1.k.n(IGiftService.class).getAssets("effects", r7);
        boolean r5 = u.q();
        boolean r6 = u.s();
        boolean r8 = x.b();
        if (r8 == false) goto L9;
    L17:
        boolean r9 = true;
    L18:
        JSONObject r10 = new JSONObject();
        String r11 = null;
        if (r9 == false) goto L26;
        boolean r13 = Iq(r21);
        String r14 = v12.f.a;
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L23;
    L25:
        boolean r15 = r13;
        JSONObject r16 = r10;
    L74:
        if (v12.f.c(r21) == false) goto L79;
        r16.put("needHide", r9);
        r16.put("triggerPlay", r15);
        r16.put("canshow", this.j);
        r16.put("reason", this.k);
        r16.put("assetId", r23.getId());
        VideoGiftView r3 = this.e;
        if (r3 == null) goto L78;
        r11 = r3.getPlayerType();
    L78:
        r16.put("playerType", r11);
        v12.f.D(r21, r16);
    L79:
        r2.c.d(Long.valueOf(r21.a), "playMp4Effect " + r15);
        h.x("播放视频礼物 canShowVideoGiftView:" + this.j + " reason: " + this.k, String.valueOf(r21.l), String.valueOf(r21.a), BuildConfig.FLAVOR, r21.n);
        return new i02.b(r15);
    L23:
        if (r21.w == false) goto L25;
        r10.put("isVerticalVideo", r5);
        r10.put("isIntercepted", r21.o);
        r10.put("isVSEpisode", r8);
        r10.put("isVerticalVideo", r5);
        goto L25
    L26:
        VideoGiftView r17 = this.e;
        if (r17 == null) goto L30;
        r17.d(this.j);
    L30:
        if (this.j == true) goto L33;
        Long r18 = Long.valueOf(r21.a);
        String r19 = this.b + " canShowVideoGiftView is false reason:" + this.k;
        Long r20 = Long.valueOf(r21.l);
        Intrinsics.checkNotNullParameter(r18, "msgId");
        Intrinsics.checkNotNullParameter(r19, "content");
        e.a.a(r18, r19, r20, null);
        return new i02.b(false, true, true, -1);
    L33:
        int r24 = m02.f.a(Long.valueOf(r21.b), r21.d);
        SuperResolutionModel r25 = new SuperResolutionModel(m02.f.d(r21.d), m02.f.c(r21.d), Kq(r24), r21.b, r24);
        this.s = r25;
        this.m.b = r25;
        VideoGiftView r26 = this.e;
        if (r26 == null) goto L39;
        IRoom r27 = this.d;
        if (r27 == null) goto L38;
        r27.getOwner();
    L38:
        r15 = r26.g(r21, this.s);
    L40:
        n02.a r28 = this.i;
        if (r28 == null) goto L43;
        Intrinsics.checkNotNull(r28);
        n02.a.a(r21);
    L43:
        if (r15 == false) goto L46;
        Bq(r21, m02.f.a(Long.valueOf(r21.b), r21.d));
    L46:
        if (v12.f.c(r21) == false) goto L72;
        SuperResolutionModel r29 = this.s;
        if (r29 == null) goto L50;
        Integer r30 = Integer.valueOf(r29.getVideoWidth());
    L51:
        r16 = r10;
        r16.put("videoWidth", r30);
        SuperResolutionModel r31 = this.s;
        if (r31 == null) goto L54;
        Integer r33 = Integer.valueOf(r31.getVideoHeight());
    L55:
        r16.put("videoHeight", r33);
        SuperResolutionModel r34 = this.s;
        if (r34 == null) goto L58;
        Long r35 = Long.valueOf(r34.getEffectId());
    L59:
        r16.put("effectId", r35);
        SuperResolutionModel r36 = this.s;
        if (r36 == null) goto L62;
        Boolean r37 = Boolean.valueOf(r36.getOpenSR());
    L63:
        r16.put("openSR", r37);
        SuperResolutionModel r38 = this.s;
        if (r38 == null) goto L66;
        Integer r39 = Integer.valueOf(r38.getResultCode());
    L67:
        r16.put("resultCode", r39);
        SuperResolutionModel r40 = this.s;
        if (r40 == null) goto L70;
        Integer r41 = Integer.valueOf(r40.getVideoAssetType());
    L71:
        r16.put("videoAssetType", r41);
        goto L74
    L70:
        r41 = null;
        goto L71
    L66:
        r39 = null;
        goto L67
    L62:
        r37 = null;
        goto L63
    L58:
        r35 = null;
        goto L59
    L54:
        r33 = null;
        goto L55
    L50:
        r30 = null;
        goto L51
    L72:
        r16 = r10;
        goto L74
    L39:
        r15 = false;
        goto L40
    L9:
        if (this.q == true) goto L13;
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_LANDSCAPE_EFFECT, Boolean.FALSE)).booleanValue() == false) goto L17;
    L13:
        if (r21.o == true) goto L17;
        if (r6 == true) goto L17;
        r9 = false;
        goto L18
    }

    public final void mr(long r8, String r10) {
        if (this.Q == false) goto L21;
        List r11 = StringsKt.split$default(r10, new String[]{"/"}, false, 0, 6, null);
        ListIterator r13 = r11.listIterator(r11.size());
    L6:
        if (r13.hasPrevious() == false) goto L13;
        Object r0 = r13.previous();
        if (((String) r0).length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L6;
    L14:
        int r14 = ft1.k.a;
        HashMap r15 = new HashMap();
        r15.put("gift_foreground_asset", r8 + ',' + ((String) r0));
        Unit r9 = Unit.INSTANCE;
        ft1.k.a(r15);
        return;
    L10:
        r1 = false;
        goto L11
    L13:
        r0 = null;
        goto L14
    }
}
