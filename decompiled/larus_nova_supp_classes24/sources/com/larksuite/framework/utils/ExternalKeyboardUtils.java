package com.larksuite.framework.utils;

import android.view.InputDevice;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ExternalKeyboardUtils {
    public static volatile Boolean a;

    static {
    }

    public ExternalKeyboardUtils() {
    }

    public static /* synthetic */ void d() {
        c(ExternalKeyboardUtils$updateConnectionState$1.INSTANCE);
    }

    public static boolean a() {
        int[] r0 = InputDevice.getDeviceIds();
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L17;
        InputDevice r5 = InputDevice.getDevice(r0[r3]);
        if (r5 == null) goto L16;
        if ((r5.getSources() & 257) != 257) goto L16;
        if (r5.getKeyboardType() != 2) goto L16;
        if (r5.isVirtual() == true) goto L16;
        Log.i("ExternalKeyboardUtils", "checkExternalKeyboardConnection : true ");
        return true;
    L16:
        r3 = r3 + 1;
        goto L4
    L17:
        Log.i("ExternalKeyboardUtils", "checkExternalKeyboardConnection : false ");
        return false;
    }

    public static boolean b(boolean r2) {
        if (a == null) goto L5;
        if (r2 == true) goto L5;
    L6:
        Log.i("ExternalKeyboardUtils", "isExternalKeyboardConnected : " + a + ", forceCheck: " + r2);
        Boolean r3 = a;
        if (r3 != null) goto L11;
        return false;
    L11:
        return r3.booleanValue();
    L5:
        a = Boolean.valueOf(a());
        goto L6
    }

    public static void c(Function1 r7) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ExternalKeyboardUtils$updateConnectionState$2(r7, null), 3, null);
    }
}
