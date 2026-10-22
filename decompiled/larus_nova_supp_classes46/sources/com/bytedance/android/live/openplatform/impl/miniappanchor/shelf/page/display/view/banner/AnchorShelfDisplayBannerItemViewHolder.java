package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.banner;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xp0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/banner/AnchorShelfDisplayBannerItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorShelfDisplayBannerItemViewHolder extends RecyclerView.ViewHolder {
    public final FrameLayout a;
    public final HSImageView b;
    public final ImageView c;
    public final a d;

    public AnchorShelfDisplayBannerItemViewHolder(View r3, a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "callback");
        super(r3);
        this.d = r4;
        FrameLayout r5 = (FrameLayout) r3.findViewById(2131363936);
        this.a = r5;
        this.b = r3.findViewById(2131363937);
        this.c = (ImageView) r3.findViewById(2131363923);
        float r6 = s1.y() - UtilityKotlinExtentionsKt.h(16);
        r5.setLayoutParams(new FrameLayout.LayoutParams((int) r6, (int) (0.44568247f * r6)));
    }
}
