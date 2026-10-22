package com.obric.miniapp.view.actionsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.selection.OActionSheetButton;
import fla.a;
import fla.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fJ\u0014\u0010\u0012\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J \u0010\u0014\u001a\u00020\r2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u001c\u0010\u001c\u001a\u00020\r2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/miniapp/view/actionsheet/MiniAppActionSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/miniapp/view/actionsheet/MiniAppActionSheetAdapter$SheetItemViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "items", "", "Lcom/obric/miniapp/view/actionsheet/ActionSheetItemData;", "onItemClickListener", "Lkotlin/Function2;", "", "", "dialogGetter", "Lkotlin/Function0;", "Landroid/app/Dialog;", "setDialogGetter", "setItems", "", "setOnItemClickListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "onBindViewHolder", "holder", "getItemCount", "SheetItemViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppActionSheetAdapter extends RecyclerView.Adapter<SheetItemViewHolder> {
    public final Context a;
    public final List<a> b;
    public Function2<? super a, ? super Integer, Unit> c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/miniapp/view/actionsheet/MiniAppActionSheetAdapter$SheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "<init>", "(Lcom/obric/miniapp/view/actionsheet/MiniAppActionSheetAdapter;Landroid/view/View;I)V", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "titleView", "Landroid/widget/TextView;", "bind", "", "item", "Lcom/obric/miniapp/view/actionsheet/ActionSheetItemData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SheetItemViewHolder extends RecyclerView.ViewHolder {
        public final int a;
        public final ImageView b;
        public final TextView c;

        public SheetItemViewHolder(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r3;
            this.b = (ImageView) r2.findViewById(2131376411);
            this.c = (TextView) r2.findViewById(2131390955);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public MiniAppActionSheetAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new ArrayList();
    }

    public final int getItemViewType(int r2) {
        return ((a) ListProtector.get(this.b, r2)).a.ordinal();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, final int r5) {
        SheetItemViewHolder r6 = (SheetItemViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        final a r0 = (a) ListProtector.get(this.b, r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        if (r6.a != OActionSheet.Companion.ItemStyle.LIST_ICON_AND_TEXT.ordinal()) goto L13;
        ImageView r1 = r6.b;
        if (r1 == null) goto L7;
        r1.setImageDrawable(r0.b);
    L7:
        TextView r2 = r6.c;
        if (r2 == null) goto L10;
        r2.setText(r0.c);
    L10:
        Integer r3 = r0.d;
        if (r3 == null) goto L16;
        r6.c.setTextColor(r3.intValue());
    L16:
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new b(this, r0, r5));
        return;
    L13:
        OActionSheetButton r7 = ((RecyclerView.ViewHolder) r6).itemView;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.selection.OActionSheetButton");
        OActionSheetButton r8 = r7;
        r8.setText(r0.c);
        Integer r9 = r0.d;
        if (r9 == null) goto L16;
        r8.setTextColor(r9.intValue());
        goto L16
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != OActionSheet.Companion.ItemStyle.LIST_ICON_AND_TEXT.ordinal()) goto L6;
        View r6 = LayoutInflater.from(this.a).inflate(2131563659, r4, false);
        Intrinsics.checkNotNull(r6);
        return new SheetItemViewHolder(r6, r5);
    L6:
        return new SheetItemViewHolder(new OActionSheetButton(this.a, null), r5);
    }
}
