package com.ss.ugc.effectplatform.repository;

import bytekn.foundation.logger.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "isSuccess", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class EffectRepository$cleanResourcesByServerStrategyWithAllowList$2 extends Lambda implements Function3<Boolean, Integer, String, Unit> {
    final /* synthetic */ com.ss.ugc.effectplatform.cache.l $cacheManager;
    final /* synthetic */ Function3 $onFinish;

    public EffectRepository$cleanResourcesByServerStrategyWithAllowList$2(com.ss.ugc.effectplatform.cache.l r1, Function3 r2) {
        this.$cacheManager = r1;
        this.$onFinish = r2;
        super(3);
    }

    public final void invoke(boolean r9, int r10, String r11) {
        if (this.$cacheManager == null) goto L11;
        Pair r0 = com.ss.ugc.effectplatform.cache.l.a();
        Logger.INSTANCE.d("JKL", "[cleanResourcesByServerStrategyWithAllowList][数据库][清理后]: 总数量:" + ((Number) r0.getFirst()).intValue() + " 总大小:" + ((Number) r0.getSecond()).longValue());
        Iterator r1 = CollectionsKt.emptyList().iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Logger.INSTANCE.d("JKL", "[cleanResourcesByServerStrategyWithAllowList][数据库][清理后][第" + r2 + "条]:" + ((com.ss.ugc.effectplatform.cache.k) r3));
        r2 = r4;
    L11:
        Function3 r5 = this.$onFinish;
        if (r5 == null) goto L18;
        Unit r12 = (Unit) r5.invoke(Boolean.valueOf(r9), Integer.valueOf(r10), r11);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Boolean) r1).booleanValue(), ((Number) r2).intValue(), (String) r3);
        return Unit.INSTANCE;
    }
}
