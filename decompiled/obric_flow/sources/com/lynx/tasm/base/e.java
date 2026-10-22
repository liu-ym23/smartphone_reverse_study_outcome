package com.lynx.tasm.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10125a;

    public /* synthetic */ e(int r5) {
        this.f10125a = r5;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r5, Intent r10) {
        switch(this.f10125a) {
            case 0: goto L15;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        if (r10 != null) goto L6;
        return;
    L6:
        if ("com.bytedance.ttnet.config.appconfig.SYNC_APP_DELAY_CONFIG_ACTION".equals(r10.getAction()) == false) goto L31;
        new sj.i().a();
        return;
    L31:
        return;
    L9:
        if (r10 != null) goto L11;
        return;
    L11:
        if ("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG".equals(r10.getAction()) == false) goto L33;
        new sj.c().a();
        return;
    L33:
        return;
    L15:
        if (r10.getAction().endsWith("LYNX_MEMORY_TRACING_START") == false) goto L21;
        int r11 = r10.getIntExtra("min_watched_size", -1);
        if (r11 <= 0) goto L19;
        LynxNativeMemoryTracer.b(r11);
        return;
    L19:
        LynxNativeMemoryTracer.b(LynxNativeMemoryTracer.f10105a);
        return;
    L21:
        if (r10.getAction().endsWith("LYNX_MEMORY_TRACING_STOP") == false) goto L24;
        LynxNativeMemoryTracer.a();
        return;
    L24:
        if (r10.getAction().endsWith("LYNX_MEMORY_TRACING_REPORT") == false) goto L37;
        String r12 = r10.getStringExtra("report_dir");
        if (r12 != null) goto L28;
        r12 = r5.getExternalFilesDir(null).getPath() + "/memory-reports";
    L28:
        LynxNativeMemoryTracer.d(r12);
        return;
    }
}
