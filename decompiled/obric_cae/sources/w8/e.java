package w8;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.activity.j;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.retrofit2.SsHttpCall;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements SsHttpCall.IHttpCallReqLevelControl, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f13069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f13070b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicInteger f13071m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ConcurrentHashMap f13072n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lock f13073o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReentrantLock f13074p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Condition f13075q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final CopyOnWriteArraySet f13076r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final CopyOnWriteArraySet f13077s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f13078t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static long f13079u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f13080v;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13081a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a[] f13082b = null;

        static {
            a r8 = new a("RELEASE_COUNTDOWN", 0);
            f13081a = r8;
            f13082b = new a[]{r8, new a("RELEASE_SWITCH", 1), new a("RELEASE_P0BACK", 2)};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f13082b.clone();
        }
    }

    static {
        f13069a = new AtomicLong(0);
        f13070b = new AtomicInteger(0);
        f13071m = new AtomicInteger(0);
        f13072n = new ConcurrentHashMap();
        f13073o = new ReentrantReadWriteLock().writeLock();
        ReentrantLock r8 = new ReentrantLock();
        f13074p = r8;
        f13075q = r8.newCondition();
        HandlerThread r10 = new HandlerThread("RequestController-Handler");
        f13076r = new CopyOnWriteArraySet();
        f13077s = new CopyOnWriteArraySet();
        f13078t = 0;
        f13079u = 0;
        f13080v = 10;
        r10.start();
    }

    public static void a(JSONObject r8) {
        JSONObject r10 = r8.optJSONObject("runtime_req_ctl_config");
        if (r10 != null) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r11 = f13076r;
        r11.clear();
        CopyOnWriteArraySet r12 = f13077s;
        r12.clear();
        JSONArray r13 = r10.optJSONArray("p0");     // Catch: JSONException -> L18
        JSONArray r14 = r10.optJSONArray("p2");     // Catch: JSONException -> L18
        if (r13 == null) goto L12;
        int r15 = 0;
    L10:
        if (r15 >= r13.length()) goto L12;
        r11.add(r13.get(r15).toString());     // Catch: JSONException -> L18
        r15 = r15 + 1;     // Catch: JSONException -> L18
    L12:
        if (r14 == null) goto L20;
        int r16 = 0;
    L14:
        if (r16 >= r14.length()) goto L20;
        r12.add(r14.get(r16).toString());     // Catch: JSONException -> L18
        r16 = r16 + 1;
    L20:
        f13079u = r10.optInt("p0_countdown", 0);
        f13078t = r10.optInt("p1_random", 0);
        f13080v = r10.optInt("p1_maxCount", 10);
        if (Logger.debug() == false) goto L28;
        Logger.e("e", "sP0PathSet is " + r11);
        Logger.e("e", "sP2PathSet is " + r12);
        Logger.e("e", "sP0Countdown is " + f13079u);
        Logger.e("e", "sP1Random is " + f13078t);
        Logger.e("e", "sP1MaxCount is " + f13080v);
        return;
    L28:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public static void b(a r8) {
        if (Logger.debug() == false) goto L5;
        Logger.e("e", "controller, release p1 request, reason is " + r8);
    L5:
        ReentrantLock r10 = f13074p;
        r10.lock();
        f13075q.signalAll();     // Catch: Throwable -> L17
        r10.unlock();
        Lock r11 = f13073o;
        r11.lock();
        Iterator r12 = f13072n.entrySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        Map.Entry r13 = (Map.Entry) r12.next();
        Handler r14 = new Handler(Looper.getMainLooper());
        j r15 = new j(r13, 15);
        if (f13071m.get() <= 3) goto L13;
        int r16 = new Random().nextInt(f13078t);
    L14:
        r14.postDelayed(r15, r16);
        r12.remove();
        goto L9
    L13:
        r16 = 0;
        goto L14
    L15:
        r11.unlock();
        return;
    L17:
        th = move-exception;
        r10.unlock();
        throw th;
    }
}
