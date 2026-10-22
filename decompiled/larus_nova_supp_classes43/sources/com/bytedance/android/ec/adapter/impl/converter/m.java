package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m extends a<IRoomEventHub, td.e> {
    public static final m b = null;

    static {
        b = new m();
    }

    public m() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final td.e c(IRoomEventHub r10) {
        IRoomEventHub r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "source");
        return new re.e(r11);
    }
}
