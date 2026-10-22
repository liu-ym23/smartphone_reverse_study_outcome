package com.bytedance.android.livesdk.interactivity.publicscreen.ui.animator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.d7;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ec2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class OptScrollItemAnimator extends BaseScrollItemAnimator {
    public static TimeInterpolator k;
    public final ArrayList<a> d;
    public final ArrayList<b> e;
    public final ArrayList<RecyclerView.ViewHolder> f;
    public final ArrayList<RecyclerView.ViewHolder> g;
    public final boolean h;
    public final int i;
    public final boolean j;

    public static class a {
        public final RecyclerView.ViewHolder a;
        public final int b;

        public a(RecyclerView.ViewHolder r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class b {
        public final RecyclerView.ViewHolder a;
        public final int b;
        public final int c;
        public final int d;

        public b(RecyclerView.ViewHolder r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public final void endAnimations() {
        int r0 = this.e.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        b r2 = (b) ListProtector.get(this.e, r0);
        View r3 = r2.a.itemView;
        r3.setTranslationY(0.0f);
        r3.setTranslationX(0.0f);
        dispatchMoveFinished(r2.a);
        ListProtector.remove(this.e, r0);
        goto L3
    L6:
        int r1 = this.d.size();
    L7:
        r1 = r1 - 1;
        if (r1 < 0) goto L11;
        RecyclerView.ViewHolder r4 = ((a) ListProtector.get(this.d, r1)).a;
        r4.itemView.setTranslationY(0.0f);
        dispatchAddFinished(r4);
        ListProtector.remove(this.d, r1);
        goto L7
    L11:
        if (isRunning() == true) goto L13;
        return;
    L13:
        ArrayList<RecyclerView.ViewHolder> r5 = this.g;
        int r6 = r5.size();
    L14:
        r6 = r6 - 1;
        if (r6 < 0) goto L17;
        ((RecyclerView.ViewHolder) ListProtector.get(r5, r6)).itemView.animate().cancel();
        goto L14
    L17:
        ArrayList<RecyclerView.ViewHolder> r7 = this.f;
        int r8 = r7.size();
    L18:
        r8 = r8 - 1;
        if (r8 < 0) goto L21;
        ((RecyclerView.ViewHolder) ListProtector.get(r7, r8)).itemView.animate().cancel();
        goto L18
    L21:
        dispatchAnimationsFinished();
    }

    public final boolean isRunning() {
        if (this.d.isEmpty() == true) goto L5;
    L12:
        return true;
    L5:
        if (this.e.isEmpty() == false) goto L12;
        if (this.g.isEmpty() == false) goto L12;
        if (this.f.isEmpty() == false) goto L12;
        return false;
    }

    public final void runPendingAnimations() {
        boolean r0 = !this.e.isEmpty();
        boolean r2 = !this.d.isEmpty();
        if (r0 == true) goto L6;
        if (r2 == true) goto L6;
        return;
    L6:
        int r6 = 0;
        if (r0 == false) goto L19;
        Iterator<b> r1 = this.e.iterator();
    L10:
        if (r1.hasNext() == false) goto L18;
        b r7 = r1.next();
        RecyclerView.ViewHolder r11 = r7.a;
        int r8 = r7.b;
        int r9 = r7.c;
        View r10 = r11.itemView;
        int r13 = r9 - r8;
        long r14 = Math.min((long) (Math.abs(r13) * this.a), this.c);
        this.g.add(r11);
        ViewPropertyAnimator r15 = r10.animate();
        if (r13 == 0) goto L15;
        r15.translationY(0.0f);
    L15:
        if (this.i != 2) goto L17;
        r15.withLayer();
    L17:
        r15.setDuration(Math.max(0, r14)).setListener(new ta2.b(this, r10, r11, r13, r15)).start();
        goto L10
    L18:
        ArrayList<b> r3 = this.e;
        r6 = 0 + ((b) ListProtector.get(r3, r3.size() - 1)).d;
        this.e.clear();
    L19:
        if (r2 == false) goto L43;
        Iterator<a> r4 = this.d.iterator();
    L22:
        if (r4.hasNext() == false) goto L24;
        r6 = r6 + (r4.next().b + this.b);
        goto L22
    L24:
        Iterator<a> r5 = this.d.iterator();
    L26:
        if (r5.hasNext() == false) goto L34;
        RecyclerView.ViewHolder r16 = r5.next().a;
        View r17 = r16.itemView;
        if (r6 == 0) goto L30;
        r17.setTranslationY(r6);
        r17.animate().translationY(0.0f);
        r17.animate().alpha(1.0f);
    L30:
        ViewPropertyAnimator r18 = r17.animate();
        this.f.add(r16);
        long r19 = Math.min((long) (Math.abs(r6) * this.a), this.c);
        if (this.i != 1) goto L33;
        r18.withLayer();
    L33:
        r18.setDuration(Math.max(0, r19)).setListener(new ta2.a(this, r17, r16, r6, r18)).start();
        goto L26
    L34:
        this.d.clear();
        return;
    }

    public OptScrollItemAnimator() {
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = ((fc2.b) q0.a.getValue()).publicScreenAnimHWStyle;
        this.j = ((Boolean) d7.a.getValue()).booleanValue();
    }

    public final boolean animateAdd(RecyclerView.ViewHolder r4) {
        View r0 = r4.itemView;
        int r1 = r0.getHeight();
        r0.setAlpha(0.0f);
        resetAnimation(r4);
        this.d.add(new a(r4, r1));
        return true;
    }

    public final boolean animateRemove(RecyclerView.ViewHolder r1) {
        dispatchRemoveFinished(r1);
        return true;
    }

    public final void endAnimation(RecyclerView.ViewHolder r7) {
        View r0 = r7.itemView;
        r0.animate().cancel();
        boolean r2 = true;
        int r1 = this.e.size() - 1;
    L3:
        if (r1 < 0) goto L8;
        if (((b) ListProtector.get(this.e, r1)).a != r7) goto L7;
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        dispatchMoveFinished(r7);
        ListProtector.remove(this.e, r1);
    L7:
        r1 = r1 - 1;
        goto L3
    L8:
        int r3 = this.d.size();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        if (r7 == ((a) ListProtector.get(this.d, r4)).a) goto L12;
        r4 = r4 + 1;
        goto L9
    L12:
        ListProtector.remove(this.d, r4);
    L15:
        if (r2 == false) goto L18;
        r0.setAlpha(1.0f);
        dispatchAddFinished(r7);
    L18:
        if (isRunning() == true) goto L26;
        dispatchAnimationsFinished();
        return;
    L26:
        return;
    L14:
        r2 = false;
        goto L15
    }

    public final void resetAnimation(RecyclerView.ViewHolder r3) {
        if (k != null) goto L5;
        k = new ValueAnimator().getInterpolator();
    L5:
        r3.itemView.animate().setInterpolator(k);
        endAnimation(r3);
    }

    public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder r2, List<Object> r3) {
        if (r3.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super/*androidx.recyclerview.widget.RecyclerView.ItemAnimator*/.canReuseUpdatedViewHolder(r2, r3) == true) goto L8;
        return false;
    }

    public final boolean animateMove(RecyclerView.ViewHolder r3, int r4, int r5, int r6, int r7) {
        View r8 = r3.itemView;
        if (this.h == true) goto L5;
    L7:
        int r9 = 0;
    L8:
        int r10 = r5 + ((int) r3.itemView.getTranslationY());
        resetAnimation(r3);
        int r1 = r7 - r10;
        if (r1 != 0) goto L12;
        dispatchMoveFinished(r3);
        return false;
    L12:
        r8.setTranslationY(-r1);
        this.e.add(new b(r3, r10, r7, r9));
        return true;
    L5:
        if (((int) r8.getTranslationY()) <= 0) goto L7;
        r9 = (int) r3.itemView.getTranslationY();
        goto L8
    }

    public final boolean animateChange(RecyclerView.ViewHolder r7, RecyclerView.ViewHolder r8, int r9, int r10, int r11, int r13) {
        if (this.j == false) goto L8;
        if (r7 == r8) goto L7;
        dispatchChangeFinished(r7, true);
    L7:
        return animateMove(r8, r9, r10, r11, r13);
    L8:
        dispatchChangeFinished(r7, true);
        if (r7 == r8) goto L11;
        dispatchChangeFinished(r8, false);
    L11:
        return true;
    }
}
