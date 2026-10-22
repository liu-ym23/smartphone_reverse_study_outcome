package com.larus.av_call.view;

import android.os.Handler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ Handler a;

    public /* synthetic */ j(Handler r1) {
        this.a = r1;
    }

    public final Object invoke() {
        this.a.removeCallbacksAndMessages(null);
        return Unit.INSTANCE;
    }
}
