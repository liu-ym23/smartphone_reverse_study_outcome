package com.larus.dispatcher.askhuman.handler;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dispatcher.api.UploadAskHumanWarnResultApi;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1", f = "AskHumanWarnResultUploader.kt", i = {}, l = {24, 41}, m = "invokeSuspend", n = {}, s = {})
public final class AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ u $serverOption;
    int label;

    /* JADX INFO: renamed from: com.larus.dispatcher.askhuman.handler.AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1$1", f = "AskHumanWarnResultUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            t19.s r4 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r4.getClass();
            t19.s.b(r0, 2131899926, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1(String r1, u r2, Continuation<? super AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1> r3) {
        this.$messageId = r1;
        this.$serverOption = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1(this.$messageId, this.$serverOption, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L32:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L13:
        dm9.a.b r16 = (dm9.a) r15;
        boolean r2 = r16 instanceof dm9.a.b;
        if (r2 == true) goto L16;
    L18:
        r4 = false;
    L19:
        if (r4 == true) goto L32;
        Set<Integer> r5 = n.a;
        n.c(this.$messageId);
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("[uploadAskHumanWarnResult] failed, scene=");
        r7.append(this.$serverOption.b);
        r7.append(", error=");
        CoroutineScope r8 = AskHumanWarnResultUploaderKt.a;
        if (r2 == false) goto L24;
        StringBuilder r3 = new StringBuilder("biz_error:");
        dm9.a.b r17 = r16;
        r3.append(r17.a.getCode());
        r3.append(':');
        r3.append(r17.a.getMsg());
        String r18 = r3.toString();
    L26:
        r7.append(r18);
        r6.e("QuickReplyClickInterceptorManager", r7.toString());
        MainCoroutineDispatcher r110 = Dispatchers.getMain();
        AnonymousClass1 r9 = new AnonymousClass1(null);
        this.label = 2;
        if (BuildersKt.withContext(r110, r9, this) != r0) goto L32;
        return r0;
    L24:
        if ((r16 instanceof dm9.a.a) == false) goto L30;
        StringBuilder r10 = new StringBuilder("http_error:");
        dm9.a.a r111 = (dm9.a.a) r16;
        r10.append(r111.a);
        r10.append(':');
        r10.append(r111.b);
        r18 = r10.toString();
        goto L26
    L30:
        throw new NoWhenBranchMatchedException();
    L16:
        if (r16.a.isSuccess() == false) goto L18;
    L10:
        ResultKt.throwOnFailure(r15);
        UploadAskHumanWarnResultApi.a r112 = UploadAskHumanWarnResultApi.a;
        AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1$result$1 r11 = new AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1$result$1(this.$serverOption, null);
        this.label = 1;
        r112.getClass();
        FlowHttpConnection r113 = FlowHttpConnection.a;
        r15 = FlowHttpConnection.g("MainBot", UploadAskHumanWarnResultApi.class, r11, true, null, null, null, this, BaiduNaviStatus.NO_PERMISSION);
        if (r15 != r0) goto L13;
        return r0;
    }
}
