package com.ss.android.lark.coremdbiz.facade.bizext.props;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import v7b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LarkCodeBlockExtend implements f {
    public static final a f = null;
    public static final /* synthetic */ KProperty<Object>[] g = null;
    public final m c;
    public final c d;
    public final c e;

    public static final class a implements h<LarkCodeBlockExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super LarkCodeBlockExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkCodeBlockExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(LarkCodeBlockExtend.class);
        }
    }

    static {
        g = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkCodeBlockExtend.class, "lineContents", "getLineContents(Lcom/ss/android/lark/commonmark/node/FencedCodeBlock;)Ljava/util/List;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkCodeBlockExtend.class, "wordWrap", "getWordWrap(Lcom/ss/android/lark/commonmark/node/FencedCodeBlock;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkCodeBlockExtend.class, "language", "getLanguage(Lcom/ss/android/lark/commonmark/node/FencedCodeBlock;)I", 0))};
        f = new a();
    }

    public LarkCodeBlockExtend() {
        KProperty<Object>[] r0 = g;
        KProperty<Object> r2 = r0[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        this.c = new m();
        final Boolean r3 = Boolean.FALSE;
        Function1<j, Boolean> r5 = new LarkCodeBlockExtend$special$$inlined$extend$1(r3);
        Intrinsics.checkNotNullParameter(r5, "defaultProvider");
        KProperty<Object> r6 = r0[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        Intrinsics.checkNotNullParameter(r6, "kProperty");
        Intrinsics.checkNotNullParameter(r5, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r9 = d.a;
        r9.put(e.a(r6), r5);
        this.d = new c();
        final int r1 = 0;
        Function1<j, Integer> r8 = new LarkCodeBlockExtend$special$$inlined$extend$2(r1);
        Intrinsics.checkNotNullParameter(r8, "defaultProvider");
        KProperty<Object> r4 = r0[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r8, "value");
        r9.put(e.a(r4), r8);
        this.e = new c();
    }

    public final List<LineContent> a(g r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (List) this.c.getValue(r4, g[0]);
    }
}
