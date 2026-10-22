package com.bytedance.android.live.core.tetris.componentx;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.InnerComponentListener;
import com.bytedance.android.live.core.tetris.componentx.schedule.m;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements ComponentSchedulingManager.b {
    public final /* synthetic */ ComponentManager a;

    public c(ComponentManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager.b
    public final void a(final int r9, final m r11, final boolean r12) {
        if (r11 == null) goto L14;
        ComponentManager r0 = this.a;
        r0.n = r9;
        ALogger.i(r0.a, "Execute load batch " + r9);
        ComponentManagerABHelper r1 = ComponentManagerABHelper.INSTANCE;
        if (r1.enableWhenLoadCheckCanLoad() == false) goto L10;
        InnerComponentListener r2 = this.a.h;
        if (r2 == null) goto L15;
        long r6 = r1.schedulerLoadResultTimeout();
        Intrinsics.checkNotNullParameter(r11, "components");
        r2.c = r9;
        r2.p(r11);
        r2.q(r6);
        ALogger.i(r2.e, "批次" + r9 + " 一共有 " + r2.h.size() + 20010);
        LayerDescriptorList r13 = r2.m(r11);
        if (r13 == null) goto L16;
        this.a.L3(r13, true, true, r12);
        return;
    L16:
        return;
    L15:
        return;
    L10:
        InnerComponentListener r3 = this.a.h;
        if (r3 == null) goto L18;
        long r7 = r1.schedulerLoadResultTimeout();
        Function0<Unit> r4 = new ComponentManager$getLoadNotifyListener$1$onExecutorNotify$$inlined$let$lambda$1(r11, this, r9, r12);
        Intrinsics.checkNotNullParameter(r11, "components");
        Intrinsics.checkNotNullParameter(r4, "function");
        r3.c = r9;
        r3.p(r11);
        r3.q(r7);
        r3.m(r11);
        ALogger.i(r3.e, "批次" + r9 + " 一共有 " + r3.h.size() + 20010);
        Unit r14 = (Unit) r4.invoke();
        return;
    L18:
        return;
    }
}
