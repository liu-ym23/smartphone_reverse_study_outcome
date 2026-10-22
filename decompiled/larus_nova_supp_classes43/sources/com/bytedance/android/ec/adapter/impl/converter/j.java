package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends a<IExternalViewGroup, wd.f> {
    public static final j b = null;

    static {
        b = new j();
    }

    public j() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final wd.f c(IExternalViewGroup r10) {
        IExternalViewGroup r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "source");
        return new se.a(r11);
    }
}
