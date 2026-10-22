package ha;

import android.text.TextUtils;
import ja.d;
import ja.f;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f17296a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f17297b = null;

    static {
        f17296a = new ConcurrentHashMap();
        f17297b = new ConcurrentHashMap();
    }

    public static boolean a(String r5, String r10) {
        boolean r11 = false;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        a r12 = ((b) f17297b.get(r5)).f17291a;
        r12.getClass();
        if (r10 != null) goto L45;
    L12:
        byte[] r13 = null;
    L13:
        d r14 = r12.f17289c;
        String r15 = r12.f17287a;
        if (((AtomicBoolean) r14.f18303c).get() == true) goto L44;
        if (r13 == null) goto L44;
        if (r13.length <= 0) goto L44;
        if (((a) ((ConcurrentHashMap) r14.f18301a).get(r15)) == null) goto L44;
        LinkedList r16 = (LinkedList) r14.d;
        monitor-enter(r16);
    L28:
        th = move-exception;
        throw th;
    L25:
        if (((AtomicBoolean) r14.f18303c).get() == false) goto L31;
        monitor-exit(r16);     // Catch: Throwable -> L28
        goto L44
    L31:
        if (((LinkedList) r14.d).size() < 2000) goto L33;
        ((LinkedList) r14.d).poll();     // Catch: Throwable -> L28
    L33:
        LinkedList r17 = (LinkedList) r14.d;     // Catch: Throwable -> L28
        ja.a r18 = new ja.a();     // Catch: Throwable -> L28
        r18.e = r15;     // Catch: Throwable -> L28
        r18.f18297b = r13;     // Catch: Throwable -> L28
        r11 = r17.add(r18);     // Catch: Throwable -> L28
        f r19 = (f) r14.f18302b;     // Catch: Throwable -> L28
        Object r20 = r19.f18308b;     // Catch: Throwable -> L28
        monitor-enter(r20);     // Catch: Throwable -> L28
        r19.f18308b.notify();     // Catch: Throwable -> L39
        monitor-exit(r20);     // Catch: Throwable -> L39
        monitor-exit(r16);     // Catch: Throwable -> L28
        goto L44
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L44:
        return r11;
    L45:
    L11:
        r13 = r10.getBytes();
        goto L13
    L8:
        if (r10.length() <= 0) goto L12;
        r13 = r10.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L11
        goto L13
    }
}
