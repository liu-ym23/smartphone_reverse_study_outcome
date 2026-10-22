package com.bytedance.android.monitorV2.dataprocessor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.monitorV2.executor.d;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f3533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f3534c;

    public b() {
        this.f3532a = true;
        new Handler(Looper.getMainLooper());
        this.f3533b = new HashMap();
        this.f3534c = new HashMap();
    }

    public final void a() {
        Lazy r5 = d.f3576a;
        d.a(new TypedDataDispatcher$notifyAllEvents$1(this));
    }

    public final void b(TypedDataDispatcher$DataType r5, Object r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f3532a == false) goto L16;
        HashMap r11 = this.f3534c;
        List r12 = (List) r11.get(r5);
        if (r12 == null) goto L9;
        r12.add(r10);
    L10:
        List r13 = (List) r11.get(r5);
        if (r13 != null) goto L13;
        return;
    L13:
        if (r13.size() <= 1000) goto L23;
        Lazy r14 = d.f3576a;
        d.a(new TypedDataDispatcher$notifyAllEvents$1(this));
        d5.b.e("DataProcessorManager", r5 + " pending list is too large! current size has more than 1000");
        return;
    L23:
        return;
    L9:
        r11.put(r5, CollectionsKt.arrayListOf(new Object[]{r10}));
        goto L10
    L16:
        HashMap r15 = this.f3533b;
        if (r15.containsKey(r5) == false) goto L21;
        Object r16 = r15.get(r5);
        Intrinsics.checkNotNull(r16);
        ((a) r16).a(r10);
        return;
    L21:
        throw new UnsupportedOperationException("not found processor");
    }

    public final void c(final TypedDataDispatcher$DataType r5, final Object r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "dataType");
        if (r11 == false) goto L6;
        Lazy r12 = d.f3576a;
        d.a(new TypedDataDispatcher$enqueue$1(this, r5, r10));
        return;
    L6:
        b(r5, r10);
    }
}
