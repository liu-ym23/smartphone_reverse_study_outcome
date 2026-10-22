package com.ss.android.lark.coremd.facade.bizext;

import com.ss.android.lark.coremd.base.parse.b;
import com.ss.android.lark.coremd.base.parse.n;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMContextExtend extends LarkContextExtend {
    public static final a A = null;
    public static final /* synthetic */ KProperty<Object>[] B = null;
    public final m u;
    public final c v;
    public final c w;
    public final c x;
    public final c y;
    public final c z;

    public static final class a implements h<IMContextExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super IMContextExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMContextExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(IMContextExtend.class);
        }
    }

    static {
        B = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "clickDelegate", "getClickDelegate(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremd/facade/click/IMNodeClickDelegate;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "messageContextData", "getMessageContextData(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremd/facade/bizext/context/MessageContextData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "forceRegexParsePhone", "getForceRegexParsePhone(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "anonymousUserId", "getAnonymousUserId(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "permissionContextData", "getPermissionContextData(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremd/facade/bizext/context/PermissionContextData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "applyStyleFromMe", "getApplyStyleFromMe(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0))};
        A = new a();
    }

    public IMContextExtend() {
        KProperty<Object>[] r0 = B;
        KProperty<Object> r1 = r0[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r1, "property");
        this.u = new m();
        IMContextExtend$messageContextData$2 r2 = IMContextExtend$messageContextData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r2, "defaultProvider");
        KProperty<Object> r5 = r0[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r2, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r8 = d.a;
        r8.put(e.a(r5), r2);
        this.v = new c();
        final Boolean r3 = Boolean.FALSE;
        Function1<j, Boolean> r7 = new IMContextExtend$special$$inlined$extend$1(r3);
        Intrinsics.checkNotNullParameter(r7, "defaultProvider");
        KProperty<Object> r9 = r0[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r9, "property");
        Intrinsics.checkNotNullParameter(r9, "kProperty");
        Intrinsics.checkNotNullParameter(r7, "value");
        r8.put(e.a(r9), r7);
        this.w = new c();
        final String r10 = BuildConfig.FLAVOR;
        Function1<j, String> r11 = new IMContextExtend$special$$inlined$extend$2(r10);
        Intrinsics.checkNotNullParameter(r11, "defaultProvider");
        KProperty<Object> r12 = r0[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r11, "value");
        r8.put(e.a(r12), r11);
        this.x = new c();
        IMContextExtend$permissionContextData$2 r13 = IMContextExtend$permissionContextData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r13, "defaultProvider");
        KProperty<Object> r14 = r0[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r14, "property");
        Intrinsics.checkNotNullParameter(r14, "kProperty");
        Intrinsics.checkNotNullParameter(r13, "value");
        r8.put(e.a(r14), r13);
        this.y = new c();
        Function1<j, Boolean> r15 = new IMContextExtend$special$$inlined$extend$3(r3);
        Intrinsics.checkNotNullParameter(r15, "defaultProvider");
        KProperty<Object> r4 = r0[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r15, "value");
        r8.put(e.a(r4), r15);
        this.z = new c();
    }

    public final boolean q(o r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return ((Boolean) this.z.getValue(r4, B[5])).booleanValue();
    }

    public final w9b.c r(n.a r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (w9b.c) this.u.getValue(r4, B[0]);
    }

    public final v9b.a s(b r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (v9b.a) this.v.getValue(r4, B[1]);
    }

    public final v9b.b t(b r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (v9b.b) this.y.getValue(r4, B[4]);
    }

    public final void u(b r4, v9b.b r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.y.setValue(r4, B[4], r5);
    }
}
