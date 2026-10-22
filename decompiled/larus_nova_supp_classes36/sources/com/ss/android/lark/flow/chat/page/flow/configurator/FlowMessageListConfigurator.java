package com.ss.android.lark.flow.chat.page.flow.configurator;

import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorKey;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import l3c.c;
import l3c.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ConfiguratorKey(ConfiguratorType.MESSAGE_LIST)
public final class FlowMessageListConfigurator implements c {
    public final Lazy a;

    @Inject
    public FlowMessageListConfigurator() {
        this.a = LazyKt.lazy(FlowMessageListConfigurator$coreConfigurator$2.INSTANCE);
    }

    public final void a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "rt");
        ((d) this.a.getValue()).a(r2);
    }
}
