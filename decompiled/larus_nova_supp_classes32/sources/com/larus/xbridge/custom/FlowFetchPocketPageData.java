package com.larus.xbridge.custom;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FlowFetchPocketPageData extends XCoreBridgeMethod {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.xbridge.custom.FlowFetchPocketPageData$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.xbridge.custom.FlowFetchPocketPageData$handle$1", f = "FlowFetchPocketPageData.kt", i = {}, l = {31, 32}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ XBridgeMethod.Callback $callback;
        int label;
        final /* synthetic */ FlowFetchPocketPageData this$0;

        /* JADX INFO: renamed from: com.larus.xbridge.custom.FlowFetchPocketPageData$handle$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.xbridge.custom.FlowFetchPocketPageData$handle$1$1", f = "FlowFetchPocketPageData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ XBridgeMethod.Callback $callback;
            final /* synthetic */ Map<String, Object> $springPocketData;
            int label;
            final /* synthetic */ FlowFetchPocketPageData this$0;

            public C00251(FlowFetchPocketPageData r1, XBridgeMethod.Callback r2, Map<String, ? extends Object> r3, Continuation<? super C00251> r4) {
                this.this$0 = r1;
                this.$callback = r2;
                this.$springPocketData = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00251(this.this$0, this.$callback, this.$springPocketData, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r9) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r9);
                FLogger.a.i("FlowFetchPocketPageData", "[handle] setResult, currentThread: " + ThreadMethodProxy.currentThread().getName());
                XCoreBridgeMethod.onSuccess$default(this.this$0, this.$callback, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(LynxResourceModule.DATA_KEY, this.$springPocketData)}), null, 4, null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(FlowFetchPocketPageData r1, XBridgeMethod.Callback r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$callback, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
        L13:
            MainCoroutineDispatcher r2 = Dispatchers.getMain();
            C00251 r3 = new C00251(this.this$0, this.$callback, (Map) r8, null);
            this.label = 2;
            if (BuildersKt.withContext(r2, r3, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            FLogger.a.i("FlowFetchPocketPageData", "[handle] getCacheOrFetchSpringPocketData currentThread: " + ThreadMethodProxy.currentThread().getName());
            IUgcAIGCService.Companion r9 = IUgcAIGCService.a;
            this.label = 1;
            r8 = r9.l(this);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    static {
    }

    public final String getName() {
        return "flow.fetchPocketPageData";
    }

    public FlowFetchPocketPageData() {
    }

    public final void handle(XReadableMap r8, XBridgeMethod.Callback r9, XBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "type");
        FLogger r11 = FLogger.a;
        r11.i("FlowFetchPocketPageData", "[handle] start, currentThread: " + ThreadMethodProxy.currentThread().getName());
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(this, r9, null), 2, null);
        r11.i("FlowFetchPocketPageData", "[handle] end");
    }
}
