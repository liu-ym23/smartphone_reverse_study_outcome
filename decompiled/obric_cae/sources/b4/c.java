package b4;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import r3.l;

/* JADX INFO: loaded from: classes.dex */
public final class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<l> f3052a;

    public c() {
        this.f3052a = new CopyOnWriteArraySet();
    }

    @Override // r3.l
    public final void a(long r8, String r10, JSONObject r11) {
        Iterator<l> r12 = this.f3052a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().a(r8, r10, r11);
        goto L4
    }

    @Override // r3.l
    public final void b(long r8, String r10) {
        Iterator<l> r11 = this.f3052a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().b(r8, r10);
        goto L4
    }

    @Override // r3.l
    public final void c(long r8, String r10, JSONObject r11) {
        Iterator<l> r12 = this.f3052a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().c(r8, r10, r11);
        goto L4
    }
}
