package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import bwb.b;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.y;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\nJ\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleViewModel;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviViewModel;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleUIEvent;", "mainViewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;)V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "subtitleRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmRecordingSubtitleRepo;", "getSubtitleRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmRecordingSubtitleRepo;", "aiNoteRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;", "getAiNoteRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;", "defaultState", "dispatchEvent", "", "event", "isSubtitleMarkEnabled", "", "isSubtitleMarked", "markId", "loadForwardSubtitle", "switchScrollMode", "mode", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleScrollMode;", "Factory", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSubtitleViewModel extends MviViewModel<a, Object, y> {
    private final Lazy logDetail$delegate;
    private final MmRecordingViewModel mainViewModel;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "subtitles", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmSubtitleItem;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleViewModel$3", f = "MmSubtitleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<List<? extends h>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmSubtitleViewModel this$0;

        public AnonymousClass3(MmSubtitleViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((List) r1, (Continuation) r2);
        }

        public final Object invoke(List<h> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            final List<h> r4 = (List) this.L$0;
            if (this.this$0.getState().b == r4) goto L8;
            this.this$0.setState(new AnonymousClass1(r4));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleViewModel$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "degraded", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleViewModel$5", f = "MmSubtitleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ MmSubtitleViewModel this$0;

        public AnonymousClass5(MmSubtitleViewModel r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass5 r0 = new AnonymousClass5(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            final boolean r4 = this.Z$0;
            this.this$0.setState(new AnonymousClass1(r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "mainViewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Factory implements ViewModelProvider.Factory {
        public final MmRecordingViewModel a;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public Factory(MmRecordingViewModel r2) {
            Intrinsics.checkNotNullParameter(r2, "mainViewModel");
            this.a = r2;
        }

        public final <T extends ViewModel> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "modelClass");
            if (r2.isAssignableFrom(MmSubtitleViewModel.class) == false) goto L7;
            return new MmSubtitleViewModel(this.a);
        L7:
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }

    private final MmRecordingAINoteRepo getAiNoteRepo() {
        return this.mainViewModel.getAiNoteRepo();
    }

    private final String getLogDetail() {
        return (String) this.logDetail$delegate.getValue();
    }

    private final MmRecordingSubtitleRepo getSubtitleRepo() {
        return this.mainViewModel.getSubtitleRepo();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public a defaultState() {
        return new a(0);
    }

    private final void loadForwardSubtitle() {
        MmRecordingSubtitleRepo r0 = getSubtitleRepo();
        if (r0 != null) goto L5;
        return;
    L5:
        String r3 = this.mainViewModel.getMeetingId();
        if (r3 != null) goto L8;
        return;
    L8:
        h r1 = (h) CollectionsKt.firstOrNull(getState().b);
        if (r1 == null) goto L11;
        long r2 = r1.a;
    L12:
        long r5 = r2;
        String r4 = this.mainViewModel.resolveSubtitleTranslateLanguage();
        if (StringsKt.isBlank(r4) == false) goto L16;
        int r6 = b.a;
        b.h(MmUiLogScene.SUBTITLE, "loadForwardSubtitle", "skip, meetingId=" + lvb.a.d(r3) + ", effectiveLanguage empty, targetSeqId=" + r5 + ", source=PULL_TO_REFRESH", getLogDetail());
        return;
    L16:
        int r7 = b.a;
        b.f(MmUiLogScene.SUBTITLE, "loadForwardSubtitle", "meetingId=" + lvb.a.d(r3) + ", effectiveLanguage=" + r4 + ", targetSeqId=" + r5 + ", source=PULL_TO_REFRESH", getLogDetail());
        r0.l().b0(r3, r4, r5, 20);
        return;
    L11:
        r2 = 0;
        goto L12
    }

    public final boolean isSubtitleMarkEnabled() {
        MmRecordingAINoteRepo r0 = getAiNoteRepo();
        if (r0 == null) goto L10;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a r1 = r0.x();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.y0() != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ l defaultState() {
        return defaultState();
    }

    public MmSubtitleViewModel(MmRecordingViewModel r8) {
        Intrinsics.checkNotNullParameter(r8, "mainViewModel");
        this.mainViewModel = r8;
        this.logDetail$delegate = LazyKt.lazy(new MmSubtitleViewModel$logDetail$2(this));
        int r0 = b.a;
        b.f(MmUiLogScene.SUBTITLE, "init", "mainViewModel:" + r8, getLogDetail());
        MmRecordingSubtitleRepo r9 = getSubtitleRepo();
        if (r9 == null) goto L9;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a r10 = r9.l();
        if (r10 == null) goto L9;
        i1<d> r1 = r10.b();
        if (r1 == null) goto L9;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r1, getViewModelScope(), AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, new AnonymousClass3(this, null), 4);
    L9:
        MmRecordingSubtitleRepo r11 = getSubtitleRepo();
        if (r11 == null) goto L17;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a r12 = r11.l();
        if (r12 == null) goto L18;
        i1<d> r2 = r12.b();
        if (r2 == null) goto L19;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r2, getViewModelScope(), AnonymousClass4.INSTANCE, null, new AnonymousClass5(this, null), 12);
        return;
    L19:
        return;
    L18:
        return;
    }

    private final void switchScrollMode(final MmSubtitleScrollMode r2) {
        setState(new C02611(r2));
    }

    public void dispatchEvent(y r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = b.a;
        b.a(MmUiLogScene.SUBTITLE, "dispatchEvent", "event:" + r5, getLogDetail());
        if ((r5 instanceof y.a) == false) goto L6;
        loadForwardSubtitle();
        return;
    L6:
        if ((r5 instanceof y.c) == false) goto L9;
        switchScrollMode(((y.c) r5).a);
        return;
    L9:
        if ((r5 instanceof y.b) == false) goto L21;
        MmRecordingAINoteRepo r1 = getAiNoteRepo();
        if (r1 == null) goto L17;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a r2 = r1.x();
        if (r2 == null) goto L17;
        boolean r6 = r2.o(((y.b) r5).a);
        boolean r3 = true;
        if (r6 != true) goto L17;
    L18:
        if (r3 == false) goto L32;
        this.mainViewModel.showFirstMarkFeedbackIfNeeded();
        return;
    L32:
        return;
    L17:
        r3 = false;
        goto L18
    L21:
        if ((r5 instanceof y.d) == false) goto L29;
        MmRecordingAINoteRepo r4 = getAiNoteRepo();
        if (r4 == null) goto L34;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a r7 = r4.x();
        if (r7 == null) goto L35;
        r7.q(((y.d) r5).a);
        return;
    L35:
        return;
    L34:
        return;
    L29:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isSubtitleMarked(String r5) {
        Intrinsics.checkNotNullParameter(r5, "markId");
        MmRecordingAINoteRepo r0 = getAiNoteRepo();
        if (r0 == null) goto L13;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a r1 = r0.x();
        if (r1 == null) goto L13;
        if (r1.R(r5) == false) goto L12;
        int r2 = b.a;
        b.f(MmUiLogScene.SUBTITLE, "isSubtitleMarked", "ignore fishbone mark collision, markId=" + r5, getLogDetail());
        return false;
    L12:
        return r1.y(r5);
    L13:
        return false;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ void dispatchEvent(j r1) {
        dispatchEvent((y) r1);
    }
}
