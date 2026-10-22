package com.bytedance.android.live.liveinteract.linkpanel.dialog;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.f0;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.c8;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import gd0.m;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/dialog/GuestTalkBeInvitedDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public class GuestTalkBeInvitedDialog extends LiveDialogFragment {
    public static final /* synthetic */ int q = 0;
    public Map<Integer, View> d;
    public Animation e;
    public Animation f;
    public Animation g;
    public final CompositeDisposable h;
    public IRoom i;
    public z0 j;
    public h1 k;
    public final int l;
    public Integer m;
    public boolean n;
    public IMessageBoardInfo o;
    public Function0<Unit> p;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ GuestTalkBeInvitedDialog a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public b(GuestTalkBeInvitedDialog r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r3) {
            GuestTalkBeInvitedDialog r4 = this.a;
            Animation r0 = r4.g;
            if (r0 == null) goto L8;
            HSImageView r5 = r4.T90(2131374209);
            if (r5 == null) goto L9;
            r5.startAnimation(r0);
            return;
        L9:
            return;
        }
    }

    public static final class c implements Animation.AnimationListener {
        public final /* synthetic */ GuestTalkBeInvitedDialog a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public c(GuestTalkBeInvitedDialog r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r3) {
            GuestTalkBeInvitedDialog r4 = this.a;
            Animation r0 = r4.f;
            if (r0 == null) goto L8;
            HSImageView r5 = r4.T90(2131374209);
            if (r5 == null) goto L9;
            r5.startAnimation(r0);
            return;
        L9:
            return;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ GuestTalkBeInvitedDialog a;

        public d(GuestTalkBeInvitedDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r4) {
            GuestTalkBeInvitedDialog r5 = this.a;
            int r0 = GuestTalkBeInvitedDialog.q;
            Dialog r1 = r5.getDialog();
            Object r2 = null;
            if (r1 == null) goto L5;
            View r3 = r1.getCurrentFocus();
        L6:
            Context r6 = r5.getContext();
            if (r3 == null) goto L20;
            if (r6 == null) goto L23;
            Object r7 = r6.getSystemService("input_method");
            if ((r7 instanceof InputMethodManager) == false) goto L14;
            r2 = r7;
        L14:
            InputMethodManager r8 = (InputMethodManager) r2;
            if (r8 != null) goto L17;
            return;
        L17:
            if (r8.isActive() != true) goto L22;
            r8.hideSoftInputFromWindow(r3.getWindowToken(), 0);
            return;
        L22:
            return;
        L23:
            return;
        L20:
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ GuestTalkBeInvitedDialog a;

        public e(GuestTalkBeInvitedDialog r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "sec");
            return Long.valueOf(((long) this.a.l) - r6.longValue());
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ GuestTalkBeInvitedDialog a;

        public f(GuestTalkBeInvitedDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            ((TextView) this.a.T90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf((int) r6.longValue())}));
            if (r6.longValue() == 0) goto L13;
            return;
        L13:
            this.a.dismiss();     // Catch: Exception -> L7
        L11:
            this.a.getClass();
            this.a.Y90("overtime");
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L11;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L11
        }
    }

    static {
    }

    public void S90() {
        this.d.clear();
    }

    public void U90() {
        IRoom r0 = this.i;
        if (r0 == null) goto L33;
        Function0<Unit> r1 = this.p;
        if (r1 == null) goto L7;
        Unit r2 = (Unit) r1.invoke();
    L7:
        z0 r3 = this.j;
        if (r3 == null) goto L13;
        String r4 = r3.getSecFromUserId();
        if (r4 == null) goto L13;
        String r6 = r4;
    L14:
        z0 r5 = this.j;
        if (r5 == null) goto L20;
        String r7 = r5.getFromUserIdStr();
        if (r7 == null) goto L20;
        String r8 = r7;
    L21:
        m r9 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r9 == null) goto L31;
        LinkPanelTransitService r10 = (LinkPanelTransitService) r9;
        r10.j(r0.getId(), r6, r8, ReplyType.Agree.ordinal());
    L31:
        dismiss();     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L34;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L34:
        return;
    L20:
        r8 = "";
    L13:
        r6 = "";
        goto L14
    }

    public void V90() {
        Animation r0 = this.e;
        if (r0 == null) goto L7;
        View r1 = T90(2131381750);
        if (r1 == null) goto L7;
        r1.startAnimation(r0);
    L7:
        Animation r2 = this.f;
        if (r2 == null) goto L12;
        HSImageView r3 = T90(2131374209);
        if (r3 == null) goto L12;
        r3.startAnimation(r2);
    L12:
        Animation r4 = this.f;
        if (r4 == null) goto L15;
        r4.setAnimationListener(new b(this));
    L15:
        Animation r5 = this.g;
        if (r5 == null) goto L19;
        r5.setAnimationListener(new c(this));
        return;
    }

    public GuestTalkBeInvitedDialog() {
        this.d = new LinkedHashMap();
        this.h = new CompositeDisposable();
        this.l = 9;
    }

    public final void X90() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.h.dispose();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.h.isDisposed() == true) goto L5;
        this.h.dispose();
    L5:
        Animation r0 = this.f;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        Animation r1 = this.g;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        Animation r2 = this.e;
        if (r2 == null) goto L14;
        r2.cancel();
    L14:
        S90();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        Integer r1 = this.m;
        boolean r2 = this.n;
        IMessageBoardInfo r3 = this.o;
        String r5 = null;
        if ((r3 instanceof MessageBoardInfo) == true) goto L5;
        r3 = null;
    L5:
        MessageBoardInfo r4 = (MessageBoardInfo) r3;
        z0 r6 = this.j;
        String r7 = "";
        if (r6 == null) goto L9;
        String r8 = r6.getFromUserIdStr();
        if (r8 == null) goto L9;
    L10:
        Intrinsics.checkNotNullParameter(r8, "fromUserId");
        LinkedHashMap r9 = new LinkedHashMap();
        if (r1 == null) goto L19;
        int r10 = r1.intValue();
        if (r10 != 1) goto L15;
        r7 = "red";
    L17:
        r9.put("grouppk_group", r7);
        goto L19
    L15:
        if (r10 != 2) goto L17;
        r7 = "blue";
    L19:
        if (r4 == null) goto L21;
        r9.put("request_page", "gift_message_panel");
        r9.put("message_text", f0.a(r4));
    L21:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r9, Integer.valueOf(r0), 4);
        if (r2 == false) goto L24;
        r9.put("request_page", "game_invite");
    L24:
        r9.put("from_user_id", r8);
        com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L30;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L30;
        r5 = r12.getOwnerUserIdString();
    L30:
        if (Intrinsics.areEqual(r8, r5) == false) goto L32;
        String r13 = "anchor";
    L33:
        r9.put("from_user_type", r13);
        j0.l().sendLog("livesdk_guest_connection_invited", r9, new Object[]{IRoom.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L32:
        r13 = "admin";
    L9:
        r8 = "";
        goto L10
    }

    public View T90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public void Y90(String r10) {
        Intrinsics.checkNotNullParameter(r10, "refuseType");
        IRoom r0 = this.i;
        if (r0 == null) goto L25;
        z0 r1 = this.j;
        String r2 = "";
        if (r1 == null) goto L10;
        String r3 = r1.getSecFromUserId();
        if (r3 == null) goto L10;
        String r6 = r3;
    L11:
        z0 r4 = this.j;
        if (r4 == null) goto L17;
        String r5 = r4.getFromUserIdStr();
        if (r5 == null) goto L17;
        r2 = r5;
    L17:
        m r7 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r7 == null) goto L20;
        LinkPanelTransitService r8 = (LinkPanelTransitService) r7;
        String r9 = r2;
        r8.j(r0.getId(), r6, r9, ReplyType.Reject.ordinal());
    L20:
        IMessageBoardInfo r11 = this.o;
        if ((r11 instanceof MessageBoardInfo) == true) goto L23;
        r11 = null;
    L23:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.f(r10, (MessageBoardInfo) r11, r2);
        return;
    L10:
        r6 = "";
        goto L11
    }

    public void Z90(String r2) {
        ((TextView) T90(2131380593)).setText(r2);
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r5.setAttributes(r0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
        this.e = AnimationUtils.loadAnimation(getContext(), 2130772759);
        this.f = AnimationUtils.loadAnimation(getContext(), 2130772760);
        this.g = AnimationUtils.loadAnimation(getContext(), 2130772761);
        Animation r3 = this.f;
        if (r3 == null) goto L5;
        r3.setRepeatCount(-1);
    L5:
        Animation r4 = this.e;
        if (r4 == null) goto L8;
        r4.setInterpolator(new LinearInterpolator());
    L8:
        Animation r5 = this.f;
        if (r5 == null) goto L11;
        r5.setInterpolator(new LinearInterpolator());
    L11:
        com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.d().I1();
        if (r6 == null) goto L17;
        Boolean r7 = (Boolean) r6.getValue();
        if (r7 == null) goto L18;
        r7.booleanValue();
        return;
    L18:
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new d(this));
        r3.setCanceledOnTouchOutside(false);
        return r3;
    }

    public void W90(z0 r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        boolean r1 = false;
        int r3 = 2131918062;
        if (r10.getInviteMsg() == null) goto L9;
        if (r11 == false) goto L6;
        String r12 = s1.B(2131918058);
    L7:
        ((TextView) T90(2131375600)).setText(sb2.a.h(r10.getInviteMsg(), r12, false));
        return;
    L6:
        r12 = s1.B(2131918062);
        goto L7
    L9:
        if (o.B() == true) goto L11;
    L34:
        if (r11 == false) goto L36;
        ((TextView) T90(2131375600)).setText(2131918058);
        return;
    L36:
        TextView r13 = (TextView) T90(2131375600);
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L39;
        r3 = 2131918063;
    L39:
        r13.setText(r3);
        return;
    L11:
        if (r10.getJoinTeamFightInfo() == null) goto L34;
        com.bytedance.android.live.liveinteract.plantform.model.j0 r0 = r10.getJoinTeamFightInfo();
        Intrinsics.checkNotNull(r0);
        if (r0.getTeamId() <= 0) goto L34;
        com.bytedance.android.live.liveinteract.plantform.model.j0 r2 = r10.getJoinTeamFightInfo();
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "$this$isRedTeam");
        if (((int) r2.getTeamId()) != 1) goto L17;
        r1 = true;
    L17:
        com.bytedance.android.live.liveinteract.plantform.model.j0 r14 = r10.getJoinTeamFightInfo();
        Intrinsics.checkNotNull(r14);
        this.m = Integer.valueOf((int) r14.getTeamId());
        if (r1 == false) goto L20;
        String r15 = "#FE2C55";
    L21:
        int r16 = ColorProtector.parseColor(r15);
        if (r11 == false) goto L28;
        SpannableStringBuilder r17 = new SpannableStringBuilder();
        r17.append(s1.B(2131922768));
        if (r1 == false) goto L26;
        String r4 = s1.B(2131922805);
    L27:
        r17.append(r4);
        r17.setSpan(new ForegroundColorSpan(r16), 5, 9, 33);
    L33:
        ((TextView) T90(2131375600)).setText(r17);
        return;
    L26:
        r4 = s1.B(2131922777);
        goto L27
    L28:
        r17 = new SpannableStringBuilder();
        r17.append(s1.B(2131922771));
        if (r1 == false) goto L31;
        String r5 = s1.B(2131922805);
    L32:
        r17.append(r5);
        r17.setSpan(new ForegroundColorSpan(r16), 4, 8, 33);
        goto L33
    L31:
        r5 = s1.B(2131922777);
        goto L32
    L20:
        r15 = "#27A4FF";
        goto L21
    }

    public void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        z0 r7 = this.j;
        if (r7 == null) goto L21;
        IRoom r0 = this.i;
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getOwnerUserIdString();
    L8:
        boolean r3 = !Intrinsics.areEqual(r2, r7.getFromUserIdStr());
        com.bytedance.android.live.liveinteract.plantform.model.e r4 = r7.getGameInviteInfo();
        if (r4 != null) goto L11;
    L13:
        W90(r7, r3);
        ImageView r8 = (ImageView) T90(2131374209);
        c8 r9 = r7.getInvitorInfo();
        if (r9 == null) goto L16;
        py.k r10 = r9.getInvitorAvatar();
    L17:
        a1.v(r8, r10, 2131251889);
        c8 r11 = r7.getInvitorInfo();
        if (r11 == null) goto L20;
        r1 = r11.getInvitorNickName();
    L20:
        Z90(r1);
        this.o = r7.getMessageBoardInfo();
        goto L21
    L16:
        r10 = null;
        goto L17
    L11:
        if (r4.isGameInvite() != true) goto L13;
        this.n = true;
        goto L13
    L7:
        r2 = null;
    L21:
        V90();
        ((TextView) T90(2131384151)).setOnClickListener(x0.a(new AnonymousClass2(this)));
        ((TextView) T90(2131361963)).setOnClickListener(x0.a(new AnonymousClass3(this)));
        ((TextView) T90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf(this.l)}));
        this.h.add(du2.a.d(1, TimeUnit.SECONDS).take(this.l + 1).map(new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this)));
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565506, r3, false);
    }
}
