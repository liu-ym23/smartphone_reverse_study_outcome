package com.obric.memorydata.memory.ui.automemory.create;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.google.android.material.card.MaterialCardView;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.databinding.FragmentAutoMemoryCollectionInfoBinding;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/FragmentAutoMemoryCollectionInfoBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showGenerateLoading", "", "loading", "", "showAiOptimizeDialog", "visible", "Companion", "memory_obricRelease", "imeHeightStore", "Lcom/obric/memorydata/middleware/api/store/IStore;"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryCreateCollectionInfoFragment extends BaseFragment {
    private static final a Companion = null;
    private static final String KEY_CREATE_TASK_IME_HEIGHT_CACHE = "create_task_ime_height_cache_v1";
    private static final String TAG_HEIGHT = "MeD_CreateInfoHeight";
    private FragmentAutoMemoryCollectionInfoBinding binding;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment$Companion;", "", "<init>", "()V", "TAG_HEIGHT", "", "KEY_CREATE_TASK_IME_HEIGHT_CACHE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements kotlinx.coroutines.flow.i<AutoMemoryCreateCollectionStep> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10625a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10626a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f10626a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$1$2$1.class) == false) goto L7;
                AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$1$2$1 r0 = (AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r8, AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f10626a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                AutoMemoryCreateCollectionStep r11 = ((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).g();
                r0.label = 1;
                if (r5.emit(r11, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$1$2$1(this, r8);
                goto L8
            }
        }

        public b(kotlinx.coroutines.flow.i r3) {
            this.f10625a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super AutoMemoryCreateCollectionStep> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10625a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10627a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10628a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f10628a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$2$2$1.class) == false) goto L7;
                AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$2$2$1 r0 = (AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r8, AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L24:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f10628a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                com.obric.memorydata.memory.ui.automemory.create.b r11 = (com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin");
                if (r11.i() == true) goto L17;
            L19:
                boolean r12 = false;
            L20:
                Boolean r13 = Boxing.boxBoolean(r12);
                r0.label = 1;
                if (r5.emit(r13, r0) != r2) goto L24;
                return r2;
            L17:
                if (r11.g() != AutoMemoryCreateCollectionStep.EDIT_INFO) goto L19;
                r12 = true;
            L7:
                r0 = new AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$2$2$1(this, r8);
                goto L8
            }
        }

        public c(kotlinx.coroutines.flow.i r3) {
            this.f10627a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super Boolean> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10627a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements kotlinx.coroutines.flow.i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10629a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$d$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10630a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f10630a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$3$2$1.class) == false) goto L7;
                AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$3$2$1 r0 = (AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$3$2$1) ZeusTransformUtils.preCheckCast(r8, AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$3$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f10630a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                String r11 = ((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).c();
                r0.label = 1;
                if (r5.emit(r11, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$3$2$1(this, r8);
                goto L8
            }
        }

        public d(kotlinx.coroutines.flow.i r3) {
            this.f10629a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super String> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10629a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements kotlinx.coroutines.flow.i<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10631a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$e$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10632a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f10632a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$4$2$1.class) == false) goto L7;
                AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$4$2$1 r0 = (AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$4$2$1) ZeusTransformUtils.preCheckCast(r8, AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$4$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f10632a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Integer r11 = Boxing.boxInt(((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).h());
                r0.label = 1;
                if (r5.emit(r11, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$4$2$1(this, r8);
                goto L8
            }
        }

        public e(kotlinx.coroutines.flow.i r3) {
            this.f10631a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super Integer> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10631a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoMemoryCreateCollectionInfoFragment f10633a;

        f(AutoMemoryCreateCollectionInfoFragment r1) {
            this.f10633a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f10633a.isAdded() == true) goto L5;
            return;
        L5:
            AutoMemoryCreateCollectionInfoFragment.access$onCreateView$ensureDescInputFullyVisible(this.f10633a);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"com/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment$onCreateView$InputContentGeometry", "", "contentHeight", "", "textHeight", "lineCount", "lineHeight", "availableTextWidth", "verticalPadding", "<init>", "(IIIIII)V", "getContentHeight", "()I", "getTextHeight", "getLineCount", "getLineHeight", "getAvailableTextWidth", "getVerticalPadding", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IIIIII)Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment$onCreateView$InputContentGeometry;", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10635b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;

        public g(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.f10634a = r1;
            this.f10635b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final int a() {
            return this.f10634a;
        }

        public final int b() {
            return this.f10635b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
            if (this.f10634a == r6.f10634a) goto L12;
            return false;
        L12:
            if (this.f10635b == r6.f10635b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.f10634a) * 31) + Integer.hashCode(this.f10635b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
        }

        public String toString() {
            return "InputContentGeometry(contentHeight=" + this.f10634a + ", textHeight=" + this.f10635b + ", lineCount=" + this.c + ", lineHeight=" + this.d + ", availableTextWidth=" + this.e + ", verticalPadding=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J@\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"com/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment$onCreateView$InputHeightConfigKey", "", "densityDpi", "", "fontScaleBits", "screenWidthDp", "screenHeightDp", "orientation", "<init>", "(IIIII)V", "getDensityDpi", "()I", "getFontScaleBits", "getScreenWidthDp", "getScreenHeightDp", "getOrientation", "component1", "component2", "component3", "component4", "component5", "copy", "(IIIII)Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment$onCreateView$InputHeightConfigKey;", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10637b;
        private final int c;
        private final int d;
        private final int e;

        public h(int r1, int r2, int r3, int r4, int r5) {
            this.f10636a = r1;
            this.f10637b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
            if (this.f10636a == r6.f10636a) goto L12;
            return false;
        L12:
            if (this.f10637b == r6.f10637b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f10636a) * 31) + Integer.hashCode(this.f10637b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "InputHeightConfigKey(densityDpi=" + this.f10636a + ", fontScaleBits=" + this.f10637b + ", screenWidthDp=" + this.c + ", screenHeightDp=" + this.d + ", orientation=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J6\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"com/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment$onCreateView$InputHeightGeometry", "", "availableHeight", "", "inputTopInRoot", "bottomBarReserve", "buttonHeight", "<init>", "(IIII)V", "getAvailableHeight", "()I", "getInputTopInRoot", "getBottomBarReserve", "getButtonHeight", "component1", "component2", "component3", "component4", "copy", "(IIII)Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment$onCreateView$InputHeightGeometry;", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10639b;
        private final int c;
        private final int d;

        public i(int r1, int r2, int r3, int r4) {
            this.f10638a = r1;
            this.f10639b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final int a() {
            return this.f10638a;
        }

        public final int b() {
            return this.f10639b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
            return false;
        L8:
            i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
            if (this.f10638a == r6.f10638a) goto L12;
            return false;
        L12:
            if (this.f10639b == r6.f10639b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f10638a) * 31) + Integer.hashCode(this.f10639b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "InputHeightGeometry(availableHeight=" + this.f10638a + ", inputTopInRoot=" + this.f10639b + ", bottomBarReserve=" + this.c + ", buttonHeight=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment$onCreateView$applyDescInputHeight$layoutListener$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class j implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f10640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout f10641b;
        final /* synthetic */ OEditText c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ AutoMemoryCreateCollectionInfoFragment g;

        j(int r1, FrameLayout r2, OEditText r3, int r4, String r5, String r6, AutoMemoryCreateCollectionInfoFragment r7) {
            this.f10640a = r1;
            this.f10641b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        private static final void a(String r1, AutoMemoryCreateCollectionInfoFragment r2) {
            AutoMemoryCreateCollectionInfoFragment.access$onCreateView$syncInputScrollToCursor(r2, r1 + "_layoutComplete");
        }

        public static /* synthetic */ void lambda$7MwnMYoZc7yguYfYWqLEAuwZZO0(String r0, AutoMemoryCreateCollectionInfoFragment r1) {
            a(r0, r1);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
            Intrinsics.checkNotNullParameter(r11, "view");
            if (r11.getHeight() == this.f10640a) goto L5;
            return;
        L5:
            this.f10641b.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            com.obric.memorydata.middleware.api.a.b r1 = com.obric.memorydata.middleware.api.a.b.f11600a;
            int r2 = this.d;
            String r4 = this.e;
            String r5 = this.f;
            AutoMemoryCreateCollectionInfoFragment r6 = this.g;
            OEditText r7 = this.c;
            if (r1.a() == false) goto L15;
            RunLog r3 = RunLog.INSTANCE;
            StringBuilder r8 = new StringBuilder().append("layout#").append(r2).append("[inputHeight/").append(r4).append('/').append(r5).append("] old=(").append(r18 - r16).append(',').append(r19 - r17).append(") new=(").append(r14 - r12).append(',').append(r15 - r13).append(") input=");
            FragmentAutoMemoryCollectionInfoBinding r9 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(r6);
            FragmentAutoMemoryCollectionInfoBinding r10 = null;
            if (r9 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r9 = null;
        L10:
            OInputLayout r20 = r9.descInput;
            Intrinsics.checkNotNullExpressionValue(r20, "descInput");
            StringBuilder r21 = r8.append(AutoMemoryCreateCollectionInfoFragment.access$onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.memorydata.plugin"))).append(" edit=").append(AutoMemoryCreateCollectionInfoFragment.access$onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"))).append(" button=");
            FragmentAutoMemoryCollectionInfoBinding r22 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(r6);
            if (r22 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L14:
            OButton r23 = r10.nextButton;
            Intrinsics.checkNotNullExpressionValue(r23, "nextButton");
            r3.debug(AutoMemoryCreateCollectionInfoFragment.TAG_HEIGHT, r21.append(AutoMemoryCreateCollectionInfoFragment.access$onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r23, View.class, "com.obric.memorydata.plugin"))).toString());
            goto L15
        L13:
            r10 = r22;
        L15:
            OEditText r24 = this.c;
            final String r25 = this.e;
            final AutoMemoryCreateCollectionInfoFragment r0 = this.g;
            r24.post(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$j$7MwnMYoZc7yguYfYWqLEAuwZZO0(r25, r0));
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class k implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OEditText f10642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f10643b;
        final /* synthetic */ AutoMemoryCreateCollectionInfoFragment c;
        final /* synthetic */ Ref.IntRef d;
        final /* synthetic */ Ref.ObjectRef e;
        final /* synthetic */ Ref.IntRef f;
        final /* synthetic */ Ref.BooleanRef g;
        final /* synthetic */ Ref.ObjectRef h;
        final /* synthetic */ Ref.ObjectRef i;
        final /* synthetic */ Ref.BooleanRef j;
        final /* synthetic */ Context k;
        final /* synthetic */ Lazy l;

        public k(OEditText r2, Ref.IntRef r3, AutoMemoryCreateCollectionInfoFragment r4, Ref.IntRef r5, Ref.ObjectRef r6, Ref.IntRef r7, Ref.BooleanRef r8, Ref.ObjectRef r9, Ref.ObjectRef r10, Ref.BooleanRef r11, Context r12, Lazy r13, AutoMemoryCreateCollectionInfoFragment r14) {
            Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
            Lazy r16 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r13, Lazy.class, "com.obric.memorydata.plugin");
            this.f10642a = r2;
            this.f10643b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = ZeusTransformUtils.wrapperContext(r15, "com.obric.memorydata.plugin");
            this.l = r16;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r17) {
            Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r17, Editable.class, "com.obric.memorydata.plugin");
            AutoMemoryCreateCollectionInfoFragment.access$onCreateView$updateDescInputHeight(this.f10643b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, true, "afterTextChanged");
            Layout r2 = this.f10642a.getLayout();
            if (r2 == null) goto L5;
            int r3 = r2.getLineForOffset(this.f10642a.getSelectionStart());
        L7:
            if (r2 == null) goto L9;
            int r4 = r2.getLineCount();
        L10:
            int r5 = r4 - 1;
            if (r3 >= 0) goto L13;
            return;
        L13:
            if ((r5 - r3) > 2) goto L17;
            this.f10642a.post((Runnable) ZeusTransformUtils.preCheckCast(new f(this.c), Runnable.class, "com.obric.memorydata.plugin"));
            return;
        L17:
            return;
        L9:
            r4 = 1;
            goto L10
        L5:
            r3 = -1;
            goto L7
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            FragmentAutoMemoryCollectionInfoBinding r7 = null;
            if (r6 == null) goto L5;
            String r8 = r6.toString();
        L6:
            if (r8 != null) goto L8;
            r8 = "";
        L8:
            FragmentAutoMemoryCollectionInfoBinding r9 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.c);
            if (r9 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L12:
            r7.descInputCounter.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.length() + "/2000", CharSequence.class, "com.obric.memorydata.plugin"));
            AutoMemoryCreateCollectionInfoFragment.access$getViewModel(this.c).onContentChanged(r8);
            AutoMemoryCreateCollectionInfoFragment.access$getViewModel(this.c).onNameChanged(StringsKt.take(r8, 8));
            return;
        L11:
            r7 = r9;
            goto L12
        L5:
            r8 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionInfoFragment$onCreateView$requestImeForHeightMeasurement$1", "Ljava/lang/Runnable;", "attempt", "", "run", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoMemoryCreateCollectionInfoFragment f10644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OEditText f10645b;
        final /* synthetic */ Ref.IntRef c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        private int f;

        l(AutoMemoryCreateCollectionInfoFragment r3, OEditText r4, Ref.IntRef r5, Context r6, String r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            this.f10644a = r3;
            this.f10645b = r4;
            this.c = r5;
            this.d = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
            this.e = r7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10644a.isAdded() == true) goto L5;
            return;
        L5:
            if (this.f10645b.isAttachedToWindow() == false) goto L42;
            WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets((View) ZeusTransformUtils.preCheckCast(this.f10645b, View.class, "com.obric.memorydata.plugin"));
            boolean r1 = false;
            if (r0 != null) goto L10;
        L12:
            boolean r2 = false;
        L13:
            if (r2 == false) goto L15;
            return;
        L15:
            if (this.c.element > 0) goto L43;
            this.f++;
            if (this.f10645b.isShown() == true) goto L20;
        L32:
            com.obric.memorydata.middleware.api.a.b r3 = com.obric.memorydata.middleware.api.a.b.f11600a;
            String r4 = this.e;
            OEditText r5 = this.f10645b;
            if (r3.a() == false) goto L36;
            RunLog.INSTANCE.debug(AutoMemoryCreateCollectionInfoFragment.TAG_HEIGHT, "requestIme[" + r4 + "] attempt=" + this.f + " requested=" + r1 + " focused=" + r5.hasFocus() + " shown=" + r5.isShown() + " windowFocus=" + r5.hasWindowFocus() + " laidOut=" + ViewCompat.isLaidOut((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin")) + " input=" + AutoMemoryCreateCollectionInfoFragment.access$onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin")));
        L36:
            if (this.f >= 12) goto L41;
            this.f10645b.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"), 120);
            return;
        L41:
            return;
        L20:
            if (this.f10645b.getWindowToken() == null) goto L32;
            WindowInsetsControllerCompat r6 = ViewCompat.getWindowInsetsController((View) ZeusTransformUtils.preCheckCast(this.f10645b, View.class, "com.obric.memorydata.plugin"));
            if (r6 == null) goto L24;
            r6.show(WindowInsetsCompat.Type.ime());
        L24:
            Object r7 = this.d.getSystemService("input_method");
            if (ZeusTransformUtils.instanceOf(r7, InputMethodManager.class) == false) goto L27;
            InputMethodManager r8 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r7, InputMethodManager.class, "com.obric.memorydata.plugin");
        L28:
            if (r8 == null) goto L32;
            if (r8.showSoftInput((View) ZeusTransformUtils.preCheckCast(this.f10645b, View.class, "com.obric.memorydata.plugin"), 1) != true) goto L32;
            r1 = true;
            goto L32
        L27:
            r8 = null;
            goto L28
        L43:
            return;
        L10:
            if (r0.isVisible(WindowInsetsCompat.Type.ime()) != true) goto L12;
            r2 = true;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$10, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "updatedStep", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionStep;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$10", f = "AutoMemoryCreateCollectionInfoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass10 extends SuspendLambda implements Function2<AutoMemoryCreateCollectionStep, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AutoMemoryCreateCollectionInfoFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$10$a */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10646a = null;

            static {
                int[] r0 = new int[AutoMemoryCreateCollectionStep.values().length];
                r0[AutoMemoryCreateCollectionStep.EDIT_INFO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[AutoMemoryCreateCollectionStep.AI_OPTIMIZING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[AutoMemoryCreateCollectionStep.GENERATE_RECOMMEND_APP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f10646a = r0;
            }
        }

        AnonymousClass10(AutoMemoryCreateCollectionInfoFragment r3, Continuation<? super AnonymousClass10> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass10 r0 = new AnonymousClass10(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(AutoMemoryCreateCollectionStep r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass10) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass10.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(AutoMemoryCreateCollectionStep r3, Continuation<? super Unit> r4) {
            return invoke2((AutoMemoryCreateCollectionStep) ZeusTransformUtils.preCheckCast(r3, AutoMemoryCreateCollectionStep.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L40;
            ResultKt.throwOnFailure(r10);
            int r11 = a.f10646a[((AutoMemoryCreateCollectionStep) ZeusTransformUtils.preCheckCast(this.L$0, AutoMemoryCreateCollectionStep.class, "com.obric.memorydata.plugin")).ordinal()];
            FragmentAutoMemoryCollectionInfoBinding r4 = null;
            if (r11 != 1) goto L7;
            FragmentAutoMemoryCollectionInfoBinding r12 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r12 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r12 = null;
        L29:
            r12.nextButton.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_create_collection_next_step, TypedValues.Custom.S_STRING, "memory_create_collection_next_step")), CharSequence.class, "com.obric.memorydata.plugin"));
            FragmentAutoMemoryCollectionInfoBinding r13 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r13 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r13 = null;
        L32:
            r13.nextButton.setVisibility(0);
            AutoMemoryCreateCollectionInfoFragment.access$showAiOptimizeDialog(this.this$0, false);
            AutoMemoryCreateCollectionInfoFragment.access$showGenerateLoading(this.this$0, false);
            FragmentAutoMemoryCollectionInfoBinding r9 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r9 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L36:
            r4.descInput.getVInput().setEnabled(true);
        L38:
            return Unit.INSTANCE;
        L35:
            r4 = r9;
            goto L36
        L7:
            if (r11 != 2) goto L9;
            AutoMemoryCreateCollectionInfoFragment.access$showAiOptimizeDialog(this.this$0, true);
            goto L38
        L9:
            if (r11 != 3) goto L38;
            FragmentAutoMemoryCollectionInfoBinding r14 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r14 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r14 = null;
        L14:
            r14.nextButton.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
            FragmentAutoMemoryCollectionInfoBinding r15 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r15 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r15 = null;
        L17:
            r15.generateLoadingText.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_recommend_app_loading, TypedValues.Custom.S_STRING, "memory_recommend_app_loading")), CharSequence.class, "com.obric.memorydata.plugin"));
            AutoMemoryCreateCollectionInfoFragment.access$showGenerateLoading(this.this$0, true);
            FragmentAutoMemoryCollectionInfoBinding r16 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r16 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r16 = null;
        L20:
            r16.descInput.setEnabled(false);
            FragmentAutoMemoryCollectionInfoBinding r17 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r17 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L24:
            r4.descInput.getVInput().clearFocus();
            goto L38
        L23:
            r4 = r17;
            goto L24
        L40:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$12, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "enabled", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$12", f = "AutoMemoryCreateCollectionInfoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass12 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ AutoMemoryCreateCollectionInfoFragment this$0;

        AnonymousClass12(AutoMemoryCreateCollectionInfoFragment r3, Continuation<? super AnonymousClass12> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass12 r0 = new AnonymousClass12(this.this$0, r5);
            r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
            return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
            Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return ((AnonymousClass12) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), AnonymousClass12.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            boolean r3 = this.Z$0;
            FragmentAutoMemoryCollectionInfoBinding r1 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r1 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r1 = null;
        L7:
            r1.nextButton.setEnabled(r3);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$14, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "newContent", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$14", f = "AutoMemoryCreateCollectionInfoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass14 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AutoMemoryCreateCollectionInfoFragment this$0;

        AnonymousClass14(AutoMemoryCreateCollectionInfoFragment r3, Continuation<? super AnonymousClass14> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass14 r0 = new AnonymousClass14(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(String r3, Continuation<? super Unit> r4) {
            return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(String r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass14) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass14.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L26;
            ResultKt.throwOnFailure(r6);
            String r7 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
            FragmentAutoMemoryCollectionInfoBinding r0 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            FragmentAutoMemoryCollectionInfoBinding r3 = null;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r0 = null;
        L7:
            OEditText r1 = r0.descInput.getVInput();
            Editable r4 = r1.getText();
            if (r4 == null) goto L10;
            String r5 = r4.toString();
        L12:
            if (Intrinsics.areEqual(r5, r7) == true) goto L14;
            FragmentAutoMemoryCollectionInfoBinding r8 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r8 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L19:
            r3.descInput.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"));
            Editable r9 = r1.getText();
            if (r9 == null) goto L22;
            int r10 = r9.length();
        L23:
            r1.setSelection(r10);
            return Unit.INSTANCE;
        L22:
            r10 = 0;
            goto L23
        L18:
            r3 = r8;
            goto L19
        L14:
            return Unit.INSTANCE;
        L10:
            r5 = null;
            goto L12
        L26:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$16, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "imeBottom", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$16", f = "AutoMemoryCreateCollectionInfoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass16 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $ctx;
        final /* synthetic */ Ref.BooleanRef $hasAppliedInitialHeight;
        final /* synthetic */ Ref.BooleanRef $hasLoadedPersistedImeHeight;
        final /* synthetic */ Ref.IntRef $heightUpdateSequence;
        final /* synthetic */ Lazy<IStore> $imeHeightStore$delegate;
        final /* synthetic */ Ref.IntRef $imeLayoutRetryCount;
        final /* synthetic */ Ref.IntRef $latestImeBottom;
        final /* synthetic */ Ref.ObjectRef<h> $measuredImeConfigKey;
        final /* synthetic */ Ref.ObjectRef<Integer> $measuredImeInputHeight;
        final /* synthetic */ Ref.ObjectRef<com.obric.memorydata.memory.ui.automemory.create.e> $persistedImeHeightRecord;
        /* synthetic */ int I$0;
        int label;
        final /* synthetic */ AutoMemoryCreateCollectionInfoFragment this$0;

        AnonymousClass16(Ref.IntRef r3, AutoMemoryCreateCollectionInfoFragment r4, Ref.IntRef r5, Ref.ObjectRef<Integer> r6, Ref.IntRef r7, Ref.BooleanRef r8, Ref.ObjectRef<h> r9, Ref.ObjectRef<com.obric.memorydata.memory.ui.automemory.create.e> r10, Ref.BooleanRef r11, Context r12, Lazy<? extends IStore> r13, Continuation<? super AnonymousClass16> r14) {
            Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
            Lazy<IStore> r16 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r13, Lazy.class, "com.obric.memorydata.plugin");
            Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
            this.$latestImeBottom = r3;
            this.this$0 = r4;
            this.$heightUpdateSequence = r5;
            this.$measuredImeInputHeight = r6;
            this.$imeLayoutRetryCount = r7;
            this.$hasAppliedInitialHeight = r8;
            this.$measuredImeConfigKey = r9;
            this.$persistedImeHeightRecord = r10;
            this.$hasLoadedPersistedImeHeight = r11;
            this.$ctx = ZeusTransformUtils.wrapperContext(r15, "com.obric.memorydata.plugin");
            this.$imeHeightStore$delegate = r16;
            super(2, r17);
        }

        private static final void invokeSuspend$lambda$1(AutoMemoryCreateCollectionInfoFragment r0) {
            AutoMemoryCreateCollectionInfoFragment.access$onCreateView$ensureDescInputFullyVisible(r0);
        }

        public static /* synthetic */ void lambda$NDW1Jf_9Jws7HInzMSCSvVUZ_9o(AutoMemoryCreateCollectionInfoFragment r0) {
            invokeSuspend$lambda$1(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
            Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass16 r1 = new AnonymousClass16(this.$latestImeBottom, this.this$0, this.$heightUpdateSequence, this.$measuredImeInputHeight, this.$imeLayoutRetryCount, this.$hasAppliedInitialHeight, this.$measuredImeConfigKey, this.$persistedImeHeightRecord, this.$hasLoadedPersistedImeHeight, this.$ctx, this.$imeHeightStore$delegate, r15);
            r1.I$0 = ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue();
            return (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");
        }

        public final Object invoke(int r3, Continuation<? super Unit> r4) {
            Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return ((AnonymousClass16) ZeusTransformUtils.preCheckCast(create(Integer.valueOf(r3), r5), AnonymousClass16.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Integer r3, Continuation<? super Unit> r4) {
            return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r23) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L28;
            ResultKt.throwOnFailure(r23);
            int r1 = this.I$0;
            int r2 = this.$latestImeBottom.element;
            this.$latestImeBottom.element = r1;
            com.obric.memorydata.middleware.api.a.b r3 = com.obric.memorydata.middleware.api.a.b.f11600a;
            AutoMemoryCreateCollectionInfoFragment r4 = this.this$0;
            if (r3.a() == false) goto L13;
            RunLog r5 = RunLog.INSTANCE;
            StringBuilder r7 = new StringBuilder().append("imeBottom old=").append(r2).append(" new=").append(r1).append(" delta=").append(r1 - r2).append(" layer=");
            FragmentAutoMemoryCollectionInfoBinding r8 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(r4);
            if (r8 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r8 = null;
        L9:
            FrameLayout r9 = r8.descInputLayer;
            Intrinsics.checkNotNullExpressionValue(r9, "descInputLayer");
            StringBuilder r10 = r7.append(AutoMemoryCreateCollectionInfoFragment.access$onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"))).append(" button=");
            FragmentAutoMemoryCollectionInfoBinding r6 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(r4);
            if (r6 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r6 = null;
        L12:
            OButton r11 = r6.nextButton;
            Intrinsics.checkNotNullExpressionValue(r11, "nextButton");
            r5.debug(AutoMemoryCreateCollectionInfoFragment.TAG_HEIGHT, r10.append(AutoMemoryCreateCollectionInfoFragment.access$onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"))).toString());
        L13:
            AutoMemoryCreateCollectionInfoFragment.access$onCreateView$updateDescInputHeight(this.$heightUpdateSequence, this.this$0, this.$latestImeBottom, this.$measuredImeInputHeight, this.$imeLayoutRetryCount, this.$hasAppliedInitialHeight, this.$measuredImeConfigKey, this.$persistedImeHeightRecord, this.$hasLoadedPersistedImeHeight, this.$ctx, this.$imeHeightStore$delegate, true, "imeBottom:" + r2 + "->" + r1);
            if (r1 <= 0) goto L26;
            FragmentAutoMemoryCollectionInfoBinding r12 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r12 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r12 = null;
        L19:
            if (r12.descInput.getVInput().hasFocus() == false) goto L26;
            FragmentAutoMemoryCollectionInfoBinding r13 = AutoMemoryCreateCollectionInfoFragment.access$getBinding$p(this.this$0);
            if (r13 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            FragmentAutoMemoryCollectionInfoBinding r14 = null;
        L24:
            FrameLayout r15 = r14.getRoot();
            final AutoMemoryCreateCollectionInfoFragment r0 = this.this$0;
            r15.postDelayed(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$onCreateView$16$NDW1Jf_9Jws7HInzMSCSvVUZ_9o(r0), 100);
            goto L26
        L23:
            r14 = r13;
        L26:
            return Unit.INSTANCE;
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoMemoryCreateCollectionInfoFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$ACSnaJK0pc_NcCW2YuKrct85Wes(this));
    }

    public static final /* synthetic */ FragmentAutoMemoryCollectionInfoBinding access$getBinding$p(AutoMemoryCreateCollectionInfoFragment r0) {
        return r0.binding;
    }

    public static final /* synthetic */ AutoMemoryCreateCollectionViewModel access$getViewModel(AutoMemoryCreateCollectionInfoFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ String access$onCreateView$bounds(View r0) {
        return onCreateView$bounds(r0);
    }

    public static final /* synthetic */ void access$onCreateView$ensureDescInputFullyVisible(AutoMemoryCreateCollectionInfoFragment r0) {
        onCreateView$ensureDescInputFullyVisible(r0);
    }

    public static final /* synthetic */ void access$onCreateView$syncInputScrollToCursor(AutoMemoryCreateCollectionInfoFragment r0, String r1) {
        onCreateView$syncInputScrollToCursor(r0, r1);
    }

    public static final /* synthetic */ void access$onCreateView$updateDescInputHeight(Ref.IntRef r15, AutoMemoryCreateCollectionInfoFragment r16, Ref.IntRef r17, Ref.ObjectRef r18, Ref.IntRef r19, Ref.BooleanRef r20, Ref.ObjectRef r21, Ref.ObjectRef r22, Ref.BooleanRef r23, Context r24, Lazy r25, boolean r26, String r27) {
        onCreateView$updateDescInputHeight(r15, r16, r17, r18, r19, r20, r21, r22, r23, (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.memorydata.plugin"), (Lazy) ZeusTransformUtils.wrapperContextForParams(r25, Lazy.class, "com.obric.memorydata.plugin"), r26, r27);
    }

    public static final /* synthetic */ void access$showAiOptimizeDialog(AutoMemoryCreateCollectionInfoFragment r0, boolean r1) {
        r0.showAiOptimizeDialog(r1);
    }

    public static final /* synthetic */ void access$showGenerateLoading(AutoMemoryCreateCollectionInfoFragment r0, boolean r1) {
        r0.showGenerateLoading(r1);
    }

    private final AutoMemoryCreateCollectionViewModel getViewModel() {
        return (AutoMemoryCreateCollectionViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), AutoMemoryCreateCollectionViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$0XP5VOHhc3KOgBeEh_6YostjBBI(AutoMemoryCreateCollectionInfoFragment r0, View r1) {
        onCreateView$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ void lambda$528FPLpIIqE1XpdNXvCcLJX45bA(AutoMemoryCreateCollectionInfoFragment r0, Ref.IntRef r1, Context r2) {
        onCreateView$lambda$60$lambda$59(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$9Ob9TxZPg2U5AcL-MWJFTo8QtcA, reason: not valid java name */
    public static /* synthetic */ void m794lambda$9Ob9TxZPg2U5AcLMWJFTo8QtcA(Ref.ObjectRef r0, Ref.ObjectRef r1, Ref.ObjectRef r2, AutoMemoryCreateCollectionInfoFragment r3, Ref.IntRef r4, Ref.IntRef r5, Ref.IntRef r6, Ref.BooleanRef r7, Ref.ObjectRef r8, Ref.BooleanRef r9, Context r10, Lazy r11, View r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        onCreateView$lambda$43(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ AutoMemoryCreateCollectionViewModel lambda$ACSnaJK0pc_NcCW2YuKrct85Wes(AutoMemoryCreateCollectionInfoFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$E9JqpixDwXuUD6tXbZvNvOdBXF0(String r0, AutoMemoryCreateCollectionInfoFragment r1) {
        onCreateView$applyDescInputHeight$lambda$28(r0, r1);
    }

    public static /* synthetic */ void lambda$FyaJTvlgOV6v9SyOCLseiS_b2is(AutoMemoryCreateCollectionInfoFragment r0, Ref.ObjectRef r1, Ref.IntRef r2, Ref.IntRef r3, String r4, int r5, boolean r6, Ref.BooleanRef r7, Ref.ObjectRef r8, Ref.ObjectRef r9, Ref.BooleanRef r10, Context r11, Lazy r12, Ref.IntRef r13) {
        onCreateView$updateDescInputHeight$lambda$42(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: lambda$SGvKp-IEjlNwH7bxOVeyKD59Ngg, reason: not valid java name */
    public static /* synthetic */ void m795lambda$SGvKpIEjlNwH7bxOVeyKD59Ngg(AutoMemoryCreateCollectionInfoFragment r0, View r1) {
        onCreateView$lambda$54$lambda$53(r0, r1);
    }

    public static /* synthetic */ boolean lambda$W2WTSWZDeO8FFJTO6FC0N9X8ogE(AutoMemoryCreateCollectionInfoFragment r0, View r1, MotionEvent r2) {
        return onCreateView$lambda$49$lambda$46(r0, r1, r2);
    }

    public static /* synthetic */ IStore lambda$amISkYlRyKYVcQJi5bhKt09Flw8() {
        return onCreateView$lambda$5();
    }

    /* JADX INFO: renamed from: lambda$c0orgtqHLKBq4wstkdx0G4F5U-I, reason: not valid java name */
    public static /* synthetic */ void m796lambda$c0orgtqHLKBq4wstkdx0G4F5UI(AutoMemoryCreateCollectionInfoFragment r0, FrameLayout r1, NestedScrollView r2) {
        onCreateView$ensureDescInputFullyVisible$lambda$44(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$dC5JLqD_BEFUbQZREwwZecSE4_Q(AutoMemoryCreateCollectionInfoFragment r0, String r1) {
        onCreateView$syncInputScrollToCursor$lambda$19(r0, r1);
    }

    public static /* synthetic */ void lambda$dfi0KfJ8OUsP8d4BNIbE_5kAOWE(String r0, Ref.IntRef r1, Ref.IntRef r2, AutoMemoryCreateCollectionInfoFragment r3, Ref.IntRef r4, Ref.ObjectRef r5, Ref.BooleanRef r6, Ref.ObjectRef r7, Ref.ObjectRef r8, Ref.BooleanRef r9, Context r10, Lazy r11) {
        onCreateView$updateDescInputHeight$lambda$42$lambda$38(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit lambda$hPNaqElTbL0KP31Gyq0591owXAQ(AutoMemoryCreateCollectionInfoFragment r0, String r1) {
        return onCreateView$lambda$54$lambda$53$lambda$52(r0, r1);
    }

    public static /* synthetic */ void lambda$mJFQnEnzK5NwbxnjEiQCPDxPBII(int r0, String r1, String r2, boolean r3, AutoMemoryCreateCollectionInfoFragment r4) {
        onCreateView$applyDescInputHeight$lambda$30(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$mywq2IWiURxDENedwWjmmUSQ1_k(int r0, String r1, String r2, View r3, AutoMemoryCreateCollectionInfoFragment r4) {
        onCreateView$updateBottomBarGravity$applyBottomBarGravity$lambda$17$lambda$16(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$t3UWkoakWlaU0pndSEjf732G-yM, reason: not valid java name */
    public static /* synthetic */ void m797lambda$t3UWkoakWlaU0pndSEjf732GyM(FrameLayout r0, j r1, int r2, String r3, AutoMemoryCreateCollectionInfoFragment r4) {
        onCreateView$applyDescInputHeight$lambda$25(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$v2TCf5n1TS1_MyiWZRGG0ciEcao(int r0, String r1, String r2, View r3, AutoMemoryCreateCollectionInfoFragment r4) {
        onCreateView$updateBottomBarGravity$applyBottomBarGravity$lambda$17$lambda$14(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$wTlEyVfVxzonoafTt9WHIvZCtR4(AutoMemoryCreateCollectionInfoFragment r0, NestedScrollView r1, int r2, int r3, int r4, int r5) {
        onCreateView$lambda$45(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$xm1mbZiEcZl0dw6IAHH6nJgNeeA(AutoMemoryCreateCollectionInfoFragment r0, int r1, View r2, WindowInsetsCompat r3) {
        return onCreateView$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$z7PcwElQijs4TMhtykJD4vKO3aA(AutoMemoryCreateCollectionInfoFragment r0, Ref.IntRef r1, Ref.IntRef r2, Ref.ObjectRef r3, Ref.IntRef r4, Ref.BooleanRef r5, Ref.ObjectRef r6, Ref.ObjectRef r7, Ref.BooleanRef r8, Context r9, Lazy r10) {
        onCreateView$lambda$60(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    private static final void onCreateView$applyDescInputHeight(final AutoMemoryCreateCollectionInfoFragment r26, final int r27, boolean r28, final String r29, final String r30, final int r31) {
        FragmentAutoMemoryCollectionInfoBinding r0 = r26.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        int r7 = r0.descInputLayer.getLayoutParams().height;
        FragmentAutoMemoryCollectionInfoBinding r1 = r26.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        int r2 = r1.descInput.getLayoutParams().height;
        FragmentAutoMemoryCollectionInfoBinding r3 = r26.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        int r4 = r3.descInputLayer.getHeight();
        FragmentAutoMemoryCollectionInfoBinding r5 = r26.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        int r6 = r5.descInput.getHeight();
        FragmentAutoMemoryCollectionInfoBinding r8 = r26.binding;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L17:
        int r9 = r8.descInput.getVInput().getHeight();
        if (r7 == r27) goto L20;
        boolean r10 = true;
    L21:
        boolean r11 = r10;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L33;
        RunLog r12 = RunLog.INSTANCE;
        StringBuilder r13 = new StringBuilder();
        r13.append("apply#").append(r31).append('[').append(r29).append('/').append(r30).append("] before requestedAnimate=").append(r28).append(" changed=").append(r11).append(" target=").append(r27).append('/').append(onCreateView$pxToDp(r26, r27)).append(" lp=(").append(r7).append(',').append(r2).append(") actual=(").append(r4).append(',').append(r6).append(',');
        StringBuilder r14 = r13.append(r9).append(") scrollY=");
        AutoMemoryCreateCollectionInfoFragment r15 = r26;
        String r16 = "descInputLayer";
        FragmentAutoMemoryCollectionInfoBinding r17 = r15.binding;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L26:
        String r18 = " layer=";
        StringBuilder r19 = r14.append(r17.descInput.getVInput().getScrollY()).append(r18);
        FragmentAutoMemoryCollectionInfoBinding r20 = r15.binding;
        if (r20 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L29:
        FrameLayout r21 = r20.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r21, r16);
        String r110 = "com.obric.memorydata.plugin";
        StringBuilder r22 = r19.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r21, View.class, r110))).append(" button=");
        FragmentAutoMemoryCollectionInfoBinding r23 = r15.binding;
        if (r23 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L32:
        OButton r24 = r23.nextButton;
        Intrinsics.checkNotNullExpressionValue(r24, "nextButton");
        r22.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r24, View.class, r110)));
        String r25 = r13.toString();
        String r32 = TAG_HEIGHT;
        r12.debug(r32, r25);
    L34:
        if (r11 == false) goto L65;
        FragmentAutoMemoryCollectionInfoBinding r33 = r15.binding;
        if (r33 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L38:
        final FrameLayout r34 = r33.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r34, r16);
        FragmentAutoMemoryCollectionInfoBinding r35 = r15.binding;
        if (r35 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r35 = null;
    L41:
        String r36 = r32;
        String r210 = r18;
        final j r37 = new j(r27, r34, r35.descInput.getVInput(), r31, r29, r30, r26);
        r34.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(r37, View.OnLayoutChangeListener.class, r110));
        if (r28 == true) goto L44;
        r26 = r26;
        String r38 = r36;
    L52:
        FragmentAutoMemoryCollectionInfoBinding r39 = r26.binding;
        if (r39 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r39 = null;
    L55:
        FrameLayout r40 = r39.descInputLayer;
        FragmentAutoMemoryCollectionInfoBinding r41 = r26.binding;
        if (r41 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r41 = null;
    L58:
        ViewGroup.LayoutParams r42 = r41.descInputLayer.getLayoutParams();
        r42.height = r27;
        r40.setLayoutParams(r42);
        FragmentAutoMemoryCollectionInfoBinding r43 = r26.binding;
        if (r43 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r43 = null;
    L61:
        OInputLayout r44 = r43.descInput;
        FragmentAutoMemoryCollectionInfoBinding r45 = r26.binding;
        if (r45 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r45 = null;
    L64:
        ViewGroup.LayoutParams r46 = r45.descInput.getLayoutParams();
        r46.height = r27;
        r44.setLayoutParams(r46);
        r34.postDelayed(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$t3UWkoakWlaU0pndSEjf732GyM(r34, r37, r27, r29, r26), 240);
    L67:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L78;
        RunLog r47 = RunLog.INSTANCE;
        final boolean r48 = r11;
        StringBuilder r49 = new StringBuilder().append("apply#").append(r31).append('[').append(r29).append('/').append(r30).append("] afterRequest animate=").append(r28).append(" changed=").append(r48).append(" target=").append(r27).append('/').append(onCreateView$pxToDp(r26, r27)).append(r210);
        FragmentAutoMemoryCollectionInfoBinding r50 = r26.binding;
        if (r50 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r50 = null;
    L71:
        FrameLayout r51 = r50.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r51, r16);
        StringBuilder r52 = r49.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r51, View.class, r110))).append(" input=");
        FragmentAutoMemoryCollectionInfoBinding r53 = r26.binding;
        if (r53 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r53 = null;
    L74:
        OInputLayout r54 = r53.descInput;
        Intrinsics.checkNotNullExpressionValue(r54, "descInput");
        StringBuilder r55 = r52.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r54, View.class, r110))).append(" edit=");
        FragmentAutoMemoryCollectionInfoBinding r56 = r26.binding;
        if (r56 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r56 = null;
    L77:
        r47.debug(r38, r55.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r56.descInput.getVInput(), View.class, r110))).toString());
    L79:
        FragmentAutoMemoryCollectionInfoBinding r57 = r26.binding;
        if (r57 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r57 = null;
    L82:
        r57.descInput.setMinimumHeight(r27);
        FragmentAutoMemoryCollectionInfoBinding r58 = r26.binding;
        if (r58 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r58 = null;
    L85:
        OEditText r59 = r58.descInput.getVInput();
        r59.setMinHeight(r27);
        r59.setMinimumHeight(r27);
        r59.setMaxHeight(r27);
        if (r48 == true) goto L91;
        FragmentAutoMemoryCollectionInfoBinding r60 = r26.binding;
        if (r60 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r60 = null;
    L90:
        r60.descInputLayer.post(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$E9JqpixDwXuUD6tXbZvNvOdBXF0(r29, r26));
    L91:
        FragmentAutoMemoryCollectionInfoBinding r61 = r26.binding;
        if (r61 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        FragmentAutoMemoryCollectionInfoBinding r111 = null;
    L95:
        r111.descInputLayer.postDelayed(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$mJFQnEnzK5NwbxnjEiQCPDxPBII(r31, r29, r30, r48, r26), 220);
        return;
    L94:
        r111 = r61;
        goto L95
    L78:
        r48 = r11;
        goto L79
    L44:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L46;
        RunLog.INSTANCE.debug(r36, "transition#" + r31 + "[inputHeight/" + r29 + '/' + r30 + "] begin duration=180 from=" + r7 + " to=" + r27);
        r38 = r36;
    L47:
        FragmentAutoMemoryCollectionInfoBinding r62 = r26.binding;
        if (r62 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r62 = null;
    L50:
        ViewGroup r63 = (ViewGroup) ZeusTransformUtils.preCheckCast(r62.rootContainer, ViewGroup.class, r110);
        AutoTransition r64 = new AutoTransition();
        r64.setDuration(180);
        r64.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, r110));
        TransitionManager.beginDelayedTransition(r63, (Transition) ZeusTransformUtils.preCheckCast(r64, Transition.class, r110));
        goto L52
    L46:
        r38 = r36;
        goto L47
    L65:
        r210 = r18;
        r26 = r15;
        r38 = r32;
        goto L67
    L33:
        r18 = " layer=";
        r16 = "descInputLayer";
        r32 = TAG_HEIGHT;
        r110 = "com.obric.memorydata.plugin";
        r15 = r26;
        goto L34
    L20:
        r10 = false;
        goto L21
    }

    private static final void onCreateView$applyDescInputHeight$lambda$25(FrameLayout r2, j r3, int r4, String r5, AutoMemoryCreateCollectionInfoFragment r6) {
        r2.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(r3, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
        if (r2.getHeight() != r4) goto L6;
        onCreateView$syncInputScrollToCursor(r6, r5 + "_layoutFallback");
        return;
    }

    private static final void onCreateView$applyDescInputHeight$lambda$28(String r0, AutoMemoryCreateCollectionInfoFragment r1) {
        onCreateView$syncInputScrollToCursor(r1, r0);
    }

    private static final void onCreateView$applyDescInputHeight$lambda$30(int r3, String r4, String r5, boolean r6, AutoMemoryCreateCollectionInfoFragment r7) {
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L28;
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("transition#").append(r3).append("[inputHeight/").append(r4).append('/').append(r5).append("] endSnapshot changed=").append(r6).append(" layerLp=");
        FragmentAutoMemoryCollectionInfoBinding r9 = r7.binding;
        FragmentAutoMemoryCollectionInfoBinding r10 = null;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L7:
        StringBuilder r11 = r8.append(r9.descInputLayer.getLayoutParams().height).append(" inputLp=");
        FragmentAutoMemoryCollectionInfoBinding r12 = r7.binding;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L10:
        StringBuilder r13 = r11.append(r12.descInput.getLayoutParams().height).append(" layer=");
        FragmentAutoMemoryCollectionInfoBinding r14 = r7.binding;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L13:
        FrameLayout r15 = r14.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r15, "descInputLayer");
        StringBuilder r16 = r13.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"))).append(" input=");
        FragmentAutoMemoryCollectionInfoBinding r17 = r7.binding;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L16:
        OInputLayout r18 = r17.descInput;
        Intrinsics.checkNotNullExpressionValue(r18, "descInput");
        StringBuilder r19 = r16.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"))).append(" edit=");
        FragmentAutoMemoryCollectionInfoBinding r20 = r7.binding;
        if (r20 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L19:
        StringBuilder r21 = r19.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r20.descInput.getVInput(), View.class, "com.obric.memorydata.plugin"))).append(" scrollY=");
        FragmentAutoMemoryCollectionInfoBinding r22 = r7.binding;
        if (r22 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L22:
        StringBuilder r23 = r21.append(r22.descInput.getVInput().getScrollY()).append(" button=");
        FragmentAutoMemoryCollectionInfoBinding r24 = r7.binding;
        if (r24 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L26:
        OButton r25 = r10.nextButton;
        Intrinsics.checkNotNullExpressionValue(r25, "nextButton");
        r0.debug(TAG_HEIGHT, r23.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r25, View.class, "com.obric.memorydata.plugin"))).toString());
        return;
    L25:
        r10 = r24;
        goto L26
    }

    private static final String onCreateView$bounds(View r3) {
        Rect r0 = new Rect();
        r3.getGlobalVisibleRect(r0);
        return "h=" + r3.getHeight() + " top=" + r0.top + " bottom=" + r0.bottom;
    }

    private static final g onCreateView$calculateInputContentGeometry(AutoMemoryCreateCollectionInfoFragment r13) {
        FragmentAutoMemoryCollectionInfoBinding r0 = r13.binding;
        FragmentAutoMemoryCollectionInfoBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OEditText r1 = r0.descInput.getVInput();
        if (r1.getWidth() > 0) goto L8;
        return null;
    L8:
        Layout r3 = r1.getLayout();
        if (r3 != null) goto L11;
        return null;
    L11:
        int r11 = RangesKt.coerceAtLeast((r1.getWidth() - r1.getCompoundPaddingLeft()) - r1.getCompoundPaddingRight(), 1);
        FragmentAutoMemoryCollectionInfoBinding r4 = r13.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        int r5 = r4.descInput.getPaddingTop();
        FragmentAutoMemoryCollectionInfoBinding r6 = r13.binding;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        int r12 = ((r5 + r2.descInput.getPaddingBottom()) + r1.getPaddingTop()) + r1.getPaddingBottom();
        return new g((r3.getHeight() + r12) + onCreateView$dpToPx(r13, 12.0f), r3.getHeight(), r3.getLineCount(), r1.getLineHeight(), r11, r12);
    L17:
        r2 = r6;
        goto L18
    }

    private static final i onCreateView$calculateInputHeightGeometry(AutoMemoryCreateCollectionInfoFragment r13) {
        FragmentAutoMemoryCollectionInfoBinding r0 = r13.binding;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        if (r0.getRoot().getHeight() > 0) goto L8;
        return null;
    L8:
        int[] r3 = new int[2];
        int[] r1 = new int[2];
        FragmentAutoMemoryCollectionInfoBinding r4 = r13.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        r4.getRoot().getLocationInWindow(r3);
        FragmentAutoMemoryCollectionInfoBinding r5 = r13.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        r5.descInputLayer.getLocationInWindow(r1);
        int r2 = r1[1] - r3[1];
        FragmentAutoMemoryCollectionInfoBinding r6 = r13.binding;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L17:
        ViewGroup.LayoutParams r7 = r6.bottomBar.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L20;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L21:
        com.obric.memorydata.memory.ui.automemory.create.f r9 = com.obric.memorydata.memory.ui.automemory.create.f.f10669a;
        FragmentAutoMemoryCollectionInfoBinding r10 = r13.binding;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L24:
        int r11 = r10.getRoot().getHeight();
        FragmentAutoMemoryCollectionInfoBinding r12 = r13.binding;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L27:
        int r14 = r12.bottomBar.getPaddingTop();
        FragmentAutoMemoryCollectionInfoBinding r15 = r13.binding;
        if (r15 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L30:
        int r16 = r15.nextButton.getHeight();
        FragmentAutoMemoryCollectionInfoBinding r17 = r13.binding;
        if (r17 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L33:
        int r18 = r17.nextButton.getMinimumHeight();
        FragmentAutoMemoryCollectionInfoBinding r19 = r13.binding;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L36:
        int r110 = r19.bottomBar.getPaddingBottom();
        int r111 = 0;
        if (r8 == null) goto L39;
        int r112 = r8.topMargin;
    L40:
        if (r8 == null) goto L42;
        r111 = r8.bottomMargin;
    L42:
        com.obric.memorydata.memory.ui.automemory.create.c r113 = r9.a(r11, r2, r14, r16, r18, r110, r112, r111);
        if (r113 != null) goto L46;
        return null;
    L46:
        return new i(r113.a(), r2, r113.b(), r113.c());
    L39:
        r112 = 0;
        goto L40
    L20:
        r8 = null;
        goto L21
    }

    private static final h onCreateView$currentInputHeightConfigKey(AutoMemoryCreateCollectionInfoFragment r7) {
        Configuration r8 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getConfiguration();
        return new h(r8.densityDpi, Float.floatToIntBits(r8.fontScale), r8.screenWidthDp, r8.screenHeightDp, r8.orientation);
    }

    private static final com.obric.memorydata.memory.ui.automemory.create.d onCreateView$currentPersistentImeCacheKey(AutoMemoryCreateCollectionInfoFragment r7, Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        FragmentAutoMemoryCollectionInfoBinding r0 = r7.binding;
        Integer r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        View r1 = r0.getRoot().getRootView();
        Integer r3 = Integer.valueOf(r1.getWidth());
        boolean r5 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
        int r6 = r3.intValue();
    L15:
        Integer r10 = Integer.valueOf(r1.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L19;
        r5 = false;
    L19:
        if (r5 == false) goto L21;
        r2 = r10;
    L21:
        if (r2 == null) goto L23;
        int r11 = r2.intValue();
    L24:
        int r12 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getConfiguration().orientation;
        String r13 = Settings.Secure.getString(r9.getContentResolver(), "default_input_method");
        if (r13 != null) goto L28;
        r13 = "";
    L28:
        return new com.obric.memorydata.memory.ui.automemory.create.d(r6, r11, r12, r13);
    L23:
        r11 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDisplayMetrics().heightPixels;
        goto L24
    L14:
        r6 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels;
        goto L15
    L8:
        r4 = false;
        goto L9
    }

    private static final int onCreateView$dpToPx(AutoMemoryCreateCollectionInfoFragment r1, float r2) {
        return (int) TypedValue.applyDimension(1, r2, ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics());
    }

    private static final void onCreateView$ensureDescInputFullyVisible(final AutoMemoryCreateCollectionInfoFragment r4) {
        FragmentAutoMemoryCollectionInfoBinding r0 = r4.binding;
        FragmentAutoMemoryCollectionInfoBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        final NestedScrollView r2 = r0.contentScroll;
        Intrinsics.checkNotNullExpressionValue(r2, "contentScroll");
        FragmentAutoMemoryCollectionInfoBinding r3 = r4.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        final FrameLayout r5 = r1.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r5, "descInputLayer");
        r2.post(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$c0orgtqHLKBq4wstkdx0G4F5UI(r4, r5, r2));
        return;
    L8:
        r1 = r3;
        goto L9
    }

    private static final void onCreateView$ensureDescInputFullyVisible$lambda$44(AutoMemoryCreateCollectionInfoFragment r4, FrameLayout r5, NestedScrollView r6) {
        if (r4.isAdded() == true) goto L5;
        return;
    L5:
        Rect r0 = new Rect();
        r5.getDrawingRect(r0);
        r6.offsetDescendantRectToMyCoords((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), r0);
        FragmentAutoMemoryCollectionInfoBinding r7 = r4.binding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        WindowInsetsCompat r8 = ViewCompat.getRootWindowInsets((View) ZeusTransformUtils.preCheckCast(r7.getRoot(), View.class, "com.obric.memorydata.plugin"));
        if (r8 == null) goto L13;
        Insets r9 = r8.getInsets(WindowInsetsCompat.Type.ime());
        if (r9 == null) goto L13;
        int r10 = r9.bottom;
    L14:
        int r11 = r6.getScrollY();
        int r1 = (r6.getScrollY() + r6.getHeight()) - r10;
        if (r0.height() < (r1 - r11)) goto L21;
        if (r6.getScrollY() == 0) goto L30;
        r6.scrollTo(0, 0);
        return;
    L30:
        return;
    L21:
        if (r0.bottom <= r1) goto L24;
        int r12 = r0.bottom - r1;
    L27:
        if (r12 == 0) goto L31;
        r6.smoothScrollBy(0, r12);
        return;
    L31:
        return;
    L24:
        if (r0.top >= r11) goto L26;
        r12 = r0.top - r11;
        goto L27
    L26:
        r12 = 0;
    L13:
        r10 = ((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r4.getViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).h();
        goto L14
    }

    private static final int onCreateView$initialInputHeight(AutoMemoryCreateCollectionInfoFragment r1) {
        return onCreateView$dpToPx(r1, 282.0f);
    }

    private static final boolean onCreateView$invalidateMeasuredImeHeightIfNeeded(Ref.ObjectRef<h> r7, Ref.ObjectRef<Integer> r8, AutoMemoryCreateCollectionInfoFragment r9) {
        h r0 = (h) ZeusTransformUtils.preCheckCast(r7.element, h.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        if (r0 != null) goto L5;
        return false;
    L5:
        h r3 = onCreateView$currentInputHeightConfigKey(r9);
        if (Intrinsics.areEqual(r0, r3) == false) goto L9;
        return false;
    L9:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L14;
        RunLog r4 = RunLog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append("invalidateImeHeight old=").append(r0).append(" new=").append(r3).append(" cached=").append(r8.element).append('/');
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r8.element, Integer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L13;
        r1 = r5.intValue();
    L13:
        r4.debug(TAG_HEIGHT, r2.append(onCreateView$pxToDp(r9, r1)).toString());
    L14:
        r8.element = null;
        r7.element = null;
        return true;
    }

    private static final boolean onCreateView$isRootReadyForIme(Ref.IntRef r5, AutoMemoryCreateCollectionInfoFragment r6) {
        if (r5.element > 0) goto L5;
        return true;
    L5:
        FragmentAutoMemoryCollectionInfoBinding r7 = r6.binding;
        FragmentAutoMemoryCollectionInfoBinding r1 = null;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        FrameLayout r8 = r7.getRoot();
        Intrinsics.checkNotNullExpressionValue(r8, "getRoot(...)");
        int r9 = onCreateView$visibleHeight((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        if (r9 <= 0) goto L17;
        FragmentAutoMemoryCollectionInfoBinding r10 = r6.binding;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        if (r1.getRoot().getHeight() > (r9 + 1)) goto L17;
        return true;
    L13:
        r1 = r10;
    L17:
        return false;
    }

    private static final WindowInsetsCompat onCreateView$lambda$1(AutoMemoryCreateCollectionInfoFragment r2, int r3, View r4, WindowInsetsCompat r5) {
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "insets");
        int r6 = r5.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        FragmentAutoMemoryCollectionInfoBinding r7 = r2.binding;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L5:
        FrameLayout r8 = r7.bottomBar;
        Intrinsics.checkNotNullExpressionValue(r8, "bottomBar");
        View r9 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin");
        if (r6 > 0) goto L8;
    L10:
        r9.setPadding(r9.getPaddingLeft(), r9.getPaddingTop(), r9.getPaddingRight(), r3);
        return r5;
    L8:
        if (r5.isVisible(WindowInsetsCompat.Type.ime()) == true) goto L10;
        r3 = 0;
        goto L10
    }

    private static final void onCreateView$lambda$3$lambda$2(AutoMemoryCreateCollectionInfoFragment r0, View r1) {
        r0.getViewModel().requestExit();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$h, java.lang.Object] */
    private static final void onCreateView$lambda$43(Ref.ObjectRef r16, Ref.ObjectRef r17, Ref.ObjectRef r18, AutoMemoryCreateCollectionInfoFragment r19, Ref.IntRef r20, Ref.IntRef r21, Ref.IntRef r22, Ref.BooleanRef r23, Ref.ObjectRef r24, Ref.BooleanRef r25, Context r26, Lazy r27, View r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r26, Context.class, "com.obric.memorydata.plugin");
        Lazy r13 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r27, Lazy.class, "com.obric.memorydata.plugin");
        ?? r2 = onCreateView$currentInputHeightConfigKey(r19);
        if (Intrinsics.areEqual(r2, r16.element) == false) goto L5;
        return;
    L5:
        r16.element = r2;
        r17.element = null;
        r18.element = null;
        onCreateView$updateDescInputHeight(r20, r19, r21, r17, r22, r23, r18, r24, r25, r1, r13, false, "configurationChanged");
        onCreateView$requestImeForHeightMeasurement(r19, r21, r1, "configurationChanged");
    }

    private static final void onCreateView$lambda$45(AutoMemoryCreateCollectionInfoFragment r0, NestedScrollView r1, int r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, BaseSwitches.V);
        if (r3 != 0) goto L5;
        return;
    L5:
        FragmentAutoMemoryCollectionInfoBinding r6 = r0.binding;
        FragmentAutoMemoryCollectionInfoBinding r7 = null;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L8:
        FrameLayout r8 = r6.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r8, "descInputLayer");
        FragmentAutoMemoryCollectionInfoBinding r9 = r0.binding;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        WindowInsetsCompat r10 = ViewCompat.getRootWindowInsets((View) ZeusTransformUtils.preCheckCast(r7.getRoot(), View.class, "com.obric.memorydata.plugin"));
        if (r10 == null) goto L17;
        Insets r11 = r10.getInsets(WindowInsetsCompat.Type.ime());
        if (r11 == null) goto L17;
        int r12 = r11.bottom;
    L18:
        int r13 = r1.getHeight() - r12;
        if (r8.getHeight() < r13) goto L23;
        if (r13 <= 0) goto L24;
        r1.scrollTo(0, 0);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        r12 = ((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r0.getViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).h();
        goto L18
    L11:
        r7 = r9;
        goto L12
    }

    private static final boolean onCreateView$lambda$49$lambda$46(AutoMemoryCreateCollectionInfoFragment r4, View r5, MotionEvent r6) {
        if (r5.canScrollVertically(-1) == false) goto L5;
    L8:
        boolean r7 = true;
    L9:
        int r8 = r6.getActionMasked();
        FragmentAutoMemoryCollectionInfoBinding r0 = null;
        if (r8 == 0) goto L22;
        if (r8 != 1) goto L13;
    L17:
        FragmentAutoMemoryCollectionInfoBinding r9 = r4.binding;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r0.contentScroll.requestDisallowInterceptTouchEvent(false);
    L27:
        return false;
    L20:
        r0 = r9;
        goto L21
    L13:
        if (r8 == 2) goto L22;
        if (r8 == 3) goto L17;
    L22:
        FragmentAutoMemoryCollectionInfoBinding r10 = r4.binding;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L26:
        r0.contentScroll.requestDisallowInterceptTouchEvent(r7);
        goto L27
    L25:
        r0 = r10;
        goto L26
    L5:
        if (r5.canScrollVertically(1) == true) goto L8;
        r7 = false;
        goto L9
    }

    private static final IStore onCreateView$lambda$5() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private static final void onCreateView$lambda$54$lambda$53(final AutoMemoryCreateCollectionInfoFragment r1, View r2) {
        r1.getViewModel().nextToTaskSettings(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$hPNaqElTbL0KP31Gyq0591owXAQ(r1));
    }

    private static final Unit onCreateView$lambda$54$lambda$53$lambda$52(AutoMemoryCreateCollectionInfoFragment r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_SESSION_ID);
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        MemoryTaskSettingsActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"), r5);
    L5:
        r4.getViewModel().closePage();
        return Unit.INSTANCE;
    }

    private static final IStore onCreateView$lambda$6(Lazy<? extends IStore> r2) {
        return (IStore) ZeusTransformUtils.preCheckCast(((Lazy) ZeusTransformUtils.wrapperContextForParams(r2, Lazy.class, "com.obric.memorydata.plugin")).getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private static final void onCreateView$lambda$60(final AutoMemoryCreateCollectionInfoFragment r15, Ref.IntRef r16, final Ref.IntRef r17, Ref.ObjectRef r18, Ref.IntRef r19, Ref.BooleanRef r20, Ref.ObjectRef r21, Ref.ObjectRef r22, Ref.BooleanRef r23, Context r24, Lazy r25) {
        final Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.memorydata.plugin");
        onCreateView$updateDescInputHeight(r16, r15, r17, r18, r19, r20, r21, r22, r23, r14, (Lazy) ZeusTransformUtils.wrapperContextForParams(r25, Lazy.class, "com.obric.memorydata.plugin"), false, "initialPlaceholder");
        FragmentAutoMemoryCollectionInfoBinding r0 = r15.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.getRoot().post(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$528FPLpIIqE1XpdNXvCcLJX45bA(r15, r17, r14));
    }

    private static final void onCreateView$lambda$60$lambda$59(AutoMemoryCreateCollectionInfoFragment r2, Ref.IntRef r3, Context r4) {
        onCreateView$requestImeForHeightMeasurement(r2, r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "initial");
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [T, com.obric.memorydata.memory.ui.automemory.create.e] */
    private static final com.obric.memorydata.memory.ui.automemory.create.e onCreateView$loadPersistedImeHeight(Ref.BooleanRef r4, Ref.ObjectRef<com.obric.memorydata.memory.ui.automemory.create.e> r5, Lazy<? extends IStore> r6) {
        Lazy r7 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r6, Lazy.class, "com.obric.memorydata.plugin");
        if (r4.element == true) goto L6;
        r5.element = com.obric.memorydata.memory.ui.automemory.create.e.f10667a.a(onCreateView$lambda$6(r7).getString(KEY_CREATE_TASK_IME_HEIGHT_CACHE, ""));
        r4.element = true;
    L6:
        return (com.obric.memorydata.memory.ui.automemory.create.e) ZeusTransformUtils.preCheckCast(r5.element, com.obric.memorydata.memory.ui.automemory.create.e.class, "com.obric.memorydata.plugin");
    }

    private static final String onCreateView$pxToDp(AutoMemoryCreateCollectionInfoFragment r2, int r3) {
        return (r3 / ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getDisplayMetrics().density) + "dp";
    }

    private static final void onCreateView$requestImeForHeightMeasurement(AutoMemoryCreateCollectionInfoFragment r8, Ref.IntRef r9, Context r10, String r11) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        FragmentAutoMemoryCollectionInfoBinding r12 = r8.binding;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L5:
        OEditText r13 = r12.descInput.getVInput();
        r13.setShowSoftInputOnFocus(true);
        r13.requestFocus();
        r13.post((Runnable) ZeusTransformUtils.preCheckCast(new l(r8, r13, r9, r6, r11), Runnable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.obric.memorydata.memory.ui.automemory.create.e, java.lang.Object] */
    private static final void onCreateView$savePersistedImeHeight(Ref.ObjectRef<com.obric.memorydata.memory.ui.automemory.create.e> r2, Ref.BooleanRef r3, AutoMemoryCreateCollectionInfoFragment r4, Context r5, Lazy<? extends IStore> r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Lazy r9 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r6, Lazy.class, "com.obric.memorydata.plugin");
        if (r7 > 0) goto L5;
        return;
    L5:
        ?? r0 = new com.obric.memorydata.memory.ui.automemory.create.e(onCreateView$currentPersistentImeCacheKey(r4, r8), r7);
        if (Intrinsics.areEqual(r0, r2.element) == false) goto L8;
        return;
    L8:
        r2.element = r0;
        r3.element = true;
        onCreateView$lambda$6(r9).save(KEY_CREATE_TASK_IME_HEIGHT_CACHE, r0.c());
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L12;
        RunLog.INSTANCE.debug(TAG_HEIGHT, "imeCacheSave key=" + r0.a() + " imeBottom=" + r0.b());
        return;
    }

    private static final void onCreateView$syncInputScrollToCursor(final AutoMemoryCreateCollectionInfoFragment r2, final String r3) {
        FragmentAutoMemoryCollectionInfoBinding r0 = r2.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.descInput.getVInput().post(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$dC5JLqD_BEFUbQZREwwZecSE4_Q(r2, r3));
    }

    private static final void onCreateView$syncInputScrollToCursor$lambda$19(AutoMemoryCreateCollectionInfoFragment r4, String r5) {
        if (r4.isAdded() == true) goto L5;
        return;
    L5:
        FragmentAutoMemoryCollectionInfoBinding r6 = r4.binding;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L8:
        OEditText r7 = r6.descInput.getVInput();
        int r0 = RangesKt.coerceAtLeast(r7.getSelectionEnd(), 0);
        r7.scrollTo(0, 0);
        if (r0 <= 0) goto L12;
        r7.bringPointIntoView(r0);
    L12:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L19;
        RunLog r1 = RunLog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("scroll[").append(r5).append("] selection=").append(r0).append(" scrollY=").append(r7.getScrollY()).append(" layoutHeight=");
        Layout r2 = r7.getLayout();
        if (r2 == null) goto L16;
        int r3 = r2.getHeight();
    L17:
        r1.debug(TAG_HEIGHT, r8.append(r3).append(" edit=").append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"))).toString());
        return;
    L16:
        r3 = -1;
        goto L17
    }

    private static final void onCreateView$toast(AutoMemoryCreateCollectionInfoFragment r7, String r8) {
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L6;
        com.obric.oui.toast.a.C0786a.a(com.obric.oui.toast.a.f14807a, (Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"), r8, 0, 4, null);
        return;
    }

    private static final void onCreateView$updateBottomBarGravity(AutoMemoryCreateCollectionInfoFragment r12, Ref.IntRef r13, boolean r14, String r15, int r16) {
        FragmentAutoMemoryCollectionInfoBinding r0 = r12.binding;
        FragmentAutoMemoryCollectionInfoBinding r9 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        LinearLayout r1 = r0.nextButtonContainer;
        Intrinsics.checkNotNullExpressionValue(r1, "nextButtonContainer");
        onCreateView$updateBottomBarGravity$applyBottomBarGravity((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), 80, r14, r12, r16, r15, r13, "nextButtonContainer");
        FragmentAutoMemoryCollectionInfoBinding r2 = r12.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        LinearLayout r3 = r9.generateLoadingContainer;
        Intrinsics.checkNotNullExpressionValue(r3, "generateLoadingContainer");
        onCreateView$updateBottomBarGravity$applyBottomBarGravity((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), 80, r14, r12, r16, r15, r13, "generateLoadingContainer");
        return;
    L8:
        r9 = r2;
        goto L9
    }

    private static final void onCreateView$updateBottomBarGravity$applyBottomBarGravity(final View r16, int r17, boolean r18, final AutoMemoryCreateCollectionInfoFragment r19, final int r20, final String r21, Ref.IntRef r22, final String r23) {
        ViewGroup.LayoutParams r2 = r16.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, FrameLayout.LayoutParams.class) == false) goto L5;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 == null) goto L32;
        int r4 = r3.gravity;
        if (r4 == r17) goto L10;
        boolean r11 = true;
    L12:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L20;
        RunLog r12 = RunLog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append("gravity#").append(r20).append('[').append(r21).append('/').append(r23).append("] requestedAnimate=").append(r18).append(" changed=").append(r11).append(" old=").append(r4).append(" target=").append(r17).append(" imeBottom=").append(r22.element).append(" before=").append(onCreateView$bounds(r16)).append(" layer=");
        FragmentAutoMemoryCollectionInfoBinding r6 = r19.binding;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L16:
        FrameLayout r7 = r6.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r7, "descInputLayer");
        StringBuilder r8 = r5.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"))).append(" layerLp=");
        FragmentAutoMemoryCollectionInfoBinding r9 = r19.binding;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L19:
        r12.debug(TAG_HEIGHT, r8.append(r9.descInputLayer.getLayoutParams().height).toString());
    L20:
        if (r11 == false) goto L33;
        if (r18 == true) goto L23;
    L30:
        r3.gravity = r17;
        r16.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r16.post(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$v2TCf5n1TS1_MyiWZRGG0ciEcao(r20, r21, r23, r16, r19));
        r16.postDelayed(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$mywq2IWiURxDENedwWjmmUSQ1_k(r20, r21, r23, r16, r19), 220);
        return;
    L23:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L25;
        RunLog.INSTANCE.debug(TAG_HEIGHT, "transition#" + r20 + "[bottomGravity/" + r21 + '/' + r23 + "] begin duration=180");
    L25:
        FragmentAutoMemoryCollectionInfoBinding r1 = r19.binding;
        if (r1 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        FragmentAutoMemoryCollectionInfoBinding r10 = null;
    L29:
        ViewGroup r13 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.rootContainer, ViewGroup.class, "com.obric.memorydata.plugin");
        AutoTransition r14 = new AutoTransition();
        r14.setDuration(180);
        r14.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        TransitionManager.beginDelayedTransition(r13, (Transition) ZeusTransformUtils.preCheckCast(r14, Transition.class, "com.obric.memorydata.plugin"));
        goto L30
    L28:
        r10 = r1;
        goto L29
    L33:
        return;
    L10:
        r11 = false;
        goto L12
    L32:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private static final void onCreateView$updateBottomBarGravity$applyBottomBarGravity$lambda$17$lambda$14(int r3, String r4, String r5, View r6, AutoMemoryCreateCollectionInfoFragment r7) {
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L17;
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("gravity#").append(r3).append('[').append(r4).append('/').append(r5).append("] laidOut gravity=");
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        FragmentAutoMemoryCollectionInfoBinding r2 = null;
        if (ZeusTransformUtils.instanceOf(r9, FrameLayout.LayoutParams.class) == false) goto L7;
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r9, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L8:
        if (r10 == null) goto L10;
        Integer r11 = Integer.valueOf(r10.gravity);
    L11:
        StringBuilder r12 = r8.append(r11).append(" after=").append(onCreateView$bounds(r6)).append(" layer=");
        FragmentAutoMemoryCollectionInfoBinding r13 = r7.binding;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        FrameLayout r14 = r2.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r14, "descInputLayer");
        r0.debug(TAG_HEIGHT, r12.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"))).toString());
        return;
    L14:
        r2 = r13;
        goto L15
    L10:
        r11 = null;
        goto L11
    L7:
        r10 = null;
        goto L8
    }

    private static final void onCreateView$updateBottomBarGravity$applyBottomBarGravity$lambda$17$lambda$16(int r3, String r4, String r5, View r6, AutoMemoryCreateCollectionInfoFragment r7) {
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L9;
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("transition#").append(r3).append("[bottomGravity/").append(r4).append('/').append(r5).append("] endSnapshot after=").append(onCreateView$bounds(r6)).append(" layer=");
        FragmentAutoMemoryCollectionInfoBinding r9 = r7.binding;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L7:
        FrameLayout r10 = r9.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r10, "descInputLayer");
        r0.debug(TAG_HEIGHT, r8.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"))).toString());
        return;
    }

    private static final void onCreateView$updateDescInputHeight(final Ref.IntRef r16, final AutoMemoryCreateCollectionInfoFragment r17, final Ref.IntRef r18, final Ref.ObjectRef<Integer> r19, final Ref.IntRef r20, final Ref.BooleanRef r21, final Ref.ObjectRef<h> r22, final Ref.ObjectRef<com.obric.memorydata.memory.ui.automemory.create.e> r23, final Ref.BooleanRef r24, Context r25, Lazy<? extends IStore> r26, final boolean r27, final String r28) {
        final Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.memorydata.plugin");
        final Lazy r13 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r26, Lazy.class, "com.obric.memorydata.plugin");
        r16.element++;
        final int r6 = r16.element;
        FragmentAutoMemoryCollectionInfoBinding r3 = null;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L15;
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append("enqueue#").append(r6).append('[').append(r28).append("] animate=").append(r27).append(" imeBottom=").append(r18.element).append(" layerLp=");
        FragmentAutoMemoryCollectionInfoBinding r10 = r17.binding;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L7:
        StringBuilder r7 = r5.append(r10.descInputLayer.getLayoutParams().height).append(" layer=");
        FragmentAutoMemoryCollectionInfoBinding r11 = r17.binding;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L10:
        FrameLayout r14 = r11.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r14, "descInputLayer");
        StringBuilder r8 = r7.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"))).append(" button=");
        FragmentAutoMemoryCollectionInfoBinding r15 = r17.binding;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L13:
        OButton r110 = r15.nextButton;
        Intrinsics.checkNotNullExpressionValue(r110, "nextButton");
        r0.debug(TAG_HEIGHT, r8.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r110, View.class, "com.obric.memorydata.plugin"))).toString());
    L15:
        FragmentAutoMemoryCollectionInfoBinding r1 = r17.binding;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        r3.getRoot().post(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$FyaJTvlgOV6v9SyOCLseiS_b2is(r17, r19, r18, r20, r28, r6, r27, r21, r22, r23, r24, r12, r13, r16));
        return;
    L18:
        r3 = r1;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v26, types: [com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$h] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v76, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v98, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r43v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v46, types: [java.lang.Object] */
    private static final void onCreateView$updateDescInputHeight$lambda$42(final AutoMemoryCreateCollectionInfoFragment r33, final Ref.ObjectRef r34, final Ref.IntRef r35, final Ref.IntRef r36, final String r37, int r38, boolean r39, final Ref.BooleanRef r40, final Ref.ObjectRef r41, final Ref.ObjectRef r42, final Ref.BooleanRef r43, Context r44, Lazy r45, final Ref.IntRef r46) {
        String r14 = "com.obric.memorydata.plugin";
        final Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r44, Context.class, "com.obric.memorydata.plugin");
        final Lazy r5 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r45, Lazy.class, "com.obric.memorydata.plugin");
        if (r33.isAdded() == false) goto L229;
        FragmentAutoMemoryCollectionInfoBinding r0 = r33.binding;
        FragmentAutoMemoryCollectionInfoBinding r17 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        if (r0.getRoot().getHeight() > 0) goto L11;
        return;
    L11:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L23;
        RunLog r1 = RunLog.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("run#").append(r38).append('[').append(r37).append("] animate=").append(r39).append(" imeBottom=").append(r35.element).append(" layerLp=");
        FragmentAutoMemoryCollectionInfoBinding r16 = r33.binding;
        if (r16 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L15:
        StringBuilder r13 = r12.append(r16.descInputLayer.getLayoutParams().height).append(" layer=");
        FragmentAutoMemoryCollectionInfoBinding r18 = r33.binding;
        if (r18 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L18:
        FrameLayout r19 = r18.descInputLayer;
        Intrinsics.checkNotNullExpressionValue(r19, "descInputLayer");
        StringBuilder r2 = r13.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.memorydata.plugin"))).append(" button=");
        FragmentAutoMemoryCollectionInfoBinding r110 = r33.binding;
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L21:
        OButton r111 = r110.nextButton;
        Intrinsics.checkNotNullExpressionValue(r111, "nextButton");
        r1.debug(TAG_HEIGHT, r2.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r111, View.class, "com.obric.memorydata.plugin"))).toString());
    L23:
        onCreateView$invalidateMeasuredImeHeightIfNeeded(r41, r34, r33);
        ?? r112 = onCreateView$currentInputHeightConfigKey(r33);
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r34.element, Integer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L28;
        ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (Intrinsics.areEqual(r41.element, r112) == false) goto L28;
    L30:
        if (r35.element <= 0) goto L50;
        if (r3 == null) goto L50;
        r36.element = 0;
        onCreateView$updateBottomBarGravity(r33, r35, false, r37, r38);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L41;
        RunLog r4 = RunLog.INSTANCE;
        StringBuilder r6 = new StringBuilder().append("restoreImeBaseline#").append(r38).append('[').append(r37).append("] target=").append(r3).append('/').append(onCreateView$pxToDp(r33, r3.intValue())).append(" current=");
        FragmentAutoMemoryCollectionInfoBinding r7 = r33.binding;
        if (r7 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L37:
        StringBuilder r8 = r6.append(r7.descInputLayer.getHeight()).append('/');
        FragmentAutoMemoryCollectionInfoBinding r9 = r33.binding;
        if (r9 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L40:
        r4.debug(TAG_HEIGHT, r8.append(onCreateView$pxToDp(r33, r9.descInputLayer.getHeight())).append(" config=").append(r112).toString());
    L41:
        int r10 = r3.intValue();
        if (r39 == true) goto L44;
    L46:
        boolean r22 = false;
    L47:
        onCreateView$applyDescInputHeight(r33, r10, r22, "imeShown_restoreBaseline", r37, r38);
        r40.element = true;
        return;
    L44:
        if (r40.element == false) goto L46;
        r22 = true;
    L50:
        if (r35.element <= 0) goto L86;
        if (onCreateView$isRootReadyForIme(r35, r33) == true) goto L86;
        if (r36.element >= 8) goto L86;
        r36.element++;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L78;
        RunLog r11 = RunLog.INSTANCE;
        StringBuilder r20 = new StringBuilder().append("defer[imeLayoutNotReady] retry=").append(r36.element).append(" imeBottom=").append(r35.element).append(" root=");
        FragmentAutoMemoryCollectionInfoBinding r113 = r33.binding;
        if (r113 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L60:
        FrameLayout r114 = r113.getRoot();
        Intrinsics.checkNotNullExpressionValue(r114, "getRoot(...)");
        StringBuilder r21 = r20.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r114, View.class, "com.obric.memorydata.plugin"))).append(" visibleHeight=");
        FragmentAutoMemoryCollectionInfoBinding r115 = r33.binding;
        if (r115 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L63:
        FrameLayout r116 = r115.getRoot();
        Intrinsics.checkNotNullExpressionValue(r116, "getRoot(...)");
        StringBuilder r23 = r21.append(onCreateView$visibleHeight((View) ZeusTransformUtils.preCheckCast(r116, View.class, "com.obric.memorydata.plugin"))).append(" rootView=");
        FragmentAutoMemoryCollectionInfoBinding r24 = r33.binding;
        if (r24 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L66:
        View r25 = r24.getRoot().getRootView();
        if (r25 == null) goto L69;
        int r26 = r25.getHeight();
    L70:
        StringBuilder r27 = r23.append(r26).append('/');
        FragmentAutoMemoryCollectionInfoBinding r28 = r33.binding;
        if (r28 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L73:
        View r29 = r28.getRoot().getRootView();
        if (r29 == null) goto L76;
        int r30 = r29.getHeight();
    L77:
        r11.debug(TAG_HEIGHT, r27.append(onCreateView$pxToDp(r33, r30)).append(" display=").append(ZeusTransformUtils.getResources(r33, "com.obric.memorydata.plugin").getDisplayMetrics().heightPixels).append('/').append(onCreateView$pxToDp(r33, ZeusTransformUtils.getResources(r33, "com.obric.memorydata.plugin").getDisplayMetrics().heightPixels)).toString());
        goto L78
    L76:
        r30 = 0;
        goto L77
    L69:
        r26 = 0;
    L78:
        FragmentAutoMemoryCollectionInfoBinding r31 = r33.binding;
        if (r31 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L82:
        r17.getRoot().postDelayed(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$dfi0KfJ8OUsP8d4BNIbE_5kAOWE(r37, r36, r46, r33, r35, r34, r40, r41, r42, r43, r15, r5), 32);
        return;
    L81:
        r17 = r31;
    L86:
        r36.element = 0;
        if (r39 == true) goto L89;
    L91:
        boolean r32 = false;
    L92:
        onCreateView$updateBottomBarGravity(r33, r35, r32, r37, r38);
        i r210 = onCreateView$calculateInputHeightGeometry(r33);
        if (r210 != null) goto L96;
        return;
    L96:
        if (r35.element > 0) goto L98;
        g r211 = onCreateView$calculateInputContentGeometry(r33);
    L99:
        int r212 = r210.a();
        if (r35.element <= 0) goto L103;
        r34.element = Integer.valueOf(r210.a());
        r41.element = r112;
        int r117 = r35.element;
        String r213 = "getRoot(...)";
        String r214 = " root=";
        String r310 = " button=";
        String r311 = " display=";
        String r47 = " rootView=";
        String r312 = "nextButton";
        int r118 = 0;
        String r119 = TAG_HEIGHT;
        onCreateView$savePersistedImeHeight(r42, r43, r33, r15, r5, r117);
        int r48 = r210.a();
        String r49 = "imeShown_captureBaseline";
        r14 = "com.obric.memorydata.plugin";
        ?? r215 = r112;
    L102:
        int r50 = r212;
        ?? r216 = r215;
    L151:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L223;
        RunLog r51 = RunLog.INSTANCE;
        StringBuilder r52 = new StringBuilder();
        StringBuilder r53 = r52.append("calc[").append(r49).append("] imeBottom=").append(r35.element).append(" available=").append(r210.a()).append('/').append(onCreateView$pxToDp(r33, r210.a())).append(" target=").append(r48).append('/').append(onCreateView$pxToDp(r33, r48)).append(" animate=").append(r39).append(" contentHeight=");
        int r54 = -1;
        if (r211 == null) goto L155;
        int r55 = r211.a();
    L156:
        StringBuilder r56 = r53.append(r55).append('/');
        if (r211 == null) goto L159;
        int r57 = r211.a();
    L160:
        StringBuilder r58 = r56.append(onCreateView$pxToDp(r33, r57)).append(" textHeight=");
        if (r211 == null) goto L163;
        int r59 = r211.b();
    L164:
        StringBuilder r60 = r58.append(r59).append(" lineCount=");
        if (r211 == null) goto L167;
        int r61 = r211.c();
    L168:
        r60.append(r61).append(" lineHeight=");
        if (r211 == null) goto L171;
        int r62 = r211.d();
    L172:
        StringBuilder r63 = r52.append(r62).append(" textWidth=");
        if (r211 == null) goto L175;
        int r64 = r211.e();
    L176:
        StringBuilder r65 = r63.append(r64).append(" verticalPadding=");
        if (r211 == null) goto L179;
        r54 = r211.f();
    L179:
        StringBuilder r66 = r65.append(r54).append(" maxExpanded=").append(r50).append('/').append(onCreateView$pxToDp(r33, r50)).append(" cached=").append(r34.element).append('/');
        String r67 = r14;
        Integer r68 = (Integer) ZeusTransformUtils.preCheckCast(r34.element, Integer.class, r67);
        if (r68 == null) goto L182;
        int r69 = r68.intValue();
    L183:
        r66.append(onCreateView$pxToDp(r33, r69)).append(" config=").append(r216).append(" inputTopInRoot=").append(r210.b()).append('/').append(onCreateView$pxToDp(r33, r210.b())).append(" bottomBarReserve=").append(r210.c()).append('/').append(onCreateView$pxToDp(r33, r210.c()));
        StringBuilder r70 = r52.append(" buttonHeight=").append(r210.d()).append('/').append(onCreateView$pxToDp(r33, r210.d())).append(" rootMeasured=");
        FragmentAutoMemoryCollectionInfoBinding r71 = r33.binding;
        if (r71 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r71 = null;
    L186:
        StringBuilder r72 = r70.append(r71.getRoot().getHeight()).append('/');
        FragmentAutoMemoryCollectionInfoBinding r73 = r33.binding;
        if (r73 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r73 = null;
    L189:
        StringBuilder r74 = r72.append(onCreateView$pxToDp(r33, r73.getRoot().getHeight())).append(r47);
        FragmentAutoMemoryCollectionInfoBinding r75 = r33.binding;
        if (r75 != null) goto L192;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r75 = null;
    L192:
        View r76 = r75.getRoot().getRootView();
        if (r76 == null) goto L195;
        int r77 = r76.getHeight();
    L196:
        StringBuilder r78 = r74.append(r77).append('/');
        FragmentAutoMemoryCollectionInfoBinding r79 = r33.binding;
        if (r79 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r79 = null;
    L199:
        View r80 = r79.getRoot().getRootView();
        if (r80 == null) goto L202;
        int r81 = r80.getHeight();
    L203:
        StringBuilder r82 = r78.append(onCreateView$pxToDp(r33, r81)).append(r311).append(ZeusTransformUtils.getResources(r33, r67).getDisplayMetrics().heightPixels).append('/').append(onCreateView$pxToDp(r33, ZeusTransformUtils.getResources(r33, r67).getDisplayMetrics().heightPixels)).append(r214);
        FragmentAutoMemoryCollectionInfoBinding r83 = r33.binding;
        if (r83 != null) goto L206;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r83 = null;
    L206:
        FrameLayout r84 = r83.getRoot();
        Intrinsics.checkNotNullExpressionValue(r84, r213);
        StringBuilder r85 = r82.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r84, View.class, r67))).append(" title=");
        FragmentAutoMemoryCollectionInfoBinding r86 = r33.binding;
        if (r86 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r86 = null;
    L209:
        OFloatingTitleBar r87 = r86.titleBar;
        Intrinsics.checkNotNullExpressionValue(r87, "titleBar");
        StringBuilder r88 = r85.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r87, View.class, r67))).append(" label=");
        FragmentAutoMemoryCollectionInfoBinding r89 = r33.binding;
        if (r89 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r89 = null;
    L212:
        TextView r90 = r89.descLabel;
        Intrinsics.checkNotNullExpressionValue(r90, "descLabel");
        r88.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r90, View.class, r67))).append(" scroll=");
        FragmentAutoMemoryCollectionInfoBinding r91 = r33.binding;
        if (r91 != null) goto L215;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r91 = null;
    L215:
        NestedScrollView r92 = r91.contentScroll;
        Intrinsics.checkNotNullExpressionValue(r92, "contentScroll");
        StringBuilder r93 = r52.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r92, View.class, r67))).append(" bottomBar=");
        FragmentAutoMemoryCollectionInfoBinding r94 = r33.binding;
        if (r94 != null) goto L218;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r94 = null;
    L218:
        FrameLayout r95 = r94.bottomBar;
        Intrinsics.checkNotNullExpressionValue(r95, "bottomBar");
        StringBuilder r96 = r93.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r95, View.class, r67))).append(r310);
        FragmentAutoMemoryCollectionInfoBinding r97 = r33.binding;
        if (r97 != null) goto L221;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r97 = null;
    L221:
        OButton r98 = r97.nextButton;
        Intrinsics.checkNotNullExpressionValue(r98, r312);
        r96.append(onCreateView$bounds((View) ZeusTransformUtils.preCheckCast(r98, View.class, r67)));
        r51.debug(r119, r52.toString());
        goto L223
    L202:
        r81 = r118;
        goto L203
    L195:
        r77 = r118;
        goto L196
    L182:
        r69 = r118;
        goto L183
    L175:
        r64 = -1;
        goto L176
    L171:
        r62 = -1;
        goto L172
    L167:
        r61 = -1;
        goto L168
    L163:
        r59 = -1;
        goto L164
    L159:
        r57 = r118;
        goto L160
    L155:
        r55 = -1;
    L223:
        if (r39 == true) goto L225;
    L227:
        onCreateView$applyDescInputHeight(r33, r48, r118, r49, r37, r38);
        r40.element = true;
        return;
    L225:
        if (r40.element == false) goto L227;
        r118 = 1;
        goto L227
    L103:
        r311 = " display=";
        r213 = "getRoot(...)";
        r214 = " root=";
        r118 = 0;
        r47 = " rootView=";
        r312 = "nextButton";
        r310 = " button=";
        r119 = TAG_HEIGHT;
        Integer r99 = (Integer) ZeusTransformUtils.preCheckCast(r34.element, Integer.class, "com.obric.memorydata.plugin");
        if (r99 != null) goto L106;
    L118:
        com.obric.memorydata.memory.ui.automemory.create.d r100 = onCreateView$currentPersistentImeCacheKey(r33, r15);
        com.obric.memorydata.memory.ui.automemory.create.e r101 = onCreateView$loadPersistedImeHeight(r43, r42, r5);
        FragmentAutoMemoryCollectionInfoBinding r102 = r33.binding;
        if (r102 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L121:
        WindowInsetsCompat r103 = ViewCompat.getRootWindowInsets((View) ZeusTransformUtils.preCheckCast(r102.getRoot(), View.class, "com.obric.memorydata.plugin"));
        if (r103 == null) goto L126;
        Insets r104 = r103.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r104 == null) goto L126;
        int r105 = r104.bottom;
    L127:
        Integer r106 = com.obric.memorydata.memory.ui.automemory.create.f.f10669a.a(r101, r100, r210.a(), r105);
        if (r106 == null) goto L138;
        int r120 = r106.intValue();
        r215 = r112;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L137;
        RunLog r107 = RunLog.INSTANCE;
        StringBuilder r108 = new StringBuilder().append("imeCacheHit key=").append(r100).append(" imeBottom=");
        if (r101 == null) goto L134;
        Integer r109 = Integer.valueOf(r101.b());
    L135:
        r107.debug(r119, r108.append(r109).append(" systemBarsBottom=").append(r105).append(" fullAvailable=").append(r210.a()).append(" target=").append(r106).toString());
        goto L137
    L134:
        r109 = null;
    L137:
        r49 = "beforeFirstIme_cachedPrediction";
        r48 = r120;
        goto L102
    L138:
        r215 = r112;
        r14 = "com.obric.memorydata.plugin";
        r48 = onCreateView$initialInputHeight(r33);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L149;
        RunLog r121 = RunLog.INSTANCE;
        StringBuilder r122 = new StringBuilder().append("imeCacheMiss current=").append(r100).append(" cached=");
        if (r101 == null) goto L143;
        com.obric.memorydata.memory.ui.automemory.create.d r123 = r101.a();
    L144:
        StringBuilder r124 = r122.append(r123).append(" imeBottom=");
        if (r101 == null) goto L147;
        Integer r125 = Integer.valueOf(r101.b());
    L148:
        r121.debug(r119, r124.append(r125).append(" systemBarsBottom=").append(r105).append(" fullAvailable=").append(r210.a()).toString());
        goto L149
    L147:
        r125 = null;
        goto L148
    L143:
        r123 = null;
    L149:
        r49 = "beforeFirstIme_placeholder";
    L126:
        r105 = 0;
        goto L127
    L106:
        if (Intrinsics.areEqual(r41.element, r112) == false) goto L118;
        r50 = RangesKt.coerceAtLeast(r210.a(), r99.intValue());
        if (r211 == null) goto L110;
        int r126 = r211.a();
    L111:
        int r127 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r126, r99.intValue()), r50);
        if (r126 > r99.intValue()) goto L114;
        r49 = "imeHidden_reuseBaseline";
    L117:
        r216 = r112;
        r48 = r127;
        r14 = "com.obric.memorydata.plugin";
        goto L151
    L114:
        if (r126 > r50) goto L116;
        r49 = "imeHidden_expandContent";
        goto L117
    L116:
        r49 = "imeHidden_capToScreen";
        goto L117
    L110:
        r126 = r99.intValue();
        goto L111
    L98:
        r211 = null;
        goto L99
    L89:
        if (r35.element > 0) goto L91;
        r32 = true;
    L28:
        r3 = null;
        goto L30
    }

    private static final void onCreateView$updateDescInputHeight$lambda$42$lambda$38(String r15, Ref.IntRef r16, Ref.IntRef r17, AutoMemoryCreateCollectionInfoFragment r18, Ref.IntRef r19, Ref.ObjectRef r20, Ref.BooleanRef r21, Ref.ObjectRef r22, Ref.ObjectRef r23, Ref.BooleanRef r24, Context r25, Lazy r26) {
        onCreateView$updateDescInputHeight(r17, r18, r19, r20, r16, r21, r22, r23, r24, (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.memorydata.plugin"), (Lazy) ZeusTransformUtils.wrapperContextForParams(r26, Lazy.class, "com.obric.memorydata.plugin"), false, r15 + "/retry" + r16.element);
    }

    private static final int onCreateView$visibleHeight(View r1) {
        Rect r0 = new Rect();
        r1.getGlobalVisibleRect(r0);
        return r0.height();
    }

    private final void showAiOptimizeDialog(boolean r5) {
        FragmentAutoMemoryCollectionInfoBinding r0 = this.binding;
        FragmentAutoMemoryCollectionInfoBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OPageStatus r2 = r0.pageStatusVerticalLoading;
        if (r5 == false) goto L8;
        int r3 = 0;
    L9:
        r2.setVisibility(r3);
        FragmentAutoMemoryCollectionInfoBinding r4 = this.binding;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L12:
        r4.pageStatusVerticalLoading.setGravity(17);
        FragmentAutoMemoryCollectionInfoBinding r6 = this.binding;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L15:
        r6.descInput.getVInput().setEnabled(!r5);
        if (r5 == false) goto L23;
        FragmentAutoMemoryCollectionInfoBinding r7 = this.binding;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r1.descInput.getVInput().clearFocus();
        return;
    L20:
        r1 = r7;
        goto L21
    L23:
        return;
    L8:
        r3 = 8;
        goto L9
    }

    private final void showGenerateLoading(boolean r7) {
        FragmentAutoMemoryCollectionInfoBinding r0 = this.binding;
        FragmentAutoMemoryCollectionInfoBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        LinearLayout r2 = r0.generateLoadingContainer;
        int r3 = 0;
        if (r7 == false) goto L8;
        int r5 = 0;
    L9:
        r2.setVisibility(r5);
        FragmentAutoMemoryCollectionInfoBinding r6 = this.binding;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        ODownloadProgressView r8 = r1.generateProgress;
        if (r7 == true) goto L17;
        r3 = 8;
    L17:
        r8.setVisibility(r3);
        return;
    L12:
        r1 = r6;
        goto L13
    L8:
        r5 = 8;
        goto L9
    }

    private static final AutoMemoryCreateCollectionViewModel viewModel_delegate$lambda$0(AutoMemoryCreateCollectionInfoFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (AutoMemoryCreateCollectionViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(AutoMemoryCreateCollectionViewModel.class), AutoMemoryCreateCollectionViewModel.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [T, com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$h] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r31, ViewGroup r32, Bundle r33) {
        Intrinsics.checkNotNullParameter(r31, "inflater");
        FragmentAutoMemoryCollectionInfoBinding r0 = FragmentAutoMemoryCollectionInfoBinding.inflate(r31, r32, false);
        Intrinsics.checkNotNullExpressionValue(r0, "inflate(...)");
        this.binding = r0;
        final Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "requireContext(...)");
        FragmentAutoMemoryCollectionInfoBinding r1 = this.binding;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        final int r2 = r1.bottomBar.getPaddingBottom();
        FragmentAutoMemoryCollectionInfoBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r3.getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$AutoMemoryCreateCollectionInfoFragment$xm1mbZiEcZl0dw6IAHH6nJgNeeA(this, r2));
        FragmentAutoMemoryCollectionInfoBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
        FragmentAutoMemoryCollectionInfoBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        OFloatingTitleBar r6 = r5.titleBar;
        r6.setFloatingTransitionEnabled(true);
        r6.setCenterTitle(ZeusTransformUtils.mapRes(R.string.memory_create_memory_task_title, TypedValues.Custom.S_STRING, "memory_create_memory_task_title"));
        OFloatingTitleBar.b(r6, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_close, "drawable", "o_floating_title_bar_icon_close"), 0, new $$Lambda$AutoMemoryCreateCollectionInfoFragment$0XP5VOHhc3KOgBeEh_6YostjBBI(this), 2, null);
        FragmentAutoMemoryCollectionInfoBinding r7 = this.binding;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L17:
        OInputLayout r8 = r7.descInput;
        r8.setType(1);
        r8.a(false);
        r8.c(false);
        r8.e(false);
        r8.g(false);
        r8.setLimitCount(2000);
        r8.setAutoChangeWithLimit(false);
        FragmentAutoMemoryCollectionInfoBinding r9 = this.binding;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L20:
        r9.descInputCounter.setText((CharSequence) ZeusTransformUtils.preCheckCast("0/2000", CharSequence.class, "com.obric.memorydata.plugin"));
        final Ref.IntRef r17 = new Ref.IntRef();
        final Ref.IntRef r18 = new Ref.IntRef();
        final Ref.IntRef r19 = new Ref.IntRef();
        final Lazy r20 = LazyKt.lazy($$Lambda$AutoMemoryCreateCollectionInfoFragment$amISkYlRyKYVcQJi5bhKt09Flw8.INSTANCE);
        final Ref.BooleanRef r21 = new Ref.BooleanRef();
        final Ref.ObjectRef r22 = new Ref.ObjectRef();
        FragmentAutoMemoryCollectionInfoBinding r10 = this.binding;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L23:
        OEditText r11 = r10.descInput.getVInput();
        r11.setBackground(null);
        r11.setMaxLines(Integer.MAX_VALUE);
        r11.setVerticalScrollBarEnabled(true);
        final Ref.BooleanRef r23 = new Ref.BooleanRef();
        final Ref.ObjectRef r24 = new Ref.ObjectRef();
        final Ref.ObjectRef r25 = new Ref.ObjectRef();
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = onCreateView$currentInputHeightConfigKey(this);
        FragmentAutoMemoryCollectionInfoBinding r14 = this.binding;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L26:
        r14.getRoot().addOnLayoutChangeListener(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$9Ob9TxZPg2U5AcLMWJFTo8QtcA(r13, r24, r25, this, r19, r17, r18, r23, r22, r21, r12, r20));
        FragmentAutoMemoryCollectionInfoBinding r15 = this.binding;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L29:
        r15.contentScroll.setOnScrollChangeListener(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$wTlEyVfVxzonoafTt9WHIvZCtR4(this));
        FragmentAutoMemoryCollectionInfoBinding r16 = this.binding;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L32:
        OEditText r26 = r16.descInput.getVInput();
        r26.setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        r26.setHorizontallyScrolling(false);
        r26.setTextAlignment(5);
        r26.setOnTouchListener(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$W2WTSWZDeO8FFJTO6FC0N9X8ogE(this));
        TextView r110 = (TextView) ZeusTransformUtils.preCheckCast(r26, TextView.class, "com.obric.memorydata.plugin");
        k r111 = new k(r26, r19, this, r17, r24, r18, r23, r25, r22, r21, r12, r20, this);
        r110.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r111, TextWatcher.class, "com.obric.memorydata.plugin"));
        TextWatcher r27 = (TextWatcher) ZeusTransformUtils.preCheckCast(r111, TextWatcher.class, "com.obric.memorydata.plugin");
        FragmentAutoMemoryCollectionInfoBinding r112 = this.binding;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L35:
        OButton r28 = r112.nextButton;
        r28.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_create_collection_next_step, TypedValues.Custom.S_STRING, "memory_create_collection_next_step")), CharSequence.class, "com.obric.memorydata.plugin"));
        r28.setOnClickListener(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$SGvKpIEjlNwH7bxOVeyKD59Ngg(this));
        kotlinx.coroutines.flow.i r29 = kotlinx.coroutines.flow.k.f(kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(getViewModel().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass10(this, null), Function2.class, "com.obric.memorydata.plugin"));
        LifecycleOwner r30 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r30, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.flow.k.b(r29, (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r30), al.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.flow.i r34 = kotlinx.coroutines.flow.k.f(kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(getViewModel().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass12(this, null), Function2.class, "com.obric.memorydata.plugin"));
        LifecycleOwner r35 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r35, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.flow.k.b(r34, (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r35), al.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.flow.i r36 = kotlinx.coroutines.flow.k.f(kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new d((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(getViewModel().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass14(this, null), Function2.class, "com.obric.memorydata.plugin"));
        LifecycleOwner r37 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r37, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.flow.k.b(r36, (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r37), al.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.flow.i r38 = kotlinx.coroutines.flow.k.f(kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new e((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(getViewModel().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass16(r17, this, r19, r24, r18, r23, r25, r22, r21, r12, r20, null), Function2.class, "com.obric.memorydata.plugin"));
        LifecycleOwner r39 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r39, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.flow.k.b(r38, (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r39), al.class, "com.obric.memorydata.plugin"));
        FragmentAutoMemoryCollectionInfoBinding r113 = this.binding;
        if (r113 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L38:
        r113.getRoot().post(new $$Lambda$AutoMemoryCreateCollectionInfoFragment$z7PcwElQijs4TMhtykJD4vKO3aA(this, r19, r17, r24, r18, r23, r25, r22, r21, r12, r20));
        FragmentActivity r40 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r40, BaseActivity.class) == false) goto L41;
        BaseActivity r114 = (BaseActivity) ZeusTransformUtils.preCheckCast(r40, BaseActivity.class, "com.obric.memorydata.plugin");
    L42:
        if (r114 == null) goto L50;
        FragmentAutoMemoryCollectionInfoBinding r41 = this.binding;
        if (r41 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r41 = null;
    L46:
        View r42 = (View) ZeusTransformUtils.preCheckCast(r41.titleBar, View.class, "com.obric.memorydata.plugin");
        FragmentAutoMemoryCollectionInfoBinding r43 = this.binding;
        if (r43 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r43 = null;
    L49:
        r114.setupCutOffArea(r42, r43.cutOff);
    L50:
        FragmentAutoMemoryCollectionInfoBinding r115 = this.binding;
        if (r115 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L53:
        FrameLayout r44 = r115.getRoot();
        Intrinsics.checkNotNullExpressionValue(r44, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r44, View.class, "com.obric.memorydata.plugin");
    L41:
        r114 = null;
        goto L42
    }
}
