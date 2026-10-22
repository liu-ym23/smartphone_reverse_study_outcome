package com.bytedance.ai.ex.widget.jsb;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.ex.widget.WidgetRenderService;
import com.bytedance.ai.ex.widget.donate.EntityType;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.h;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/ex/widget/jsb/AddBizEntityMethod;", "Lcom/bytedance/ai/ex/widget/jsb/AbsAddBizEntityMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/ex/widget/jsb/AbsAddBizEntityMethodIDL$AddBizEntityMethodParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/ex/widget/jsb/AbsAddBizEntityMethodIDL$AddBizEntityMethodResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/ex/widget/jsb/AbsAddBizEntityMethodIDL$AddBizEntityMethodParamModel;Lo1/f;)V", "Companion", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AddBizEntityMethod extends AbsAddBizEntityMethodIDL {
    public static final Companion Companion = null;
    private static final Map<String, MutableLiveData<AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel>> donateCallback = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/ex/widget/jsb/AddBizEntityMethod$Companion;", "", "<init>", "()V", "donateCallback", "", "", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ai/ex/widget/jsb/AbsAddBizEntityMethodIDL$AddBizEntityMethodParamModel;", "getDonateCallback", "()Ljava/util/Map;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Map<String, MutableLiveData<AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel>> getDonateCallback() {
            return AddBizEntityMethod.access$getDonateCallback$cp();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.jsb.AddBizEntityMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.jsb.AddBizEntityMethod$handle$1", f = "AddBizEntityMethod.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"findWidgetBlock"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nAddBizEntityMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddBizEntityMethod.kt\ncom/bytedance/ai/ex/widget/jsb/AddBizEntityMethod$handle$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,63:1\n1#2:64\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ c $bridgeContext;
        final /* synthetic */ f $callback;
        final /* synthetic */ AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel $params;
        Object L$0;
        int label;

        public AnonymousClass1(AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel r5, f r10, c r11, Continuation<? super AnonymousClass1> r12) {
            this.$params = r5;
            this.$callback = r10;
            this.$bridgeContext = r11;
            super(2, r12);
        }

        public static /* synthetic */ com.bytedance.ai.widget.contianer.f b(c r5) {
            return invokeSuspend$lambda$0(r5);
        }

        private static final com.bytedance.ai.widget.contianer.f invokeSuspend$lambda$0(c r5) {
            return WidgetRenderService.INSTANCE.findWidgetContainerByView(((n1.a) r5).a());
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass1(this.$params, this.$callback, this.$bridgeContext, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            Function0 r12 = (Function0) this.L$0;
            ResultKt.throwOnFailure(r5);
        L16:
            com.bytedance.ai.widget.contianer.f r13 = (com.bytedance.ai.widget.contianer.f) r12.invoke();
        L17:
            if (r13 == null) goto L28;
            h r14 = ((WidgetContainer) r13).f;
            if (r14 == null) goto L21;
            String r15 = r14.e;
        L22:
            if (r15 == null) goto L28;
            MutableLiveData<AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel> r16 = AddBizEntityMethod.Companion.getDonateCallback().get(r15);
            if (r16 == null) goto L28;
            r16.postValue(this.$params);
            goto L28
        L21:
            r15 = null;
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            if (EntityType.Companion.fromValue(this.$params.getEntityTpe()) == null) goto L26;
            f r17 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsAddBizEntityMethodIDL.AddBizEntityMethodResultModel.class, "<this>");
            r17.b((ResultModel) e.c(AbsAddBizEntityMethodIDL.AddBizEntityMethodResultModel.class), "");
            final c r18 = this.$bridgeContext;
            Function0 r19 = new a(r18);
            r13 = invokeSuspend$lambda$0(r18);
            if (r13 != null) goto L17;
            this.L$0 = r19;
            this.label = 1;
            if (DelayKt.delay(500, this) != r10) goto L15;
            return r10;
        L15:
            r12 = r19;
            goto L16
        L26:
            f r20 = this.$callback;
            String r21 = this.$params.getEntityTpe() + " 不支持";
            Intrinsics.checkNotNullParameter(AbsAddBizEntityMethodIDL.AddBizEntityMethodResultModel.class, "<this>");
            r20.c(r21, (ResultModel) e.c(AbsAddBizEntityMethodIDL.AddBizEntityMethodResultModel.class));
            goto L28
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        Companion = new Companion(null);
        donateCallback = new LinkedHashMap();
    }

    public AddBizEntityMethod() {
    }

    public static final /* synthetic */ Map access$getDonateCallback$cp() {
        return donateCallback;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel) r10, r11);
    }

    public void handle(c r10, AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(h0.a(Dispatchers.getDefault()), null, null, new AnonymousClass1(r11, r12, r10, null), 3, null);
    }
}
