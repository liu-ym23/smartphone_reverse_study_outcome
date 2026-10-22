package com.larus.bmhome.chat.deepresearch.view;

import com.larus.im.bean.message.SearchImageInfo;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h2 implements Function1 {
    public final /* synthetic */ SearchImageInfo a;
    public final /* synthetic */ j2 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;

    public /* synthetic */ h2(SearchImageInfo r1, j2 r2, String r3, int r4, int r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r12) {
        final SearchImageInfo r2 = this.a;
        final j2 r1 = this.b;
        final String r3 = this.c;
        final int r4 = this.d;
        final int r5 = this.e;
        final int r6 = this.f;
        ii9.b r13 = (ii9.b) r12;
        Intrinsics.checkNotNullParameter(r13, "$this$expose");
        Function0 r0 = new q1(r2);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "cellId");
        r13.a = r0;
        r13.a(CollectionsKt.listOf(new Integer[]{0, 1, 2}));
        float[] r7 = {0.5f};
        Intrinsics.checkNotNullParameter(r7, "percentages");
        r13.c = r7;
        r13.e = true;
        Function1 r8 = new r1(r1, r2, r3, r4, r5, r6);
        Intrinsics.checkNotNullParameter(r8, "block");
        r13.b = r8;
        return Unit.INSTANCE;
    }
}
