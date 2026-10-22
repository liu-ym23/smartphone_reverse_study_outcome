package com.larus.bmhome.view.actionbar.edit.component;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.instruction.impl.databinding.LarusItemActionbarTextSelectorHolderBinding;
import com.obric.assistant.spi.actionbar.ObricActionBarTrackServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorWidgetAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/SingleSelectorInstructionOption;", "Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolder;", "callback", "Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;", "<init>", "(Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextSelectorWidgetAdapter extends ListAdapter<com.larus.bmhome.actionbar.model.y1, TextSelectorHolder> {
    public static final TextSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1 b = null;
    public final r2 a;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.actionbar.edit.component.TextSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        b = new TextSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1();
    }

    public TextSelectorWidgetAdapter(r2 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(b);
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        final TextSelectorHolder r8 = (TextSelectorHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        final com.larus.bmhome.actionbar.model.y1 r9 = (com.larus.bmhome.actionbar.model.y1) getItem(r7);
        Intrinsics.checkNotNull(r9);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "data");
        ViewGroup.LayoutParams r0 = ((RecyclerView.ViewHolder) r8).itemView.getLayoutParams();
        if ((r0 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L5;
        int r2 = i5.W() + TextListSelectorWidget.l;
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
        com.larus.utils.e1.d(((RecyclerView.ViewHolder) r8).itemView, new q2(r8, r9));
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
        return new TextSelectorHolder(LarusItemActionbarTextSelectorHolderBinding.a(LayoutInflater.from(r2.getContext()), r2).a, this.a);
    }
}
