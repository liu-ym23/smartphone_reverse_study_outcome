package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg;

import android.animation.AnimatorSet;
import com.bytedance.android.live.base.model.message.f1;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import f32.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements f52.d, l {
    public f52.b a;
    public PlayerProgressServiceContext b;
    public boolean c;
    public final CompositeDisposable d;
    public final c e;
    public HotMsgGatherViewV2 f;
    public f32.e g;
    public final C0210b h;
    public final String i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.b$b, reason: collision with other inner class name */
    public static final class C0210b implements h32.d<f32.e> {
        public final /* synthetic */ b a;

        public C0210b(b r1) {
            this.a = r1;
        }

        @Override // h32.d
        public final void a(f r3) {
            f32.e r4 = (f32.e) r3;
            Intrinsics.checkNotNullParameter(r4, "newConfig");
            b r0 = this.a;
            r0.g = r4;
            if (r4.b == false) goto L14;
            HotMsgGatherViewV2 r5 = r0.f;
            if (r5 == null) goto L18;
            r5.l = false;
            AnimatorSet r1 = r5.m;
            if (r1 != null) goto L9;
        L13:
            r5.m = null;
            return;
        L9:
            if (r1.isRunning() != true) goto L13;
            AnimatorSet r2 = r5.m;
            if (r2 == null) goto L13;
            r2.cancel();
            goto L13
        L18:
            return;
        L14:
            HotMsgGatherViewV2 r6 = r0.f;
            if (r6 == null) goto L20;
            r6.a();
            return;
        }
    }

    static {
    }

    @Override // f52.d
    public final void onUnload() {
        ALogger.i("HotMsgViewManager", "onUnload");
        this.d.clear();
        if (com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.a.booleanValue() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.b <= 0) goto L7;
    L9:
        HashMap r0 = new HashMap();
        int r1 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.c;
        String r5 = "0";
        if (r1 <= 0) goto L12;
        String r2 = String.valueOf(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.b / r1);
    L13:
        r0.put("init_view_cost", r2);
        r0.put("bind_view_cnt", String.valueOf(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.e));
        int r3 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.e;
        if (r3 <= 0) goto L16;
        String r4 = String.valueOf(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.d / r3);
    L17:
        r0.put("bind_view_cost", r4);
        IMiddlewareUserService r6 = k.f(IMiddlewareUserService.class);
        if (r6 == null) goto L23;
        com.bytedance.android.livesdk.user.e r7 = r6.user();
        if (r7 == null) goto L23;
        String r8 = r7.n();
        if (r8 == null) goto L23;
    L24:
        r0.put("user_id", r8);
        IRoomContextService r9 = k.f(IRoomContextService.class);
        if (r9 == null) goto L36;
        o r10 = IRoomContextService.a.a(r9, null, 0, 3);
        if (r10 == null) goto L36;
        m r11 = r10.getRoom();
        if (r11 == null) goto L36;
        IRoom r13 = (IRoom) r11.getValue();
        if (r13 == null) goto L36;
        String r14 = String.valueOf(r13.getRoomId());
        if (r14 == null) goto L36;
        r5 = r14;
    L36:
        r0.put("room_id", r5);
        j0.l().sendLog("ttlive_hot_msg_performance", r0, new Object[0]);
    L37:
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.b = 0;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.c = 0;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.d = 0;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.e = 0;
        return;
    L23:
        r8 = "0";
        goto L24
    L16:
        r4 = "0";
        goto L17
    L12:
        r2 = "0";
        goto L13
    L7:
        if (com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.e > 0) goto L9;
        goto L9
    }

    public b() {
        this.d = new CompositeDisposable();
        this.e = new c();
        this.g = new f32.e(false, 3);
        this.h = new C0210b(this);
        this.i = "HotMsgViewManager";
    }

    @Override // f52.d
    public final String getId() {
        return this.i;
    }

    @Override // f52.d
    public final void j(f52.b r6) {
        Intrinsics.checkNotNullParameter(r6, "container");
        this.a = r6;
        boolean r1 = false;
        if (com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.a.booleanValue() == false) goto L5;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.b = 0;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.c = 0;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.d = 0;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.e = 0;
    L5:
        ALogger.i("HotMsgViewManager", "onLoad");
        o r0 = r6.getRoomContext();
        if (r0 == null) goto L8;
        r1 = r0.isVSFirstShow();
    L8:
        this.c = r1;
        DataCenter r7 = r6.getDataCenter();
        IVSPlayerService r2 = k.f(IVSPlayerService.class);
        if (r2 == null) goto L13;
        IPlayerProgressService r3 = r2.provideVSProgressService(r7);
        if (r3 == null) goto L13;
        PlayerProgressServiceContext r4 = r3.provideContext(r7);
    L14:
        this.b = r4;
        IRoomContextService r5 = k.f(IRoomContextService.class);
        if (r5 == null) goto L25;
        o r8 = IRoomContextService.a.a(r5, r7, 0, 2);
        if (r8 == null) goto L25;
        j r9 = r8.getMessageManager();
        if (r9 == null) goto L25;
        vlc.d r10 = (vlc.d) r9.getValue();
        if (r10 == null) goto L25;
        Disposable r11 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.c(r10, "WebcastHotChatMessage", this);
        if (r11 == null) goto L25;
        RxUtilKt.c(r11, this.d);
    L25:
        h r13 = i.b(r7, 1);
        if (r13 == null) goto L37;
        j<h32.a> r14 = r13.getDegradeManager();
        if (r14 == null) goto L38;
        h32.a r15 = (h32.a) r14.getValue();
        if (r15 == null) goto L39;
        h32.c<f32.e> r16 = r15.g();
        if (r16 == null) goto L40;
        Disposable r17 = g32.b.a(r16, this.h);
        if (r17 == null) goto L41;
        RxUtilKt.c(r17, this.d);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L13:
        r4 = null;
        goto L14
    }

    public final void onMessage(tlc.d r11) {
        boolean r1 = false;
        if (this.c == false) goto L14;
        PlayerProgressServiceContext r0 = this.b;
        if (r0 == null) goto L11;
        m r2 = r0.getAtLatest();
        if (r2 == null) goto L11;
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
    L20:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
        return;
    L24:
        if ((r11 instanceof f1) == false) goto L60;
        f1 r5 = (f1) r11;
        if (r5.getSequenceId() == 0) goto L45;
        List r6 = r5.getShowDuration();
        if (r6 == null) goto L45;
        if ((!r6.isEmpty()) != true) goto L45;
        List r7 = r5.getNum();
        if (r7 == null) goto L45;
        if ((!r7.isEmpty()) != true) goto L45;
        List r8 = r5.getShowDuration();
        Integer r9 = null;
        if (r8 == null) goto L38;
        Integer r10 = Integer.valueOf(r8.size());
    L39:
        List r13 = r5.getNum();
        if (r13 == null) goto L43;
        r9 = Integer.valueOf(r13.size());
    L43:
        if (Intrinsics.areEqual(r10, r9) == false) goto L45;
        r1 = true;
        goto L45
    L38:
        r10 = null;
    L45:
        if (r1 == false) goto L61;
        ALogger.i("HotMsgViewManager", "receive msg. id=" + r5.getMessageId() + " sequenceId=" + r5.getSequenceId() + " maxSequenceId=" + this.e.a);
        if (r5.getSequenceId() < this.e.a) goto L62;
        r11.setReceiveTime(System.currentTimeMillis());
        f52.b r14 = this.a;
        if (r14 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L51:
        f1 r15 = (f1) r11;
        HotMsgGatherViewV2 r16 = this.f;
        if (r16 != null) goto L57;
        Boolean r17 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.a;
        Function0<HotMsgGatherViewV2> r18 = new HotMsgViewManager$getOrCreateHotMsgView$1(this);
        Intrinsics.checkNotNullParameter(r18, "action");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.a.booleanValue() == true) goto L56;
        r16 = (HotMsgGatherViewV2) r18.invoke();
        goto L57
    L56:
        long r19 = System.nanoTime();
        r16 = (HotMsgGatherViewV2) r18.invoke();
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.b += System.nanoTime() - r19;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.a.c++;
    L57:
        r14.a(new HotMsgPSTopView(r15, r16, this.e));
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L11:
        r3 = false;
    L14:
        if (((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.b.a.getValue()).booleanValue() == true) goto L16;
    L18:
        boolean r20 = false;
    L19:
        if (r20 == true) goto L20;
        r4 = false;
        goto L22
    L16:
        if (this.g.a == true) goto L18;
        r20 = true;
        goto L19
    }
}
