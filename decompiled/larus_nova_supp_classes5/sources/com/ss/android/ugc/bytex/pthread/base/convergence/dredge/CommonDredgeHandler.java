package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/CommonDredgeHandler;", "", "()V", "sHandler", "Landroid/os/Handler;", "getSHandler", "()Landroid/os/Handler;", "sHandler$delegate", "Lkotlin/Lazy;", "getHandler", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class CommonDredgeHandler {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final CommonDredgeHandler INSTANCE = null;
    private static final Lazy sHandler$delegate = null;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CommonDredgeHandler.class), "sHandler", "getSHandler()Landroid/os/Handler;"))};
        INSTANCE = new CommonDredgeHandler();
        sHandler$delegate = LazyKt.lazy(CommonDredgeHandler$sHandler$2.INSTANCE);
    }

    private CommonDredgeHandler() {
    }

    private final Handler getSHandler() {
        Lazy r0 = sHandler$delegate;
        KProperty r1 = $$delegatedProperties[0];
        return (Handler) r0.getValue();
    }

    public final Handler getHandler() {
        return getSHandler();
    }
}
