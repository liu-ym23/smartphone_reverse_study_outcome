package com.larus.dora.impl.device.settings.sound;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraAmbientVolumeSettingsNotifier {
    public static final DoraAmbientVolumeSettingsNotifier a = null;
    public static final IntRange b = null;

    public DoraAmbientVolumeSettingsNotifier() {
    }

    static {
        a = new DoraAmbientVolumeSettingsNotifier();
        b = new IntRange(0, 1);
    }

    public static Boolean a(Intent r5, DoraDevice r6) {
        Intrinsics.checkNotNullParameter(r5, "intent");
        Intrinsics.checkNotNullParameter(r6, "device");
        if (Intrinsics.areEqual(r5.getAction(), "com.larus.dora.impl.action.AMBIENT_VOLUME_CHANGED") == true) goto L5;
        return null;
    L5:
        if (r5.hasExtra("enabled") == false) goto L35;
        String r1 = r5.getStringExtra("device_serial_number");
        boolean r2 = true;
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
    L17:
        String r3 = r5.getStringExtra("device_mac");
        if (r3 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
    L28:
        r2 = false;
    L29:
        if (r2 == true) goto L32;
        return null;
    L32:
        return Boolean.valueOf(r5.getBooleanExtra("enabled", false));
    L26:
        if (Intrinsics.areEqual(r3, r6.mac) == false) goto L28;
    L20:
        if (r3.length() == 0) goto L23;
        r7 = false;
        goto L24
    L15:
        if (Intrinsics.areEqual(r1, r6.getSerialNumber()) == false) goto L17;
    L9:
        if (r1.length() == 0) goto L12;
        r4 = false;
        goto L13
    L35:
        return null;
    }

    public static void b(DoraDevice r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "device");
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(new Intent("com.larus.dora.impl.action.AMBIENT_VOLUME_CHANGED").putExtra("device_serial_number", r4.getSerialNumber()).putExtra("device_mac", r4.mac).putExtra("enabled", r5));
    }

    public final Object c(DoraDevice r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1) == false) goto L7;
        DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1 r0 = (DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        int r8 = ((Number) r7).intValue();
        IntRange r9 = b;
        int r10 = r9.getFirst();
        if (r8 > r9.getLast()) goto L21;
        if (r10 > r8) goto L21;
        boolean r11 = true;
    L22:
        if (r11 == true) goto L25;
        g49.d.e("DoraAmbientVolumeSettingsNotifier", "ignore unexpected ambient-volume state=" + r8);
        return Unit.INSTANCE;
    L25:
        if (r8 == 1) goto L28;
        r4 = false;
    L28:
        b(r5, r4);
        return Unit.INSTANCE;
    L21:
        r11 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        kj4.a r12 = kj4.a.g();
        r0.L$0 = r5;
        r0.label = 1;
        r7 = DoraAdapterExtKt.l(r12);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1(this, r6);
        goto L8
    }
}
