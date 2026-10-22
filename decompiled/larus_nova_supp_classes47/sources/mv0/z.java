package mv0;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostDouyinIm;
import com.bytedance.android.livesdk.widget.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z implements IHostDouyinIm.IDouyinImLoadingListener {
    public final /* synthetic */ x a;
    public final /* synthetic */ Fragment b;

    public static final class a implements DialogInterface.OnCancelListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r1) {
            IHostDouyinIm r2 = TTLiveSDK.hostService().hostDouyinIm();
            if (r2 == null) goto L6;
            r2.cancelDouyinImHomePageToUser();
            return;
        }
    }

    public final void onLoadFinish() {
        Dialog r0 = this.a.a;
        if (r0 == null) goto L22;
        if (r0 == null) goto L26;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(r0));
        return;
    L26:
        return;
    }

    public final void onLoading() {
        x r0 = this.a;
        r0.a = new e1((Activity) this.b.getContext());
        Dialog r1 = this.a.a;
        if (r1 == null) goto L5;
        r1.setCancelable(true);
    L5:
        Dialog r2 = this.a.a;
        if (r2 == null) goto L8;
        r2.setOnCancelListener(a.a);
    L8:
        Dialog r3 = this.a.a;
        if (r3 != null) goto L11;
        return;
    L11:
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
    }

    public z(x r1, Fragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
