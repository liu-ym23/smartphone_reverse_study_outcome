package com.larus.commercecredit.impl.page;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.router.SmartRouter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k0 extends ClickableSpan {
    public final /* synthetic */ String a;
    public final /* synthetic */ CommerceInviteFriendsFragment b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        String r3 = this.a;
        if (r3 == null) goto L6;
        SmartRouter.buildRoute(this.b.getContext(), r3).d();
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        Context r0 = this.b.getContext();
        if (r0 == null) goto L5;
        r3.setColor(ContextCompat.getColor(r0, 2131103136));
    L5:
        r3.setUnderlineText(false);
    }

    public k0(String r1, CommerceInviteFriendsFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
