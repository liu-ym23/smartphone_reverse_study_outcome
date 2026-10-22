package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k extends o2<f10.e, InteractEntranceCell, l> {
    public k() {
        this(null);
    }

    public k(Object r2) {
        Function2<InteractEntranceCell, l, f10.e> r3 = PreviewOpenFeatureBehaviorProviderKt.a;
        Intrinsics.checkNotNullParameter(r3, "behaviorFactory");
        super(r3);
    }

    public final Object b(o2.b r1, o2.a r2, Object r3) {
        l r4 = (l) r2;
        f10.e r5 = (f10.e) r3;
        Intrinsics.checkNotNullParameter((InteractEntranceCell) r1, "data");
        Intrinsics.checkNotNullParameter(r5, "behavior");
        return r5;
    }
}
