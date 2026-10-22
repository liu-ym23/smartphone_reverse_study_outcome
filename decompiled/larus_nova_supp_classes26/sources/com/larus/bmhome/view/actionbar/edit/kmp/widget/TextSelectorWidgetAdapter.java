package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import bt8.n2;
import bt8.o2;
import com.larus.bmhome.actionbar.model.y1;
import com.larus.instruction.impl.databinding.LarusItemActionbarTextSelectorHolderBinding;
import com.larus.utils.e1;
import com.obric.assistant.spi.actionbar.ObricActionBarTrackServiceDelegate;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TextSelectorWidgetAdapter extends ListAdapter<y1, com.larus.bmhome.view.actionbar.edit.kmp.widget.a> {
    public static final TextSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1 b = null;
    public final o2 a;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.actionbar.edit.kmp.widget.TextSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        b = new TextSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1();
    }

    public TextSelectorWidgetAdapter(KmpTextListSelectorWidget.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(b);
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        final com.larus.bmhome.view.actionbar.edit.kmp.widget.a r8 = (com.larus.bmhome.view.actionbar.edit.kmp.widget.a) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        final y1 r9 = (y1) getItem(r7);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "data");
        ViewGroup.LayoutParams r0 = ((RecyclerView.ViewHolder) r8).itemView.getLayoutParams();
        if ((r0 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L5;
        int r2 = i5.W() + KmpTextListSelectorWidget.o;
        ((ViewGroup.MarginLayoutParams) ((StaggeredGridLayoutManager.LayoutParams) r0)).height = r2;
        ((RecyclerView.ViewHolder) r8).itemView.setLayoutParams(r0);
    L5:
        Integer r1 = r9.g;
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
    L16:
        r8.d.setText(r9.b);
        ObricActionBarTrackServiceDelegate.b.k(r8.d, r9.g, r9.b, ((RecyclerView.ViewHolder) r8).itemView);
        e1.d(((RecyclerView.ViewHolder) r8).itemView, new n2(r8, r9));
        return;
    L14:
        if (r1.intValue() != 1) goto L16;
        ((RecyclerView.ViewHolder) r8).itemView.setSelected(true);
        r8.d.setTextColor(r8.b);
        goto L16
    L9:
        if (r1.intValue() != 0) goto L11;
        ((RecyclerView.ViewHolder) r8).itemView.setSelected(false);
        r8.d.setTextColor(r8.c);
        goto L16
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new com.larus.bmhome.view.actionbar.edit.kmp.widget.a(LarusItemActionbarTextSelectorHolderBinding.a(LayoutInflater.from(r2.getContext()), r2).a, this.a);
    }
}
