package com.obric.assistant.interaction.impl;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ m(Function0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricCameraServiceDiffImpl.f(this.a);
    }
}
