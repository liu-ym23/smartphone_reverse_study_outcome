package com.obric.memorydata.sdk.screencapture;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/memorydata/sdk/screencapture/ScreenCaptureManager$captureCurrentRemote$1", "Lcom/obric/memorydata/sdk/screencapture/ICaptureCurrentCallback$Stub;", "onCaptured", "", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onError", "errorCode", "", "errorMessage", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenCaptureManager$captureCurrentRemote$1 extends ICaptureCurrentCallback.Stub {
    final /* synthetic */ b $dispatcher;

    public ScreenCaptureManager$captureCurrentRemote$1(b r1) {
        this.$dispatcher = r1;
    }

    @Override // com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback
    public void onCaptured(ScreenData r4) {
        b r0 = this.$dispatcher;
        r0.a.invoke(new a(r0, r4));
    }

    @Override // com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback
    public void onError(int r3, String r4) {
        b r5 = this.$dispatcher;
        r5.a.invoke(new a(r5, null));
    }
}
