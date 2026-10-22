package com.obric.cae.location.cell;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends TelephonyManager.CellInfoCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f7043a;

    public f(c r1) {
        this.f7043a = r1;
    }

    @Override // android.telephony.TelephonyManager.CellInfoCallback
    public final void onCellInfo(List<CellInfo> r3) {
        List<CellInfo> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.d("StarLocation-cell", "requestCellInfoUpdate callback, count=" + r4.size());
        c r2 = this.f7043a;
        Set<String> r0 = c.f7034a;
        r2.a(r4);
    }
}
