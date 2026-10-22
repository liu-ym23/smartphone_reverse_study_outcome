package com.ss.android.lark.inline.ai.logic;

import android.R;
import android.content.DialogInterface;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.arch.jack.JackView;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.LockType;
import com.ss.android.lark.inline.ai.api.MaskType;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.api.Templates;
import com.ss.android.lark.inline.ai.api.ui.FeedbackConfig;
import com.ss.android.lark.inline.ai.api.ui.Operate;
import com.ss.android.lark.inline.ai.api.ui.ParamResultDetail;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.api.ui.TextResultContentList;
import com.ss.android.lark.inline.ai.ui.IInlineAIUISdkImpl;
import com.ss.android.lark.inline.ai.utils.StringUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;
import slb.l;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0002MNB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001fJ\u001e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00102\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u0006\u0010/\u001a\u00020)J\b\u00100\u001a\u00020)H\u0007J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000eH\u0002J\u0019\u00107\u001a\u00020\u001f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u00109J\u0019\u0010:\u001a\u00020\f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010;J\u0012\u0010<\u001a\u0004\u0018\u00010\u00102\u0006\u0010=\u001a\u00020\u001fH\u0002J\u0012\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u001fH\u0002J\u0010\u0010A\u001a\u0002052\u0006\u00106\u001a\u00020\u000eH\u0002J\u0010\u0010B\u001a\u0002052\u0006\u00106\u001a\u00020\u000eH\u0002J\u0010\u0010C\u001a\u0002052\u0006\u00106\u001a\u00020\u000eH\u0002J\u000e\u0010H\u001a\u00020)2\u0006\u0010.\u001a\u00020\u0010J\u0006\u0010I\u001a\u00020\u001fJ\u0006\u0010J\u001a\u00020\u001fJ\u000e\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0015\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010!R!\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b&\u0010\u0017R\u0014\u0010D\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006O"}, d2 = {"Lcom/ss/android/lark/inline/ai/logic/InlineAIController;", "Lcom/larksuite/arch/jack/JackView;", "Landroidx/lifecycle/LifecycleObserver;", "inlineAIParams", "Lcom/ss/android/lark/inline/ai/api/InlineAIParams;", "<init>", "(Lcom/ss/android/lark/inline/ai/api/InlineAIParams;)V", "inlineAIUISdk", "Lcom/ss/android/lark/inline/ai/ui/IInlineAIUISdkImpl;", "viewModel", "Lcom/ss/android/lark/inline/ai/logic/InlineAIViewModel;", "destroyed", "", "inlineAIState", "Lcom/ss/android/lark/inline/ai/logic/InlineAIState;", "lastClickPrompt", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "showingSubPromptGroups", "", "", "Lcom/ss/android/lark/inline/ai/api/PromptGroup;", "isShowing", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "isShowing$delegate", "Lkotlin/Lazy;", "runningScope", "Lkotlinx/coroutines/CoroutineScope;", "inlineAIReport", "Lcom/ss/android/lark/inline/ai/report/InlineAIReport;", "waitingPlaceHolder", "", "getWaitingPlaceHolder", "()Ljava/lang/String;", "writingPlaceHolder", "getWritingPlaceHolder", "finishedPlaceHolder", "getFinishedPlaceHolder", "isEnable", "isEnable$delegate", "showPanel", "", "promptGroups", "hidePanel", "quitType", "sendPrompt", "prompt", "retryCurrentPrompt", "onDestroy", "toastError", "code", "", "generateWaitingPanel", "Lcom/ss/android/lark/inline/ai/api/ui/InlineAIPanel;", "state", "getMaskType", "isPreviewMode", "(Ljava/lang/Boolean;)Ljava/lang/String;", "getLockType", "(Ljava/lang/Boolean;)Z", "findPromptById", "localId", "findOperateButtonById", "Lcom/ss/android/lark/inline/ai/api/OperateButton;", "id", "generatePrepareWaitingPanel", "generateWritingPanel", "generateFinishedPanel", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "applyPrompt", "getCurrentStatus", "getCurrentCommandType", "getFeedbackType", "like", "Companion", "UIOperateCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InlineAIController implements JackView, LifecycleObserver {
    public static final /* synthetic */ int k = 0;
    public final slb.g a;
    public final IInlineAIUISdkImpl b;
    public final InlineAIViewModel c;
    public volatile boolean d;
    public f e;
    public slb.j f;
    public final List<List<m>> g;
    public final Lazy h;
    public final zlb.a i;
    public final Lazy j;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.InlineAIController$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.inline.ai.logic.InlineAIController$3", f = "InlineAIController.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InlineAIController this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.InlineAIController$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ InlineAIController a;

            public a(InlineAIController r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                int r5 = ((Number) r3).intValue();
                InlineAIController r6 = this.a;
                int r0 = InlineAIController.k;
                r6.getClass();
                Log.i("InlineAIController", "toastError, code = " + r5);
                FragmentActivity r7 = r6.a.getActivity();
                StringUtils.a.getClass();
                UDToast.makeToast(r7, StringUtils.b(r5), 2131256189).show();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(InlineAIController r1, Continuation<? super AnonymousClass3> r2) {
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
            d1<Integer> r6 = this.this$0.c.getErrorCodeFlow();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.InlineAIController$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.inline.ai.logic.InlineAIController$4", f = "InlineAIController.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InlineAIController this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.InlineAIController$4$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ InlineAIController a;

            public a(InlineAIController r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                Pair r5 = (Pair) r3;
                Log.i("InlineAIController", "getDebugInfo getDebugCodeFlow, code = " + r5 + ".first, info = " + ((String) r5.getSecond()));
                if (((Number) r5.getFirst()).intValue() != 0) goto L8;
                StringBuilder r6 = new StringBuilder();
                r6.append((String) r5.getSecond());
                r6.append("\n\nInlineAIState is\n");
                f r7 = this.a.e;
                if (r7 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
                r7 = null;
            L7:
                r6.append(g.c(r7));
                String r8 = r6.toString();
                new UDDialogBuilder(this.a.a.getActivity()).message(r8).addActionButton(2131391777, R.string.copy, new com.ss.android.lark.inline.ai.logic.c(this.a, r8)).addActionButton(2131391778, R.string.cancel, d.a).show();
            L10:
                return Unit.INSTANCE;
            L8:
                UDToast.show(this.a.a.getActivity(), 2131892995);
                goto L10
            }
        }

        public AnonymousClass4(InlineAIController r1, Continuation<? super AnonymousClass4> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass4(this.this$0, r3);
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
            d1<Pair<Integer, String>> r6 = this.this$0.c.getDebugCodeFlow();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.InlineAIController$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.inline.ai.logic.InlineAIController$6", f = "InlineAIController.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InlineAIController this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.InlineAIController$6$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ InlineAIController a;

            public a(InlineAIController r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                if (((Boolean) r1).booleanValue() == false) goto L6;
                this.a.i.b();
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass6(InlineAIController r1, Continuation<? super AnonymousClass6> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass6(this.this$0, r3);
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
            i1 r6 = (i1) this.this$0.h.getValue();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public final class UIOperateCallback implements wlb.e {
        public final /* synthetic */ InlineAIController a;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ InlineAIController a;

            public a(InlineAIController r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r2, int r3) {
                InlineAIController r4 = this.a;
                r4.i.d(r4.b(), "continue");
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ InlineAIController a;
            public final /* synthetic */ Function0<Unit> b;

            public b(InlineAIController r1, Function0<Unit> r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r2, int r3) {
                this.a.c.hidePanel();
                InlineAIController r4 = this.a;
                r4.i.d(r4.b(), "quit");
                this.b.invoke();
            }
        }

        @Override // wlb.e
        public final void d() {
        }

        @Override // wlb.e
        public final String g() {
            return "";
        }

        @Override // wlb.e
        public final void j(Object r3) {
            Intrinsics.checkNotNullParameter("ccm_res", "type");
            Intrinsics.checkNotNullParameter(r3, "data");
        }

        @Override // wlb.e
        public final void e() {
            Log.i("InlineAIController", "onClickStop");
            this.a.c.cancelCurrentTask();
        }

        @Override // wlb.e
        public final void r() {
            Log.i("InlineAIController", "onRangeEditClick");
        }

        public UIOperateCallback(InlineAIController r1) {
            this.a = r1;
        }

        @Override // wlb.e
        public final void a(int r3) {
            Log.i("InlineAIController", "onHeightChange, height = " + r3);
        }

        @Override // wlb.e
        public final void b(boolean r3) {
            Log.i("InlineAIController", "onKeyboardChange, show = " + r3);
            this.a.c.onKeyboardChange(r3);
        }

        @Override // wlb.e
        public final void f(String r3) {
            Intrinsics.checkNotNullParameter(r3, "url");
            Log.i("InlineAIController", "onLinkClicked");
            int r0 = com.ss.android.lark.router.c.a;
            com.ss.android.lark.router.c.b(this.a.a.getActivity(), r3);
        }

        @Override // wlb.e
        public final void h(Object r11) {
            Intrinsics.checkNotNullParameter(r11, "text");
            InlineAIViewModel r0 = this.a.c;
            if ((r11 instanceof String) == false) goto L5;
            j r1 = new j.a((String) r11);
        L31:
            final InlineAIController r12 = this.a;
            slb.j r2 = r12.f;
            Function0<slb.j> r3 = new InlineAIController$UIOperateCallback$onClickSend$1(r12);
            final InlineAIController r4 = this.a;
            r0.clickSend(r1, r2, r3, new InlineAIController$UIOperateCallback$onClickSend$2(r4));
            return;
        L5:
            String r5 = "";
            if ((r11 instanceof TextResultContentList) == false) goto L30;
            int r6 = com.ss.android.lark.inline.ai.logic.a.a;
            TextResultContentList r13 = (TextResultContentList) r11;
            Intrinsics.checkNotNullParameter(r13, "textResultContentList");
            String r7 = r13.getDisplayName();
            if (r7 != null) goto L10;
            r7 = "";
        L10:
            ArrayList r8 = new ArrayList();
            ArrayList<ParamResultDetail> r9 = r13.getParamDetails();
            if (r9 == null) goto L25;
            Iterator<T> r10 = r9.iterator();
        L14:
            if (r10.hasNext() == false) goto L25;
            ParamResultDetail r14 = (ParamResultDetail) r10.next();
            String r15 = r14.getKey();
            if (r15 != null) goto L18;
            r15 = "";
        L18:
            String r16 = r14.getName();
            if (r16 != null) goto L21;
            r16 = "";
        L21:
            String r17 = r14.getPlaceHolder();
            String r18 = r14.getContent();
            if (r18 != null) goto L24;
            r18 = "";
        L24:
            r8.add(new j.b.a(r15, r16, r17, r18));
        L25:
            String r19 = r13.getDisplayContent();
            if (r19 == null) goto L29;
            r5 = r19;
        L29:
            r1 = new j.b(r7, r8, r5);
            goto L31
        L30:
            r1 = new j.a("");
            goto L31
        }

        @Override // wlb.e
        public final void i(String r4) {
            Intrinsics.checkNotNullParameter(r4, "closeType");
            Log.i("InlineAIController", "onClosePanel, closeType = ".concat(r4));
            this.a.c.hidePanel();
            InlineAIController r0 = this.a;
            r0.i.e(r4, r0.c(), this.a.b());
        }

        @Override // wlb.e
        public final void k(Operate r12) {
            Intrinsics.checkNotNullParameter(r12, "operate");
            Log.i("InlineAIController", "onClickOperation operate: " + r12);
            InlineAIController r0 = this.a;
            String r13 = r12.getType();
            f r1 = r0.e;
            f r3 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r1 = null;
        L5:
            h r2 = g.a(r1);
            if (r2 == null) goto L15;
            List<? extends slb.h> r4 = r2.h;
            if (r4 == null) goto L15;
            Iterator<T> r5 = r4.iterator();
            slb.h r6 = null;
        L11:
            if (r5.hasNext() == false) goto L16;
            slb.h r7 = (slb.h) r5.next();
            if (Intrinsics.areEqual(r7.a, r13) == false) goto L11;
            r6 = r7;
        L16:
            if (r6 != null) goto L19;
            Log.e("InlineAIController", "onClickOperation, can not find operate!");
            return;
        L19:
            ArrayList<m> r14 = r6.d;
            if (r14 != null) goto L22;
        L25:
            boolean r8 = true;
        L26:
            if (r8 == true) goto L28;
            IInlineAIUISdkImpl r9 = this.a.b;
            int r10 = com.ss.android.lark.inline.ai.logic.a.a;
            wlb.c.a.a(r9, com.ss.android.lark.inline.ai.logic.a.b(r14, new j.a("")), null, false, null, 14);
        L38:
            InlineAIController r15 = this.a;
            zlb.a r11 = r15.i;
            String r16 = r6.a;
            String r17 = r15.b();
            f r18 = this.a.e;
            if (r18 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        L42:
            r11.f(r16, r17, g.b(r3));
            return;
        L41:
            r3 = r18;
            goto L42
        L28:
            Function2<String, String, Unit> r19 = r6.c;
            if (r19 == null) goto L38;
            String r20 = r6.a;
            f r21 = this.a.e;
            if (r21 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r21 = null;
        L33:
            h r22 = g.a(r21);
            if (r22 == null) goto L36;
            String r23 = r22.d;
        L37:
            r19.invoke(r20, r23);
            goto L38
        L36:
            r23 = null;
            goto L37
        L22:
            if (r14.isEmpty() == true) goto L25;
            r8 = false;
        L15:
            r6 = null;
            goto L16
        }

        @Override // wlb.e
        public final void m(Prompt r2) {
            Intrinsics.checkNotNullParameter(r2, "prompt");
            Log.i("InlineAIController", "onDeleteHistoryPrompt");
        }

        @Override // wlb.e
        public final void n(boolean r3) {
            Log.i("InlineAIController", "onNeedOnBoarding, needOnBoarding = " + r3);
        }

        @Override // wlb.e
        public final void o(Map<String, Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "downloadRes");
        }

        @Override // wlb.e
        public final void onInputTextChange(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a.c.updateUserInput(r2);
        }

        @Override // wlb.e
        public final void p(boolean r9) {
            Log.i("InlineAIController", "onClickHistory, isNext = " + r9);
            InlineAIController r0 = this.a;
            zlb.a r1 = r0.i;
            if (r9 == false) goto L5;
            String r2 = "next";
        L6:
            f r3 = r0.e;
            f r4 = null;
            if (r3 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r3 = null;
        L9:
            int r5 = 1;
            int r6 = r3.e + 1;
            if (r9 == true) goto L13;
            r5 = -1;
        L13:
            int r7 = r6 + r5;
            f r8 = this.a.e;
            if (r8 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        L17:
            int r10 = r4.d.size();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "switchType");
            JSONObject r11 = r1.a();     // Catch: Exception -> L20
            r11.put("click", "switch");     // Catch: Exception -> L20
            r11.put("target", "none");     // Catch: Exception -> L20
            r11.put("switch_type", r2);     // Catch: Exception -> L20
            r11.put("click_number", r7);     // Catch: Exception -> L20
            r11.put("total_number", r10);     // Catch: Exception -> L20
            com.ss.android.lark.statistics.b.b("ccm_ai_history_toggle_click", r11);     // Catch: Exception -> L20
            Log.d("InlineAIReport", "report, event = ccm_ai_history_toggle_click, params = " + r11);     // Catch: Exception -> L20
        L22:
            this.a.c.switchHistory(r9);
            return;
        L20:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
            goto L22
        L16:
            r4 = r8;
            goto L17
        L5:
            r2 = "forward";
            goto L6
        }

        @Override // wlb.e
        public final void q(Prompt r10) {
            Intrinsics.checkNotNullParameter(r10, "uiPrompt");
            InlineAIController r0 = this.a;
            String r11 = r10.getLocalId();
            int r1 = InlineAIController.k;
            r0.getClass();
            ArrayList r2 = new ArrayList();
            f r3 = r0.e;
            slb.j r4 = null;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r3 = null;
        L5:
            h r5 = g.a(r3);
            if (r5 == null) goto L21;
            List<? extends slb.h> r6 = r5.h;
            if (r6 == null) goto L21;
            Iterator<T> r7 = r6.iterator();
        L11:
            if (r7.hasNext() == false) goto L21;
            ArrayList<m> r8 = ((slb.h) r7.next()).d;
            if (r8 == null) goto L18;
            ArrayList r9 = new ArrayList();
            Iterator<T> r12 = r8.iterator();
        L16:
            if (r12.hasNext() == false) goto L19;
            CollectionsKt.addAll(r9, ((m) r12.next()).b);
        L19:
            if (r9 == null) goto L11;
            r2.addAll(r9);
            goto L11
        L18:
            r9 = null;
        L21:
            List<List<m>> r13 = r0.g;
            ArrayList r14 = new ArrayList();
            Iterator r15 = ((ArrayList) r13).iterator();
        L23:
            if (r15.hasNext() == false) goto L29;
            List r16 = (List) r15.next();
            ArrayList r17 = new ArrayList();
            Iterator r18 = r16.iterator();
        L26:
            if (r18.hasNext() == false) goto L28;
            CollectionsKt.addAll(r17, ((m) r18.next()).b);
            goto L26
        L28:
            CollectionsKt.addAll(r14, r17);
            goto L23
        L29:
            r2.addAll(r14);
            f r19 = r0.e;
            if (r19 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r19 = null;
        L32:
            List<m> r20 = r19.c;
            ArrayList r21 = new ArrayList();
            Iterator<T> r22 = r20.iterator();
        L34:
            if (r22.hasNext() == false) goto L36;
            CollectionsKt.addAll(r21, ((m) r22.next()).b);
            goto L34
        L36:
            r2.addAll(r21);
        L38:
            if ((!r2.isEmpty()) == false) goto L45;
            slb.j r23 = (slb.j) ListProtector.remove(r2, 0);
            if (Intrinsics.areEqual(r23.i, r11) == true) goto L41;
            ArrayList<slb.j> r24 = r23.g;
            if (r24 == null) goto L38;
            r2.addAll(r24);
            goto L38
        L41:
            r4 = r23;
        L45:
            if (r4 != null) goto L48;
            Log.e("InlineAIController", "onClickPrompt, can not find prompt!");
            return;
        L48:
            this.a.a(r4);
        }

        @Override // wlb.e
        public final void s(final String r8) {
            Intrinsics.checkNotNullParameter(r8, "closeType");
            Log.i("InlineAIController", "onCloseConfirm");
            boolean r3 = false;
            List r1 = CollectionsKt.listOf(new InlineAIStatus[]{InlineAIStatus.Init, InlineAIStatus.Closed});
            f r2 = this.a.e;
            String r6 = null;
            f r7 = null;
            r6 = null;
            if (r2 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r2 = null;
        L6:
            if (r1.contains(r2.a) == false) goto L13;
            StringBuilder r9 = new StringBuilder("onCloseConfirm with wrong status: ");
            f r4 = this.a.e;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        L11:
            r9.append(r7.a);
            Log.w("InlineAIController", r9.toString());
            return;
        L10:
            r7 = r4;
            goto L11
        L13:
            final InlineAIController r5 = this.a;
            Function0<Unit> r0 = new InlineAIController$UIOperateCallback$onCloseConfirm$reportQuitFunc$1(r5, r8);
            InlineAIController r10 = this.a;
            if (r10.a.g == false) goto L71;
            f r11 = r10.e;
            if (r11 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r11 = null;
        L19:
            if (r11.a == InlineAIStatus.Waiting) goto L71;
            this.a.a.getClass();
            UDDialogBuilder r12 = new UDDialogBuilder(this.a.a.getActivity());
            InlineAIController r13 = this.a;
            String r14 = "";
            if ("".length() != 0) goto L24;
            boolean r15 = true;
        L25:
            if (r15 == false) goto L27;
            String r16 = r13.a.getActivity().getString(2131889162);
        L28:
            UDDialogBuilder r17 = r12.title(r16);
            if ("".length() != 0) goto L31;
            boolean r18 = true;
        L32:
            if (r18 == true) goto L75;
            String r19 = "";
        L53:
            UDDialogBuilder r20 = r17.message(r19);
            InlineAIController r21 = this.a;
            if ("".length() != 0) goto L56;
            boolean r22 = true;
        L57:
            if (r22 == false) goto L59;
            String r23 = r21.a.getActivity().getString(2131889149);
        L60:
            UDDialogBuilder r24 = r20.addActionButton(2131391777, r23, new a(this.a));
            InlineAIController r25 = this.a;
            if ("".length() != 0) goto L63;
            r3 = true;
        L63:
            if (r3 == false) goto L65;
            r14 = r25.a.getActivity().getString(2131889161);
        L65:
            r24.addActionButton(2131391778, r14, new b(this.a, r0)).show();
            InlineAIController r26 = this.a;
            zlb.a r27 = r26.i;
            String r28 = r26.b();
            r27.getClass();
            Intrinsics.checkNotNullParameter(r28, "commandType");
            JSONObject r29 = r27.a();     // Catch: Exception -> L68
            r29.put("command_type", r28);     // Catch: Exception -> L68
            com.ss.android.lark.statistics.b.b("ccm_doc_ai_quit_double_check_view", r29);     // Catch: Exception -> L68
            Log.d("InlineAIReport", "report, event = ccm_doc_ai_quit_double_check_view, params = " + r29);     // Catch: Exception -> L68
            return;
        L68:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
            return;
        L59:
            r23 = "";
            goto L60
        L56:
            r22 = false;
            goto L57
        L75:
            Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L35
            Object r31 = Result.constructor-impl((nsb.b) LarkContext.spiByDwarf(nsb.b.class));     // Catch: Throwable -> L35
        L38:
            if (Result.isFailure-impl(r31) == false) goto L40;
            r31 = null;
        L40:
            nsb.b r32 = (nsb.b) r31;
            if (r32 == null) goto L45;
            i1<String> r33 = r32.a();
            if (r33 == null) goto L45;
            r6 = (String) r33.getValue();
        L45:
            if (r6 != null) goto L47;
            r6 = "";
        L47:
            if (r32 == null) goto L51;
            i1<com.ss.android.lark.myai.export.c> r34 = r32.W();
            if (r34 == null) goto L51;
            com.ss.android.lark.myai.export.c r35 = (com.ss.android.lark.myai.export.c) r34.getValue();
        L51:
            r19 = UIHelper.mustacheFormat(2131889154, "AiNickname", r6);
        L35:
            th = move-exception;
            Result.Companion r36 = Result.Companion;
            r31 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L38
        L31:
            r18 = false;
            goto L32
        L27:
            r16 = "";
            goto L28
        L24:
            r15 = false;
        L71:
            this.a.c.hidePanel();
            r0.invoke();
        }

        @Override // wlb.e
        public final void t(String r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
        }

        @Override // wlb.e
        public final void c(String r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "id");
        }

        @Override // wlb.e
        public final void l(boolean r11, wlb.b r12) {
            StringBuilder r0 = new StringBuilder("onClickFeedback like: ");
            r0.append(r11);
            r0.append(", currentChoice = ");
            f r1 = this.a.e;
            String r3 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r1 = null;
        L5:
            h r2 = g.a(r1);
            if (r2 == null) goto L8;
            FeedBackChoice r4 = r2.c;
        L9:
            r0.append(r4);
            Log.i("InlineAIController", r0.toString());
            InlineAIController r5 = this.a;
            zlb.a r6 = r5.i;
            f r7 = r5.e;
            if (r7 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r7 = null;
        L12:
            h r8 = g.a(r7);
            if (r8 == null) goto L16;
            FeedBackChoice r9 = r8.c;
            if (r9 == null) goto L16;
        L17:
            if (r11 == true) goto L19;
        L21:
            if (r11 == false) goto L23;
        L25:
            if (r11 == false) goto L27;
            String r10 = "like";
        L28:
            String r13 = this.a.b();
            f r14 = this.a.e;
            if (r14 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r14 = null;
        L31:
            String r15 = g.b(r14);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r10, "feedbackType");
            Intrinsics.checkNotNullParameter(r13, "commandType");
            Intrinsics.checkNotNullParameter(r15, "taskId");
            JSONObject r16 = r6.a();     // Catch: Exception -> L34
            r16.put("click", "feedback");     // Catch: Exception -> L34
            r16.put("target", "none");     // Catch: Exception -> L34
            r16.put("feedback_type", r10);     // Catch: Exception -> L34
            r16.put("command_type", r13);     // Catch: Exception -> L34
            r16.put("taskID", r15);     // Catch: Exception -> L34
            com.ss.android.lark.statistics.b.b("ccm_ai_result_feedback_click", r16);     // Catch: Exception -> L34
            Log.d("InlineAIReport", "report, event = ccm_ai_result_feedback_click, params = " + r16);     // Catch: Exception -> L34
        L36:
            this.a.c.onFeedbackChange(r11);
            f r17 = this.a.e;
            if (r17 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
            r17 = null;
        L39:
            h r18 = g.a(r17);
            if (r18 == null) goto L45;
            slb.j r19 = r18.f;
            if (r19 == null) goto L45;
            String r20 = r19.d;
            if (r20 == null) goto L45;
        L51:
            if (r18 == null) goto L54;
            String r21 = r18.j;
            if (r21 == null) goto L54;
        L55:
            String r22 = this.a.a.e.name();
            if (r18 == null) goto L58;
            r3 = r18.d;
        L58:
            r12.a(new FeedbackConfig(r21, r22, r20, r3));
            return;
        L54:
            r21 = "";
        L45:
            if (r18 == null) goto L49;
            j r23 = r18.b;
            if (r23 == null) goto L49;
            r20 = g.d(r23);
        L49:
            r20 = null;
        L34:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
            goto L36
        L27:
            r10 = "dislike";
            goto L28
        L23:
            if (r9 != FeedBackChoice.Unlike) goto L25;
            r10 = "cancel_dislike";
            goto L28
        L19:
            if (r9 != FeedBackChoice.Like) goto L21;
            r10 = "cancel_like";
        L16:
            r9 = FeedBackChoice.Unselected;
            goto L17
        L8:
            r4 = null;
            goto L9
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[MaskType.values().length];
            r0[MaskType.FULLSCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L40:
            r0[MaskType.AROUNDPANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L52:
            r0[MaskType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L42:
            r0[MaskType.DEFAULT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            a = r0;
            int[] r1 = new int[LockType.values().length];
            r1[LockType.LOCK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L44:
            r1[LockType.UNLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L32:
            r1[LockType.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L14:
            b = r1;
            int[] r2 = new int[InlineAIStatus.values().length];
            r2[InlineAIStatus.Waiting.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L48:
            r2[InlineAIStatus.PrepareWaiting.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L36:
            r2[InlineAIStatus.Writing.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            r2[InlineAIStatus.Finished.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L19:
            c = r2;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ InlineAIController a;

        public c(InlineAIController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.i.a = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public final com.larksuite.arch.jack.i getLifecycleOwnerHolder() {
        return this;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.d = true;
        this.c.onDestroy();
        rcb.e.a(new c(this), 300);
    }

    public final String b() {
        f r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        r0 = null;
    L5:
        h r1 = g.a(r0);
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

    public final String c() {
        f r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        r0 = null;
    L5:
        InlineAIStatus r1 = r0.a;
        int r2 = b.c[r1.ordinal()];
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

    public final String g() {
        f r0 = this.e;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        r0 = null;
    L5:
        h r2 = g.a(r0);
        if (r2 == null) goto L11;
        l r3 = r2.g;
        if (r3 == null) goto L11;
        r1 = r3.c;
    L11:
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        boolean r4 = false;
        if (r1.length() != 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L27;
        slb.i r6 = this.a.f;
        if (r6 == null) goto L22;
        r6.b();
    L22:
        if ("".length() != 0) goto L24;
        r4 = true;
    L24:
        if (r4 == true) goto L29;
        return "";
    L29:
        return this.a.getActivity().getString(2131889157);
    L27:
        return r1;
    L16:
        r5 = false;
        goto L17
    }

    public final Lifecycle getLifecycle() {
        return this.a.b.getLifecycle();
    }

    public InlineAIController(slb.g r19) {
        Intrinsics.checkNotNullParameter(r19, "inlineAIParams");
        this.a = r19;
        FragmentActivity r4 = r19.getActivity();
        ScenarioType r12 = r19.e;
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r12, "scenario");
        ViewGroup r6 = r19.d;
        slb.a r9 = r19.l;
        int r10 = r19.m;
        boolean r11 = CollectionsKt.listOf(new ScenarioType[]{ScenarioType.GroupChat, ScenarioType.P2PChat}).contains(r19.e);
        this.b = new IInlineAIUISdkImpl(new wlb.h(r4, null, r6, new wlb.j(r4), new wlb.a(r19.o, true), r9, r10, r11, r12, null, true), new UIOperateCallback(this));
        InlineAIViewModel r2 = new ViewModelProvider(r19.c, new InlineAIController$viewModel$1(this)).get(InlineAIViewModel.class);
        this.c = r2;
        this.g = new ArrayList();
        this.h = LazyKt.lazy(new InlineAIController$isShowing$2(this));
        LifecycleCoroutineScope r13 = LifecycleOwnerKt.getLifecycleScope(r19.b);
        zlb.a r14 = new zlb.a(r19.e);
        this.i = r14;
        r2.updateScenario(r19.e);
        r2.initialize(new AnonymousClass1(this));
        r2.init();
        com.larksuite.arch.jack.f.a.h(this, r2, new AnonymousClass2(this));
        r19.b.getLifecycle().addObserver(this);
        BuildersKt.launch$default(r13, null, null, new AnonymousClass3(this, null), 3, null);
        BuildersKt.launch$default(r13, null, null, new AnonymousClass4(this, null), 3, null);
        r14.a = new AnonymousClass5(this);
        BuildersKt.launch$default(r13, null, null, new AnonymousClass6(this, null), 3, null);
        this.j = LazyKt.lazy(new InlineAIController$isEnable$2(this));
    }

    public final void a(slb.j r11) {
        Intrinsics.checkNotNullParameter(r11, "prompt");
        this.f = r11;
        ArrayList<slb.j> r0 = r11.g;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        String r3 = "";
        if (r2 == true) goto L12;
        final List r12 = CollectionsKt.listOf(new m(r11.d, r0));
        ((ArrayList) this.g).add(r12);
        IInlineAIUISdkImpl r4 = this.b;
        int r1 = com.ss.android.lark.inline.ai.logic.a.a;
        wlb.c.a.a(r4, com.ss.android.lark.inline.ai.logic.a.b(r12, new j.a("")), null, false, new InlineAIController$applyPrompt$1(this, r12), 6);
        return;
    L12:
        Templates r5 = r11.e;
        f r6 = null;
        if (r5 != null) goto L15;
    L18:
        r3 = this.c.startNewTask(r11, null, false);
    L19:
        zlb.a r7 = this.i;
        String r13 = r11.getType();
        f r8 = this.e;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
    L24:
        if (r6.d.isEmpty() == false) goto L26;
        String r9 = "first_time";
    L27:
        r7.c(r13, r9, r3);
        return;
    L26:
        r9 = "adjustment";
        goto L27
    L22:
        r6 = r8;
        goto L24
    L15:
        if (r5.getTemplateList().isEmpty() == true) goto L18;
        this.c.fillTemplateList(r5);
        goto L19
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean e(Boolean r4) {
        LockType r0 = this.a.i;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        if (r1 == (-1)) goto L18;
        if (r1 != 1) goto L10;
        return true;
    L10:
        if (r1 != 2) goto L12;
        return false;
    L12:
        if (r1 == 3) goto L18;
        throw new NoWhenBranchMatchedException();
    L18:
        return Intrinsics.areEqual(r4, Boolean.TRUE);
    L5:
        r1 = b.b[r0.ordinal()];
        goto L6
    }

    public final String f(Boolean r5) {
        MaskType r0 = this.a.h;
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == (-1)) goto L22;
        if (r1 == 1) goto L26;
        if (r1 != 2) goto L13;
        return "aroundPanel";
    L13:
        if (r1 != 3) goto L15;
        return "none";
    L15:
        if (r1 == 4) goto L22;
        throw new NoWhenBranchMatchedException();
    L26:
        return "fullScreen";
    L22:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == true) goto L26;
        return "aroundPanel";
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r1, com.larksuite.arch.jack.l<S> r2, Function1<? super S, Unit> r3) {
        return JackView.a.d(this, r1, r2, r3);
    }

    public final com.larksuite.arch.jack.c Ik(JackViewModel r1, PropertyReference1Impl r2, com.larksuite.arch.jack.l r3, Function1 r4) {
        return JackView.a.a(this, r1, r2, r3, r4);
    }

    public final com.larksuite.arch.jack.c Ki(JackViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, com.larksuite.arch.jack.l r4, Function1 r5) {
        return JackView.a.b(this, r1, r2, r3, r4, r5);
    }

    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, PropertyReference1Impl r4, com.larksuite.arch.jack.l r5, Function1 r6) {
        return JackView.a.c(this, r1, r2, r3, r4, r5, r6);
    }
}
