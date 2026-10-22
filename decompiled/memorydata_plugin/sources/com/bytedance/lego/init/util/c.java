package com.bytedance.lego.init.util;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0007R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u0007\u001a\u00020\b8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\u0007\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u00020\u00138FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/lego/init/util/InitContext;", "", "()V", "commonParams", "Ljava/util/concurrent/ConcurrentHashMap;", "getCommonParams", "()Ljava/util/concurrent/ConcurrentHashMap;", "isMainProcess", "", "isMainProcess$annotations", "()Z", "isMainProcess$delegate", "Lkotlin/Lazy;", "mainActivity", "Landroid/app/Activity;", "mainActivity$annotations", "getMainActivity", "()Landroid/app/Activity;", "processName", "", "processName$annotations", "getProcessName", "()Ljava/lang/String;", "processName$delegate", "splashActivity", "splashActivity$annotations", "getSplashActivity", "key", "setCommonParams", "", EventBody.KEY_VALUE, "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f2798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f2799b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;
    private static final ConcurrentHashMap<Object, Object> e = null;

    static {
        f2798a = new KProperty[]{(KProperty) ZeusTransformUtils.preCheckCast(Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(c.class), "isMainProcess", "isMainProcess()Z")), KProperty.class, "com.obric.memorydata.plugin"), (KProperty) ZeusTransformUtils.preCheckCast(Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(c.class), "processName", "getProcessName()Ljava/lang/String;")), KProperty.class, "com.obric.memorydata.plugin")};
        f2799b = new c();
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(InitContext$isMainProcess$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(InitContext$processName$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        e = new ConcurrentHashMap();
    }

    private c() {
    }
}
