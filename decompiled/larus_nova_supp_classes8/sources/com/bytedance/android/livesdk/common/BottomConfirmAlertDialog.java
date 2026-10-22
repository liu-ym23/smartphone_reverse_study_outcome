package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/common/BottomConfirmAlertDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BottomConfirmAlertDialog extends CommonBottomDialog {
    public final String a;
    public final String b;
    public final String c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BottomConfirmAlertDialog a;

        public b(BottomConfirmAlertDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L17:
            this.a.getClass();
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

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BottomConfirmAlertDialog a;

        public c(BottomConfirmAlertDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L17:
            this.a.getClass();
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

    static {
    }

    public int getLayoutId() {
        return 2131565405;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        TextView r3 = (TextView) findViewById(2131388924);
        if (r3 == null) goto L5;
        r3.setText(this.a);
    L5:
        TextView r4 = (TextView) findViewById(2131380653);
        if (r4 == null) goto L8;
        r4.setText(this.c);
        r4.setOnClickListener(new b(this));
    L8:
        TextView r5 = (TextView) findViewById(2131382814);
        if (r5 == null) goto L12;
        r5.setText(this.b);
        r5.setOnClickListener(new c(this));
        return;
    }

    public BottomConfirmAlertDialog(Context r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "titleText");
        Intrinsics.checkNotNullParameter(r4, "positiveText");
        Intrinsics.checkNotNullParameter(r5, "negativeText");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
