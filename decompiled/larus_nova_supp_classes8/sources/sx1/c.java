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
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.bpea.cert.token.TokenCert;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends Dialog {
    public View a;
    public View b;
    public TextView c;
    public View d;
    public final List<ViewPropertyAnimator> e;
    public final TokenCert f;

    @Override // android.app.Dialog
    public final void onBackPressed() {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        Iterator r1 = ((ArrayList) this.e).iterator();
    L19:
        if (r1.hasNext() == false) goto L23;
        ViewPropertyAnimator r2 = (ViewPropertyAnimator) r1.next();
        if (r2 == null) goto L19;
        r2.cancel();
        goto L19
    L23:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        a("no_wifi_alert");
        this.a.setAlpha(0.0f);
        this.b.setTranslationY(t6.a(getContext(), 20.0f));
        long r3 = 300;
        ((ArrayList) this.e).add(this.a.animate().alpha(1.0f).setDuration(r3));
        ((ArrayList) this.e).add(this.b.animate().translationY(0.0f).setDuration(r3));
        Iterator r0 = ((ArrayList) this.e).iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        ViewPropertyAnimator r1 = (ViewPropertyAnimator) r0.next();
        if (r1 == null) goto L9;
        r1.start();
        goto L9
    L13:
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public c(Context r2) {
        super(r2, 2131954742);
        this.e = new ArrayList();
        this.f = TokenCert.with("bpea-live_mobile_flow_old");
    }

    public final void a(String r6) {
        String r1 = TTLiveSDKContext.getHostService().d().appConfig().getMobileFlowUrl();
        HashMap r2 = new HashMap();
        r2.put("url", URLEncoder.encode(r1, "UTF-8"));     // Catch: Throwable -> L5
    L6:
        r2.put("telecom_carrier", e.a(getContext(), this.f));
        r2.put("enter_from", "live");
        if (TextUtils.equals(r6, "no_wifi_byte_free") == false) goto L9;
        r2.put("alert_type", "popup");
    L9:
        u.l().sendLog(r6, r2, new Object[]{new x()});
        return;
    L5:
        r2.put("url", "");
        goto L6
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.a = LayoutInflater.from(getContext()).inflate(2131565644, null);
        if (getWindow() == null) goto L5;
        getWindow().setLayout(-1, -1);
        getWindow().setDimAmount(0.0f);
    L5:
        setContentView(this.a);
        this.b = findViewById(2131367862);
        this.c = (TextView) findViewById(2131389553);
        this.d = findViewById(2131389492);
        this.c.setOnClickListener(new a(this));
        this.d.setVisibility(8);
        this.c.setOnTouchListener(new b(this));
    }
}
