package com.obric.aikernel.core;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/aikernel/core/TransactHandle;", "", "()V", "TAG", "", "Transact_post_event", "", "notifyRequestComplete", "", "binder", "Landroid/os/IBinder;", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "event", "postEventInner", "bundle", "Landroid/os/Bundle;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5989a = null;

    static {
        f5989a = new b();
    }

    private b() {
    }

    private final void a(IBinder r3, Bundle r4) {
        IBinder r2 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        Parcel r5 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r5, "obtain()");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Boolean.valueOf(r2.transact(1001, r5, null, 1)));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L10;
        AIKLog.INSTANCE.e("TransactHandle", "postEvent err: " + r7);
    L10:
        r5.recycle();
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void a(IBinder r3, RequestParams r4, int r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "binder");
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        r4.setTargetComponent(2);
        r4.setEvent(r5);
        a(r6, r4.start());
    }
}
