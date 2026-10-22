package com.ss.android.lark.flow.chat.message.system;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.extension.ImPlugin;
import com.ss.android.lark.integrator.im.extension.ImContextImpl;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ImPlugin
public final class c implements qxa.b {
    public c() {
    }

    public final void a(ImContextImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.d(ImExtensionType.MESSAGE_ACTION_HANDLER_PROVIDER, CollectionsKt.listOf(d.class));
        r5.d(ImExtensionType.SYSTEM_MESSAGE_ACTION_PROCESSOR, CollectionsKt.listOf(new Class[]{b.class, a.class}));
    }
}
