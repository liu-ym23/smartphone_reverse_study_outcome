package com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui;

import android.content.Context;
import android.graphics.Path;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ch0.h;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.base.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.datamerge.i;
import com.bytedance.android.live.liveinteract.plantform.datamerge.k;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.LinkRoomFightWindowListHelperV2;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamClientMixStrategy;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamPlayState;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.emoji.VideoTalkInteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.config.n60;
import com.bytedance.android.livesdk.config.vn0;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rj0.l;
import zg1.r0;
import zi0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/ui/MultiLinkLinkRoomFightWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/CommonMultiLinkWindowManager;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkLinkRoomFightWindowManager extends CommonMultiLinkWindowManager {
    public static final /* synthetic */ int Z = 0;
    public final eh0.b X;
    public final boolean Y;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiLinkLinkRoomFightWindowManager a;

        public b(MultiLinkLinkRoomFightWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            MultiLinkLinkRoomFightWindowManager r4 = this.a;
            int r0 = MultiLinkLinkRoomFightWindowManager.Z;
            r4.q1();
        }
    }

    public static final class c implements Runnable {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (zi0.b.b() == false) goto L10;
            e r0 = zi0.b.d;     // Catch: Throwable -> L7
            com.bytedance.android.livesdk.utils.ntp.e.a();     // Catch: Throwable -> L7
            r0.getClass();     // Catch: Throwable -> L7
            zi0.b.c.onNext(Unit.INSTANCE);     // Catch: Throwable -> L7
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void T0() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.a a1() {
        List<m.d> r0 = this.z.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<m.e> r3 = this.z.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        k r7 = new k(r2 + r1);
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
    L14:
        return new i(r5, this.C, this.n, this.z, r7, this.B, this.X);
    L12:
        r5 = null;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.a b1() {
        List<m.d> r0 = this.z.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<m.e> r3 = this.z.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        k r7 = new k(r2 + r1);
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
    L14:
        return new LinkRoomFightWindowListHelperV2(r5, this.C, this.n, this.z, r7, this.B, this.X, 0);
    L12:
        r5 = null;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void end() {
        if (this.Y == false) goto L11;
        j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r0 == null) goto L18;
        f r1 = (f) r0.getValue();
        if (r1 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r2 = r1.t();
        if (r2 == null) goto L18;
        int r3 = r2.b;
    L20:
        if (aj0.b.c(r3) == true) goto L22;
        this.X.e();
    L22:
        super.end();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L25;
        String r4 = je0.d.k(this.C);
        RxBusAbility.INSTANCE.getRxBus(r4).post(new r0());
        return;
    L25:
        xs2.b.a().post(new r0());
        return;
    L18:
        r3 = 0;
        goto L20
    L11:
        j r5 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r5 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getValue();
        if (r6 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r7 = r6.t();
        if (r7 == null) goto L18;
        r3 = r7.c;
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final int j0() {
        IRoom r0 = je0.d.e(this.C);
        if (r0 != null) goto L5;
    L7:
        return 3;
    L5:
        if (r0.isLiveTypeAudio() != true) goto L7;
        return 2;
    }

    public final void q1() {
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r0 = this.h;
        if (r0 == null) goto L40;
        BehaviorSubject<List<tf0.e>> r1 = r0.b;
        if (r1 == null) goto L41;
        List r2 = (List) r1.getValue();
        if (r2 == null) goto L42;
        Path r3 = new Path();
        Iterator r4 = r2.iterator();
        int r5 = 0;
    L10:
        if (r4.hasNext() == false) goto L29;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        tf0.e r8 = (tf0.e) r6;
        if ((r8 instanceof MultiLinkGuestViewBinder.a) == true) goto L17;
        r8 = null;
    L17:
        MultiLinkGuestViewBinder.a r9 = (MultiLinkGuestViewBinder.a) r8;
        if (r9 == null) goto L28;
        ILinkPlayerInfoBridge r10 = r9.k.a;
        if (r10.getUser() == null) goto L28;
        if (je0.d.x(Integer.valueOf(r10.getLinkType())) == false) goto L28;
        com.bytedance.android.live.liveinteract.videotalk.utils.c r11 = this.b;
        if (r11 == null) goto L26;
        Path r12 = r11.a(r5, 0.0f, 0.0f);
    L27:
        r3.addPath(r12);
        goto L28
    L26:
        r12 = new Path();
    L28:
        r5 = r7;
        goto L10
    L29:
        g r13 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r13 == null) goto L43;
        com.bytedance.android.live.ui.c r14 = r13.y4();
        if (r14 == null) goto L44;
        r14.o(r3);
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    }

    public final void r1() {
        LinkRoomFightContext r0 = LinkRoomFightContext.Companion.getContext();
        if (r0 == null) goto L10;
        n<com.bytedance.android.live.base.model.data.i> r1 = r0.getLinkRoomUpdateContent();
        if (r1 == null) goto L11;
        Disposable r2 = i80.a.b(r1, new MultiLinkLinkRoomFightWindowManager$initViewManager$1(this));
        if (r2 == null) goto L12;
        RxUtilKt.c(r2, this.e);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void w() {
        ALogger.i(LinkRoomFightContext.TAG, "sendPlayViewActionAfterUpdateFullMode");
        r1();
        p0();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void L() {
        l1();
        if (this.n == true) goto L12;
        g2 r0 = zi0.d.b;
        LinkRoomFightContext r1 = LinkRoomFightContext.Companion.getContext();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.multiscene.a> r2 = r1.getFightInfo();
        if (r2 == null) goto L9;
        com.bytedance.android.live.liveinteract.multiscene.a r3 = (com.bytedance.android.live.liveinteract.multiscene.a) r2.getValue();
    L10:
        zi0.d.e(null, r3);
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void O() {
        super.O();
        if (this.n == true) goto L12;
        g2 r0 = zi0.d.b;
        LinkRoomFightContext r1 = LinkRoomFightContext.Companion.getContext();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.multiscene.a> r2 = r1.getFightInfo();
        if (r2 == null) goto L9;
        com.bytedance.android.live.liveinteract.multiscene.a r3 = (com.bytedance.android.live.liveinteract.multiscene.a) r2.getValue();
    L10:
        zi0.d.f(r3);
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final com.bytedance.android.live.ui.c m0() {
        boolean r0 = MultiLinkLoadWidgetUtils.g();
        if (this.Y == false) goto L7;
        if (r0 == true) goto L7;
        return null;
    L7:
        return super.m0();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.animation.e
    public final boolean Pf(int r1) {
        return lo(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void Q3(MultiLinkSpecialViewBinder.a r5) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        if (this.n == false) goto L21;
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        int r6 = r5.k;
        Integer r1 = je0.d.h();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        int r7 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.a(r6, r2);
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L17;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L17;
        if (r4.isLiveTypeAudio() != true) goto L17;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r8 = IVoiceChatAdminService.a.a();
        if (r8 == null) goto L22;
        r8.showInviteAndPermitDialog(false, "seat", r7);
        return;
    L22:
        return;
    L17:
        rj0.k.m2.getClass();
        rj0.k r9 = rj0.k.a.a();
        if (r9 == null) goto L24;
        rj0.k.b.c(r9, "seat", r7, 8);
        return;
    L24:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void d2(MultiLinkNormalEmptyViewBinder.a r9) {
        Intrinsics.checkNotNullParameter(r9, "itemData");
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.d(Integer.valueOf(r9.b())) == false) goto L54;
        int r10 = r9.b();
        Integer r1 = je0.d.h();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        int r7 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.a(r10, r2);
        if (this.n == true) goto L11;
        Integer r11 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r11 != null) goto L22;
    L31:
        if (r11 != null) goto L34;
    L48:
        if (r11 != null) goto L51;
        return;
    L51:
        if (r11.intValue() != 2) goto L68;
        i1(r7);
        return;
    L68:
        return;
    L34:
        if (r11.intValue() != 1) goto L48;
        IRoom r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r4 != null) goto L39;
        return;
    L39:
        if (s0.a(r4) == true) goto L41;
        return;
    L41:
        if (this.Y == false) goto L45;
        ILinkPanelService r3 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r3 == null) goto L64;
        r3.pj(getContext(), r4, null, "seat", r7);
        return;
    L64:
        return;
    L45:
        l.n2.getClass();
        l r12 = l.a.a();
        if (r12 == null) goto L66;
        r12.Sj();
        return;
    L66:
        return;
    L22:
        if (r11.intValue() != 0) goto L31;
        if (this.Y == false) goto L28;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r13 = IVoiceChatGuestService.a.a();
        if (r13 == null) goto L59;
        int r5 = bh0.a.a;
        r13.checkAndApply(r7, String.valueOf(101), LinkApplyType.NORMAL.getValue(), "voice_empty_stub_click");
        return;
    L59:
        return;
    L28:
        l.n2.getClass();
        l r14 = l.a.a();
        if (r14 == null) goto L61;
        int r6 = bh0.a.a;
        l.b.a(r14, r7, 101, "video_empty_stub_click");
        return;
    L61:
        return;
    L11:
        if (this.Y == false) goto L15;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r15 = IVoiceChatAdminService.a.a();
        if (r15 == null) goto L55;
        r15.showInviteAndPermitDialog(false, "seat", r7);
        return;
    L55:
        return;
    L15:
        rj0.k.m2.getClass();
        rj0.k r16 = rj0.k.a.a();
        if (r16 == null) goto L57;
        rj0.k.b.c(r16, "seat", r7, 8);
        return;
    L57:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void e4(MultiLinkGuestViewBinder.a r10) {
        Intrinsics.checkNotNullParameter(r10, "itemData");
        if (this.Y == false) goto L7;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L10;
        Boolean r1 = Boolean.valueOf(r0.isEngineOn());
    L11:
        boolean r2 = false;
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == true) goto L14;
    L33:
        xi0.a r3 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
        if (r3 != null) goto L36;
    L38:
        boolean r4 = false;
    L39:
        int r5 = r10.b;
        int r6 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        boolean r7 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.d(Integer.valueOf(r5));
        com.bytedance.live.datacontext.m r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        String r9 = "0";
        if (r8 == null) goto L45;
        IRoom r11 = (IRoom) r8.getValue();
        if (r11 == null) goto L45;
        String r12 = r11.getAnchorAbValue("room_battle_mode_switch");
        if (r12 == null) goto L45;
    L46:
        com.bytedance.live.datacontext.m r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r13 == null) goto L52;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L52;
        String r15 = r14.getAnchorAbValue("room_battle_none_mode_switch");
        if (r15 == null) goto L52;
    L53:
        com.bytedance.live.datacontext.m r16 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r16 == null) goto L62;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L62;
        String r18 = r17.getAnchorAbValue("room_battle_mode_switch_audio");
        if (r18 == null) goto L62;
        r9 = r18;
    L62:
        if (Intrinsics.areEqual(r12, "3") == false) goto L64;
    L77:
        r2 = true;
    L78:
        if (r2 == false) goto L82;
        if (r4 == false) goto L82;
        if (r7 == true) goto L82;
        return;
    L82:
        com.bytedance.live.datacontext.m r19 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r19 == null) goto L95;
        IRoom r20 = (IRoom) r19.getValue();
        if (r20 == null) goto L98;
        ILinkPlayerInfoBridge r21 = r10.k.a;
        if (r20.getOwner() == null) goto L96;
        if (r21 != null) goto L91;
        return;
    L91:
        if (r21.getUser() == null) goto L99;
        IBaseUser r22 = r21.getUser();
        Intrinsics.checkNotNull(r22);
        TalkRoomLogUtils.c(r22.getIdString());
        hi0.a.a.b(getContext(), this.C, r21, r20, !com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.d(Integer.valueOf(r10.a)));
        return;
    L99:
        return;
    L96:
        return;
    L98:
        return;
    L95:
        return;
    L64:
        if (Intrinsics.areEqual(r12, "2") == true) goto L77;
        if (Intrinsics.areEqual(r15, "2") == true) goto L77;
        if (Intrinsics.areEqual(r9, "2") == false) goto L70;
    L71:
        com.bytedance.live.datacontext.m r23 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r23 == null) goto L78;
        IRoom r24 = (IRoom) r23.getValue();
        if (r24 == null) goto L78;
        if (r24.isLiveTypeAudio() != true) goto L78;
    L70:
        if (Intrinsics.areEqual(r9, "3") == false) goto L78;
    L52:
        r15 = "";
    L45:
        r12 = "0";
        goto L46
    L36:
        if (r3.A4() != true) goto L38;
        r4 = true;
        goto L39
    L14:
        if (((Boolean) n60.a.getValue()).booleanValue() == false) goto L33;
        o r25 = com.bytedance.android.live.liveinteract.api.utils.m.l(this.C, 0L);
        if (r25 == null) goto L33;
        com.bytedance.live.datacontext.m r26 = r25.getCleanMode();
        if (r26 == null) goto L33;
        Integer r27 = (Integer) r26.getValue();
        if (r27 == null) goto L33;
        int r28 = r27.intValue();
        if (r28 != 2) goto L24;
    L29:
        boolean r29 = true;
    L30:
        if (r29 != true) goto L33;
        ALogger.w("BaseMultiLinkWindowManager", "rejected guest rank click for new clean mode");
        return;
    L24:
        if (r28 == 3) goto L29;
        if (r28 == 13) goto L29;
        r29 = false;
    L10:
        r1 = null;
        goto L11
    L7:
        l.n2.getClass();
        l r30 = l.a.a();
        if (r30 == null) goto L10;
        r1 = Boolean.valueOf(r30.isEngineOn());
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.animation.e
    public final boolean lo(int r2) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r0 = this.h;
        if (r0 == null) goto L9;
        BehaviorSubject<List<tf0.e>> r1 = r0.b;
        if (r1 == null) goto L9;
        List r3 = (List) r1.getValue();
        if (r3 == null) goto L9;
        tf0.e r4 = (tf0.e) CollectionsKt.getOrNull(r3, r2);
    L10:
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.j == false) goto L18;
        return true;
    L18:
        return false;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void w1(MultiLinkGuestViewBinder.a r12) {
        Intrinsics.checkNotNullParameter(r12, "itemData");
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.d(Integer.valueOf(r12.a)) == false) goto L5;
        super.w1(r12);
        return;
    L5:
        boolean r1 = hd0.c.f().h();
        if (this.n == false) goto L8;
    L9:
        if (r1 == false) goto L19;
        g2 r2 = zi0.d.b;
        zi0.d.d(r12.k.a, "head");
        Context r3 = getContext();
        DataCenter r4 = this.C;
        ILinkPlayerInfoBridge r13 = r12.k.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r13, "userInfo");
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        if (hg6.i.a() == false) goto L13;
        ih0.d r5 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r13, "seat", false);
    L17:
        r5.a();
        return;
    L13:
        VideoTalkInteractEmojiPanel r6 = new VideoTalkInteractEmojiPanel(r3, r4, r13);
        Intrinsics.checkNotNullParameter("seat", "<set-?>");
        r6.k = "seat";
        r6.r = true;
        tb6.c r14 = r6.x;
        if (r14 == null) goto L16;
        r14.a();
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r14.d = "seat";
    L16:
        r5 = r6;
    L19:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L21;
    L27:
        if (r1 == false) goto L36;
        Context r7 = getContext();
        DataCenter r8 = this.C;
        ILinkPlayerInfoBridge r15 = r12.k.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r15, "userInfo");
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        if (hg6.i.a() == false) goto L31;
        ih0.d r9 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r15, "seat", false);
    L35:
        r9.a();
        return;
    L31:
        VideoTalkInteractEmojiPanel r10 = new VideoTalkInteractEmojiPanel(r7, r8, r15);
        Intrinsics.checkNotNullParameter("seat", "<set-?>");
        r10.k = "seat";
        r10.r = true;
        tb6.c r16 = r10.x;
        if (r16 == null) goto L34;
        r16.a();
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r16.d = "seat";
    L34:
        r9 = r10;
        goto L35
    L36:
        xs2.b.a().post(new UserProfileEvent(r12.k.a.getUser()).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience"));
        g2 r11 = zi0.d.b;
        zi0.d.d(r12.k.a, "head");
        ILinkPlayerInfoBridge r17 = r12.k.a;
        Intrinsics.checkNotNullParameter(r17, "userInfo");
        LinkedHashMap r18 = new LinkedHashMap();
        IBaseUser r19 = r17.getUser();
        if (r19 == null) goto L41;
        String r110 = r19.getIdString();
        if (r110 == null) goto L41;
        r18.put("guest_id", r110);
    L41:
        TalkRoomLogUtils.J0(r18);
        TalkRoomLogUtils.B0(r18, null, null, 6);
        TalkRoomLogUtils.u0(r18);
        j0.l().sendLog("livesdk_room_grouppk_others_live_icon_show", r18, new Object[]{IRoom.class});
        return;
    L21:
        if (hd0.c.f().h() == true) goto L27;
        yi0.a r20 = new yi0.a(getContext(), r12.k.a, true);
        if (DialogLancet.shouldBlockDialogShow(r20) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(r20);
        return;
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L43
    L26:
        DialogLancet.beforeDialogShow(r20);
        r20.show();
        DialogLancet.afterDialogShow(r20);
        return;
    L8:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L19;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.animation.InteractAnimationController.d
    public final EmojiSoundManager I8(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "fromUid");
        Intrinsics.checkNotNullParameter(r10, "toUid");
        Map.Entry r0 = tc0.c.h().p;
        boolean r1 = false;
        if (r0 == null) goto L9;
        g2 r2 = (g2) r0.getValue();
        if (r2 == null) goto L9;
        if (r2.getRoomLinkSilenceStatus() != 1) goto L9;
        boolean r3 = true;
    L10:
        Iterator<T> r4 = this.X.d().iterator();
    L12:
        if (r4.hasNext() == false) goto L25;
        Object r5 = r4.next();
        ch0.e r6 = (ch0.e) r5;
        IBaseUser r7 = r6.a.getUser();
        if (r7 == null) goto L16;
        String r8 = r7.getIdString();
    L18:
        if (Intrinsics.areEqual(r8, r9) == false) goto L22;
        int r11 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.b(r6.a) == true) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L12;
    L26:
        if (r5 == null) goto L28;
        r1 = true;
    L28:
        if (r3 == false) goto L32;
        if (r1 == false) goto L32;
        return null;
    L32:
        return super.I8(r9, r10);
    L22:
        r12 = false;
        goto L23
    L16:
        r8 = null;
        goto L18
    L25:
        r5 = null;
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void U0(int r1, int r2) {
        super.U0(r1, r2);
        q1();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void n0(boolean r3, boolean r4) {
        StringBuilder r5 = new StringBuilder("initPlayModeViewManager isFromFastMode: ");
        r5.append(r3);
        r5.append(" context:");
        LinkRoomFightContext.a r0 = LinkRoomFightContext.Companion;
        r5.append(r0.getContext());
        ALogger.i(LinkRoomFightContext.TAG, r5.toString());
        int r6 = com.bytedance.android.live.liveinteract.videotalk.ui.b.a;
        Disposable r7 = com.bytedance.android.live.liveinteract.videotalk.ui.b.b(this.y, this.C);
        if (r7 == null) goto L6;
        RxUtilKt.c(r7, this.e);
    L6:
        if (r.m() == false) goto L8;
        super.n0(r3, false);
    L8:
        if (r3 == false) goto L12;
        if (r3 == true) goto L11;
        return;
    L11:
        if (r0.getContext() != null) goto L12;
        return;
    L12:
        r1();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final int D0(List<ti6.f> r7, Map<String, Integer> r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r7, "list");
        Intrinsics.checkNotNullParameter(r8, "posMap");
        boolean r1 = true;
        if (this.D.mc() != PublicStreamPlayState.Playing.ordinal()) goto L33;
        if (((Boolean) vn0.a.getValue()).booleanValue() == false) goto L33;
        List r10 = (List) this.X.h().getValue();
        LinkedHashMap r0 = null;
        if (r10 == null) goto L17;
        List r11 = r10;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L16;
        Object r2 = r12.next();
        h r4 = ((ch0.e) r2).b;
        if (r4 == null) goto L14;
        String r5 = r4.a;
    L15:
        r3.put(r5, r2);
        goto L10
    L14:
        r5 = null;
        goto L15
    L16:
        r0 = r3;
    L17:
        Map r13 = (Map) this.X.o().getValue();
        if (r13 != null) goto L20;
        r13 = MapsKt.emptyMap();
    L20:
        Iterator<T> r6 = r7.iterator();
    L22:
        if (r6.hasNext() == false) goto L33;
        ti6.f r14 = (ti6.f) r6.next();
        if (r0 == null) goto L30;
        ch0.e r15 = (ch0.e) r0.get(r14.b);
        if (r15 == null) goto L30;
        if (ch0.f.a(r15) != true) goto L30;
    L31:
        r14.j = true;
    L30:
        if (Intrinsics.areEqual((Boolean) r13.get(r14.b), Boolean.TRUE) == false) goto L22;
    L33:
        if (this.D.dn() == PublicStreamClientMixStrategy.Using.ordinal()) goto L37;
        r1 = false;
    L37:
        return super.D0(r7, r8, MapsKt.mapOf(TuplesKt.to("mcu_client_mix", Boolean.valueOf(r1))));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void l(boolean r2, Pair<Integer, Integer> r3, Pair<Integer, Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r4, "livePlayerLayoutSize");
        super.l(r2, r3, r4);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c r5 = this.P;
        eh0.b r6 = this.X;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "linkRoomFightDataMergeCenter");
        r5.b = r6;
        RxUtilKt.c(RxUtilKt.h(this.B.f()).subscribe(new b(this)), this.e);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r7 = this.d;
        if (r7 == null) goto L8;
        ViewGroup r8 = r7.td();
        if (r8 == null) goto L8;
        r8.post(c.a);
    L8:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L10;
        String r9 = je0.d.k(this.C);
        RxBusAbility.INSTANCE.getRxBus(r9).post(new r0());
        return;
    L10:
        xs2.b.a().post(new r0());
    }

    public MultiLinkLinkRoomFightWindowManager(Context r16, ConstraintLayout r17, m r18, zj0.c r19, com.bytedance.android.live.liveinteract.plantform.datamerge.d r20, eh0.b r21, DataCenter r22, tf0.o.a r23, PlatformMultiLinkWidget r24, View r25, GLSurfaceView r26, com.bytedance.android.live.pushstream.d r27, boolean r28, PlatformMultiLinkWidget r29) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "containerView");
        Intrinsics.checkNotNullParameter(r18, "layoutConfig");
        Intrinsics.checkNotNullParameter(r20, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r21, "linkRoomFightDataMergeCenter");
        Intrinsics.checkNotNullParameter(r22, "dataCenter");
        Intrinsics.checkNotNullParameter(r23, "callBack");
        Intrinsics.checkNotNullParameter(r24, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r25, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r26, "renderContainer");
        super(r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r29);
        this.X = r21;
        this.Y = r28;
    }
}
