package com.ss.android.lark.coremd.nonimbiz.calendar;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CalendarContextExtend implements f {
    public static final /* synthetic */ KProperty<Object>[] d = null;
    public final c c;

    public static final class a implements h<CalendarContextExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (CalendarContextExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(CalendarContextExtend.class);
        }
    }

    static {
        d = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(CalendarContextExtend.class, "isFoldMessage", "isFoldMessage(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0))};
        new a();
    }

    public CalendarContextExtend() {
        final Boolean r0 = Boolean.FALSE;
        Function1<j, Boolean> r1 = new CalendarContextExtend$special$$inlined$extend$1(r0);
        Intrinsics.checkNotNullParameter(r1, "defaultProvider");
        KProperty<Object> r2 = d[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r3 = d.a;
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r1, "value");
        d.a.put(e.a(r2), r1);
        this.c = new c();
    }
}
