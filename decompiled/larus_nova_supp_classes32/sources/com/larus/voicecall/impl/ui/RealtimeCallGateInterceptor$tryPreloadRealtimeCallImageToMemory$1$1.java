package com.larus.voicecall.impl.ui;

import android.app.Application;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallGateInterceptor$tryPreloadRealtimeCallImageToMemory$1$1", f = "RealtimeCallGateInterceptor.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallGateInterceptor$tryPreloadRealtimeCallImageToMemory$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $avatarUrl;
    final /* synthetic */ com.bytedance.router.c $it;
    int label;

    public static final class a extends BaseDataSubscriber<Void> {
        public final /* synthetic */ DataSource<Void> a;
        public final /* synthetic */ com.bytedance.router.c b;

        public final void onFailureImpl(DataSource<Void> r3) {
            Intrinsics.checkNotNullParameter(r3, "dataSource");
            r3.close();
            FLogger.a.e("RealtimeCallGateInterceptor", "realtime call preload, prefetchToBitmapCache onFailureImpl, res : " + this.a + " , url : " + this.b);
        }

        public final void onNewResultImpl(DataSource<Void> r3) {
            Intrinsics.checkNotNullParameter(r3, "dataSource");
            r3.close();
            FLogger.a.i("RealtimeCallGateInterceptor", "realtime call preload, prefetchToBitmapCache onNewResultImpl, res : " + this.a + " , url : " + this.b);
        }

        public a(DataSource<Void> r1, com.bytedance.router.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public RealtimeCallGateInterceptor$tryPreloadRealtimeCallImageToMemory$1$1(String r1, com.bytedance.router.c r2, Continuation<? super RealtimeCallGateInterceptor$tryPreloadRealtimeCallImageToMemory$1$1> r3) {
        this.$avatarUrl = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeCallGateInterceptor$tryPreloadRealtimeCallImageToMemory$1$1(this.$avatarUrl, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        DataSource r10 = (DataSource) r9;
        r10.subscribe(new a(r10, this.$it), UiThreadImmediateExecutorService.getInstance());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        String r2 = this.$avatarUrl;
        Application r3 = AppHost.a.getApplication();
        this.label = 1;
        r9 = ImageLoaderKt.A(r2, "realtime_call_bot_avatar_new", r3, null, null, this, 56);
        if (r9 != r0) goto L11;
        return r0;
    }
}
