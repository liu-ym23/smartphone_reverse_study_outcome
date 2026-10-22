package com.bytedance.android.livesdk.interactivity.pin.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.interactivity.pin.container.v2.g;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/ui/PinAndQARemoveDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinAndQARemoveDialog extends AppCompatDialog {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final a d;

    public interface a {
        void a();

        void b();
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PinAndQARemoveDialog a;

        public b(PinAndQARemoveDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.d.b();
            AppCompatDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PinAndQARemoveDialog a;

        public c(PinAndQARemoveDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.d.a();
            AppCompatDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PinAndQARemoveDialog a;

        public d(PinAndQARemoveDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            AppCompatDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
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
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setGravity(80);
    L5:
        setContentView(2131567140);
        Window r5 = getWindow();
        if (r5 == null) goto L8;
        r5.setLayout(-1, -2);
    L8:
        TextView r6 = (TextView) this.a.getValue();
        if (r6 == null) goto L11;
        r6.setOnClickListener(new b(this));
    L11:
        TextView r7 = (TextView) this.b.getValue();
        if (r7 == null) goto L14;
        r7.setOnClickListener(new c(this));
    L14:
        TextView r8 = (TextView) this.c.getValue();
        if (r8 == null) goto L18;
        r8.setOnClickListener(new d(this));
        return;
    }

    public PinAndQARemoveDialog(Context r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2, 2131954639);
        this.d = r3;
        this.a = LazyKt.lazy(new PinAndQARemoveDialog$tvRemoveItem$2(this));
        this.b = LazyKt.lazy(new PinAndQARemoveDialog$tvRemoveAll$2(this));
        this.c = LazyKt.lazy(new PinAndQARemoveDialog$cancelView$2(this));
    }
}
