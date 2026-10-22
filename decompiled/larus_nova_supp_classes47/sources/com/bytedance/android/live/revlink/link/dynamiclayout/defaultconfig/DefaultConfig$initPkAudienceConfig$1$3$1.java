package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import t51.e;
import z41.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "offset", "", "forWithAudience", "", "Lt51/e;", "invoke", "(IZ)Ljava/util/List;", "getAnchorRegion"}, k = 3, mv = {1, 5, 1})
final class DefaultConfig$initPkAudienceConfig$1$3$1 extends Lambda implements Function2<Integer, Boolean, List<? extends e>> {
    public static final DefaultConfig$initPkAudienceConfig$1$3$1 INSTANCE = null;

    static {
        INSTANCE = new DefaultConfig$initPkAudienceConfig$1$3$1();
    }

    public DefaultConfig$initPkAudienceConfig$1$3$1() {
        super(2);
    }

    public final List<e> invoke(int r6, boolean r7) {
        if (g.o.b() == false) goto L6;
        if (r7 == false) goto L6;
        float r8 = 8.5f;
    L7:
        e r1 = new e();
        r1.m(0.0f);
        r1.n(0.19f);
        r1.l(0.5f);
        float r9 = r8 / 32.0f;
        r1.h(r9);
        r1.i(r6 + 0);
        r1.s();
        Unit r4 = Unit.INSTANCE;
        e r2 = new e();
        r2.m(0.5f);
        r2.n(0.19f);
        r2.l(0.5f);
        r2.h(r9);
        r2.i(r6 + 1);
        r2.s();
        return CollectionsKt.listOf(new e[]{r1, r2});
    L6:
        r8 = 13.0f;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), ((Boolean) r2).booleanValue());
    }
}
