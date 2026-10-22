package com.larus.audio.utils;

import com.larus.audio.SoundsSource;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a1 implements Runnable {
    public final /* synthetic */ SoundsSource a;

    public /* synthetic */ a1(SoundsSource r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoundsSource r0 = this.a;
        if (r0 != SoundsMobHelper.h) goto L7;
        SoundsMobHelper.u = null;
        SoundsMobHelper r2 = SoundsMobHelper.a;
        String r3 = SoundsMobHelper.m();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new SoundsMobHelper$onPlayFinish$1$1(r0, r3, null), 2, null);
        return;
    }
}
