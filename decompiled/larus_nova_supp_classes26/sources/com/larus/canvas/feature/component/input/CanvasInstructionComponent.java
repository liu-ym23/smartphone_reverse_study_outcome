package com.larus.canvas.feature.component.input;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBindings;
import com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget;
import com.larus.canvas.feature.component.instruction.factory.InstructionTabWidgetFactory;
import com.larus.canvas.feature.component.instruction.model.InstructionTabState;
import com.larus.canvas.feature.component.instruction.model.InstructionTabViewModel;
import com.larus.canvas.feature.component.instruction.model.TabDataSource;
import com.larus.canvas.feature.component.instruction.model.TabUIState;
import com.larus.canvas.feature.component.instruction.model.UIInstructionTab;
import com.larus.canvas.feature.component.instruction.model.UIOptionItem;
import com.larus.canvas.feature.component.instruction.model.UIOptionStatus;
import com.larus.canvas.feature.component.instruction.widget.CanvasOptionsWidget;
import com.larus.canvas.feature.component.instruction.widget.DropDownBoxWidget;
import com.larus.canvas.feature.component.instruction.widget.FeatureSelectorWidget;
import com.larus.canvas.feature.component.instruction.widget.MsgInstructionWidget;
import com.larus.canvas.feature.component.instruction.widget.ToolsWidget;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u0017H\u0016J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\u0010\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020\u0019H\u0016J\b\u00106\u001a\u00020*H\u0016J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0016J\u0016\u0010:\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020908H\u0016J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020=08H\u0016J\u0010\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u000202H\u0016J\u0010\u0010>\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0016J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020=082\f\u0010;\u001a\b\u0012\u0004\u0012\u00020908H\u0016J\b\u0010C\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020*H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006F"}, d2 = {"Lcom/larus/canvas/feature/component/input/CanvasInstructionComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/canvas/feature/ability/CanvasInstructionAbility;", "<init>", "()V", "viewModel", "Lcom/larus/canvas/feature/component/instruction/model/InstructionTabViewModel;", "getViewModel", "()Lcom/larus/canvas/feature/component/instruction/model/InstructionTabViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "rootView", "Landroid/view/ViewGroup;", "binding", "Lcom/larus/canvas/impl/databinding/LarusComponentCanvasInstructionLayoutBinding;", "instructionTabWidgetFactory", "Lcom/larus/canvas/feature/component/instruction/IInstructionTabWidgetFactory;", "instructionRenderTaskRegister", "", "Lcom/larus/canvas/feature/component/instruction/model/TabUIState;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "mInstructionInitConfig", "Lcom/larus/canvas/feature/ability/InstructionInitConfig;", "finishInstructionRender", "", "rootViewHeightAnimator", "Landroid/animation/ValueAnimator;", "canvasEditorAbility", "Lcom/larus/canvas/feature/ability/CreationCanvasEditorAbility;", "getCanvasEditorAbility", "()Lcom/larus/canvas/feature/ability/CreationCanvasEditorAbility;", "canvasEditorAbility$delegate", "Lkotlin/Lazy;", "_instructionTabUIState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/canvas/feature/component/instruction/model/InstructionTabState;", "instructionTabStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInstructionTabStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "initInstruction", "instructionInitConfig", "setInstructionHeight", "height", "", "getInstructionHeight", "setInstructionVisible", "visible", "onFragmentViewDestroyed", "getUIInstructionTabList", "", "Lcom/larus/canvas/feature/component/instruction/model/UIInstructionTab;", "updateUIInstructionTabList", "uiInstructionTabList", "getCurrentInstructionTabList", "Lcom/larus/canvas/service/bean/InstructionTab;", "selectInstructionTab", "index", "tabLabel", "", "getInstructionTabListFormUIList", "getInstructionTraceContent", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasInstructionComponent extends BaseContentWidget implements fy8.h {
    public static final /* synthetic */ int v = 0;
    public final com.larus.ui.arch.vm.internal.l m;
    public ViewGroup n;
    public InstructionTabWidgetFactory o;
    public final Map<TabUIState, Runnable> p;
    public fy8.l q;
    public boolean r;
    public final Lazy s;
    public final StateFlowImpl t;
    public final b1 u;

    public static final class a {
    }

    public static final class b implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public b(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class c implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public c(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class d implements Function0<ViewModelProvider.Factory> {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CanvasInstructionComponent$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "tabUiState", "Lcom/larus/canvas/feature/component/instruction/model/TabUIState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.input.CanvasInstructionComponent$onViewCreated$3", f = "CanvasInstructionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<TabUIState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CanvasInstructionComponent this$0;

        /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CanvasInstructionComponent$onViewCreated$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.canvas.feature.component.input.CanvasInstructionComponent$onViewCreated$3$1", f = "CanvasInstructionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TabUIState $tabUiState;
            int label;
            final /* synthetic */ CanvasInstructionComponent this$0;

            /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CanvasInstructionComponent$onViewCreated$3$1$a */
            public /* synthetic */ class a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[TabUIState.values().length];
                    r0[TabUIState.STATE_LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r0[TabUIState.STATE_SHOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r0[TabUIState.STATE_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    a = r0;
                }
            }

            public AnonymousClass1(TabUIState r1, CanvasInstructionComponent r2, Continuation<? super AnonymousClass1> r3) {
                this.$tabUiState = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.$tabUiState, this.this$0, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r17) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L145;
                ResultKt.throwOnFailure(r17);
                int r1 = a.a[this.$tabUiState.ordinal()];
                if (r1 != 1) goto L7;
                FLogger.a.i("CanvasInstructionComponent", "instruction tab state loading");
                InstructionTabWidgetFactory r2 = this.this$0.o;
                if (r2 == null) goto L139;
                Fragment r7 = r2.a;
                if (r7 != null) goto L113;
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
                r7 = null;
            L113:
                Context r6 = r7.getContext();
                if (r6 == null) goto L139;
                ViewGroup r8 = r2.b;
                if (r8 != null) goto L118;
                Intrinsics.throwUninitializedPropertyAccessException("tabContainer");
                r8 = null;
            L118:
                e1.x(r8);
                ViewGroup r9 = r2.b;
                if (r9 != null) goto L121;
                Intrinsics.throwUninitializedPropertyAccessException("tabContainer");
                r9 = null;
            L121:
                r9.removeAllViews();
                int r10 = com.larus.utils.i.d(r6);
                AppHost.Companion r11 = AppHost.a;
                int r12 = r11.getApplication().getResources().getDimensionPixelSize(v19.c.b(2130971547, null, 2131167463));
                int r13 = r11.getApplication().getResources().getDimensionPixelSize(v19.c.b(2130971435, null, 2131167240));
                int r14 = r10 / r12;
                IntIterator r3 = new IntRange(1, r14).iterator();
                int r15 = 0;
            L123:
                if (r3.hasNext() == false) goto L139;
                r3.nextInt();
                int r16 = r15 + 1;
                if (r15 >= 0) goto L127;
                CollectionsKt.throwIndexOverflow();
            L127:
                FrameLayout r18 = new FrameLayout(r6);
                r18.setLayoutParams(new FrameLayout.LayoutParams(r12, r13));
                AppHost.Companion r19 = AppHost.a;
                r18.setBackground(ContextCompat.getDrawable(r19.getApplication(), v19.c.b(2130970698, r19.getApplication(), 2131239180)));
                r18.setId(View.generateViewId());
                ViewGroup r4 = r2.b;
                if (r4 != null) goto L130;
                Intrinsics.throwUninitializedPropertyAccessException("tabContainer");
                r4 = null;
            L130:
                LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(r12, r13);
                if (r15 != 0) goto L133;
                int r111 = i5.h();
            L134:
                r110.setMarginStart(r111);
                if (r15 != (r14 - 1)) goto L137;
                int r112 = i5.h();
            L138:
                r110.setMarginEnd(r112);
                Unit r113 = Unit.INSTANCE;
                r4.addView(r18, r110);
                r15 = r16;
                goto L123
            L137:
                r112 = 0;
                goto L138
            L133:
                r111 = i5.r0();
            L139:
                Map<TabUIState, Runnable> r5 = this.this$0.p;
                TabUIState r20 = TabUIState.STATE_LOADING;
                Runnable r21 = (Runnable) ((LinkedHashMap) r5).get(r20);
                if (r21 == null) goto L142;
                CanvasInstructionComponent r22 = this.this$0;
                r21.run();
                Runnable r23 = r22.p.remove(r20);
            L142:
                CanvasInstructionComponent r24 = this.this$0;
                r24.t.setValue(r24.Y2().getState());
                return Unit.INSTANCE;
            L7:
                if (r1 == 2) goto L14;
                if (r1 != 3) goto L13;
                FLogger.a.i("CanvasInstructionComponent", "instruction tab state error");
                Map<TabUIState, Runnable> r25 = this.this$0.p;
                TabUIState r26 = TabUIState.STATE_ERROR;
                Runnable r27 = (Runnable) ((LinkedHashMap) r25).get(r26);
                if (r27 == null) goto L142;
                CanvasInstructionComponent r28 = this.this$0;
                r27.run();
                Runnable r29 = r28.p.remove(r26);
                goto L142
            L13:
                throw new NoWhenBranchMatchedException();
            L14:
                FLogger.a.i("CanvasInstructionComponent", "instruction tab state show");
                CanvasInstructionComponent r30 = this.this$0;
                int r31 = CanvasInstructionComponent.v;
                if (((InstructionTabState) r30.Y2().getState()).getDataSource() != TabDataSource.FROM_REMOTE) goto L25;
                InstructionTabWidgetFactory r32 = this.this$0.o;
                if (r32 != null) goto L19;
            L21:
                boolean r33 = false;
            L22:
                if (r33 == false) goto L25;
                return Unit.INSTANCE;
            L19:
                if (r32.h != true) goto L21;
                r33 = true;
            L25:
                List<InstructionTab> r34 = ((InstructionTabState) this.this$0.Y2().getState()).getInstructionTabList();
                InstructionTabWidgetFactory r35 = this.this$0.o;
                if (r35 == null) goto L70;
                Intrinsics.checkNotNullParameter(r34, "tabList");
                ((ArrayList) r35.d).clear();
                ((ArrayList) r35.d).addAll(r34);
                r35.e.clear();
                Iterator r36 = ((ArrayList) r35.d).iterator();
            L29:
                if (r36.hasNext() == false) goto L70;
                InstructionTab r114 = (InstructionTab) r36.next();
                Fragment r115 = r35.a;
                if (r115 != null) goto L33;
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
                r115 = null;
            L33:
                Integer r116 = r114.getTabType();
                if (r116 != null) goto L37;
            L39:
                if (r116 != null) goto L42;
            L44:
                if (r116 != null) goto L47;
            L49:
                if (r116 != null) goto L52;
            L54:
                if (r116 != null) goto L57;
            L62:
                AbstractInstructionTabWidget r117 = null;
            L63:
                if (r117 == null) goto L68;
                Map<String, String> r118 = r35.g;
                if (r118 != null) goto L67;
                Intrinsics.throwUninitializedPropertyAccessException("traceMap");
                r118 = null;
            L67:
                r117.l(r114, r115, r118);
            L68:
                if (r117 == null) goto L29;
                r35.e.put(r114, r117);
                goto L29
            L57:
                if (r116.intValue() != 5) goto L62;
                FeatureSelectorWidget r119 = new FeatureSelectorWidget();
                Function0<String> r120 = r35.f;
                if (r120 != null) goto L61;
                Intrinsics.throwUninitializedPropertyAccessException("getCurrentPrompt");
                r120 = null;
            L61:
                Intrinsics.checkNotNullParameter(r120, "getCurrentPrompt");
                r119.h = r120;
                r117 = r119;
                goto L63
            L52:
                if (r116.intValue() != 4) goto L54;
                r117 = new MsgInstructionWidget();
                goto L63
            L47:
                if (r116.intValue() != 3) goto L49;
                r117 = new ToolsWidget();
                goto L63
            L42:
                if (r116.intValue() != 2) goto L44;
                r117 = new DropDownBoxWidget();
                goto L63
            L37:
                if (r116.intValue() != 1) goto L39;
                r117 = new CanvasOptionsWidget();
            L70:
                InstructionTabWidgetFactory r37 = this.this$0.o;
                if (r37 == null) goto L105;
                ViewGroup r38 = r37.b;
                if (r38 != null) goto L75;
                Intrinsics.throwUninitializedPropertyAccessException("tabContainer");
                r38 = null;
            L75:
                e1.x(r38);
                r37.b();
                ViewGroup r39 = r37.b;
                if (r39 != null) goto L78;
                Intrinsics.throwUninitializedPropertyAccessException("tabContainer");
                r39 = null;
            L78:
                r39.removeAllViews();
                Iterator<T> r40 = r37.e.values().iterator();
                int r41 = 0;
            L80:
                if (r40.hasNext() == false) goto L105;
                Object r42 = r40.next();
                int r121 = r41 + 1;
                if (r41 >= 0) goto L84;
                CollectionsKt.throwIndexOverflow();
            L84:
                View r43 = ((com.larus.canvas.feature.component.instruction.b) r42).d();
                Fragment r122 = r37.a;
                if (r122 != null) goto L87;
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
                r122 = null;
            L87:
                Context r123 = r122.getContext();
                if (r123 == null) goto L92;
                Resources r124 = r123.getResources();
                if (r124 == null) goto L92;
                int r125 = (int) r124.getDimension(2131166156);
            L93:
                ViewGroup r126 = r37.b;
                if (r126 != null) goto L96;
                Intrinsics.throwUninitializedPropertyAccessException("tabContainer");
                r126 = null;
            L96:
                LinearLayout.LayoutParams r127 = new LinearLayout.LayoutParams(-2, r125);
                if (r41 != 0) goto L99;
                int r128 = i5.h();
            L100:
                r127.setMarginStart(r128);
                if (r41 != (r37.e.size() - 1)) goto L103;
                int r44 = i5.h();
            L104:
                r127.setMarginEnd(r44);
                Unit r45 = Unit.INSTANCE;
                r126.addView(r43, r127);
                r41 = r121;
                goto L80
            L103:
                r44 = 0;
                goto L104
            L99:
                r128 = i5.j0();
            L92:
                r125 = -2;
            L105:
                CanvasInstructionComponent r46 = this.this$0;
                r46.r = true;
                Map<TabUIState, Runnable> r47 = r46.p;
                TabUIState r48 = TabUIState.STATE_SHOW;
                Runnable r49 = (Runnable) ((LinkedHashMap) r47).get(r48);
                if (r49 == null) goto L142;
                CanvasInstructionComponent r50 = this.this$0;
                r49.run();
                Runnable r51 = r50.p.remove(r48);
                goto L142
            L145:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass3(CanvasInstructionComponent r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(TabUIState r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((TabUIState) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            TabUIState r9 = (TabUIState) this.L$0;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new AnonymousClass1(r9, this.this$0, null), 3, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final void A2() {
    }

    @Override // fy8.h
    public final String K5() {
        InstructionTabWidgetFactory r0 = this.o;
        if (r0 == null) goto L22;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.e.values().iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = ((com.larus.canvas.feature.component.instruction.b) r2.next()).a();
        if (r3 == null) goto L6;
        r1.add(r3);
        goto L6
    L10:
        StringBuilder r4 = new StringBuilder();
        Iterator r5 = r1.iterator();
        int r6 = 0;
    L12:
        if (r5.hasNext() == false) goto L20;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        String r9 = (String) r7;
        if (r6 == (r1.size() - 1)) goto L19;
        r4.append("，");
    L19:
        r4.append(r9);
        r6 = r8;
        goto L12
    L20:
        String r10 = r4.toString();
        if (r10 == null) goto L22;
        return r10;
    L22:
        return "";
    }

    public final InstructionTabViewModel Y2() {
        return (InstructionTabViewModel) this.m.getValue();
    }

    @Override // fy8.h
    public final List<UIInstructionTab> cW() {
        InstructionTabWidgetFactory r0 = this.o;
        if (r0 == null) goto L9;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.e.values().iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        r1.add(((com.larus.canvas.feature.component.instruction.b) r2.next()).c());
        goto L6
    L11:
        return r1;
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // fy8.h
    public final int lG() {
        ViewGroup r0 = this.n;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getHeight();
    }

    public final void onDestroy() {
        InstructionTabWidgetFactory r0 = this.o;
        if (r0 == null) goto L9;
        ValueAnimator r1 = r0.i;
        if (r1 == null) goto L7;
        r1.cancel();
    L7:
        r0.i = null;
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, fy8.h.class);
    }

    public CanvasInstructionComponent() {
        this.m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(InstructionTabViewModel.class), Reflection.getOrCreateKotlinClass(InstructionTabState.class), new b(this), new c(this), d.a);
        this.p = new LinkedHashMap();
        this.s = LazyKt.lazy(new u(this));
        StateFlowImpl r0 = j1.a(new InstructionTabState(null, null, null, 7, null));
        this.t = r0;
        this.u = kotlinx.coroutines.flow.e.b(r0);
    }

    @Override // fy8.h
    public final b1 i70() {
        return this.u;
    }

    @Override // fy8.h
    public final void jU(fy8.l r8) {
        Intrinsics.checkNotNullParameter(r8, "instructionInitConfig");
        this.q = r8;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasInstructionComponent$initInstruction$1(this, r8, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.canvas.feature.component.input.v] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r18) {
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r18, "view");
        if ((r18 instanceof ViewGroup) == false) goto L26;
        this.n = (ViewGroup) r18;
        this.o = new InstructionTabWidgetFactory();
        View r1 = LayoutInflater.from(getContext()).inflate(2131561982, null, false);
        int r2 = 2131375450;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131375450);
        if (r8 == null) goto L25;
        r2 = 2131375453;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131375453);
        if (r7 == null) goto L25;
        r2 = 2131375454;
        if (((HorizontalScrollView) ViewBindings.findChildViewById(r1, 2131375454)) == null) goto L25;
        LinearLayout r3 = (LinearLayout) r1;
        ViewGroup r4 = this.n;
        if (r4 == null) goto L13;
        r4.removeAllViews();
    L13:
        ViewGroup r5 = this.n;
        if (r5 == null) goto L16;
        r5.addView(r3);
    L16:
        InstructionTabWidgetFactory r6 = this.o;
        if (r6 == 0) goto L22;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r9 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        ?? r10 = new v(this);
        fy8.l r11 = this.q;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mInstructionInitConfig");
        r11 = null;
    L21:
        r6.a(r9, r7, r8, r10, r11.b);
    L22:
        ComponentViewModel.onEach$default(Y2(), AnonymousClass2.INSTANCE, null, new AnonymousClass3(this, null), 2, null);
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    @Override // fy8.h
    public final void p2(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "tabLabel");
        if (this.r == true) goto L5;
        this.p.put(TabUIState.STATE_LOADING, new s(this));
        this.p.put(TabUIState.STATE_SHOW, new t(this, r4));
        return;
    L5:
        InstructionTabWidgetFactory r0 = this.o;
        if (r0 == null) goto L10;
        r0.c(r4);
        return;
    }

    @Override // fy8.h
    public final void pw(int r3) {
        ViewGroup r0 = this.n;
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L8;
        r1.height = r3;
        r0.setLayoutParams(r1);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // fy8.h
    public final List<InstructionTab> rb(List<UIInstructionTab> r22) {
        Intrinsics.checkNotNullParameter(r22, "uiInstructionTabList");
        List<InstructionTab> r1 = ((InstructionTabState) Y2().getState()).getInstructionTabList();
        if (r1.isEmpty() == true) goto L5;
        ArrayList r2 = new ArrayList();
        Iterator<T> r0 = r22.iterator();
    L8:
        if (r0.hasNext() == false) goto L75;
        UIInstructionTab r3 = (UIInstructionTab) r0.next();
        Iterator<T> r4 = r1.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((InstructionTab) r5).getTabLabel(), r3.getTabLabel()) == false) goto L11;
    L16:
        InstructionTab r6 = (InstructionTab) r5;
        if (r6 == null) goto L8;
        Integer r7 = r6.getTabType();
        if (r7 == null) goto L47;
        if (r7.intValue() != 1) goto L47;
        ArrayList r14 = new ArrayList();
        Iterator<T> r8 = r3.getUiOptionList().iterator();
    L25:
        if (r8.hasNext() == false) goto L44;
        UIOptionItem r9 = (UIOptionItem) r8.next();
        if (r9.getUiStatus() != UIOptionStatus.LOADING) goto L25;
        List<OptionItem> r10 = r6.getOptionList();
        if (r10 == null) goto L25;
        Iterator<T> r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L39;
        Object r12 = r11.next();
        if (((OptionItem) r12).getId() != r9.getId()) goto L36;
        boolean r13 = true;
    L37:
        if (r13 == false) goto L32;
    L40:
        OptionItem r15 = (OptionItem) r12;
        if (r15 == null) goto L25;
        r14.add(r15);
        goto L25
    L36:
        r13 = false;
        goto L37
    L39:
        r12 = null;
        goto L40
    L44:
        if ((!r14.isEmpty()) == false) goto L47;
        r2.add(InstructionTab.copy$default(r6, null, null, null, null, null, null, r14, null, null, 447, null));
    L47:
        Integer r16 = r6.getTabType();
        if (r16 == null) goto L8;
        if (r16.intValue() != 2) goto L8;
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r3.getUiOptionList().iterator();
    L54:
        if (r18.hasNext() == false) goto L73;
        UIOptionItem r19 = (UIOptionItem) r18.next();
        if (r19.getUiStatus() != UIOptionStatus.SELECTED) goto L54;
        List<OptionItem> r20 = r6.getOptionList();
        if (r20 == null) goto L54;
        Iterator<T> r21 = r20.iterator();
    L61:
        if (r21.hasNext() == false) goto L68;
        Object r23 = r21.next();
        if (((OptionItem) r23).getId() != r19.getId()) goto L65;
        boolean r110 = true;
    L66:
        if (r110 == false) goto L61;
    L69:
        OptionItem r24 = (OptionItem) r23;
        if (r24 == null) goto L54;
        r17.add(r24);
        goto L54
    L65:
        r110 = false;
        goto L66
    L68:
        r23 = null;
        goto L69
    L73:
        if ((!r17.isEmpty()) == false) goto L8;
        r2.add(InstructionTab.copy$default(r6, null, null, null, null, null, null, r17, null, null, 447, null));
        goto L8
    L15:
        r5 = null;
        goto L16
    L75:
        return r2;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // fy8.h
    public final void wN(boolean r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasInstructionComponent$setInstructionVisible$1(this, r7, null), 3, null);
    }
}
