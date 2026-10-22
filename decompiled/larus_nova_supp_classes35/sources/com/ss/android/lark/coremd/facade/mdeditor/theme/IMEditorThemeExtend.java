package com.ss.android.lark.coremd.facade.mdeditor.theme;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMEditorThemeExtend extends LarkThemeExtend {
    public static final a p = null;
    public static final /* synthetic */ KProperty<Object>[] q = null;
    public final c o;

    public static final class a implements h<IMEditorThemeExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMEditorThemeExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(IMEditorThemeExtend.class);
        }
    }

    static {
        q = new KProperty[]{Reflection.property2(new PropertyReference2Impl(IMEditorThemeExtend.class, "atThemeData", "getAtThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/facade/mdeditor/theme/IMEditorAtThemeData;", 0))};
        p = new a();
    }

    public IMEditorThemeExtend() {
        IMEditorThemeExtend$atThemeData$2 r0 = IMEditorThemeExtend$atThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object> r1 = q[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r1, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r2 = d.a;
        Intrinsics.checkNotNullParameter(r1, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        d.a.put(e.a(r1), r0);
        this.o = new c();
    }

    @Override // com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend
    public final /* bridge */ /* synthetic */ LarkAtThemeData b(com.ss.android.lark.coremd.base.parse.j r1) {
        return m(r1);
    }

    public final IMEditorAtThemeData m(com.ss.android.lark.coremd.base.parse.j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (IMEditorAtThemeData) this.o.getValue(r4, q[0]);
    }
}
