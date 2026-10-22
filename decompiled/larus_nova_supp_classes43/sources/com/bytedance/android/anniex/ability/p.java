package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements IDLXBridgeMethod.b {
    public final /* synthetic */ AnnieXWebKit a;

    public p(AnnieXWebKit r1) {
        this.a = r1;
    }

    public final void a(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        this.a.p(r10, r11);
    }
}
