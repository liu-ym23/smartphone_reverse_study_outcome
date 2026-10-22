package a5a;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class h extends Dialog {
    public static final /* synthetic */ int c = 0;
    public final WebView a;
    public Map<String, Object> b;

    public class a implements View.OnClickListener {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.b();
            h r5 = this.a;
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

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ h b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.a.evaluateJavascript(this.a, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(h r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c {
        public final /* synthetic */ h a;

        public final void a() {
            InputStream r1 = this.a.getContext().getAssets().open("logbox/mappings.wasm");     // Catch: JSONException -> L9 Throwable -> L11
            ByteArrayOutputStream r2 = new ByteArrayOutputStream();     // Catch: JSONException -> L9 Throwable -> L11
            byte[] r3 = new byte[8192];     // Catch: JSONException -> L9 Throwable -> L11
        L4:
            int r4 = r1.read(r3);     // Catch: JSONException -> L9 Throwable -> L11
            if (r4 == (-1)) goto L6;
            r2.write(r3, 0, r4);     // Catch: JSONException -> L9 Throwable -> L11
            goto L4
        L6:
            r1.close();     // Catch: JSONException -> L9 Throwable -> L11
            String r5 = Base64.encodeToString(r2.toByteArray(), 0);     // Catch: JSONException -> L9 Throwable -> L11
            JSONObject r6 = new JSONObject();     // Catch: JSONException -> L9 Throwable -> L11
            r6.put("event", "loadFile");     // Catch: JSONException -> L9 Throwable -> L11
            JSONObject r7 = new JSONObject();     // Catch: JSONException -> L9 Throwable -> L11
            r7.putOpt("type", "mappings.wasm");     // Catch: JSONException -> L9 Throwable -> L11
            r7.putOpt(LynxResourceModule.DATA_KEY, r5);     // Catch: JSONException -> L9 Throwable -> L11
            r6.putOpt(LynxResourceModule.DATA_KEY, r7);     // Catch: JSONException -> L9 Throwable -> L11
            this.a.c(r6);     // Catch: JSONException -> L9 Throwable -> L11
            return;
        L11:
            e = move-exception;
            e.getMessage();
        }

        public c(h r1) {
            this.a = r1;
        }

        public final void b(int r3, Object r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            JSONObject r0 = new JSONObject();
            r0.put("callbackId", r3);     // Catch: JSONException -> L8
            r0.put(LynxResourceModule.DATA_KEY, r4);     // Catch: JSONException -> L8
            this.a.a("javascript: window.logbox.sendResult(" + r0.toString() + ");");
            return;
        L8:
            e = move-exception;
            e.getMessage();
        }

        @JavascriptInterface
        public void on(String r1, Object r2) {
        }
    }

    public abstract void b();

    static {
    }

    public h(Context r6) {
        super(r6);
        requestWindowFeature(1);
        LinearLayout r1 = new LinearLayout(r6);
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r1.setBackgroundColor(Color.alpha(80));
        r1.setOrientation(1);
        setContentView(r1);
        r1.setOnClickListener(new a(this));
        WebView r0 = new WebView(r6);
        this.a = r0;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -1);
        Resources r7 = r6.getResources();
        r2.setMargins(0, Math.round(WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).heightPixels * 0.39999998f), 0, 0);
        r1.addView(r0, r2);
        if (getWindow() == null) goto L6;
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setLayout(-1, -1);
        return;
    }

    public final void a(String r3) {
        b r0 = new b(this, r3);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        r0.run();
        return;
    L8:
        b5a.c.a(r0);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void c(JSONObject r3) {
        a("javascript: window.logbox.sendEvent(" + r3.toString() + ");");
    }
}
