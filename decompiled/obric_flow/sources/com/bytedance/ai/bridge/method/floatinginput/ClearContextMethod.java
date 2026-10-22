package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.core.base.g;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.p;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.h;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h0;
import m1.j;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/ClearContextMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsClearContextMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsClearContextMethodIDL$ClearContextParamModal;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsClearContextMethodIDL$ClearContextResultModal;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floatinginput/AbsClearContextMethodIDL$ClearContextParamModal;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClearContextMethod extends AbsClearContextMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.floatinginput.ClearContextMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.floatinginput.ClearContextMethod$handle$1", f = "ClearContextMethod.kt", i = {1}, l = {46, 74}, m = "invokeSuspend", n = {"clearAdditional"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n1.c f1815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f1816b;

        public AnonymousClass1(n1.c r5, f r10, Continuation r11) {
            this.f1815a = r5;
            this.f1816b = r10;
            super(2, r11);
        }

        public static final Unit a(WidgetContainer r5) {
            String r10 = null;
            if (r5 == null) goto L19;
            h r11 = r5.f;
            if (r11 == null) goto L7;
            String r12 = r11.d;
        L8:
            Intrinsics.checkNotNullParameter("", "ctx");
            ConcurrentHashMap r13 = r5.f3028o;
            if (r12 != null) goto L16;
            h r14 = r5.f;
            if (r14 == null) goto L13;
            r12 = r14.d;
        L14:
            if (r12 != null) goto L16;
            r12 = r5.f3029p;
            goto L16
        L13:
            r12 = null;
        L16:
            r13.put(r12, "");
            Function1 r15 = r5.f3030q;
            if (r15 == null) goto L19;
            r15.invoke(r5);
            goto L19
        L7:
            r12 = null;
        L19:
            if (r5 == null) goto L26;
            h r16 = r5.f;
            if (r16 == null) goto L23;
            r10 = r16.d;
        L23:
            if (r10 == null) goto L26;
            Lazy r17 = p.f2292a;
            Intrinsics.checkNotNullParameter(r10, "botId");
            p.f(new b2.c(r10, 3));
        L26:
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r5, Continuation r10) {
            return new AnonymousClass1(this.f1815a, this.f1816b, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            n1.c r11 = this.f1815a;
            f r12 = this.f1816b;
            return new AnonymousClass1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v13, types: [T, com.bytedance.ai.bridge.method.floatinginput.b] */
        /* JADX WARN: Type inference failed for: r4v27, types: [T, com.bytedance.ai.bridge.method.floatinginput.b] */
        /* JADX WARN: Type inference failed for: r4v4, types: [T, com.bytedance.ai.bridge.method.floatinginput.c] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            final int r5 = 1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r10);
            final Ref.ObjectRef r11 = new Ref.ObjectRef();
            Ref.ObjectRef r12 = new Ref.ObjectRef();
            j r13 = (j) ((n1.a) this.f1815a).b(j.class);
            if (r13 == null) goto L5;
            ContainerType r14 = r13.d();
        L7:
            if (r14 != null) goto L9;
            int r15 = -1;
        L11:
            if (r15 == (-1)) goto L54;
            if (r15 != 1) goto L14;
            final WidgetContainer r16 = (WidgetContainer) ((n1.a) this.f1815a).b(WidgetContainer.class);
            if (r16 == null) goto L51;
            T r17 = r16.f3018a;
        L52:
            r11.element = r17;
            r12.element = new c(r16);
            goto L54
        L51:
            r17 = 0;
            goto L52
        L14:
            if (r15 != 2) goto L16;
            final w0.f r18 = (w0.f) ((n1.a) this.f1815a).b(w0.f.class);
            Lazy r19 = p.f2292a;
            if (r18 == null) goto L40;
            PageInfo r20 = ((com.bytedance.ai.model.widgets.a) r18).f2330b;
            if (r20 == null) goto L40;
            String r21 = r20.getBotId();
        L41:
            if (r21 == null) goto L46;
            ConcurrentHashMap r22 = o2.a.f20402a;
            Intrinsics.checkNotNullParameter(r21, "<this>");
            if (r21.length() == 0) goto L46;
            T r23 = (String) o2.a.f20402a.get(r21);
        L47:
            r11.element = r23;
            r12.element = new b(r18, r11, r5);
        L46:
            r23 = 0;
        L40:
            r21 = null;
            goto L41
        L16:
            if (r15 != 3) goto L18;
            final AppletRuntime r24 = (AppletRuntime) ((n1.a) this.f1815a).b(AppletRuntime.class);
            Lazy r25 = p.f2292a;
            if (r24 == null) goto L27;
            Applet r26 = r24.f2197h;
            if (r26 == null) goto L27;
            String r27 = r26.I;
        L28:
            if (r27 == null) goto L33;
            ConcurrentHashMap r28 = o2.a.f20402a;
            Intrinsics.checkNotNullParameter(r27, "<this>");
            if (r27.length() == 0) goto L33;
            T r29 = (String) o2.a.f20402a.get(r27);
        L34:
            r11.element = r29;
            final int r30 = 0;
            r12.element = new b(r24, r11, r30);
        L33:
            r29 = 0;
        L27:
            r27 = null;
            goto L28
        L18:
            if (r15 == 4) goto L54;
            throw new NoWhenBranchMatchedException();
        L54:
            if (((String) r11.element) != null) goto L56;
        L60:
            f r31 = this.f1816b;
            Intrinsics.checkNotNullParameter(AbsClearContextMethodIDL.ClearContextResultModal.class, "<this>");
            r31.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsClearContextMethodIDL.ClearContextResultModal.class), "");
            return Unit.INSTANCE;
        L56:
            if (Intrinsics.areEqual(null, Boxing.boxBoolean(true)) == false) goto L60;
            Function0 r32 = (Function0) r12.element;
            if (r32 == null) goto L60;
            r32.invoke();
            goto L60
        L9:
            r15 = d.f1828a[r14.ordinal()];
            goto L11
        L5:
            r14 = null;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final Unit a(w0.f r5, Ref.ObjectRef r10) {
            if (r5 == null) goto L8;
            AppletRuntime r11 = ((com.bytedance.ai.model.widgets.a) r5).f2329a;
            if (r11 == null) goto L8;
            String r12 = (String) r10.element;
            if (r12 == null) goto L8;
            Intrinsics.checkNotNullParameter(r12, "sessionId");
            g r13 = (g) r11.f2206q.get(r12);
        L8:
            if (r5 == null) goto L15;
            PageInfo r14 = ((com.bytedance.ai.model.widgets.a) r5).f2330b;
            if (r14 == null) goto L15;
            String r15 = r14.getBotId();
            if (r15 == null) goto L15;
            Lazy r16 = p.f2292a;
            Intrinsics.checkNotNullParameter(r15, "botId");
            p.f(new b2.c(r15, 3));
        L15:
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final Unit a(AppletRuntime r5, Ref.ObjectRef r10) {
            if (r5 == null) goto L6;
            String r11 = (String) r10.element;
            if (r11 == null) goto L6;
            Intrinsics.checkNotNullParameter(r11, "sessionId");
            g r12 = (g) r5.f2206q.get(r11);
        L6:
            if (r5 == null) goto L13;
            Applet r13 = r5.f2197h;
            if (r13 == null) goto L13;
            String r14 = r13.I;
            if (r14 == null) goto L13;
            Lazy r15 = p.f2292a;
            Intrinsics.checkNotNullParameter(r14, "botId");
            p.f(new b2.c(r14, 3));
        L13:
            return Unit.INSTANCE;
        }
    }

    public ClearContextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsClearContextMethodIDL.ClearContextParamModal) r10, r11);
    }

    public void handle(n1.c r10, AbsClearContextMethodIDL.ClearContextParamModal r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AnonymousClass1(r10, r12, null), 3, null);
    }
}
