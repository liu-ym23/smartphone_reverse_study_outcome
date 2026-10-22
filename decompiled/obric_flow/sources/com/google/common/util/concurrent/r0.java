package com.google.common.util.concurrent;

import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends ClassValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9432a;

    public /* synthetic */ r0(int r5) {
        this.f9432a = r5;
    }

    @Override // java.lang.ClassValue
    public final Object computeValue(Class r5) {
        switch(this.f9432a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "type");
        kotlinx.serialization.internal.r0 r10 = new kotlinx.serialization.internal.r0();
        r10.f19338a = new SoftReference(null);
        return r10;
    L6:
        s0.a(r5.asSubclass(Exception.class));
        return Boolean.TRUE;
    }
}
