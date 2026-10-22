package com.ss.android.ugc.bytex.pthread.base.convergence.helper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0012\u001a\u00020\u000fR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/helper/ThreadCleaner;", "", "()V", "sThreadExitMethod", "Ljava/lang/reflect/Method;", "getSThreadExitMethod", "()Ljava/lang/reflect/Method;", "sThreadExitMethod$delegate", "Lkotlin/Lazy;", "sThreadLocalsField", "Ljava/lang/reflect/Field;", "getSThreadLocalsField", "()Ljava/lang/reflect/Field;", "sThreadLocalsField$delegate", "clearThread", "", "thread", "Ljava/lang/Thread;", "clearTls", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ThreadCleaner {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final ThreadCleaner INSTANCE = null;
    private static final Lazy sThreadExitMethod$delegate = null;
    private static final Lazy sThreadLocalsField$delegate = null;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ThreadCleaner.class), "sThreadLocalsField", "getSThreadLocalsField()Ljava/lang/reflect/Field;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ThreadCleaner.class), "sThreadExitMethod", "getSThreadExitMethod()Ljava/lang/reflect/Method;"))};
        INSTANCE = new ThreadCleaner();
        sThreadLocalsField$delegate = LazyKt.lazy(ThreadCleaner$sThreadLocalsField$2.INSTANCE);
        sThreadExitMethod$delegate = LazyKt.lazy(ThreadCleaner$sThreadExitMethod$2.INSTANCE);
    }

    private ThreadCleaner() {
    }

    private final Method getSThreadExitMethod() {
        Lazy r0 = sThreadExitMethod$delegate;
        KProperty r1 = $$delegatedProperties[1];
        return (Method) r0.getValue();
    }

    private final Field getSThreadLocalsField() {
        Lazy r0 = sThreadLocalsField$delegate;
        KProperty r1 = $$delegatedProperties[0];
        return (Field) r0.getValue();
    }

    public final void clearThread(Thread r3) {
        if (r3 == null) goto L7;
        Method r0 = INSTANCE.getSThreadExitMethod();
        if (r0 == null) goto L8;
        r0.invoke(r3, new Object[0]);
        return;
    L8:
        return;
    }

    public final void clearTls() {
        Field r0 = getSThreadLocalsField();
        if (r0 == null) goto L6;
        r0.set(Thread.currentThread(), null);
        return;
    }
}
