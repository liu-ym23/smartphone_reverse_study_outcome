package com.larus.camera.impl.ui.component.generalonly.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/larus/camera/impl/ui/component/generalonly/adapter/ResultPreviewThumbHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "previewThumbImageView", "Landroid/widget/ImageView;", "getPreviewThumbImageView", "()Landroid/widget/ImageView;", "previewMarkedImageView", "getPreviewMarkedImageView", "previewThumbBorderView", "getPreviewThumbBorderView", "()Landroid/view/View;", "deletePreviewThumbButton", "Landroid/widget/ImageButton;", "getDeletePreviewThumbButton", "()Landroid/widget/ImageButton;", "largeStyleApplied", "", "Ljava/lang/Boolean;", "applyUnifiedStyle", "", "enabled", "dp", "", "value", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultPreviewThumbHolder extends RecyclerView.ViewHolder {
    public final ImageView a;
    public final ImageView b;
    public final View c;
    public final ImageButton d;
    public Boolean e;

    public ResultPreviewThumbHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (ImageView) r2.findViewById(2131376501);
        this.b = (ImageView) r2.findViewById(2131376500);
        this.c = r2.findViewById(2131376502);
        this.d = (ImageButton) r2.findViewById(2131364704);
    }

    public final int T3(int r3) {
        Resources r0 = ((RecyclerView.ViewHolder) this).itemView.getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }
}
