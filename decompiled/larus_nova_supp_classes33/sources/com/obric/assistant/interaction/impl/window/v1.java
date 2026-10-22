package com.obric.assistant.interaction.impl.window;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class v1 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ WindowOperationExecutor c;

    public /* synthetic */ v1(String r1, Function0 r2, WindowOperationExecutor r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowOperationExecutor.a(this.a, this.b, this.c);
    }
}
