package com.larus.ugc.feed.impl.viewholder.selfprivate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zp9.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/ugc/feed/impl/viewholder/selfprivate/CreationSelfPrivateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "musicLabel", "Landroid/view/View;", "creationGroupSize", "Landroid/widget/TextView;", "videoIcon", "Landroid/widget/ImageView;", "bindData", "", "position", "", "userCreationModel", "Lcom/larus/profile/api/bean/UserCreationModel;", "itemWidth", "creationClickCallBack", "Lcom/larus/ugc/feed/impl/adapter/ICreationClickCallBack;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public class CreationSelfPrivateViewHolder extends RecyclerView.ViewHolder implements q {
    public static final /* synthetic */ int e = 0;
    public final SimpleDraweeView a;
    public final View b;
    public final TextView c;
    public final ImageView d;

    @Override // zp9.q
    public final void onViewRecycled() {
    }

    public CreationSelfPrivateViewHolder(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        super(LayoutInflater.from(r4.getContext()).inflate(2131561949, r4, false));
        this.a = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375775);
        this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131380497);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131368245);
        this.d = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392307);
    }
}
