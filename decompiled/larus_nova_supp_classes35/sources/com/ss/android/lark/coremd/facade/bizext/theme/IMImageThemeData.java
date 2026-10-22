package com.ss.android.lark.coremd.facade.bizext.theme;

import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkImageThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMImageThemeData extends LarkImageThemeData {
    public static final /* synthetic */ KProperty<Object>[] r = null;
    public final c m;
    public final c n;
    public final c o;
    public final c p;
    public final c q;

    static {
        r = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "imageBackgroundColorRes", "getImageBackgroundColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "showImageBorder", "getShowImageBorder()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "showImageMode", "getShowImageMode()Lcom/ss/android/lark/coremd/facade/bizext/image/IMShowImageScene;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "imageSizeCoordinator", "getImageSizeCoordinator()Lcom/ss/android/lark/coremd/facade/bizext/image/IMImageSizeInterceptor;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "imageBorderProvider", "getImageBorderProvider()Lkotlin/jvm/functions/Function1;", 0))};
    }

    public IMImageThemeData(j r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super(r9);
        final int r10 = 2131100548;
        Function1<j, Integer> r0 = new IMImageThemeData$special$$inlined$extend$1(r10);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = r;
        KProperty<Object> r2 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = d.a;
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        r7.put(e.a(r2), r0);
        this.m = new c();
        final Boolean r3 = Boolean.TRUE;
        Function1<j, Boolean> r4 = new IMImageThemeData$special$$inlined$extend$2(r3);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r6 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        Intrinsics.checkNotNullParameter(r6, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(e.a(r6), r4);
        this.n = new c();
        IMImageThemeData$showImageMode$2 r8 = IMImageThemeData$showImageMode$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r8, "defaultProvider");
        KProperty<Object> r11 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r8, "value");
        r7.put(e.a(r11), r8);
        this.o = new c();
        IMImageThemeData$imageSizeCoordinator$2 r12 = IMImageThemeData$imageSizeCoordinator$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r12, "defaultProvider");
        KProperty<Object> r13 = r1[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r13, "property");
        Intrinsics.checkNotNullParameter(r13, "kProperty");
        Intrinsics.checkNotNullParameter(r12, "value");
        r7.put(e.a(r13), r12);
        this.p = new c();
        IMImageThemeData$imageBorderProvider$2 r14 = IMImageThemeData$imageBorderProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r14, "defaultProvider");
        KProperty<Object> r15 = r1[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r15, "property");
        Intrinsics.checkNotNullParameter(r15, "kProperty");
        Intrinsics.checkNotNullParameter(r14, "value");
        r7.put(e.a(r15), r14);
        this.q = new c();
    }
}
