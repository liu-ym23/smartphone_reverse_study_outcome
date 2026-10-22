package com.ss.android.lark.emoji_office.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class OfficeReactionDetailPopupBinding implements ViewBinding {
    public final LinearLayout a;
    public final AppCompatImageView b;
    public final TabLayout c;
    public final ViewPager2 d;

    public final View getRoot() {
        return this.a;
    }

    public OfficeReactionDetailPopupBinding(LinearLayout r1, AppCompatImageView r2, TabLayout r3, ViewPager2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
