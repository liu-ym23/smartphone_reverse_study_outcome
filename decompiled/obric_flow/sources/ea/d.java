package ea;

import android.content.Context;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ia.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f16809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList f16810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16811c;
    public final String d;
    public boolean e;

    public d(Context r5, String r10) {
        this.f16810b = new LinkedList();
        this.f16811c = 0;
        this.e = false;
        this.f16809a = c.b(r5);
        this.d = r10;
    }

    @Override // ia.b
    public final void a(long r5) {
        if (this.e == true) goto L6;
        c(r5, false);
        return;
    }

    public final void b(String r5, String r10, JSONObject r11) {
        if (this.e == true) goto L9;
        String r12 = r11.toString();
        long r13 = System.currentTimeMillis();
        ga.a r14 = new ga.a();
        r14.f17075b = this.d;
        r14.f17076c = r5;
        r14.d = r10;
        r14.e = r12;
        r14.f = r13;
        LinkedList r15 = this.f16810b;
        if (r15.size() < 200) goto L7;
        c(System.currentTimeMillis(), true);
    L7:
        r15.add(r14);
        return;
    }

    public final void c(long r5, boolean r10) {
        int r11 = this.f16810b.size();
        if (r11 <= 0) goto L21;
        if (r10 == false) goto L6;
    L9:
        this.f16811c = r5;
        LinkedList r12 = this.f16810b;
        monitor-enter(r12);
        LinkedList r13 = new LinkedList(this.f16810b);     // Catch: Throwable -> L18
        this.f16810b.clear();     // Catch: Throwable -> L18
        monitor-exit(r12);     // Catch: Throwable -> L18
        if (r13.size() == 0) goto L27;
        this.f16809a.e(this.d, r13);     // Catch: Exception -> L22
        return;
    L28:
        return;
    L27:
        return;
    L18:
        th = move-exception;
        throw th;
    L6:
        if (r11 >= 5) goto L9;
        if ((r5 - this.f16811c) > 120000) goto L9;
        return;
    }
}
