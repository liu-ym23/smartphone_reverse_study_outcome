package com.bytedance.ai.bridge.method.floatinginput;

import android.content.Context;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import f2.k;
import f3.h;
import k2.j;
import k2.t;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/ClearContextMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsClearContextMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsClearContextMethodIDL$ClearContextParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsClearContextMethodIDL$ClearContextResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClearContextMethod extends AbsClearContextMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.floatinginput.ClearContextMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.floatinginput.ClearContextMethod$handle$1", f = "ClearContextMethod.kt", i = {1}, l = {45, 73}, m = "invokeSuspend", n = {"clearAdditional"}, s = {"L$0"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ h<AbsClearContextMethodIDL.b> $callback;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.floatinginput.ClearContextMethod$handle$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ContainerType.values().length];
                r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[ContainerType.WORKER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public AnonymousClass1(e3.d r1, h<AbsClearContextMethodIDL.b> r10, Continuation<? super AnonymousClass1> r11) {
            this.$bridgeContext = r1;
            this.$callback = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$bridgeContext, this.$callback, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Ref.ObjectRef r11 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r10);
        L67:
            Boolean r12 = (Boolean) r10;
            Ref.ObjectRef r13 = r11;
        L69:
            if (Intrinsics.areEqual(r12, Boxing.boxBoolean(true)) == false) goto L73;
            Function0 r14 = (Function0) r13.element;
            if (r14 == null) goto L73;
            r14.invoke();
        L73:
            h<AbsClearContextMethodIDL.b> r15 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsClearContextMethodIDL.b.class, "<this>");
            h.a.b(r15, (ResultModel) k3.c.a(AbsClearContextMethodIDL.b.class));
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L41:
            h<AbsClearContextMethodIDL.b> r16 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsClearContextMethodIDL.b.class, "<this>");
            h.a.b(r16, (ResultModel) k3.c.a(AbsClearContextMethodIDL.b.class));
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r10);
            final Ref.ObjectRef r17 = new Ref.ObjectRef();
            r13 = new Ref.ObjectRef();
            a0 r18 = this.$bridgeContext.getContainerContext();
            r12 = null;
            if (r18 == null) goto L13;
            ContainerType r19 = r18.getContainerType();
        L14:
            if (r19 != null) goto L16;
            int r20 = -1;
        L17:
            if (r20 == 1) goto L54;
            if (r20 != 2) goto L20;
            final j r21 = (j) this.$bridgeContext.d(j.class);
            if (r21 == null) goto L36;
            t r22 = r21.getFloatingSpeakerController();
        L37:
            if (r22 == null) goto L43;
            this.label = 1;
            if (r22.h(this) != r0) goto L41;
            return r0;
        L43:
            AppletRuntimeManager r23 = AppletRuntimeManager.INSTANCE;
            if (r21 == null) goto L48;
            PageInfo r24 = r21.getPageInfo();
            if (r24 == null) goto L48;
            String r25 = r24.getBotId();
        L49:
            r23.getClass();
            if (r25 == null) goto L52;
            String r26 = x4.a.a(r25);
        L53:
            r17.element = r26;
            r13.element = new c(r21, r17);
        L59:
            String r110 = (String) r17.element;
            if (r110 == null) goto L73;
            r4.h r27 = r4.a.l;
            if (r27 == null) goto L69;
            Context r28 = k.a();
            this.L$0 = r13;
            this.label = 2;
            r10 = r27.a(r28, r110, this);
            if (r10 != r0) goto L66;
            return r0;
        L66:
            r11 = r13;
            goto L67
        L52:
            r26 = null;
        L48:
            r25 = null;
            goto L49
        L36:
            r22 = null;
            goto L37
        L20:
            if (r20 != 3) goto L59;
            final AppletRuntime r29 = (AppletRuntime) this.$bridgeContext.d(AppletRuntime.class);
            AppletRuntimeManager r30 = AppletRuntimeManager.INSTANCE;
            if (r29 == null) goto L27;
            Applet r31 = r29.h;
            if (r31 == null) goto L27;
            String r32 = r31.N;
        L28:
            r30.getClass();
            if (r32 == null) goto L31;
            String r33 = x4.a.a(r32);
        L32:
            r17.element = r33;
            r13.element = new d(r29, r17);
            goto L59
        L31:
            r33 = null;
        L27:
            r32 = null;
            goto L28
        L54:
            final WidgetContainer r34 = (WidgetContainer) this.$bridgeContext.d(WidgetContainer.class);
            if (r34 == null) goto L57;
            String r35 = r34.b;
        L58:
            r17.element = r35;
            r13.element = new b(r34);
            goto L59
        L57:
            r35 = null;
            goto L58
        L16:
            r20 = a.a[r19.ordinal()];
            goto L17
        L13:
            r19 = null;
            goto L14
        }
    }

    public ClearContextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsClearContextMethodIDL.a) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AnonymousClass1(r10, r12, null), 3, null);
    }
}
