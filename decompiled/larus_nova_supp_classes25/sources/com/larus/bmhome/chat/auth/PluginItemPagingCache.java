package com.larus.bmhome.chat.auth;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.auth.model.PluginItemData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PluginItemPagingCache {
    public static final /* synthetic */ int g = 0;
    public final String a;
    public final Function5<String, Integer, Integer, DowngradeSource, Continuation<? super PluginItemData>, Object> b;
    public int c;
    public final CopyOnWriteArrayList<PluginItem> d;
    public int e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PluginItemPagingCache(String r2, Function5<? super String, ? super Integer, ? super Integer, ? super DowngradeSource, ? super Continuation<? super PluginItemData>, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "requestPluginList");
        this.a = r2;
        this.b = r3;
        this.d = new CopyOnWriteArrayList();
    }

    public final Object b(DowngradeSource r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof PluginItemPagingCache$updateFirstPage$1) == false) goto L7;
        PluginItemPagingCache$updateFirstPage$1 r0 = (PluginItemPagingCache$updateFirstPage$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        PluginItemPagingCache$updateFirstPage$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L17:
        PluginItemData r12 = (PluginItemData) r11;
        if (r12 == null) goto L22;
        Integer r13 = r12.total;
        if (r13 == null) goto L22;
        this.c = r13.intValue();
    L22:
        if (r12 == null) goto L48;
        List<PluginItem> r14 = r12.items;
        if (r14 == null) goto L48;
        Iterator<T> r15 = r14.iterator();
    L27:
        if (r15.hasNext() == false) goto L48;
        PluginItem r16 = (PluginItem) r15.next();
        if (r16 == null) goto L27;
        Iterator<T> r4 = this.d.iterator();
    L32:
        if (r4.hasNext() == false) goto L36;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((PluginItem) r5).pluginId, r16.pluginId) == false) goto L32;
    L37:
        PluginItem r7 = (PluginItem) r5;
        if (r7 != null) goto L39;
        Boxing.boxBoolean(this.d.add(r16));
        goto L27
    L39:
        int r8 = this.d.indexOf(r7);
        boolean r17 = false;
        if (r8 >= 0) goto L42;
    L44:
        if (r17 == false) goto L27;
        this.d.set(r8, r16);
        goto L27
    L42:
        if (r8 >= this.d.size()) goto L44;
        r17 = true;
        goto L44
    L36:
        r5 = null;
    L48:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Function5<String, Integer, Integer, DowngradeSource, Continuation<? super PluginItemData>, Object> r18 = this.b;
        String r19 = this.a;
        Integer r20 = Boxing.boxInt(1);
        Integer r21 = Boxing.boxInt(20);
        r6.label = 1;
        r11 = r18.invoke(r19, r20, r21, r9, r6);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new PluginItemPagingCache$updateFirstPage$1(this, r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(boolean r10, DowngradeSource r11, Continuation<? super List<PluginItem>> r12) {
        if ((r12 instanceof PluginItemPagingCache$requestNextPage$1) == false) goto L7;
        PluginItemPagingCache$requestNextPage$1 r0 = (PluginItemPagingCache$requestNextPage$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        PluginItemPagingCache$requestNextPage$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L39:
        PluginItemData r14 = (PluginItemData) r13;
        if (r14 == null) goto L44;
        Integer r15 = r14.total;
        if (r15 == null) goto L44;
        this.c = r15.intValue();
    L44:
        if (r14 == null) goto L53;
        List<PluginItem> r16 = r14.items;
        if (r16 == null) goto L53;
        Iterator<T> r17 = r16.iterator();
    L49:
        if (r17.hasNext() == false) goto L53;
        PluginItem r18 = (PluginItem) r17.next();
        if (r18 == null) goto L49;
        this.d.add(r18);
    L53:
        CopyOnWriteArrayList<PluginItem> r19 = this.d;
        ArrayList r110 = new ArrayList();
        Iterator<PluginItem> r111 = r19.iterator();
    L55:
        if (r111.hasNext() == false) goto L62;
        PluginItem r112 = r111.next();
        if (r112 == null) goto L59;
        boolean r4 = true;
    L60:
        if (r4 == false) goto L55;
        r110.add(r112);
        goto L55
    L59:
        r4 = false;
        goto L60
    L62:
        HashSet r113 = new HashSet();
        ArrayList r114 = new ArrayList();
        Iterator r115 = r110.iterator();
    L64:
        if (r115.hasNext() == false) goto L69;
        Object r5 = r115.next();
        if (r113.add(((PluginItem) r5).pluginId) == false) goto L64;
        r114.add(r5);
        goto L64
    L69:
        if (r114.size() >= this.d.size()) goto L71;
        this.d.clear();
        this.d.addAll(r114);
    L71:
        this.f = false;
        return r114;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r116 = r6.Z$0;
        r11 = (DowngradeSource) r6.L$0;
        ResultKt.throwOnFailure(r13);
        int r117 = r116;
    L25:
        DowngradeSource r7 = r11;
        if ((!this.d.isEmpty()) == false) goto L34;
        if (this.d.size() != this.c) goto L34;
        if (RangesKt.coerceAtLeast(this.e, r117) <= 0) goto L34;
        this.f = false;
        return this.d;
    L34:
        if (this.d.isEmpty() == false) goto L36;
        this.e = 0;
    L36:
        int r118 = this.e + 1;
        this.e = r118;
        Function5<String, Integer, Integer, DowngradeSource, Continuation<? super PluginItemData>, Object> r8 = this.b;
        String r119 = this.a;
        Integer r9 = Boxing.boxInt(r118);
        Integer r20 = Boxing.boxInt(20);
        r6.L$0 = null;
        r6.label = 2;
        r13 = r8.invoke(r119, r9, r20, r7, r6);
        if (r13 != r2) goto L39;
        return r2;
    L16:
        ResultKt.throwOnFailure(r13);
        if (this.f == true) goto L19;
        this.f = true;
        r117 = r10;
        if (r10 == false) goto L25;
        r6.L$0 = r11;
        r6.Z$0 = r10;
        r6.label = 1;
        r117 = r10;
        if (b(r11, r6) != r2) goto L25;
        return r2;
    L19:
        return this.d;
    L7:
        r0 = new PluginItemPagingCache$requestNextPage$1(this, r12);
        goto L8
    }
}
