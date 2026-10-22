package com.larus.camera.impl.utils;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.impl.widget.TabPickerView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/camera/impl/utils/TabPickerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/camera/impl/widget/TabPickerView$Tab;", "Lcom/larus/camera/impl/utils/TabPickerAdapter$PickerViewHolder;", "<init>", "()V", "scrollListener", "Lkotlin/Function1;", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "bindScrollListener", "Companion", "PickerViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabPickerAdapter extends ListAdapter<TabPickerView.a, PickerViewHolder> {
    public static final TabPickerAdapter$Companion$differ$1 b = null;
    public Function1<? super Integer, Unit> a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/camera/impl/utils/TabPickerAdapter$PickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PickerViewHolder extends RecyclerView.ViewHolder {
        public final View a;

        public PickerViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.camera.impl.utils.TabPickerAdapter$Companion$differ$1] */
    static {
        b = new TabPickerAdapter$Companion$differ$1();
    }

    public TabPickerAdapter() {
        super(b);
        this.a = new h0();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, final int r3) {
        PickerViewHolder r4 = (PickerViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        TextView r5 = (TextView) r4.a.findViewById(2131375863);
        r5.setTypeface(Typeface.defaultFromStyle(1));
        r5.setText(((TabPickerView.a) getItem(r3)).a);
        e1.d(r5, new i0(this, r3));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new PickerViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131562927, r4, false));
    }
}
