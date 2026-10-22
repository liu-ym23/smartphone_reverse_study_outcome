package com.obric.memorydata.screencapture.service;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.screencapture.ScreenData;
import com.obric.memorydata.sdk.screencapture.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J&\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/screencapture/service/CaptureCurrentCallbackNotifier;", "", "<init>", "()V", "TAG", "", "notifyCaptured", "", "callback", "Lcom/obric/memorydata/sdk/screencapture/ICaptureCurrentCallback;", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "targetPackage", "notifyError", "errorCode", "", "errorMessage", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12811a = null;

    static {
        f12811a = new a();
    }

    private a() {
    }

    public final void a(c r3, ScreenData r4, String r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "targetPackage");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r6.a(r4);     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L18;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L11
        RunLog.INSTANCE.warn("ScreenCaptureService", "captureCurrent onCaptured callback failed pkg=" + r5, r8);     // Catch: Throwable -> L11
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L18:
        return;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void a(c r3, String r4, int r5, String r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r4, "targetPackage");
        Intrinsics.checkNotNullParameter(r6, "errorMessage");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r7.a(r5, r6);     // Catch: Throwable -> L5
        Object r8 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L18;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L11
        RunLog.INSTANCE.warn("ScreenCaptureService", "captureCurrent onError callback failed pkg=" + r4, r9);     // Catch: Throwable -> L11
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L18:
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
