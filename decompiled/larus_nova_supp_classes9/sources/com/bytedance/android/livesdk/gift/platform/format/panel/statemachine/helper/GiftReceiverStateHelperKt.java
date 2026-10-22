package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.revenue.core.util.i;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftReceiverViewModel;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftReceiverStateHelperKt {
    public static final StateMachine<a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> a(Function1<? super StateMachine.c<? extends a, ? extends GiftStateMachineConfig.Event, ? extends GiftStateMachineConfig.f>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        int r0 = i.a;
        q r1 = m.b;
        StateMachine.a r2 = StateMachine.c;
        GiftReceiverStateHelperKt$createReceiverStateMachine$1 r4 = new GiftReceiverStateHelperKt$createReceiverStateMachine$1(null, r3);
        r2.getClass();
        return StateMachine.a.a(r4);
    }

    public static final boolean b(int r2) {
        Intrinsics.checkNotNullParameter(null, "receiver");
        FormatGiftReceiverViewModel r0 = b.i();
        if (r0 == null) goto L8;
        a r1 = (a) r0.f.b();
        if (r1 == null) goto L8;
        List r3 = r1.b(r2).a;
        if (r3 == null) goto L8;
    L9:
        Iterator r4 = r3.iterator();
        if (r4.hasNext() == true) goto L13;
        return false;
    L13:
        ((IBaseUser) r4.next()).getIdString();
        throw null;
    L8:
        r3 = new ArrayList();
        goto L9
    }
}
