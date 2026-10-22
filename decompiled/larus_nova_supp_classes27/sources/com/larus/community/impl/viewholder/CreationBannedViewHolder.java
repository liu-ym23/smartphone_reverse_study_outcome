package com.larus.community.impl.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J4\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationBannedViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "authorInfoLayout", "Lcom/larus/common_ui/widget/CommonAuthorInfoLayout;", "creationStatusText", "Landroid/widget/TextView;", "creationStatusLayout", "bindData", "", "position", "", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "itemWidth", "creationClickCallBack", "Lcom/larus/community/impl/adapter/ICreationClickCallBack;", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CreationBannedViewHolder extends RecyclerView.ViewHolder implements zp9.q {
    public static final /* synthetic */ int d = 0;
    public final CommonAuthorInfoLayout a;
    public final TextView b;
    public final View c;

    public final void onViewRecycled() {
    }

    public CreationBannedViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (CommonAuthorInfoLayout) r2.findViewById(2131377437);
        this.b = (TextView) r2.findViewById(2131368275);
        this.c = r2.findViewById(2131368274);
        w0.e(r2, i5.Y());
    }
}
