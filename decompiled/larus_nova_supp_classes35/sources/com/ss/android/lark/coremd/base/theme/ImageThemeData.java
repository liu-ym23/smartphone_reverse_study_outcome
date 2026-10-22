package com.ss.android.lark.coremd.base.theme;

import com.ss.android.lark.coremd.base.parse.a;
import com.ss.android.lark.coremd.base.parse.a0;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ImageThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] f = null;
    public final c d;
    public final c e;

    static {
        f = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ImageThemeData.class, "showImage", "getShowImage()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ImageThemeData.class, "imageSizeProvider", "getImageSizeProvider()Lcom/ss/android/lark/coremd/base/parse/ImageSizeProvider;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ImageThemeData.class, "imagePlaceHolderRes", "getImagePlaceHolderRes()I", 0))};
    }

    public ImageThemeData(j r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        super(r10);
        final Boolean r11 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new ImageThemeData$special$$inlined$extend$1(r11);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = f;
        KProperty<Object> r3 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r3, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r8 = d.a;
        r8.put(e.a(r3), r0);
        this.d = new c();
        final a.C0177a r2 = a.a;
        Function1<j, a> r4 = new ImageThemeData$special$$inlined$extend$2(r2);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r5 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r8.put(e.a(r5), r4);
        this.e = new c();
        final int r7 = 0;
        Function1<j, Integer> r9 = new ImageThemeData$special$$inlined$extend$3(r7);
        Intrinsics.checkNotNullParameter(r9, "defaultProvider");
        KProperty<Object> r12 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.put(e.a(r12), r9);
    }
}
