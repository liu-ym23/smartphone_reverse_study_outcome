package com.ss.android.lark.chat.base.view.recycleview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import g2b.d;
import g2b.e;
import g2b.f;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zdc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T extends c> implements g2b.a {
    public final RecyclerView a;
    public g2b.c b;
    public final InterfaceC0030b c;
    public int d;
    public ValueAnimator e;

    public class a implements Runnable {
        public Object a;
        public final /* synthetic */ b b;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.base.view.recycleview.b$a$a, reason: collision with other inner class name */
        public class C0029a extends AnimatorListenerAdapter {
            public final /* synthetic */ View a;
            public final /* synthetic */ Drawable b;
            public final /* synthetic */ int c;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r4) {
                View r5 = this.a;
                Drawable r0 = this.b;
                r5.post(new f(this.c, r5, r0));
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r4) {
                View r5 = this.a;
                Drawable r0 = this.b;
                r5.post(new f(this.c, r5, r0));
            }

            public C0029a(View r1, Drawable r2, int r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public final void a() {
            RecyclerView r0 = this.b.a;
            Intrinsics.checkNotNullParameter(r0, "<this>");
            RecyclerView.Adapter r1 = r0.getAdapter();
            if ((r1 instanceof ConcatAdapter) == false) goto L6;
            r1 = (RecyclerView.Adapter) CollectionsKt.getOrNull(((ConcatAdapter) r1).getAdapters(), 0);
        L6:
            final c r2 = (c) r1;
            if (r2 != null) goto L9;
            return;
        L9:
            final int r3 = this.b.b.b();
            if (r3 >= 0) goto L12;
            return;
        L12:
            if (r3 >= r2.getItemCount()) goto L39;
            Object r4 = r2.getItem(r3);
            if (r4 != null) goto L17;
            return;
        L17:
            this.a = r4;
            final RecyclerView.ViewHolder r5 = this.b.a.findViewHolderForAdapterPosition(r3);
            if (r5 != null) goto L20;
            return;
        L20:
            View r6 = this.b.b.a(r5.itemView);
            if (r6 != null) goto L23;
            r6 = r5.itemView;
        L23:
            Animation r7 = r6.getAnimation();
            if (r7 == null) goto L26;
            r7.cancel();
        L26:
            Drawable r8 = r6.getBackground();
            if (r8 != null) goto L29;
        L31:
            int r9 = 0;
        L32:
            int r10 = j08.b.c(r6.getContext(), 2131108860, 1.0f);
            if (r9 != 0) goto L35;
            int r11 = j08.b.c(r6.getContext(), 2131108860, 0.0f);
        L36:
            this.b.e = ObjectAnimator.ofInt(r6, "backgroundColor", new int[]{r10, r11});
            this.b.e.setDuration(3000);
            this.b.e.setInterpolator(new g2b.b());
            this.b.e.setEvaluator(new ArgbEvaluator());
            this.b.e.addListener(new C0029a(r6, r8, r9));
            this.b.e.addUpdateListener(new e(this, r5, r3, r2));
            this.b.e.start();
            return;
        L35:
            r11 = r9;
            goto L36
        L29:
            if ((r8 instanceof ColorDrawable) == false) goto L31;
            r9 = ((ColorDrawable) r8).getColor();
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

        public a(b r1) {
            this.b = r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.base.view.recycleview.b$b, reason: collision with other inner class name */
    public interface InterfaceC0030b<I> {
        boolean a(I r1, I r2);
    }

    @Override // g2b.a
    public final void a() {
        ValueAnimator r0 = this.e;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // g2b.a
    public final void b() {
        this.a.postDelayed(new a(this), this.d);
    }

    @Override // g2b.a
    public final void cancel() {
        a();
    }

    public b(RecyclerView r2, InterfaceC0030b r3) {
        this.d = 100;
        this.a = r2;
        if (r3 != null) goto L5;
        this.c = new d();
        return;
    L5:
        this.c = r3;
    }
}
