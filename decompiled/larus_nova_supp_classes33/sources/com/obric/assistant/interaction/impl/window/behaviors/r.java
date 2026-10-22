package com.obric.assistant.interaction.impl.window.behaviors;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ MemoryPressureDestroyBehavior b;

    public /* synthetic */ r(String r1, MemoryPressureDestroyBehavior r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MemoryPressureDestroyBehavior.a(this.a, this.b);
    }
}
