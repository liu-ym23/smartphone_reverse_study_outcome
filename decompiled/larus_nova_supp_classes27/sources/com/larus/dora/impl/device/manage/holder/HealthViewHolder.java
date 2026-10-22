package com.larus.dora.impl.device.manage.holder;

import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementHealthBinding;
import com.larus.dora.impl.device.manage.o0;
import com.larus.dora.impl.device.manage.p0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/HealthViewHolder;", "Lcom/larus/dora/impl/device/manage/holder/BaseViewHolder;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementHealthBinding;", "onHealthClick", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementHealthBinding;Lkotlin/jvm/functions/Function1;)V", "onBind", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HealthViewHolder extends BaseViewHolder<p0> {
    public static final /* synthetic */ int c = 0;
    public final LarusItemDoraGDeviceManagementHealthBinding a;
    public final Function1<String, Unit> b;

    public static final class a {
    }

    static {
    }

    public HealthViewHolder() {
        throw null;
    }

    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void U3(p0 r3) {
        p0 r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        final o0 r5 = (o0) r4;
        g49.d.d("HealthViewHolder", "onBind");
        this.a.f.setText(r5.b);
        this.a.d.setText(r5.c);
        this.a.c.setText(r5.e);
        this.a.e.setText(r5.d);
        this.a.a.setOnClickListener(new m(this, r5));
        this.a.b.setOnClickListener(new n(this, r5));
    }

    public HealthViewHolder(LarusItemDoraGDeviceManagementHealthBinding r2, Function1 r3) {
        super(r2.a);
        this.a = r2;
        this.b = r3;
    }
}
