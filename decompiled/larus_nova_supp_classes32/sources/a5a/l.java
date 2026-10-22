package a5a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.basedevtool.logbox.LogBoxLifeCycleListenerFragment;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public final WeakReference<Context> a;
    public final Map<LogBoxLogLevel, a> b;
    public m c;
    public b d;

    public class a {
        public final LogBoxLogLevel a;
        public final List<LogBoxProxy> b;
        public int c;
        public int d;

        public final LogBoxProxy a() {
            if (this.c >= ((ArrayList) this.b).size()) goto L9;
            int r0 = this.c;
            if (r0 >= 0) goto L8;
            return null;
        L8:
            return (LogBoxProxy) ListProtector.get(this.b, r0);
        L9:
            return null;
        }

        public a(LogBoxLogLevel r1) {
            this.a = r1;
            this.b = new ArrayList();
            this.c = 0;
            this.d = 0;
        }

        public final boolean b(LogBoxProxy r4) {
            int r1 = 0;
            if (((ArrayList) this.b).contains(r4) == true) goto L5;
            return false;
        L5:
            this.d -= r4.getLogCount(this.a);
            ((ArrayList) this.b).remove(r4);
            if (((ArrayList) this.b).isEmpty() == true) goto L9;
            r1 = this.c % ((ArrayList) this.b).size();
        L9:
            this.c = r1;
            return true;
        }
    }

    public final void e() {
        Iterator r0 = ((HashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        Map.Entry r1 = (Map.Entry) r0.next();
        a r2 = (a) r1.getValue();
        m r3 = this.c;
        if (r3 == null) goto L4;
        Boolean r4 = (Boolean) ((HashMap) r3.d).get((LogBoxLogLevel) r1.getKey());
        if (r4 != null) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L4;
        if (c(this.a.get()) == false) goto L4;
        if (((ArrayList) r2.b).isEmpty() == false) goto L17;
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        this.c.c((LogBoxLogLevel) r1.getKey(), b(r6), r2.d);
        goto L4
    L17:
        List<LogBoxProxy> r7 = r2.b;
        r6 = ((LogBoxProxy) ListProtector.get(r7, ((ArrayList) r7).size() - 1)).getLastLog(r2.a);
        goto L18
    L10:
        r5 = r4.booleanValue();
        goto L11
    }

    public l(Context r4) {
        this.a = new WeakReference(r4);
        HashMap r0 = new HashMap();
        this.b = r0;
        LogBoxLogLevel r1 = LogBoxLogLevel.Error;
        r0.put(r1, new a(r1));
        LogBoxLogLevel r2 = LogBoxLogLevel.Warn;
        r0.put(r2, new a(r2));
        this.c = new m(r4, this);
        c(r4);
    }

    public static void a(b r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static String b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L36;
        return NameKeys.UnloadStrategy_No_Strategy;
    L36:
        Object r1 = new JSONObject(r5).opt("error");     // Catch: JSONException -> L20
        if ((r1 instanceof String) == false) goto L16;
        String r2 = (String) r1;     // Catch: JSONException -> L20
        JSONObject r3 = new JSONObject((String) r1).optJSONObject("rawError");     // Catch: JSONException -> L13
    L35:
    L23:
        if (r3 == null) goto L25;
        r2 = r3.optString("message", null);
    L25:
        if (r2 == null) goto L29;
        r5 = r2;
    L29:
        if (r5.length() <= 50) goto L32;
        r5 = r5.substring(0, 50);
    L32:
        return r5.replace('\n', ' ');
    L13:
        e = e;
    L22:
        e.getMessage();
        r3 = null;
        goto L23
    L16:
        if ((r1 instanceof JSONObject) == false) goto L19;
        r3 = ((JSONObject) r1).optJSONObject("rawError");     // Catch: JSONException -> L20
        r2 = null;
        goto L35
    L19:
        r3 = null;
        r2 = null;
    L20:
        e = e;
        r2 = null;
        goto L22
    }

    public static boolean c(Context r3) {
        if ((r3 instanceof Activity) == false) goto L18;
        Activity r4 = (Activity) r3;
        if (r4.isFinishing() == false) goto L8;
        return false;
    L8:
        if (r4.getFragmentManager().findFragmentByTag("BaseDevToolLogBoxLifeCycleListener") == null) goto L16;
        return true;
    L16:
        r4.getFragmentManager().beginTransaction().add(new LogBoxLifeCycleListenerFragment(), "BaseDevToolLogBoxLifeCycleListener").commit();     // Catch: IllegalStateException -> L12
        return true;
    L12:
        e = move-exception;
        e.getMessage();
        return false;
    L18:
        return false;
    }

    public final void d(int r6, LogBoxLogLevel r7) {
        Objects.toString(r7);
        a r0 = (a) ((HashMap) this.b).get(r7);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r6 == (-1)) goto L12;
        int r8 = r6 - 1;
        if (r8 < 0) goto L12;
        if (r8 >= ((ArrayList) r0.b).size()) goto L12;
        r0.c = r8;
    L12:
        b r9 = this.d;
        if (r9 == null) goto L37;
        int r1 = r0.c + 1;
        int r2 = ((ArrayList) r0.b).size();
        a r3 = (a) ((HashMap) this.b).get(r7);
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 == null) goto L21;
        LogBoxProxy r5 = r3.a();
        if (r5 == null) goto L21;
        r4 = r5.getEntryUrlForLogSrc();
    L21:
        r9.e(r1, r2, r7, r4);
        b r10 = this.d;
        a r11 = (a) ((HashMap) this.b).get(r7);
        if (r11 == null) goto L26;
        LogBoxProxy r12 = r11.a();
        if (r12 == null) goto L26;
        Map<String, Object> r13 = r12.getLogSources();
    L28:
        r10.b = r13;
        LogBoxProxy r14 = r0.a();
        if (r14 == null) goto L39;
        b r15 = this.d;
        String r16 = r14.getErrorNamespace();
        List<String> r17 = r14.getLogMessages(r7);
        r15.getClass();
        if (r17 == null) goto L40;
        Iterator<String> r18 = r17.iterator();
    L35:
        if (r18.hasNext() == false) goto L41;
        r15.d(r16, r18.next());
        goto L35
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L26:
        r13 = null;
        goto L28
    }
}
