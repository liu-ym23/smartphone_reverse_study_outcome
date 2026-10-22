package com.obric.assistant.settings.memory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.settings.ToggleName;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0019\u001a\u001b\u001cB7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricPersonalContextSettingAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/settings/memory/ObricPersonalContextRow;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isObricOS", "", "onLocalDataSearchToggleClick", "Lkotlin/Function1;", "", "onDataSourceItemClick", "Lcom/obric/assistant/settings/ToggleName;", "<init>", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "dataSourceIndex", "Lkotlin/Pair;", "toggleName", "Companion", "CardViewHolder", "BannerViewHolder", "SectionHeaderViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPersonalContextSettingAdapter extends ListAdapter<com.obric.assistant.settings.memory.a, RecyclerView.ViewHolder> {
    public static final ObricPersonalContextSettingAdapter$Companion$diff$1 d = null;
    public final boolean a;
    public final Function1<Boolean, Unit> b;
    public final Function1<ToggleName, Unit> c;

    public static final class a extends RecyclerView.ViewHolder {
        public final ImageView a;

        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131382187);
        }
    }

    public final class b extends RecyclerView.ViewHolder {
        public final OCardListItem a;
        public final /* synthetic */ ObricPersonalContextSettingAdapter b;

        public final void T3() {
            this.a.getTitleView().requestLayout();
            this.a.getSubTitleView().requestLayout();
            this.a.getTitleContainer().requestLayout();
            this.a.requestLayout();
        }

        public b(ObricPersonalContextSettingAdapter r2, OCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.b = r2;
            super(r3);
            this.a = r3;
        }
    }

    public static final class c {
    }

    public static final class d extends RecyclerView.ViewHolder {
        public final TextView a;

        public d(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131368539);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.memory.ObricPersonalContextSettingAdapter$Companion$diff$1] */
    static {
        d = new ObricPersonalContextSettingAdapter$Companion$diff$1();
    }

    public final int getItemViewType(int r2) {
        com.obric.assistant.settings.memory.a r3 = (com.obric.assistant.settings.memory.a) getItem(r2);
        if ((r3 instanceof com.obric.assistant.settings.memory.a.C0023a) == false) goto L6;
        return 0;
    L6:
        if ((r3 instanceof com.obric.assistant.settings.memory.a.c) == false) goto L9;
        return 1;
    L9:
        if ((r3 instanceof com.obric.assistant.settings.memory.a.d) == false) goto L12;
        return 2;
    L12:
        if ((r3 instanceof com.obric.assistant.settings.memory.a.b) == false) goto L16;
        return 3;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        com.obric.assistant.settings.memory.a r13 = (com.obric.assistant.settings.memory.a) getItem(r12);
        Integer r1 = null;
        a r2 = null;
        d r3 = null;
        if ((r13 instanceof com.obric.assistant.settings.memory.a.C0023a) == true) goto L5;
        int r4 = 1;
        if ((r13 instanceof com.obric.assistant.settings.memory.a.c) == false) goto L25;
        if ((r11 instanceof b) == false) goto L14;
        b r14 = (b) r11;
    L15:
        if (r14 == null) goto L91;
        final com.obric.assistant.settings.memory.a.c r15 = (com.obric.assistant.settings.memory.a.c) r13;
        Intrinsics.checkNotNullParameter(r15, "row");
        r14.a.setCardType(0);
        r14.a.p(false);
        r14.a.setTitle(r15.a);
        r14.a.s(true);
        r14.a.q(false);
        r14.a.setDefaultCustomEndView(1);
        r14.a.m(true);
        r14.a.r(false);
        OCardListItem.h(r14.a, 0);
        OCardListItem r0 = r14.a;
        if (r14.b.a == true) goto L20;
        int r5 = rda.a.a;
        rda.a.a(r0, r0.getCardPosition());
    L20:
        OCardListItem r6 = r14.a;
        final ObricPersonalContextSettingAdapter r7 = r14.b;
        r6.setOnContentClickListener(new com.obric.assistant.settings.memory.c(r7, r15));
        OSwitch r8 = r14.a.getEndSwitch();
        if (r8 == null) goto L23;
        final ObricPersonalContextSettingAdapter r9 = r14.b;
        r8.setOnCheckedChangeListener(null);
        r8.setOnTouchListener(new com.obric.assistant.settings.memory.d(r9, r15));
        r8.setChecked(r15.b);
    L23:
        r14.T3();
        return;
    L91:
        return;
    L14:
        r14 = null;
        goto L15
    L25:
        if ((r13 instanceof com.obric.assistant.settings.memory.a.d) == false) goto L32;
        if ((r11 instanceof d) == false) goto L29;
        r3 = (d) r11;
    L29:
        if (r3 == null) goto L93;
        com.obric.assistant.settings.memory.a.d r16 = (com.obric.assistant.settings.memory.a.d) r13;
        Intrinsics.checkNotNullParameter(r16, "row");
        r3.a.setText(r16.a);
        return;
    L93:
        return;
    L32:
        if ((r13 instanceof com.obric.assistant.settings.memory.a.b) == false) goto L81;
        if ((r11 instanceof b) == false) goto L36;
        b r17 = (b) r11;
    L37:
        if (r17 == null) goto L95;
        final com.obric.assistant.settings.memory.a.b r18 = (com.obric.assistant.settings.memory.a.b) r13;
        ToggleName r10 = r18.a;
        List r19 = getCurrentList();
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L40:
        if (r21.hasNext() == false) goto L44;
        Object r22 = r21.next();
        if ((r22 instanceof com.obric.assistant.settings.memory.a.b) == false) goto L40;
        r20.add(r22);
        goto L40
    L44:
        Iterator r23 = r20.iterator();
        int r24 = 0;
    L46:
        if (r23.hasNext() == false) goto L54;
        if (((com.obric.assistant.settings.memory.a.b) r23.next()).a != r10) goto L50;
        boolean r25 = true;
    L51:
        if (r25 == true) goto L55;
        r24 = r24 + 1;
    L55:
        Integer r26 = Integer.valueOf(r24);
        if (r26.intValue() < 0) goto L58;
        boolean r27 = true;
    L59:
        if (r27 == false) goto L61;
        r1 = r26;
    L61:
        if (r1 == null) goto L63;
        int r28 = r1.intValue();
    L64:
        Pair r29 = TuplesKt.to(Integer.valueOf(r28), Integer.valueOf(r20.size()));
        Intrinsics.checkNotNullParameter(r18, "row");
        Intrinsics.checkNotNullParameter(r29, "indexAndCount");
        r17.a.setCardType(0);
        r17.a.p(false);
        r17.a.setTitle(r18.b);
        r17.a.s(true);
        r17.a.q(false);
        r17.a.setDefaultCustomEndView(3);
        r17.a.k(r18.c, -1);
        r17.a.m(true);
        r17.a.setDefaultTailIcon(0);
        r17.a.r(true);
        OCardListItem r30 = r17.a;
        int r31 = ((Number) r29.getFirst()).intValue();
        int r32 = ((Number) r29.getSecond()).intValue();
        if (r32 == 0) goto L73;
        if (r32 == 1) goto L73;
        if (r31 != 0) goto L70;
    L74:
        OCardListItem.h(r30, r4);
        OCardListItem r33 = r17.a;
        if (r17.b.a == true) goto L78;
        int r34 = rda.a.a;
        rda.a.a(r33, r33.getCardPosition());
    L78:
        OCardListItem r35 = r17.a;
        final ObricPersonalContextSettingAdapter r36 = r17.b;
        r35.setOnContentClickListener(new com.obric.assistant.settings.memory.b(r36, r18));
        r17.T3();
        return;
    L70:
        if (r31 != (r32 - 1)) goto L72;
        r4 = 3;
        goto L74
    L72:
        r4 = 2;
    L73:
        r4 = 0;
        goto L74
    L63:
        r28 = 0;
        goto L64
    L58:
        r27 = false;
        goto L59
    L50:
        r25 = false;
        goto L51
    L54:
        r24 = -1;
        goto L55
    L95:
        return;
    L36:
        r17 = null;
        goto L37
    L81:
        throw new NoWhenBranchMatchedException();
    L5:
        if ((r11 instanceof a) == false) goto L7;
        r2 = (a) r11;
    L7:
        if (r2 == null) goto L89;
        r2.a.setImageResource(2131244571);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 != 0) goto L5;
        RecyclerView.ViewHolder r6 = new a(r0.inflate(2131561643, r4, false));
    L15:
        return r6;
    L5:
        if (r5 != 1) goto L7;
    L12:
        OCardListItem r7 = r0.inflate(2131561647, r4, false);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        r6 = new b(this, r7);
        goto L15
    L7:
        if (r5 != 2) goto L9;
        r6 = new d(r0.inflate(2131561644, r4, false));
        goto L15
    L9:
        if (r5 == 3) goto L12;
        final View r8 = new View(r4.getContext());
        return new AnonymousClass1(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricPersonalContextSettingAdapter(boolean r2, Function1<? super Boolean, Unit> r3, Function1<? super ToggleName, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "onLocalDataSearchToggleClick");
        Intrinsics.checkNotNullParameter(r4, "onDataSourceItemClick");
        super(d);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
