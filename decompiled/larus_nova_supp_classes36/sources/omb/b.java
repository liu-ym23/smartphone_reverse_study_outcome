package omb;

import com.bytedance.lark.base.open.pkm.PkmBizType;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.bytedance.lark.base.open.pkm.c {
    public b() {
    }

    public final void onEvent(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "payload");
        if (Intrinsics.areEqual(r3, "JSSDKVersionInfo") == false) goto L9;
        PkmBizType r5 = a.a;
        String r6 = r4.get("db_sdk_update_version");
        if (r6 != null) goto L7;
        r6 = r4.get("db_sdk_version");
    L7:
        a.d = r6;
        Log.i("CardTemplatePkmManager", "JSSDKVersionInfo: " + a.d);
        return;
    L9:
        if (Intrinsics.areEqual(r3, "JSSDKVersionError") == false) goto L13;
        Log.w("CardTemplatePkmManager", "getJssdkInstallationVersion error: " + r4);
        return;
    }
}
