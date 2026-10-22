package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import android.net.Uri;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ BgPromptGenerateViewModel a;

    public /* synthetic */ g(BgPromptGenerateViewModel r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        BgPromptGenerateViewModel r0 = this.a;
        Uri r11 = (Uri) r10;
        if (((f) r0.f.getValue()).c != 0) goto L6;
        return Unit.INSTANCE;
    L6:
        if (r11 != null) goto L8;
    L13:
        r0.g(null);
    L15:
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r11.getScheme(), ShareType.FILE) == false) goto L10;
        Uri r4 = r11;
    L11:
        if (r4 == null) goto L13;
        BotImageUploadViewModel.upload$default(r0.d, r4, 6, false, 4, null);
        goto L15
    L10:
        r4 = null;
        goto L11
    }
}
