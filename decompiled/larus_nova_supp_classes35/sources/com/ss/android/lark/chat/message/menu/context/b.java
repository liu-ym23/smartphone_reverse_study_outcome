package com.ss.android.lark.chat.message.menu.context;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.i;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.j;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.k;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.l;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.m;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.n;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import yya.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class b extends g implements l, j, o4b.a, n, ChatReplyActionProvider.c, i, x2b.a, m, k {
    public final PageType e;
    public final m2b.a f;
    public final com.ss.android.lark.chat.chatwindow.chat.menu.handler.b g;

    public Fragment d() {
        return this.f.R();
    }

    @Override // com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider.c
    public final OpenApp e() {
        return this.f.e();
    }

    public FragmentActivity getActivity() {
        return this.f.getContext();
    }

    public final Chat getChat() {
        return this.f.getChat();
    }

    public Context getContext() {
        return this.f.getContext();
    }

    @Override // x2b.a
    public final m2b.a a() {
        return this.f;
    }

    public final PageType r() {
        return this.e;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.j
    public final void R(int r2) {
        this.g.R(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.k
    public final void c(String r3) {
        com.ss.android.lark.chat.chatwindow.chat.menu.handler.b r0 = this.g;
        if ((r0 instanceof k) == false) goto L6;
        ((k) r0).c(r3);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.n
    public final void h(String r2) {
        this.g.h(r2);
    }

    @Override // o4b.a
    public final void U(PhotoItem r2, boolean r3) {
        this.g.U(r2, r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.i
    public final void X(String r2, int r3) {
        this.g.X(r2, r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.m
    public final void b(y6b.c<?> r3, yya.n r4) {
        com.ss.android.lark.chat.chatwindow.chat.menu.handler.b r0 = this.g;
        if ((r0 instanceof m) == false) goto L6;
        ((m) r0).b(r3, r4);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.l
    public final void o(String r2, int r3) {
        this.g.o(r2, r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.l
    public final void I(String r2, int r3, PartialReplyInfo r4) {
        this.g.I(r2, r3, r4);
    }

    public b(yya.n r1, PageType r2, m2b.a r3, com.ss.android.lark.chat.chatwindow.chat.menu.handler.b r4) {
        super(r1);
        this.e = r2;
        this.f = r3;
        this.g = r4;
    }
}
