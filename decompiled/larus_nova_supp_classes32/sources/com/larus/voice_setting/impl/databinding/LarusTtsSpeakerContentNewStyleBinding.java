package com.larus.voice_setting.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.voice_setting.voice.mix.SingleVoiceBar;
import com.larus.voice_setting.voice.mix.VoiceEditArea;
import com.larus.voice_setting.voice.mix.VoiceMixBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusTtsSpeakerContentNewStyleBinding implements ViewBinding {
    public final CoordinatorLayout a;
    public final AppBarLayout b;
    public final CollapsingToolbarLayout c;
    public final Toolbar d;
    public final VoiceMixBar e;
    public final TabLayout f;
    public final ViewPager2 g;
    public final SingleVoiceBar h;
    public final ItemTextToggle i;
    public final FrameLayout j;
    public final VoiceEditArea k;

    public final View getRoot() {
        return this.a;
    }

    public LarusTtsSpeakerContentNewStyleBinding(CoordinatorLayout r1, AppBarLayout r2, CollapsingToolbarLayout r3, Toolbar r4, VoiceMixBar r5, TabLayout r6, ViewPager2 r7, SingleVoiceBar r8, ItemTextToggle r9, FrameLayout r10, VoiceEditArea r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
