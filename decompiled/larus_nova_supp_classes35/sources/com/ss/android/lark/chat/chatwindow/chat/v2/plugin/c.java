package com.ss.android.lark.chat.chatwindow.chat.v2.plugin;

import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ StatusBarPlugin a;

    public c(StatusBarPlugin r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        StatusBarPlugin r0 = this.a;
        Intrinsics.checkNotNull(r5);
        r0.k = r5.intValue();
        if (r5.intValue() != 2) goto L14;
        ITitlebarComponent r6 = this.a.h;
        if (r6 == null) goto L7;
        TitleTheme r7 = r6.getTheme();
    L8:
        if (r7 == null) goto L15;
        StatusBarPlugin r1 = this.a;
        Integer r2 = r7.b;
        if (r2 == null) goto L12;
        r1.F(r7.getType(), r2);
        return;
    L12:
        r1.F(r7.getType(), null);
        return;
    L15:
        return;
    L7:
        r7 = null;
        goto L8
    }
}
