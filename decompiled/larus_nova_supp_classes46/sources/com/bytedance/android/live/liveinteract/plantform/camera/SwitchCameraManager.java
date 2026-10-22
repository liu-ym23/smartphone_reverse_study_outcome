package com.bytedance.android.live.liveinteract.plantform.camera;

import am2.x;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.utils.b1;
import com.bytedance.android.live.liveinteract.videotalk.dialog.AnchorInviteOpenCameraDialog;
import com.bytedance.android.live.liveinteract.videotalk.utils.j;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.d2;
import com.bytedance.android.livesdk.chatroom.model.interact.e2;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeReplyContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import nd0.g;
import org.json.JSONObject;
import qh0.h;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SwitchCameraManager implements com.bytedance.android.live.liveinteract.plantform.camera.b, l {
    public final CompositeDisposable a;
    public vlc.d b;
    public AnchorInviteOpenCameraDialog c;
    public IRoom d;
    public boolean e;
    public boolean f;
    public final b1 g;
    public final Context h;
    public final DataCenter i;
    public final i<ILinkPlayerInfoBridge> j;
    public final j1 k;

    public static final class a implements j {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ SwitchCameraManager b;
        public final /* synthetic */ tlc.d c;

        @Override // com.bytedance.android.live.liveinteract.videotalk.utils.j
        public final void a() {
            GuestLinkContext r0 = GuestLinkContext.Companion.getContext();
            if (r0 != null) goto L5;
        L8:
            this.b.j(((ILinkerUpdateLinkTypeApplyContent) this.a.element).getFromUserIdString(), ReplyType.Agree.ordinal());
            SwitchCameraManager.h(this.b, "accept");
            return;
        L5:
            if (r0.isWatcher() != true) goto L8;
            f2.b(2131917289, 0);
        }

        @Override // com.bytedance.android.live.liveinteract.videotalk.utils.j
        public final void onRefuse() {
            this.b.j(((ILinkerUpdateLinkTypeApplyContent) this.a.element).getFromUserIdString(), ReplyType.Reject.ordinal());
            SwitchCameraManager.h(this.b, "reject");
        }

        public a(Ref.ObjectRef r1, SwitchCameraManager r2, tlc.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SwitchCameraManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        public b(SwitchCameraManager r1, String r2, int r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r11) {
            ExtraResponse r12 = (ExtraResponse) r11;
            int r0 = g.a;
            String r1 = this.b;
            int r2 = this.c;
            long r3 = this.d;
            Intrinsics.checkNotNullParameter(r1, "toUserId");
            Intrinsics.checkNotNullParameter(r12, "response");
            JSONObject r4 = new JSONObject();
            r4.put("to_user_id", r1);
            pd0.b r5 = pd0.b.a;
            r4.put("reply_type", pd0.b.i(r2));
            TalkRoomBusinessFullLinkMonitor r6 = TalkRoomBusinessFullLinkMonitor.a;
            LinkMonitorData r7 = LinkMonitorData.UpdateLinkTypeReplyApiMonitorData;
            r6.getClass();
            TalkRoomBusinessFullLinkMonitor.Z(r7, TalkRoomBusinessFullLinkMonitor.h(r3), r12.logId, r4);
            d2 r8 = (d2) r12.data;
            Intrinsics.checkNotNullParameter(r8, "$this$getLiveCoreExtInfo");
            String r9 = r8.getLiveCoreExtInfoRaw();
            String r10 = "";
            if (r9 != null) goto L5;
            r9 = "";
        L5:
            d2 r13 = (d2) r12.data;
            Intrinsics.checkNotNullParameter(r13, "$this$getRtcExtInfo");
            String r14 = r13.getRtcExtInfoRaw();
            if (r14 == null) goto L9;
            r10 = r14;
        L9:
            InteractLinkFullLinkMonitor.t0("update_link_type_reply_success", r9, r10, null, null);
            if (this.c == ReplyType.Agree.ordinal()) goto L12;
            return;
        L12:
            if (je0.d.O() == false) goto L19;
            DigitAvatarContext.a r15 = DigitAvatarContext.Companion;
            DigitAvatarContext r16 = r15.getContext();
            if (r16 == null) goto L16;
            r16.setSkipFrequencyCheck(true);
        L16:
            DigitAvatarContext r17 = r15.getContext();
            if (r17 == null) goto L22;
            DigitAvatarContext.setVideoShowMode$default(r17, VideoShowMode.VIDEO, null, 2, null);
            return;
        L22:
            return;
        L19:
            com.bytedance.android.live.liveinteract.plantform.camera.b.C0048b.a(this.a, true, false, true, false, "switchcameraManager replycamera", 24);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SwitchCameraManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        public c(SwitchCameraManager r1, String r2, int r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.b;
            int r2 = this.c;
            long r3 = this.d;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "toUserId");
            JSONObject r4 = new JSONObject();
            r4.put("to_user_id", r1);
            pd0.b r5 = pd0.b.a;
            r4.put("reply_type", pd0.b.i(r2));
            TalkRoomBusinessFullLinkMonitor.Y(LinkMonitorData.UpdateLinkTypeReplyApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r3), r8, r4);
            new h(0, new SwitchCameraManager$replyCamera$2$1(this), SwitchCameraManager$replyCamera$2$2.INSTANCE).c(r8);
            ExceptionUtils.handleException(s1.getContext(), r8);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ SwitchCameraManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ long d;

        public d(SwitchCameraManager r1, String r2, Ref.IntRef r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r7) {
            ExtraResponse r8 = (ExtraResponse) r7;
            dn0.c r0 = (dn0.c) this.a.k.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
            if (r0 == null) goto L5;
            r0.Z(this.b, e2.a((d2) r8.data), AckFromSource.TALK_ROOM_CAMERA_API);
        L5:
            int r1 = this.c.element;
            String r2 = this.b;
            long r3 = this.d;
            InteractLinkFullLinkMonitor.s0(r1, r2, System.currentTimeMillis() - r3, r8.logId);
            int r4 = g.a;
            g.j(this.b, this.c.element, this.d, r8);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Ref.IntRef a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public e(Ref.IntRef r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            int r0 = this.a.element;
            String r1 = this.b;
            long r2 = this.c;
            InteractLinkFullLinkMonitor.r0(r0, r1, System.currentTimeMillis() - r2, r8);
            TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
            String r4 = this.b;
            int r5 = this.a.element;
            long r6 = this.c;
            r3.getClass();
            TalkRoomBusinessFullLinkMonitor.C0(r4, r5, r6, r8);
            ExceptionUtils.handleException(s1.getContext(), r8);
        }
    }

    public static final class f implements lg6.a<Unit> {
        public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.camera.a a;

        public f(com.bytedance.android.live.liveinteract.plantform.camera.a r1) {
            this.a = r1;
        }

        public final void a(Unit r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            com.bytedance.android.live.liveinteract.plantform.camera.a r3 = this.a;
            if (r3 == null) goto L6;
            r3.onSuccess();
            return;
        }

        public final void onFailed(Exception r2) {
            Intrinsics.checkNotNullParameter(r2, "exception");
            com.bytedance.android.live.liveinteract.plantform.camera.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.onError(r2);
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.camera.b
    public final boolean a() {
        if (((Boolean) b6.h.getValue()).booleanValue() == true) goto L6;
        return false;
    L6:
        if (this.f == false) goto L8;
        return false;
    L8:
        return true;
    }

    public final cg6.a i() {
        return this.k.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    public final void k() {
        this.d = (IRoom) this.i.get("data_room", vh7.f.c(IRoom.class));
        this.e = ((Boolean) this.i.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        vlc.d r0 = (vlc.d) this.i.get("data_message_manager");
        this.b = r0;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.LINKER.getKey(), this);
    L5:
        vlc.d r1 = this.b;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.LINK_MIC.getKey(), this);
    L8:
        Pair r2 = com.bytedance.live.datacontext.d.a(SwitchCameraManager$start$pair$1.INSTANCE);
        ((SwitchCameraContext) r2.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r2.getFirst(), "ISwitchCameraManager");
        this.a.add((Disposable) r2.getSecond());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.camera.b
    public final void g() {
        cg6.a r0 = i();
        if (r0 == null) goto L9;
        jg6.a r1 = r0.e5();
        if (r1 == null) goto L9;
        lh6.b r2 = r1.a();
        if (r2 == null) goto L9;
        r2.l();
    L9:
        DigitAvatarContext r3 = DigitAvatarContext.Companion.getContext();
        if (r3 == null) goto L13;
        DigitAvatarContext.setVideoShowMode$default(r3, VideoShowMode.VIDEO, null, 2, null);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.camera.b
    public final boolean e() {
        return this.f;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.camera.b
    public final int c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "interactId");
        if (Intrinsics.areEqual(r4, tc0.c.h().f) == true) goto L5;
        i<ILinkPlayerInfoBridge> r0 = this.j;
        if (r0 == null) goto L17;
        List<T> r1 = r0.getOnlineUserList();
        if (r1 == 0) goto L22;
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L23;
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r2.next();
        if (Intrinsics.areEqual(r3.getInteractId(), r4) == false) goto L12;
        return r3.getLinkType();
    L23:
        return 2;
    L22:
        return 2;
    L17:
        return 2;
    L5:
        return hd0.c.f().g;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.camera.b
    public final boolean d(String r6) {
        if (Intrinsics.areEqual(r6, tc0.c.h().f) == true) goto L5;
        i<ILinkPlayerInfoBridge> r0 = this.j;
        if (r0 == null) goto L34;
        List<T> r1 = r0.getOnlineUserList();
        if (r1 == 0) goto L35;
        Iterator r2 = r1.iterator();
    L21:
        if (r2.hasNext() == false) goto L37;
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r2.next();
        if (Intrinsics.areEqual(r3.getInteractId(), r6) == false) goto L21;
        if (r3.getLinkType() != 1) goto L36;
        return true;
    L36:
        return false;
    L37:
        return false;
    L35:
        return false;
    L34:
        return false;
    L5:
        if (je0.d.r() == false) goto L7;
        return true;
    L7:
        cg6.a r7 = i();
        if (r7 == null) goto L31;
        jg6.a r8 = r7.e5();
        if (r8 == null) goto L32;
        lh6.b r9 = r8.a();
        if (r9 != null) goto L14;
        return false;
    L14:
        return r9.d();
    L32:
        return false;
    L31:
        return false;
    }

    public final void onMessage(tlc.d r21) {
        if (r21 != null) goto L6;
        return;
    L6:
        if ((r21 instanceof h1) == false) goto L241;
        h1 r1 = (h1) r21;
        int r2 = r1.getMType();
        boolean r8 = false;
        Object r12 = null;
        if (r2 != 18) goto L179;
        ILinkerUpdateLinkTypeApplyContent r3 = r1.getUpdateLinkTypeApplyContent();
        if (r3 == null) goto L19;
        String r4 = r3.getToast();
        if (r4 == null) goto L19;
        if (r4.length() != 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == true) goto L19;
        f2.c(r4, 0);
        goto L19
    L16:
        r5 = false;
    L19:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "linkerMessage");
        JSONObject r15 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "$this$messageId");
        r15.put("msg_id", r1.getMessageId3());
        ILinkerUpdateLinkTypeApplyContent r6 = r1.getUpdateLinkTypeApplyContent();
        if (r6 == null) goto L22;
        Intrinsics.checkNotNullParameter(r6, "$this$fromUserIdStringExt");
        r15.put("from_user_id", r6.getFromUserIdString());
        pd0.b r7 = pd0.b.a;
        r15.put("link_type", pd0.b.g(r6.getLinkType()));
    L22:
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveUpdateLinkTypeApplyMsgMonitorData, r15, 0, null, false, 28);
        AnchorInviteOpenCameraDialog r9 = this.c;
        if (r9 == null) goto L28;
        if (r9.isShowing() != true) goto L28;
        return;
    L28:
        if (hd0.c.f().h() == false) goto L48;
        if (hd0.c.f().g != 3) goto L48;
        if (aj0.a.e() == false) goto L45;
        m r0 = o3.f().getRoom();
        if (r0 == null) goto L36;
        IRoom r10 = (IRoom) r0.getValue();
    L38:
        if (aj0.a.b(r10) == false) goto L45;
        DigitAvatarContext.a r11 = DigitAvatarContext.Companion;
        DigitAvatarContext r13 = r11.getContext();
        if (r13 == null) goto L42;
        r13.setSkipFrequencyCheck(true);
    L42:
        DigitAvatarContext r14 = r11.getContext();
        if (r14 == null) goto L45;
        DigitAvatarContext.setVideoShowMode$default(r14, VideoShowMode.AUDIO, null, 2, null);
        goto L45
    L36:
        r10 = null;
    L45:
        ALogger.i("KtvDigitAvatar", "ignore open/close camera invite when using avatar");
        return;
    L48:
        if (this.d == null) goto L242;
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = r1.getUpdateLinkTypeApplyContent();
        dn0.c r17 = (dn0.c) this.k.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r17 == null) goto L61;
        ILinkerUpdateLinkTypeApplyContent r18 = (ILinkerUpdateLinkTypeApplyContent) r16.element;
        if (r18 == null) goto L55;
        String r19 = r18.getToUserIdString();
        if (r19 == null) goto L55;
    L56:
        ILinkerUpdateLinkTypeApplyContent r20 = (ILinkerUpdateLinkTypeApplyContent) r16.element;
        if (r20 == null) goto L59;
        String r22 = r20.getAckMessage();
    L60:
        r17.Z(r19, r22, AckFromSource.TALK_ROOM_CAMERA_MESSAGE);
        goto L61
    L59:
        r22 = null;
    L55:
        r19 = "";
    L61:
        ILinkerUpdateLinkTypeApplyContent r23 = (ILinkerUpdateLinkTypeApplyContent) r16.element;
        if (r23 != null) goto L64;
    L129:
        ILinkerUpdateLinkTypeApplyContent r24 = (ILinkerUpdateLinkTypeApplyContent) r16.element;
        if (r24 == null) goto L132;
        String r25 = r24.getToUserIdString();
    L134:
        if (Intrinsics.areEqual(r25, k.n(IMiddlewareUserService.class).user().n()) == false) goto L248;
        cg6.a r26 = i();
        if (r26 == null) goto L143;
        jg6.a r27 = r26.e5();
        if (r27 == null) goto L143;
        lh6.b r28 = r27.a();
        if (r28 == null) goto L143;
        r28.g("close by server");
    L143:
        if (je0.d.O() == false) goto L151;
        DigitAvatarContext.a r29 = DigitAvatarContext.Companion;
        DigitAvatarContext r30 = r29.getContext();
        if (r30 == null) goto L147;
        r30.setSkipFrequencyCheck(true);
    L147:
        VideoShowMode r31 = VideoShowMode.AUDIO;
        r31.setSource(0);
        DigitAvatarContext r32 = r29.getContext();
        if (r32 == null) goto L150;
        DigitAvatarContext.setVideoShowMode$default(r32, r31, null, 2, null);
    L150:
        com.bytedance.android.live.liveinteract.linksecurity.b r33 = com.bytedance.android.live.liveinteract.linksecurity.b.g;
        LinkedHashMap r34 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r35 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r36 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r33.getClass();
        Intrinsics.checkNotNullParameter(r34, "params");
        Intrinsics.checkNotNullParameter(r35, "callback");
        Intrinsics.checkNotNullParameter(r36, "config");
        r33.e("close_camera_by_other", r34, r35, r36);
    L152:
        ILinkerUpdateLinkTypeApplyContent r37 = (ILinkerUpdateLinkTypeApplyContent) r16.element;
        if (r37 != null) goto L155;
    L156:
        this.f = true;
    L157:
        ILinkerUpdateLinkTypeApplyContent r38 = (ILinkerUpdateLinkTypeApplyContent) r16.element;
        if (r38 == null) goto L160;
        Boolean r39 = r38.getClientNoToast();
    L162:
        if (Intrinsics.areEqual(r39, Boolean.FALSE) == false) goto L249;
        String r40 = ((ILinkerUpdateLinkTypeApplyContent) r16.element).getToast();
        if (r40 != null) goto L166;
    L171:
        String r41 = ((ILinkerUpdateLinkTypeApplyContent) r16.element).getFromUserIdString();
        IRoom r42 = this.d;
        if (r42 == null) goto L175;
        r12 = r42.getOwnerUserIdString();
    L175:
        if ((!Intrinsics.areEqual(r41, r12)) == false) goto L177;
        f2.b(2131917475, 0);
        return;
    L177:
        f2.b(2131917582, 0);
        return;
    L166:
        if (r40.length() <= 0) goto L168;
        boolean r43 = true;
    L169:
        if (r43 != true) goto L171;
        f2.c(((ILinkerUpdateLinkTypeApplyContent) r16.element).getToast(), 0);
        return;
    L168:
        r43 = false;
        goto L169
    L249:
        return;
    L160:
        r39 = null;
        goto L162
    L155:
        if (r37.getSource() == 2) goto L157;
    L151:
        com.bytedance.android.live.liveinteract.plantform.camera.b.C0048b.a(this, false, false, false, true, "switchcameraManager onMessage", 16);
        goto L152
    L248:
        return;
    L132:
        r25 = null;
        goto L134
    L64:
        if (r23.getLinkType() != 1) goto L129;
        this.f = false;
        cg6.a r44 = i();
        if (r44 == null) goto L72;
        jg6.a r45 = r44.e5();
        if (r45 == null) goto L72;
        lh6.b r46 = r45.a();
        if (r46 == null) goto L72;
        boolean r47 = r46.d();
    L73:
        if (r47 == false) goto L82;
        DigitAvatarContext r48 = DigitAvatarContext.Companion.getContext();
        if (r48 == null) goto L77;
        VideoShowMode r49 = r48.getCurrentVideoShowMode();
    L79:
        if (r49 != VideoShowMode.VIDEO) goto L82;
        return;
    L77:
        r49 = null;
    L82:
        if (us1.d.b(this.e, tc0.c.h().E) == true) goto L91;
        com.bytedance.live.datacontext.j r50 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r50 == null) goto L243;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r51 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r50.getValue();
        if (r51 == null) goto L244;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r52 = r51.t();
        if (r52 != null) goto L90;
        return;
    L90:
        if (r52.a == 12) goto L91;
        return;
    L244:
        return;
    L243:
        return;
    L91:
        int r53 = AnchorInviteOpenCameraDialog.j;
        IRoom r54 = this.d;
        String r55 = ((ILinkerUpdateLinkTypeApplyContent) r16.element).getFromUserIdString();
        AnchorInviteOpenCameraDialog r56 = new AnchorInviteOpenCameraDialog();
        r56.h = r54;
        r56.i = r55;
        this.c = r56;
        a r57 = new a(r16, this, r21);
        if (((ILinkerUpdateLinkTypeApplyContent) r16.element).getShowType() != 1) goto L94;
        com.bytedance.android.live.liveinteract.videotalk.utils.l.a(r57);
    L108:
        HashMap r58 = new HashMap();
        com.bytedance.live.datacontext.j r59 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r59 == null) goto L115;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r60 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r59.getValue();
        if (r60 == null) goto L115;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r61 = r60.t();
        if (r61 == null) goto L115;
        TalkRoomLogUtils.B0(r58, Integer.valueOf(r61.a), null, 4);
        TalkRoomLogUtils.I0(r58, r61.a);
    L115:
        com.bytedance.live.datacontext.j r62 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r62 == null) goto L128;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r63 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r62.getValue();
        if (r63 == null) goto L128;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r65 = r63.t();
        if (r65 == null) goto L128;
        List r66 = r65.b;
        if (r66 == null) goto L128;
        if (r66.contains(1) == false) goto L126;
        r12 = r66;
    L126:
        if (r12 == null) goto L128;
        r58.put("play_type", "video_friend");
    L128:
        j0.l().sendLog("livesdk_anchor_audience_connection_open_popup_show", r58, new Object[]{IRoom.class, x.class});
        return;
    L94:
        AnchorInviteOpenCameraDialog r67 = this.c;
        if (r67 == null) goto L97;
        r67.g = r57;
    L97:
        FragmentActivity r68 = ContextUtil.contextToFragmentActivity(this.h);
        if (r68 == null) goto L108;
        FragmentManager r69 = r68.getSupportFragmentManager();
        if (r69 == null) goto L108;
        AnchorInviteOpenCameraDialog r70 = this.c;
        if (r70 == null) goto L108;
        LandscapeRestrictionOperation r71 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r70, "AnchorInviteOpenCameraDialog", r71);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r69, r70, r71) == true) goto L108;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L238
    L107:
        r70.show(r69, "AnchorInviteOpenCameraDialog");
    L72:
        r47 = false;
        goto L73
    L242:
        return;
    L179:
        if (r2 != 19) goto L189;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "linkerMessage");
        JSONObject r110 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "$this$messageId");
        r110.put("msg_id", r1.getMessageId3());
        ILinkerUpdateLinkTypeReplyContent r72 = r1.getUpdateLinkTypeReplyContent();
        if (r72 == null) goto L183;
        pd0.b r73 = pd0.b.a;
        r110.put("reply_type", pd0.b.i(r72.getReplyType()));
        r110.put("prompt", r72.getPrompts());
    L183:
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveUpdateLinkTypeReplyMsgMonitorData, r110, 0, null, false, 28);
        ILinkerUpdateLinkTypeReplyContent r74 = r1.getUpdateLinkTypeReplyContent();
        if (r74 == null) goto L253;
        String r75 = r74.getPrompts();
        if (r75 == null) goto L254;
        f2.c(r75, 0);
        return;
    L254:
        return;
    L253:
        return;
    L189:
        if (r2 != 69) goto L256;
        ILinkerUpdateLinkTypeForceOpenCameraContent r76 = r1.getUpdateLinkTypeForceOpenCameraContent();
        if (r76 == null) goto L193;
        String r77 = r76.getToOpenId();
    L195:
        if (Intrinsics.areEqual(r77, k.n(IMiddlewareUserService.class).user().n()) == false) goto L257;
        cg6.a r78 = i();
        if (r78 == null) goto L206;
        jg6.a r79 = r78.e5();
        if (r79 == null) goto L206;
        lh6.b r80 = r79.a();
        if (r80 == null) goto L206;
        if (r80.b() != 5) goto L206;
        r8 = true;
    L206:
        if (Intrinsics.areEqual(o3.f().isAnchor(), Boolean.FALSE) == true) goto L208;
        if (r8 == true) goto L208;
    L215:
        ILinkerUpdateLinkTypeForceOpenCameraContent r81 = r1.getUpdateLinkTypeForceOpenCameraContent();
        if (r81 == null) goto L218;
        Integer r82 = r81.getLinkType();
    L219:
        if (r82 != null) goto L222;
    L226:
        ILinkerUpdateLinkTypeForceOpenCameraContent r83 = r1.getUpdateLinkTypeForceOpenCameraContent();
        if (r83 == null) goto L229;
        Integer r84 = r83.getLinkType();
    L230:
        if (r84 != null) goto L233;
        return;
    L233:
        if (r84.intValue() != 3) goto L260;
        DigitAvatarContext r85 = DigitAvatarContext.Companion.getContext();
        if (r85 == null) goto L261;
        DigitAvatarContext.setVideoShowMode$default(r85, VideoShowMode.DIGIT_AVATAR, null, 2, null);
        return;
    L261:
        return;
    L260:
        return;
    L229:
        r84 = null;
        goto L230
    L222:
        if (r82.intValue() != 1) goto L226;
        DigitAvatarContext r86 = DigitAvatarContext.Companion.getContext();
        if (r86 == null) goto L258;
        DigitAvatarContext.setVideoShowMode$default(r86, VideoShowMode.VIDEO, null, 2, null);
        return;
    L258:
        return;
    L218:
        r82 = null;
    L208:
        cg6.a r87 = i();
        if (r87 == null) goto L215;
        jg6.a r88 = r87.e5();
        if (r88 == null) goto L215;
        lh6.b r89 = r88.a();
        if (r89 == null) goto L215;
        r89.l();
        goto L215
    L257:
        return;
    L193:
        r77 = null;
        goto L195
    L256:
        return;
    }

    public static final void h(SwitchCameraManager r4, String r5) {
        r4.getClass();
        HashMap r6 = new HashMap();
        r6.put("selection", r5);
        com.bytedance.live.datacontext.j r7 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        List r0 = null;
        if (r7 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
        if (r8 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r9 = r8.t();
        if (r9 == null) goto L9;
        TalkRoomLogUtils.B0(r6, Integer.valueOf(r9.a), null, 4);
        TalkRoomLogUtils.I0(r6, r9.a);
    L9:
        com.bytedance.live.datacontext.j r10 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r10 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r10.getValue();
        if (r11 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r12 = r11.t();
        if (r12 == null) goto L22;
        List r13 = r12.b;
        if (r13 == null) goto L22;
        if (r13.contains(1) == false) goto L20;
        r0 = r13;
    L20:
        if (r0 == null) goto L22;
        r6.put("play_type", "video_friend");
    L22:
        j0.l().sendLog("livesdk_anchor_audience_connection_open_popup_click", r6, new Object[]{x.class, IRoom.class});
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.camera.b
    public final void b(String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "targetUid");
        if (this.g.a() == true) goto L6;
        f2.b(2131917584, 0);
        return;
    L6:
        Ref.IntRef r6 = new Ref.IntRef();
        if (r13 == false) goto L9;
        int r0 = 1;
    L10:
        r6.element = r0;
        long r7 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.q0(r6.element, r12);
        int r1 = eg0.c.a;
        IRoom r2 = this.d;
        if (r2 == null) goto L13;
        long r3 = r2.getId();
    L14:
        Disposable r4 = eg0.c.a(r3, r12, r12, r6.element, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r12, r6, r7), new e(r6, r12, r7));
        this.a.add(r4);
        return;
    L13:
        r3 = 0;
        goto L14
    L9:
        r0 = 2;
        goto L10
    }

    public final void j(String r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "targetUid");
        long r7 = System.currentTimeMillis();
        int r0 = eg0.c.a;
        IRoom r1 = this.d;
        if (r1 == null) goto L5;
        long r2 = r1.getId();
    L6:
        Disposable r14 = eg0.c.b(r2, r12, r12, r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r12, r13, r7), new c(this, r12, r13, r7));
        this.a.add(r14);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public SwitchCameraManager(Context r2, DataCenter r3, y r4, j1 r5) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mDataCenter");
        Intrinsics.checkNotNullParameter(r5, "scopeProvider");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.a = new CompositeDisposable();
        this.g = new b1();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.camera.b
    public final void f(boolean r9, boolean r10, boolean r11, boolean r12, com.bytedance.android.live.liveinteract.plantform.camera.a r13, String r14) {
        Intrinsics.checkNotNullParameter(r14, "reason");
        if (this.e == false) goto L8;
        if (r13 == null) goto L23;
        r13.onSuccess();
        return;
    L23:
        return;
    L8:
        if (this.g.a() == true) goto L15;
        if (r11 == true) goto L15;
        if (r12 == true) goto L15;
        f2.b(2131917584, 0);
        if (r13 == null) goto L24;
        r13.onSuccess();
        return;
    L24:
        return;
    L15:
        cg6.a r0 = i();
        if (r0 == null) goto L25;
        jg6.a r1 = r0.e5();
        if (r1 == null) goto L26;
        lh6.b r2 = r1.a();
        if (r2 == null) goto L27;
        r2.k(r9, r10, r11, r12, new f(r13), r14);
        return;
    L27:
        return;
    L26:
        return;
    }
}
