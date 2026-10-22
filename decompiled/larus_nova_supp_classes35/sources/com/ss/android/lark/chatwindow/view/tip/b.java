package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class b<T> extends a<T> {
    public int f;
    public boolean g;
    public int h;
    public final boolean i;

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean f() {
        return false;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final int b() {
        return this.b.G7();
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final int c() {
        int r0 = this.b.i() - this.h;
        int r1 = this.b.h();
        if (r0 >= 0) goto L6;
        return 0;
    L6:
        return Math.min(r1, r0);
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean g() {
        if (this.b.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.d == true) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean h() {
        if ((!this.d) == true) goto L5;
    L7:
        return false;
    L5:
        if (c() <= 0) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean i() {
        if (g() == false) goto L6;
        return true;
    L6:
        if (this.b.f() != Chat.MessagePosition.NEWEST_UNREAD) goto L15;
        if (this.g == true) goto L10;
    L12:
        return false;
    L10:
        if (c() <= 0) goto L12;
        return true;
    L15:
        if (c() > 0) goto L20;
        return false;
    L20:
        return true;
    }

    public b(Context r1, r7b.c r2) {
        super(r1, r2);
        this.i = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final void j(List<T> r4, a.b<T> r5) {
        Iterator r0 = ((ArrayList) r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Object r1 = r0.next();
        this.h = Math.max(this.h, r5.b(r1));
        goto L4
    L6:
        super.j(r4, r5);
    }
}
