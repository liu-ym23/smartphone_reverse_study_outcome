package w0b;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleonv2.debug.ui.LoadingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public String a;
    public LoadingView b;
    public TextView c;
    public Dialog d;
    public boolean e;

    public static void a(Dialog r3) {
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public a(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.a = r4;
        View r5 = LayoutInflater.from(r3).inflate(2131559836, null);
        LinearLayout r0 = (LinearLayout) r5.findViewById(2131367046);
        this.b = (LoadingView) r5.findViewById(2131367047);
        TextView r6 = (TextView) r5.findViewById(2131367048);
        this.c = r6;
        if (r6 == null) goto L5;
        r6.setText(this.a);
    L5:
        Dialog r7 = new Dialog(r3, 2131954142);
        r7.setContentView(r0, new LinearLayout.LayoutParams(-1, -1));
        r7.setCancelable(false);
        this.d = r7;
    }
}
