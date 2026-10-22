package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutBotBgChooseRowBinding implements ViewBinding {
    public final LinearLayout a;
    public final SimpleDraweeView b;
    public final LarusLayoutAiGenBgChooseCheckBoxBinding c;
    public final SimpleDraweeView d;
    public final LarusLayoutAiGenBgChooseCheckBoxBinding e;
    public final SimpleDraweeView f;
    public final LarusLayoutAiGenBgChooseCheckBoxBinding g;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutBotBgChooseRowBinding a(View r10) {
        int r0 = 2131365396;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r10, 2131365396);
        if (r4 == null) goto L17;
        r0 = 2131365403;
        View r1 = ViewBindings.findChildViewById(r10, 2131365403);
        if (r1 == null) goto L17;
        LarusLayoutAiGenBgChooseCheckBoxBinding r5 = LarusLayoutAiGenBgChooseCheckBoxBinding.a(r1);
        r0 = 2131377693;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r10, 2131377693);
        if (r6 == null) goto L17;
        r0 = 2131377742;
        View r2 = ViewBindings.findChildViewById(r10, 2131377742);
        if (r2 == null) goto L17;
        LarusLayoutAiGenBgChooseCheckBoxBinding r7 = LarusLayoutAiGenBgChooseCheckBoxBinding.a(r2);
        r0 = 2131384500;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r10, 2131384500);
        if (r8 == null) goto L17;
        r0 = 2131384564;
        View r3 = ViewBindings.findChildViewById(r10, 2131384564);
        if (r3 == null) goto L17;
        LinearLayout r9 = (LinearLayout) r10;
        return new LarusLayoutBotBgChooseRowBinding(r9, r4, r5, r6, r7, r8, LarusLayoutAiGenBgChooseCheckBoxBinding.a(r3));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }

    public LarusLayoutBotBgChooseRowBinding(LinearLayout r1, SimpleDraweeView r2, LarusLayoutAiGenBgChooseCheckBoxBinding r3, SimpleDraweeView r4, LarusLayoutAiGenBgChooseCheckBoxBinding r5, SimpleDraweeView r6, LarusLayoutAiGenBgChooseCheckBoxBinding r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
