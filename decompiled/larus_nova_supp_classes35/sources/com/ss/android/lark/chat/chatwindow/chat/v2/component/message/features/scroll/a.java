package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a extends com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a {
    void a();

    s0 b();

    void e(int r1, boolean r2);

    a1 h();

    w0 i();

    void r(ScrollScene r1, int r2, boolean r3, int r4);

    void t3(ScrollScene r1, int r2, boolean r3, boolean r4, IMessageListComponent.k r5, Function1<? super MessageInfo, Boolean> r6);
}
