package com.obric.assistant.dora;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0003¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/dora/ObricVendorBluetoothQueryServiceImpl;", "Lcom/obric/assistant/spi/dora/IObricVendorBluetoothQueryService;", "<init>", "()V", "queryVendorBluetoothSppStatus", "Lcom/obric/assistant/spi/dora/VendorBluetoothSppStatus;", "isSppAvailable", "", "device", "Landroid/bluetooth/BluetoothDevice;", "uuid", "Ljava/util/UUID;", "getConnectedBluetoothHeadsetDevice", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVendorBluetoothQueryServiceImpl implements IObricVendorBluetoothQueryService {

    public static final class a {
    }

    static {
    }

    public ObricVendorBluetoothQueryServiceImpl() {
    }

    @Override // com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService
    public final lga.a a() {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        boolean r1 = false;
        if (r0 != null) goto L6;
    L18:
        BluetoothDevice r2 = null;
    L24:
        if (r2 != null) goto L26;
        return null;
    L26:
        UUID r3 = UUID.fromString("00002499-0000-1000-8000-00805f9b34fb");
        UUID r4 = UUID.fromString("00101020-4C42-0065-636E-614465747942");
        Intrinsics.checkNotNull(r3);
        boolean r5 = b(r2, r3);
        if (r5 == true) goto L30;
        Intrinsics.checkNotNull(r4);
        r1 = b(r2, r4);
    L30:
        String r6 = r2.getAddress();
        if (r6 != null) goto L34;
        r6 = "";
    L34:
        return new lga.a(r6, r5, r1);
    L6:
        if (r0.isEnabled() == false) goto L18;
        CountDownLatch r7 = new CountDownLatch(1);
        BluetoothDevice[] r8 = new BluetoothDevice[1];
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L11
        Object r10 = Result.constructor-impl(Boolean.valueOf(r0.getProfileProxy(AppHost.a.getApplication(), new h(r7, r8, r0), 1)));     // Catch: Throwable -> L11
    L13:
        Boolean r11 = Boolean.FALSE;
        if (Result.isFailure-impl(r10) == false) goto L17;
        r10 = r11;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L18;
        Result.constructor-impl(Boolean.valueOf(r7.await(500, TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L21
    L23:
        r2 = r8[0];
    L21:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static boolean b(BluetoothDevice r5, UUID r6) {
        if (kj4.a.g().isReady() == 0) goto L40;
        FLogger.a.w("ObricVendorBluetooth", "isSppAvailable: DoraAdapter is not ready");
        return false;
    L40:
        BluetoothSocket r7 = r5.createRfcommSocketToServiceRecord(r6);     // Catch: Throwable -> L19
        if (r7 != null) goto L10;
        FLogger.a.w("ObricVendorBluetooth", "isSppAvailable: createRfcommSocketToServiceRecord return null");     // Catch: Throwable -> L17
        return false;
    L10:
        r7.connect();     // Catch: Throwable -> L17
        r7.close();     // Catch: Throwable -> L13
        return true;
    L13:
        th = move-exception;
        FLogger.a.e("ObricVendorBluetooth", "isSppAvailable: close socket error", th);
        return true;
    L17:
        th = th;
    L42:
        FLogger.a.e("ObricVendorBluetooth", "isSppAvailable exception", th);     // Catch: Throwable -> L28
        if (r7 != null) goto L38;
    L27:
        return false;
    L38:
        r7.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        FLogger.a.e("ObricVendorBluetooth", "isSppAvailable: close socket error", th);
    L28:
        th = move-exception;
        if (r7 != null) goto L35;
    L34:
        throw th;
    L35:
        r7.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        FLogger.a.e("ObricVendorBluetooth", "isSppAvailable: close socket error", th);
    L19:
        th = th;
        r7 = null;
        goto L42
    }
}
