package v19;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.common_ui.utils.RecyclerViewExtKt$onItemCompletelyShow$1;
import com.larus.common_ui.utils.RecyclerViewExtKt$onItemCompletelyShow$2;
import com.larus.common_ui.utils.RecyclerViewExtKt$onItemCompletelyShowWithReturnListener$onScrollListener$1;
import com.larus.common_ui.utils.RecyclerViewExtKt$onItemHalfShow$1;
import com.larus.common_ui.utils.RecyclerViewExtKt$onItemShowAbsoluteBy$1;
import com.larus.utils.n0;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y6 {
    public static final void i(RecyclerView r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r2 = r1.getTag(2131384073);
        if (TypeIntrinsics.isMutableSet(r2) == false) goto L5;
        Set r3 = (Set) r2;
    L6:
        if (r3 == null) goto L9;
        r3.clear();
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static final void h(RecyclerView r2, d6 r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != null) goto L5;
        return;
    L5:
        View.OnLayoutChangeListener r0 = r3.b;
        if (r0 == null) goto L8;
        r2.removeOnLayoutChangeListener(r0);
    L8:
        ViewTreeObserver.OnGlobalLayoutListener r1 = r3.c;
        if (r1 == null) goto L13;
        ViewTreeObserver r4 = r2.getViewTreeObserver();
        if (r4 == null) goto L13;
        r4.removeOnGlobalLayoutListener(r1);
    L13:
        RecyclerView.OnScrollListener r5 = r3.a;
        if (r5 == null) goto L17;
        r2.removeOnScrollListener(r5);
        return;
    }

    public static final void a(RecyclerView r9, n0<Rect> r10, Function2<? super Integer, ? super RecyclerView.ViewHolder, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "rectPool");
        Intrinsics.checkNotNullParameter(r11, "callBack");
        LinearLayoutManager r1 = null;
        if ((r9.getLayoutManager() instanceof LinearLayoutManager) == false) goto L51;
        LinearLayoutManager r0 = r9.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L7;
        r1 = r0;
    L7:
        if (r1 != null) goto L9;
        return;
    L9:
        Rect r2 = (Rect) r10.a();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        Object r4 = Result.constructor-impl(Boolean.valueOf(r9.getGlobalVisibleRect(r2)));     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r4) == null) goto L19;
        r4 = Boolean.FALSE;
    L19:
        if (((Boolean) r4).booleanValue() == true) goto L22;
        r10.c = 0;
        return;
    L22:
        Rect r5 = (Rect) r10.a();
        int r6 = r1.findFirstCompletelyVisibleItemPosition();
        int r7 = r1.findLastCompletelyVisibleItemPosition();
        int r8 = Math.min(r6, r7);
        int r12 = Math.max(r6, r7);
        if (r8 > r12) goto L49;
    L24:
        View r13 = r1.findViewByPosition(r8);
        if (r13 == null) goto L47;
        RecyclerView.ViewHolder r14 = r9.getChildViewHolder(r13);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L30
        Object r16 = Result.constructor-impl(Boolean.valueOf(r13.getGlobalVisibleRect(r5)));     // Catch: Throwable -> L30
    L33:
        if (Result.exceptionOrNull-impl(r16) == null) goto L37;
        r16 = Boolean.FALSE;
    L37:
        if (((Boolean) r16).booleanValue() == false) goto L47;
        if (r5.top < r2.top) goto L47;
        if (r5.bottom > r2.bottom) goto L47;
        if (r5.left < r2.left) goto L47;
        if (r5.right > r2.right) goto L47;
        Integer r17 = Integer.valueOf(r8);
        Intrinsics.checkNotNull(r14);
        r11.invoke(r17, r14);
    L30:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L47:
        if (r8 == r12) goto L49;
        r8 = r8 + 1;
    L49:
        r10.c = 0;
        return;
    L12:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L51:
        if ((r9.getLayoutManager() instanceof StaggeredGridLayoutManager) == false) goto L80;
        StaggeredGridLayoutManager r21 = r9.getLayoutManager();
        if ((r21 instanceof StaggeredGridLayoutManager) == false) goto L55;
        StaggeredGridLayoutManager r22 = r21;
    L56:
        if (r22 != null) goto L59;
        return;
    L59:
        if (r9.getGlobalVisibleRect((Rect) r10.a()) == true) goto L61;
        return;
    L61:
        int[] r23 = r22.findFirstVisibleItemPositions(null);
        int r24 = r23[0];
        Intrinsics.checkNotNull(r23);
        int r25 = r23.length;
        int r26 = 0;
    L62:
        if (r26 >= r25) goto L64;
        r24 = Math.min(r23[r26], r24);
        r26 = r26 + 1;
        goto L62
    L64:
        int[] r27 = r22.findLastVisibleItemPositions(null);
        int r28 = r27[0];
        Intrinsics.checkNotNull(r27);
        int r30 = r27.length;
        int r31 = 0;
    L65:
        if (r31 >= r30) goto L67;
        r28 = Math.max(r27[r31], r28);
        r31 = r31 + 1;
        goto L65
    L67:
        if (r24 > r28) goto L78;
    L68:
        View r32 = r22.findViewByPosition(r24);
        if (r32 == null) goto L76;
        RecyclerView.ViewHolder r33 = r9.getChildViewHolder(r32);
        Rect r34 = new Rect();
        boolean r35 = r32.getGlobalVisibleRect(r34);
        float r36 = (r34.height() * r34.width()) / RangesKt.coerceAtLeast(r32.getHeight() * r32.getWidth(), 0.1f);
        if (r35 == false) goto L76;
        if (r36 < 0.99f) goto L76;
        Integer r37 = Integer.valueOf(r24);
        Intrinsics.checkNotNull(r33);
        r11.invoke(r37, r33);
    L76:
        if (r24 == r28) goto L78;
        r24 = r24 + 1;
    L78:
        r10.c = 0;
        return;
    L55:
        r22 = null;
        goto L56
    L80:
        if ((r9.getLayoutManager() instanceof GridLayoutManager) == false) goto L124;
        LinearLayoutManager r38 = r9.getLayoutManager();
        if ((r38 instanceof GridLayoutManager) == false) goto L84;
        r1 = (GridLayoutManager) r38;
    L84:
        if (r1 != null) goto L86;
        return;
    L86:
        Rect r40 = (Rect) r10.a();
        if (r9.getGlobalVisibleRect(r40) == true) goto L89;
        return;
    L89:
        int r41 = r1.findFirstCompletelyVisibleItemPosition();
        int r42 = r1.findLastCompletelyVisibleItemPosition();
        if (r41 == (-1)) goto L125;
        if (r42 == (-1)) goto L126;
        int r43 = Math.min(r41, r42);
        int r44 = Math.max(r41, r42);
        if (r43 > r44) goto L111;
    L95:
        View r45 = r1.findViewByPosition(r43);
        if (r45 == null) goto L109;
        RecyclerView.ViewHolder r46 = r9.getChildViewHolder(r45);
        Rect r47 = new Rect();
        if (r45.getGlobalVisibleRect(r47) == false) goto L109;
        if (r47.top < r40.top) goto L109;
        if (r47.bottom > r40.bottom) goto L109;
        if (r47.left < r40.left) goto L109;
        if (r47.right > r40.right) goto L109;
        Integer r48 = Integer.valueOf(r43);
        Intrinsics.checkNotNull(r46);
        r11.invoke(r48, r46);
    L109:
        if (r43 == r44) goto L111;
        r43 = r43 + 1;
    L111:
        r10.c = 0;
        return;
    L126:
        return;
    L125:
        return;
    }

    public static final void c(RecyclerView r3, final Function1 r4, final Function2 r5, final Function2 r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r6, "callBack");
        Object r0 = r3.getTag(2131384073);
        if (TypeIntrinsics.isMutableSet(r0) == false) goto L5;
        final Set r1 = (Set) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        b(r3, new n0(new x6()), 0.0f, false, new h6(r5, r4, r1, r6));
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.jvm.functions.Function0, v19.p6] */
    public static d6 e(final RecyclerView r9, final Function1 r10, final Function2 r11, final Function2 r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r12, "callBack");
        final LinkedHashSet r6 = new LinkedHashSet();
        final n0 r3 = new n0(new g6());
        d6 r0 = new d6(0);
        r9.setTag(2131384073, r6);
        final ?? r8 = new p6(r9, r3, r11, r10, r6, r12);
        RecyclerView.OnScrollListener r13 = new RecyclerViewExtKt$onItemCompletelyShowWithReturnListener$onScrollListener$1(r8);
        View.OnLayoutChangeListener r14 = new q6(r8);
        r9.addOnScrollListener(r13);
        r9.addOnLayoutChangeListener(r14);
        r0.b = r14;
        r0.a = r13;
        ViewTreeObserver.OnGlobalLayoutListener r15 = new p5(r8);
        r9.getViewTreeObserver().addOnGlobalLayoutListener(r15);
        r0.c = r15;
        return r0;
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.jvm.functions.Function0, v19.j6] */
    public static void g(final RecyclerView r9, final Function2 r10, final int r11, final Function2 r12) {
        final Function1 r5 = null;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r12, "callBack");
        final LinkedHashSet r6 = new LinkedHashSet();
        final n0 r2 = new n0(new i6());
        r9.setTag(2131384073, r6);
        final ?? r8 = new j6(r9, r2, r11, r10, r5, r6, r12);
        r9.addOnScrollListener(new RecyclerViewExtKt$onItemShowAbsoluteBy$1(r8));
        r9.addOnLayoutChangeListener(new k6(r8));
        r9.getViewTreeObserver().addOnGlobalLayoutListener(new p5(r8));
    }

    public static final void b(RecyclerView r11, n0<Rect> r12, float r13, boolean r14, Function2<? super Integer, ? super RecyclerView.ViewHolder, Unit> r15) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "rectPool");
        Intrinsics.checkNotNullParameter(r15, "callBack");
        LinearLayoutManager r3 = null;
        if ((r11.getLayoutManager() instanceof LinearLayoutManager) == false) goto L40;
        LinearLayoutManager r0 = r11.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L7;
        r3 = r0;
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        int r1 = r3.getOrientation();
        if (r11.getGlobalVisibleRect((Rect) r12.a()) == true) goto L14;
        if (r14 == true) goto L14;
        boolean r5 = false;
    L15:
        if (r5 == true) goto L17;
        return;
    L17:
        int r6 = r3.findFirstVisibleItemPosition();
        int r7 = r3.findLastVisibleItemPosition();
        if (r6 > r7) goto L38;
    L19:
        View r8 = r3.findViewByPosition(r6);
        if (r8 == null) goto L36;
        RecyclerView.ViewHolder r9 = r11.getChildViewHolder(r8);
        Rect r10 = new Rect();
        if (r8.getGlobalVisibleRect(r10) == true) goto L27;
        if (r14 == true) goto L27;
        boolean r16 = false;
    L28:
        if (r1 != 1) goto L30;
        float r17 = r10.height();
        float r18 = RangesKt.coerceAtLeast(r8.getHeight(), 0.01f);
    L31:
        float r20 = r17 / r18;
        if (r16 == false) goto L36;
        if (r20 < r13) goto L36;
        Integer r21 = Integer.valueOf(r6);
        Intrinsics.checkNotNull(r9);
        r15.invoke(r21, r9);
        goto L36
    L30:
        r17 = r10.width();
        r18 = RangesKt.coerceAtLeast(r8.getWidth(), 0.01f);
    L27:
        r16 = true;
    L36:
        if (r6 == r7) goto L38;
        r6 = r6 + 1;
    L38:
        r12.c = 0;
        return;
    L14:
        r5 = true;
        goto L15
    L40:
        if ((r11.getLayoutManager() instanceof StaggeredGridLayoutManager) == false) goto L71;
        StaggeredGridLayoutManager r110 = r11.getLayoutManager();
        if ((r110 instanceof StaggeredGridLayoutManager) == false) goto L44;
        StaggeredGridLayoutManager r111 = r110;
    L45:
        if (r111 != null) goto L47;
        return;
    L47:
        int r2 = r111.getOrientation();
        if (r11.getGlobalVisibleRect((Rect) r12.a()) == true) goto L50;
        return;
    L50:
        int r22 = ArraysKt.first(r111.findFirstVisibleItemPositions(null));
        int[] r4 = r111.findLastVisibleItemPositions(null);
        Intrinsics.checkNotNull(r4);
        Integer r23 = ArraysKt.maxOrNull(r4);
        if (r23 == null) goto L53;
        int r24 = r23.intValue();
    L54:
        if (r22 > r24) goto L69;
    L55:
        View r25 = r111.findViewByPosition(r22);
        if (r25 == null) goto L67;
        RecyclerView.ViewHolder r26 = r11.getChildViewHolder(r25);
        Rect r27 = new Rect();
        boolean r28 = r25.getGlobalVisibleRect(r27);
        if (r2 != 1) goto L61;
        float r30 = r27.height();
        float r31 = RangesKt.coerceAtLeast(r25.getHeight(), 0.01f);
    L62:
        float r32 = r30 / r31;
        if (r28 == false) goto L67;
        if (r32 < r13) goto L67;
        Integer r33 = Integer.valueOf(r22);
        Intrinsics.checkNotNull(r26);
        r15.invoke(r33, r26);
        goto L67
    L61:
        r30 = r27.width();
        r31 = RangesKt.coerceAtLeast(r25.getWidth(), 0.01f);
    L67:
        if (r22 == r24) goto L69;
        r22 = r22 + 1;
    L69:
        r12.c = 0;
        return;
    L53:
        r24 = ArraysKt.last(r4);
        goto L54
    L44:
        r111 = null;
        goto L45
    L71:
        if ((r11.getLayoutManager() instanceof GridLayoutManager) == false) goto L103;
        LinearLayoutManager r112 = r11.getLayoutManager();
        if ((r112 instanceof GridLayoutManager) == false) goto L75;
        r3 = (GridLayoutManager) r112;
    L75:
        if (r3 != null) goto L78;
        return;
    L78:
        if (r11.getGlobalVisibleRect((Rect) r12.a()) == true) goto L80;
        return;
    L80:
        int r113 = r3.findFirstCompletelyVisibleItemPosition();
        int r34 = r3.findLastCompletelyVisibleItemPosition();
        if (r113 == (-1)) goto L104;
        if (r34 == (-1)) goto L105;
        int r35 = Math.min(r113, r34);
        int r114 = Math.max(r113, r34);
        if (r35 > r114) goto L96;
    L86:
        View r36 = r3.findViewByPosition(r35);
        if (r36 == null) goto L94;
        RecyclerView.ViewHolder r37 = r11.getChildViewHolder(r36);
        Rect r38 = new Rect();
        boolean r40 = r36.getGlobalVisibleRect(r38);
        float r41 = r38.height() / RangesKt.coerceAtLeast(r36.getHeight(), 0.01f);
        if (r40 == false) goto L94;
        if (r41 < r13) goto L94;
        Integer r42 = Integer.valueOf(r35);
        Intrinsics.checkNotNull(r37);
        r15.invoke(r42, r37);
    L94:
        if (r35 == r114) goto L96;
        r35 = r35 + 1;
    L96:
        r12.c = 0;
        return;
    L105:
        return;
    L104:
        return;
    }

    /* JADX WARN: Type inference failed for: r11v7, types: [kotlin.jvm.functions.Function0, v19.v6] */
    public static void d(final RecyclerView r10, Function1 r11, Function2 r12, RecyclerView r13, final Function2 r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r15 & 2) == 0) goto L9;
        final Function1 r7 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        final Function2 r6 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        r13 = null;
    L17:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r14, "callBack");
        final LinkedHashSet r8 = new LinkedHashSet();
        final n0 r5 = new n0(new u6());
        r10.setTag(2131384073, r8);
        final ?? r16 = new v6(r10, r5, r6, r7, r8, r14);
        r10.addOnScrollListener(new RecyclerViewExtKt$onItemCompletelyShow$1(r16));
        if (r13 == null) goto L20;
        r13.addOnScrollListener(new RecyclerViewExtKt$onItemCompletelyShow$2(r16));
    L20:
        r10.addOnLayoutChangeListener(new w6(r16));
        if (r0 == false) goto L24;
        r10.getViewTreeObserver().addOnGlobalLayoutListener(new p5(r16));
        return;
    L24:
        return;
    L13:
        r6 = r12;
        goto L15
    L9:
        r7 = r11;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.jvm.functions.Function0, v19.s6] */
    public static s6 f(final RecyclerView r13, Function2 r14, Function2 r15, float r16, final Function2 r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        boolean r11 = true;
    L7:
        if ((r18 & 2) == 0) goto L9;
        final Function2 r6 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        final Function2 r5 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        final float r3 = 0.5f;
    L18:
        final boolean r4 = false;
        if ((r18 & 32) == 0) goto L21;
        final boolean r8 = true;
    L22:
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r17, "callBack");
        final LinkedHashSet r7 = new LinkedHashSet();
        final n0 r2 = new n0(new r6());
        r13.setTag(2131384073, r7);
        final ?? r12 = new s6(r13, r2, r3, r4, r5, r6, r7, r8, r17);
        r13.addOnScrollListener(new RecyclerViewExtKt$onItemHalfShow$1(r12));
        r13.addOnLayoutChangeListener(new t6(r12));
        if (r11 == false) goto L25;
        r13.getViewTreeObserver().addOnGlobalLayoutListener(new p5(r12));
    L25:
        return r12;
    L21:
        r8 = false;
        goto L22
    L17:
        r3 = r16;
        goto L18
    L13:
        r5 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r11 = false;
        goto L7
    }
}
