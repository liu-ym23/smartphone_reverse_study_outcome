package com.obric.cae.utils.bridge;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/obric/cae/utils/bridge/CaeLocationBridgeApi;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "runIndoorCheck", "", "withoutWifi", "CommSenseAAR_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CaeLocationBridgeApi {
    public CaeLocationBridgeApi(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        com.obric.cae.location.indoor.a.a().a(r4);
    }

    @PythonBridgeMethod
    public final boolean runIndoorCheck(boolean r1) {
        return com.obric.cae.location.indoor.a.a().a("python_bridge");
    }
}
