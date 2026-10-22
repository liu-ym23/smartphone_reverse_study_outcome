package obric.flow.nlwidget.ui.feeds.drag;

import ai.j0;
import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.drakeet.multitype.MultiTypeAdapter;
import com.obric.flow.cardlistpage.ui.drag.DragInsertRecyclerView;
import com.obric.flow.cardlistpage.ui.viewbinder.FakeWidgetCardViewBinder$ViewHolder;
import com.obric.flow.cardlistpage.ui.viewbinder.TravelCardViewBinder$ViewHolder;
import com.obric.flow.cardlistpage.ui.viewbinder.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ju.b;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lobric/flow/nlwidget/ui/feeds/drag/CardItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCardItemTouchHelperCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CardItemTouchHelperCallback.kt\nobric/flow/nlwidget/ui/feeds/drag/CardItemTouchHelperCallback\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,349:1\n1755#2,3:350\n1#3:353\n*S KotlinDebug\n*F\n+ 1 CardItemTouchHelperCallback.kt\nobric/flow/nlwidget/ui/feeds/drag/CardItemTouchHelperCallback\n*L\n243#1:350,3\n*E\n"})
public final class CardItemTouchHelperCallback extends ItemTouchHelper.SimpleCallback {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f20517j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiTypeAdapter f20518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f20519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f20520c;
    public final Function0 d;
    public final Function1 e;
    public final boolean f;
    public volatile RecyclerView.ViewHolder g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f20521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView.ViewHolder f20522i;

