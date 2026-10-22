package q0b;

import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.WebViewPoolConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.d;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import swb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements q0b.a {
    public final Deque<a> a;
    public q0b.a.InterfaceC0279a b;
    public final WebViewPoolConfig c;

    public static class a {
        public Object a;
        public ChameleonWebView b;

        public a() {
        }
    }

    @Override // q0b.a
    public final synchronized void destroyAll() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (e.a(this.a) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        ArrayList r0 = new ArrayList(this.a);     // Catch: Throwable -> L16
        ((LinkedList) this.a).clear();     // Catch: Throwable -> L16
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L16
    L9:
        if (r1.hasNext() == false) goto L14;
        a r2 = (a) r1.next();     // Catch: Throwable -> L16
        q0b.a.InterfaceC0279a r3 = this.b;     // Catch: Throwable -> L16
        if (r3 == null) goto L9;
        r3.a(r2.b);     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(this);
    }

    @Override // q0b.a
    public final int occupiedSize() {
        Iterator<a> r0 = this.a.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().a == null) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        return r1;
    }

    @Override // q0b.a
    public final int poolSize() {
        return ((LinkedList) this.a).size();
    }

    @Override // q0b.a
    public final WebViewPoolConfig a() {
        return this.c;
    }

    public b(WebViewPoolConfig r2) {
        this.a = new LinkedList();
        this.c = r2;
    }

    @Override // q0b.a
    public final synchronized ChameleonWebView c(Object r1) {
        monitor-enter(this);
        a r2 = f(r1);     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        ChameleonWebView r3 = r2.b;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r3;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // q0b.a
    public final synchronized ChameleonWebView d(Object r7) {
        monitor-enter(this);
        a r1 = null;
        if (e.a(this.a) == false) goto L8;
        j.b("CML_TAG_WebViewPool", "call provideChameleonWebView without initializing pool!");     // Catch: Throwable -> L26
        monitor-exit(this);
        return null;
    L8:
        Iterator r0 = ((LinkedList) this.a).descendingIterator();     // Catch: Throwable -> L26
        a r2 = null;
    L10:
        if (r0.hasNext() == false) goto L18;
        a r3 = (a) r0.next();     // Catch: Throwable -> L26
        if (r3.a != null) goto L10;
        if (r3.b.getIsReady() == true) goto L15;
        if (r2 != null) goto L10;
        r2 = r3;
        goto L10
    L15:
        r1 = r3;
    L18:
        if (r1 == null) goto L21;
        r2 = r1;
    L21:
        if (r2 != null) goto L23;
        r2 = (a) ((LinkedList) this.a).getLast();     // Catch: Throwable -> L26
    L23:
        ((LinkedList) this.a).remove(r2);     // Catch: Throwable -> L26
        ((LinkedList) this.a).addFirst(r2);     // Catch: Throwable -> L26
        r2.a = r7;     // Catch: Throwable -> L26
        ChameleonWebView r8 = r2.b;     // Catch: Throwable -> L26
        monitor-exit(this);
        return r8;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // q0b.a
    public final synchronized ChameleonWebView detachWebView(Object r5) {
        monitor-enter(this);
        ChameleonWebView r0 = null;
        if (r5 != null) goto L23;
        monitor-exit(this);
        return null;
    L23:
        Iterator<a> r1 = this.a.iterator();     // Catch: Throwable -> L20
    L9:
        if (r1.hasNext() == false) goto L13;
        a r2 = r1.next();     // Catch: Throwable -> L20
        if (r5.equals(r2.a) == false) goto L9;
        r1.remove();     // Catch: Throwable -> L20
    L14:
        if (r2 == null) goto L16;
        r2.a = null;     // Catch: Throwable -> L20
        ((LinkedList) this.a).addLast(r2);     // Catch: Throwable -> L20
    L16:
        if (r2 == null) goto L18;
        r0 = r2.b;     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return r0;
    L13:
        r2 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // q0b.a
    public final synchronized void e(ChameleonWebView r3) {
        monitor-enter(this);
        if (r3 != null) goto L24;
        monitor-exit(this);
        return;
    L24:
        q0b.a.InterfaceC0279a r0 = this.b;     // Catch: Throwable -> L21
        if (r0 == null) goto L10;
        r0.a(r3);     // Catch: Throwable -> L21
    L10:
        if (e.a(this.a) == false) goto L13;
        monitor-exit(this);
        return;
    L13:
        Iterator<a> r1 = this.a.iterator();     // Catch: Throwable -> L21
    L15:
        if (r1.hasNext() == false) goto L19;
        if (r1.next().b != r3) goto L15;
        r1.remove();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final a f(Object r5) {
        a r1 = null;
        if (e.a(this.a) == true) goto L14;
        if (r5 == null) goto L14;
        Iterator<a> r0 = this.a.iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        a r2 = r0.next();
        if (r5.equals(r2.a) == false) goto L8;
        r1 = r2;
    L12:
        if (r1 == null) goto L14;
        r1.a = r5;
        ((LinkedList) this.a).remove(r1);
        ((LinkedList) this.a).addFirst(r1);
    L14:
        return r1;
    }

    @Override // q0b.a
    public final ChameleonWebView getOverMaxUsedWebView(int r5) {
        if (e.a(this.a) == false) goto L6;
        j.b("CML_TAG_WebViewPool", "getOverMaxUsedChameleonWebView without initializing pool!");
        return null;
    L6:
        Iterator r0 = ((LinkedList) this.a).descendingIterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        a r2 = (a) r0.next();
        if (r2.b.getUsedCount() <= r5) goto L8;
    L13:
        if (r2 != null) goto L16;
        return null;
    L16:
        return r2.b;
    L12:
        r2 = null;
        goto L13
    }

    @Override // q0b.a
    public final synchronized ChameleonWebView b(ChameleonConfig r5, Object r6) {
        monitor-enter(this);
        a r1 = new a();     // Catch: Throwable -> L10
        r1.b = new ChameleonWebView(d.a(), r5);     // Catch: Throwable -> L10
        r1.a = r6;     // Catch: Throwable -> L10
        ((LinkedList) this.a).addLast(r1);     // Catch: Throwable -> L10
        j.e("CML_TAG_WebViewPool", "createWebView webView=" + r1.b.hashCode() + ", ownerTag=" + r6);     // Catch: Throwable -> L10
        q0b.a.InterfaceC0279a r7 = this.b;     // Catch: Throwable -> L10
        if (r7 == null) goto L7;
        r7.b(r1.b);     // Catch: Throwable -> L10
    L7:
        ChameleonWebView r8 = r1.b;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r8;
    L10:
        th = move-exception;
        throw th;
    }
}
