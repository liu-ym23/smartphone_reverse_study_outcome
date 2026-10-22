package com.obric.memorydata.sdk.screencapture;

import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/sdk/screencapture/ScreenCaptureManager$registerRemote$1", "Lcom/obric/memorydata/sdk/screencapture/IEventReactionCallback$Stub;", "onEvent", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onError", "errorCode", "", "errorMessage", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenCaptureManager$registerRemote$1 extends IEventReactionCallback.Stub {
    final /* synthetic */ c $callback;
    final /* synthetic */ boolean $isMainThread;

    public static /* synthetic */ void a(int r1, String r2) {
        onError$lambda$1(null, r1, r2);
    }

    public static /* synthetic */ void b(ScreenEvent r1, ScreenData r2) {
        onEvent$lambda$0(null, r1, r2);
    }

    public ScreenCaptureManager$registerRemote$1(boolean r1, c r2) {
        this.$isMainThread = r1;
    }

    @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
    public void onError(final int r3, final String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        if (this.$isMainThread == false) goto L7;
        ScreenCaptureManager.access$getMainHandler$p().post(new p(r3, r4));
        ScreenCaptureManager.access$autoUnbindServiceIfNeed(ScreenCaptureManager.INSTANCE);
        return;
    L7:
        throw null;
    }

    @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
    public void onEvent(final ScreenEvent r3, final ScreenData r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "data");
        if (this.$isMainThread == false) goto L7;
        ScreenCaptureManager.access$getMainHandler$p().post(new o(r3, r4));
        ScreenCaptureManager.access$autoUnbindServiceIfNeed(ScreenCaptureManager.INSTANCE);
        return;
    L7:
        throw null;
    }

    private static final void onError$lambda$1(c r0, int r1, String r2) {
        r0.onError();
    }

    private static final void onEvent$lambda$0(c r0, ScreenEvent r1, ScreenData r2) {
        r0.onEvent();
    }
}
