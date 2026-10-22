package com.bytedance.bpea.entry.api.device.info;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/telephony/CellInfo;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class TelephonyManagerEntry$Companion$getAllCellInfoUnsafe$1 extends Lambda implements Function0<List<CellInfo>> {
    final /* synthetic */ TelephonyManager $this_getAllCellInfoUnsafe;

    public TelephonyManagerEntry$Companion$getAllCellInfoUnsafe$1(TelephonyManager r1) {
        this.$this_getAllCellInfoUnsafe = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<CellInfo> m1640invoke() {
        return this.$this_getAllCellInfoUnsafe.getAllCellInfo();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1640invoke();
    }
}
