package x70;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layout.ViewState;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements b {
    public final HashMap<Integer, HashSet<d>> a;
    public final Map<Class<? extends View>, ViewGroup> b;
    public final c c;
    public final C0295a d;
    public final int e;
    public final Context f;

    /* JADX INFO: renamed from: x70.a$a, reason: collision with other inner class name */
    public static final class C0295a implements c.e {
        public final /* synthetic */ a a;

        public C0295a(a r1) {
            this.a = r1;
        }

        @Override // x70.c.e
        public final void a(View r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            LocalTestManager.a(new Class[]{wy.a.class});
            d r0 = new d(r4, ViewState.CREATED);
            HashSet<d> r6 = this.a.a.get(Integer.valueOf(r5));
            if (r6 == null) goto L5;
            r6.add(r0);
            return;
        L5:
            HashSet<d> r7 = new HashSet();
            this.a.a.put(Integer.valueOf(r5), r7);
            r7.add(r0);
        }
    }

    public final void g() {
        this.a.clear();
        ((LinkedHashMap) this.b).clear();
    }

    @Override // x70.b
    public final int f() {
        return this.e;
    }

    public final Context getContext() {
        return this.f;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.f = r2;
        this.a = new HashMap();
        this.b = new LinkedHashMap();
        this.c = new c(r2);
        this.d = new C0295a(this);
        this.e = 1;
    }

    @Override // x70.b
    public final boolean a(int r6) {
        HashSet<d> r7 = this.a.get(Integer.valueOf(r6));
        if (r7 != null) goto L5;
        return false;
    L5:
        Iterator<T> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        Object r1 = r8.next();
        if (((d) r1).b != ViewState.CREATED) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
    L15:
        if (r1 == null) goto L23;
        return true;
    L23:
        return false;
    L11:
        r3 = false;
        goto L12
    L14:
        r1 = null;
        goto L15
    }

    @Override // x70.b
    public final int c(int r2) {
        HashSet<d> r3 = this.a.get(Integer.valueOf(r2));
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.size();
    }

    @Override // x70.b
    public final View e(int r8) {
        HashSet<d> r9 = this.a.get(Integer.valueOf(r8));
        if (r9 != null) goto L5;
        return null;
    L5:
        Iterator<T> r1 = r9.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        if (((d) r2).b != ViewState.CREATED) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L7;
    L15:
        d r3 = (d) r2;
        if (r3 == null) goto L18;
        r9.remove(r3);
        ViewState r11 = ViewState.USING;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r3.b = r11;
    L18:
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r3 != null) goto L21;
        return null;
    L21:
        return r3.a;
    L11:
        r5 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    @Override // x70.b
    public final void d(int r5, Class<? extends View> r6) {
        if (r6 != null) goto L5;
        ViewGroup r7 = null;
    L10:
        this.c.a(r5, r7, this.d);
        return;
    L5:
        if (this.b.containsKey(r6) == false) goto L7;
        r7 = (ViewGroup) ((LinkedHashMap) this.b).get(r6);
        goto L10
    L7:
        View r0 = r6.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f});
        Map<Class<? extends View>, ViewGroup> r1 = this.b;
        if (r0 == null) goto L13;
        ViewGroup r2 = (ViewGroup) r0;
        r1.put(r6, r2);
        r7 = r2;
        goto L10
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // x70.b
    public final View b(int r2, ViewGroup r3, boolean r4) {
        if (a(r2) == false) goto L11;
        View r0 = e(r2);
        if (r4 == false) goto L8;
        if (r3 == null) goto L8;
        r3.addView(r0);
    L8:
        if (r0 == null) goto L13;
        return r0;
    L13:
        return LayoutInflater.from(this.f).inflate(r2, r3, r4);
    L11:
        return LayoutInflater.from(this.f).inflate(r2, r3, r4);
    }
}
