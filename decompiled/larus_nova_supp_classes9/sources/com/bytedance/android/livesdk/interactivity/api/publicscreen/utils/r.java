package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommonKt;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final PSMessageAction a(IPublicAreaCommon r1) {
        Intrinsics.checkNotNullParameter(r1, "data");
        int r2 = r1.getActionType();
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L19;
        if (r2 == 3) goto L18;
        if (r2 == 4) goto L17;
        return PSMessageAction.UNKNOW;
    L17:
        return PSMessageAction.SYSTEM;
    L18:
        return PSMessageAction.BUSINESS;
    L19:
        return PSMessageAction.BASIC;
    L15:
        return PSMessageAction.CHAT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        int r0 = com.bytedance.android.livesdk.interactivity.service.model.e.a;
        boolean r1 = false;
        if (com.bytedance.android.livesdk.interactivity.service.model.e.a.a().publicScreenMessage == true) goto L6;
    L28:
        return r1;
    L6:
        if ((r4 instanceof com.bytedance.android.livesdk.interactivity.api.n) == false) goto L12;
        IPublicAreaCommon r2 = ((com.bytedance.android.livesdk.interactivity.api.n) r4).a().c();
        if (r2 != null) goto L10;
    L19:
        if (r1 == false) goto L28;
        boolean r3 = TextMessageTracer.a;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L28;
        StringBuilder r5 = new StringBuilder("filter message by server ");
        T r6 = r4.b;
        if (r6 == 0) goto L26;
        Long r7 = Long.valueOf(r6.getMessageId());
    L27:
        r5.append(r7);
        ALogger.i("TextMessageTracer", r5.toString());
        goto L28
    L26:
        r7 = null;
        goto L27
    L10:
        if (IPublicAreaCommonKt.getNeedFilterDisplay(r2) != true) goto L19;
    L18:
        r1 = true;
        goto L19
    L12:
        tlc.d r8 = r4.b;
        if (r8 == null) goto L19;
        IPublicAreaCommon r9 = v3.a(r8);
        if (r9 == null) goto L19;
        if (IPublicAreaCommonKt.getNeedFilterDisplay(r9) != true) goto L19;
        goto L18
    }

    @JvmStatic
    public static final boolean c(tlc.d r2) {
        String r1 = null;
        if ((r2 instanceof com.bytedance.android.live.base.model.message.t) == true) goto L5;
        r2 = null;
    L5:
        com.bytedance.android.live.base.model.message.t r3 = (com.bytedance.android.live.base.model.message.t) r2;
        if (r3 == null) goto L11;
        Map r4 = r3.getMessageExtra();
        if (r4 == null) goto L11;
        r1 = (String) r4.get("top_message");
    L11:
        return Intrinsics.areEqual(r1, "1");
    }

    @JvmStatic
    public static final void d(com.bytedance.android.live.base.model.message.t r1, PSMessageAction r2) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r2, "action");
        if ((r1 instanceof u3) == false) goto L8;
        IPublicAreaCommon r3 = ((u3) r1).getOrInitPublicAreaCommon();
        if (r3 == null) goto L9;
        r3.setActionType(r2.getServerValue());
        return;
    L9:
        return;
    }
}
