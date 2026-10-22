package com.obric.flow.cardlistpage.ui.view;

import ai.p;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.flow.cardlistpage.R$string;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.oui.text.OTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OTextView f11850c;
    public final /* synthetic */ Object d;

    public /* synthetic */ g(Object r5, String r10, OTextView r11, int r12) {
        this.f11848a = r12;
        this.d = r5;
        this.f11849b = r10;
        this.f11850c = r11;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r5) {
        switch(this.f11848a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "widget");
        com.obric.oui.window.permission.c r10 = ((com.obric.oui.privacy.b) this.d).e;
        if (r10 == null) goto L13;
        r10.a(this.f11849b);
        return;
    L13:
        return;
    L9:
        Intrinsics.checkNotNullParameter(r5, "widget");
        p r11 = ((i) this.d).f11855c;
        if (r11 == null) goto L14;
        String r12 = this.f11849b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "linkText");
        CardFeedLayout r13 = (CardFeedLayout) r11.f287b;
        com.bytedance.ies.bullet.base.utils.b.s(r13.getContext(), r13.getContext().getString(R$string.privacy_policy_link_url), r13.getContext().getString(R$string.privacy_policy_link), "privacy_sheet");
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        switch(this.f11848a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "ds");
        super.updateDrawState(r5);
        r5.setColor(ContextCompat.getColor(this.f11850c.getContext(), R$color.oui_functional_blue_6));
        r5.setUnderlineText(false);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "ds");
        super.updateDrawState(r5);
        r5.setColor(ContextCompat.getColor(this.f11850c.getContext(), R$color.oui_functional_blue_6));
        r5.setUnderlineText(false);
    }
}
