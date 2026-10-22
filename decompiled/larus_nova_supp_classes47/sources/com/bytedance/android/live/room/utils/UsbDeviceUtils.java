package com.bytedance.android.live.room.utils;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class UsbDeviceUtils {
    public static volatile UsbManager a;
    public static final UsbDeviceUtils b = null;

    public UsbDeviceUtils() {
    }

    static {
        b = new UsbDeviceUtils();
    }

    public static boolean a() {
        if (a != null) goto L5;
        u.l().sendLog("livesdk_live_broadcast_business_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_function", "checkHasUsbDevice"), TuplesKt.to("message", "usbManager is null")}), new Object[]{Room.class});
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UsbDeviceUtils$checkHasUsbDevice$1(null), 3, null);
    L5:
        UsbManager r0 = a;
        if (r0 == null) goto L13;
        HashMap<String, UsbDevice> r1 = r0.getDeviceList();
        if (r1 != null) goto L10;
        return false;
    L10:
        if ((!r1.isEmpty()) != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public static List b() {
        if (a != null) goto L5;
        u.l().sendLog("livesdk_live_broadcast_business_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_function", "getConnectedUsbDevices"), TuplesKt.to("message", "usbManager is null")}), new Object[]{Room.class});
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UsbDeviceUtils$getConnectedUsbDevices$1(null), 3, null);
    L5:
        UsbManager r0 = a;
        if (r0 == null) goto L9;
        HashMap<String, UsbDevice> r1 = r0.getDeviceList();
        if (r1 == null) goto L9;
    L10:
        ArrayList r2 = new ArrayList();
        Iterator<UsbDevice> r3 = r1.values().iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        r2.add(c(r3.next()));
        goto L12
    L14:
        return r2;
    L9:
        r1 = new HashMap();
        goto L10
    }

    public static String c(UsbDevice r2) {
        Intrinsics.checkNotNullParameter(r2, "usbDevice");
        return "productId" + r2.getProductId() + "_vendorId:" + r2.getVendorId();
    }

    public final Object d(Continuation<? super UsbManager> r6) {
        if ((r6 instanceof UsbDeviceUtils$initUsbManager$1) == false) goto L7;
        UsbDeviceUtils$initUsbManager$1 r0 = (UsbDeviceUtils$initUsbManager$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L19:
        a = (UsbManager) r7;
    L21:
        return a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (a != null) goto L21;
        CoroutineDispatcher r8 = Dispatchers.getIO();
        UsbDeviceUtils$initUsbManager$2 r4 = new UsbDeviceUtils$initUsbManager$2(null);
        r0.label = 1;
        r7 = BuildersKt.withContext(r8, r4, r0);
        if (r7 != r2) goto L19;
        return r2;
    L7:
        r0 = new UsbDeviceUtils$initUsbManager$1(this, r6);
        goto L8
    }
}
