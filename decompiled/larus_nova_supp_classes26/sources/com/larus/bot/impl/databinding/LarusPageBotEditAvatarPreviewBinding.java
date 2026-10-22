package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ChatCheckBox;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget.BotBgImagePreviewView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageBotEditAvatarPreviewBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final FrameLayout c;
    public final ProgressBar d;
    public final BotBgImagePreviewView e;
    public final TextView f;
    public final ChatCheckBox g;
    public final LinearLayout h;
    public final TextView i;
    public final NovaTitleBarEx j;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageBotEditAvatarPreviewBinding(ConstraintLayout r1, SimpleDraweeView r2, FrameLayout r3, ProgressBar r4, BotBgImagePreviewView r5, TextView r6, ChatCheckBox r7, LinearLayout r8, TextView r9, NovaTitleBarEx r10) {
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
    }
}
