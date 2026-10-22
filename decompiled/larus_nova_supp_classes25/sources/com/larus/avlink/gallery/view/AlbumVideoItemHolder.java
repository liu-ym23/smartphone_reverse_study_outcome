package com.larus.avlink.gallery.view;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/avlink/gallery/view/AlbumVideoItemHolder;", "Lcom/larus/avlink/gallery/view/AlbumViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "<init>", "(Landroid/view/View;Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "image", "Lcom/larus/bmhome/chat/plugin/image4/view/ImageViewWithLastMotion;", "selectedCheckBox", "videoDuration", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "mask", "lastTouchX", "", "lastTouchY", "hasRecordedTouch", "", "bindData", "", "item", "Lcom/larus/bmhome/bigimg/MediaItem;", "loadThumbnailImage", "thumbnailPath", "", "setUIDisplay", "setupClickListeners", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AlbumVideoItemHolder extends AlbumViewHolder {
    public static final /* synthetic */ int k = 0;
    public final f a;
    public final LifecycleCoroutineScope b;
    public final ImageViewWithLastMotion c;
    public final View d;
    public final TextView e;
    public final ProgressBar f;
    public final View g;
    public float h;
    public float i;
    public boolean j;

    public static final class a {
    }

    static {
    }

    public AlbumVideoItemHolder(ConstraintLayout r2, f r3, LifecycleCoroutineScope r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "lifecycleScope");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = (ImageViewWithLastMotion) r2.findViewById(2131374931);
        this.d = r2.findViewById(2131362468);
        this.e = (TextView) r2.findViewById(2131370393);
        this.f = (ProgressBar) r2.findViewById(2131362467);
        this.g = r2.findViewById(2131373413);
    }
}
