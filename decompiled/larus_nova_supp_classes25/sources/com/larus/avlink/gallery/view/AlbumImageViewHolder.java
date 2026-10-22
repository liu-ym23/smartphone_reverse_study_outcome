package com.larus.avlink.gallery.view;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/gallery/view/AlbumImageViewHolder;", "Lcom/larus/avlink/gallery/view/AlbumViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "<init>", "(Landroid/view/View;Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "image", "Lcom/larus/bmhome/chat/plugin/image4/view/ImageViewWithLastMotion;", "selectedCheckBox", "progressBar", "Landroid/widget/ProgressBar;", "mask", "lastTouchX", "", "lastTouchY", "hasRecordedTouch", "", "bindData", "", "item", "Lcom/larus/bmhome/bigimg/MediaItem;", "setUIDisplay", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AlbumImageViewHolder extends AlbumViewHolder {
    public static final /* synthetic */ int i = 0;
    public final f a;
    public final ImageViewWithLastMotion b;
    public final View c;
    public final ProgressBar d;
    public final View e;
    public float f;
    public float g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public AlbumImageViewHolder(ConstraintLayout r2, f r3, LifecycleCoroutineScope r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "lifecycleScope");
        super(r2);
        this.a = r3;
        this.b = (ImageViewWithLastMotion) r2.findViewById(2131374931);
        this.c = r2.findViewById(2131362468);
        this.d = (ProgressBar) r2.findViewById(2131362467);
        this.e = r2.findViewById(2131373413);
    }
}
