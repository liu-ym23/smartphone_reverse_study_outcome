package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class j implements Function1 {
    public /* synthetic */ j() {
    }

    public final Object invoke(Object r2) {
        RichMediaItem r3 = (RichMediaItem) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        Integer r4 = r3.type;
        int r0 = RichMediaType.CREATION.getValue();
        if (r4 != null) goto L6;
    L8:
        boolean r5 = false;
    L10:
        return Boolean.valueOf(r5);
    L6:
        if (r4.intValue() != r0) goto L8;
        r5 = true;
        goto L10
    }
}
