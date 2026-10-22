package com.bytedance.android.live.liveinteract.widget.widget;

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
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment.AudienceEditReasonFragment;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment.AudienceInputReasonFragment;
import com.bytedance.android.live.liveinteract.interact.audience.ui.AudienceInteractWaitingView;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/ChatRoomGuestAppliedDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatRoomGuestAppliedDialog extends CommonBottomDialog implements Observer<Integer> {
    public final IRoom a;
    public final IBaseUser b;
    public final CompositeDisposable c;
    public ChatMatchViewModel d;
    public final DataCenter e;
    public final com.bytedance.android.live.liveinteract.widget.widget.a f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ChatRoomGuestAppliedDialog a;

        public a(ChatRoomGuestAppliedDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            if (r6 == null) goto L34;
            ImageView r0 = (ImageView) this.a.findViewById(2131362565);
            IRoom r1 = this.a.a;
            if (r1 == null) goto L9;
            IBaseUser r2 = r1.getBaseOwner();
            if (r2 == null) goto L9;
            py.k r3 = r2.getAvatarThumbKt();
        L10:
            ImageUtil.loadRoundImage(r0, r3);
            AudienceInteractWaitingView r4 = (AudienceInteractWaitingView) this.a.findViewById(2131392992);
            if (r4 == null) goto L13;
            r4.a(((com.bytedance.android.livesdk.chatroom.model.interact.x) r6.data).getWaitingUsers(), this.a.b);
        L13:
            com.bytedance.android.livesdk.chatroom.model.interact.x r7 = (com.bytedance.android.livesdk.chatroom.model.interact.x) r6.data;
            if (r7 == null) goto L16;
            int r8 = (int) r7.getTotalCount();
        L18:
            if (((TextView) this.a.findViewById(2131392988)).getVisibility() != 0) goto L28;
            TextView r9 = (TextView) this.a.findViewById(2131392988);
            if (r9 == null) goto L35;
            this.a.getClass();
            if (r8 == 0) goto L26;
            if (r8 == 1) goto L26;
            String r10 = s1.C(2131917805, new Object[]{String.valueOf(r8 - 1)});
        L27:
            r9.setText(r10);
            return;
        L26:
            r10 = s1.B(2131918102);
            goto L27
        L35:
            return;
        L28:
            TextView r11 = (TextView) this.a.findViewById(2131374198);
            if (r8 <= 1) goto L31;
            String r12 = s1.C(2131917532, new Object[]{Integer.valueOf(r8)});
        L32:
            r11.setText(r12);
            return;
        L31:
            r12 = s1.B(2131917533);
            goto L32
        L16:
            r8 = 0;
        L9:
            r3 = null;
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ChatRoomGuestAppliedDialog a;

        public b(ChatRoomGuestAppliedDialog r1) {
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
        public final /* synthetic */ ChatRoomGuestAppliedDialog a;

        public c(ChatRoomGuestAppliedDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ChatRoomGuestAppliedDialog.N0(this.a);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ChatRoomGuestAppliedDialog a;

        public d(ChatRoomGuestAppliedDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ChatRoomGuestAppliedDialog.N0(this.a);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ChatRoomGuestAppliedDialog a;

        public e(ChatRoomGuestAppliedDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Integer r5 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r5 != null) goto L6;
        L15:
            Observer r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L18;
        L20:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L23 Exception -> L25
        L29:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L23:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L25:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
            if (r1 == null) goto L29;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
            goto L29
        L18:
            if (Looper.myLooper() == r0.getLooper()) goto L20;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        L6:
            if (r5.intValue() != 1) goto L15;
            IRoom r7 = this.a.a;
            if (r7 != null) goto L10;
        L12:
            rj0.l.n2.getClass();
            rj0.l r8 = rj0.l.a.a();
            if (r8 == null) goto L15;
            rj0.l.b.c(r8, null, 7);
            goto L15
        L10:
            if (true != r7.isLiveTypeAudio()) goto L12;
            this.a.e.put("cmd_interact_state_change", new a1(9));
            goto L15
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ChatRoomGuestAppliedDialog a;

        public f(ChatRoomGuestAppliedDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ?? r5 = this.a;
            if (r5.a != null) goto L5;
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
            ChatRoomGuestAppliedDialog r2 = this.a;
            AudienceInputReasonFragment r8 = new AudienceInputReasonFragment(r1, r2.e, r2.a);
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

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ ChatRoomGuestAppliedDialog a;

        public g(ChatRoomGuestAppliedDialog r1) {
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
            ChatRoomGuestAppliedDialog r2 = this.a;
            AudienceEditReasonFragment r7 = new AudienceEditReasonFragment(r1, r2.e, r2.a);
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
        return 2131565419;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.dispose();
        hd0.c.f().e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M0(ChatRoomGuestAppliedDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final void N0(ChatRoomGuestAppliedDialog r7) {
        com.bytedance.android.live.liveinteract.widget.widget.a r0 = r7.f;
        if (r0 != null) goto L7;
        String r1 = ChatMatchWidget.o;
        ChatMatchViewModel r2 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        if (r2 == null) goto L8;
        r2.showMatchDialog(true);
        ChatMatchViewModel.startMatch$default(r2, r7.a, false, 0, 6, null);
    L8:
        M0(r7);
        return;
    L7:
        r0.show();
        goto L8
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L6;
    L7:
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.intValue() != 0) goto L13;
    L11:
        M0(this);
        return;
    L13:
        return;
    L6:
        if (r4.intValue() == 2) goto L11;
        goto L7
    }

    public final void onCreate(Bundle r12) {
        super.onCreate(r12);
        String r13 = ChatMatchWidget.o;
        this.d = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        int r5 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        LinkAudienceApi r0 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r14 = this.a;
        if (r14 == null) goto L5;
        long r1 = r14.getRoomId();
    L6:
        IRoom r15 = this.a;
        if (r15 == null) goto L9;
        long r3 = r15.getRoomId();
    L10:
        Disposable r16 = r0.getUserWaitingRankPosition(r1, r3, r5, 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this));
        if (r16 == null) goto L13;
        this.c.add(r16);
    L13:
        Boolean r2 = null;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.c() != 1) goto L31;
        ((TextView) findViewById(2131365468)).setVisibility(0);
        ChatMatchViewModel r4 = this.d;
        if (r4 == null) goto L21;
        MutableLiveData<Boolean> r6 = r4.getMatchingState();
        if (r6 == null) goto L21;
        r2 = (Boolean) r6.getValue();
    L21:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L24;
        ((TextView) findViewById(2131365468)).setText(s1.B(2131914831));
        findViewById(2131365471).setVisibility(0);
        findViewById(2131365471).b();
    L29:
        ((TextView) findViewById(2131365468)).setOnClickListener(new c(this));
        findViewById(2131365470).setVisibility(0);
    L42:
        ((TextView) findViewById(2131365114)).setOnClickListener(new e(this));
        hd0.c.f().c(this);
        if (TextUtils.isEmpty(tc0.c.h().F) == false) goto L50;
        LinearLayout r17 = (LinearLayout) findViewById(2131383838);
        if (r17 == null) goto L47;
        r17.setVisibility(8);
    L47:
        Button r18 = (Button) findViewById(2131364803);
        if (r18 == null) goto L59;
        r18.setVisibility(0);
    L59:
        findViewById(2131363187).setAnimation("link_apply_waiting.json");
        com.bytedance.android.live.liveinteract.utils.d r19 = jf0.c.a;
        jf0.c.n();
        ((Button) findViewById(2131364803)).setOnClickListener(new f(this));
        ((LinearLayout) findViewById(2131383838)).setOnClickListener(new g(this));
        IRoom r110 = this.a;
        if (r110 != null) goto L62;
        return;
    L62:
        if (r110.isThirdParty() == false) goto L66;
        ((Button) findViewById(2131364803)).setVisibility(8);
        return;
    L66:
        return;
    L50:
        LinearLayout r111 = (LinearLayout) findViewById(2131383838);
        if (r111 == null) goto L53;
        r111.setVisibility(0);
    L53:
        Button r112 = (Button) findViewById(2131364803);
        if (r112 == null) goto L56;
        r112.setVisibility(8);
    L56:
        TextView r113 = (TextView) findViewById(2131363194);
        if (r113 == null) goto L59;
        r113.setText(tc0.c.h().F);
        goto L59
    L24:
        if (hd0.c.f().f > 0) goto L26;
    L28:
        ((TextView) findViewById(2131365468)).setText(s1.B(2131914818));
        goto L29
    L26:
        if ((System.currentTimeMillis() - hd0.c.f().f) < 60000) goto L28;
        ((TextView) findViewById(2131365468)).setTextColor(ColorProtector.parseColor("#CCFE2C55"));
        hd0.c.f().f = 0;
        goto L28
    L31:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.c() != 2) goto L42;
        ((LinearLayout) findViewById(2131365465)).setVisibility(0);
        ChatMatchViewModel r7 = this.d;
        if (r7 == null) goto L38;
        MutableLiveData<Boolean> r8 = r7.getMatchingState();
        if (r8 == null) goto L38;
        r2 = (Boolean) r8.getValue();
    L38:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L40;
        ((TextView) findViewById(2131365467)).setTextColor(ColorProtector.parseColor("#7F161823"));
        ((TextView) findViewById(2131365467)).setText(s1.B(2131914832));
        UtilityKotlinExtentionsKt.u(findViewById(2131365466));
    L41:
        ((LinearLayout) findViewById(2131365465)).setOnClickListener(new d(this));
        ((TextView) findViewById(2131392988)).setVisibility(8);
        com.bytedance.android.live.core.utils.a1.o(findViewById(2131364803), UtilityKotlinExtentionsKt.i(18));
        com.bytedance.android.live.core.utils.a1.o(findViewById(2131383838), UtilityKotlinExtentionsKt.i(18));
        goto L42
    L40:
        ((TextView) findViewById(2131365467)).setText(s1.B(2131914817));
        goto L41
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public ChatRoomGuestAppliedDialog(Context r2, DataCenter r3, com.bytedance.android.live.liveinteract.widget.widget.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.a = (IRoom) r3.get("data_room", vh7.f.c(IRoom.class));
        this.b = jc1.k.n(IMiddlewareUserService.class).user().b();
        this.c = new CompositeDisposable();
    }
}
