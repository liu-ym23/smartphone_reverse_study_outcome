package com.ss.android.lark.flow.mergeforward.page.plugin;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.c;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.flow.chat.page.flow.plugin.b {
    public a() {
    }

    @Override // com.ss.android.lark.flow.chat.page.flow.plugin.b
    public final List<d> a(FragmentActivity r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        return super.a(r2, r3);
    }
}
