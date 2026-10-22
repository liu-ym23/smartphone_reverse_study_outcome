package com.obric.aikernel.runtime.utils;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/obric/aikernel/runtime/utils/ILogger;", "", "aeeLog", "", "priority", "", LocationMonitorConst.TAG, "", Params.CONTENT, "log", "message", "level", "tracking", "key", "data", "Lorg/json/JSONObject;", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface c {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(c r2, String r3, String r4, int r5, int r6, Object r7) {
            c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r5 = 3;
        L7:
            r8.a(r3, r4, r5);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
    }

    void a(int r1, String r2, String r3);

    void a(String r1, String r2, int r3);

    void a(String r1, JSONObject r2);
}
