package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.digitavatar.AvatarGender;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import com.bytedance.android.live.liveinteract.digitavatar.a0;
import com.bytedance.android.live.liveinteract.digitavatar.c0;
import com.bytedance.android.live.liveinteract.digitavatar.h0;
import com.bytedance.android.live.liveinteract.digitavatar.y;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.voicechat.api.KtvDigitAvatarApi;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerAvatarAuditContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/videoavatar/VideoDigitAvatarWidget;", "Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "Lvlc/l;", "<init>", "()V", "a", "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoDigitAvatarWidget extends BaseMultiLinkWidget implements vlc.l {
    public static final /* synthetic */ int l = 0;
    public final CompositeDisposable a;
    public Disposable b;
    public Disposable c;
    public Disposable d;
    public o e;
    public DigitAvatarMsgController f;
    public com.bytedance.android.live.liveinteract.digitavatar.videoavatar.a g;
    public final a0 h;
    public b i;
    public boolean j;
    public final g k;

    public static final class a {
    }

    public interface b {
        void gn();
    }

    public static final class c implements a0.b {
        public final /* synthetic */ VideoDigitAvatarWidget a;

        @Override // com.bytedance.android.live.liveinteract.digitavatar.a0.b
        public final void a(AvatarGender r2, Exception r3) {
            Intrinsics.checkNotNullParameter(r2, "gender");
            Intrinsics.checkNotNullParameter(r3, "e");
        }

        public c(VideoDigitAvatarWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.a0.b
        public final void b(Exception r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.a0.b
        public final void c(Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
            Intrinsics.checkNotNullParameter(r2, "sticker");
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.a0.b
        public final void d(AvatarGender r11, Sticker r12) {
            Intrinsics.checkNotNullParameter(r11, "gender");
            Intrinsics.checkNotNullParameter(r12, "sticker");
            o r3 = this.a.e;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("showModeProcessor");
        L5:
            r3.getClass();
            Intrinsics.checkNotNullParameter(r11, "gender");
            Intrinsics.checkNotNullParameter(r12, "sticker");
            if (r3.f == true) goto L8;
            return;
        L8:
            if (r11 != r3.g) goto L14;
            r3.f = false;
            if (r3.l != VideoShowMode.DIGIT_AVATAR) goto L15;
            ALogger.i("KtvDigitAvatar", "等待的道具下载完成了，此时还是avatar演唱模式，so加载avatar道具");
            r3.d(r11, r12, r3.c, true, null, null);
            return;
        L15:
            return;
        }
    }

    public static final class d {
        public d() {
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ VideoDigitAvatarWidget a;

        public e(VideoDigitAvatarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.liveinteract.digitavatar.videoavatar.c r8 = (com.bytedance.android.live.liveinteract.digitavatar.videoavatar.c) r7;
            boolean r1 = true;
            if (vm2.e.d() == false) goto L16;
            DigitAvatarContext.a r0 = DigitAvatarContext.Companion;
            DigitAvatarContext r3 = r0.getContext();
            if (r3 == null) goto L12;
            if (r8.a != VideoShowMode.DIGIT_AVATAR) goto L9;
            boolean r4 = true;
        L10:
            r3.setIsDigitAvatarLoading(r4);
            goto L12
        L9:
            r4 = false;
        L12:
            if (r8.a != VideoShowMode.DIGIT_AVATAR) goto L16;
            DigitAvatarContext r2 = r0.getContext();
            if (r2 == null) goto L16;
            r2.setIsDigitAvatarLoaded(false);
        L16:
            VideoDigitAvatarWidget r5 = this.a;
            VideoShowMode r6 = r8.a;
            int r9 = VideoDigitAvatarWidget.l;
            r5.yq(r6);
            DataCenter r10 = ((Widget) this.a).dataCenter;
            VideoShowMode r11 = r8.a;
            VideoShowMode r12 = VideoShowMode.AUDIO;
            if (r11 == r12) goto L19;
            boolean r13 = true;
        L20:
            r10.put("data_self_is_camera_on", Boolean.valueOf(r13));
            lh6.b r14 = null;
            if (((Boolean) vm2.d.p0.getValue(null, vm2.d.a[65])).booleanValue() == false) goto L31;
            DigitAvatarContext r15 = DigitAvatarContext.Companion.getContext();
            if (r15 == null) goto L25;
            VideoShowMode r16 = r15.getLastVideoShowMode();
        L27:
            if (r16 == VideoShowMode.DIGIT_AVATAR) goto L31;
            r1 = false;
            goto L31
        L25:
            r16 = null;
        L31:
            if (vm2.e.d() == true) goto L33;
            return;
        L33:
            if (je0.d.G() == true) goto L56;
            if (r1 == true) goto L36;
            return;
        L36:
            if (r8.a != r12) goto L58;
            rj0.l.n2.getClass();
            rj0.l r17 = rj0.l.a.a();
            if (r17 == null) goto L40;
            m00.g r18 = r17.hh();
        L41:
            VideoDigitAvatarWidget r19 = this.a;
            r19.getClass();
            jg6.a r20 = r19.getScopeServiceInMultiLinkRoom(cg6.a.class).e5();
            if (r20 == null) goto L44;
            r14 = r20.a();
        L44:
            if (r14 != null) goto L46;
        L48:
            Disposable r21 = r19.b;
            if (r21 == null) goto L51;
            r19.a.remove(r21);
        L51:
            Disposable r22 = Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(r19, r18), k.a);
            r19.b = r22;
            if (r22 == null) goto L59;
            r19.a.add(r22);
            return;
        L59:
            return;
        L46:
            if (r14.b() != 0) goto L48;
            r14.n(5, false, "pushBlackFrameForSomeTime");
            r14.i("pushBlackFrameForSomeTime");
            goto L48
        L40:
            r18 = null;
            goto L41
        L58:
            return;
        L56:
            return;
        L19:
            r13 = false;
            goto L20
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ VideoDigitAvatarWidget a;

        public f(VideoDigitAvatarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((Boolean) r4).booleanValue() == false) goto L13;
            VideoDigitAvatarWidget r5 = this.a;
            int r0 = VideoDigitAvatarWidget.l;
            r5.getClass();
            if (vm2.e.d() == false) goto L14;
            Disposable r1 = r5.c;
            if (r1 == null) goto L9;
            r5.a.remove(r1);
        L9:
            Disposable r2 = Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(r5), m.a);
            r5.c = r2;
            if (r2 == null) goto L15;
            r5.a.add(r2);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ VideoDigitAvatarWidget a;

        public g(VideoDigitAvatarWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            Integer r11 = (Integer) r10;
            boolean r12 = hd0.c.f().h();
            VideoDigitAvatarWidget r0 = this.a;
            if (r0.j == r12) goto L46;
            r0.j = r12;
            if (r12 == false) goto L7;
            String r1 = "我上麦位了";
        L8:
            ALogger.i("KtvDigitAvatar", r1);
            if (r12 == false) goto L46;
            ALogger.i("KtvDigitAvatar", "start pre download digit avatar stickers");
            a0 r2 = r0.h;
            r2.getClass();
            ALogger.i("KtvDigitAvatar", "fire preDownloadDigitAvatarStickers()");
            if (y.b != null) goto L13;
            ALogger.i("KtvDigitAvatar", "开始预下载recognition识别道具。stick");
            r2.a = System.currentTimeMillis();
            y.a(r2.b);
        L14:
            ALogger.i("KtvDigitAvatar", "当前用户性别(1: 男， 2： 女)：gender = " + jc1.k.n(IMiddlewareUserService.class).user().b().getGender() + ' ');
            DigitAvatarContext r4 = DigitAvatarContext.Companion.getContext();
            if (r4 == null) goto L22;
            com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r5 = r4.getDigitAvatar();
            if (r5 == null) goto L22;
            com.bytedance.android.live.liveinteract.digitavatar.n r6 = (com.bytedance.android.live.liveinteract.digitavatar.n) r5.getValue();
            if (r6 == null) goto L22;
            AvatarGender r7 = r6.b;
            if (r7 == null) goto L22;
        L23:
            r2.a(r7);
            AvatarGender[] r8 = AvatarGender.values();
            int r9 = r8.length;
            int r13 = 0;
        L24:
            if (r13 >= r9) goto L29;
            AvatarGender r14 = r8[r13];
            if (r14 == r7) goto L28;
            r2.a(r14);
        L28:
            r13 = r13 + 1;
            goto L24
        L29:
            DigitAvatarContext.a r3 = DigitAvatarContext.Companion;
            DigitAvatarContext r15 = r3.getContext();
            if (r15 == null) goto L42;
            com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r16 = r15.getDigitAvatar();
            if (r16 == null) goto L42;
            com.bytedance.android.live.liveinteract.digitavatar.n r17 = (com.bytedance.android.live.liveinteract.digitavatar.n) r16.getValue();
            if (r17 == null) goto L42;
            if (r17.e == false) goto L38;
        L41:
            ALogger.i("KtvDigitAvatar", "getAvatarAuditResult：用户已经审核过了，或者没有设置自定义形象，so不用真正发请求");
        L43:
            DigitAvatarContext r18 = r3.getContext();
            if (r18 == null) goto L46;
            r18.checkEnsureVideoShowMode();
            goto L46
        L38:
            if (r17.a == true) goto L41;
            if (r17.b() == false) goto L41;
        L42:
            ALogger.i("KtvDigitAvatar", "fire getAvatarAuditResult(), 开始从server请求avatar审核结果");
            r0.a.add(((KtvDigitAvatarApi) com.bytedance.android.live.network.c.b().e(KtvDigitAvatarApi.class)).getAvatarAuditResult().compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.digitavatar.videoavatar.h(r0), com.bytedance.android.live.liveinteract.digitavatar.videoavatar.i.a));
        L22:
            r7 = c0.b();
            goto L23
        L13:
            ALogger.i("KtvDigitAvatar", "recognition识别道具已经下载好了，不需要预下载");
            goto L14
        L7:
            r1 = "我下麦位了";
        L46:
            if (r12 == true) goto L54;
            DigitAvatarContext r19 = DigitAvatarContext.Companion.getContext();
            if (r19 == null) goto L55;
            r19.setIsDigitAvatarLoading(false);
            return;
        L55:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            IInteractService r7 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r7 == null) goto L7;
            com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r8 = r7.getLinkUserInfoCenter();
            if (r8 == null) goto L7;
            Iterable r9 = r8.getOnlineUserList();
        L8:
            if (r9 == null) goto L23;
            Iterator<T> r10 = r9.iterator();
        L11:
            if (r10.hasNext() == false) goto L19;
            T r1 = r10.next();
            IBaseUser r2 = ((ILinkPlayerInfoBridge) r1).getUser();
            if (r2 == null) goto L15;
            String r3 = r2.getIdString();
        L17:
            if (Intrinsics.areEqual(r3, je0.d.b0()) == false) goto L11;
        L20:
            ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) r1;
            if (r4 == null) goto L23;
            Boolean r11 = Boolean.valueOf(r4.isBackground());
        L24:
            DigitAvatarContext.a r12 = DigitAvatarContext.Companion;
            DigitAvatarContext r13 = r12.getContext();
            if (r13 != null) goto L27;
            return;
        L27:
            if (r13.getIsDigitAvatarLoading() == true) goto L29;
            return;
        L29:
            if ((!Intrinsics.areEqual(r11, Boolean.TRUE)) == false) goto L47;
            DigitAvatarContext r14 = r12.getContext();
            if (r14 == null) goto L33;
            r14.setIsDigitAvatarLoading(false);
        L33:
            DigitAvatarContext r15 = r12.getContext();
            if (r15 == null) goto L48;
            DigitAvatarContext r16 = r12.getContext();
            if (r16 == null) goto L39;
            VideoShowMode r17 = r16.getLastVideoShowMode();
            if (r17 == null) goto L39;
        L40:
            DigitAvatarContext.setVideoShowMode$default(r15, r17, null, 2, null);
            return;
        L39:
            r17 = VideoShowMode.AUDIO;
            goto L40
        L48:
            return;
        L47:
            return;
        L15:
            r3 = null;
            goto L17
        L19:
            r1 = null;
        L23:
            r11 = null;
        L7:
            r9 = null;
            goto L8
        }
    }

    public static final class i<T> implements Consumer {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public VideoDigitAvatarWidget() {
        this.a = new CompositeDisposable();
        this.h = new a0();
        this.k = new g(this);
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return je0.d.f();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.m(getRoomContext());
        if (r0 == null) goto L5;
        Boolean r1 = r0.isAnchor();
    L6:
        Boolean r2 = Boolean.TRUE;
        final boolean r4 = Intrinsics.areEqual(r1, r2);
        ALogger.i("KtvDigitAvatar", "VideoDigitAvatarWidget current scene = " + je0.d.f() + ", isAnchor=" + r4 + ", machine score = " + z0.b(r4) + ", anchor limit score=" + vm2.d.A0() + ", guest limit score=" + vm2.d.B0());
        Pair r3 = com.bytedance.live.datacontext.d.a(new VideoDigitAvatarWidget$onCreate$pair$1(this, r4));
        com.bytedance.live.datacontext.b.a((DataContext) r3.getFirst(), DigitAvatarContext.class);
        this.a.add((Disposable) r3.getSecond());
        ((LinkedHashMap) y.a).clear();
        y.b = null;
        com.bytedance.android.livesdk.chatroom.o r5 = com.bytedance.android.live.liveinteract.api.utils.m.m(getRoomContext());
        if (r5 == null) goto L9;
        Boolean r6 = r5.isAnchor();
    L11:
        if (Intrinsics.areEqual(r6, r2) == false) goto L15;
        rj0.k.m2.getClass();
        rj0.k r7 = rj0.k.a.a();
        if (r7 == null) goto L18;
        com.bytedance.android.live.pushstream.d r8 = r7.getLiveStream();
    L19:
        this.f = new DigitAvatarMsgController(r8);
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r9 = ILiveWrappedEffectSDKService.a.a();
        if (r9 == null) goto L22;
        r9.getMessageCenter();
    L22:
        VideoShowMode r10 = ((DigitAvatarContext) r3.getFirst()).getCurrentVideoShowMode();
        boolean r11 = hd0.c.f().h();
        DigitAvatarMsgController r12 = this.f;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMsgController");
    L25:
        o r13 = new o(r4, r10, r11, r12, wq(), this);
        this.e = r13;
        o.g(false);
        if (r13.k == false) goto L33;
        r13.m = true;
        DigitAvatarContext r14 = DigitAvatarContext.Companion.getContext();
        if (r14 == null) goto L31;
        VideoShowMode r15 = r14.getCurrentVideoShowMode();
        if (r15 == null) goto L31;
    L32:
        r13.l = r15;
        r13.c(VideoShowMode.VIDEO);
    L39:
        DigitAvatarContext.a r16 = DigitAvatarContext.Companion;
        DigitAvatarContext r17 = r16.getContext();
        if (r17 == null) goto L48;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.digitavatar.videoavatar.c> r18 = r17.getSetVideoShowModeEvent();
        if (r18 == null) goto L48;
        PublishSubject r19 = r18.onEvent();
        if (r19 == null) goto L48;
        Disposable r20 = r19.subscribe(new p(r13));
        if (r20 == null) goto L48;
        r13.a.add(r20);
    L48:
        DigitAvatarContext r21 = r16.getContext();
        if (r21 == null) goto L58;
        com.bytedance.live.datacontext.k<h0> r22 = r21.getRequestUpdateAvatar();
        if (r22 == null) goto L58;
        PublishSubject r23 = r22.onEvent();
        if (r23 == null) goto L58;
        Disposable r24 = r23.subscribe(new q(r13));
        if (r24 == null) goto L58;
        r13.a.add(r24);
    L58:
        if (r13.k == false) goto L68;
        com.bytedance.live.datacontext.j r25 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r25 == null) goto L68;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r26 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r25.getValue();
        if (r26 == null) goto L68;
        BehaviorSubject r27 = r26.a();
        if (r27 == null) goto L68;
        Disposable r28 = r27.subscribe(new r(r13), s.a);
        if (r28 == null) goto L68;
        r13.a.add(r28);
    L68:
        r13.e(r13.l, true, null, "videoshowmode processor start");
        DigitAvatarMsgController r29 = this.f;
        if (r29 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMsgController");
    L71:
        this.g = new com.bytedance.android.live.liveinteract.digitavatar.videoavatar.a(r29, this);
        this.h.d = new c(this);
        hd0.c.f().c(this.k);
        DigitAvatarMsgController r30 = this.f;
        if (r30 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMsgController");
    L74:
        new d();
        r30.getClass();
        t r31 = jc1.k.n(IRoomContextService.class).getRoomInteractivityService(getRoomContext());
        if (r31 == null) goto L81;
        com.bytedance.live.datacontext.j r32 = r31.getMessageManager();
        if (r32 == null) goto L81;
        vlc.d r33 = (vlc.d) r32.getValue();
        if (r33 == null) goto L81;
        r33.addMessageListener(MessageType.LINKER.getKey(), this);
    L81:
        DigitAvatarContext r34 = r16.getContext();
        if (r34 == null) goto L90;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.digitavatar.videoavatar.c> r35 = r34.getSetVideoShowModeEvent();
        if (r35 == null) goto L90;
        PublishSubject r36 = r35.onEvent();
        if (r36 == null) goto L90;
        Disposable r37 = r36.subscribe(new e(this));
        if (r37 == null) goto L90;
        RxUtilKt.c(r37, this.a);
    L90:
        DigitAvatarContext r38 = r16.getContext();
        if (r38 == null) goto L100;
        com.bytedance.live.datacontext.m<Boolean> r39 = r38.getRestoreDigitAvatar();
        if (r39 == null) goto L101;
        Observable r40 = r39.a();
        if (r40 == null) goto L102;
        Disposable r41 = r40.subscribe(new f(this));
        if (r41 == null) goto L103;
        RxUtilKt.c(r41, this.a);
        return;
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L31:
        r15 = VideoShowMode.VIDEO;
        goto L32
    L33:
        r13.m = hd0.c.f().h();
        DigitAvatarContext r42 = DigitAvatarContext.Companion.getContext();
        if (r42 == null) goto L37;
        VideoShowMode r43 = r42.getCurrentVideoShowMode();
        if (r43 == null) goto L37;
    L38:
        r13.l = r43;
        r13.c(VideoShowMode.AUDIO);
        hd0.c.f().c(r13.i);
    L37:
        r43 = VideoShowMode.VIDEO;
    L18:
        r8 = null;
        goto L19
    L15:
        rj0.l.n2.getClass();
        rj0.l r44 = rj0.l.a.a();
        if (r44 == null) goto L18;
        r8 = r44.getLiveStream();
        goto L19
    L9:
        r6 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        DigitAvatarContext.a r0 = DigitAvatarContext.Companion;
        DigitAvatarContext r1 = r0.getContext();
        if (r1 == null) goto L7;
        VideoShowMode r2 = r1.getCurrentVideoShowMode();
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.c.Y0;
        Integer r4 = Integer.valueOf(r2.getType());
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
    L7:
        ((Widget) this).dataCenter.put("data_self_is_camera_on", Boolean.FALSE);
        DigitAvatarContext r5 = r0.getContext();
        if (r5 == null) goto L10;
        r5.saveDigitAvatar();
    L10:
        DigitAvatarMsgController r6 = this.f;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMsgController");
    L13:
        r6.getClass();
        this.h.d = null;
        this.a.clear();
        DigitAvatarMsgController r7 = this.f;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMsgController");
    L16:
        r7.getClass();
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r8 = ILiveWrappedEffectSDKService.a.a();
        if (r8 == null) goto L19;
        r8.getMessageCenter();
    L19:
        r7.a.removeCallbacksAndMessages(null);
        o r9 = this.e;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("showModeProcessor");
    L23:
        if (r9.k == true) goto L25;
        hd0.c.f().e(r9.i);
    L25:
        com.bytedance.android.live.liveinteract.digitavatar.videoavatar.e r10 = r9.d;
        DownloadTask r11 = r10.a;
        if (r11 == null) goto L28;
        r11.subThreadListener(null);
    L28:
        r10.b.clear();
        r9.e.a.clear();
        r9.a.clear();
        r9.a();
        com.bytedance.android.live.liveinteract.digitavatar.videoavatar.a r12 = this.g;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("avatarEmojiController");
    L31:
        r12.getClass();
        hd0.c.f().e(this.k);
        wq().b("livedigitavatar", "VideoDigitAvatarWidget_onDestroy");
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        this.a.remove(r0);
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L5;
        VideoShowMode r1 = r0.getCurrentVideoShowMode();
    L6:
        yq(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final com.bytedance.android.live.effect.api.o wq() {
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.m(getRoomContext());
        if (r0 == null) goto L5;
        Boolean r1 = r0.isAnchor();
    L7:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L10;
        return jc1.k.n(IMiddlewareEffectService.class).effectContext(LiveEffectContextFactoryType.DEFAULT).b();
    L10:
        return jc1.k.n(IMiddlewareEffectService.class).effectContext(LiveEffectContextFactoryType.LINK).b();
    L5:
        r1 = null;
        goto L7
    }

    public final void onMessage(tlc.d r9) {
        if ((r9 instanceof h1) == false) goto L14;
        h1 r10 = (h1) r9;
        if (r10.getMType() != 20) goto L15;
        LinkerAvatarAuditContent r11 = r10.getAvatarAuditContent();
        if (r11 == null) goto L12;
        ALogger.i("KtvDigitAvatar", "收到server审核结果消息。auditId=" + r11.getAuditId() + ", result=" + r11.getAuditResult() + ", reason=" + r11.getReason() + '}');
        if (r11.getAuditResult() != 2) goto L11;
        f2.b(2131918201, 0);
    L11:
        xq(r11.getAuditId(), r11.getAuditResult(), r11.getReason());
        return;
    L12:
        ALogger.w("KtvDigitAvatar", "收到server审核结果消息,但是avatarAuditContent=null");
        return;
    L15:
        return;
    }

    public final void yq(VideoShowMode r3) {
        if (vm2.e.d() == true) goto L5;
        return;
    L5:
        if (r3 != VideoShowMode.DIGIT_AVATAR) goto L16;
        DigitAvatarContext r4 = DigitAvatarContext.Companion.getContext();
        if (r4 == null) goto L16;
        if (r4.getIsDigitAvatarLoading() != true) goto L16;
        Disposable r5 = this.d;
        if (r5 == null) goto L13;
        this.a.remove(r5);
    L13:
        Disposable r6 = Observable.timer(((Number) vm2.d.e3.getValue(null, vm2.d.a[210(0xd2, float:2.94E-43)])).longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(h.a, i.a);
        this.d = r6;
        if (r6 == null) goto L21;
        this.a.add(r6);
        return;
    L21:
        return;
    L16:
        Disposable r7 = this.d;
        if (r7 == null) goto L23;
        this.a.remove(r7);
        return;
    }

    public final void xq(long r23, long r25, String r27) {
        DigitAvatarContext.a r5 = DigitAvatarContext.Companion;
        DigitAvatarContext r6 = r5.getContext();
        if (r6 == null) goto L96;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r7 = r6.getDigitAvatar();
        if (r7 == null) goto L97;
        com.bytedance.android.live.liveinteract.digitavatar.n r8 = (com.bytedance.android.live.liveinteract.digitavatar.n) r7.getValue();
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.b() == true) goto L11;
        return;
    L11:
        if (r8.e == true) goto L100;
        int r9 = x.a;
        long r10 = r8.f;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("audit_id", Long.valueOf(r23));
        r11.put("local_audit_id", Long.valueOf(r10));
        r11.put("audit_result", Long.valueOf(r25));
        r11.put("error_msg", String.valueOf(r27));
        x.t0("digit_avatar_on_audit_result", r11);
        TalkRoomBusinessFullLinkMonitor r12 = TalkRoomBusinessFullLinkMonitor.a;
        long r13 = r8.f;
        r12.getClass();
        JSONObject r14 = new JSONObject();
        r14.put("audit_id", r23);
        r14.put("local_audit_id", r13);
        r14.put("audit_result", r25);
        r14.put("error_msg", String.valueOf(r27));
        nd0.c.o(nd0.c.a, LinkMonitorData.AvatarOnAuditResultMonitorData, r14, 0, null, false, 28);
        if (r23 == r8.f) goto L15;
        ALogger.i("KtvDigitAvatar", "收到的审核auditID(" + r23 + ")和本地avatar保存的id(" + r8.f + ")不一致");
        if (r8.a == false) goto L74;
        return;
    L74:
        if (r8.e == true) goto L107;
        f2.b(2131916213, 0);
        DigitAvatarContext r1 = r5.getContext();
        if (r1 == null) goto L82;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r2 = r1.getDigitAvatar();
        if (r2 == null) goto L82;
        com.bytedance.android.live.liveinteract.digitavatar.n r3 = (com.bytedance.android.live.liveinteract.digitavatar.n) r2.getValue();
        if (r3 == null) goto L82;
        r3.c = false;
    L82:
        DigitAvatarContext r4 = r5.getContext();
        if (r4 == null) goto L89;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r15 = r4.getDigitAvatar();
        if (r15 == null) goto L89;
        com.bytedance.android.live.liveinteract.digitavatar.n r16 = (com.bytedance.android.live.liveinteract.digitavatar.n) r15.getValue();
        if (r16 == null) goto L89;
        r16.e = true;
    L89:
        o r17 = this.e;
        if (r17 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("showModeProcessor");
    L92:
        r17.getClass();
        DigitAvatarContext r18 = r5.getContext();
        if (r18 == null) goto L108;
        r18.saveDigitAvatar();
        return;
    L108:
        return;
    L107:
        return;
    L15:
        if (r25 != 1) goto L50;
        f2.b(2131916214, 0);
        DigitAvatarContext r19 = r5.getContext();
        if (r19 == null) goto L23;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r20 = r19.getDigitAvatar();
        if (r20 == null) goto L23;
        com.bytedance.android.live.liveinteract.digitavatar.n r21 = (com.bytedance.android.live.liveinteract.digitavatar.n) r20.getValue();
        if (r21 == null) goto L23;
        r21.c = true;
    L23:
        DigitAvatarContext r22 = r5.getContext();
        if (r22 == null) goto L30;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r24 = r22.getDigitAvatar();
        if (r24 == null) goto L30;
        com.bytedance.android.live.liveinteract.digitavatar.n r26 = (com.bytedance.android.live.liveinteract.digitavatar.n) r24.getValue();
        if (r26 == null) goto L30;
        r26.e = true;
    L30:
        o r28 = this.e;
        if (r28 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("showModeProcessor");
    L34:
        if (r28.m == true) goto L36;
    L46:
        DigitAvatarContext r29 = r5.getContext();
        if (r29 == null) goto L101;
        r29.saveDigitAvatar();
        return;
    L101:
        return;
    L36:
        if (r28.l != VideoShowMode.DIGIT_AVATAR) goto L46;
        DigitAvatarContext r30 = r5.getContext();
        if (r30 == null) goto L46;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r31 = r30.getDigitAvatar();
        if (r31 == null) goto L46;
        com.bytedance.android.live.liveinteract.digitavatar.n r32 = (com.bytedance.android.live.liveinteract.digitavatar.n) r31.getValue();
        if (r32 == null) goto L46;
        String r33 = r32.d;
        if (r33 == null) goto L46;
        ALogger.i("KtvDigitAvatar", "收到avatar审核通过的消息，而我正在用avatar展示，so 向道具发消息更新形象使用审核过后的形象，avatarData=".concat(r33));
        DigitAvatarMsgController r34 = r28.n;
        r34.getClass();
        Intrinsics.checkNotNullParameter(r33, "mode");
        r34.a(203, 0, r33);
        goto L46
    L50:
        if (r25 != 2) goto L103;
        f2.b(2131916213, 0);
        DigitAvatarContext r35 = r5.getContext();
        if (r35 == null) goto L58;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r36 = r35.getDigitAvatar();
        if (r36 == null) goto L58;
        com.bytedance.android.live.liveinteract.digitavatar.n r37 = (com.bytedance.android.live.liveinteract.digitavatar.n) r36.getValue();
        if (r37 == null) goto L58;
        r37.c = false;
    L58:
        DigitAvatarContext r38 = r5.getContext();
        if (r38 == null) goto L65;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r39 = r38.getDigitAvatar();
        if (r39 == null) goto L65;
        com.bytedance.android.live.liveinteract.digitavatar.n r40 = (com.bytedance.android.live.liveinteract.digitavatar.n) r39.getValue();
        if (r40 == null) goto L65;
        r40.e = true;
    L65:
        o r41 = this.e;
        if (r41 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("showModeProcessor");
    L68:
        r41.getClass();
        DigitAvatarContext r42 = r5.getContext();
        if (r42 == null) goto L104;
        r42.saveDigitAvatar();
        return;
    L104:
        return;
    L103:
        return;
    L100:
        return;
    L97:
        return;
    }
}
