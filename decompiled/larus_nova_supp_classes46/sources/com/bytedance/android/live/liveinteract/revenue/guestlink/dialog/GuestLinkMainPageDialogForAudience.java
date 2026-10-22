package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkWidget;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/dialog/GuestLinkMainPageDialogForAudience;", "Lcom/bytedance/android/live/liveinteract/revenue/guestlink/dialog/BaseGuestLinkMainPageDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestLinkMainPageDialogForAudience extends BaseGuestLinkMainPageDialog {
    public static final /* synthetic */ int S = 0;
    public com.bytedance.android.livesdk.multilink.base.model.guestlink.b K;
    public DataCenter L;
    public LivePlayerView M;
    public ILivePlayerClient N;
    public boolean O;
    public final com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.h P;
    public final com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.g Q;
    public final j1 R;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

        public b(GuestLinkMainPageDialogForAudience r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ALogger.i("GuestLinkMainPageDialogForAudience", "click touch_outside");
            this.a.onBackPressed();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

        public c(GuestLinkMainPageDialogForAudience r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ALogger.i("GuestLinkMainPageDialogForAudience", "click back_press_arrow");
            this.a.onBackPressed();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

        public d(GuestLinkMainPageDialogForAudience r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            GuestLinkMainPageDialogForAudience.fa0(this.a);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

        public e(GuestLinkMainPageDialogForAudience r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            ALogger.i("GuestLinkMainPageDialogForAudience", "onClick button_report");
            Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            if (r0 == null) goto L29;
            com.bytedance.android.live.base.model.message.guestlink.a r1 = this.a.T90();
            if (r1 == null) goto L30;
            HashMap r2 = new HashMap();
            r2.put("guest_link_channel_id", String.valueOf(r1.getChannelId()));
            List r3 = r1.getLinkedUsers();
            String r4 = "";
            if (r3 == null) goto L14;
            com.bytedance.android.live.base.model.message.guestlink.k r5 = (com.bytedance.android.live.base.model.message.guestlink.k) CollectionsKt.getOrNull(r3, 0);
            if (r5 == null) goto L14;
            IBaseUser r6 = r5.getUser();
            if (r6 == null) goto L14;
            String r8 = r6.getIdString();
            if (r8 == null) goto L14;
        L15:
            r2.put("guest_link_user1", r8);
            List r9 = r1.getLinkedUsers();
            if (r9 == null) goto L25;
            com.bytedance.android.live.base.model.message.guestlink.k r10 = (com.bytedance.android.live.base.model.message.guestlink.k) CollectionsKt.getOrNull(r9, 1);
            if (r10 == null) goto L25;
            IBaseUser r11 = r10.getUser();
            if (r11 == null) goto L25;
            String r12 = r11.getIdString();
            if (r12 == null) goto L25;
            r4 = r12;
        L25:
            r2.put("guest_link_user2", r4);
            ALogger.i("GuestLinkMainPageDialogForAudience", "show reportPage, extraParams: " + r2);
            IMiddlewareReportService r13 = jc1.k.f(IMiddlewareReportService.class);
            if (r13 == null) goto L31;
            y71.a r14 = new y71.a(ReportConstant.BusinessSource.MultiLinkGuestLink);
            r14.a = r0.getOwner();
            r14.b = r0;
            r14.c = "guest_link";
            r14.e = "report_anchor";
            r14.h = r2;
            r13.report(r14);
            return;
        L31:
            return;
        L14:
            r8 = "";
            goto L15
        L30:
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

        public f(GuestLinkMainPageDialogForAudience r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            GuestLinkMainPageDialogForAudience.fa0(this.a);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

        public g(GuestLinkMainPageDialogForAudience r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ALogger.i("GuestLinkMainPageDialogForAudience", "enter last channel");
            com.bytedance.android.live.base.model.message.guestlink.a r11 = this.a.T90();
            if (r11 == null) goto L5;
            tb6.a.e(false, r11, "last", null);
        L5:
            lb6.g r0 = this.a.D;
            if (r0 == null) goto L13;
            long r1 = je0.d.a0();
            com.bytedance.android.live.base.model.message.guestlink.a r12 = this.a.T90();
            if (r12 == null) goto L10;
            long r3 = r12.getChannelId();
        L11:
            r0.i(r1, r3, 0, 1);
            return;
        L10:
            r3 = 0;
            goto L11
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

        public h(GuestLinkMainPageDialogForAudience r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ALogger.i("GuestLinkMainPageDialogForAudience", "enter next channel");
            com.bytedance.android.live.base.model.message.guestlink.a r11 = this.a.T90();
            if (r11 == null) goto L5;
            tb6.a.e(false, r11, "next", null);
        L5:
            lb6.g r0 = this.a.D;
            if (r0 == null) goto L13;
            long r1 = je0.d.a0();
            com.bytedance.android.live.base.model.message.guestlink.a r12 = this.a.T90();
            if (r12 == null) goto L10;
            long r3 = r12.getChannelId();
        L11:
            r0.i(r1, r3, 0, 2);
            return;
        L10:
            r3 = 0;
            goto L11
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void ca0() {
        LivePlayerView r0 = this.M;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    public final boolean onBackPressed() {
        ALogger.i("GuestLinkMainPageDialogForAudience", "onBackPressed");
        com.bytedance.android.live.base.model.message.guestlink.a r1 = T90();
        if (r1 == null) goto L15;
        ALogger.i("GuestLinkMainPageDialogForAudience", "leaveChannel, channelId: " + r1.getChannelId());
        tb6.a.e(false, r1, "out", null);
        lb6.g r4 = this.D;
        if (r4 == null) goto L15;
        r4.g(je0.d.a0(), r1.getChannelId(), "onBackPressed", true);
    L15:
        dismiss();     // Catch: Exception -> L9
    L14:
        return super.onBackPressed();
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L14;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void onDestroy() {
        ALogger.i("GuestLinkMainPageDialogForAudience", "onDestroy");
        super.onDestroy();
        com.bytedance.android.live.base.model.message.guestlink.a r1 = T90();
        if (r1 == null) goto L7;
        ALogger.i("GuestLinkMainPageDialogForAudience", "onDestroy -> leaveChannel, channelId: " + r1.getChannelId());
        lb6.g r3 = this.D;
        if (r3 == null) goto L7;
        r3.g(je0.d.a0(), r1.getChannelId(), "GuestLinkMainPageDialogForAudience#onDestroy", false);
    L7:
        this.L = null;
        hd0.c.f().e(this.P);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void onDestroyView() {
        ALogger.i("GuestLinkMainPageDialogForAudience", "onDestroyView");
        super.onDestroyView();
        ALogger.i("GuestLinkMainPageDialogForAudience", "releaseLivePlayer");
        ILivePlayerClient r0 = this.N;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.N = null;
        lb6.g r1 = this.D;
        if (r1 == null) goto L9;
        r1.b(this.Q);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void initView() {
        super.initView();
        Dialog r0 = getDialog();
        if (r0 == null) goto L9;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        View r2 = r1.findViewById(2131389843);
        if (r2 == null) goto L9;
        r2.setOnClickListener(new b(this));
    L9:
        View r3 = this.s;
        if (r3 == null) goto L12;
        r3.setOnClickListener(new c(this));
    L12:
        View r4 = this.s;
        if (r4 == null) goto L15;
        r4.setVisibility(0);
    L15:
        TextView r5 = this.t;
        if (r5 == null) goto L22;
        String r6 = vm2.i.e().getWatcherPageTitle();
        if (r6 != null) goto L21;
        r6 = s1.B(2131917294);
    L21:
        r5.setText(r6);
    L22:
        com.bytedance.android.livesdk.multilink.base.model.guestlink.b r7 = this.K;
        if (r7 == null) goto L26;
        com.bytedance.android.live.base.model.message.guestlink.a r8 = r7.getChannelInfo();
        if (r8 == null) goto L26;
    L28:
        if (je0.d.D() == false) goto L35;
        View r9 = this.l;
        if (r9 == null) goto L32;
        r9.setVisibility(0);
    L32:
        View r10 = this.l;
        if (r10 == null) goto L52;
        r10.setOnClickListener(new d(this));
    L52:
        Button r11 = this.q;
        if (r11 == null) goto L59;
        String r12 = vm2.i.e().getWatcherPageLeftBtnText();
        if (r12 != null) goto L58;
        r12 = s1.B(2131917270);
    L58:
        r11.setText(r12);
    L59:
        Button r13 = this.q;
        if (r13 == null) goto L62;
        r13.setOnClickListener(new g(this));
    L62:
        Button r14 = this.r;
        if (r14 == null) goto L69;
        String r15 = vm2.i.e().getWatcherPageRightBtnText();
        if (r15 != null) goto L68;
        r15 = s1.B(2131917271);
    L68:
        r14.setText(r15);
    L69:
        Button r16 = this.r;
        if (r16 == null) goto L72;
        r16.setOnClickListener(new h(this));
    L72:
        ALogger.i("GuestLinkMainPageDialogForAudience", "initChannelPlayerView");
        View r17 = this.d;
        ILivePlayerClient r18 = null;
        if (r17 == null) goto L79;
        ViewStub r19 = (ViewStub) r17.findViewById(2131378440);
        if (r19 == null) goto L79;
        View r20 = r19.inflate();
        if (r20 == null) goto L79;
        LivePlayerView r21 = (LivePlayerView) r20.findViewById(2131378439);
    L80:
        this.M = r21;
        if (r21 == null) goto L83;
        r18 = r21.getClient();
    L83:
        this.N = r18;
        lb6.g r22 = this.D;
        if (r22 == null) goto L93;
        sb6.a r23 = r22.getLinkState();
        if (r23 == null) goto L93;
        com.bytedance.android.livesdk.multilink.base.model.guestlink.b r24 = r23.d;
        if (r24 == null) goto L93;
        String r25 = r24.getStreamData();
        if (r25 == null) goto L93;
        ha0(r25);
    L93:
        if (r8 == null) goto L95;
        long r26 = r8.getCallDuration();
    L97:
        if (r26 > 0) goto L100;
        aa0(-1);
        return;
    L100:
        return;
    L95:
        r26 = 0;
    L79:
        r21 = null;
        goto L80
    L35:
        TextView r27 = this.m;
        if (r27 == null) goto L38;
        r27.setVisibility(0);
    L38:
        TextView r28 = this.m;
        if (r28 == null) goto L42;
        r28.setOnClickListener(new e(this));
    L42:
        if (vi0.f.a(this.L) == false) goto L52;
        TextView r29 = this.n;
        if (r29 == null) goto L46;
        r29.setVisibility(0);
    L46:
        View r30 = this.o;
        if (r30 == null) goto L49;
        r30.setVisibility(0);
    L49:
        TextView r31 = this.n;
        if (r31 == null) goto L52;
        r31.setOnClickListener(new f(this));
    L26:
        r8 = T90();
        goto L28
    }

    public static final void fa0(GuestLinkMainPageDialogForAudience r6) {
        r6.getClass();
        ALogger.i("GuestLinkMainPageDialogForAudience", "click finishChannel");
        com.bytedance.android.live.base.model.message.guestlink.a r0 = r6.T90();
        if (r0 == null) goto L5;
        long r2 = (p6.b() - r0.getStartTimeMs()) / ((long) 1000);
        int r4 = tb6.a.a;
        tb6.a.e(false, r0, "end", Long.valueOf(r2));
    L5:
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = null;
        String r3 = vm2.i.e().getAnchorFinishChannelDoubleCheckTitle();
        if (r3 != null) goto L8;
        r3 = s1.B(2131917283);
    L8:
        String r5 = vm2.i.e().getAnchorFinishChannelDoubleCheckMsg();
        if (r5 != null) goto L11;
        r5 = s1.B(2131917279);
    L11:
        x0.b r7 = new x0.b(r6.requireContext(), 0);
        x0.d r8 = r7.a;
        r8.c = r3;
        r8.d = r5;
        r7.setCornerRadius(16.0f);
        r7.i(0, 2131917281, new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.e(r1));
        r7.i(1, 2131917282, new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.f(r6, r1));
        x0 r9 = r7.h();
        r1.element = r9;
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(r9);
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
    }

    public final void ga0(ArrayList<Map<String, Object>> r8) {
        if (r8 == null) goto L31;
        Iterator<T> r9 = r8.iterator();
    L5:
        if (r9.hasNext() == false) goto L37;
        Map r0 = (Map) r9.next();
        Object r1 = r0.get("talk");
        String r3 = null;
        if ((r1 instanceof Double) == true) goto L9;
        r1 = null;
    L9:
        Double r2 = (Double) r1;
        Object r4 = r0.get("uid");
        if ((r4 instanceof String) == true) goto L12;
        r4 = null;
    L12:
        String r5 = (String) r4;
        Object r6 = r0.get("volume");
        if ((r6 instanceof Double) == true) goto L15;
        r6 = null;
    L15:
        Number r7 = (Double) r6;
        if (r7 != null) goto L18;
        r7 = 0;
    L18:
        com.bytedance.android.live.base.model.message.guestlink.a r10 = T90();
        Intrinsics.checkNotNull(r10);
        com.bytedance.android.live.base.model.message.guestlink.k r11 = BaseGuestLinkMainPageDialog.U90(r10);
        if (r11 == null) goto L21;
        String r12 = r11.getLinkmicIdStr();
    L23:
        if (Intrinsics.areEqual(r12, r5) == false) goto L25;
        ea0(r11, this.y, this.w, r7.intValue());
    L25:
        com.bytedance.android.live.base.model.message.guestlink.a r13 = T90();
        Intrinsics.checkNotNull(r13);
        com.bytedance.android.live.base.model.message.guestlink.k r14 = BaseGuestLinkMainPageDialog.V90(r13);
        if (r14 == null) goto L29;
        r3 = r14.getLinkmicIdStr();
    L29:
        if (Intrinsics.areEqual(r3, r5) == false) goto L5;
        ea0(r14, this.z, this.x, r7.intValue());
        goto L5
    L21:
        r12 = null;
        goto L23
    L37:
        return;
    }

    public final void ha0(String r3) {
        ALogger.i("GuestLinkMainPageDialogForAudience", "startPlay: ".concat(r3));
        LiveRequest r4 = new LiveRequest.Builder().streamData(r3).resolution("origin").preview(false).mute(false).build();
        ILivePlayerClient r0 = this.N;
        if (r0 == null) goto L6;
        r0.stream(r4, new GuestLinkMainPageDialogForAudience$startPlay$1(this));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void onCreate(Bundle r3) {
        ALogger.i("GuestLinkMainPageDialogForAudience", "onCreate");
        super.onCreate(r3);
        com.bytedance.android.livesdk.multilink.base.model.guestlink.b r4 = this.K;
        if (r4 == null) goto L8;
        com.bytedance.android.live.base.model.message.guestlink.a r5 = r4.getChannelInfo();
        if (r5 == null) goto L8;
        tb6.a.f(false, r5);
    L8:
        if (je0.d.r() == false) goto L10;
    L11:
        f2.b(2131917269, 0);
    L12:
        hd0.c.f().c(this.P);
        return;
    L10:
        if (hd0.c.f().h() == false) goto L12;
        goto L11
    }

    public GuestLinkMainPageDialogForAudience(GuestLinkWidget r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "outerScopeProvider");
        super(r2, r3);
        this.R = r2;
        this.O = hd0.c.f().h();
        this.P = new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.h(this);
        this.Q = new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.g(this);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ALogger.i("GuestLinkMainPageDialogForAudience", "onViewCreated");
        super.onViewCreated(r3, r4);
        lb6.g r5 = this.D;
        if (r5 == null) goto L6;
        r5.d(this.Q, false);
        return;
    }
}
