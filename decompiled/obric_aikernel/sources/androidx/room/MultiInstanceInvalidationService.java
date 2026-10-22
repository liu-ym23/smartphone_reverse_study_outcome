package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalRoomApi
public final class MultiInstanceInvalidationService extends Service {
    private final IMultiInstanceInvalidationService.Stub binder;
    private final RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList;
    private final Map<Integer, String> clientNames;
    private int maxClientId;

    public MultiInstanceInvalidationService() {
        this.clientNames = new LinkedHashMap();
        this.callbackList = new MultiInstanceInvalidationService$callbackList$1(this);
        this.binder = new MultiInstanceInvalidationService$binder$1(this);
    }

    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> getCallbackList$room_runtime_release() {
        return this.callbackList;
    }

    public final Map<Integer, String> getClientNames$room_runtime_release() {
        return this.clientNames;
    }

    public final int getMaxClientId$room_runtime_release() {
        return this.maxClientId;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        Intrinsics.checkNotNullParameter(r10, "intent");
        return this.binder;
    }

    public final void setMaxClientId$room_runtime_release(int r10) {
        this.maxClientId = r10;
    }
}
