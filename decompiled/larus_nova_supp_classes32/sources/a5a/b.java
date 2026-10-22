package a5a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends h {
    public LogBoxLogLevel d;
    public final WeakReference<l> e;
    public final Runnable f;
    public Boolean g;

    public class a extends h.c {
        public final /* synthetic */ b b;

        /* JADX INFO: renamed from: a5a.b$a$a, reason: collision with other inner class name */
        public class RunnableC0001a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(this.b.b.getContext(), this.a, 0).show();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0001a(a r1, String r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: a5a.b$a$b, reason: collision with other inner class name */
        public class C0002b implements b5a.b {
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            @Override // b5a.b
            public final /* synthetic */ void onResponse(int r1, int r2) {
            }

            @Override // b5a.b
            public final void onFailure(String r3) {
                this.b.b(this.a, NameKeys.UnloadStrategy_No_Strategy);
            }

            @Override // b5a.b
            public final void onData(byte[] r2, int r3) {
                String r4 = new String(r2, Charset.defaultCharset());
                this.b.b(this.a, r4);
            }

            public C0002b(a r1, int r2, String r3) {
                this.b = r1;
                this.a = r2;
            }
        }

        public a(b r1) {
            this.b = r1;
            super(r1);
        }

        @JavascriptInterface
        public void postMessage(String r5) {
            JSONObject r0 = new JSONObject(r5);     // Catch: Exception -> L42
            JSONObject r6 = new JSONObject(JSONObjectProtectorUtils.getString(r0, LynxResourceModule.DATA_KEY));     // Catch: Exception -> L42
            String r1 = JSONObjectProtectorUtils.getString(r0, "bridgeName");     // Catch: Exception -> L42
            switch(r1.hashCode()) {
                case -2131858827: goto L24;
                case -348084113: goto L21;
                case 110532135: goto L18;
                case 469389831: goto L15;
                case 1355828097: goto L12;
                case 1456732406: goto L9;
                case 1671672458: goto L6;
                default: goto L26;
            };     // Catch: Exception -> L42
        L26:
            byte r2 = -1;
        L28:
            switch(r2) {
                case 0: goto L40;
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L37;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L30;
                default: goto L54;
            };
        L30:
            String r7 = JSONObjectProtectorUtils.getString(r6, "namespace");     // Catch: Exception -> L42
            int r3 = JSONObjectProtectorUtils.getInt(r0, "callbackId");     // Catch: Exception -> L42
            com.lynx.basedevtool.logbox.a r4 = com.lynx.basedevtool.logbox.a.b.a;     // Catch: Exception -> L42
            Context r8 = this.b.getContext();     // Catch: Exception -> L42
            c r9 = new c(this, r3);     // Catch: Exception -> L42
            com.lynx.basedevtool.logbox.a.InterfaceC0031a r10 = (com.lynx.basedevtool.logbox.a.InterfaceC0031a) ((HashMap) r4.a).get(r7);     // Catch: Exception -> L42
            if (r10 == null) goto L46;
            r10.a(r8, r9);     // Catch: Exception -> L42
            return;
        L46:
            return;
        L33:
            String r11 = JSONObjectProtectorUtils.getString(r6, EasyGoDbTable.Server.NAME);     // Catch: Exception -> L42
            c(JSONObjectProtectorUtils.getInt(r0, "callbackId"), r11);     // Catch: Exception -> L42
            return;
        L34:
            String r12 = JSONObjectProtectorUtils.getString(r6, "message");     // Catch: Exception -> L42
            if (TextUtils.isEmpty(r12) == true) goto L49;
            b5a.c.a(new RunnableC0001a(this, r12));     // Catch: Exception -> L42
            return;
        L49:
            return;
        L37:
            b5a.c.a(new g(this, JSONObjectProtectorUtils.getInt(r6, "viewNumber")));     // Catch: Exception -> L42
            return;
        L38:
            b5a.c.a(new e(this));     // Catch: Exception -> L42
            b5a.c.a(new f(this));     // Catch: Exception -> L42
            return;
        L39:
            b5a.c.a(new d(this));     // Catch: Exception -> L42
            return;
        L40:
            a();     // Catch: Exception -> L42
            b5a.c.a(this.b.f);     // Catch: Exception -> L42
            return;
        L54:
            return;
        L6:
            if (r1.equals("dismiss") == false) goto L26;
            r2 = 1;
            goto L28
        L9:
            if (r1.equals("queryResource") == false) goto L26;
            r2 = 5;
            goto L28
        L12:
            if (r1.equals("loadErrorParser") == false) goto L26;
            r2 = 6;
            goto L28
        L15:
            if (r1.equals("deleteLynxview") == false) goto L26;
            r2 = 2;
            goto L28
        L18:
            if (r1.equals("toast") == false) goto L26;
            r2 = 4;
            goto L28
        L21:
            if (r1.equals("getExceptionStack") == false) goto L26;
            r2 = 0;
            goto L28
        L24:
            if (r1.equals("changeView") == false) goto L26;
            r2 = 3;
        L42:
            e = move-exception;
            e.getMessage();
        }

        public final void c(int r6, String r7) {
            boolean r0 = TextUtils.isEmpty(r7);
            Object r1 = NameKeys.UnloadStrategy_No_Strategy;
            if (r0 == false) goto L6;
            b(r6, NameKeys.UnloadStrategy_No_Strategy);
            return;
        L6:
            C0002b r2 = new C0002b(this, r6, r7);
            if (r7.startsWith("http") == true) goto L9;
            l r3 = this.b.e.get();
            if (r3 == null) goto L34;
            LogBoxLogLevel r4 = this.b.d;
            l.a r5 = (l.a) ((HashMap) r3.b).get(r4);
            if (r5 == null) goto L21;
            LogBoxProxy r8 = r5.a();
            if (r8 == null) goto L21;
            String r9 = r8.getLogSourceWithFileName(r7);
        L24:
            if (TextUtils.isEmpty(r9) == true) goto L34;
            if (r9.startsWith("http") == true) goto L28;
            b(r6, r9);
            return;
        L28:
            if (TextUtils.isEmpty(r9) == false) goto L30;
            return;
        L30:
            if (r9.startsWith("http") == false) goto L56;
            new b5a.a(r9, r2);
            return;
        L56:
            return;
        L21:
            r9 = NameKeys.UnloadStrategy_No_Strategy;
        L34:
            Map<String, Object> r10 = this.b.b;
            if (r10 != null) goto L38;
            b(r6, NameKeys.UnloadStrategy_No_Strategy);
            return;
        L38:
            Iterator<Map.Entry<String, Object>> r11 = r10.entrySet().iterator();
        L40:
            if (r11.hasNext() == false) goto L44;
            Map.Entry<String, Object> r12 = r11.next();
            if (r12.getKey().contains(r7) == false) goto L40;
            Object r13 = r12.getValue();
        L46:
            if ((r13 instanceof String) == false) goto L48;
            r1 = (String) r13;
        L48:
            b(r6, r1);
            return;
        L44:
            r13 = NameKeys.UnloadStrategy_No_Strategy;
            goto L46
        L9:
            if (TextUtils.isEmpty(r7) == false) goto L11;
            return;
        L11:
            if (r7.startsWith("http") == false) goto L54;
            new b5a.a(r7, r2);
            return;
        }
    }

    @Override // a5a.h
    public final void b() {
        l r0 = this.e.get();
        if (r0 == null) goto L5;
        r0.e();
    L5:
        a("javascript: window.logbox.sendEvent({event: \"reset\"});");
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        if (this.g.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.isShowing() == false) goto L7;
        return true;
    }

    public final void finalize() throws Throwable {
        super.finalize();
        this.a.destroy();
    }

    public final void d(String r4, String r5) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put("log", r5);     // Catch: JSONException -> L5
        r1.put("namespace", r4);     // Catch: JSONException -> L5
        r0.put("event", "receiveNewLog");     // Catch: JSONException -> L5
        r0.put(LynxResourceModule.DATA_KEY, r1);     // Catch: JSONException -> L5
        c(r0);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.getMessage();
    }

    public b(Context r2, l r3, k r4) {
        super(r2);
        this.g = Boolean.FALSE;
        this.e = new WeakReference(r3);
        this.f = r4;
        a r5 = new a(this);
        this.a.getSettings().setJavaScriptEnabled(true);
        this.a.getSettings().setUserAgentString(this.a.getSettings().getUserAgentString() + " Lynx LogBox");
        this.a.setWebViewClient(new i(this));
        this.a.setWebChromeClient(new j(this));
        this.a.addJavascriptInterface(r5, "nativeBridge");
        this.a.loadUrl("file:///android_asset/logbox/index.html");
    }

    public final void e(int r5, int r6, LogBoxLogLevel r7, String r8) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r0.put("event", "receiveViewInfo");     // Catch: JSONException -> L5
        r1.put("currentView", r5);     // Catch: JSONException -> L5
        r1.put("viewsCount", r6);     // Catch: JSONException -> L5
        r1.put(LynxUIOverlay.PROP_LEVEL, r7.value);     // Catch: JSONException -> L5
        r1.put("templateUrl", r8);     // Catch: JSONException -> L5
        r0.put(LynxResourceModule.DATA_KEY, r1);     // Catch: JSONException -> L5
        c(r0);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.getMessage();
    }
}
