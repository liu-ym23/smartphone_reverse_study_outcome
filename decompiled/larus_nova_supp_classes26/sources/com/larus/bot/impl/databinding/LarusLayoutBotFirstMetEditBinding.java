package com.larus.bot.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotCreateTtsPlayerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutBotFirstMetEditBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatEditText b;
    public final LarusBotCreateDescSkeletonBinding c;
    public final View d;
    public final AppCompatTextView e;
    public final ItemTextArrow f;
    public final BotCreateTtsPlayerView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutBotFirstMetEditBinding(ConstraintLayout r1, AppCompatEditText r2, LarusBotCreateDescSkeletonBinding r3, View r4, AppCompatTextView r5, ItemTextArrow r6, BotCreateTtsPlayerView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
