package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ AudioRecordDataProcessor a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ String c;
    public final /* synthetic */ AudioRecordDataProcessor.UploadAudioDataConsumer d;

    public e(AudioRecordDataProcessor r1, Message r2, String r3, String r4, int r5, AudioRecordDataProcessor.UploadAudioDataConsumer r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        qob.a r0 = this.a.c;     // Catch: Throwable -> L4
        Message r1 = this.b;     // Catch: Throwable -> L4
        String r2 = this.c;     // Catch: Throwable -> L4
        r0.f();     // Catch: Throwable -> L4
        r0.p(r1, r2);     // Catch: Throwable -> L4
        this.d.e();     // Catch: Throwable -> L4
        this.d.b = null;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
