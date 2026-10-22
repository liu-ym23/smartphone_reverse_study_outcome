package com.bytedance.android.live.lynx.components;

import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements k7a.a {
    public final boolean a;

    public n() {
        this.a = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
    }

    public final void loadDynamicComponent(String r4, k7a.a.a r5) {
        if (r4 == null) goto L16;
        WebResourceResponse r1 = com.bytedance.android.livesdk.gecko.n.b.c(r4);
        if (r1 == null) goto L9;
        InputStream r2 = r1.getData();
        if (r2 == null) goto L9;
        byte[] r3 = ByteStreamsKt.readBytes(r2);
    L10:
        if (r3 == null) goto L14;
        if (r5 == null) goto L13;
        r5.a(r3, null);
        Unit r6 = Unit.INSTANCE;
    L15:
        if (r6 == null) goto L16;
        return;
    L13:
        r6 = null;
        goto L15
    L14:
        ((TemplateApi) RetrofitUtils.createOkRetrofit(r4, null, null, null).create(TemplateApi.class)).getTemplate(r4).enqueue(new m(this, r5, r4));
        r6 = Unit.INSTANCE;
    L9:
        r3 = null;
    L16:
        if (r5 == null) goto L20;
        r5.a(null, new Exception("Url is null"));
        Unit r7 = Unit.INSTANCE;
        return;
    }
}
