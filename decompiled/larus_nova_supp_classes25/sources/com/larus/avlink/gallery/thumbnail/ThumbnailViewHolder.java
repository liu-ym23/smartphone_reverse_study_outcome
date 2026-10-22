package com.larus.avlink.gallery.thumbnail;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.avlink.impl.databinding.LarusItemThumbnailBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/avlink/gallery/thumbnail/ThumbnailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/avlink/impl/databinding/LarusItemThumbnailBinding;", "callback", "Lcom/larus/avlink/gallery/thumbnail/ThumbnailItemCallback;", "<init>", "(Lcom/larus/avlink/impl/databinding/LarusItemThumbnailBinding;Lcom/larus/avlink/gallery/thumbnail/ThumbnailItemCallback;)V", "currentImageUuid", "", "isSelectionModeEnabled", "", "isItemSelected", "bindData", "", "item", "Lcom/larus/avlink/gallery/model/ThumbnailMetadata;", "isSelected", "isSelectionMode", "applySelection", "updateSelectionState", "formatDuration", "", "duration", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ThumbnailViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int d = 0;
    public final LarusItemThumbnailBinding a;
    public final i0 b;
    public long c;

    public static final class a {
    }

    static {
    }

    public final void T3(boolean r6) {
        FLogger r0 = FLogger.a;
        r0.d("ThumbnailViewHolder", "updateSelectionState: imageUuid=" + this.c + ", isSelected=" + r6);
        this.a.b.setVisibility(0);
        this.a.b.setChecked(r6);
        if (r6 == false) goto L5;
        this.a.b.setBackgroundResource(2131240819);
        r0.d("ThumbnailViewHolder", "Setting selected icon for imageUuid=" + this.c);
        return;
    L5:
        this.a.b.setBackgroundResource(2131240820);
        r0.d("ThumbnailViewHolder", "Setting unselected icon for imageUuid=" + this.c);
    }

    public ThumbnailViewHolder(LarusItemThumbnailBinding r2, i0 r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2.a);
        this.a = r2;
        this.b = r3;
    }
}
