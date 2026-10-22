package com.bytedance.android.live.livepkaudience.vm;

import am2.x;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.utils.b1;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.dialog.PkAudienceInviteOpenCameraDialog;
import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.w7;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerUpdateLinkTypeApplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerUpdateLinkTypeReplyContent;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import dl0.m;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkPkSwitchCameraManager implements com.bytedance.android.live.livepkaudience.vm.c, l {
    public final CompositeDisposable a;
    public vlc.d b;
    public PkAudienceInviteOpenCameraDialog c;
    public Room d;
    public boolean e;
    public boolean f;
    public final b1 g;
    public final Context h;
    public final DataCenter i;
    public final i j;
    public final com.bytedance.android.live.livepkaudience.vm.b k;

    public static final class a implements PkAudienceInviteOpenCameraDialog.b {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ LinkPkSwitchCameraManager b;
        public final /* synthetic */ tlc.d c;

        @Override // com.bytedance.android.live.livepkaudience.dialog.PkAudienceInviteOpenCameraDialog.b
        public final void a() {
            this.b.i(((LinkerUpdateLinkTypeApplyContent) this.a.element).getFromUserIdString(), ReplyType.Agree.ordinal());
            LinkPkSwitchCameraManager.g(this.b, "accept");
        }

        @Override // com.bytedance.android.live.livepkaudience.dialog.PkAudienceInviteOpenCameraDialog.b
        public final void onRefuse() {
            this.b.i(((LinkerUpdateLinkTypeApplyContent) this.a.element).getFromUserIdString(), ReplyType.Reject.ordinal());
            LinkPkSwitchCameraManager.g(this.b, "reject");
        }

        public a(Ref.ObjectRef r1, LinkPkSwitchCameraManager r2, tlc.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LinkPkSwitchCameraManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        public b(LinkPkSwitchCameraManager r1, String r2, int r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r14) {
            m r0 = m.a;
            String r1 = this.b;
            int r2 = this.c;
            long r10 = System.currentTimeMillis() - this.d;
            String r15 = ((ExtraResponse) r14).logId;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "toUserId");
            Intrinsics.checkNotNullParameter(r15, "logId");
            JSONObject r12 = new JSONObject();
            BaseMonitor.add(r12, "to_user_id", r1);
            BaseMonitor.add(r12, "api_log_id", r15);
            ReplyType r16 = ReplyType.Agree;
            if (r2 != r16.ordinal()) goto L6;
            String r3 = "agree";
        L9:
            BaseMonitor.add(r12, "reply_type", r3);
            m.z("audience_update_link_type_reply", 0, "", r10, r12);
            if (this.c != r16.ordinal()) goto L13;
            com.bytedance.android.live.livepkaudience.vm.c.b.a(this.a, true, false, true, false, true, 64);
            return;
        L13:
            return;
        L6:
            if (r2 != ReplyType.Reject.ordinal()) goto L8;
            r3 = "reject";
            goto L9
        L8:
            r3 = "unknown: " + r2;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public c(String r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r14) {
            ApiServerException r15 = (Throwable) r14;
            m r0 = m.a;
            String r1 = this.a;
            int r2 = this.b;
            long r10 = System.currentTimeMillis() - this.c;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "toUserId");
            JSONObject r12 = new JSONObject();
            BaseMonitor.add(r12, "to_user_id", r1);
            if (r2 != ReplyType.Agree.ordinal()) goto L6;
            String r3 = "agree";
        L9:
            BaseMonitor.add(r12, "reply_type", r3);
            if (r15 != null) goto L12;
        L18:
            ExceptionUtils.handleException(s1.getContext(), r15);
            return;
        L12:
            if ((r15 instanceof ApiServerException) == false) goto L17;
            ApiServerException r4 = r15;
            int r8 = r4.getErrorCode();
            String r5 = r4.getErrorMsg();
            if (r5 != null) goto L16;
            r5 = "";
        L16:
            m.z("audience_update_link_type_reply", r8, r5, r10, r12);
            goto L18
        L17:
            m.z("audience_update_link_type_reply", 1, r15.toString(), r10, r12);
            goto L18
        L6:
            if (r2 != ReplyType.Reject.ordinal()) goto L8;
            r3 = "reject";
            goto L9
        L8:
            r3 = "unknown: " + r2;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ long c;

        public d(String r1, Ref.IntRef r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r13) {
            String r0 = this.a;
            int r1 = this.b.element;
            long r2 = this.c;
            long r9 = System.currentTimeMillis() - r2;
            String r14 = ((ExtraResponse) r13).logId;
            m r3 = m.a;
            Intrinsics.checkNotNullParameter(r0, "toUserId");
            Intrinsics.checkNotNullParameter(r14, "logId");
            JSONObject r11 = new JSONObject();
            BaseMonitor.add(r11, "target_link_type", r1);
            BaseMonitor.add(r11, "to_user_id", r0.toString());
            BaseMonitor.add(r11, "api_log_id", r14);
            m.a.getClass();
            m.z("audience_update_link_type_apply", 0, "", r9, r11);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ long c;

        public e(String r1, Ref.IntRef r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r13) {
            ApiServerException r14 = (Throwable) r13;
            String r0 = this.a;
            int r1 = this.b.element;
            long r2 = this.c;
            long r9 = System.currentTimeMillis() - r2;
            m r3 = m.a;
            Intrinsics.checkNotNullParameter(r0, "toUserId");
            JSONObject r11 = new JSONObject();
            BaseMonitor.add(r11, "target_link_type", r1);
            BaseMonitor.add(r11, "to_user_id", r0.toString());
            if (r14 != null) goto L5;
        L11:
            ExceptionUtils.handleException(s1.getContext(), r14);
            return;
        L5:
            if ((r14 instanceof ApiServerException) == false) goto L10;
            m r4 = m.a;
            ApiServerException r5 = r14;
            int r7 = r5.getErrorCode();
            String r6 = r5.getErrorMsg();
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            r4.getClass();
            m.z("audience_update_link_type_apply", r7, r6, r9, r11);
            goto L11
        L10:
            m r8 = m.a;
            String r10 = r14.toString();
            r8.getClass();
            m.z("audience_update_link_type_apply", 1, r10, r9, r11);
            goto L11
        }
    }

    @Override // com.bytedance.android.live.livepkaudience.vm.c
    public final boolean a() {
        if (((Boolean) w7.a.getValue()).booleanValue() == true) goto L6;
        return false;
    L6:
        if (((Boolean) b6.h.getValue()).booleanValue() == true) goto L9;
        return false;
    L9:
        if (this.f == false) goto L11;
        return false;
    L11:
        return true;
    }

    public final void j() {
        this.d = (Room) this.i.get("data_room", new Room());
        this.e = ((Boolean) this.i.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        vlc.d r0 = (vlc.d) this.i.get("data_message_manager");
        this.b = r0;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.LINKER.getIntType(), this);
    L5:
        vlc.d r1 = this.b;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.LINK_MIC.getIntType(), this);
    L8:
        Pair r2 = com.bytedance.live.datacontext.d.a(LinkPkSwitchCameraManager$start$pair$1.INSTANCE);
        ((LinkPkSwitchCameraContext) r2.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r2.getFirst(), "ILinkPkSwitchCameraManager");
        this.a.add((Disposable) r2.getSecond());
    }

    @Override // com.bytedance.android.live.livepkaudience.vm.c
    public final boolean e() {
        return this.f;
    }

    public static void h(HashMap r2) {
        r2.put("pk_id", String.valueOf(k.n(ILinkServiceExternal.class).getMultiDataHolder().getPkId()));
        r2.put("is_in_pk", "1");
    }

    @Override // com.bytedance.android.live.livepkaudience.vm.c
    public final int c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "interactId");
        if (Intrinsics.areEqual(r4, tc0.c.h().f) == true) goto L5;
        i r0 = this.j;
        if (r0 == null) goto L17;
        CopyOnWriteArrayList<LinkPlayerInfo> r1 = r0.c;
        if (r1 == null) goto L22;
        Iterator<LinkPlayerInfo> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L23;
        LinkPlayerInfo r3 = r2.next();
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

    @Override // com.bytedance.android.live.livepkaudience.vm.c
    public final boolean d(String r5) {
        if (Intrinsics.areEqual(r5, tc0.c.h().f) == true) goto L5;
        i r0 = this.j;
        if (r0 == null) goto L22;
        CopyOnWriteArrayList<LinkPlayerInfo> r1 = r0.c;
        if (r1 == null) goto L23;
        Iterator<LinkPlayerInfo> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L25;
        LinkPlayerInfo r3 = r2.next();
        if (Intrinsics.areEqual(r3.getInteractId(), r5) == false) goto L12;
        if (r3.getLinkType() != 1) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    L23:
        return false;
    L22:
        return false;
    L5:
        return this.k.l5();
    }

    public final void onMessage(tlc.d r12) {
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r12 instanceof if) == false) goto L62;
        if r0 = (if) r12;
        int r1 = r0.mScene;
        if (r1 != 4) goto L9;
    L11:
        int r6 = r0.getMType();
        if (r6 != 18) goto L52;
        m.y((BaseMessage) r12, r0.getLinkerId(), r6, System.currentTimeMillis());
        StringBuilder r2 = new StringBuilder("LinkPkSwitchCameraManager onMessage LinkerMessage_18: isShowing = ");
        PkAudienceInviteOpenCameraDialog r3 = this.c;
        Integer r4 = null;
        if (r3 == null) goto L16;
        Boolean r5 = Boolean.valueOf(r3.isShowing());
    L17:
        r2.append(r5);
        r2.append(", linkType = ");
        LinkerUpdateLinkTypeApplyContent r7 = r0.mUpdateLinkTypeApplyContent;
        if (r7 == null) goto L20;
        r4 = Integer.valueOf(r7.linkType);
    L20:
        r2.append(r4);
        r2.append(", isCameraOn = ");
        r2.append(this.k.l5());
        r2.append(", ");
        String r8 = r2.toString();
        ALogger.i("LinkPkInteract", r8);
        m.a.getClass();
        m.C("LinkPkSwitchCameraManager_onMessage", r8);
        PkAudienceInviteOpenCameraDialog r9 = this.c;
        if (r9 == null) goto L26;
        if (r9.isShowing() != true) goto L26;
        return;
    L26:
        if (this.d == null) goto L63;
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        LinkerUpdateLinkTypeApplyContent r11 = r0.mUpdateLinkTypeApplyContent;
        r10.element = r11;
        CompositeDisposable r13 = LinkSecurityManager.b;
        LinkSecurityManager.b(r11.getToUserIdString(), ((LinkerUpdateLinkTypeApplyContent) r10.element).ackMessage, LinkSecurityManager.AckFromSource.PK_WITH_AUDIENCE_CAMERA_MESSAGE);
        LinkerUpdateLinkTypeApplyContent r14 = (LinkerUpdateLinkTypeApplyContent) r10.element;
        if (r14 == null) goto L49;
        if (r14.linkType != 1) goto L49;
        this.f = false;
        if (this.k.l5() == false) goto L35;
        return;
    L35:
        if (((Boolean) w7.a.getValue()).booleanValue() == false) goto L64;
        int r15 = PkAudienceInviteOpenCameraDialog.i;
        Room r16 = this.d;
        PkAudienceInviteOpenCameraDialog r17 = new PkAudienceInviteOpenCameraDialog();
        r17.h = r16;
        this.c = r17;
        r17.g = new a(r10, this, r12);
        FragmentActivity r18 = ContextUtil.contextToFragmentActivity(this.h);
        if (r18 == null) goto L47;
        FragmentManager r19 = r18.getSupportFragmentManager();
        if (r19 == null) goto L47;
        PkAudienceInviteOpenCameraDialog r20 = this.c;
        if (r20 == null) goto L47;
        LandscapeRestrictionOperation r21 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r20, "PkAudienceInviteOpenCameraDialog", r21);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r19, r20, r21) == true) goto L47;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L59
    L46:
        r20.show(r19, "PkAudienceInviteOpenCameraDialog");
    L47:
        HashMap r110 = new HashMap();
        h(r110);
        u.l().sendLog("livesdk_anchor_audience_connection_open_popup_show", r110, new Object[]{Room.class, x.class});
        return;
    L64:
        return;
    L49:
        if (Intrinsics.areEqual(r14.getToUserIdString(), k.n(IUserService.class).user().n()) == false) goto L66;
        com.bytedance.android.live.livepkaudience.vm.c.b.a(this, false, false, false, true, false, 112);
        cl0.a r111 = cl0.a.d;
        LinkedHashMap r22 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r23 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r24 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r23, "callback");
        Intrinsics.checkNotNullParameter(r24, "config");
        r111.e("close_camera_by_other", r22, r23, r24);
        this.f = true;
        return;
    L66:
        return;
    L63:
        return;
    L16:
        r5 = null;
        goto L17
    L52:
        if (r6 != 19) goto L68;
        m.y((BaseMessage) r12, r0.getLinkerId(), r6, System.currentTimeMillis());
        LinkerUpdateLinkTypeReplyContent r112 = r0.mUpdateLinkTypeReplyContent;
        if (r112 == null) goto L69;
        String r113 = r112.prompts;
        if (r113 == null) goto L70;
        f2.c(r113, 0);
        return;
    L70:
        return;
    L69:
        return;
    L68:
        return;
    L9:
        if (r1 == 8) goto L11;
        return;
    }

    public static final void g(LinkPkSwitchCameraManager r3, String r4) {
        r3.getClass();
        HashMap r5 = new HashMap();
        r5.put("selection", r4);
        h(r5);
        u.l().sendLog("livesdk_anchor_audience_connection_open_popup_click", r5, new Object[]{x.class, Room.class});
    }

    @Override // com.bytedance.android.live.livepkaudience.vm.c
    public final void b(String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "targetUid");
        if (this.g.a() == true) goto L6;
        f2.b(2131917584, 0);
        return;
    L6:
        Ref.IntRef r0 = new Ref.IntRef();
        if (r13 == false) goto L9;
        int r14 = 1;
    L10:
        r0.element = r14;
        long r1 = System.currentTimeMillis();
        int r15 = eg0.c.a;
        Room r16 = this.d;
        if (r16 == null) goto L13;
        long r3 = r16.id;
    L14:
        Disposable r17 = eg0.c.a(r3, r12, r12, r0.element, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r12, r0, r1), new e(r12, r0, r1));
        this.a.add(r17);
        return;
    L13:
        r3 = 0;
        goto L14
    L9:
        r14 = 2;
        goto L10
    }

    public final void i(String r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "targetUid");
        long r7 = System.currentTimeMillis();
        int r0 = eg0.c.a;
        Room r1 = this.d;
        if (r1 == null) goto L5;
        long r2 = r1.id;
    L6:
        Disposable r13 = eg0.c.b(r2, r11, r11.toString(), r12).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r11, r12, r7), new c(r11, r12, r7));
        this.a.add(r13);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public LinkPkSwitchCameraManager(Context r2, DataCenter r3, i r4, com.bytedance.android.live.livepkaudience.vm.b r5) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mDataCenter");
        Intrinsics.checkNotNullParameter(r5, "mSwitchCamera");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.a = new CompositeDisposable();
        this.g = new b1();
    }

    @Override // com.bytedance.android.live.livepkaudience.vm.c
    public final void f(boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, com.bytedance.android.live.livepkaudience.vm.a r15) {
        if (this.e == false) goto L8;
        if (r15 == null) goto L17;
        r15.onSuccess();
        return;
    L17:
        return;
    L8:
        if (this.g.a() == true) goto L15;
        if (r11 == true) goto L15;
        if (r12 == true) goto L15;
        f2.b(2131917584, 0);
        if (r15 == null) goto L18;
        r15.onError("");
        return;
    L18:
        return;
    L15:
        String r16 = "LinkPkSwitchCameraManager switchSelfCamera openCamera: " + r9 + ", switchCamera: " + r10 + ", skipServer: " + r11 + ", skipFrequncy: " + r12 + ", skipShowBeauty: " + r13 + ", agreeOpen: " + r14 + ' ';
        ALogger.i("LinkPkInteract", r16);
        m.a.getClass();
        m.C("LinkPkSwitchCameraManager_switchSelfCamera", r16);
        this.k.Mo(r9, r10, r11, r12, r13, r15);
    }
}
