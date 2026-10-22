package com.larus.canvas.feature.component.title.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/canvas/feature/component/title/widget/DropdownItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", ItemStyle.ITEM_STYLE_DIVIDER, "iconView", "Landroid/widget/ImageView;", "descTv", "Landroid/widget/TextView;", "bindData", "", "data", "Lcom/larus/canvas/feature/component/title/widget/DropdownItemData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownItemHolder extends RecyclerView.ViewHolder {
    public final View a;
    public final ImageView b;
    public final TextView c;

    public DropdownItemHolder(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.findViewById(2131375736);
        this.b = (ImageView) r2.findViewById(2131374718);
        this.c = (TextView) r2.findViewById(2131368819);
    }
}
