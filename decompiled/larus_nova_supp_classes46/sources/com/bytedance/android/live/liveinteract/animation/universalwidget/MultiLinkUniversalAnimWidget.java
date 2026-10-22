package com.bytedance.android.live.liveinteract.animation.universalwidget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.jsbridge.base.SendInteractEffectEventResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.VideoGiftView;
import com.bytedance.android.live.liveinteract.animation.universalwidget.context.LinkUniversalAnimContext;
import com.bytedance.android.live.liveinteract.animation.universalwidget.effect.LynxEffectJsbController;
import com.bytedance.android.live.liveinteract.animation.universalwidget.view.LynxContainerView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/animation/universalwidget/MultiLinkUniversalAnimWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcd0/a;", "Lcom/bytedance/android/live/liveinteract/animation/universalwidget/a;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkUniversalAnimWidget extends MiddlewareRoomWidget implements Observer<KVData>, cd0.a, com.bytedance.android.live.liveinteract.animation.universalwidget.a {
    public static final /* synthetic */ int x = 0;
    public VideoGiftView a;
    public VideoGiftView b;
    public FrameLayout c;
    public LynxContainerView d;
    public ka0.b e;
    public boolean f;
    public boolean g;
    public boolean h;
    public List<s0> i;
    public boolean j;
    public com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a k;
    public LynxEffectJsbController l;
    public final CompositeDisposable m;
    public String n;
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.g o;
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.c p;
    public final Handler q;
    public Disposable r;
    public final List<Function0<Unit>> s;
    public boolean t;
    public boolean u;
    public final ViewGroup v;
    public final SceneType w;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiLinkUniversalAnimWidget a;

        public b(MultiLinkUniversalAnimWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            StringBuilder r5 = new StringBuilder("3d兼容-定时期间内没有新的3d礼物，通知执行灵活布局动画. animationEndListener null, animationEndListenerList size ");
            MultiLinkUniversalAnimWidget r0 = this.a;
            int r1 = MultiLinkUniversalAnimWidget.x;
            r0.getClass();
            r5.append(((ArrayList) this.a.s).size());
            ALogger.i("MultiLinkEffect.Widget", r5.toString());
            this.a.getClass();
            Iterator r6 = ((ArrayList) this.a.s).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ((Function0) r6.next()).invoke();
            goto L4
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MultiLinkUniversalAnimWidget a;

        public c(MultiLinkUniversalAnimWidget r1) {
            this.a = r1;
        }

        public final void a() {
            MultiLinkUniversalAnimWidget r0 = this.a;
            int r1 = MultiLinkUniversalAnimWidget.x;
            r0.Lq();
            ALogger.d("MultiLinkEffect.Widget", "notifySeatChangedToLynx.headRenderList:" + this.a.i);
            MultiLinkUniversalAnimWidget r2 = this.a;
            List<s0> r3 = r2.i;
            if (r3 == null) goto L48;
            r2.getClass();
            JSONObject r4 = new JSONObject();
            r4.put("eventName", "event_flymic_guest_list_change");
            IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
            int r6 = 0;
            if (r5 == null) goto L7;
            int r7 = r5.getCurUILayout();
        L8:
            r4.put("layout", r7);
            if (r2.v.getWidth() <= 0) goto L11;
            int r8 = r2.v.getWidth();
        L20:
            if (r2.v.getHeight() <= 0) goto L22;
            int r9 = r2.v.getHeight();
        L30:
            Intrinsics.checkNotNullParameter(r3, "headRenderList");
            JsonArray r10 = new JsonArray();
            Iterator<T> r11 = r3.iterator();
        L32:
            if (r11.hasNext() == false) goto L41;
            s0 r12 = (s0) r11.next();
            JsonObject r13 = new JsonObject();
            r13.addProperty("view_width", Integer.valueOf(r12.c));
            r13.addProperty("view_height", Integer.valueOf(r12.d));
            r13.addProperty("view_x", Float.valueOf(r12.a));
            r13.addProperty("view_y", Float.valueOf(r12.b));
            r13.addProperty("uid", r12.i);
            if (r12.e == null) goto L36;
        L39:
            String r14 = "audio";
        L40:
            r13.addProperty("link_type", r14);
            r13.addProperty("user_position", Integer.valueOf(r6));
            r10.add(r13);
            r6 = r6 + 1;
            goto L32
        L36:
            if (Intrinsics.areEqual(r12.k, Boolean.TRUE) == true) goto L39;
            r14 = "video";
            goto L40
        L41:
            r4.put("micseats", r10.toString());
            r4.put("screen_width", r8);
            r4.put("screen_height", r9);
            ka0.b r15 = r2.e;
            if (r15 == null) goto L49;
            r15.sendJsEvent("H5_webcastNotification", r4);
            return;
        L49:
            return;
        L22:
            Context r16 = ((Widget) r2).context;
            if (r16 == null) goto L29;
            Resources r17 = r16.getResources();
            if (r17 == null) goto L29;
            DisplayMetrics r18 = WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics());
            if (r18 == null) goto L29;
            r9 = r18.heightPixels;
        L29:
            r9 = 0;
            goto L30
        L11:
            Context r19 = ((Widget) r2).context;
            if (r19 == null) goto L18;
            Resources r20 = r19.getResources();
            if (r20 == null) goto L18;
            DisplayMetrics r21 = WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics());
            if (r21 == null) goto L18;
            r8 = r21.widthPixels;
        L18:
            r8 = 0;
            goto L20
        L7:
            r7 = 0;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MultiLinkUniversalAnimWidget a;

        public d(MultiLinkUniversalAnimWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            DataCenter r5 = ((Widget) this.a).dataCenter;
            if (r5 == null) goto L6;
            r5.put("data_consume_next", Boolean.TRUE);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.universalwidget.a
    public final void Jl(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "clipPath");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class wq() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("m.l.lynx.svs.svsimpl.LynxSoLibLoader");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("m.l.lynx.svs.svsimpl.LynxSoLibLoader");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("m.l.lynx.svs.svsimpl.LynxSoLibLoader");
    }

    public final boolean Aq() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        int r1 = r0.getCurUILayout();
    L7:
        if (r1 != 22) goto L9;
    L18:
        boolean r2 = true;
    L20:
        if (this.w != SceneType.SCENE_AUDIO_TALKROOM) goto L24;
        if (r2 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L9:
        if (e0.b(r1) == true) goto L18;
        if (r1 == 26) goto L18;
        if (r1 == 24) goto L18;
        if (r1 == 28) goto L18;
        r2 = false;
        goto L20
    L5:
        r1 = 0;
        goto L7
    }

    public final void Bq() {
        if ((!this.s.isEmpty()) == false) goto L9;
        ALogger.i("MultiLinkEffect.Widget", "3d兼容-一个3d礼物播放完毕，启动定时器");
        Disposable r0 = this.r;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        this.r = Observable.timer(((Number) vm2.h.o6.getValue(null, vm2.h.a[377(0x179, float:5.28E-43)])).longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    }

    public final void Cq() {
        this.q.post(new c(this));
    }

    public final boolean Gq() {
        SceneType r0 = this.w;
        int r1 = com.bytedance.android.live.liveinteract.animation.universalwidget.b.a[r0.ordinal()];
        if (r1 == 1) goto L27;
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L38;
        View r2 = this.v.findViewById(2131375527);
        if (r2 == null) goto L13;
        FrameLayout r3 = (FrameLayout) r2;
    L39:
        boolean r4 = true ^ Intrinsics.areEqual(this.c, r3);
        if (r4 == false) goto L58;
        VideoGiftView r5 = this.b;
        if (r5 == null) goto L44;
        r5.setVisibility(8);
    L44:
        VideoGiftView r6 = this.b;
        if (r6 == null) goto L50;
        PlayerController r7 = r6.a;
        if (r7 == null) goto L50;
        r7.detachAlphaView(r6);
    L50:
        VideoGiftView r8 = this.b;
        if (r8 == null) goto L55;
        PlayerController r9 = r8.a;
        if (r9 == null) goto L55;
        r9.cancel();
    L55:
        FrameLayout r10 = this.c;
        if (r10 == null) goto L58;
        r10.removeAllViews();
    L58:
        this.c = r3;
        return r4;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L38:
        r3 = null;
        goto L39
    L15:
        if (isAnchor() == false) goto L21;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r11 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r11 == null) goto L38;
        tf0.o r12 = r11.commonWindowManager();
        if (r12 == null) goto L38;
        r3 = r12.v();
        goto L39
    L21:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r13 = IVoiceChatGuestService.a.a();
        if (r13 == null) goto L38;
        tf0.o r14 = r13.commonWindowManager();
        if (r14 == null) goto L38;
        r3 = r14.v();
        goto L39
    L27:
        if (isAnchor() == false) goto L33;
        rj0.k.m2.getClass();
        rj0.k r15 = rj0.k.a.a();
        if (r15 == null) goto L38;
        tf0.o r16 = r15.windowManager();
        if (r16 == null) goto L38;
        r3 = r16.v();
        goto L39
    L33:
        rj0.l.n2.getClass();
        rj0.l r17 = rj0.l.a.a();
        if (r17 == null) goto L38;
        tf0.o r18 = r17.windowManager();
        if (r18 == null) goto L38;
        r3 = r18.v();
        goto L39
    }

    public final void Jq() {
        FrameLayout r0 = this.c;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        if (this.h == false) goto L10;
        VideoGiftView r1 = this.b;
        if (r1 == null) goto L10;
    L17:
        if (r1 == null) goto L22;
        FrameLayout r2 = this.c;
        if (r2 == null) goto L23;
        r2.addView(r1);
        return;
    L23:
        return;
    L22:
        return;
    L10:
        VideoGiftView r3 = new VideoGiftView(((Widget) this).context);
        this.b = r3;
        Intrinsics.checkNotNull(r3);
        r3.a(((Widget) this).context, this, true, new e(this), new f());
        VideoGiftView r4 = this.b;
        if (r4 == null) goto L13;
        r4.setBackgroundColor(ColorProtector.parseColor("#01000000"));
    L13:
        VideoGiftView r5 = this.b;
        if (r5 == null) goto L16;
        r5.setVisibility(8);
    L16:
        this.h = true;
        r1 = this.b;
        goto L17
    }

    @Override // cd0.a
    public final void Kc() {
        ALogger.i("MultiLinkEffect.Widget", "requestUpdateRegion.sceneType:" + this.w);
        if (this.w != SceneType.SCENE_VIDEO_TALKROOM) goto L29;
        boolean r1 = true;
        if (isAnchor() == false) goto L11;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L22;
        tf0.o r2 = r0.windowManager();
        if (r2 == null) goto L22;
        List<bd0.b> r3 = r2.H(true);
    L23:
        com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r4 = this.k;
        if (r4 == null) goto L30;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "updateRegionList regionList:[" + r3 + ']');
        ((ArrayList) r4.c).clear();
        if (r3 == null) goto L31;
        ((ArrayList) r4.c).addAll(r3);
        return;
    L31:
        return;
    L30:
        return;
    L22:
        r3 = null;
        goto L23
    L11:
        rj0.l.n2.getClass();
        rj0.l r5 = rj0.l.a.a();
        if (r5 == null) goto L22;
        tf0.o r6 = r5.windowManager();
        if (r6 == null) goto L22;
        com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r7 = this.k;
        if (r7 != null) goto L18;
    L20:
        r1 = false;
    L21:
        r3 = r6.H(r1);
        goto L23
    L18:
        if (r7.c() != true) goto L20;
    }

    public final void Kq() {
        ALogger.d("MultiLinkEffect.Widget", "resetTakeOverAlpha");
        List<s0> r0 = this.i;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Fq((s0) r1.next());
        goto L6
    L10:
        return;
    }

    public final void Lq() {
        SceneType r0 = this.w;
        if (r0 != SceneType.SCENE_AUDIO_TALKROOM) goto L17;
        if (isAnchor() == false) goto L11;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r1 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r1 == null) goto L33;
        tf0.o r2 = r1.commonWindowManager();
        if (r2 == null) goto L33;
        List<s0> r3 = r2.getHeadPointList();
    L34:
        ALogger.d("MultiLinkEffect.Widget", "updateHeadRenderList.headRenderList:" + this.i);
        if (r3 == null) goto L49;
        List<s0> r4 = this.i;
        if (r4 == null) goto L49;
        Intrinsics.checkNotNull(r4);
        Iterator<s0> r5 = r4.iterator();
    L40:
        if (r5.hasNext() == false) goto L49;
        s0 r6 = r5.next();
        Iterator<s0> r7 = r3.iterator();
        boolean r8 = true;
    L43:
        if (r7.hasNext() == false) goto L47;
        if (Intrinsics.areEqual(r7.next().i, r6.i) == false) goto L43;
        r8 = false;
        goto L43
    L47:
        if (r8 == false) goto L40;
        Fq(r6);
    L49:
        this.i = r3;
        return;
    L33:
        r3 = null;
        goto L34
    L11:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r9 = IVoiceChatGuestService.a.a();
        if (r9 == null) goto L33;
        tf0.o r10 = r9.commonWindowManager();
        if (r10 == null) goto L33;
        r3 = r10.getHeadPointList();
        goto L34
    L17:
        if (r0 != SceneType.SCENE_KTV) goto L22;
        IKtvService r11 = jc1.k.f(IKtvService.class);
        if (r11 == null) goto L33;
        r3 = r11.getHeadPointList();
        goto L34
    L22:
        if (isAnchor() == false) goto L28;
        rj0.k.m2.getClass();
        rj0.k r12 = rj0.k.a.a();
        if (r12 == null) goto L33;
        tf0.o r13 = r12.windowManager();
        if (r13 == null) goto L33;
        r3 = r13.getHeadPointList();
        goto L34
    L28:
        rj0.l.n2.getClass();
        rj0.l r14 = rj0.l.a.a();
        if (r14 == null) goto L33;
        tf0.o r15 = r14.windowManager();
        if (r15 == null) goto L33;
        r3 = r15.getHeadPointList();
        goto L34
    }

    public final boolean isAnchor() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return a0.d(r0, false);
    }

    public final boolean zq() {
        if (this.t == false) goto L5;
        return false;
    L5:
        ViewGroup.LayoutParams r0 = new ViewGroup.LayoutParams(-1, -1);
        LynxContainerView r2 = new LynxContainerView(((Widget) this).context, null, 6, 0);
        this.d = r2;
        this.v.addView(r2, r0);
        this.t = true;
        return true;
    }

    public final void onCreate() {
        super.onCreate();
        ALogger.i("MultiLinkEffect.Widget", "onCreate.start.instance:" + hashCode());
        Pair r0 = com.bytedance.live.datacontext.d.a(MultiLinkUniversalAnimWidget$initDataContext$pair$1.INSTANCE);
        LinkUniversalAnimContext r2 = (LinkUniversalAnimContext) r0.getFirst();
        r2.getService().d(this);
        com.bytedance.live.datacontext.b.a(r2, com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.a.class);
        this.m.add((Disposable) r0.getSecond());
        boolean r1 = zq();
        boolean r3 = true;
        if (this.u == false) goto L6;
    L9:
        boolean r4 = false;
    L11:
        if (this.f == true) goto L13;
    L15:
        VideoGiftView r6 = new VideoGiftView(((Widget) this).context);
        this.a = r6;
        r6.a(((Widget) this).context, this, false, new h(), new i());
        VideoGiftView r5 = this.a;
        if (r5 == null) goto L18;
        r5.setPlayCallback(new j());
    L18:
        this.v.addView(this.a, new ViewGroup.LayoutParams(-1, -1));
        VideoGiftView r7 = this.a;
        if (r7 == null) goto L21;
        r7.setVisibility(8);
    L21:
        this.f = true;
        boolean r8 = true;
    L23:
        if (this.w != SceneType.SCENE_VIDEO_TALKROOM) goto L47;
        boolean r9 = com.bytedance.android.live.revenue.core.util.h.a;
        ca0.i r10 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGiftRenderFilterWrapper();
        if (r10 == null) goto L44;
        com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r13 = new com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a(isAnchor(), r10, this, ((Widget) this).dataCenter, this.v);
        this.k = r13;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "onCreate");
        boolean r11 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a = false;
        DataCenter r12 = r13.g;
        if (r12 == null) goto L29;
        r12.observe("cmd_link_window_layout_config_changed", new com.bytedance.android.live.liveinteract.animation.universalwidget.effect.c(r13));
    L29:
        DataCenter r14 = r13.g;
        if (r14 == null) goto L32;
        r14.observe("cmd_trigger_update_effect_stream", new com.bytedance.android.live.liveinteract.animation.universalwidget.effect.d(r13));
    L32:
        com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r15 = this.k;
        if (r15 == null) goto L43;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "handleLinkMicStatus");
        boolean r16 = r15.c();
        if (r15.a == r16) goto L37;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "updateUseLiveCore. useLiveCore:" + r16 + ", lastUseLiveCore:" + r15.a);
        r15.b();
    L37:
        r15.a = r16;
        vc0.a r17 = r15.a();
        if (r17 != null) goto L40;
        ALogger.e("MicseatMixer#MultiLinkEffectManager", "handleLinkMicStatus", new Throwable());
        goto L43
    L40:
        ca0.i r18 = r15.e;
        if (r18 == null) goto L43;
        r18.e(r17);
    L43:
        com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r19 = this.k;
        Intrinsics.checkNotNull(r19);
        this.l = new LynxEffectJsbController(r19);
    L44:
        if (r10 != null) goto L47;
        r3 = false;
    L47:
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L50;
        r20.observe("cmd_gift_effect_is_open", this);
    L50:
        com.bytedance.live.datacontext.m r21 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCleanMode();
        if (r21 == null) goto L57;
        Observable r22 = r21.a();
        if (r22 == null) goto L57;
        Disposable r23 = r22.subscribe(new l(this));
        if (r23 == null) goto L57;
        RxUtilKt.c(r23, this.m);
    L57:
        IGameDataService r24 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r24 == null) goto L66;
        com.bytedance.live.datacontext.m r25 = r24.getClearScreen();
        if (r25 == null) goto L66;
        Observable r26 = r25.a();
        if (r26 == null) goto L66;
        Disposable r27 = r26.subscribe(new m(this));
        if (r27 == null) goto L66;
        RxUtilKt.c(r27, this.m);
    L66:
        TeamFightContext r28 = TeamFightContext.Companion.getContext();
        if (r28 == null) goto L75;
        com.bytedance.live.datacontext.m<Integer> r29 = r28.getFightStatus();
        if (r29 == null) goto L75;
        Observable r30 = r29.a();
        if (r30 == null) goto L75;
        Disposable r31 = r30.subscribe(new n(this));
        if (r31 == null) goto L75;
        RxUtilKt.c(r31, this.m);
    L75:
        CPositionContext r32 = CPositionContext.Companion.getContext();
        if (r32 == null) goto L84;
        com.bytedance.live.datacontext.m<Boolean> r33 = r32.isCPositionOpen();
        if (r33 == null) goto L84;
        Observable r34 = r33.a();
        if (r34 == null) goto L84;
        Disposable r35 = r34.subscribe(new k(this));
        if (r35 == null) goto L84;
        this.m.add(r35);
    L84:
        DataCenter r36 = ((Widget) this).dataCenter;
        if (r36 == null) goto L87;
        r36.observe("data_multi_lick_dynamic_event_change", this);
    L87:
        DataCenter r37 = ((Widget) this).dataCenter;
        if (r37 == null) goto L90;
        r37.observe("data_ktv_micseat_list", this);
    L90:
        RxUtilKt.c(Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)), this.m);
        ALogger.i("MultiLinkEffect.Widget", "onCreate.finish.instance:" + hashCode() + ",topContainerInit:" + r1 + ",bottomContainerInit:" + r4 + ",topVideoInit:" + r8 + ",renderFilterInit:" + r3);
        return;
    L13:
        if (this.a == null) goto L15;
        r8 = false;
        goto L23
    L6:
        if (Gq() == false) goto L8;
        Jq();
        this.u = true;
        r4 = true;
        goto L11
    L8:
        this.u = false;
        goto L9
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        ALogger.i("MultiLinkEffect.Widget", "onDestroy.start.instance:" + hashCode());
        yq(this, null, true, 1);
        this.m.dispose();
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L5;
        r2.removeObserver("cmd_multi_enter_room_remove_view_mock", this);
    L5:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L8;
        r3.removeObserver("data_multi_lick_dynamic_event_change", this);
    L8:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L11;
        r4.removeObserver("data_ktv_micseat_list", this);
    L11:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L14;
        r5.put("data_micseat_mix_stream_state", Boolean.FALSE);
    L14:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L17;
        r6.removeObserver("cmd_gift_effect_is_open", this);
    L17:
        ((ArrayList) this.s).clear();
        com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r7 = this.k;
        if (r7 == null) goto L20;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "onDestroy");
        r7.b();
    L20:
        this.k = null;
        this.l = null;
        this.v.removeView(this.a);
        this.v.removeView(this.d);
        FrameLayout r8 = this.c;
        if (r8 == null) goto L23;
        r8.removeAllViews();
    L23:
        this.j = false;
        this.i = null;
        ALogger.d("MultiLinkEffect.Widget", "resetCurGiftInfo");
        this.n = null;
        this.o = null;
        this.p = null;
        ALogger.i("MultiLinkEffect.Widget", "onDestroy.finish.instance:" + hashCode());
    }

    public final void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        ALogger.i("MultiLinkEffect.Widget", "onStart.instance:" + hashCode());
        yq(this, null, false, 3);
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        ALogger.i("MultiLinkEffect.Widget", "onStop.instance:" + hashCode());
        yq(this, null, false, 3);
    }

    public static void Fq(s0 r3) {
        float r0 = r3.g;
        if (r0 > 0.0f) goto L5;
        r0 = 1.0f;
    L5:
        View r1 = r3.f;
        if (r1 == null) goto L8;
        r1.setAlpha(r0);
    L8:
        Integer r2 = je0.d.h();
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.intValue() != 24) goto L31;
        boolean r4 = true;
        if (je0.d.r() == false) goto L20;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r5 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r5 != null) goto L18;
    L25:
        r4 = false;
    L26:
        if (r4 == false) goto L32;
        View r6 = r3.f;
        if (r6 == null) goto L33;
        r6.setAlpha(1.0f);
        return;
    L33:
        return;
    L32:
        return;
    L18:
        if (r5.isNewWidget() != true) goto L25;
    L20:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r7 = IVoiceChatGuestService.a.a();
        if (r7 == null) goto L25;
        if (r7.isNewWidget() != true) goto L25;
    }

    public static void Iq(View r8) {
        if (r8 == null) goto L23;
    L16:
        e = move-exception;
        ALogger.e("MultiLinkEffect.Widget", "registerKryptonServices error: " + e);
        e.printStackTrace();
        Unit r9 = Unit.INSTANCE;
        return;
    L4:
        if ((r8 instanceof LynxView) == true) goto L6;
        return;
    L6:
        Class r0 = wq();     // Catch: Exception -> L16
        Method[] r1 = r0.getDeclaredMethods();     // Catch: Exception -> L16
        int r2 = r1.length;     // Catch: Exception -> L16
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L12;
        Method r5 = r1[r4];     // Catch: Exception -> L16
        if (Intrinsics.areEqual(r5.getName(), "onLynxViewCreated") == true) goto L13;
        r4 = r4 + 1;     // Catch: Exception -> L16
    L13:
        if (r5 == null) goto L24;
        r5.invoke(Reflect.on(r0).field("INSTANCE", new Class[]{r0}).get(), new Object[]{r8});     // Catch: Exception -> L16
        return;
    L24:
        return;
    L12:
        r5 = null;
        goto L13
    }

    public final void Eq(String r4) {
        ALogger.i("MultiLinkEffect.Widget", "onAnimationFinished,reason:" + r4 + ",isIn3DAnim:" + this.j + ",curGiftInfo:" + this.p);
        this.j = false;
        Bq();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r5 = this.p;
        if (r5 == null) goto L7;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r1 = this.o;
        if (r1 == null) goto L7;
        r1.c(r5, TaskState.CANCEL);
    L7:
        ALogger.d("MultiLinkEffect.Widget", "resetCurGiftInfo");
        this.n = null;
        this.o = null;
        this.p = null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.universalwidget.a
    public final boolean Zg(String r4) {
        Intrinsics.checkNotNullParameter(r4, "id");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return this.j;
    L9:
        if (this.j == false) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r1 = this.p;
        if (r1 == null) goto L13;
        String r2 = r1.a;
    L15:
        if (Intrinsics.areEqual(r4, r2) == false) goto L17;
        return true;
    L13:
        r2 = null;
    L17:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        if (r8 == null) goto L5;
        String r1 = r8.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_multi_lick_dynamic_event_change") == false) goto L33;
        nh0.f r9 = (nh0.f) r8.getData();
        if (r9 == null) goto L54;
        ALogger.i("MultiLinkEffect.Widget", "onChanged.eventType:" + r9.a);
        if (Intrinsics.areEqual(r9.a, "dynamicIslandLayoutCompleted") == false) goto L15;
        Cq();
        return;
    L15:
        if (Intrinsics.areEqual(r9.a, "linkmic") == false) goto L18;
        yq(this, null, false, 3);
        Eq("cut_layout");
        return;
    L18:
        if (Intrinsics.areEqual(r9.a, "seat") == false) goto L26;
        if (r.a(null, 3) == true) goto L26;
        if (this.w != SceneType.SCENE_VIDEO_TALKROOM) goto L24;
        this.q.postDelayed(new o(this), 200);
    L24:
        Cq();
        return;
    L26:
        if (Intrinsics.areEqual(r9.a, "guest_list") == true) goto L28;
        return;
    L28:
        if (r.a(null, 3) == true) goto L30;
        return;
    L30:
        if (this.w != SceneType.SCENE_VIDEO_TALKROOM) goto L32;
        this.q.postDelayed(new o(this), 200);
    L32:
        Cq();
        return;
    L54:
        return;
    L33:
        if (r8 == null) goto L35;
        String r2 = r8.getKey();
    L37:
        if (Intrinsics.areEqual(r2, "data_ktv_micseat_list") == false) goto L39;
        ALogger.i("MultiLinkEffect.Widget", "onChanged.DATA_KTV_MICSEAT_LIST");
        Cq();
        return;
    L39:
        if (r8 == null) goto L41;
        String r10 = r8.getKey();
    L43:
        if (Intrinsics.areEqual(r10, "cmd_gift_effect_is_open") == false) goto L53;
        ALogger.i("MultiLinkEffect.Widget", "onChanged.CMD_GIFT_EFFECT_IS_OPEN");
        yq(this, null, false, 3);
        Eq("CMD_GIFT_EFFECT_IS_OPEN_Lynx");
        return;
    L53:
        return;
    L41:
        r10 = null;
        goto L43
    L35:
        r2 = null;
        goto L37
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.animation.universalwidget.a
    public final void y7(Function0<Unit> r2) {
        if (r2 == null) goto L5;
        ((ArrayList) this.s).remove(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.universalwidget.a
    public final void zn(Function0<Unit> r2) {
        if (r2 == null) goto L5;
        ((ArrayList) this.s).add(r2);
        return;
    }

    public MultiLinkUniversalAnimWidget(ViewGroup r2, SceneType r3) {
        Intrinsics.checkNotNullParameter(r2, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        this.v = r2;
        this.w = r3;
        this.m = new CompositeDisposable();
        this.q = new Handler(Looper.getMainLooper());
        this.s = new ArrayList();
    }

    public static final void xq(MultiLinkUniversalAnimWidget r2, boolean r3) {
        r2.getClass();
        ALogger.i("MultiLinkEffect.Widget", "notify clean mode:" + r3);
        JSONObject r4 = new JSONObject();
        r4.put("eventName", "event_flymic_clean_mode_change");
        r4.put("clean", r3 ? 1 : 0);
        jc1.k.n(IBrowserService.class).sendEventToAllJsBridges("H5_webcastNotification", r4);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.universalwidget.a
    public final void d4(int r4, int r5) {
        boolean r0 = Gq();
        ALogger.i("MultiLinkEffect.Widget", "refreshAnimWidgetRender.scene:" + r4 + ",layout:" + r5 + ",changed:" + r0);
        if (r0 == false) goto L8;
        Jq();
        FrameLayout r6 = this.c;
        if (r6 == null) goto L9;
        r6.setVisibility(8);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.universalwidget.a
    public final void Le(String r27, JsonObject r28, final oh0.a r29) {
        Intrinsics.checkNotNullParameter(r27, "type");
        Intrinsics.checkNotNullParameter(r28, "updateExtraInfo");
        Intrinsics.checkNotNullParameter(r29, "updateCallback");
        JsonElement r5 = r28.get("id");
        if (r5 == null) goto L5;
        String r6 = r5.getAsString();
    L6:
        char r9 = 0;
        if (r27.length() != 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L15;
        JsonElement r3 = r28.get("type");
        if (r3 == null) goto L14;
        String r4 = r3.getAsString();
    L16:
        ALogger.i("MultiLinkEffect.Widget", "handleLynxCmd.cmd:" + r4 + ",id:" + r6 + ",curGiftInfo:" + this.p);
        if (r4 != null) goto L20;
    L221:
        r29.a(SendInteractEffectEventResultModel.Code.Failed, "type is undefined: " + r4, null);
        return;
    L20:
        switch(r4.hashCode()) {
            case -2129517671: goto L219;
            case -1900830233: goto L201;
            case -860210598: goto L195;
            case -493590755: goto L148;
            case -162918085: goto L134;
            case -53161372: goto L76;
            case 389562333: goto L73;
            case 614073998: goto L67;
            case 915063929: goto L61;
            case 964059287: goto L58;
            case 1714591545: goto L41;
            case 1746216950: goto L35;
            case 1837478453: goto L29;
            case 2101172676: goto L23;
            default: goto L221;
        };
    L23:
        if (r4.equals("removeComposer") == false) goto L221;
        LynxEffectJsbController r8 = this.l;
        if (r8 == null) goto L27;
        r8.e(r28, r29);
        Unit r1 = Unit.INSTANCE;
        return;
    L27:
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L29:
        if (r4.equals("setMicseatMixStreamEnable") == false) goto L221;
        LynxEffectJsbController r10 = this.l;
        if (r10 == null) goto L33;
        r10.g(r28, r29);
        Unit r2 = Unit.INSTANCE;
        return;
    L33:
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L35:
        if (r4.equals("setEffectEnable") == false) goto L221;
        LynxEffectJsbController r11 = this.l;
        if (r11 == null) goto L39;
        r11.f(r28, new MultiLinkUniversalAnimWidget$handleLynxCmd$4(this, r29));
        Unit r12 = Unit.INSTANCE;
        return;
    L39:
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L41:
        if (r4.equals("stopLynx") == false) goto L221;
        if (r6 != null) goto L44;
    L47:
        boolean r13 = true;
    L48:
        if (r13 == true) goto L55;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r14 = this.p;
        if (r14 == null) goto L52;
        String r15 = r14.a;
    L54:
        if (Intrinsics.areEqual(r6, r15) == true) goto L55;
    L56:
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L52:
        r15 = null;
    L55:
        yq(this, r6, false, 2);
        Eq("normal");
        goto L56
    L44:
        if (r6.length() == 0) goto L47;
        r13 = false;
        goto L48
    L58:
        if (r4.equals("getStreamFrame") == false) goto L221;
        UtilityKotlinExtentionsKt.s(0, false, false, new MultiLinkUniversalAnimWidget$handleLynxCmd$5(this, r29), 7);
        return;
    L61:
        if (r4.equals("updateMicseatMixStream") == false) goto L221;
        LynxEffectJsbController r16 = this.l;
        if (r16 == null) goto L65;
        r16.h(r28, r29);
        Unit r17 = Unit.INSTANCE;
        return;
    L65:
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L67:
        if (r4.equals("sendEffectMessage") == false) goto L221;
        LynxEffectJsbController r18 = this.l;
        if (r18 == null) goto L71;
        r18.d(r28, r29);
        Unit r19 = Unit.INSTANCE;
        return;
    L71:
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L73:
        if (r4.equals("recoverAvatar") == false) goto L221;
        JsonObject r20 = new JsonObject();
        Kq();
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", r20);
        return;
    L76:
        if (r4.equals("getMicseatInfo") == false) goto L221;
        Lq();
        JsonObject r21 = new JsonObject();
        JsonArray r22 = new JsonArray();
        ViewGroup r23 = (ViewGroup) this.v.findViewById(2131378012);
        if (r23 == null) goto L80;
        int r24 = r23.getChildCount();
    L81:
        if (r24 <= 0) goto L83;
        View r25 = r23.getChildAt(0);
    L85:
        if (r25.getWidth() <= 0) goto L87;
        int r26 = r25.getWidth();
    L96:
        if (r25.getHeight() <= 0) goto L98;
        int r110 = r25.getHeight();
    L106:
        int[] r111 = new int[2];
        r25.getLocationOnScreen(r111);
        List<s0> r30 = this.i;
        if (r30 == null) goto L132;
        List<s0> r31 = r30;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10));
        Iterator r32 = r31.iterator();
    L110:
        if (r32.hasNext() == false) goto L127;
        s0 r113 = (s0) r32.next();
        float r114 = r113.a - r111[r9];
        float r115 = r113.b - r111[1];
        float r33 = r113.c;
        float r34 = r113.d;
        String r35 = r113.n;
        if (r2.a(r35) == true) goto L115;
        r35 = null;
    L115:
        if (r35 == null) goto L117;
        Iterator r210 = r32;
        String r211 = r35;
    L126:
        int[] r212 = r111;
        bd0.a r116 = new bd0.a(r114, r115, r33, r34, r33, r34, r211, r113.l, r113.m);
        String r36 = String.valueOf(r113.i);
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        r116.i = r36;
        String r37 = r113.j;
        Intrinsics.checkNotNullParameter(r37, "<set-?>");
        r116.j = r37;
        r116.m = r113.o;
        r112.add(r116);
        r32 = r210;
        r111 = r212;
        r9 = 0;
        goto L110
    L117:
        if (r113.e != null) goto L122;
        r210 = r32;
        if (Intrinsics.areEqual(r113.k, Boolean.TRUE) == true) goto L123;
        String r38 = "video";
    L124:
        r211 = r38;
    L123:
        r38 = "audio";
        goto L124
    L122:
        r210 = r32;
        goto L123
    L127:
        Iterator r39 = r112.iterator();
    L129:
        if (r39.hasNext() == false) goto L131;
        bd0.a r40 = (bd0.a) r39.next();
        Intrinsics.checkNotNullParameter(r40, "$this$toNormalJsonObject");
        JsonObject r41 = new JsonObject();
        r41.addProperty("view_x", Float.valueOf(r40.a));
        r41.addProperty("view_y", Float.valueOf(r40.b));
        r41.addProperty("view_z", Float.valueOf(r40.c));
        r41.addProperty("view_width", Float.valueOf(r40.d));
        r41.addProperty("view_height", Float.valueOf(r40.e));
        r41.addProperty("uid", r40.i);
        r41.addProperty("url", r40.j);
        r41.addProperty("link_type", r40.h);
        r41.addProperty("shape", r40.k);
        r41.addProperty("radius", r40.l);
        r41.addProperty("user_position", r40.m);
        r22.add(r41);
        goto L129
    L131:
        Unit r42 = Unit.INSTANCE;
    L132:
        r21.add("micseats", r22);
        r21.addProperty("screen_width", Integer.valueOf(r26));
        r21.addProperty("screen_height", Integer.valueOf(r110));
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", r21);
        ALogger.d("MultiLinkEffect.Widget", "handleLynxCmd.result:" + r21);
        return;
    L98:
        Context r117 = ((Widget) this).context;
        if (r117 == null) goto L105;
        Resources r118 = r117.getResources();
        if (r118 == null) goto L105;
        DisplayMetrics r119 = WindowDisplayMetricsOverride.apply(r118, r118.getDisplayMetrics());
        if (r119 == null) goto L105;
        r110 = r119.heightPixels;
    L105:
        r110 = 0;
        goto L106
    L87:
        Context r43 = ((Widget) this).context;
        if (r43 == null) goto L94;
        Resources r44 = r43.getResources();
        if (r44 == null) goto L94;
        DisplayMetrics r45 = WindowDisplayMetricsOverride.apply(r44, r44.getDisplayMetrics());
        if (r45 == null) goto L94;
        r26 = r45.widthPixels;
    L94:
        r26 = 0;
        goto L96
    L83:
        r25 = this.v;
        goto L85
    L80:
        r24 = 0;
        goto L81
    L134:
        if (r4.equals("hideAvatar") == false) goto L221;
        JsonObject r46 = new JsonObject();
        List<s0> r47 = this.i;
        if (r47 == null) goto L146;
        Iterator<T> r48 = r47.iterator();
    L139:
        if (r48.hasNext() == false) goto L145;
        s0 r49 = (s0) r48.next();
        if (r2.a(r49.i) == false) goto L139;
        View r50 = r49.f;
        if (r50 == null) goto L139;
        r50.setAlpha(0.0f);
        goto L139
    L145:
        Unit r51 = Unit.INSTANCE;
    L146:
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", r46);
        return;
    L148:
        if (r4.equals("playMp4") == false) goto L221;
        String r52 = r28.get("layer").getAsString();
        String r53 = r28.get("path").getAsString();
        JsonObject r54 = new JsonObject();
        if (r2.a(r53) == true) goto L152;
        r29.a(SendInteractEffectEventResultModel.Code.Failed, "", r54);
        return;
    L152:
        if (Intrinsics.areEqual(r52, "back") == false) goto L174;
        FrameLayout r55 = this.c;
        if (r55 == null) goto L156;
        r55.setVisibility(0);
    L156:
        VideoGiftView r56 = this.b;
        if (r56 == null) goto L159;
        r56.setVisibility(0);
    L159:
        VideoGiftView r57 = this.b;
        if (r57 == null) goto L165;
        PlayerController r58 = r57.a;
        if (r58 == null) goto L165;
        r58.attachAlphaView(r57);
    L165:
        VideoGiftView r59 = this.b;
        if (r59 == null) goto L171;
        PlayerController r60 = r59.a;
        if (r60 == null) goto L170;
        r60.cancel();
    L170:
        Unit r61 = Unit.INSTANCE;
    L171:
        VideoGiftView r62 = this.b;
        if (r62 == null) goto L192;
        r62.b(r53);
        Unit r63 = Unit.INSTANCE;
    L192:
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", r54);
        return;
    L174:
        VideoGiftView r65 = this.a;
        if (r65 == null) goto L177;
        r65.setVisibility(0);
    L177:
        VideoGiftView r66 = this.a;
        if (r66 == null) goto L183;
        PlayerController r67 = r66.a;
        if (r67 == null) goto L183;
        r67.attachAlphaView(r66);
    L183:
        this.g = true;
        VideoGiftView r68 = this.a;
        if (r68 == null) goto L189;
        PlayerController r69 = r68.a;
        if (r69 == null) goto L188;
        r69.cancel();
    L188:
        Unit r70 = Unit.INSTANCE;
    L189:
        VideoGiftView r71 = this.a;
        if (r71 == null) goto L192;
        r71.b(r53);
        Unit r72 = Unit.INSTANCE;
        goto L192
    L195:
        if (r4.equals("appendComposer") == false) goto L221;
        LynxEffectJsbController r73 = this.l;
        if (r73 == null) goto L199;
        r73.e(r28, r29);
        Unit r74 = Unit.INSTANCE;
        return;
    L199:
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L201:
        if (r4.equals("getInteractId") == false) goto L221;
        JsonObject r75 = r28.get("params").getAsJsonObject();
        if (r75 == null) goto L208;
        JsonElement r76 = r75.get("uid");
        if (r76 == null) goto L208;
        String r77 = r76.getAsString();
        if (r77 == null) goto L208;
    L209:
        IInteractService r78 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r78 == null) goto L212;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r79 = r78.getLinkUserInfoCenter();
    L213:
        if (r79 == null) goto L216;
        String r80 = r79.N4(r77);
        if (r80 == null) goto L216;
    L217:
        JsonObject r81 = new JsonObject();
        r81.addProperty("interactId", r80);
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", r81);
        return;
    L216:
        r80 = "";
        goto L217
    L212:
        r79 = null;
    L208:
        r77 = "";
        goto L209
    L219:
        if (r4.equals("startLynx") == false) goto L221;
        ALogger.i("MultiLinkEffect.Widget", "onAnimationStart");
        r29.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L14:
        r4 = null;
        goto L16
    L15:
        r4 = r27;
        goto L16
    L9:
        r7 = false;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public static void yq(MultiLinkUniversalAnimWidget r8, String r9, boolean r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r9 = null;
    L6:
        if ((r11 & 2) == 0) goto L8;
        boolean r6 = false;
    L9:
        r8.getClass();
        ALogger.i("MultiLinkEffect.Widget", "finishLynxAnimation.curGiftInfo:" + r8.p + ",animationId:" + r9);
        if (r9 != null) goto L12;
    L15:
        boolean r12 = true;
    L16:
        if (r12 == true) goto L23;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r13 = r8.p;
        if (r13 == null) goto L20;
        String r14 = r13.a;
    L22:
        if (Intrinsics.areEqual(r9, r14) == true) goto L23;
        return;
    L20:
        r14 = null;
    L23:
        com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r2 = r8.k;
        if (r2 == null) goto L26;
        r2.e(false, 0, "default_scene", r6, MultiLinkUniversalAnimWidget$clearVideoEffects$1.INSTANCE);
    L26:
        ka0.b r15 = r8.e;
        if (r15 == null) goto L29;
        r15.release();
    L29:
        r8.e = null;
        LynxContainerView r16 = r8.d;
        if (r16 == null) goto L32;
        r16.removeAllViews();
        r16.setVisibility(8);
    L32:
        r8.Jq();
        if (r8.g == false) goto L49;
        VideoGiftView r17 = r8.a;
        if (r17 == null) goto L37;
        r17.setVisibility(8);
    L37:
        VideoGiftView r18 = r8.a;
        if (r18 == null) goto L43;
        PlayerController r19 = r18.a;
        if (r19 == null) goto L43;
        r19.detachAlphaView(r18);
    L43:
        VideoGiftView r20 = r8.a;
        if (r20 == null) goto L48;
        PlayerController r21 = r20.a;
        if (r21 == null) goto L48;
        r21.cancel();
    L48:
        r8.g = false;
    L49:
        VideoGiftView r22 = r8.b;
        if (r22 == null) goto L52;
        r22.setVisibility(8);
    L52:
        VideoGiftView r23 = r8.b;
        if (r23 == null) goto L58;
        PlayerController r110 = r23.a;
        if (r110 == null) goto L58;
        r110.detachAlphaView(r23);
    L58:
        VideoGiftView r24 = r8.b;
        if (r24 == null) goto L63;
        PlayerController r25 = r24.a;
        if (r25 == null) goto L63;
        r25.cancel();
    L63:
        r8.Kq();
        return;
    L12:
        if (r9.length() == 0) goto L15;
        r12 = false;
        goto L16
    L8:
        r6 = r10;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.animation.universalwidget.a
    public final void m9(final com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r14, final com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r15, final com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r16, final com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r17, final String r18, final com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r19, final MultiLinkScriptInfo r20, final com.bytedance.android.live.liveinteract.animation.e r21) {
        Intrinsics.checkNotNullParameter(r15, "giftInfo");
        Intrinsics.checkNotNullParameter(r19, "positionInfo");
        Context r11 = ((Widget) this).context;
        Function0<Unit> r12 = new MultiLinkUniversalAnimWidget$startAnim$1(this, r14, r15, r16, r17, r18, r19, r20, r21);
        ArrayList r1 = new ArrayList();
        r1.add(new qh0.f.C0257f(r11, OperateType.UniversalAnimForSaas, 0, false));
        qh0.f.a(r1).a(new com.bytedance.android.live.liveinteract.animation.universalwidget.c(r12));
    }

    @Override // com.bytedance.android.live.liveinteract.animation.universalwidget.a
    public final void start3DAnim(com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r3, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r6, String r7, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r8, MultiLinkScriptInfo r9, com.bytedance.android.live.liveinteract.animation.e r10) {
        Intrinsics.checkNotNullParameter(r4, "giftInfo");
        Intrinsics.checkNotNullParameter(r8, "positionInfo");
        ALogger.i("MultiLinkEffect.Widget", "start3DAnim.invoke from service.giftInfo:" + r4);
        m9(r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
