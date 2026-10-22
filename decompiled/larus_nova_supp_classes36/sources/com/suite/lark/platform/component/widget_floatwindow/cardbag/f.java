package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements LayoutTransition.TransitionListener {
    public final /* synthetic */ DialogAnimationLayout a;

    public class a implements Runnable {
        public final /* synthetic */ f a;

        @Override // java.lang.Runnable
        public final void run() {
            DialogAnimationLayout r0 = this.a.a;     // Catch: Throwable -> L4
            int r1 = DialogAnimationLayout.i;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(f r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ f c;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            DialogAnimationLayout r0 = this.c.a;
            int r1 = DialogAnimationLayout.i;
            r0.c();
            DialogAnimationLayout r2 = this.c.a;
            View r3 = this.a;
            int r4 = this.b;
            r2.getClass();
            boolean r7 = false;
            ValueAnimator r8 = null;
            if (r4 != 2) goto L5;
            if (r3 == null) goto L32;
            int r5 = r3.getHeight();
            jpc.a r9 = (jpc.a) r3.getTag();
            if (r9 != null) goto L31;
            r9 = new jpc.a();
        L31:
            r9.a = r5;
            r3.setTag(r9);
            DialogAnimationLayout.a r6 = new DialogAnimationLayout.a(r2, 0);
            int r10 = (int) r2.getResources().getDimension(2131165478);
            ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r11.addListener(new com.suite.lark.platform.component.widget_floatwindow.cardbag.a(r6, r2));
            r11.addUpdateListener(new com.suite.lark.platform.component.widget_floatwindow.cardbag.b(r2, r10, r5));
            r11.setDuration(300);
            r11.start();
        L32:
            r2.g = r8;
            return;
        L5:
            if (r4 != 3) goto L32;
            int r12 = (r2.e.size() - 1) - r2.getChildCount();
            if (r12 < 0) goto L22;
            r2.setLayoutTransition(null);
            View r13 = (View) ListProtector.get(r2.e, r12);
            if (r13.getParent() != null) goto L22;
            int r14 = (r2.f * 3) * 2;
            r13.setPadding(r14, 0, r14, 0);
            if (((jpc.a) r13.getTag()) != null) goto L17;
            jpc.a r15 = new jpc.a();
            r15.c = 0;
            r15.b = r14;
            r13.setTag(r15);
        L17:
            if (r2.getChildCount() <= 1) goto L19;
            int r16 = r2.getChildAt(r2.getChildCount() - 1).getHeight();
        L20:
            FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(r2.b, r16);
            r17.gravity = r2.c;
            r2.addView(r13, 0, r17);
            goto L22
        L19:
            r16 = -2;
        L22:
            if (r2.e.size() <= 0) goto L24;
            r7 = true;
        L24:
            if (r7 == false) goto L32;
            DialogAnimationLayout.a r18 = new DialogAnimationLayout.a(r2, 1);
            int r19 = (int) r2.getResources().getDimension(2131165478);
            r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r8.addListener(new c(r18, r2));
            r8.addUpdateListener(new d(r2, r19));
            r8.setDuration(300);
            r8.start();
            goto L32
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

        public b(f r1, View r2, int r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public f(DialogAnimationLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.LayoutTransition.TransitionListener
    public final void endTransition(LayoutTransition r2, ViewGroup r3, View r4, int r5) {
        int r6 = this.a.getHeight();
        DialogAnimationLayout r7 = this.a;
        if (r6 <= r7.h) goto L6;
        r7.h = r7.getHeight();
    L6:
        if (r5 != 3) goto L8;
        this.a.post(new a(this));
    L8:
        this.a.post(new b(this, r4, r5));
    }

    @Override // android.animation.LayoutTransition.TransitionListener
    public final void startTransition(LayoutTransition r1, ViewGroup r2, View r3, int r4) {
        DialogAnimationLayout r5 = this.a;
        int r6 = DialogAnimationLayout.i;
        r5.c();
    }
}
