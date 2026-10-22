package com.bytedance.android.live.liveinteract.interact.audience.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment.AudienceEditReasonFragment;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment.AudienceInputReasonFragment;
import com.bytedance.android.live.liveinteract.interact.audience.ui.AudienceInteractWaitingView;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.model.interact.x;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/InteractAudienceGuestAppliedDialogV2;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceGuestAppliedDialogV2 extends CommonStandardBottomDialog implements Observer<Integer> {
    public final IRoom B;
    public final IBaseUser C;
    public final CompositeDisposable D;
    public final DataCenter E;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ InteractAudienceGuestAppliedDialogV2 a;

        public a(InteractAudienceGuestAppliedDialogV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            if (r7 == null) goto L28;
            ImageView r0 = (ImageView) this.a.findViewById(2131362565);
            IRoom r1 = this.a.B;
            if (r1 == null) goto L9;
            IBaseUser r2 = r1.getBaseOwner();
            if (r2 == null) goto L9;
            k r3 = r2.getAvatarThumbKt();
        L10:
            ImageUtil.loadRoundImage(r0, r3);
            AudienceInteractWaitingView r4 = (AudienceInteractWaitingView) this.a.findViewById(2131392992);
            if (r4 == null) goto L13;
            r4.a(((x) r7.data).getWaitingUsers(), this.a.C);
        L13:
            TextView r5 = (TextView) this.a.findViewById(2131392988);
            if (r5 == null) goto L29;
            InteractAudienceGuestAppliedDialogV2 r8 = this.a;
            x r9 = (x) r7.data;
            if (r9 == null) goto L18;
            int r10 = (int) r9.getTotalCount();
        L19:
            r8.getClass();
            if (r10 != 0) goto L22;
        L25:
            String r11 = s1.B(2131918102);
        L26:
            r5.setText(r11);
            return;
        L22:
            if (r10 == 1) goto L25;
            r11 = s1.C(2131917805, new Object[]{String.valueOf(r10 - 1)});
            goto L26
        L18:
            r10 = 0;
            goto L19
        L29:
            return;
        L9:
            r3 = null;
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractAudienceGuestAppliedDialogV2 a;

        public b(InteractAudienceGuestAppliedDialogV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            Observer r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
        L17:
            ExceptionUtils.handleException(this.a.getContext(), r6);
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

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestAppliedDialogV2 a;

        public c(InteractAudienceGuestAppliedDialogV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Integer r5 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r5 != null) goto L6;
        L10:
            com.bytedance.android.live.liveinteract.utils.d r6 = jf0.c.a;
            jf0.c.e("livesdk_audience_connection_cancel_click");
            Observer r7 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r1 == null) goto L24;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L13:
            if (Looper.myLooper() == r0.getLooper()) goto L15;
            r0.post(DialogLancet.createDismissRunnable(r7));
            return;
        L6:
            if (r5.intValue() != 1) goto L10;
            com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r8 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r8 == null) goto L10;
            com.bytedance.android.live.liveinteract.plantform.base.e.b.a(r8);
            goto L10
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestAppliedDialogV2 a;

        public d(InteractAudienceGuestAppliedDialogV2 r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceGuestAppliedDialogV2] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ?? r5 = this.a;
            if (r5.B != null) goto L5;
            return;
        L5:
            if (r5.getContext() == null) goto L35;
            Observer r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r6);
        L21:
            com.bytedance.android.live.liveinteract.utils.d r7 = jf0.c.a;
            jf0.c.b();
            Context r1 = this.a.getContext();
            InteractAudienceGuestAppliedDialogV2 r2 = this.a;
            AudienceInputReasonFragment r8 = new AudienceInputReasonFragment(r1, r2.E, r2.B);
            if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L32;
            DialogLancet.handleBlockedDialogShow(r8);
            return;
        L32:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
        L25:
            DialogLancet.beforeDialogShow(r8);
            r8.show();
            DialogLancet.afterDialogShow(r8);
            return;
        L16:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r3 == null) goto L20;
            com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L9:
            if (Looper.myLooper() == r0.getLooper()) goto L11;
            r0.post(DialogLancet.createDismissRunnable(r6));
            goto L21
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestAppliedDialogV2 a;

        public e(InteractAudienceGuestAppliedDialogV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Observer r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L17:
            com.bytedance.android.live.liveinteract.utils.d r6 = jf0.c.a;
            jf0.c.b();
            Context r1 = this.a.getContext();
            InteractAudienceGuestAppliedDialogV2 r2 = this.a;
            AudienceEditReasonFragment r7 = new AudienceEditReasonFragment(r1, r2.E, r2.B);
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

    public final int getLayoutId() {
        return 2131565526;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.D.dispose();
        hd0.c.f().e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L6;
    L7:
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.intValue() != 0) goto L32;
    L11:
        Handler r5 = DialogLancet.resolveDialogHandler(this);
        if (r5 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(this);
        return;
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r6 == null) goto L25;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
        goto L25
    L14:
        if (Looper.myLooper() == r5.getLooper()) goto L16;
        r5.post(DialogLancet.createDismissRunnable(this));
        return;
    L32:
        return;
    L6:
        if (r4.intValue() == 2) goto L11;
        goto L7
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        LinkAudienceApi r0 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r10 = this.B;
        long r1 = 0;
        if (r10 == null) goto L5;
        long r3 = r10.getRoomId();
    L6:
        IRoom r11 = this.B;
        if (r11 == null) goto L9;
        r1 = r11.getRoomId();
    L9:
        Disposable r12 = r0.getUserWaitingRankPosition(r3, r1, 4, 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this));
        if (r12 == null) goto L12;
        this.D.add(r12);
    L12:
        ((TextView) findViewById(2131365114)).setOnClickListener(new c(this));
        hd0.c.f().c(this);
        if (TextUtils.isEmpty(tc0.c.h().F) == false) goto L20;
        LinearLayout r13 = (LinearLayout) findViewById(2131383838);
        if (r13 == null) goto L17;
        r13.setVisibility(8);
    L17:
        Button r14 = (Button) findViewById(2131364803);
        if (r14 == null) goto L29;
        r14.setVisibility(0);
    L29:
        findViewById(2131363187).setAnimation("link_apply_waiting.json");
        com.bytedance.android.live.liveinteract.utils.d r15 = jf0.c.a;
        jf0.c.n();
        ((Button) findViewById(2131364803)).setOnClickListener(new d(this));
        ((LinearLayout) findViewById(2131383838)).setOnClickListener(new e(this));
        IRoom r16 = this.B;
        if (r16 != null) goto L32;
        return;
    L32:
        if (r16.isThirdParty() == false) goto L36;
        ((Button) findViewById(2131364803)).setVisibility(8);
        return;
    L36:
        return;
    L20:
        LinearLayout r17 = (LinearLayout) findViewById(2131383838);
        if (r17 == null) goto L23;
        r17.setVisibility(0);
    L23:
        Button r18 = (Button) findViewById(2131364803);
        if (r18 == null) goto L26;
        r18.setVisibility(8);
    L26:
        TextView r19 = (TextView) findViewById(2131363194);
        if (r19 == null) goto L29;
        r19.setText(tc0.c.h().F);
        goto L29
    L5:
        r3 = 0;
        goto L6
    }

    public InteractAudienceGuestAppliedDialogV2(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, false);
        this.E = r3;
        this.B = (IRoom) r3.get("data_room", f.c(IRoom.class));
        this.C = jc1.k.n(IMiddlewareUserService.class).user().b();
        this.D = new CompositeDisposable();
    }
}
