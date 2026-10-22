package com.bytedance.ai.process;

import android.os.RemoteException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"com/bytedance/ai/process/AISDKRemoteServiceProxy$ServiceDeadException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ai-sdk-multiprocess_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AISDKRemoteServiceProxy$ServiceDeadException extends Exception {
    public AISDKRemoteServiceProxy$ServiceDeadException() {
        super("remote service is dead", null);
    }

    public AISDKRemoteServiceProxy$ServiceDeadException(RemoteException r5) {
        super("remote service is dead", r5);
    }
}
