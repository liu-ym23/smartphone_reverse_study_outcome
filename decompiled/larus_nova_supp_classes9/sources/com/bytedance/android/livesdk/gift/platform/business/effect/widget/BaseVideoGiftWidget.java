package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.GiftRecyclableWidget;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.model.extension.main.IMainGiftRoom;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.model.s3;
import com.bytedance.android.livesdk.gift.model.t3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.NewGiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.n0;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.w;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.LynxVideoView;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.VideoGiftView;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.AssembleLynxPlayer;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.VideoGiftMsgManagerV2;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftEffectManager;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftMessageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g0;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.gift.platform.core.y;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.q8;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.interact.animation.RevTaskState;
import com.bytedance.android.livesdk.revenue.interact.animation.ScriptInfo;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayController;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerProgressListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.depend.live.gift.SuperResolutionModel;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.LynxAlphaPlayerAutoReleaseSwitch;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import i12.o;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.h2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseVideoGiftWidget;", "Lcom/bytedance/android/GiftRecyclableWidget;", "Lcom/bytedance/android/livesdk/gift/platform/core/y;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseVideoGiftWidget extends GiftRecyclableWidget implements y, Observer<KVData> {
    public static final /* synthetic */ int I = 0;
    public PointF A;
    public final b B;
    public final e C;
    public final d D;
    public final m E;
    public final g F;
    public final h G;
    public final f H;
    public String b;
    public final AssetsService c;
    public IRoom d;
    public VideoGiftView e;
    public FrameLayout f;
    public LynxVideoView g;
    public final Map<Integer, com.bytedance.android.livesdk.gift.platform.business.effect.player.a> h;
    public n02.a i;
    public boolean j;
    public String k;
    public boolean l;
    public final m02.i m;
    public FrameLayout n;
    public EffectMessage o;
    public long p;
    public boolean q;
    public final com.bytedance.android.livesdk.gift.platform.business.effect.player.f.a r;
    public SuperResolutionModel s;
    public com.bytedance.android.livesdk.gift.platform.business.effect.player.n t;
    public h2 u;
    public Disposable v;
    public int w;
    public boolean x;
    public com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a y;
    public final boolean z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public b(BaseVideoGiftWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L11;
            VideoGiftView r3 = this.a.e;
            if (r3 == null) goto L9;
            com.bytedance.android.livesdk.gift.platform.business.effect.player.f r4 = r3.h;
            if (r4 == null) goto L9;
            r4.a();
        L9:
            this.a.l = false;
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BaseVideoGiftWidget a;
        public final /* synthetic */ EffectMessage b;

        public c(BaseVideoGiftWidget r1, EffectMessage r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseVideoGiftWidget r0 = this.a;     // Catch: Throwable -> L4
            r0.l = false;     // Catch: Throwable -> L4
            r0.Fq();     // Catch: Throwable -> L4
            BaseVideoGiftWidget r1 = this.a;     // Catch: Throwable -> L4
            TimeCostUtil.Tag.ShowVideoGift.name();     // Catch: Throwable -> L4
            BaseVideoGiftWidget.yq(r1, this.b.n);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements IPlayerActionListener {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public final void onFileLoaded(int r1, int r2) {
        }

        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.-CC.$default$onFirstFrame(this);
        }

        public final /* synthetic */ void onReportPlayMetrics(Map r1) {
            IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
        }

        public final void updateTextEffectPosition(float r1, float r2, float r3, float r4) {
        }

        public final void onEnd() {
            DataCenter r1 = ((Widget) this.a).dataCenter;
            if (r1 == null) goto L5;
            r1.put("cmd_video_gift_start", Boolean.FALSE);
        L5:
            com.bytedance.android.live.profit.livepet.b r2 = yt0.c.e();
            if (r2 == null) goto L12;
            EffectMessage r4 = this.a.o;
            if (r4 == null) goto L10;
            Long r5 = Long.valueOf(r4.l);
        L11:
            r2.V1(false, r5);
            goto L12
        L10:
            r5 = null;
        L12:
            EffectMessage r3 = this.a.o;
            if (r3 == null) goto L59;
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.f(Long.valueOf(r3.a), "onPlayAction onEnd giftId:" + r3.l + " effectId:" + r3.b);
            String r6 = v12.f.a;
            v12.f.E("effect_play_end", r3.a, true);
            c0 r7 = c0.a;
            String r8 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
            Intrinsics.checkNotNullParameter(r3, "effectMessage");
            Intrinsics.checkNotNullParameter(r8, "currentUserId");
            if (Boolean.valueOf(r3.O).booleanValue() == false) goto L59;
            long r9 = com.bytedance.live.kmp.util.e.b();
            if (((HashMap) r3.B).get(1) == null) goto L24;
            Long r10 = (Long) ((HashMap) r3.B).get(1);
            if (r10 == null) goto L22;
            long r11 = r10.longValue();
        L23:
            long r13 = r11 - r9;
        L25:
            Long r14 = (Long) ((HashMap) r3.B).get(1);
            if (r14 == null) goto L28;
            long r15 = r14.longValue();
        L29:
            Long r16 = (Long) ((HashMap) r3.B).get(7);
            if (r16 == null) goto L32;
            long r17 = r16.longValue();
        L33:
            long r18 = r15 - r17;
            Long r19 = (Long) ((HashMap) r3.B).get(1);
            if (r19 == null) goto L36;
            long r110 = r19.longValue();
        L37:
            Long r20 = (Long) ((HashMap) r3.B).get(10);
            if (r20 == null) goto L40;
            long r111 = r20.longValue();
        L41:
            long r112 = r110 - r111;
            IBaseUser r21 = r3.h;
            if (r21 == null) goto L45;
            Object r23 = r21.getIdString();
            if (r23 == null) goto L45;
        L47:
            if (Intrinsics.areEqual(r8, r23) == false) goto L49;
            String r24 = "receiver";
        L58:
            JSONObject r113 = new JSONObject();
            JSONObject r25 = new JSONObject();
            JSONObject r26 = new JSONObject();
            Intrinsics.checkNotNullParameter(r26, "extra");
            Intrinsics.checkNotNullParameter(r25, "metric");
            EventModule r114 = EventModule.LIVE_GIFT;
            Intrinsics.checkNotNullParameter(r114, "eventModule");
            String r115 = r114.getValue();
            rz0.b r116 = new rz0.b(r26);
            r116.a("asset_id", Long.valueOf(r3.b));
            r116.a("required_asset", r3.M);
            r116.a("all_time", Long.valueOf(r13));
            r116.a("download_time", Long.valueOf(r18));
            r116.a("wait_time", Long.valueOf(r112));
            r116.a("scene", r3.N);
            r116.a("role", r24);
            cy0.e.a.getClass();
            cy0.j r27 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r28 = com.bytedance.android.scope.m.b(r27).b(n97.a.class);
            Intrinsics.checkNotNull(r28);
            ((com.bytedance.live.kmp.core.c) r28).g("ttlive_gift_asset_message_play", r115, "bussiness_api_call", r113, r25, r26);
            goto L59
        L49:
            IBaseUser r29 = r3.i;
            if (r29 == null) goto L53;
            Object r30 = r29.getIdString();
            if (r30 == null) goto L53;
        L55:
            if (Intrinsics.areEqual(r8, r30) == false) goto L57;
            r24 = "sender";
            goto L58
        L57:
            r24 = "others";
        L53:
            r30 = 0L;
        L45:
            r23 = 0L;
            goto L47
        L40:
            r111 = 0;
            goto L41
        L36:
            r110 = 0;
            goto L37
        L32:
            r17 = 0;
            goto L33
        L28:
            r15 = 0;
            goto L29
        L22:
            r11 = 0;
            goto L23
        L24:
            r13 = 0;
        L59:
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStop("gift_lynx");
            this.a.l = false;
            GiftContext r31 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r31 == null) goto L64;
            com.bytedance.live.datacontext.n<i02.a> r33 = r31.getCurrentSendTogetherInfo();
            if (r33 == null) goto L64;
            r33.setValue(new i02.a(0));
        L64:
            GiftContext r34 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r34 == null) goto L69;
            com.bytedance.live.datacontext.m<Integer> r35 = r34.getMsgCount();
            if (r35 == null) goto L69;
            r35.setValue(0);
        L69:
            GiftContext r36 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r36 == null) goto L74;
            com.bytedance.live.datacontext.m<Boolean> r37 = r36.isIntercept();
            if (r37 == null) goto L74;
            r37.setValue(Boolean.FALSE);
        L74:
            GiftContext r38 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r38 == null) goto L79;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.gift.platform.core.d> r39 = r38.getCurrentGiftEffect();
            if (r39 == null) goto L79;
            r39.setValue(null);
        L79:
            BaseVideoGiftWidget r40 = this.a;
            r40.br(r40.o);
            this.a.Fq();
            BaseVideoGiftWidget r41 = this.a;
            TimeCostUtil.Tag.ShowVideoGift.name();
            BaseVideoGiftWidget.xq(this.a);
            EffectMessage r43 = this.a.o;
            if (r43 == null) goto L82;
            Intrinsics.checkNotNull(r43);
            String r44 = r43.n;
        L83:
            BaseVideoGiftWidget.yq(r41, r44);
            BaseVideoGiftWidget.zq(this.a, true);
            return;
        L82:
            r44 = BuildConfig.FLAVOR;
            goto L83
        }

        public final void onStart() {
            BaseVideoGiftWidget r0 = this.a;
            if (((Widget) r0).dataCenter != null) goto L5;
            return;
        L5:
            r0.l = true;
            r0.Qq();
            ((Widget) this.a).dataCenter.put("cmd_video_gift_start", Boolean.TRUE);
            com.bytedance.android.live.profit.livepet.b r1 = yt0.c.e();
            if (r1 == null) goto L12;
            EffectMessage r2 = this.a.o;
            if (r2 == null) goto L10;
            Long r3 = Long.valueOf(r2.l);
        L11:
            r1.V1(true, r3);
            goto L12
        L10:
            r3 = null;
        L12:
            HashMap r4 = new HashMap();
            com.bytedance.android.livesdk.gift.model.h2 r5 = u.e(this.a.o);
            EffectMessage r6 = this.a.o;
            if (r6 == null) goto L19;
            Intrinsics.checkNotNull(r6);
            r4.put("id", String.valueOf(r6.l));
            if (r5 == null) goto L17;
            String r7 = String.valueOf(r5.getDiamondCount());
        L18:
            r4.put("price", r7);
            goto L19
        L17:
            r7 = String.valueOf(0);
        L19:
            EffectMessage r8 = this.a.o;
            if (r8 == null) goto L22;
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.d(Long.valueOf(r8.a), "onPlayAction start");
            String r9 = v12.f.a;
            v12.f.E("onPlayAction onStart", r8.a, false);
        L22:
            GiftContext r10 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r10 == null) goto L27;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.gift.platform.core.d> r11 = r10.getCurrentGiftEffect();
            if (r11 == null) goto L27;
            r11.setValue(new com.bytedance.android.livesdk.gift.platform.core.d("gift_lynx", r5));
        L27:
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStart("gift_lynx", r4);
            com.bytedance.android.live.core.performance.a r13 = com.bytedance.android.live.core.performance.a.a;
            TimeCostUtil.Tag.ShowVideoGift.name();
            BaseVideoGiftWidget.xq(this.a);
            this.a.getLifecycle();
            this.a.getContext();
            r13.getClass();
        }

        public final void onStop() {
            com.bytedance.android.live.profit.livepet.b r0 = yt0.c.e();
            if (r0 == null) goto L10;
            EffectMessage r1 = this.a.o;
            if (r1 == null) goto L7;
            Long r2 = Long.valueOf(r1.l);
        L8:
            r0.V1(false, r2);
            return;
        L7:
            r2 = null;
            goto L8
        }

        public d(BaseVideoGiftWidget r1) {
            this.a = r1;
        }
    }

    public static final class e implements IPlayerActionListener {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public final void onFileLoaded(int r1, int r2) {
        }

        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.-CC.$default$onFirstFrame(this);
        }

        public final /* synthetic */ void onReportPlayMetrics(Map r1) {
            IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
        }

        public final void onStop() {
        }

        public final void onEnd() {
            com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.a.b, "play end");
            Disposable r0 = this.a.v;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            BaseVideoGiftWidget r1 = this.a;
            r1.v = null;
            r1.u = null;
            com.bytedance.android.livesdk.gift.platform.business.effect.player.n r2 = r1.t;
            if (r2 == null) goto L8;
            r2.a();
        L8:
            LynxVideoView r3 = this.a.g;
            if (r3 == null) goto L13;
            ConstraintLayout r4 = r3.c;
            if (r4 == null) goto L13;
            r4.setVisibility(8);
        L13:
            com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).sendEventToAllJsBridges("H5_webcastNotification", MapsKt.mapOf(TuplesKt.to("eventName", "alpha_video_play_finished")));
        }

        public final void onStart() {
            com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a.b, "play end");
            BaseVideoGiftWidget r0 = this.a;
            h2 r1 = r0.u;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.c == false) goto L13;
            com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r0.b, "start vibrate");
            if (this.a.i == null) goto L13;
            Throwable r2 = new Throwable("vibration is not supported on saas (missing CapabilityScheduler)");
            Intrinsics.checkNotNullParameter(r2, "throwable");
            String r3 = r2.getMessage();
            if (r3 != null) goto L11;
            r3 = "failed to get error message";
        L11:
            com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.a.b, "lynx alpha video vibrate show, error is ".concat(r3));
        L13:
            if (r1.c == false) goto L15;
        L16:
            BaseVideoGiftWidget r4 = this.a;
            LynxVideoView r5 = r4.g;
            if (r5 == null) goto L40;
            com.bytedance.android.livesdk.gift.platform.business.effect.player.n r6 = r4.t;
            if (r6 == null) goto L23;
            ITextureViewPlayerController r7 = r6.b;
            if (r7 == null) goto L23;
            int r8 = r7.getDuration();
        L25:
            if (com.bytedance.android.livesdk.gift.platform.core.h.j().d() == false) goto L29;
            ConstraintLayout r9 = r5.c;
            if (r9 == null) goto L41;
            r9.setVisibility(0);
            return;
        L41:
            return;
        L29:
            GiftSwitchImageView r10 = r5.b;
            if (r10 != null) goto L32;
            return;
        L32:
            if (r10.k == true) goto L36;
            Disposable r11 = r5.e;
            if (r11 == null) goto L36;
            r11.dispose();
        L36:
            r5.e = Observable.timer(300, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.b(r5, r8));
            return;
        L23:
            r8 = 0;
            goto L25
        L40:
            return;
        L15:
            if (r1.b == true) goto L16;
        }

        public e(BaseVideoGiftWidget r1) {
            this.a = r1;
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
        public final void updateTextEffectPosition(float r24, float r25, float r26, float r27) {
            h2 r0 = this.a.u;
            String r2 = null;
            if (r0 == null) goto L5;
            JsonObject r1 = r0.f;
        L7:
            if (r1 != null) goto L9;
        L14:
            long r4 = 0;
        L15:
            BaseVideoGiftWidget r3 = this.a;
            h2 r6 = r3.u;
            if (r6 != null) goto L18;
        L23:
            FrameLayout r5 = r3.f;
        L24:
            BaseVideoGiftWidget r7 = this.a;
            LynxVideoView r14 = r7.g;
            if (r14 == null) goto L145;
            h2 r8 = r7.u;
            if (r8 == null) goto L29;
            r2 = r8.a;
        L29:
            i02.g.b r9 = m02.c.a(r2);
            if (r9 == null) goto L149;
            i02.g.a r10 = r9.icons;
            if (r10 != null) goto L36;
            return;
        L36:
            if (com.bytedance.android.livesdk.gift.platform.core.h.j().d() == false) goto L95;
            String r11 = r10.closeUrl;
            if (r11 != null) goto L40;
        L91:
            NewGiftSwitchImageView r15 = r14.c;
            if (r15 == null) goto L94;
            r15.S5(BuildConfig.FLAVOR, BuildConfig.FLAVOR, 0, 0, 0, false);
        L94:
            r14.d = false;
            return;
        L40:
            if (r11.length() <= 0) goto L42;
            boolean r13 = true;
        L43:
            if (r13 != true) goto L91;
            String r16 = r10.openUrl;
            if (r16 == null) goto L91;
            if (r16.length() <= 0) goto L49;
            boolean r17 = true;
        L50:
            if (r17 != true) goto L91;
            int r18 = r10.width;
            if (r18 == 0) goto L54;
            float r19 = (r18 / 10000.0f) * r24;
        L55:
            int r20 = r10.height;
            if (r20 == 0) goto L58;
            float r21 = (r20 / 10000.0f) * r25;
        L59:
            int r110 = r10.x;
            if (r110 == 0) goto L62;
        L74:
            ConstraintLayout r23 = r14.c;
            float r28 = 0.0f;
            if (r23 == null) goto L81;
            float r111 = (r110 / 10000.0f) * r24;
            if (r5 == null) goto L79;
            float r112 = r5.getX();
        L80:
            r23.setX((r111 + r112) - r14.getX());
            goto L81
        L79:
            r112 = 0.0f;
        L81:
            ConstraintLayout r29 = r14.c;
            if (r29 == null) goto L87;
            float r113 = (r10.y / 10000.0f) * r25;
            if (r5 == null) goto L86;
            r28 = r5.getY();
        L86:
            r29.setY((r113 + r28) - r14.getY());
        L87:
            NewGiftSwitchImageView r30 = r14.c;
            if (r30 == null) goto L90;
            r30.S5(r10.openUrl, r10.closeUrl, (int) r19, (int) r21, r4, !r14.d);
        L90:
            r14.d = true;
            return;
        L62:
            if (r10.y != 0) goto L74;
            if (PadConfigUtils.c() == true) goto L68;
            ConstraintLayout r31 = r14.c;
            if (r31 == null) goto L71;
            r31.setX((r14.getWidth() - s1.f(12.0f)) - r19);
        L71:
            ConstraintLayout r33 = r14.c;
            if (r33 == null) goto L87;
            r33.setY((r14.getHeight() - s1.f(136.0f)) - r21);
            goto L87
        L68:
            ConstraintLayout r34 = r14.c;
            if (r34 == null) goto L71;
            r34.setX((r14.getWidth() - s1.f(20.0f)) - r19);
            goto L71
        L58:
            r21 = s1.j(2131168708);
            goto L59
        L54:
            r19 = s1.j(2131168708);
            goto L55
        L49:
            r17 = false;
            goto L50
        L42:
            r13 = false;
            goto L43
        L95:
            int r35 = m02.c.b(r2);
            if (TextUtils.isEmpty(r10.closeUrl) == true) goto L138;
            if (r35 == 0) goto L138;
            if (r10.x == 0) goto L101;
        L123:
            int r36 = n0.a;
            if (n0.a.a(r35) == true) goto L128;
            ConstraintLayout r37 = r14.b;
            if (r37 == null) goto L131;
            r37.setX(((((r10.x / 10000.0f) * r24) + r26) - s1.j(2131168709)) + s1.j(2131168708));
        L131:
            ConstraintLayout r38 = r14.b;
            if (r38 == null) goto L134;
            r38.setY(((r10.y / 10000.0f) * r25) + r27);
        L134:
            GiftSwitchImageView r39 = r14.b;
            if (r39 == null) goto L137;
            r39.Y5(r10.openUrl, r10.closeUrl, r35, r4);
        L137:
            r14.d = true;
            return;
        L128:
            ConstraintLayout r40 = r14.b;
            if (r40 == null) goto L131;
            r40.setX(((r10.x / 10000.0f) * r24) + r26);
            goto L131
        L101:
            if (r10.y != 0) goto L123;
            if (PadConfigUtils.c() == true) goto L112;
            int r41 = n0.a;
            if (n0.a.a(r35) == true) goto L109;
            ConstraintLayout r43 = r14.b;
            if (r43 == null) goto L120;
            r43.setX((r14.getWidth() - s1.f(12.0f)) - s1.j(2131168709));
        L120:
            ConstraintLayout r44 = r14.b;
            if (r44 == null) goto L134;
            r44.setY((r14.getHeight() - s1.f(136.0f)) - s1.j(2131168708));
            goto L134
        L109:
            ConstraintLayout r45 = r14.b;
            if (r45 == null) goto L120;
            r45.setX((r14.getWidth() - s1.f(12.0f)) - s1.j(2131168708));
            goto L120
        L112:
            int r46 = n0.a;
            if (n0.a.a(r35) == true) goto L117;
            ConstraintLayout r47 = r14.b;
            if (r47 == null) goto L120;
            r47.setX((r14.getWidth() - s1.f(20.0f)) - s1.j(2131168709));
            goto L120
        L117:
            ConstraintLayout r48 = r14.b;
            if (r48 == null) goto L120;
            r48.setX((r14.getWidth() - s1.f(20.0f)) - s1.j(2131168708));
        L138:
            GiftSwitchImageView r49 = r14.b;
            if (r49 == null) goto L141;
            r49.Y5(BuildConfig.FLAVOR, BuildConfig.FLAVOR, 0, r4);
        L141:
            r14.d = false;
            return;
        L149:
            return;
        L145:
            return;
        L18:
            if (r6.e != true) goto L23;
            LynxVideoView r50 = r3.g;
            if (r50 == null) goto L22;
            r5 = r50.getVideoContainer();
            goto L24
        L22:
            r5 = null;
            goto L24
        L9:
            if (r1.has("giftId") != true) goto L14;
            r4 = r1.get("giftId").getAsLong();     // Catch: Exception -> L12
        L12:
            e = move-exception;
            jy0.b.c(this.a.b, "get giftId failed, error message is " + e.getMessage(), null, 4);
            goto L14
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class f implements IResultMonitor {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public f(BaseVideoGiftWidget r1) {
            this.a = r1;
        }

        public final void monitor(boolean r24, String r25, int r26, int r27, String r28) {
            h2 r0 = this.a.u;
            if (r0 == null) goto L57;
            boolean r2 = d0.a;
            boolean r3 = r0.b;
            boolean r4 = r0.c;
            String r5 = r0.a;
            JsonObject r1 = r0.f;
            Intrinsics.checkNotNullParameter(r5, "url");
            LinkedHashMap r6 = new LinkedHashMap();
            r6.put("enable_audio", Integer.valueOf(r3 ? 1 : 0));
            r6.put("enable_vibrate", Integer.valueOf(r4 ? 1 : 0));
            r6.put("url", r5);
            LinkedHashMap r7 = new LinkedHashMap();
            String r8 = BuildConfig.FLAVOR;
            if (r1 != null) goto L48;
            Set r9 = null;
        L10:
            if (r9 == null) goto L24;
            Iterator r10 = r9.iterator();     // Catch: JSONException -> L7
        L12:
            if (r10.hasNext() == false) goto L24;
            String r11 = (String) r10.next();     // Catch: JSONException -> L7
            JsonElement r13 = r1.get(r11);     // Catch: JSONException -> L7
            if (r13 != null) goto L17;
            r13 = BuildConfig.FLAVOR;
        L17:
            r7.put(r11, r13);     // Catch: JSONException -> L7
        L7:
            e = move-exception;
            String r14 = e.getMessage();
            if (r14 != null) goto L22;
            r14 = BuildConfig.FLAVOR;
        L22:
            r7.put("json_error_msg", r14);
        L24:
            if (r24 == true) goto L38;
            r6.put("error_code", Integer.valueOf(r26));
            if (r28 == null) goto L29;
            r8 = r28;
        L29:
            r7.put("error_msg", r8);
            String r15 = z.b("ttlive_alpha_video_player_show_status");
            JSONObject r16 = new JSONObject();
            JSONObject r17 = new JSONObject();
            JSONObject r18 = new JSONObject();
            Intrinsics.checkNotNullParameter(r18, "extra");
            Intrinsics.checkNotNullParameter(r17, "metric");
            EventModule r19 = EventModule.LIVE_GIFT;
            Intrinsics.checkNotNullParameter(r19, "eventModule");
            String r110 = r19.getValue();
            Intrinsics.checkNotNullParameter(r16, "map");
            Intrinsics.checkNotNullParameter(r6, "value");
            Iterator r111 = r6.entrySet().iterator();
        L31:
            if (r111.hasNext() == false) goto L33;
            Map.Entry r112 = (Map.Entry) r111.next();
            Iterator r29 = r111;
            r16.put((String) r112.getKey(), r112.getValue());
            r111 = r29;
            goto L31
        L33:
            Intrinsics.checkNotNullParameter(r18, "map");
            Intrinsics.checkNotNullParameter(r7, "value");
            Iterator r20 = r7.entrySet().iterator();
        L35:
            if (r20.hasNext() == false) goto L37;
            Map.Entry r113 = (Map.Entry) r20.next();
            Iterator r210 = r20;
            r18.put((String) r113.getKey(), r113.getValue());
            r20 = r210;
            goto L35
        L37:
            cy0.e.a.getClass();
            cy0.j r114 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r21 = com.bytedance.android.scope.m.b(r114).b(n97.a.class);
            Intrinsics.checkNotNull(r21);
            ((com.bytedance.live.kmp.core.c) r21).g(r15, r110, "bussiness_api_call", r16, r17, r18);
        L38:
            String r115 = z.a("ttlive_alpha_video_player_show_status");
            JSONObject r23 = new JSONObject();
            JSONObject r30 = new JSONObject();
            JSONObject r31 = new JSONObject();
            Intrinsics.checkNotNullParameter(r31, "extra");
            Intrinsics.checkNotNullParameter(r30, "metric");
            EventModule r33 = EventModule.LIVE_GIFT;
            Intrinsics.checkNotNullParameter(r33, "eventModule");
            String r116 = r33.getValue();
            Intrinsics.checkNotNullParameter(r23, "map");
            Intrinsics.checkNotNullParameter(r6, "value");
            Iterator r34 = r6.entrySet().iterator();
        L40:
            if (r34.hasNext() == false) goto L42;
            Map.Entry r35 = (Map.Entry) r34.next();
            r23.put((String) r35.getKey(), r35.getValue());
            goto L40
        L42:
            Intrinsics.checkNotNullParameter(r31, "map");
            Intrinsics.checkNotNullParameter(r7, "value");
            Iterator r36 = r7.entrySet().iterator();
        L44:
            if (r36.hasNext() == false) goto L46;
            Map.Entry r37 = (Map.Entry) r36.next();
            r31.put((String) r37.getKey(), r37.getValue());
            goto L44
        L46:
            cy0.e.a.getClass();
            cy0.j r38 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r39 = com.bytedance.android.scope.m.b(r38).b(n97.a.class);
            Intrinsics.checkNotNull(r39);
            ((com.bytedance.live.kmp.core.c) r39).g(r115, r116, "bussiness_api_call", r23, r30, r31);
            return;
        L48:
            r9 = r1.keySet();     // Catch: JSONException -> L7
            goto L10
        }
    }

    public static final class g implements IPlayerActionListener {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public final void onFileLoaded(int r1, int r2) {
        }

        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.-CC.$default$onFirstFrame(this);
        }

        public final /* synthetic */ void onReportPlayMetrics(Map r1) {
            IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
        }

        public final void onEnd() {
            VideoGiftView r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.d.setVisibility(8);
            r0.l = false;
        L5:
            DataCenter r1 = ((Widget) this.a).dataCenter;
            if (r1 == null) goto L8;
            r1.put("cmd_video_gift_start", Boolean.FALSE);
        L8:
            com.bytedance.android.live.profit.livepet.b r2 = yt0.c.e();
            if (r2 == null) goto L15;
            EffectMessage r3 = this.a.o;
            if (r3 == null) goto L13;
            Long r4 = Long.valueOf(r3.l);
        L14:
            r2.V1(false, r4);
            goto L15
        L13:
            r4 = null;
        L15:
            EffectMessage r5 = this.a.o;
            if (r5 == null) goto L18;
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.f(Long.valueOf(r5.a), "onPlayAction onEnd giftId:" + r5.l + " effectId:" + r5.b);
        L18:
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStop("gift_mp4");
            BaseVideoGiftWidget r6 = this.a;
            r6.l = false;
            r6.x = false;
            r6.A = new PointF(-1.0f, -1.0f);
            GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r7 == null) goto L23;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.gift.platform.core.d> r8 = r7.getCurrentGiftEffect();
            if (r8 == null) goto L23;
            r8.setValue(null);
        L23:
            a(false, true);
            BaseVideoGiftWidget r9 = this.a;
            r9.br(r9.o);
            this.a.Fq();
            BaseVideoGiftWidget r10 = this.a;
            TimeCostUtil.Tag.ShowVideoGift.name();
            BaseVideoGiftWidget.xq(this.a);
            EffectMessage r11 = this.a.o;
            if (r11 == null) goto L26;
            Intrinsics.checkNotNull(r11);
            String r13 = r11.n;
        L27:
            BaseVideoGiftWidget.yq(r10, r13);
            BaseVideoGiftWidget.zq(this.a, true);
            return;
        L26:
            r13 = BuildConfig.FLAVOR;
            goto L27
        }

        public final void onStart() {
            BaseVideoGiftWidget r0 = this.a;
            if (r0.e != null) goto L5;
        L56:
            com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r0.b, "PlayerAction onStart err: mVideoGiftView " + this.a.e + "  dataCenter : " + ((Widget) this.a).dataCenter);
            return;
        L5:
            if (((Widget) r0).dataCenter == null) goto L56;
            r0.Qq();
            ((Widget) this.a).dataCenter.put("cmd_video_gift_start", Boolean.TRUE);
            com.bytedance.android.live.profit.livepet.b r1 = yt0.c.e();
            if (r1 == null) goto L14;
            EffectMessage r3 = this.a.o;
            if (r3 == null) goto L12;
            Long r4 = Long.valueOf(r3.l);
        L13:
            r1.V1(true, r4);
            goto L14
        L12:
            r4 = null;
        L14:
            HashMap r2 = new HashMap();
            com.bytedance.android.livesdk.gift.model.h2 r5 = u.e(this.a.o);
            EffectMessage r6 = this.a.o;
            if (r6 == null) goto L21;
            Intrinsics.checkNotNull(r6);
            r2.put("id", String.valueOf(r6.l));
            if (r5 == null) goto L19;
            String r7 = String.valueOf(r5.getDiamondCount());
        L20:
            r2.put("price", r7);
            goto L21
        L19:
            r7 = String.valueOf(0);
        L21:
            EffectMessage r8 = this.a.o;
            if (r8 == null) goto L24;
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.d(Long.valueOf(r8.a), "onPlayAction start");
        L24:
            GiftContext r9 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r9 == null) goto L29;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.gift.platform.core.d> r10 = r9.getCurrentGiftEffect();
            if (r10 == null) goto L29;
            r10.setValue(new com.bytedance.android.livesdk.gift.platform.core.d("gift_mp4", r5));
        L29:
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStart("gift_mp4", r2);
            BaseVideoGiftWidget r11 = this.a;
            if (r11.i == null) goto L34;
            EffectMessage r13 = r11.o;
            if (r13 == null) goto L34;
            n02.a.a(r13);
        L34:
            VideoGiftView r14 = this.a.e;
            if (r14 == null) goto L37;
            r14.setVisibility(0);
        L37:
            final VideoGiftView r15 = this.a.e;
            if (r15 != null) goto L40;
        L51:
            VideoGiftView r16 = this.a.e;
            if (r16 == null) goto L54;
            r16.e();
        L54:
            a(true, false);
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).monitorPerformance("show_video_gift");
            com.bytedance.android.live.core.performance.a r17 = com.bytedance.android.live.core.performance.a.a;
            TimeCostUtil.Tag.ShowVideoGift.name();
            BaseVideoGiftWidget.xq(this.a);
            this.a.getLifecycle();
            this.a.getContext();
            r17.getClass();
            this.a.dr(null, null, null);
            return;
        L40:
            if (com.bytedance.android.livesdk.gift.platform.core.h.j().d() == false) goto L46;
            if (r15.l == false) goto L44;
            r15.d.setVisibility(0);
            goto L51
        L44:
            r15.d.setVisibility(8);
            goto L51
        L46:
            if (r15.c.k == true) goto L51;
            Disposable r18 = r15.k;
            if (r18 == null) goto L50;
            r18.dispose();
        L50:
            r15.k = Observable.timer(300, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.d(r15));
            goto L51
        }

        public final void onStop() {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L5;
            r0.put("cmd_video_gift_start", Boolean.FALSE);
        L5:
            com.bytedance.android.live.profit.livepet.b r1 = yt0.c.e();
            if (r1 == null) goto L12;
            EffectMessage r3 = this.a.o;
            if (r3 == null) goto L10;
            Long r4 = Long.valueOf(r3.l);
        L11:
            r1.V1(false, r4);
            goto L12
        L10:
            r4 = null;
        L12:
            EffectMessage r2 = this.a.o;
            if (r2 == null) goto L15;
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.f(Long.valueOf(r2.a), "onPlayAction onStop giftId:" + r2.l + " effectId:" + r2.b);
        L15:
            BaseVideoGiftWidget r5 = this.a;
            r5.l = false;
            r5.x = false;
            r5.A = new PointF(-1.0f, -1.0f);
            GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r6 == null) goto L20;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.gift.platform.core.d> r7 = r6.getCurrentGiftEffect();
            if (r7 == null) goto L20;
            r7.setValue(null);
        L20:
            a(false, true);
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStop("gift_mp4");
            com.bytedance.android.live.core.performance.a r8 = com.bytedance.android.live.core.performance.a.a;
            TimeCostUtil.Tag.ShowVideoGift.name();
            BaseVideoGiftWidget.xq(this.a);
            r8.getClass();
            this.a.getClass();
            VideoGiftView r9 = this.a.e;
            if (r9 == null) goto L24;
            r9.d.setVisibility(8);
            r9.l = false;
            return;
        }

        public g(BaseVideoGiftWidget r1) {
            this.a = r1;
        }

        public final void a(boolean r3, boolean r4) {
            EffectMessage r0 = this.a.o;
            if (r0 == null) goto L14;
            Intrinsics.checkNotNull(r0);
            if (r0.i == null) goto L15;
            EffectMessage r1 = this.a.o;
            Intrinsics.checkNotNull(r1);
            IBaseUser r2 = r1.i;
            if (r2 == null) goto L9;
            String r5 = r2.getIdString();
        L11:
            if (Intrinsics.areEqual(r5, com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString()) == false) goto L16;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.message.e.class).Eb(r3, r4, this.a.o);
            return;
        L16:
            return;
        L9:
            r5 = null;
            goto L11
        L15:
            return;
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
        public final void updateTextEffectPosition(float r31, float r33, float r34, float r35) {
            VideoGiftView r3 = this.a.e;
            if (r3 == null) goto L63;
            Intrinsics.checkNotNull(r3);
            int r4 = m02.c.a;
            i02.g.b r5 = m02.c.a(r3.g);
            if (r5 == null) goto L61;
            i02.g.a r6 = r5.icons;
            if (r6 == null) goto L61;
            int r10 = m02.c.b(r3.g);
            if (com.bytedance.android.livesdk.gift.platform.core.h.j().d() == false) goto L37;
            if (r10 == 0) goto L61;
            if (TextUtils.isEmpty(r6.closeUrl) == false) goto L15;
        L35:
            r3.d.S5(BuildConfig.FLAVOR, BuildConfig.FLAVOR, 0, 0, r3.n, false);
            r3.l = false;
            goto L61
        L15:
            if (TextUtils.isEmpty(r6.openUrl) == true) goto L35;
            float r7 = (r6.width / 10000.0f) * r31;
            if (r7 != 0.0f) goto L20;
            r7 = s1.j(2131168708);
        L20:
            float r8 = (r6.height / 10000.0f) * r33;
            if (r8 != 0.0f) goto L24;
            r8 = s1.j(2131168708);
        L24:
            int r9 = r6.x;
            if (r9 == 0) goto L27;
        L33:
            r3.d.setX((((r9 / 10000.0f) * r31) + r3.getVideoContainer().getX()) - r3.getX());
            r3.d.setY((((r6.y / 10000.0f) * r33) + r3.getVideoContainer().getY()) - r3.getY());
        L34:
            r3.d.S5(r6.openUrl, r6.closeUrl, (int) r7, (int) r8, r3.n, !r3.l);
            r3.l = true;
            goto L61
        L27:
            if (r6.y != 0) goto L33;
            if (PadConfigUtils.c() == true) goto L31;
            r3.d.setX((r3.getWidth() - s1.f(12.0f)) - r7);
        L32:
            r3.d.setY((r3.getHeight() - s1.f(136.0f)) - r8);
            goto L34
        L31:
            r3.d.setX((r3.getWidth() - s1.f(20.0f)) - r7);
            goto L32
        L37:
            if (TextUtils.isEmpty(r5.icons.closeUrl) == true) goto L60;
            if (r10 == 0) goto L60;
            if (r6.x == 0) goto L42;
        L54:
            int r11 = n0.a;
            if (n0.a.a(r10) == true) goto L57;
            r3.c.setX(((((r6.x / 10000.0f) * r31) + r34) - s1.j(2131168709)) + s1.j(2131168708));
        L58:
            r3.c.setY(((r6.y / 10000.0f) * r33) + r35);
        L59:
            r3.c.Y5(r6.openUrl, r6.closeUrl, r10, r3.n);
            r3.l = true;
            goto L61
        L57:
            r3.c.setX(((r6.x / 10000.0f) * r31) + r34);
            goto L58
        L42:
            if (r6.y != 0) goto L54;
            if (PadConfigUtils.c() == true) goto L49;
            int r13 = n0.a;
            if (n0.a.a(r10) == true) goto L48;
            r3.c.setX((r3.getWidth() - s1.f(12.0f)) - s1.j(2131168709));
        L53:
            r3.c.setY((r3.getHeight() - s1.f(136.0f)) - s1.j(2131168708));
            goto L59
        L48:
            r3.c.setX((r3.getWidth() - s1.f(12.0f)) - s1.j(2131168708));
            goto L53
        L49:
            int r14 = n0.a;
            if (n0.a.a(r10) == true) goto L52;
            r3.c.setX((r3.getWidth() - s1.f(20.0f)) - s1.j(2131168709));
            goto L53
        L52:
            r3.c.setX((r3.getWidth() - s1.f(20.0f)) - s1.j(2131168708));
        L60:
            r3.c.Y5(BuildConfig.FLAVOR, BuildConfig.FLAVOR, 0, r3.n);
            r3.l = false;
        L61:
            this.a.A = new PointF(r31, r33);
            return;
        }
    }

    public static final class h implements IResultMonitor {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public h(BaseVideoGiftWidget r1) {
            this.a = r1;
        }

        public final void monitor(boolean r27, String r28, int r29, int r30, String r31) {
            String r15 = r31;
            if (r27 == false) goto L5;
        L7:
            BaseVideoGiftWidget r1 = this.a;
            m02.i r2 = r1.m;
            EffectMessage r13 = r1.o;
            boolean r11 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h();
            com.bytedance.android.live.core.resources.e r3 = r2.a;
            if (r3 == null) goto L54;
            com.bytedance.android.live.core.resources.f r4 = r3.castToOrNull(com.bytedance.android.live.core.resources.f.class);
            if (r4 == null) goto L54;
            long r5 = r4.getId();
            SuperResolutionModel r6 = r2.b;
            if (r6 == null) goto L14;
            Integer r7 = Integer.valueOf(r6.getVideoAssetType());
        L16:
            if (r7 != null) goto L19;
        L25:
            if (r7 != null) goto L28;
        L36:
            if (r7 != null) goto L39;
        L47:
            com.bytedance.android.live.core.resources.l r8 = r4.getResourceModel();
            if (r8 == null) goto L52;
            List r9 = r8.getUrlList();
            if (r9 == null) goto L52;
            String r10 = (String) CollectionsKt.getOrNull(r9, 0);
        L53:
            long r14 = r5;
            String r16 = r10;
        L55:
            JSONObject r17 = new JSONObject();
            r17.put("gift_id", r14);
            r17.put("gift_resource", r16);
            r17.put("extra", r30);
            r17.put("code", r29);
            r17.put("error_info", r15);
            LiveSlardarMonitor.monitorStatusAndDuration("hotsoon_live_video_gift_play_success_rate", !r27 ? 1 : 0, new JSONObject(), r17);
            HashMap r18 = new HashMap();
            r18.put("event_name", "VIDEO_GIFT_PLAY_SUCCESS_RATE");
            r18.put("gift_id", Long.valueOf(r14));
            r18.put("gift_resource", r16);
            r18.put("extra", Integer.valueOf(r30));
            r18.put("code", Integer.valueOf(r29));
            r18.put("player_type", r28);
            r18.put("error_info", r15);
            LinkedHashMap r19 = new LinkedHashMap();
            SuperResolutionModel r0 = r2.b;
            if (r0 == null) goto L62;
            r19.put("video_asset_type", Integer.valueOf(r0.getVideoAssetType()));
            r19.put("enable_sr", Boolean.valueOf(r0.getOpenSR()));
            if (r0.getOpenSR() == false) goto L60;
            int r20 = r0.getResultCode();
            r19.put("error_domain", "super_resolution");
        L61:
            int r21 = r20;
        L63:
            r18.putAll(r19);
            if (r13 == null) goto L66;
            r18.put("log_id", r13.n);
        L66:
            jy0.b.d("ttlive_gift", r18.toString());
            IBaseUser r23 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b();
            if (r13 == null) goto L74;
            List<String> r24 = r13.A;
            if (r24 == null) goto L74;
            if ((!r24.isEmpty()) != true) goto L74;
            boolean r110 = r13.A.contains(r23.getIdString());
        L75:
            if (r13 == null) goto L79;
            IBaseUser r25 = r13.i;
            if (r25 == null) goto L79;
            String r26 = r25.getIdString();
        L80:
            boolean r111 = Intrinsics.areEqual(r23.getIdString(), r26);
            c0 r112 = c0.a;
            if (r13 == null) goto L83;
            String r210 = r13.n;
        L84:
            if (r13 == null) goto L87;
            Map<Integer, Long> r33 = r13.B;
            if (r33 == null) goto L87;
        L88:
            long r211 = r14;
            c0.b(r27, r14, r16, r21, r31, r30, r28, r210, r19, r33, r11, r110, r111);
            if (r13 != null) goto L91;
            return;
        L91:
            if (r13.L != 2) goto L101;
            if (r27 == true) goto L102;
            if (r15 != null) goto L95;
            r15 = BuildConfig.FLAVOR;
        L95:
            if (r28 != null) goto L97;
            String r34 = BuildConfig.FLAVOR;
        L98:
            Intrinsics.checkNotNullParameter("AssetEffectUtilMessage", "source");
            Intrinsics.checkNotNullParameter(r15, "errorMsg");
            Intrinsics.checkNotNullParameter(r34, "playerType");
            JSONObject r35 = new JSONObject();
            c0.r(r35, "asset_id", Long.valueOf(r211));
            c0.r(r35, "source", "AssetEffectUtilMessage");
            c0.r(r35, "error_code", Integer.valueOf(r29));
            c0.r(r35, "error_msg", r15);
            c0.r(r35, "player_type", r34);
            c0.n(r112, "ttlive_activity_effect_show_error", r35, 1);
            return;
        L97:
            r34 = r28;
            goto L98
        L102:
            return;
        L101:
            return;
        L87:
            r33 = MapsKt.emptyMap();
            goto L88
        L83:
            r210 = BuildConfig.FLAVOR;
        L79:
            r26 = null;
        L74:
            r110 = r11;
            goto L75
        L60:
            r20 = r29;
            goto L61
        L62:
            r21 = r29;
        L52:
            r10 = null;
            goto L53
        L39:
            if (r7.intValue() != 2) goto L47;
            com.bytedance.android.live.core.resources.k r36 = r4.getH265SuperResourceModel();
            if (r36 == null) goto L52;
            com.bytedance.android.live.core.resources.l r37 = r36.getResourceModel();
            if (r37 == null) goto L52;
            List r38 = r37.getUrlList();
            if (r38 == null) goto L52;
            r10 = (String) CollectionsKt.getOrNull(r38, 0);
            goto L53
        L28:
            if (r7.intValue() != 1) goto L36;
            com.bytedance.android.live.core.resources.j r39 = r4.getH265ResourceModel();
            if (r39 == null) goto L52;
            com.bytedance.android.live.core.resources.l r40 = r39.getResourceModel();
            if (r40 == null) goto L52;
            List r41 = r40.getUrlList();
            if (r41 == null) goto L52;
            r10 = (String) CollectionsKt.getOrNull(r41, 0);
            goto L53
        L19:
            if (r7.intValue() != 0) goto L25;
            com.bytedance.android.live.core.resources.l r43 = r4.getResourceModel();
            if (r43 == null) goto L52;
            List r44 = r43.getUrlList();
            if (r44 == null) goto L52;
            r10 = (String) CollectionsKt.getOrNull(r44, 0);
            goto L53
        L14:
            r7 = null;
        L54:
            r14 = -1;
            r16 = BuildConfig.FLAVOR;
            goto L55
        L5:
            if (TextUtils.equals("DefaultSystemPlayer", r28) == false) goto L7;
            ay1.b.l.setValue(null, ay1.b.a[14], Boolean.TRUE);
            goto L7
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public i(BaseVideoGiftWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            BaseVideoGiftWidget r0 = this.a;
            int r1 = BaseVideoGiftWidget.I;
            r0.gr(r4, "toggleVideoGiftView event");
            if (r4 == true) goto L5;
            return;
        L5:
            if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.o.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[13])).booleanValue() == false) goto L9;
            VideoGiftMsgManagerV2 r5 = VideoGiftWidgetV2.S;
            r5.getClass();
            Intrinsics.checkNotNullParameter("toggleVideoGiftView", "reason");
            r5.l(true, "toggleVideoGiftView");
            r5.i();
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public j(BaseVideoGiftWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            BaseVideoGiftWidget r0 = this.a;
            if (r0.l == false) goto L16;
            if (r4 == false) goto L18;
            VideoGiftView r5 = r0.e;
            if (r5 == null) goto L12;
            com.bytedance.android.livesdk.gift.platform.business.effect.player.f r6 = r5.h;
            if (r6 == null) goto L12;
            ILiveGiftPlayController r7 = r6.f;
            if (r7 == null) goto L12;
            r7.cancel();
        L12:
            r0.l = false;
            Iterator r8 = ((LinkedHashMap) r0.h).entrySet().iterator();
        L14:
            if (r8.hasNext() == false) goto L19;
            Map.Entry r1 = (Map.Entry) r8.next();
            ((Number) r1.getKey()).intValue();
            ((com.bytedance.android.livesdk.gift.platform.business.effect.player.a) r1.getValue()).onCancel();
            goto L14
        L19:
            return;
        L18:
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public k(BaseVideoGiftWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            h2 r3 = (h2) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            this.a.Rq(r3);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public l(BaseVideoGiftWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.a.b, "timeout and release player");
            com.bytedance.android.livesdk.gift.platform.business.effect.player.n r4 = this.a.t;
            if (r4 == null) goto L5;
            r4.a();
        L5:
            Disposable r5 = this.a.v;
            if (r5 == null) goto L9;
            r5.dispose();
            return;
        }
    }

    public static final class m implements IPlayerProgressListener {
        public final /* synthetic */ BaseVideoGiftWidget a;

        public m(BaseVideoGiftWidget r1) {
            this.a = r1;
        }

        public final void onProgress(long r5) {
            VideoGiftView r0 = this.a.e;
            if (r0 == null) goto L5;
            Integer r1 = Integer.valueOf(r0.getDuration());
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            if (r1.intValue() != 0) goto L10;
            return;
        L10:
            if (r5 >= ((r1.intValue() / 2) - 25)) goto L12;
            return;
        L12:
            if (r5 > ((r1.intValue() / 2) + 25)) goto L18;
            BaseVideoGiftWidget.zq(this.a, false);
            return;
        L18:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class n implements eq2.a {
        public final /* synthetic */ BaseVideoGiftWidget a;
        public final /* synthetic */ com.bytedance.android.live.core.resources.e b;
        public final /* synthetic */ Function0 c;

        public final FrameLayout a() {
            com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r0 = this.a.y;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a;
        }

        public final GLSurfaceView b() {
            com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r0 = this.a.y;
            if (r0 == null) goto L7;
            GLSurfaceView r1 = r0.b;
            if (r1 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4View");
            return r1;
        L9:
            return r1;
        L7:
            return null;
        }

        public final void c(eq2.c r4, RevTaskState r5) {
            if (r5 == RevTaskState.COMPLETE) goto L7;
            if (r5 == RevTaskState.CANCEL) goto L7;
            return;
        L7:
            if (com.bytedance.android.livesdk.gift.platform.business.effect.a.f() == false) goto L28;
            com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r6 = this.a.y;
            if (r6 == null) goto L27;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r6);
            goto L27
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r1 == null) goto L24;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
            goto L24
        L13:
            if (Looper.myLooper() == r0.getLooper()) goto L15;
            r0.post(DialogLancet.createDismissRunnable(r6));
        L27:
            BaseVideoGiftWidget r7 = this.a;
            r7.y = null;
            com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r7.b, "temp dialog dismiss");
        L28:
            Function0 r8 = this.c;
            if (r8 == null) goto L32;
            Unit r9 = (Unit) r8.invoke();
        L32:
            if (r4 == null) goto L42;
            String r2 = r4.h;
            if (r2 == null) goto L41;
            if (r2.length() != 0) goto L38;
            boolean r3 = true;
        L39:
            if (r3 == false) goto L42;
        L38:
            r3 = false;
        L41:
            if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r4.j) == true) goto L42;
            return;
        L42:
            BaseVideoGiftWidget r10 = this.a;
            r10.x = false;
            r10.l = false;
            r10.Fq();
        }

        public n(BaseVideoGiftWidget r1, com.bytedance.android.live.core.resources.e r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public abstract void Cq();

    public void Eq() {
    }

    public abstract void Fq();

    public abstract com.bytedance.android.livesdk.gift.platform.business.effect.player.f.a Gq();

    public abstract void Mq();

    public void Nq() {
    }

    public void Pq(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public void Qq() {
    }

    public abstract void Sq(k6 r1);

    public abstract void Tq(i6 r1);

    public abstract void Wq(q8 r1);

    public abstract void Yq(gm2.g r1);

    public abstract void Zq(o7 r1);

    public abstract void ar();

    public final int getLayoutId() {
        return 2131567842;
    }

    public final String getSpm() {
        return "a100.a100.a227";
    }

    public final void onInit(Object[] r1) {
    }

    public BaseVideoGiftWidget() {
        this.b = "BaseVideoGiftWidget";
        this.h = new LinkedHashMap();
        this.j = true;
        this.k = "default";
        this.q = true;
        this.z = m12.b.a();
        this.A = new PointF(-1.0f, -1.0f);
        this.B = new b(this);
        this.c = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
        this.m = new m02.i();
        this.r = Gq();
        this.C = new e(this);
        this.D = new d(this);
        this.E = new m(this);
        this.F = new g(this);
        this.G = new h(this);
        this.H = new f(this);
    }

    public final boolean Jq() {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.i().a() == false) goto L15;
        com.bytedance.android.scope.j r0 = ((GiftRecyclableWidget) this).a;
        if (r0 == null) goto L7;
        g0 r1 = (g0) com.bytedance.android.scope.m.e.d(r0, g0.class);
    L8:
        if (r1 == null) goto L16;
        MutableLiveData<Boolean> r2 = r1.b;
        if (r2 == null) goto L17;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 != null) goto L14;
        return false;
    L14:
        return r3.booleanValue();
    L17:
        return false;
    L16:
        return false;
    L7:
        r1 = null;
        goto L8
    L15:
        return false;
    }

    public final void Lq() {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.f() == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r0 = this.y;
        if (r0 == null) goto L8;
        wq(r0);
    L8:
        Boolean r1 = null;
        this.y = null;
        if (u.p() == true) goto L34;
        IRoom r2 = this.d;
        boolean r3 = true;
        if (r2 != null) goto L13;
    L15:
        ReadOnlyProperty r4 = com.bytedance.android.livesdk.gift.platform.business.effect.a.r;
        KProperty[] r5 = com.bytedance.android.livesdk.gift.platform.business.effect.a.a;
        if (((Boolean) r4.getValue(null, r5[16])).booleanValue() == true) goto L18;
    L32:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "setting is " + ((Boolean) r4.getValue(null, r5[16])).booleanValue() + ", isPortrait is " + com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k());
        return;
    L18:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L32;
        Activity r6 = ContextUtil.contextToActivity(((Widget) this).context);
        if (r6 == null) goto L27;
        com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r7 = new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a(r6);
        this.y = r7;
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(r7);
    L26:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "dialog启动");
        goto L27
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L25:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    L27:
        String r8 = this.b;
        StringBuilder r9 = new StringBuilder("context is ");
        if (getContext() == null) goto L31;
        r3 = false;
    L31:
        r9.append(r3);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r8, r9.toString());
        return;
    L13:
        if (r2.isMediaRoom() != true) goto L15;
    L34:
        String r10 = this.b;
        StringBuilder r11 = new StringBuilder("isVs is ");
        r11.append(u.p());
        r11.append(", isMediaRoom is ");
        IRoom r13 = this.d;
        if (r13 == null) goto L37;
        r1 = Boolean.valueOf(r13.isMediaRoom());
    L37:
        r11.append(r1);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r10, r11.toString());
    }

    public void onUnload() {
        ar();
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).onModuleStop("gift_mp4");
        if (this.c.D == false) goto L7;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r0 = GiftResourceManagerFactory.a();
        if (r0 == null) goto L7;
        r0.clear();
    L7:
        this.l = false;
        this.p = 0;
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.gift.platform.core.d> r2 = r1.getCurrentGiftEffect();
        if (r2 == null) goto L12;
        r2.setValue(null);
    L12:
        Iterator r3 = ((LinkedHashMap) this.h).entrySet().iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.player.a) ((Map.Entry) r3.next()).getValue()).onDestroy();
        goto L14
    L16:
        ((LinkedHashMap) this.h).clear();
        com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r4 = this.y;
        if (r4 == null) goto L19;
        wq(r4);
    L19:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "baseVideoGiftWidget unload, flyDialog dismiss");
        com.bytedance.android.livesdk.gift.platform.business.effect.player.n r5 = this.t;
        if (r5 == null) goto L22;
        r5.a();
    L22:
        Disposable r6 = this.v;
        if (r6 == null) goto L25;
        r6.dispose();
    L25:
        com.bytedance.android.scope.j r7 = ((GiftRecyclableWidget) this).a;
        if (r7 == null) goto L32;
        com.bytedance.android.livesdk.gift.platform.core.scope.service.j r8 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.j) com.bytedance.android.scope.m.e.d(r7, com.bytedance.android.livesdk.gift.platform.core.scope.service.j.class);
        if (r8 == null) goto L33;
        b r9 = this.B;
        Intrinsics.checkNotNullParameter(r9, "observer");
        r8.a.removeObserver(r9);
        return;
    L33:
        return;
    }

    public void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onDestroy();
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
    }

    public static void wq(com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final String xq(BaseVideoGiftWidget r0) {
        VideoGiftView r1 = r0.e;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        return r1.getPlayerType();
    L5:
        return CardLockInfo.sUNKNOWN;
    }

    public final boolean Iq(EffectMessage r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.d(Long.valueOf(r4.a), "displayAndHidEffect");
        VideoGiftView r0 = this.e;
        Intrinsics.checkNotNull(r0);
        boolean r5 = r0.f(r4, new c(this, r4));
        if (r5 == true) goto L5;
        this.l = false;
    L5:
        return r5;
    }

    public final boolean Kq(int r3) {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.g() == 4) goto L5;
        return false;
    L5:
        if (r3 != 2) goto L8;
        return true;
    L8:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.i().b() == true) goto L10;
        return false;
    L10:
        if (r3 != (-1)) goto L12;
        return false;
    L12:
        return !Jq();
    }

    public final void Rq(h2 r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.b, "receive event: " + r10);
        if (this.j == true) goto L8;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "effect switch close");
        return;
    L8:
        f r7 = this.H;
        this.u = r10;
        if (this.t != null) goto L12;
        this.t = new com.bytedance.android.livesdk.gift.platform.business.effect.player.n();
    L12:
        if (r10.e == false) goto L20;
        com.bytedance.android.livesdk.gift.platform.business.effect.player.n r1 = this.t;
        if (r1 == null) goto L23;
        Context r2 = ((Widget) this).context;
        LynxVideoView r0 = this.g;
        if (r0 == null) goto L18;
        FrameLayout r3 = r0.getVideoContainer();
    L19:
        r1.b(r2, r3, r10.a, r10.b, this.C, r7);
        goto L23
    L18:
        r3 = null;
    L23:
        Disposable r11 = this.v;
        if (r11 == null) goto L26;
        r11.dispose();
    L26:
        LynxAlphaPlayerAutoReleaseSwitch r13 = (LynxAlphaPlayerAutoReleaseSwitch) com.bytedance.android.livesdk.gift.platform.business.effect.a.A.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[25]);
        if (r13.getEnable() == false) goto L30;
        this.v = Observable.timer(r13.getAliveDuration(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this));
        return;
    L30:
        return;
    L20:
        com.bytedance.android.livesdk.gift.platform.business.effect.player.n r4 = this.t;
        if (r4 == null) goto L23;
        r4.b(((Widget) this).context, this.f, r10.a, r10.b, this.C, r7);
        goto L23
    }

    public final void br(EffectMessage r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Map<Long, iy1.a> r7 = r6.e;
        i12.e r0 = o.b();
        if (r0 == null) goto L7;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, w.class);
    L8:
        w r2 = (w) r1;
        if (r7 == null) goto L23;
        Iterator<Map.Entry<Long, iy1.a>> r8 = r7.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L36;
        String r3 = this.c.D1(r8.next().getKey().longValue());
        if (r3 == null) goto L12;
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(r3, "md5");
        Integer r4 = r2.a.get(r3);
        if (r4 == null) goto L12;
        int r5 = r4.intValue() - 1;
        if (r5 <= 0) goto L21;
        r2.a.put(r3, Integer.valueOf(r5));
        goto L12
    L21:
        r2.a.remove(r3);
        goto L12
    L36:
        return;
    L23:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void fr(EffectMessage r7) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.h.x("临时下载该特效失败", String.valueOf(r7.l), String.valueOf(r7.a), BuildConfig.FLAVOR, r7.n);
        if ((System.currentTimeMillis() - this.p) <= (((long) 30) * 1000)) goto L6;
        this.p = System.currentTimeMillis();
        ToastUtil.a(2131920068, 0);
        return;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6.getKey()) == false) goto L7;
        return;
    L7:
        if (r6.getData() == null) goto L92;
        String r0 = r6.getKey();
        int r2 = 0;
        switch(r0.hashCode()) {
            case -1907464197: goto L61;
            case -1768545333: goto L58;
            case -1203988366: goto L45;
            case -138407311: goto L40;
            case -79017966: goto L37;
            case 294674590: goto L29;
            case 309908432: goto L13;
            default: goto L93;
        };
    L93:
        return;
    L13:
        if (r0.equals("data_media_introduction_showing") == false) goto L68;
        IRoom r1 = this.d;
        if (r1 == null) goto L69;
        Intrinsics.checkNotNull(r1);
        if (r1.isMediaRoom() == false) goto L70;
        IRoom r3 = this.d;
        Intrinsics.checkNotNull(r3);
        if (r3.getRoomAuthStatus() == null) goto L71;
        IRoom r4 = this.d;
        Intrinsics.checkNotNull(r4);
        if (r4.getRoomAuthStatus().getEnableGift() == false) goto L72;
        Object r7 = r6.getData();
        Intrinsics.checkNotNull(r7);
        boolean r8 = ((Boolean) r7).booleanValue();
        ViewGroup r9 = ((Widget) this).containerView;
        if (r8 == false) goto L25;
        r2 = 8;
    L25:
        UIUtils.setViewVisibility(r9, r2);
        if (this.e == null) goto L73;
        er(!r8, "DATA_MEDIA_INTRODUCTION_SHOWING");
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L69:
        return;
    L68:
        return;
    L29:
        if (r0.equals("data_keyboard_status_douyin") == false) goto L75;
        Object r10 = r6.getData();
        Intrinsics.checkNotNull(r10);
        boolean r11 = ((Boolean) r10).booleanValue();
        VideoGiftView r13 = this.e;
        if (r13 == null) goto L76;
        Intrinsics.checkNotNull(r13);
        if (r11 == false) goto L35;
        r2 = 8;
    L35:
        UIUtils.setViewVisibility(null, r2);
        return;
    L76:
        return;
    L75:
        return;
    L37:
        if (r0.equals("cmd_toggle_gift_video_view") == false) goto L78;
        gr(!Intrinsics.areEqual((Boolean) r6.getData(Boolean.TRUE), Boolean.FALSE), "CMD_TOGGLE_GIFT_VIDEO_VIEW");
        return;
    L78:
        return;
    L40:
        if (r0.equals("cmd_init_gift_effect_dialog") == true) goto L42;
        return;
    L42:
        if (Intrinsics.areEqual((Boolean) r6.getData(), Boolean.TRUE) == false) goto L81;
        Lq();
        return;
    L81:
        return;
    L45:
        if (r0.equals("data_room_gift_status") == false) goto L83;
        IRoom r14 = this.d;
        if (r14 == null) goto L84;
        Intrinsics.checkNotNull(r14);
        if (r14.getRoomAuthStatus() == null) goto L85;
        ViewGroup r15 = ((Widget) this).containerView;
        IRoom r16 = this.d;
        Intrinsics.checkNotNull(r16);
        if (r16.getRoomAuthStatus().getEnableGift() == true) goto L54;
        r2 = 8;
    L54:
        UIUtils.setViewVisibility(r15, r2);
        if (this.e == null) goto L86;
        IRoom r17 = this.d;
        Intrinsics.checkNotNull(r17);
        er(r17.getRoomAuthStatus().getEnableGift(), "DATA_ROOM_GIFT_STATUS");
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L83:
        return;
    L58:
        if (r0.equals("data_consume_next") == false) goto L88;
        this.l = false;
        this.x = false;
        Fq();
        return;
    L88:
        return;
    L61:
        if (r0.equals("cmd_gift_effect_is_open") == false) goto L90;
        Object r18 = r6.getData(Boolean.TRUE);
        Intrinsics.checkNotNull(r18);
        boolean r19 = ((Boolean) r18).booleanValue();
        if (this.e == null) goto L91;
        er(r19, "CMD_GIFT_EFFECT_IS_OPEN");
        return;
    L91:
        return;
    L90:
        return;
    }

    public void onLoad(Object[] r15) {
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.a.class).J6() == false) goto L5;
        return;
    L5:
        boolean r16 = true;
        this.j = true;
        this.d = x.a();
        ((Widget) this).dataCenter.observeForever("data_keyboard_status_douyin", this).observe("data_room_gift_status", this).observe("cmd_gift_effect_is_open", this).observe("data_media_introduction_showing", this).observe("cmd_toggle_gift_video_view", this).observe("cmd_init_gift_effect_dialog", this).observe("data_consume_next", this);
        this.n = (FrameLayout) findViewById(2131392305);
        this.e = (VideoGiftView) findViewById(2131392304);
        Boolean r0 = (Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE);
        VideoGiftView r1 = this.e;
        if (r1 == null) goto L8;
        r1.setPortrait(r0.booleanValue());
    L8:
        VideoGiftView r2 = this.e;
        if (r2 == null) goto L11;
        Context r4 = ((Widget) this).context;
        g r3 = this.F;
        m r7 = this.E;
        com.bytedance.android.livesdk.gift.platform.business.effect.player.f.a r8 = this.r;
        h r9 = this.G;
        com.bytedance.android.livesdk.gift.platform.business.effect.giftview.i r6 = new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.i(r2, r3);
        r2.o = r6;
        r2.h = new com.bytedance.android.livesdk.gift.platform.business.effect.player.f(r4, r2.a, r6, r7, r8, r9);
    L11:
        AttributeSet r5 = null;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.p.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[14])).booleanValue() == false) goto L16;
        FrameLayout r10 = this.n;
        if (r10 == null) goto L16;
        r10.setOnTouchListener(new com.bytedance.android.livesdk.gift.platform.business.effect.widget.a(this, r0));
    L16:
        Lq();
        ILiveWrappedEffectSDKService.Companion.getClass();     // Catch: Throwable -> L21
        ILiveWrappedEffectSDKService r11 = ILiveWrappedEffectSDKService.a.a();     // Catch: Throwable -> L21
        if (r11 == null) goto L22;
        r11.getSdkVersion();     // Catch: Throwable -> L21
    L22:
        FrameLayout r13 = this.n;
        if (r13 != null) goto L25;
    L36:
        this.f = (FrameLayout) findViewById(2131363783);
        LynxVideoView r14 = new LynxVideoView(((Widget) this).context, r5, 6, 0);
        this.g = r14;
        FrameLayout r17 = this.n;
        if (r17 == null) goto L39;
        r17.addView(r14, -1, -1);
    L39:
        this.i = new n02.a();
        Mq();
        this.q = ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        GiftContext r18 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r18 == null) goto L48;
        com.bytedance.live.datacontext.k<Boolean> r19 = r18.getToggleVideoGiftView();
        if (r19 == null) goto L48;
        PublishSubject r20 = r19.onEvent();
        if (r20 == null) goto L48;
        ObservableSubscribeProxy r21 = (ObservableSubscribeProxy) r20.as(AutoDispose.bind(this));
        if (r21 == null) goto L48;
        r21.subscribe(new i(this));
    L48:
        GiftContext r23 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r23 == null) goto L57;
        com.bytedance.live.datacontext.k<Boolean> r24 = r23.getNeedStopEffect();
        if (r24 == null) goto L57;
        PublishSubject r25 = r24.onEvent();
        if (r25 == null) goto L57;
        ObservableSubscribeProxy r26 = (ObservableSubscribeProxy) r25.as(AutoDispose.bind(this));
        if (r26 == null) goto L57;
        r26.subscribe(new j(this));
    L57:
        GiftContext r27 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r27 == null) goto L66;
        com.bytedance.live.datacontext.k<h2> r28 = r27.getPlayLynxAlphaVideoEvent();
        if (r28 == null) goto L66;
        PublishSubject r29 = r28.onEvent();
        if (r29 == null) goto L66;
        ObservableSubscribeProxy r30 = (ObservableSubscribeProxy) r29.as(AutoDispose.bind(this));
        if (r30 == null) goto L66;
        r30.subscribe(new k(this));
    L66:
        com.bytedance.android.scope.j r31 = ((GiftRecyclableWidget) this).a;
        if (r31 == null) goto L99;
        GiftMessageService r33 = (GiftMessageService) com.bytedance.android.scope.m.e.d(r31, GiftMessageService.class);
        if (r33 == null) goto L99;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.F.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[30])).booleanValue() == false) goto L99;
        IMainGiftRoom r34 = r33.D.getRoom().castToOrNull(IMainGiftRoom.class);
        if (r34 == null) goto L99;
        com.bytedance.android.live.revenue.model.extension.main.c r35 = r34.getOthers();
        if (r35 == null) goto L99;
        com.bytedance.android.live.revenue.model.extension.main.a r36 = r35.getEnterGiftAnimation();
        if (r36 == null) goto L99;
        int r37 = com.bytedance.android.livesdk.gift.platform.core.utils.a.a;
        int r38 = r36.getDisplayGap();
        int r39 = r36.getDisplayFreq();
        Set r40 = CollectionsKt.toMutableSet((Set) com.bytedance.android.livesdk.gift.platform.core.utils.b.b.getValue(null, com.bytedance.android.livesdk.gift.platform.core.utils.b.a[0]));
        long r41 = System.currentTimeMillis() - ((long) (r38 * 86400000));
        ArrayList r43 = new ArrayList();
        Iterator r44 = r40.iterator();
    L81:
        if (r44.hasNext() == false) goto L89;
        Object r110 = r44.next();
        if (CastLongProtector.parseLong((String) r110) <= r41) goto L85;
        boolean r111 = true;
    L86:
        if (r111 == false) goto L81;
        r43.add(r110);
        goto L81
    L85:
        r111 = false;
        goto L86
    L89:
        if (r43.size() < r39) goto L91;
        r16 = false;
    L92:
        if (r16 == false) goto L99;
        k6 r112 = vh7.f.c(k6.class);
        r112.setAssetId(r36.getGiftEffectId());
        m0 r45 = vh7.f.c(m0.class);
        r45.setMessageId(114514);
        Unit r46 = Unit.INSTANCE;
        r112.setCommonData(r45);
        r112.setFromUser(r33.D.getUser());
        r112.setToUser(r33.D.getUser());
        r33.E.f(r112);
        boolean r47 = GiftEffectManager.a;
        if (GiftEffectManager.b(r112, r33.i) == true) goto L99;
        if (r33.r == true) goto L99;
        r33.b.setValue(r112);
        goto L99
    L91:
        r40.clear();
        r40.addAll(r43);
        Intrinsics.checkNotNullParameter(r40, "<set-?>");
        com.bytedance.android.livesdk.gift.platform.core.utils.b.b.setValue(null, com.bytedance.android.livesdk.gift.platform.core.utils.b.a[0], r40);
    L99:
        com.bytedance.android.scope.j r113 = ((GiftRecyclableWidget) this).a;
        if (r113 == null) goto L112;
        com.bytedance.android.livesdk.gift.platform.core.scope.service.j r114 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.j) com.bytedance.android.scope.m.e.d(r113, com.bytedance.android.livesdk.gift.platform.core.scope.service.j.class);
        if (r114 == null) goto L113;
        b r48 = this.B;
        Intrinsics.checkNotNullParameter(this, "owner");
        Intrinsics.checkNotNullParameter(r48, "observer");
        r114.a.observe(this, r48);
        return;
    L113:
        return;
    L112:
        return;
    L25:
        if ((((Widget) this).context instanceof Activity) == false) goto L27;
        Map<Integer, com.bytedance.android.livesdk.gift.platform.business.effect.player.a> r49 = this.h;
        DataCenter r50 = ((Widget) this).dataCenter;
        Context r51 = ((Widget) this).context;
        if (r51 == null) goto L35;
        AssembleLynxPlayer r53 = new AssembleLynxPlayer(r50, r13, (Activity) r51);
        d r54 = this.D;
        Intrinsics.checkNotNullParameter(r54, "listener");
        r53.d = r54;
        Unit r55 = Unit.INSTANCE;
        r49.put(11, r53);
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L27:
        if (v.a() == true) goto L30;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "ERROR:context is not Activity ,cannot create lynx component");
        v12.f.B("initEffectPlayer context is not Activity");
        goto L36
    L30:
        throw new IllegalArgumentException("ERROR:context is not Activity ,cannot create lynx component");
    L21:
        jy0.b.c(this.b, "init bef gift view fail!! effect not ready", null, 4);
        goto L22
    }

    public static void cr(EffectMessage r3, com.bytedance.android.live.core.resources.e r4) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "assets");
        HashMap r0 = new HashMap();
        r0.put("desc", "特效资源类型有误");
        r0.put("asset_type", Integer.valueOf(r4.getResourceType()));
        r0.put("asset_id", Long.valueOf(r3.b));
        r0.put("gift_id", Long.valueOf(r3.l));
        r0.put("msg_id", Long.valueOf(r3.a));
        r0.put("log_id", r3.n);
        jy0.b.c("ttlive_gift", r0.toString(), null, 4);
    }

    public static final void yq(BaseVideoGiftWidget r3, String r4) {
        DataCenter r0 = ((Widget) r3).dataCenter;
        if (r0 == null) goto L19;
        VideoGiftView r5 = r3.e;
        if (r5 == null) goto L8;
        Intrinsics.checkNotNull(r5);
        String r6 = r5.getPlayerType();
    L9:
        String r1 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Intrinsics.checkNotNullParameter(r0, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "playerType");
        Boolean r2 = (Boolean) r0.get("data_is_anchor", Boolean.FALSE);
        HashMap r7 = new HashMap();
        r7.put("isAnchor", String.valueOf(r2.booleanValue()));
        if (r4 != null) goto L12;
        r4 = BuildConfig.FLAVOR;
    L12:
        r7.put("log_id", r4);
        if (TextUtils.equals("TTGiftPlayerImpl", r6) == false) goto L15;
    L16:
        r7.put("ttplayer_hardcore_open", String.valueOf(com.bytedance.android.livesdk.gift.platform.business.effect.a.h()));
    L17:
        com.bytedance.android.live.core.performance.a.a.getClass();
        return;
    L15:
        if (TextUtils.equals("TTEnginePlayerImpl", r6) == false) goto L17;
    L8:
        r6 = CardLockInfo.sUNKNOWN;
        goto L9
    }

    public static final void zq(BaseVideoGiftWidget r21, boolean r23) {
        r21.getClass();
        boolean r2 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h();
        com.bytedance.android.livesdk.revenue.service.performance.c r1 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class);
        yz0.k r3 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r3 == null) goto L5;
        long r4 = r3.Hl();
    L6:
        long r5 = (System.currentTimeMillis() - r4) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        c0 r6 = c0.a;
        IRoom r7 = r21.d;
        long r8 = 0;
        if (r7 == null) goto L9;
        long r9 = r7.getRoomId();
    L10:
        EffectMessage r10 = r21.o;
        if (r10 == null) goto L13;
        long r11 = r10.l;
    L14:
        if (r10 == null) goto L16;
        r8 = r10.b;
    L16:
        int r13 = (int) r5;
        float r14 = r1.getTemperature();
        double r15 = r1.getFps();
        double r16 = r1.getGpuUsed();
        double r17 = r1.getCpuRate();
        SuperResolutionModel r18 = r21.s;
        if (r18 == null) goto L19;
        int r19 = r18.getVideoAssetType();
    L20:
        SuperResolutionModel r0 = r21.s;
        if (r0 == null) goto L23;
        boolean r20 = r0.getOpenSR();
    L24:
        c0.g(r9, r2 ? 1 : 0, r11, r8, r13, r14, r15, r16, r17, r23, r19, r20);
        return;
    L23:
        r20 = false;
        goto L24
    L19:
        r19 = -1;
        goto L20
    L13:
        r11 = 0;
        goto L14
    L9:
        r9 = 0;
        goto L10
    L5:
        r4 = System.currentTimeMillis();
        goto L6
    }

    public final void Bq(EffectMessage r18, int r19) {
        HashMap r2 = new HashMap();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r3 = com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class).W2(LogCommon.PAGE_SOURCE_LOG);
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r4 = com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class).W2(LogCommon.ROOM);
        if (r3 == null) goto L5;
        r3.h(r2);
    L5:
        if (r4 == null) goto L7;
        r4.h(r2);
    L7:
        IRoom r5 = this.d;
        if (r5 == null) goto L13;
        Intrinsics.checkNotNull(r5);
        r2.put("room_id", String.valueOf(r5.getId()));
        IRoom r6 = this.d;
        Intrinsics.checkNotNull(r6);
        String r7 = r6.getAnchorId();
        if (r7 != null) goto L12;
        r7 = BuildConfig.FLAVOR;
    L12:
        r2.put("anchor_id", r7);
    L13:
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L18;
        Boolean r9 = (Boolean) r8.get("data_is_anchor", Boolean.FALSE);
        if (r9 == null) goto L18;
        boolean r10 = r9.booleanValue();
    L19:
        String r11 = "0";
        if (r10 == false) goto L22;
        Object r13 = "1";
    L23:
        r2.put("is_anchor", r13);
        r2.put("gift_id", String.valueOf(r18.l));
        r2.put("effect_id", String.valueOf(r18.b));
        r2.put("gift_type", String.valueOf(r18.u));
        String r14 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        if (r14.length() <= 0) goto L26;
        boolean r15 = true;
    L27:
        String r16 = null;
        if (r15 == false) goto L47;
        IBaseUser r17 = r18.i;
        if (r17 != null) goto L32;
    L34:
        IBaseUser r20 = r18.h;
        if (r20 == null) goto L37;
        String r21 = r20.getIdString();
    L39:
        if (Intrinsics.areEqual(r14, r21) == true) goto L46;
        List<String> r23 = r18.A;
        if (r23 != null) goto L43;
    L45:
        r2.put("gift_role", "2");
    L48:
        char r24 = 'x';
    L50:
        if (r19 == (-1)) goto L52;
        r2.put("is_new_resolution", String.valueOf(r19));
    L52:
        int r25 = r18.f;
        if (r25 != 5) goto L55;
    L58:
        Object r26 = "1";
    L59:
        r2.put("ies_effect", r26);
        r2.put("gift_effect_type", String.valueOf(r18.f));
        if (Jq() == false) goto L62;
        Object r27 = "1";
    L63:
        r2.put("is_super_resolution_degrade", r27);
        com.bytedance.android.livesdk.gift.model.a r28 = r18.q;
        if (r28 == null) goto L69;
        t3 r110 = r28.c;
        if (r110 == null) goto L69;
        Map<String, String> r111 = r110.f;
        if (r111 == null) goto L69;
    L75:
        if (r111 != null) goto L77;
    L99:
        r2.put("asset_predownload", String.valueOf(r18.I));
        r2.put("message_id", String.valueOf(r18.a));
        List<n3> r29 = r18.P;
        if (r29 != null) goto L102;
    L105:
        boolean r30 = true;
    L106:
        if (r30 == false) goto L108;
        Object r31 = "0";
    L109:
        r2.put("is_series_send", r31);
        IBaseUser r33 = r18.i;
        if (r33 == null) goto L112;
        r16 = r33.getIdString();
    L112:
        IBaseUser r34 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b();
        if (Intrinsics.areEqual(r34.getIdString(), r16) == false) goto L115;
        Object r35 = "1";
        r24 = 'n';
    L116:
        r2.put("is_gift_sender", r35);
        List<String> r36 = r18.A;
        if (r36 != null) goto L119;
    L122:
        boolean r112 = true;
    L123:
        if (r112 == false) goto L125;
        if (r10 == false) goto L129;
    L128:
        r11 = "1";
        r24 = 'd';
    L129:
        r2.put("is_gift_receiver", r11);
        Long r37 = (Long) ((HashMap) r18.B).get(6);
        long r38 = 0;
        if (r37 == null) goto L132;
        long r113 = r37.longValue();
    L133:
        Long r39 = (Long) ((HashMap) r18.B).get(7);
        if (r39 == null) goto L136;
        r38 = r39.longValue();
    L136:
        r2.put("download_time", String.valueOf(r38 - r113));
        if (r24 == 'x') goto L140;
        v12.e.a(r2, r18);
    L140:
        if (this.z == false) goto L146;
        if (r24 == 'd') goto L145;
        if (r24 != 'n') goto L146;
        String r1 = "livesdk_gift_effect_show_sender";
    L147:
        mz0.n r40 = new mz0.n();
        Map r41 = r40.a;
        Intrinsics.checkNotNullParameter(r41, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r41.putAll(r2);
        cy0.e.a.getClass();
        cy0.j r43 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r44 = com.bytedance.android.scope.m.b(r43).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r44);
        ((f80.a) r44).w3(r1, r40.a, r40.b);
        return;
    L145:
        r1 = "livesdk_gift_effect_show_anchor";
    L146:
        r1 = "livesdk_gift_effect_show";
        goto L147
    L132:
        r113 = 0;
        goto L133
    L125:
        if (r18.A.contains(r34.getIdString()) == false) goto L129;
    L119:
        if (r36.isEmpty() == true) goto L122;
        r112 = false;
        goto L123
    L115:
        r35 = "0";
        goto L116
    L108:
        r31 = "1";
        goto L109
    L102:
        if (r29.isEmpty() == true) goto L105;
        r30 = false;
        goto L106
    L77:
        if (r111.containsKey("effect_source") != true) goto L99;
        Iterator<Map.Entry<String, String>> r114 = r111.entrySet().iterator();
    L80:
        if (r114.hasNext() == false) goto L82;
        Map.Entry<String, String> r115 = r114.next();
        r2.put(r115.getKey(), r115.getValue());
        goto L80
    L82:
        m0 r45 = r18.z;
        if (r45 == null) goto L87;
        IBaseUser r46 = r45.getUser();
        if (r46 == null) goto L87;
        String r47 = r46.getIdString();
    L88:
        yz0.k r116 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r116 == null) goto L93;
        IBaseUser r117 = r116.getUser();
        if (r117 == null) goto L93;
        String r118 = r117.getIdString();
    L95:
        if (Intrinsics.areEqual(r47, r118) == false) goto L97;
        Object r48 = "1";
    L98:
        r2.put("is_activator", r48);
        mz0.n r49 = new mz0.n();
        Map r119 = r49.a;
        Intrinsics.checkNotNullParameter(r119, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r119.putAll(r2);
        mz0.m r120 = new mz0.m();
        r120.b(LogCommon.DRAWER_LOG);
        ((ArrayList) r49.b).addAll(r120.a);
        cy0.e.a.getClass();
        cy0.j r121 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r122 = com.bytedance.android.scope.m.b(r121).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r122);
        ((f80.a) r122).w3("livesdk_privilege_effect_show", r49.a, r49.b);
        r2.put("bit_type", "1");
        goto L99
    L97:
        r48 = "0";
    L93:
        r118 = null;
    L87:
        r47 = null;
    L69:
        if (r28 == null) goto L73;
        s3 r50 = r28.d;
        if (r50 == null) goto L73;
        r111 = r50.f;
    L73:
        r111 = null;
        goto L75
    L62:
        r27 = "0";
        goto L63
    L55:
        if (r25 == 8) goto L58;
        r26 = "0";
        goto L59
    L43:
        if (r23.contains(r14) != true) goto L45;
    L46:
        r2.put("gift_role", "1");
        r24 = 'd';
        goto L50
    L37:
        r21 = null;
        goto L39
    L32:
        if (Intrinsics.areEqual(r14, r17.getIdString()) == false) goto L34;
        r2.put("gift_role", "0");
        r24 = 'n';
        goto L50
    L47:
        r2.put("gift_role", "2");
        goto L48
    L26:
        r15 = false;
        goto L27
    L22:
        r13 = "0";
    L18:
        r10 = false;
        goto L19
    }

    public final void er(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        if (r4 == true) goto L9;
        com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r0 = this.y;
        if (r0 == null) goto L14;
        FrameLayout r1 = r0.a;
        if (r1 == null) goto L14;
        r1.setVisibility(4);
    L14:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.b, "showGiftView " + r4 + " reason:" + r5);
        VideoGiftView r6 = this.e;
        Intrinsics.checkNotNull(r6);
        r6.d(r4);
        return;
    L9:
        com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r2 = this.y;
        if (r2 == null) goto L14;
        FrameLayout r3 = r2.a;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
        goto L14
    }

    public final void gr(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.j = r4;
        if (r4 == true) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.b, "set canshowVideoGiftView false reason: ".concat(r5));
    L5:
        if (r4 == false) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.b, "set canshowVideoGiftView " + r4 + " consumeNextMessage reason: " + r5);
        Fq();
    L7:
        this.k = r5;
        ViewGroup r0 = ((Widget) this).containerView;
        if (r4 == false) goto L10;
        int r1 = 0;
    L11:
        UIUtils.setViewVisibility(r0, r1);
        if (this.e == null) goto L15;
        er(r4, r5);
        return;
    L15:
        return;
    L10:
        r1 = 8;
        goto L11
    }

    public final void Aq(EffectMessage r30, int r31, boolean r33) {
        Long r1 = (Long) ((HashMap) r30.B).get(6);
        if (r1 == null) goto L5;
        long r4 = r1.longValue();
    L6:
        Long r2 = (Long) ((HashMap) r30.B).get(7);
        if (r2 == null) goto L9;
        long r6 = r2.longValue();
    L10:
        long r13 = r6 - r4;
        boolean r7 = false;
        if (r30.l <= 0) goto L13;
        boolean r14 = true;
    L14:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L19;
        Boolean r5 = (Boolean) r3.get("data_is_anchor", Boolean.FALSE);
        if (r5 == null) goto L19;
        boolean r26 = r5.booleanValue();
    L20:
        IBaseUser r8 = r30.i;
        if (r8 == null) goto L23;
        String r9 = r8.getIdString();
    L24:
        IBaseUser r10 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b();
        List<String> r11 = r30.A;
        if (r11 != null) goto L27;
    L30:
        boolean r15 = true;
    L31:
        if (r15 == true) goto L33;
        boolean r27 = r30.A.contains(r10.getIdString());
    L34:
        boolean r28 = Intrinsics.areEqual(r10.getIdString(), r9);
        if (r33 == true) goto L42;
        int r16 = j02.a.a;
        long r17 = r30.b;
        int r18 = r30.f;
        long r19 = r30.a;
        int r20 = r30.I;
        List<n3> r21 = r30.P;
        if (r21 != null) goto L39;
    L40:
        r7 = true;
    L41:
        j02.a.a(r17, r18, r31, r13, r14, r19, r20, r27, r28, !r7, r30.l, r30.u);
        goto L42
    L39:
        if (r21.isEmpty() == false) goto L41;
    L42:
        c0 r23 = c0.a;
        c0.b(r33, r30.b, BuildConfig.FLAVOR, r31, BuildConfig.FLAVOR, -1, null, null, null, null, r26, r27, r28);
        return;
    L33:
        r27 = r26;
        goto L34
    L27:
        if (r11.isEmpty() == true) goto L30;
        r15 = false;
        goto L31
    L23:
        r9 = null;
    L19:
        r26 = false;
        goto L20
    L13:
        r14 = false;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final void dr(final ScriptInfo r23, final com.bytedance.android.live.core.resources.e r24, Function0<Unit> r25) {
        if (this.e != null) goto L5;
        return;
    L5:
        final EffectMessage r7 = this.o;
        if (r7 == null) goto L53;
        iy1.a r1 = r7.e.get(Long.valueOf(r7.b));
        if (r1 == null) goto L53;
        if (r1.b != 15) goto L53;
        if (this.x == true) goto L53;
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.f() == false) goto L34;
        Activity r2 = ContextUtil.contextToActivity(((Widget) this).context);
        if (r2 == null) goto L34;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.E.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[29])).booleanValue() == true) goto L20;
        com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r4 = this.y;
        if (r4 == null) goto L25;
        wq(r4);
    L25:
        this.y = new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a(r2);
    L26:
        com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a r3 = this.y;
        if (r3 != null) goto L29;
    L33:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.b, "temp dialog show");
        goto L34
    L29:
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L55;
        DialogLancet.handleBlockedDialogShow(r3);
        goto L33
    L55:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54
    L32:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        goto L33
    L20:
        if (this.y != null) goto L26;
        this.y = new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a(r2);
    L34:
        final com.bytedance.android.livesdk.gift.model.h2 r5 = u.e(this.o);
        final VideoGiftView r15 = this.e;
        boolean r18 = false;
        if (r15 == null) goto L50;
        final long r9 = r7.a;
        final String r14 = r1.a;
        final long r11 = r7.x;
        final int r13 = r7.G;
        final List<String> r6 = r7.A;
        PointF r8 = this.A;
        final float r10 = r8.x;
        final float r16 = r8.y;
        final n r17 = new n(this, r24, r25);
        yz0.k r19 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r19 != null) goto L39;
    L41:
        dq2.o r20 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getInteractAnimationService();
        r15.p = r20;
        if (r20 == null) goto L49;
        r15.post(new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.g(r15, r5, r23, r24, r7, r17, r9, r11, r13, r14, r10, r16, r6));
        if (r15.p.c() == true) goto L46;
    L48:
        boolean r0 = r18;
    L51:
        this.x = r0;
        return;
    L46:
        if (r15.p.a() == false) goto L48;
        r18 = true;
        goto L48
    L49:
        jy0.b.b("videoGiftView", "mAnimService is null", null);
        goto L50
    L39:
        if (r19.isCleanMode() == false) goto L41;
    L50:
        r0 = false;
    }
}
