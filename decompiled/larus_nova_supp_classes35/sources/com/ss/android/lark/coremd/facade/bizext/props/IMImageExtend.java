package com.ss.android.lark.coremd.facade.bizext.props;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import v7b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMImageExtend extends LarkImageExtend {
    public static final a p = null;
    public static final /* synthetic */ KProperty<Object>[] q = null;
    public final c i;
    public final c j;
    public final c k;
    public final c l;
    public final m m;
    public final m n;
    public final c o;

    public static final class a implements h<IMImageExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super IMImageExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMImageExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(IMImageExtend.class);
        }
    }

    static {
        q = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "originKey", "getOriginKey(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "middleKey", "getMiddleKey(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "thumbKey", "getThumbKey(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "url", "getUrl(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "inlinePreview", "getInlinePreview(Lcom/ss/android/lark/commonmark/node/Image;)Lokio/ByteString;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "resourceCleanScene", "getResourceCleanScene(Lcom/ss/android/lark/commonmark/node/Image;)Lcom/ss/android/lark/image/entity/ResourceCleanScene;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "needCopy", "getNeedCopy(Lcom/ss/android/lark/commonmark/node/Image;)Z", 0))};
        p = new a();
    }

    public IMImageExtend() {
        final String r1 = BuildConfig.FLAVOR;
        Function1<j, String> r0 = new IMImageExtend$special$$inlined$extend$1(r1);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r3 = q;
        KProperty<Object> r4 = r3[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r9 = d.a;
        r9.put(e.a(r4), r0);
        this.i = new c();
        Function1<j, String> r2 = new IMImageExtend$special$$inlined$extend$2(r1);
        Intrinsics.checkNotNullParameter(r2, "defaultProvider");
        KProperty<Object> r5 = r3[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r2, "value");
        r9.put(e.a(r5), r2);
        this.j = new c();
        Function1<j, String> r6 = new IMImageExtend$special$$inlined$extend$3(r1);
        Intrinsics.checkNotNullParameter(r6, "defaultProvider");
        KProperty<Object> r8 = r3[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r8, "property");
        Intrinsics.checkNotNullParameter(r8, "kProperty");
        Intrinsics.checkNotNullParameter(r6, "value");
        r9.put(e.a(r8), r6);
        this.k = new c();
        Function1<j, String> r10 = new IMImageExtend$special$$inlined$extend$4(r1);
        Intrinsics.checkNotNullParameter(r10, "defaultProvider");
        KProperty<Object> r11 = r3[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r10, "value");
        r9.put(e.a(r11), r10);
        this.l = new c();
        KProperty<Object> r12 = r3[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        this.m = new m();
        KProperty<Object> r13 = r3[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r13, "property");
        this.n = new m();
        final Boolean r14 = Boolean.FALSE;
        Function1<j, Boolean> r15 = new IMImageExtend$special$$inlined$extend$5(r14);
        Intrinsics.checkNotNullParameter(r15, "defaultProvider");
        KProperty<Object> r16 = r3[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r16, "property");
        Intrinsics.checkNotNullParameter(r16, "kProperty");
        Intrinsics.checkNotNullParameter(r15, "value");
        r9.put(e.a(r16), r15);
        this.o = new c();
    }

    public static String j(l r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.j;
    }

    public final String g(l r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.j.getValue(r4, q[1]);
    }

    public final String h(l r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.i.getValue(r4, q[0]);
    }

    public final ResourceCleanScene i(l r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (ResourceCleanScene) this.n.getValue(r4, q[5]);
    }

    public final String k(l r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.l.getValue(r4, q[3]);
    }
}
