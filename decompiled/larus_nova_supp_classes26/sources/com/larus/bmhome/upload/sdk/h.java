package com.larus.bmhome.upload.sdk;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import mr9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(String r10, String r11, ContinuationImpl r12) {
        FLogger r0 = FLogger.a;
        r0.i("UploadAuthToken", "[fetch] start, scene:" + r10 + ", dataType:" + r11);
        Keva r1 = fs8.a.a;
        Intrinsics.checkNotNullParameter(r11, "dataType");
        UploadDataType.Companion.getClass();
        if (UploadDataType.a.a(r11) == true) goto L5;
    L17:
        fs8.a.b(false);
        m r2 = null;
    L18:
        if (r2 == null) goto L22;
        r0.i("UploadAuthToken", "[fetch] hit token cache, dataType:".concat(r11));
        return r2;
    L22:
        return BuildersKt.withContext(Dispatchers.getIO(), new UploadAuthTokenService$fetch$3(r11, r10, null), r12);
    L5:
        if (z2.a.uploaderUseCachedTokenEnable() == false) goto L17;
        String r3 = fs8.a.a.getString("image_token_data" + r11 + fs8.a.a(), "");
        if (r3 == null) goto L17;
        if (o0.d(r3) == false) goto L17;
        r2 = (m) GsonProtectorUtils.fromJson(new Gson(), r3, m.class);
        r0.d("UploaderCacheStrategy", "accessAuthToken success, tokenData: " + r2);
        mr9.b r4 = r2.a();
        if (r4 == null) goto L13;
        long r5 = r4.b();
    L15:
        if (r5 <= (AppHost.a.getAppClock().currentTimeMillis() + 300000)) goto L17;
        fs8.a.b(true);
        goto L18
    L13:
        r5 = -1;
        goto L15
    }
}
