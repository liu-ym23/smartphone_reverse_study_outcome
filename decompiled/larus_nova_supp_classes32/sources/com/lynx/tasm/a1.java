package com.lynx.tasm;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class a1 implements Executor {
    public final /* synthetic */ LynxTemplateRender a;

    public /* synthetic */ a1(LynxTemplateRender r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r2) {
        this.a.runOnTasmThread(r2);
    }
}
