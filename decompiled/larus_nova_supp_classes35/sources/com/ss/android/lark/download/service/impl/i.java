package com.ss.android.lark.download.service.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.pb.compliance.IMFileRiskTag;
import com.ss.android.lark.pb.compliance.MGetIMFileRiskTagResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements SdkSender.IParser<List<wbb.d.c>> {
    public i() {
    }

    public final Object parse(byte[] r6) throws IOException {
        List r7 = ((MGetIMFileRiskTagResponse) MGetIMFileRiskTagResponse.ADAPTER.decode(r6)).mresult;
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r7.size()) goto L6;
        IMFileRiskTag r2 = (IMFileRiskTag) ListProtector.get(r7, r1);
        String r4 = r2.mobject_id;
        r2.mis_risk_tag_exist.booleanValue();
        r2.mis_risk_file.booleanValue();
        r0.add(new wbb.d.c(r2.mrestrict_operation.booleanValue()));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
