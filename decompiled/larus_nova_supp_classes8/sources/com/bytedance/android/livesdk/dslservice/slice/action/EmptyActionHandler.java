package com.bytedance.android.livesdk.dslservice.slice.action;

import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ecom.arch.slice.render.b;
import com.bytedance.android.livesdk.dslservice.util.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class EmptyActionHandler implements b {
    public static final EmptyActionHandler a = null;

    public EmptyActionHandler() {
    }

    static {
        a = new EmptyActionHandler();
    }

    public final void a(r r3) {
        Intrinsics.checkNotNullParameter(r3, "actionInfo");
        o r4 = o.f;
        EmptyActionHandler$handleAction$1 r0 = EmptyActionHandler$handleAction$1.INSTANCE;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "initBlock");
        r4.e(2, r0);
    }
}
