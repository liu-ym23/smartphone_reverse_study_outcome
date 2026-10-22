package com.ss.android.lark.coremd.facade.mdeditor.theme;

import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMEditorAtThemeData extends LarkAtThemeData {
    public static final /* synthetic */ KProperty<Object>[] n = null;
    public final c l;
    public final c m;

    static {
        n = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMEditorAtThemeData.class, "parseAtChatter", "getParseAtChatter()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMEditorAtThemeData.class, "showAtAll", "getShowAtAll()Z", 0))};
    }

    public IMEditorAtThemeData(j r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super(r9);
        final Boolean r10 = Boolean.FALSE;
        Function1<j, Boolean> r0 = new IMEditorAtThemeData$special$$inlined$extend$1(r10);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = n;
        KProperty<Object> r2 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = d.a;
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        r7.put(e.a(r2), r0);
        this.l = new c();
        final Boolean r3 = Boolean.TRUE;
        Function1<j, Boolean> r4 = new IMEditorAtThemeData$special$$inlined$extend$2(r3);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r11 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(e.a(r11), r4);
        this.m = new c();
    }
}
