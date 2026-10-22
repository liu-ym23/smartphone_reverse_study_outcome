package com.larus.dora.impl.device_v2.viewholder;

import com.larus.dora.impl.databinding.LarusDoraHistoryDeviceInfoLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import e59.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import z49.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\f\u001a\u00020\b*\u00020\tH\u0002J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/device_v2/viewholder/HistoryDeviceInfoHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/device_v2/entity/HistoryDeviceListInfo;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraHistoryDeviceInfoLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraHistoryDeviceInfoLayoutBinding;)V", "show", "", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoBannerLayoutBinding;", "bannerType", "", "openSodaVipApplet", "bind", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryDeviceInfoHolder extends BaseViewHolder<c> {
    public static final /* synthetic */ int c = 0;
    public final LarusDoraHistoryDeviceInfoLayoutBinding b;

    public static final class a {
    }

    static {
    }

    public HistoryDeviceInfoHolder(LarusDoraHistoryDeviceInfoLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c r7, b r8, d59.b r9) {
        c r10 = r7;
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r8, "connectionState");
        LarusDoraHistoryDeviceInfoLayoutBinding r11 = this.b;
        if (r11 == null) goto L6;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new HistoryDeviceInfoHolder$bind$1$1(r10, r11, r9, null), 2, null);
        return;
    }
}
