package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r extends AudioDeviceCallback {
    public final /* synthetic */ q a;

    public r(q r1) {
        this.a = r1;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] r2) {
        lvb.a.e("MmAudioRouteDetector", "[onAudioDevicesAdded]");
        this.a.b.invoke();
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] r2) {
        lvb.a.e("MmAudioRouteDetector", "[onAudioDevicesRemoved]");
        this.a.b.invoke();
    }
}
