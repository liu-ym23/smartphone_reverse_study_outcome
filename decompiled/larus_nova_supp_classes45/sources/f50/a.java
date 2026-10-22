package f50;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import c50.c;
import c50.d;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.common.utility.reflect.Reflect;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final boolean a;
    public final boolean b;

    public a(boolean r2, boolean r3) {
        this.a = false;
        this.b = false;
        if (v.a() == false) goto L6;
        this.a = r2;
        this.b = r3;
        return;
    }

    public final void a(HashMap<Integer, d> r2, c r3) {
        if (this.a == false) goto L12;
        if (r3 == null) goto L13;
        if (r2 == null) goto L11;
        d r4 = r2.get(Integer.valueOf(r3.d));
        if (r4 == null) goto L11;
        r4.b();
    L11:
        return;
    L13:
        return;
    }

    public final void b(Handler r11, HashMap<Integer, d> r12) {
        if (this.a == true) goto L6;
        return;
    L6:
        if (this.b == true) goto L8;
        if (r11 == null) goto L49;
        HashMap r0 = new HashMap();
        Message r13 = (Message) Reflect.on((MessageQueue) Reflect.on(r11).get("mQueue", new Class[0])).get("mMessages", new Class[0]);     // Catch: Exception -> L45
    L33:
        if (r13 == null) goto L47;
        int r3 = r13.what;     // Catch: Exception -> L45
        Integer r4 = (Integer) r0.get(Integer.valueOf(r3));     // Catch: Exception -> L45
        if (r4 != null) goto L37;
    L39:
        int r5 = 0;
    L40:
        r0.put(Integer.valueOf(r3), Integer.valueOf(r5 + 1));     // Catch: Exception -> L45
        r13.getWhen();     // Catch: Exception -> L45
        Runnable r6 = r13.getCallback();     // Catch: Exception -> L45
        if (r6 == null) goto L43;
        Runnable r7 = (Runnable) Reflect.on(r6).get("origin", new Class[0]);     // Catch: Exception -> L60
    L43:
        r13.getTarget();     // Catch: Exception -> L45
        r13 = (Message) Reflect.on(r13).get("next", new Class[0]);     // Catch: Exception -> L45
        goto L33
    L37:
        if (r4.intValue() < 0) goto L39;
        r5 = r4.intValue();     // Catch: Exception -> L45
    L47:
        r0.toString();
    L45:
        e = move-exception;
        e.printStackTrace();
    L49:
        if (r12 == null) goto L59;
        Iterator<Map.Entry<Integer, d>> r14 = r12.entrySet().iterator();
        if (r14.hasNext() == false) goto L77;
    L54:
        d r15 = r14.next().getValue();
        if (r15 == null) goto L58;
        r15.b();
    L58:
        if (r14.hasNext() == true) goto L54;
        return;
    L77:
        return;
    L59:
        return;
    L8:
        if (r11 == null) goto L49;
        HashMap r8 = new HashMap();
        StringBuilder r9 = new StringBuilder();
        Message r16 = (Message) Reflect.on((MessageQueue) Reflect.on(r11).get("mQueue", new Class[0])).get("mMessages", new Class[0]);     // Catch: Exception -> L25
        int r17 = 0;
    L13:
        if (r16 == null) goto L28;
        r17 = r17 + 1;
        int r18 = r16.what;     // Catch: Exception -> L23
        Integer r19 = (Integer) r8.get(Integer.valueOf(r18));     // Catch: Exception -> L23
        if (r19 != null) goto L18;
    L20:
        int r21 = 0;
    L21:
        r8.put(Integer.valueOf(r18), Integer.valueOf(r21 + 1));     // Catch: Exception -> L23
        r9.append("Msg:");     // Catch: Exception -> L23
        r9.append(r16.what);     // Catch: Exception -> L23
        r9.append("; ");     // Catch: Exception -> L23
        r16 = (Message) Reflect.on(r16).get("next", new Class[0]);     // Catch: Exception -> L23
        goto L13
    L18:
        if (r19.intValue() < 0) goto L20;
        r21 = r19.intValue();     // Catch: Exception -> L23
    L23:
        e = e;
    L27:
        e.printStackTrace();
    L28:
        r9.insert(0, "MessageQueue Info: size= " + r17 + "; " + r8.toString());
    L25:
        e = e;
        r17 = 0;
        goto L27
    }
}
