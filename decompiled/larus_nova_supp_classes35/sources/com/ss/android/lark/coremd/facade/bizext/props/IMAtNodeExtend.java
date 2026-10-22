package com.ss.android.lark.coremd.facade.bizext.props;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMAtNodeExtend implements f {
    public static final a i = null;
    public static final /* synthetic */ KProperty<Object>[] j = null;
    public final c c;
    public final c d;
    public final c e;
    public final c f;
    public final c g;
    public final c h;

    public static final class a implements h<IMAtNodeExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super IMAtNodeExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMAtNodeExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(IMAtNodeExtend.class);
        }
    }

    static {
        j = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "chatId", "getChatId(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "isOutChatUser", "isOutChatUser(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "isHighLight", "isHighLight(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "isAnonymous", "isAnonymous(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "isAtAll", "isAtAll(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "originName", "getOriginName(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Ljava/lang/String;", 0))};
        i = new a();
    }

    public IMAtNodeExtend() {
        final String r1 = BuildConfig.FLAVOR;
        Function1<j, String> r0 = new IMAtNodeExtend$special$$inlined$extend$1(r1);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r3 = j;
        KProperty<Object> r4 = r3[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r9 = d.a;
        r9.put(e.a(r4), r0);
        this.c = new c();
        final Boolean r2 = Boolean.FALSE;
        Function1<j, Boolean> r5 = new IMAtNodeExtend$special$$inlined$extend$2(r2);
        Intrinsics.checkNotNullParameter(r5, "defaultProvider");
        KProperty<Object> r10 = r3[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r10, "property");
        Intrinsics.checkNotNullParameter(r10, "kProperty");
        Intrinsics.checkNotNullParameter(r5, "value");
        r9.put(e.a(r10), r5);
        this.d = new c();
        Function1<j, Boolean> r6 = new IMAtNodeExtend$special$$inlined$extend$3(r2);
        Intrinsics.checkNotNullParameter(r6, "defaultProvider");
        KProperty<Object> r11 = r3[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r6, "value");
        r9.put(e.a(r11), r6);
        this.e = new c();
        Function1<j, Boolean> r8 = new IMAtNodeExtend$special$$inlined$extend$4(r2);
        Intrinsics.checkNotNullParameter(r8, "defaultProvider");
        KProperty<Object> r12 = r3[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r8, "value");
        r9.put(e.a(r12), r8);
        this.f = new c();
        Function1<j, Boolean> r13 = new IMAtNodeExtend$special$$inlined$extend$5(r2);
        Intrinsics.checkNotNullParameter(r13, "defaultProvider");
        KProperty<Object> r14 = r3[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r14, "property");
        Intrinsics.checkNotNullParameter(r14, "kProperty");
        Intrinsics.checkNotNullParameter(r13, "value");
        r9.put(e.a(r14), r13);
        this.g = new c();
        Function1<j, String> r15 = new IMAtNodeExtend$special$$inlined$extend$6(r1);
        Intrinsics.checkNotNullParameter(r15, "defaultProvider");
        KProperty<Object> r16 = r3[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r16, "property");
        Intrinsics.checkNotNullParameter(r16, "kProperty");
        Intrinsics.checkNotNullParameter(r15, "value");
        r9.put(e.a(r16), r15);
        this.h = new c();
    }

    public final boolean a(eab.a r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return ((Boolean) this.f.getValue(r4, j[3])).booleanValue();
    }

    public final boolean b(eab.a r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return ((Boolean) this.d.getValue(r4, j[1])).booleanValue();
    }

    public final void d(eab.a r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.f.setValue(r4, j[3], Boolean.valueOf(r5));
    }

    public final void f(eab.a r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.d.setValue(r4, j[1], Boolean.valueOf(r5));
    }
}
