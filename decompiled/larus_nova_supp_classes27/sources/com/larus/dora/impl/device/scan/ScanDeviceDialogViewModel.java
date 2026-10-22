package com.larus.dora.impl.device.scan;

import android.bluetooth.le.ScanCallback;
import android.os.SystemClock;
import androidx.lifecycle.ViewModel;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/device/scan/ScanDeviceDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "singleExecutor", "Ljava/util/concurrent/ExecutorService;", "doraScanCallback", "Landroid/bluetooth/le/ScanCallback;", "_scanDialogSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/scan/ScanDeviceModel;", "scanDialogSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getScanDialogSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "startScan", "", "stopScan", "realStopScan", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanDeviceDialogViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "ScanDeviceDialogViewModel";
    private MutableSharedFlow<j> _scanDialogSharedFlow;
    private ScanCallback doraScanCallback;
    private final d1<j> scanDialogSharedFlow;
    private ExecutorService singleExecutor;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void Mo(ScanDeviceDialogViewModel r0) {
        startScan$lambda$0(r0);
    }

    public static /* synthetic */ void yo(ScanDeviceDialogViewModel r0) {
        stopScan$lambda$1(r0);
    }

    private final void realStopScan() {
        if (this.doraScanCallback != null) goto L5;
        return;
    L5:
        if (l69.a.c(TAG) == true) goto L8;
        this.doraScanCallback = null;
        g49.d.e(TAG, "realStopScan: bluetooth scan permission not granted, skip stopScan");
        return;
    L8:
        g49.d.d(TAG, "realStopScan");
        kj4.a.g().stopScan(this.doraScanCallback);     // Catch: Throwable -> L11
    L13:
        this.doraScanCallback = null;
        return;
    L11:
        th = move-exception;
        g49.d.c(TAG, "realStopScan: stopScan exception", th);
        goto L13
    }

    public final void startScan() {
        g49.d.d(TAG, "startScan");
        ExecutorService r0 = this.singleExecutor;
        if (r0 == null) goto L6;
        r0.submit(new d(this));
        return;
    }

    public final void stopScan() {
        g49.d.d(TAG, "stopScan");
        ExecutorService r0 = this.singleExecutor;
        if (r0 == null) goto L6;
        r0.submit(new e(this));
        return;
    }

    public ScanDeviceDialogViewModel() {
        MutableSharedFlow<j> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._scanDialogSharedFlow = r0;
        this.scanDialogSharedFlow = r0;
        g49.d.d(TAG, "##init##");
        this.singleExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory(TAG));
    }

    public void onCleared() {
        super.onCleared();
        g49.d.d(TAG, "##onCleared##");
        stopScan();
        ExecutorService r0 = this.singleExecutor;
        if (r0 == null) goto L5;
        r0.shutdown();
    L5:
        this.singleExecutor = null;
    }

    public final d1<j> getScanDialogSharedFlow() {
        return this.scanDialogSharedFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_scanDialogSharedFlow$p(ScanDeviceDialogViewModel r0) {
        return r0._scanDialogSharedFlow;
    }

    private static final void startScan$lambda$0(final ScanDeviceDialogViewModel r3) {
        r3.realStopScan();
        final Ref.LongRef r0 = new Ref.LongRef();
        r0.element = SystemClock.elapsedRealtime();
        final Set<String> r1 = com.larus.dora.impl.core.j.a(AppHost.a.getApplication());
        r3.doraScanCallback = new ScanDeviceDialogViewModel$startScan$1$1(r3, r0, r1);
        g49.d.d(TAG, "startScan: start");
        if (l69.a.c(TAG) == true) goto L11;
        g49.d.e(TAG, "startScan: bluetooth scan permission not granted, skip scan");
        return;
    L11:
        kj4.a.g().scan(CollectionsKt.mutableListOf(new String[]{"0000FD7B-0000-1000-8000-00805F9B34FB"}), r3.doraScanCallback);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        g49.d.c(TAG, "startScan: scan exception", th);
    }

    private static final void stopScan$lambda$1(ScanDeviceDialogViewModel r0) {
        r0.realStopScan();
    }
}
