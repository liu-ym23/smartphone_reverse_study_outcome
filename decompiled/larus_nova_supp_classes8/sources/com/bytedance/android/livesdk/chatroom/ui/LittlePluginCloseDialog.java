package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LittlePluginCloseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LittlePluginCloseDialog extends AppCompatDialog implements View.OnClickListener {
    public View a;
    public View b;
    public final DataCenter c;
    public final com.bytedance.android.live.broadcastgame.api.model.e d;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r0 = getWindow();
        if (r0 == null) goto L16;
        WindowManager.LayoutParams r1 = new WindowManager.LayoutParams();
        r1.copyFrom(r0.getAttributes());
        r1.width = com.bytedance.android.live.core.utils.s1.f(280.0f);
        r1.height = -2;
        r0.setAttributes(r1);
        View r2 = this.b;
        if (r2 == null) goto L17;
        com.bytedance.android.live.core.utils.a1.p(r2, com.bytedance.android.live.core.utils.s1.f(280.0f));
        return;
    L17:
        return;
    L16:
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void I0(LittlePluginCloseDialog r3) {
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

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (r3 == null) goto L4;
        Integer r4 = Integer.valueOf(r3.getId());
    L5:
        if (r4 != null) goto L8;
    L10:
        if (r4 != null) goto L13;
        return;
    L13:
        if (r4.intValue() != 2131381425) goto L19;
        I0(this);
        DataCenter r5 = this.c;
        if (r5 == null) goto L20;
        r5.put("cmd_close_little_plugin", this.d);
        return;
    L20:
        return;
    L19:
        return;
    L8:
        if (r4.intValue() != 2131365114) goto L10;
        I0(this);
        return;
    L4:
        r4 = null;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        View r4 = LayoutInflater.from(getContext()).inflate(2131565598, null);
        this.a = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        this.b = r4.findViewById(2131369197);
        View r5 = this.a;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L8:
        View r1 = r5.findViewById(2131365114);
        if (r1 == null) goto L11;
        r1.setOnClickListener(this);
    L11:
        TextView r6 = (TextView) r5.findViewById(2131381425);
        if (r6 == null) goto L14;
        r6.setOnClickListener(this);
    L14:
        View r7 = this.a;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L17:
        setContentView(r7);
    }

    public LittlePluginCloseDialog(Context r2, DataCenter r3, com.bytedance.android.live.broadcastgame.api.model.e r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        super(r2, 2131954708);
        this.c = r3;
        this.d = r4;
    }
}
