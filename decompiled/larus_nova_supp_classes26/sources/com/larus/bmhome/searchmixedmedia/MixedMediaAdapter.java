package com.larus.bmhome.searchmixedmedia;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import pr8.b;
import pr8.c;
import pr8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB]\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n\u0012 \u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0007H\u0016R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/searchmixedmedia/MixedMediaAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaCardInput;", "Lcom/larus/bmhome/searchmixedmedia/MixedMediaAdapter$MixedMediaViewHolder;", "onClick", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "onLongClick", "Lkotlin/Function1;", "onExpose", "", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "currentInput", "Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaViewInput;", "submit", "items", "", "input", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "MixedMediaViewHolder", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MixedMediaAdapter extends ListAdapter<c, MixedMediaViewHolder> {
    public static final MixedMediaAdapter$Companion$DIFF$1 e = null;
    public final Function3<View, Integer, c, Unit> a;
    public final Function1<View, Unit> b;
    public final Function3<View, Integer, String, Unit> c;
    public e d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/searchmixedmedia/MixedMediaAdapter$MixedMediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaItemView;", "<init>", "(Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaItemView;)V", "getView", "()Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaItemView;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MixedMediaViewHolder extends RecyclerView.ViewHolder {
        public final SearchMixedMediaItemView a;

        public MixedMediaViewHolder(SearchMixedMediaItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.searchmixedmedia.MixedMediaAdapter$Companion$DIFF$1] */
    static {
        e = new MixedMediaAdapter$Companion$DIFF$1();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, final int r6) {
        final MixedMediaViewHolder r7 = (MixedMediaViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        final c r0 = (c) getItem(r6);
        e r1 = this.d;
        if (r1 == null) goto L6;
        RatioMode r2 = r1.a;
        if (r2 == null) goto L6;
    L7:
        SearchMixedMediaItemView r3 = r7.a;
        Intrinsics.checkNotNull(r0);
        int r4 = SearchMixedMediaItemView.e;
        r3.a(r0, r2, true);
        e1.d(r7.a, new pr8.a(this, r7, r6, r0));
        r7.a.setOnLongClickListener(new b(this));
        this.c.invoke(r7.a, Integer.valueOf(r6), r0.a);
        return;
    L6:
        r2 = RatioMode.FIXED;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new MixedMediaViewHolder(new SearchMixedMediaItemView(r2.getContext(), null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MixedMediaAdapter(Function3<? super View, ? super Integer, ? super c, Unit> r2, Function1<? super View, Unit> r3, Function3<? super View, ? super Integer, ? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "onClick");
        Intrinsics.checkNotNullParameter(r3, "onLongClick");
        Intrinsics.checkNotNullParameter(r4, "onExpose");
        super(e);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
