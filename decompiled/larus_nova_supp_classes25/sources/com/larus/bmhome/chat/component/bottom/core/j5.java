package com.larus.bmhome.chat.component.bottom.core;

import android.os.Build;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j5 implements Function0 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ j5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        if (com.larus.platform.service.z2.a.messageInputMenuConfig().b() == true) goto L6;
        FLogger.a.i("CoreInputComponent", "[needPasteAndSend] false: settings");
    L14:
        boolean r2 = false;
    L17:
        return Boolean.valueOf(r2);
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        FLogger.a.i("CoreInputComponent", "[needPasteAndSend] false: VERSION_CODES");
        goto L14
    L9:
        if (r0.F4().validModifyMode() == false) goto L12;
        FLogger.a.i("CoreInputComponent", "[needPasteAndSend] false: inModify");
        goto L14
    L12:
        if (r0.G3() == true) goto L15;
        FLogger.a.i("CoreInputComponent", "[needPasteAndSend] false: scene");
        goto L14
    L15:
        r2 = true;
        goto L17
    }
}
