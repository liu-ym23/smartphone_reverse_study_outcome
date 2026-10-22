package com.larus.dora.impl.noti_v3.overview.ui;

import com.bytedance.router.SmartRouter;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3Binding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z implements UrlSpanTextView.a {
    public final /* synthetic */ LarusDoraPageNotiV3Binding a;

    public z(LarusDoraPageNotiV3Binding r1) {
        this.a = r1;
    }

    @Override // com.larus.common_ui.widget.UrlSpanTextView.a
    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "url");
        if (Intrinsics.areEqual(r4, "pp") == false) goto L6;
        com.bytedance.router.i r5 = SmartRouter.buildRoute(this.a.a.getContext(), "//flow/webview");
        r5.c.putExtra("link_url", "https://www.doubao.com/dora/legal/dora_push/privacy");
        r5.d = 2130772401;
        r5.e = 2130772399;
        r5.d();
        return;
    }
}
