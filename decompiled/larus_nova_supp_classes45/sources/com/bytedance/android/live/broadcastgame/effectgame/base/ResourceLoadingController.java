package com.bytedance.android.live.broadcastgame.effectgame.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.livesdk.widget.CircleProgressView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ResourceLoadingController {
    public LoadingDialog a;
    public u b;
    public Map<String, ? extends Object> c;
    public final Context d;

    public static final class LoadingDialog extends Dialog {
        public final Lazy a;
        public final Lazy b;
        public final Lazy c;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ LoadingDialog a;

            public a(LoadingDialog r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r4) {
                LoadingDialog r5 = this.a;
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

        public LoadingDialog(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "ctx");
            super(r2, 2131954851);
            this.a = LazyKt.lazy(new ResourceLoadingController$LoadingDialog$textView$2(this));
            this.b = LazyKt.lazy(new ResourceLoadingController$LoadingDialog$progressView$2(this));
            this.c = LazyKt.lazy(new ResourceLoadingController$LoadingDialog$closeBtn$2(this));
        }

        public final void a(int r4) {
            TextView r0 = (TextView) this.a.getValue();
            StringBuilder r1 = new StringBuilder();
            r1.append(r4);
            r1.append('%');
            r0.setText(r1.toString());
            ((CircleProgressView) this.b.getValue()).setProgress(r4 * 3.6f);
        }

        @Override // android.app.Dialog
        public final void onCreate(Bundle r2) {
            super.onCreate(r2);
            setContentView(2131565469);
            setCancelable(false);
            ((View) this.c.getValue()).setOnClickListener(new a(this));
        }
    }

    public ResourceLoadingController(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.d = r2;
    }

    public final void a(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "success");
        LoadingDialog r0 = this.a;
        if (r0 != null) goto L6;
        r5.invoke();
    L31:
        this.a = null;
        this.b = null;
        return;
    L6:
        if (r0.isShowing() != true) goto L27;
        LoadingDialog r1 = this.a;
        if (r1 == null) goto L26;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r1);
        goto L26
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r3 == null) goto L23;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L12:
        if (Looper.myLooper() == r2.getLooper()) goto L14;
        r2.post(DialogLancet.createDismissRunnable(r1));
    L26:
        r5.invoke();
        goto L31
    L27:
        int r6 = b.a;
        JSONObject r7 = new JSONObject().put("status_code", IInteractGameMonitorService.FAILURE_CODE_EFFECT_GAME_START_RESOURCE_CANCEL);
        if (r7 != null) goto L30;
        r7 = new JSONObject();
    L30:
        ((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class)).logGameStartupResult(1, this.b, r7);
        goto L31
    }
}
