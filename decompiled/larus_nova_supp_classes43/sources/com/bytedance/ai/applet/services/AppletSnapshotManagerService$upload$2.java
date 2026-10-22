package com.bytedance.ai.applet.services;

import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import p4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/applet/services/SnapshotUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.services.AppletSnapshotManagerService$upload$2", f = "AppletSnapshotManagerService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletSnapshotManagerService$upload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends e>>, Object> {
    final /* synthetic */ String $messageId;
    int label;

    public AppletSnapshotManagerService$upload$2(String r1, Continuation<? super AppletSnapshotManagerService$upload$2> r10) {
        this.$messageId = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletSnapshotManagerService$upload$2(this.$messageId, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<e>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L49;
        ResultKt.throwOnFailure(r10);
        d r0 = null;
        if (StringsKt.isBlank(this.$messageId) == false) goto L8;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "upload failed: messageId is blank", null);
        Result.Companion r11 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception("messageId is blank"))));
    L8:
        com.bytedance.ai.applet.base.log.b r12 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "upload: messageId=" + this.$messageId);
        AppletSnapshotManagerService r13 = AppletSnapshotManagerService.a;
        String r14 = this.$messageId;
        Intrinsics.checkNotNullParameter(r14, "messageId");
        if (StringsKt.isBlank(r14) == false) goto L11;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "remove failed: messageId is blank", null);
    L23:
        if (r0 != null) goto L26;
        Result.Companion r15 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception("snapshot not found, messageId=" + this.$messageId))));
    L26:
        UserAuthService r16 = UserAuthService.a;
        t r17 = new t(this.$messageId, r0.b);
        Intrinsics.checkNotNullParameter(r17, "request");
        SsResponse r18 = UserAuthService.e.uploadScreenshot(r17).execute();     // Catch: Exception -> L37
        if (r18.isSuccessful() == true) goto L30;
    L35:
        g.a.e("UserAuthService", "uploadScreenshot: Http Error, code = " + r18.code());     // Catch: Exception -> L37
    L50:
    L39:
        boolean r19 = false;
    L40:
        if (r19 == true) goto L43;
        Result.Companion r20 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception("upload screenshot failed, messageId=" + this.$messageId))));
    L43:
        Result.Companion r21 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(new e(this.$messageId, r0.a, r0.c, r0.d)));
    L30:
        if (r18.body() == null) goto L35;
        p4.a r22 = (p4.a) r18.body();     // Catch: Exception -> L37
        if (r22.d() == false) goto L34;
        r19 = true;
        goto L40
    L34:
        g.a.e("UserAuthService", "uploadScreenshot: Server Error: " + r22);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        g.a.e("UserAuthService", "uploadScreenshot ERROR: " + e.getMessage(), e);
        goto L39
    L11:
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "remove: messageId=" + r14);
        Object r1 = AppletSnapshotManagerService.b;
        monitor-enter(r1);
        AppletSnapshotManagerService.g();     // Catch: Throwable -> L45
        Iterator<Map.Entry<String, AppletSnapshotManagerService.b>> r23 = AppletSnapshotManagerService.c.entrySet().iterator();     // Catch: Throwable -> L45
    L15:
        if (r23.hasNext() == false) goto L21;
        Map.Entry<String, AppletSnapshotManagerService.b> r24 = r23.next();     // Catch: Throwable -> L45
        if (Intrinsics.areEqual(r24.getValue().b, r14) == false) goto L15;
        r23.remove();     // Catch: Throwable -> L45
        AppletSnapshotManagerService r25 = AppletSnapshotManagerService.a;     // Catch: Throwable -> L45
        AppletSnapshotManagerService.h();     // Catch: Throwable -> L45
        AppletSnapshotManagerService.b r26 = r24.getValue();     // Catch: Throwable -> L45
        r26.getClass();     // Catch: Throwable -> L45
        r0 = new d(r26.a, r26.d, r26.c, r26.e, r26.f);     // Catch: Throwable -> L45
        monitor-exit(r1);
    L53:
        goto L23
    L21:
        AppletSnapshotManagerService r27 = AppletSnapshotManagerService.a;     // Catch: Throwable -> L45
        AppletSnapshotManagerService.h();     // Catch: Throwable -> L45
        com.bytedance.ai.applet.base.log.b r28 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L45
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "remove: not found, messageId=" + r14, null);     // Catch: Throwable -> L45
        monitor-exit(r1);
    L45:
        th = move-exception;
        throw th;
    L49:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
