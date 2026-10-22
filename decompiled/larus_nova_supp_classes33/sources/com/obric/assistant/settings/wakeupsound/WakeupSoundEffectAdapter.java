package com.obric.assistant.settings.wakeupsound;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.obric.oui.lisitem.OCardListItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0017\u0018B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectRowUiModel;", "Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectAdapter$WakeupSoundEffectViewHolder;", "onItemClicked", "Lkotlin/Function1;", "Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectItemUiModel;", "", "isObricOS", "", "<init>", "(Lkotlin/jvm/functions/Function1;Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "payloads", "", "", "Companion", "WakeupSoundEffectViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupSoundEffectAdapter extends ListAdapter<h, WakeupSoundEffectViewHolder> {
    public static final WakeupSoundEffectAdapter$Companion$diffCallback$1 c = null;
    public final Function1<g, Unit> a;
    public final boolean b;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectAdapter$WakeupSoundEffectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardItem", "Lcom/obric/oui/lisitem/OCardListItem;", "onItemClicked", "Lkotlin/Function1;", "Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectItemUiModel;", "", "isObricOS", "", "<init>", "(Lcom/obric/oui/lisitem/OCardListItem;Lkotlin/jvm/functions/Function1;Z)V", "bind", "item", "bindSelectedState", "bindPlayingState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WakeupSoundEffectViewHolder extends RecyclerView.ViewHolder {
        public final OCardListItem a;
        public final Function1<g, Unit> b;
        public final boolean c;

        public final void T3(g r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            ImageView r0 = (ImageView) this.a.findViewById(2131392994);
            LottieAnimationView r1 = this.a.findViewById(2131392995);
            if (r5.d == false) goto L16;
            if (r0 == null) goto L6;
            r0.setVisibility(8);
        L6:
            if (r1 == null) goto L8;
            r1.setVisibility(0);
        L8:
            if (r1 == null) goto L10;
            r1.setRepeatMode(1);
        L10:
            if (r1 == null) goto L12;
            r1.setRepeatCount(-1);
        L12:
            if (r1 == null) goto L14;
            r1.cancelAnimation();
        L14:
            if (r1 == null) goto L25;
            r1.playAnimation();
            return;
        L25:
            return;
        L16:
            if (r1 == null) goto L18;
            r1.cancelAnimation();
        L18:
            if (r1 == null) goto L20;
            r1.setVisibility(8);
        L20:
            if (r0 == null) goto L22;
            r0.setVisibility(0);
        L22:
            if (r0 == null) goto L27;
            r0.setImageResource(2131236114);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public WakeupSoundEffectViewHolder(OCardListItem r2, Function1<? super g, Unit> r3, boolean r4) {
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

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.wakeupsound.WakeupSoundEffectAdapter$Companion$diffCallback$1] */
    static {
        c = new WakeupSoundEffectAdapter$Companion$diffCallback$1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WakeupSoundEffectAdapter(Function1<? super g, Unit> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "onItemClicked");
        super(c);
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        final WakeupSoundEffectViewHolder r8 = (WakeupSoundEffectViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Object r9 = getItem(r7);
        if ((r9 instanceof h.a) == false) goto L5;
        h.a r10 = (h.a) r9;
    L6:
        if (r10 == null) goto L13;
        final g r11 = r10.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r11, "item");
        r8.a.setCardType(0);
        OCardListItem.h(r8.a, r11.e);
        if (r8.c == true) goto L11;
        int r1 = rda.a.a;
        rda.a.a(r8.a, r11.e);
    L11:
        r8.a.p(false);
        r8.a.setCustomStartView(2131561652);
        r8.a.n(true);
        r8.a.setTitle(r11.b);
        r8.a.s(true);
        r8.a.setSubTitle("");
        r8.a.q(false);
        r8.a.setDefaultCustomEndView(2);
        Intrinsics.checkNotNullParameter(r11, "item");
        r8.a.m(r11.c);
        r8.T3(r11);
        r8.a.r(false);
        r8.a.setOnContentClickListener(new f(r8, r11));
        return;
    L13:
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        OCardListItem r6 = LayoutInflater.from(r4.getContext()).inflate(2131561651, r4, false);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        return new WakeupSoundEffectViewHolder(r6, this.a, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.ArrayList] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9, List r10) {
        WakeupSoundEffectViewHolder r11 = (WakeupSoundEffectViewHolder) r8;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r10, "payloads");
        Object r0 = getItem(r9);
        if ((r0 instanceof h.a) == false) goto L5;
        h.a r1 = (h.a) r0;
    L6:
        if (r1 != null) goto L8;
    L34:
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onBindViewHolder(r11, r9, r10);
        return;
    L8:
        if ((!r10.isEmpty()) == false) goto L34;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r10.iterator();
    L11:
        if (r3.hasNext() == false) goto L26;
        Object r4 = r3.next();
        if ((r4 instanceof List) == false) goto L21;
        ?? r5 = new ArrayList();
        Iterator r6 = ((Iterable) r4).iterator();
    L16:
        if (r6.hasNext() == false) goto L24;
        Object r7 = r6.next();
        if ((r7 instanceof String) == false) goto L16;
        r5.add(r7);
    L24:
        CollectionsKt.addAll(r2, (Iterable) r5);
        goto L11
    L21:
        if ((r4 instanceof String) == false) goto L23;
        r5 = CollectionsKt.listOf(r4);
        goto L24
    L23:
        r5 = CollectionsKt.emptyList();
        goto L24
    L26:
        if (r2.contains("payload_playing_changed") == false) goto L29;
        r11.T3(r1.a);
    L29:
        if (r2.contains("payload_selected_changed") == false) goto L32;
        g r12 = r1.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "item");
        r11.a.m(r12.c);
    L32:
        if ((!r2.isEmpty()) == false) goto L34;
        return;
    L5:
        r1 = null;
        goto L6
    }
}
