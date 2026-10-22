package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements kp1.c {
    public static final Pair<ElementType, kp1.c> a = null;
    public static final w b = null;

    public w() {
    }

    static {
        w r0 = new w();
        b = r0;
        a = TuplesKt.to(ElementType.Unknown, r0);
    }

    @Override // kp1.c
    public final kp1.b<? extends lp1.b<Object>> a(kp1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L7;
        return new x(r2.b);
    L7:
        throw new IllegalStateException("AudienceElementFactory：未匹配的element类型");
    }
}
