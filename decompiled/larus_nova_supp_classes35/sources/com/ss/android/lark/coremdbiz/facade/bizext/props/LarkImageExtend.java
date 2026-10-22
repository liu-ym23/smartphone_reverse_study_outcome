package com.ss.android.lark.coremdbiz.facade.bizext.props;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okio.ByteString;
import v7b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkImageExtend implements f {
    public static final a g = null;
    public static final /* synthetic */ KProperty<Object>[] h = null;
    public final c c;
    public final c d;
    public final m e;
    public final m f;

    public static final class a implements h<LarkImageExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super LarkImageExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkImageExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(LarkImageExtend.class);
        }
    }

    static {
        h = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkImageExtend.class, "width", "getWidth(Lcom/ss/android/lark/commonmark/node/Image;)I", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkImageExtend.class, "height", "getHeight(Lcom/ss/android/lark/commonmark/node/Image;)I", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkImageExtend.class, "fsUnit", "getFsUnit(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkImageExtend.class, "crypto", "getCrypto(Lcom/ss/android/lark/commonmark/node/Image;)Lokio/ByteString;", 0))};
        g = new a();
    }

    public LarkImageExtend() {
        final int r1 = 0;
        Function1<j, Integer> r2 = new LarkImageExtend$special$$inlined$extend$1(r1);
        Intrinsics.checkNotNullParameter(r2, "defaultProvider");
        KProperty<Object>[] r4 = h;
        KProperty<Object> r0 = r4[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r0, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        Intrinsics.checkNotNullParameter(r0, "kProperty");
        Intrinsics.checkNotNullParameter(r2, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r9 = d.a;
        r9.put(e.a(r0), r2);
        this.c = new c();
        Function1<j, Integer> r3 = new LarkImageExtend$special$$inlined$extend$2(r1);
        Intrinsics.checkNotNullParameter(r3, "defaultProvider");
        KProperty<Object> r5 = r4[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r3, "value");
        r9.put(e.a(r5), r3);
        this.d = new c();
        KProperty<Object> r6 = r4[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        this.e = new m();
        KProperty<Object> r8 = r4[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r8, "property");
        this.f = new m();
    }

    public final ByteString a(l r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (ByteString) this.f.getValue(r4, h[3]);
    }

    public final String b(l r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.e.getValue(r4, h[2]);
    }

    public final int d(l r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return ((Number) this.d.getValue(r4, h[1])).intValue();
    }

    public final int f(l r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return ((Number) this.c.getValue(r4, h[0])).intValue();
    }
}
