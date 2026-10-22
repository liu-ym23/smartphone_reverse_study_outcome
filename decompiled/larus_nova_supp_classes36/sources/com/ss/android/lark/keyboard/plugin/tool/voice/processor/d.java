package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ AudioRecordDataProcessor a;
    public final /* synthetic */ com.ss.android.lark.audio.voiceinput.c b;

    public d(AudioRecordDataProcessor r1, com.ss.android.lark.audio.voiceinput.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.audio.voiceinput.e r0 = this.a.m;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.e(this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
