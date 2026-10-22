package e7a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.ui.list.ListViewHolder;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements d {
    public final EventEmitter a;
    public final Handler b;
    public RunnableC0085b c;
    public LinkedList<a> d;
    public LinkedList<a> e;
    public boolean f;

    public static class a {
        public final ListViewHolder a;
        public final String b;
        public final int c;
        public String d;
        public final int e;

        public final String toString() {
            return "{type='" + this.b + "', position=" + this.c + ", key='" + this.d + "'}";
        }

        public a(ListViewHolder r1, String r2) {
            this.a = r1;
            this.b = r2;
            this.c = r1.getLayoutPosition();
            UIComponent r3 = r1.a.b;
            if (r3 == null) goto L6;
            this.d = r3.b;
            this.e = r3.getSign();
            return;
        }
    }

    /* JADX INFO: renamed from: e7a.b$b, reason: collision with other inner class name */
    public static class RunnableC0085b implements Runnable {
        public final WeakReference<b> a;

        public final void a() {
            b r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.c = null;
            int r1 = UIList.L0;
        L7:
            if (r0.d.size() <= 0) goto L45;
            a r2 = r0.d.removeFirst();
            if (r0.g(r2) == false) goto L7;
            Iterator<a> r3 = r0.d.iterator();
        L12:
            boolean r4 = true;
            boolean r5 = false;
            if (r3.hasNext() == false) goto L17;
            a r6 = r3.next();
            if (r0.e(r2, r6) == false) goto L12;
            r0.d.remove(r6);
            boolean r7 = true;
        L18:
            if (r7 == true) goto L7;
            Iterator<a> r8 = r0.e.iterator();
        L22:
            if (r8.hasNext() == false) goto L26;
            a r9 = r8.next();
            if (r0.e(r2, r9) == false) goto L22;
            r0.e.remove(r9);
        L27:
            if (r4 == true) goto L7;
            if (r0.g(r2) == false) goto L40;
            UIComponent r10 = r2.a.a.b;
            if (r10 == null) goto L38;
            if (r10.getEvents() == null) goto L38;
            r5 = r10.getEvents().containsKey(r2.b);
        L38:
            if (r0.f == false) goto L40;
            r5 = "nodedisappear".equals(r2.b);
        L40:
            if (r5 == false) goto L7;
            if (r0.g(r2) == false) goto L7;
            int r11 = UIList.L0;
            m7a.d r12 = new m7a.d(r2.e, r2.b);
            r12.a("position", Integer.valueOf(r2.c));
            r12.a("key", r2.d);
            r0.a.sendCustomEvent(r12);
            goto L7
        L26:
            r4 = r7;
            goto L27
        L17:
            r7 = false;
            goto L18
        L45:
            r0.d = r0.e;
            r0.e = new LinkedList();
            if (r0.d.size() <= 0) goto L68;
            r0.f();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0085b(b r2) {
            this.a = new WeakReference(r2);
        }
    }

    @Override // e7a.d
    public final void b() {
    }

    @Override // e7a.d
    public final void dispose() {
    }

    public final void f() {
        if (this.c == null) goto L5;
        return;
    L5:
        RunnableC0085b r0 = new RunnableC0085b(this);
        this.c = r0;
        this.b.postDelayed(r0, 50);
    }

    public b(EventEmitter r4) {
        this.f = false;
        this.a = r4;
        Handler r5 = new Handler(Looper.getMainLooper());
        this.b = r5;
        this.e = new LinkedList();
        this.d = new LinkedList();
        RunnableC0085b r0 = new RunnableC0085b(this);
        this.c = r0;
        r5.postDelayed(r0, 500);
    }

    @Override // e7a.d
    public final void a(ListViewHolder r4) {
        int r0 = UIList.L0;
        this.e.push(new a(r4, "nodedisappear"));
        f();
    }

    @Override // e7a.d
    public final void c(ListViewHolder r4) {
        int r0 = UIList.L0;
        this.e.push(new a(r4, "nodeappear"));
        f();
    }

    @Override // e7a.d
    public final void d(ListViewHolder r4) {
        Iterator<a> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        a r1 = r0.next();
        if (r1.a != r4) goto L4;
        UIComponent r2 = r4.a.b;
        if (r2 == null) goto L4;
        r1.d = r2.b;
        goto L4
    L10:
        Iterator<a> r3 = this.e.iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        a r5 = r3.next();
        if (r5.a != r4) goto L12;
        r5.d = r4.a.b.b;
        goto L12
    }

    public final boolean g(a r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.a.a.b != null) goto L12;
        if (this.f == true) goto L10;
        return false;
    L10:
        return "nodedisappear".equals(r3.b);
    L12:
        if (r3.b == null) goto L16;
        return true;
    L16:
        return false;
    }

    public final boolean e(a r4, a r5) {
        if (this.f == true) goto L5;
    L9:
        String r0 = r4.d;
        if (r0 != null) goto L19;
        if (r5.d != null) goto L19;
        if (r4.c != r5.c) goto L20;
        return true;
    L20:
        return false;
    L19:
        return TextUtils.equals(r0, r5.d);
    L5:
        if (TextUtils.isEmpty(r4.b) == true) goto L9;
        if (r4.b.equals(r5.b) == true) goto L9;
        return false;
    }
}
