package com.bytedance.android.live.liveinteract.hamlet;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.d2;
import com.bytedance.android.live.base.model.message.e1;
import com.bytedance.android.live.base.model.message.i3;
import com.bytedance.android.live.base.model.message.w5;
import com.bytedance.android.live.base.model.message.x5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.hamlet.api.HamletAvatarApi;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.multicamera.api.MultiCameraApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.x0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.xplay.basic.api.XplayBasicMessageType;
import com.bytedance.android.live.xplay.basic.api.XplayBasicState;
import com.bytedance.android.live.xplay.basic.api.XplayException;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.config.f7;
import com.bytedance.android.livesdk.config.ig;
import com.bytedance.android.livesdk.config.jg;
import com.bytedance.android.livesdk.config.uz;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamSycnInfoConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushMode;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.LinkMicBigEventMessage;
import com.bytedance.android.livesdk.message.model.LinkmicEcologyMessage;
import com.bytedance.android.livesdk.message.model.g9;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.BigEventAvatarConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletAvatarMockConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletExternalRenderConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletLiveMediaMockConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import j40.f4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/HamletAvatarWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lgd0/g;", "Lvlc/l;", "Lgd1/b$a;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class HamletAvatarWidget extends PlatformMultiLinkWidget implements gd0.g, vlc.l, gd1.b.a {
    public static final /* synthetic */ int T = 0;
    public boolean A;
    public MixStreamType B;
    public boolean C;
    public long D;
    public boolean E;
    public String F;
    public x0 G;
    public final Map<String, df0.a> H;
    public final y I;
    public final x J;
    public final g0 K;
    public long L;
    public long M;
    public long N;
    public final w O;
    public final h0 P;
    public final ViewGroup Q;
    public final Function0<hg6.g> R;
    public final Function0<he0.b.a> S;
    public final CompositeDisposable a;
    public com.bytedance.android.live.broadcastgame.api.xplay.f b;
    public gd1.a c;
    public gd1.b d;
    public Disposable e;
    public HamletAvatarContext f;
    public com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> g;
    public final ef0.c h;
    public gf0.d i;
    public volatile boolean j;
    public cf0.b k;
    public boolean l;
    public volatile boolean m;
    public View n;
    public com.bytedance.android.live.broadcastgame.api.xplay.basic.c o;
    public final Handler p;
    public final r q;
    public final c0 r;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g s;
    public x5 t;
    public final List<com.bytedance.android.livesdk.chatroom.model.multicamera.a> u;
    public String v;
    public LinkedList<String> w;
    public Disposable x;
    public final LiveWrappedStreamSycnInfoConfig y;
    public Disposable z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            ff0.d r0 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(2, "deleteAllExtraCamera successed", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("log_id", String.valueOf(r9.logId)), TuplesKt.to("camera_id", String.valueOf(r9))}), 12);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            ff0.d r0 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(2, "deleteAllExtraCamera failed", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("log_id", String.valueOf(ff0.c.a(r9))), TuplesKt.to("camera_id", String.valueOf(r9))}), 12);
        }
    }

    public static final class d implements gf0.a {
        public final /* synthetic */ HamletAvatarWidget a;
        public final /* synthetic */ x5 b;

        @Override // gf0.a
        public final boolean a() {
            return HamletAvatarWidget.wq(this.a);
        }

        @Override // gf0.a
        public final void b() {
            HamletAvatarWidget.xq(this.a);
        }

        @Override // gf0.a
        public final void c(long r3) {
            cf0.b r0 = this.a.k;
            if (r0 == null) goto L17;
            cf0.a<Long> r1 = r0.a;
            Long r4 = Long.valueOf(r3);
        L6:
            if (r1.b.get() < r1.c) goto L10;
            if (r1.a.poll() == null) goto L6;
            r1.b.decrementAndGet();
            goto L6
        L10:
            r1.a.offer(r4);
            r1.b.incrementAndGet();
            return;
        }

        public d(HamletAvatarWidget r1, x5 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ViewGroup a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.a.getHeight() <= 0) goto L27;
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int r0 = this.a.getHeight();
            boolean r1 = ff0.c.a;
            int r2 = Math.max((int) ((r0 * 9.0f) / 16), s1.y());
            ViewGroup r3 = this.a;
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            ViewGroup.LayoutParams r5 = null;
            if (r4 == null) goto L24;
            r4.height = r0;
            r4.width = r2;
            if (MultiLinkLoadWidgetUtils.g() == false) goto L23;
            ViewGroup r6 = this.a;
            if (r6 == null) goto L13;
            ViewGroup r7 = UtilityKotlinExtentionsKt.p(r6);
            if (r7 == null) goto L13;
            int r8 = r7.getWidth();
        L14:
            if (r8 <= 0) goto L23;
            if (r2 <= r8) goto L23;
            if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
            r5 = r4;
        L20:
            ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r5;
            if (r9 == null) goto L23;
            r9.leftMargin = (r8 - r2) / 2;
        L13:
            r8 = 0;
        L23:
            Unit r10 = Unit.INSTANCE;
        L25:
            r3.setLayoutParams(r4);
            return;
        L24:
            r4 = null;
            goto L25
        }

        public e(ViewGroup r1) {
            this.a = r1;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ int a;

        public f(int r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            ff0.d r9 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "xplay_init_callback_result", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("init_status", String.valueOf(this.a))}), 12);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ int a;

        public g(int r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            ff0.d r0 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "xplay_init_callback_result", -1, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("init_status", String.valueOf(this.a)), TuplesKt.to("log_id", ff0.c.a((Throwable) r8))}), 8);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ long a;

        public h(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            ff0.d r9 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "notifyAvatarChange", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", "success"), TuplesKt.to("avtID", String.valueOf(this.a))}), 12);
        }
    }

    public static final class i<T> implements Consumer {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final void accept(Object r8) {
            ff0.d r0 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "notifyAvatarChange", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", "failed"), TuplesKt.to("logId", String.valueOf(ff0.c.a((Throwable) r8)))}), 12);
        }
    }

    public static final class j implements gd1.c {
        public final /* synthetic */ HamletAvatarWidget a;

        public j(HamletAvatarWidget r1) {
            this.a = r1;
        }

        public final void onCloudPlayerList(List<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "players");
            ff0.d r1 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "onCloudPlayerList ", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("players", String.valueOf(GsonProtectorUtils.toJson(GsonHelper.get(), r10)))}), 12);
            Iterator<T> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            String r0 = (String) r11.next();
            HamletAvatarContext r2 = this.a.f;
            if (r2 == null) goto L8;
            boolean r3 = r2.isXplayAudioEnable();
        L9:
            gd1.a r4 = this.a.c;
            if (r4 == null) goto L4;
            r4.enableAudio(r0, r3);
            goto L4
        L8:
            r3 = false;
            goto L9
        }

        public final void a(String r2, String r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (Intrinsics.areEqual(this.a.v, r2) == false) goto L10;
            gf0.d r4 = this.a.i;
            if (r4 == null) goto L11;
            r4.a(r3);
            return;
        L11:
            return;
        }

        public final void b(String r8, com.bytedance.android.live.broadcastgame.api.xplay.b r9) {
            ff0.d r0 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "onFirstFrame ", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("playerName", String.valueOf(r8)), TuplesKt.to("cloudRtcInfo", String.valueOf(GsonProtectorUtils.toJson(GsonHelper.get(), r9)))}), 12);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ HamletAvatarWidget a;

        public k(HamletAvatarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            XplayException r12 = (XplayException) r11;
            HamletAvatarContext r0 = this.a.f;
            if (r0 == null) goto L5;
            int r1 = r0.getXplayRetryCount();
        L6:
            ff0.d r2 = ff0.d.a;
            Pair[] r3 = new Pair[3];
            if (r12 == null) goto L9;
            boolean r7 = r12.getRetryable();
        L10:
            r3[0] = TuplesKt.to("retryable", String.valueOf(r7));
            r3[1] = TuplesKt.to("retry_count", String.valueOf(r1));
            if (r12 == null) goto L15;
            gd1.d r4 = r12.getErrorInfo();
            if (r4 == null) goto L15;
            int r5 = r4.a();
        L16:
            r3[2] = TuplesKt.to("error_code", String.valueOf(r5));
            com.bytedance.android.live.liveinteract.utils.j.a(1, "game_exception", 0, null, MapsKt.mutableMapOf(r3), 12);
            if (r12 != null) goto L19;
            return;
        L19:
            if (r12.getRetryable() != true) goto L36;
            HamletAvatarWidget r13 = this.a;
            HamletAvatarContext r6 = r13.f;
            if (r6 == null) goto L23;
            int r8 = r6.getXplayRetryCount();
        L24:
            StringBuilder r9 = new StringBuilder("retryStartXplayIfCan, currentRetryCount=");
            r9.append(r8);
            r9.append(", maxCount=");
            boolean r10 = ff0.c.a;
            r9.append(vm2.d.I().getXplayMaxRetryCount());
            ALogger.i("HamletAvatar", r9.toString());
            if (r8 >= vm2.d.I().getXplayMaxRetryCount()) goto L30;
            HamletAvatarContext r14 = r13.f;
            if (r14 == null) goto L29;
            r14.setXplayRetryCount(r8 + 1);
        L29:
            r13.p.removeCallbacks(r13.r);
            r13.p.postDelayed(r13.r, ((long) (r8 + 1)) * 1000);
            return;
        L30:
            HamletAvatarContext r15 = r13.f;
            if (r15 == null) goto L33;
            r15.setXplayRetryCount(0);
        L33:
            r13.Yq(1);
            return;
        L23:
            r8 = 0;
            goto L24
        L36:
            return;
        L15:
            r5 = 0;
            goto L16
        L9:
            r7 = false;
            goto L10
        L5:
            r1 = 0;
            goto L6
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ HamletAvatarWidget a;

        public l(HamletAvatarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            XplayBasicState r10 = (XplayBasicState) r9;
            ALogger.i("HamletAvatar", "xplayStateChange, xplayState=" + r10);
            if (r10 == null) goto L43;
            int r11 = com.bytedance.android.live.liveinteract.hamlet.b.a[r10.ordinal()];
            if (r11 != 1) goto L8;
            HamletAvatarWidget r12 = this.a;
            int r1 = HamletAvatarWidget.T;
            r12.getClass();
            ff0.d r2 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "game_loading", 0, null, null, 28);
            HamletAvatarContext r13 = r12.f;
            if (r13 == null) goto L41;
            com.bytedance.live.datacontext.n<Integer> r14 = r13.getCurrentState();
            if (r14 == null) goto L42;
            r14.setValue(1);
            return;
        L42:
            return;
        L41:
            return;
        L8:
            if (r11 != 2) goto L10;
            HamletAvatarWidget r15 = this.a;
            int r3 = HamletAvatarWidget.T;
            r15.getClass();
            ff0.d r4 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "game_loaded", 0, null, null, 28);
            HamletAvatarContext r16 = r15.f;
            if (r16 == null) goto L38;
            com.bytedance.live.datacontext.n<Integer> r17 = r16.getCurrentState();
            if (r17 == null) goto L39;
            r17.setValue(2);
            return;
        L39:
            return;
        L38:
            return;
        L10:
            if (r11 != 3) goto L12;
            HamletAvatarWidget r18 = this.a;
            int r0 = HamletAvatarWidget.T;
            r18.br();
            return;
        L12:
            if (r11 != 4) goto L44;
            HamletAvatarWidget r19 = this.a;
            int r5 = HamletAvatarWidget.T;
            r19.getClass();
            ff0.d r6 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(2, "game_stopped", 0, null, null, 28);
            HamletAvatarContext r7 = r19.f;
            if (r7 == null) goto L19;
            com.bytedance.live.datacontext.n<Integer> r8 = r7.getCurrentState();
            if (r8 == null) goto L19;
            r8.setValue(4);
        L19:
            HamletAvatarContext r20 = r19.f;
            if (r20 == null) goto L22;
            boolean r21 = r20.getAudienceMultiCamera();
        L23:
            r19.Tq(r21);
            return;
        L22:
            r21 = false;
            goto L23
        L44:
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ HamletAvatarWidget a;

        public m(HamletAvatarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            com.bytedance.android.live.broadcastgame.api.xplay.g r14 = (com.bytedance.android.live.broadcastgame.api.xplay.g) r13;
            HamletAvatarWidget r0 = this.a;
            HamletAvatarContext r1 = r0.f;
            if (r1 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r2 = r1.isStreamRending();
            if (r2 == null) goto L9;
            Boolean r3 = (Boolean) r2.getValue();
            if (r3 == null) goto L9;
            boolean r4 = r3.booleanValue();
        L11:
            if (r0.m == true) goto L18;
            boolean r5 = ff0.c.a;
            if (vm2.d.J().getEnable() == false) goto L18;
            r0.m = true;
            HamletExternalRenderConfig r6 = vm2.d.J();
            ff0.d r7 = ff0.d.a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "set_video_exteral_config", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sharpness", String.valueOf(r6.getSharpness())), TuplesKt.to("contrast", String.valueOf(r6.getContrast())), TuplesKt.to("brightness", String.valueOf(r6.getBrightness()))}), 12);
            gd1.a r8 = r0.c;
            if (r8 == null) goto L18;
            r8.f(r6.getSharpness(), r6.getContrast(), r6.getBrightness());
        L18:
            if (gh0.a.d() == false) goto L27;
            if (r4 == false) goto L27;
            HamletAvatarContext r9 = r0.f;
            if (r9 == null) goto L26;
            com.bytedance.live.datacontext.m<Boolean> r10 = r9.isMultiAvatarMode();
            if (r10 == null) goto L26;
            if (((Boolean) r10.getValue()).booleanValue() == true) goto L27;
        L26:
            ef0.c r11 = r0.h;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r14, "frame");
            r11.a.a(r14);
        L27:
            String r15 = r14.b().getSEIInfo();
            if (r15 == null) goto L38;
            gf0.d r12 = r0.i;     // Catch: Exception -> L33
            if (r12 == null) goto L39;
            r12.a(r15);     // Catch: Exception -> L33
            return;
        L39:
            return;
        L33:
            e = move-exception;
            ALogger.e("HamletAvatar", "onXplaySeiProcess parse exception=" + Log.getStackTraceString(e));
            return;
        L38:
            return;
        L9:
            r4 = false;
            goto L11
        }
    }

    public static final class n<T> implements Consumer {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final void accept(Object r3) {
            ALogger.e("HamletAvatar", "onXplayVideoFrame Error, " + Log.getStackTraceString((Throwable) r3));
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ HamletAvatarWidget a;

        public o(HamletAvatarWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r5) {
            x5 r6 = ((com.bytedance.android.live.liveinteract.hamlet.model.j) ((com.bytedance.android.live.network.response.e) r5).data).a();
            if (r6 == null) goto L6;
            boolean r0 = !hd0.c.f().h();
            HamletAvatarWidget r2 = this.a;
            int r3 = HamletAvatarWidget.T;
            r2.Kq(r6, true, false, r0);
            return;
        }
    }

    public static final class p<T> implements Consumer {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public final void Bq() {
        List<com.bytedance.android.livesdk.chatroom.model.multicamera.a> r0 = this.u;
        if (r0 == null) goto L12;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L20;
        com.bytedance.android.livesdk.chatroom.model.multicamera.a r2 = (com.bytedance.android.livesdk.chatroom.model.multicamera.a) r1.next();
        if (r2 == null) goto L6;
        Long r3 = r2.getCameraId();
        if (r3 == null) goto L6;
        Cq(Long.valueOf(r3.longValue()));
        goto L6
    L20:
        return;
    }

    public final cg6.a Eq() {
        return getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    @Override // gd0.g
    public final boolean I6() {
        HamletAvatarContext r0 = HamletAvatarContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isMultiAvatarMode();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // gd0.g
    public final Long Ue() {
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Long> r1 = r0.getCurrentSelectAvatarID();
        if (r1 == null) goto L7;
        return (Long) r1.getValue();
    L7:
        return null;
    }

    @Override // gd0.g
    public final int W3() {
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isStreamRending();
        if (r1 == null) goto L12;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L12;
        LinkedList<String> r2 = this.w;
        if (r2 != null) goto L11;
        return 0;
    L11:
        return CollectionsKt.indexOf(r2, this.v);
    L12:
        dq1.a r3 = pm1.f.a();
        if (r3 != null) goto L15;
        return 0;
    L15:
        return r3.W3();
    }

    public final void br() {
        af0.a r1 = af0.a.a;
        long r2 = System.currentTimeMillis() - this.N;
        r1.getClass();
        LinkMonitorData r3 = LinkMonitorData.HamletAvatarFirstFrameDuration;     // Catch: Exception -> L5
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L5
        r4.put("duration", r2);     // Catch: Exception -> L5
        Unit r5 = Unit.INSTANCE;     // Catch: Exception -> L5
        af0.a.l(r3, r4);     // Catch: Exception -> L5
    L6:
        ff0.d r6 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "game_running", 0, null, null, 28);
        HamletAvatarContext r7 = this.f;
        if (r7 != null) goto L9;
    L13:
        gd1.a r8 = this.c;
        if (r8 == null) goto L16;
        List r9 = r8.getAllCloudPlayerRtcInfo();
    L18:
        if (r9 == null) goto L20;
        int r10 = r9.size();
    L21:
        if (r10 <= 1) goto L23;
        boolean r11 = true;
    L24:
        HamletAvatarContext r12 = this.f;
        if (r12 == null) goto L27;
        r12.setPlayerHasMultiCamera(r11);
    L27:
        Tq(r11);
        HamletAvatarContext r13 = this.f;
        if (r13 == null) goto L30;
        r13.setXplayRetryCount(0);
    L30:
        HamletAvatarContext r14 = this.f;
        if (r14 == null) goto L35;
        com.bytedance.live.datacontext.n<Integer> r15 = r14.getCurrentState();
        if (r15 == null) goto L35;
        r15.setValue(3);
    L35:
        HamletAvatarContext r16 = this.f;
        if (r16 == null) goto L40;
        com.bytedance.live.datacontext.m<Boolean> r17 = r16.isStreamRending();
        if (r17 == null) goto L40;
        r17.setValue(Boolean.TRUE);
    L40:
        HamletAvatarContext r18 = this.f;
        if (r18 == null) goto L47;
        Map<Long, Float> r19 = r18.getDownloadAvatarProgressRecord();
        if (r19 == null) goto L47;
        Set<Long> r20 = r19.keySet();
        if (r20 == null) goto L47;
        List<Long> r21 = CollectionsKt.toList(r20);
    L48:
        StringBuilder r22 = new StringBuilder("preloadAllAvatar, avatarIds is empty : ");
        if (r21 != null) goto L51;
    L53:
        boolean r23 = false;
    L54:
        r22.append(r23);
        ALogger.i("HamletAvatar", r22.toString());
        if (r21 != null) goto L57;
    L59:
        gd1.a r24 = this.c;
        if (r24 == null) goto L69;
        View r25 = r24.K();
        if (r25 == null) goto L69;
        ViewGroup r26 = this.Q;
        if (r26 == null) goto L66;
        r26.removeAllViews();
    L66:
        ViewGroup r27 = this.Q;
        if (r27 == null) goto L69;
        r27.addView(r25, new ViewGroup.LayoutParams(-1, -1));
    L69:
        int r28 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) this).dataCenter).c();
        if (gh0.a.d() == false) goto L133;
        HamletAvatarContext r29 = this.f;
        if (r29 == null) goto L76;
        com.bytedance.live.datacontext.n<JSONArray> r30 = r29.getVideoSimulcastJSONArray();
        if (r30 == null) goto L76;
        JSONArray r31 = (JSONArray) r30.getValue();
    L77:
        HamletAvatarContext r32 = this.f;
        if (r32 == null) goto L82;
        com.bytedance.live.datacontext.m<Long> r33 = r32.getVideoSimulcastIndex();
        if (r33 == null) goto L82;
        Long r34 = (Long) r33.getValue();
    L83:
        Integer r35 = -1;
        if (r31 == null) goto L94;
        if (r34 == null) goto L94;
        if (r34.longValue() < 0) goto L94;
        if (r34.longValue() >= r31.length()) goto L94;
        gd1.a r36 = this.c;
        if (r36 == null) goto L93;
        r35 = Integer.valueOf(r36.switchRemoteSimulcastStreamType((int) r34.longValue()));
        goto L94
    L93:
        r35 = null;
    L94:
        StringBuilder r110 = new StringBuilder("onXplayStart videoSimulcastJsonArray.length=");
        if (r31 == null) goto L97;
        Integer r37 = Integer.valueOf(r31.length());
    L98:
        r110.append(r37);
        r110.append(" videoSimulcastIndex=");
        r110.append(r34);
        r110.append(" switchRemoteSimulcastResult=");
        r110.append(r35);
        ALogger.i("HamletAvatar", r110.toString());
        HamletAvatarContext r38 = this.f;
        if (r38 == null) goto L131;
        com.bytedance.live.datacontext.m<Boolean> r39 = r38.isMultiAvatarMode();
        if (r39 == null) goto L131;
        if (((Boolean) r39.getValue()).booleanValue() != true) goto L131;
        ArrayList r40 = new ArrayList();
        if (r9 == null) goto L124;
        Iterator r41 = r9.iterator();
    L109:
        if (r41.hasNext() == false) goto L124;
        com.bytedance.android.live.broadcastgame.api.xplay.b r42 = (com.bytedance.android.live.broadcastgame.api.xplay.b) r41.next();
        x0 r43 = new x0(0);
        r43.d(r42.b);
        r43.e(r42.c);
        int r44 = bg0.a.a;
        String r45 = r42.a;
        if (r45 != null) goto L113;
    L115:
        boolean r46 = false;
    L116:
        r43.c(!r46);
        r40.add(r43);
        String r47 = r42.a;
        if (r47 != null) goto L119;
    L121:
        boolean r48 = false;
    L122:
        if (r48 == true) goto L109;
        this.G = r43;
        goto L109
    L119:
        if (StringsKt.endsWith$default(r47, "_main", false, 2, null) != true) goto L121;
        r48 = true;
        goto L122
    L113:
        if (StringsKt.endsWith$default(r45, "_main", false, 2, null) != true) goto L115;
        r46 = true;
    L124:
        long r49 = je0.d.a0();
        String r50 = GsonProtectorUtils.toJson(GsonHelper.get(), r40);
        ff0.d r51 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "genOrderSingStreamInfo start", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("rtcInfosParam", String.valueOf(r50))}), 12);
        af0.a.a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarMainPublicStreamCreateStart);
        if (r40.size() <= 1) goto L127;
        af0.a.m(LinkMonitorData.HamletAvatarSubPublicStreamCreateStart);
    L127:
        Disposable r52 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).orderSingGenStreamInfo(Long.valueOf(r49), r50).compose(RxUtil.rxSchedulerHelper()).subscribe(u.a, v.a);
        if (r52 == null) goto L130;
        RxUtilKt.c(r52, this.a);
    L130:
        com.bytedance.android.live.liveinteract.utils.j.a(1, "startAudienceSeiSendTask", 0, null, null, 28);
        boolean r53 = ff0.c.a;
        this.z = du2.a.b(0, vm2.d.I().getAudienceSeiSendInterval(), TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe(new e0(this));
    L132:
        Yq(0);
    L131:
        Nq("onXplayHamletRunning");
        goto L132
    L97:
        r37 = null;
    L82:
        r34 = null;
    L76:
        r31 = null;
    L133:
        Wq(true);
        return;
    L57:
        if ((!r21.isEmpty()) == false) goto L59;
        int r54 = ff0.e.a;
        Intrinsics.checkNotNullParameter(r21, "allAvatarIds");
        com.bytedance.android.live.liveinteract.hamlet.model.u r55 = new com.bytedance.android.live.liveinteract.hamlet.model.u();
        r55.b(r21);
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r55), null);
        goto L59
    L51:
        if ((!r21.isEmpty()) == false) goto L53;
        r23 = true;
    L47:
        r21 = null;
        goto L48
    L23:
        r11 = false;
        goto L24
    L20:
        r10 = 0;
        goto L21
    L16:
        r9 = null;
        goto L18
    L9:
        if (r7.isXplayAudioEnable() != true) goto L13;
        ILivePlayerClient r56 = hs0.a.b.getCurrentClient();
        if (r56 == null) goto L13;
        r56.mute("HamletAvatarWidget.onXplayHamletRunning");
        goto L13
    }

    public final void cr() {
        com.bytedance.android.live.broadcastgame.api.xplay.f r0 = this.b;
        Disposable r1 = null;
        if (r0 == null) goto L5;
        gd1.a r2 = (gd1.a) r0.getService(gd1.a.class);
    L6:
        this.c = r2;
        if (r2 == null) goto L9;
        r2.d(new j(this));
    L9:
        gd1.a r3 = this.c;
        if (r3 == null) goto L16;
        Observable r4 = r3.h();
        if (r4 == null) goto L16;
        Disposable r5 = r4.subscribe(new k(this));
        if (r5 == null) goto L16;
        RxUtilKt.c(r5, this.a);
    L16:
        gd1.a r6 = this.c;
        if (r6 == null) goto L23;
        Observable r7 = r6.g();
        if (r7 == null) goto L23;
        Disposable r8 = r7.subscribe(new l(this));
        if (r8 == null) goto L23;
        RxUtilKt.c(r8, this.a);
    L23:
        com.bytedance.android.live.broadcastgame.api.xplay.f r9 = this.b;
        if (r9 == null) goto L26;
        gd1.b r10 = (gd1.b) r9.getService(gd1.b.class);
    L27:
        this.d = r10;
        if (r10 == null) goto L30;
        r10.a(XplayBasicMessageType.Orser_Song_Message, this);
    L30:
        gd1.a r11 = this.c;
        if (r11 == null) goto L37;
        Observable r12 = r11.c();
        if (r12 == null) goto L37;
        Disposable r13 = r12.subscribe(new m(this), n.a);
        if (r13 == null) goto L37;
        RxUtilKt.c(r13, this.a);
        r1 = r13;
    L37:
        this.e = r1;
        return;
    L26:
        r10 = null;
        goto L27
    L5:
        r2 = null;
        goto L6
    }

    public final void dr() {
        if (this.B != MixStreamType.SERVER_MIX) goto L5;
    L35:
        StringBuilder r0 = new StringBuilder();
        Iterator r1 = ((LinkedHashMap) this.H).keySet().iterator();
    L37:
        if (r1.hasNext() == false) goto L48;
        String r3 = (String) r1.next();
        Function0<hg6.g> r4 = this.R;
        if (r4 == null) goto L47;
        hg6.g r5 = (hg6.g) r4.invoke();
        if (r5 == null) goto L47;
        ei6.a r6 = r5.V0();
        if (r6 == null) goto L47;
        ti6.d r7 = r6.p();
        if (r7 == null) goto L47;
        r7.b(r3, this + " stopAllExtraMixerTask");
    L47:
        r0.append("," + r3);
        goto L37
    L48:
        ff0.d r2 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "stopAllExtraMixerTask", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("all_tasks", String.valueOf(r0))}), 12);
        Map<String, df0.a> r8 = this.H;
        if (r8 == null) goto L51;
        ((LinkedHashMap) r8).clear();
    L51:
        Bq();
        return;
    L5:
        if (this.E == false) goto L15;
        Function0<hg6.g> r9 = this.R;
        if (r9 == null) goto L15;
        hg6.g r10 = (hg6.g) r9.invoke();
        if (r10 == null) goto L15;
        ei6.a r11 = r10.V0();
        if (r11 == null) goto L15;
        fi6.a r12 = r11.g();
        if (r12 == null) goto L15;
        r12.p = false;
    L15:
        MixStreamType r13 = this.B;
        if (r13 == null) goto L26;
        Function0<hg6.g> r14 = this.R;
        if (r14 == null) goto L26;
        hg6.g r15 = (hg6.g) r14.invoke();
        if (r15 == null) goto L26;
        ei6.a r16 = r15.V0();
        if (r16 == null) goto L26;
        ti6.d r17 = r16.p();
        if (r17 == null) goto L26;
        r17.m(r13);
    L26:
        Function0<hg6.g> r18 = this.R;
        if (r18 == null) goto L35;
        hg6.g r19 = (hg6.g) r18.invoke();
        if (r19 == null) goto L35;
        ei6.a r20 = r19.V0();
        if (r20 == null) goto L35;
        vi6.a r21 = r20.v();
        if (r21 == null) goto L35;
        r21.f();
        goto L35
    }

    public final void gr() {
        ALogger.i("HamletAvatar", "stopCheckAudioDelay");
        cf0.b r0 = this.k;
        if (r0 == null) goto L5;
        cf0.a<Long> r1 = r0.a;
        r1.a.clear();
        r1.b.set(0);
    L5:
        this.j = false;
        this.p.removeCallbacks(this.q);
        hr(-1);
    }

    @Override // gd0.g
    public final boolean ib() {
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isStreamRending();
        if (r1 == null) goto L11;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
        HamletAvatarContext r2 = this.f;
        if (r2 != null) goto L16;
        return false;
    L16:
        return r2.getPlayerHasMultiCamera();
    L11:
        HamletAvatarContext r3 = this.f;
        if (r3 != null) goto L14;
        return false;
    L14:
        return r3.getAudienceMultiCamera();
    }

    @Override // gd0.g
    public final boolean kl() {
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isAvatarRending();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        gd0.i r2 = r0.getInteractFloatWindowService();
        if (r2 == null) goto L9;
        if (((com.bytedance.android.live.liveinteract.service.g) r2).b() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L18;
        cg6.a r4 = Eq();
        if (r4 == null) goto L18;
        hg6.g r5 = r4.getRtcManager();
        if (r5 == null) goto L18;
        if (r5.A() != true) goto L18;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L54;
        HamletAvatarContext r7 = this.f;
        if (r7 == null) goto L32;
        com.bytedance.live.datacontext.n<Long> r8 = r7.getCurrentSelectAvatarID();
        if (r8 == null) goto L32;
        Long r9 = (Long) r8.getValue();
        if (r9 == null) goto L32;
        long r10 = r9.longValue();
        x5 r11 = this.t;
        if (r11 == null) goto L32;
        w5 r12 = r11.getHamletAvatarInit();
        if (r12 == null) goto L32;
        r12.setAvatarId(r10);
    L32:
        String r13 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().F = this.t;
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a r14 = new com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a();
        r14.b = this.b;
        HamletAvatarContext r15 = this.f;
        if (r15 == null) goto L37;
        com.bytedance.live.datacontext.m<Boolean> r16 = r15.isMultiAvatarMode();
        if (r16 == null) goto L37;
        Boolean r17 = (Boolean) r16.getValue();
    L38:
        r14.a = r17;
        HamletAvatarContext r18 = this.f;
        if (r18 == null) goto L43;
        com.bytedance.live.datacontext.n<Long> r19 = r18.getCurrentSelectAnimationIndex();
        if (r19 == null) goto L43;
        Long r20 = (Long) r19.getValue();
    L44:
        r14.c = r20;
        LinkmicOnlineFloatWindowManager.c.a().G = r14;
        gd1.a r21 = this.c;
        if (r21 == null) goto L55;
        View r22 = r21.K();
        if (r22 == null) goto L55;
        ViewParent r23 = r22.getParent();
        if ((r23 instanceof ViewGroup) == true) goto L51;
        r23 = null;
    L51:
        ViewGroup r24 = (ViewGroup) r23;
        if (r24 == null) goto L55;
        r24.removeView(r22);
    L55:
        HamletAvatarContext r25 = this.f;
        if (r25 == null) goto L62;
        com.bytedance.live.datacontext.m<Boolean> r26 = r25.isMultiAvatarMode();
        if (r26 == null) goto L62;
        if (((Boolean) r26.getValue()).booleanValue() != true) goto L62;
        boolean r27 = true;
    L63:
        this.f = null;
        if (r6 == false) goto L66;
        if (r27 == false) goto L66;
    L67:
        Aq("widget destroy", r1);
        super.onDestroy();
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r28 = this.s;
        if (r28 == null) goto L72;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r29 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r29 == null) goto L72;
        r29.d1(r28);
    L72:
        com.bytedance.android.livesdk.chatroom.t r30 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r30 == null) goto L77;
        com.bytedance.live.datacontext.j r31 = r30.getMessageManager();
        if (r31 == null) goto L77;
        r31.c(new AnonymousClass3(this));
    L77:
        cg6.a r32 = Eq();
        if (r32 == null) goto L82;
        vb6.g r33 = r32.O5();
        if (r33 == null) goto L82;
        r33.a1(this.O);
    L82:
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.b.f(this.P);
        this.a.dispose();
        gr();
        this.p.removeCallbacksAndMessages(null);
        cg6.a r34 = Eq();
        if (r34 == null) goto L88;
        vb6.g r35 = r34.O5();
        if (r35 == null) goto L89;
        r35.a1(this.O);
        return;
    L89:
        return;
    L88:
        return;
    L66:
        r1 = true;
    L62:
        r27 = false;
    L43:
        r20 = null;
    L37:
        r17 = null;
        goto L38
    L54:
        String r36 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().F = null;
        LinkmicOnlineFloatWindowManager.c.a().G = null;
    L18:
        r6 = false;
    L9:
        r3 = false;
        goto L10
    }

    @Override // gd0.g
    public final void switchCamera() {
        ALogger.i("HamletAvatar", "switchCamera");
        ff0.d r0 = ff0.d.a;
        boolean r7 = false;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "switchCamera", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("current_camera_index", String.valueOf(W3()))}), 12);
        long r1 = System.currentTimeMillis();
        long r2 = this.D;
        if (r2 > 0) goto L5;
    L8:
        this.D = r1;
        af0.a.a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarSwitchCameraStart);
        final long r3 = System.currentTimeMillis();
        HamletAvatarContext r4 = this.f;
        if (r4 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.isStreamRending();
        if (r5 == null) goto L15;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L15;
        r7 = r6.booleanValue();
    L15:
        if (r7 == false) goto L19;
        gd1.a r8 = this.c;
        if (r8 == null) goto L24;
        r8.a(new AnonymousClass1(this, r3));
        return;
    L24:
        return;
    L19:
        dq1.a r9 = pm1.f.a();
        if (r9 == null) goto L22;
        dq1.a.a.a(r9, null, null, false, null, Boolean.FALSE, 15);
    L22:
        ar();
        return;
    L5:
        if ((r1 - r2) >= 1000) goto L8;
        f2.b(2131917321, 0);
    }

    @Override // gd0.g
    public final boolean yd() {
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isStreamRending();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    public final void zq() {
        cf0.b r0 = this.k;
        if (r0 == null) goto L17;
        int r1 = r0.a.b.get();
        if (r1 <= 0) goto L11;
        Iterator<Long> r2 = r0.a.a.iterator();
        long r4 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r4 = r4 + r2.next().longValue();
        goto L8
    L10:
        long r5 = r4 / ((long) r1);
    L13:
        if (r5 <= 0) goto L18;
        hr(r5);
        return;
    L18:
        return;
    L11:
        r5 = 0;
        goto L13
    }

    @Override // gd0.g
    public final void a7() {
        Disposable r0 = ((HamletAvatarApi) com.bytedance.android.live.network.c.b().e(HamletAvatarApi.class)).getXplayInitInfo(lu2.c.f(((Widget) this).dataCenter).getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new o(this), p.a);
        if (r0 == null) goto L6;
        RxUtilKt.c(r0, this.a);
        return;
    }

    public final void ar() {
        if (W3() <= 0) goto L5;
        Sq(false, false);
        return;
    L5:
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isAvatarRending();
        if (r1 == null) goto L12;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L12;
        boolean r3 = r2.booleanValue();
    L13:
        HamletAvatarContext r4 = this.f;
        if (r4 == null) goto L20;
        com.bytedance.live.datacontext.m<Integer> r5 = r4.getDirecting();
        if (r5 == null) goto L20;
        Integer r6 = (Integer) r5.getValue();
        if (r6 == null) goto L20;
        int r7 = r6.intValue();
    L21:
        boolean r8 = true;
        if (r7 <= 0) goto L24;
        boolean r9 = true;
    L25:
        if (r3 == true) goto L28;
        if (r9 == true) goto L28;
    L29:
        Sq(r8, mg(0));
        return;
    L28:
        r8 = false;
        goto L29
    L24:
        r9 = false;
    L20:
        r7 = 0;
    L12:
        r3 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return je0.d.f();
    }

    public final void jr() {
        this.L = System.currentTimeMillis();
        Function0<hg6.g> r0 = this.R;
        fi6.a r1 = null;
        if (r0 == null) goto L11;
        hg6.g r2 = (hg6.g) r0.invoke();
        if (r2 == null) goto L11;
        ei6.a r3 = r2.V0();
        if (r3 == null) goto L11;
        fi6.a r4 = r3.g();
        if (r4 == null) goto L11;
        MixStreamType r5 = r4.U;
    L12:
        this.B = r5;
        ff0.d r6 = ff0.d.a;
        Pair[] r7 = new Pair[2];
        r7[0] = TuplesKt.to("lastMixType", String.valueOf(r5));
        Function0<hg6.g> r8 = this.R;
        if (r8 == null) goto L17;
        hg6.g r9 = (hg6.g) r8.invoke();
        if (r9 == null) goto L17;
        ei6.a r10 = r9.V0();
    L18:
        r7[1] = TuplesKt.to("client", String.valueOf(r10));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "switchMainToServerMix", 0, null, MapsKt.mutableMapOf(r7), 12);
        MixStreamType r11 = this.B;
        MixStreamType r12 = MixStreamType.SERVER_MIX;
        if (r11 == r12) goto L53;
        af0.a.a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarMainMixerSwitchStart);
        if (((Boolean) f7.a.getValue()).booleanValue() == false) goto L34;
        Function0<hg6.g> r13 = this.R;
        if (r13 == null) goto L29;
        hg6.g r14 = (hg6.g) r13.invoke();
        if (r14 == null) goto L29;
        ei6.a r15 = r14.V0();
        if (r15 == null) goto L29;
        r1 = r15.g();
    L29:
        if (r1 == null) goto L31;
        r1.p = true;
    L31:
        if (r1 == null) goto L33;
        LiveWrappedMixedStreamPushMode r16 = LiveWrappedMixedStreamPushMode.ON_START_REQUEST;
        Intrinsics.checkNotNullParameter(r16, "mTargetPushStreamMode");
        r1.q = r16;
    L33:
        this.E = true;
    L34:
        Function0<hg6.g> r17 = this.R;
        if (r17 == null) goto L43;
        hg6.g r18 = (hg6.g) r17.invoke();
        if (r18 == null) goto L43;
        ei6.a r19 = r18.V0();
        if (r19 == null) goto L43;
        ti6.d r20 = r19.p();
        if (r20 == null) goto L43;
        r20.m(r12);
    L43:
        Function0<hg6.g> r21 = this.R;
        if (r21 == null) goto L54;
        hg6.g r22 = (hg6.g) r21.invoke();
        if (r22 == null) goto L55;
        ei6.a r23 = r22.V0();
        if (r23 == null) goto L56;
        vi6.a r24 = r23.v();
        if (r24 == null) goto L57;
        r24.f();
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L17:
        r10 = null;
    L11:
        r5 = null;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r7v25, types: [com.bytedance.android.live.liveinteract.hamlet.HamletAvatarWidget$addDataChangeObserver$$inlined$let$lambda$10] */
    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        r1.c(new HamletAvatarWidget$listerMsg$1(this));
    L7:
        this.k = new cf0.b();
        LinkUserDataMergeContext.a r2 = LinkUserDataMergeContext.Companion;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r3 = LinkUserDataMergeContext.a.b(r2, ((Widget) this).dataCenter);
        if (r3 == null) goto L10;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r4 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g();
        this.s = r4;
        Intrinsics.checkNotNull(r4);
        r3.M0(r4);
    L10:
        Pair r5 = com.bytedance.live.datacontext.d.a(HamletAvatarWidget$initContext$pair$1.INSTANCE);
        HamletAvatarContext r6 = (HamletAvatarContext) r5.getFirst();
        this.f = r6;
        r6.getHamletAvatarService().d(this);
        com.bytedance.live.datacontext.b.a(r6, i0.class);
        IInteractService r7 = (IInteractService) jc1.k.f(IInteractService.class);
        Boolean r8 = null;
        if (r7 == null) goto L13;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r9 = r7.getLinkUserInfoCenter();
    L14:
        this.g = r9;
        if (r9 == null) goto L17;
        r9.Q4(this.K);
    L17:
        this.a.add((Disposable) r5.getSecond());
        cg6.a r10 = Eq();
        if (r10 == null) goto L22;
        vb6.g r11 = r10.O5();
        if (r11 == null) goto L22;
        r11.X0(this.O, true);
    L22:
        final HamletAvatarContext r12 = this.f;
        Object r13 = "";
        if (r12 == null) goto L133;
        RxUtilKt.c(Observable.combineLatest(r12.isStreamRending().a(), r12.isRtcClientInitialized().a(), r12.isMultiAvatarMode().a(), com.bytedance.android.live.liveinteract.hamlet.o.a).subscribe(new com.bytedance.android.live.liveinteract.hamlet.e(this)), this.a);
        RxUtilKt.c(Observable.combineLatest(r12.isStreamRending().a(), r12.isRtcClientInitialized().a(), r12.isSelfCPosition().a(), com.bytedance.android.live.liveinteract.hamlet.p.a).subscribe(new com.bytedance.android.live.liveinteract.hamlet.f(this)), this.a);
        if (gh0.a.d() == false) goto L33;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.liveinteract.hamlet.model.l> r14 = r12.getChestPosition();
        if (r14 == null) goto L33;
        Observable r15 = r14.a();
        if (r15 == null) goto L33;
        Disposable r16 = r15.subscribe(new com.bytedance.android.live.liveinteract.hamlet.g(this));
        if (r16 == null) goto L33;
        RxUtilKt.c(r16, this.a);
    L33:
        Observable r17 = r12.getChestPosition().a().compose(RxUtil.rxSchedulerHelper());
        if (r17 == null) goto L38;
        Disposable r18 = r17.subscribe(new com.bytedance.android.live.liveinteract.hamlet.h(this));
        if (r18 == null) goto L38;
        RxUtilKt.c(r18, this.a);
    L38:
        Observable r19 = r12.isAvatarRending().a().compose(RxUtil.rxSchedulerHelper());
        if (r19 == null) goto L43;
        Disposable r20 = r19.subscribe(new com.bytedance.android.live.liveinteract.hamlet.i(this));
        if (r20 == null) goto L43;
        RxUtilKt.c(r20, this.a);
    L43:
        com.bytedance.live.datacontext.m<Integer> r21 = r12.getDirecting();
        if (r21 == null) goto L52;
        Observable r22 = r21.a();
        if (r22 == null) goto L52;
        Observable r23 = r22.compose(RxUtil.rxSchedulerHelper());
        if (r23 == null) goto L52;
        Disposable r24 = r23.subscribe(new com.bytedance.android.live.liveinteract.hamlet.j(this));
        if (r24 == null) goto L52;
        RxUtilKt.c(r24, this.a);
    L52:
        InteractiveSongContext.a r25 = InteractiveSongContext.Companion;
        InteractiveSongContext r26 = r25.getContext();
        if (r26 == null) goto L61;
        com.bytedance.live.datacontext.m<Boolean> r27 = r26.m130isOpenInteractiveSong();
        if (r27 == null) goto L61;
        if (((Boolean) r27.getValue()).booleanValue() != true) goto L61;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r28 = this.s;
        if (r28 == null) goto L61;
        r28.d = Boolean.TRUE;
        r28.c();
    L61:
        InteractiveSongContext r29 = r25.getContext();
        if (r29 == null) goto L70;
        com.bytedance.live.datacontext.m<Boolean> r30 = r29.m130isOpenInteractiveSong();
        if (r30 == null) goto L70;
        Observable r31 = r30.a();
        if (r31 == null) goto L70;
        Disposable r32 = r31.subscribe(new com.bytedance.android.live.liveinteract.hamlet.k(this));
        if (r32 == null) goto L70;
        RxUtilKt.c(r32, this.a);
    L70:
        com.bytedance.android.livesdk.chatroom.u r33 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        com.bytedance.live.datacontext.j r34 = r33.s();
        if (r34 == null) goto L77;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r35 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r34.getValue();
        if (r35 == null) goto L77;
        BehaviorSubject r36 = r35.b();
        if (r36 == null) goto L77;
    L78:
        com.bytedance.live.datacontext.j r37 = r33.s();
        if (r37 == null) goto L85;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r38 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r37.getValue();
        if (r38 == null) goto L85;
        BehaviorSubject r39 = r38.a();
        if (r39 == null) goto L85;
    L86:
        Observable r40 = Observable.combineLatest(r36, r39, com.bytedance.android.live.liveinteract.hamlet.n.a);
        if (r40 == null) goto L92;
        Disposable r41 = r40.subscribe(new com.bytedance.android.live.liveinteract.hamlet.l(this));
        if (r41 == null) goto L92;
        RxUtilKt.c(r41, this.a);
    L92:
        if (gh0.a.d() == false) goto L101;
        com.bytedance.live.datacontext.n<Pair<Set<String>, Set<String>>> r42 = r12.getCPositionList();
        if (r42 == null) goto L101;
        Observable r43 = r42.a();
        if (r43 == null) goto L101;
        Disposable r44 = r43.subscribe(new com.bytedance.android.live.liveinteract.hamlet.m(this));
        if (r44 == null) goto L101;
        RxUtilKt.c(r44, this.a);
    L101:
        if (gh0.a.d() == true) goto L106;
        dq1.a r45 = pm1.f.a();
        if (r45 == null) goto L106;
        r45.c4(this, new HamletAvatarWidget$addDataChangeObserver$$inlined$let$lambda$10(r12, this));
    L106:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L120;
        LinkUserDataMergeContext r46 = r2.getContext(((Widget) this).dataCenter, "");
        if (r46 == null) goto L133;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.d> r47 = r46.getDataMergeCenter();
        if (r47 == null) goto L133;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r48 = (com.bytedance.android.live.liveinteract.plantform.datamerge.d) r47.getValue();
        if (r48 == null) goto L133;
        BehaviorSubject<Map<String, Boolean>> r49 = r48.j1();
        if (r49 == null) goto L133;
        Observable r50 = r49.observeOn(Schedulers.io());
        if (r50 == null) goto L133;
        Disposable r51 = r50.subscribe(new com.bytedance.android.live.liveinteract.hamlet.c(this));
        if (r51 == null) goto L133;
        RxUtilKt.c(r51, this.a);
        goto L133
    L120:
        LinkUserDataMergeContext r52 = r2.getContext(((Widget) this).dataCenter, "");
        if (r52 == null) goto L133;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.d> r53 = r52.getDataMergeCenter();
        if (r53 == null) goto L133;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r54 = (com.bytedance.android.live.liveinteract.plantform.datamerge.d) r53.getValue();
        if (r54 == null) goto L133;
        BehaviorSubject<List<ch0.e>> r55 = r54.f();
        if (r55 == null) goto L133;
        Observable r56 = r55.observeOn(Schedulers.io());
        if (r56 == null) goto L133;
        Disposable r57 = r56.subscribe(new com.bytedance.android.live.liveinteract.hamlet.d(this));
        if (r57 == null) goto L133;
        RxUtilKt.c(r57, this.a);
    L85:
        r39 = Observable.empty();
    L77:
        r36 = Observable.empty();
    L133:
        ILivePlayerClient r58 = hs0.a.b.getCurrentClient();
        if (r58 == null) goto L140;
        IRoomEventHub r59 = r58.getEventHub();
        if (r59 == null) goto L140;
        MutableLiveData r60 = r59.getFirstFrame();
        if (r60 == null) goto L140;
        r60.observe(this, new q(this));
    L140:
        z5 r61 = com.bytedance.android.live.ktv.common.util.a.a().getLinkerDetail();
        if (r61 == null) goto L147;
        List r62 = r61.getFeatureList();
        if (r62 == null) goto L147;
        if (r62.contains(1L) != true) goto L147;
        boolean r63 = true;
    L148:
        z5 r65 = com.bytedance.android.live.ktv.common.util.a.a().getLinkerDetail();
        if (r65 == null) goto L155;
        List r66 = r65.getFeatureList();
        if (r66 == null) goto L155;
        if (r66.contains(2L) != true) goto L155;
        boolean r67 = true;
    L156:
        ALogger.i("HamletAvatar", "init featureListContainHamletAvatar:" + r63);
        ff0.d r68 = ff0.d.a;
        Pair[] r69 = new Pair[1];
        Gson r110 = GsonHelper.get();
        z5 r111 = com.bytedance.android.live.ktv.common.util.a.a().getLinkerDetail();
        if (r111 == null) goto L159;
        List r112 = r111.getFeatureList();
    L160:
        r69[0] = TuplesKt.to("feature_list", GsonProtectorUtils.toJson(r110, r112));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "room enter", 0, null, MapsKt.mutableMapOf(r69), 12);
        ((Widget) this).dataCenter.put("data_hamlet_avatar_status", Boolean.valueOf(r63));
        HamletAvatarContext r70 = this.f;
        if (r70 == null) goto L165;
        com.bytedance.live.datacontext.m<Boolean> r71 = r70.isMultiAvatarMode();
        if (r71 == null) goto L165;
        r71.setValue(Boolean.valueOf(r67));
    L165:
        HamletAvatarContext r72 = this.f;
        if (r72 == null) goto L168;
        r72.setMultiAvatarModeForReport(r67);
    L168:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r73 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.m = Boolean.valueOf(r67);
        if (r67 == false) goto L173;
        ViewGroup r74 = this.Q;
        if (r74 == null) goto L173;
        r74.setVisibility(0);
    L173:
        this.l = gh0.a.d();
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b r75 = com.bytedance.android.live.broadcastgame.api.xplay.basic.b.b;
        r75.c();
        r75.a(this.P);
        HamletAvatarContext r76 = this.f;
        if (r76 == null) goto L176;
        RxUtilKt.c(Observable.combineLatest(r76.getXplyStartMessageRecived().a(), r76.isRtcClientInitialized().a(), b0.a).subscribe(new a0(this)), this.a);
    L176:
        String r77 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager r78 = LinkmicOnlineFloatWindowManager.c.a();
        if (r78 == null) goto L240;
        this.t = r78.F;
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a r79 = r78.G;
        HamletAvatarContext r80 = this.f;
        if (r80 == null) goto L186;
        com.bytedance.live.datacontext.n<Long> r81 = r80.getCurrentSelectAnimationIndex();
        if (r81 == null) goto L186;
        if (r79 == null) goto L184;
        Long r82 = r79.c;
    L185:
        r81.setValue(r82);
        goto L186
    L184:
        r82 = null;
    L186:
        String r83 = je0.d.b0();
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r84 = IVoiceChatGuestService.a.a();
        if (r84 == null) goto L206;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r85 = r84.getLinkUserInfoCenter();
        if (r85 == null) goto L206;
        Iterable r86 = r85.getOnlineUserList();
        if (r86 == null) goto L206;
        Iterator r87 = r86.iterator();
    L194:
        if (r87.hasNext() == false) goto L202;
        Object r88 = r87.next();
        IBaseUser r89 = ((ILinkPlayerInfoBridge) r88).getUser();
        if (r89 == null) goto L198;
        String r90 = r89.getIdString();
    L200:
        if (Intrinsics.areEqual(r90, r83) == false) goto L194;
    L203:
        ILinkPlayerInfoBridge r91 = (ILinkPlayerInfoBridge) r88;
        if (r91 == null) goto L206;
        boolean r92 = r91.isEnlarged();
    L207:
        if (r92 == false) goto L219;
        Ref.ObjectRef r93 = new Ref.ObjectRef();
        r93.element = null;
        HamletAvatarContext r94 = this.f;
        if (r94 == null) goto L215;
        com.bytedance.live.datacontext.n<Integer> r95 = r94.getCurrentState();
        if (r95 == null) goto L215;
        Observable r96 = r95.a();
        if (r96 == null) goto L215;
        Disposable r97 = r96.subscribe(new d0(r79, r93, this));
    L216:
        r93.element = r97;
        if (r97 == null) goto L219;
        RxUtilKt.c(r97, this.a);
    L215:
        r97 = null;
    L219:
        x5 r98 = this.t;
        if (r98 == null) goto L241;
        if (r79 == null) goto L223;
        r8 = r79.a;
    L223:
        Boolean r99 = Boolean.TRUE;
        if (Intrinsics.areEqual(r8, r99) == false) goto L231;
        this.b = r79.b;
        HamletAvatarContext r100 = this.f;
        if (r100 == null) goto L230;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.getXplyStartMessageRecived();
        if (r101 == null) goto L230;
        r101.setValue(r99);
    L230:
        cr();
        Kq(r98, false, false, false);
        br();
    L232:
        ff0.d r102 = ff0.d.a;
        Pair[] r103 = new Pair[5];
        r103[0] = TuplesKt.to("init_type", String.valueOf(r98.getInitType()));
        r103[1] = TuplesKt.to("init_param", String.valueOf(r98.getInitParam()));
        r103[2] = TuplesKt.to("channel", String.valueOf(r98.getChannel()));
        r103[3] = TuplesKt.to("game_id", String.valueOf(r98.getGameId()));
        w5 r104 = r98.getHamletAvatarInit();
        if (r104 == null) goto L235;
        r13 = Long.valueOf(r104.getAvatarId());
    L235:
        r103[4] = TuplesKt.to("avatar_id", String.valueOf(r13));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "resume_from_float_window", 0, null, MapsKt.mutableMapOf(r103), 12);
        return;
    L231:
        Kq(r98, true, true, false);
        goto L232
    L241:
        return;
    L198:
        r90 = null;
        goto L200
    L202:
        r88 = null;
    L206:
        r92 = false;
        goto L207
    L240:
        return;
    L159:
        r112 = null;
    L155:
        r67 = false;
    L147:
        r63 = false;
        goto L148
    L13:
        r9 = null;
        goto L14
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.b.b(true);
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.b.b(false);
    }

    @Override // gd0.g
    public final boolean wp() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 28) goto L8;
        return true;
    }

    @Override // gd0.g
    public final String Ac() {
        return this.F;
    }

    public static void Fq(String r2) {
        com.bytedance.android.live.liveinteract.hamlet.model.a r3 = (com.bytedance.android.live.liveinteract.hamlet.model.a) GsonHelper.get().fromJson(r2, com.bytedance.android.live.liveinteract.hamlet.model.a.class);     // Catch: Exception -> L16
        Integer r0 = r3.b();     // Catch: Exception -> L16
        String r4 = r3.c();     // Catch: Exception -> L16
        if (r0 != null) goto L6;
    L8:
        if (r4 != null) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L22;
        f2.c(r4, 0);     // Catch: Exception -> L16
        return;
    L22:
        return;
    L10:
        if (r4.length() <= 0) goto L12;
        r1 = true;
        goto L13
    L6:
        if (r0.intValue() != 0) goto L8;
        return;
    L16:
        e = move-exception;
        ALogger.e("HamletAvatar", "handleActionRspMessage exception=" + Log.getStackTraceString(e));
    }

    public static void Gq(String r5) {
        boolean r0 = ff0.c.a;
        if (vm2.d.I().getHamletAppLogEnable() == true) goto L22;
        return;
    L22:
        com.bytedance.android.live.liveinteract.hamlet.model.b r6 = (com.bytedance.android.live.liveinteract.hamlet.model.b) GsonHelper.get().fromJson(r5, com.bytedance.android.live.liveinteract.hamlet.model.b.class);     // Catch: Exception -> L19
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Exception -> L19
        String r2 = r6.c();     // Catch: Exception -> L19
        if (r2 == null) goto L12;
        JSONObject r3 = new JSONObject(r2);     // Catch: Exception -> L19
        Iterator<String> r4 = r3.keys();     // Catch: Exception -> L19
        if (r4 == null) goto L12;
    L10:
        if (r4.hasNext() == false) goto L12;
        String r7 = r4.next();     // Catch: Exception -> L19
        r1.put(r7, r3.get(r7).toString());     // Catch: Exception -> L19
    L12:
        IRoom r8 = je0.d.e(null);     // Catch: Exception -> L19
        if (r8 == null) goto L16;
        String r9 = r8.getOwnerUserIdString();     // Catch: Exception -> L19
        if (r9 == null) goto L16;
    L17:
        r1.put("anchor_id", r9);     // Catch: Exception -> L19
        r1.put("live_type", "voice_live");     // Catch: Exception -> L19
        j0.l().sendLog(r6.b(), r1, new Object[]{IRoom.class, am2.x.class});     // Catch: Exception -> L19
        return;
    L16:
        r9 = "";
    L19:
        e = move-exception;
        ALogger.e("HamletAvatar", "handleAppLogMessage exception=" + Log.getStackTraceString(e));
    }

    public static final boolean wq(HamletAvatarWidget r4) {
        HamletAvatarContext r0 = r4.f;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isMultiAvatarMode();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        boolean r5 = ff0.c.a;
        if (vm2.d.I().getAudioCheckDelayEnable() == true) goto L13;
        return false;
    L13:
        if (r4.j == true) goto L25;
        cf0.b r6 = r4.k;
        if (r6 == null) goto L26;
        cf0.a<Long> r7 = r6.a;
        if (r7.b.get() < r7.c) goto L19;
        boolean r8 = true;
    L20:
        if (r8 != true) goto L27;
        if (r3 == true) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L19:
        r8 = false;
        goto L20
    L26:
        return false;
    L25:
        return false;
    L9:
        r3 = false;
        goto L10
    }

    public static final void xq(HamletAvatarWidget r3) {
        r3.getClass();
        StringBuilder r0 = new StringBuilder("startCheckAudioDelay, interval=");
        boolean r1 = ff0.c.a;
        r0.append(vm2.d.I().getAudioDelayCheckInterval());
        ALogger.i("HamletAvatar", r0.toString());
        r3.j = true;
        r3.p.removeCallbacks(r3.q);
        r3.zq();
        r3.p.postDelayed(r3.q, vm2.d.I().getAudioDelayCheckInterval());
    }

    public final void Cq(Long r5) {
        RxUtilKt.c(((MultiCameraApi) com.bytedance.android.live.network.c.b().e(MultiCameraApi.class)).updateCameraInfo(Long.valueOf(je0.d.a0()), r5, 4, 2).subscribe(b.a, c.a), this.a);
    }

    @Override // gd0.g
    public final void E7(long r3) {
        ALogger.i("HamletAvatar", "playAnimation, animationId:" + r3);
        int r0 = ff0.e.a;
        com.bytedance.android.live.liveinteract.hamlet.model.s r1 = new com.bytedance.android.live.liveinteract.hamlet.model.s();
        r1.b(Long.valueOf(r3));
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r1), null);
    }

    public final void Iq(Long r9) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r9, Ue()) == false) goto L7;
        ff0.d r0 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "current_avatar_download_failed", 0, null, null, 28);
    L8:
        HamletAvatarContext r1 = this.f;
        if (r1 == null) goto L13;
        Map<Long, Float> r2 = r1.getDownloadAvatarProgressRecord();
        if (r2 == null) goto L13;
        Float r3 = r2.put(r9, Float.valueOf(0.0f));
    L13:
        ALogger.i("HamletAvatar", "retryStartXplayIfCan, avatarId=" + r9 + ", currentSelectAvatarID=" + Ue());
        if (Intrinsics.areEqual(r9, Ue()) == false) goto L30;
        HamletAvatarContext r4 = this.f;
        if (r4 == null) goto L18;
        int r5 = r4.getAvatarLoadRetryCount();
    L19:
        boolean r6 = ff0.c.a;
        if (r5 >= vm2.d.I().getAvatarLoadRetryCount()) goto L25;
        HamletAvatarContext r7 = this.f;
        if (r7 == null) goto L24;
        r7.setAvatarLoadRetryCount(r5 + 1);
    L24:
        uc(r9.longValue());
        return;
    L25:
        HamletAvatarContext r10 = this.f;
        if (r10 == null) goto L28;
        r10.setAvatarLoadRetryCount(0);
    L28:
        f2.b(2131923217, 0);
        return;
    L18:
        r5 = 0;
        goto L19
    L30:
        return;
    L7:
        ALogger.i("HamletAvatar", "handleAvatarDownloadFailed, avatarId=" + r9);
        goto L8
    }

    @Override // gd0.g
    public final void Jf(long r3) {
        ALogger.i("HamletAvatar", "changeAnimation, animationId:" + r3);
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Long> r1 = r0.getCurrentSelectAnimationIndex();
        if (r1 == null) goto L7;
        r1.setValue(Long.valueOf(r3));
    L7:
        int r2 = ff0.e.a;
        com.bytedance.android.live.liveinteract.hamlet.model.f r4 = new com.bytedance.android.live.liveinteract.hamlet.model.f();
        r4.b(Long.valueOf(r3));
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r4), null);
    }

    public final void Jq(String r5) {
        com.bytedance.android.live.liveinteract.hamlet.model.i r6 = (com.bytedance.android.live.liveinteract.hamlet.model.i) GsonHelper.get().fromJson(r5, com.bytedance.android.live.liveinteract.hamlet.model.i.class);     // Catch: Exception -> L53
        Integer r0 = r6.a();     // Catch: Exception -> L53
        if (r0 != null) goto L6;
    L16:
        if (r0 != null) goto L19;
    L30:
        if (r0 != null) goto L33;
    L47:
        if (r0 != null) goto L50;
        return;
    L50:
        if (r0.intValue() != 10) goto L67;
        Iq(r6.b());     // Catch: Exception -> L53
        return;
    L67:
        return;
    L33:
        if (r0.intValue() != 9) goto L47;
        Long r7 = r6.b();     // Catch: Exception -> L53
        if (r7 == null) goto L62;
        HamletAvatarContext r1 = this.f;     // Catch: Exception -> L53
        if (r1 == null) goto L42;
        Map<Long, Float> r2 = r1.getDownloadAvatarProgressRecord();     // Catch: Exception -> L53
        if (r2 == null) goto L42;
        Float r3 = r2.put(r7, Float.valueOf(1.0f));     // Catch: Exception -> L53
    L42:
        Pq(r7.longValue(), 1.0f);     // Catch: Exception -> L53
        if (Intrinsics.areEqual(r7, Ue()) == false) goto L63;
        HamletAvatarContext r8 = this.f;     // Catch: Exception -> L53
        if (r8 == null) goto L64;
        r8.setAvatarLoadRetryCount(0);     // Catch: Exception -> L53
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L19:
        if (r0.intValue() != 8) goto L30;
        Long r4 = r6.b();     // Catch: Exception -> L53
        Float r9 = r6.c();     // Catch: Exception -> L53
        if (r4 == null) goto L59;
        if (r9 == null) goto L60;
        HamletAvatarContext r10 = this.f;     // Catch: Exception -> L53
        if (r10 == null) goto L29;
        Map<Long, Float> r11 = r10.getDownloadAvatarProgressRecord();     // Catch: Exception -> L53
        if (r11 == null) goto L29;
        Float r12 = r11.put(r4, r9);     // Catch: Exception -> L53
    L29:
        Pq(r4.longValue(), r9.floatValue());     // Catch: Exception -> L53
        return;
    L60:
        return;
    L59:
        return;
    L6:
        if (r0.intValue() != 7) goto L16;
        Long r13 = r6.b();     // Catch: Exception -> L53
        if (r13 == null) goto L57;
        HamletAvatarContext r14 = this.f;     // Catch: Exception -> L53
        if (r14 == null) goto L15;
        Map<Long, Float> r15 = r14.getDownloadAvatarProgressRecord();     // Catch: Exception -> L53
        if (r15 == null) goto L15;
        Float r16 = r15.put(r13, Float.valueOf(0.0f));     // Catch: Exception -> L53
    L15:
        Pq(r13.longValue(), 0.0f);     // Catch: Exception -> L53
        return;
    L57:
        return;
    L53:
        e = move-exception;
        ALogger.e("HamletAvatar", "handleAvatarDownloadMessage exception=" + Log.getStackTraceString(e));
    }

    public final void Ln(String r6) {
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        ALogger.e("HamletAvatar", "onXplayMessage, msg=" + r6);     // Catch: Exception -> L46
        int r1 = JSONObjectProtectorUtils.getInt(new JSONObject(r6), "messageID");     // Catch: Exception -> L46
        boolean r3 = true;
        if (r1 != 7) goto L6;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L17;
        Jq(r6);     // Catch: Exception -> L46
    L22:
        int r4 = ff0.e.a;     // Catch: Exception -> L46
        if (r1 != 2001) goto L25;
    L32:
        boolean r5 = true;
    L33:
        if (r5 == false) goto L36;
        fr(r6);     // Catch: Exception -> L46
    L36:
        if (r1 != 2021) goto L38;
    L43:
        if (r3 == false) goto L51;
        Fq(r6);     // Catch: Exception -> L46
        return;
    L51:
        return;
    L38:
        if (r1 == 2022) goto L43;
        if (r1 == 2003) goto L43;
        r3 = false;
        goto L43
    L25:
        if (r1 == 2002) goto L32;
        if (r1 == 2011) goto L32;
        if (r1 == 2012) goto L32;
        r5 = false;
        goto L33
    L17:
        if (r1 != 11) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        Gq(r6);     // Catch: Exception -> L46
        goto L22
    L19:
        r7 = false;
        goto L20
    L6:
        if (r1 == 8) goto L13;
        if (r1 == 9) goto L13;
        if (r1 == 10) goto L13;
        r2 = false;
    L46:
        e = move-exception;
        ALogger.e("HamletAvatar", "onXplayMessage exception=" + Log.getStackTraceString(e));
    }

    public final boolean Lq(i3 r4) {
        String r0 = r4.getRtcRoomId();
        x0 r1 = this.G;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.a();
    L7:
        if (Intrinsics.areEqual(r0, r3) == false) goto L14;
        String r5 = r4.getRtcUserId();
        x0 r6 = this.G;
        if (r6 == null) goto L12;
        r2 = r6.b();
    L12:
        if (Intrinsics.areEqual(r5, r2) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public final void Nq(String r9) {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L54;
        rj0.d r1 = r0.getCommonService();
        if (r1 == null) goto L55;
        com.bytedance.android.live.pushstream.d r2 = r1.getLiveStream();
        if (r2 == null) goto L60;
        HamletAvatarContext r3 = this.f;
        boolean r4 = false;
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r5 = r3.isRtcClientInitialized();
        if (r5 == null) goto L16;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L16;
        boolean r7 = r6.booleanValue();
    L17:
        HamletAvatarContext r8 = this.f;
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.m<Boolean> r10 = r8.isStreamRending();
        if (r10 == null) goto L25;
        Boolean r11 = (Boolean) r10.getValue();
        if (r11 == null) goto L25;
        r4 = r11.booleanValue();
    L25:
        if (gh0.a.d() == false) goto L56;
        ALogger.i("HamletAvatar", "notifyAnchorVideoPush, from=" + r9 + " isHamletStreamRending=" + r4 + ", isRtcClientInited=" + r7);
        ei6.a r12 = null;
        if (r4 == false) goto L32;
        boolean r13 = ff0.c.a;
        if (vm2.d.I().getSetLiveCoreSurfaceViewNull() == false) goto L31;
        this.n = r2.getSurfaceView();
        r2.K0(null);
    L31:
        r2.Z0(4, new uv0.a(LiveRequestSourceRole.Business, "HamletAvatarWidget.switchExtern", null));
        r2.D();
        ff0.d r14 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "switch_extern_video_capture", 0, null, null, 28);
    L38:
        if (r7 == false) goto L57;
        com.bytedance.android.live.liveinteract.plantform.base.a.g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r15 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        if (r15 == null) goto L44;
        hg6.g r16 = r15.R1();
        if (r16 == null) goto L44;
        r16.e0("hamlet avatar video frame push");
    L44:
        com.bytedance.android.live.liveinteract.plantform.base.a r17 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        if (r17 == null) goto L49;
        hg6.g r18 = r17.R1();
        if (r18 == null) goto L49;
        r12 = r18.V0();
    L49:
        if (r12 == null) goto L58;
        vi6.a r19 = r12.v();
        if (r19 == null) goto L59;
        r19.f();
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L32:
        boolean r20 = ff0.c.a;
        if (vm2.d.I().getSetLiveCoreSurfaceViewNull() == false) goto L37;
        View r21 = this.n;
        if (r21 == null) goto L37;
        r2.K0(r21);
    L37:
        r2.Z0(5, new uv0.a(LiveRequestSourceRole.Business, "HamletAvatarWidget.switchRadio", null));
        r2.D();
        ff0.d r22 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "switch_radio_video_capture", 0, null, null, 28);
        goto L38
    L56:
        return;
    L16:
        r7 = false;
        goto L17
    L60:
        return;
    L55:
        return;
    }

    @Override // gd0.g
    public final void Ph(long r5) {
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 == null) goto L12;
        Iterable r1 = r0.getOnlineUserList();
        if (r1 == null) goto L12;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        if (((ILinkPlayerInfoBridge) r4).isEnlarged() == false) goto L8;
        r2.add(r4);
    L13:
        ALogger.e("wuzhixin", "playInteractiveAnimation, animationIndex=" + r5 + ", enlargeUserList.size=" + r2.size());
        if (r2.size() >= 2) goto L16;
        f2.b(2131915117, 0);
    L16:
        int r6 = ff0.e.a;
        com.bytedance.android.live.liveinteract.hamlet.model.t r7 = new com.bytedance.android.live.liveinteract.hamlet.model.t();
        r7.b(r5);
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r7), null);
        return;
    L12:
        r2 = new ArrayList();
        goto L13
    }

    public final void Qq(int r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "action_index_change");
        JsonObject r1 = new JsonObject();
        r1.addProperty("index", Integer.valueOf(r5));
        Unit r6 = Unit.INSTANCE;
        r0.add("data", r1);
        ih0.b r7 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r7 == null) goto L6;
        r7.Dk("avatar", "avatar_event", r0, false);
        return;
    }

    public final void Rq(boolean r7) {
        JsonObject r0 = new JsonObject();
        HamletAvatarContext r1 = HamletAvatarContext.Companion.getContext();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.isStreamRending();
        if (r2 == null) goto L9;
        int r3 = 1;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L9;
    L10:
        r0.addProperty("type", "render");
        JsonObject r4 = new JsonObject();
        r4.addProperty("is_render", Boolean.valueOf(r7));
        HamletAvatarContext r8 = this.f;
        if (r8 == null) goto L18;
        com.bytedance.live.datacontext.n<Long> r9 = r8.getCurrentSelectAvatarID();
        if (r9 == null) goto L18;
        Long r10 = (Long) r9.getValue();
        if (r10 == null) goto L18;
        String r11 = String.valueOf(r10.longValue());
        if (r11 == null) goto L18;
    L19:
        r4.addProperty("avatar_id", r11);
        r4.addProperty("is_xplay_running", Integer.valueOf(r3));
        Unit r12 = Unit.INSTANCE;
        r0.add("data", r4);
        ih0.b r13 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r13 == null) goto L23;
        r13.Dk("avatar", "avatar_event", r0, false);
        return;
    L23:
        return;
    L18:
        r11 = "0";
    L9:
        r3 = 0;
        goto L10
    }

    public final void Tq(boolean r5) {
        ALogger.e("HamletAvatar", "notifyLynxMultiCameraStatus, multiCamera=" + r5 + ", trace=" + Log.getStackTraceString(new Throwable()));
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "multi_camera_status");
        JsonObject r1 = new JsonObject();
        r1.addProperty("multi_camera_status", Integer.valueOf(r5 ? 1 : 0));
        Unit r6 = Unit.INSTANCE;
        r0.add("data", r1);
        ih0.b r7 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r7 == null) goto L6;
        r7.Dk("avatar", "avatar_event", r0, false);
        return;
    }

    public final void Wq(boolean r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "xplay_first_frame_state");
        JsonObject r1 = new JsonObject();
        r1.addProperty("state", Integer.valueOf(r5 ? 1 : 0));
        Unit r6 = Unit.INSTANCE;
        r0.add("data", r1);
        ih0.b r7 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r7 == null) goto L6;
        r7.Dk("avatar", "avatar_event", r0, false);
        return;
    }

    @Override // gd0.g
    public final void Yc(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "avatarIds");
        int r0 = ff0.e.a;
        Intrinsics.checkNotNullParameter(r2, "allAvatarIds");
        com.bytedance.android.live.liveinteract.hamlet.model.u r1 = new com.bytedance.android.live.liveinteract.hamlet.model.u();
        r1.b(r2);
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r1), null);
    }

    public final void Yq(int r5) {
        long r0 = je0.d.a0();
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).xplayInitCallback(r0, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r5), new g(r5)), this.a);
    }

    public final void Zq(Integer r4) {
        if (r4 != null) goto L6;
    L8:
        boolean r5 = false;
    L9:
        HamletAvatarContext r1 = this.f;
        if (r1 == null) goto L14;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.isAvatarRending();
        if (r2 == null) goto L14;
        Boolean r3 = (Boolean) r2.getValue();
    L16:
        if ((true ^ Intrinsics.areEqual(r3, Boolean.valueOf(r5))) == false) goto L23;
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L24;
        com.bytedance.live.datacontext.m<Boolean> r6 = r0.isAvatarRending();
        if (r6 == null) goto L25;
        r6.setValue(Boolean.valueOf(r5));
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L14:
        r3 = null;
        goto L16
    L6:
        if (r4.intValue() != 1) goto L8;
        r5 = true;
        goto L9
    }

    @Override // gd0.g
    public final void eh(boolean r3) {
        ALogger.i("HamletAvatar", "changeFullBody, isFullBody:" + r3);
        int r0 = ff0.e.a;
        com.bytedance.android.live.liveinteract.hamlet.model.h r1 = new com.bytedance.android.live.liveinteract.hamlet.model.h();
        r1.b(Integer.valueOf(r3 ? 1 : 0));
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r1), null);
    }

    public final void fr(String r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "receive_xplay_msg");
        JsonObject r1 = new JsonObject();
        r1.addProperty("msg", r5);
        Unit r6 = Unit.INSTANCE;
        r0.add("data", r1);
        ih0.b r7 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r7 == null) goto L6;
        r7.Dk("avatar", "avatar_event", r0, false);
        return;
    }

    public final void hr(long r10) {
        if (r10 <= 0) goto L5;
        int r3 = 1;
    L6:
        ff0.d r0 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(r3, "delay_send_audio", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("delay_time", String.valueOf(r10))}), 12);
        Function0<hg6.g> r1 = this.R;
        if (r1 == null) goto L12;
        hg6.g r2 = (hg6.g) r1.invoke();
        if (r2 == null) goto L13;
        r2.g0(r10);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r3 = 2;
        goto L6
    }

    @Override // gd0.g
    public final boolean mg(int r5) {
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 == null) goto L12;
        Iterable r1 = r0.getOnlineUserList();
        if (r1 == null) goto L12;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r3.next();
        if (((ILinkPlayerInfoBridge) r4).isEnlarged() == false) goto L8;
        r2.add(r4);
    L14:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r5) == false) goto L28;
        ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) CollectionsKt.firstOrNull(r2);
        Boolean r7 = null;
        if (r6 == null) goto L18;
        String r8 = r6.getInteractId();
    L19:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r9 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r9 == null) goto L27;
        BehaviorSubject<Map<String, Boolean>> r10 = r9.j1();
        if (r10 == null) goto L27;
        Map r11 = (Map) r10.getValue();
        if (r11 == null) goto L27;
        r7 = (Boolean) r11.get(r8);
    L27:
        return Intrinsics.areEqual(r7, Boolean.TRUE);
    L18:
        r8 = null;
        goto L19
    L28:
        ILinkPlayerInfoBridge r12 = (ILinkPlayerInfoBridge) CollectionsKt.firstOrNull(r2);
        if (r12 != null) goto L38;
        return false;
    L38:
        return com.bytedance.android.live.liveinteract.plantform.model.n.h(r12);
    L12:
        r2 = new ArrayList();
        goto L14
    }

    public final void onMessage(tlc.d r33) {
        boolean r11 = false;
        if ((r33 instanceof g9) == false) goto L213;
        g9 r2 = (g9) r33;
        int r13 = r2.getMsg_type();
        String r14 = null;
        if (r13 == 3) goto L137;
        if (r13 == 4) goto L112;
        if (r13 != 5) goto L9;
        i3 r3 = r2.getNotifyMultiAvatarPublicStream();
        if (r3 == null) goto L274;
        HamletAvatarContext.a r4 = HamletAvatarContext.Companion;
        HamletAvatarContext r5 = r4.getContext();
        if (r5 == null) goto L43;
        com.bytedance.live.datacontext.n<Integer> r6 = r5.getCurrentState();
        if (r6 == null) goto L43;
        Integer r7 = (Integer) r6.getValue();
    L45:
        if (gh0.a.d() == false) goto L274;
        if (r7 == null) goto L274;
        if (r7.intValue() != 3) goto L274;
        String r8 = r3.getPrompt();
        if (r8 != null) goto L53;
    L55:
        boolean r9 = false;
    L56:
        if (r9 == false) goto L59;
        f2.c(r8, 0);
    L59:
        if (r3.getStatus() != 0) goto L106;
        if (TextUtils.isEmpty(r3.getMixStreamTaskId()) == false) goto L84;
        this.F = r3.getPublicStreamId();
        HamletAvatarContext r10 = this.f;
        if (r10 == null) goto L65;
        r10.setMainStreamPublicStreamReady(true);
    L65:
        Function0<hg6.g> r12 = this.R;
        if (r12 == null) goto L74;
        hg6.g r15 = (hg6.g) r12.invoke();
        if (r15 == null) goto L74;
        ei6.a r16 = r15.V0();
        if (r16 == null) goto L74;
        vi6.a r17 = r16.v();
        if (r17 == null) goto L74;
        r17.f();
    L74:
        HamletAvatarContext r18 = r4.getContext();
        if (r18 == null) goto L77;
        long r19 = r18.getPlayModeStartTs();
    L78:
        af0.a.a.getClass();
        long r20 = System.currentTimeMillis() - r19;
        LinkMonitorData r110 = LinkMonitorData.HamletAvatarOpenSuccess;     // Catch: Exception -> L266
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L266
        r111.put("duration", r20);     // Catch: Exception -> L266
        Unit r21 = Unit.INSTANCE;     // Catch: Exception -> L266
        af0.a.l(r110, r111);     // Catch: Exception -> L266
    L80:
        af0.a.a.getClass();
        long r22 = System.currentTimeMillis() - 0;
        LinkMonitorData r23 = LinkMonitorData.HamletAvatarMainPublicStreamCreateSuccess;     // Catch: Exception -> L83
        JSONObject r24 = new JSONObject();     // Catch: Exception -> L83
        r24.put("duration", r22);     // Catch: Exception -> L83
        Unit r25 = Unit.INSTANCE;     // Catch: Exception -> L83
        af0.a.l(r23, r24);     // Catch: Exception -> L83
    L97:
        ff0.d r26 = ff0.d.a;
        Pair[] r27 = new Pair[4];
        r27[0] = TuplesKt.to("targetStreamInfo_roomId", String.valueOf(r3.getRtcRoomId()));
        r27[1] = TuplesKt.to("targetStreamInfo_uid", String.valueOf(r3.getRtcUserId()));
        x0 r28 = this.G;
        if (r28 == null) goto L100;
        String r29 = r28.a();
    L101:
        r27[2] = TuplesKt.to("currentStreamInfo_roomId", String.valueOf(r29));
        x0 r30 = this.G;
        if (r30 == null) goto L104;
        r14 = r30.b();
    L104:
        r27[3] = TuplesKt.to("currentStreamInfo_uid", String.valueOf(r14));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "onMultiAvatarPublicStreamMessageRev", 0, null, MapsKt.mutableMapOf(r27), 12);
        goto L274
    L100:
        r29 = null;
        goto L101
    L77:
        r19 = 0;
        goto L78
    L84:
        af0.a.a.getClass();
        long r31 = System.currentTimeMillis() - 0;
        LinkMonitorData r32 = LinkMonitorData.HamletAvatarSubPublicStreamCreateSuccess;     // Catch: Exception -> L87
        JSONObject r34 = new JSONObject();     // Catch: Exception -> L87
        r34.put("duration", r31);     // Catch: Exception -> L87
        Unit r35 = Unit.INSTANCE;     // Catch: Exception -> L87
        af0.a.l(r32, r34);     // Catch: Exception -> L87
    L89:
        if (Lq(r3) == false) goto L97;
        Bq();
        ff0.d r36 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "createNewCamera start", 0, null, new LinkedHashMap(), 12);
        af0.a.a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarCameraCreateStart);
        long r37 = System.currentTimeMillis();
        MultiCameraApi r38 = (MultiCameraApi) com.bytedance.android.live.network.c.b().e(MultiCameraApi.class);
        IRoom r39 = je0.d.e(null);
        if (r39 == null) goto L93;
        Long r40 = Long.valueOf(r39.getRoomId());
    L94:
        Disposable r41 = r38.createCameraInfo(r40, null, 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new s(this, r37, r3), t.a);
        if (r41 == null) goto L97;
        RxUtilKt.c(r41, this.a);
        goto L97
    L93:
        r40 = null;
        goto L94
    L106:
        if (TextUtils.isEmpty(r3.getMixStreamTaskId()) == false) goto L108;
        af0.a.a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarMainPublicStreamCreateFail);
        goto L274
    L108:
        af0.a.a.getClass();
        LinkMonitorData r42 = LinkMonitorData.HamletAvatarSubPublicStreamCreateFail;     // Catch: Exception -> L267
        JSONObject r43 = new JSONObject();     // Catch: Exception -> L267
        r43.put("error_code", 0);     // Catch: Exception -> L267
        Unit r44 = Unit.INSTANCE;     // Catch: Exception -> L267
        af0.a.l(r42, r43);     // Catch: Exception -> L267
        goto L274
    L53:
        if (r8.length() <= 0) goto L55;
        r9 = true;
    L43:
        r7 = null;
    L274:
        ff0.d r45 = ff0.d.a;     // Catch: Exception -> L265
        com.bytedance.android.live.liveinteract.utils.j.a(1, "notify_multiAvatar_public_stream_msg", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("content", GsonHelper.get().toJson(r33))}), 12);     // Catch: Exception -> L265
        return;
    L310:
        return;
    L9:
        if (r13 != 100) goto L11;
        DataCenter r1 = ((Widget) this).dataCenter;
        Boolean r46 = Boolean.TRUE;
        r1.put("data_hamlet_avatar_status", r46);
        e1 r47 = r2.getHamletAvatarStartContent();
        if (r47 != null) goto L24;
        return;
    L24:
        if (r47.getMultiAvatarMode() != true) goto L283;
        HamletAvatarContext r48 = this.f;
        if (r48 == null) goto L30;
        com.bytedance.live.datacontext.m<Boolean> r49 = r48.isMultiAvatarMode();
        if (r49 == null) goto L30;
        r49.setValue(r46);
    L30:
        HamletAvatarContext r50 = this.f;
        if (r50 == null) goto L33;
        r50.setMultiAvatarModeForReport(true);
    L33:
        TalkRoomLogUtils.m = r46;
        ViewGroup r51 = this.Q;
        if (r51 == null) goto L284;
        r51.setVisibility(0);
        return;
    L284:
        return;
    L283:
        return;
    L11:
        if (r13 != 101) goto L307;
        DataCenter r52 = ((Widget) this).dataCenter;
        Boolean r53 = Boolean.FALSE;
        r52.put("data_hamlet_avatar_status", r53);
        ViewGroup r54 = this.Q;
        if (r54 == null) goto L16;
        r54.setVisibility(8);
    L16:
        HamletAvatarContext r55 = this.f;
        if (r55 == null) goto L279;
        com.bytedance.live.datacontext.m<Boolean> r56 = r55.isMultiAvatarMode();
        if (r56 == null) goto L280;
        r56.setValue(r53);
        return;
    L280:
        return;
    L279:
        return;
    L307:
        return;
    L112:
        Aq("IM from server", true);
        ff0.d r57 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "Xplay close message recieved", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg_id", String.valueOf(r33.getMessageId()))}), 12);
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r58 = this.s;
        if (r58 == null) goto L116;
        r58.b = null;
        r58.c = null;
        r58.d = null;
        r58.c();
    L116:
        if (ff0.c.b() == false) goto L127;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "disable_audio_vad_report", 0, null, null, 28);
        Function0<hg6.g> r59 = this.R;
        if (r59 == null) goto L127;
        hg6.g r60 = (hg6.g) r59.invoke();
        if (r60 == null) goto L127;
        ei6.a r61 = r60.V0();
        if (r61 == null) goto L127;
        ri6.b r62 = r61.r();
        if (r62 == null) goto L127;
        r62.q();
    L127:
        if (vm2.d.I().getAedEnable() == false) goto L286;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "disable_audio_aed_report", 0, null, null, 28);
        Function0<hg6.g> r63 = this.R;
        if (r63 == null) goto L287;
        hg6.g r65 = (hg6.g) r63.invoke();
        if (r65 == null) goto L288;
        ei6.a r66 = r65.V0();
        if (r66 == null) goto L289;
        ri6.b r67 = r66.r();
        if (r67 == null) goto L290;
        r67.x();
        return;
    L290:
        return;
    L289:
        return;
    L288:
        return;
    L287:
        return;
    L286:
        return;
    L137:
        HamletAvatarContext r112 = HamletAvatarContext.Companion.getContext();
        if (r112 == null) goto L142;
        com.bytedance.live.datacontext.n<Integer> r113 = r112.getCurrentState();
        if (r113 == null) goto L142;
        Integer r114 = (Integer) r113.getValue();
    L143:
        ff0.d r115 = ff0.d.a;
        Pair[] r116 = new Pair[11];
        x5 r210 = r2.getXplayINitContent();
        Object r211 = "";
        if (r210 == null) goto L146;
        Object r212 = Long.valueOf(r210.getInitType());
    L147:
        r116[0] = TuplesKt.to("init_type", String.valueOf(r212));
        if (r114 != null) goto L150;
        Object r68 = "";
    L151:
        r116[1] = TuplesKt.to("xplay_state", String.valueOf(r68));
        x5 r69 = r2.getXplayINitContent();
        if (r69 == null) goto L155;
        String r70 = r69.getInitParam();
        if (r70 == null) goto L155;
    L156:
        r116[2] = TuplesKt.to("init_param", r70);
        x5 r71 = r2.getXplayINitContent();
        if (r71 == null) goto L160;
        String r72 = r71.getChannel();
        if (r72 == null) goto L160;
    L161:
        r116[3] = TuplesKt.to("channel", r72);
        x5 r73 = r2.getXplayINitContent();
        if (r73 == null) goto L165;
        String r74 = r73.getGameId();
        if (r74 == null) goto L165;
    L166:
        r116[4] = TuplesKt.to("game_id", r74);
        x5 r75 = r2.getXplayINitContent();
        if (r75 == null) goto L171;
        w5 r76 = r75.getHamletAvatarInit();
        if (r76 == null) goto L171;
        Object r77 = Long.valueOf(r76.getAvatarId());
    L172:
        r116[5] = TuplesKt.to("avatar_id", String.valueOf(r77));
        x5 r78 = r2.getXplayINitContent();
        if (r78 == null) goto L177;
        w5 r79 = r78.getHamletAvatarInit();
        if (r79 == null) goto L177;
        Boolean r80 = Boolean.valueOf(r79.getMultiAvatarMode());
    L178:
        r116[6] = TuplesKt.to("multi_avatar_mode", String.valueOf(r80));
        HamletAvatarContext r81 = this.f;
        if (r81 == null) goto L183;
        com.bytedance.live.datacontext.m<Boolean> r82 = r81.isRtcClientInitialized();
        if (r82 == null) goto L183;
        Boolean r117 = (Boolean) r82.getValue();
    L184:
        r116[7] = TuplesKt.to("rtc_client_inited", String.valueOf(r117));
        r116[8] = TuplesKt.to("msg_id", String.valueOf(r33.getMessageId()));
        g9 r83 = (g9) r33;
        x5 r84 = r83.getXplayINitContent();
        if (r84 == null) goto L188;
        String r85 = r84.getVideoSimulcast();
        if (r85 == null) goto L188;
    L189:
        r116[9] = TuplesKt.to("video_simulcast", r85);
        x5 r86 = r83.getXplayINitContent();
        if (r86 == null) goto L192;
        r211 = Long.valueOf(r86.getVideoSimulcastIndex());
    L192:
        r116[10] = TuplesKt.to("video_simulcast_index", String.valueOf(r211));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "init_xplay_message_receive", 0, null, MapsKt.mutableMapOf(r116), 12);
        if (((BigEventAvatarConfig) ig.a.getValue()).getEnableBlockInitMsg() == false) goto L199;
        if (r114 == null) goto L199;
        if (r114.intValue() != 3) goto L199;
        return;
    L199:
        x5 r87 = r83.getXplayINitContent();
        if (r87 != null) goto L202;
        return;
    L202:
        if (r87.getInitType() != 0) goto L278;
        x5 r88 = r83.getXplayINitContent();
        if (r88 == null) goto L292;
        this.t = r88;
        Kq(r88, true, true, false);
        w5 r89 = r88.getHamletAvatarInit();
        if (r89 == null) goto L293;
        long r90 = r89.getAvatarId();
        if (r90 <= 0) goto L294;
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).notifyAvatarChange(je0.d.a0(), r90).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(r90), i.a), this.a);
        return;
    L294:
        return;
    L293:
        return;
    L292:
        return;
    L278:
        return;
    L188:
        r85 = "";
    L183:
        r117 = null;
    L177:
        r80 = null;
    L171:
        r77 = "";
    L165:
        r74 = "";
    L160:
        r72 = "";
    L155:
        r70 = "";
        goto L156
    L150:
        r68 = r114;
        goto L151
    L146:
        r212 = "";
    L142:
        r114 = null;
        goto L143
    L213:
        if ((r33 instanceof d2) == true) goto L215;
        return;
    L215:
        if (((Boolean) jg.a.getValue()).booleanValue() == true) goto L218;
        ALogger.i("HamletAvatar", "LIVE_BIG_EVENT_ENABLE_LOCAl=false messageType=" + ((d2) r33).getMsgType());
        return;
    L218:
        d2 r91 = (d2) r33;
        switch(r91.getMsgType()) {
            case 14: goto L251;
            case 15: goto L231;
            case 16: goto L221;
            default: goto L309;
        };
    L221:
        boolean r92 = ff0.c.b();
        int r93 = r91.getSwitch_avatar_vad_mode_content().getAvatarVADMode();
        ff0.d r94 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "receive_big_event_msg", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "switch_vad_status"), TuplesKt.to("vad_enable_before", String.valueOf(r92)), TuplesKt.to("to_vad_status", String.valueOf(r93))}), 12);
        if (r93 == LinkMicBigEventMessage.SwitchAvatarVADModeContent.AvatarVADMode.VADModeOn.getValue()) goto L226;
        if (r93 == LinkMicBigEventMessage.SwitchAvatarVADModeContent.AvatarVADMode.VADModeOff.getValue()) goto L226;
        return;
    L226:
        if (r93 != LinkMicBigEventMessage.SwitchAvatarVADModeContent.AvatarVADMode.VADModeOff.getValue()) goto L228;
        r11 = true;
    L228:
        ff0.c.a = r11;
        boolean r95 = ff0.c.b();
        ALogger.i("HamletAvatar", "LinkMicBigEventMessage.SwitchAvatarVADMode, vadModeByServer=" + r93 + " isVadEnableBefore=" + r92 + " isVadEnableNow=" + r95);
        if (r92 == r95) goto L298;
        int r96 = ze0.a.a;
        ff0.c.b();
        return;
    L298:
        return;
    L231:
        HamletAvatarContext r97 = this.f;
        if (r97 == null) goto L238;
        com.bytedance.live.datacontext.n<Long> r98 = r97.getCurrentSelectAvatarID();
        if (r98 == null) goto L238;
        Long r99 = (Long) r98.getValue();
        if (r99 == null) goto L238;
        long r118 = r99.longValue();
    L239:
        int r100 = r91.getSwitch_avatar_action_content().getAvatarActionType();
        long r101 = r91.getSwitch_avatar_action_content().getAvatarId();
        long r119 = r91.getSwitch_avatar_action_content().getLoopActionIndex();
        long r102 = r91.getSwitch_avatar_action_content().getSingleActionId();
        ALogger.i("HamletAvatar", "LinkMicBigEventMessage.SwitchAvatarAction, currentAvatarId:" + r118 + " toChangeActionAvatarId:" + r101 + " avatarActionType=" + r100 + " toChangeLoopActionIndex=" + r119 + " toChangeSingeActionId=" + r102);
        ff0.d r103 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "receive_big_event_msg", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "switch_avatar_act"), TuplesKt.to("avatar_id", String.valueOf(r118)), TuplesKt.to("to_avatar_id", String.valueOf(r101)), TuplesKt.to("act_type", String.valueOf(r100)), TuplesKt.to("singe_act_id", String.valueOf(r102)), TuplesKt.to("loop_act_index", String.valueOf(r119))}), 12);
        if (r118 == r101) goto L242;
        return;
    L242:
        if (r100 != LinkMicBigEventMessage.SwitchAvatarActionContent.AvatarActionType.ActionTypeLoop.getValue()) goto L247;
        if (r119 < 0) goto L247;
        Jf(r119);
        Qq((int) r119);
        return;
    L247:
        if (r100 == LinkMicBigEventMessage.SwitchAvatarActionContent.AvatarActionType.ActionTypeSingle.getValue()) goto L249;
        return;
    L249:
        if (r102 < 0) goto L303;
        E7(r102);
        return;
    L303:
        return;
    L238:
        r118 = 0;
        goto L239
    L251:
        long r104 = r91.getSwitch_avatar_content().getAvatarId();
        HamletAvatarContext r105 = this.f;
        if (r105 == null) goto L258;
        com.bytedance.live.datacontext.n<Long> r106 = r105.getCurrentSelectAvatarID();
        if (r106 == null) goto L258;
        Long r107 = (Long) r106.getValue();
        if (r107 == null) goto L258;
        long r108 = r107.longValue();
    L259:
        ALogger.i("HamletAvatar", "LinkMicBigEventMessage.SwitchAvatar, fromAvatarId:" + r108 + " toAvatarId:" + r104);
        ff0.d r109 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "receive_big_event_msg", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "switch_avatar_act"), TuplesKt.to("from_id", String.valueOf(r108)), TuplesKt.to("to_id", String.valueOf(r104))}), 12);
        if (r108 != r104) goto L262;
        return;
    L262:
        if (r104 <= 0) goto L306;
        uc(r104);
        return;
    L306:
        return;
    L258:
        r108 = 0;
        goto L259
    }

    @Override // gd0.g
    public final void tg(String r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        IInteractService r2 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: Exception -> L11
        if (r2 == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r3 = r2.getLinkUserInfoCenter();     // Catch: Exception -> L11
        if (r3 == null) goto L8;
        long r4 = r3.getLastVersion();     // Catch: Exception -> L11
    L9:
        JSONObject r5 = new JSONObject(r6);     // Catch: Exception -> L11
        r5.put("linkVersion", r4);     // Catch: Exception -> L11
        String r7 = r5.toString();     // Catch: Exception -> L11
        ALogger.e("HamletAvatar", "sendXplayMessage, msg=" + r7);     // Catch: Exception -> L11
        er(r7, null);     // Catch: Exception -> L11
        return;
    L8:
        r4 = 0;
    L11:
        e = move-exception;
        ALogger.e("HamletAvatar", "sendXplayMessage exception=" + Log.getStackTraceString(e));
    }

    @Override // gd0.g
    public final void uc(long r3) {
        ALogger.i("HamletAvatar", "changeAvatar, avatarId:" + r3);
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Long> r1 = r0.getCurrentSelectAvatarID();
        if (r1 == null) goto L7;
        r1.setValue(Long.valueOf(r3));
    L7:
        int r2 = ff0.e.a;
        com.bytedance.android.live.liveinteract.hamlet.model.g r4 = new com.bytedance.android.live.liveinteract.hamlet.model.g();
        r4.b(Long.valueOf(r3));
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r4), this.J);
    }

    @Override // gd0.g
    public final void zi(boolean r2) {
        if (r2 == false) goto L4;
        return;
    L4:
        if (hd0.c.f().h() == true) goto L14;
        HamletAvatarContext r3 = this.f;
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.isStreamRending();
        if (r4 != null) goto L10;
        return;
    L10:
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L17;
        Aq("admin changed", true);
        return;
    L17:
        return;
    L15:
        return;
    }

    public static final void yq(HamletAvatarWidget r5, boolean r6) {
        if (r5.A != r6) goto L5;
        return;
    L5:
        if (r5.W3() <= 0) goto L7;
        return;
    L7:
        if (r5.kl() == true) goto L37;
        Boolean r0 = (Boolean) ((Widget) r5).dataCenter.get("data_hamlet_avatar_status", Boolean.FALSE);
        HamletAvatarContext r1 = r5.f;
        boolean r2 = false;
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r3 = r1.isAvatarRending();
        if (r3 == null) goto L15;
        Boolean r4 = (Boolean) r3.getValue();
        if (r4 == null) goto L15;
        boolean r7 = r4.booleanValue();
    L16:
        HamletAvatarContext r8 = HamletAvatarContext.Companion.getContext();
        if (r8 == null) goto L23;
        com.bytedance.live.datacontext.m<Integer> r9 = r8.getDirecting();
        if (r9 == null) goto L23;
        Integer r10 = (Integer) r9.getValue();
        if (r10 == null) goto L23;
        int r11 = r10.intValue();
    L25:
        if (r11 <= 0) goto L27;
        boolean r12 = true;
    L29:
        if (r0.booleanValue() == false) goto L33;
        if (r7 == true) goto L33;
        if (r12 == true) goto L33;
        r2 = true;
    L33:
        r5.Sq(r2, r6);
        r5.A = r6;
        return;
    L27:
        r12 = false;
    L23:
        r11 = 0;
    L15:
        r7 = false;
        goto L16
    }

    public final void Aq(String r7, boolean r8) {
        HamletAvatarContext.a r0 = HamletAvatarContext.Companion;
        HamletAvatarContext r1 = r0.getContext();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.isMultiAvatarMode();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L9;
        boolean r4 = r3.booleanValue();
    L10:
        ALogger.i("HamletAvatar", "closeXPlay reason=" + r7 + ", isMultiAvatarMode=" + r4);
        HamletAvatarContext r5 = this.f;
        boolean r6 = true;
        if (r5 != null) goto L13;
    L17:
        this.m = false;
        gd1.b r9 = this.d;
        if (r9 == null) goto L20;
        r9.c(XplayBasicMessageType.Orser_Song_Message);
    L20:
        if (r8 == false) goto L22;
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.b.e(r7);
    L22:
        HamletAvatarContext r10 = this.f;
        if (r10 == null) goto L25;
        r10.resetXplayState();
    L25:
        int r11 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) this).dataCenter).c();
        if (r4 == true) goto L28;
        Nq("closeXPlay, reason=".concat(r7));
    L28:
        gf0.d r12 = this.i;
        if (r12 == null) goto L31;
        r12.release();
    L31:
        Disposable r13 = this.x;
        if (r13 == null) goto L34;
        r13.dispose();
    L34:
        Disposable r14 = this.z;
        if (r14 == null) goto L37;
        r14.dispose();
    L37:
        this.C = false;
        if (gh0.a.d() == false) goto L41;
        if (r4 != true) goto L71;
        dr();
        return;
    L71:
        return;
    L41:
        dq1.a r15 = pm1.f.a();
        if (r15 == null) goto L44;
        int r16 = r15.W3();
    L45:
        HamletAvatarContext r17 = r0.getContext();
        if (r17 == null) goto L52;
        com.bytedance.live.datacontext.m<Boolean> r18 = r17.isAvatarRending();
        if (r18 == null) goto L52;
        Boolean r19 = (Boolean) r18.getValue();
        if (r19 == null) goto L52;
        boolean r20 = r19.booleanValue();
    L53:
        HamletAvatarContext r21 = r0.getContext();
        if (r21 == null) goto L60;
        com.bytedance.live.datacontext.m<Integer> r22 = r21.getDirecting();
        if (r22 == null) goto L60;
        Integer r23 = (Integer) r22.getValue();
        if (r23 == null) goto L60;
        int r24 = r23.intValue();
    L61:
        if (r24 <= 0) goto L63;
        boolean r25 = true;
    L64:
        if (r16 > 0) goto L68;
        if (r20 == true) goto L68;
        if (r25 == true) goto L68;
    L69:
        Sq(r6, mg(0));
        return;
    L68:
        r6 = false;
        goto L69
    L63:
        r25 = false;
    L60:
        r24 = 0;
    L52:
        r20 = false;
        goto L53
    L44:
        r16 = 0;
        goto L45
    L13:
        if (r5.isXplayAudioEnable() != true) goto L17;
        ILivePlayerClient r26 = hs0.a.b.getCurrentClient();
        if (r26 == null) goto L17;
        r26.unmute("HamletAvatarWidget.closeXPlay");
    L9:
        r4 = false;
        goto L10
    }

    public final void Pq(long r3, float r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("avatar_id", Long.valueOf(r3));
        r0.addProperty("progress", Float.valueOf(r5));
        JsonObject r4 = new JsonObject();
        r4.addProperty("type", "avatar_progress");
        JsonObject r6 = new JsonObject();
        r6.add("avatar_progress", r0);
        Unit r7 = Unit.INSTANCE;
        r4.add("data", r6);
        ih0.b r8 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r8 == null) goto L6;
        r8.Dk("avatar", "avatar_event", r4, false);
        return;
    }

    public final void Sq(boolean r4, boolean r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "big_head");
        JsonObject r1 = new JsonObject();
        r1.addProperty("display", Boolean.valueOf(r4));
        r1.addProperty("talking", Boolean.valueOf(r5));
        Unit r6 = Unit.INSTANCE;
        r0.add("data", r1);
        ih0.b r7 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r7 == null) goto L6;
        r7.Dk("avatar", "avatar_event", r0, false);
        return;
    }

    @Override // gd0.g
    public final void Zf(boolean r5, int r6) {
        Rq(r5);
        if (r5 == true) goto L6;
        if (r6 > 0) goto L6;
        boolean r7 = true;
    L7:
        Sq(r7, mg(0));
        af0.a r8 = af0.a.a;
        long r0 = System.currentTimeMillis() - this.N;
        r8.getClass();
        LinkMonitorData r9 = LinkMonitorData.HamletAvatarFirstSeiDuration;     // Catch: Exception -> L10
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L10
        r10.put("duration", r0);     // Catch: Exception -> L10
        Unit r1 = Unit.INSTANCE;     // Catch: Exception -> L10
        af0.a.l(r9, r10);     // Catch: Exception -> L10
        return;
    L13:
        return;
    L6:
        r7 = false;
        goto L7
    }

    public final void er(String r2, gd1.b.b r3) {
        gd1.b r0 = this.d;
        if (r0 == null) goto L8;
        if (r3 != null) goto L6;
        r3 = this.I;
    L6:
        r0.d(r2, r3);
        return;
    }

    public HamletAvatarWidget(HamletInterceptTouchFrameLayout r1, Function0 r2, Function0 r3) {
        this.Q = r1;
        this.R = r2;
        this.S = r3;
        this.a = new CompositeDisposable();
        this.h = new ef0.c();
        this.p = new Handler(Looper.getMainLooper());
        this.q = new r(this);
        this.r = new c0(this);
        this.u = new ArrayList();
        this.y = new LiveWrappedStreamSycnInfoConfig(LiveWrappedStreamIndex.STREAM_INDEX_MAIN, LiveWrappedStreamSycnInfoConfig.LiveWrappedSyncInfoStreamType.SYNC_INFO_STREAM_TYPE_AUDIO);
        this.B = MixStreamType.NONE;
        this.H = new LinkedHashMap();
        this.I = new y();
        this.J = new x(this);
        this.K = new g0(this);
        this.O = new w(this);
        this.P = new h0(this);
    }

    public final void Mq(long r9, long r11, Long r13) {
        if (((Boolean) f4.c.getValue()).booleanValue() == false) goto L5;
    L19:
        ALogger.i("HamletAvatar", "joinCPosition, avatarId:" + r9 + "， version:" + r11 + ", position=" + r13);
        int r0 = ff0.e.a;
        com.bytedance.android.live.liveinteract.hamlet.model.r r1 = new com.bytedance.android.live.liveinteract.hamlet.model.r();
        r1.b(r9);
        r1.d(r11);
        r1.c(r13);
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r1), null);
        return;
    L5:
        if (r9 <= 0) goto L19;
        boolean r2 = ff0.c.a;
        Function1<String, Unit> r3 = new HamletAvatarWidget$joinCPosition$1(this);
        Intrinsics.checkNotNullParameter(r3, "listener");
        Context r4 = s1.getContext();     // Catch: Exception -> L21
        if (r4 == null) goto L19;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r4.getExternalCacheDir(), "live_hamlet_avatar");     // Catch: Exception -> L21
        if (r5.exists() == true) goto L13;
        r5.mkdirs();     // Catch: Exception -> L21
    L13:
        String r6 = (String) vm2.d.N6.getValue(null, vm2.d.a[401(0x191, float:5.62E-43)]);     // Catch: Exception -> L21
        String r7 = UriProtector.parse(r6).getLastPathSegment();     // Catch: Exception -> L21
        if (r7 == null) goto L19;
        PolarisFileWrapper r8 = new PolarisFileWrapper(r5, r7);     // Catch: Exception -> L21
        if (r8.exists() == false) goto L18;
        r3.invoke(r8.getAbsolutePath());     // Catch: Exception -> L21
        goto L19
    L18:
        Single.create(new ff0.a(Downloader.with(r4).url(r6).name(r7).monitorScene("hamlet_guide_image_download").savePath(r5.getAbsolutePath()).onlyWifi(false).retryCount(2).mainThreadListener(new ff0.b(r3)))).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());     // Catch: Exception -> L21
        goto L19
    }

    public final void Kq(x5 r31, boolean r32, boolean r33, boolean r34) {
        ALogger.i("HamletAvatar", "initXPlay, initXplayContent=" + r31.toString());
        HamletAvatarContext r0 = this.f;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n<Long> r1 = r0.getCurrentSelectAvatarID();
        if (r1 == null) goto L11;
        w5 r6 = r31.getHamletAvatarInit();
        if (r6 == null) goto L9;
        Long r7 = Long.valueOf(r6.getAvatarId());
    L10:
        r1.setValue(r7);
        goto L11
    L9:
        r7 = null;
    L11:
        HamletAvatarContext r2 = this.f;
        if (r2 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r3 = r2.getXplyStartMessageRecived();
        if (r3 == null) goto L16;
        r3.setValue(Boolean.TRUE);
    L16:
        HamletAvatarContext r4 = this.f;
        if (r4 == null) goto L19;
        r4.setXplayAudioEnable(r34);
    L19:
        Function0<hg6.g> r5 = this.R;
        if (r5 == null) goto L22;
        hg6.g r8 = (hg6.g) r5.invoke();
    L24:
        if (r8 == null) goto L26;
        boolean r9 = r8.isEngineOn();
    L28:
        if (gh0.a.d() == false) goto L35;
        if (r9 == true) goto L35;
        ff0.d r10 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "join_channel", 0, null, null, 28);
        cg6.a r11 = Eq();
        if (r11 == null) goto L35;
        com.bytedance.live.bizlink.impl.platform.manager.a r12 = r11.A0();
        if (r12 == null) goto L35;
        r12.g();
    L35:
        ViewGroup r13 = this.Q;
        if (r13 == null) goto L293;
        r13.setVisibility(0);
        r13.getViewTreeObserver().addOnGlobalLayoutListener(new e(r13));
        w5 r14 = r31.getHamletAvatarInit();
        if (r14 == null) goto L49;
        List r15 = r14.getAllAvatarIds();
        if (r15 == null) goto L49;
        Iterator r16 = r15.iterator();
    L43:
        if (r16.hasNext() == false) goto L49;
        long r17 = ((Number) r16.next()).longValue();
        HamletAvatarContext r18 = this.f;
        if (r18 == null) goto L43;
        Map<Long, Float> r19 = r18.getDownloadAvatarProgressRecord();
        if (r19 == null) goto L43;
        Float r20 = r19.put(Long.valueOf(r17), Float.valueOf(0.0f));
    L49:
        LinkmicEcologyMessage.XPlayInitContent.a r21 = LinkmicEcologyMessage.XPlayInitContent.Companion;
        String r22 = r31.getVideoSimulcast();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "videoSimulcast");
        JSONArray r23 = new JSONArray(r22);     // Catch: Exception -> L52
    L54:
        if (r23 != null) goto L56;
    L69:
        HamletAvatarContext r24 = this.f;
        if (r24 == null) goto L78;
        com.bytedance.live.datacontext.m<Boolean> r25 = r24.isMultiAvatarMode();
        if (r25 == null) goto L78;
        w5 r110 = r31.getHamletAvatarInit();
        if (r110 == null) goto L76;
        boolean r111 = r110.getMultiAvatarMode();
    L77:
        r25.setValue(Boolean.valueOf(r111));
        goto L78
    L76:
        r111 = false;
    L78:
        HamletAvatarContext r26 = this.f;
        if (r26 == null) goto L85;
        w5 r112 = r31.getHamletAvatarInit();
        if (r112 == null) goto L83;
        boolean r113 = r112.getMultiAvatarMode();
    L84:
        r26.setMultiAvatarModeForReport(r113);
        goto L85
    L83:
        r113 = false;
    L85:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r27 = TalkRoomLogUtils.a;
        w5 r28 = r31.getHamletAvatarInit();
        if (r28 == null) goto L88;
        boolean r29 = r28.getMultiAvatarMode();
    L89:
        TalkRoomLogUtils.m = Boolean.valueOf(r29);
        HamletAvatarContext r30 = this.f;
        if (r30 == null) goto L106;
        com.bytedance.live.datacontext.m<Boolean> r35 = r30.isMultiAvatarMode();
        if (r35 == null) goto L106;
        if (((Boolean) r35.getValue()).booleanValue() != true) goto L106;
        if (gh0.a.d() == false) goto L105;
        HamletAvatarContext r36 = this.f;
        if (r36 == null) goto L104;
        com.bytedance.live.datacontext.m<Boolean> r37 = r36.isRtcClientInitialized();
        if (r37 == null) goto L104;
        if (((Boolean) r37.getValue()).booleanValue() != true) goto L104;
        jr();
    L104:
        this.C = true;
    L105:
        this.i = new gf0.c(this.f);
    L107:
        LinkedList<String> r114 = new LinkedList();
        HamletAvatarContext r38 = this.f;
        if (r38 == null) goto L114;
        com.bytedance.live.datacontext.m<Boolean> r39 = r38.isMultiAvatarMode();
        if (r39 == null) goto L114;
        Boolean r40 = (Boolean) r39.getValue();
        if (r40 == null) goto L114;
        boolean r41 = r40.booleanValue();
    L116:
        if (r41 == false) goto L124;
        boolean r42 = ff0.c.a;
        int r43 = 0;
    L119:
        if (r43 >= 2) goto L124;
        int r115 = bg0.a.a;
        String r44 = je0.d.a0() + "_Android_" + r43;
        if (r43 != 0) goto L123;
        r44 = r44 + "_main";
    L123:
        r114.add(r44);
        r43 = r43 + 1;
    L124:
        this.w = r114;
        uz r45 = uz.a;
        String r46 = ((HamletAvatarMockConfig) r45.getValue()).getMockChannel();
        if (r46 != null) goto L127;
    L130:
        boolean r47 = true;
    L131:
        if (r47 == false) goto L133;
        r46 = r31.getChannel();
    L133:
        String r48 = ((HamletAvatarMockConfig) r45.getValue()).getMockGameId();
        if (r48 != null) goto L136;
    L143:
        r48 = r31.getGameId();
    L144:
        boolean r116 = ff0.c.a;
        int r117 = Math.max((int) ((s1.w() * 9.0f) / 16), s1.y());
        int r118 = s1.w();
        LinkedHashMap r119 = new LinkedHashMap();
        JSONObject r120 = new JSONObject(r31.getInitParam());     // Catch: Exception -> L150
        if (((HamletAvatarMockConfig) r45.getValue()).getMockAvatarId() < 0) goto L148;
        r120.put("avatarID", ((HamletAvatarMockConfig) r45.getValue()).getMockAvatarId());     // Catch: Exception -> L150
    L148:
        r119.putAll(ff0.f.a(r120));     // Catch: Exception -> L150
    L152:
        ALogger.i("HamletAvatar", "makeExtraToXplayServer: init_param=" + r31.getInitParam());
        HamletAvatarContext r49 = this.f;
        if (r49 == null) goto L159;
        com.bytedance.live.datacontext.m<Boolean> r50 = r49.isMultiAvatarMode();
        if (r50 == null) goto L159;
        Boolean r51 = (Boolean) r50.getValue();
        if (r51 == null) goto L159;
        boolean r121 = r51.booleanValue();
    L160:
        boolean r52 = ff0.c.a;
        HamletAvatarContext r53 = this.f;
        if (r53 == null) goto L165;
        com.bytedance.live.datacontext.n<JSONArray> r54 = r53.getVideoSimulcastJSONArray();
        if (r54 == null) goto L165;
        JSONArray r55 = (JSONArray) r54.getValue();
    L166:
        HamletAvatarContext r122 = this.f;
        if (r122 == null) goto L171;
        com.bytedance.live.datacontext.m<Long> r123 = r122.getVideoSimulcastIndex();
        if (r123 == null) goto L171;
        Long r124 = (Long) r123.getValue();
    L172:
        if (r55 == null) goto L186;
        if (r124 == null) goto L186;
        if (r124.longValue() < 0) goto L186;
        if (r124.longValue() >= r55.length()) goto L186;
        Object r56 = r55.get((int) r124.longValue());     // Catch: Exception -> L184
        if ((r56 instanceof String) == false) goto L186;
        LinkedHashMap r125 = r119;
        if (StringsKt.contains$default((CharSequence) r56, vm2.d.K().getResolution1080Config(), false, 2, null) == false) goto L187;
        boolean r57 = true;
    L188:
        LinkedHashMap r58 = new LinkedHashMap();
        r58.put("enter_from", "live_app");
        IRoomContextService r59 = jc1.k.f(IRoomContextService.class);
        if (r59 == null) goto L197;
        LinkedList<String> r126 = r114;
        com.bytedance.android.livesdk.chatroom.o r60 = IRoomContextService.a.a(r59, null, 0, 3);
        if (r60 == null) goto L198;
        Room r61 = r60.getCurrentRoom();
        if (r61 == null) goto L198;
        String r62 = String.valueOf(r61.getRoomId());
        if (r62 == null) goto L198;
    L199:
        r58.put("live_room_id", r62);
        r58.put("is_anchor", String.valueOf(gh0.a.d()));
        uz r63 = uz.a;
        if (((HamletAvatarMockConfig) r63.getValue()).getMockAvatarId() < 0) goto L202;
        JSONObject r65 = new JSONObject(r31.getInitParam());
        r65.put("avatarID", ((HamletAvatarMockConfig) r63.getValue()).getMockAvatarId());
        r58.put("init_param", r65.toString());
    L203:
        boolean r66 = ff0.c.a;
        if (r121 == true) goto L208;
        if (r57 == true) goto L208;
        HamletLiveMediaMockConfig r67 = (HamletLiveMediaMockConfig) vm2.d.H6.getValue(null, vm2.d.a[395(0x18b, float:5.54E-43)]);
    L210:
        if (r67.getEnable() == true) goto L212;
        String r68 = String.valueOf(30);
    L213:
        r58.put("expect_fps", r68);
        if (r121 == true) goto L218;
        if (r57 == true) goto L218;
        HamletLiveMediaMockConfig r69 = (HamletLiveMediaMockConfig) vm2.d.H6.getValue(null, vm2.d.a[395(0x18b, float:5.54E-43)]);
    L220:
        if (r69.getEnable() == true) goto L226;
        if (r121 == true) goto L225;
        if (r57 == true) goto L225;
        String r70 = "720P";
    L227:
        r58.put("expect_resolution", r70);
        if (r121 == true) goto L232;
        if (r57 == true) goto L232;
        HamletLiveMediaMockConfig r71 = (HamletLiveMediaMockConfig) vm2.d.H6.getValue(null, vm2.d.a[395(0x18b, float:5.54E-43)]);
    L234:
        if (r71.getEnable() == true) goto L240;
        if (r121 == true) goto L239;
        if (r57 == true) goto L239;
        String r72 = "1600";
    L241:
        r58.put("expect_kbps", r72);
        HamletAvatarContext r73 = HamletAvatarContext.Companion.getContext();
        if (r73 == null) goto L250;
        com.bytedance.live.datacontext.m<Boolean> r74 = r73.isMultiAvatarMode();
        if (r74 == null) goto L250;
        if (((Boolean) r74.getValue()).booleanValue() != true) goto L250;
        String r75 = r31.getRtcAppId();
        if (r75 == null) goto L250;
        r58.put("rtc_app_id", r75);
    L250:
        boolean r76 = !r34;
        boolean r210 = vm2.d.I().getUseSurfaceView();
        boolean r211 = vm2.d.J().getEnable();
        w5 r77 = r31.getHamletAvatarInit();
        if (r77 == null) goto L256;
        if (r77.getMultiAvatarMode() != true) goto L256;
        boolean r212 = true;
    L257:
        String r127 = r46;
        LinkedList<String> r78 = r126;
        com.bytedance.android.live.broadcastgame.api.xplay.basic.e r213 = new com.bytedance.android.live.broadcastgame.api.xplay.basic.e(r48, r127, r117, r118, 9, 16, r125, r58, true, r76, true, r210, true, r211, r78, r212, jc1.a.b(), r23, 29401344);
        if ((!r78.isEmpty()) == false) goto L260;
        this.v = r78.get(0);
    L260:
        Context r79 = ((Widget) this).context;
        String r80 = lu2.c.f(((Widget) this).dataCenter).getAnchorId();
        if (r80 != null) goto L263;
        String r128 = "";
    L264:
        boolean r129 = gb2.a.a(((Widget) this).dataCenter, false);
        IMiddlewareUserService r81 = jc1.k.f(IMiddlewareUserService.class);
        if (r81 == null) goto L272;
        com.bytedance.android.livesdk.user.e r82 = r81.user();
        if (r82 == null) goto L272;
        String r83 = r82.n();
        if (r83 == null) goto L272;
        String r214 = r83;
    L273:
        com.bytedance.android.live.broadcastgame.api.xplay.basic.c r84 = new com.bytedance.android.live.broadcastgame.api.xplay.basic.c(r79, r128, r129, r214, r213);
        this.o = r84;
        if (r32 == false) goto L294;
        this.N = System.currentTimeMillis();
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.b.d(r84, true, r33);
        return;
    L294:
        return;
    L272:
        r214 = "";
        goto L273
    L263:
        r128 = r80;
    L256:
        r212 = false;
    L239:
        r72 = "3600";
        goto L241
    L240:
        r72 = String.valueOf(r71.getDefaultBitrate() / 1000);
    L232:
        r71 = vm2.d.K();
    L225:
        r70 = "1080P";
        goto L227
    L226:
        StringBuilder r85 = new StringBuilder();
        r85.append(r69.getResolution());
        r85.append('P');
        r70 = r85.toString();
    L218:
        r69 = vm2.d.K();
        goto L220
    L212:
        r68 = String.valueOf(r67.getFps());
    L208:
        r67 = vm2.d.K();
        goto L210
    L202:
        r58.put("init_param", r31.getInitParam());
    L198:
        r62 = "";
        goto L199
    L197:
        r126 = r114;
    L187:
        r57 = false;
    L184:
        e = move-exception;
        r125 = r119;
        ALogger.e("HamletAvatar", "isAvatarQualityImprove exception:" + e.getMessage());
    L186:
        r125 = r119;
    L171:
        r124 = null;
    L165:
        r55 = null;
    L159:
        r121 = false;
    L150:
        e = move-exception;
        ALogger.e("HamletAvatar", "makeExtraToHamlet exception=" + Log.getStackTraceString(e));
        goto L152
    L136:
        if (r48.length() <= 0) goto L138;
        boolean r130 = true;
    L139:
        if (r130 == true) goto L142;
        r48 = null;
    L142:
        if (r48 != null) goto L144;
    L138:
        r130 = false;
        goto L139
    L127:
        if (r46.length() == 0) goto L130;
        r47 = false;
    L114:
        r41 = false;
    L106:
        this.i = new gf0.b(this.f, new d(this, r31));
        goto L107
    L88:
        r29 = false;
        goto L89
    L56:
        if (r31.getVideoSimulcastIndex() < 0) goto L69;
        if (r31.getVideoSimulcastIndex() >= r23.length()) goto L69;
        HamletAvatarContext r86 = this.f;
        if (r86 == null) goto L64;
        com.bytedance.live.datacontext.m<Long> r87 = r86.getVideoSimulcastIndex();
        if (r87 == null) goto L64;
        r87.setValue(Long.valueOf(r31.getVideoSimulcastIndex()));
    L64:
        HamletAvatarContext r88 = this.f;
        if (r88 == null) goto L69;
        com.bytedance.live.datacontext.n<JSONArray> r89 = r88.getVideoSimulcastJSONArray();
        if (r89 == null) goto L69;
        r89.setValue(r23);
    L52:
        r23 = null;
        goto L54
    L293:
        return;
    L26:
        r9 = false;
        goto L28
    L22:
        r8 = null;
        goto L24
    }
}
