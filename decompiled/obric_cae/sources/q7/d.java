package q7;

import android.content.Context;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements u7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f10192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<s7.a> f10193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10196e;

    public d(Context r8, String r10) {
        this.f10193b = new LinkedList();
        this.f10194c = 0;
        this.f10196e = false;
        if (c.f10186i == null) goto L5;
    L14:
        this.f10192a = c.f10186i;
        this.f10195d = r10;
        return;
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c.f10186i != null) goto L9;
        c.f10186i = new c(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // u7.b
    public final void a(long r8) {
        if (this.f10196e == true) goto L6;
        c(r8, false);
        return;
    }

    public final void b(JSONObject r10, String r11, String r12) {
        if (this.f10196e == true) goto L9;
        s7.a r8 = new s7.a(this.f10195d, r11, r12, r10.toString(), System.currentTimeMillis());
        LinkedList<s7.a> r13 = this.f10193b;
        if (r13.size() < 200) goto L7;
        c(System.currentTimeMillis(), true);
    L7:
        r13.add(r8);
        return;
    }

    public final void c(long r8, boolean r10) {
        int r11 = this.f10193b.size();
        if (r11 <= 0) goto L23;
        if (r10 == false) goto L6;
    L9:
        this.f10194c = r8;
        LinkedList<s7.a> r12 = this.f10193b;
        monitor-enter(r12);
        LinkedList r13 = new LinkedList(this.f10193b);     // Catch: Throwable -> L20
        this.f10193b.clear();     // Catch: Throwable -> L20
        monitor-exit(r12);     // Catch: Throwable -> L20
        if (r13.size() != 0) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == true) goto L29;
        this.f10192a.d(this.f10195d, r13);     // Catch: Exception -> L24
        return;
    L30:
        return;
    L29:
        return;
    L16:
        r14 = false;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (r11 >= 5) goto L9;
        if ((r8 - this.f10194c) > 120000) goto L9;
        return;
    }
}
