package com.larus.bot.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget.FixedAspectRatioConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutBotBgImagePreviewBinding implements ViewBinding {
    public final View a;
    public final FixedAspectRatioConstraintLayout b;
    public final FixedAspectRatioConstraintLayout c;
    public final FixedAspectRatioConstraintLayout d;
    public final SimpleDraweeView e;
    public final View f;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutBotBgImagePreviewBinding(View r1, FixedAspectRatioConstraintLayout r2, FixedAspectRatioConstraintLayout r3, FixedAspectRatioConstraintLayout r4, SimpleDraweeView r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
