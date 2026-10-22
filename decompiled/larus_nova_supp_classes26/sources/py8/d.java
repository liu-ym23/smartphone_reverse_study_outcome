package py8;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanFilter;
import android.companion.AssociationRequest;
import android.companion.BluetoothDeviceFilter;
import android.companion.BluetoothLeDeviceFilter;
import android.companion.CompanionDeviceManager;
import android.companion.DeviceFilter;
import android.os.ParcelUuid;
import com.larus.cdm.DeviceHandler;
import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1;
import com.larus.cdm.impl.FlowCompanionDeviceManagerDelegate;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class d implements b {
    public final CompanionDeviceManager a;

    @Override // py8.b
    public void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "deviceAddress");
    }

    @Override // py8.b
    public void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "deviceAddress");
    }

    @Override // py8.b
    public List<String> e() {
        return this.a.getAssociations();
    }

    public d(CompanionDeviceManager r2) {
        Intrinsics.checkNotNullParameter(r2, "companionDeviceManager");
        this.a = r2;
    }

    @Override // py8.b
    public void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
        this.a.disassociate(r2);
    }

    @Override // py8.b
    public boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "macAddress");
        List<String> r0 = this.a.getAssociations();
        FLogger.a.d("flow_cdm", "[hasAssociated] " + r0);
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (StringsKt.equals(r5, (String) r2, true) == false) goto L4;
    L10:
        return o0.d((String) r2);
    L8:
        r2 = null;
        goto L10
    }

    @Override // py8.b
    public final void c(String r8, FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1 r9) {
        Intrinsics.checkNotNullParameter(r8, "macAddress");
        Intrinsics.checkNotNullParameter(r9, "callback");
        FlowCompanionDeviceManagerDelegate.a.getClass();     // Catch: Exception -> L39
        oy8.a r0 = FlowCompanionDeviceManagerDelegate.f;     // Catch: Exception -> L39
        if (r0 == null) goto L6;
        int r1 = r0.getProductId();     // Catch: Exception -> L39
    L7:
        DeviceHandler.Device r2 = DeviceHandler.a(r1);     // Catch: Exception -> L39
        boolean r3 = false;
        if (r2.getScanUUID().length() <= 0) goto L10;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L28;
        if (DeviceHandler.a(r1) != DeviceHandler.Device.H_FREE_CLIP) goto L16;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L28;
        DeviceFilter<?> r10 = new BluetoothLeDeviceFilter.Builder().setScanFilter(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(r2.getScanUUID())).build()).build();     // Catch: IllegalArgumentException -> L25 Exception -> L39
    L35:
        if (r10 == null) goto L37;
        this.a.associate(new AssociationRequest.Builder().addDeviceFilter(r10).setSingleDevice(true).build(), new c(r9), null);     // Catch: Exception -> L39
        return;
    L37:
        r9.a("Invalid device params: UUID or MAC address is illegal/empty");     // Catch: Exception -> L39
        return;
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L39
    L34:
        r10 = null;
        goto L35
    L16:
        if (DeviceHandler.a(r1) == DeviceHandler.Device.H_FREE_PRO) goto L21;
        if (DeviceHandler.a(r1) == DeviceHandler.Device.H_FREE_BUDS_PRO) goto L21;
        r5 = false;
    L28:
        if (r8.length() <= 0) goto L30;
        r3 = true;
    L30:
        if (r3 == false) goto L34;
        if (BluetoothAdapter.checkBluetoothAddress(r8) == false) goto L34;
        r10 = new BluetoothDeviceFilter.Builder().setAddress(r8).build();     // Catch: Exception -> L39
        goto L35
    L10:
        r4 = false;
        goto L12
    L6:
        r1 = -1;
    L39:
        e = move-exception;
        e.printStackTrace();
        r9.a("Association init failed: " + e.getMessage());
    }
}
