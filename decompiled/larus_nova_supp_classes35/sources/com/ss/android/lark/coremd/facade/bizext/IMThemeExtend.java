package com.ss.android.lark.coremd.facade.bizext;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.facade.bizext.theme.IMAtThemeData;
import com.ss.android.lark.coremd.facade.bizext.theme.IMImageThemeData;
import com.ss.android.lark.coremd.facade.bizext.theme.IMMediaThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkImageThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkMediaThemeData;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMThemeExtend extends LarkThemeExtend {
    public static final a s = null;
    public static final /* synthetic */ KProperty<Object>[] t = null;
    public final c o;
    public final c p;
    public final c q;
    public final c r;

    public static final class a implements h<IMThemeExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super IMThemeExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMThemeExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(IMThemeExtend.class);
        }
    }

    static {
        t = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMThemeExtend.class, "atThemeData", "getAtThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/facade/bizext/theme/IMAtThemeData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMThemeExtend.class, "imageThemeData", "getImageThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/facade/bizext/theme/IMImageThemeData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMThemeExtend.class, "mediaThemeData", "getMediaThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/facade/bizext/theme/IMMediaThemeData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMThemeExtend.class, "showEditMessageTag", "getShowEditMessageTag(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Z", 0))};
        s = new a();
    }

    public IMThemeExtend() {
        IMThemeExtend$atThemeData$2 r0 = IMThemeExtend$atThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r2 = t;
        KProperty<Object> r3 = r2[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r3, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r8 = d.a;
        r8.put(e.a(r3), r0);
        this.o = new c();
        IMThemeExtend$imageThemeData$2 r1 = IMThemeExtend$imageThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "defaultProvider");
        KProperty<Object> r4 = r2[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r1, "value");
        r8.put(e.a(r4), r1);
        this.p = new c();
        IMThemeExtend$mediaThemeData$2 r5 = IMThemeExtend$mediaThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "defaultProvider");
        KProperty<Object> r7 = r2[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r7, "property");
        Intrinsics.checkNotNullParameter(r7, "kProperty");
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.put(e.a(r7), r5);
        this.q = new c();
        final Boolean r9 = Boolean.TRUE;
        Function1<j, Boolean> r10 = new IMThemeExtend$special$$inlined$extend$1(r9);
        Intrinsics.checkNotNullParameter(r10, "defaultProvider");
        KProperty<Object> r11 = r2[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r10, "value");
        r8.put(e.a(r11), r10);
        this.r = new c();
    }

    @Override // com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend
    public final /* bridge */ /* synthetic */ LarkAtThemeData b(com.ss.android.lark.coremd.base.parse.j r1) {
        return m(r1);
    }

    @Override // com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend
    public final /* bridge */ /* synthetic */ LarkImageThemeData h(com.ss.android.lark.coremd.base.parse.j r1) {
        return n(r1);
    }

    @Override // com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend
    public final /* bridge */ /* synthetic */ LarkMediaThemeData j(com.ss.android.lark.coremd.base.parse.j r1) {
        return o(r1);
    }

    public final IMAtThemeData m(com.ss.android.lark.coremd.base.parse.j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (IMAtThemeData) this.o.getValue(r4, t[0]);
    }

    public final IMImageThemeData n(com.ss.android.lark.coremd.base.parse.j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (IMImageThemeData) this.p.getValue(r4, t[1]);
    }

    public final IMMediaThemeData o(com.ss.android.lark.coremd.base.parse.j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (IMMediaThemeData) this.q.getValue(r4, t[2]);
    }

    public final boolean p(com.ss.android.lark.coremd.base.parse.j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return ((Boolean) this.r.getValue(r4, t[3])).booleanValue();
    }
}
