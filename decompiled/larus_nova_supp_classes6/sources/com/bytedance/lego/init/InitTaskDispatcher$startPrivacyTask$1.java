package com.bytedance.lego.init;

import bf6.f;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 13})
final class InitTaskDispatcher$startPrivacyTask$1 extends Lambda implements Function0<Unit> {
    public static final InitTaskDispatcher$startPrivacyTask$1 INSTANCE = null;

    static {
        INSTANCE = new InitTaskDispatcher$startPrivacyTask$1();
    }

    public InitTaskDispatcher$startPrivacyTask$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m7invoke() {
        Iterator r0 = InitTaskDispatcher.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        m r1 = (m) r0.next();
        if (r1.p().d == true) goto L7;
        InitTaskDispatcher r2 = InitTaskDispatcher.o;
        f r3 = r1.p();
        r2.getClass();
        InitTaskDispatcher.d(r3);
        goto L4
    L7:
        CountDownLatch r4 = new CountDownLatch(1);
        InitTaskDispatcher.n.post(new a(r1, r4));
        r4.await();
        goto L4
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m7invoke();
        return Unit.INSTANCE;
    }
}
