package com.larus.audio.utils;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class e1 implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ e1(com.obric.assistant.feedback.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.invoke();
    }
}
