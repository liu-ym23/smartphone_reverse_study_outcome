package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/AppGlobals;", "", "()V", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "app$delegate", "Lkotlin/Lazy;", "getApplication", "getApplicationContext", "Landroid/content/Context;", "getResource", "Landroid/content/res/Resources;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8070a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f8071b = null;

    static {
        f8070a = new a();
        f8071b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(AppGlobals$app$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }

    private final Application c() {
        return (Application) ZeusTransformUtils.preCheckCast(f8071b.getValue(), Application.class, "com.obric.memorydata.plugin");
    }

    public final Application a() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
    }

    public final Context b() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getApplication().applicationContext");
        return r2;
    }
}
