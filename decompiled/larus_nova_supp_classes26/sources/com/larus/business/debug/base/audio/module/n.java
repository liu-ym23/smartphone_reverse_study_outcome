package com.larus.business.debug.base.audio.module;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class n implements Runnable {
    public /* synthetic */ n() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = AudioDebugUtil.a;
        List r1 = AudioDebugUtil.b(new PolarisFileWrapper(AudioDebugUtil.b, "tts"));
        if (r1.size() <= ((Number) AudioDebugUtil.d.getValue()).intValue()) goto L8;
        List r2 = AudioDebugUtil.d(r1);
    L6:
        if (r2.size() <= ((Number) AudioDebugUtil.d.getValue()).intValue()) goto L8;
        File r3 = (File) ListProtector.get(r2, 0);
        ListProtector.remove(r2, 0);
        r3.delete();
    L8:
        List r4 = AudioDebugUtil.b(new PolarisFileWrapper(AudioDebugUtil.b, "asr"));
        if (r4.size() <= ((Number) AudioDebugUtil.e.getValue()).intValue()) goto L14;
        List r5 = AudioDebugUtil.d(r4);
    L12:
        if (r5.size() <= ((Number) AudioDebugUtil.e.getValue()).intValue()) goto L14;
        File r6 = (File) ListProtector.get(r5, 0);
        ListProtector.remove(r5, 0);
        r6.delete();
    L14:
        List r7 = AudioDebugUtil.b(new PolarisFileWrapper(AudioDebugUtil.b, "aec"));
        if (r7.size() <= ((Number) AudioDebugUtil.f.getValue()).intValue()) goto L20;
        List r8 = AudioDebugUtil.d(r7);
    L18:
        if (r8.size() <= ((Number) AudioDebugUtil.f.getValue()).intValue()) goto L24;
        File r9 = (File) ListProtector.get(r8, 0);
        ListProtector.remove(r8, 0);
        r9.delete();
        goto L18
    L24:
        return;
    }
}
