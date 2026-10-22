package androidx.room;

import android.widget.Button;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropEventHandler;
import com.obric.cae.BWDL.BwdlDrop.fileTransmission.FileInfoTransmission;
import com.obric.cae.libs.softap.CaeSoftApConfig;
import com.obric.cae.location.StarLocationService;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimPredictionResultActivity;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppRepository;
import com.obric.cae.softap.CaeSoftApService;
import com.sdk.bwdl.BWDLDevice;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2658b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f2659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f2660n;

    public /* synthetic */ m(CaeSoftApService r8, CaeSoftApConfig r10, String r11) {
        this.f2657a = 5;
        this.f2658b = r8;
        this.f2660n = r10;
        this.f2659m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f2657a;
        Object r10 = this.f2660n;
        Object r11 = this.f2659m;
        Object r12 = this.f2658b;
        switch(r8) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L15;
        };
    L5:
        CarkeyAppRepository.d((CarkeyAppRepository) r12, (Callable) r11, (CarkeyAppRepository.ResultCallback) r10);
        return;
    L7:
        BdimPredictionResultActivity.d((BdimPredictionResultActivity) r12, (String) r11, (Button) r10);
        return;
    L9:
        StarLocationService.e((StarLocationService) r12, (PrintWriter) r11, (String[]) r10);
        return;
    L11:
        FileInfoTransmission.b((BWDLDevice) r12, (BwdlDropEventHandler) r11, (BwdlDropDeviceManager) r10);
        return;
    L13:
        he.i.f((n) r12, "this$0");
        he.i.f((String) r11, "$sql");
        he.i.f((List) r10, "$inputArguments");
        throw null;
    L15:
        CaeSoftApService.J2((CaeSoftApService) r12, (CaeSoftApConfig) r10, (String) r11);
    }

    public /* synthetic */ m(Object r8, Object r10, Object r11, int r12) {
        this.f2657a = r12;
        this.f2658b = r8;
        this.f2659m = r10;
        this.f2660n = r11;
    }
}
