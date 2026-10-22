package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/SingletonHolder;", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public abstract class SingletonHolder<T, A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FunctionReferenceImpl f7480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f7481b;

    /* JADX WARN: Multi-variable type inference failed */
    public SingletonHolder(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "creator");
        this.f7480a = (FunctionReferenceImpl) r5;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.internal.FunctionReferenceImpl] */
    public final Object a(Context r5) {
        Object r10 = this.f7481b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        monitor-enter(this);
        Object r11 = this.f7481b;     // Catch: Throwable -> L12
        if (r11 != null) goto L10;
        ?? r12 = this.f7480a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L12
        r11 = r12.invoke(r5);     // Catch: Throwable -> L12
        this.f7481b = r11;     // Catch: Throwable -> L12
        this.f7480a = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r11;
    L12:
        th = move-exception;
        throw th;
    }
}
