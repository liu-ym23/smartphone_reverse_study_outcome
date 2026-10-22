package com.ss.android.lark.coremd.facade.bizext.theme;

import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkMediaThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMMediaThemeData extends LarkMediaThemeData {
    public static final /* synthetic */ KProperty<Object>[] m = null;
    public final c k;
    public final c l;

    static {
        m = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMMediaThemeData.class, "mediaBorderProvider", "getMediaBorderProvider()Lkotlin/jvm/functions/Function1;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMMediaThemeData.class, "mediaCoverSizeCoordinator", "getMediaCoverSizeCoordinator()Lcom/ss/android/lark/coremd/facade/bizext/image/IMImageSizeInterceptor;", 0))};
    }

    public IMMediaThemeData(j r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super(r9);
        IMMediaThemeData$mediaBorderProvider$2 r10 = IMMediaThemeData$mediaBorderProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r10, "defaultProvider");
        KProperty<Object>[] r1 = m;
        KProperty<Object> r2 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = d.a;
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r10, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        r7.put(e.a(r2), r10);
        this.k = new c();
        IMMediaThemeData$mediaCoverSizeCoordinator$2 r11 = IMMediaThemeData$mediaCoverSizeCoordinator$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r11, "defaultProvider");
        KProperty<Object> r0 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r0, "property");
        Intrinsics.checkNotNullParameter(r0, "kProperty");
        Intrinsics.checkNotNullParameter(r11, "value");
        r7.put(e.a(r0), r11);
        this.l = new c();
    }
}
