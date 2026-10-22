package com.bytedance.android.live.liveinteract.interact.audience.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.c8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/InteractAudienceGuestInviteDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceGuestInviteDialog extends LiveDialogFragment {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> d;
    public Animation e;
    public Animation f;
    public Animation g;
    public final CompositeDisposable h;
    public IRoom i;
    public z0 j;
    public final int k;
    public IMessageBoardInfo l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ InteractAudienceGuestInviteDialog a;

        public b(InteractAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            InteractAudienceGuestInviteDialog r4 = this.a;
            int r0 = InteractAudienceGuestInviteDialog.m;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L18;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L9;
            View r6 = r5.getCurrentFocus();
        L10:
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L15;
            return;
        L15:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L9:
            r6 = null;
            goto L10
        L21:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestInviteDialog a;

        public c(InteractAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            InteractAudienceGuestInviteDialog r10 = this.a;
            IRoom r0 = r10.i;
            if (r0 == null) goto L17;
            z0 r11 = r10.j;
            if (r11 == null) goto L17;
            com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r2 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r2 == null) goto L17;
            long r3 = r0.getId();
            String r1 = r11.getSecFromUserId();
            if (r1 != null) goto L11;
            String r5 = "";
        L12:
            String r12 = r11.getFromUserIdStr();
            if (r12 != null) goto L15;
            String r6 = "";
        L16:
            r2.X3(r3, r5, r6, ReplyType.Reject.ordinal());
            goto L17
        L15:
            r6 = r12;
            goto L16
        L11:
            r5 = r1;
        L17:
            com.bytedance.android.live.liveinteract.utils.d r13 = jf0.c.a;
            jf0.c.m("oneself", this.a.l);
            this.a.dismiss();     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r14 = DialogFragmentLancet.sLastShowStack;
            if (r14 == null) goto L27;
            com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestInviteDialog a;

        public d(InteractAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            InteractAudienceGuestInviteDialog r10 = this.a;
            IRoom r0 = r10.i;
            if (r0 == null) goto L25;
            z0 r11 = r10.j;
            if (r11 == null) goto L25;
            com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r2 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r2 == null) goto L25;
            long r3 = r0.getId();
            String r1 = r11.getSecFromUserId();
            if (r1 != null) goto L11;
            String r5 = "";
        L12:
            String r12 = r11.getFromUserIdStr();
            if (r12 != null) goto L15;
            String r6 = "";
        L16:
            r2.X3(r3, r5, r6, ReplyType.Agree.ordinal());
            goto L25
        L15:
            r6 = r12;
            goto L16
        L11:
            r5 = r1;
        L25:
            this.a.dismiss();     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r13 = DialogFragmentLancet.sLastShowStack;
            if (r13 == null) goto L27;
            com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ InteractAudienceGuestInviteDialog a;

        public e(InteractAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "sec");
            return Long.valueOf(((long) this.a.k) - r6.longValue());
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ InteractAudienceGuestInviteDialog a;

        public f(InteractAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            ((TextView) this.a.S90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf((int) r10.longValue())}));
            if (r10.longValue() != 0) goto L29;
            InteractAudienceGuestInviteDialog r11 = this.a;
            IRoom r0 = r11.i;
            if (r0 == null) goto L19;
            z0 r12 = r11.j;
            if (r12 == null) goto L19;
            com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r2 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r2 == null) goto L19;
            long r3 = r0.getId();
            String r1 = r12.getSecFromUserId();
            if (r1 != null) goto L13;
            String r5 = "";
        L14:
            String r13 = r12.getFromUserIdStr();
            if (r13 != null) goto L17;
            String r6 = "";
        L18:
            r2.X3(r3, r5, r6, ReplyType.Reject.ordinal());
            goto L19
        L17:
            r6 = r13;
            goto L18
        L13:
            r5 = r1;
        L19:
            com.bytedance.android.live.liveinteract.utils.d r14 = jf0.c.a;
            jf0.c.m("overtime", this.a.l);
            this.a.dismiss();     // Catch: Exception -> L22
            return;
        L22:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r15 = DialogFragmentLancet.sLastShowStack;
            if (r15 == null) goto L30;
            com.bytedance.crash.d.d(r15, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L30:
            return;
        }
    }

    static {
    }

    public InteractAudienceGuestInviteDialog() {
        this.d = new LinkedHashMap();
        this.h = new CompositeDisposable();
        this.k = 9;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.h.dispose();
        Animation r0 = this.f;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animation r1 = this.g;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        Animation r2 = this.e;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        ((LinkedHashMap) this.d).clear();
    }

    public final View S90(int r3) {
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
        if (r5 == null) goto L12;
        r5.setInterpolator(new LinearInterpolator());
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new b(this));
        r3.setCanceledOnTouchOutside(false);
        return r3;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        z0 r7 = this.j;
        if (r7 == null) goto L25;
        IRoom r0 = this.i;
        if (r0 == null) goto L8;
        String r1 = r0.getOwnerUserIdString();
        if (r1 == null) goto L8;
    L10:
        if (r7.isFromUser(r1) == true) goto L12;
        ((TextView) S90(2131375600)).setText(2131918058);
    L17:
        ImageView r2 = (ImageView) S90(2131374209);
        c8 r3 = r7.getInvitorInfo();
        String r4 = null;
        if (r3 == null) goto L20;
        k r8 = r3.getInvitorAvatar();
    L21:
        a1.v(r2, r8, 2131251889);
        TextView r9 = (TextView) S90(2131380593);
        c8 r10 = r7.getInvitorInfo();
        if (r10 == null) goto L24;
        r4 = r10.getInvitorNickName();
    L24:
        r9.setText(r4);
        this.l = r7.getMessageBoardInfo();
        goto L25
    L20:
        r8 = null;
        goto L21
    L12:
        TextView r11 = (TextView) S90(2131375600);
        if (fj0.e.i() == false) goto L15;
        int r12 = 2131918063;
    L16:
        r11.setText(r12);
        goto L17
    L15:
        r12 = 2131918062;
    L8:
        r1 = "";
    L25:
        Animation r13 = this.f;
        if (r13 == null) goto L28;
        r13.setAnimationListener(new com.bytedance.android.live.liveinteract.interact.audience.dialog.a(this));
    L28:
        Animation r14 = this.g;
        if (r14 == null) goto L31;
        r14.setAnimationListener(new com.bytedance.android.live.liveinteract.interact.audience.dialog.b(this));
    L31:
        Animation r15 = this.e;
        if (r15 == null) goto L36;
        View r16 = S90(2131362935);
        if (r16 == null) goto L36;
        r16.startAnimation(r15);
    L36:
        Animation r17 = this.f;
        if (r17 == null) goto L41;
        HSImageView r18 = S90(2131374209);
        if (r18 == null) goto L41;
        r18.startAnimation(r17);
    L41:
        ((TextView) S90(2131384151)).setOnClickListener(new c(this));
        ((TextView) S90(2131361963)).setOnClickListener(new d(this));
        ((TextView) S90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf(this.k)}));
        this.h.add(du2.a.d(1, TimeUnit.SECONDS).take(this.k + 1).map(new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this)));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565499, r3, false);
    }
}
