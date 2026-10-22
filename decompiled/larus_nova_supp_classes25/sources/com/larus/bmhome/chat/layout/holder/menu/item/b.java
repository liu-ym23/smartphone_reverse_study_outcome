package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function1 {
    public /* synthetic */ b() {
    }

    public final Object invoke(Object r2) {
        UplinkFileEntity r3 = (UplinkFileEntity) r2;
        Intrinsics.checkNotNullParameter(r3, "entity");
        return CreationNoWatermarkManager.a.e0(r3);
    }
}
