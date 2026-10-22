package com.ss.android.lark.coremdbiz.facade.bizext.props;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LarkLinkExtend implements f {
    public static final a f = null;
    public static final /* synthetic */ KProperty<Object>[] g = null;
    public final c c;
    public final c d;
    public final m e;

    public static final class a implements h<LarkLinkExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super LarkLinkExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkLinkExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(LarkLinkExtend.class);
        }
    }

    static {
        g = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkLinkExtend.class, "linkType", "getLinkType(Lcom/ss/android/lark/commonmark/node/Link;)Lcom/ss/android/lark/coremdbiz/facade/link/LinkType;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkLinkExtend.class, "previewId", "getPreviewId(Lcom/ss/android/lark/commonmark/node/Link;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkLinkExtend.class, "iconInfo", "getIconInfo(Lcom/ss/android/lark/commonmark/node/Link;)Lcom/ss/android/lark/coremdbiz/facade/link/icon/ILinkIconInfo;", 0))};
        f = new a();
    }

    public LarkLinkExtend() {
        final LinkType r0 = LinkType.UrlInline;
        Function1<j, LinkType> r1 = new LarkLinkExtend$special$$inlined$extend$1(r0);
        Intrinsics.checkNotNullParameter(r1, "defaultProvider");
        KProperty<Object>[] r2 = g;
        KProperty<Object> r3 = r2[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r3, "kProperty");
        Intrinsics.checkNotNullParameter(r1, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r8 = d.a;
        r8.put(e.a(r3), r1);
        this.c = new c();
        final String r4 = BuildConfig.FLAVOR;
        Function1<j, String> r5 = new LarkLinkExtend$special$$inlined$extend$2(r4);
        Intrinsics.checkNotNullParameter(r5, "defaultProvider");
        KProperty<Object> r7 = r2[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r7, "property");
        Intrinsics.checkNotNullParameter(r7, "kProperty");
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.put(e.a(r7), r5);
        this.d = new c();
        KProperty<Object> r9 = r2[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r9, "property");
        this.e = new m();
    }

    public final dab.a a(n r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (dab.a) this.e.getValue(r4, g[2]);
    }

    public final LinkType b(n r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LinkType) this.c.getValue(r4, g[0]);
    }

    public final String d(n r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (String) this.d.getValue(r4, g[1]);
    }

    public final void f(n r4, LinkType r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.c.setValue(r4, g[0], r5);
    }
}
