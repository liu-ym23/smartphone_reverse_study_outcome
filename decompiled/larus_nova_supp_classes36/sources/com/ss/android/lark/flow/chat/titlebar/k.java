package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements CoreNavigationBar.f {
    public final /* synthetic */ com.ss.android.lark.biz.im.api.extension.chat_window.j a;
    public final /* synthetic */ TitleTheme.ThemeType b;
    public final /* synthetic */ TitleBarActionKey c;

    public k(com.ss.android.lark.biz.im.api.extension.chat_window.j r1, TitleTheme.ThemeType r2, TitleBarActionKey r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.f
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AppCompatImageView r0 = new AppCompatImageView(r5);
        com.ss.android.lark.biz.im.api.extension.chat_window.k r6 = this.a;
        TitleTheme.ThemeType r1 = this.b;
        TitleBarActionKey r2 = this.c;
        r0.setScaleType(ImageView.ScaleType.CENTER);
        r0.setImageDrawable(r6.g(r1));
        r0.setTag(r2);
        return r0;
    }
}
