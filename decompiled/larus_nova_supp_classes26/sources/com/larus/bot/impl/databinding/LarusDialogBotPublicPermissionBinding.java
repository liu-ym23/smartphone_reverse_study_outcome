package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bot.impl.feature.edit.view.BotAccessPermissionItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusDialogBotPublicPermissionBinding implements ViewBinding {
    public final ScrollView a;
    public final TextView b;
    public final BotAccessPermissionItem c;
    public final BotAccessPermissionItem d;
    public final View e;
    public final BotAccessPermissionItem f;
    public final View g;
    public final ImageView h;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogBotPublicPermissionBinding(ScrollView r1, TextView r2, BotAccessPermissionItem r3, BotAccessPermissionItem r4, View r5, BotAccessPermissionItem r6, View r7, ImageView r8) {
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
