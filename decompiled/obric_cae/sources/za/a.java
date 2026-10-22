package za;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import defpackage.c;
import gb.b;
import ge.q;
import hb.d;
import he.i;
import he.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xd.e;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f14318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f14319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f14320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<bb.a<?>> f14321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q<? super String, Object, Object, j> f14322e;

    /* JADX INFO: renamed from: za.a$a, reason: collision with other inner class name */
    public static final class C0206a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f14323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f14324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f14325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public q<? super String, Object, Object, j> f14326d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f14327e;

        public C0206a(View r8) {
            i.f(r8, "view");
            this.f14327e = r8;
            this.f14323a = 1.0f;
            this.f14324b = 60.0f;
            this.f14325c = new ArrayList();
        }

        public static void b(C0206a r8, hb.a r10, Float r11, float r12, b r13) {
            String r14 = r10.f8018a;
            if (r11 == null) goto L19;
            float r15 = r11.floatValue();
        L15:
            bb.a.C0034a r16 = new bb.a.C0034a(r10.f8018a, Float.valueOf(r15), Float.valueOf(r12), p.a(Float.TYPE), r13, null);
            r8.f14325c.add(r16);
            return;
        L19:
            Object r17 = c.M(r8.f14327e, r14);     // Catch: Throwable -> L10
            if (r17 == null) goto L9;
            Object r18 = Float.valueOf(((Float) r17).floatValue());     // Catch: Throwable -> L10
        L12:
            Throwable r19 = e.a(r18);
            if (r19 != null) goto L18;
            r15 = ((Number) r18).floatValue();
            goto L15
        L18:
            throw new IllegalArgumentException(defpackage.b.d("获取属性 ", r14, " 的初始值时出错，请检查"), r19);
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            r18 = c.D(th);
            goto L12
        }

        public final a a() {
            ArrayList r8 = this.f14325c;
            if (r8 != null) goto L5;
        L8:
            boolean r10 = true;
        L9:
            if (r10 == false) goto L11;
            int r11 = d.f8025a;
            throw new IllegalArgumentException("必须先调用方法ofXXX方法指定添加动画");
        L11:
            return new a(this.f14327e, this.f14323a, this.f14324b, r8, this.f14326d);
        L5:
            if (r8.isEmpty() == true) goto L8;
            r10 = false;
            goto L9
        }
    }

    public a(View r8, float r10, float r11, ArrayList r12, q r13) {
        this.f14318a = r8;
        this.f14319b = r10;
        this.f14320c = r11;
        this.f14321d = r12;
        this.f14322e = r13;
    }

    public static db.d a(a r13) {
        cb.b r8 = cb.b.f3430a;
        cb.a r10 = cb.a.f3428a;
        mb.a.a("PropertyAnimatable", "执行start ");
        float r11 = r13.f14320c;
        View r12 = r13.f14318a;
        float r14 = r13.f14319b;
        List<bb.a<?>> r15 = r13.f14321d;
        if (r15 == null) goto L27;
        q<? super String, Object, Object, j> r16 = r13.f14322e;
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r15.iterator();
    L6:
        if (r18.hasNext() == false) goto L8;
        r17.add(((bb.a) r18.next()).a());
        goto L6
    L8:
        if (r12 == null) goto L21;
        ya.a<?> r19 = ya.b.f14105b.get(r12);
        if (r19 == null) goto L12;
        float r20 = r19.f14103k;
    L13:
        Iterator r21 = r17.iterator();
    L15:
        if (r21.hasNext() == false) goto L21;
        ya.a<?> r22 = (ya.a) r21.next();
        if (r22.f14101i != null) goto L19;
        mb.a.a("AnimatableSubmitter", "没指定初始速度，重设velocity " + r20);
        r22.f14101i = Float.valueOf(r20);
    L20:
        ya.b.f14105b.put(r12, r22);
        goto L15
    L19:
        mb.a.a("AnimatableSubmitter", "指定了初始速度，" + r22.f14101i);
        goto L20
    L12:
        r20 = 0.0f;
    L21:
        db.d r110 = new db.d();
        ArrayList<db.d> r23 = ya.b.f14104a;
        r23.add(r110);
        mb.a.e("addAnimationManager, size: " + r23.size());
        eb.a r24 = new eb.a(r110);
        Looper r25 = Looper.getMainLooper();
        i.e(r25, "Looper.getMainLooper()");
        if ((!i.a(r25.getThread(), Thread.currentThread())) == false) goto L24;
        new Handler(Looper.getMainLooper()).post(new db.c(r110, r11, r12, r8, r14, r10, r17, r16, r24));
    L25:
        return r110;
    L24:
        r110.b(r12, r8, r14, r10, r17, r16, r24);
        goto L25
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
    }
}
