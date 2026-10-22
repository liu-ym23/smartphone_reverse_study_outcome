package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.view.ChatConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageChatDoubleTabBinding implements ViewBinding {
    public final ChatConstraintLayout a;
    public final ChatConstraintLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ViewPager2 f;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageChatDoubleTabBinding(ChatConstraintLayout r1, ChatConstraintLayout r2, FrameLayout r3, FrameLayout r4, FrameLayout r5, ViewPager2 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
