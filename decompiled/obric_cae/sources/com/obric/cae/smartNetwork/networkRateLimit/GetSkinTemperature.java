package com.obric.cae.smartNetwork.networkRateLimit;

import android.os.IThermalEventListener;
import android.os.IThermalService;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Temperature;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class GetSkinTemperature {
    private static final String TAG = "GetSkinTemperature";
    private float mSkinTemp;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkRateLimit.GetSkinTemperature$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class PerfSkinThermalEventListener extends IThermalEventListener.Stub {
        final /* synthetic */ GetSkinTemperature this$0;

        private PerfSkinThermalEventListener(GetSkinTemperature r8) {
            this.this$0 = r8;
        }

        public void notifyThrottling(Temperature r8) {
            CaeLog.i(GetSkinTemperature.TAG, "PerfSkinThermalEventListener, temperature update: " + r8);
            GetSkinTemperature.access$100(this.this$0, r8.getValue());
        }

        public /* synthetic */ PerfSkinThermalEventListener(GetSkinTemperature r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public GetSkinTemperature() {
        this.mSkinTemp = -1.0f;
    }

    public static /* synthetic */ void access$100(GetSkinTemperature r8, float r10) {
        r8.setTemp(r10);
    }

    private synchronized void setTemp(float r8) {
        monitor-enter(this);
        this.mSkinTemp = r8;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized float getSkinTemperature() {
        monitor-enter(this);
        float r8 = this.mSkinTemp;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public void init() {
        IThermalService r8 = IThermalService.Stub.asInterface(ServiceManager.getService("thermalservice"));
        if (r8 != null) goto L11;
        CaeLog.e(TAG, "thermalService is null");
        return;
    L11:
        r8.registerThermalEventListenerWithType(new PerfSkinThermalEventListener(this, null), 3);     // Catch: RemoteException -> L8
        CaeLog.i(TAG, "register perf skin thermal event listener success");     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "register perf skin thermal event listener failed!", e);
    }
}
