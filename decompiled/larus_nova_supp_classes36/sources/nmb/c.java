package nmb;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.extension.ImPlugin;
import com.ss.android.lark.flow.chat.menu.FlowImMessageActionFactoryConfig;
import com.ss.android.lark.integrator.im.extension.ImContextImpl;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ImPlugin
public final class c implements qxa.b {
    public c() {
    }

    public final void a(ImContextImpl r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        r4.d(ImExtensionType.MESSAGE_ACTION_PROVIDER, (List) FlowImMessageActionFactoryConfig.a.getValue());
        ImExtensionType r0 = ImExtensionType.MESSAGE_ACTION_INTERCEPTOR;
        List r1 = CollectionsKt.toMutableList((List) FlowImMessageActionFactoryConfig.b.getValue());
        r1.add(qmb.a.class);
        Unit r2 = Unit.INSTANCE;
        r4.d(r0, r1);
        r4.c(new kgb.a());
    }
}
