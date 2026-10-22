package com.larus.bmhome.bot;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d5 extends ClickableSpan {
    public final /* synthetic */ hq9.p1 a;
    public final /* synthetic */ CommonSettingFragment b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        Bundle r5 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", this.a.c)});
        com.larus.bmhome.setting.c r0 = this.b.g;
        if (r0 == null) goto L7;
        View r1 = r0.P0();
        if (r1 == null) goto L7;
        com.larus.platform.service.q.a.e(r1.getContext(), r5, null);
    L7:
        tx9.j1.b(this.b.S, this.a.d, "bot_setting_link");
        tx9.j1.a(this.b.S, this.a.d, "bot_setting");
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r4) {
        Intrinsics.checkNotNullParameter(r4, "ds");
        super.updateDrawState(r4);
        r4.setUnderlineText(false);
        int r0 = com.larus.utils.j0.a;
        r4.setColor(com.larus.utils.j0.a(v19.c.b(2130972081, this.b.getContext(), 2131103143)));
    }

    public d5(hq9.p1 r1, CommonSettingFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
