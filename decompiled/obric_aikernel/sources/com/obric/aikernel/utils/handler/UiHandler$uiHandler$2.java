package com.obric.aikernel.utils.handler;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class UiHandler$uiHandler$2 extends Lambda implements Function0<Handler> {
    public static final UiHandler$uiHandler$2 INSTANCE = null;

    static {
        INSTANCE = new UiHandler$uiHandler$2();
    }

    UiHandler$uiHandler$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Handler invoke() {
        return invoke();
    }
}
