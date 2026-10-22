package com.larus.audio.ttsV2;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ boolean a;

    public /* synthetic */ d(boolean r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = this.a;
        e r1 = e.a;
        AudioDeviceInfo[] r2 = ((AudioManager) e.d.getValue()).getDevices(2);
        int r3 = r2.length;
        boolean r4 = false;
        int r5 = 0;
    L3:
        boolean r6 = true;
        if (r5 >= r3) goto L16;
        int r7 = r2[r5].getType();
        if (r7 != 3) goto L8;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == true) goto L14;
        r5 = r5 + 1;
        goto L3
    L14:
        boolean r9 = true;
    L17:
        StateFlowImpl r10 = e.b;
        a r11 = (a) r10.getValue();
        Intrinsics.checkNotNullParameter(r11, "current");
        if (r0 == false) goto L20;
    L21:
        r4 = true;
    L22:
        if (r4 == false) goto L24;
        FLogger.a.i("HeadsetDetector", "Earphone state changed: " + r9);
    L24:
        if (r9 == true) goto L26;
    L28:
        r6 = r11.b;
    L29:
        r11.getClass();
        r10.setValue(new a(r9, r6));
        return;
    L26:
        if (r11.a == true) goto L28;
    L20:
        if (r11.a == r9) goto L22;
    L8:
        if (r7 == 4) goto L12;
        if (r7 == 8) goto L12;
        r8 = false;
        goto L13
    L16:
        r9 = false;
        goto L17
    }
}
