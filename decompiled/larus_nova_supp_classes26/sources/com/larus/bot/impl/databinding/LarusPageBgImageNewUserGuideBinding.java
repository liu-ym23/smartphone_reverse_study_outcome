package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageBgImageNewUserGuideBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final SimpleDraweeView c;
    public final TextView d;
    public final NovaTitleBarEx e;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageBgImageNewUserGuideBinding(ConstraintLayout r1, View r2, SimpleDraweeView r3, TextView r4, NovaTitleBarEx r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
