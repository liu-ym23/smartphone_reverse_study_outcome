package com.larus.bmhome.banner;

import bb8.i;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.business.banner.databinding.LarusItemBannerSingleBinding;
import com.zhpan.bannerview.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/banner/BannerViewBindingViewHolder;", "Lcom/zhpan/bannerview/BaseViewHolder;", "Lcom/larus/bmhome/banner/BannerModel;", "viewBinding", "Lcom/larus/business/banner/databinding/LarusItemBannerSingleBinding;", "<init>", "(Lcom/larus/business/banner/databinding/LarusItemBannerSingleBinding;)V", "getViewBinding", "()Lcom/larus/business/banner/databinding/LarusItemBannerSingleBinding;", "setViewBinding", "banner_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BannerViewBindingViewHolder extends BaseViewHolder<i> {
    public final LarusItemBannerSingleBinding a;

    public BannerViewBindingViewHolder(LarusItemBannerSingleBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2.a);
        this.a = r2;
    }
}
