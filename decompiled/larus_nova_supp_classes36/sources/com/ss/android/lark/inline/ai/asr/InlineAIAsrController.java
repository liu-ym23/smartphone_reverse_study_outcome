package com.ss.android.lark.inline.ai.asr;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larksuite.arch.jack.JackView;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.l;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.api.Template;
import com.ss.android.lark.inline.ai.api.Templates;
import com.ss.android.lark.inline.ai.api.ui.Operate;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.asr.subprompt.SubPromptAdapter;
import com.ss.android.lark.inline.ai.logic.InlineAIRustPbWrapper;
import com.ss.android.lark.inline.ai.logic.InlineAIStatus;
import com.ss.android.lark.inline.ai.logic.h;
import com.ss.android.lark.inline.ai.utils.StringUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.pb.office_ai_inline.QuickAction;
import com.ss.android.lark.pb.office_ai_inline.QuickActionParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.i;
import slb.j;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0003HIJB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\rJ\u0006\u0010)\u001a\u00020$J\u000e\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\b\u0010+\u001a\u00020$H\u0007J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0007J\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\f\u00107\u001a\b\u0012\u0004\u0012\u0002020\nH\u0002J(\u00108\u001a\u00020$2\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020&0:j\b\u0012\u0004\u0012\u00020&`;2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010<\u001a\u00020$2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010?2\u0006\u0010E\u001a\u000205H\u0002J\u0006\u0010F\u001a\u000205J\u0006\u0010G\u001a\u000205R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u001f\u0010\u0015R\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006K"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/InlineAIAsrController;", "Lcom/larksuite/arch/jack/JackView;", "Landroidx/lifecycle/LifecycleObserver;", "inlineAIParams", "Lcom/ss/android/lark/inline/ai/api/InlineAIParams;", "<init>", "(Lcom/ss/android/lark/inline/ai/api/InlineAIParams;)V", "asrView", "Lcom/ss/android/lark/inline/ai/asr/InlineAIAsrView;", "promptGroups", "", "Lcom/ss/android/lark/inline/ai/api/PromptGroup;", "aIAsrCallback", "Lcom/ss/android/lark/inline/ai/api/asr/IInlineAIAsrCallback;", "aIAsrProvider", "Lcom/ss/android/lark/inline/ai/api/asr/IInlineAIAsrProvider;", "inlineAIReport", "Lcom/ss/android/lark/inline/ai/report/InlineAIReport;", "isShowing", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "isShowing$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/ss/android/lark/inline/ai/asr/InlineAIAsrViewModel;", "destroyed", "inlineAIState", "Lcom/ss/android/lark/inline/ai/logic/InlineAIState;", "runningScope", "Lkotlinx/coroutines/CoroutineScope;", "isEnable", "isEnable$delegate", "getPrompts", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showPanel", "", "prompt", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "provider", "callback", "hidePanel", "applyPrompt", "onDestroy", "toastError", "code", "", "buildTemplates", "Lcom/ss/android/lark/inline/ai/api/Templates;", "quickAction", "Lcom/ss/android/lark/pb/office_ai_inline/QuickAction;", "getIconRes", TabAppInfo.IMAGE_JSON_KEY, "", "convertToPromptGroups", "quickActions", "addPromptByPriority", "promptList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addDebugButton", "operateButtons", "", "Lcom/ss/android/lark/inline/ai/api/OperateButton;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "findOperateButtonById", "id", "getCurrentStatus", "getCurrentCommandType", "Companion", "SubPromptClickListener", "UIOperateCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InlineAIAsrController implements JackView, LifecycleObserver {
    public static final ScenarioType k = null;
    public final slb.g a;
    public final com.ss.android.lark.inline.ai.asr.c b;
    public volatile List<m> c;
    public final zlb.a d;
    public final Lazy e;
    public final InlineAIAsrViewModel f;
    public volatile boolean g;
    public com.ss.android.lark.inline.ai.logic.f h;
    public final CoroutineScope i;
    public final Lazy j;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.asr.InlineAIAsrController$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.inline.ai.asr.InlineAIAsrController$3", f = "InlineAIAsrController.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InlineAIAsrController this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.asr.InlineAIAsrController$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ InlineAIAsrController a;

            public a(InlineAIAsrController r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                int r5 = ((Number) r3).intValue();
                InlineAIAsrController r6 = this.a;
                ScenarioType r0 = InlineAIAsrController.k;
                r6.getClass();
                Log.i("InlineAIAsrController", "toastError, code = " + r5);
                FragmentActivity r7 = r6.a.getActivity();
                StringUtils.a.getClass();
                UDToast.makeToast(r7, StringUtils.b(r5), 2131256189).show();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(InlineAIAsrController r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            d1<Integer> r6 = this.this$0.f.getErrorCodeFlow();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.asr.InlineAIAsrController$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.inline.ai.asr.InlineAIAsrController$5", f = "InlineAIAsrController.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InlineAIAsrController this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.asr.InlineAIAsrController$5$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ InlineAIAsrController a;

            public a(InlineAIAsrController r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                if (((Boolean) r1).booleanValue() == false) goto L6;
                this.a.d.b();
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass5(InlineAIAsrController r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass5(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            i1 r6 = (i1) this.this$0.e.getValue();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a implements slb.e.a {
        public final /* synthetic */ InlineAIAsrController a;

        public a(InlineAIAsrController r1) {
            this.a = r1;
        }

        @Override // slb.e.a
        public final void onError(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            Log.i("InlineAIAsrController", "getQuickAction onError, error = " + r3);
        }

        @Override // slb.e.a
        public final void onSuccess(List<QuickAction> r3) {
            Intrinsics.checkNotNullParameter(r3, "quickActions");
            Log.i("InlineAIAsrController", "getQuickAction onSuccess, quickActions = " + r3);
            InlineAIAsrController r0 = this.a;
            ScenarioType r1 = InlineAIAsrController.k;
            r0.c = r0.b(r3);
        }
    }

    public static final class b {
    }

    public final class c implements SubPromptAdapter.a {
        public final /* synthetic */ InlineAIAsrController a;

        public c(InlineAIAsrController r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.inline.ai.asr.subprompt.SubPromptAdapter.a
        public final void a(j r3) {
            Intrinsics.checkNotNullParameter(r3, "prompt");
            Log.i("InlineAIAsrController", "onOperateClick prompt : " + r3);
            this.a.f.startNewTaskForSubPrompt(r3);
        }
    }

    public final class d implements wlb.e {
        public final /* synthetic */ InlineAIAsrController a;

        @Override // wlb.e
        public final void a(int r1) {
        }

        @Override // wlb.e
        public final void b(boolean r1) {
        }

        @Override // wlb.e
        public final void d() {
        }

        @Override // wlb.e
        public final String g() {
            return "";
        }

        @Override // wlb.e
        public final void h(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
        }

        @Override // wlb.e
        public final void j(Object r3) {
            Intrinsics.checkNotNullParameter("ccm_res", "type");
            Intrinsics.checkNotNullParameter(r3, "data");
        }

        @Override // wlb.e
        public final void l(boolean r1, wlb.b r2) {
        }

        @Override // wlb.e
        public final void m(Prompt r2) {
            Intrinsics.checkNotNullParameter(r2, "prompt");
        }

        @Override // wlb.e
        public final void n(boolean r1) {
        }

        @Override // wlb.e
        public final void onInputTextChange(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
        }

        @Override // wlb.e
        public final void p(boolean r1) {
        }

        @Override // wlb.e
        public final void q(Prompt r2) {
            Intrinsics.checkNotNullParameter(r2, "prompt");
        }

        @Override // wlb.e
        public final void r() {
        }

        @Override // wlb.e
        public final void s(String r2) {
            Intrinsics.checkNotNullParameter(r2, "closeType");
        }

        @Override // wlb.e
        public final void e() {
            this.a.f.cancelCurrentTask();
        }

        public d(InlineAIAsrController r1) {
            this.a = r1;
        }

        @Override // wlb.e
        public final void f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
        }

        @Override // wlb.e
        public final void i(String r4) {
            Intrinsics.checkNotNullParameter(r4, "closeType");
            this.a.f.hidePanel();
            InlineAIAsrController r0 = this.a;
            r0.d.e(r4, r0.e(), this.a.c());
        }

        @Override // wlb.e
        public final void k(Operate r8) {
            Intrinsics.checkNotNullParameter(r8, "operate");
            Log.i("InlineAIAsrController", "onClickOperation operate: " + r8);
            InlineAIAsrController r0 = this.a;
            String r9 = r8.getType();
            com.ss.android.lark.inline.ai.logic.f r1 = r0.h;
            com.ss.android.lark.inline.ai.logic.f r3 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r1 = null;
        L5:
            h r2 = com.ss.android.lark.inline.ai.logic.g.a(r1);
            if (r2 == null) goto L15;
            List<? extends slb.h> r4 = r2.h;
            if (r4 == null) goto L15;
            Iterator<T> r5 = r4.iterator();
            slb.h r6 = null;
        L11:
            if (r5.hasNext() == false) goto L16;
            slb.h r7 = (slb.h) r5.next();
            if (Intrinsics.areEqual(r7.a, r9) == false) goto L11;
            r6 = r7;
        L16:
            if (r6 != null) goto L19;
            Log.e("InlineAIAsrController", "onClickOperation, can not find operate!");
            return;
        L19:
            Function2<String, String, Unit> r10 = r6.c;
            if (r10 == null) goto L29;
            String r11 = r6.a;
            com.ss.android.lark.inline.ai.logic.f r12 = this.a.h;
            if (r12 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r12 = null;
        L24:
            h r13 = com.ss.android.lark.inline.ai.logic.g.a(r12);
            if (r13 == null) goto L27;
            String r14 = r13.d;
        L28:
            r10.invoke(r11, r14);
            goto L29
        L27:
            r14 = null;
        L29:
            InlineAIAsrController r15 = this.a;
            zlb.a r16 = r15.d;
            String r17 = r6.a;
            String r18 = r15.c();
            com.ss.android.lark.inline.ai.logic.f r19 = this.a.h;
            if (r19 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        L33:
            r16.f(r17, r18, com.ss.android.lark.inline.ai.logic.g.b(r3));
            return;
        L32:
            r3 = r19;
        L15:
            r6 = null;
            goto L16
        }

        @Override // wlb.e
        public final void o(Map<String, Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "downloadRes");
        }

        @Override // wlb.e
        public final void t(String r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
        }

        @Override // wlb.e
        public final void c(String r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "id");
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[InlineAIStatus.values().length];
            r0[InlineAIStatus.Waiting.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[InlineAIStatus.PrepareWaiting.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[InlineAIStatus.Writing.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[InlineAIStatus.Finished.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class f implements slb.e.a {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ i<List<QuickAction>> b;

        @Override // slb.e.a
        public final void onError(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            if (this.a.element == false) goto L6;
            Log.i("InlineAIAsrController", "getPrompt onError canceled");
            return;
        L6:
            i<List<QuickAction>> r0 = this.b;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r3)));
        }

        @Override // slb.e.a
        public final void onSuccess(List<QuickAction> r2) {
            Intrinsics.checkNotNullParameter(r2, "quickActions");
            if (this.a.element == false) goto L6;
            Log.i("InlineAIAsrController", "getPrompt onSuccess canceled");
            return;
        L6:
            this.b.resumeWith(Result.constructor-impl(r2));
        }

        public f(Ref.BooleanRef r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public final com.larksuite.arch.jack.i getLifecycleOwnerHolder() {
        return this;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.g = true;
        this.f.onDestroy();
    }

    static {
        k = ScenarioType.VoiceInput;
    }

    public final String c() {
        com.ss.android.lark.inline.ai.logic.f r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        r0 = null;
    L5:
        h r1 = com.ss.android.lark.inline.ai.logic.g.a(r0);
        if (r1 == null) goto L13;
        String r2 = r1.f.getType();
        if (r2.length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L15;
        return "user_prompt";
    L15:
        return r2;
    L10:
        r3 = false;
        goto L11
    L13:
        return "";
    }

    public final String e() {
        com.ss.android.lark.inline.ai.logic.f r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        r0 = null;
    L5:
        InlineAIStatus r1 = r0.a;
        int r2 = e.a[r1.ordinal()];
        if (r2 != 1) goto L8;
        return "waiting";
    L8:
        if (r2 != 2) goto L10;
    L15:
        return "writing";
    L10:
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L14;
        return "";
    L14:
        return "finished";
    }

    public final Lifecycle getLifecycle() {
        return this.a.b.getLifecycle();
    }

    public InlineAIAsrController(slb.g r12) {
        Intrinsics.checkNotNullParameter(r12, "inlineAIParams");
        this.a = r12;
        this.b = new com.ss.android.lark.inline.ai.asr.c(r12, new d(this), new c(this));
        ScenarioType r1 = k;
        zlb.a r0 = new zlb.a(r1);
        this.d = r0;
        this.e = LazyKt.lazy(new InlineAIAsrController$isShowing$2(this));
        InlineAIAsrViewModel r2 = new ViewModelProvider(r12.c, new InlineAIAsrController$viewModel$1(this)).get(InlineAIAsrViewModel.class);
        this.f = r2;
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.i = r3;
        r2.initialize(new AnonymousClass1(this));
        r2.init();
        com.larksuite.arch.jack.f.a.h(this, r2, new AnonymousClass2(this));
        r12.b.getLifecycle().addObserver(this);
        BuildersKt.launch$default(r3, null, null, new AnonymousClass3(this, null), 3, null);
        r0.a = new AnonymousClass4(this);
        BuildersKt.launch$default(r3, null, null, new AnonymousClass5(this, null), 3, null);
        List<slb.d.a> r13 = InlineAIRustPbWrapper.a;
        InlineAIRustPbWrapper.c(r1, MapsKt.emptyMap(), new a(this));
        this.j = LazyKt.lazy(new InlineAIAsrController$isEnable$2(this));
    }

    public final List<m> b(List<QuickAction> r21) {
        if (r21.isEmpty() == false) goto L6;
        return null;
    L6:
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<T> r2 = r21.iterator();
    L8:
        if (r2.hasNext() == false) goto L67;
        QuickAction r4 = (QuickAction) r2.next();
        Gson r0 = com.ss.android.lark.inline.ai.asr.a.a;
        Map r5 = com.ss.android.lark.inline.ai.asr.a.C0100a.a(r4.mextra_map);
        Object r3 = r5.get(TabAppInfo.IMAGE_JSON_KEY);
        if (r3 == null) goto L15;
        String r6 = r3.toString();
        if (r6 == null) goto L15;
        String r7 = r6;
    L16:
        String r9 = r4.mid;
        Map r8 = r4.mextra_map;
        Intrinsics.checkNotNullParameter(r8, "extraMap");
        String r10 = (String) r8.get("Comment");
        if (r10 != null) goto L19;
    L22:
        boolean r11 = true;
    L24:
        if (r11 == false) goto L26;
        Log.i("AsrExtra", "extra comment is empty");
        com.ss.android.lark.inline.ai.asr.a r12 = new com.ss.android.lark.inline.ai.asr.a();
    L42:
        String r13 = r12.a();
        Intrinsics.checkNotNullParameter(r13, TabAppInfo.IMAGE_JSON_KEY);
        if (Intrinsics.areEqual(r13, "EfficiencyOutlined") == false) goto L46;
    L48:
        int r14 = 2131255763;
    L49:
        String r15 = r4.mname;
        Object r16 = r5.get(TabAppInfo.IMAGE_JSON_KEY);
        if (r16 == null) goto L55;
        String r17 = r16.toString();
        if (r17 == null) goto L55;
        String r18 = r17;
    L56:
        List r19 = r4.mparam_details;
        ArrayList r20 = new ArrayList();
        Iterator r22 = r19.iterator();
    L58:
        if (r22.hasNext() == false) goto L62;
        Object r23 = r22.next();
        if (((QuickActionParam) r23).mneed_confirm.booleanValue() == false) goto L58;
        r20.add(r23);
        goto L58
    L62:
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r25 = r20.iterator();
    L64:
        if (r25.hasNext() == false) goto L66;
        QuickActionParam r26 = (QuickActionParam) r25.next();
        r24.add(new Template(r26.mdisplay_name, r26.mplace_holder, r26.mname, null, 8, null));
        goto L64
    L66:
        Templates r110 = new Templates(r4.mname, new ArrayList(r24));
        Gson r27 = com.ss.android.lark.inline.ai.asr.a.a;
        r1.put(r7, new j(r9, r18, r14, r15, r110, com.ss.android.lark.inline.ai.asr.a.C0100a.a(r4.mextra_map), null, new InlineAIAsrController$convertToPromptGroups$1$1$1(this), null, 320));
    L55:
        r18 = "";
        goto L56
    L46:
        if (Intrinsics.areEqual(r13, "EffectsOutlined") == false) goto L48;
        r14 = 2131254291;
        goto L49
    L26:
        Gson r28 = com.ss.android.lark.inline.ai.asr.a.a;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L32
        com.ss.android.lark.inline.ai.asr.a r29 = (com.ss.android.lark.inline.ai.asr.a) r28.fromJson(r10, com.ss.android.lark.inline.ai.asr.a.class);     // Catch: Throwable -> L32
        if (r29 != null) goto L30;
        r29 = new com.ss.android.lark.inline.ai.asr.a();     // Catch: Throwable -> L32
    L30:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r30) == false) goto L38;
        Log.e("AsrExtra", "parse json failed", Result.exceptionOrNull-impl(r30));
    L38:
        if (Result.exceptionOrNull-impl(r30) == null) goto L41;
        r30 = new com.ss.android.lark.inline.ai.asr.a();
    L41:
        r12 = (com.ss.android.lark.inline.ai.asr.a) r30;
    L32:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L19:
        if (r10.length() == 0) goto L22;
        r11 = false;
    L15:
        r7 = "";
        goto L16
    L67:
        ArrayList r32 = new ArrayList();
        Iterator r33 = r1.entrySet().iterator();
    L69:
        if (r33.hasNext() == false) goto L88;
        Map.Entry r34 = (Map.Entry) r33.next();
        Object r35 = ((j) r34.getValue()).f.get("parent_key");
        if (r35 == null) goto L74;
        String r36 = r35.toString();
        if (r36 == null) goto L74;
    L76:
        if (TextUtils.isEmpty(r36) == true) goto L77;
        j r37 = (j) r1.get(r36);
        if (r37 == null) goto L69;
        if (r37.g != null) goto L83;
        r37.g = new ArrayList();
    L83:
        ArrayList<j> r38 = r37.g;
        if (r38 != null) goto L86;
        r38 = new ArrayList();
    L86:
        a(r38, (j) r34.getValue());
        goto L69
    L77:
        a(r32, (j) r34.getValue());
    L74:
        r36 = "";
        goto L76
    L88:
        return CollectionsKt.listOf(new m("base", r32));
    }

    public final Object f(Continuation<? super List<m>> r9) {
        if ((r9 instanceof InlineAIAsrController$getPrompts$1) == false) goto L7;
        InlineAIAsrController$getPrompts$1 r0 = (InlineAIAsrController$getPrompts$1) r9;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        long r4 = r0.J$0;
        InlineAIAsrController$getPrompts$1 r5 = (InlineAIAsrController$getPrompts$1) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
    L29:
        Object r11 = Result.constructor-impl((List) r10);     // Catch: Throwable -> L14
    L34:
        long r6 = SystemClock.uptimeMillis() - r4;
        if (Result.isFailure-impl(r11) == false) goto L37;
        Object r7 = null;
    L38:
        List<QuickAction> r8 = (List) r7;
        if (r8 == null) goto L41;
        this.c = b(r8);
    L43:
        return this.c;
    L41:
        Log.e("InlineAIAsrController", "fetchQuickActions result empty,duration:" + r6, Result.exceptionOrNull-impl(r11));
        goto L43
    L37:
        r7 = r11;
    L14:
        th = th;
        long r12 = r4;
    L33:
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        r4 = r12;
        goto L34
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        if (this.c != null) goto L21;
        r12 = SystemClock.uptimeMillis();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L32
        r0.L$0 = r0;     // Catch: Throwable -> L32
        r0.J$0 = r12;     // Catch: Throwable -> L32
        r0.label = 1;     // Catch: Throwable -> L32
        kotlinx.coroutines.j r15 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L32
        r15.C();     // Catch: Throwable -> L32
        final Ref.BooleanRef r16 = new Ref.BooleanRef();     // Catch: Throwable -> L32
        r15.i(new InlineAIAsrController$getPrompts$result$1$1$1(r16));     // Catch: Throwable -> L32
        List<slb.d.a> r17 = InlineAIRustPbWrapper.a;     // Catch: Throwable -> L32
        InlineAIRustPbWrapper.c(k, MapsKt.emptyMap(), new f(r16, r15));     // Catch: Throwable -> L32
        r10 = r15.B();     // Catch: Throwable -> L32
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L32
    L26:
        if (r10 != r2) goto L28;
        return r2;
    L28:
        r4 = r12;
    L32:
        th = th;
        goto L33
    L21:
        return this.c;
    L7:
        r0 = new InlineAIAsrController$getPrompts$1(this, r9);
        goto L8
    }

    public static void a(ArrayList r10, j r11) {
        if (r10.isEmpty() == false) goto L5;
        r10.add(r11);
        return;
    L5:
        Object r0 = r11.f.get("priority");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Double");
        double r3 = ((Double) r0).doubleValue();
        Iterator r1 = r10.iterator();
        int r5 = 0;
        int r6 = 0;
    L7:
        if (r1.hasNext() == false) goto L15;
        Object r7 = r1.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        Object r9 = ((j) r7).f.get("priority");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Double");
        if (r3 <= ((Double) r9).doubleValue()) goto L14;
        r5 = r5 + 1;
    L14:
        r6 = r8;
        goto L7
    L15:
        ListProtector.add(r10, r5, r11);
    }

    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r1, l<S> r2, Function1<? super S, Unit> r3) {
        return JackView.a.d(this, r1, r2, r3);
    }

    public final com.larksuite.arch.jack.c Ik(JackViewModel r1, PropertyReference1Impl r2, l r3, Function1 r4) {
        return JackView.a.a(this, r1, r2, r3, r4);
    }

    public final com.larksuite.arch.jack.c Ki(JackViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, l r4, Function1 r5) {
        return JackView.a.b(this, r1, r2, r3, r4, r5);
    }

    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, PropertyReference1Impl r4, l r5, Function1 r6) {
        return JackView.a.c(this, r1, r2, r3, r4, r5, r6);
    }
}
