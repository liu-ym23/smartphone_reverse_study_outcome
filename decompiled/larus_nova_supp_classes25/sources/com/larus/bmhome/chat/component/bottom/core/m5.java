package com.larus.bmhome.chat.component.bottom.core;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import bc8.a;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m5 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ EditText b;

    public /* synthetic */ m5(CoreInputComponent r1, EditText r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r6) {
        CoreInputComponent r0 = this.a;
        EditText r1 = this.b;
        boolean r7 = ((Boolean) r6).booleanValue();
        r0.L1 = r7;
        r0.W2 = Boolean.valueOf(r7);
        if (r0.v1 == false) goto L5;
        r0.W6();
    L5:
        r0.Q6();
        r0.b7(r7);
        if (r7 == true) goto L13;
        if (r1.hasFocus() == false) goto L13;
        if (ObricFeatureServiceDelegate.b.a() == false) goto L13;
        FLogger.a.i("CoreInputComponent", "[observeImeStatus] clear obric input focus after ime hidden");
        r1.clearFocus();
    L13:
        if (com.larus.platform.service.z2.a.switchReadyToSpeakOnHideIme() == false) goto L32;
        if (r7 == true) goto L32;
        Editable r8 = r1.getText();
        boolean r2 = false;
        if (r8 == null) goto L18;
        int r9 = r8.length();
    L19:
        if (r9 != 0) goto L32;
        r0.k4().g2(2, true);
        a r10 = s1a.d.a(r0).getAbility(a.class);
        if (r10 != null) goto L23;
    L25:
        if (r2 == true) goto L32;
        LarusWidgetInputBinding r11 = r0.W;
        if (r11 == null) goto L32;
        View r12 = r11.C;
        if (r12 == null) goto L32;
        com.larus.utils.e1.o(r12);
        goto L32
    L23:
        if (r10.mt() != true) goto L25;
        r2 = true;
        goto L25
    L18:
        r9 = 0;
    L32:
        return Unit.INSTANCE;
    }
}
