package com.bytedance.android.live.liveinteract.voicechat.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.livesdk.utils.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q extends com.bytedance.android.livesdk.common.b {
    public TextView b;
    public TextView c;
    public TextView d;
    public final a e;
    public final VoiceChatMuteManager f;

    public static final class a implements VoiceChatMuteManager.a {
        public final /* synthetic */ q a;

        public a(q r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(q r3) {
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

        @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
        public final void C(String r2) {
            Intrinsics.checkNotNullParameter(r2, "targetUserId");
            f2.b(2131919830, 0);
            a(this.a);
        }

        @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
        public final void V(String r2) {
            Intrinsics.checkNotNullParameter(r2, "targetUserId");
            f2.b(2131919827, 0);
            a(this.a);
        }

        @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
        public final void Q(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "targetUserId");
            if ((r3 instanceof ApiServerException) == true) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r4 == true) goto L11;
            ExceptionUtils.handleException(this.a.getContext(), r3, 2131919337);
            return;
        L11:
            return;
        L5:
            if (((ApiServerException) r3).getErrorCode() != 4004468) goto L7;
            r4 = true;
            goto L8
        }

        @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
        public final void i0(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "targetUserId");
            ExceptionUtils.handleException(this.a.getContext(), r3, 2131919335);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.app.Dialog*/.onAttachedToWindow();
        this.f.a(this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.f.g(this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super/*android.app.Dialog*/.onCreate(r3);
        setContentView(LayoutInflater.from(getContext()).inflate(2131565495, null));
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setGravity(80);
        r4.setLayout(-1, -2);
    L5:
        this.b = (TextView) findViewById(2131386504);
        this.c = (TextView) findViewById(2131365133);
        this.d = (TextView) findViewById(2131365114);
        TextView r5 = this.b;
        if (r5 == null) goto L8;
        r5.setOnClickListener(x0.a(new VoiceChatAnchorManageDialog$initViews$1(this)));
    L8:
        TextView r6 = this.c;
        if (r6 == null) goto L11;
        r6.setOnClickListener(x0.a(new VoiceChatAnchorManageDialog$initViews$2(this)));
    L11:
        TextView r7 = this.d;
        if (r7 == null) goto L15;
        r7.setOnClickListener(x0.a(new VoiceChatAnchorManageDialog$initViews$3(this)));
    L15:
        if (this.f.isMute() == true) goto L22;
        TextView r8 = this.b;
        if (r8 == null) goto L19;
        r8.setVisibility(0);
    L19:
        TextView r9 = this.c;
        if (r9 == null) goto L29;
        r9.setVisibility(8);
        return;
    L29:
        return;
    L22:
        TextView r10 = this.b;
        if (r10 == null) goto L25;
        r10.setVisibility(8);
    L25:
        TextView r11 = this.c;
        if (r11 == null) goto L31;
        r11.setVisibility(0);
        return;
    }

    public q(Context r2, VoiceChatMuteManager r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "muteManager");
        super(r2, true);
        this.f = r3;
        this.e = new a(this);
    }
}
