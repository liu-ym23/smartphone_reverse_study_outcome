package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.WebcastPaidLiveDataMessage;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarVSMsgBoardBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, vlc.l {
    public static final /* synthetic */ int i = 0;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s a;
    public View b;
    public ToolbarVSMsgBoardBehavior c;
    public Disposable d;
    public Disposable e;
    public final Lazy f;
    public final boolean g;
    public final DataCenter h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ToolbarVSMsgBoardBehavior a;
        public final /* synthetic */ DataCenter b;
        public final /* synthetic */ View c;

        public b(ToolbarVSMsgBoardBehavior r1, DataCenter r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            sh6.b r4 = (sh6.b) r3;
            DataCenter r5 = this.b;
            Boolean r0 = Boolean.FALSE;
            if (((Boolean) r5.get("showPanelBefore", r0)).booleanValue() == true) goto L7;
            if (((Boolean) this.b.get("show_msg_board", r0)).booleanValue() == false) goto L7;
        L8:
            this.a.b(this.c, "passive");
            return;
        L7:
            if (TextUtils.isEmpty((CharSequence) this.b.get("comment_id")) == false) goto L8;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r5) {
        this.a = r5;
        if (r5 == null) goto L11;
        py.k r6 = r5.c;
        if (r6 != null) goto L7;
        return;
    L7:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.h).n(ToolbarButton.VS_MESSAGE_BOARD) == false) goto L13;
        this.d = com.bytedance.android.livesdk.chatroom.utils.a1.l(r6, com.bytedance.android.live.core.utils.s1.f(38.0f), com.bytedance.android.live.core.utils.s1.f(38.0f), false, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new r5(this), s5.a);
        return;
    L13:
        return;
    }

    public final void a(final String r6) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.h, 0, 2);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getLoggerHelper();
        if (r1 == null) goto L9;
        r1.c(new ToolbarVSMsgBoardBehavior$logEvent$1(this, r6));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r4) {
        Intrinsics.checkNotNullParameter(r4, "command");
        if (this.g == false) goto L6;
        return;
    L6:
        if ((r4 instanceof pp1.g) == false) goto L18;
        StringBuilder r0 = new StringBuilder("move to more = ");
        pp1.g r5 = (pp1.g) r4;
        r0.append(r5.a);
        ALogger.e("ToolbarVSMsgBoardBehavior", r0.toString());
        DataCenter r1 = this.h;
        if (r1 == null) goto L11;
        r1.put("data_vs_message_board_move_to_more", Boolean.valueOf(r5.a));
    L11:
        if (r5.a == true) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.h).d(ToolbarButton.VS_MESSAGE_BOARD, this.c);
        return;
    L13:
        if (this.c != null) goto L15;
        this.c = new ToolbarVSMsgBoardBehavior(true, this.h);
    L15:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.h).k(ToolbarButton.VS_MESSAGE_BOARD, this.c);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        b(r2, "active");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void onHide(boolean r1) {
        this.a = null;
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof WebcastPaidLiveDataMessage) == false) goto L9;
        qh1.a r4 = pm1.f.n();
        if (r4 == null) goto L7;
        r4.paidStatusChanged(this.h);
    L7:
        jc1.k.n(IExternalBrowserService.class).enqueueEvent("ticket_unpaid", new JSONObject());
        return;
    }

    public ToolbarVSMsgBoardBehavior(boolean r1, DataCenter r2) {
        this.g = r1;
        this.h = r2;
        this.f = LazyKt.lazy(new ToolbarVSMsgBoardBehavior$params$2(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Disposable r4 = this.d;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        Disposable r5 = this.e;
        if (r5 == null) goto L9;
        r5.dispose();
        return;
    }

    public final void b(View r11, String r12) {
        IVSPlayerService r0 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = r0.provideVSPlayerViewControlService(this.h);
        if (r1 == null) goto L7;
        r1.setVisibilityStatus(false);
    L7:
        Disposable r2 = this.e;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        DataCenter r3 = this.h;
        if (r3 == null) goto L13;
        r3.put("showPanelBefore", Boolean.TRUE);
    L13:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r4 = this.a;
        Uri r5 = null;
        if (r4 == null) goto L16;
        String r6 = r4.e;
    L18:
        if (TextUtils.isEmpty(r6) == false) goto L24;
        qh1.a r7 = pm1.f.n();
        if (r7 == null) goto L22;
        r6 = r7.getMsgBoardSchema(this.h);
        goto L24
    L22:
        r6 = null;
    L24:
        if (TextUtils.isEmpty(r6) == false) goto L26;
        return;
    L26:
        a("livesdk_vs_guest_book_icon_click");
        a("livesdk_toolbar_icon_click");
        if (r11 == null) goto L29;
        Context r13 = r11.getContext();
    L30:
        DataCenter r8 = this.h;
        if (r13 == null) goto L102;
        if (r8 == null) goto L103;
        Uri r9 = UriProtector.parse(new UrlBuilder(r6).build());
        if (r9 == null) goto L36;
        String r10 = UriProtector.getQueryParameter(r9, "url");
    L38:
        if (TextUtils.isEmpty(r10) == false) goto L40;
        Uri.Builder r14 = r9.buildUpon();
    L49:
        if (r14 == null) goto L82;
        Map r15 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        if (r15 == null) goto L55;
        Map r16 = (Map) this.f.getValue();
        if (r16 == null) goto L55;
        r16.putAll(r15);
    L55:
        Map r17 = com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap();
        if (r17 == null) goto L60;
        Map r18 = (Map) this.f.getValue();
        if (r18 == null) goto L60;
        r18.putAll(r17);
    L60:
        Map r19 = (Map) this.f.getValue();
        if (r19 == null) goto L66;
        Iterator r20 = r19.entrySet().iterator();
    L64:
        if (r20.hasNext() == false) goto L66;
        Map.Entry r21 = (Map.Entry) r20.next();
        r14.appendQueryParameter((String) r21.getKey(), (String) r21.getValue());
    L66:
        Room r22 = com.bytedance.android.live.core.utils.z.o(r8);
        if (r22 == null) goto L70;
        String r23 = r22.getShareUrl();
        if (r23 == null) goto L70;
    L71:
        r14.appendQueryParameter("share_url", r23);
        r14.appendQueryParameter("show_type", r12);
        if (com.bytedance.android.live.core.utils.z.m(r8, true) == true) goto L79;
        if (PadConfigUtils.c() == true) goto L79;
        if (FoldScreenUtils.f() == true) goto L79;
        r14.appendQueryParameter("use_anim_in_landscape", "true");
    L79:
        if (TextUtils.isEmpty((CharSequence) r8.get("comment_id")) == true) goto L82;
        r14.appendQueryParameter("insert_comment_id", (String) r8.get("comment_id"));
        r8.put("comment_id", "");
    L70:
        r23 = "";
    L82:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r9, "url")) == true) goto L84;
        r5 = com.bytedance.android.live.schema.helper.h.b(r9, "url", String.valueOf(r14));
    L87:
        if (PadConfigUtils.c() == false) goto L89;
    L90:
        Intrinsics.checkNotNull(r5);
        r5 = com.bytedance.android.live.schema.helper.h.b(r5, "radius", "8");
    L92:
        if (FoldScreenUtils.f() == true) goto L94;
    L99:
        jc1.k.n(ILiveActionHandler.class).handle(r13, r5);
        return;
    L94:
        if (FoldScreenUtils.e() == false) goto L97;
        Intrinsics.checkNotNull(r5);
        Uri r110 = com.bytedance.android.live.schema.helper.h.b(r5, "use_player_bottom_height", "0");
        Intrinsics.checkNotNull(r110);
        r5 = com.bytedance.android.live.schema.helper.h.b(r110, "pad_use_player_bottom_height", "0");
    L97:
        if (com.bytedance.android.live.core.utils.z.m(r8, true) == true) goto L99;
        float r111 = ((com.bytedance.android.live.core.utils.s1.w() * 375) / 504) / com.bytedance.android.live.core.utils.s1.y();
        Intrinsics.checkNotNull(r5);
        r5 = com.bytedance.android.live.schema.helper.h.b(r5, "horizontal_width_percent", String.valueOf((int) (r111 * 100)));
        goto L99
    L89:
        if (com.bytedance.android.live.core.utils.z.m(r8, true) == true) goto L92;
    L84:
        if (r14 == null) goto L87;
        r5 = r14.build();
        goto L87
    L40:
        if (r9 == null) goto L43;
        String r24 = UriProtector.getQueryParameter(r9, "url");
        if (r24 == null) goto L43;
    L44:
        Uri r25 = UriProtector.parse(r24);
        if (r25 == null) goto L47;
        r14 = r25.buildUpon();
        goto L49
    L47:
        r14 = null;
    L43:
        r24 = "";
        goto L44
    L36:
        r10 = null;
        goto L38
    L103:
        return;
    L102:
        return;
    L29:
        r13 = null;
        goto L30
    L16:
        r6 = null;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        if (com.bytedance.android.live.core.utils.z.o(r8) == null) goto L11;
        qh1.a r0 = pm1.f.n();
        if (r0 == null) goto L11;
        if (r0.roomToolbarDataHasDress(com.bytedance.android.live.core.utils.z.o(r8)) != true) goto L11;
        vlc.d r1 = (vlc.d) r8.get("data_message_manager");
        if (r1 == null) goto L11;
        r1.addMessageListener(MessageType.PAID_LIVE_DATA_MESSAGE.getIntType(), this);
    L11:
        this.b = r7;
        Map r2 = (Map) this.f.getValue();
        if (r2 != null) goto L14;
    L18:
        a("livesdk_vs_guest_book_icon_show");
        View r3 = this.b;
        if (r3 == null) goto L21;
        r3.setOnClickListener(new com.bytedance.android.livesdk.utils.w0(new ToolbarVSMsgBoardBehavior$onLoad$1(this), 500));
    L21:
        Disposable r5 = null;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L28;
        com.bytedance.live.datacontext.j r6 = r4.isFirstFrameShown();
        if (r6 == null) goto L28;
        Maybe r9 = r6.b();
        if (r9 == null) goto L28;
        r5 = r9.subscribe(new b(this, r8, r7));
    L28:
        this.e = r5;
        com.bytedance.android.livesdk.r3.c(this.b, "留言墙", true);
        return;
    L14:
        if (this.g == false) goto L16;
        String r10 = "more";
    L17:
        String r11 = (String) r2.put("source", r10);
        goto L18
    L16:
        r10 = "toolbar";
        goto L17
    }
}
