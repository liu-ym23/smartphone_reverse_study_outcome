package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ez;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/PlaySettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlaySettingDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int D = 0;
    public qk1.a B;
    public boolean C;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PlaySettingDialog a;

        public a(PlaySettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonStandardBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L17:
            int r6 = com.bytedance.android.livesdk.chatroom.utils.e5.a;
            com.bytedance.android.livesdk.chatroom.utils.e5.b(this.a.getContext());
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
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
            r0.post(DialogLancet.createDismissRunnable(r5));
            goto L17
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PlaySettingDialog a;

        public b(PlaySettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonStandardBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L17:
            Activity r6 = com.bytedance.android.livesdk.utils.z2.b.getActivity();
            if (r6 == null) goto L26;
            com.bytedance.android.livesdk.chatroom.utils.e5.a(r6);
            return;
        L26:
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
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
            r0.post(DialogLancet.createDismissRunnable(r5));
            goto L17
        }
    }

    public final int getLayoutId() {
        return 2131565705;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qk1.a r0 = this.B;
        if (r0 == null) goto L6;
        r0.a.clear();
        return;
    }

    public PlaySettingDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.C = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String W0(int r2) {
        return getContext().getResources().getString(r2);
    }

    public final void X0(long r5) {
        if (this.C == true) goto L5;
        return;
    L5:
        RelativeLayout r0 = (RelativeLayout) findViewById(2131362519);
        final LiveSwitchButton r1 = (LiveSwitchButton) findViewById(2131362521);
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.b.f3;
        Long r3 = Long.valueOf(r5);
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
        if (r1 != null) goto L8;
    L12:
        if (r1 == null) goto L15;
        r1.setOnClickListener(new PlaySettingDialog$updateAnchorRelation$1(this, r1));
        return;
    L15:
        return;
    L8:
        if (r5 != 1) goto L10;
        boolean r6 = true;
    L11:
        r1.setChecked(r6);
        goto L12
    L10:
        r6 = false;
        goto L11
    }

    public final void Y0(long r10) {
        final LiveSwitchButton r0 = (LiveSwitchButton) findViewById(2131362529);
        TextView r1 = (TextView) findViewById(2131362528);
        RelativeLayout r2 = (RelativeLayout) findViewById(2131362532);
        LinearLayout r3 = (LinearLayout) findViewById(2131392203);
        TextView r4 = (TextView) findViewById(2131362531);
        if (r0 == null) goto L6;
        r0.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.b.e3.getValue()).booleanValue());
    L6:
        if (r0 != null) goto L8;
    L13:
        if (r0 == null) goto L16;
        r0.setOnClickListener(new PlaySettingDialog$updateUserGiftUI$1(this, r0));
    L16:
        if (r10 != 5) goto L28;
        if (r2 == null) goto L19;
        r2.setVisibility(0);
    L19:
        if (r1 == null) goto L21;
        r1.setVisibility(8);
    L21:
        if (r4 == null) goto L23;
        r4.setVisibility(0);
    L23:
        if (r4 == null) goto L25;
        r4.setText(com.bytedance.android.live.core.utils.s1.B(2131914618));
    L25:
        if (r3 == null) goto L46;
        r3.setOnClickListener(new a(this));
        return;
    L46:
        return;
    L28:
        if (r10 != 7) goto L39;
        if (r2 == null) goto L31;
        r2.setVisibility(0);
    L31:
        if (r1 == null) goto L33;
        r1.setVisibility(8);
    L33:
        if (r4 == null) goto L35;
        r4.setVisibility(0);
    L35:
        if (r4 == null) goto L37;
        r4.setText(com.bytedance.android.live.core.utils.s1.B(2131914619));
    L37:
        if (r3 == null) goto L48;
        r3.setOnClickListener(new b(this));
        return;
    L48:
        return;
    L39:
        if (r2 == null) goto L41;
        r2.setVisibility(8);
    L41:
        if (r1 == null) goto L43;
        r1.setVisibility(0);
    L43:
        if (r4 == null) goto L50;
        r4.setVisibility(8);
        return;
    L50:
        return;
    L8:
        if (r0.isChecked() != true) goto L13;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        if (r1 == null) goto L13;
        r1.setVisibility(0);
        goto L13
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        this.C = true;
        this.B = new qk1.a();
        if (this.C == false) goto L6;
        X0(((Long) com.bytedance.android.livesdk.sharedpref.b.f3.getValue()).longValue());
    L6:
        RelativeLayout r0 = (RelativeLayout) findViewById(2131362527);
        if (ez.a.getValue().booleanValue() == false) goto L27;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L20;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L20;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L20;
        RoomAuthStatus r4 = r3.getRoomAuthStatus();
        if (r4 == null) goto L20;
        if (r4.getEnableGift() == false) goto L27;
    L20:
        if (this.C == true) goto L22;
        this.B = new qk1.a();
    L22:
        Y0(0);
        qk1.a r5 = this.B;
        if (r5 == null) goto L25;
        r5.b(new PlaySettingDialog$initReceiveGiftSwitchSetting$3(this), new PlaySettingDialog$initReceiveGiftSwitchSetting$4(this));
    L25:
        if (r0 == null) goto L34;
        r0.setVisibility(0);
    L34:
        TextView r6 = (TextView) findViewById(2131380302);
        if (r6 == null) goto L37;
        r6.setOnClickListener(f8.a);
    L37:
        View r8 = findViewById(2131362527);
        if (r8 == null) goto L41;
        r8.setOnClickListener(e8.a);
        com.bytedance.android.livesdk.r3.e(r8, new PlaySettingDialog$addContentDescription$$inlined$let$lambda$1(this));
        return;
    L41:
        return;
    L27:
        if (r0 == null) goto L30;
        r0.setVisibility(8);
    L30:
        if (this.C == false) goto L34;
        qk1.a r9 = this.B;
        if (r9 == null) goto L34;
        r9.b(new PlaySettingDialog$initReceiveGiftSwitchSetting$1(this), PlaySettingDialog$initReceiveGiftSwitchSetting$2.INSTANCE);
        goto L34
    }
}
