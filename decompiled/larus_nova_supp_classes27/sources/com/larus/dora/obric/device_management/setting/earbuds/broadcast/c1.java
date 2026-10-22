package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.router.SmartRouter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c1 extends ClickableSpan {
    public final /* synthetic */ URLSpan a;
    public final /* synthetic */ DoraObricEarbudsBroadcastSettingFragment b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        if (Intrinsics.areEqual(this.a.getURL(), "pp") == false) goto L6;
        com.bytedance.router.i r5 = SmartRouter.buildRoute(r4.getContext(), "//flow/webview");
        r5.c.putExtra("link_url", "https://www.doubao.com/dora/legal/dora_push/privacy");
        r5.d = 2130772401;
        r5.e = 2130772399;
        r5.d();
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        r3.setColor(ContextCompat.getColor(this.b.requireContext(), 2131103056));
        r3.setUnderlineText(false);
    }

    public c1(URLSpan r1, DoraObricEarbudsBroadcastSettingFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
