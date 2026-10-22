package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class NetImagePreloader extends com.bytedance.android.ec.sdk.initalizer.a implements pi.c {
    public static final /* synthetic */ KProperty[] b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final ReadOnlyProperty f = null;
    public static final Lazy g = null;
    public static final NetImagePreloader h = null;

    public static final class a implements ReadOnlyProperty<Object, yl.c> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public yl.c b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, yl.c] */
        public final yl.c getValue(Object r10, KProperty<?> r11) {
            Intrinsics.checkNotNullParameter(r10, "thisRef");
            Intrinsics.checkNotNullParameter(r11, "property");
            if (this.b != null) goto L5;
            LazyFastSDKSettings r12 = this.a;
            KProperty<?>[] r0 = g;
            if (r12.getValue(this, r0[0]) == this.d) goto L15;
            this.b = this.a.getValue(this, r0[0]);
            if (ColdLaunchExpFilter.e.b(this.c) == true) goto L15;
            return this.b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.e.b(this.c) == false) goto L8;
            return null;
        L8:
            return this.b;
        }

        public a(final yl.c r10, Function0 r11, Function2 r12) {
            final String r1 = "ec_net_image_preload_config";
            this.c = "ec_net_image_preload_config";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_net_image_preload_config", r10, null, r11, r12, new NetImagePreloader$$special$$inlined$lazyImageXSettingsOrNull$1$1(r1, r10));
        }
    }

    static {
        b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(NetImagePreloader.class, "config", "getConfig()Lcom/bytedance/android/ec/opt/config/NetImagePreloadConfig;", 0))};
        NetImagePreloader r0 = new NetImagePreloader();
        h = r0;
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        c = LazyKt.lazy(r1, NetImagePreloader$types$2.INSTANCE);
        d = LazyKt.lazy(NetImagePreloader$reflectionHelper$2.INSTANCE);
        e = LazyKt.lazy(r1, NetImagePreloader$enable$2.INSTANCE);
        yl.c r10 = new yl.c(null);
        NetImagePreloader$config$2 r11 = NetImagePreloader$config$2.INSTANCE;
        NetImagePreloader$config$3 r12 = new NetImagePreloader$config$3(r0);
        if (z.b() == false) goto L5;
        ReadOnlyProperty r13 = new a(r10, r11, r12);
    L6:
        f = r13;
        g = LazyKt.lazy(r1, NetImagePreloader$imagePreloaderHandler$2.INSTANCE);
        return;
    L5:
        r13 = com.bytedance.android.ec.core.opt.ab.h.b("ec_net_image_preload_config", r10, null, r11, r12);
        goto L6
    }

    public final Object b() {
        return Boxing.boxBoolean(((Boolean) e.getValue()).booleanValue());
    }

    public NetImagePreloader() {
    }

    public final Object c(Continuation<? super Unit> r10) {
        yl.c r11 = (yl.c) f.getValue(this, b[0]);
        return Unit.INSTANCE;
    }
}
