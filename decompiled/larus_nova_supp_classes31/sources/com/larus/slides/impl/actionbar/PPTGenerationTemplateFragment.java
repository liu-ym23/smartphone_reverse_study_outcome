package com.larus.slides.impl.actionbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.NetworkUtils;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.y;
import com.larus.slides.biz.impl.databinding.LarusSlidesDialogPptTemplateSelectorBinding;
import com.larus.slides.impl.actionbar.model.PPTGenerationRepo;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001d\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u001b\u001a\u00020\f*\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0016J&\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0002J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020(2\u0006\u00105\u001a\u000206H\u0016J\b\u00108\u001a\u00020(H\u0002J\b\u00109\u001a\u00020(H\u0002J\b\u0010:\u001a\u00020(H\u0002J\b\u0010;\u001a\u00020(H\u0002J\u0016\u0010<\u001a\u00020(2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140>H\u0002J\u0016\u0010?\u001a\u00020(2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140>H\u0002J\u0006\u0010@\u001a\u00020(J\b\u0010A\u001a\u00020\u000eH\u0002J\b\u0010B\u001a\u00020(H\u0002J\u0010\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020EH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001a\u001a\u0004\b/\u00100¨\u0006G"}, d2 = {"Lcom/larus/slides/impl/actionbar/PPTGenerationTemplateFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusSlidesDialogPptTemplateSelectorBinding;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "templateAdapter", "Lcom/larus/slides/impl/actionbar/PPTTemplateAdapter;", "currentSelectedId", "", "isLoadingData", "", "hasMoreData", "nextCursor", "", "templateList", "", "Lcom/larus/slides/impl/actionbar/model/PPTTemplate;", "callback", "Lcom/larus/slides/impl/actionbar/PPTTemplateCallback;", "getCallback", "()Lcom/larus/slides/impl/actionbar/PPTTemplateCallback;", "callback$delegate", "Lkotlin/Lazy;", "typeStr", "scrollListener", "com/larus/slides/impl/actionbar/PPTGenerationTemplateFragment$scrollListener$1", "Lcom/larus/slides/impl/actionbar/PPTGenerationTemplateFragment$scrollListener$1;", "getTheme", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "setupSheetHeight", "setupPageDatas", "mobParam", "Lcom/larus/slides/impl/actionbar/PPTTemplateMobParam;", "getMobParam", "()Lcom/larus/slides/impl/actionbar/PPTTemplateMobParam;", "mobParam$delegate", "setupPageViews", "setupListeners", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onCancel", "finishActivityIfNeeded", "refreshData", "loadMoreData", "checkListViewVisibility", "refreshTemplateList", "templates", "", "loadMoreTemplateList", "setLoadMoreError", "restoreDataFromCache", "scrollToSelectedItem", "simulateTouchToFix", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PPTGenerationTemplateFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int n = 0;
    public LarusSlidesDialogPptTemplateSelectorBinding d;
    public PPTTemplateAdapter e;
    public String f;
    public boolean g;
    public boolean h;
    public int i;
    public final List<com.larus.slides.impl.actionbar.model.c> j;
    public final Lazy k;
    public final PPTGenerationTemplateFragment$scrollListener$1 l;
    public final Lazy m;

    public static final class a {
    }

    public static final class b implements l {
        public final /* synthetic */ PPTGenerationTemplateFragment a;

        public b(PPTGenerationTemplateFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.slides.impl.actionbar.l
        public final void a(int r6, com.larus.slides.impl.actionbar.model.c r7) {
            Intrinsics.checkNotNullParameter(r7, "template");
            this.a.f = r7.b();
            j.a r0 = j.a;
            String r1 = r7.b();
            j.a r2 = j.a;
            if (r2 == null) goto L5;
            List<com.larus.slides.impl.actionbar.model.c> r3 = r2.a;
            int r4 = r2.b;
            boolean r5 = r2.c;
            Intrinsics.checkNotNullParameter(r3, "templateList");
            j.a = new j.a(r3, r4, r5, r1);
            FLogger.a.d("PPTGenerationTemplateManager", "Selected template ID updated: " + r1);
        L5:
            FragmentActivity r8 = this.a.getActivity();
            if (r8 == null) goto L26;
            PPTGenerationTemplateFragment r9 = this.a;
            Intent r10 = new Intent();
            r10.putExtra("selected_id", r7.b());
            r10.putExtra("selected_name", r7.c());
            r9.getClass();
            Integer r11 = r7.getType();
            if (r11 != null) goto L11;
        L13:
            if (r11 != null) goto L16;
        L18:
            if (r11 != null) goto L21;
        L23:
            String r12 = "";
        L24:
            r10.putExtra("selected_type", r12);
            r10.putExtra("selected_item_show_position", r6 + 1);
            r10.putExtra("selected_result_from", "selected_result_from_action_bar_button_router");
            Unit r13 = Unit.INSTANCE;
            r8.setResult(-1, r10);
            r8.finish();
            return;
        L21:
            if (r11.intValue() != 3) goto L23;
            r12 = "auto_match";
            goto L24
        L16:
            if (r11.intValue() != 2) goto L18;
            r12 = "self_design";
            goto L24
        L11:
            if (r11.intValue() != 1) goto L13;
            r12 = "official_template";
            goto L24
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$refreshData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$refreshData$1", f = "PPTGenerationTemplateFragment.kt", i = {}, l = {391, 396, 407}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PPTGenerationTemplateFragment this$0;

        /* JADX INFO: renamed from: com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$refreshData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$refreshData$1$1", f = "PPTGenerationTemplateFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ com.larus.slides.impl.actionbar.model.d $result;
            int label;
            final /* synthetic */ PPTGenerationTemplateFragment this$0;

            public C00331(PPTGenerationTemplateFragment r1, com.larus.slides.impl.actionbar.model.d r2, Continuation<? super C00331> r3) {
                this.this$0 = r1;
                this.$result = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00331(this.this$0, this.$result, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L39;
                ResultKt.throwOnFailure(r6);
                PPTGenerationTemplateFragment r7 = this.this$0;
                com.larus.slides.impl.actionbar.model.d r0 = this.$result;
                if (r0 == null) goto L7;
                boolean r1 = r0.a();
            L8:
                r7.h = r1;
                PPTGenerationTemplateFragment r8 = this.this$0;
                com.larus.slides.impl.actionbar.model.d r2 = this.$result;
                if (r2 == null) goto L11;
                int r3 = r2.b();
            L12:
                r8.i = r3;
                LarusSlidesDialogPptTemplateSelectorBinding r9 = this.this$0.d;
                if (r9 == null) goto L17;
                LinearLayout r10 = r9.b;
                if (r10 == null) goto L17;
                e1.o(r10);
            L17:
                LarusSlidesDialogPptTemplateSelectorBinding r11 = this.this$0.d;
                if (r11 == null) goto L22;
                ProgressBar r12 = r11.c;
                if (r12 == null) goto L22;
                e1.o(r12);
            L22:
                com.larus.slides.impl.actionbar.model.d r13 = this.$result;
                if (r13 == null) goto L37;
                List<com.larus.slides.impl.actionbar.model.c> r14 = r13.c();
                if (r14 == null) goto L37;
                List r15 = CollectionsKt.filterNotNull(r14);
                if (r15 == null) goto L37;
                PPTGenerationTemplateFragment r4 = this.this$0;
                ((ArrayList) r4.j).clear();
                ArrayList r5 = (ArrayList) r4.j;
                r5.addAll(r15);
                Iterator r16 = ((ArrayList) r4.j).iterator();
            L30:
                if (r16.hasNext() == false) goto L32;
                com.larus.slides.impl.actionbar.model.c r17 = (com.larus.slides.impl.actionbar.model.c) r16.next();
                r17.e(Intrinsics.areEqual(r17.b(), String.valueOf(r4.f)));
                goto L30
            L32:
                PPTTemplateAdapter r18 = r4.e;
                if (r18 == null) goto L35;
                r18.y2(r4.j, r4.h);
            L35:
                r4.g = false;
                j.a r19 = j.a;
                j.a(r4.j, r4.i, r4.h, r4.f);
                r4.S90();
            L37:
                return Unit.INSTANCE;
            L11:
                r3 = 0;
                goto L12
            L7:
                r1 = false;
                goto L8
            L39:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$refreshData$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$refreshData$1$2", f = "PPTGenerationTemplateFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PPTGenerationTemplateFragment this$0;

            public AnonymousClass2(PPTGenerationTemplateFragment r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L17;
                ResultKt.throwOnFailure(r2);
                PPTGenerationTemplateFragment r3 = this.this$0;
                r3.g = false;
                LarusSlidesDialogPptTemplateSelectorBinding r4 = r3.d;
                if (r4 == null) goto L9;
                LinearLayout r5 = r4.b;
                if (r5 == null) goto L9;
                e1.x(r5);
            L9:
                LarusSlidesDialogPptTemplateSelectorBinding r6 = this.this$0.d;
                if (r6 == null) goto L14;
                ProgressBar r7 = r6.c;
                if (r7 == null) goto L14;
                e1.o(r7);
            L14:
                this.this$0.S90();
                return Unit.INSTANCE;
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(PPTGenerationTemplateFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r7);
        L24:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r7);
        L15:
            y r8 = (com.larus.network.http.a) r7;
            if ((r8 instanceof y) == false) goto L20;
            com.larus.slides.impl.actionbar.model.d r9 = (com.larus.slides.impl.actionbar.model.d) ((com.larus.network.http.a) r8).b;
            MainCoroutineDispatcher r2 = Dispatchers.getMain();
            C00331 r3 = new C00331(this.this$0, r9, null);
            this.label = 2;
            if (BuildersKt.withContext(r2, r3, this) != r0) goto L24;
            return r0;
        L20:
            MainCoroutineDispatcher r10 = Dispatchers.getMain();
            AnonymousClass2 r4 = new AnonymousClass2(this.this$0, null);
            this.label = 3;
            if (BuildersKt.withContext(r10, r4, this) != r0) goto L24;
            return r0;
        L12:
            ResultKt.throwOnFailure(r7);
            PPTGenerationRepo r11 = PPTGenerationRepo.a;
            int r5 = this.this$0.i;
            this.label = 1;
            r7 = r11.a(r5, 20, this);
            if (r7 != r0) goto L15;
            return r0;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void S90() {
        if ((!this.j.isEmpty()) == false) goto L9;
        LarusSlidesDialogPptTemplateSelectorBinding r0 = this.d;
        if (r0 == null) goto L15;
        RecyclerView r1 = r0.d;
        if (r1 == null) goto L16;
        e1.x(r1);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LarusSlidesDialogPptTemplateSelectorBinding r2 = this.d;
        if (r2 == null) goto L18;
        RecyclerView r3 = r2.d;
        if (r3 == null) goto L19;
        e1.o(r3);
        return;
    L19:
        return;
    }

    public final n U90() {
        return (n) this.m.getValue();
    }

    public final void V90() {
        if (this.g == false) goto L5;
    L9:
        FLogger.a.d("PPTGenerationTemplateFragment", "Load more skipped: isLoadingMore=" + this.g + ", hasMoreData=" + this.h);
        return;
    L5:
        if (this.h == false) goto L9;
        this.g = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new PPTGenerationTemplateFragment$loadMoreData$1(this, null), 2, null);
        FLogger.a.i("PPTGenerationTemplateFragment", "Loading more data, page: " + this.i);
    }

    public final void refreshData() {
        if (this.g == false) goto L5;
    L32:
        FLogger.a.d("PPTGenerationTemplateFragment", "Refresh skipped: isLoadingMore=" + this.g + ", hasMoreData=" + this.h);
        return;
    L5:
        if (this.h == false) goto L32;
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication().getApplicationContext()) == true) goto L20;
        LarusSlidesDialogPptTemplateSelectorBinding r0 = this.d;
        if (r0 == null) goto L14;
        LinearLayout r1 = r0.b;
        if (r1 == null) goto L14;
        e1.x(r1);
    L14:
        LarusSlidesDialogPptTemplateSelectorBinding r2 = this.d;
        if (r2 == null) goto L34;
        ProgressBar r3 = r2.c;
        if (r3 == null) goto L35;
        e1.o(r3);
        return;
    L35:
        return;
    L34:
        return;
    L20:
        this.g = true;
        LarusSlidesDialogPptTemplateSelectorBinding r4 = this.d;
        if (r4 == null) goto L25;
        LinearLayout r5 = r4.b;
        if (r5 == null) goto L25;
        e1.o(r5);
    L25:
        LarusSlidesDialogPptTemplateSelectorBinding r6 = this.d;
        if (r6 == null) goto L30;
        ProgressBar r7 = r6.c;
        if (r7 == null) goto L30;
        e1.x(r7);
    L30:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        FLogger.a.i("PPTGenerationTemplateFragment", "Refresh data, page: " + this.i);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$scrollListener$1] */
    public PPTGenerationTemplateFragment() {
        this.h = true;
        this.j = new ArrayList();
        this.k = LazyKt.lazy(new com.larus.slides.impl.actionbar.a(this));
        this.l = new PPTGenerationTemplateFragment$scrollListener$1(this);
        this.m = LazyKt.lazy(new com.larus.slides.impl.actionbar.b(this));
    }

    public final void T90() {
        if ((getActivity() instanceof PPTGenerationTemplateActivity) == false) goto L14;
        FragmentActivity r0 = getActivity();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L15;
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L16;
        r2.finish();
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r0.isFinishing() == true) goto L9;
        r1 = true;
        goto L9
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        T90();
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L5
        T90();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.slides.impl.actionbar.c] */
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        Resources r11 = getResources();
        final int r12 = (int) (((double) WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).heightPixels) * 0.8d);
        Dialog r13 = getDialog();
        if (r13 == null) goto L5;
        r13.setOnShowListener(new e(r12, this));
    L5:
        Bundle r14 = getArguments();
        j.a r15 = null;
        if (r14 == null) goto L8;
        String r16 = r14.getString("extra_selected_template_id", "");
    L9:
        this.f = r16;
        final int r0 = 0;
        if (r16 != null) goto L12;
    L15:
        boolean r17 = true;
    L16:
        if (r17 == false) goto L22;
        j.a r18 = j.a;
        if (r18 == null) goto L20;
        String r19 = r18.d;
    L21:
        this.f = r19;
        goto L22
    L20:
        r19 = null;
    L22:
        LarusSlidesDialogPptTemplateSelectorBinding r20 = this.d;
        if (r20 == null) goto L31;
        RecyclerView r21 = r20.d;
        if (r21 == null) goto L31;
        PPTTemplateAdapter r2 = new PPTTemplateAdapter((l) this.k.getValue(), new c(this));
        this.e = r2;
        r21.setAdapter(r2);
        GridLayoutManager r3 = new GridLayoutManager(r21.getContext(), 2);
        final PPTTemplateAdapter r4 = this.e;
        if (r4 == null) goto L29;
        GridLayoutManager.SpanSizeLookup r5 = new PPTTemplateAdapter$getSpanSizeLookup$1(r4);
    L30:
        r3.setSpanSizeLookup(r5);
        r21.setLayoutManager(r3);
        r21.setItemAnimator(null);
        r21.addItemDecoration(new PPTGenerationTemplateFragment$setupPageViews$1$2());
        y6.d(r21, null, null, null, new d(this), 15);
        r21.addOnItemTouchListener(new PPTGenerationTemplateFragment$setupPageViews$1$4());
        goto L31
    L29:
        r5 = null;
    L31:
        LarusSlidesDialogPptTemplateSelectorBinding r22 = this.d;
        if (r22 == null) goto L36;
        RecyclerView r23 = r22.d;
        if (r23 == null) goto L36;
        r23.addOnScrollListener(this.l);
    L36:
        LarusSlidesDialogPptTemplateSelectorBinding r24 = this.d;
        if (r24 == null) goto L41;
        LinearLayout r25 = r24.b;
        if (r25 == null) goto L41;
        e1.d(r25, new g(this));
    L41:
        j.a r26 = j.a;
        if (r26 == null) goto L45;
        r15 = new j.a(r26.a, r26.b, r26.c, r26.d);
    L45:
        if (r15 == null) goto L80;
        j.a r6 = j.a;
        if (r6 != null) goto L50;
    L52:
        boolean r7 = false;
    L53:
        if (r7 == false) goto L80;
        ((ArrayList) this.j).clear();
        ((ArrayList) this.j).addAll(r15.a);
        this.i = r15.b;
        boolean r8 = r15.c;
        this.h = r8;
        this.f = r15.d;
        PPTTemplateAdapter r110 = this.e;
        if (r110 == null) goto L58;
        r110.y2(this.j, r8);
    L58:
        S90();
        String r111 = this.f;
        if (r111 == null) goto L79;
        j.a r27 = j.a;
        if (r27 == null) goto L71;
        List<com.larus.slides.impl.actionbar.model.c> r28 = r27.a;
        if (r28 == null) goto L71;
        Iterator<com.larus.slides.impl.actionbar.model.c> r29 = r28.iterator();
    L66:
        if (r29.hasNext() == false) goto L71;
        if (Intrinsics.areEqual(r29.next().b(), r111) == true) goto L72;
        r0 = r0 + 1;
    L72:
        if (r0 < 0) goto L79;
        LarusSlidesDialogPptTemplateSelectorBinding r112 = this.d;
        if (r112 == null) goto L79;
        final RecyclerView r113 = r112.d;
        if (r113 == null) goto L79;
        r113.post(new f(r113, r0, this));
    L71:
        r0 = -1;
    L79:
        FLogger.a.d("PPTGenerationTemplateFragment", "Data restored from cache, count: " + ((ArrayList) this.j).size() + ", selectedId: " + this.f);
        r0 = 1;
        goto L80
    L50:
        if ((!r6.a.isEmpty()) == false) goto L52;
        r7 = true;
    L80:
        if (r0 == 0) goto L82;
        FLogger.a.d("PPTGenerationTemplateFragment", "Data restored from cache");
        return;
    L82:
        FLogger.a.d("PPTGenerationTemplateFragment", "No valid cache, refreshing data");
        refreshData();
        return;
    L12:
        if (r16.length() == 0) goto L15;
        r17 = false;
        goto L16
    L8:
        r16 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131563135, r8, false);
        int r11 = 2131377491;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131377491);
        if (r2 == null) goto L13;
        r11 = 2131383302;
        ProgressBar r3 = (ProgressBar) ViewBindings.findChildViewById(r10, 2131383302);
        if (r3 == null) goto L13;
        r11 = 2131385019;
        RecyclerView r4 = ViewBindings.findChildViewById(r10, 2131385019);
        if (r4 == null) goto L13;
        r11 = 2131386176;
        View r5 = ViewBindings.findChildViewById(r10, 2131386176);
        if (r5 == null) goto L13;
        ConstraintLayout r12 = r10;
        this.d = new LarusSlidesDialogPptTemplateSelectorBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
