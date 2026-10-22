package com.ss.android.lark.flow.chat.page.flow.plugin;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin;
import com.ss.android.lark.flow.chat.page.flow.plugin.tip.FlowMessageTipsPlugin;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends b {
    public c() {
    }

    @Override // com.ss.android.lark.flow.chat.page.flow.plugin.b
    public final List<com.ss.android.lark.chat.chatwindow.biz.plugin.core.d> a(FragmentActivity r2, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        List r4 = CollectionsKt.toMutableList(super.a(r2, r3));
        r4.add(new FlowMessageTipsPlugin());
        r4.add(new com.ss.android.lark.chat.chatwindow.chat.v2.plugin.b());
        r4.add(new FlowChatReadablePlugin());
        r4.add(new FlowMessageSelectPlugin(0));
        r4.add(new i());
        r4.add(new com.ss.android.lark.chat.chatwindow.chat.v2.plugin.a());
        return CollectionsKt.toList(r4);
    }
}
