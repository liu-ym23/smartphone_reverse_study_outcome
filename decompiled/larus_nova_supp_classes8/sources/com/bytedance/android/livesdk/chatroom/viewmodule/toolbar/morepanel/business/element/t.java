package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t implements kp1.c {
    public static final Pair<ElementType, kp1.c> a = null;

    public t() {
    }

    static {
        t r0 = new t();
        a = TuplesKt.to(ElementType.ShareIM, r0);
    }

    @Override // kp1.c
    public final kp1.b<? extends lp1.b<Object>> a(kp1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return new AudienceShareIMElement(r2.b);
    }
}
