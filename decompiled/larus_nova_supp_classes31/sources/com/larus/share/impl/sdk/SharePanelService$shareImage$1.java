package com.larus.share.impl.sdk;

import android.content.Context;
import com.larus.platform.service.e;
import com.larus.share.impl.sdk.special.ShareImageSpecialHandler;
import com.larus.share.impl.util.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.sdk.SharePanelService$shareImage$1", f = "SharePanelService.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
final class SharePanelService$shareImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Integer, Unit> $listener;
    final /* synthetic */ String $shareChannel;
    final /* synthetic */ com.larus.bmhome.share.panel.b $shareContent;
    final /* synthetic */ String $shareType;
    final /* synthetic */ boolean $showLoading;
    int label;
    final /* synthetic */ SharePanelService this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SharePanelService$shareImage$1(Context r1, Function1<? super Integer, Unit> r2, String r3, String r4, boolean r5, SharePanelService r6, com.larus.bmhome.share.panel.b r7, Continuation<? super SharePanelService$shareImage$1> r8) {
        this.$context = r1;
        this.$listener = r2;
        this.$shareChannel = r3;
        this.$shareType = r4;
        this.$showLoading = r5;
        this.this$0 = r6;
        this.$shareContent = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new SharePanelService$shareImage$1(this.$context, this.$listener, this.$shareChannel, this.$shareType, this.$showLoading, this.this$0, this.$shareContent, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L20
    L13:
        com.larus.bmhome.share.panel.b r14 = (com.larus.bmhome.share.panel.b) r13;     // Catch: Throwable -> L20
        if (r14 != null) goto L23;
        s r15 = s.a;     // Catch: Throwable -> L20
        Context r2 = this.$context;     // Catch: Throwable -> L20
        r15.getClass();     // Catch: Throwable -> L20
        s.s(r2, 2131908982);     // Catch: Throwable -> L20
        Function1<Integer, Unit> r16 = this.$listener;     // Catch: Throwable -> L20
        if (r16 == null) goto L19;
        r16.invoke(Boxing.boxInt(2));     // Catch: Throwable -> L20
    L19:
        return Unit.INSTANCE;
    L23:
        if (new ShareImageSpecialHandler().i(this.$context, this.$shareChannel, this.$shareType, r14, this.$showLoading, this.$listener) == false) goto L30;
        Function1<Integer, Unit> r17 = this.$listener;     // Catch: Throwable -> L20
        if (r17 == null) goto L28;
        r17.invoke(Boxing.boxInt(3));     // Catch: Throwable -> L20
    L28:
        return Unit.INSTANCE;
    L30:
        if (o0.d(r14.a) == false) goto L45;
        int r3 = f.a;     // Catch: Throwable -> L20
        if (f.a(r14.a) == true) goto L45;
        if (r14.r == true) goto L39;
        if (r14.q == false) goto L39;
        int r4 = e.a;     // Catch: Throwable -> L20
        String r5 = r14.a;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L20
        e.b(r5);     // Catch: Throwable -> L20
    L39:
        if (Intrinsics.areEqual(this.$shareChannel, "save_image") == false) goto L45;
        com.larus.share.impl.util.e.a.f(this.$context, r14.a, true, this.$listener);     // Catch: Throwable -> L20
        Function1<Integer, Unit> r18 = this.$listener;     // Catch: Throwable -> L20
        if (r18 == null) goto L44;
        r18.invoke(Boxing.boxInt(3));     // Catch: Throwable -> L20
    L44:
        return Unit.INSTANCE;
    L45:
        SharePanelService r6 = this.this$0;     // Catch: Throwable -> L20
        Context r7 = this.$context;     // Catch: Throwable -> L20
        String r8 = this.$shareChannel;     // Catch: Throwable -> L20
        String r9 = this.$shareType;     // Catch: Throwable -> L20
        boolean r10 = this.$showLoading;     // Catch: Throwable -> L20
        Function1<Integer, Unit> r11 = this.$listener;     // Catch: Throwable -> L20
        Set r12 = SharePanelService.b;     // Catch: Throwable -> L20
        r6.g(r7, r8, r9, r14, r10, r11);     // Catch: Throwable -> L20
    L51:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r19 = Dispatchers.getIO();     // Catch: Throwable -> L20
        SharePanelService$shareImage$1$finalShareContent$1 r20 = new SharePanelService$shareImage$1$finalShareContent$1(this.this$0, this.$context, this.$shareChannel, this.$shareContent, null);     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        r13 = BuildersKt.withContext(r19, r20, this);     // Catch: Throwable -> L20
        if (r13 != r0) goto L13;
        return r0;
    L20:
        th = move-exception;
        FLogger.a.e(this.this$0.a, "share image failed", th);
        s r110 = s.a;
        Context r21 = this.$context;
        r110.getClass();
        s.s(r21, 2131908982);
        Function1<Integer, Unit> r111 = this.$listener;
        if (r111 == null) goto L51;
        r111.invoke(Boxing.boxInt(2));
        goto L51
    }
}
