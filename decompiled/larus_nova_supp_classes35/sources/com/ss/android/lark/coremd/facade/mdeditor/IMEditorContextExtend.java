package com.ss.android.lark.coremd.facade.mdeditor;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMEditorContextExtend extends LarkContextExtend {
    public static final /* synthetic */ KProperty<Object>[] v = null;
    public final c u;

    public static final class a implements h<IMEditorContextExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMEditorContextExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(IMEditorContextExtend.class);
        }
    }

    static {
        v = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMEditorContextExtend.class, "chatIdProvider", "getChatIdProvider(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0))};
        new a();
    }

    public IMEditorContextExtend() {
        IMEditorContextExtend$chatIdProvider$2 r0 = IMEditorContextExtend$chatIdProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object> r1 = v[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r1, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r2 = d.a;
        Intrinsics.checkNotNullParameter(r1, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        d.a.put(e.a(r1), r0);
        this.u = new c();
    }
}
