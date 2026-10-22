package com.larus.voicecall.impl.component.vlm;

import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class j2 implements Function1 {
    public final /* synthetic */ ImageView a;

    public /* synthetic */ j2(ImageView r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        JSONObject r4 = (JSONObject) r3;
        if (this.a.isSelected() == false) goto L5;
        String r0 = "on";
    L6:
        r4.put("flashlight_status", r0);
        return Unit.INSTANCE;
    L5:
        r0 = "off";
        goto L6
    }
}
