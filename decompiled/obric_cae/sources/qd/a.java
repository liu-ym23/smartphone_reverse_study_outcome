package qd;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import r3.k;
import we.d0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11296a;

    public a(int r8) {
        if (r8 == 5) goto L6;
        this.f11296a = new CopyOnWriteArraySet();
        return;
    L6:
        this.f11296a = new LinkedHashSet();
    }

    public final synchronized void a(d0 r8) {
        monitor-enter(this);
        ((Set) this.f11296a).remove(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void b(String r8, String r10) {
        Iterator r11 = ((CopyOnWriteArraySet) this.f11296a).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((k) r11.next()).b();
        goto L4
    }

    public /* synthetic */ a(JSONObject r8) {
        this.f11296a = r8;
    }
}
