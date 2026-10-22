package com.ss.android.lark.flow.threadwindow.plugin;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends com.ss.android.lark.flow.chat.page.flow.plugin.b {
    public h() {
    }

    @Override // com.ss.android.lark.flow.chat.page.flow.plugin.b
    public final List<com.ss.android.lark.chat.chatwindow.biz.plugin.core.d> a(FragmentActivity r2, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        return CollectionsKt.plus(super.a(r2, r3), CollectionsKt.listOf(new FlowThreadWindowMsgTipsPlugin()));
    }
}
