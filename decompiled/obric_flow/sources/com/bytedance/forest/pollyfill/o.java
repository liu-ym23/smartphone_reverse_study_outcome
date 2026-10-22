package com.bytedance.forest.pollyfill;

import com.bytedance.forest.model.w;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTNetDepender$tryFetchFromCache$2 f4529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f4531c;

    public o(TTNetDepender$tryFetchFromCache$2 r5, Ref.ObjectRef r10, d r11) {
        this.f4529a = r5;
        this.f4530b = r10;
        this.f4531c = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.forest.model.q r5 = (com.bytedance.forest.model.q) this.f4530b.element;
        TTNetDepender$tryFetchFromCache$2 r10 = this.f4529a;
        if (r5 == null) goto L5;
        q r11 = r10.f4488a;
        w r12 = r10.f4489b;
        AtomicBoolean r13 = q.f4535b;
        r11.e(this.f4531c, r5, r12);
    L5:
        q.f4536c.remove(r10.f4490c.toString());
    }
}
