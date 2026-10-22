package com.ss.android.lark.chat.core.api;

import com.ss.android.lark.chat.chatwindow.biz.plugin.core.f;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Collection;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import yya.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c extends f {
    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.f
    com.ss.android.lark.chat.chatwindow.biz.plugin.core.e a(i7b.a r1);

    Object b(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r1, String r2, int r3, Continuation<? super Result<? extends ChatMessageResponse>> r4);

    Collection<l> c();

    x4b.c d(v r1, m2b.a r2, boolean r3, boolean r4, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r5);

    Collection<yya.b> e();

    Object f(String r1, int r2, Continuation<? super Result<? extends ChatMessageResponse>> r3);

    b g();

    Collection<com.ss.android.lark.chat.chatwindow.chat.perload.d<? extends u3b.a, ?>> h();

    e i(Chat r1);
}
