package com.ss.android.lark.officesdk.plugin;

import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginStage;
import io.reactivex.Completable;
import io.reactivex.functions.Function;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ OfficeSDKPluginStage a;
    public final /* synthetic */ String b;

    public b(OfficeSDKPluginStage r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        if ((r5 instanceof TimeoutException) == false) goto L6;
        ConcurrentHashMap<String, Completable> r6 = d.a;
        return Completable.error(d.e(this.a, OfficeSDKPluginErrorCode.OPERATION_TIMEOUT, "Plugin operation timed out: " + this.b, null));
    L6:
        return Completable.error(r5);
    }
}
