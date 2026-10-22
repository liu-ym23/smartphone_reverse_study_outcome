package com.obric.memorydata.memory.ui.automemory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.memory.databinding.ActivityAutoMemoryDetailBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryDetailActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "viewModel", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryFriendAgreementDetailViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryFriendAgreementDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityAutoMemoryDetailBinding;", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryDetailActivity extends BaseMemoryActivity {
    private static final String AUTO_MEMORY_DATA = "auto_memory_data";
    public static final a Companion = null;
    private static final String TAG = "AutoMemoryDetailActivity";
    private ActivityAutoMemoryDetailBinding binding;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryDetailActivity$Companion;", "", "<init>", "()V", "TAG", "", "AUTO_MEMORY_DATA", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", OaidModel.KEY_ID, "", "clearTask", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void a(a r1, Context r2, long r3, boolean r5, int r6, Object r7) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if ((r6 & 4) == 0) goto L5;
            r5 = false;
        L5:
            r1.a(r4, r3, r5);
        }

        public final void a(Context r3, long r4, boolean r6) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r5 = new Intent(r2, AutoMemoryDetailActivity.class);
            r5.putExtra(AutoMemoryDetailActivity.AUTO_MEMORY_DATA, r4);
            if (r6 == false) goto L7;
            int r7 = 268468224;
        L5:
            r5.addFlags(r7);
        L9:
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.memorydata.plugin");
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L9;
            r7 = SQLiteDatabase.CREATE_IF_NECESSARY;
            goto L5
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryDetailActivity$onCreateChecked$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryDetailActivity$onCreateChecked$1", f = "AutoMemoryDetailActivity.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ MarkdownTextView $contentMarkdownView;
        final /* synthetic */ Ref.ObjectRef<String> $latestContent;
        final /* synthetic */ TextView $titleTextView;
        int label;
        final /* synthetic */ AutoMemoryDetailActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryDetailActivity$onCreateChecked$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class C05271<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ TextView f10597a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<String> f10598b;
            final /* synthetic */ MarkdownTextView c;
            final /* synthetic */ AutoMemoryDetailActivity d;

            C05271(TextView r3, Ref.ObjectRef<String> r4, MarkdownTextView r5, AutoMemoryDetailActivity r6) {
                AutoMemoryDetailActivity r7 = (AutoMemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r6, AutoMemoryDetailActivity.class, "com.obric.memorydata.plugin");
                this.f10597a = r3;
                this.f10598b = r4;
                this.c = r5;
                this.d = r7;
            }

            private static final Unit a(Ref.ObjectRef r49, String r50, AutoMemoryDetailActivity r51, MarkdownTextView r52, int r53) {
                AutoMemoryDetailActivity r0 = (AutoMemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r51, AutoMemoryDetailActivity.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(r49.element, r50) == false) goto L5;
                com.larus.business.markdown.api.a r1 = com.obric.memorydata.markdown.a.f9973a.b();
                if (r1 == null) goto L9;
                com.larus.business.markdown.api.model.h r2 = com.larus.business.markdown.api.a.b.a(r1, (Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"), r53, r50, true, new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()))), Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -98305, null), null, null, null, 224, null);
            L10:
                r52.setMarkdownWidth(r53);
                if (r2 == null) goto L13;
                r52.setMarkdown(r2);
            L15:
                return Unit.INSTANCE;
            L13:
                r52.setText((CharSequence) ZeusTransformUtils.preCheckCast(r50, CharSequence.class, "com.obric.memorydata.plugin"));
                goto L15
            L9:
                r2 = null;
                goto L10
            L5:
                return Unit.INSTANCE;
            }

            public static /* synthetic */ Unit lambda$rNrOtC3TZ4gm8PiC3fBdNhpNUps(Ref.ObjectRef r0, String r1, AutoMemoryDetailActivity r2, MarkdownTextView r3, int r4) {
                return a(r0, r1, r2, r3, r4);
            }

            /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.String] */
            public final Object a(i r4, Continuation<? super Unit> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.f10597a.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.a(), CharSequence.class, "com.obric.memorydata.plugin"));
                final ?? r7 = (T) StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
                this.f10598b.element = r7;
                View r8 = (View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin");
                final Ref.ObjectRef<String> r0 = this.f10598b;
                final AutoMemoryDetailActivity r1 = this.d;
                final MarkdownTextView r3 = this.c;
                com.obric.memorydata.memory.ui.p.a(r8, false, new $$Lambda$AutoMemoryDetailActivity$onCreateChecked$1$1$rNrOtC3TZ4gm8PiC3fBdNhpNUps(r0, r7, r1, r3), 2, null);
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        AnonymousClass1(AutoMemoryDetailActivity r3, TextView r4, Ref.ObjectRef<String> r5, MarkdownTextView r6, Continuation<? super AnonymousClass1> r7) {
            AutoMemoryDetailActivity r8 = (AutoMemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryDetailActivity.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r8;
            this.$titleTextView = r4;
            this.$latestContent = r5;
            this.$contentMarkdownView = r6;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$titleTextView, this.$latestContent, this.$contentMarkdownView, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r8);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            ar<i> r9 = AutoMemoryDetailActivity.access$getViewModel(this.this$0).getState();
            kotlinx.coroutines.flow.j<? super i> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05271(this.$titleTextView, this.$latestContent, this.$contentMarkdownView, this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r9.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoMemoryDetailActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new AutoMemoryDetailActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(AutoMemoryFriendAgreementDetailViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new AutoMemoryDetailActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new AutoMemoryDetailActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ AutoMemoryFriendAgreementDetailViewModel access$getViewModel(AutoMemoryDetailActivity r2) {
        return ((AutoMemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryDetailActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    private final AutoMemoryFriendAgreementDetailViewModel getViewModel() {
        return (AutoMemoryFriendAgreementDetailViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), AutoMemoryFriendAgreementDetailViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r16) {
        setupInset();
        prepareSystemBar();
        ActivityAutoMemoryDetailBinding r0 = ActivityAutoMemoryDetailBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r0, "inflate(...)");
        this.binding = r0;
        ActivityAutoMemoryDetailBinding r3 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r0.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityAutoMemoryDetailBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        OScrollView r2 = r1.scrollView;
        Intrinsics.checkNotNullExpressionValue(r2, "scrollView");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        ActivityAutoMemoryDetailBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        OFloatingTitleBar r5 = r4.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r5, "viewTitle");
        ActivityAutoMemoryDetailBinding r6 = this.binding;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L14:
        OScrollView r7 = r6.scrollView;
        Intrinsics.checkNotNullExpressionValue(r7, "scrollView");
        ActivityAutoMemoryDetailBinding r8 = this.binding;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L17:
        TextView r9 = r8.titleText;
        Intrinsics.checkNotNullExpressionValue(r9, "titleText");
        ActivityAutoMemoryDetailBinding r10 = this.binding;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L20:
        MarkdownTextView r11 = r10.contentMarkdown;
        Intrinsics.checkNotNullExpressionValue(r11, "contentMarkdown");
        r11.setLineSpacing(MathKt.roundToInt(TypedValue.applyDimension(1, 6, Resources.getSystem().getDisplayMetrics())), 1.0f);
        com.obric.memorydata.memory.ui.m.a((TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.memorydata.plugin"), (ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin"));
        View r12 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        ActivityAutoMemoryDetailBinding r14 = this.binding;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        setupTitleBarBackAction(r5, r12, r13, r3.cutOff);
        registerFloatingTitleBar(r5);
        getViewModel().load(getIntent().getLongExtra(AUTO_MEMORY_DATA, -1));
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = "";
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r9, r15, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L23:
        r3 = r14;
        goto L24
    }
}
