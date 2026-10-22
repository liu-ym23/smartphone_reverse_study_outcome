package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\t !\"#$%&'(B/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationReviewPageAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/cocreationreview/PageItem;", "Lcom/obric/assistant/cocreationreview/CocreationReviewPageAdapter$PageItemViewHolder;", "renderPageItem", "Lkotlin/Function1;", "Landroid/view/View;", "onModuleTabClick", "Lcom/obric/assistant/cocreationreview/ModuleTabState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "cardViewCache", "Lcom/obric/assistant/cocreationreview/CocreationCardViewCache;", "sharedImageRowPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getItemViewType", NameKeys.UnloadStrategy_No_Strategy, "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "cardViewFor", "item", "applySharedImageRowPool", "view", "pageItemContainer", "Landroid/widget/FrameLayout;", "moduleTabsContainer", "PageItemViewHolder", "DefaultPageItemViewHolder", "ModuleTabsViewHolder", "ModuleTabAdapter", "ModuleTabViewHolder", "PageItemViewType", "PageItemDiffCallback", "ModuleTabDiffCallback", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationReviewPageAdapter extends ListAdapter<q5, PageItemViewHolder> {
    public final Function1<q5, View> a;
    public final Function1<p5, Unit> b;
    public final CocreationCardViewCache<View> c;
    public final RecyclerView.RecycledViewPool d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationReviewPageAdapter$PageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class PageItemViewHolder extends RecyclerView.ViewHolder {
        public PageItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationReviewPageAdapter$PageItemViewType;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "MODULE_TABS", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PageItemViewType extends Enum<PageItemViewType> {
        public static final PageItemViewType DEFAULT = null;
        public static final PageItemViewType MODULE_TABS = null;
        public static final /* synthetic */ PageItemViewType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PageItemViewType> getEntries() {
            return b;
        }

        static {
            PageItemViewType r0 = new PageItemViewType("DEFAULT", 0);
            DEFAULT = r0;
            PageItemViewType r1 = new PageItemViewType("MODULE_TABS", 1);
            MODULE_TABS = r1;
            PageItemViewType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static PageItemViewType[] values() {
            return (PageItemViewType[]) a.clone();
        }

        public static PageItemViewType valueOf(String r1) {
            return (PageItemViewType) r27.a.a(PageItemViewType.class, r1);
        }

        public PageItemViewType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b extends PageItemViewHolder {
        public final FrameLayout a;

        public b(FrameLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            super(r2);
            this.a = r2;
        }
    }

    public static final class c extends ListAdapter<p5, e> {
        public final Function1<p5, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super p5, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "onTabClick");
            super(new d());
            this.a = r2;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
            final e r11 = (e) r9;
            Intrinsics.checkNotNullParameter(r11, "holder");
            final p5 r12 = (p5) getItem(r10);
            r11.getClass();
            Intrinsics.checkNotNullParameter(r12, "tab");
            r11.d.setText(r12.b);
            TextView r0 = r11.d;
            int r2 = -9735552;
            if (r12.f == false) goto L5;
            int r1 = r12.g;
        L6:
            r0.setTextColor(r1);
            if (r12.d != null) goto L9;
            boolean r3 = true;
        L10:
            r11.e.setText(String.valueOf(r12.e));
            TextView r4 = r11.e;
            if (r3 == true) goto L14;
            r2 = r12.g;
        L14:
            r4.setTextColor(r2);
            TextView r5 = r11.e;
            Context r6 = r11.a.getContext();
            if (r12.d != null) goto L17;
            int r7 = -1;
        L18:
            if (r3 == false) goto L20;
            int r8 = -1973274;
        L21:
            r5.setBackground(c4.h(r6, r7, 13, r8, 1));
            r11.c.setImageResource(r12.c);
            if (r12.f == false) goto L24;
            r11.b.setVisibility(0);
            r11.b.setBackground(c4.h(r11.a.getContext(), r12.g, 24, 0, 0));
            r11.c.setColorFilter(-1);
        L25:
            r11.c.setContentDescription(r12.b);
            r11.a.setOnClickListener(new u3(r11, r12));
            return;
        L24:
            r11.b.setVisibility(8);
            r11.b.setBackground(null);
            r11.c.clearColorFilter();
            goto L25
        L20:
            r8 = e.T3(r12.g, 0.58f);
            goto L21
        L17:
            r7 = e.T3(r12.g, 0.86f);
            goto L18
        L9:
            r3 = false;
            goto L10
        L5:
            r1 = -9735552;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r17, int r18) {
            Intrinsics.checkNotNullParameter(r17, "parent");
            LinearLayout r2 = c4.k(r17.getContext());
            r2.setGravity(49);
            r2.setMinimumHeight(c4.c(r2.getContext(), 88));
            r2.setClickable(true);
            r2.setFocusable(true);
            r2.setClipChildren(false);
            r2.setClipToPadding(false);
            RecyclerView.LayoutParams r5 = new RecyclerView.LayoutParams(c4.c(r2.getContext(), 82), c4.c(r2.getContext(), 88));
            r5.setMargins(0, 0, c4.c(r2.getContext(), 8), 0);
            r2.setLayoutParams(r5);
            FrameLayout r3 = new FrameLayout(r17.getContext());
            r3.setClipChildren(false);
            r3.setClipToPadding(false);
            View r6 = new View(r17.getContext());
            r6.setVisibility(8);
            int r7 = c4.c(r17.getContext(), 48);
            r3.addView(r6, new FrameLayout.LayoutParams(r7, r7, 17));
            ImageView r8 = new ImageView(r17.getContext());
            r8.setScaleType(ImageView.ScaleType.FIT_CENTER);
            r3.addView(r8, new FrameLayout.LayoutParams(c4.c(r17.getContext(), 60), c4.c(r17.getContext(), 60), 17));
            TextView r9 = c4.f(r17.getContext(), NameKeys.UnloadStrategy_No_Strategy, 12.0f, -9735552, 1);
            r9.setGravity(17);
            r9.setIncludeFontPadding(false);
            r9.setMaxLines(1);
            FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(c4.c(r17.getContext(), 26), c4.c(r17.getContext(), 26), 8388661);
            r12.topMargin = c4.c(r17.getContext(), 2);
            Unit r13 = Unit.INSTANCE;
            r3.addView(r9, r12);
            r2.addView(r3, new LinearLayout.LayoutParams(c4.c(r17.getContext(), 68), c4.c(r17.getContext(), 68)));
            TextView r10 = c4.f(r17.getContext(), NameKeys.UnloadStrategy_No_Strategy, 12.0f, -9735552, 1);
            r10.setGravity(17);
            r10.setMaxLines(1);
            LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(c4.c(r17.getContext(), 80), -2);
            r0.setMargins(0, c4.c(r17.getContext(), 4), 0, 0);
            r2.addView(r10, r0);
            return new e(r2, r6, r8, r10, r9, this.a);
        }
    }

    public static final class d extends DiffUtil.ItemCallback<p5> {
        public d() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            p5 r4 = (p5) r2;
            p5 r5 = (p5) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            p5 r4 = (p5) r2;
            p5 r5 = (p5) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.a, r5.a);
        }
    }

    public static final class e extends RecyclerView.ViewHolder {
        public final ViewGroup a;
        public final View b;
        public final ImageView c;
        public final TextView d;
        public final TextView e;
        public final Function1<p5, Unit> f;

        public static int T3(int r3, float r4) {
            float r0 = 1.0f - r4;
            float r2 = 255 * r4;
            return Color.rgb((int) ((Color.red(r3) * r0) + r2), (int) ((Color.green(r3) * r0) + r2), (int) ((Color.blue(r3) * r0) + r2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(ViewGroup r2, View r3, ImageView r4, TextView r5, TextView r6, Function1<? super p5, Unit> r7) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "selectedIconFill");
            Intrinsics.checkNotNullParameter(r4, "icon");
            Intrinsics.checkNotNullParameter(r5, "label");
            Intrinsics.checkNotNullParameter(r6, "countBadge");
            Intrinsics.checkNotNullParameter(r7, "onTabClick");
            super(r2);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public final class f extends PageItemViewHolder {
        public final FrameLayout a;
        public final c b;

        public f(CocreationReviewPageAdapter r5, FrameLayout r6) {
            Intrinsics.checkNotNullParameter(r6, "container");
            super(r6);
            this.a = r6;
            c r0 = new c(r5.b);
            this.b = r0;
            RecyclerView r7 = new RecyclerView(r6.getContext());
            r7.setLayoutManager(new LinearLayoutManager(r6.getContext(), 0, false));
            r7.setAdapter(r0);
            r7.setOverScrollMode(2);
            r7.setHorizontalScrollBarEnabled(false);
            r7.setItemAnimator(null);
            r7.setClipChildren(false);
            r7.setClipToPadding(false);
            r6.addView(r7, new FrameLayout.LayoutParams(-1, c4.c(r6.getContext(), 88)));
        }
    }

    public static final class g extends DiffUtil.ItemCallback<q5> {
        public g() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            q5 r4 = (q5) r2;
            q5 r5 = (q5) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            q5 r4 = (q5) r2;
            q5 r5 = (q5) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.a, r5.a);
        }
    }

    public /* synthetic */ class h {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PageItemViewType.values().length];
            r0[PageItemViewType.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PageItemViewType.MODULE_TABS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final int getItemViewType(int r1) {
        if ((((q5) getItem(r1)) instanceof q5.c) == false) goto L6;
        return PageItemViewType.MODULE_TABS.ordinal();
    L6:
        return PageItemViewType.DEFAULT.ordinal();
    }

    public final void y2(View r4) {
        if ((r4 instanceof RecyclerView) == false) goto L8;
        RecyclerView r0 = (RecyclerView) r4;
        if ((r0.getLayoutManager() instanceof LinearLayoutManager) == false) goto L8;
        r0.setRecycledViewPool(this.d);
    L8:
        if ((r4 instanceof ViewGroup) == false) goto L12;
        ViewGroup r5 = (ViewGroup) r4;
        int r1 = r5.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L14;
        y2(r5.getChildAt(r2));
        r2 = r2 + 1;
        goto L10
    L14:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CocreationReviewPageAdapter(Function1<? super q5, ? extends View> r2, Function1<? super p5, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "renderPageItem");
        Intrinsics.checkNotNullParameter(r3, "onModuleTabClick");
        super(new g());
        this.a = r2;
        this.b = r3;
        this.c = new CocreationCardViewCache();
        this.d = new RecyclerView.RecycledViewPool();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        PageItemViewHolder r9 = (PageItemViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        q5 r10 = (q5) getItem(r8);
        if ((r10 instanceof q5.c) == false) goto L5;
        f r11 = (f) r9;
        q5.c r12 = (q5.c) r10;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "item");
        r11.b.submitList(r12.b);
        return;
    L5:
        b r13 = (b) r9;
        Intrinsics.checkNotNull(r10);
        ViewGroup r3 = null;
        if ((r10 instanceof q5.f) == false) goto L8;
        View r0 = (View) this.a.invoke(r10);
    L21:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "view");
        boolean r14 = !(r10 instanceof q5.b);
        r13.a.setClipChildren(r14);
        r13.a.setClipToPadding(r14);
        if (r13.a.getChildCount() == 1) goto L24;
    L26:
        r13.a.removeAllViews();
        ViewParent r15 = r0.getParent();
        if ((r15 instanceof ViewGroup) == false) goto L29;
        r3 = (ViewGroup) r15;
    L29:
        if (r3 == null) goto L31;
        r3.removeView(r0);
    L31:
        r13.a.addView(r0, new FrameLayout.LayoutParams(-1, -2));
        return;
    L24:
        if (r13.a.getChildAt(0) != r0) goto L26;
        return;
    L8:
        CocreationCardViewCache<View> r1 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        CocreationCardViewCache.a<View> r2 = r1.a.get(r10.a);
        if (r2 != null) goto L11;
    L16:
        View r4 = null;
    L17:
        r0 = r4;
        if (r0 != null) goto L21;
        r0 = (View) this.a.invoke(r10);
        y2(r0);
        CocreationCardViewCache<View> r5 = this.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r0, "view");
        r5.a.put(r10.a, new CocreationCardViewCache.a(r10, r0));
        goto L21
    L11:
        if (Intrinsics.areEqual(r2.a, r10) == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L16;
        r4 = r2.b;
        goto L17
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        PageItemViewType r10 = PageItemViewType.values()[r9];
        int r11 = h.a[r10.ordinal()];
        if (r11 != 1) goto L5;
        FrameLayout r0 = new FrameLayout(r8.getContext());
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new b(r0);
    L5:
        if (r11 != 2) goto L8;
        FrameLayout r1 = new FrameLayout(r8.getContext());
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        r1.setPadding(c4.c(r8.getContext(), 14), 0, c4.c(r8.getContext(), 14), c4.c(r8.getContext(), 10));
        r1.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new f(this, r1);
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
