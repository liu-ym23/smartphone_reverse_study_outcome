package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteHint;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001(B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\rJ\r\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010!\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u0006\u0010%\u001a\u00020\u0017J\u000e\u0010&\u001a\u00020\u0017*\u0004\u0018\u00010'H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteViewModel;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviViewModel;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteUIEvent;", "args", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteFragmentArgs;", "repo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteFragmentArgs;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;)V", "defaultState", "attachHost", "", "container", "Landroid/view/ViewGroup;", "callback", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteHostCallback;", "detachHost", "dispatchEvent", "event", "handleCapturedPhoto", AppbrandHostConstants.Schema_RESERVED_FIELD.PATH, "", "handleCameraOpenFailed", "createMarkAINote", "", "()Ljava/lang/Long;", "contentHeightPx", "", "repoEventsObserved", "", "repoStateObserved", "observeRepoState", "observeRepoEvents", "resolveDisplayDuration", "duration", "formattedDuration", "debugId", "", "Factory", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmAINoteViewModel extends MviViewModel<s, r, MmAINoteUIEvent> {
    private final MmAINoteFragmentArgs args;
    private final MmRecordingAINoteRepo repo;
    private boolean repoEventsObserved;
    private boolean repoStateObserved;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "args", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteFragmentArgs;", "repo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteFragmentArgs;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        public final MmAINoteFragmentArgs a;
        public final MmRecordingAINoteRepo b;

        public final <T extends ViewModel> T create(Class<T> r3) {
            Intrinsics.checkNotNullParameter(r3, "modelClass");
            if (r3.isAssignableFrom(MmAINoteViewModel.class) == false) goto L7;
            return new MmAINoteViewModel(this.a, this.b);
        L7:
            return (T) super.create(r3);
        }

        public Factory(MmAINoteFragmentArgs r2, MmRecordingAINoteRepo r3) {
            Intrinsics.checkNotNullParameter(r2, "args");
            Intrinsics.checkNotNullParameter(r3, "repo");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$dispatchEvent$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$dispatchEvent$2", f = "MmAINoteViewModel.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmAINoteUIEvent $event;
        int label;
        final /* synthetic */ MmAINoteViewModel this$0;

        public AnonymousClass2(MmAINoteViewModel r1, MmAINoteUIEvent r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$event, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MmAINoteViewModel r6 = this.this$0;
            r.h r2 = new r.h(((MmAINoteUIEvent.j) this.$event).c);
            this.label = 1;
            if (r6.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$dispatchEvent$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$dispatchEvent$3", f = "MmAINoteViewModel.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmAINoteViewModel this$0;

        public AnonymousClass3(MmAINoteViewModel r1, Continuation<? super AnonymousClass3> r2) {
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MmAINoteViewModel r6 = this.this$0;
            r.c r2 = new r.c("sdk_show_failed");
            this.label = 1;
            if (r6.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$dispatchEvent$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$dispatchEvent$6", f = "MmAINoteViewModel.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmAINoteViewModel this$0;

        public AnonymousClass6(MmAINoteViewModel r1, Continuation<? super AnonymousClass6> r2) {
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

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MmAINoteViewModel r5 = this.this$0;
            r.e r2 = r.e.a;
            this.label = 1;
            if (r5.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$dispatchEvent$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$dispatchEvent$8", f = "MmAINoteViewModel.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmAINoteViewModel this$0;

        public AnonymousClass8(MmAINoteViewModel r1, Continuation<? super AnonymousClass8> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass8(this.this$0, r3);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MmAINoteViewModel r6 = this.this$0;
            r.c r2 = new r.c("close_click");
            this.label = 1;
            if (r6.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$observeRepoEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepoEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$observeRepoEvents$1", f = "MmAINoteViewModel.kt", i = {}, l = {214, 217, 220, 223, 226, 229}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02211 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmAINoteViewModel this$0;

        public C02211(MmAINoteViewModel r1, Continuation<? super C02211> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02211 r0 = new C02211(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L7;
                case 1: goto L6;
                case 2: goto L6;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r5);
        L45:
            return Unit.INSTANCE;
        L7:
            ResultKt.throwOnFailure(r5);
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j) this.L$0;
            if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j.e) == false) goto L20;
            MmRecordingAINoteHint r7 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j.e) r6).a;
            int r8 = t.a[r7.ordinal()];
            if (r8 == 1) goto L15;
            if (r8 != 2) goto L14;
            final MmAINoteHint r9 = MmAINoteHint.MARK_THROTTLE;
        L16:
            this.this$0.setState(new C00561(r9));
            MmAINoteViewModel r2 = this.this$0;
            r.f r3 = new r.f(r9);
            this.label = 1;
            if (r2.sendVMEvent(r3, this) != r0) goto L45;
            return r0;
        L14:
            throw new NoWhenBranchMatchedException();
        L15:
            r9 = MmAINoteHint.SUBTITLE_MISSING;
            goto L16
        L20:
            if (Intrinsics.areEqual(r6, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j.a.a) == false) goto L25;
            MmAINoteViewModel r10 = this.this$0;
            r.a r1 = r.a.a;
            this.label = 2;
            if (r10.sendVMEvent(r1, this) != r0) goto L45;
            return r0;
        L25:
            if (Intrinsics.areEqual(r6, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j.f.a) == false) goto L30;
            MmAINoteViewModel r11 = this.this$0;
            r.g r4 = r.g.a;
            this.label = 3;
            if (r11.sendVMEvent(r4, this) != r0) goto L45;
            return r0;
        L30:
            if (Intrinsics.areEqual(r6, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j.b.a) == false) goto L35;
            MmAINoteViewModel r12 = this.this$0;
            r.b r13 = r.b.a;
            this.label = 4;
            if (r12.sendVMEvent(r13, this) != r0) goto L45;
            return r0;
        L35:
            if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j.d) == false) goto L40;
            MmAINoteViewModel r14 = this.this$0;
            r.c r15 = new r.c(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j.d) r6).a);
            this.label = 5;
            if (r14.sendVMEvent(r15, this) != r0) goto L45;
            return r0;
        L40:
            if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j.c) == false) goto L47;
            MmAINoteViewModel r16 = this.this$0;
            r.d r17 = new r.d(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.j.c) r6).a);
            this.label = 6;
            if (r16.sendVMEvent(r17, this) != r0) goto L45;
            return r0;
        L47:
            throw new NoWhenBranchMatchedException();
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$observeRepoState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "entity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteEntity;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteViewModel$observeRepoState$1", f = "MmAINoteViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02221 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.c, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmAINoteViewModel this$0;

        public C02221(MmAINoteViewModel r1, Continuation<? super C02221> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02221 r0 = new C02221(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.c r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.c) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.c r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.c) this.L$0;
            this.this$0.setState(new C00571(r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void observeRepoEvents() {
        if (this.repoEventsObserved == false) goto L5;
        return;
    L5:
        this.repoEventsObserved = true;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.repo.e(), new C02211(this, null)), getViewModelScope());
    }

    private final void observeRepoState() {
        if (this.repoStateObserved == false) goto L5;
        return;
    L5:
        this.repoStateObserved = true;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.repo.x().b(), new C02221(this, null)), getViewModelScope());
    }

    public final int contentHeightPx() {
        return this.repo.x().t();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public s defaultState() {
        return new s(this.repo.x().t0(), this.args.getUiLaunchMode(), 991);
    }

    public final void detachHost() {
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteViewModel#detachHost", "state=" + getState(), null, 8);
        this.repo.x().I0();
    }

    public final String formattedDuration() {
        int r0 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a;
        return com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a(getState().a);
    }

    public final void handleCameraOpenFailed() {
        int r0 = bwb.b.a;
        bwb.b.h(MmUiLogScene.AI_NOTE, "MmAINoteViewModel#handleCameraOpenFailed", "camera open failed", null);
        this.repo.x().d();
    }

    public final Long createMarkAINote() {
        long r0 = System.currentTimeMillis();
        Long r2 = this.repo.x().J();
        int r3 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteViewModel#createMarkAINote", "external call noteId=" + r2 + " costMs=" + (System.currentTimeMillis() - r0), null, 8);
        return r2;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l defaultState() {
        return defaultState();
    }

    private final String debugId(Object r3) {
        if (r3 == null) goto L5;
        String r4 = r3.getClass().getSimpleName() + '@' + System.identityHashCode(r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return "null";
    }

    private final long resolveDisplayDuration(long r4) {
        if (r4 <= 0) goto L6;
        return r4;
    L6:
        return getState().a;
    }

    public void dispatchEvent(final MmAINoteUIEvent r19) {
        Intrinsics.checkNotNullParameter(r19, "event");
        int r2 = bwb.b.a;
        MmUiLogScene r3 = MmUiLogScene.AI_NOTE;
        bwb.b.g(r3, "MmAINoteViewModel#dispatchEvent", r19.toString(), null, 8);
        if ((r19 instanceof MmAINoteUIEvent.j) == false) goto L9;
        long r8 = System.currentTimeMillis();
        MmAINoteUIEvent.j r10 = (MmAINoteUIEvent.j) r19;
        this.repo.x().G0(r10.a, r10.b);
        final long r11 = resolveDisplayDuration(r10.a);
        setState(new AnonymousClass1(r11, r19));
        boolean r4 = this.repo.x().H0();
        bwb.b.g(r3, "MmAINoteViewModel#dispatchEvent", "Show ensureLoaded=" + r4 + " costMs=" + (System.currentTimeMillis() - r8) + " duration=" + r10.a + " effectiveDuration=" + r11 + " meetingStartTime=" + r10.b + " expandImmediately=" + r10.c, null, 8);
        if (r4 == false) goto L7;
        this.repo.x().N0();
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass2(this, r19, null), 3, null);
        return;
    L7:
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass3(this, null), 3, null);
        return;
    L9:
        if ((r19 instanceof MmAINoteUIEvent.l) == false) goto L12;
        MmAINoteUIEvent.l r5 = (MmAINoteUIEvent.l) r19;
        this.repo.x().G0(r5.a, r5.b);
        setState(new AnonymousClass4(this, r19));
        return;
    L12:
        if ((r19 instanceof MmAINoteUIEvent.m) == false) goto L15;
        setState(new AnonymousClass5(r19));
        return;
    L15:
        if ((r19 instanceof MmAINoteUIEvent.CreateMarkAINote) == false) goto L18;
        long r9 = System.currentTimeMillis();
        bwb.b.g(r3, "MmAINoteViewModel#createMarkAINote", "click start", null, 8);
        bwb.b.g(r3, "MmAINoteViewModel#createMarkAINote", "click end noteId=" + this.repo.x().J() + " costMs=" + (System.currentTimeMillis() - r9), null, 8);
        return;
    L18:
        if (Intrinsics.areEqual(r19, MmAINoteUIEvent.a.a) == false) goto L23;
        long r12 = System.currentTimeMillis();
        bwb.b.g(r3, "MmAINoteViewModel#cameraClick", "click start", null, 8);
        boolean r6 = this.repo.x().o0();
        bwb.b.g(r3, "MmAINoteViewModel#cameraClick", "prepareOpenCamera=" + r6 + " costMs=" + (System.currentTimeMillis() - r12), null, 8);
        if (r6 == false) goto L57;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass6(this, null), 3, null);
        return;
    L57:
        return;
    L23:
        if ((r19 instanceof MmAINoteUIEvent.d) == false) goto L26;
        this.repo.x().V(((MmAINoteUIEvent.d) r19).a);
        return;
    L26:
        if ((r19 instanceof MmAINoteUIEvent.g) == false) goto L29;
        MmAINoteUIEvent.g r1 = (MmAINoteUIEvent.g) r19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a.C0040a.a(this.repo.x(), Boolean.valueOf(r1.a), null, null, "panel_visibility:" + r1.a, 6);
        return;
    L29:
        if ((r19 instanceof MmAINoteUIEvent.e) == false) goto L32;
        MmAINoteUIEvent.e r7 = (MmAINoteUIEvent.e) r19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a.C0040a.a(this.repo.x(), null, Boolean.valueOf(r7.a), null, "editor_focus:" + r7.a, 5);
        return;
    L32:
        if ((r19 instanceof MmAINoteUIEvent.f) == false) goto L35;
        MmAINoteUIEvent.f r13 = (MmAINoteUIEvent.f) r19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a.C0040a.a(this.repo.x(), null, null, Boolean.valueOf(r13.a), "keyboard_visibility:" + r13.a, 3);
        return;
    L35:
        if (Intrinsics.areEqual(r19, MmAINoteUIEvent.h.a) == false) goto L38;
        this.repo.x().w0(true, "tooltip_close_click");
        return;
    L38:
        if (Intrinsics.areEqual(r19, MmAINoteUIEvent.i.a) == false) goto L41;
        this.repo.x().w0(false, "tooltip_dismiss");
        return;
    L41:
        if (Intrinsics.areEqual(r19, MmAINoteUIEvent.b.a) == false) goto L44;
        setState(AnonymousClass7.INSTANCE);
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass8(this, null), 3, null);
        return;
    L44:
        if (Intrinsics.areEqual(r19, MmAINoteUIEvent.c.a) == false) goto L47;
        setState(AnonymousClass9.INSTANCE);
        return;
    L47:
        if ((r19 instanceof MmAINoteUIEvent.k) == false) goto L51;
        this.repo.x().v0(((MmAINoteUIEvent.k) r19).a);
        return;
    L51:
        throw new NoWhenBranchMatchedException();
    }

    public final void handleCapturedPhoto(String r10) {
        Intrinsics.checkNotNullParameter(r10, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
        long r0 = System.currentTimeMillis();
        int r2 = bwb.b.a;
        MmUiLogScene r3 = MmUiLogScene.AI_NOTE;
        bwb.b.g(r3, "MmAINoteViewModel#handleCapturedPhoto", "start path=" + r10, null, 8);
        this.repo.x().M(r10);
        bwb.b.g(r3, "MmAINoteViewModel#handleCapturedPhoto", "end costMs=" + (System.currentTimeMillis() - r0) + " path=" + r10, null, 8);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ void dispatchEvent(com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j r1) {
        dispatchEvent((MmAINoteUIEvent) r1);
    }

    public MmAINoteViewModel(MmAINoteFragmentArgs r2, MmRecordingAINoteRepo r3) {
        Intrinsics.checkNotNullParameter(r2, "args");
        Intrinsics.checkNotNullParameter(r3, "repo");
        this.args = r2;
        this.repo = r3;
    }

    public static final /* synthetic */ long access$resolveDisplayDuration(MmAINoteViewModel r0, long r1) {
        return r0.resolveDisplayDuration(r1);
    }

    public final void attachHost(ViewGroup r6, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.f r7) {
        Intrinsics.checkNotNullParameter(r6, "container");
        Intrinsics.checkNotNullParameter(r7, "callback");
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteViewModel#attachHost", "container=" + debugId(r6) + " callback=" + debugId(r7), null, 8);
        this.repo.x().O0(r6, r7);
        observeRepoState();
        observeRepoEvents();
    }
}
