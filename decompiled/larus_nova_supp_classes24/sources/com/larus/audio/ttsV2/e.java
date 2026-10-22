package com.larus.audio.ttsV2;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public static final e a = null;
    public static final StateFlowImpl b = null;
    public static final StateFlowImpl c = null;
    public static final Lazy d = null;
    public static final a e = null;

    public static final class a extends AudioDeviceCallback {
        public a() {
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesAdded(AudioDeviceInfo[] r4) {
            Intrinsics.checkNotNullParameter(r4, "addedDevices");
            e r0 = e.a;
            t0.b(new d(false), 0);
            e.a(r4, "Connected");
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesRemoved(AudioDeviceInfo[] r4) {
            Intrinsics.checkNotNullParameter(r4, "removedDevices");
            e r0 = e.a;
            t0.b(new d(false), 0);
            e.a(r4, "Disconnected");
        }
    }

    public e() {
    }

    static {
        a = new e();
        StateFlowImpl r0 = j1.a(new com.larus.audio.ttsV2.a(false, true));
        b = r0;
        c = r0;
        d = LazyKt.lazy(new b());
        e = new a();
        t0.b(new c(), 5000);
    }

    public static final void a(AudioDeviceInfo[] r5, String r6) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        int r2 = r5[r1].getType();
        if (r2 != 3) goto L7;
        FLogger.a.i("HeadsetDetector", "Wired headset ".concat(r6));
    L14:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2 != 4) goto L9;
        FLogger.a.i("HeadsetDetector", "Wired headphones ".concat(r6));
        goto L14
    L9:
        if (r2 != 8) goto L14;
        FLogger.a.i("HeadsetDetector", "Bluetooth headset ".concat(r6));
        goto L14
    }
}