    public CardItemTouchHelperCallback(MultiTypeAdapter r5, RecyclerView r10, a r11, Function0 r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r5, "adapter");
        super(51, 0);
        this.f20518a = r5;
        this.f20519b = r10;
        this.f20520c = r11;
        this.d = r12;
        this.e = r13;
        this.f = true;
    }

    public static void c(List r5, int r10, int r11, int r12, int r13, Function1 r14, Function1 r15) {
        List r16 = r5.subList(r10, r11);
        List r17 = CollectionsKt.toList(r16);
        r16.clear();
        if (r12 >= r13) goto L5;
        int r18 = r13 - 1;
    L6:
        if (r12 < r13) goto L9;
        r14 = r15;
    L9:
        if (r14 == null) goto L11;
        r14.invoke(r17);
        return;
    L11:
        r5.addAll(r18, r17);
        return;
    L5:
        r18 = r13;
        goto L6
    }

    public final boolean a(int r5) {
        GridLayoutManager r10 = null;
        RecyclerView r11 = this.f20519b;
        if (r11 == null) goto L5;
        RecyclerView.LayoutManager r12 = r11.getLayoutManager();
    L7:
        if ((r12 instanceof GridLayoutManager) == false) goto L10;
        r10 = (GridLayoutManager) r12;
    L10:
        if (r10 != null) goto L13;
        return false;
    L13:
        if (r10.getSpanSizeLookup().getSpanSize(r5) != r10.getSpanCount()) goto L16;
        return true;
    L16:
        return false;
    L5:
        r12 = null;
        goto L7
    }

    public final boolean b(int r5) {
        GridLayoutManager r10 = null;
        RecyclerView r11 = this.f20519b;
        if (r11 == null) goto L5;
        RecyclerView.LayoutManager r12 = r11.getLayoutManager();
    L7:
        if ((r12 instanceof GridLayoutManager) == false) goto L10;
        r10 = (GridLayoutManager) r12;
    L10:
        if (r10 != null) goto L13;
        return false;
    L13:
        if (r10.getSpanSizeLookup().getSpanIndex(r5, r10.getSpanCount()) != 0) goto L16;
        return true;
    L16:
        return false;
    L5:
        r12 = null;
        goto L7
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void clearView(RecyclerView r5, RecyclerView.ViewHolder r10) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Intrinsics.checkNotNullParameter(r10, "viewHolder");
        super.clearView(r5, r10);
        if (Intrinsics.areEqual(this.f20522i, r10) == false) goto L15;
        c r11 = this.f20520c;
        if (r11 == null) goto L7;
        r11.b(r10);
    L7:
        this.f20522i = null;
        RecyclerView r12 = this.f20519b;
        if ((r12 instanceof DragInsertRecyclerView) == false) goto L10;
        DragInsertRecyclerView r13 = (DragInsertRecyclerView) r12;
    L11:
        if (r13 == null) goto L16;
        r13.setDragSelectedView(null);
        return;
    L16:
        return;
    L10:
        r13 = null;
        goto L11
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final long getAnimationDuration(RecyclerView r5, int r10, float r11, float r12) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        if (r10 != 8) goto L18;
        if ((this.g instanceof FakeWidgetCardViewBinder$ViewHolder) == false) goto L9;
        return 0;
    L9:
        if (this.f20521h == false) goto L11;
        int r13 = 200;
    L12:
        String r14 = "getAnimationDuration: " + r13;
        Intrinsics.checkNotNullParameter("card_touch_event", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        org.koin.core.a r15 = su.a.f22013b;
        if (r15 == null) goto L16;
        ((b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).d("card_touch_event", r14);
        return r13;
    L16:
        throw new IllegalStateException("KoinApplication has not been started");
    L11:
        r13 = 0;
        goto L12
    L18:
        return super.getAnimationDuration(r5, r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final float getMoveThreshold(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        return 1.0f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final int interpolateOutOfBoundsScroll(RecyclerView r5, int r10, int r11, int r12, long r13) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        if (this.f == true) goto L7;
        return 0;
    L7:
        return super.interpolateOutOfBoundsScroll(r5, r10, r11, r12, r13) * 5;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onChildDraw(Canvas r5, RecyclerView r10, RecyclerView.ViewHolder r11, float r12, float r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        Intrinsics.checkNotNullParameter(r11, "viewHolder");
        if (this.f20521h == false) goto L5;
    L11:
        c r16 = this.f20520c;
        if (r16 == null) goto L14;
        r16.a(r11, r12, r13);
    L14:
        super.onChildDraw(r5, r10, r11, r12, r13, r14, r15);
        return;
    L5:
        if (Math.abs(r13) <= 20.0d) goto L7;
    L8:
        this.f20521h = true;
        Function0 r17 = this.d;
        if (r17 == null) goto L11;
        r17.invoke();
        goto L11
    L7:
        if (Math.abs(r12) <= 20.0d) goto L11;
        goto L8
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView r12, RecyclerView.ViewHolder r13, RecyclerView.ViewHolder r14) {
        Intrinsics.checkNotNullParameter(r12, "recyclerView");
        Intrinsics.checkNotNullParameter(r13, "viewHolder");
        Intrinsics.checkNotNullParameter(r14, "target");
        int r5 = r13.getBindingAdapterPosition();
        final int r10 = r14.getBindingAdapterPosition();
        List r11 = null;
        boolean r15 = false;
        if (r5 == (-1)) goto L82;
        if (r10 == (-1)) goto L82;
        if (r10 != 0) goto L8;
        return false;
    L8:
        String r16 = "onMove: " + r13 + " " + r14 + " fromPosition=" + r5 + " toPosition=" + r10;
        Intrinsics.checkNotNullParameter("card_touch_event", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        org.koin.core.a r17 = su.a.f22013b;
        if (r17 == null) goto L81;
        ((b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).d("card_touch_event", r16);
        if ((r14 instanceof TravelCardViewBinder$ViewHolder) == false) goto L13;
        return true;
    L13:
        if (r5 == r10) goto L77;
        if (r10 == 0) goto L77;
        String r18 = j0.f(r5, r10, "moveItem: fromPosition=", " toPosition=");
        Intrinsics.checkNotNullParameter("card_touch_event", "tag");
        Intrinsics.checkNotNullParameter(r18, "msg");
        org.koin.core.a r19 = su.a.f22013b;
        if (r19 == null) goto L79;
        ((b) r19.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).i("card_touch_event", r18);
        if (r5 < 0) goto L77;
        MultiTypeAdapter r110 = this.f20518a;
        if (r5 >= r110.f7569a.size()) goto L77;
        if (r10 < 0) goto L77;
        if (r10 >= r110.f7569a.size()) goto L77;
        final List r111 = CollectionsKt.toMutableList(r110.f7569a);
        String r20 = j0.f(r5, r10, "generateNewListAfterMove: fromPosition=", " toPosition=");
        Intrinsics.checkNotNullParameter("card_touch_event", "tag");
        Intrinsics.checkNotNullParameter(r20, "msg");
        org.koin.core.a r21 = su.a.f22013b;
        if (r21 == null) goto L76;
        ((b) r21.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).i("card_touch_event", r20);
        if (a(r5) == false) goto L43;
        boolean r112 = b(r10);
        boolean r22 = a(r10);
        int r23 = r10 + 1;
        boolean r24 = b(r23);
        if (r112 == false) goto L36;
        if (r22 == true) goto L36;
        if (r24 == true) goto L36;
        if (r5 >= r10) goto L36;
        r10 = r23;
    L40:
        if (r5 == r10) goto L69;
        r111.add(r10, r111.remove(r5));
    L69:
        if (r111 == null) goto L71;
        r11 = r111;
    L71:
        if (r11 == null) goto L77;
        Function1 r113 = this.e;
        if (r113 == null) goto L77;
        r113.invoke(r11);
    L36:
        if (r112 == true) goto L40;
        if (r22 == true) goto L40;
        if (r5 <= r10) goto L40;
        r10 = r10 - 1;
        goto L40
    L43:
        Iterable r114 = new IntRange(Math.min(r5, r10), Math.max(r5, r10));
        if ((r114 instanceof Collection) == true) goto L46;
    L48:
        Iterator r115 = r114.iterator();
    L50:
        if (r115.hasNext() == false) goto L54;
        if (a(((IntIterator) r115).nextInt()) == false) goto L50;
        r15 = true;
    L54:
        if (r15 == true) goto L56;
    L60:
        if (r15 == true) goto L62;
    L66:
        if (r5 == r10) goto L69;
        r111.add(r10, r111.remove(r5));
        goto L69
    L62:
        if (b(r5) == true) goto L66;
        int r25 = r5 - 1;
        if (b(r25) == false) goto L66;
        c(r111, r25, r5 + 1, r5, r10, null, new CardItemTouchHelperCallback$generateNewListAfterMove$1(r10, this, r111));
        goto L69
    L56:
        if (b(r5) == false) goto L60;
        if (b(r5 + 1) == true) goto L60;
        c(r111, r5, r5 + 2, r5, r10, null, null);
        goto L69
    L46:
        if (((Collection) r114).isEmpty() == false) goto L48;
    L76:
        throw new IllegalStateException("KoinApplication has not been started");
    L79:
        throw new IllegalStateException("KoinApplication has not been started");
    L77:
        return true;
    L81:
        throw new IllegalStateException("KoinApplication has not been started");
    L82:
        String r116 = j0.f(r5, r10, "onMove ignored: fromPosition=", " toPosition=");
        Intrinsics.checkNotNullParameter("card_touch_event", "tag");
        Intrinsics.checkNotNullParameter(r116, "msg");
        org.koin.core.a r117 = su.a.f22013b;
        if (r117 == null) goto L87;
        ((b) r117.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).w("card_touch_event", r116);
        return false;
    L87:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onMoved(RecyclerView r5, RecyclerView.ViewHolder r10, int r11, RecyclerView.ViewHolder r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Intrinsics.checkNotNullParameter(r10, "viewHolder");
        Intrinsics.checkNotNullParameter(r12, "target");
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSelectedChanged(RecyclerView.ViewHolder r10, int r11) {
        String r5 = "onSelectedChanged: " + r10 + " " + r11;
        Intrinsics.checkNotNullParameter("card_touch_event", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L22;
        DragInsertRecyclerView r13 = null;
        ((b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).i("card_touch_event", r5);
        this.g = r10;
        if (r10 != null) goto L7;
    L17:
        if (r10 != null) goto L19;
        this.f20521h = false;
    L19:
        super.onSelectedChanged(r10, r11);
        return;
    L7:
        if (r11 != 2) goto L17;
        c r14 = this.f20520c;
        if (r14 == null) goto L11;
        r14.c(r10);
    L11:
        this.f20522i = r10;
        this.f20521h = false;
        RecyclerView r15 = this.f20519b;
        if ((r15 instanceof DragInsertRecyclerView) == false) goto L14;
        r13 = (DragInsertRecyclerView) r15;
    L14:
        if (r13 == null) goto L17;
        r13.setDragSelectedView(r10.itemView);
        goto L17
    L22:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
    }
}
