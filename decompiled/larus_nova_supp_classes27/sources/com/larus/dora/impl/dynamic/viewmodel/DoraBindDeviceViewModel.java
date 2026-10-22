package com.larus.dora.impl.dynamic.viewmodel;

import android.bluetooth.le.ScanCallback;
import android.os.SystemClock;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device.scan.j;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewmodel/DoraBindDeviceViewModel;", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel;", "<init>", "()V", "singleExecutor", "Ljava/util/concurrent/ExecutorService;", "doraScanCallback", "Landroid/bluetooth/le/ScanCallback;", "_scanDialogSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/scan/ScanDeviceModel;", "scanDialogSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getScanDialogSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_scanDeviceFlow", "Lcom/bytedance/dora/device/DoraDevice;", "scanDeviceFlow", "getScanDeviceFlow", "startScan", "", "productId", "", "(Ljava/lang/Integer;)V", "stopScan", "from", "", "realStopScan", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraBindDeviceViewModel extends DoraDynamicViewModel {
    private MutableSharedFlow<DoraDevice> _scanDeviceFlow;
    private MutableSharedFlow<j> _scanDialogSharedFlow;
    private ScanCallback doraScanCallback;
    private final d1<DoraDevice> scanDeviceFlow;
    private final d1<j> scanDialogSharedFlow;
    private ExecutorService singleExecutor;

    public static /* synthetic */ void yo(DoraBindDeviceViewModel r0, boolean r1, Ref.BooleanRef r2, Ref.ObjectRef r3) {
        startScan$lambda$0(r0, r1, r2, r3);
    }

    private final void realStopScan() {
        if (this.doraScanCallback == null) goto L6;
        g49.d.d(DoraDynamicViewModel.TAG, "realStopScan");
        kj4.a.g().stopScan(this.doraScanCallback);
        this.doraScanCallback = null;
        return;
    }

    public DoraBindDeviceViewModel() {
        MutableSharedFlow<j> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._scanDialogSharedFlow = r3;
        this.scanDialogSharedFlow = r3;
        MutableSharedFlow<DoraDevice> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._scanDeviceFlow = r0;
        this.scanDeviceFlow = r0;
        g49.d.d(DoraDynamicViewModel.TAG, "##init##");
        this.singleExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("DoraBindDeviceViewModel"));
    }

    public final d1<DoraDevice> getScanDeviceFlow() {
        return this.scanDeviceFlow;
    }

    public final d1<j> getScanDialogSharedFlow() {
        return this.scanDialogSharedFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_scanDeviceFlow$p(DoraBindDeviceViewModel r0) {
        return r0._scanDeviceFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_scanDialogSharedFlow$p(DoraBindDeviceViewModel r0) {
        return r0._scanDialogSharedFlow;
    }

    private final void stopScan(String r3) {
        g49.d.d(DoraDynamicViewModel.TAG, "stopScan: <- " + r3);
        if (this.doraScanCallback == null) goto L6;
        kj4.a.g().stopScan(this.doraScanCallback);
        this.doraScanCallback = null;
        return;
    }

    public final void startScan(Integer r5) {
        g49.d.d(DoraDynamicViewModel.TAG, "startScan");
        if (kj4.a.g().getDeviceList() != null) goto L5;
        CollectionsKt.emptyList();
    L5:
        final Ref.BooleanRef r6 = new Ref.BooleanRef();
        final boolean r0 = !com.larus.dora.impl.core.j.a(AppHost.a.getApplication()).isEmpty();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        ExecutorService r2 = this.singleExecutor;
        if (r2 == null) goto L9;
        r2.submit(new a(this, r0, r6, r1));
        return;
    }

    public static final /* synthetic */ void access$stopScan(DoraBindDeviceViewModel r0, String r1) {
        r0.stopScan(r1);
    }

    private static final void startScan$lambda$0(final DoraBindDeviceViewModel r8, final boolean r9, final Ref.BooleanRef r10, final Ref.ObjectRef r11) {
        r8.realStopScan();
        final Ref.LongRef r4 = new Ref.LongRef();
        r4.element = SystemClock.elapsedRealtime();
        final Set<String> r5 = com.larus.dora.impl.core.j.a(AppHost.a.getApplication());
        r8.doraScanCallback = new DoraBindDeviceViewModel$startScan$1$1(r8, r9, r10, r4, r5, r11);
        g49.d.d(DoraDynamicViewModel.TAG, "startScan: start");
        kj4.a.g().scan(CollectionsKt.mutableListOf(new String[]{"0000FD7B-0000-1000-8000-00805F9B34FB"}), r8.doraScanCallback);
    }
}
