package com.ss.android.lark.chat.cot.detail;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.biz.im.extension.panel.drag.view.DragPanelLayout;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import com.ss.android.lark.widget.textview.ShineTextView;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final j a;
    public final com.ss.android.lark.chat.cot.a b;
    public final boolean c;
    public final Function1<k, Unit> d;
    public final Function2<k, String, Unit> e;
    public com.ss.android.lark.biz.im.extension.panel.drag.i f;
    public RecyclerView g;
    public ShineTextView h;
    public View i;
    public CotDetailBlueprintAdapter j;
    public Function0<Unit> k;
    public InvalidDecorationObserver l;
    public g m;
    public CotStepExposureTracker n;
    public CotDetailContentController$setupStepTracking$2 o;
    public q p;
    public boolean q;
    public boolean r;
    public String s;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotDetailBlockType.values().length];
            r0[CotDetailBlockType.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CotDetailBlockType.TOOLCALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CotDetailBlockType.ACTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CotDetailBlockType.THINKING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CotDetailBlockType.STATUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public static final void a(c r12, String r13) {
        RecyclerView r0 = r12.g;
        if (r0 == null) goto L36;
        LinearLayoutManager r1 = r0.getLayoutManager();
        CotDetailBlockType r3 = null;
        if ((r1 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r2 = r1;
    L9:
        if (r2 == null) goto L37;
        CotDetailBlueprintAdapter r4 = r12.j;
        if (r4 == null) goto L14;
        int r5 = r4.getItemCount();
    L15:
        int r6 = r5 - 1;
        if (r6 < 0) goto L38;
        CotDetailBlueprintAdapter r14 = r12.j;
        if (r14 == null) goto L23;
        List r15 = r14.c.getCurrentList();
        if (r15 == null) goto L23;
        k r16 = (k) CollectionsKt.getOrNull(r15, r6);
    L24:
        View r7 = r2.findViewByPosition(r6);
        if (r7 != null) goto L30;
        StringBuilder r8 = new StringBuilder("scroll reason=");
        r8.append(r13);
        r8.append(", last=");
        r8.append(r6);
        r8.append(", lastType=");
        if (r16 == null) goto L29;
        r3 = r16.b;
    L29:
        r8.append(r3);
        r8.append(", lastView=null -> scrollToPosition");
        com.ss.android.lark.chat.cot.f.c("detail_autoscroll", r8.toString());
        r2.scrollToPosition(r6);
        return;
    L30:
        int r10 = (r0.getHeight() - r0.getPaddingTop()) - r0.getPaddingBottom();
        int r9 = r2.getDecoratedMeasuredHeight(r7);
        int r11 = RangesKt.coerceAtLeast(r10 - r9, 0);
        StringBuilder r17 = new StringBuilder("scroll reason=");
        r17.append(r13);
        r17.append(", last=");
        r17.append(r6);
        r17.append(", lastType=");
        if (r16 == null) goto L33;
        r3 = r16.b;
    L33:
        r17.append(r3);
        r17.append(", rawH=");
        r17.append(r7.getHeight());
        r17.append(", decoratedH=");
        r17.append(r9);
        r17.append(", visibleH=");
        r17.append(r10);
        r17.append(", top=");
        r17.append(r7.getTop());
        r17.append(", bottom=");
        r17.append(r7.getBottom());
        r17.append(", decoratedTop=");
        r17.append(r2.getDecoratedTop(r7));
        r17.append(", decoratedBottom=");
        r17.append(r2.getDecoratedBottom(r7));
        r17.append(", offset=");
        r17.append(r11);
        com.ss.android.lark.chat.cot.f.c("detail_autoscroll", r17.toString());
        r2.scrollToPositionWithOffset(r6, r11);
        return;
    L23:
        r16 = null;
        goto L24
    L38:
        return;
    L14:
        r5 = 0;
        goto L15
    L37:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final View c(Context r8, DragPanelLayout r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r10 = LayoutInflater.from(r8).inflate(2131561528, r9, false);
        this.h = r10.findViewById(2131367982);
        this.i = r10.findViewById(2131367977);
        View r11 = r10.findViewById(2131367981);
        if (r11 == null) goto L5;
        r11.setOnClickListener(new d(this));
    L5:
        View r12 = r10.findViewById(2131367984);
        if (r12 == null) goto L8;
        r12.setOnClickListener(new e(this));
    L8:
        RecyclerView r13 = r10.findViewById(2131367983);
        this.g = r13;
        int r0 = com.ss.android.lark.chat.cot.detail.blueprint.a.a;
        CotDetailBlueprintAdapter r1 = com.ss.android.lark.chat.cot.detail.blueprint.a.a(r13.getContext(), this.a, this.b, this.c, new CotDetailContentController$setupRecyclerView$blueprintAdapter$1(this), new CotDetailContentController$setupRecyclerView$blueprintAdapter$2(this));
        this.j = r1;
        r13.setLayoutManager(new LinearLayoutManager(r13.getContext()));
        r13.setAdapter(r1);
        if (this.c == false) goto L11;
        RecyclerView.ItemDecoration r2 = new CotDetailSpacingDecoration(r13.getContext());
    L12:
        r13.addItemDecoration(r2);
        InvalidDecorationObserver r3 = new InvalidDecorationObserver(r13);
        r1.registerAdapterDataObserver(r3);
        this.l = r3;
        r13.setItemAnimator(null);
        r13.addOnScrollListener(new CotDetailContentController$setupRecyclerView$2(this));
        if (this.c == false) goto L20;
        CotStepExposureTracker r4 = new CotStepExposureTracker(r13, r1, this.d);
        if (r4.e == true) goto L19;
        r4.e = true;
        r4.a.addOnScrollListener(r4.i);
        r4.a.addOnChildAttachStateChangeListener(r4.j);
        r4.a();
    L19:
        this.n = r4;
        final GestureDetector r5 = new GestureDetector(r13.getContext(), new h(this, r13, r1));
        RecyclerView.OnItemTouchListener r6 = new CotDetailContentController$setupStepTracking$2(r5);
        r13.addOnItemTouchListener(r6);
        this.o = r6;
    L20:
        g r7 = new g(r13, this);
        r13.getViewTreeObserver().addOnGlobalLayoutListener(r7);
        this.m = r7;
        Intrinsics.checkNotNull(r10);
        return r10;
    L11:
        r2 = new CotDotItemDecoration(r13.getContext());
        goto L12
    }

    public static final void b(c r6, RecyclerView r7, CotDetailBlueprintAdapter r8, MotionEvent r9) {
        r6.getClass();
        View r0 = r7.findChildViewUnder(r9.getX(), r9.getY());
        if (r0 == null) goto L81;
        k r10 = (k) CollectionsKt.getOrNull(r8.c.getCurrentList(), r7.getChildAdapterPosition(r0));
        if (r10 == null) goto L82;
        CotDetailBlockType r11 = r10.b;
        int[] r1 = b.a;
        int r12 = r1[r11.ordinal()];
        boolean r2 = false;
        View r4 = null;
        if (r12 != 1) goto L11;
        View r13 = r0.findViewById(2131368001);
    L47:
        if (r13 != null) goto L49;
        return;
    L49:
        if (r13.getVisibility() != 0) goto L51;
        boolean r3 = true;
    L52:
        if (r3 == false) goto L54;
        r4 = r13;
    L54:
        if (r4 == null) goto L83;
        int r14 = (int) r9.getRawX();
        int r15 = (int) r9.getRawY();
        Rect r5 = new Rect();
        if (r4.getGlobalVisibleRect(r5) == true) goto L59;
    L61:
        if (r2 == true) goto L64;
        return;
    L64:
        if (r4.hasOnClickListeners() == true) goto L69;
        if (r10.b != CotDetailBlockType.TOOLCALL) goto L79;
        r6.e.invoke(r10, "none");
        return;
    L79:
        return;
    L69:
        if (r1[r10.b.ordinal()] != 1) goto L71;
        boolean r16 = r6.a.b(r10.a);
    L72:
        Function2<k, String, Unit> r17 = r6.e;
        if (r16 == false) goto L75;
        String r18 = "collapse";
    L76:
        r17.invoke(r10, r18);
        return;
    L75:
        r18 = "expand";
        goto L76
    L71:
        r16 = r4.isSelected();
        goto L72
    L59:
        if (r5.contains(r14, r15) == false) goto L61;
        r2 = true;
        goto L61
    L83:
        return;
    L51:
        r3 = false;
        goto L52
    L11:
        if (r12 != 2) goto L13;
        r13 = r0.findViewById(2131368003);
        goto L47
    L13:
        if (r12 != 3) goto L15;
        r13 = r0.findViewById(2131367976);
        if (r13 != null) goto L36;
    L44:
        r13 = r0.findViewById(2131367975);
        goto L47
    L36:
        if (r13.getVisibility() != 0) goto L38;
        boolean r19 = true;
    L39:
        if (r19 == true) goto L42;
        r13 = null;
    L42:
        if (r13 == null) goto L44;
    L38:
        r19 = false;
        goto L39
    L15:
        if (r12 != 4) goto L17;
        r13 = r0.findViewById(2131367996);
        if (r13 != null) goto L24;
    L32:
        r13 = r0.findViewById(2131367995);
        goto L47
    L24:
        if (r13.getVisibility() != 0) goto L26;
        boolean r20 = true;
    L27:
        if (r20 == true) goto L30;
        r13 = null;
    L30:
        if (r13 == null) goto L32;
    L26:
        r20 = false;
        goto L27
    L17:
        if (r12 != 5) goto L20;
        r13 = r0.findViewById(2131367994);
        goto L47
    L20:
        throw new NoWhenBranchMatchedException();
    L82:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(j r2, com.ss.android.lark.chat.cot.a r3, boolean r4, Function1<? super k, Unit> r5, Function2<? super k, ? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "expandStore");
        Intrinsics.checkNotNullParameter(r3, "cotFeatureGate");
        Intrinsics.checkNotNullParameter(r5, "onStepView");
        Intrinsics.checkNotNullParameter(r6, "onStepClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.r = true;
    }
}
