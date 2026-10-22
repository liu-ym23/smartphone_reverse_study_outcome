package f5;

import a6.b;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import r5.f;
import we.a0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f7328e;

    public a(String r8, int r10, ArrayList r11, String r12) {
        this.f7324a = 0;
        this.f7327d = r8;
        this.f7326c = r10;
        if (r11 != null) goto L5;
        List r13 = r2;
        ArrayList r14 = new ArrayList();
    L6:
        this.f7325b = r13;
        this.f7328e = r12;
        return;
    L5:
        ArrayList r15 = new ArrayList(r11);
        r13 = Collections.unmodifiableList(r14);
        r14 = r15;
        goto L6
    }

    public final synchronized Pair a(a0 r8) {
        monitor-enter(this);
        String r10 = b();     // Catch: Throwable -> L22
        long r11 = ((b) ((a6.a) this.f7328e)).a(r8);     // Catch: Throwable -> L22
        if (r11 != (-1)) goto L19;
        b r12 = (b) ((a6.a) this.f7328e);     // Catch: Throwable -> L22
        r12.f56b = 0;     // Catch: Throwable -> L22
        r12.f57c = 0;     // Catch: Throwable -> L22
        monitor-enter(this);     // Catch: Throwable -> L22
        int r13 = this.f7326c + 1;     // Catch: Throwable -> L16
        this.f7326c = r13;     // Catch: Throwable -> L16
        if (this.f7325b.size() <= r13) goto L10;
        String r14 = (String) this.f7325b.get(r13);     // Catch: Throwable -> L16
        this.f7327d = r14;     // Catch: Throwable -> L16
    L11:
        r10 = r14;
        monitor-exit(this);     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r10) == true) goto L19;
        ((b) ((a6.a) this.f7328e)).getClass();     // Catch: Throwable -> L22
        r11 = (long) ((Math.random() * 4500.0d) + 500.0d);     // Catch: Throwable -> L22
        goto L19
    L10:
        r14 = "";
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L19:
        Pair r15 = new Pair(r10, Long.valueOf(r11));     // Catch: Throwable -> L22
        monitor-exit(this);
        return r15;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized String b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (f.b(this.f7327d) == false) goto L8;
        int r8 = this.f7325b.size();     // Catch: Throwable -> L11
        int r10 = this.f7326c;     // Catch: Throwable -> L11
        if (r8 <= r10) goto L8;
        this.f7327d = (String) this.f7325b.get(r10);     // Catch: Throwable -> L11
    L8:
        String r11 = this.f7327d;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r11;
    }

    public final synchronized void c() {
        monitor-enter(this);
        b r8 = (b) ((a6.a) this.f7328e);     // Catch: Throwable -> L6
        r8.f56b = 0;     // Catch: Throwable -> L6
        r8.f57c = 0;     // Catch: Throwable -> L6
        this.f7327d = null;     // Catch: Throwable -> L6
        this.f7326c = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        switch(this.f7324a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r8 = new StringBuilder("DeviceResponse{\n body=");
        r8.append((String) this.f7328e);
        r8.append("\n headers=");
        r8.append(this.f7325b);
        r8.append("\n code=");
        r8.append(this.f7326c);
        r8.append("\n url='");
        return android.aimedia.a.i(r8, this.f7327d, "'}");
    L5:
        return super.toString();
    }

    public a(List r8, a6.a r10) {
        this.f7324a = 1;
        this.f7326c = 0;
        ArrayList r11 = new ArrayList();
        this.f7325b = r11;
        if (r8 == null) goto L5;
        r11.addAll(r8);
    L5:
        Logger.d("WsChannelSdk_ok", "urls : " + r11);
        this.f7328e = r10;
        c();
    }
}
