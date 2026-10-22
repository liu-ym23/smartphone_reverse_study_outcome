package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends a<ILiveRoomViewHandler, td.d> {
    public static final n b = null;

    static {
        b = new n();
    }

    public n() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final td.d c(ILiveRoomViewHandler r10) {
        ILiveRoomViewHandler r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "source");
        return new re.d(r11);
    }
}
