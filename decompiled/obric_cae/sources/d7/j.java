package d7;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class j implements we.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile j f6863d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f6865c;

    public j() {
        this.f6864b = j.class.getSimpleName();
        this.f6865c = new ConcurrentHashMap();
    }

    public static j b() {
        if (f6863d != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6863d != null) goto L9;
        f6863d = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f6863d;
    }

    public final void a(String r8, l r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap r11 = this.f6865c;
        if (r11.containsKey(r8) == false) goto L7;
        ((CopyOnWriteArrayList) r11.get(r8)).add(r10);
        return;
    L7:
        CopyOnWriteArrayList r12 = new CopyOnWriteArrayList();
        r12.add(r10);
        r11.put(r8, r12);
    }

    public final void c(String r8, l r10) {
        if (TextUtils.isEmpty(r8) == true) goto L10;
        ConcurrentHashMap r11 = this.f6865c;
        if (r11.containsKey(r8) == false) goto L11;
        ((CopyOnWriteArrayList) r11.get(r8)).remove(r10);
        if (((CopyOnWriteArrayList) r11.get(r8)).isEmpty() == false) goto L12;
        r11.remove(r8);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // we.n
    public final List<InetAddress> lookup(String r8) {
        String r10 = defpackage.b.c("lookup address list for ", r8);
        Logger.d(this.f6864b, r10);
        e7.b r11 = e7.e.g().e(r8);
        if (r11 == null) goto L28;
        if (r11.f7146a.isEmpty() == true) goto L7;
    L8:
        ArrayList r12 = new ArrayList();
        Iterator<String> r13 = r11.f7147b.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        r12.add(InetAddress.getByName(r13.next()));
        goto L10
    L12:
        Iterator<String> r14 = r11.f7146a.iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        r12.add(InetAddress.getByName(r14.next()));
        goto L14
    L16:
        ConcurrentHashMap r15 = this.f6865c;
        if (r15.containsKey(r8) == false) goto L26;
        Iterator r16 = ((CopyOnWriteArrayList) r15.get(r8)).iterator();
    L20:
        if (r16.hasNext() == false) goto L26;
        l r17 = (l) r16.next();
        if (r17.T.isEmpty() == false) goto L20;
        if (r17.S != e7.b.a.f7149a) goto L20;
        r17.S = r11.f7148m;
        CopyOnWriteArrayList<String> r18 = r17.T;
        r18.addAll(r11.f7147b);
        r18.addAll(r11.f7146a);
    L26:
        return r12;
    L7:
        if (r11.f7147b.isEmpty() == false) goto L8;
    L28:
        return we.n.f13232a.lookup(r8);
    }
}
