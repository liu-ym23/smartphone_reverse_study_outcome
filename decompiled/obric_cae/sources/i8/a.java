package i8;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import j8.b;
import j8.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, HandlerThread> f8278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f8279b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f8280c = null;

    /* JADX INFO: renamed from: i8.a$a, reason: collision with other inner class name */
    public static class HandlerThreadC0091a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f8281a;

        public HandlerThreadC0091a() {
            super("ParseThread", 0);
            this.f8281a = false;
        }

        @Override // java.lang.Thread
        public final synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f8281a == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f8281a = true;     // Catch: Throwable -> L11
            super.start();     // Catch: Throwable -> L11
            monitor-exit(this);
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        f8278a = new HashMap();
        f8279b = Arrays.asList(new String[]{"NpthHandlerThread", "NewVideo-HandlerThread", "trace_time_update_thread"});
        f8280c = Arrays.asList(new String[]{"DBHelper-AsyncOp-New"});
        new HashMap();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static HandlerThread a() {
        HashMap<String, HandlerThread> r8 = f8278a;
        Iterator<Map.Entry<String, HandlerThread>> r10 = r8.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r10.next().getValue().isAlive() == true) goto L4;
        r10.remove();
        goto L4
    L8:
        HandlerThread r11 = r8.get("ParseThread");
        HandlerThread r12 = r11;
        if (r11 != null) goto L17;
        HandlerThreadC0091a r13 = new HandlerThreadC0091a();
        r13.start();
        if (c.f8747c == false) goto L16;
        ArrayList r14 = c.f8745a;
        if (r14.contains(r13) == true) goto L16;
        r14.add(r13);
        r13.getLooper().setMessageLogging(new b(r13));
    L16:
        r8.put("ParseThread", r13);
        r12 = r13;
    L17:
        return r12;
    }
}
