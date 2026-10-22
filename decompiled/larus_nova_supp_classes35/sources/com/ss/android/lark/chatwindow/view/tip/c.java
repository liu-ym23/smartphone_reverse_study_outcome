package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wgb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class c<T> extends a<T> {
    public int f;
    public int g;
    public int h;

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean f() {
        return true;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean g() {
        return false;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean i() {
        f r0 = (f) this;
        if ((r0.g - r0.h) > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.b.f() != Chat.MessagePosition.NEWEST_UNREAD) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final int b() {
        if (this.f <= this.b.b()) goto L7;
        return this.f;
    L7:
        return this.b.G7();
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean h() {
        if (this.b.f() == Chat.MessagePosition.NEWEST_UNREAD) goto L5;
    L9:
        return false;
    L5:
        if ((!this.d) == false) goto L9;
        f r0 = (f) this;
        if ((r0.g - r0.h) <= 0) goto L9;
        ChatCoreModule.a().getAppConfigDependency().isOn();
        return true;
    }

    static {
        UIHelper.getDimens(2131168457);
    }

    public c(Context r1, r7b.c r2) {
        super(r1, r2);
        UIHelper.dp2px(8.0f);
        this.g = -1;
        UIHelper.dp2px(8.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final void j(List<T> r4, a.b<T> r5) {
        Iterator r0 = ((ArrayList) r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        int r1 = r5.b(r0.next());
        if (r1 == (-1)) goto L4;
        if (this.g <= r1) goto L4;
        this.g = r1;
        goto L4
    L11:
        super.j(r4, r5);
    }
}
