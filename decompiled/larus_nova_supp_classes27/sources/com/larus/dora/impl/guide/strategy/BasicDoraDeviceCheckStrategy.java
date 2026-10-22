package com.larus.dora.impl.guide.strategy;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.network.HttpConst;
import com.larus.network.http.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class BasicDoraDeviceCheckStrategy {
    public static final /* synthetic */ int d = 0;
    public final BluetoothAdapter a;
    public Integer b;
    public BluetoothDevice c;

    public static final class a {
    }

    static {
    }

    public BasicDoraDeviceCheckStrategy() {
        Object r0 = AppHost.a.getApplication().getSystemService("bluetooth");
        BluetoothAdapter r2 = null;
        if ((r0 instanceof BluetoothManager) == false) goto L5;
        BluetoothManager r1 = (BluetoothManager) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.getAdapter();
    L8:
        this.a = r2;
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x017e -> B:83:0x0186). Please report as a decompilation issue!!! */
    public final Object b(Continuation<? super Boolean> r13) {
        if ((r13 instanceof BasicDoraDeviceCheckStrategy$isConditionMet$1) == false) goto L7;
        BasicDoraDeviceCheckStrategy$isConditionMet$1 r0 = (BasicDoraDeviceCheckStrategy$isConditionMet$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        boolean r4 = r0.Z$0;
        BluetoothDevice r7 = (BluetoothDevice) r0.L$1;
        Iterator r8 = (Iterator) r0.L$0;
        ResultKt.throwOnFailure(r14);
        Object r15 = ((Result) r14).unbox-impl();
        Iterator r9 = r8;
        BluetoothDevice r10 = r7;
        boolean r11 = r4;
        Object r5 = r2;
        BasicDoraDeviceCheckStrategy$isConditionMet$1 r6 = r0;
        BasicDoraDeviceCheckStrategy r12 = this;
    L84:
        if (Result.isFailure-impl(r15) == false) goto L86;
        r15 = null;
    L86:
        Boolean r16 = (Boolean) r15;
        if (r16 == null) goto L95;
        boolean r17 = r16.booleanValue();
        if (r11 == false) goto L93;
        if (r17 == true) goto L93;
        r12.b = Boxing.boxInt(4096);
        g49.d.d("BasicDoraDeviceCheckStrategy", "has dora device, vendorId=" + r12.b);
        r12.c = r10;
        return Boxing.boxBoolean(true);
    L93:
        BasicDoraDeviceCheckStrategy r18 = r12;
        r0 = r6;
        r2 = r5;
        Iterator r20 = r9;
    L40:
        if (r20.hasNext() == false) goto L97;
        BluetoothDevice r21 = (BluetoothDevice) r20.next();
        if (kj4.a.g().getBtConnectState(DoraDevice.from(r21)) != 2) goto L48;
        boolean r22 = true;
    L49:
        if (r22 == false) goto L40;
        g49.d.d("BasicDoraDeviceCheckStrategy", "check bonded device, device=" + r21);
        String r23 = r21.getName();     // Catch: Exception -> L74 SecurityException -> L76
        if (r23 != null) goto L55;
    L57:
        boolean r24 = false;
    L58:
        if (r24 == false) goto L78;
        String r25 = r21.getName();     // Catch: Exception -> L74 SecurityException -> L76
        if (r25 != null) goto L62;
    L64:
        boolean r26 = false;
    L65:
        if (r26 == false) goto L78;
        String r27 = r21.getName();     // Catch: Exception -> L74 SecurityException -> L76
        if (r27 != null) goto L69;
    L71:
        boolean r28 = false;
    L72:
        if (r28 == false) goto L78;
        boolean r30 = true;
    L79:
        r0.L$0 = r20;
        r0.L$1 = r21;
        r0.Z$0 = r30;
        r0.label = 1;
        Object r31 = r18.c(r21, 4096, r0);
        if (r31 != r2) goto L82;
        return r2;
    L82:
        BasicDoraDeviceCheckStrategy$isConditionMet$1 r110 = r0;
        r12 = r18;
        r15 = r31;
        r9 = r20;
        r10 = r21;
        r11 = r30;
        r5 = r2;
        r6 = r110;
        goto L84
    L69:
        if (StringsKt.contains(r27, "2", true) != true) goto L71;
        r28 = true;
        goto L72
    L62:
        if (StringsKt.contains(r25, "huawei", true) != true) goto L64;
        r26 = true;
    L78:
        r30 = false;
        goto L79
    L55:
        if (StringsKt.contains(r23, "clip", true) != true) goto L57;
        r24 = true;
        goto L58
    L76:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Failed to read device name for H check: " + r21.getAddress(), e);
    L74:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Unexpected error when reading device name: " + r21.getAddress(), e);
    L48:
        r22 = false;
    L46:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "getBtConnectState failed for device: " + r21.getAddress(), e);
        goto L48
    L97:
        return Boxing.boxBoolean(false);
    L95:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        int r111 = Build.VERSION.SDK_INT;
        if (r111 >= 31) goto L18;
        boolean r32 = true;
    L23:
        if (r32 == true) goto L26;
        g49.d.c("BasicDoraDeviceCheckStrategy", "BLUETOOTH_CONNECT permission not granted, skip Dora device check on sdk=" + r111, new SecurityException("BLUETOOTH_CONNECT not granted"));
        return Boxing.boxBoolean(false);
    L26:
        BluetoothAdapter r112 = this.a;
        if (r112 != null) goto L29;
    L104:
        g49.d.c("BasicDoraDeviceCheckStrategy", "BluetoothAdapter is null or not enabled, cannot check Dora devices", new IllegalStateException("adapter null"));
        return Boxing.boxBoolean(false);
    L29:
        if (r112.isEnabled() == false) goto L104;
        Set<BluetoothDevice> r113 = r112.getBondedDevices();     // Catch: Exception -> L98 SecurityException -> L101
        if (r113 != null) goto L35;
        r113 = SetsKt.emptySet();     // Catch: Exception -> L98 SecurityException -> L101
    L35:
        if (r113.isEmpty() == true) goto L37;
        r20 = r113.iterator();
        r18 = this;
        goto L40
    L37:
        return Boxing.boxBoolean(false);
    L101:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Failed to access bondedDevices, permission might be missing", e);
        return Boxing.boxBoolean(false);
    L98:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Unexpected error when reading bondedDevices", e);
        return Boxing.boxBoolean(false);
    L18:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.BLUETOOTH_CONNECT") != 0) goto L20;
        r32 = true;
    L21:
        if (r32 == true) goto L23;
        g49.d.c("BasicDoraDeviceCheckStrategy", "BLUETOOTH_CONNECT permission not granted when checking Dora devices", new SecurityException("BLUETOOTH_CONNECT not granted"));
        goto L23
    L20:
        r32 = false;
    L7:
        r0 = new BasicDoraDeviceCheckStrategy$isConditionMet$1(this, r13);
        goto L8
    }

    public final Object a(DoraDevice r12, Continuation<? super Result<Boolean>> r13) {
        if ((r13 instanceof BasicDoraDeviceCheckStrategy$checkBindStatus$1) == false) goto L7;
        BasicDoraDeviceCheckStrategy$checkBindStatus$1 r2 = (BasicDoraDeviceCheckStrategy$checkBindStatus$1) r13;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        BasicDoraDeviceCheckStrategy$checkBindStatus$1 r8 = r2;
        Object r14 = r8.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L39
    L19:
        y r15 = (com.larus.network.http.a) r14;     // Catch: Throwable -> L39
        if ((r15 instanceof y) == false) goto L33;
        Long r16 = r15.g;     // Catch: Throwable -> L39
        if (r16 == null) goto L33;
        if (r16.longValue() != 0) goto L33;
        FineDoraDeviceStrategy.a r17 = (FineDoraDeviceStrategy.a) ((com.larus.network.http.a) r15).b;     // Catch: Throwable -> L39
        if (r17 == null) goto L31;
        Boolean r18 = r17.a();     // Catch: Throwable -> L39
        if (r18 == null) goto L31;
        boolean r110 = r18.booleanValue();     // Catch: Throwable -> L39
    L32:
        g49.d.d("BasicDoraDeviceCheckStrategy", "checkBindStatus() success, bindingStatus=" + r110);     // Catch: Throwable -> L39
        Object r111 = Result.constructor-impl(Boxing.boxBoolean(r110));     // Catch: Throwable -> L39
    L41:
        Throwable r112 = Result.exceptionOrNull-impl(r111);
        if (r112 == null) goto L47;
        g49.d.c("BasicDoraDeviceCheckStrategy", "checkBindStatus() error: " + r112.getMessage(), r112);
        return Result.constructor-impl(ResultKt.createFailure(r112));
    L47:
        return Result.constructor-impl(Boxing.boxBoolean(((Boolean) r111).booleanValue()));
    L31:
        r110 = false;
    L33:
        StringBuilder r0 = new StringBuilder("Check bind status failed, code=");     // Catch: Throwable -> L39
        if ((r15 instanceof y) == false) goto L36;
        Long r113 = r15.g;     // Catch: Throwable -> L39
    L37:
        r0.append(r113);     // Catch: Throwable -> L39
        throw new IllegalStateException(r0.toString());     // Catch: Throwable -> L39
    L36:
        r113 = Boxing.boxLong(-1);     // Catch: Throwable -> L39
        goto L37
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        g49.d.d("BasicDoraDeviceCheckStrategy", "checkBindStatus() start, w_did=" + r12.getSerialNumber());
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L39
        com.larus.dora.api.network.a r6 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L39
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L39
        HttpConst.a.getClass();     // Catch: Throwable -> L39
        r7.append(HttpConst.m);     // Catch: Throwable -> L39
        r7.append("/alice/w/device/check_binding_status");     // Catch: Throwable -> L39
        String r9 = r7.toString();     // Catch: Throwable -> L39
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L39
        r10.put("w_did", r12.getSerialNumber());     // Catch: Throwable -> L39
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r8.label = 1;     // Catch: Throwable -> L39
        r14 = com.larus.dora.api.network.a.c(r6, FineDoraDeviceStrategy.a.class, r9, r10, null, r8, 248);     // Catch: Throwable -> L39
        if (r14 != r4) goto L19;
        return r4;
    L39:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new BasicDoraDeviceCheckStrategy$checkBindStatus$1(this, r13);
        goto L8
    }

    public final Object c(BluetoothDevice r7, int r8, Continuation<? super Result<Boolean>> r9) {
        if ((r9 instanceof BasicDoraDeviceCheckStrategy$isDeviceBound$1) == false) goto L7;
        BasicDoraDeviceCheckStrategy$isDeviceBound$1 r0 = (BasicDoraDeviceCheckStrategy$isDeviceBound$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        BluetoothDevice r11 = (BluetoothDevice) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L34
        return ((Result) r10).unbox-impl();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
        List r12 = kj4.a.g().getDoraBindList();     // Catch: Exception -> L34
        boolean r4 = false;
        if ((r12 instanceof Collection) == true) goto L20;
    L22:
        Iterator r13 = r12.iterator();     // Catch: Exception -> L34
    L24:
        if (r13.hasNext() == false) goto L28;
        if (Intrinsics.areEqual(((DoraDevice) r13.next()).mac, r7.getAddress()) == false) goto L24;
        r4 = true;
    L28:
        if (r4 == false) goto L31;
        Result.Companion r14 = Result.Companion;     // Catch: Exception -> L34
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L31:
        DoraDevice r15 = DoraDevice.from(r7);     // Catch: Exception -> L34
        r15.vendorId = r8;     // Catch: Exception -> L34
        r0.L$0 = r7;     // Catch: Exception -> L34
        r0.label = 1;     // Catch: Exception -> L34
        Object r16 = a(r15, r0);     // Catch: Exception -> L34
        if (r16 != r2) goto L41;
        return r2;
    L41:
        return r16;
    L20:
        if (r12.isEmpty() == false) goto L22;
    L34:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Failed to check bind state for device: " + r7.getAddress(), e);
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(e));
    L7:
        r0 = new BasicDoraDeviceCheckStrategy$isDeviceBound$1(this, r9);
        goto L8
    }
}
