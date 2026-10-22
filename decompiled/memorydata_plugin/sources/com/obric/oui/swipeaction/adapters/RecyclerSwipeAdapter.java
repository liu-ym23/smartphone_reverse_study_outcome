package com.obric.oui.swipeaction.adapters;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.b.a;
import com.obric.oui.swipeaction.util.Attributes;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RecyclerSwipeAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements a {
    public com.obric.oui.swipeaction.a.a mItemManger;

    public RecyclerSwipeAdapter() {
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    public void closeAllExcept(OSwipeLayout r1) {
        this.mItemManger.a(r1);
    }

    public void closeAllItems() {
        this.mItemManger.b();
    }

    public void closeItem(int r1) {
        this.mItemManger.b(r1);
    }

    public Attributes.Mode getMode() {
        return this.mItemManger.a();
    }

    public List<Integer> getOpenItems() {
        return this.mItemManger.c();
    }

    public List<OSwipeLayout> getOpenLayouts() {
        return this.mItemManger.d();
    }

    public boolean isOpen(int r1) {
        return this.mItemManger.c(r1);
    }

    @Override // com.obric.oui.swipeaction.b.a
    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract void onBindViewHolder(VH r1, int r2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract VH onCreateViewHolder(ViewGroup r1, int r2);

    public void openItem(int r1) {
        this.mItemManger.a(r1);
    }

    public void removeShownLayouts(OSwipeLayout r1) {
        this.mItemManger.b(r1);
    }

    public void setMode(Attributes.Mode r1) {
        this.mItemManger.a(r1);
    }
}
