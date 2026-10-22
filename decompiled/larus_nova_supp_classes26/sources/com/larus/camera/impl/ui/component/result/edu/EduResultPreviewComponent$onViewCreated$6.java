package com.larus.camera.impl.ui.component.result.edu;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.camera.impl.databinding.LarusLayoutViewEduPreviewComponentBinding;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.widget.EduPreviewLoadingView;
import com.larus.platform.service.z2;
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
import kotlinx.coroutines.flow.StateFlowImpl;
import nx8.m;
import oq9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.edu.EduResultPreviewComponent$onViewCreated$6", f = "EduResultPreviewComponent.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
public final class EduResultPreviewComponent$onViewCreated$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    int label;
    final /* synthetic */ EduResultPreviewComponent this$0;

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.edu.EduResultPreviewComponent$onViewCreated$6$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/camera/impl/edulibs/cameraapi/EduImageClipState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.edu.EduResultPreviewComponent$onViewCreated$6$1", f = "EduResultPreviewComponent.kt", i = {0, 0}, l = {226}, m = "invokeSuspend", n = {"state", "isDataLoading"}, s = {"L$0", "Z$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<nx8.f, Continuation<? super Unit>, Object> {
        final /* synthetic */ CameraResultViewModel $viewModel;
        /* synthetic */ Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ EduResultPreviewComponent this$0;

        public AnonymousClass1(EduResultPreviewComponent r1, CameraResultViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$viewModel = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$viewModel, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((nx8.f) r1, (Continuation) r2);
        }

        public final Object invoke(nx8.f r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            boolean r3 = this.Z$0;
            nx8.f r4 = (nx8.f) this.L$0;
            ResultKt.throwOnFailure(r14);
        L16:
            boolean r15 = r3;
        L18:
            if (r15 == true) goto L65;
            final EduResultPreviewComponent r16 = this.this$0;
            final CameraResultViewModel r5 = this.$viewModel;
            if (r16.p == true) goto L65;
            r16.p = true;
            String r6 = r16.s();
            if (Intrinsics.areEqual(r6, "CAPTURE_MODE_EDU_GENERAL_PHOTO") == false) goto L48;
            LarusLayoutViewEduPreviewComponentBinding r7 = r16.n;
            if (r7 == null) goto L65;
            if (r16.t() == false) goto L46;
            r7.g.setVisibility(8);
            if (((g) r16.o.getValue()).d() == false) goto L41;
            r7.f.setVisibility(8);
            if (((g) r16.o.getValue()).a() != 1) goto L33;
            EduResultMode r8 = EduResultMode.MULTI_QUESTION;
        L34:
            m r9 = r16.m;
            if (r9 != null) goto L37;
        L39:
            boolean r10 = false;
        L40:
            r5.updateEduResultTabState(EduResultPreviewComponent.r(r8, r10));
            r16.p(r5, r8);
            goto L65
        L37:
            if (r9.q() != true) goto L39;
            r10 = true;
            goto L40
        L33:
            r8 = EduResultMode.SINGLE_QUESTION;
            goto L34
        L41:
            r5.updateEduResultTabState(px8.b.e);
            if (z2.a.getEduDefaultQuestionMode() != 1) goto L44;
            boolean r11 = true;
        L45:
            r16.q(r5, r11);
            TextView r12 = r7.f;
            r12.setVisibility(0);
            r12.setOnClickListener(new b(r16, r5));
            goto L65
        L44:
            r11 = false;
            goto L45
        L46:
            EduResultMode r13 = EduResultMode.SINGLE_QUESTION;
            r5.updateEduResultTabState(new px8.b(CollectionsKt.listOf(r13), r13, false, r13));
            r7.f.setVisibility(8);
            r5.changeMultiQuestionMode(false);
            BuildersKt.launch$default(r16.k(), null, null, new EduResultPreviewComponent$showGeneralQuestionTip$1$2(r7, null), 3, null);
            goto L65
        L48:
            if (Intrinsics.areEqual(r6, "CAPTURE_MODE_EDU_HOMEWORK_PHOTO") == false) goto L60;
            LarusLayoutViewEduPreviewComponentBinding r17 = r16.n;
            if (r17 == null) goto L55;
            FrameLayout r18 = r17.e;
            if (r18 == null) goto L55;
            r18.setVisibility(8);
        L55:
            if (((g) r16.o.getValue()).d() == true) goto L57;
        L59:
            EduResultMode r19 = EduResultMode.HOMEWORK_CORRECTION;
            r5.updateEduResultTabState(new px8.b(CollectionsKt.listOf(r19), r19, false, r19));
            r16.p(r5, r19);
            goto L65
        L57:
            if (r16.t() == false) goto L59;
            EduResultMode r20 = EduResultMode.HOMEWORK_CORRECTION;
            r5.updateEduResultTabState(EduResultPreviewComponent.r(r20, true));
            r16.p(r5, r20);
            goto L65
        L60:
            r5.updateEduResultTabState(px8.b.e);
            LarusLayoutViewEduPreviewComponentBinding r110 = r16.n;
            if (r110 == null) goto L65;
            FrameLayout r111 = r110.e;
            if (r111 == null) goto L65;
            r111.setVisibility(8);
        L65:
            nx8.f.a r112 = nx8.f.a.b;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r112, "o");
            if (Intrinsics.compare(r4.a, 2) < 0) goto L69;
            r2 = false;
        L69:
            this.$viewModel.tryUpdateEduImageLoading(r2);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            r4 = (nx8.f) this.L$0;
            r15 = Intrinsics.areEqual(r4, nx8.f.c.b);
            LarusLayoutViewEduPreviewComponentBinding r21 = this.this$0.n;
            if (r21 == null) goto L18;
            EduPreviewLoadingView r22 = r21.c;
            if (r22 == null) goto L18;
            this.L$0 = r4;
            this.Z$0 = r15;
            this.label = 1;
            if (r22.l(r15, this) != r0) goto L15;
            return r0;
        L15:
            r3 = r15;
            goto L16
        }
    }

    public EduResultPreviewComponent$onViewCreated$6(EduResultPreviewComponent r1, CameraResultViewModel r2, Continuation<? super EduResultPreviewComponent$onViewCreated$6> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new EduResultPreviewComponent$onViewCreated$6(this.this$0, this.$viewModel, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        m r8 = this.this$0.m;
        if (r8 == null) goto L16;
        StateFlowImpl r9 = r8.i();
        if (r9 == null) goto L16;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$viewModel, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r9, r2, this) != r0) goto L16;
        return r0;
    }
}
