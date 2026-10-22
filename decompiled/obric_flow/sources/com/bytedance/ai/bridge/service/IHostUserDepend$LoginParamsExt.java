package com.bytedance.ai.bridge.service;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/bytedance/ai/bridge/service/IHostUserDepend$LoginParamsExt", "", "<init>", "()V", "", "keepOpen", "Z", "getKeepOpen", "()Z", "setKeepOpen", "(Z)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IHostUserDepend$LoginParamsExt {
    private boolean keepOpen;

    public IHostUserDepend$LoginParamsExt() {
        this.keepOpen = true;
    }

    public final boolean getKeepOpen() {
        return this.keepOpen;
    }

    public final void setKeepOpen(boolean r5) {
        this.keepOpen = r5;
    }
}
