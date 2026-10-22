package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.OneButtonOpenSceneAndPlayModeResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w20.ac;
import w20.c4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s0 extends c4<ac, OneButtonOpenSceneAndPlayModeResultModel> {
    public final CompositeDisposable a;
    public boolean b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ s0 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ IRoom c;
        public final /* synthetic */ long d;
        public final /* synthetic */ Function1 e;

        public a(s0 r1, int r2, IRoom r3, long r4, Function1 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r18) {
            com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r18;
            Intrinsics.checkNotNull(r1);
            com.bytedance.android.live.liveinteract.plantform.utils.i.d((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data, r1.logId);
            this.a.b = false;
            tc0.c r2 = tc0.c.h();
            ALogger.w("ttlive_link_video", "initV2Success reqScene=" + this.b + " initResult=" + ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data));
            tc0.c.h().E = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).isSupportVideo();
            com.bytedance.android.livesdk.chatroom.u r3 = com.bytedance.android.live.liveinteract.api.utils.m.d();
            if (r3 == null) goto L22;
            com.bytedance.live.datacontext.j r5 = r3.getVideoTalkRoomSubScene();
            if (r5 == null) goto L7;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getValue();
        L8:
            if (r6 == null) goto L22;
            if (((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getScene() == 0) goto L17;
            com.bytedance.live.datacontext.j r4 = r3.getVideoTalkRoomSubScene();
            if (r4 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
            if (r7 == null) goto L16;
            r7.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getScene(), ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getPlayModes(), ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getUiLayout(), false, null, false, 56));
        L16:
            com.bytedance.android.livesdk.sharedpref.d.q(((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getScene());
            goto L22
        L17:
            com.bytedance.live.datacontext.j r8 = r3.getVideoTalkRoomSubScene();
            if (r8 == null) goto L22;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r8.getValue();
            if (r9 == null) goto L22;
            r9.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(this.b, ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getPlayModes(), ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getUiLayout(), false, null, false, 56));
            goto L22
        L7:
            r6 = null;
        L22:
            this.c.setLinkInitResult((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data);
            r2.k = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getRtcExtInfo();
            r2.m = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getLiveCoreExtInfo();
            r2.r = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getMultiLiveCoreInfo();
            r2.n = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getMultiRtcInfo();
            long r13 = System.currentTimeMillis() - this.d;
            com.bytedance.android.live.liveinteract.plantform.utils.x.z0(r13);
            InteractLinkFullLinkMonitor.l("8,12", 0, ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data).getScene(), (com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data, r13, r1.logId, "OneKeyOpenSceneAndPlayModeMethod");
            com.bytedance.android.livesdk.chatroom.model.interact.j0 r10 = (com.bytedance.android.livesdk.chatroom.model.interact.j0) r1.data;
            if (TextUtils.isEmpty(r10.getLinkMicIdStr()) == false) goto L25;
            r2.f = String.valueOf(r10.getLinkMicId());
            r2.e = String.valueOf(r10.getLinkMicId());
        L26:
            r2.j = r10.getVendor();
            r2.k = r10.getRtcExtInfo();
            if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L29;
            com.bytedance.android.live.liveinteract.plantform.base.f.a().id(32, MultiLinkOpenSource.INNER_TOOLS);
        L29:
            hd0.c.f().k(2);
            if (UserSetting.b() == false) goto L36;
            IUserServiceV2 r11 = jc1.k.f(IUserServiceV2.class);
            if (r11 == null) goto L37;
            Single r12 = r11.updateCurrentUser(null, "OneKeyOpenSceneAndPlayModeMethod");
            if (r12 == null) goto L37;
            r12.subscribe(new com.bytedance.android.livesdk.user.h());
        L37:
            Function1 r14 = this.e;
            if (r14 == null) goto L41;
            Unit r15 = (Unit) r14.invoke(Boolean.TRUE);
            return;
        L41:
            return;
        L36:
            jc1.k.n(IMiddlewareUserService.class).user().j().subscribe(new com.bytedance.android.livesdk.user.h());
            goto L37
        L25:
            r2.e = r10.getLinkMicIdStr();
            r2.f = r10.getLinkMicIdStr();
            goto L26
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ s0 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Function1 e;
        public final /* synthetic */ long f;

        public b(s0 r1, int r2, int r3, boolean r4, Function1 r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r8) {
            Throwable r4 = (Throwable) r8;
            if (this.c != 8) goto L5;
            int r0 = 1;
        L6:
            new qh0.h(r0, new OneKeyOpenSceneAndPlayModeMethod$openTalkRoom$disp$2$1(this), OneKeyOpenSceneAndPlayModeMethod$openTalkRoom$disp$2$2.INSTANCE).c(r4);
            this.a.b = false;
            InteractLinkFullLinkMonitor.j("8,12", 0, System.currentTimeMillis() - this.f, r4, "tool_fast_open");
            return;
        L5:
            r0 = 2;
            goto L6
        }
    }

    public final int j() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
    }

    public s0() {
        this.a = new CompositeDisposable();
    }

    public static void k(s0 r2) {
        r2.getClass();
        OneButtonOpenSceneAndPlayModeResultModel r0 = new OneButtonOpenSceneAndPlayModeResultModel();
        r0.a(OneButtonOpenSceneAndPlayModeResultModel.Code.Success);
        r0.b("");
        r2.finishWithResult(r0);
    }

    public final void invoke(Object r9, CallContext r10) {
        ac r11 = (ac) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        if ((!Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE)) == false) goto L5;
        OneButtonOpenSceneAndPlayModeResultModel r12 = new OneButtonOpenSceneAndPlayModeResultModel();
        r12.a(OneButtonOpenSceneAndPlayModeResultModel.Code.Failed);
        r12.b("你不是主播不能更改场景和玩法");
        finishWithResult(r12);
        return;
    L5:
        String r13 = r11.getType();
        if (r13 == null) goto L63;
        j();
        int r14 = r13.hashCode();
        if (r14 == 408060947) goto L44;
        switch(r14) {
            case 49: goto L38;
            case 50: goto L32;
            case 51: goto L26;
            case 52: goto L20;
            case 53: goto L14;
            default: goto L64;
        };
    L64:
        return;
    L14:
        if (r13.equals("5") == false) goto L48;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "openFloat3x3Window.invoked");
        if (j() != 0) goto L18;
        m(this, 12, 7, new OneKeyOpenSceneAndPlayModeMethod$openFloat3x3Window$1(this), 1);
        return;
    L18:
        n(this, j(), 12, 7);
        this.a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new r0(this)));
        return;
    L48:
        return;
    L20:
        if (r13.equals("4") == false) goto L51;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "open3x3Window.invoked");
        if (j() != 0) goto L24;
        m(this, 12, 5, new OneKeyOpenSceneAndPlayModeMethod$open3x3Window$1(this), 1);
        return;
    L24:
        n(this, j(), 12, 5);
        this.a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new o0(this)));
        return;
    L51:
        return;
    L26:
        if (r13.equals("3") == false) goto L54;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "openFloat1V6Window.invoked");
        if (j() != 0) goto L30;
        m(this, 8, 7, new OneKeyOpenSceneAndPlayModeMethod$openFloat1V6Window$1(this), 1);
        return;
    L30:
        n(this, j(), 8, 7);
        this.a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new q0(this)));
        return;
    L54:
        return;
    L32:
        if (r13.equals("2") == false) goto L57;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "open1v6Window.invoked");
        if (j() != 0) goto L36;
        m(this, 8, 0, new OneKeyOpenSceneAndPlayModeMethod$open1v6Window$1(this), 5);
        return;
    L36:
        n(this, j(), 8, 0);
        this.a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new n0(this)));
        return;
    L57:
        return;
    L38:
        if (r13.equals("1") == false) goto L60;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "openDoubleChat.invoked");
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L42;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().K7("right_away");
    L42:
        this.a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new p0(this)));
        return;
    L60:
        return;
    L44:
        if (r13.equals("interact_room_battle") == false) goto L62;
        ((IInteractService) jc1.k.n(IInteractService.class)).clickLinkRoomFightIcon(MapsKt.mapOf(TuplesKt.to("request_page", "activity")));
        k(this);
        return;
    L62:
        return;
    }

    public static void n(s0 r1, int r2, int r3, int r4) {
        r1.getClass();
        Intrinsics.checkNotNullParameter("", "reason");
        ((IInteractService) jc1.k.n(IInteractService.class)).switchScene(r2, r3, "", Integer.valueOf(r4));
    }

    public final void l(boolean r30, int r31, int r32, Function1<? super Boolean, Unit> r33) {
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.c0("tool_fast_open", r31, r32);
        long r20 = System.currentTimeMillis();
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L23;
        IRoom r3 = (IRoom) r1.getValue();
        if (r3 != null) goto L8;
        return;
    L8:
        if (jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId() == 0) goto L12;
        TalkRoomBusinessFullLinkMonitor.g0("during_pk");
        return;
    L12:
        if (this.b == false) goto L14;
        return;
    L14:
        this.b = true;
        LiveMode r4 = null;
        int r2 = ((Number) com.bytedance.android.livesdk.sharedpref.d.d0.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[54])).intValue();
        InteractLinkFullLinkMonitor.i("8,12", r2, "tool_fast_open");
        if (r30 == false) goto L17;
        Single<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.chatroom.model.interact.j0>> r0 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(r3.getId(), 4, 16, false, r2, "8,12", 0, r32, 1);
    L18:
        int r5 = com.bytedance.android.live.liveinteract.plantform.utils.f.a;
        com.bytedance.live.datacontext.i r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveMode();
        if (r6 == null) goto L21;
        r4 = (LiveMode) r6.getValue();
    L21:
        com.bytedance.android.live.liveinteract.plantform.utils.f.a(r4);
        ((IInteractService) jc1.k.n(IInteractService.class)).setDynamicFromAudience(false);
        r0.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r2, r3, r20, r33), new b(this, r32, r31, r30, r33, r20));
        return;
    L17:
        r0 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(r3.getId(), 4, false, r2, "8,12");
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(s0 r4, int r5, int r6, Function1 r7, int r8) {
        if ((r8 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r8 & 2) == 0) goto L10;
        r5 = 8;
    L10:
        if ((r8 & 4) == 0) goto L13;
        r6 = 0;
    L13:
        if ((r8 & 8) == 0) goto L15;
        r7 = null;
    L15:
        r4.l(r0, r5, r6, r7);
        return;
    L5:
        r0 = false;
        goto L7
    }
}
