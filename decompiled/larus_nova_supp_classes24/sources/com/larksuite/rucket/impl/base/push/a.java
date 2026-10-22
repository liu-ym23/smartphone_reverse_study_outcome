package com.larksuite.rucket.impl.base.push;

import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.RucketJobImpl;
import com.squareup.wire.Message;
import com.ss.android.lark.sdk.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a<T extends Message<?, ?>> extends RucketJobImpl<T> implements g.b {
    public final Class<T> a;
    public final CopyOnWriteArrayList<RucketJob<T>> b;
    public final AtomicBoolean c;

    /* JADX INFO: renamed from: com.larksuite.rucket.impl.base.push.a$a, reason: collision with other inner class name */
    public static final class C0058a {
    }

    static {
    }

    public abstract void b();

    public abstract void c();

    @Override // com.larksuite.rucket.job.RucketJobImpl, com.larksuite.rucket.job.RucketJob
    public final void cancel() {
        CopyOnWriteArrayList<RucketJob<T>> r0 = this.b;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((true ^ ((RucketJob) r3).isCanceled()) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        this.b.clear();
        if ((!r1.isEmpty()) == false) goto L12;
        this.b.addAll(r1);
        return;
    L12:
        if (this.c.compareAndSet(true, false) == false) goto L21;
        c();
        return;
    }

    public a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "responseClazz");
        this.a = r2;
        this.b = new CopyOnWriteArrayList();
        this.c = new AtomicBoolean(false);
    }

    public final void a(byte[] r7) {
        BuildersKt.launch$default(this, null, null, new BasePushRucketJob$onPush$1(this, r7, null), 3, null);
    }
}
