package com.larus.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0011\u0010\u001b\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u0011\u0010\u001d\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/ui/CommonTaskItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "getIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "descView", "getDescView", "dividerView", "getDividerView", "()Landroid/view/View;", "statusBadgeView", "getStatusBadgeView", "statusBadgeIcon", "Landroid/widget/ImageView;", "getStatusBadgeIcon", "()Landroid/widget/ImageView;", "statusBadgeTextView", "getStatusBadgeTextView", "endLabel", "getEndLabel", "endIcon", "getEndIcon", "endLoadingView", "getEndLoadingView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public class CommonTaskItemViewHolder extends RecyclerView.ViewHolder {
    public final AppCompatImageView a;
    public final TextView b;
    public final TextView c;
    public final View d;
    public final View e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;
    public final ImageView i;
    public final View j;

    public CommonTaskItemViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.findViewById(2131375790);
        this.b = (TextView) r2.findViewById(2131375802);
        this.c = (TextView) r2.findViewById(2131375733);
        this.d = r2.findViewById(2131375736);
        this.e = r2.findViewById(2131375848);
        this.f = (ImageView) r2.findViewById(2131375849);
        this.g = (TextView) r2.findViewById(2131375850);
        this.h = (TextView) r2.findViewById(2131375743);
        this.i = (ImageView) r2.findViewById(2131375742);
        this.j = r2.findViewById(2131375744);
    }
}
