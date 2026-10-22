package com.larus.bmhome.chat.component.audio;

import android.content.Context;
import com.larus.bmhome.audio.VolumeChangedObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ VolumeComponent a;

    public /* synthetic */ l(VolumeComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VolumeComponent r0 = this.a;
        int r1 = VolumeComponent.m;
        Context r2 = r0.getContext();
        ((VolumeChangedObserver) r0.h.getValue()).registerReceiver(r2, (VolumeComponent$b) r0.l.getValue());
    }
}
