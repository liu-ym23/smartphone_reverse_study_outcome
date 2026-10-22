package com.larus.dora.o.impl.memory;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004#$%&B=\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0016\u0010\u0015\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0007J\u0006\u0010\u0017\u001a\u00020\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0019H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/o/impl/memory/OMemoryPersonalAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onAddClick", "Lkotlin/Function0;", "", "onEditClick", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/memory/OPersonalMemoryEntry;", "onDeleteClick", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "entries", "", "placeholderTexts", "", "", "openedSwipe", "Lcom/obric/oui/lisitem/OCardListItem;", "setPlaceholders", "texts", "setEntries", "newEntries", "closeOpenedSwipe", "placeholderCount", "", "getItemCount", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "HeaderHolder", "EntryHolder", "PlaceholderHolder", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OMemoryPersonalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Function0<Unit> a;
    public final Function1<o0, Unit> b;
    public final Function1<o0, Unit> c;
    public final List<o0> d;
    public List<String> e;
    public OCardListItem f;

    public static final class a {
    }

    public final class b extends RecyclerView.ViewHolder {
        public final OCardListItem a;
        public o0 b;

        public static final class a extends com.obric.oui.swipeaction.b {
            public final /* synthetic */ OMemoryPersonalAdapter a;
            public final /* synthetic */ b b;

            public final void onClose() {
                b r0 = this.b;
                OCardListItem r1 = r0.a;
                OStateGradientDrawable r2 = r1.g;
                if (r2 == null) goto L6;
                r2.setSolidColors(r1.getContentContainerBgColor());
            L6:
                r0.a.getContentContainer().setSelected(false);
            }

            public final void c(OSwipeLayout r2) {
                Intrinsics.checkNotNullParameter(r2, "layout");
                OCardListItem r3 = this.a.f;
                if (r3 == this.b.a) goto L6;
                if (r3 == null) goto L6;
                r3.t();
            L6:
                OMemoryPersonalAdapter r4 = this.a;
                r4.f = this.b.a;
            }

            public a(OMemoryPersonalAdapter r1, b r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public b(final OMemoryPersonalAdapter r4, View r5) {
            Intrinsics.checkNotNullParameter(r5, "view");
            super(r5);
            OCardListItem r6 = (OCardListItem) r5;
            this.a = r6;
            ColorStateList r0 = ContextCompat.getColorStateList(r6.getContext(), 2131101350);
            if (r0 != null) goto L5;
            r0 = ColorStateList.valueOf(ContextCompat.getColor(r6.getContext(), 2131101350));
        L5:
            r6.setContentContainerBgColor(r0);
            r6.getContentContainer().setForeground(ContextCompat.getDrawable(r6.getContext(), 2131233947));
            u69.b.a(r6, 20);
            OTextView r1 = r6.getTitleView();
            r1.setMaxLines(Integer.MAX_VALUE);
            r1.setEllipsize(null);
            r6.setSwipeView(2131560167);
            OSwipeLayout r2 = r6.getSwipeLayout();
            a r3 = new a(r4, this);
            ((ArrayList) r2.p).add(r3);
            View r7 = r6.getSwipeView();
            if (r7 == null) goto L10;
            ImageView r8 = (ImageView) r7.findViewById(2131387509);
            if (r8 == null) goto L10;
            r8.setOnClickListener(new c0(r4, this));
        L10:
            View r9 = r6.getSwipeView();
            if (r9 == null) goto L15;
            ImageView r10 = (ImageView) r9.findViewById(2131387508);
            if (r10 == null) goto L15;
            r10.setOnClickListener(new d0(r4, this));
        L15:
            r6.setOnContentClickListener(new e0(this, r4));
        }
    }

    public final class c extends RecyclerView.ViewHolder {
        public final TextView a;
        public final OSectionTitleBar b;
        public final /* synthetic */ OMemoryPersonalAdapter c;

        public c(OMemoryPersonalAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.c = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131379879);
            this.b = r3.findViewById(2131379882);
        }
    }

    public static final class d extends RecyclerView.ViewHolder {
        public final TextView a;

        public d(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131379887);
        }
    }

    static {
    }

    public final int getItemCount() {
        int r1 = 1;
        int r0 = ((ArrayList) this.d).size() + 1;
        if (((ArrayList) this.d).isEmpty() == true) goto L5;
    L7:
        r1 = 0;
    L9:
        return r0 + r1;
    L5:
        if ((!this.e.isEmpty()) == false) goto L7;
        goto L7
    }

    public final void y2() {
        OCardListItem r0 = this.f;
        if (r0 == null) goto L5;
        r0.t();
    L5:
        this.f = null;
    }

    public final int getItemViewType(int r2) {
        if (r2 != 0) goto L5;
        return 0;
    L5:
        if (r2 > ((ArrayList) this.d).size()) goto L7;
        return 1;
    L7:
        return 2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        if ((r10 instanceof c) == false) goto L6;
        c r12 = (c) r10;
        r12.b.setTitleText(((RecyclerView.ViewHolder) r12).itemView.getContext().getString(2131903462));
        r12.b.setTitleTextSize(12.0f);
        TextView r13 = r12.a;
        final OMemoryPersonalAdapter r14 = r12.c;
        r13.setOnClickListener(new f0(r14));
        return;
    L6:
        if ((r10 instanceof b) == false) goto L16;
        b r15 = (b) r10;
        o0 r16 = (o0) ListProtector.get(this.d, r11 - 1);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "entry");
        r15.b = r16;
        r15.a.t();
        OCardListItem r0 = r15.a;
        OStateGradientDrawable r2 = r0.g;
        if (r2 == null) goto L11;
        r2.setSolidColors(r0.getContentContainerBgColor());
    L11:
        r15.a.getContentContainer().setSelected(false);
        r15.a.setEnableSwipe(true);
        OCardListItem r1 = r15.a;
        String r17 = r16.a();
        if (r17 != null) goto L14;
        r17 = "";
    L14:
        r1.setTitle(r17);
        r15.a.s(true);
        return;
    L16:
        if ((r10 instanceof d) == false) goto L21;
        d r18 = (d) r10;
        List<String> r110 = this.e;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r110, "hints");
        r18.a.setText(CollectionsKt.joinToString$default(r110, "\n", null, null, 0, null, null, 62, null));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 == 0) goto L9;
        if (r5 == 2) goto L11;
        return new b(this, r0.inflate(2131560156, r4, false));
    L11:
        return new d(r0.inflate(2131560158, r4, false));
    L9:
        return new c(this, r0.inflate(2131560157, r4, false));
    }

    public OMemoryPersonalAdapter(g0 r2, h0 r3, i0 r4) {
        Intrinsics.checkNotNullParameter(r2, "onAddClick");
        Intrinsics.checkNotNullParameter(r3, "onEditClick");
        Intrinsics.checkNotNullParameter(r4, "onDeleteClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new ArrayList();
        this.e = CollectionsKt.emptyList();
    }
}
