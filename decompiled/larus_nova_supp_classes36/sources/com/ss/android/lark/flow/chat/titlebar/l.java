package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements CoreNavigationBar.f {
    public final /* synthetic */ TitleBarActionKey a;

    public l(TitleBarActionKey r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.f
    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AppCompatTextView r0 = new AppCompatTextView(r3);
        TitleBarActionKey r4 = this.a;
        r0.setText("");
        r0.setTag(r4);
        return r0;
    }
}
