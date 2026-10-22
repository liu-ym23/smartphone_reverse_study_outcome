package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkWidget;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.guestlink.model.ChannelFinishReason;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hh1.v0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import uf2.d0;
import uf2.m1;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/dialog/GuestLinkMainPageDialogForLinker;", "Lcom/bytedance/android/live/liveinteract/revenue/guestlink/dialog/BaseGuestLinkMainPageDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestLinkMainPageDialogForLinker extends BaseGuestLinkMainPageDialog {
    public static final /* synthetic */ int P = 0;
    public boolean K;
    public long L;
    public IVoiceLiveTheme M;
    public final q N;
    public final j1 O;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForLinker a;

        public d(GuestLinkMainPageDialogForLinker r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            ALogger.i("GuestLinkMainPageDialogForLinker", "show helpPage");
            com.bytedance.android.live.base.model.message.guestlink.a r6 = this.a.T90();
            if (r6 == null) goto L5;
            tb6.a.e(true, r6, "rules", null);
        L5:
            int r7 = com.bytedance.android.live.liveinteract.revenue.guestlink.a.a;
            Context r8 = this.a.requireContext();
            Intrinsics.checkNotNullParameter(r8, "context");
            String r1 = vm2.i.e().getGuidePanelSchema();
            String r2 = "";
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            String r3 = vm2.i.e().getGuidePanelUrl();
            if (r3 == null) goto L12;
            r2 = r3;
        L12:
            com.bytedance.android.live.liveinteract.revenue.guestlink.a.a(r8, r1, r2, null);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForLinker a;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ Ref.ObjectRef a;

            public a(Ref.ObjectRef r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r3, int r4) {
                Dialog r5 = (Dialog) this.a.element;
                if (r5 == null) goto L21;
                Handler r6 = DialogLancet.resolveDialogHandler(r5);
                if (r6 != null) goto L7;
            L9:
                DialogLancet.beforeDialogDismiss(r5);
                r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
            L18:
                DialogLancet.afterDialogDismiss(r5);
                goto L21
            L14:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
                Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
                if (r7 == null) goto L18;
                com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r5);
                throw th;
            L7:
                if (Looper.myLooper() == r6.getLooper()) goto L9;
                r6.post(DialogLancet.createDismissRunnable(r5));
            L21:
                ALogger.i("GuestLinkMainPageDialogForLinker", "click finishChannel, negative button");
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ e a;
            public final /* synthetic */ Ref.ObjectRef b;

            public b(e r1, Ref.ObjectRef r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r12, int r13) {
                ALogger.i("GuestLinkMainPageDialogForLinker", "click finishChannel, positive button");
                com.bytedance.android.live.base.model.message.guestlink.a r14 = this.a.a.T90();
                if (r14 == null) goto L23;
                long r0 = (p6.b() - r14.getStartTimeMs()) / ((long) 1000);
                int r15 = tb6.a.a;
                tb6.a.e(true, r14, "double_end", Long.valueOf(r0));
                List r16 = r14.getLinkedUsers();
                com.bytedance.android.live.base.model.message.guestlink.k r2 = null;
                Object r3 = null;
                if (r16 == null) goto L17;
                Iterator r17 = r16.iterator();
            L8:
                if (r17.hasNext() == false) goto L16;
                Object r4 = r17.next();
                IBaseUser r5 = ((com.bytedance.android.live.base.model.message.guestlink.k) r4).getUser();
                if (r5 == null) goto L12;
                String r6 = r5.getIdString();
            L14:
                if (Intrinsics.areEqual(r6, je0.d.b0()) == false) goto L8;
                r3 = r4;
                goto L16
            L12:
                r6 = null;
            L16:
                r2 = (com.bytedance.android.live.base.model.message.guestlink.k) r3;
            L17:
                if (r2 != null) goto L19;
            L21:
                String r18 = "user";
            L22:
                tb6.a.d(true, r14, r18, r0);
                goto L23
            L19:
                if (com.bytedance.android.live.base.model.message.guestlink.l.a(r2) != true) goto L21;
                r18 = "audience";
            L23:
                Dialog r19 = (Dialog) this.b.element;
                if (r19 == null) goto L42;
                Handler r110 = DialogLancet.resolveDialogHandler(r19);
                if (r110 != null) goto L28;
            L30:
                DialogLancet.beforeDialogDismiss(r19);
                r19.dismiss();     // Catch: Throwable -> L33 Exception -> L35
            L39:
                DialogLancet.afterDialogDismiss(r19);
                goto L42
            L33:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r19);
                throw th;
            L35:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L33
                Throwable r111 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L33
                if (r111 == null) goto L39;
                com.bytedance.crash.d.d(r111, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L33
                goto L39
            L28:
                if (Looper.myLooper() == r110.getLooper()) goto L30;
                r110.post(DialogLancet.createDismissRunnable(r19));
            L42:
                int r112 = vi0.b.a;
                com.bytedance.android.live.base.model.message.guestlink.a r113 = this.a.a.T90();
                if (r113 == null) goto L46;
                String r114 = String.valueOf(r113.getChannelId());
                if (r114 == null) goto L46;
            L47:
                String r1 = String.valueOf(je0.d.a0());
                ChannelFinishReason r7 = ChannelFinishReason.LINKER;
                String r8 = r7.getRequestSource();
                Intrinsics.checkNotNullParameter(r114, "channelId");
                Intrinsics.checkNotNullParameter(r1, "roomId");
                Intrinsics.checkNotNullParameter("", "errorMsg");
                Intrinsics.checkNotNullParameter(r8, "source");
                JSONObject r9 = new JSONObject();
                r9.put("channel_id", r114);
                r9.put("room_id", r1);
                r9.put("error", "");
                r9.put("source", r8);
                int r115 = rd0.a.a;
                rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_channel_finish_api_call", 0, null, r9, 88);
                lb6.g r10 = this.a.a.D;
                if (r10 == null) goto L61;
                long r11 = je0.d.a0();
                com.bytedance.android.live.base.model.message.guestlink.a r116 = this.a.a.T90();
                if (r116 == null) goto L52;
                long r117 = r116.getChannelId();
            L53:
                r10.c(r11, r117, r7.getRequestSource(), r7.getRequestSource(), true);
                return;
            L52:
                r117 = 0;
                goto L53
            L61:
                return;
            L46:
                r114 = "";
                goto L47
            }
        }

        public e(GuestLinkMainPageDialogForLinker r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            ALogger.i("GuestLinkMainPageDialogForLinker", "click finishChannel");
            if (this.a.T90() != null) goto L12;
            ALogger.e("GuestLinkMainPageDialogForLinker", "click finishChannel, channelInfo is null");
            this.a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r8 = DialogFragmentLancet.sLastShowStack;
            if (r8 == null) goto L32;
            com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L32:
            return;
        L12:
            com.bytedance.android.live.base.model.message.guestlink.a r9 = this.a.T90();
            if (r9 == null) goto L15;
            long r1 = (p6.b() - r9.getStartTimeMs()) / ((long) 1000);
            int r3 = tb6.a.a;
            tb6.a.e(true, r9, "end", Long.valueOf(r1));
        L15:
            Ref.ObjectRef r10 = new Ref.ObjectRef();
            r10.element = null;
            String r2 = vm2.i.e().getLinkerFinishChannelDoubleCheckTitle();
            if (r2 != null) goto L18;
            r2 = s1.B(2131917284);
        L18:
            String r4 = vm2.i.e().getLinkerFinishChannelDoubleCheckMsg();
            if (r4 != null) goto L21;
            r4 = s1.B(2131917280);
        L21:
            x0.b r5 = new x0.b(this.a.requireContext(), 0);
            x0.d r6 = r5.a;
            r6.c = r2;
            r6.d = r4;
            r5.setCornerRadius(16.0f);
            r5.i(0, 2131917281, new a(r10));
            r5.i(1, 2131917282, new b(this, r10));
            x0 r0 = r5.h();
            r10.element = r0;
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L30;
            DialogLancet.handleBlockedDialogShow(r0);
            return;
        L30:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L25:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ GuestLinkMainPageDialogForLinker a;

        public f(GuestLinkMainPageDialogForLinker r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ALogger.i("GuestLinkMainPageDialogForLinker", "click send gift");
            com.bytedance.android.live.base.model.message.guestlink.a r0 = this.a.T90();
            if (r0 == null) goto L46;
            com.bytedance.android.live.base.model.message.guestlink.k r3 = null;
            Object r4 = null;
            tb6.a.e(true, r0, PbRequest.SwitchType.GIFT, null);
            long r5 = r0.getChannelId();
            List r2 = r0.getLinkedUsers();
            if (r2 == null) goto L18;
            Iterator r6 = r2.iterator();
        L8:
            if (r6.hasNext() == false) goto L16;
            Object r7 = r6.next();
            IBaseUser r8 = ((com.bytedance.android.live.base.model.message.guestlink.k) r7).getUser();
            if (r8 == null) goto L12;
            String r9 = r8.getIdString();
        L14:
            if (Intrinsics.areEqual(r9, je0.d.b0()) == false) goto L8;
        L17:
            com.bytedance.android.live.base.model.message.guestlink.k r11 = (com.bytedance.android.live.base.model.message.guestlink.k) r7;
        L19:
            List r1 = r0.getLinkedUsers();
            if (r1 == null) goto L32;
            Iterator r12 = r1.iterator();
        L23:
            if (r12.hasNext() == false) goto L31;
            Object r13 = r12.next();
            IBaseUser r14 = ((com.bytedance.android.live.base.model.message.guestlink.k) r13).getUser();
            if (r14 == null) goto L27;
            String r15 = r14.getIdString();
        L29:
            if ((!Intrinsics.areEqual(r15, je0.d.b0())) == false) goto L23;
            r4 = r13;
            goto L31
        L27:
            r15 = null;
        L31:
            r3 = (com.bytedance.android.live.base.model.message.guestlink.k) r4;
        L32:
            if (r11 == null) goto L38;
            if (r3 == null) goto L38;
            g50.c r16 = jc1.k.f(g50.c.class);
            if (r16 == null) goto L47;
            IBaseUser r17 = r3.getUser();
            Bundle r18 = new Bundle();
            r18.putString("gift_show_from", "audience_linkingpage");
            r18.putLong("guest_link_channel_id", r5);
            Unit r19 = Unit.INSTANCE;
            r16.openGiftDialog(r17, r18);
            return;
        L47:
            return;
        L38:
            ALogger.e("GuestLinkMainPageDialogForLinker", "send gift failed, cause: selfUser: " + r11 + ", targetUser: " + r3);
            return;
        L12:
            r9 = null;
            goto L14
        L16:
            r7 = null;
            goto L17
        L18:
            r11 = null;
            goto L19
        }
    }

    public static final class g implements rb6.a.a {
        public final /* synthetic */ GuestLinkMainPageDialogForLinker a;

        public g(GuestLinkMainPageDialogForLinker r1) {
            this.a = r1;
        }

        public final void W(long r1, OperateType r3) {
            Intrinsics.checkNotNullParameter(r3, "operationType");
            ALogger.d("GuestLinkMainPageDialogForLinker", "onPermissionCheckSuccess");
        }

        public final void c1(long r1, OperateType r3, BaseCheckException r4) {
            Intrinsics.checkNotNullParameter(r3, "operationType");
            Intrinsics.checkNotNullParameter(r4, "exception");
            ALogger.d("GuestLinkMainPageDialogForLinker", "onPermissionCheckFailed");
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r2 = DialogFragmentLancet.sLastShowStack;
            if (r2 == null) goto L12;
            com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public final boolean onBackPressed() {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void ca0() {
        super.ca0();
        View r0 = this.d;
        if (r0 == null) goto L8;
        View r1 = r0.findViewById(2131378481);
        if (r1 == null) goto L9;
        r1.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void initView() {
        super.initView();
        setBottomSheetSlideProcessor(b.a);
        Dialog r0 = getDialog();
        if (r0 == null) goto L9;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        View r2 = r1.findViewById(2131389843);
        if (r2 == null) goto L9;
        r2.setOnClickListener(c.a);
    L9:
        View r3 = this.s;
        if (r3 == null) goto L12;
        r3.setVisibility(8);
    L12:
        TextView r4 = this.t;
        if (r4 == null) goto L19;
        String r5 = vm2.i.e().getLinkerPageTitle();
        if (r5 != null) goto L18;
        r5 = s1.B(2131917295);
    L18:
        r4.setText(r5);
    L19:
        HSImageView r6 = this.p;
        if (r6 == null) goto L22;
        r6.setVisibility(0);
    L22:
        HSImageView r7 = this.p;
        if (r7 == null) goto L25;
        r7.setOnClickListener(new d(this));
    L25:
        Button r8 = this.q;
        if (r8 == null) goto L32;
        String r9 = vm2.i.e().getLinkerPageLeftBtnText();
        if (r9 != null) goto L31;
        r9 = s1.B(2131917274);
    L31:
        r8.setText(r9);
    L32:
        Button r10 = this.q;
        if (r10 == null) goto L35;
        r10.setOnClickListener(new e(this));
    L35:
        Button r11 = this.r;
        if (r11 == null) goto L42;
        String r12 = vm2.i.e().getLinkerPageRightBtnText();
        if (r12 != null) goto L41;
        r12 = s1.B(2131917292);
    L41:
        r11.setText(r12);
    L42:
        this.r.setOnClickListener(new f(this));
        if (this.L > 0) goto L45;
        aa0(-1);
    L45:
        lb6.g r13 = this.D;
        FrameLayout r14 = null;
        if (r13 == null) goto L52;
        ob6.a r15 = r13.j();
        if (r15 == null) goto L52;
        ec6.a r16 = r15.n();
        if (r16 == null) goto L52;
        v0 r17 = gc6.b.b(r16);
    L54:
        if ((r17 instanceof m00.g) == true) goto L56;
        v0 r18 = null;
    L57:
        m00.g r19 = (m00.g) r18;
        if (r19 == null) goto L60;
        SurfaceView r20 = r19.getSurfaceView();
    L61:
        ALogger.e("GuestLinkMainPageDialogForLinker", "addSurfaceView: surfaceView: " + r20);
        if (r20 == null) goto L84;
        ViewParent r21 = r20.getParent();
        if ((r21 instanceof ViewGroup) == true) goto L67;
        r21 = null;
    L67:
        ViewGroup r22 = (ViewGroup) r21;
        if (r22 == null) goto L70;
        r22.removeView(r20);
    L70:
        Dialog r23 = getDialog();
        if (r23 == null) goto L75;
        Window r24 = r23.getWindow();
        if (r24 == null) goto L75;
        r14 = (FrameLayout) r24.findViewById(2131378481);
    L75:
        if (r14 != null) goto L77;
    L79:
        com.bytedance.android.live.pushstream.d r25 = ((m00.g) r17).getLiveStream();
        if (r25 == null) goto L83;
        r25.O(true);
        return;
    L83:
        return;
    L77:
        if (r14.indexOfChild(r20) != (-1)) goto L79;
        r14.addView(r20);
        goto L79
    L84:
        return;
    L60:
        r20 = null;
        goto L61
    L56:
        r18 = r17;
    L52:
        r17 = null;
        goto L54
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void onDestroy() {
        super.onDestroy();
        lb6.g r0 = this.D;
        if (r0 == null) goto L11;
        sb6.a r1 = r0.getLinkState();
        if (r1 == null) goto L11;
        if (r1.a != true) goto L11;
        ALogger.e("GuestLinkMainPageDialogForLinker", "onDestroy -> finishChannel");
        lb6.g r2 = this.D;
        if (r2 == null) goto L11;
        r2.k("GuestLinkMainPageDialogForLinker#onDestroy");
    L11:
        lb6.g r3 = this.D;
        if (r3 == null) goto L20;
        ob6.a r4 = r3.j();
        if (r4 == null) goto L20;
        ei6.a r5 = r4.A();
        if (r5 == null) goto L20;
        gi6.e r6 = r5.getEventManager();
        if (r6 == null) goto L20;
        r6.b(null);
    L20:
        Lazy r7 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().b(this.N);
    }

    public static com.bytedance.android.live.base.model.message.guestlink.k ga0(com.bytedance.android.live.base.model.message.guestlink.a r4) {
        List r5 = r4.getLinkedUsers();
        Object r0 = null;
        if (r5 == null) goto L19;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L15;
        Object r1 = r6.next();
        IBaseUser r2 = ((com.bytedance.android.live.base.model.message.guestlink.k) r1).getUser();
        if (r2 == null) goto L10;
        String r3 = r2.getIdString();
    L12:
        if (Intrinsics.areEqual(r3, je0.d.b0()) == false) goto L6;
        r0 = r1;
        goto L15
    L10:
        r3 = null;
    L15:
        return (com.bytedance.android.live.base.model.message.guestlink.k) r0;
    L19:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void Z90(com.bytedance.android.live.base.model.message.guestlink.a r12) {
        Intrinsics.checkNotNullParameter(r12, "channelInfo");
        if (this.K == true) goto L11;
        List r0 = r12.getLinkedUsers();
        if (r0 == null) goto L7;
        int r1 = r0.size();
    L9:
        if (r1 < 2) goto L11;
        this.K = true;
        tb6.a.f(true, r12);
        int r2 = vi0.b.a;
        String r3 = String.valueOf(r12.getChannelId());
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r3, "channelId");
        JSONObject r9 = new JSONObject();
        r9.put("channel_id", r3);
        int r4 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_full_channel_info", 0, null, r9, 88);
        goto L11
    L7:
        r1 = 0;
    L11:
        ha0(fa0(r12, BaseGuestLinkMainPageDialog.U90(r12)), 0);
        ha0(fa0(r12, BaseGuestLinkMainPageDialog.V90(r12)), 1);
        super.Z90(r12);
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.fragment.app.DialogFragment*/.onSaveInstanceState(r3);
        ALogger.d("GuestLinkMainPageDialogForLinker", "BaseGuestLinkMainPageDialog#onSaveInstanceState: channelInfo: " + T90());
        com.bytedance.android.live.base.model.message.guestlink.a r0 = T90();
        if (r0 == null) goto L6;
        r3.putString("channel_info", com.bytedance.android.annie.api.data.subscribe.d.c(r0));
        return;
    }

    public final void onViewStateRestored(Bundle r5) {
        super/*androidx.fragment.app.DialogFragment*/.onViewStateRestored(r5);
        if (this.D != null) goto L12;
        ALogger.d("GuestLinkMainPageDialogForLinker", "BaseGuestLinkMainPageDialog#onViewStateRestored: mLinkService is null, dialog dismiss");
        dismiss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L31;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L31:
        return;
    L12:
        if (r5 == null) goto L16;
        String r7 = r5.getString("channel_info");
        if (r7 == null) goto L16;
        Gson r0 = com.bytedance.android.annie.api.data.subscribe.d.a;
        com.bytedance.android.live.base.model.message.guestlink.a r8 = (com.bytedance.android.live.base.model.message.guestlink.a) com.bytedance.android.annie.api.data.subscribe.d.a(r7, com.bytedance.android.live.base.model.message.guestlink.a.class);
    L17:
        ALogger.d("GuestLinkMainPageDialogForLinker", "appEnterBackground: channelInfo: " + r8);
        if (r8 == null) goto L27;
        com.bytedance.android.live.base.model.message.guestlink.k r1 = ga0(r8);
        if (r1 == null) goto L22;
        int r2 = r1.getLinkType();
    L23:
        ALogger.d("GuestLinkMainPageDialogForLinker", "appEnterBackground: linkType: " + r2);
        lb6.g r3 = this.D;
        if (r3 == null) goto L26;
        r3.a(r2, new g(this));
    L26:
        Z90(r8);
        goto L27
    L22:
        r2 = 2;
    L27:
        this.C = r8;
        return;
    L16:
        r8 = null;
        goto L17
    }

    public GuestLinkMainPageDialogForLinker(GuestLinkWidget r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "outerScopeProvider");
        super(r2, r3);
        this.O = r2;
        this.N = new q(this);
    }

    public static void ha0(z.a r2, int r3) {
        ALogger.e("GuestLinkMainPageDialogForLinker", "setLinkerUserLayer: position: " + r3 + ", targetLayer: " + r2);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
        m1.b r1 = null;
        if (r0 == null) goto L5;
        r1 = r0.newVideoMixerDescription(null);
    L5:
        if (r3 != 0) goto L20;
        if (r1 == null) goto L8;
        r1.e();
    L8:
        if (r1 == null) goto L10;
        r1.b();
    L10:
        if (r1 == null) goto L12;
        r1.c();
    L12:
        if (r1 == null) goto L14;
        r1.f();
    L14:
        if (r1 == null) goto L16;
        r1.i();
    L16:
        if (r1 == null) goto L18;
        r1.g();
    L18:
        if (r1 == null) goto L34;
        r1.h();
    L34:
        if (r2 == null) goto L37;
        r2.b();
        return;
    L37:
        return;
    L20:
        if (r1 == null) goto L22;
        r1.e();
    L22:
        if (r1 == null) goto L24;
        r1.b();
    L24:
        if (r1 == null) goto L26;
        r1.c();
    L26:
        if (r1 == null) goto L28;
        r1.f();
    L28:
        if (r1 == null) goto L30;
        r1.i();
    L30:
        if (r1 == null) goto L32;
        r1.g();
    L32:
        if (r1 == null) goto L34;
        r1.h();
        goto L34
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void X90(String r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "interactId");
        if (T90() != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.base.model.message.guestlink.a r0 = T90();
        Intrinsics.checkNotNull(r0);
        List r1 = r0.getLinkedUsers();
        com.bytedance.android.live.base.model.message.guestlink.k r2 = null;
        Object r3 = null;
        if (r1 == null) goto L14;
        Iterator r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        Object r7 = r4.next();
        if (Intrinsics.areEqual(((com.bytedance.android.live.base.model.message.guestlink.k) r7).getLinkmicIdStr(), r5) == false) goto L9;
        r3 = r7;
    L13:
        r2 = (com.bytedance.android.live.base.model.message.guestlink.k) r3;
    L14:
        ALogger.d("GuestLinkMainPageDialogForLinker", "onRemoteVideoMute linker: " + r2 + ", interactId: " + r5 + ", mute: " + r6);
        if (r2 != null) goto L17;
        return;
    L17:
        if (r2.getLinkType() == 1) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L21;
        long r8 = 1;
    L22:
        r2.setBackground(r8);
        com.bytedance.android.live.base.model.message.guestlink.a r9 = T90();
        Intrinsics.checkNotNull(r9);
        Z90(r9);
        return;
    L21:
        r8 = 0;
        goto L22
    }

    public final z.a fa0(com.bytedance.android.live.base.model.message.guestlink.a r4, com.bytedance.android.live.base.model.message.guestlink.k r5) {
        lb6.g r0 = this.D;
        if (r0 == null) goto L11;
        ob6.a r1 = r0.j();
        if (r1 == null) goto L11;
        ec6.a r2 = r1.n();
        if (r2 == null) goto L11;
        sk0.c r3 = r2.r();
        if (r3 == null) goto L11;
        com.bytedance.android.live.pushstream.d r6 = gc6.b.a(r3);
    L13:
        if (Intrinsics.areEqual(r5, ga0(r4)) == false) goto L20;
        if (r6 == null) goto L52;
        d0 r7 = r6.getLiveCore();
        if (r7 == null) goto L53;
        z r8 = r7.C();
        if (r8 != null) goto L55;
        return null;
    L55:
        return r8.K0();
    L53:
        return null;
    L52:
        return null;
    L20:
        StringBuilder r9 = new StringBuilder("getLayerDescription: linkmic_id_str: ");
        if (r5 == null) goto L23;
        String r10 = r5.getLinkmicIdStr();
    L24:
        r9.append(r10);
        r9.append(", layer: ");
        if (r6 == null) goto L33;
        d0 r11 = r6.getLiveCore();
        if (r11 == null) goto L33;
        z r12 = r11.C();
        if (r12 == null) goto L33;
        if (r5 == null) goto L32;
        r5.getLinkmicIdStr();
    L32:
        z.a r13 = r12.l();
    L34:
        r9.append(r13);
        r9.append(", layerControlSize: ");
        if (r6 == null) goto L41;
        d0 r14 = r6.getLiveCore();
        if (r14 == null) goto L41;
        z r15 = r14.C();
        if (r15 == null) goto L41;
        Integer r16 = Integer.valueOf(r15.g());
    L42:
        r9.append(r16);
        r9.append(",targetLinkerUser: ");
        r9.append(r5);
        ALogger.d("GuestLinkMainPageDialogForLinker", r9.toString());
        if (r6 == null) goto L56;
        d0 r17 = r6.getLiveCore();
        if (r17 == null) goto L57;
        z r18 = r17.C();
        if (r18 == null) goto L58;
        if (r5 == null) goto L51;
        r5.getLinkmicIdStr();
    L51:
        return r18.l();
    L58:
        return null;
    L57:
        return null;
    L56:
        return null;
    L41:
        r16 = null;
    L33:
        r13 = null;
        goto L34
    L23:
        r10 = null;
    L11:
        r6 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ALogger.i("GuestLinkMainPageDialogForLinker", "onViewCreated");
        super.onViewCreated(r3, r4);
        da0(this.M);
        Lazy r5 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().a(this.N);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void Y90(String[] r9, boolean[] r10, int[] r11) {
        Integer r0 = null;
        if (T90() == null) goto L27;
        if (r9 == null) goto L27;
        if (r11 == null) goto L27;
        if (r9.length != r11.length) goto L27;
        int r12 = r9.length;
        int r1 = 0;
        int r2 = 0;
    L10:
        if (r1 >= r12) goto L26;
        String r3 = r9[r1];
        com.bytedance.android.live.base.model.message.guestlink.a r4 = T90();
        Intrinsics.checkNotNull(r4);
        com.bytedance.android.live.base.model.message.guestlink.k r5 = BaseGuestLinkMainPageDialog.U90(r4);
        if (r5 == null) goto L14;
        String r6 = r5.getLinkmicIdStr();
    L16:
        if (Intrinsics.areEqual(r3, r6) == false) goto L18;
        ea0(r5, this.y, this.w, r11[r2]);
    L18:
        com.bytedance.android.live.base.model.message.guestlink.a r7 = T90();
        Intrinsics.checkNotNull(r7);
        com.bytedance.android.live.base.model.message.guestlink.k r8 = BaseGuestLinkMainPageDialog.V90(r7);
        if (r8 == null) goto L21;
        String r13 = r8.getLinkmicIdStr();
    L23:
        if (Intrinsics.areEqual(r3, r13) == false) goto L25;
        ea0(r8, this.z, this.x, r11[r2]);
    L25:
        r2 = r2 + 1;
        r1 = r1 + 1;
        goto L10
    L21:
        r13 = null;
        goto L23
    L14:
        r6 = null;
        goto L16
    L26:
        return;
    L27:
        StringBuilder r14 = new StringBuilder("onTalkStateUpdated: return, channelInfo: ");
        r14.append(T90());
        r14.append(", talkVolumes: ");
        r14.append(r11);
        r14.append(",  linkIds.size != talkVolumes.size: ");
        if (r9 == null) goto L30;
        Integer r15 = Integer.valueOf(r9.length);
    L31:
        if (r11 == null) goto L33;
        r0 = Integer.valueOf(r11.length);
    L33:
        r14.append(!Intrinsics.areEqual(r15, r0));
        r14.append(' ');
        ALogger.d("GuestLinkMainPageDialogForLinker", r14.toString());
        return;
    L30:
        r15 = null;
        goto L31
    }
}
