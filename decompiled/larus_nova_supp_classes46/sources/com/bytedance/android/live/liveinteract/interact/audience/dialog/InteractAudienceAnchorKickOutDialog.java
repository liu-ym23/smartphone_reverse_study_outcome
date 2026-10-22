package com.bytedance.android.live.liveinteract.interact.audience.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import fj0.e;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/InteractAudienceAnchorKickOutDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceAnchorKickOutDialog extends CommonBottomDialog {
    public static final /* synthetic */ int d = 0;
    public final boolean a;
    public final IBaseUser b;
    public final long c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceAnchorKickOutDialog a;

        public a(InteractAudienceAnchorKickOutDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L17:
            xs2.b.a().post(new UserProfileEvent(this.a.b).setClickUserPosition("pk_linked_audience").setReportSource("audience_linkmic").setReportType("data_card_linked_audience").setShowSendGift(true));
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
            goto L17
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceAnchorKickOutDialog a;

        public static final class a implements DialogInterface.OnClickListener {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                r1.dismiss();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceAnchorKickOutDialog$b$b, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0031b implements DialogInterface.OnClickListener {
            public final /* synthetic */ b a;

            public DialogInterfaceOnClickListenerC0031b(b r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r3, int r4) {
                r3.dismiss();
                if (this.a.a.a == false) goto L8;
                com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
                com.bytedance.android.live.liveinteract.plantform.base.d r5 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
                if (r5 == null) goto L16;
                r5.kickOut(this.a.a.b.getIdString(), o.a(this.a.a.b), "");
                return;
            L16:
                return;
            L8:
                if (k.n(IMiddlewareUserService.class).user().c() == false) goto L14;
                String r6 = o.a(this.a.a.b);
                if (r6 == null) goto L18;
                com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
                com.bytedance.android.live.liveinteract.plantform.base.c r0 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
                if (r0 == null) goto L19;
                r0.kickOut(this.a.a.b.getIdString(), r6, "");
                return;
            L19:
                return;
            L18:
                return;
            L14:
                InteractAudienceAnchorKickOutDialog.M0(this.a.a, TalkRoomOperate.DISCONNECT);
            }
        }

        public b(InteractAudienceAnchorKickOutDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            if (this.a.a == false) goto L5;
        L8:
            CommonBottomDialog r7 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L11;
        L13:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L16 Exception -> L18
        L22:
            DialogLancet.afterDialogDismiss(r7);
        L23:
            DialogInterfaceOnClickListenerC0031b r8 = new DialogInterfaceOnClickListenerC0031b(this);
            a r1 = a.a;
            j0.a r2 = new j0.a(this.a.getContext());
            r2.a = s1.C(2131917528, new Object[]{this.a.b.getNickName()});
            r2.b(s1.B(2131916227), r8);
            r2.a(s1.B(2131915442), r1);
            r2.c();
            return;
        L16:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L18:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
            if (r3 == null) goto L22;
            com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
            goto L22
        L11:
            if (Looper.myLooper() == r0.getLooper()) goto L13;
            r0.post(DialogLancet.createDismissRunnable(r7));
            goto L23
        L5:
            if (k.n(IMiddlewareUserService.class).user().c() == true) goto L8;
            InteractAudienceAnchorKickOutDialog.M0(this.a, TalkRoomOperate.DISCONNECT);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceAnchorKickOutDialog a;

        public c(InteractAudienceAnchorKickOutDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            CommonBottomDialog r7 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r7);
        L17:
            InteractAudienceAnchorKickOutDialog r8 = this.a;
            int r1 = InteractAudienceAnchorKickOutDialog.d;
            r8.getClass();
            m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r2 == null) goto L20;
            IRoom r3 = (IRoom) r2.getValue();
        L21:
            IMiddlewareReportService r4 = k.n(IMiddlewareReportService.class);
            ReportConstant.BusinessSource r5 = ReportConstant.BusinessSource.NewProfile;
            IBaseUser r9 = r8.b;
            r4.reportWithUserProfileEvent(r5, r9, r3, new UserProfileEvent(r9).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience"));
            return;
        L20:
            r3 = null;
            goto L21
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r10 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r10 == null) goto L16;
            com.bytedance.crash.d.d(r10, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r7));
            goto L17
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceAnchorKickOutDialog a;

        public d(InteractAudienceAnchorKickOutDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public final int getLayoutId() {
        return 2131565524;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.setDimAmount(0.0f);
        return;
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        ((TextView) findViewById(2131383183)).setOnClickListener(new a(this));
        if (e.i() == true) goto L5;
    L9:
        ((TextView) findViewById(2131362246)).setVisibility(8);
    L10:
        ((TextView) findViewById(2131362246)).setOnClickListener(x0.a(new AnonymousClass2(this)));
        ((TextView) findViewById(2131369129)).setOnClickListener(new b(this));
        TextView r3 = (TextView) findViewById(2131384367);
        if (r3 == null) goto L13;
        r3.setOnClickListener(new c(this));
    L13:
        ((TextView) findViewById(2131365114)).setOnClickListener(new d(this));
        if (this.b.isAnonymous() == false) goto L22;
        TextView r10 = (TextView) findViewById(2131383183);
        if (r10 == null) goto L18;
        r10.setVisibility(8);
    L18:
        TextView r11 = (TextView) findViewById(2131384367);
        if (r11 == null) goto L23;
        r11.setVisibility(0);
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (this.a == false) goto L9;
        if (this.c <= 0) goto L9;
        ((TextView) findViewById(2131362246)).setVisibility(0);
        fj0.a r0 = fj0.b.a;
        fj0.b.b(this.b.getIdString());
        goto L10
    }

    public static final void M0(InteractAudienceAnchorKickOutDialog r1, TalkRoomOperate r2) {
        r1.getClass();
        if (k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L5;
        f2.b(2131914522, 0);
    L6:
        x.C0(r2);
        return;
    L5:
        f2.b(2131917298, 0);
        goto L6
    }

    public InteractAudienceAnchorKickOutDialog(Context r2, boolean r3, IBaseUser r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "user");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
