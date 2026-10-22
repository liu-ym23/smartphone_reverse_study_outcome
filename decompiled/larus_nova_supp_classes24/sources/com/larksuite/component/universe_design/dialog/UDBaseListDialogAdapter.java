package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\rH\u0004J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010\u001f\u001a\u00020\u00142\b\b\u0001\u0010 \u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\rJ\u000e\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0012J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\rH\u0016J\b\u0010)\u001a\u00020\rH\u0016J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mItems", "", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItem;", "mOnItemClickListener", "Lcom/larksuite/component/universe_design/dialog/UDListDialogController$OnItemClickListener;", "mItemLayoutRes", "", "mItemTextSize", "mItemTextColorRes", "mItemHeight", "hasTitle", "", "setItems", "", "items", "", "setOnItemClickListener", "listener", "onItemClick", "position", "setItemLayoutRes", "layoutRes", "setTextSize", "textSize", "setTextColor", "textColor", "setItemHeight", "itemHeight", "setHasTitle", "value", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "UDDialogListItemViewHolder", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDBaseListDialogAdapter extends RecyclerView.Adapter<UDDialogListItemViewHolder> {
    public final Context a;
    public final List<UDBaseListDialogBuilder.ListItem> b;
    public UDListDialogController.OnItemClickListener c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static class UDDialogListItemViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public UDDialogListItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131391793);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ UDBaseListDialogAdapter a;
        public final /* synthetic */ int b;

        public a(UDBaseListDialogAdapter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            UDListDialogController.OnItemClickListener r3 = this.a.c;
            if (r3 == null) goto L6;
            r3.onItemClick(this.b);
            return;
        }
    }

    public int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public UDBaseListDialogAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        this.a = r2;
        this.b = new ArrayList();
        this.d = 2131568076;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = true;
    }

    public final void A2(List<UDBaseListDialogBuilder.ListItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        ((ArrayList) this.b).clear();
        ArrayList r0 = (ArrayList) this.b;
        r0.addAll(r2);
        notifyDataSetChanged();
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((UDDialogListItemViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1, r2);
    }

    public void y2(UDDialogListItemViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        UDBaseListDialogBuilder.ListItem r0 = (UDBaseListDialogBuilder.ListItem) ListProtector.get(this.b, r8);
        TextView r1 = r7.a;
        r1.setText(r0.getText());
        if (r0.getTextColor() != 0) goto L12;
        if (r0.getTextColorRes() != 0) goto L12;
        Context r2 = this.a;
        int r3 = this.f;
        if (r3 != (-1)) goto L10;
        r3 = 2131106622;
    L10:
        r1.setTextColor(UDColorUtils.getColor(r2, r3));
    L15:
        int r4 = this.e;
        if (r4 <= 0) goto L18;
        r1.setTextSize(r4);
    L18:
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new a(this, r8));
        if (this.g <= 0) goto L21;
        ((RecyclerView.ViewHolder) r7).itemView.getLayoutParams().height = (int) h18.d.b(this.a, this.g);
    L21:
        int r5 = 2131253515;
        if (this.h == false) goto L29;
        View r6 = ((RecyclerView.ViewHolder) r7).itemView;
        if (r8 == (getItemCount() - 1)) goto L27;
        r5 = 2131253516;
    L27:
        r6.setBackgroundResource(r5);
    L38:
        if (r0.getBackgroundColorRes() == 0) goto L41;
        ((RecyclerView.ViewHolder) r7).itemView.setBackgroundTintList(UDColorUtils.getColorStateList(this.a, r0.getBackgroundColorRes()));
        ((RecyclerView.ViewHolder) r7).itemView.setBackgroundTintMode(PorterDuff.Mode.SRC);
        return;
    L41:
        return;
    L29:
        if (getItemCount() != 1) goto L31;
        ((RecyclerView.ViewHolder) r7).itemView.setBackgroundResource(2131253513);
        goto L38
    L31:
        if (r8 != 0) goto L34;
        ((RecyclerView.ViewHolder) r7).itemView.setBackgroundResource(2131253514);
        goto L38
    L34:
        if (r8 != (getItemCount() - 1)) goto L36;
        ((RecyclerView.ViewHolder) r7).itemView.setBackgroundResource(2131253515);
        goto L38
    L36:
        ((RecyclerView.ViewHolder) r7).itemView.setBackgroundResource(2131253516);
    L12:
        if (r0.getTextColorRes() == 0) goto L14;
        r1.setTextColor(UDColorUtils.getColor(this.a, r0.getTextColorRes()));
        goto L15
    L14:
        r1.setTextColor(r0.getTextColor());
        goto L15
    }

    public UDDialogListItemViewHolder z2(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new UDDialogListItemViewHolder(LayoutInflater.from(this.a).inflate(this.d, r3, false));
    }
}
