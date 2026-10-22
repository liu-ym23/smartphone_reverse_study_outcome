package s1;

import android.app.Application;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.HandlerThread;
import android.widget.Button;
import com.bytedance.bdlocation.BDLocation;
import com.google.android.material.datepicker.g0;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.cae.R;
import com.obric.cae.cloud.CloudService;
import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimPredictionResultActivity;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppRepository;
import com.obric.cae.userAware.UserAwareService;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance.BluetoothGattCentral;
import com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance.BluetoothGattPeripheral;
import com.ttnet.org.chromium.base.task.SequencedTaskRunnerImpl;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12009b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f12010m;

    public /* synthetic */ x(int r8, Object r10, Object r11) {
        this.f12008a = r8;
        this.f12009b = r10;
        this.f12010m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f12008a;
        Object r10 = this.f12010m;
        Object r11 = this.f12009b;
        switch(r8) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L5;
            default: goto L27;
        };
    L5:
        BluetoothGattPeripheral.a((BluetoothGattPeripheral) r11, (BluetoothGattService[]) r10);
        return;
    L7:
        BluetoothGattCentral.a((BluetoothGattCentral) r11, (ScanSettings) r10);
        return;
    L9:
        AwareStateListener.a((AwareStateListener) r11, (String) r10);
        return;
    L11:
        WifiAwareInfoManager.k((WifiAwareInfoManager) r11, (List) r10);
        return;
    L13:
        UserAwareService.c((UserAwareService) r11, (HandlerThread) r10);
        return;
    L15:
        CarkeyAppRepository.f((CarkeyAppRepository.ResultCallback) r11, r10);
        return;
    L17:
        BdimPredictionResultActivity.f((BdimPredictionResultActivity) r11, (Button) r10);
        return;
    L19:
        CaeSoftApManager.b((CaeSoftApManager) r11, (CaeSoftApManager.c) r10);
        return;
    L21:
        CloudService.a((Context) r11, (Application) r10);
        return;
    L23:
        com.google.android.material.datepicker.d r12 = (com.google.android.material.datepicker.d) r11;
        TextInputLayout r13 = r12.f4662a;
        Context r14 = r13.getContext();
        r13.setError(r14.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(r14.getString(R.string.mtrl_picker_invalid_format_use), new Object[]{((String) r10).replace(' ', 160)}) + "\n" + String.format(r14.getString(R.string.mtrl_picker_invalid_format_example), new Object[]{r12.f4664m.format(new Date(g0.f().getTimeInMillis())).replace(' ', 160)}));
        r12.a();
        return;
    L25:
        ((o5.x) r11).f9733a.onLocationChanged((BDLocation) r10);
        return;
    L27:
        SequencedTaskRunnerImpl.a((SequencedTaskRunnerImpl) r11, (Runnable) r10);
    }
}
