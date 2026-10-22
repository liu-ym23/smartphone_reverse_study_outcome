package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusDialogAvatarPromptInputBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final AppCompatEditText c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogAvatarPromptInputBinding(FrameLayout r1, ImageView r2, AppCompatEditText r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
