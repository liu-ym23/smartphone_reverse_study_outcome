package com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceGuestAppliedDialogV2;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.utils.d;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/fragment/AudienceEditReasonFragment;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudienceEditReasonFragment extends CommonBottomDialog {
    public final DataCenter a;
    public final IRoom b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AudienceEditReasonFragment a;

        public a(AudienceEditReasonFragment r1) {
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
            d r6 = jf0.c.a;
            jf0.c.c("edit");
            Context r1 = this.a.getContext();
            AudienceEditReasonFragment r2 = this.a;
            AudienceInputReasonFragment r7 = new AudienceInputReasonFragment(r1, r2.a, r2.b);
            if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L28;
            DialogLancet.handleBlockedDialogShow(r7);
            return;
        L28:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
        L21:
            DialogLancet.beforeDialogShow(r7);
            r7.show();
            DialogLancet.afterDialogShow(r7);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r3 == null) goto L16;
            com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
            goto L17
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AudienceEditReasonFragment a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ b a;
            public final /* synthetic */ int b;

            public a(b r1, int r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                com.bytedance.android.live.network.response.a r5 = (com.bytedance.android.live.network.response.a) r4;
                CommonBottomDialog r6 = this.a.a;
                Handler r0 = DialogLancet.resolveDialogHandler(r6);
                if (r0 != null) goto L5;
            L7:
                DialogLancet.beforeDialogDismiss(r6);
                r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
            L16:
                DialogLancet.afterDialogDismiss(r6);
            L17:
                f2.b(2131917987, 0);
                tc0.c.h().F = "";
                if (this.b != 4) goto L24;
                InteractAudienceGuestAppliedDialogV2 r7 = new InteractAudienceGuestAppliedDialogV2(this.a.a.getContext(), this.a.a.a);
                if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L37;
                DialogLancet.handleBlockedDialogShow(r7);
                return;
            L37:
                DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
            L23:
                DialogLancet.beforeDialogShow(r7);
                r7.show();
                DialogLancet.afterDialogShow(r7);
                return;
            L24:
                ChatRoomGuestAppliedDialog r8 = new ChatRoomGuestAppliedDialog(this.a.a.getContext(), this.a.a.a, null);
                if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L39;
                DialogLancet.handleBlockedDialogShow(r8);
                return;
            L39:
                DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L33
            L28:
                DialogLancet.beforeDialogShow(r8);
                r8.show();
                DialogLancet.afterDialogShow(r8);
                return;
            L10:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r6);
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
                r0.post(DialogLancet.createDismissRunnable(r6));
                goto L17
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment.AudienceEditReasonFragment$b$b, reason: collision with other inner class name */
        public static final class C0032b<T> implements Consumer {
            public final /* synthetic */ b a;

            public C0032b(b r1) {
                this.a = r1;
            }

            public final void accept(Object r5) {
                Throwable r6 = (Throwable) r5;
                CommonBottomDialog r0 = this.a.a;
                Handler r1 = DialogLancet.resolveDialogHandler(r0);
                if (r1 != null) goto L5;
            L7:
                DialogLancet.beforeDialogDismiss(r0);
                r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
            L16:
                DialogLancet.afterDialogDismiss(r0);
            L17:
                ExceptionUtils.handleException(this.a.a.getContext(), r6);
                return;
            L10:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r0);
                throw th;
            L12:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
                Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
                if (r2 == null) goto L16;
                com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
                goto L16
            L5:
                if (Looper.myLooper() == r1.getLooper()) goto L7;
                r1.post(DialogLancet.createDismissRunnable(r0));
                goto L17
            }
        }

        public b(AudienceEditReasonFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            d r8 = jf0.c.a;
            jf0.c.c("delete");
            int r9 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
            LinkAudienceApi r0 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
            IRoom r1 = this.a.b;
            if (r1 == null) goto L5;
            Long r2 = Long.valueOf(r1.getId());
        L6:
            r0.updateApplyReason(r2.longValue(), r9, 2, "").compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r9), new C0032b(this));
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ AudienceEditReasonFragment a;

        public c(AudienceEditReasonFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            d r5 = jf0.c.a;
            jf0.c.c("cancel");
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
        }
    }

    public final int getLayoutId() {
        return 2131565527;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        TextView r3 = (TextView) findViewById(2131365452);
        if (r3 == null) goto L5;
        r3.setOnClickListener(new a(this));
    L5:
        TextView r4 = (TextView) findViewById(2131368777);
        if (r4 == null) goto L8;
        r4.setOnClickListener(new b(this));
    L8:
        TextView r5 = (TextView) findViewById(2131365114);
        if (r5 == null) goto L12;
        r5.setOnClickListener(new c(this));
        return;
    }

    public AudienceEditReasonFragment(Context r2, DataCenter r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        super(r2);
        this.a = r3;
        this.b = r4;
    }
}
