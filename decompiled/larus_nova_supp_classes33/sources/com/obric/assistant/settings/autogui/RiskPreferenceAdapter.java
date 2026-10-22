package com.obric.assistant.settings.autogui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001b\u001c\u001dB+\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J&\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/settings/autogui/RiskPreferenceAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/settings/autogui/RiskPreferenceRowUiModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemClicked", "Lkotlin/Function1;", "Lcom/obric/assistant/settings/autogui/RiskPreferenceItemUiModel;", "", "isObricOS", "", "bottomHintBottomMarginPx", "", "<init>", "(Lkotlin/jvm/functions/Function1;ZI)V", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "createBottomHintView", "Lcom/obric/oui/text/OTextView;", "Companion", "RiskPreferenceViewHolder", "BottomHintViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RiskPreferenceAdapter extends ListAdapter<v0, RecyclerView.ViewHolder> {
    public static final RiskPreferenceAdapter$Companion$diffCallback$1 d = null;
    public final Function1<u0, Unit> a;
    public final boolean b;
    public final int c;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/assistant/settings/autogui/RiskPreferenceAdapter$BottomHintViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "textView", "Lcom/obric/oui/text/OTextView;", "<init>", "(Lcom/obric/oui/text/OTextView;)V", "bind", "", "item", "Lcom/obric/assistant/settings/autogui/RiskPreferenceRowUiModel$BottomHint;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BottomHintViewHolder extends RecyclerView.ViewHolder {
        public final OTextView a;

        public BottomHintViewHolder(OTextView r2) {
            Intrinsics.checkNotNullParameter(r2, "textView");
            super(r2);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/settings/autogui/RiskPreferenceAdapter$RiskPreferenceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardItem", "Lcom/obric/oui/lisitem/OCardListItem;", "onItemClicked", "Lkotlin/Function1;", "Lcom/obric/assistant/settings/autogui/RiskPreferenceItemUiModel;", "", "isObricOS", "", "<init>", "(Lcom/obric/oui/lisitem/OCardListItem;Lkotlin/jvm/functions/Function1;Z)V", "bind", "item", "bindSelectedState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RiskPreferenceViewHolder extends RecyclerView.ViewHolder {
        public final OCardListItem a;
        public final Function1<u0, Unit> b;
        public final boolean c;

        /* JADX WARN: Multi-variable type inference failed */
        public RiskPreferenceViewHolder(OCardListItem r2, Function1<? super u0, Unit> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "cardItem");
            Intrinsics.checkNotNullParameter(r3, "onItemClicked");
            super(r2);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.autogui.RiskPreferenceAdapter$Companion$diffCallback$1] */
    static {
        d = new RiskPreferenceAdapter$Companion$diffCallback$1();
    }

    public final int getItemViewType(int r2) {
        v0 r3 = (v0) getItem(r2);
        if ((r3 instanceof v0.b) == false) goto L6;
        return 1;
    L6:
        if ((r3 instanceof v0.a) == false) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        v0 r8 = (v0) getItem(r7);
        int r1 = 0;
        BottomHintViewHolder r3 = null;
        final RiskPreferenceViewHolder r4 = null;
        if ((r8 instanceof v0.b) == false) goto L13;
        if ((r6 instanceof RiskPreferenceViewHolder) == false) goto L7;
        r4 = (RiskPreferenceViewHolder) r6;
    L7:
        if (r4 == null) goto L25;
        final u0 r9 = ((v0.b) r8).a;
        Intrinsics.checkNotNullParameter(r9, "item");
        r4.a.setCardType(0);
        r4.a.p(false);
        r4.a.setTitle(r9.b);
        r4.a.s(true);
        r4.a.setSubTitle(r9.c);
        r4.a.q(true ^ StringsKt.isBlank(r9.c));
        OCardListItem.h(r4.a, r9.e);
        if (r4.c == true) goto L11;
        int r10 = rda.a.a;
        rda.a.a(r4.a, r9.e);
    L11:
        r4.a.setDefaultCustomEndView(2);
        Intrinsics.checkNotNullParameter(r9, "item");
        r4.a.m(r9.d);
        r4.a.r(false);
        r4.a.setOnContentClickListener(new t0(r4, r9));
        return;
    L25:
        return;
    L13:
        if ((r8 instanceof v0.a) == false) goto L24;
        if ((r6 instanceof BottomHintViewHolder) == false) goto L17;
        r3 = (BottomHintViewHolder) r6;
    L17:
        if (r3 == null) goto L27;
        v0.a r11 = (v0.a) r8;
        Intrinsics.checkNotNullParameter(r11, "item");
        r3.a.setText(r11.a);
        OTextView r12 = r3.a;
        if (StringsKt.isBlank(r11.a) == false) goto L21;
        r1 = 8;
    L21:
        r12.setVisibility(r1);
        return;
    L27:
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        LayoutInflater r0 = LayoutInflater.from(r6.getContext());
        if (r7 != 1) goto L5;
        OCardListItem r8 = r0.inflate(2131561646, r6, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        RecyclerView.ViewHolder r9 = new RiskPreferenceViewHolder(r8, this.a, this.b);
    L10:
        return r9;
    L5:
        if (r7 == 2) goto L7;
        final View r10 = new View(r6.getContext());
        return new AnonymousClass1(r10);
    L7:
        OTextView r1 = new OTextView(r6.getContext(), null, 0, 14);
        RecyclerView.LayoutParams r11 = new RecyclerView.LayoutParams(-1, -2);
        r11.setMargins(0, c7.b(8), 0, this.c);
        r1.setLayoutParams(r11);
        r1.setMaxLines(5);
        r1.setPaddingRelative(c7.b(32), 0, c7.b(32), 0);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), v19.c.b(2130972081, r1.getContext(), 2131103143)));
        r1.setTextSize(2, 12.0f);
        r9 = new BottomHintViewHolder(r1);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RiskPreferenceAdapter(Function1<? super u0, Unit> r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "onItemClicked");
        super(d);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List<Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.contains("payload_selected_changed") == false) goto L15;
        Object r0 = getItem(r5);
        RiskPreferenceViewHolder r2 = null;
        if ((r0 instanceof v0.b) == false) goto L7;
        v0.b r1 = (v0.b) r0;
    L9:
        if ((r4 instanceof RiskPreferenceViewHolder) == false) goto L11;
        r2 = (RiskPreferenceViewHolder) r4;
    L11:
        if (r1 == null) goto L15;
        if (r2 == null) goto L15;
        u0 r7 = r1.a;
        Intrinsics.checkNotNullParameter(r7, "item");
        r2.a.m(r7.d);
        return;
    L7:
        r1 = null;
    L15:
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onBindViewHolder(r4, r5, r6);
    }
}
