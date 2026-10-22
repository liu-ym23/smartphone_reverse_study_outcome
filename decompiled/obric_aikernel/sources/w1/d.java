package w1;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.g;
import java.util.ArrayList;
import java.util.List;
import okhttp3.z;

/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f13294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x1.b f13295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13297d;

    d(List<String> r10, x1.b r11) {
        this.f13296c = 0;
        ArrayList r12 = new ArrayList();
        this.f13294a = r12;
        if (r10 == null) goto L5;
        r12.addAll(r10);
    L5:
        Logger.d("WsChannelSdk_ok", "urls : " + r12);
        this.f13295b = r11;
        d();
    }

    synchronized String a() {
        monitor-enter(this);
        int r10 = this.f13296c + 1;     // Catch: Throwable -> L11
        this.f13296c = r10;     // Catch: Throwable -> L11
        if (this.f13294a.size() <= r10) goto L9;
        String r11 = this.f13294a.get(r10);     // Catch: Throwable -> L11
        this.f13297d = r11;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r11;
    L9:
        monitor-exit(this);
        return "";
    L11:
        th = move-exception;
        throw th;
    }

    synchronized Pair<String, Long> b(z r10) {
        monitor-enter(this);
        String r11 = c();     // Catch: Throwable -> L11
        long r12 = this.f13295b.b(r10);     // Catch: Throwable -> L11
        if (r12 != (-1)) goto L8;
        this.f13295b.reset();     // Catch: Throwable -> L11
        r11 = a();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r11) == true) goto L8;
        r12 = this.f13295b.a();     // Catch: Throwable -> L11
    L8:
        Pair<String, Long> r13 = new Pair(r11, Long.valueOf(r12));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r13;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized String c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (g.b(this.f13297d) == false) goto L8;
        int r10 = this.f13294a.size();     // Catch: Throwable -> L11
        int r11 = this.f13296c;     // Catch: Throwable -> L11
        if (r10 <= r11) goto L8;
        this.f13297d = this.f13294a.get(r11);     // Catch: Throwable -> L11
    L8:
        String r12 = this.f13297d;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    }

    synchronized void d() {
        monitor-enter(this);
        this.f13295b.reset();     // Catch: Throwable -> L6
        this.f13297d = null;     // Catch: Throwable -> L6
        this.f13296c = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
