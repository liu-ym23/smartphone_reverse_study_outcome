package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements CoreNavigationBar.f {
    public final /* synthetic */ com.ss.android.lark.biz.im.api.extension.chat_window.j a;
    public final /* synthetic */ TitleTheme.ThemeType b;
    public final /* synthetic */ TitleBarActionKey c;

    public j(com.ss.android.lark.biz.im.api.extension.chat_window.j r1, TitleTheme.ThemeType r2, TitleBarActionKey r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.f
    public final View createView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        AppCompatTextView r0 = new AppCompatTextView(r8);
        com.ss.android.lark.biz.im.api.extension.chat_window.l r1 = this.a;
        TitleTheme.ThemeType r2 = this.b;
        TitleBarActionKey r3 = this.c;
        com.ss.android.lark.biz.im.api.extension.chat_window.l r4 = r1;
        r0.setText(r4.getText());
        r4.getTextSize();
        r0.setTextSize(2, 17);
        r4.c(r2);
        r0.setTextColor(ContextCompat.getColor(r8, 2131102040));
        r0.setMaxLines(1);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setGravity(17);
        r0.setTag(r3);
        r0.setPadding(r4.e(), r4.b(), r4.e(), r4.b());
        return r0;
    }
}
