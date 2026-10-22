package com.larksuite.component.universe_design.breadcrumb;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020 J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\u001dJ\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\nJ\u0016\u0010(\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\n2\u0006\u0010\"\u001a\u00020 J\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\u001dJ\u0010\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010-\u001a\u00020\u001d2\b\b\u0001\u0010.\u001a\u00020\nJ\u0006\u0010/\u001a\u00020\nJ\"\u00100\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\nH\u0002R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumb;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mInnerItemClickListener", "Lcom/larksuite/component/universe_design/breadcrumb/OnBreadcrumbItemClickListener;", "getMInnerItemClickListener", "()Lcom/larksuite/component/universe_design/breadcrumb/OnBreadcrumbItemClickListener;", "mInnerItemClickListener$delegate", "Lkotlin/Lazy;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mAdapter", "Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbAdapter;", "getMAdapter", "()Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbAdapter;", "mAdapter$delegate", "mItemClickListener", "setItems", "", "items", "", "", "addItem", "item", "removeItems", "index", "count", "removeLastOne", "removeLast", "updateItem", "getItemCount", "scrollToEnd", "setOnItemClickListener", "listener", "setItemMaxWidth", "maxWidth", "getItemMaxWidth", "initAttributes", "set", "onItemClick", "universe-ui-breadcrumb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDBreadcrumb extends FrameLayout {
    public final Lazy a;
    public final RecyclerView b;
    public final Lazy c;
    public a d;

    private final UDBreadcrumbAdapter getMAdapter() {
        return (UDBreadcrumbAdapter) this.c.getValue();
    }

    private final a getMInnerItemClickListener() {
        return (a) this.a.getValue();
    }

    public final int getItemCount() {
        return getMAdapter().getItemCount();
    }

    public final int getItemMaxWidth() {
        return getMAdapter().d;
    }

    public UDBreadcrumb(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ a a(UDBreadcrumb r0) {
        return r0.getMInnerItemClickListener();
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        UDBreadcrumbAdapter r1 = getMAdapter();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "item");
        ((ArrayList) r1.c).add(r3);
        r1.notifyItemInserted(CollectionsKt.getLastIndex(r1.c));
        if (r1.getItemCount() <= 1) goto L5;
        r1.notifyItemChanged(CollectionsKt.getLastIndex(r1.c) - 1);
    L5:
        this.b.scrollToPosition(getMAdapter().getItemCount() - 1);
    }

    public final void c(int r7) {
        if (r7 >= 0) goto L4;
        return;
    L4:
        if (r7 >= getMAdapter().getItemCount()) goto L20;
        UDBreadcrumbAdapter r0 = getMAdapter();
        int r1 = getMAdapter().getItemCount() - r7;
        int r4 = 0;
        if ((r7 + r1) != r0.getItemCount()) goto L9;
        boolean r2 = true;
    L10:
        if (r4 >= r1) goto L12;
        ListProtector.remove(r0.c, r7);
        r4 = r4 + 1;
        goto L10
    L12:
        r0.notifyItemRangeRemoved(r7, r1);
        if (r2 == false) goto L19;
        r0.notifyItemChanged(r0.getItemCount() - 1);
        return;
    L19:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void setItemMaxWidth(int r2) {
        UDBreadcrumbAdapter r0 = getMAdapter();
        r0.d = r2;
        r0.notifyDataSetChanged();
    }

    public final void setItems(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        UDBreadcrumbAdapter r0 = getMAdapter();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "itemList");
        ((ArrayList) r0.c).clear();
        ArrayList r1 = (ArrayList) r0.c;
        r1.addAll(r3);
        r0.notifyDataSetChanged();
    }

    public final void setOnItemClickListener(a r1) {
        this.d = r1;
    }

    public UDBreadcrumb(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public UDBreadcrumb(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7, 2131953822);
        this.a = LazyKt.lazy(new UDBreadcrumb$mInnerItemClickListener$2(this));
        RecyclerView r8 = new RecyclerView(getContext());
        this.b = r8;
        this.c = LazyKt.lazy(new UDBreadcrumb$mAdapter$2(this));
        r8.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r8.setLayoutManager(new LinearLayoutManager(r8.getContext(), 0, false));
        r8.setItemAnimator(null);
        r8.setClipToPadding(false);
        r8.setAdapter(getMAdapter());
        int r1 = d.d(r8.getContext(), 2131169368);
        r8.setPaddingRelative(r1, 0, r1, 0);
        r8.addItemDecoration(new UDBreadcrumbItemDecoration(r8.getContext()));
        addView(r8);
        TypedArray r9 = getContext().obtainStyledAttributes(r6, new int[]{2130974859}, r7, 2131953822);
        int r10 = r9.getDimensionPixelSize(0, -1);
        if (r10 < 0) goto L5;
        UDBreadcrumbAdapter r11 = getMAdapter();
        r11.d = r10;
        r11.notifyDataSetChanged();
    L5:
        r9.recycle();
    }
}
