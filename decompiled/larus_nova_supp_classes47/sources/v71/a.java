package v71;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import m71.c;
import n71.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final boolean a() {
        b r0 = (b) c.a.getValue();
        if (r0 == null) goto L7;
        Boolean r1 = r0.g();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean e() {
        b r0 = (b) c.a.getValue();
        if (r0 == null) goto L7;
        Boolean r1 = r0.f();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean b() {
        if (a() == false) goto L13;
        b r0 = (b) c.a.getValue();
        if (r0 == null) goto L9;
        Boolean r1 = r0.b();
        if (r1 == null) goto L9;
        boolean r2 = r1.booleanValue();
    L10:
        if (r2 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r2 = false;
        goto L10
    L13:
        return false;
    }

    @JvmStatic
    public static final boolean c() {
        if (a() == false) goto L13;
        b r0 = (b) c.a.getValue();
        if (r0 == null) goto L9;
        Boolean r1 = r0.c();
        if (r1 == null) goto L9;
        boolean r2 = r1.booleanValue();
    L10:
        if (r2 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r2 = false;
        goto L10
    L13:
        return false;
    }

    @JvmStatic
    public static final boolean d() {
        if (a() == false) goto L13;
        b r0 = (b) c.a.getValue();
        if (r0 == null) goto L9;
        Boolean r1 = r0.d();
        if (r1 == null) goto L9;
        boolean r2 = r1.booleanValue();
    L10:
        if (r2 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r2 = false;
        goto L10
    L13:
        return false;
    }

    static {
    }

    @JvmStatic
    public static final String g(Integer r7) {
        StringBuilder r0 = new StringBuilder();
        StackTraceElement[] r2 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: Exception -> L7
        int r3 = r2.length;     // Catch: Exception -> L7
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L9;
        StackTraceElement r5 = r2[r4];     // Catch: Exception -> L7
        r0.append(r5.getClassName());     // Catch: Exception -> L7
        r0.append(".");     // Catch: Exception -> L7
        r0.append(r5.getMethodName());     // Catch: Exception -> L7
        r0.append("(");     // Catch: Exception -> L7
        r0.append(r5.getFileName());     // Catch: Exception -> L7
        r0.append(":");     // Catch: Exception -> L7
        r0.append(r5.getLineNumber());     // Catch: Exception -> L7
        r0.append(")\n");     // Catch: Exception -> L7
        r4 = r4 + 1;
    L9:
        if (r7 == null) goto L21;
        int r6 = r7.intValue();
        if (r0.length() <= r6) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == true) goto L17;
        r7 = null;
    L17:
        if (r7 == null) goto L21;
        String r9 = r0.substring(0, r7.intValue());
        if (r9 == null) goto L21;
        return r9;
    L13:
        r8 = false;
    L21:
        return r0.toString();
    L7:
        e = move-exception;
        ALogger.e("CardTraceParamsBuilder", e);
        goto L9
    }

    @JvmStatic
    public static final String f(o r4, DataCenter r5) {
        if (r4 == null) goto L19;
        Map r6 = r4.F2();
        if (r6 == null) goto L19;
        Boolean r1 = null;
        if ((!r6.isEmpty()) == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L19;
        StringBuilder r0 = new StringBuilder();
        Iterator r7 = r6.entrySet().iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) r7.next();
        r0.append((String) r2.getKey());
        r0.append("=");
        r0.append((String) r2.getValue());
        r0.append(",");
        goto L12
    L14:
        StringBuilder r8 = new StringBuilder("is_portrait=");
        if (r5 == null) goto L17;
        r1 = (Boolean) r5.get("data_is_portrait", Boolean.TRUE);
    L17:
        r8.append(r1);
        r0.append(r8.toString());
        String r9 = r0.toString();
        if (r9 == null) goto L19;
        return r9;
    L19:
        return "null";
    }
}
