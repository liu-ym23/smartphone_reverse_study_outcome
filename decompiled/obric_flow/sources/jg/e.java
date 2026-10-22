package jg;

import ai.j0;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.monitor.collector.LockMonitorManager;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18329c;
    public final String d;
    public String e;
    public String f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18330h;

    public e(long r5, String r10, long r11, String r12) {
        this.f18327a = r5;
        this.f18328b = r11;
        this.f18329c = r10;
        this.f18330h = r12;
        String r13 = r10.substring(r10.indexOf("monitor contention with owner"));
        this.g = r13.substring(30, r13.indexOf("(") - 1);
        int r14 = r13.indexOf(" at ");
        if (r14 == (-1)) goto L5;
        String r15 = r13.substring(r14 + 5, r13.indexOf("waiters=", r14));
        String r16 = r15.substring(r15.indexOf(" "));
        this.f = r16.substring(1, r16.indexOf("(")) + r16.substring(r16.indexOf(")") + 1, r16.lastIndexOf(")") + 1);
    L5:
        String r17 = r13.substring(r13.indexOf("blocking from") + 14);
        String r18 = r17.substring(r17.indexOf(" ") + 1);
        this.d = r18.substring(0, r18.indexOf("(")) + r18.substring(r18.indexOf(")") + 1, r18.lastIndexOf(")") + 1);
        if (r7.a.a(s7.a.class) != null) goto L9;
        return;
    L9:
        throw new ClassCastException();
    }

    public static e a(String r10) {
        String r5 = null;
        if (r10 != null) goto L5;
    L69:
        return null;
    L5:
        if (r10.isEmpty() == true) goto L69;
        Log.d("lockDetect", r10);
        String[] r11 = r10.split("&#&");
        if (r11.length == 4) goto L11;
        Log.d("lockDetect", "spiltData != 4".concat(r10));
        return null;
    L11:
        long r12 = Long.parseLong(r11[0]);
        long r13 = Long.parseLong(r11[1]);
        String r14 = r11[2];
        e r15 = new e(r12, r14, r13, r11[3]);
        if (LockMonitorManager.access$300() == false) goto L53;
        BlockingQueue r16 = LockMonitorManager.access$400();
        monitor-enter(r16);
        String r17 = (String) LockMonitorManager.access$400().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L18 InterruptedException -> L20
    L22:
        if (r17 == null) goto L24;
    L26:
        LockMonitorManager.access$502(r17);     // Catch: Throwable -> L18
    L28:
        if (LockMonitorManager.access$400().isEmpty() == true) goto L30;
        LockMonitorManager.access$400().clear();     // Catch: Throwable -> L18
    L30:
        monitor-exit(r16);     // Catch: Throwable -> L18
        BlockingQueue r18 = LockMonitorManager.access$600();
        monitor-enter(r18);
        r5 = (String) LockMonitorManager.access$600().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L35 InterruptedException -> L37
    L39:
        if (r5 == null) goto L41;
    L43:
        LockMonitorManager.access$702(r17);     // Catch: Throwable -> L35
    L45:
        if (LockMonitorManager.access$600().isEmpty() == true) goto L47;
        LockMonitorManager.access$600().clear();     // Catch: Throwable -> L35
    L47:
        monitor-exit(r18);     // Catch: Throwable -> L35
        String r19 = r5;
        r5 = r17;
    L54:
        if (r5 != null) goto L56;
    L64:
        if (r19 != null) goto L66;
    L68:
        return r15;
    L66:
        if (r19.isEmpty() == true) goto L68;
        r15.f = r19;
        goto L68
    L56:
        if (TextUtils.isEmpty(r5) == true) goto L60;
        int r20 = r5.indexOf("at ") + 3;
        int r21 = r5.indexOf(40);
        if (r20 >= r21) goto L60;
        String r22 = r5.substring(r20, r21);
    L62:
        if (r14.contains(r22) == false) goto L64;
        r15.e = r5;
    L60:
        r22 = "unknownMethodName";
        goto L62
    L41:
        if (LockMonitorManager.access$700() == null) goto L43;
        r5 = LockMonitorManager.access$700();     // Catch: Throwable -> L35
        goto L45
    L35:
        th = move-exception;
        throw th;
    L37:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L35
        goto L39
    L24:
        if (LockMonitorManager.access$500() == null) goto L26;
        r17 = LockMonitorManager.access$500();     // Catch: Throwable -> L18
        goto L28
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        r17 = null;
    L18:
        th = move-exception;
        throw th;
    L53:
        r19 = null;
        goto L54
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LockInfo{timestamp=");
        r5.append(this.f18327a);
        r5.append(", duration=");
        r5.append(this.f18328b);
        r5.append(", rawAtrace='");
        r5.append(this.f18329c);
        r5.append("', topActivityName='unknown', blockStackInfo='");
        r5.append(this.d);
        r5.append("', completeBlockStackInfo='");
        r5.append(this.e);
        r5.append("', ownerStackInfo='");
        r5.append(this.f);
        r5.append("', lockThreadName='");
        r5.append(this.f18330h);
        r5.append("', ownerThreadName='");
        return j0.q(r5, this.g, "'}");
    }
}
