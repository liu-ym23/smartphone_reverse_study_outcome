package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l extends a<ILiveRoomMessageHandler, td.c> {
    public static final l b = null;

    static {
        b = new l();
    }

    public l() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final td.c c(ILiveRoomMessageHandler r10) {
        ILiveRoomMessageHandler r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "source");
        return new re.c(r11);
    }
}
