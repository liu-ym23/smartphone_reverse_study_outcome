package com.larus.dora.impl.device.manage.holder;

import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementFeedbackBinding;
import com.larus.dora.impl.device.manage.p0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/FeedbackViewHolder;", "Lcom/larus/dora/impl/device/manage/holder/BaseViewHolder;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementFeedbackBinding;", "onFeedbackClick", "Lkotlin/Function0;", "", "<init>", "(Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementFeedbackBinding;Lkotlin/jvm/functions/Function0;)V", "onBind", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackViewHolder extends BaseViewHolder<p0> {
    public static final /* synthetic */ int c = 0;
    public final LarusItemDoraGDeviceManagementFeedbackBinding a;
    public final Function0<Unit> b;

    public static final class a {
    }

    static {
    }

    public FeedbackViewHolder() {
        throw null;
    }

    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void U3(p0 r2) {
        p0 r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a.b.setText(((com.larus.dora.impl.device.manage.f) r3).b);
        g49.d.d("FeedbackViewHolder", "onBind feedback item");
        this.a.a.setOnClickListener(new j(this));
    }

    public FeedbackViewHolder(LarusItemDoraGDeviceManagementFeedbackBinding r2, Function0 r3) {
        super(r2.a);
        this.a = r2;
        this.b = r3;
    }
}
