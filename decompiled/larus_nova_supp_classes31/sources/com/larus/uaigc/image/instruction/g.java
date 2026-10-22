package com.larus.uaigc.image.instruction;

import android.net.Uri;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class g implements Function3 {
    public final /* synthetic */ ImageListSelectorWithMoreTemplateWidget a;

    public /* synthetic */ g(ImageListSelectorWithMoreTemplateWidget r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3, Object r4) {
        String r5 = (String) r3;
        return ImageListSelectorWithMoreTemplateWidget.i6(this.a, (TemplateInfo$TemplateInfo) r2, (Uri) r4);
    }
}
