package com.larus.setting.impl.blocklist;

import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.setting.impl.databinding.LarusItemBlockUserBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/setting/impl/blocklist/BlockUserItemViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "viewBinding", "Lcom/larus/setting/impl/databinding/LarusItemBlockUserBinding;", "<init>", "(Lcom/larus/setting/impl/databinding/LarusItemBlockUserBinding;)V", "getViewBinding", "()Lcom/larus/setting/impl/databinding/LarusItemBlockUserBinding;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BlockUserItemViewHolder extends ViewBindingHolder {
    public final LarusItemBlockUserBinding a;

    public BlockUserItemViewHolder(LarusItemBlockUserBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2);
        this.a = r2;
    }
}
