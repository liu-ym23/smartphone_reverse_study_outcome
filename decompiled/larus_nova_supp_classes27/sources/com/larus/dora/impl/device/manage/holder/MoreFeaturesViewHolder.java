package com.larus.dora.impl.device.manage.holder;

import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementMoreFeaturesBinding;
import com.larus.dora.impl.device.manage.p0;
import com.larus.dora.impl.device.manage.s0;
import com.larus.dora.impl.resource.DoraDrawableDensity;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/MoreFeaturesViewHolder;", "Lcom/larus/dora/impl/device/manage/holder/BaseViewHolder;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementMoreFeaturesBinding;", "onMoreFeaturesClick", "Lkotlin/Function0;", "", "<init>", "(Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementMoreFeaturesBinding;Lkotlin/jvm/functions/Function0;)V", "onBind", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreFeaturesViewHolder extends BaseViewHolder<p0> {
    public static final /* synthetic */ int c = 0;
    public final LarusItemDoraGDeviceManagementMoreFeaturesBinding a;
    public final Function0<Unit> b;

    public static final class a {
    }

    static {
    }

    public MoreFeaturesViewHolder() {
        throw null;
    }

    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void U3(p0 r9) {
        p0 r10 = r9;
        Intrinsics.checkNotNullParameter(r10, "data");
        s0 r11 = (s0) r10;
        g49.d.d("MoreFeaturesViewHolder", "onBind: title=" + r11.b);
        this.a.e.setText(r11.b);
        this.a.d.setText(r11.c);
        LarusItemDoraGDeviceManagementMoreFeaturesBinding r0 = this.a;
        r0.c.setImageDrawable(com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, r0.a.getContext(), DoraResourceDeviceType.G1, r11.d, DoraDrawableDensity.XXHDPI, 8));
        this.a.a.setOnClickListener(new o(this));
        this.a.b.setOnClickListener(new p(this));
    }

    public MoreFeaturesViewHolder(LarusItemDoraGDeviceManagementMoreFeaturesBinding r2, Function0 r3) {
        super(r2.a);
        this.a = r2;
        this.b = r3;
    }
}
