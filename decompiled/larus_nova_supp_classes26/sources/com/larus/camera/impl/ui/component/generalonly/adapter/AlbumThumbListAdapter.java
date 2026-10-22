package com.larus.camera.impl.ui.component.generalonly.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.camera.impl.databinding.LarusLayoutAlbumThumbItemBinding;
import com.larus.camera.impl.ui.component.generalonly.i;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ux8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \"2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\"#BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012:\b\u0002\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u000f2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\u0016\u0010!\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/larus/camera/impl/ui/component/generalonly/adapter/AlbumThumbListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/camera/impl/ui/component/generalonly/adapter/AlbumThumbListAdapter$ImageViewHolder;", "context", "Landroid/content/Context;", "imageUris", "", "Landroid/net/Uri;", "onItemClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "uri", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "albumThumbItemRadius", "", "getAlbumThumbItemRadius", "()F", "albumThumbItemRadius$delegate", "Lkotlin/Lazy;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "notifyAllDataSetChanged", "Companion", "ImageViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumThumbListAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    public static final /* synthetic */ int e = 0;
    public final Context a;
    public List<? extends Uri> b;
    public final Function2<View, Uri, Unit> c;
    public final Lazy d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/camera/impl/ui/component/generalonly/adapter/AlbumThumbListAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/camera/impl/databinding/LarusLayoutAlbumThumbItemBinding;", "<init>", "(Lcom/larus/camera/impl/ui/component/generalonly/adapter/AlbumThumbListAdapter;Lcom/larus/camera/impl/databinding/LarusLayoutAlbumThumbItemBinding;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ImageViewHolder extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;

        public ImageViewHolder(AlbumThumbListAdapter r2, LarusLayoutAlbumThumbItemBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            super(r3.a);
            SimpleDraweeView r4 = r3.b;
            this.a = r4;
            GenericDraweeHierarchy r0 = r4.getHierarchy();
            r0.setRoundingParams(RoundingParams.fromCornersRadius(((Number) r2.d.getValue()).floatValue()));
            r4.setHierarchy(r0);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        final ImageViewHolder r5 = (ImageViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        final Uri r6 = (Uri) ListProtector.get(this.b, r4);
        ImageLoaderKt.s(r5.a, r6, "camera_album_thumb_list");
        e1.d(r5.a, new ux8.a(this, r5, r6));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        SimpleDraweeView r5 = LayoutInflater.from(this.a).inflate(2131562737, r3, false);
        if (r5 == null) goto L7;
        SimpleDraweeView r6 = r5;
        return new ImageViewHolder(this, new LarusLayoutAlbumThumbItemBinding(r6, r6));
    L7:
        throw new NullPointerException("rootView");
    }

    public AlbumThumbListAdapter(Context r2, List r3, i r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imageUris");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new b());
    }
}
