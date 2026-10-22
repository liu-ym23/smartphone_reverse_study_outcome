package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelOwnerSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelOwnerSettingDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int F = 0;
    public final String B;
    public final a C;
    public final long D;
    public final s22.a E;

    public static final class a extends s22.e.a {
        public final /* synthetic */ ChatChannelOwnerSettingDialog a;

        @Override // s22.e.a
        public final void a(s22.a r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "chatChannel");
        }

        public a(ChatChannelOwnerSettingDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelOwnerSettingDialog, java.lang.Object] */
        @Override // s22.e.a
        public final void b(long r4) {
            if (this.a.E.getChannelId() != r4) goto L21;
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
        return 2131567390;
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
        RoomContext.a r1 = RoomContext.Companion;
        s22.e r2 = ChatChannelUtils.b(RoomContext.a.c(r1, null, this.D, 1));
        if (r2 == null) goto L20;
        r2.recordChatChannelDialog(this.B, null);
    L20:
        s22.e r3 = ChatChannelUtils.b(RoomContext.a.c(r1, null, this.D, 1));
        if (r3 == null) goto L23;
        r3.removeListener(this.C);
    L23:
        boolean r4 = findViewById(2131379846).isChecked();
        if (((Boolean) this.E.z().a).booleanValue() == r4) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == false) goto L37;
        s22.e r6 = ChatChannelUtils.b(RoomContext.a.c(r1, null, this.D, 1));
        if (r6 == null) goto L38;
        r6.updateSetting(this.E.getChannelId(), false, r4);
        return;
    L38:
        return;
    L37:
        return;
    L26:
        r5 = false;
        goto L27
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r7 == null) goto L16;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
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
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        RoomContext.a r0 = RoomContext.Companion;
        s22.e r1 = ChatChannelUtils.b(RoomContext.a.c(r0, null, this.D, 1));
        if (r1 == null) goto L10;
        r1.recordChatChannelDialog(this.B, this);
    L10:
        s22.e r2 = ChatChannelUtils.b(RoomContext.a.c(r0, null, this.D, 1));
        if (r2 == null) goto L17;
        r2.addListener(this.C);
        return;
    L17:
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        int r8 = e62.a.a;
        e62.a.a(getWindow(), findViewById(2131381779), RoomContext.a.c(RoomContext.Companion, null, 0, 3));
        r3.a(findViewById(2131363781), "返回");
        ((ImageView) findViewById(2131363781)).setOnClickListener(new p(this));
        if (this.E.e() == false) goto L5;
        final LiveSwitchButton r9 = findViewById(2131379846);
        r9.setOnClickListener(x0.a(new ChatChannelOwnerSettingDialog$initView$$inlined$apply$lambda$1(r9, this)));
        r9.setEnableTouchEvent(false);
        r9.setAlpha(0.3f);
    L6:
        ((TextView) findViewById(2131369127)).setOnClickListener(x0.a(new ChatChannelOwnerSettingDialog$initView$3(this)));
        ((TextView) findViewById(2131383575)).setOnClickListener(x0.a(new ChatChannelOwnerSettingDialog$initView$4(this)));
        int r10 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.a;
        boolean r11 = ((Boolean) this.E.d().a).booleanValue();
        boolean r0 = ((Boolean) this.E.z().a).booleanValue();
        HashMap r1 = new HashMap();
        String r2 = "1";
        if (r11 == false) goto L9;
        Object r13 = "1";
    L10:
        r1.put("voice_state", r13);
        if (r0 == true) goto L14;
        r2 = "0";
    L14:
        r1.put("member_invite_state", r2);
        r1.put("is_anchor", "0");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_match_chat_channel_set_panel_show", r1);
        return;
    L9:
        r13 = "0";
        goto L10
    L5:
        findViewById(2131379846).setChecked(((Boolean) this.E.z().a).booleanValue());
        goto L6
    }

    public ChatChannelOwnerSettingDialog(Context r2, long r3, s22.a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "chatChannel");
        super(r2, false);
        this.D = r3;
        this.E = r5;
        this.B = "ChatChannelOwnerSettingDialog";
        this.C = new a(this);
    }
}
