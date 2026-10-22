package com.bytedance.ai.bridge.method.device.wifi;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/wifi/WifiError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", a.KEY_MSG, "", "<init>", "(Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;Ljava/lang/String;)V", "getErrNo", "()Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "getMessage", "()Ljava/lang/String;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WifiError extends Exception {
    private final f3.a errNo;
    private final String message;

    public final f3.a getErrNo() {
        return this.errNo;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public WifiError(f3.a r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "errNo");
        Intrinsics.checkNotNullParameter(r11, a.KEY_MSG);
        super(r11);
        this.errNo = r10;
        this.message = r11;
    }
}
