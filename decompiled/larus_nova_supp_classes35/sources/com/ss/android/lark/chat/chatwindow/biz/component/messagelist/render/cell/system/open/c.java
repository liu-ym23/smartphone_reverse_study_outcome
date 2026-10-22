package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.base.view.vo.message.d;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import mya.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.biz.im.api.extension.message.system.a {
    public final /* synthetic */ SystemContent a;
    public final /* synthetic */ v5b.c<d> b;
    public final /* synthetic */ m2b.a c;

    public final h a() {
        return this.c.j5();
    }

    public final FragmentActivity context() {
        return this.c.getContext();
    }

    public final SystemContent content() {
        return this.a;
    }

    public final v5b.c<d> message() {
        return this.b;
    }

    public c(SystemContent r1, y6b.a r2, m2b.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
