package com.bytedance.ai.settings;

import com.bytedance.ai.debug.f;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a<T> {
    public final String a;
    public final T b;
    public final Type c;

    public final T a() {
        f.a r0 = f.a;
        String r1 = this.a;
        Type r10 = this.c;
        T r11 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r10, "type");
        if (r11 == null) goto L5;
        return r11;
    L5:
        return this.b;
    }

    public final Type getType() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        this.a = r10;
        this.b = r11;
        Class<?> r12 = r11.getClass();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.Class<T of com.bytedance.ai.settings.AISDKSetting>");
        this.c = r12;
    }
}
