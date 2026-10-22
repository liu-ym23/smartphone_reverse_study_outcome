package com.obric.oui.swipeaction.adapters;

import aa.a;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.util.Attributes$Mode;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RecyclerSwipeAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements a {
    public z9.a mItemManger;

    public RecyclerSwipeAdapter() {
        this.mItemManger = new z9.a(this);
    }

    public void closeAllExcept(OSwipeLayout r10) {
        this.mItemManger.a(r10);
    }

    public void closeAllItems() {
        this.mItemManger.b();
    }

    public void closeItem(int r10) {
        this.mItemManger.c(r10);
    }

    public Attributes$Mode getMode() {
        return this.mItemManger.d();
    }

    public List<Integer> getOpenItems() {
        return this.mItemManger.e();
    }

    public List<OSwipeLayout> getOpenLayouts() {
        return this.mItemManger.f();
    }

    public abstract /* synthetic */ int getSwipeLayoutResourceId(int r10);

    public boolean isOpen(int r10) {
        return this.mItemManger.g(r10);
    }

    @Override // aa.a
    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract void onBindViewHolder(VH r10, int r11);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract VH onCreateViewHolder(ViewGroup r10, int r11);

    public void openItem(int r10) {
        this.mItemManger.h(r10);
    }

    public void removeShownLayouts(OSwipeLayout r10) {
        this.mItemManger.i(r10);
    }

    public void setMode(Attributes$Mode r10) {
        this.mItemManger.j(r10);
    }
}
