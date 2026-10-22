package com.bytedance.ai.ex.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.MainThread;
import androidx.compose.runtime.ComposerKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.j;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.flow.c0;
import kotlinx.coroutines.flow.f2;
import kotlinx.coroutines.flow.t;
import kotlinx.coroutines.flow.u0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aL\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012-\u0010\t\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aN\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012-\u0010\t\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001aE\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013¢\u0006\u0002\b\bH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017\u001a=\u0010\u0018\u001a\u00020\u0015*\u00020\u00002'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013¢\u0006\u0002\b\bH\u0087@¢\u0006\u0004\b\u0018\u0010\u0019\u001a=\u0010\u001a\u001a\u00020\u0015*\u00020\u00002'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013¢\u0006\u0002\b\bH\u0087@¢\u0006\u0004\b\u001a\u0010\u0019\u001a=\u0010\u001b\u001a\u00020\u0015*\u00020\u00002'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013¢\u0006\u0002\b\bH\u0087@¢\u0006\u0004\b\u001b\u0010\u0019\u001aH\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\"\u0004\b\u0000\u0010\u001c2-\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013¢\u0006\u0002\b\b¢\u0006\u0004\b\u001f\u0010 \u001aS\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u001e\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010!*\b\u0012\u0004\u0012\u00028\u00000\u001e2(\u0010\"\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001e0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013¢\u0006\u0004\b#\u0010$\"\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'\"\u0014\u0010)\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*\"\u0014\u0010+\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010*\"\u0014\u0010,\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010*\"\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u001e*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/\" \u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000\u001e*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/\"\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020-0\u001e*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010/\"\u001e\u00104\u001a\b\u0012\u0004\u0012\u00020-0\u001e*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010/\"\u001b\u00105\u001a\b\u0012\u0004\u0012\u00020-0\u001e*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b5\u0010/\"\u001e\u00104\u001a\b\u0012\u0004\u0012\u00020-0\u001e*\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00106\"\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020-0\u001e*\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00106¨\u00067"}, d2 = {"Landroid/view/View;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/Function3;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/t0;", RepeatWhenAttachedKt.DEFAULT_TRACE_NAME, "(Landroid/view/View;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/t0;", "view", "Lcom/bytedance/ai/ex/widget/ViewLifecycleOwner;", "createLifecycleOwnerAndRun", "(Landroid/view/View;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lcom/bytedance/ai/ex/widget/ViewLifecycleOwner;", "Lcom/bytedance/ai/ex/widget/WindowLifecycleState;", "state", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "", "repeatOnWindowLifecycle", "(Landroid/view/View;Lcom/bytedance/ai/ex/widget/WindowLifecycleState;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "repeatWhenAttachedToWindow", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "repeatWhenWindowIsVisible", "repeatWhenWindowHasFocus", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/u;", "Lkotlinx/coroutines/flow/g;", "conflatedCallbackFlow", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/g;", "R", "transform", "flatMapLatestConflated", "(Lkotlinx/coroutines/flow/g;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/g;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "MAIN_DISPATCHER_SINGLETON", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "", "DEFAULT_TRACE_NAME", "Ljava/lang/String;", "CURRENT_CLASS_NAME", "JAVA_ADAPTER_CLASS_NAME", "", "isAttached", "(Landroid/view/View;)Lkotlinx/coroutines/flow/g;", "Landroid/view/ViewTreeObserver;", "getCurrentViewTreeObserver", "currentViewTreeObserver", "isWindowVisible", "isWindowFocused", "isVisible", "(Landroid/view/ViewTreeObserver;)Lkotlinx/coroutines/flow/g;", "widget-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRepeatWhenAttached.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatWhenAttached.kt\ncom/bytedance/ai/ex/widget/RepeatWhenAttachedKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,350:1\n47#2:351\n49#2:355\n50#3:352\n55#3:354\n106#4:353\n190#5:356\n*S KotlinDebug\n*F\n+ 1 RepeatWhenAttached.kt\ncom/bytedance/ai/ex/widget/RepeatWhenAttachedKt\n*L\n275#1:351\n275#1:355\n275#1:352\n275#1:354\n275#1:353\n350#1:356\n*E\n"})
public final class RepeatWhenAttachedKt {
    private static final String CURRENT_CLASS_NAME = "com.android.systemui.lifecycle.RepeatWhenAttachedKt";
    private static final String DEFAULT_TRACE_NAME = "repeatWhenAttached";
    private static final String JAVA_ADAPTER_CLASS_NAME = "com.android.systemui.util.kotlin.JavaAdapterKt";
    private static final MainCoroutineDispatcher MAIN_DISPATCHER_SINGLETON = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[WindowLifecycleState.values().length];
            r5[WindowLifecycleState.ATTACHED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[WindowLifecycleState.VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[WindowLifecycleState.FOCUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isAttached$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/u;", "", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isAttached$1", f = "RepeatWhenAttached.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $this_isAttached;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(View r5, Continuation<? super AnonymousClass1> r10) {
            this.$this_isAttached = r5;
            super(2, r10);
        }

        public static /* synthetic */ Unit b(View r5, RepeatWhenAttachedKt$isAttached$1$onAttachListener$1 r10) {
            return invokeSuspend$lambda$0(r5, r10);
        }

        private static final Unit invokeSuspend$lambda$0(View r5, RepeatWhenAttachedKt$isAttached$1$onAttachListener$1 r10) {
            r5.removeOnAttachStateChangeListener(r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass1 r11 = new AnonymousClass1(this.$this_isAttached, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            final u r12 = (u) this.L$0;
            View.OnAttachStateChangeListener r13 = new RepeatWhenAttachedKt$isAttached$1$onAttachListener$1(r12);
            this.$this_isAttached.addOnAttachStateChangeListener(r13);
            j r14 = (j) r12;
            r14.g(Boxing.boxBoolean(this.$this_isAttached.isAttachedToWindow()));
            int r15 = 0;
            b r16 = new b(r15, this.$this_isAttached, r13);
            this.label = 1;
            if (s.a(r12, r16, this) != r5) goto L12;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(u r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isVisible$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isWindowVisible", "Lkotlinx/coroutines/flow/g;", "<anonymous>", "(Z)Lkotlinx/coroutines/flow/g;"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isVisible$1", f = "RepeatWhenAttached.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nRepeatWhenAttached.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatWhenAttached.kt\ncom/bytedance/ai/ex/widget/RepeatWhenAttachedKt$isVisible$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,350:1\n47#2:351\n49#2:355\n50#3:352\n55#3:354\n106#4:353\n*S KotlinDebug\n*F\n+ 1 RepeatWhenAttached.kt\ncom/bytedance/ai/ex/widget/RepeatWhenAttachedKt$isVisible$1\n*L\n304#1:351\n304#1:355\n304#1:352\n304#1:354\n304#1:353\n*E\n"})
    public static final class C01571 extends SuspendLambda implements Function2<Boolean, Continuation<? super kotlinx.coroutines.flow.g>, Object> {
        final /* synthetic */ View $this_isVisible;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isVisible$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/u;", "", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
        @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isVisible$1$1", f = "RepeatWhenAttached.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00111 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
            final /* synthetic */ View $this_isVisible;
            private /* synthetic */ Object L$0;
            int label;

            public C00111(View r5, Continuation<? super C00111> r10) {
                this.$this_isVisible = r5;
                super(2, r10);
            }

            public static /* synthetic */ Unit b(View r5, c r10) {
                return invokeSuspend$lambda$1(r5, r10);
            }

            public static /* synthetic */ void f(u r5) {
                invokeSuspend$lambda$0(r5);
            }

            /* JADX WARN: Multi-variable type inference failed */
            private static final void invokeSuspend$lambda$0(u r5) {
                j r10 = (j) r5;
                r10.g(Unit.INSTANCE);
            }

            private static final Unit invokeSuspend$lambda$1(View r5, ViewTreeObserver.OnGlobalLayoutListener r10) {
                r5.getViewTreeObserver().removeOnGlobalLayoutListener(r10);
                return Unit.INSTANCE;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                C00111 r11 = new C00111(this.$this_isVisible, r10);
                r11.L$0 = r5;
                return r11;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r10) {
                Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                ResultKt.throwOnFailure(r10);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r10);
                final u r12 = (u) this.L$0;
                j r13 = (j) r12;
                r13.g(Boxing.boxBoolean(this.$this_isVisible.isShown()));
                ViewTreeObserver.OnGlobalLayoutListener r14 = new c(r12);
                this.$this_isVisible.getViewTreeObserver().addOnGlobalLayoutListener(r14);
                int r15 = 1;
                b r16 = new b(r15, this.$this_isVisible, r14);
                this.label = 1;
                if (s.a(r12, r16, this) != r5) goto L12;
                return r5;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(u r5, Continuation<? super Unit> r10) {
                return ((C00111) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public C01571(View r5, Continuation<? super C01571> r10) {
            this.$this_isVisible = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C01571 r11 = new C01571(this.$this_isVisible, r10);
            r11.Z$0 = ((Boolean) r5).booleanValue();
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Boolean r5, Continuation<? super kotlinx.coroutines.flow.g> r10) {
            return invoke(r5.booleanValue(), r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            int r10 = 0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            if (this.Z$0 == false) goto L9;
            kotlinx.coroutines.flow.g r11 = RepeatWhenAttachedKt.conflatedCallbackFlow(new C00111(this.$this_isVisible, null));
            kotlinx.coroutines.flow.g[] r12 = {new f2(new RepeatWhenAttachedKt$isVisible$1$2$1(null)), kotlinx.coroutines.flow.i.g(r11)};
            int r13 = u0.f18908a;
            final kotlinx.coroutines.flow.internal.j r14 = new kotlinx.coroutines.flow.internal.j(ArraysKt.asIterable(r12), EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
            final View r15 = this.$this_isVisible;
            return new RepeatWhenAttachedKt$isVisible$1$invokeSuspend$$inlined$map$1(r14, r15);
        L9:
            return new t(Boxing.boxBoolean(false), r10);
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(boolean r5, Continuation<? super kotlinx.coroutines.flow.g> r10) {
            return ((C01571) create(Boolean.valueOf(r5), r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowFocused$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/ViewTreeObserver;", "vto", "Lkotlinx/coroutines/flow/g;", "", "<anonymous>", "(Landroid/view/ViewTreeObserver;)Lkotlinx/coroutines/flow/g;"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowFocused$1", f = "RepeatWhenAttached.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01581 extends SuspendLambda implements Function2<ViewTreeObserver, Continuation<? super kotlinx.coroutines.flow.g>, Object> {
        final /* synthetic */ View $this_isWindowFocused;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowFocused$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/h;", "", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {2, 0, 0})
        @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowFocused$1$1", f = "RepeatWhenAttached.kt", i = {}, l = {286}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00121 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.h, Continuation<? super Unit>, Object> {
            final /* synthetic */ View $this_isWindowFocused;
            private /* synthetic */ Object L$0;
            int label;

            public C00121(View r5, Continuation<? super C00121> r10) {
                this.$this_isWindowFocused = r5;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                C00121 r11 = new C00121(this.$this_isWindowFocused, r10);
                r11.L$0 = r5;
                return r11;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                kotlinx.coroutines.flow.h r12 = (kotlinx.coroutines.flow.h) this.L$0;
                Boolean r13 = Boxing.boxBoolean(this.$this_isWindowFocused.hasWindowFocus());
                this.label = 1;
                if (r12.emit(r13, this) != r10) goto L12;
                return r10;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
                return ((C00121) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public C01581(View r5, Continuation<? super C01581> r10) {
            this.$this_isWindowFocused = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C01581 r11 = new C01581(this.$this_isWindowFocused, r10);
            r11.L$0 = r5;
            return r11;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ViewTreeObserver r5, Continuation<? super kotlinx.coroutines.flow.g> r10) {
            return ((C01581) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r5);
            ViewTreeObserver r10 = (ViewTreeObserver) this.L$0;
            if (r10 == null) goto L11;
            kotlinx.coroutines.flow.g r11 = RepeatWhenAttachedKt.access$isWindowFocused(r10);
            if (r11 == null) goto L11;
            return new c0(r11, new C00121(this.$this_isWindowFocused, null));
        L11:
            return kotlinx.coroutines.flow.f.f18845a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(ViewTreeObserver r5, Continuation<? super kotlinx.coroutines.flow.g> r10) {
            return invoke2(r5, r10);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowFocused$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/u;", "", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowFocused$2", f = "RepeatWhenAttached.kt", i = {}, l = {317}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewTreeObserver $this_isWindowFocused;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(ViewTreeObserver r5, Continuation<? super AnonymousClass2> r10) {
            this.$this_isWindowFocused = r5;
            super(2, r10);
        }

        public static /* synthetic */ void b(u r5, boolean r10) {
            invokeSuspend$lambda$0(r5, r10);
        }

        public static /* synthetic */ Unit f(ViewTreeObserver r5, d r10) {
            return invokeSuspend$lambda$1(r5, r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final void invokeSuspend$lambda$0(u r5, boolean r10) {
            j r11 = (j) r5;
            r11.g(Boolean.valueOf(r10));
        }

        private static final Unit invokeSuspend$lambda$1(ViewTreeObserver r5, ViewTreeObserver.OnWindowFocusChangeListener r10) {
            r5.removeOnWindowFocusChangeListener(r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass2 r11 = new AnonymousClass2(this.$this_isWindowFocused, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            u r12 = (u) this.L$0;
            d r13 = new d(r12, 0);
            this.$this_isWindowFocused.addOnWindowFocusChangeListener(r13);
            int r14 = 2;
            b r15 = new b(r14, this.$this_isWindowFocused, r13);
            this.label = 1;
            if (s.a(r12, r15, this) != r5) goto L12;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(u r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowVisible$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/ViewTreeObserver;", "vto", "Lkotlinx/coroutines/flow/g;", "", "<anonymous>", "(Landroid/view/ViewTreeObserver;)Lkotlinx/coroutines/flow/g;"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowVisible$1", f = "RepeatWhenAttached.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01591 extends SuspendLambda implements Function2<ViewTreeObserver, Continuation<? super kotlinx.coroutines.flow.g>, Object> {
        final /* synthetic */ View $this_isWindowVisible;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowVisible$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/h;", "", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {2, 0, 0})
        @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowVisible$1$1", f = "RepeatWhenAttached.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00131 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.h, Continuation<? super Unit>, Object> {
            final /* synthetic */ View $this_isWindowVisible;
            private /* synthetic */ Object L$0;
            int label;

            public C00131(View r5, Continuation<? super C00131> r10) {
                this.$this_isWindowVisible = r5;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                C00131 r11 = new C00131(this.$this_isWindowVisible, r10);
                r11.L$0 = r5;
                return r11;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L16:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                kotlinx.coroutines.flow.h r12 = (kotlinx.coroutines.flow.h) this.L$0;
                if (this.$this_isWindowVisible.getWindowVisibility() != 0) goto L11;
                boolean r13 = true;
            L12:
                Boolean r14 = Boxing.boxBoolean(r13);
                this.label = 1;
                if (r12.emit(r14, this) != r10) goto L16;
                return r10;
            L11:
                r13 = false;
                goto L12
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
                return ((C00131) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public C01591(View r5, Continuation<? super C01591> r10) {
            this.$this_isWindowVisible = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C01591 r11 = new C01591(this.$this_isWindowVisible, r10);
            r11.L$0 = r5;
            return r11;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ViewTreeObserver r5, Continuation<? super kotlinx.coroutines.flow.g> r10) {
            return ((C01591) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r5);
            ViewTreeObserver r10 = (ViewTreeObserver) this.L$0;
            if (r10 == null) goto L11;
            kotlinx.coroutines.flow.g r11 = RepeatWhenAttachedKt.access$isWindowVisible(r10);
            if (r11 == null) goto L11;
            return new c0(r11, new C00131(this.$this_isWindowVisible, null));
        L11:
            return kotlinx.coroutines.flow.f.f18845a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(ViewTreeObserver r5, Continuation<? super kotlinx.coroutines.flow.g> r10) {
            return invoke2(r5, r10);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowVisible$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/u;", "", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isWindowVisible$2", f = "RepeatWhenAttached.kt", i = {}, l = {325}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01602 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewTreeObserver $this_isWindowVisible;
        private /* synthetic */ Object L$0;
        int label;

        public C01602(ViewTreeObserver r5, Continuation<? super C01602> r10) {
            this.$this_isWindowVisible = r5;
            super(2, r10);
        }

        public static /* synthetic */ void b(u r5, int r10) {
            invokeSuspend$lambda$0(r5, r10);
        }

        public static /* synthetic */ Unit f(ViewTreeObserver r5, e r10) {
            return invokeSuspend$lambda$1(r5, r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final void invokeSuspend$lambda$0(u r5, int r10) {
            if (r10 != 0) goto L4;
            boolean r11 = true;
        L5:
            j r12 = (j) r5;
            r12.g(Boolean.valueOf(r11));
            return;
        L4:
            r11 = false;
            goto L5
        }

        private static final Unit invokeSuspend$lambda$1(ViewTreeObserver r5, ViewTreeObserver.OnWindowVisibilityChangeListener r10) {
            androidx.room.b.g(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C01602 r11 = new C01602(this.$this_isWindowVisible, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            u r12 = (u) this.L$0;
            e r13 = new e(r12, 0);
            androidx.room.b.h(this.$this_isWindowVisible, r13);
            int r14 = 3;
            b r15 = new b(r14, this.$this_isWindowVisible, r13);
            this.label = 1;
            if (s.a(r12, r15, this) != r5) goto L12;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(u r5, Continuation<? super Unit> r10) {
            return ((C01602) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatOnWindowLifecycle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt", f = "RepeatWhenAttached.kt", i = {}, l = {187, 188, 189}, m = "repeatOnWindowLifecycle", n = {}, s = {})
    public static final class C01611 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01611(Continuation<? super C01611> r5) {
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return RepeatWhenAttachedKt.repeatOnWindowLifecycle(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenAttachedToWindow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt", f = "RepeatWhenAttached.kt", i = {}, l = {205, ComposerKt.referenceKey}, m = "repeatWhenAttachedToWindow", n = {}, s = {})
    public static final class C01621 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01621(Continuation<? super C01621> r5) {
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return RepeatWhenAttachedKt.repeatWhenAttachedToWindow(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenAttachedToWindow$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006H\n"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "", "Lkotlin/ParameterName;", "name", "value"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenAttachedToWindow$2", f = "RepeatWhenAttached.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01632 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenAttachedToWindow$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenAttachedToWindow$2$1", f = "RepeatWhenAttached.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super AnonymousClass1> r10) {
                this.$block = r5;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                AnonymousClass1 r11 = new AnonymousClass1(this.$block, r10);
                r11.L$0 = r5;
                return r11;
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
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                CoroutineScope r12 = (CoroutineScope) this.L$0;
                Function2<CoroutineScope, Continuation<? super Unit>, Object> r13 = this.$block;
                this.label = 1;
                if (r13.mo2invoke(r12, this) != r10) goto L12;
                return r10;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01632(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super C01632> r10) {
            this.$block = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C01632 r11 = new C01632(this.$block, r10);
            r11.Z$0 = ((Boolean) r5).booleanValue();
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Boolean r5, Continuation<? super Unit> r10) {
            return invoke(r5.booleanValue(), r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            if (this.Z$0 == false) goto L14;
            AnonymousClass1 r12 = new AnonymousClass1(this.$block, null);
            this.label = 1;
            if (h0.d(r12, this) != r10) goto L14;
            return r10;
        }

        public final Object invoke(boolean r5, Continuation<? super Unit> r10) {
            return ((C01632) create(Boolean.valueOf(r5), r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowHasFocus$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt", f = "RepeatWhenAttached.kt", i = {}, l = {237, 238}, m = "repeatWhenWindowHasFocus", n = {}, s = {})
    public static final class C01641 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01641(Continuation<? super C01641> r5) {
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return RepeatWhenAttachedKt.repeatWhenWindowHasFocus(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowHasFocus$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006H\n"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "", "Lkotlin/ParameterName;", "name", "value"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowHasFocus$2", f = "RepeatWhenAttached.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01652 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowHasFocus$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowHasFocus$2$1", f = "RepeatWhenAttached.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super AnonymousClass1> r10) {
                this.$block = r5;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                AnonymousClass1 r11 = new AnonymousClass1(this.$block, r10);
                r11.L$0 = r5;
                return r11;
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
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                CoroutineScope r12 = (CoroutineScope) this.L$0;
                Function2<CoroutineScope, Continuation<? super Unit>, Object> r13 = this.$block;
                this.label = 1;
                if (r13.mo2invoke(r12, this) != r10) goto L12;
                return r10;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01652(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super C01652> r10) {
            this.$block = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C01652 r11 = new C01652(this.$block, r10);
            r11.Z$0 = ((Boolean) r5).booleanValue();
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Boolean r5, Continuation<? super Unit> r10) {
            return invoke(r5.booleanValue(), r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            if (this.Z$0 == false) goto L14;
            AnonymousClass1 r12 = new AnonymousClass1(this.$block, null);
            this.label = 1;
            if (h0.d(r12, this) != r10) goto L14;
            return r10;
        }

        public final Object invoke(boolean r5, Continuation<? super Unit> r10) {
            return ((C01652) create(Boolean.valueOf(r5), r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowIsVisible$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt", f = "RepeatWhenAttached.kt", i = {}, l = {221, 222}, m = "repeatWhenWindowIsVisible", n = {}, s = {})
    public static final class C01661 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01661(Continuation<? super C01661> r5) {
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return RepeatWhenAttachedKt.repeatWhenWindowIsVisible(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowIsVisible$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006H\n"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "", "Lkotlin/ParameterName;", "name", "value"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowIsVisible$2", f = "RepeatWhenAttached.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01672 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowIsVisible$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenWindowIsVisible$2$1", f = "RepeatWhenAttached.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super AnonymousClass1> r10) {
                this.$block = r5;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                AnonymousClass1 r11 = new AnonymousClass1(this.$block, r10);
                r11.L$0 = r5;
                return r11;
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
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                CoroutineScope r12 = (CoroutineScope) this.L$0;
                Function2<CoroutineScope, Continuation<? super Unit>, Object> r13 = this.$block;
                this.label = 1;
                if (r13.mo2invoke(r12, this) != r10) goto L12;
                return r10;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01672(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super C01672> r10) {
            this.$block = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C01672 r11 = new C01672(this.$block, r10);
            r11.Z$0 = ((Boolean) r5).booleanValue();
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Boolean r5, Continuation<? super Unit> r10) {
            return invoke(r5.booleanValue(), r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            if (this.Z$0 == false) goto L14;
            AnonymousClass1 r12 = new AnonymousClass1(this.$block, null);
            this.label = 1;
            if (h0.d(r12, this) != r10) goto L14;
            return r10;
        }

        public final Object invoke(boolean r5, Continuation<? super Unit> r10) {
            return ((C01672) create(Boolean.valueOf(r5), r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        MAIN_DISPATCHER_SINGLETON = Dispatchers.getMain();
    }

    public static /* synthetic */ void a(Ref.ObjectRef r5, View r10, RepeatWhenAttachedKt$repeatWhenAttached$onAttachListener$1 r11) {
        repeatWhenAttached$lambda$0(r5, r10, r11);
    }

    public static final /* synthetic */ ViewLifecycleOwner access$createLifecycleOwnerAndRun(View r5, CoroutineContext r10, Function3 r11) {
        return createLifecycleOwnerAndRun(r5, r10, r11);
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.g access$isWindowFocused(ViewTreeObserver r5) {
        return isWindowFocused(r5);
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.g access$isWindowVisible(ViewTreeObserver r5) {
        return isWindowVisible(r5);
    }

    public static final <T> kotlinx.coroutines.flow.g conflatedCallbackFlow(Function2<? super u, ? super Continuation<? super Unit>, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        return kotlinx.coroutines.flow.i.e(new kotlinx.coroutines.flow.b(r5, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND), -1);
    }

    private static final ViewLifecycleOwner createLifecycleOwnerAndRun(View r10, CoroutineContext r11, Function3<? super LifecycleOwner, ? super View, ? super Continuation<? super Unit>, ? extends Object> r12) {
        ViewLifecycleOwner r5 = new ViewLifecycleOwner(r10);
        r5.onCreate();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r5), r11, null, new RepeatWhenAttachedKt$createLifecycleOwnerAndRun$1$1(r12, r5, r10, null), 2, null);
        return r5;
    }

    public static final <T, R> kotlinx.coroutines.flow.g flatMapLatestConflated(kotlinx.coroutines.flow.g r10, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.g>, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        RepeatWhenAttachedKt$flatMapLatestConflated$$inlined$flatMapLatest$1 r5 = new RepeatWhenAttachedKt$flatMapLatestConflated$$inlined$flatMapLatest$1(r11, null);
        int r12 = u0.f18908a;
        return kotlinx.coroutines.flow.i.e(new kotlinx.coroutines.flow.internal.i(r5, r10, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND), -1);
    }

    private static final kotlinx.coroutines.flow.g getCurrentViewTreeObserver(final View r5) {
        final kotlinx.coroutines.flow.g r10 = isAttached(r5);
        return new RepeatWhenAttachedKt$special$$inlined$map$1(r10, r5);
    }

    private static final kotlinx.coroutines.flow.g isAttached(View r5) {
        return conflatedCallbackFlow(new AnonymousClass1(r5, null));
    }

    public static final kotlinx.coroutines.flow.g isVisible(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return kotlinx.coroutines.flow.i.h(flatMapLatestConflated(isWindowVisible(r5), new C01571(r5, null)));
    }

    private static final kotlinx.coroutines.flow.g isWindowFocused(View r5) {
        return flatMapLatestConflated(getCurrentViewTreeObserver(r5), new C01581(r5, null));
    }

    private static final kotlinx.coroutines.flow.g isWindowVisible(View r5) {
        return flatMapLatestConflated(getCurrentViewTreeObserver(r5), new C01591(r5, null));
    }

    public static final Object repeatOnWindowLifecycle(View r10, WindowLifecycleState r11, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<?> r13) {
        if ((r13 instanceof C01611) == false) goto L7;
        C01611 r5 = (C01611) r13;
        int r14 = r5.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.label;
        if (r17 == 0) goto L18;
        if (r17 == 1) goto L17;
        if (r17 == 2) goto L16;
        if (r17 != 3) goto L14;
        ResultKt.throwOnFailure(r15);
    L26:
        throw new KotlinNothingValueException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r15);
    L33:
        throw new KotlinNothingValueException();
    L17:
        ResultKt.throwOnFailure(r15);
    L38:
        throw new KotlinNothingValueException();
    L18:
        ResultKt.throwOnFailure(r15);
        int r18 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r18 == 1) goto L34;
        if (r18 == 2) goto L29;
        if (r18 != 3) goto L28;
        r5.label = 3;
        if (repeatWhenWindowHasFocus(r10, r12, r5) != r16) goto L26;
    L36:
        return r16;
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        r5.label = 2;
        if (repeatWhenWindowIsVisible(r10, r12, r5) != r16) goto L33;
    L34:
        r5.label = 1;
        if (repeatWhenAttachedToWindow(r10, r12, r5) != r16) goto L38;
    L7:
        r5 = new C01611(r13);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$OnAttachStateChangeListener, com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$repeatWhenAttached$onAttachListener$1] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, com.bytedance.ai.ex.widget.ViewLifecycleOwner] */
    @MainThread
    public static final t0 repeatWhenAttached(final View r5, CoroutineContext r10, final Function3<? super LifecycleOwner, ? super View, ? super Continuation<? super Unit>, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "coroutineContext");
        Intrinsics.checkNotNullParameter(r11, "block");
        Assert.isMainThread();
        final CoroutineContext r12 = MAIN_DISPATCHER_SINGLETON.plus(r10);
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        final ?? r14 = new RepeatWhenAttachedKt$repeatWhenAttached$onAttachListener$1(r13, r5, r12, r11);
        r5.addOnAttachStateChangeListener(r14);
        if (r5.isAttachedToWindow() == false) goto L6;
        r13.element = createLifecycleOwnerAndRun(r5, r12, r11);
    L6:
        return new a(r13, r5, r14);
    }

    public static /* synthetic */ t0 repeatWhenAttached$default(View r5, CoroutineContext r10, Function3 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = EmptyCoroutineContext.INSTANCE;
    L6:
        return repeatWhenAttached(r5, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void repeatWhenAttached$lambda$0(Ref.ObjectRef r5, View r10, RepeatWhenAttachedKt$repeatWhenAttached$onAttachListener$1 r11) {
        Intrinsics.checkNotNullParameter(r5, "$lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "$view");
        Intrinsics.checkNotNullParameter(r11, "$onAttachListener");
        Assert.isMainThread();
        ViewLifecycleOwner r12 = (ViewLifecycleOwner) r5.element;
        if (r12 == null) goto L5;
        r12.onDestroy();
    L5:
        r5.element = null;
        r10.removeOnAttachStateChangeListener(r11);
    }

    @MainThread
    public static final Object repeatWhenAttachedToWindow(View r5, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<?> r11) {
        if ((r11 instanceof C01621) == false) goto L7;
        C01621 r12 = (C01621) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L13;
        ResultKt.throwOnFailure(r14);
    L23:
        throw new KotlinNothingValueException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
    L19:
        r12.label = 2;
        if (DelayKt.awaitCancellation(r12) != r15) goto L23;
    L21:
        return r15;
    L16:
        ResultKt.throwOnFailure(r14);
        Assert.isMainThread();
        kotlinx.coroutines.flow.g r17 = isAttached(r5);
        C01632 r18 = new C01632(r10, null);
        r12.label = 1;
        if (kotlinx.coroutines.flow.i.f(r17, r18, r12) != r15) goto L19;
    L7:
        r12 = new C01621(r11);
        goto L8
    }

    @MainThread
    public static final Object repeatWhenWindowHasFocus(View r5, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<?> r11) {
        if ((r11 instanceof C01641) == false) goto L7;
        C01641 r12 = (C01641) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L13;
        ResultKt.throwOnFailure(r14);
    L23:
        throw new KotlinNothingValueException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
    L19:
        r12.label = 2;
        if (DelayKt.awaitCancellation(r12) != r15) goto L23;
    L21:
        return r15;
    L16:
        ResultKt.throwOnFailure(r14);
        Assert.isMainThread();
        kotlinx.coroutines.flow.g r17 = isWindowFocused(r5);
        C01652 r18 = new C01652(r10, null);
        r12.label = 1;
        if (kotlinx.coroutines.flow.i.f(r17, r18, r12) != r15) goto L19;
    L7:
        r12 = new C01641(r11);
        goto L8
    }

    @MainThread
    public static final Object repeatWhenWindowIsVisible(View r5, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<?> r11) {
        if ((r11 instanceof C01661) == false) goto L7;
        C01661 r12 = (C01661) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L13;
        ResultKt.throwOnFailure(r14);
    L23:
        throw new KotlinNothingValueException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
    L19:
        r12.label = 2;
        if (DelayKt.awaitCancellation(r12) != r15) goto L23;
    L21:
        return r15;
    L16:
        ResultKt.throwOnFailure(r14);
        Assert.isMainThread();
        kotlinx.coroutines.flow.g r17 = isWindowVisible(r5);
        C01672 r18 = new C01672(r10, null);
        r12.label = 1;
        if (kotlinx.coroutines.flow.i.f(r17, r18, r12) != r15) goto L19;
    L7:
        r12 = new C01661(r11);
        goto L8
    }

    private static final kotlinx.coroutines.flow.g isWindowFocused(ViewTreeObserver r5) {
        return conflatedCallbackFlow(new AnonymousClass2(r5, null));
    }

    private static final kotlinx.coroutines.flow.g isWindowVisible(ViewTreeObserver r5) {
        return conflatedCallbackFlow(new C01602(r5, null));
    }
}
