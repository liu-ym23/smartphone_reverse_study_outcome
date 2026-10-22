package com.bytedance.android.livesdk.gift.multiplayer;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.resources.l;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.NewGiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.n0;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.VideoGiftWidgetV2;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.VideoGiftMsgManagerV2;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.GiftMsgConsumeDispatcher;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftEffectManager;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.gift.platform.core.y;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerProgressListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonSyntaxException;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.multi_player.MultiPlayerController;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/multiplayer/MultiPlayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/gift/platform/core/y;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "Lcom/bytedance/android/livesdk/gift/platform/business/tray2/manager/dispatcher/b;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiPlayerWidget extends LiveRecyclableWidget implements y, Observer<KVData>, com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b<NormalGiftMessage> {
    public static final /* synthetic */ int r = 0;
    public FrameLayout a;
    public FrameLayout b;
    public NewGiftSwitchImageView c;
    public GiftSwitchImageView d;
    public IRoom e;
    public boolean f;
    public AssetsService g;
    public boolean h;
    public EffectMessage i;
    public long j;
    public final ArrayList<EffectMessage> k;
    public com.bytedance.android.livesdk.gift.multiplayer.c l;
    public Disposable m;
    public n02.a n;
    public final e o;
    public final f p;
    public final b q;

    public static final class a {
    }

    public static final class b implements IResultMonitor {
        public final /* synthetic */ MultiPlayerWidget a;

        public b(MultiPlayerWidget r1) {
            this.a = r1;
        }

        public final void monitor(boolean r21, String r23, int r24, int r25, String r26) {
            EffectMessage r2 = this.a.i;
            if (r2 == null) goto L5;
            long r3 = r2.b;
        L6:
            com.bytedance.android.live.core.resources.e r4 = k.n(IGiftService.class).getAssets("effects", r3);
            if (r4 == null) goto L13;
            l r5 = r4.getResourceModel();
            if (r5 == null) goto L13;
            List r6 = r5.getUrlList();
            if (r6 == null) goto L13;
            String r7 = (String) CollectionsKt.getOrNull(r6, 0);
        L14:
            HashMap r8 = new HashMap();
            r8.put("event_name", "VIDEO_GIFT_PLAY_SUCCESS_RATE");
            r8.put("gift_id", String.valueOf(r3));
            String r9 = BuildConfig.FLAVOR;
            if (r7 != null) goto L17;
            String r10 = BuildConfig.FLAVOR;
        L18:
            r8.put("gift_resource", r10);
            r8.put("extra", String.valueOf(r25));
            r8.put("code", String.valueOf(r24));
            if (r23 != null) goto L21;
            String r11 = BuildConfig.FLAVOR;
        L22:
            r8.put("player_type", r11);
            if (r26 != null) goto L25;
            String r13 = BuildConfig.FLAVOR;
        L26:
            r8.put("error_info", r13);
            EffectMessage r14 = this.a.i;
            if (r14 == null) goto L32;
            String r15 = r14.n;
            if (r15 != null) goto L31;
            r15 = BuildConfig.FLAVOR;
        L31:
            r8.put("log_id", r15);
        L32:
            c0 r16 = c0.a;
            EffectMessage r17 = this.a.i;
            if (r17 == null) goto L36;
            String r18 = r17.n;
            if (r18 == null) goto L36;
        L37:
            if (r17 == null) goto L40;
            Map<Integer, Long> r19 = r17.B;
            if (r19 == null) goto L40;
        L41:
            JSONObject r110 = new JSONObject();
            c0.r(r110, "asset_id", Long.valueOf(r3));
            if (r7 != null) goto L44;
            r7 = BuildConfig.FLAVOR;
        L44:
            c0.r(r110, "url", r7);
            c0.r(r110, "error_code", Integer.valueOf(r24));
            if (r26 != null) goto L47;
            String r20 = BuildConfig.FLAVOR;
        L48:
            c0.r(r110, "error_msg", r20);
            c0.r(r110, "asset_show_extra", Integer.valueOf(r25));
            if (r23 == null) goto L52;
            r9 = r23;
        L52:
            c0.r(r110, "gift_player_type", r9);
            if (TextUtils.equals("TTGiftPlayerImpl", r23) == false) goto L55;
        L56:
            c0.r(r110, "gift_ttplayer_hardcore", Integer.valueOf(com.bytedance.android.livesdk.gift.platform.business.effect.a.h()));
        L57:
            c0.r(r110, "log_id", r18);
            boolean r1 = d0.a;
            if (r19 != null) goto L60;
            r19 = MapsKt.emptyMap();
        L60:
            d0.g(r19);
            if (r21 == false) goto L67;
            String r111 = z.a("ttlive_gift_asset_show_status");
            JSONObject r112 = new JSONObject();
            JSONObject r27 = new JSONObject();
            JSONObject r28 = new JSONObject();
            Intrinsics.checkNotNullParameter(r28, "extra");
            Intrinsics.checkNotNullParameter(r27, "metric");
            EventModule r29 = EventModule.LIVE_GIFT;
            Intrinsics.checkNotNullParameter(r29, "eventModule");
            String r113 = r29.getValue();
            r27.put("status", String.valueOf(0));
            Intrinsics.checkNotNullParameter(r28, "map");
            Iterator<String> r30 = r110.keys();
        L64:
            if (r30.hasNext() == false) goto L66;
            String r31 = r30.next();
            Object r33 = r110.get(r31);
            Intrinsics.checkNotNullParameter(r31, "key");
            Intrinsics.checkNotNullParameter(r33, "value");
            r28.put(r31, r33);
            goto L64
        L66:
            cy0.e.a.getClass();
            j r34 = cy0.e.a.a;
            m.e.getClass();
            Object r35 = m.b(r34).b(n97.a.class);
            Intrinsics.checkNotNull(r35);
            ((com.bytedance.live.kmp.core.c) r35).g(r111, r113, "bussiness_api_call", r112, r27, r28);
            return;
        L67:
            r16.o("ttlive_gift_asset_show_status", r110);
            return;
        L55:
            if (TextUtils.equals("TTEnginePlayerImpl", r23) == false) goto L57;
        L47:
            r20 = r26;
        L40:
            r19 = MapsKt.emptyMap();
        L36:
            r18 = BuildConfig.FLAVOR;
            goto L37
        L25:
            r13 = r26;
            goto L26
        L21:
            r11 = r23;
            goto L22
        L17:
            r10 = r7;
        L13:
            r7 = null;
            goto L14
        L5:
            r3 = -1;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MultiPlayerWidget a;

        public d(MultiPlayerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            MultiPlayerWidget r0 = this.a;
            if (r0.h == false) goto L12;
            if (r4 == false) goto L13;
            com.bytedance.android.livesdk.gift.multiplayer.c r5 = r0.l;
            if (r5 == null) goto L10;
            MultiPlayerController r6 = r5.a;
            if (r6 == null) goto L10;
            r6.stop();
        L10:
            r0.h = false;
            return;
        L13:
            return;
        }
    }

    public static final class e implements IPlayerActionListener {
        public final /* synthetic */ MultiPlayerWidget a;

        public final void onFileLoaded(int r1, int r2) {
        }

        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.-CC.$default$onFirstFrame(this);
        }

        public final /* synthetic */ void onReportPlayMetrics(Map r1) {
            IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
        }

        public final void onEnd() {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L5;
            r0.put("cmd_video_gift_start", Boolean.FALSE);
        L5:
            this.a.h = false;
            a(false, true);
            GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r1 == null) goto L10;
            n<com.bytedance.android.livesdk.gift.platform.core.d> r2 = r1.getCurrentGiftEffect();
            if (r2 == null) goto L10;
            r2.setValue(null);
        L10:
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStop("gift_mp4");
            MultiPlayerWidget.yq(this.a, true);
            MultiPlayerWidget r3 = this.a;
            FrameLayout r4 = r3.a;
            FrameLayout r5 = r3.b;
            if (r4 == null) goto L16;
            if (r5 == null) goto L16;
            com.bytedance.android.livesdk.gift.multiplayer.c r6 = r3.l;
            if (r6 == null) goto L16;
            r6.b(r4, r5);
        L16:
            ConstraintLayout r7 = this.a.c;
            if (r7 == null) goto L19;
            r7.setVisibility(8);
        L19:
            this.a.zq();
            MultiPlayerWidget r8 = this.a;
            TimeCostUtil.Tag.ShowVideoGift.name();
            this.a.getClass();
            EffectMessage r9 = this.a.i;
            if (r9 == null) goto L23;
            String r10 = r9.n;
            if (r10 == null) goto L23;
        L24:
            MultiPlayerWidget.xq(r8, r10);
            return;
        L23:
            r10 = BuildConfig.FLAVOR;
            goto L24
        }

        public final void onStart() {
            MultiPlayerWidget r0 = this.a;
            if (r0.a != null) goto L5;
        L38:
            com.bytedance.android.livesdk.gift.platform.core.utils.c.b("MultiPlayerWidget", "PlayerAction onStart err: foregroundVideoView " + this.a.a + " backgroundVideoView : " + this.a.b + " dataCenter : " + ((Widget) this.a).dataCenter);
            return;
        L5:
            if (r0.b == null) goto L38;
            DataCenter r1 = ((Widget) r0).dataCenter;
            if (r1 == null) goto L38;
            r1.put("cmd_video_gift_start", Boolean.TRUE);
            HashMap r2 = new HashMap();
            EffectMessage r3 = this.a.i;
            if (r3 == null) goto L20;
            r2.put("id", String.valueOf(r3.l));
            h2 r4 = GiftManagerKt.l(r3.l);
            if (r4 == null) goto L14;
            int r5 = r4.getDiamondCount();
        L15:
            r2.put("price", String.valueOf(r5));
            GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r6 == null) goto L20;
            n<com.bytedance.android.livesdk.gift.platform.core.d> r7 = r6.getCurrentGiftEffect();
            if (r7 == null) goto L20;
            r7.setValue(new com.bytedance.android.livesdk.gift.platform.core.d("gift_mp4", r4));
            goto L20
        L14:
            r5 = 0;
        L20:
            MultiPlayerWidget r8 = this.a;
            if (r8.n == null) goto L23;
            n02.a.a(r8.i);
        L23:
            MultiPlayerWidget r9 = this.a;
            r9.getClass();
            if (com.bytedance.android.livesdk.gift.platform.core.h.j().d() == false) goto L28;
            ConstraintLayout r10 = r9.c;
            if (r10 == null) goto L36;
            r10.setVisibility(0);
        L36:
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStart("gift_mp4", r2);
            a(true, false);
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).monitorPerformance("show_video_gift");
            com.bytedance.android.live.core.performance.a r11 = com.bytedance.android.live.core.performance.a.a;
            TimeCostUtil.Tag.ShowVideoGift.name();
            this.a.getClass();
            this.a.getLifecycle();
            this.a.getContext();
            r11.getClass();
            return;
        L28:
            GiftSwitchImageView r13 = r9.d;
            if (r13 != null) goto L31;
        L35:
            r9.m = Observable.timer(300, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.multiplayer.e(r9), com.bytedance.android.livesdk.gift.multiplayer.f.a);
            goto L36
        L31:
            if (r13.k == true) goto L35;
            Disposable r14 = r9.m;
            if (r14 == null) goto L35;
            r14.dispose();
            goto L35
        }

        public final void onStop() {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L5;
            r0.put("cmd_video_gift_start", Boolean.FALSE);
        L5:
            this.a.h = false;
            a(false, true);
            GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r1 == null) goto L10;
            n<com.bytedance.android.livesdk.gift.platform.core.d> r2 = r1.getCurrentGiftEffect();
            if (r2 == null) goto L10;
            r2.setValue(null);
        L10:
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStop("gift_mp4");
            com.bytedance.android.live.core.performance.a r3 = com.bytedance.android.live.core.performance.a.a;
            TimeCostUtil.Tag.ShowVideoGift.name();
            this.a.Aq();
            r3.getClass();
        }

        public e(MultiPlayerWidget r1) {
            this.a = r1;
        }

        public final void a(boolean r3, boolean r4) {
            EffectMessage r0 = this.a.i;
            if (r0 == null) goto L7;
            IBaseUser r1 = r0.i;
            if (r1 == null) goto L7;
            String r2 = r1.getIdString();
        L9:
            if (Intrinsics.areEqual(r2, com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString()) == false) goto L12;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.message.e.class).Eb(r3, r4, this.a.i);
            return;
        L12:
            return;
        L7:
            r2 = null;
            goto L9
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void updateTextEffectPosition(float r23, float r24, float r25, float r26) {
            MultiPlayerWidget r1 = this.a;
            EffectMessage r2 = r1.i;
            if (r2 == null) goto L5;
            String r3 = r2.d;
        L6:
            i02.g.b r4 = m02.c.a(r3);
            if (r4 == null) goto L143;
            i02.g.a r5 = r4.icons;
            if (r5 == null) goto L144;
            int r6 = 0;
            long r9 = 0;
            if (com.bytedance.android.livesdk.gift.platform.core.h.j().d() == false) goto L77;
            EffectMessage r7 = r1.i;
            if (r7 == null) goto L17;
            r9 = r7.l;
        L17:
            long r18 = r9;
            boolean r8 = true;
            if (r5.closeUrl.length() <= 0) goto L20;
            boolean r10 = true;
        L21:
            if (r10 == true) goto L23;
            return;
        L23:
            if (r5.openUrl.length() > 0) goto L26;
            r8 = false;
        L26:
            if (r8 == false) goto L137;
            int r11 = r5.width;
            if (r11 == 0) goto L30;
            float r13 = (r11 / 10000.0f) * r23;
        L31:
            int r14 = r5.height;
            if (r14 == 0) goto L34;
            float r15 = (r14 / 10000.0f) * r24;
        L36:
            if (r5.x == 0) goto L38;
        L61:
            ConstraintLayout r16 = r1.c;
            float r17 = 0.0f;
            if (r16 == null) goto L68;
            FrameLayout r19 = r1.a;
            if (r19 == null) goto L66;
            float r20 = r19.getX();
        L67:
            r16.setX((r20 - ((Widget) r1).containerView.getX()) + ((r5.x / 10000.0f) * r23));
            goto L68
        L66:
            r20 = 0.0f;
        L68:
            ConstraintLayout r21 = r1.c;
            if (r21 == null) goto L74;
            FrameLayout r27 = r1.a;
            if (r27 == null) goto L73;
            r17 = r27.getY();
        L73:
            r21.setY((r17 - ((Widget) r1).containerView.getY()) + ((r5.y / 10000.0f) * r24));
        L74:
            NewGiftSwitchImageView r110 = r1.c;
            if (r110 == null) goto L138;
            r110.S5(r5.openUrl, r5.closeUrl, (int) r13, (int) r15, r18, false);
            return;
        L138:
            return;
        L38:
            if (r5.y != 0) goto L61;
            if (PadConfigUtils.c() == true) goto L48;
            ConstraintLayout r28 = r1.c;
            if (r28 == null) goto L55;
            FrameLayout r29 = r1.a;
            if (r29 == null) goto L46;
            int r30 = r29.getWidth();
        L47:
            r28.setX((r30 - s1.f(12.0f)) - r13);
            goto L55
        L46:
            r30 = 0;
        L55:
            ConstraintLayout r31 = r1.c;
            if (r31 == null) goto L74;
            FrameLayout r33 = r1.a;
            if (r33 == null) goto L60;
            r6 = r33.getHeight();
        L60:
            r31.setY((r6 - s1.f(136.0f)) - r15);
            goto L74
        L48:
            ConstraintLayout r34 = r1.c;
            if (r34 == null) goto L55;
            FrameLayout r35 = r1.a;
            if (r35 == null) goto L53;
            int r36 = r35.getWidth();
        L54:
            r34.setX((r36 - s1.f(20.0f)) - r13);
            goto L55
        L53:
            r36 = 0;
            goto L54
        L34:
            r15 = s1.j(2131168708);
            goto L36
        L30:
            r13 = s1.j(2131168708);
            goto L31
        L137:
            return;
        L20:
            r10 = false;
            goto L21
        L77:
            FrameLayout r37 = r1.a;
            if (r37 == null) goto L80;
            int r38 = r37.getWidth();
        L81:
            FrameLayout r111 = r1.a;
            if (r111 == null) goto L84;
            r6 = r111.getHeight();
        L84:
            int r112 = m02.c.b(r3);
            if (TextUtils.isEmpty(r5.closeUrl) == true) goto L129;
            if (r112 == 0) goto L129;
            if (r5.x == 0) goto L90;
        L112:
            int r39 = n0.a;
            if (n0.a.a(r112) == true) goto L117;
            ConstraintLayout r40 = r1.d;
            if (r40 == null) goto L120;
            r40.setX(((((r5.x / 10000.0f) * r23) + r25) - s1.j(2131168709)) + s1.j(2131168708));
        L120:
            ConstraintLayout r41 = r1.d;
            if (r41 == null) goto L123;
            r41.setY(((r5.y / 10000.0f) * r24) + r26);
        L123:
            GiftSwitchImageView r113 = r1.d;
            if (r113 == null) goto L140;
            String r114 = r5.openUrl;
            String r115 = r5.closeUrl;
            EffectMessage r43 = r1.i;
            if (r43 == null) goto L128;
            r9 = r43.l;
        L128:
            r113.Y5(r114, r115, r112, r9);
            return;
        L140:
            return;
        L117:
            ConstraintLayout r44 = r1.d;
            if (r44 == null) goto L120;
            r44.setX(((r5.x / 10000.0f) * r23) + r25);
            goto L120
        L90:
            if (r5.y != 0) goto L112;
            if (PadConfigUtils.c() == true) goto L101;
            int r45 = n0.a;
            if (n0.a.a(r112) == true) goto L98;
            ConstraintLayout r46 = r1.d;
            if (r46 == null) goto L109;
            r46.setX((r38 - s1.f(12.0f)) - s1.j(2131168709));
        L109:
            ConstraintLayout r47 = r1.d;
            if (r47 == null) goto L123;
            r47.setY((r6 - s1.f(136.0f)) - s1.j(2131168708));
            goto L123
        L98:
            ConstraintLayout r48 = r1.d;
            if (r48 == null) goto L109;
            r48.setX((r38 - s1.f(12.0f)) - s1.j(2131168708));
            goto L109
        L101:
            int r49 = n0.a;
            if (n0.a.a(r112) == true) goto L106;
            ConstraintLayout r50 = r1.d;
            if (r50 == null) goto L109;
            r50.setX((r38 - s1.f(20.0f)) - s1.j(2131168709));
            goto L109
        L106:
            ConstraintLayout r51 = r1.d;
            if (r51 == null) goto L109;
            r51.setX((r38 - s1.f(20.0f)) - s1.j(2131168708));
        L129:
            GiftSwitchImageView r53 = r1.d;
            if (r53 == null) goto L142;
            EffectMessage r54 = r1.i;
            if (r54 == null) goto L134;
            r9 = r54.l;
        L134:
            r53.Y5(BuildConfig.FLAVOR, BuildConfig.FLAVOR, 0, r9);
            return;
        L142:
            return;
        L80:
            r38 = 0;
            goto L81
        L144:
            return;
        L143:
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class f implements IPlayerProgressListener {
        public final /* synthetic */ MultiPlayerWidget a;

        public f(MultiPlayerWidget r1) {
            this.a = r1;
        }

        public final void onProgress(long r6) {
            com.bytedance.android.livesdk.gift.multiplayer.c r0 = this.a.l;
            if (r0 == null) goto L9;
            MultiPlayerController r1 = r0.a;
            if (r1 == null) goto L7;
            int r2 = r1.getDuration();
        L8:
            Integer r3 = Integer.valueOf(r2);
        L10:
            if (r3 != null) goto L12;
            return;
        L12:
            if (r3.intValue() != 0) goto L14;
            return;
        L14:
            if (r6 >= ((r3.intValue() / 2) - 25)) goto L16;
            return;
        L16:
            if (r6 > ((r3.intValue() / 2) + 25)) goto L22;
            MultiPlayerWidget.yq(this.a, false);
            return;
        L22:
            return;
        L7:
            r2 = 0;
            goto L8
        L9:
            r3 = null;
            goto L10
        }
    }

    public final class g implements Consumer {
        public final /* synthetic */ Function1 a;

        public g(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ MultiPlayerWidget a;
        public final /* synthetic */ EffectMessage b;

        public h(MultiPlayerWidget r1, EffectMessage r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            MultiPlayerWidget r4 = this.a;
            r4.h = false;
            r4.zq();
            MultiPlayerWidget r5 = this.a;
            TimeCostUtil.Tag.ShowVideoGift.name();
            MultiPlayerWidget.xq(r5, this.b.n);
        }
    }

    public static final class i<T> implements SingleOnSubscribe {
        public final /* synthetic */ MultiPlayerWidget a;
        public final /* synthetic */ EffectMessage b;

        public i(MultiPlayerWidget r1, EffectMessage r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(SingleEmitter<Object> r21) {
            Intrinsics.checkNotNullParameter(r21, "it");
            MultiPlayerWidget r0 = this.a;
            FrameLayout r2 = r0.a;
            FrameLayout r3 = r0.b;
            if (r2 == null) goto L81;
            if (r3 == null) goto L82;
            com.bytedance.android.livesdk.gift.multiplayer.c r4 = r0.l;
            if (r4 == null) goto L11;
            Context r1 = ((Widget) r0).context;
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "foregroundContainer");
            Intrinsics.checkNotNullParameter(r3, "backgroundContainer");
            if (r4.a != null) goto L11;
            Configuration r5 = new Configuration();
            r5.a = r1;
            r5.b = r4.k;
            MultiPlayerController r7 = new MultiPlayerController(r5, com.bytedance.android.livesdk.gift.multiplayer.c.a(r1), com.bytedance.android.livesdk.gift.multiplayer.c.a(r1));
            r4.a = r7;
            com.bytedance.android.livesdk.gift.multiplayer.c.d r6 = r4.f;
            PlayerController r8 = r7.a;
            r8.h = r6;
            com.bytedance.android.livesdk.gift.multiplayer.c.b r9 = r4.g;
            PlayerController r10 = r7.b;
            r10.h = r9;
            r8.g = r4.h;
            r10.g = r4.i;
            r7.attachAlphaView(r2);
            r7.i(r3);
            r7.b(r4.j, 1);
        L11:
            com.bytedance.android.livesdk.gift.multiplayer.c r11 = this.a.l;
            if (r11 == null) goto L83;
            EffectMessage r13 = this.b;
            String r14 = r13.d;
            if (r14 != null) goto L16;
            r14 = BuildConfig.FLAVOR;
        L16:
            long r15 = r13.a;
            Intrinsics.checkNotNullParameter(r14, "filePath");
            Intrinsics.checkNotNullParameter("foreground_default", "foregroundKey");
            Intrinsics.checkNotNullParameter("background_default", "backgroundKey");
            if (r11.a == null) goto L84;
            jy0.b.a("LiveMultiPlayerController", "start() called with: multiPlayerController = [" + r11.a + ']');
            String r16 = m02.b.a(r14);
            String r17 = m02.b.b(r16);
            if (r17 == null) goto L75;
            boolean r18 = true;
            if (r17.length() != 0) goto L23;
            boolean r19 = true;
        L24:
            if (r19 == true) goto L75;
            i02.g r20 = (i02.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r17, i02.g.class);     // Catch: JsonSyntaxException -> L28
        L30:
            if (r20 != null) goto L34;
            IResultMonitor r110 = r11.e;
            if (r110 == null) goto L85;
            r110.monitor(false, BuildConfig.FLAVOR, 0, 0, "Gson convert failed: " + new Regex("\\s").replace(r17, BuildConfig.FLAVOR));
            return;
        L85:
            return;
        L34:
            DataSource r23 = new DataSource();
            DataSource r24 = new DataSource();
            r23.f = r15;
            r24.f = r15;
            i02.g.b r25 = r20.portrait;
            if (r25 == null) goto L43;
            HashMap<String, i02.g.b> r26 = r25.foregroundItemMap;
            if (r26 == null) goto L43;
            i02.g.b r27 = r26.get("foreground_default");
            if (r27 == null) goto L43;
            DataSource.DataInfo r28 = new DataSource.DataInfo(r14 + File.separator + r27.path);
            r28.d(r27.align);
            r28.j = r27.version;
            r28.c = r27.totalFrame;
            r28.f = r27.videoWidth;
            r28.g = r27.videoHeight;
            r28.h = r27.actualWidth;
            r28.i = r27.actualHeight;
            r28.b(r27.alphaFrame);
            r28.c(r27.rgbFrame);
            r28.k = r27.masks;
            r23.c(r28);
            if (PadConfigUtils.c() == false) goto L43;
            r23.b(r28);
        L43:
            i02.g.b r29 = r20.portrait;
            if (r29 == null) goto L52;
            HashMap<String, i02.g.b> r30 = r29.backgroundItemMap;
            if (r30 == null) goto L52;
            i02.g.b r31 = r30.get("background_default");
            if (r31 == null) goto L52;
            DataSource.DataInfo r33 = new DataSource.DataInfo(r14 + File.separator + r31.path);
            r33.d(r31.align);
            r33.j = r31.version;
            r33.c = r31.totalFrame;
            r33.f = r31.videoWidth;
            r33.g = r31.videoHeight;
            r33.h = r31.actualWidth;
            r33.i = r31.actualHeight;
            r33.b(r31.alphaFrame);
            r33.c(r31.rgbFrame);
            r33.k = r31.masks;
            r24.c(r33);
            if (PadConfigUtils.c() == false) goto L52;
            r24.b(r33);
        L52:
            i02.g.b r34 = r20.landscape;
            if (r34 == null) goto L59;
            HashMap<String, i02.g.b> r35 = r34.foregroundItemMap;
            if (r35 == null) goto L59;
            i02.g.b r36 = r35.get("foreground_default");
            if (r36 == null) goto L59;
            DataSource.DataInfo r37 = new DataSource.DataInfo(r14 + File.separator + r36.path);
            r37.d(r36.align);
            r37.j = r36.version;
            r37.c = r36.totalFrame;
            r37.f = r36.videoWidth;
            r37.g = r36.videoHeight;
            r37.h = r36.actualWidth;
            r37.i = r36.actualHeight;
            r37.b(r36.alphaFrame);
            r37.c(r36.rgbFrame);
            r37.k = r36.masks;
            r23.b(r37);
        L59:
            i02.g.b r38 = r20.landscape;
            if (r38 == null) goto L67;
            HashMap<String, i02.g.b> r39 = r38.backgroundItemMap;
            if (r39 == null) goto L67;
            i02.g.b r40 = r39.get("background_default");
            if (r40 == null) goto L67;
            DataSource.DataInfo r41 = new DataSource.DataInfo(r14 + File.separator + r40.path);
            r41.d(r40.align);
            r41.j = r40.version;
            r41.c = r40.totalFrame;
            r41.f = r40.videoWidth;
            r41.g = r40.videoHeight;
            r41.h = r40.actualWidth;
            r41.i = r40.actualHeight;
            r41.b(r40.alphaFrame);
            r41.c(r40.rgbFrame);
            r41.k = r40.masks;
            r24.b(r41);
        L67:
            if (r23.a == false) goto L69;
        L71:
            r18 = false;
        L72:
            r11.b = r18;
            MultiPlayerController r43 = r11.a;
            if (r43 == null) goto L87;
            r43.d(r23);
            r43.b.f(r24, false);
            return;
        L87:
            return;
        L69:
            if (r24.a == false) goto L71;
        L28:
            e = move-exception;
            jy0.b.c("LiveMultiPlayerController", null, e, 2);
            r20 = null;
            goto L30
        L23:
            r19 = false;
        L75:
            boolean r44 = new PolarisFileWrapper(r16).exists();
            IResultMonitor r45 = r11.e;
            if (r45 == null) goto L89;
            r45.monitor(false, BuildConfig.FLAVOR, 0, 0, "configJson is null; exist: " + r44);
            return;
        L89:
            return;
        L84:
            return;
        L83:
            return;
        L82:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.multiplayer.MultiPlayerWidget$onLoad$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "p1", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(MultiPlayerWidget r8) {
            super(1, r8, MultiPlayerWidget.class, "toggleVideoGift", "toggleVideoGift(Z)V", 0);
        }

        public final void invoke(boolean r3) {
            MultiPlayerWidget r0 = (MultiPlayerWidget) ((CallableReference) this).receiver;
            int r1 = MultiPlayerWidget.r;
            ViewGroup r2 = ((Widget) r0).containerView;
            if (r2 == null) goto L9;
            if (r3 == false) goto L6;
            int r4 = 0;
        L7:
            r2.setVisibility(r4);
            return;
        L6:
            r4 = 8;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String Aq() {
        return CardLockInfo.sUNKNOWN;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b
    public final void ei() {
        this.h = false;
    }

    public final void onInit(Object[] r1) {
    }

    public final void zq() {
        this.h = false;
        VideoGiftMsgManagerV2 r0 = VideoGiftWidgetV2.S;
        VideoGiftWidgetV2.a.a().c();
    }

    public final void Fq() {
        boolean r2 = true;
        if (this.k.isEmpty() == false) goto L5;
    L47:
        StringBuilder r0 = new StringBuilder("[tryConsumeEffectMessage] not consume, effectMessageList:");
        r0.append(this.k.size());
        r0.append(" isPlayingSpecialGift:");
        r0.append(this.h);
        r0.append(" foregroundVideoView(null?):");
        if (this.a != null) goto L50;
        boolean r4 = true;
    L51:
        r0.append(r4);
        r0.append(" backgroundVideoView(null?):");
        if (this.b != null) goto L54;
        boolean r5 = true;
    L55:
        r0.append(r5);
        r0.append(" mRoom(null?):");
        if (this.e == null) goto L59;
        r2 = false;
    L59:
        r0.append(r2);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("MultiPlayerWidget", r0.toString());
        return;
    L54:
        r5 = false;
        goto L55
    L50:
        r4 = false;
        goto L51
    L5:
        if (this.h == true) goto L47;
        if (this.a == null) goto L47;
        if (this.b == null) goto L47;
        if (this.e == null) goto L47;
        EffectMessage r1 = (EffectMessage) ListProtector.remove(this.k, 0);
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.consume_effect_message, r1.a, r1.l, r1.b);
        this.i = r1;
        AssetsService r6 = this.g;
        if (r6 == null) goto L16;
        com.bytedance.android.live.core.resources.e r7 = r6.G1(r1.b);
    L18:
        if (r7 != null) goto L27;
        String r3 = String.valueOf(r1.l);
        String r8 = String.valueOf(r1.a);
        EffectMessage r9 = this.i;
        if (r9 == null) goto L23;
        String r10 = r9.n;
        if (r10 == null) goto L23;
    L24:
        Cq("特效列表找不到该Id", r3, r8, BuildConfig.FLAVOR, r10);
        zq();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("MultiPlayerWidget", "assets not found consume next one, effectId: " + r1.b);
        return;
    L23:
        r10 = BuildConfig.FLAVOR;
        goto L24
    L27:
        if (r7.getResourceType() == 9) goto L29;
        zq();
        return;
    L29:
        if (TextUtils.isEmpty(r1.d) == true) goto L41;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("MultiPlayerWidget", "ConsumeEffectMessage(), giftId = " + r1.l);
        this.h = true;
        if (this.f == true) goto L35;
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_LANDSCAPE_EFFECT, Boolean.FALSE)).booleanValue() == true) goto L35;
    L38:
        if (r2 == false) goto L40;
        ((ObservableSubscribeProxy) Observable.timer(1500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new h(this, r1));
        return;
    L40:
        Single.create(new i(this, r1)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L35:
        if (r1.o == true) goto L38;
        r2 = false;
        goto L38
    L41:
        Cq("临时下载该特效失败", String.valueOf(r1.l), String.valueOf(r1.a), BuildConfig.FLAVOR, r1.n);
        if ((System.currentTimeMillis() - this.j) <= 30000) goto L44;
        this.j = System.currentTimeMillis();
        ToastUtil.a(2131920068, 0);
    L44:
        zq();
        return;
    L16:
        r7 = null;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b
    public final boolean isIdle() {
        return !this.h;
    }

    public final void onUnload() {
        Disposable r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        FrameLayout r1 = this.a;
        FrameLayout r2 = this.b;
        if (r1 == null) goto L11;
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.gift.multiplayer.c r3 = this.l;
        if (r3 == null) goto L11;
        r3.b(r1, r2);
    L11:
        VideoGiftMsgManagerV2 r4 = VideoGiftWidgetV2.S;
        VideoGiftWidgetV2.a.a().d(this);
    }

    public MultiPlayerWidget() {
        this.k = new ArrayList();
        this.o = new e(this);
        this.p = new f(this);
        this.q = new b(this);
    }

    public final int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L5;
        return 2131567017;
    L5:
        return 2131567016;
    }

    public final boolean Bq(EffectMessage r6) {
        if (r6 != null) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("MultiPlayerWidget", "loadEffectResource: effectMessage is null");
        return false;
    L6:
        AssetsService r2 = this.g;
        if (r2 == null) goto L9;
        com.bytedance.android.live.core.resources.e r3 = r2.G1(r6.b);
    L10:
        AssetsService r4 = this.g;
        if (r4 != null) goto L13;
    L24:
        StringBuilder r7 = new StringBuilder("loadEffectResource: assets is not valid ; assets = ");
        if (r3 == null) goto L27;
        Object r5 = Long.valueOf(r3.getId());
    L28:
        r7.append(r5);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("MultiPlayerWidget", r7.toString());
        return false;
    L27:
        r5 = "null";
        goto L28
    L13:
        if (r4.O9(r3) != true) goto L24;
        if (r3 != null) goto L17;
    L23:
        return false;
    L17:
        if (r3.getResourceType() != 9) goto L23;
        AssetsService r0 = this.g;
        if (r0 == null) goto L22;
        r0.j4(r6.b, new com.bytedance.android.livesdk.gift.multiplayer.d(this, r6), 4);
    L22:
        return true;
    L9:
        r3 = null;
        goto L10
    }

    public final void Eq(boolean r4) {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L15;
        if (r4 == false) goto L6;
        int r5 = 0;
    L13:
        r0.setVisibility(r5);
        return;
    L6:
        FrameLayout r6 = this.a;
        FrameLayout r1 = this.b;
        if (r6 == null) goto L12;
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.gift.multiplayer.c r2 = this.l;
        if (r2 == null) goto L12;
        r2.b(r6, r1);
        Unit r7 = Unit.INSTANCE;
    L12:
        r5 = 8;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.y
    public final boolean Lc(NormalGiftMessage r14) {
        IBaseUser r0 = null;
        if (GiftEffectManager.b(r14, null) == false) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("MultiPlayerWidget", "onConsumeMessage: not consume, because of interceptGiftMsg " + r14);
        return false;
    L7:
        if ((r14 instanceof NormalGiftMessage) == false) goto L34;
        gm2.d r1 = r14.t;
        if ((r1 instanceof o7) == false) goto L20;
        o7 r2 = r14.r();
        if (r2 == null) goto L15;
        h1 r3 = r2.getGift();
        if (r3 == null) goto L15;
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.consume_message, r2.getMessageId(), r2.getGiftId(), r3.getPrimaryEffectId());
    L15:
        int r4 = com.bytedance.android.livesdk.gift.platform.core.utils.m.a;
        IRoom r5 = this.e;
        if (r5 == null) goto L19;
        r0 = r5.getOwner();
    L19:
        return Bq(com.bytedance.android.livesdk.gift.platform.core.utils.m.b(r14, r0));
    L20:
        long r6 = 0;
        if ((r1 instanceof k6) == false) goto L28;
        k6 r15 = r14.o();
        VideoGiftLinkMonitor.Event r7 = VideoGiftLinkMonitor.Event.consume_message;
        Long r8 = qj.a(r15);
        if (r8 == null) goto L25;
        r6 = r8.longValue();
    L25:
        VideoGiftLinkMonitor.a(r7, r6, -1, r15.getAssetId());
        return Bq(com.bytedance.android.livesdk.gift.platform.core.utils.m.d(r15));
    L28:
        if (r14.n() == null) goto L35;
        i6 r16 = r14.n();
        VideoGiftLinkMonitor.Event r9 = VideoGiftLinkMonitor.Event.consume_message;
        Long r10 = qj.a(r16);
        if (r10 == null) goto L32;
        r6 = r10.longValue();
    L32:
        VideoGiftLinkMonitor.a(r9, r6, -1, r16.getAssetId());
        return Bq(com.bytedance.android.livesdk.gift.platform.core.utils.m.c(r16));
    L35:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("MultiPlayerWidget", "onConsumeMessage: not consume, unhandled msg = " + r14);
        return false;
    L34:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("MultiPlayerWidget", "[onConsumeMessage] ERROR!: message ignored.. " + r14);
        goto L35
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b
    public final boolean lh(NormalGiftMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return Lc(r2);
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L42;
        String r0 = r6.getKey();
        boolean r2 = false;
        int r3 = 0;
        r2 = false;
        r2 = false;
        switch(r0.hashCode()) {
            case -1907464197: goto L39;
            case -1203988366: goto L29;
            case -79017966: goto L21;
            case 309908432: goto L8;
            default: goto L56;
        };
    L56:
        return;
    L8:
        if (r0.equals("data_media_introduction_showing") == false) goto L43;
        IRoom r1 = this.e;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.isMediaRoom() != true) goto L45;
        IRoom r4 = this.e;
        if (r4 == null) goto L46;
        IRoomAuthStatus r7 = r4.getRoomAuthStatus();
        if (r7 != null) goto L18;
        return;
    L18:
        if (r7.getEnableGift() != true) goto L48;
        Eq(Intrinsics.areEqual((Boolean) r6.getData(), Boolean.TRUE));
        return;
    L48:
        return;
    L46:
        return;
    L45:
        return;
    L43:
        return;
    L21:
        if (r0.equals("cmd_toggle_gift_video_view") == false) goto L50;
        boolean r8 = !Intrinsics.areEqual((Boolean) r6.getData(Boolean.TRUE), Boolean.FALSE);
        ViewGroup r9 = ((Widget) this).containerView;
        if (r9 == null) goto L51;
        if (r8 == true) goto L27;
        r3 = 8;
    L27:
        r9.setVisibility(r3);
        return;
    L51:
        return;
    L50:
        return;
    L29:
        if (r0.equals("data_room_gift_status") == false) goto L53;
        IRoom r10 = this.e;
        if (r10 == null) goto L37;
        IRoomAuthStatus r11 = r10.getRoomAuthStatus();
        if (r11 == null) goto L37;
        if (r11.getEnableGift() != true) goto L37;
        r2 = true;
    L37:
        Eq(r2);
        return;
    L53:
        return;
    L39:
        if (r0.equals("cmd_gift_effect_is_open") == false) goto L55;
        Eq(Intrinsics.areEqual((Boolean) r6.getData(), Boolean.TRUE));
        return;
    L55:
        return;
    }

    public final void onLoad(Object[] r3) {
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.a.class).J6() == false) goto L5;
        return;
    L5:
        this.a = (FrameLayout) findViewById(2131373166);
        this.b = (FrameLayout) findViewById(2131363820);
        this.d = (GiftSwitchImageView) findViewById(2131387878);
        this.c = (NewGiftSwitchImageView) findViewById(2131387884);
        this.g = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
        if ((((Widget) this).context instanceof LifecycleOwner) == false) goto L12;
        LifecycleOwner r0 = ((Widget) this).context;
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.gift.multiplayer.c r4 = new com.bytedance.android.livesdk.gift.multiplayer.c(r0);
        this.l = r4;
        r4.c = this.o;
        r4.d = this.p;
        r4.e = this.q;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L12:
        this.n = new n02.a();
        this.e = x.a();
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L15;
        r5.observe("data_room_gift_status", this);
        r5.observe("cmd_gift_effect_is_open", this);
        r5.observe("data_media_introduction_showing", this);
        r5.observe("cmd_toggle_gift_video_view", this);
    L15:
        this.f = ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        VideoGiftMsgManagerV2 r6 = VideoGiftWidgetV2.S;
        GiftMsgConsumeDispatcher r7 = VideoGiftWidgetV2.a.a();
        r7.getClass();
        Intrinsics.checkNotNullParameter(this, "consumer");
        r7.c.put(5, this);
        GiftContext r8 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r8 == null) goto L24;
        com.bytedance.live.datacontext.k<Boolean> r9 = r8.getToggleVideoGiftView();
        if (r9 == null) goto L24;
        PublishSubject r10 = r9.onEvent();
        if (r10 == null) goto L24;
        ObservableSubscribeProxy r11 = (ObservableSubscribeProxy) r10.as(AutoDispose.bind(this));
        if (r11 == null) goto L24;
        r11.subscribe(new g(new AnonymousClass2(this)), c.a);
    L24:
        GiftContext r13 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r13 == null) goto L34;
        com.bytedance.live.datacontext.k<Boolean> r14 = r13.getNeedStopEffect();
        if (r14 == null) goto L35;
        PublishSubject r15 = r14.onEvent();
        if (r15 == null) goto L36;
        ObservableSubscribeProxy r16 = (ObservableSubscribeProxy) r15.as(AutoDispose.bind(this));
        if (r16 == null) goto L37;
        r16.subscribe(new d(this));
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.b
    public final void pg(NormalGiftMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public static final void wq(MultiPlayerWidget r2, EffectMessage r3) {
        if (r2.isViewValid() == false) goto L11;
        if (r3 == null) goto L11;
        if (r3.g == false) goto L9;
        ListProtector.add(r2.k, 0, r3);
    L10:
        r2.Fq();
        return;
    L9:
        r2.k.add(r3);
    L11:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("MultiPlayerWidget", "addSpecialMessage failed: message" + r3);
    }

    public static final void xq(MultiPlayerWidget r2, String r3) {
        DataCenter r4 = ((Widget) r2).dataCenter;
        if (r4 == null) goto L12;
        Boolean r5 = (Boolean) r4.get("data_is_anchor", Boolean.FALSE);
        HashMap r0 = new HashMap();
        r0.put("isAnchor", String.valueOf(r5.booleanValue()));
        r0.put("log_id", r3);
        if (TextUtils.equals("TTGiftPlayerImpl", CardLockInfo.sUNKNOWN) == false) goto L8;
    L9:
        r0.put("ttplayer_hardcore_open", String.valueOf(com.bytedance.android.livesdk.gift.platform.business.effect.a.h()));
    L10:
        com.bytedance.android.live.core.performance.a.a.getClass();
        return;
    L8:
        if (TextUtils.equals("TTEnginePlayerImpl", CardLockInfo.sUNKNOWN) == false) goto L10;
    }

    public static final void yq(MultiPlayerWidget r23, boolean r24) {
        r23.getClass();
        boolean r2 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h();
        com.bytedance.android.livesdk.revenue.service.performance.c r1 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class);
        yz0.k r3 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r3 == null) goto L5;
        long r4 = r3.Hl();
    L6:
        long r5 = (System.currentTimeMillis() - r4) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        c0 r6 = c0.a;
        IRoom r7 = r23.e;
        long r8 = 0;
        if (r7 == null) goto L9;
        long r9 = r7.getRoomId();
    L10:
        EffectMessage r0 = r23.i;
        if (r0 == null) goto L13;
        long r18 = r0.l;
    L14:
        if (r0 == null) goto L16;
        r8 = r0.b;
    L16:
        float r10 = r1.getTemperature();
        double r11 = r1.getFps();
        double r13 = r1.getGpuUsed();
        double r14 = r1.getCpuRate();
        int r15 = r2 ? 1 : 0;
        c0.g(r9, r15, r18, r8, (int) r5, r10, r11, r13, r14, r24, -1, false);
        return;
    L13:
        r18 = 0;
        goto L14
    L9:
        r9 = 0;
        goto L10
    L5:
        r4 = System.currentTimeMillis();
        goto L6
    }

    public static void Cq(String r2, String r3, String r4, String r5, String r6) {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r2) == true) goto L6;
        r0.put("desc", r2);
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0.put("gift_id", r3);
    L9:
        if (TextUtils.isEmpty(r4) == true) goto L12;
        r0.put("msg_id", r4);
    L12:
        if (TextUtils.isEmpty(r5) == true) goto L15;
        r0.put("asset_id", r5);
    L15:
        if (TextUtils.isEmpty(r6) == true) goto L17;
        r0.put("log_id", r6);
    L17:
        jy0.b.c("ttlive_gift", r0.toString(), null, 4);
    }
}
