package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.download.IECDownloadAppService;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECDownloadAppAdMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "Lqi/a;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECDownloadAppAdMethod extends ECBaseBridgeMethod implements qi.a {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECDownloadAppAdMethod() {
        this.e = "iesecDownloadAppAd";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        Context r0 = getContext();
        if (r0 != null) goto L14;
        return;
    L14:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L11
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L11
        r12.put("event_tag", r10.opt("eventTag"));     // Catch: Exception -> L11
        r12.put("pkg_name", r10.opt("pkgName"));     // Catch: Exception -> L11
        r12.put("download_url", r10.opt("downloadURL"));     // Catch: Exception -> L11
        r12.put("open_url", r10.opt("openURL"));     // Catch: Exception -> L11
        r1.put("data", r12);     // Catch: Exception -> L11
        int r13 = ECSdk.a;     // Catch: Exception -> L11
        IECHostService r14 = (IECHostService) ECSdk.a(IECHostService.class);     // Catch: Exception -> L11
        if (r14 == null) goto L12;
        IECDownloadAppService r15 = r14.getIECDownloadAppService();     // Catch: Exception -> L11
        if (r15 == null) goto L12;
        r15.downloadApp(r0, r1, this);     // Catch: Exception -> L11
    L12:
        r11.onSuccess(new JSONObject());
        return;
    L11:
        r11.onFailed(-1, "download failed");
        goto L12
    }
}
