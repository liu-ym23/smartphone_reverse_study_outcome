package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveRequireGiftEffectLynxViewResultModel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.cb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends wy0.b<cb, LiveRequireGiftEffectLynxViewResultModel> {
    public final l02.h a;

    public static final class a {
    }

    static {
    }

    public final Type k() {
        return TypesJVMKt.getJavaType(Reflection.typeOf(cb.class));
    }

    public m(l02.h r2) {
        Intrinsics.checkNotNullParameter(r2, "effectInfoService");
        this.a = r2;
    }

    public final void l(vh7.j r10, CallContext r11) {
        cb r13 = (cb) r10;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r11, "callContext");
        l02.h r1 = this.a;
        Integer r14 = r13.getAction();
        if (r14 == null) goto L5;
        int r2 = r14.intValue();
    L6:
        Integer r15 = r13.getType();
        if (r15 == null) goto L9;
        int r3 = r15.intValue();
    L10:
        Boolean r16 = r13.U2();
        if (r16 == null) goto L13;
        boolean r4 = r16.booleanValue();
    L14:
        String r17 = r13.getSchema();
        if (r17 != null) goto L17;
        r17 = BuildConfig.FLAVOR;
    L17:
        String r5 = r17;
        Boolean r18 = r13.I5();
        if (r18 == null) goto L20;
        boolean r6 = r18.booleanValue();
    L21:
        r1.a(r2, r3, r4, r5, r6, r13.getChannel(), r13.i2());
        return;
    L20:
        r6 = false;
        goto L21
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }
}
