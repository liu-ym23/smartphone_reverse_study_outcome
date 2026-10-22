package com.lynx.tasm.behavior.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.base.LLog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static int c = 80;
    public final RecyclerView a;
    public final a b;

    public static class a implements Runnable {
        public final WeakReference<RecyclerView> a;
        public Callback b;
        public int c;
        public String d;
        public int e;
        public int f;
        public int g;
        public ListViewHolder.b h;
        public boolean i;
        public boolean j;
        public final C0054a k;

        /* JADX INFO: renamed from: com.lynx.tasm.behavior.ui.list.b$a$a, reason: collision with other inner class name */
        public class C0054a extends RecyclerView.SimpleOnItemTouchListener {
            public final /* synthetic */ a a;

            public C0054a(a r1) {
                this.a = r1;
            }

            public final boolean onInterceptTouchEvent(RecyclerView r1, MotionEvent r2) {
                this.a.i = false;
                return false;
            }
        }

        public final void a() {
            RecyclerView r1 = this.a.get();
            if (r1 != null) goto L5;
        L159:
            b();
            return;
        L5:
            if (r1.getLayoutManager() == null) goto L159;
            if (r1.getChildCount() == 0) goto L159;
            boolean r3 = true;
            if (this.i == true) goto L13;
            this.b.invoke(new Object[]{0});
            b();
            return;
        L13:
            int r2 = Math.min(this.c, r1.getLayoutManager().getItemCount() - 1);
            this.c = r2;
            this.c = Math.max(r2, 0);
            int r4 = r1.getChildCount();
            int r6 = 0;
        L15:
            if (r6 >= r4) goto L22;
            ListViewHolder.b r8 = (ListViewHolder.b) r1.getChildAt(r6);
            if (r8.a == 3) goto L21;
            if (((ListViewHolder) r1.getChildViewHolder(r8)).a.b == null) goto L21;
            boolean r5 = false;
        L23:
            if (r5 == false) goto L155;
            RecyclerView.LayoutManager r7 = r1.getLayoutManager();
            int r9 = r1.getChildCount();
            this.f = r7.getItemCount();
            this.g = 0;
            int r10 = 0;
        L26:
            if (r10 >= r9) goto L32;
            ListViewHolder.b r11 = (ListViewHolder.b) r1.getChildAt(r10);
            int r12 = r11.getLayoutParams().getViewLayoutPosition();
            this.g = Math.max(r12, this.g);
            this.f = Math.min(r12, this.f);
            if (r12 == this.c) goto L29;
            r10 = r10 + 1;
            goto L26
        L29:
            this.h = r11;
        L32:
            if (this.h != null) goto L58;
            int r13 = this.f;
            int r14 = this.c;
            if (r13 <= r14) goto L36;
            int r15 = -1;
        L37:
            int r16 = this.g;
            int r17 = (r16 - r13) + 1;
            if (r15 != (-1)) goto L40;
            int r18 = r13 - r14;
        L42:
            if (this.j == false) goto L44;
            int r19 = r1.getHeight();
        L45:
            int r20 = (r18 * r19) / r17;
            if (r18 > 30) goto L48;
        L50:
            boolean r21 = false;
        L51:
            if (r21 == false) goto L57;
            int r22 = this.f;
            int r23 = this.c;
            if (r22 > r23) goto L56;
            r22 = this.g;
        L56:
            r1.scrollToPosition(((r22 - r23) / 2) + r23);
            goto L155
        L57:
            int r24 = Math.min(r19, b.c * r18) * r15;
        L100:
            boolean r25 = this.j;
            if (r24 == 0) goto L147;
            if (r24 <= 0) goto L105;
            byte r26 = 1;
        L106:
            RecyclerView.LayoutManager r27 = r1.getLayoutManager();
            int r110 = r1.getChildCount();
            if (r1.findViewHolderForLayoutPosition(0) == null) goto L109;
            boolean r111 = true;
        L111:
            if (r1.findViewHolderForLayoutPosition(r27.getItemCount() - 1) == null) goto L113;
            boolean r112 = true;
        L114:
            if (r111 == false) goto L116;
            if ((-1) != r26) goto L116;
        L118:
            int r113 = Integer.MAX_VALUE;
            int r114 = Integer.MIN_VALUE;
            int r115 = 0;
        L119:
            if (r115 >= r110) goto L129;
            View r28 = r1.getChildAt(r115);
            if (r25 == false) goto L123;
            int r29 = Math.min(r27.getDecoratedTop(r28), r113);
        L124:
            r113 = r29;
            if (r25 == false) goto L127;
            int r30 = Math.max(r27.getDecoratedBottom(r28), r114);
        L128:
            r114 = r30;
            r115 = r115 + 1;
            goto L119
        L127:
            r30 = Math.max(r27.getDecoratedRight(r28), r114);
            goto L128
        L123:
            r29 = Math.min(r27.getDecoratedLeft(r28), r113);
            goto L124
        L129:
            if (r25 == false) goto L131;
            int r31 = r27.getPaddingTop();
        L132:
            if (r25 == false) goto L134;
            int r32 = r27.getHeight();
            int r33 = r27.getPaddingBottom();
        L135:
            int r34 = r32 - r33;
            if (r111 == false) goto L140;
            if ((-1) != r26) goto L140;
            if (r113 < r31) goto L145;
        L144:
            boolean r35 = false;
        L146:
            if (r35 == false) goto L147;
            if (r25 == false) goto L150;
            char r36 = 0;
            r1.scrollBy(0, r24);
        L151:
            boolean r116 = true;
        L152:
            if (r116 == true) goto L154;
            Callback r37 = this.b;
            Object[] r38 = new Object[2];
            r38[r36] = 4;
            r38[1] = "can not scroll when come to border";
            r37.invoke(r38);
        L154:
            r3 = r116;
            goto L155
        L150:
            r36 = 0;
            r1.scrollBy(r24, 0);
        L145:
            r35 = true;
        L140:
            if (r112 == false) goto L145;
            if (1 != r26) goto L145;
            if (r114 <= r34) goto L144;
        L134:
            r32 = r27.getWidth();
            r33 = r27.getPaddingRight();
            goto L135
        L131:
            r31 = r27.getPaddingLeft();
        L116:
            if (r112 == false) goto L145;
            if (1 != r26) goto L145;
        L113:
            r112 = false;
            goto L114
        L109:
            r111 = false;
            goto L111
        L105:
            r26 = -1;
        L147:
            r36 = 0;
            r116 = false;
            goto L152
        L48:
            if (r20 <= (r19 * 10)) goto L50;
            r21 = true;
            goto L51
        L44:
            r19 = r1.getWidth();
            goto L45
        L40:
            r18 = r14 - r16;
            goto L42
        L36:
            r15 = 1;
            goto L37
        L58:
            RecyclerView.LayoutManager r39 = r1.getLayoutManager();
            if (this.j == false) goto L61;
            int r40 = r39.getDecoratedTop(this.h);
        L63:
            if (this.j == false) goto L65;
            int r117 = r39.getDecoratedMeasuredHeight(this.h);
        L67:
            if (this.j == false) goto L69;
            int r118 = r39.getHeight();
        L71:
            if (this.j == false) goto L73;
            int r119 = r39.getPaddingTop();
        L75:
            if (this.j == false) goto L77;
            int r41 = r39.getPaddingBottom();
        L78:
            int r120 = (r118 - r119) - r41;
            if (TextUtils.equals(this.d, "middle") == false) goto L82;
            int r42 = (this.e + r119) + ((r120 - r117) / 2);
        L85:
            int r43 = r40 - r42;
            if (r43 != 0) goto L88;
            this.b.invoke(new Object[]{0});
        L99:
            r3 = false;
            goto L155
        L88:
            r24 = Math.min(Math.max(Math.abs(r43) / 3, 1), b.c);
            if (r43 > 0) goto L93;
            r24 = -r24;
        L93:
            if (this.j == false) goto L95;
            int r44 = this.h.getHeight();
        L96:
            if (r44 != 0) goto L100;
            if (r24 != 1) goto L100;
            this.b.invoke(new Object[]{0});
            goto L99
        L95:
            r44 = this.h.getWidth();
            goto L96
        L82:
            if (TextUtils.equals(this.d, "bottom") == false) goto L84;
            r42 = ((this.e + r119) + r120) - r117;
            goto L85
        L84:
            r42 = this.e + r119;
            goto L85
        L77:
            r41 = r39.getPaddingRight();
            goto L78
        L73:
            r119 = r39.getPaddingLeft();
            goto L75
        L69:
            r118 = r39.getWidth();
            goto L71
        L65:
            r117 = r39.getDecoratedMeasuredWidth(this.h);
            goto L67
        L61:
            r40 = r39.getDecoratedLeft(this.h);
        L155:
            if (r3 == false) goto L157;
            r1.post(this);
            return;
        L157:
            b();
            return;
        L21:
            r6 = r6 + 1;
            goto L15
        L22:
            r5 = true;
            goto L23
        }

        public final void b() {
            LLog.i("UIList", "ListScroller stop");
            RecyclerView r0 = this.a.get();
            this.i = false;
            if (r0 == null) goto L6;
            r0.removeOnItemTouchListener(this.k);
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

        public a(RecyclerView r2) {
            this.j = true;
            this.k = new C0054a(this);
            this.a = new WeakReference(r2);
            this.b = null;
            this.h = null;
            this.i = false;
        }
    }

    public b(Context r2, RecyclerView r3) {
        Resources r4 = r2.getResources();
        c = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).densityDpi / 4;
        this.a = r3;
        this.b = new a(this.a);
    }

    public final void a(int r5, int r6, Callback r7) {
        LLog.i("UIList", "ListScroller scrollToPositionNoSmooth: position=" + r5 + ", offset=" + r6);
        a r0 = this.b;
        if (r0 != null) goto L5;
    L10:
        RecyclerView r1 = this.a;
        if (r1 == null) goto L13;
        r1.stopScroll();
        this.a.stopNestedScroll();
    L13:
        LinearLayoutManager r2 = this.a.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == false) goto L17;
        r2.scrollToPositionWithOffset(r5, r6);
    L19:
        if (r7 == null) goto L23;
        r7.invoke(new Object[]{0});
        return;
    L23:
        return;
    L17:
        if ((r2 instanceof StaggeredGridLayoutManager) == false) goto L19;
        ((StaggeredGridLayoutManager) r2).scrollToPositionWithOffset(r5, r6);
        goto L19
    L5:
        if (r0.i == false) goto L10;
        LLog.e("UIList", "ListScroller scrollToPositionSmoothly is scrolling ");
        if (r7 == null) goto L22;
        r7.invoke(new Object[]{1, "dumplicated, scrollToPositionSmoothly is working"});
        return;
    }
}
