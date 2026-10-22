package com.obric.assistant.interaction.impl.window.behaviors;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ ActivityStartBehavior a;
    public final /* synthetic */ ActivityStartBehavior$PendingInternalActivityRecord b;

    public /* synthetic */ b(ActivityStartBehavior r1, ActivityStartBehavior$PendingInternalActivityRecord r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityStartBehavior.a(this.a, this.b);
    }
}
