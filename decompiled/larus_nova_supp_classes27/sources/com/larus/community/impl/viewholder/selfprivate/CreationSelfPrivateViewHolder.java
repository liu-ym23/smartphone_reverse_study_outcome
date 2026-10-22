package com.larus.community.impl.viewholder.selfprivate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zp9.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/community/impl/viewholder/selfprivate/CreationSelfPrivateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "musicLabel", "Landroid/view/View;", "creationGroupSize", "Landroid/widget/TextView;", "videoIcon", "Landroid/widget/ImageView;", "bindData", "", "position", "", "userCreationModel", "Lcom/larus/profile/api/bean/UserCreationModel;", "itemWidth", "creationClickCallBack", "Lcom/larus/community/impl/adapter/ICreationClickCallBack;", "resolveSelfPrivateCoverImage", "Lcom/larus/platform/api/Image;", "Lcom/larus/platform/api/creation/UserCreation;", "selectCoverImage", "Lcom/larus/platform/api/ImageInfo;", "takeIfHasUrl", "bestUrl", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CreationSelfPrivateViewHolder extends RecyclerView.ViewHolder implements q {
    public static final /* synthetic */ int e = 0;
    public final SimpleDraweeView a;
    public final View b;
    public final TextView c;
    public final ImageView d;

    public final void onViewRecycled() {
    }

    public CreationSelfPrivateViewHolder(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        super(LayoutInflater.from(r4.getContext()).inflate(2131561946, r4, false));
        this.a = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375775);
        this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131380497);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131368245);
        this.d = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392307);
    }

    public static String T3(Image r3) {
        if (r3 == null) goto L13;
        String r1 = r3.a;
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        if (r3 == null) goto L21;
        String r4 = r3.b;
        if (r4 != null) goto L17;
        return null;
    L17:
        if ((!StringsKt.isBlank(r4)) == true) goto L19;
        return null;
    L19:
        return r4;
    L21:
        return null;
    }

    public static Image U3(ImageInfo r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        Image r0 = V3(r1.b);
        if (r0 != null) goto L15;
        Image r2 = V3(r1.c);
        if (r2 != null) goto L16;
        Image r3 = V3(r1.a);
        if (r3 != null) goto L17;
        Image r4 = V3(r1.j);
        if (r4 == null) goto L14;
        return r4;
    L14:
        return V3(r1.i);
    L17:
        return r3;
    L16:
        return r2;
    L15:
        return r0;
    }

    public static Image V3(Image r2) {
        String r0 = T3(r2);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if ((!r1) == true) goto L14;
        return null;
    L14:
        return r2;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
