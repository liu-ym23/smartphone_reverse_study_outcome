package com.larus.photopicker.v2.impl.ui;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaDiffCallback extends DiffUtil.ItemCallback<d> {
    public MediaDiffCallback() {
    }

    public final boolean areContentsTheSame(Object r2, Object r3) {
        d r4 = (d) r2;
        d r5 = (d) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        return Intrinsics.areEqual(r4, r5);
    }

    public final boolean areItemsTheSame(Object r4, Object r5) {
        d r6 = (d) r4;
        d r7 = (d) r5;
        Intrinsics.checkNotNullParameter(r6, "oldItem");
        Intrinsics.checkNotNullParameter(r7, "newItem");
        if (r6.a.a != r7.a.a) goto L5;
        return true;
    L5:
        return false;
    }
}
