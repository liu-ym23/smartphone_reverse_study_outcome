package androidx.appcompat.app;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.scan.wifi.WifiInfoManager;
import com.google.protobuf.LegacyUnredactedTextFormat;
import com.obric.cae.BWDL.BwdlDrop.fileTransmission.FileInfoTransmission;
import com.obric.cae.CaeApplication;
import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.libs.softap.ICaeSoftApCallback;
import com.obric.cae.location.cell.StarCellManager;
import com.obric.cae.smartBluetooth.btaware.SmartBluetoothInCarAware;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimResultCollector;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppRepository;
import com.obric.cae.userAware.SplitWifiScanner;
import com.obric.cae.userAware.SubwayFusionAware.SubwayEventProcessor;
import com.obric.cae.userAware.SubwayFusionAware.SubwayStateManager;
import com.obric.cae.userAware.UserAwareService;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.wifi.CaeWifiDatabaseService;
import com.sdk.bwdl.BWDLDevice;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.Promise;
import j1.i0;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f676b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f677m;

    public /* synthetic */ r(int r8, Object r10, Object r11) {
        this.f675a = r8;
        this.f676b = r10;
        this.f677m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f675a;
        Object r10 = this.f677m;
        Object r11 = this.f676b;
        switch(r8) {
            case 0: goto L49;
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L43;
            case 4: goto L41;
            case 5: goto L39;
            case 6: goto L37;
            case 7: goto L35;
            case 8: goto L33;
            case 9: goto L31;
            case 10: goto L29;
            case 11: goto L27;
            case 12: goto L25;
            case 13: goto L23;
            case 14: goto L21;
            case 15: goto L19;
            case 16: goto L17;
            case 17: goto L15;
            case 18: goto L13;
            case 19: goto L11;
            case 20: goto L9;
            case 21: goto L7;
            case 22: goto L5;
            default: goto L56;
        };
    L5:
        CaeWifiDatabaseService.b((CaeWifiDatabaseService) r11, (Runnable) r10);
        return;
    L7:
        WifiAwareInfoManager.b((WifiAwareInfoManager) r11, (List) r10);
        return;
    L9:
        WifiAwareInfoManager.f((WifiAwareInfoManager) r11, (Bundle) r10);
        return;
    L11:
        SubwayStateManager.b((SubwayStateManager) r11, (String) r10);
        return;
    L13:
        SubwayEventProcessor.a((SubwayEventProcessor) r11, (String) r10);
        return;
    L15:
        SplitWifiScanner.b((SplitWifiScanner) r11, (Set) r10);
        return;
    L17:
        CarkeyAppRepository.a((CarkeyAppRepository.ResultCallback) r11, (Throwable) r10);
        return;
    L19:
        BdimResultCollector.b((BdimResultCollector) r11, (Context) r10);
        return;
    L21:
        SmartBluetoothInCarAware.a((SmartBluetoothInCarAware) r11, (String) r10);
        return;
    L23:
        StarCellManager.b((StarCellManager) r11, (Executor) r10);
        return;
    L25:
        CaeSoftApManager.a((CaeSoftApManager) r11, (ICaeSoftApCallback) r10);
        return;
    L27:
        CaeApplication.c((Context) r11, (UserAwareService) r10);
        return;
    L29:
        FileInfoTransmission.a((BWDLDevice) r11, (byte[]) r10);
        return;
    L31:
        LegacyUnredactedTextFormat.a((String[]) r11, r10);
        return;
    L33:
        ((BDLocationCallback) r11).onError((BDLocationException) r10);
        return;
    L35:
        Looper r12 = o5.g.f9674l;
        ((BDLocationCallback) r11).onLocationChanged((BDLocation) r10);
        return;
    L37:
        WifiInfoManager.e((WifiInfoManager) r11, (Context) r10);
        return;
    L39:
        LocationUtil.a((LocationUploadExtra) r11, (LocationUploadCallback) r10);
        return;
    L41:
        ((a2.a) r11).a((BDLocation) r10);
        return;
    L43:
        i0.a((i0) r11, (ga.a) r10);
        return;
    L45:
        he.i.f((androidx.room.n) r11, "this$0");
        he.i.f((String) r10, "$sql");
        throw null;
    L47:
        ((z.f.e) r11).d((Typeface) r10);
        return;
    L49:
        s.a r13 = (s.a) r11;
        Runnable r14 = (Runnable) r10;
        r13.getClass();
        r14.run();     // Catch: Throwable -> L53
        r13.a();
        return;
    L53:
        th = move-exception;
        r13.a();
        throw th;
    L56:
        Promise.b((Callback) r11, r10);
    }
}
