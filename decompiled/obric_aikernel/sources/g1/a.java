package g1;

import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f8909d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<l1.a> f8910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<String> f8911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.applog.c f8912c;

    static {
        f8909d = Collections.singletonList("AppLogCache");
    }

    public a(com.bytedance.applog.c r10) {
        this.f8910a = new LinkedList();
        this.f8911b = new LinkedList();
        this.f8912c = r10;
    }

    public void a(l1.a r10) {
        LinkedList<l1.a> r11 = this.f8910a;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f8910a.size() <= 1000) goto L7;
        l1.a r12 = this.f8910a.poll();     // Catch: Throwable -> L10
        this.f8912c.R().i(r12, MonitorState.f_cache);     // Catch: Throwable -> L10
        this.f8912c.R().m(MonitorKey.f_cache_event, com.bytedance.applog.monitor.a.c(r12));     // Catch: Throwable -> L10
        this.f8912c.P().g(f8909d, "AppLogCache overflow remove data: {}", new Object[]{r12});     // Catch: Throwable -> L10
    L7:
        this.f8910a.add(r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
    }

    public void b(String[] r10) {
        LinkedList<String> r11 = this.f8911b;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f8911b.size() <= 1000) goto L7;
        String r12 = this.f8911b.poll();     // Catch: Throwable -> L10
        l1.a r13 = l1.a.g(r12);     // Catch: Throwable -> L10
        this.f8912c.R().i(r13, MonitorState.f_cache);     // Catch: Throwable -> L10
        this.f8912c.R().m(MonitorKey.f_cache_event, com.bytedance.applog.monitor.a.c(r13));     // Catch: Throwable -> L10
        this.f8912c.P().g(f8909d, "AppLogCache overflow2 remove data: " + r12, new Object[0]);     // Catch: Throwable -> L10
    L7:
        this.f8911b.addAll(Arrays.asList(r10));     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
    }

    public int c(ArrayList<l1.a> r10) {
        LinkedList<l1.a> r11 = this.f8910a;
        monitor-enter(r11);
        int r12 = this.f8910a.size();     // Catch: Throwable -> L7
        r10.addAll(this.f8910a);     // Catch: Throwable -> L7
        this.f8910a.clear();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public String[] d() {
        int r10 = this.f8911b.size();
        if (r10 <= 0) goto L5;
        String[] r11 = new String[r10];
        this.f8911b.toArray(r11);
        this.f8911b.clear();
        return r11;
    L5:
        return null;
    }
}
