package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.immerse.ChatImmerseConstraintLayout;
import com.larus.common_ui.widget.RedDotTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageChatImmersiveBinding implements ViewBinding {
    public final ChatImmerseConstraintLayout a;
    public final AppCompatImageView b;
    public final ViewPager2 c;
    public final RedDotTextView d;
    public final ImageView e;
    public final ConstraintLayout f;
    public final ConstraintLayout g;
    public final ConstraintLayout h;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageChatImmersiveBinding(ChatImmerseConstraintLayout r1, AppCompatImageView r2, ViewPager2 r3, RedDotTextView r4, ImageView r5, ConstraintLayout r6, ConstraintLayout r7, ConstraintLayout r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
