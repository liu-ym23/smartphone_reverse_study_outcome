package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r extends ClickableSpan {
    public final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$2 a;

    public r(LiveMgMountContextService$showStarAtlasAgreementDialog$2 r1) {
        this.a = r1;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.a.invoke("https://www.xingtu.cn/protocol?id=1662105635&enable_title=1");
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        super.updateDrawState(r2);
        r2.setColor(ColorProtector.parseColor("#04498D"));
        r2.setUnderlineText(false);
    }
}
