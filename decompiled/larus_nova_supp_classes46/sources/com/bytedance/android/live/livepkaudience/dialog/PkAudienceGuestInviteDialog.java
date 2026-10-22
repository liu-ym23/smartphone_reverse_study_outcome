package com.bytedance.android.live.livepkaudience.dialog;

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
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.message.model.InvitorInfo;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkAudienceGuestInviteDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAudienceGuestInviteDialog extends LiveDialogFragment {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> d;
    public Animation e;
    public Animation f;
    public Animation g;
    public final CompositeDisposable h;
    public Room i;
    public xe j;
    public final int k;
    public MessageBoardInfo l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PkAudienceGuestInviteDialog a;

        public b(PkAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            PkAudienceGuestInviteDialog r4 = this.a;
            int r0 = PkAudienceGuestInviteDialog.m;
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
        public final /* synthetic */ PkAudienceGuestInviteDialog a;

        public c(PkAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            PkAudienceGuestInviteDialog r6 = this.a;
            Room r0 = r6.i;
            if (r0 == null) goto L9;
            xe r7 = r6.j;
            if (r7 == null) goto L9;
            com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r1 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r1 == null) goto L9;
            r1.Rc(r0.id, r7.getSecFromUserId(), ReplyType.Reject.ordinal());
        L9:
            int r8 = al0.c.b;
            al0.c.i("oneself", this.a.l);
            this.a.dismiss();     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r9 = DialogFragmentLancet.sLastShowStack;
            if (r9 == null) goto L19;
            com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PkAudienceGuestInviteDialog a;

        public d(PkAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            PkAudienceGuestInviteDialog r6 = this.a;
            Room r0 = r6.i;
            if (r0 == null) goto L17;
            xe r7 = r6.j;
            if (r7 == null) goto L17;
            com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r1 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r1 == null) goto L17;
            r1.Rc(r0.id, r7.getSecFromUserId(), ReplyType.Agree.ordinal());
        L17:
            this.a.dismiss();     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r8 = DialogFragmentLancet.sLastShowStack;
            if (r8 == null) goto L19;
            com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ PkAudienceGuestInviteDialog a;

        public e(PkAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "sec");
            return Long.valueOf(((long) this.a.k) - r6.longValue());
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PkAudienceGuestInviteDialog a;

        public f(PkAudienceGuestInviteDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            ((TextView) this.a.S90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf((int) r6.longValue())}));
            if (r6.longValue() != 0) goto L21;
            PkAudienceGuestInviteDialog r7 = this.a;
            Room r0 = r7.i;
            if (r0 == null) goto L11;
            xe r8 = r7.j;
            if (r8 == null) goto L11;
            com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r1 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r1 == null) goto L11;
            r1.Rc(r0.id, r8.getSecFromUserId(), ReplyType.Reject.ordinal());
        L11:
            int r9 = al0.c.b;
            al0.c.i("overtime", this.a.l);
            this.a.dismiss();     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r10 = DialogFragmentLancet.sLastShowStack;
            if (r10 == null) goto L22;
            com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L22:
            return;
        }
    }

    static {
    }

    public PkAudienceGuestInviteDialog() {
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
        this.e = AnimationUtils.loadAnimation(getContext(), 2130772725);
        this.f = AnimationUtils.loadAnimation(getContext(), 2130772726);
        this.g = AnimationUtils.loadAnimation(getContext(), 2130772727);
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

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        xe r8 = this.j;
        if (r8 == null) goto L25;
        Room r1 = this.i;
        MessageBoardInfo r2 = null;
        if (r1 == null) goto L7;
        String r3 = r1.getOwnerUserIdString();
    L9:
        if ((!Intrinsics.areEqual(r3, r8.getFromUserIdStr())) == false) goto L11;
        ((TextView) S90(2131375600)).setText(2131918058);
    L12:
        ImageView r4 = (ImageView) S90(2131374209);
        InvitorInfo r5 = r8.getInvitorInfo();
        if (r5 == null) goto L15;
        py.k r9 = r5.getInvitorAvatar();
    L16:
        a1.v(r4, r9, 2131251889);
        TextView r10 = (TextView) S90(2131380593);
        InvitorInfo r11 = r8.getInvitorInfo();
        if (r11 == null) goto L19;
        String r12 = r11.getInvitorNickName();
    L20:
        r10.setText(r12);
        MessageBoardInfo r13 = r8.getMessageBoardInfo();
        if ((r13 instanceof MessageBoardInfo) == false) goto L24;
        r2 = r13;
    L24:
        this.l = r2;
        goto L25
    L19:
        r12 = null;
        goto L20
    L15:
        r9 = null;
        goto L16
    L11:
        ((TextView) S90(2131375600)).setText(2131918062);
        goto L12
    L7:
        r3 = null;
    L25:
        Animation r14 = this.f;
        if (r14 == null) goto L28;
        r14.setAnimationListener(new j(this));
    L28:
        Animation r15 = this.g;
        if (r15 == null) goto L31;
        r15.setAnimationListener(new k(this));
    L31:
        Animation r16 = this.e;
        if (r16 == null) goto L36;
        View r17 = S90(2131362935);
        if (r17 == null) goto L36;
        r17.startAnimation(r16);
    L36:
        Animation r18 = this.f;
        if (r18 == null) goto L41;
        HSImageView r19 = S90(2131374209);
        if (r19 == null) goto L41;
        r19.startAnimation(r18);
    L41:
        ((TextView) S90(2131384151)).setOnClickListener(new c(this));
        ((TextView) S90(2131361963)).setOnClickListener(new d(this));
        ((TextView) S90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf(this.k)}));
        this.h.add(du2.a.d(1, TimeUnit.SECONDS).take(this.k + 1).map(new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this)));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565689, r3, false);
    }
}
