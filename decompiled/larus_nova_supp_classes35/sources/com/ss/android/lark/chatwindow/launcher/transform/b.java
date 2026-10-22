package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {
    Object a(String r1, ProfileSource r2, Continuation<? super Result<? extends Chat>> r3);

    Object b(String r1, Continuation<? super Result<? extends Chat>> r2);

    Object c(String r1, Continuation<? super Result<? extends Chatter>> r2);
}
