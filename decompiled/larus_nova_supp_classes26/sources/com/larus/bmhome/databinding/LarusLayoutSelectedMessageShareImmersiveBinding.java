package com.larus.bmhome.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.bot.share.ImmerseBgBitmapImageView;
import com.larus.bmhome.chat.view.share.MessageListMaskView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutSelectedMessageShareImmersiveBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final View c;
    public final ImmerseBgBitmapImageView d;
    public final MessageListMaskView e;
    public final View f;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutSelectedMessageShareImmersiveBinding(ConstraintLayout r1, ConstraintLayout r2, View r3, ImmerseBgBitmapImageView r4, MessageListMaskView r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
