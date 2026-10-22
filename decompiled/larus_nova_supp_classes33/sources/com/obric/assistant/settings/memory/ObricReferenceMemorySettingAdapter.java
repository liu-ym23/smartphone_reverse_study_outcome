package com.obric.assistant.settings.memory;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0019\u001aB)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J*\u0010\u0010\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryRow;", "Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingAdapter$CardViewHolder;", "isObricOS", "", "onSwitchChanged", "Lkotlin/Function2;", "", "<init>", "(ZLkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "payloads", "", "", "switchIndex", "Lkotlin/Pair;", "row", "Companion", "CardViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricReferenceMemorySettingAdapter extends ListAdapter<y, CardViewHolder> {
    public static final ObricReferenceMemorySettingAdapter$Companion$diff$1 c = null;
    public final boolean a;
    public final Function2<y, Boolean, Unit> b;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\f\u0010\u0017\u001a\u00020\f*\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingAdapter$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Lcom/obric/oui/lisitem/OCardListItem;", "<init>", "(Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingAdapter;Lcom/obric/oui/lisitem/OCardListItem;)V", "bind", "", "row", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryRow;", "indexAndCount", "Lkotlin/Pair;", "", "bindSwitchState", "resolveCardPosition", "index", "count", "applyCardStyle", "applyEnabledStyle", "enabled", "", "stabilizeCardLayout", "applyGroupSpacing", "dp", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CardViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final OCardListItem a;
        public final /* synthetic */ ObricReferenceMemorySettingAdapter b;

        public final void T3(final y r6) {
            Intrinsics.checkNotNullParameter(r6, "row");
            OCardListItem r0 = this.a;
            float r2 = 1.0f;
            if (r6.e == false) goto L5;
            float r1 = 1.0f;
        L6:
            r0.getTitleView().setAlpha(r1);
            r0.getSubTitleView().setAlpha(r1);
            OSwitch r3 = this.a.getEndSwitch();
            if (r3 == null) goto L14;
            final ObricReferenceMemorySettingAdapter r4 = this.b;
            r3.setOnCheckedChangeListener(null);
            r3.setEnabled(r6.e);
            if (r6.e == true) goto L12;
            r2 = 0.4f;
        L12:
            r3.setAlpha(r2);
            r3.setChecked(r6.d);
            r3.setOnCheckedChangeListener(new a0(r6, r4));
            return;
        L14:
            return;
        L5:
            r1 = 0.4f;
            goto L6
        }

        public CardViewHolder(ObricReferenceMemorySettingAdapter r2, OCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.b = r2;
            super(r3);
            this.a = r3;
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.memory.ObricReferenceMemorySettingAdapter$Companion$diff$1] */
    static {
        c = new ObricReferenceMemorySettingAdapter$Companion$diff$1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricReferenceMemorySettingAdapter(boolean r2, Function2<? super y, ? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onSwitchChanged");
        super(c);
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        CardViewHolder r10 = (CardViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        y r11 = (y) getItem(r9);
        Intrinsics.checkNotNull(r11);
        List r0 = getCurrentList();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L3:
        int r3 = 1;
        int r4 = 0;
        if (r2.hasNext() == false) goto L11;
        Object r5 = r2.next();
        if (((y) r5).f == r11.f) goto L9;
        r3 = 0;
    L9:
        if (r3 == 0) goto L3;
        r1.add(r5);
        goto L3
    L11:
        Iterator r6 = r1.iterator();
        int r7 = 0;
    L13:
        if (r6.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((y) r6.next()).a, r11.a) == true) goto L19;
        r7 = r7 + 1;
    L19:
        Integer r12 = Integer.valueOf(r7);
        if (r12.intValue() < 0) goto L22;
        boolean r13 = true;
    L23:
        ViewGroup.MarginLayoutParams r14 = null;
        if (r13 == true) goto L27;
        r12 = null;
    L27:
        if (r12 == null) goto L29;
        int r15 = r12.intValue();
    L30:
        Pair r16 = TuplesKt.to(Integer.valueOf(r15), Integer.valueOf(r1.size()));
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "row");
        Intrinsics.checkNotNullParameter(r16, "indexAndCount");
        r10.a.setCardType(0);
        r10.a.p(false);
        r10.a.setTitle(r11.b);
        r10.a.s(true);
        r10.a.setSubTitle(r11.c);
        OCardListItem r17 = r10.a;
        if (r11.c.length() <= 0) goto L33;
        boolean r18 = true;
    L34:
        r17.q(r18);
        r10.a.setDefaultCustomEndView(1);
        r10.a.m(true);
        r10.a.r(false);
        OCardListItem r19 = r10.a;
        int r20 = ((Number) r16.getFirst()).intValue();
        int r21 = ((Number) r16.getSecond()).intValue();
        if (r21 == 0) goto L43;
        if (r21 == 1) goto L43;
        if (r20 != 0) goto L40;
    L44:
        OCardListItem.h(r19, r3);
        OCardListItem r22 = r10.a;
        int r23 = ((Number) r16.getFirst()).intValue();
        if (r11.f != ObricReferenceMemorySwitchGroup.CHILD) goto L48;
        if (r23 != 0) goto L48;
        Resources r24 = r10.a.getResources();
        r4 = (int) ((16 * WindowDisplayMetricsOverride.apply(r24, r24.getDisplayMetrics()).density) + 0.5f);
    L48:
        ViewGroup.LayoutParams r25 = r22.getLayoutParams();
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L51;
        r14 = (ViewGroup.MarginLayoutParams) r25;
    L51:
        if (r14 != null) goto L53;
    L55:
        OCardListItem r26 = r10.a;
        if (r10.b.a == true) goto L59;
        int r27 = rda.a.a;
        rda.a.a(r26, r26.getCardPosition());
    L59:
        r10.a.setOnContentClickListener(new z());
        r10.T3(r11);
        r10.a.getTitleView().requestLayout();
        r10.a.getSubTitleView().requestLayout();
        r10.a.getTitleContainer().requestLayout();
        r10.a.requestLayout();
        return;
    L53:
        if (r14.topMargin == r4) goto L55;
        r14.topMargin = r4;
        r22.setLayoutParams(r14);
        goto L55
    L40:
        if (r20 != (r21 - 1)) goto L42;
        r3 = 3;
        goto L44
    L42:
        r3 = 2;
    L43:
        r3 = 0;
        goto L44
    L33:
        r18 = false;
        goto L34
    L29:
        r15 = 0;
        goto L30
    L22:
        r13 = false;
        goto L23
    L18:
        r7 = -1;
        goto L19
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        OCardListItem r6 = LayoutInflater.from(r4.getContext()).inflate(2131561647, r4, false);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        return new CardViewHolder(this, r6);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        CardViewHolder r5 = (CardViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.contains("payload_switch_state_changed") == false) goto L5;
        r5.T3((y) getItem(r3));
        return;
    L5:
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onBindViewHolder(r5, r3, r4);
    }
}
