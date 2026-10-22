package e7a;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.ui.list.ListViewHolder;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements e7a.d {
    public final EventEmitter a;
    public final Handler b;
    public final a c;
    public final RecyclerView d;
    public C0086c e;
    public d f;
    public e g;
    public final HashSet<b> h;
    public final Rect i;
    public final int[] j;
    public final Rect k;
    public long l;

    public static class a implements Runnable {
        public final WeakReference<c> a;

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a.get();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.e(true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(c r2) {
            this.a = new WeakReference(r2);
        }
    }

    public class b {
        public final int a;
        public final int b;
        public final String c;

        public final int hashCode() {
            return this.a << (this.b + 16);
        }

        public final boolean equals(Object r5) {
            if (r5 != null) goto L6;
            return false;
        L6:
            if (this != r5) goto L9;
            return true;
        L9:
            if ((r5 instanceof b) == false) goto L18;
            b r6 = (b) r5;
            if (r6.a == this.a) goto L13;
            return false;
        L13:
            if (r6.b == this.b) goto L15;
            return false;
        L15:
            if (TextUtils.equals(r6.c, this.c) == false) goto L21;
            return true;
        L21:
            return false;
        L18:
            return false;
        }

        public b(int r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: e7a.c$c, reason: collision with other inner class name */
    public static class C0086c extends RecyclerView.OnScrollListener {
        public final WeakReference<c> a;

        public C0086c(c r2) {
            this.a = new WeakReference(r2);
        }

        public final void onScrollStateChanged(RecyclerView r1, int r2) {
            c r3 = this.a.get();
            if (r3 == null) goto L7;
            if (r2 != 0) goto L8;
            r3.e(true);
            return;
        L8:
            return;
        }

        public final void onScrolled(RecyclerView r1, int r2, int r3) {
            c r4 = this.a.get();
            if (r4 == null) goto L6;
            r4.e(false);
            return;
        }
    }

    public static class d implements ViewTreeObserver.OnDrawListener {
        public final WeakReference<c> a;

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            c r0 = this.a.get();
            if (r0 == null) goto L6;
            r0.e(false);
            return;
        }

        public d(c r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static class e implements ViewTreeObserver.OnScrollChangedListener {
        public final WeakReference<c> a;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            c r0 = this.a.get();
            if (r0 == null) goto L6;
            r0.e(false);
            return;
        }

        public e(c r2) {
            this.a = new WeakReference(r2);
        }
    }

    @Override // e7a.d
    public final void a(ListViewHolder r1) {
    }

    @Override // e7a.d
    public final void b() {
        e(false);
    }

    @Override // e7a.d
    public final void c(ListViewHolder r1) {
    }

    @Override // e7a.d
    public final void d(ListViewHolder r1) {
    }

    @Override // e7a.d
    public final void dispose() {
        this.b.removeCallbacks(this.c);
        RecyclerView r0 = this.d;
        if (r0 == null) goto L15;
        C0086c r1 = this.e;
        if (r1 == null) goto L7;
        r0.removeOnScrollListener(r1);
        this.e = null;
    L7:
        ViewTreeObserver r2 = this.d.getViewTreeObserver();
        if (r2 == null) goto L15;
        d r3 = this.f;
        if (r3 == null) goto L12;
        r2.removeOnDrawListener(r3);
        this.f = null;
    L12:
        e r4 = this.g;
        if (r4 == null) goto L15;
        r2.removeOnScrollChangedListener(r4);
        this.g = null;
    L15:
        this.h.clear();
    }

    public final void e(boolean r13) {
        long r0 = System.currentTimeMillis();
        if (r13 == false) goto L5;
    L7:
        this.l = r0;
        this.b.removeCallbacks(this.c);
        System.nanoTime();
        HashSet r1 = new HashSet();
        ArrayList r2 = new ArrayList();
        int r5 = 0;
    L9:
        if (r5 >= this.d.getChildCount()) goto L23;
        View r6 = this.d.getChildAt(r5);
        ListViewHolder r9 = (ListViewHolder) this.d.getChildViewHolder(r6);
        UIComponent r10 = r9.a.b;
        if (r10 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == false) goto L22;
        this.k.set(0, 0, r6.getWidth(), r6.getHeight());
        r6.getLocationOnScreen(this.j);
        Rect r8 = this.k;
        int[] r11 = this.j;
        r8.offset(r11[0], r11[1]);
        if (this.k.intersect(this.i) == false) goto L22;
        b r12 = new b(r9.a.b.getSign(), r9.getLayoutPosition(), r9.a.b.b);
        r1.add(r12);
        if (this.h.contains(r12) == true) goto L22;
        r2.add(r12);
    L22:
        r5 = r5 + 1;
        goto L9
    L13:
        if (r10.getEvents() == null) goto L15;
        r7 = r10.getEvents().containsKey("nodeappear") | r10.getEvents().containsKey("nodedisappear");
        goto L16
    L23:
        this.h.removeAll(r1);
        Iterator<b> r4 = this.h.iterator();
    L25:
        if (r4.hasNext() == false) goto L27;
        f("nodedisappear", r4.next());
        goto L25
    L27:
        this.h.clear();
        this.h.addAll(r1);
        Iterator r3 = r2.iterator();
    L29:
        if (r3.hasNext() == false) goto L31;
        f("nodeappear", (b) r3.next());
        goto L29
    L31:
        int r14 = UIList.L0;
        if (r13 == true) goto L42;
        this.b.postDelayed(this.c, 200);
        return;
    L42:
        return;
    L5:
        if ((r0 - this.l) >= 200) goto L7;
    }

    public c(EventEmitter r5, RecyclerView r6) {
        this.h = new HashSet();
        Rect r0 = new Rect();
        this.i = r0;
        this.j = new int[2];
        this.k = new Rect();
        this.l = 0;
        DisplayMetrics r1 = DisplayMetricsHolder.getRealScreenDisplayMetrics(r6.getContext());
        r0.set(0, 0, r1.widthPixels, r1.heightPixels);
        this.a = r5;
        this.b = new Handler(Looper.getMainLooper());
        this.c = new a(this);
        this.d = r6;
        C0086c r7 = new C0086c(this);
        this.e = r7;
        r6.addOnScrollListener(r7);
        ViewTreeObserver r8 = r6.getViewTreeObserver();
        this.f = new d(this);
        this.g = new e(this);
        r8.addOnDrawListener(this.f);
        r8.addOnScrollChangedListener(this.g);
    }

    public final void f(String r3, b r4) {
        int r0 = UIList.L0;
        m7a.d r1 = new m7a.d(r4.a, r3);
        r1.a("position", Integer.valueOf(r4.b));
        r1.a("key", r4.c);
        this.a.sendCustomEvent(r1);
    }
}
