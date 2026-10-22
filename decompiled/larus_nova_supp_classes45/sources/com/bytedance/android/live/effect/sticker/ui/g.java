package com.bytedance.android.live.effect.sticker.ui;

import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.x0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.d2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends x0 {
    public final /* synthetic */ Sticker a;
    public final /* synthetic */ d2 b;

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.b
    public final void d() {
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.b
    public final Sticker f() {
        return this.a;
    }

    public g(Sticker r1, d2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.b
    public final void e(Sticker r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "extra");
        this.b.d.a(r2, r3);
    }
}
