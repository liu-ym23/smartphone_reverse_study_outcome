package com.larus.dora.o.impl.diary.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.swipeaction.OSwipeLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0015\u0016\u0017BC\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/o/impl/diary/style/ODiaryStyleAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$StyleUiItem;", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleAdapter$StyleViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "onEditClick", "onDeleteClick", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "openedItem", "Lcom/obric/oui/lisitem/OCardListItem;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "Companion", "StyleViewHolder", "DiffCallback", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryStyleAdapter extends ListAdapter<ODiaryStyleViewModel.d, StyleViewHolder> {
    public static final /* synthetic */ int e = 0;
    public final Function1<ODiaryStyleViewModel.d, Unit> a;
    public final Function1<ODiaryStyleViewModel.d, Unit> b;
    public final Function1<ODiaryStyleViewModel.d, Unit> c;
    public OCardListItem d;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/o/impl/diary/style/ODiaryStyleAdapter$StyleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "card", "Lcom/obric/oui/lisitem/OCardListItem;", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$StyleUiItem;", "", "onEditClick", "onDeleteClick", "onSwipeOpened", "<init>", "(Lcom/obric/oui/lisitem/OCardListItem;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "boundItem", "bind", "item", "cardPosition", "", "restoreContentColor", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StyleViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int g = 0;
        public final OCardListItem a;
        public final Function1<ODiaryStyleViewModel.d, Unit> b;
        public final Function1<ODiaryStyleViewModel.d, Unit> c;
        public final Function1<ODiaryStyleViewModel.d, Unit> d;
        public final Function1<OCardListItem, Unit> e;
        public ODiaryStyleViewModel.d f;

        public StyleViewHolder(OCardListItem r2, Function1 r3, Function1 r4, Function1 r5, com.larus.dora.o.impl.diary.style.a r6) {
            Intrinsics.checkNotNullParameter(r2, "card");
            Intrinsics.checkNotNullParameter(r3, "onItemClick");
            Intrinsics.checkNotNullParameter(r4, "onEditClick");
            Intrinsics.checkNotNullParameter(r5, "onDeleteClick");
            Intrinsics.checkNotNullParameter(r6, "onSwipeOpened");
            super(r2);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            ColorStateList r7 = ContextCompat.getColorStateList(r2.getContext(), 2131101350);
            if (r7 != null) goto L5;
            r7 = ColorStateList.valueOf(ContextCompat.getColor(r2.getContext(), 2131101350));
        L5:
            r2.setContentContainerBgColor(r7);
            r2.getContentContainer().setForeground(ContextCompat.getDrawable(r2.getContext(), 2131233947));
            u69.b.a(r2, 20);
            Resources r8 = r2.getResources();
            int r9 = (int) ((WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density * 8) + 0.5f);
            OUICardConstraintLayout r10 = r2.getContentContainer();
            r10.setPaddingRelative(r10.getPaddingStart(), r9, r10.getPaddingEnd(), r9);
            LinearLayout r11 = r2.getTitleContainer();
            r11.setPaddingRelative(r11.getPaddingStart(), r11.getPaddingTop(), r9, r11.getPaddingBottom());
            LinearLayout r12 = r2.getTitleContainer();
            Resources r13 = r2.getResources();
            r12.setMinimumWidth(WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).widthPixels);
            r2.getTitleView().setMaxLines(1);
            View r14 = r2.findViewById(2131368384);
            if (r14 == null) goto L13;
            ViewGroup.LayoutParams r15 = r14.getLayoutParams();
            if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
            ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        L11:
            if (r16 == null) goto L13;
            r16.setMarginEnd(r16.getMarginEnd() + r9);
            r14.setLayoutParams(r16);
            goto L13
        L10:
            r16 = null;
        L13:
            r2.setSwipeView(2131560167);
            OSwipeLayout r17 = r2.getSwipeLayout();
            ((ArrayList) r17.p).add(new e(this));
            View r18 = r2.getSwipeView();
            if (r18 == null) goto L18;
            ImageView r20 = (ImageView) r18.findViewById(2131387509);
            if (r20 == null) goto L18;
            r20.setOnClickListener(new com.larus.dora.o.impl.diary.style.b(this));
        L18:
            View r21 = r2.getSwipeView();
            if (r21 == null) goto L23;
            ImageView r22 = (ImageView) r21.findViewById(2131387508);
            if (r22 == null) goto L23;
            r22.setOnClickListener(new c(this));
        L23:
            r2.setOnContentClickListener(new d(this));
        }
    }

    public static final class a {
    }

    public static final class b extends DiffUtil.ItemCallback<ODiaryStyleViewModel.d> {
        public b() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            ODiaryStyleViewModel.d r4 = (ODiaryStyleViewModel.d) r2;
            ODiaryStyleViewModel.d r5 = (ODiaryStyleViewModel.d) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            ODiaryStyleViewModel.d r4 = (ODiaryStyleViewModel.d) r2;
            ODiaryStyleViewModel.d r5 = (ODiaryStyleViewModel.d) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.a, r5.a);
        }
    }

    static {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        StyleViewHolder r12 = (StyleViewHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        ODiaryStyleViewModel.d r13 = (ODiaryStyleViewModel.d) getItem(r11);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "item");
        r12.f = r13;
        Context r0 = r12.a.getContext();
        OCardListItem.h(r12.a, 0);
        String r1 = r0.getString(2131903897);
        boolean r4 = true;
        if (r13.f == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        OCardListItem r3 = r12.a;
        if (r2 == false) goto L11;
        SpannableStringBuilder r5 = new SpannableStringBuilder(r13.b);
        String r6 = "  " + r0.getString(2131903896);
        int r7 = r5.length();
        r5.append(r6);
        Resources r8 = r0.getResources();
        r5.setSpan(new AbsoluteSizeSpan((int) TypedValue.applyDimension(2, 11.0f, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()))), r7, r5.length(), 33);
        r5.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r0, 2131101369)), r7, r5.length(), 33);
        CharSequence r9 = r5;
    L12:
        r3.setTitle(r9);
        OCardListItem r14 = r12.a;
        if (r13.b.length() <= 0) goto L15;
        boolean r15 = true;
    L16:
        r14.s(r15);
        r12.a.setSubTitle(r13.c);
        OCardListItem r16 = r12.a;
        if (r13.c.length() > 0) goto L20;
        r4 = false;
    L20:
        r16.q(r4);
        r12.a.m(r13.e);
        r12.a.setEnableSwipe(r13.f);
        r12.a.t();
        OCardListItem r17 = r12.a;
        OStateGradientDrawable r18 = r17.g;
        if (r18 == null) goto L24;
        r18.setSolidColors(r17.getContentContainerBgColor());
    L24:
        r12.a.getContentContainer().setSelected(false);
        return;
    L15:
        r15 = false;
        goto L16
    L11:
        r9 = r13.b;
        goto L12
    L5:
        if (StringsKt.startsWith$default(StringsKt.trim(r13.b).toString(), r1, false, 2, null) == true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.dora.o.impl.diary.style.a] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        OCardListItem r9 = LayoutInflater.from(r7.getContext()).inflate(2131560152, r7, false);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        return new StyleViewHolder(r9, this.a, this.b, this.c, new com.larus.dora.o.impl.diary.style.a(this));
    }

    public ODiaryStyleAdapter(o r2, p r3, q r4) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        Intrinsics.checkNotNullParameter(r3, "onEditClick");
        Intrinsics.checkNotNullParameter(r4, "onDeleteClick");
        super(new b());
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
