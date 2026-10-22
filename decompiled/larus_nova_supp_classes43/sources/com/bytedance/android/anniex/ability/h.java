package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements IDLXBridgeMethod.b {
    public final /* synthetic */ AnnieXLynxView a;

    public h(AnnieXLynxView r1) {
        this.a = r1;
    }

    public final void a(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        AnnieXLynxView r0 = this.a;
        int r1 = AnnieXLynxView.B;
        r0.O(r10, r11, true);
    }
}
