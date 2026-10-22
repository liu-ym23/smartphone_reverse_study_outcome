package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b1 implements Runnable {
    public final /* synthetic */ c1 a;

    public /* synthetic */ b1(c1 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c1 r0 = this.a;
        IAIChatRenderTraceService.a.m(r0.a(), "");
        FLogger.a.i("WcbFillInputMgr", "clear autoFillPrompt");
    }
}
