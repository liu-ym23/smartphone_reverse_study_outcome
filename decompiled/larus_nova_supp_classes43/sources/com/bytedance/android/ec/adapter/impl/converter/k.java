package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k extends a<IBaseLiveRoomFunctionHandler, td.b> {
    public static final k b = null;

    static {
        b = new k();
    }

    public k() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final td.b c(IBaseLiveRoomFunctionHandler r10) {
        IBaseLiveRoomFunctionHandler r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "source");
        return new re.b(r11);
    }
}
