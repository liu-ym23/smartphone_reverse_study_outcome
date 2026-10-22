package h0;

import com.bytedance.apm.d;
import com.bytedance.apm6.util.log.Logger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import q0.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f9126b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CopyOnWriteArraySet<d0.a> f9127a;

    /* JADX INFO: renamed from: h0.a$a, reason: collision with other inner class name */
    class RunnableC0175a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9128c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9129g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f9130h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f9131i;

        RunnableC0175a(a r10, String r11, String r12, JSONObject r13) {
            this.f9131i = r10;
            this.f9128c = r11;
            this.f9129g = r12;
            this.f9130h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<d0.a> r10 = this.f9131i.f9127a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r10.next().a(this.f9128c, this.f9129g, this.f9130h);
            goto L4
        }
    }

    private a() {
        this.f9127a = new CopyOnWriteArraySet();
    }

    public static a b() {
        if (f9126b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9126b != null) goto L9;
        f9126b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9126b;
    }

    public void a(d0.a r10) {
        if (r10 == null) goto L8;
        this.f9127a.add(r10);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public void c(String r10, String r11, JSONObject r12) {
        if (d.D() == false) goto L6;
        Logger.d("LogObserver", "logObserverList:" + this.f9127a.size());
    L6:
        if (this.f9127a.size() != 0) goto L8;
        return;
    L8:
        b.f().p(new RunnableC0175a(this, r10, r11, r12));
    }
}
