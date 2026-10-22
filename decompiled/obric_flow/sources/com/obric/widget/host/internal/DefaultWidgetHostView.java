package com.obric.widget.host.internal;

import a3.g;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.feature.miniapp.widget.MiniAppHostView;
import com.obric.widget.host.WidgetHostContract;
import com.obric.widget.host.runtime.WidgetDataSnapshot;
import com.obric.widget.host.runtime.WidgetDefinitionMetadata;
import com.obric.widget.host.runtime.WidgetInstanceSnapshot;
import com.obric.widget.host.runtime.WidgetRefreshAffectedResult;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014J2\u0010\u001b\u001a\u00020\u00192\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00190\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u001dH\u0016JT\u0010\u001f\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060!2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u001e\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060!\u0012\u0004\u0012\u00020\u00190#2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u001dH\u0016JB\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00190\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u001dH\u0016J2\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190,2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u001dH\u0016J\u0016\u0010-\u001a\u00020\u00192\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190,H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00060"}, d2 = {"Lcom/obric/widget/host/internal/DefaultWidgetHostView;", "Landroid/widget/FrameLayout;", "Lcom/obric/feature/miniapp/widget/MiniAppHostView;", "context", "Landroid/content/Context;", "hostId", "", "metadata", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "snapshot", "Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;", "runtimeServices", "Lcom/obric/widget/host/runtime/WidgetRuntimeServices;", "contract", "Lcom/obric/widget/host/WidgetHostContract;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;Lcom/obric/widget/host/runtime/WidgetRuntimeServices;Lcom/obric/widget/host/WidgetHostContract;Lkotlinx/coroutines/CoroutineScope;)V", "value", "Landroid/view/View;", "widgetView", "getWidgetView", "()Landroid/view/View;", "setWidgetView", "", "view", "updateWidget", "onSuccess", "Lkotlin/Function1;", "onFailure", "refreshAffected", "changedDomains", "", "reason", "Lkotlin/Function2;", "", "sendPayload", "payload", "waitForResult", "", "openPage", "args", "Landroid/os/Bundle;", "Lkotlin/Function0;", "dispatchCallback", "callback", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultWidgetHostView extends FrameLayout implements MiniAppHostView {
    public static final Companion Companion = null;
    private static final String TAG = "OWidgetHostView";
    private final WidgetHostContract contract;
    private final String hostId;
    private final WidgetDefinitionMetadata metadata;
    private final WidgetRuntimeServices runtimeServices;
    private final CoroutineScope scope;
    private final WidgetInstanceSnapshot snapshot;
    private View widgetView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/widget/host/internal/DefaultWidgetHostView$Companion;", "", "<init>", "()V", "TAG", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultWidgetHostView$dispatchCallback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHostView$dispatchCallback$1", f = "DefaultWidgetHostView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        int label;

        public AnonymousClass1(Function0<Unit> r5, Continuation<? super AnonymousClass1> r10) {
            this.$callback = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass1(this.$callback, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            this.$callback.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultWidgetHostView$openPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHostView$openPage$1", f = "DefaultWidgetHostView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ Function1<String, Unit> $onFailure;
        final /* synthetic */ Function0<Unit> $onSuccess;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DefaultWidgetHostView this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C01891(DefaultWidgetHostView r5, Bundle r10, Function0<Unit> r11, Function1<? super String, Unit> r12, Continuation<? super C01891> r13) {
            this.this$0 = r5;
            this.$args = r10;
            this.$onSuccess = r11;
            this.$onFailure = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C01891 r12 = new C01891(this.this$0, this.$args, this.$onSuccess, this.$onFailure, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L24;
            ResultKt.throwOnFailure(r5);
            CoroutineScope r10 = (CoroutineScope) this.L$0;
            DefaultWidgetHostView r11 = this.this$0;
            Bundle r12 = this.$args;
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L7
            Object r14 = Result.m124constructorimpl(Boxing.boxBoolean(DefaultWidgetHostView.access$getContract$p(r11).openPage(r12)));     // Catch: Throwable -> L7
        L9:
            Function0<Unit> r15 = this.$onSuccess;
            Function1<String, Unit> r16 = this.$onFailure;
            DefaultWidgetHostView r17 = this.this$0;
            if (Result.m131isSuccessimpl(r14) == true) goto L12;
        L15:
            DefaultWidgetHostView r18 = this.this$0;
            Function1<String, Unit> r19 = this.$onFailure;
            Throwable r20 = Result.m127exceptionOrNullimpl(r14);
            if (r20 == null) goto L22;
            Log.w(DefaultWidgetHostView.TAG, "openPage failed: host=" + DefaultWidgetHostView.access$getHostId$p(r18) + ", instance=" + DefaultWidgetHostView.access$getSnapshot$p(r18).getHostWidgetInstanceId(), r20);
            String r21 = r20.getMessage();
            if (r21 != null) goto L20;
            r21 = r20.toString();
        L20:
            r19.invoke(r21);
        L22:
            return Unit.INSTANCE;
        L12:
            if (((Boolean) r14).booleanValue() == false) goto L14;
            r15.invoke();
            goto L15
        L14:
            r16.invoke("openPage is not handled by host=" + DefaultWidgetHostView.access$getHostId$p(r17));
        L7:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L9
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01891) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultWidgetHostView$refreshAffected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHostView$refreshAffected$1", f = "DefaultWidgetHostView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $changedDomains;
        final /* synthetic */ Function1<String, Unit> $onFailure;
        final /* synthetic */ Function2<Integer, List<String>, Unit> $onSuccess;
        final /* synthetic */ String $reason;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DefaultWidgetHostView this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C01901(DefaultWidgetHostView r5, List<String> r10, String r11, Function2<? super Integer, ? super List<String>, Unit> r12, Function1<? super String, Unit> r13, Continuation<? super C01901> r14) {
            this.this$0 = r5;
            this.$changedDomains = r10;
            this.$reason = r11;
            this.$onSuccess = r12;
            this.$onFailure = r13;
            super(2, r14);
        }

        public static /* synthetic */ Unit b(Function2 r5, int r10, List r11) {
            return invokeSuspend$lambda$2$lambda$1(r5, r10, r11);
        }

        public static /* synthetic */ Unit f(Function1 r5, Throwable r10) {
            return invokeSuspend$lambda$4$lambda$3(r5, r10);
        }

        private static final Unit invokeSuspend$lambda$2$lambda$1(Function2 r5, int r10, List r11) {
            r5.mo2invoke(Integer.valueOf(r10), r11);
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$4$lambda$3(Function1 r5, Throwable r10) {
            String r11 = r10.getMessage();
            if (r11 != null) goto L5;
            r11 = r10.toString();
        L5:
            r5.invoke(r11);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C01901 r12 = new C01901(this.this$0, this.$changedDomains, this.$reason, this.$onSuccess, this.$onFailure, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            int r5 = 0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r12);
            CoroutineScope r13 = (CoroutineScope) this.L$0;
            DefaultWidgetHostView r14 = this.this$0;
            List<String> r10 = this.$changedDomains;
            String r11 = this.$reason;
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L7
            Object r16 = Result.m124constructorimpl(DefaultWidgetHostView.access$getRuntimeServices$p(r14).refreshAffectedByUpdate(DefaultWidgetHostView.access$getMetadata$p(r14).getAppletId(), r10, r11));     // Catch: Throwable -> L7
        L9:
            DefaultWidgetHostView r17 = this.this$0;
            final Function2<Integer, List<String>, Unit> r18 = this.$onSuccess;
            if (Result.m131isSuccessimpl(r16) == false) goto L21;
            WidgetRefreshAffectedResult r19 = (WidgetRefreshAffectedResult) r16;
            if (r19 == null) goto L14;
            final int r20 = r19.getAcceptedCount();
        L15:
            if (r19 == null) goto L17;
            final List<String> r21 = r19.getUpdatedWidgetIds();
        L18:
            if (r21 != null) goto L20;
            r21 = CollectionsKt.emptyList();
        L20:
            Log.d(DefaultWidgetHostView.TAG, "refreshAffected success: host=" + DefaultWidgetHostView.access$getHostId$p(r17) + ", instance=" + DefaultWidgetHostView.access$getSnapshot$p(r17).getHostWidgetInstanceId() + ", acceptedCount=" + r20 + ", updatedWidgetIds=" + r21);
            DefaultWidgetHostView.access$dispatchCallback(r17, new a(r18, r20, r21));
            goto L21
        L17:
            r21 = null;
            goto L18
        L14:
            r20 = 0;
        L21:
            DefaultWidgetHostView r22 = this.this$0;
            Function1<String, Unit> r110 = this.$onFailure;
            Throwable r111 = Result.m127exceptionOrNullimpl(r16);
            if (r111 == null) goto L25;
            Log.w(DefaultWidgetHostView.TAG, "refreshAffected failed: host=" + DefaultWidgetHostView.access$getHostId$p(r22) + ", instance=" + DefaultWidgetHostView.access$getSnapshot$p(r22).getHostWidgetInstanceId(), r111);
            DefaultWidgetHostView.access$dispatchCallback(r22, new b(r110, r111, r5));
        L25:
            return Unit.INSTANCE;
        L7:
            th = move-exception;
            Result.Companion r23 = Result.Companion;
            r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L9
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01901) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultWidgetHostView$sendPayload$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHostView$sendPayload$1", f = "DefaultWidgetHostView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onFailure;
        final /* synthetic */ Function1<String, Unit> $onSuccess;
        final /* synthetic */ String $payload;
        final /* synthetic */ boolean $waitForResult;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DefaultWidgetHostView this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C01911(DefaultWidgetHostView r5, String r10, boolean r11, Function1<? super String, Unit> r12, Function1<? super String, Unit> r13, Continuation<? super C01911> r14) {
            this.this$0 = r5;
            this.$payload = r10;
            this.$waitForResult = r11;
            this.$onSuccess = r12;
            this.$onFailure = r13;
            super(2, r14);
        }

        public static /* synthetic */ Unit b(Function1 r5, Throwable r10) {
            return invokeSuspend$lambda$4$lambda$3(r5, r10);
        }

        public static /* synthetic */ Unit f(Function1 r5, String r10) {
            return invokeSuspend$lambda$2$lambda$1(r5, r10);
        }

        private static final Unit invokeSuspend$lambda$2$lambda$1(Function1 r5, String r10) {
            r5.invoke(r10);
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$4$lambda$3(Function1 r5, Throwable r10) {
            String r11 = r10.getMessage();
            if (r11 != null) goto L5;
            r11 = r10.toString();
        L5:
            r5.invoke(r11);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C01911 r12 = new C01911(this.this$0, this.$payload, this.$waitForResult, this.$onSuccess, this.$onFailure, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            int r5 = 0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r12);
            CoroutineScope r13 = (CoroutineScope) this.L$0;
            DefaultWidgetHostView r14 = this.this$0;
            String r10 = this.$payload;
            boolean r11 = this.$waitForResult;
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L7
            Object r16 = Result.m124constructorimpl(DefaultWidgetHostView.access$getRuntimeServices$p(r14).sendPayload(DefaultWidgetHostView.access$getMetadata$p(r14).getAppletId(), DefaultWidgetHostView.access$getMetadata$p(r14).getWidgetId(), DefaultWidgetHostView.access$getSnapshot$p(r14).getHostWidgetInstanceId(), r10, r11));     // Catch: Throwable -> L7
        L9:
            DefaultWidgetHostView r17 = this.this$0;
            Function1<String, Unit> r18 = this.$onSuccess;
            if (Result.m131isSuccessimpl(r16) == false) goto L16;
            String r19 = (String) r16;
            String r20 = DefaultWidgetHostView.access$getHostId$p(r17);
            int r21 = DefaultWidgetHostView.access$getSnapshot$p(r17).getHostWidgetInstanceId();
            if (r19 == null) goto L14;
            int r22 = r19.length();
        L15:
            Log.d(DefaultWidgetHostView.TAG, "sendPayload success: host=" + r20 + ", instance=" + r21 + ", resultLength=" + r22);
            DefaultWidgetHostView.access$dispatchCallback(r17, new c(r5, r18, r19));
            goto L16
        L14:
            r22 = 0;
        L16:
            DefaultWidgetHostView r23 = this.this$0;
            Function1<String, Unit> r110 = this.$onFailure;
            Throwable r111 = Result.m127exceptionOrNullimpl(r16);
            if (r111 == null) goto L20;
            Log.w(DefaultWidgetHostView.TAG, "sendPayload failed: host=" + DefaultWidgetHostView.access$getHostId$p(r23) + ", instance=" + DefaultWidgetHostView.access$getSnapshot$p(r23).getHostWidgetInstanceId(), r111);
            DefaultWidgetHostView.access$dispatchCallback(r23, new b(r110, r111, 1));
        L20:
            return Unit.INSTANCE;
        L7:
            th = move-exception;
            Result.Companion r24 = Result.Companion;
            r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L9
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01911) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultWidgetHostView$updateWidget$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHostView$updateWidget$1", f = "DefaultWidgetHostView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onFailure;
        final /* synthetic */ Function1<String, Unit> $onSuccess;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DefaultWidgetHostView this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C01921(DefaultWidgetHostView r5, Function1<? super String, Unit> r10, Function1<? super String, Unit> r11, Continuation<? super C01921> r12) {
            this.this$0 = r5;
            this.$onSuccess = r10;
            this.$onFailure = r11;
            super(2, r12);
        }

        public static /* synthetic */ Unit b(Function1 r5, Throwable r10) {
            return invokeSuspend$lambda$4$lambda$3(r5, r10);
        }

        public static /* synthetic */ Unit f(Function1 r5, String r10) {
            return invokeSuspend$lambda$2$lambda$1(r5, r10);
        }

        private static final Unit invokeSuspend$lambda$2$lambda$1(Function1 r5, String r10) {
            r5.invoke(r10);
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$4$lambda$3(Function1 r5, Throwable r10) {
            String r11 = r10.getMessage();
            if (r11 != null) goto L5;
            r11 = r10.toString();
        L5:
            r5.invoke(r11);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C01921 r11 = new C01921(this.this$0, this.$onSuccess, this.$onFailure, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L31;
            ResultKt.throwOnFailure(r11);
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            DefaultWidgetHostView r13 = this.this$0;
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
            WidgetDataSnapshot r10 = DefaultWidgetHostView.access$getRuntimeServices$p(r13).queryWidgetData(DefaultWidgetHostView.access$getMetadata$p(r13).getAppletId(), DefaultWidgetHostView.access$getMetadata$p(r13).getWidgetId(), DefaultWidgetHostView.access$getSnapshot$p(r13).getHostWidgetInstanceId());     // Catch: Throwable -> L8
            if (r10 == null) goto L10;
            String r14 = r10.getWidgetData();     // Catch: Throwable -> L8
        L11:
            String r15 = DefaultWidgetHostView.access$getRuntimeServices$p(r13).updateWidget(DefaultWidgetHostView.access$getMetadata$p(r13).getAppletId(), DefaultWidgetHostView.access$getMetadata$p(r13).getWidgetId(), DefaultWidgetHostView.access$getSnapshot$p(r13).getHostWidgetInstanceId(), DefaultWidgetHostView.access$getRuntimeServices$p(r13).getInstanceManager().resolvePreferredRefreshReason(DefaultWidgetHostView.access$getSnapshot$p(r13).getHostWidgetInstanceId(), "manual"));     // Catch: Throwable -> L8
            if (r15 == null) goto L15;
            r14 = r15;
        L15:
            Object r16 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L8
        L18:
            DefaultWidgetHostView r17 = this.this$0;
            Function1<String, Unit> r18 = this.$onSuccess;
            if (Result.m131isSuccessimpl(r16) == false) goto L25;
            String r19 = (String) r16;
            String r20 = DefaultWidgetHostView.access$getHostId$p(r17);
            int r21 = DefaultWidgetHostView.access$getSnapshot$p(r17).getHostWidgetInstanceId();
            if (r19 == null) goto L23;
            int r22 = r19.length();
        L24:
            Log.d(DefaultWidgetHostView.TAG, "updateWidget success: host=" + r20 + ", instance=" + r21 + ", dataLength=" + r22);
            DefaultWidgetHostView.access$dispatchCallback(r17, new c(1, r18, r19));
            goto L25
        L23:
            r22 = 0;
        L25:
            DefaultWidgetHostView r23 = this.this$0;
            Function1<String, Unit> r110 = this.$onFailure;
            Throwable r111 = Result.m127exceptionOrNullimpl(r16);
            if (r111 == null) goto L29;
            Log.w(DefaultWidgetHostView.TAG, "updateWidget failed: host=" + DefaultWidgetHostView.access$getHostId$p(r23) + ", instance=" + DefaultWidgetHostView.access$getSnapshot$p(r23).getHostWidgetInstanceId(), r111);
            DefaultWidgetHostView.access$dispatchCallback(r23, new b(r110, r111, 2));
        L29:
            return Unit.INSTANCE;
        L10:
            r14 = null;
        L8:
            th = move-exception;
            Result.Companion r24 = Result.Companion;
            r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L18
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01921) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DefaultWidgetHostView(Context r5, String r10, WidgetDefinitionMetadata r11, WidgetInstanceSnapshot r12, WidgetRuntimeServices r13, WidgetHostContract r14, CoroutineScope r15) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "hostId");
        Intrinsics.checkNotNullParameter(r11, "metadata");
        Intrinsics.checkNotNullParameter(r12, "snapshot");
        Intrinsics.checkNotNullParameter(r13, "runtimeServices");
        Intrinsics.checkNotNullParameter(r14, "contract");
        Intrinsics.checkNotNullParameter(r15, "scope");
        super(r5);
        this.hostId = r10;
        this.metadata = r11;
        this.snapshot = r12;
        this.runtimeServices = r13;
        this.contract = r14;
        this.scope = r15;
    }

    public static /* synthetic */ void a(Function0 r5) {
        dispatchCallback$lambda$0(r5);
    }

    public static final /* synthetic */ void access$dispatchCallback(DefaultWidgetHostView r5, Function0 r10) {
        r5.dispatchCallback(r10);
    }

    public static final /* synthetic */ WidgetHostContract access$getContract$p(DefaultWidgetHostView r5) {
        return r5.contract;
    }

    public static final /* synthetic */ String access$getHostId$p(DefaultWidgetHostView r5) {
        return r5.hostId;
    }

    public static final /* synthetic */ WidgetDefinitionMetadata access$getMetadata$p(DefaultWidgetHostView r5) {
        return r5.metadata;
    }

    public static final /* synthetic */ WidgetRuntimeServices access$getRuntimeServices$p(DefaultWidgetHostView r5) {
        return r5.runtimeServices;
    }

    public static final /* synthetic */ WidgetInstanceSnapshot access$getSnapshot$p(DefaultWidgetHostView r5) {
        return r5.snapshot;
    }

    private final void dispatchCallback(Function0<Unit> r10) {
        if (isAttachedToWindow() == false) goto L5;
        post(new g(3, r10));
        return;
    L5:
        BuildersKt.launch$default(this.scope, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(r10, null), 2, null);
    }

    private static final void dispatchCallback$lambda$0(Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "$tmp0");
        r5.invoke();
    }

    public final View getWidgetView() {
        return this.widgetView;
    }

    @Override // com.obric.feature.miniapp.widget.MiniAppHostView
    public void openPage(Bundle r10, Function0<Unit> r11, Function1<? super String, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "args");
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        Intrinsics.checkNotNullParameter(r12, "onFailure");
        BuildersKt.launch$default(this.scope, Dispatchers.getMain().getImmediate(), null, new C01891(this, r10, r11, r12, null), 2, null);
    }

    @Override // com.obric.feature.miniapp.widget.MiniAppHostView
    public void refreshAffected(List<String> r11, String r12, Function2<? super Integer, ? super List<String>, Unit> r13, Function1<? super String, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "changedDomains");
        Intrinsics.checkNotNullParameter(r13, "onSuccess");
        Intrinsics.checkNotNullParameter(r14, "onFailure");
        BuildersKt.launch$default(this.scope, Dispatchers.getIO(), null, new C01901(this, r11, r12, r13, r14, null), 2, null);
    }

    @Override // com.obric.feature.miniapp.widget.MiniAppHostView
    public void sendPayload(String r11, boolean r12, Function1<? super String, Unit> r13, Function1<? super String, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "payload");
        Intrinsics.checkNotNullParameter(r13, "onSuccess");
        Intrinsics.checkNotNullParameter(r14, "onFailure");
        BuildersKt.launch$default(this.scope, Dispatchers.getIO(), null, new C01911(this, r11, r12, r13, r14, null), 2, null);
    }

    public final void setWidgetView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.widgetView = r5;
        removeAllViews();
        addView(r5, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.obric.feature.miniapp.widget.MiniAppHostView
    public void updateWidget(Function1<? super String, Unit> r10, Function1<? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "onSuccess");
        Intrinsics.checkNotNullParameter(r11, "onFailure");
        BuildersKt.launch$default(this.scope, Dispatchers.getIO(), null, new C01921(this, r10, r11, null), 2, null);
    }
}
