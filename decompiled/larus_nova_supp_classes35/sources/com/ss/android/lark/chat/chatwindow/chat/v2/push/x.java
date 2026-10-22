package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface x {
    Object a(String r1, int r2, Continuation<? super Result<? extends ChatMessageResponse>> r3);

    Object b(String r1, int r2, Continuation<? super Result<? extends ChatMessageResponse>> r3);

    Object c(fxa.b r1, Continuation<? super Result<? extends i7b.a>> r2);
}
