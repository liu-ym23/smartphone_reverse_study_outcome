package r40;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: r40.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0269a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0269a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            a r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L17:
            this.a.cancel();
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
            goto L17
        }
    }

    public a(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, 2131954397);
        View r0 = LayoutInflater.from(r6).inflate(2131565621, null);
        setContentView(r0);
        setCanceledOnTouchOutside(false);
        Window r2 = getWindow();
        if (r2 == null) goto L5;
        WindowManager.LayoutParams r3 = r2.getAttributes();
        r3.height = (int) UIUtils.dip2Px(r6, 86.0f);
        r3.width = (int) UIUtils.dip2Px(r6, 104.0f);
        r2.setAttributes(r3);
        r2.setBackgroundDrawable(new ColorDrawable(0));
    L5:
        ((TextView) r0.findViewById(2131388367)).setText(r7);
        ((ImageView) r0.findViewById(2131366984)).setOnClickListener(new ViewOnClickListenerC0269a(this));
    }
}
