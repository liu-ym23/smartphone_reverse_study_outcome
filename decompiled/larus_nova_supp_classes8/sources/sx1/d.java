package sx1;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends Dialog {
    public View a;
    public View b;
    public View c;
    public final Handler d;
    public final a e;
    public final List<ViewPropertyAnimator> f;
    public final TokenCert g;

    public class a implements Runnable {
        public final /* synthetic */ d a;

        public final void a() {
            d r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r0));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r1) {
            this.a = r1;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Iterator r0 = ((ArrayList) this.f).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ViewPropertyAnimator r1 = (ViewPropertyAnimator) r0.next();
        if (r1 == null) goto L4;
        r1.cancel();
        goto L4
    L8:
        Handler r2 = DialogLancet.resolveDialogHandler(this);
        if (r2 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(this);
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r3 == null) goto L22;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L11:
        if (Looper.myLooper() == r2.getLooper()) goto L13;
        r2.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isShowing() == false) goto L21;
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(this));
    L21:
        Handler r2 = this.d;
        if (r2 == null) goto L28;
        r2.removeCallbacks(this.e);
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        String r1 = TTLiveSDKContext.getHostService().d().appConfig().getMobileFlowUrl();
        HashMap r2 = new HashMap();
        r2.put("url", URLEncoder.encode(r1, "UTF-8"));     // Catch: Exception -> L10
    L11:
        r2.put("telecom_carrier", e.a(getContext(), this.g));
        r2.put("enter_from", "live");
        if (TextUtils.equals("no_wifi_toast", "no_wifi_byte_free") == false) goto L14;
        r2.put("alert_type", "toast");
    L14:
        u.l().sendLog("no_wifi_toast", r2, new Object[]{new x()});
        this.a.setAlpha(0.0f);
        this.b.setTranslationY(t6.a(getContext(), 20.0f));
        ((ArrayList) this.f).add(this.a.animate().alpha(1.0f).setDuration(300));
        ((ArrayList) this.f).add(this.b.animate().translationY(0.0f).setDuration(300));
        Iterator r0 = ((ArrayList) this.f).iterator();
    L16:
        if (r0.hasNext() == false) goto L20;
        ViewPropertyAnimator r3 = (ViewPropertyAnimator) r0.next();
        if (r3 == null) goto L16;
        r3.start();
        goto L16
    L20:
        Handler r4 = this.d;
        if (r4 == null) goto L34;
        r4.postDelayed(this.e, 4000);
        return;
    L34:
        return;
    L10:
        r2.put("url", "");
        goto L11
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public d(Context r2) {
        super(r2, 2131954742);
        this.e = new a(this);
        this.f = new ArrayList();
        this.g = TokenCert.with("bpea-live_mobile_flow_new");
        this.d = new Handler(Looper.getMainLooper());
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        this.a = LayoutInflater.from(getContext()).inflate(2131565645, null);
        if (getWindow() == null) goto L5;
        getWindow().setLayout(-2, -2);
        getWindow().addFlags(8);
        getWindow().setDimAmount(0.0f);
    L5:
        setContentView(this.a);
        this.b = findViewById(2131367862);
        View r6 = findViewById(2131389492);
        this.c = r6;
        r6.setVisibility(8);
        View r7 = findViewById(2131389520);
        if (r7 == null) goto L11;
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        int r2 = r1.leftMargin;
        int r3 = r1.topMargin;
        r1.setMargins(r2, r3, r1.rightMargin, r3);
        r7.setLayoutParams(r1);
        return;
    L12:
        return;
    }
}
