package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelMemberSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelMemberSettingDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int E = 0;
    public final a B;
    public final long C;
    public final s22.a D;

    public static final class a extends s22.e.a {
        public final /* synthetic */ ChatChannelMemberSettingDialog a;

        @Override // s22.e.a
        public final void a(s22.a r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "chatChannel");
        }

        public a(ChatChannelMemberSettingDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelMemberSettingDialog, java.lang.Object] */
        @Override // s22.e.a
        public final void b(long r4) {
            if (this.a.D.getChannelId() != r4) goto L21;
            ?? r5 = this.a;
            Handler r6 = DialogLancet.resolveDialogHandler(r5);
            if (r6 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            return;
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
            return;
        }
    }

    public final boolean V0() {
        return true;
    }

    public final int getLayoutId() {
        return 2131567389;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        s22.e r1 = ChatChannelUtils.b(RoomContext.a.c(RoomContext.Companion, null, this.C, 1));
        if (r1 == null) goto L26;
        r1.removeListener(this.B);
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        s22.e r0 = ChatChannelUtils.b(RoomContext.a.c(RoomContext.Companion, null, this.C, 1));
        if (r0 == null) goto L14;
        r0.addListener(this.B);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        if (PadConfigUtils.c() == true) goto L10;
        int r4 = s1.w() - s1.A();
        Window r0 = getWindow();
        if (r0 == null) goto L10;
        if (r4 != 0) goto L9;
        r4 = -1;
    L9:
        r0.setLayout(-1, r4);
    L10:
        ((ImageView) findViewById(2131366984)).setOnClickListener(new m(this));
        findViewById(2131371858).setOnClickListener(x0.a(new ChatChannelMemberSettingDialog$initView$2(this)));
        if (PadConfigUtils.c() == false) goto L13;
        findViewById(2131379854).setBackgroundResource(e62.a.d);
        return;
    L13:
        findViewById(2131379854).setBackgroundResource(e62.a.f);
    }

    public ChatChannelMemberSettingDialog(Context r2, long r3, s22.a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "chatChannel");
        super(r2, false);
        this.C = r3;
        this.D = r5;
        this.B = new a(this);
    }
}
