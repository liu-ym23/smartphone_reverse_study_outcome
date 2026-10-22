package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q {
    public final Handler a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public final Context d;
    public final AudioManager e;
    public r f;
    public MmAudioRouteDetector$registerVolumeReceiver$1 g;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        AudioManager r0 = this.e;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L32;
        AudioDeviceInfo[] r1 = r0.getDevices(2);
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L42;
        AudioDeviceInfo r5 = r1[r3];
        Intrinsics.checkNotNull(r5);
        int r6 = r5.getType();
        if (r6 != 3) goto L12;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == true) goto L37;
        r3 = r3 + 1;
    L37:
        return true;
    L12:
        if (r6 == 4) goto L27;
        if (r6 == 7) goto L27;
        if (r6 == 8) goto L27;
        if (r6 == 11) goto L27;
        if (r6 == 22) goto L27;
        if (Build.VERSION.SDK_INT >= 31) goto L24;
    L26:
        r7 = false;
        goto L28
    L24:
        if (r5.getType() != 26) goto L26;
    L42:
        return false;
    L32:
        if (r0.isWiredHeadsetOn() == true) goto L37;
        if (r0.isBluetoothScoOn() == true) goto L37;
        if (r0.isBluetoothA2dpOn() == true) goto L37;
        return false;
    }

    public q(Context r2, Handler r3, Function0<Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callbackHandler");
        Intrinsics.checkNotNullParameter(r4, "onRouteChanged");
        Intrinsics.checkNotNullParameter(r5, "onVolumeChanged");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        Context r6 = r2.getApplicationContext();
        this.d = r6;
        Object r7 = r6.getSystemService("audio");
        if ((r7 instanceof AudioManager) == false) goto L5;
        AudioManager r8 = (AudioManager) r7;
    L6:
        this.e = r8;
        return;
    L5:
        r8 = null;
        goto L6
    }
}
