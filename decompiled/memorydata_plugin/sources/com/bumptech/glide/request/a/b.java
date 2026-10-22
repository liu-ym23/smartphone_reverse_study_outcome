package com.bumptech.glide.request.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.util.j;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends View, Z> implements e<Z> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f957b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f958a;
    private final a c;
    private View.OnAttachStateChangeListener d;
    private boolean e;
    private boolean f;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Integer f959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f960b;
        private final View c;
        private final List<d> d;
        private ViewTreeObserverOnPreDrawListenerC0072a e;

        /* JADX INFO: renamed from: com.bumptech.glide.request.a.b$a$a, reason: collision with other inner class name */
        private static final class ViewTreeObserverOnPreDrawListenerC0072a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f961a;

            ViewTreeObserverOnPreDrawListenerC0072a(a r2) {
                this.f961a = new WeakReference(r2);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2) == false) goto L5;
                Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
            L5:
                a r3 = (a) ZeusTransformUtils.preCheckCast(this.f961a.get(), a.class, "com.obric.memorydata.plugin");
                if (r3 == null) goto L10;
                r3.a();
                return true;
            L10:
                return true;
            }
        }

        a(View r2) {
            this.d = new ArrayList();
            this.c = r2;
        }

        private int a(int r3, int r4, int r5) {
            int r0 = r4 - r5;
            if (r0 <= 0) goto L6;
            return r0;
        L6:
            if (this.f960b == true) goto L8;
        L10:
            int r6 = r3 - r5;
            if (r6 <= 0) goto L14;
            return r6;
        L14:
            if (this.c.isLayoutRequested() == false) goto L16;
        L22:
            return 0;
        L16:
            if (r4 != (-2)) goto L22;
            if (Log.isLoggable("CustomViewTarget", 4) == false) goto L21;
            Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        L21:
            return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        L8:
            if (this.c.isLayoutRequested() == false) goto L10;
            return 0;
        }

        private static int a(Context r2) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if (f959a != null) goto L6;
            Display r4 = ((WindowManager) ZeusTransformUtils.preCheckCast(j.a((WindowManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")), WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay();
            Point r0 = new Point();
            r4.getSize(r0);
            f959a = Integer.valueOf(Math.max(r0.x, r0.y));
        L6:
            return f959a.intValue();
        }

        private void a(int r4, int r5) {
            Iterator r3 = new ArrayList(this.d).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.memorydata.plugin")).a(r4, r5);
            goto L4
        }

        private boolean a(int r1) {
            if (r1 <= 0) goto L4;
        L7:
            return true;
        L4:
            if (r1 == Integer.MIN_VALUE) goto L7;
            return false;
        }

        private boolean b(int r1, int r2) {
            if (a(r1) == true) goto L5;
        L7:
            return false;
        L5:
            if (a(r2) == false) goto L7;
            return true;
        }

        private int c() {
            int r0 = this.c.getPaddingTop() + this.c.getPaddingBottom();
            ViewGroup.LayoutParams r1 = this.c.getLayoutParams();
            if (r1 == null) goto L5;
            int r2 = r1.height;
        L7:
            return a(this.c.getHeight(), r2, r0);
        L5:
            r2 = 0;
            goto L7
        }

        private int d() {
            int r0 = this.c.getPaddingLeft() + this.c.getPaddingRight();
            ViewGroup.LayoutParams r1 = this.c.getLayoutParams();
            if (r1 == null) goto L5;
            int r2 = r1.width;
        L7:
            return a(this.c.getWidth(), r2, r0);
        L5:
            r2 = 0;
            goto L7
        }

        void a() {
            if (this.d.isEmpty() == false) goto L5;
            return;
        L5:
            int r0 = d();
            int r1 = c();
            if (b(r0, r1) == true) goto L8;
            return;
        L8:
            a(r0, r1);
            b();
        }

        void a(d r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
            int r0 = d();
            int r1 = c();
            if (b(r0, r1) == false) goto L7;
            r5.a(r0, r1);
            return;
        L7:
            if (this.d.contains(r5) == true) goto L10;
            this.d.add(r5);
        L10:
            if (this.e != null) goto L13;
            ViewTreeObserver r6 = this.c.getViewTreeObserver();
            ViewTreeObserverOnPreDrawListenerC0072a r2 = new ViewTreeObserverOnPreDrawListenerC0072a(this);
            this.e = r2;
            r6.addOnPreDrawListener(r2);
            return;
        }

        void b() {
            ViewTreeObserver r0 = this.c.getViewTreeObserver();
            if (r0.isAlive() == false) goto L5;
            r0.removeOnPreDrawListener(this.e);
        L5:
            this.e = null;
            this.d.clear();
        }

        void b(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            this.d.remove(r4);
        }
    }

    static {
        f957b = ZeusTransformUtils.mapRes(R.id.glide_custom_view_target_tag, OaidModel.KEY_ID, "glide_custom_view_target_tag");
    }

    public b(T r4) {
        this.f958a = (T) ZeusTransformUtils.preCheckCast(j.a(r4), View.class, "com.obric.memorydata.plugin");
        this.c = new a(r4);
    }

    private Object a() {
        return this.f958a.getTag(f957b);
    }

    private void a(Object r2) {
        this.f958a.setTag(f957b, r2);
    }

    private void c() {
        View.OnAttachStateChangeListener r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f == true) goto L10;
        this.f958a.addOnAttachStateChangeListener(r0);
        this.f = true;
        return;
    }

    private void d() {
        View.OnAttachStateChangeListener r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f == false) goto L10;
        this.f958a.removeOnAttachStateChangeListener(r0);
        this.f = false;
        return;
    }

    public abstract void a(Drawable r1);

    @Override // com.bumptech.glide.request.a.e
    public final void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.c.a(r4);
    }

    @Override // com.bumptech.glide.request.a.e
    public final void a(com.bumptech.glide.request.d r3) {
        a((com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.request.a.e
    public final void a_(Drawable r2) {
        this.c.b();
        a(r2);
        if (this.e == true) goto L6;
        d();
        return;
    }

    @Override // com.bumptech.glide.request.a.e
    public final com.bumptech.glide.request.d b() {
        Object r2 = a();
        if (r2 != null) goto L5;
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, com.bumptech.glide.request.d.class) == false) goto L9;
        return (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r2, com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");
    L9:
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.request.a.e
    public final void b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.c.b(r4);
    }

    @Override // com.bumptech.glide.request.a.e
    public final void c(Drawable r1) {
        c();
        d(r1);
    }

    public void d(Drawable r1) {
    }

    @Override // com.bumptech.glide.manager.k
    public void e() {
    }

    @Override // com.bumptech.glide.manager.k
    public void f() {
    }

    @Override // com.bumptech.glide.manager.k
    public void g() {
    }

    public String toString() {
        return "Target for: " + this.f958a;
    }
}
