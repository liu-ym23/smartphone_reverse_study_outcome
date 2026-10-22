package com.larus.camera.impl.ui.component.generalonly.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.camera.api.params.OutputParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/camera/impl/ui/component/generalonly/adapter/OutputParamDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/camera/api/params/OutputParam;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OutputParamDiffCallback extends DiffUtil.ItemCallback<OutputParam> {
    public OutputParamDiffCallback() {
    }

    public final boolean areContentsTheSame(Object r6, Object r7) {
        OutputParam r8 = (OutputParam) r6;
        OutputParam r9 = (OutputParam) r7;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        if (r8.isSelected() == r9.isSelected()) goto L5;
    L11:
        return false;
    L5:
        if (r8.getCreateTime() != r9.getCreateTime()) goto L11;
        if (r8.getImageParam().getBitmapChangedTime() != r9.getImageParam().getBitmapChangedTime()) goto L11;
        if (Intrinsics.areEqual(r8.getPath(), r9.getPath()) == false) goto L11;
        return true;
    }

    public final boolean areItemsTheSame(Object r4, Object r5) {
        OutputParam r6 = (OutputParam) r4;
        OutputParam r7 = (OutputParam) r5;
        Intrinsics.checkNotNullParameter(r6, "oldItem");
        Intrinsics.checkNotNullParameter(r7, "newItem");
        if (Intrinsics.areEqual(r6.getPath(), r7.getPath()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r6.getCreateTime() != r7.getCreateTime()) goto L7;
        return true;
    }
}
