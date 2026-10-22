package p000if;

import android.text.TextUtils;
import com.bytedance.keva.KevaImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile a f8329m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicBoolean f8330n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f8331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f8332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f8333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f8334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f8335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f8336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f8337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<Integer> f8338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f8339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0093a f8340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CopyOnWriteArrayList f8341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f8342l;

    /* JADX INFO: renamed from: if.a$a, reason: collision with other inner class name */
    public static class C0093a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f8343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f8344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f8345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f8346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f8347e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f8348f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicBoolean f8349g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AtomicBoolean f8350h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ArrayList f8351i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ArrayList f8352j;

        public C0093a() {
            this.f8343a = new CopyOnWriteArrayList();
            this.f8344b = new CopyOnWriteArrayList();
            this.f8345c = new AtomicBoolean(false);
            this.f8346d = new CopyOnWriteArrayList();
            this.f8347e = new AtomicBoolean(false);
            this.f8348f = new AtomicBoolean(false);
            this.f8349g = new AtomicBoolean(false);
            this.f8350h = new AtomicBoolean(false);
            this.f8351i = new ArrayList();
            this.f8352j = new ArrayList();
        }
    }

    static {
        f8330n = new AtomicBoolean(false);
    }

    public a() {
        new AtomicInteger(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        this.f8331a = new AtomicInteger(60000);
        this.f8332b = new CopyOnWriteArrayList();
        this.f8333c = new AtomicBoolean(true);
        this.f8334d = new AtomicBoolean(false);
        this.f8335e = new AtomicInteger(320);
        this.f8336f = new AtomicInteger(0);
        this.f8337g = new AtomicBoolean(false);
        this.f8338h = new CopyOnWriteArrayList();
        this.f8339i = new CopyOnWriteArrayList();
        this.f8340j = new C0093a();
        this.f8341k = new CopyOnWriteArrayList();
        this.f8342l = new AtomicBoolean(false);
    }

    public static boolean a(String r8) {
        CopyOnWriteArrayList r10 = b().f8341k;
        if (TextUtils.isEmpty(r8) == true) goto L17;
        if (r10 == null) goto L17;
        if (r10.isEmpty() == true) goto L17;
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        String r12 = (String) r11.next();
        if (TextUtils.isEmpty(r12) == true) goto L10;
        if (r8.endsWith(r12) == false) goto L10;
        return true;
    L17:
        return false;
    }

    public static a b() {
        if (f8329m != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8329m != null) goto L9;
        f8329m = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f8329m;
    }
}
