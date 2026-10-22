package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2;

import a2b.j;
import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import kotlin.jvm.internal.Intrinsics;
import q3b.r;
import x4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final m2b.a a;
    public final v b;
    public final d c;
    public final BasePageStore.c<MessageInfo> d;
    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a e;
    public final MessageListPinExtraLoader f;
    public final j.a g;
    public final boolean h;

    public final m2b.a getContext() {
        return this.a;
    }

    public b(m2b.a r2, v r3, d r4, MessageListViewModelV2.w r5, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r6, MessageListPinExtraLoader r7, r r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "executor");
        Intrinsics.checkNotNullParameter(r5, "onDataChangeListener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
