package com.bytedance.lego.init;

import com.bytedance.lego.init.model.DelayTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 13})
public final class DelayTaskDispatcher$mainHandler$1$9 extends Lambda implements Function0<Unit> {
    public static final DelayTaskDispatcher$mainHandler$1$9 INSTANCE = null;

    static {
        INSTANCE = new DelayTaskDispatcher$mainHandler$1$9();
    }

    public DelayTaskDispatcher$mainHandler$1$9() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m6invoke() {
        Map r0 = DelayTaskDispatcher.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        DelayTaskDispatcher.a((PriorityQueue) r1.get(DelayTime.MINUTE_10));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m6invoke();
        return Unit.INSTANCE;
    }
}
