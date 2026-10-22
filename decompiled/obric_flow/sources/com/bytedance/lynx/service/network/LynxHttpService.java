package com.bytedance.lynx.service.network;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.iesgurd.settings.b;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.ILynxHttpService;
import ko.i;
import nm.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxHttpService implements ILynxHttpService {
    private static final String KEY_CLIENT_CODE = "clientCode";
    private static final String KEY_ERROR_MESSAGE = "errorMessage";
    private static final String KEY_NEED_COMMON_PARAMS = "needCommonParams";
    private static final String KEY_PRIORITY_LEVEL = "priorityLevel";
    private static final String KEY_URL_PARAMS = "params";
    private static final String TAG = "LynxHttpService";
    private static volatile LynxHttpService mInstance;

    private LynxHttpService() {
    }

    private void doRequest(@NonNull HttpRequest r5, @NonNull i r10, a r11, boolean r12) {
        LynxLog.b(2, "NetworkModule", "call http request with url: " + r5.f9926b);
        TraceEvent.c("NetworkModule.call");
        new b(r5, r12).a();
        throw null;
    }

    public static LynxHttpService getInstance() {
        if (mInstance != null) goto L16;
        monitor-enter(LynxHttpService.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L11;
        mInstance = new LynxHttpService();     // Catch: Throwable -> L9
    L11:
        monitor-exit(LynxHttpService.class);     // Catch: Throwable -> L9
    L16:
        return mInstance;
    }

    @Override // com.lynx.tasm.service.ILynxHttpService
    public void request(@NonNull HttpRequest r5, @NonNull i r10) {
        doRequest(r5, r10, null, false);
    }

    @Override // com.lynx.tasm.service.ILynxHttpService
    public void requestStreaming(@NonNull HttpRequest r5, @NonNull i r10, @NonNull a r11) {
        doRequest(r5, r10, r11, true);
    }
}
