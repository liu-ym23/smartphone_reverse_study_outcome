package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.AudioLiveThemeReporter;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements Runnable {
    public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;

    public n(AudioSceneBasicBusinessContentWidget r1) {
        this.a = r1;
    }

    public final void a() {
        AudioSceneBasicBusinessContentWidget r0 = this.a;
        if (r0.i != null) goto L5;
        return;
    L5:
        if (r0.j != 5) goto L12;
        AudioLiveThemeReporter.a r1 = AudioLiveThemeReporter.Companion;
        boolean r2 = r0.f;
        r1.getClass();
        AudioLiveThemeReporter.access$setAnchor$p((AudioLiveThemeReporter) AudioLiveThemeReporter.access$getReporter$cp().getValue(), r2);
        AudioLiveThemeReporter r3 = (AudioLiveThemeReporter) AudioLiveThemeReporter.access$getReporter$cp().getValue();
        IVoiceLiveTheme r4 = this.a.i;
        if (r4 == null) goto L9;
        r4.setChangeByAnchor(true);
    L9:
        r3.onThemeEnd(this.a.i);
        r3.onThemeStart(this.a.i);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
