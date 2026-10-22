package com.ss.android.lark.dynamicconfig.v2.impl.fetcher;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.settings.v1.GetUserSettingsResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements SdkSender.IParser<DomainSettings> {
    public d() {
    }

    public final Object parse(byte[] r3) throws IOException {
        GetUserSettingsResponse r4 = (GetUserSettingsResponse) GetUserSettingsResponse.ADAPTER.decode(r3);
        StringBuilder r0 = new StringBuilder("GetUserSettingsResponse, size: ");
        Map r1 = r4.settings;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        r0.append(r2);
        Log.d("DomainFetcherImpl", r0.toString());
        return r4.domains;
    L5:
        r2 = r1.size();
        goto L6
    }
}
