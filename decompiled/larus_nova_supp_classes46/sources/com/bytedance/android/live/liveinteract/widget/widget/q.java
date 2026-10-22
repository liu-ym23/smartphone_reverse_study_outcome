package com.bytedance.android.live.liveinteract.widget.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q extends com.bytedance.android.livesdk.common.b {
    public TextView b;
    public TextView c;
    public TextView d;
    public HSImageView e;
    public final IRoom f;
    public final LifecycleOwner g;
    public final tf0.q h;
    public boolean i;
    public boolean j;
    public final boolean k;
    public final boolean l;

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        if (this.i == true) goto L5;
        return;
    L5:
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
    L21:
        if (this.h != null) goto L23;
        return;
    L23:
        if (this.j == true) goto L32;
        ALogger.e("ttlive_link", "dismiss dialog follow fail");
        this.h.a();
        return;
    L32:
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r1 == null) goto L19;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r0.getLooper()) goto L10;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.app.Dialog*/.onAttachedToWindow();
        this.i = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.i = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStart() {
        super.onStart();
        if (getWindow() == null) goto L6;
        getWindow().setLayout(-1, -1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if ((getContext() instanceof Activity) == false) goto L8;
        if (((Activity) getContext()).isFinishing() == false) goto L8;
        return;
    L8:
        if (isShowing() == false) goto L11;
        return;
    L11:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(q r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        super/*android.app.Dialog*/.onCreate(r8);
        setCanceledOnTouchOutside(true);
        FrameLayout r0 = new FrameLayout(getContext());
        r0.setOnClickListener(new m(this));
        View r1 = View.inflate(getContext(), 2131565585, r0);
        this.e = r1.findViewById(2131376019);
        TextView r2 = (TextView) r1.findViewById(2131390993);
        this.b = r2;
        r2.setFocusable(true);
        this.c = (TextView) r1.findViewById(2131364730);
        TextView r3 = (TextView) r1.findViewById(2131390648);
        this.d = r3;
        r3.setFocusable(true);
        setContentView(r1);
        IRoom r4 = this.f;
        if (r4 != null) goto L5;
    L7:
        py.k r5 = null;
        String r6 = "";
    L8:
        a1.y(this.e, r5, 2131251677, s1.h(2131101254), t6.a(getContext(), 2.0f));
        this.b.setText(r6);
        this.c.setOnClickListener(new n(this));
        if (this.k == false) goto L12;
        this.d.setText(2131918712);
        this.c.setText(2131918711);
    L14:
        ALogger.w("ttlive_link", "LinkFollowGuideDialog onCreate isAddSong=" + this.k + "isJoinChorus=" + this.l);
        HashMap r7 = new HashMap();
        int r9 = ((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.z0(r7, Integer.valueOf(r9));
        TalkRoomLogUtils.I0(r7, r9);
        j0.l().sendLog("livesdk_fans_link_guide_show", r7, new Object[]{IRoom.class, am2.x.class});
        r3.a(r0, s1.B(2131918704));
        return;
    L12:
        if (this.l == false) goto L14;
        this.d.setText(2131918772);
        this.c.setText(2131918771);
        goto L14
    L5:
        if (r4.getOwner() == null) goto L7;
        r5 = r4.getOwner().getAvatarThumbKt();
        r6 = r4.getOwner().getNickName();
        goto L8
    }

    public q(Context r2, com.bytedance.android.livesdk.chatroom.o r3, LifecycleOwner r4, boolean r5, tf0.q r6) {
        super(r2, true);
        this.i = false;
        this.j = false;
        this.f = r3.getCurrentRoom();
        this.g = r4;
        this.h = r6;
        this.k = r5;
    }

    public q(Context r2, com.bytedance.android.livesdk.chatroom.o r3, LifecycleOwner r4, boolean r5, boolean r6, tf0.q r7) {
        super(r2, true);
        this.i = false;
        this.j = false;
        this.f = r3.getCurrentRoom();
        this.g = r4;
        this.h = r7;
        this.k = r5;
        this.l = r6;
    }
}
