package com.larus.bmhome.chat.component.bottom.core;

import android.widget.EditText;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o6 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ LarusWidgetInputBinding b;
    public final /* synthetic */ EditText c;

    public /* synthetic */ o6(CoreInputComponent r1, LarusWidgetInputBinding r2, EditText r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6) {
        final CoreInputComponent r0 = this.a;
        LarusWidgetInputBinding r1 = this.b;
        EditText r2 = this.c;
        boolean r7 = ((Boolean) r6).booleanValue();
        int r3 = CoreInputComponent.d3;
        if (r7 == true) goto L5;
        CoreInputViewModel.handleFloatWindow$default(r0.F4(), false, null, 2, null);
        r2.post(new a3(r0));
    L12:
        return Unit.INSTANCE;
    L5:
        if (r0.F4().getKvStore().getInt("template_ime_height", -1) >= 0) goto L7;
        int[] r8 = new int[2];
        r1.a.getLocationOnScreen(r8);
        r0.F4().handleFloatWindow(true, Integer.valueOf(r8[1]));
    L7:
        com.larus.bmhome.chat.component.list.u7 r9 = (com.larus.bmhome.chat.component.list.u7) r0.r.getValue();
        if (r9 == null) goto L12;
        r9.z();
        goto L12
    }
}
