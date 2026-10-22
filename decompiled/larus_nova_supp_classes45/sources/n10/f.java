package n10;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.opengame.debug.dialog.DebugMenuDialog;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.live.datacontext.k;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ DebugMenuDialog a;

    public f(DebugMenuDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r5 = AnchorGameContext.a.a();
        if (r5 == null) goto L7;
        k<Boolean> r6 = r5.getOpenGamePerfUploadEvent();
        if (r6 == null) goto L7;
        r6.post(Boolean.TRUE);
    L7:
        CommonBottomDialog r7 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r7);
        if (r0 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r1 == null) goto L21;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L10:
        if (Looper.myLooper() == r0.getLooper()) goto L12;
        r0.post(DialogLancet.createDismissRunnable(r7));
    }
}
