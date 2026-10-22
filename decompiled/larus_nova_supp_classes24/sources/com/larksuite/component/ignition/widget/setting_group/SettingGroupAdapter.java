package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.UIUtils;
import h18.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\tH\u0016J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u001a2\u0006\u00101\u001a\u000202H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00064"}, d2 = {"Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "adapter", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "value", "", "itemBackgroundColorResources", "getItemBackgroundColorResources", "()I", "setItemBackgroundColorResources", "(I)V", "isItemStateful", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setItemStateful", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "bindBackground", "getItemViewType", "setHasStableIds", "hasStableIds", "getItemId", "", "getItemCount", "lastItemIndex", "onViewRecycled", "onFailedToRecycleView", "onViewAttachedToWindow", "onViewDetachedFromWindow", "registerAdapterDataObserver", "observer", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "unregisterAdapterDataObserver", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "ignition-widget-settinggroup_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SettingGroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Context a;
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> b;
    public int c;
    public final Function1<? super Integer, Boolean> d;

    public final int getItemCount() {
        return this.b.getItemCount();
    }

    public final long getItemId(int r3) {
        return this.b.getItemId(r3);
    }

    public final int getItemViewType(int r2) {
        return this.b.getItemViewType(r2);
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.b.onAttachedToRecyclerView(r2);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.b.onDetachedFromRecyclerView(r2);
    }

    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        return this.b.onFailedToRecycleView(r2);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.b.onViewAttachedToWindow(r2);
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.b.onViewDetachedFromWindow(r2);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.b.onViewRecycled(r2);
    }

    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.b.registerAdapterDataObserver(r2);
    }

    public final void setHasStableIds(boolean r2) {
        this.b.setHasStableIds(r2);
    }

    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.b.unregisterAdapterDataObserver(r2);
    }

    public SettingGroupAdapter(Context r2, RecyclerView.Adapter<RecyclerView.ViewHolder> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        this.a = r2;
        this.b = r3;
        this.c = 2131100568;
        this.d = SettingGroupAdapter$isItemStateful$1.INSTANCE;
        r3.registerAdapterDataObserver(new AnonymousClass1(this));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.b.onBindViewHolder(r2, r3);
        y2(r2, r3);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return this.b.onCreateViewHolder(r2, r3);
    }

    public final void y2(RecyclerView.ViewHolder r8, int r9) {
        Drawable r0 = r8.itemView.getBackground();
        if ((r0 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r1 = (GradientDrawable) r0;
    L6:
        if (r1 != null) goto L11;
        r1 = new GradientDrawable();
        if (((Boolean) this.d.invoke(Integer.valueOf(r9))).booleanValue() == false) goto L10;
        r1.setColor(UIUtils.getColorStateList(this.a, this.c));
        goto L11
    L10:
        r1.setColor(UIUtils.getColor(this.a, this.c));
    L11:
        int r2 = b.a;
        Context r3 = this.a;
        int r4 = getItemCount();
        float r5 = d.b(r3, 10);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        boolean r6 = false;
        if (r9 != 0) goto L14;
        boolean r7 = true;
    L16:
        if (r9 != (r4 - 1)) goto L18;
        r6 = true;
    L18:
        b.a(r1, r3, r7, r6, r5);
        r8.itemView.setBackground(r1);
        return;
    L14:
        r7 = false;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        this.b.onBindViewHolder(r2, r3, r4);
        y2(r2, r3);
    }
}
