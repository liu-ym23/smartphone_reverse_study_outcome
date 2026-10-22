package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j3 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ j3(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        FLogger.a.i("CoreInputComponent", "[onStoredStatusChanged_" + r0.hashCode() + "] " + ((Integer) r5));
        r0.k4().g2(r0.F4().statusToSyncOnSavedStatusChanged(), false);
        LarusWidgetInputBinding r6 = r0.W;
        if (r6 == null) goto L8;
        View r7 = r6.a;
        if (r7 == null) goto L8;
        r7.invalidate();
    L8:
        return Unit.INSTANCE;
    }
}
