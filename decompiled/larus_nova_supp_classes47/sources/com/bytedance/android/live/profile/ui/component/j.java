package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements yt1.h {
    public final /* synthetic */ i a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Context c;

    public final String a() {
        return "shop_custom_method";
    }

    public final DSLActionEnum getName() {
        return DSLActionEnum.CustomOpenShopOrDismiss;
    }

    public final void b(Map r4, yt1.j r5) {
        Object r6 = null;
        if (r4 == null) goto L5;
        Object r0 = r4.get("scheme");
    L7:
        if ((r0 instanceof String) == true) goto L9;
        r0 = null;
    L9:
        String r1 = (String) r0;
        if (r1 != null) goto L39;
        return;
    L39:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        Object r7 = r4.get("current_room_index");     // Catch: Throwable -> L22
        if ((r7 instanceof Integer) == false) goto L16;
        r6 = r7;
    L16:
        Integer r8 = (Integer) r6;     // Catch: Throwable -> L22
        if (r8 == null) goto L19;
        int r9 = r8.intValue();     // Catch: Throwable -> L22
    L20:
        Object r10 = Result.constructor-impl(Integer.valueOf(r9));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r10) == false) goto L27;
        r10 = -1;
    L27:
        int r12 = ((Number) r10).intValue();
        if (this.b == false) goto L35;
        if (r12 != 0) goto L35;
        com.bytedance.android.live.profile.ui.base.l r13 = this.a.h;
        if (r13 == null) goto L42;
        com.bytedance.android.live.profile.profilecontext.a r14 = r13.b();
        if (r14 == null) goto L43;
        r14.dismiss();
        return;
    L43:
        return;
    L42:
        return;
    L35:
        IBaseLiveActionHandler r15 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r15 == null) goto L45;
        r15.handle(this.c, r1);
        return;
    L45:
        return;
    L19:
        r9 = -1;
    L22:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L5:
        r0 = null;
        goto L7
    }

    public j(i r1, boolean r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
