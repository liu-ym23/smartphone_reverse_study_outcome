package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.component.bottom.floating.button.BottomFloatingButton;
import com.larus.bmhome.view.FastScrollButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageChatBottomFloatingButtonBinding implements ViewBinding {
    public final FrameLayout a;
    public final BottomFloatingButton b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final FastScrollButton e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageChatBottomFloatingButtonBinding(FrameLayout r1, BottomFloatingButton r2, LinearLayout r3, LinearLayout r4, FastScrollButton r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
