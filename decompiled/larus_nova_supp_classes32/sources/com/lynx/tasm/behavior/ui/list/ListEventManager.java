package com.lynx.tasm.behavior.ui.list;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.q1;
import com.lynx.tasm.utils.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import m7a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ListEventManager extends RecyclerView.OnScrollListener {
    public final EventEmitter a;
    public final RecyclerView b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public long i;
    public final UIList j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;

    public final JavaOnlyArray l() {
        JavaOnlyArray r0 = new JavaOnlyArray();
        ArrayList r1 = new ArrayList();
        LinearLayoutManager r2 = this.b.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r3 = r2;
        int r4 = r3.findFirstVisibleItemPosition();
        int r5 = r3.findLastVisibleItemPosition();
    L5:
        if (r4 > r5) goto L19;
        r1.add(Integer.valueOf(r4));
        r4 = r4 + 1;
    L19:
        Iterator r6 = r1.iterator();
    L21:
        if (r6.hasNext() == false) goto L28;
        int r7 = ((Integer) r6.next()).intValue();
        ListViewHolder r8 = (ListViewHolder) this.b.findViewHolderForLayoutPosition(r7);
        if (r8 == null) goto L21;
        if (r8.a.b == null) goto L21;
        View r9 = ((RecyclerView.ViewHolder) r8).itemView;
        JavaOnlyMap r10 = new JavaOnlyMap();
        r10.put("id", r8.a.b.getIdSelector());
        r10.put("position", Integer.valueOf(r7));
        r10.put("index", Integer.valueOf(r7));
        r10.put("itemKey", r8.a.b.b);
        r10.put("top", Float.valueOf(i.c(r9.getTop())));
        r10.put("bottom", Float.valueOf(i.c(r9.getBottom())));
        r10.put("left", Float.valueOf(i.c(r9.getLeft())));
        r10.put("right", Float.valueOf(i.c(r9.getRight())));
        r0.add(r10);
        goto L21
    L28:
        return r0;
    L8:
        if ((r2 instanceof StaggeredGridLayoutManager) == false) goto L19;
        StaggeredGridLayoutManager r11 = (StaggeredGridLayoutManager) r2;
        int[] r12 = r11.findFirstVisibleItemPositions(null);
        int[] r13 = r11.findLastVisibleItemPositions(null);
        int r14 = r12.length;
        int r15 = 0;
        int r16 = Integer.MIN_VALUE;
        int r17 = 0;
    L10:
        if (r17 >= r14) goto L12;
        int r18 = r12[r17];
        r1.add(Integer.valueOf(r18));
        r16 = Math.max(r16, r18);
        r17 = r17 + 1;
        goto L10
    L12:
        int r19 = r13.length;
        int r20 = Integer.MAX_VALUE;
    L13:
        if (r15 >= r19) goto L15;
        int r21 = r13[r15];
        r1.add(Integer.valueOf(r21));
        r20 = Math.min(r20, r21);
        r15 = r15 + 1;
    L15:
        r16 = r16 + 1;
        if (r16 >= r20) goto L18;
        r1.add(Integer.valueOf(r16));
        goto L15
    L18:
        Collections.sort(r1);
        goto L19
    }

    public final void o(int r4) {
        if ((this.c & 8) != 0) goto L5;
        return;
    L5:
        d r1 = new d(this.j.getSign(), "scrollstatechange");
        if (this.n == false) goto L8;
        JavaOnlyArray r0 = l();
    L9:
        r1.a("state", Integer.valueOf(r4));
        if (r0 == null) goto L12;
        r1.d(r0);
    L12:
        this.a.sendCustomEvent(r1);
        return;
    L8:
        r0 = null;
        goto L9
    }

    public static boolean j(f6a.a r2, boolean r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        ReadableType r0 = r2.getType();
        if (r0 != ReadableType.String) goto L8;
        return Boolean.parseBoolean(r2.asString());
    L8:
        if (r0 == ReadableType.Int) goto L18;
        if (r0 == ReadableType.Number) goto L18;
        if (r0 == ReadableType.Long) goto L18;
        if (r0 == ReadableType.Boolean) goto L24;
        return r3;
    L24:
        return r2.asBoolean();
    L18:
        if (r2.asInt() == 0) goto L21;
        return true;
    L21:
        return false;
    }

    public static int k(f6a.a r2, int r3) {
        ReadableType r0 = r2.getType();
        if (r0 != ReadableType.String) goto L9;
        return CastIntegerProtector.parseInt(r2.asString());
    L6:
        e = move-exception;
        e.printStackTrace();
        return r3;
    L9:
        if (r0 == ReadableType.Int) goto L15;
        if (r0 == ReadableType.Number) goto L15;
        if (r0 == ReadableType.Long) goto L15;
        return r3;
    L15:
        return r2.asInt();
    }

    public final void m(int r8, int r9) {
        if (this.k == true) goto L27;
        if (r9 == 0) goto L6;
        return;
    L6:
        if (r8 > 0) goto L8;
        if (r8 >= 0) goto L30;
        this.l = 0;
        if (this.j.F == true) goto L19;
    L23:
        n("scrolltoupper", 2, 0, 0, 0, 0);
        this.k = true;
        return;
    L19:
        if (this.g == 0) goto L21;
        return;
    L21:
        if (this.e == 0) goto L23;
        return;
    L30:
        return;
    L8:
        if (this.j.F == true) goto L10;
    L14:
        int r4 = this.l;
        n("scrolltolower", 4, r4, r4, 0, 0);
        this.k = true;
        return;
    L10:
        if (this.h == 0) goto L12;
        return;
    L12:
        if (this.f == 0) goto L14;
        return;
    }

    public final void onScrollStateChanged(RecyclerView r6, int r7) {
        this.j.recognizeGesturere();
        if (r7 != 0) goto L5;
        this.j.getLynxContext().getFluencyTraceHelper().c(this.j.getSign());
        o(1);
        if (this.j.isEnableScrollMonitor() == false) goto L20;
        this.j.getLynxContext().getLynxViewClient().onScrollStop(new q1.b(r6, this.j.getTagName(), this.j.getScrollMonitorTag()));
    L20:
        if (this.j.R == false) goto L22;
        r6.invalidateItemDecorations();
    L22:
        this.j.notifyScrollStateChanged(0);
        return;
    L5:
        if (r7 == 1) goto L12;
        if (r7 != 2) goto L26;
        o(3);
        if (this.j.isEnableScrollMonitor() == false) goto L11;
        this.j.getLynxContext().getLynxViewClient().onFling(new q1.b(r6, this.j.getTagName(), this.j.getScrollMonitorTag()));
    L11:
        this.j.notifyScrollStateChanged(2);
        return;
    L26:
        return;
    L12:
        this.j.getLynxContext().getFluencyTraceHelper().b(this.j.getSign(), this.j.getScrollMonitorTag());
        this.k = false;
        o(2);
        if (this.j.isEnableScrollMonitor() == false) goto L15;
        this.j.getLynxContext().getLynxViewClient().onScrollStart(new q1.b(r6, this.j.getTagName(), this.j.getScrollMonitorTag()));
    L15:
        this.j.notifyScrollStateChanged(1);
    }

    public ListEventManager(EventEmitter r4, RecyclerView r5, UIList r6) {
        this.c = 0;
        this.d = 200;
        this.e = 50;
        this.f = 50;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.k = true;
        this.l = 0;
        this.m = 1;
        this.n = false;
        this.a = r4;
        this.b = r5;
        r5.addOnScrollListener(this);
        this.j = r6;
    }

    public final void onScrolled(RecyclerView r18, int r19, int r20) {
        if (r19 != 0) goto L7;
        if (r20 != 0) goto L7;
        return;
    L7:
        if (this.j.x == false) goto L9;
        int r0 = r20;
    L11:
        if (1 != this.b.getLayoutDirection()) goto L13;
        r0 = -r0;
    L13:
        int r9 = r0;
        this.l += r9;
        if ((System.currentTimeMillis() - this.i) <= this.d) goto L16;
        int r4 = this.l;
        n("scroll", 1, r4, r4, r19, r20);
        this.i = System.currentTimeMillis();
    L16:
        RecyclerView.LayoutManager r1 = this.b.getLayoutManager();
        int r2 = this.b.getChildCount();
        int r3 = r1.getItemCount();
        boolean r5 = this.j.x;
        if (r5 == false) goto L19;
        int r6 = r1.getPaddingTop();
    L20:
        if (r5 == false) goto L22;
        int r7 = r1.getHeight();
        int r8 = r1.getPaddingBottom();
    L23:
        int r10 = r7 - r8;
        int r11 = this.g;
        if (r11 <= 0) goto L26;
    L29:
        int r14 = (r3 - this.h) - 1;
        int r12 = Integer.MAX_VALUE;
        int r13 = Integer.MIN_VALUE;
        int r15 = 0;
    L30:
        if (r15 >= r2) goto L44;
        View r16 = this.b.getChildAt(r15);
        int r17 = this.b.getChildLayoutPosition(r16);
        if (r5 == false) goto L34;
        int r110 = r1.getDecoratedTop(r16);
    L35:
        int r111 = r110;
        if (r5 == false) goto L38;
        int r112 = r1.getDecoratedBottom(r16);
    L39:
        if (r112 <= r6) goto L41;
        r12 = Math.min(r17, r12);
    L41:
        if (r111 >= r10) goto L43;
        r13 = Math.max(r17, r13);
    L43:
        r15 = r15 + 1;
        goto L30
    L38:
        r112 = r1.getDecoratedRight(r16);
        goto L39
    L34:
        r110 = r1.getDecoratedLeft(r16);
        goto L35
    L44:
        if (r12 >= r11) goto L46;
        int r21 = 4;
    L47:
        if (r13 <= r14) goto L50;
        r21 = r21 | 8;
    L50:
        if (this.b.findViewHolderForLayoutPosition(0) == null) goto L52;
        boolean r113 = true;
    L54:
        if (this.b.findViewHolderForLayoutPosition(r3 - 1) == null) goto L56;
        boolean r22 = true;
    L57:
        if (r113 == true) goto L61;
        if (r22 == true) goto L61;
        int r23 = r21;
    L91:
        if ((r23 & 1) == 0) goto L93;
        boolean r24 = true;
    L94:
        if (r24 == false) goto L101;
        boolean r25 = true;
        if ((this.m & 1) == 0) goto L98;
        boolean r26 = true;
    L99:
        if (r26 == true) goto L102;
        boolean r27 = true;
    L104:
        if ((r23 & 4) == 0) goto L106;
        boolean r28 = true;
    L107:
        if (r28 == true) goto L109;
    L114:
        boolean r29 = false;
    L116:
        if ((r23 & 2) == 0) goto L118;
        boolean r30 = true;
    L119:
        if (r30 == true) goto L121;
    L126:
        boolean r31 = false;
    L128:
        if ((r23 & 8) == 0) goto L130;
        boolean r32 = true;
    L131:
        if (r32 == true) goto L133;
    L138:
        r25 = false;
    L139:
        if (r9 >= 0) goto L143;
        if (r27 == true) goto L142;
        if (r29 == false) goto L143;
    L142:
        int r33 = this.l;
        n("scrolltoupper", 2, r33, r33, 0, 0);
    L147:
        this.m = r23;
        return;
    L143:
        if (r9 <= 0) goto L147;
        if (r31 == true) goto L146;
        if (r25 == false) goto L147;
    L146:
        int r34 = this.l;
        n("scrolltolower", 4, r34, r34, 0, 0);
        goto L147
    L133:
        if ((this.m & 8) == 0) goto L135;
        boolean r35 = true;
    L136:
        if (r35 == true) goto L138;
    L135:
        r35 = false;
        goto L136
    L130:
        r32 = false;
        goto L131
    L121:
        if ((this.m & 2) == 0) goto L123;
        boolean r36 = true;
    L124:
        if (r36 == true) goto L126;
        r31 = true;
        goto L128
    L123:
        r36 = false;
        goto L124
    L118:
        r30 = false;
        goto L119
    L109:
        if ((this.m & 4) == 0) goto L111;
        boolean r37 = true;
    L112:
        if (r37 == true) goto L114;
        r29 = true;
        goto L116
    L111:
        r37 = false;
        goto L112
    L106:
        r28 = false;
    L102:
        r27 = false;
        goto L104
    L98:
        r26 = false;
        goto L99
    L101:
        r25 = true;
        goto L102
    L93:
        r24 = false;
    L61:
        int r38 = 0;
        int r114 = Integer.MAX_VALUE;
        int r115 = Integer.MIN_VALUE;
    L62:
        if (r38 >= r2) goto L71;
        View r116 = this.b.getChildAt(r38);
        if (r5 == false) goto L66;
        r114 = Math.min(r1.getDecoratedTop(r116), r114);
    L67:
        if (r5 == false) goto L69;
        r115 = Math.max(r1.getDecoratedBottom(r116), r115);
    L70:
        r38 = r38 + 1;
        goto L62
    L69:
        r115 = Math.max(r1.getDecoratedRight(r116), r115);
        goto L70
    L66:
        r114 = Math.min(r1.getDecoratedLeft(r116), r114);
        goto L67
    L71:
        if (r113 == false) goto L82;
        if (r114 != r6) goto L76;
        this.l = 0;
    L76:
        if (r114 <= (r6 - this.e)) goto L82;
        int r39 = r21 | 1;
        if (this.g <= 0) goto L80;
        r39 = r39 & (-5);
    L80:
        r21 = r39;
    L82:
        if (r22 == true) goto L84;
    L89:
        r23 = r21;
        goto L91
    L84:
        if (r115 >= (r10 + this.f)) goto L89;
        int r40 = r21 | 2;
        if (this.h <= 0) goto L88;
        r40 = r40 & (-9);
    L88:
        r21 = r40;
        goto L89
    L56:
        r22 = false;
        goto L57
    L52:
        r113 = false;
        goto L54
    L46:
        r21 = 0;
        goto L47
    L26:
        if (this.h > 0) goto L29;
        r21 = 0;
        goto L50
    L22:
        r7 = r1.getWidth();
        r8 = r1.getPaddingRight();
        goto L23
    L19:
        r6 = r1.getPaddingLeft();
        goto L20
    L9:
        r0 = r19;
        goto L11
    }

    public final void n(String r2, int r3, int r4, int r5, int r6, int r7) {
        if ((r3 & this.c) == 0) goto L10;
        d r0 = new d(this.j.getSign(), r2);
        if (this.n == false) goto L7;
        JavaOnlyArray r8 = l();
    L8:
        r0.a("scrollLeft", Float.valueOf(i.c(r4)));
        r0.a("scrollTop", Float.valueOf(i.c(r5)));
        r0.a("deltaX", Float.valueOf(i.c(r6)));
        r0.a("deltaY", Float.valueOf(i.c(r7)));
        r0.d(r8);
        this.a.sendCustomEvent(r0);
        return;
    L7:
        r8 = null;
        goto L8
    }
}
