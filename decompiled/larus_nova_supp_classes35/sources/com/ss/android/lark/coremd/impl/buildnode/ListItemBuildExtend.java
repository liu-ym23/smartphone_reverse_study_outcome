package com.ss.android.lark.coremd.impl.buildnode;

import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ListItemBuildExtend implements f {
    public static final a g = null;
    public static final /* synthetic */ KProperty<Object>[] h = null;
    public final m c;
    public final com.ss.android.lark.coremd.ext.c d;
    public final com.ss.android.lark.coremd.ext.c e;
    public final com.ss.android.lark.coremd.ext.c f;

    public static final class a implements h<ListItemBuildExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (ListItemBuildExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(ListItemBuildExtend.class);
        }
    }

    static {
        h = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(ListItemBuildExtend.class, "listContainer", "getListContainer(Lcom/ss/android/lark/commonmark/node/ListItem;)Lcom/ss/android/lark/commonmark/node/Node;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(ListItemBuildExtend.class, "floor", "getFloor(Lcom/ss/android/lark/commonmark/node/ListItem;)I", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(ListItemBuildExtend.class, IPortraitService.TYPE, "getType(Lcom/ss/android/lark/commonmark/node/BulletList;)Lcom/ss/android/lark/coremd/span/CommonPrefixSpan$Type;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(ListItemBuildExtend.class, "floor", "getFloor(Lcom/ss/android/lark/commonmark/node/OrderedList;)I", 0))};
        g = new a();
    }

    public ListItemBuildExtend() {
        KProperty<Object>[] r0 = h;
        final int r2 = 0;
        KProperty<Object> r1 = r0[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r1, "property");
        this.c = new m();
        Function1<j, Integer> r3 = new ListItemBuildExtend$special$$inlined$extend$1(r2);
        Intrinsics.checkNotNullParameter(r3, "defaultProvider");
        KProperty<Object> r6 = r0[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = com.ss.android.lark.coremd.ext.d.a;
        Intrinsics.checkNotNullParameter(r6, "kProperty");
        Intrinsics.checkNotNullParameter(r3, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r9 = com.ss.android.lark.coremd.ext.d.a;
        r9.put(e.a(r6), r3);
        this.d = new com.ss.android.lark.coremd.ext.c();
        final CommonPrefixSpan.Type r4 = CommonPrefixSpan.Type.FILL_CIRCLE;
        Function1<j, CommonPrefixSpan.Type> r8 = new ListItemBuildExtend$special$$inlined$extend$2(r4);
        Intrinsics.checkNotNullParameter(r8, "defaultProvider");
        KProperty<Object> r5 = r0[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r8, "value");
        r9.put(e.a(r5), r8);
        this.e = new com.ss.android.lark.coremd.ext.c();
        Function1<j, Integer> r10 = new ListItemBuildExtend$special$$inlined$extend$3(r2);
        Intrinsics.checkNotNullParameter(r10, "defaultProvider");
        KProperty<Object> r11 = r0[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r10, "value");
        r9.put(e.a(r11), r10);
        this.f = new com.ss.android.lark.coremd.ext.c();
    }

    public final CommonPrefixSpan.Type getType(v7b.c r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (CommonPrefixSpan.Type) this.e.getValue(r4, h[2]);
    }
}
