package com.ss.android.lark.keyboard.biz.plus;

import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MorePlugin implements com.ss.android.lark.biz.im.api.extension.chat_window.d<m>, a {
    public final boolean a;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b b;
    public PlusKBPlugin c;

    public final String getName() {
        return "plus";
    }

    public final void isEnable() {
    }

    public final m c() {
        if (this.c != null) goto L6;
        PlusKBPlugin r0 = new PlusKBPlugin(this.a, this.b);
        Function0<Unit> r1 = new MorePlugin$getPlugin$1$1(this);
        Intrinsics.checkNotNullParameter(r1, "listener");
        r0.k = r1;
        this.c = r0;
    L6:
        return this.c;
    }

    public final /* bridge */ /* synthetic */ Object getPlugin() {
        return c();
    }

    public MorePlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.a = false;
        this.b = r2;
    }

    @Override // com.ss.android.lark.keyboard.biz.plus.a
    public final void a(Collection<Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "interceptors");
        m r1 = c();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.keyboard.biz.plus.PlusKBPlugin");
        PlusKBPlugin r2 = (PlusKBPlugin) r1;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "interceptors");
        r2.o.addAll(r4);
    }

    @Override // com.ss.android.lark.keyboard.biz.plus.a
    public final void b(List<? extends d5b.a> r3) {
        Intrinsics.checkNotNullParameter(r3, LocationHitPoint$ResultType.LIST);
        m r0 = c();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.keyboard.biz.plus.PlusKBPlugin");
        PlusKBPlugin r1 = (PlusKBPlugin) r0;
        List r4 = CollectionsKt.filterNotNull(r3);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "plusItemList");
        ArrayList r2 = new ArrayList();
        CollectionsKt.filterNotNullTo(r4, r2);
        r1.j.addAll(r2);
        Iterator r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((d5b.a) r5.next()).d(r1);
        goto L4
    }
}
