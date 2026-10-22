package com.larus.asr;

import com.larus.im.bean.message.UplinkFileEntity;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class m implements Function1 {
    public /* synthetic */ m() {
    }

    public final Object invoke(Object r2) {
        UplinkFileEntity r3 = (UplinkFileEntity) r2;
        Set r0 = ChatBottomSpeakerComponent.F2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(yc9.n1.a(r3));
    }
}
