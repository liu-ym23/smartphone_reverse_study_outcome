package m5a;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static final h e = null;
    public WeakReference<Context> a;
    public final HashMap<Integer, q> b;
    public final List<a> c;
    public int d;

    public static class a {
        public final String a;
        public final g b;

        public a(String r1, g r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void c() {
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.c).size()) goto L21;
        q r1 = ((a) ListProtector.get(this.c, r0)).b.a;
        if (r1.f.isShowing() == false) goto L20;
        Window r2 = r1.f.getWindow();
        if (r2 == null) goto L20;
        View r3 = q.a(r2);
        if (r3 == null) goto L20;
        r3.bringToFront();
        WindowManager r4 = (WindowManager) r1.getContext().getSystemService("window");
        if (r4 == null) goto L20;
        if (r3.getWindowToken() == null) goto L20;
        r4.updateViewLayout(r3, r2.getAttributes());     // Catch: IllegalArgumentException -> L22
    L20:
        r0 = r0 + 1;
        goto L4
    }

    static {
        e = new h();
    }

    public final void b() {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L20;
        final q r1 = ((a) r0.next()).b.a;
        if (r1.a == true) goto L8;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L4;
        r1.postOnAnimation(new m(r1));
        goto L4
    L8:
        if (r1.m == true) goto L16;
        if (r1.f.isShowing() == false) goto L16;
        if (r1.p == null) goto L16;
        if (r1.r == false) goto L16;
        r2 = true;
        goto L17
    }

    public h() {
        this.b = new HashMap();
        new HashSet();
        this.c = new ArrayList();
        this.d = 0;
    }

    public final void a(a r5) {
        int r0 = ((ArrayList) this.c).size();
        int r1 = 0;
    L4:
        if (r1 >= ((ArrayList) this.c).size()) goto L9;
        if (r5.b.c > ((a) ListProtector.get(this.c, r1)).b.c) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        r0 = r1;
    L9:
        ListProtector.add(this.c, r0, r5);
    }
}
