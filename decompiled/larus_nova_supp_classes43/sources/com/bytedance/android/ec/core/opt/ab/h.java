package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final /* synthetic */ KProperty[] a = null;
    public static final a b = null;

    public static final class a implements ReadOnlyProperty<Object, cj.b> {
        public cj.b a;

        public a() {
        }

        public final cj.b getValue(Object r10, KProperty<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "property");
            cj.b r12 = this.a;
            if (r12 == null) goto L5;
            return r12;
        L5:
            int r13 = ECSdk.a;
            cj.b r14 = (cj.b) ECSdk.a(cj.b.class);
            if (r14 == null) goto L11;
            if (StringsKt.contains$default(r14.getClass().getSimpleName(), "DefaultImpl_", false, 2, null) == true) goto L12;
            this.a = r14;
            return r14;
        L12:
            return r14;
        L11:
            return null;
        }
    }

    static {
        a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(h.class, "shoppingPerfOptService", "getShoppingPerfOptService()Lcom/bytedance/android/ec/host/api/opt/IShoppingPerfOptService;", 1))};
        b = new a();
    }

    public static final LazyOptHostSettings a(String r10, Object r11, com.bytedance.android.ec.core.imagex.opt.w.b r12, Function0 r13, Function2 r14) {
        Intrinsics.checkNotNullParameter(r10, "configKey");
        Intrinsics.checkNotNullParameter(r11, "defaultConfig");
        Intrinsics.checkNotNullParameter(r13, "isEnable");
        return new LazyOptHostSettings(r10, r11, r12, r13, r14);
    }

    public static final i b(String r10, Object r11, com.bytedance.android.ec.core.imagex.opt.w.b r12, Function0 r13, Function2 r14) {
        Intrinsics.checkNotNullParameter(r10, "configKey");
        Intrinsics.checkNotNullParameter(r11, "defaultConfig");
        Intrinsics.checkNotNullParameter(r13, "isEnable");
        Intrinsics.checkNotNullParameter(r14, "onConfigReady");
        return new i(r10, r11, r12, r13, r14);
    }
}
