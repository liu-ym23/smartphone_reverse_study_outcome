package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.p;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.q;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001ZB\u0017\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010'J&\u0010)\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00072\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020 H\u0082@¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0012H\u0002J\b\u0010/\u001a\u00020\u001aH\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0012H\u0002J\u0016\u00102\u001a\u0002032\u0006\u00101\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\u0002H\u0016J\u0010\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u0004H\u0016J\u0010\u00108\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001a\u00109\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0012H\u0002J\f\u0010;\u001a\u00020\u0012*\u00020\u0002H\u0002J\f\u0010<\u001a\u00020\u0012*\u00020 H\u0002J\u001c\u0010=\u001a\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u00020 0>2\u0006\u0010?\u001a\u00020\u000bH\u0002J\u001e\u0010@\u001a\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u00020 0>2\b\u0010A\u001a\u0004\u0018\u00010 H\u0002J\u0016\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020DH\u0082@¢\u0006\u0002\u0010EJ\u0018\u0010F\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0002H\u0002J\u0018\u0010H\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u000bH\u0002J\u001a\u0010J\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010&\u001a\u00020\u0007H\u0002J\f\u0010M\u001a\u00020N*\u00020\u0002H\u0002J\u0014\u0010O\u001a\u00020\u0012*\u00020\u00022\u0006\u0010P\u001a\u00020\u0012H\u0002J\f\u0010Q\u001a\u00020R*\u00020 H\u0002J\u000e\u0010S\u001a\u0004\u0018\u00010 *\u00020RH\u0002J&\u0010T\u001a\b\u0012\u0004\u0012\u00020 0>*\b\u0012\u0004\u0012\u00020 0>2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020 0>H\u0002J2\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010 2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020 0>2\b\u0010Y\u001a\u0004\u0018\u00010\u000bH\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationViewModel;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviViewModel;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationUIEvent;", "sessionProvider", "Lkotlin/Function0;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/MmRecordingSession;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "observedSession", "hasRequestedCloseForEndState", "", "hasTrackedStartView", "hasTrackedEndView", "hasLoadedLanguageSnapshot", "languageSettingInFlight", "pendingLanguageSelection", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageSelectionBuffer;", "bindSession", "", "onPauseResumeClick", "onStopClick", "onLanguageClick", "onSetSpokenLanguage", "language", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;", "onSetTargetLanguage", "onSetLanguage", "side", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageSide;", "setSpokenLanguage", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/MmRecordingSession;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchTargetLanguage", "switchFromBidirectionalLanguage", "spokenLanguage", "targetLanguage", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/MmRecordingSession;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSetBilingual", "enabled", "onSpeakerClick", "onSetSaveArtifactType", "saveArtifactType", "syncSaveArtifactStatus", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationSaveArtifactSyncResult;", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultState", "dispatchEvent", "event", "observeSession", "refreshLanguageState", "languageSettingSyncing", "isBidirectionalActive", "isBidirectional", "findByType", "", "languageType", "resolveNormalLanguage", "selected", "closePageIfSessionEnded", "newState", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/statemachine/MmRecordingSessionState;", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/statemachine/MmRecordingSessionState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackStartViewIfReady", "state", "loadSaveArtifactState", "recordingId", "trackLanguageIconClick", "getStandaloneAIInterpretationTracker", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/MmStandaloneAIInterpretationTracker;", "toTrackState", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/MmStandaloneAIInterpretationTrackState;", "isStartViewSnapshotReady", "languageSnapshotLoaded", "toSubtitleLanguage", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;", "toStandaloneLanguage", "mergeByStableOrder", "previous", "shouldShowHeaderLanguageLoading", "currentHeaderLanguageLoading", "supportTargetLanguages", "errorMessage", "Factory", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmStandaloneAIInterpretationViewModel extends MviViewModel<g, f, e> {
    private boolean hasLoadedLanguageSnapshot;
    private boolean hasRequestedCloseForEndState;
    private boolean hasTrackedEndView;
    private boolean hasTrackedStartView;
    private boolean languageSettingInFlight;
    private final Lazy logDetail$delegate;
    private MmRecordingSession observedSession;
    private final c pendingLanguageSelection;
    private final Function0<MmRecordingSession> sessionProvider;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "sessionProvider", "Lkotlin/Function0;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/MmRecordingSession;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        public final Function0<MmRecordingSession> a;

        public Factory(Function0<MmRecordingSession> r2) {
            Intrinsics.checkNotNullParameter(r2, "sessionProvider");
            this.a = r2;
        }

        public final <T extends ViewModel> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "modelClass");
            if (r2.isAssignableFrom(MmStandaloneAIInterpretationViewModel.class) == false) goto L7;
            return new MmStandaloneAIInterpretationViewModel(this.a);
        L7:
            return (T) super.create(r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmStandaloneAIInterpretationLanguageSide.values().length];
            r0[MmStandaloneAIInterpretationLanguageSide.SPOKEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmStandaloneAIInterpretationLanguageSide.TARGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$closePageIfSessionEnded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {792, 795}, m = "closePageIfSessionEnded", n = {}, s = {})
    public static final class C02921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C02921(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C02921> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MmStandaloneAIInterpretationViewModel.access$closePageIfSessionEnded(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$dispatchEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$dispatchEvent$1", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {551}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C02931(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C02931> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02931(this.this$0, r3);
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
            MmStandaloneAIInterpretationViewModel r5 = this.this$0;
            f.a r2 = f.a.a;
            this.label = 1;
            if (r5.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "duration", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$1", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02941 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C02941(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C02941> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02941 r0 = new C02941(this.this$0, r4);
            r0.J$0 = ((Number) r3).longValue();
            return r0;
        }

        public final Object invoke(long r1, Continuation<? super Unit> r3) {
            return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
            return invoke(((Number) r3).longValue(), (Continuation) r4);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            final long r0 = this.J$0;
            this.this$0.setState(new C00691(r0));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "volume", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$2", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02952 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C02952(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C02952> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02952 r0 = new C02952(this.this$0, r4);
            r0.I$0 = ((Number) r3).intValue();
            return r0;
        }

        public final Object invoke(int r1, Continuation<? super Unit> r2) {
            return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Number) r1).intValue(), (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            final int r4 = this.I$0;
            this.this$0.setState(new AnonymousClass1(r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lkotlin/Pair;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/statemachine/MmRecordingSessionState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$3", f = "MmStandaloneAIInterpretationViewModel.kt", i = {0}, l = {590}, m = "invokeSuspend", n = {"newState"}, s = {"L$0"})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<Pair<? extends com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c, ? extends com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public AnonymousClass3(MmStandaloneAIInterpretationViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Pair) r1, (Continuation) r2);
        }

        public final Object invoke(Pair<? extends com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c, ? extends com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            final com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r2 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) this.L$0;
            ResultKt.throwOnFailure(r7);
        L13:
            if (((Boolean) r7).booleanValue() == true) goto L15;
            this.this$0.setState(new AnonymousClass1(r2));
            return Unit.INSTANCE;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            Pair r8 = (Pair) this.L$0;
            com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r3 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r8.getSecond();
            int r4 = bwb.b.a;
            bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "observeSessionState", r8.getFirst() + " -> " + r3 + ", clearLoading=true", MmStandaloneAIInterpretationViewModel.access$getLogDetail(this.this$0));
            MmStandaloneAIInterpretationViewModel r9 = this.this$0;
            this.L$0 = r3;
            this.label = 1;
            r7 = MmStandaloneAIInterpretationViewModel.access$closePageIfSessionEnded(r9, r3, this);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r3;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmCreateAudioResponse;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$4", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<Result<? extends MmCreateAudioResponse>, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSession $session;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public AnonymousClass4(MmStandaloneAIInterpretationViewModel r1, MmRecordingSession r2, Continuation<? super AnonymousClass4> r3) {
            this.this$0 = r1;
            this.$session = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass4 r0 = new AnonymousClass4(this.this$0, this.$session, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Result) r1, (Continuation) r2);
        }

        public final Object invoke(Result<MmCreateAudioResponse> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r7);
            Result r8 = (Result) this.L$0;
            if (MmStandaloneAIInterpretationViewModel.access$getObservedSession$p(this.this$0) != this.$session) goto L7;
            Boolean r0 = null;
            if (r8 == null) goto L16;
            Object r1 = r8.unbox-impl();
            if (Result.isFailure-impl(r1) == false) goto L13;
            r1 = null;
        L13:
            MmCreateAudioResponse r2 = (MmCreateAudioResponse) r1;
            if (r2 == null) goto L16;
            String r3 = r2.getRecordingId();
        L17:
            if (r3 != null) goto L19;
            r3 = "";
        L19:
            boolean r4 = true;
            if ((!StringsKt.isBlank(r3)) == true) goto L30;
            int r5 = bwb.b.a;
            MmUiLogScene r6 = MmUiLogScene.StandaloneAIInterpretation;
            StringBuilder r9 = new StringBuilder("skip, ready=false, hasResult=");
            if (r8 != null) goto L25;
            r4 = false;
        L25:
            r9.append(r4);
            r9.append(", success=");
            if (r8 == null) goto L28;
            r0 = Boxing.boxBoolean(Result.isSuccess-impl(r8.unbox-impl()));
        L28:
            r9.append(r0);
            bwb.b.f(r6, "observeRecordingIdReady", r9.toString(), MmStandaloneAIInterpretationViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L30:
            int r10 = bwb.b.a;
            bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "observeRecordingIdReady", "ready=true, recordingId=" + lvb.a.d(r3), MmStandaloneAIInterpretationViewModel.access$getLogDetail(this.this$0));
            final boolean r11 = MmStandaloneAIInterpretationViewModel.access$loadSaveArtifactState(this.this$0, this.$session, r3);
            this.this$0.setState(new AnonymousClass1(r11));
            return Unit.INSTANCE;
        L16:
            r3 = null;
            goto L17
        L7:
            return Unit.INSTANCE;
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "entity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationEntity;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$5", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {644}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSession $session;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public AnonymousClass5(MmStandaloneAIInterpretationViewModel r1, MmRecordingSession r2, Continuation<? super AnonymousClass5> r3) {
            this.this$0 = r1;
            this.$session = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass5 r0 = new AnonymousClass5(this.this$0, this.$session, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            MmRecordingSession r2 = (MmRecordingSession) this.L$1;
            MmStandaloneAIInterpretationViewModel r3 = (MmStandaloneAIInterpretationViewModel) this.L$0;
            ResultKt.throwOnFailure(r7);
        L19:
            MmStandaloneAIInterpretationViewModel.access$trackStartViewIfReady(r3, r2, (g) r7);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b) this.L$0;
            int r4 = bwb.b.a;
            MmUiLogScene r5 = MmUiLogScene.StandaloneAIInterpretation;
            StringBuilder r6 = new StringBuilder("enabled=");
            r6.append(r8.a);
            r6.append(", selected=");
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r9 = r8.g;
            if (r9 == null) goto L11;
            String r10 = r9.a;
        L12:
            r6.append(r10);
            r6.append(", spokenSize=");
            r6.append(r8.b.size());
            r6.append(", targetSize=");
            r6.append(r8.c.size());
            r6.append(", spokenToTargetKeys=");
            r6.append(r8.d.size());
            r6.append(", targetToSpokenKeys=");
            r6.append(r8.e.size());
            bwb.b.f(r5, "observeStandaloneEntity", r6.toString(), MmStandaloneAIInterpretationViewModel.access$getLogDetail(this.this$0));
            if (MmStandaloneAIInterpretationViewModel.access$getLanguageSettingInFlight$p(this.this$0) == true) goto L15;
            MmStandaloneAIInterpretationViewModel.refreshLanguageState$default(this.this$0, this.$session, false, 2, null);
        L15:
            r3 = this.this$0;
            MmRecordingSession r11 = this.$session;
            this.L$0 = r3;
            this.L$1 = r11;
            this.label = 1;
            Object r12 = r3.awaitState(this);
            if (r12 != r0) goto L18;
            return r0;
        L18:
            r2 = r11;
            r7 = r12;
            goto L19
        L11:
            r10 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmRecordingLanguageEntity;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$observeSession$6", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {657}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSession $session;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public AnonymousClass6(MmStandaloneAIInterpretationViewModel r1, MmRecordingSession r2, Continuation<? super AnonymousClass6> r3) {
            this.this$0 = r1;
            this.$session = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass6(this.this$0, this.$session, r4);
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            MmRecordingSession r2 = (MmRecordingSession) this.L$1;
            MmStandaloneAIInterpretationViewModel r3 = (MmStandaloneAIInterpretationViewModel) this.L$0;
            ResultKt.throwOnFailure(r7);
        L15:
            MmStandaloneAIInterpretationViewModel.access$trackStartViewIfReady(r3, r2, (g) r7);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            MmStandaloneAIInterpretationViewModel.access$setHasLoadedLanguageSnapshot$p(this.this$0, true);
            if (MmStandaloneAIInterpretationViewModel.access$getLanguageSettingInFlight$p(this.this$0) == true) goto L11;
            MmStandaloneAIInterpretationViewModel.refreshLanguageState$default(this.this$0, this.$session, false, 2, null);
        L11:
            r3 = this.this$0;
            MmRecordingSession r8 = this.$session;
            this.L$0 = r3;
            this.L$1 = r8;
            this.label = 1;
            Object r4 = r3.awaitState(this);
            if (r4 != r0) goto L14;
            return r0;
        L14:
            r2 = r8;
            r7 = r4;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onLanguageClick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onLanguageClick$1", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C02961(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C02961> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02961(this.this$0, r3);
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
            MmStandaloneAIInterpretationViewModel r5 = this.this$0;
            f.b r2 = f.b.a;
            this.label = 1;
            if (r5.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onSetLanguage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onSetLanguage$1", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C02981(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C02981> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02981(this.this$0, r3);
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
            MmStandaloneAIInterpretationViewModel r5 = this.this$0;
            f.c r2 = f.c.a;
            this.label = 1;
            if (r5.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onSetLanguage$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onSetLanguage$3", f = "MmStandaloneAIInterpretationViewModel.kt", i = {5}, l = {293, 298, 300, 311, 314, 337, 351}, m = "invokeSuspend", n = {"accepted"}, s = {"Z$0"})
    public static final class C03003 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c $bidirectionalTarget;
        final /* synthetic */ Pair<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> $fallbackPair;
        final /* synthetic */ boolean $optimistic;
        final /* synthetic */ g $previousState;
        final /* synthetic */ boolean $requiresLanguagePair;
        final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c $selectedOption;
        final /* synthetic */ MmRecordingSession $session;
        final /* synthetic */ MmStandaloneAIInterpretationLanguageSide $side;
        final /* synthetic */ g $state;
        private /* synthetic */ Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C03003(MmStandaloneAIInterpretationLanguageSide r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2, MmStandaloneAIInterpretationViewModel r3, MmRecordingSession r4, boolean r5, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r6, boolean r7, Pair<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r8, g r9, g r10, Continuation<? super C03003> r11) {
            this.$side = r1;
            this.$selectedOption = r2;
            this.this$0 = r3;
            this.$session = r4;
            this.$optimistic = r5;
            this.$bidirectionalTarget = r6;
            this.$requiresLanguagePair = r7;
            this.$fallbackPair = r8;
            this.$state = r9;
            this.$previousState = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
            C03003 r12 = new C03003(this.$side, this.$selectedOption, this.this$0, this.$session, this.$optimistic, this.$bidirectionalTarget, this.$requiresLanguagePair, this.$fallbackPair, this.$state, this.$previousState, r15);
            r12.L$0 = r14;
            return r12;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L16;
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r14);
        L90:
            if (MmStandaloneAIInterpretationViewModel.access$getObservedSession$p(this.this$0) != this.$session) goto L95;
            MmStandaloneAIInterpretationViewModel.access$setLanguageSettingInFlight$p(this.this$0, false);
            c r15 = MmStandaloneAIInterpretationViewModel.access$getPendingLanguageSelection$p(this.this$0);
            Pair<? extends MmStandaloneAIInterpretationLanguageSide, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r1 = r15.a;
            r15.a = null;
            if (r1 == null) goto L95;
            MmStandaloneAIInterpretationViewModel r16 = this.this$0;
            MmStandaloneAIInterpretationLanguageSide r2 = (MmStandaloneAIInterpretationLanguageSide) r1.component1();
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r3 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r1.component2();
            int r4 = bwb.b.a;
            bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "onSetLanguage", "replay latest, side=" + r2 + ", target=" + r3.a, MmStandaloneAIInterpretationViewModel.access$getLogDetail(r16));
            MmStandaloneAIInterpretationViewModel.access$onSetLanguage(r16, r2, r3);
        L95:
            return Unit.INSTANCE;
        L7:
            boolean r5 = this.Z$0;
            ResultKt.throwOnFailure(r14);
        L77:
            MmRecordingSession r17 = MmStandaloneAIInterpretationViewModel.access$getObservedSession$p(this.this$0);
            MmRecordingSession r6 = this.$session;
            if (r17 == r6) goto L82;
            return Unit.INSTANCE;
        L82:
            if (this.$optimistic == false) goto L85;
            if (r5 == true) goto L85;
            MmStandaloneAIInterpretationViewModel r18 = this.this$0;
            final g r7 = this.$previousState;
            r18.setState(new AnonymousClass1(r7));
        L86:
            MmStandaloneAIInterpretationViewModel r19 = this.this$0;
            this.label = 7;
            if (r19.awaitState(this) != r0) goto L90;
            return r0;
        L85:
            MmStandaloneAIInterpretationViewModel.access$refreshLanguageState(this.this$0, r6, false);
            goto L86
        L8:
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        L46:
            boolean r110 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L14
        L47:
            Object r111 = Result.constructor-impl(Boxing.boxBoolean(r110));     // Catch: Throwable -> L14
        L50:
            MmStandaloneAIInterpretationLanguageSide r8 = this.$side;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r9 = this.$selectedOption;
            MmStandaloneAIInterpretationViewModel r10 = this.this$0;
            Throwable r11 = Result.exceptionOrNull-impl(r111);
            if (r11 != null) goto L53;
        L56:
            Boolean r12 = Boxing.boxBoolean(false);
            if (Result.isFailure-impl(r111) == false) goto L59;
            r111 = r12;
        L59:
            r5 = ((Boolean) r111).booleanValue();
            int r112 = bwb.b.a;
            bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "onSetLanguage", "finish, side=" + this.$side + ", target=" + this.$selectedOption.a + ", accepted=" + r5, MmStandaloneAIInterpretationViewModel.access$getLogDetail(this.this$0));
            MmRecordingSession r113 = MmStandaloneAIInterpretationViewModel.access$getObservedSession$p(this.this$0);
            MmRecordingSession r13 = this.$session;
            if (r113 != r13) goto L95;
            if (r5 == true) goto L77;
            MmStandaloneAIInterpretationRootRepo r114 = r13.h();
            if (r114 == null) goto L71;
            MmStandaloneAIInterpretationRepo r115 = r114.a();
            if (r115 == null) goto L71;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r116 = r115.t();
            if (r116 == null) goto L71;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b r117 = r116.m();
            if (r117 == null) goto L71;
            String r118 = r117.j;
        L73:
            if (Intrinsics.areEqual(r118, "rollback_failed") == false) goto L77;
            MmStandaloneAIInterpretationViewModel r119 = this.this$0;
            f.c r20 = f.c.a;
            this.Z$0 = r5;
            this.label = 6;
            if (r119.sendVMEvent(r20, this) != r0) goto L77;
            return r0;
        L71:
            r118 = null;
            goto L73
        L53:
            if ((r11 instanceof CancellationException) == true) goto L55;
            int r21 = bwb.b.a;
            bwb.b.d(MmUiLogScene.StandaloneAIInterpretation, "onSetLanguage", "failed, side=" + r8 + ", target=" + r9.a + ", error=" + r11, MmStandaloneAIInterpretationViewModel.access$getLogDetail(r10));
            goto L56
        L55:
            throw r11;
        L9:
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        L42:
            r110 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L14
            goto L47
        L10:
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        L35:
            r110 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L14
            goto L47
        L11:
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        L31:
            r110 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L14
            goto L47
        L12:
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        L23:
            r110 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L14
            goto L47
        L16:
            ResultKt.throwOnFailure(r14);
            CoroutineScope r120 = (CoroutineScope) this.L$0;
            MmStandaloneAIInterpretationViewModel r22 = this.this$0;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r121 = this.$selectedOption;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r23 = this.$bidirectionalTarget;
            boolean r24 = this.$requiresLanguagePair;
            Pair<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r25 = this.$fallbackPair;
            MmStandaloneAIInterpretationLanguageSide r26 = this.$side;
            MmRecordingSession r122 = this.$session;
            g r123 = this.$state;
            Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L14
            if (MmStandaloneAIInterpretationViewModel.access$isBidirectional(r22, r121) == false) goto L24;
            if (r23 == null) goto L36;
            this.label = 1;     // Catch: Throwable -> L14
            r14 = MmStandaloneAIInterpretationViewModel.access$switchTargetLanguage(r22, r122, r23, this);     // Catch: Throwable -> L14
            if (r14 != r0) goto L23;
            return r0;
        L36:
            r110 = false;
            goto L47
        L24:
            if (r24 == false) goto L38;
            if (r25 == null) goto L36;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r125 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r25.component1();     // Catch: Throwable -> L14
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r27 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r25.component2();     // Catch: Throwable -> L14
            if (MmStandaloneAIInterpretationViewModel.access$isBidirectionalActive(r22, r123) == false) goto L32;
            this.label = 2;     // Catch: Throwable -> L14
            r14 = MmStandaloneAIInterpretationViewModel.access$switchFromBidirectionalLanguage(r22, r122, r125, r27, this);     // Catch: Throwable -> L14
            if (r14 != r0) goto L31;
            return r0;
        L32:
            MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1 r28 = new MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1(r22, r122, r27, r125, null);     // Catch: Throwable -> L14
            this.label = 3;     // Catch: Throwable -> L14
            r14 = CoroutineScopeKt.coroutineScope(r28, this);     // Catch: Throwable -> L14
            if (r14 != r0) goto L35;
            return r0;
        L38:
            if (r26 != MmStandaloneAIInterpretationLanguageSide.SPOKEN) goto L43;
            this.label = 4;     // Catch: Throwable -> L14
            r14 = MmStandaloneAIInterpretationViewModel.access$setSpokenLanguage(r22, r122, r121, this);     // Catch: Throwable -> L14
            if (r14 != r0) goto L42;
            return r0;
        L43:
            this.label = 5;     // Catch: Throwable -> L14
            r14 = MmStandaloneAIInterpretationViewModel.access$switchTargetLanguage(r22, r122, r121, this);     // Catch: Throwable -> L14
            if (r14 != r0) goto L46;
            return r0;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            th = move-exception;
            Result.Companion r29 = Result.Companion;
            r111 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L50
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onSetSaveArtifactType$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onSetSaveArtifactType$3", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {496, 520}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03023 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $previousSaveArtifactType;
        final /* synthetic */ boolean $saveArtifactType;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C03023(MmStandaloneAIInterpretationViewModel r1, boolean r2, boolean r3, Continuation<? super C03023> r4) {
            this.this$0 = r1;
            this.$saveArtifactType = r2;
            this.$previousSaveArtifactType = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03023(this.this$0, this.$saveArtifactType, this.$previousSaveArtifactType, r5);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L22:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L13:
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.f r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.f) r7;
            if (r8.a == false) goto L16;
            int r9 = bwb.b.a;
            bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "onSetSaveArtifactType", "success, target=" + this.$saveArtifactType, MmStandaloneAIInterpretationViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(AnonymousClass1.INSTANCE);
            goto L22
        L16:
            int r2 = bwb.b.a;
            bwb.b.d(MmUiLogScene.StandaloneAIInterpretation, "onSetSaveArtifactType", "failed, rollback=" + this.$previousSaveArtifactType + ", target=" + this.$saveArtifactType + ", suppressLocalFallback=" + r8.b, MmStandaloneAIInterpretationViewModel.access$getLogDetail(this.this$0));
            MmStandaloneAIInterpretationViewModel r3 = this.this$0;
            final boolean r4 = this.$previousSaveArtifactType;
            r3.setState(new AnonymousClass2(r4));
            if (r8.b == true) goto L22;
            MmStandaloneAIInterpretationViewModel r10 = this.this$0;
            f.c r5 = f.c.a;
            this.label = 2;
            if (r10.sendVMEvent(r5, this) != r0) goto L22;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            MmStandaloneAIInterpretationViewModel r11 = this.this$0;
            boolean r6 = this.$saveArtifactType;
            this.label = 1;
            r7 = MmStandaloneAIInterpretationViewModel.access$syncSaveArtifactStatus(r11, r6, this);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onSpeakerClick$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onSpeakerClick$3", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {462, 463}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03043 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $muted;
        final /* synthetic */ MmRecordingSession $session;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C03043(MmRecordingSession r1, boolean r2, MmStandaloneAIInterpretationViewModel r3, Continuation<? super C03043> r4) {
            this.$session = r1;
            this.$muted = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03043(this.$session, this.$muted, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L25:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L21:
            MmStandaloneAIInterpretationViewModel r7 = this.this$0;
            f.d r2 = new f.d(true ^ this.$muted);
            this.label = 2;
            if (r7.sendVMEvent(r2, this) != r0) goto L25;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            MmRecordingSession r8 = this.$session;
            if (r8 == null) goto L21;
            MmStandaloneAIInterpretationRootRepo r9 = r8.h();
            if (r9 == null) goto L21;
            MmStandaloneAIInterpretationRepo r10 = r9.a();
            if (r10 == null) goto L21;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r11 = r10.t();
            if (r11 == null) goto L21;
            boolean r3 = this.$muted;
            this.label = 1;
            if (r11.p0(r3, this) != r0) goto L21;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$setSpokenLanguage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel", f = "MmStandaloneAIInterpretationViewModel.kt", i = {0}, l = {376}, m = "setSpokenLanguage", n = {"language"}, s = {"L$0"})
    public static final class C03061 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C03061(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C03061> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MmStandaloneAIInterpretationViewModel.access$setSpokenLanguage(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$switchFromBidirectionalLanguage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {437}, m = "switchFromBidirectionalLanguage", n = {}, s = {})
    public static final class C03071 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C03071(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C03071> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MmStandaloneAIInterpretationViewModel.access$switchFromBidirectionalLanguage(this.this$0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$switchTargetLanguage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel", f = "MmStandaloneAIInterpretationViewModel.kt", i = {0}, l = {406}, m = "switchTargetLanguage", n = {"language"}, s = {"L$0"})
    public static final class C03081 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C03081(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C03081> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MmStandaloneAIInterpretationViewModel.access$switchTargetLanguage(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$syncSaveArtifactStatus$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel", f = "MmStandaloneAIInterpretationViewModel.kt", i = {}, l = {535}, m = "syncSaveArtifactStatus", n = {}, s = {})
    public static final class C03091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

        public C03091(MmStandaloneAIInterpretationViewModel r1, Continuation<? super C03091> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MmStandaloneAIInterpretationViewModel.access$syncSaveArtifactStatus(this.this$0, false, this);
        }
    }

    private final void bindSession() {
        MmRecordingSession r0 = (MmRecordingSession) this.sessionProvider.invoke();
        if (r0 != null) goto L7;
        int r1 = bwb.b.a;
        bwb.b.d(MmUiLogScene.StandaloneAIInterpretation, "bindSession", "session not found", getLogDetail());
        return;
    L7:
        if (this.observedSession != r0) goto L9;
        return;
    L9:
        this.observedSession = r0;
        this.hasRequestedCloseForEndState = false;
        this.hasTrackedStartView = false;
        this.hasTrackedEndView = false;
        this.hasLoadedLanguageSnapshot = false;
        this.languageSettingInFlight = false;
        MmRecordingSource r3 = null;
        this.pendingLanguageSelection.a = null;
        MmRecordingAudioService r2 = r0.a();
        if (r2 == null) goto L12;
        final boolean r4 = r2.s;
    L13:
        setState(new AnonymousClass1(r4));
        int r5 = bwb.b.a;
        MmUiLogScene r6 = MmUiLogScene.StandaloneAIInterpretation;
        StringBuilder r7 = new StringBuilder("recordingId=");
        r7.append(lvb.a.d(r0.e()));
        r7.append(", source=");
        k r8 = r0.f;
        if (r8 == null) goto L16;
        r3 = r8.a;
    L16:
        r7.append(r3);
        r7.append(", playbackMuted=");
        r7.append(r4);
        bwb.b.f(r6, "bindSession", r7.toString(), getLogDetail());
        observeSession(r0);
        return;
    L12:
        r4 = true;
        goto L13
    }

    private final String getLogDetail() {
        return (String) this.logDetail$delegate.getValue();
    }

    private final void onLanguageClick() {
        trackLanguageIconClick((MmRecordingSession) this.sessionProvider.invoke(), getState().k);
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02961(this, null), 3, null);
    }

    private final void onPauseResumeClick() {
        MmRecordingSession r0 = (MmRecordingSession) this.sessionProvider.invoke();
        if (r0 != null) goto L7;
        int r1 = bwb.b.a;
        bwb.b.h(MmUiLogScene.StandaloneAIInterpretation, "onPauseResumeClick", "skip, session not found", getLogDetail());
        return;
    L7:
        if (getState().c != MMRecordingState.PAUSED) goto L9;
        boolean r2 = true;
    L10:
        int r3 = bwb.b.a;
        MmUiLogScene r4 = MmUiLogScene.StandaloneAIInterpretation;
        StringBuilder r5 = new StringBuilder("recordingId=");
        r5.append(lvb.a.d(r0.e()));
        r5.append(", state=");
        r5.append(getState().c);
        r5.append(", event=");
        if (r2 == false) goto L13;
        String r6 = "RecordingResumeEvent";
    L14:
        r5.append(r6);
        bwb.b.f(r4, "onPauseResumeClick", r5.toString(), getLogDetail());
        if (r2 == false) goto L17;
        getStandaloneAIInterpretationTracker(r0).b(r0, "continue_record");
    L18:
        if (r2 == false) goto L20;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a r7 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.i.a;
    L21:
        r0.u(r7);
        return;
    L20:
        r7 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.h.a;
        goto L21
    L17:
        getStandaloneAIInterpretationTracker(r0).b(r0, "pause_record");
        goto L18
    L13:
        r6 = "RecordingPauseEvent";
        goto L14
    L9:
        r2 = false;
        goto L10
    }

    private final void onSpeakerClick() {
        MmRecordingSession r0 = (MmRecordingSession) this.sessionProvider.invoke();
        final boolean r1 = !getState().n;
        if (r0 == null) goto L9;
        q r2 = getStandaloneAIInterpretationTracker(r0);
        boolean r3 = !r1;
        r2.getClass();
        if (r3 == false) goto L7;
        String r4 = "ai_si_voice_on";
    L8:
        r2.b(r0, r4);
        goto L9
    L7:
        r4 = "ai_si_voice_off";
    L9:
        if (r0 == null) goto L13;
        MmRecordingAudioService r5 = r0.a();
        if (r5 == null) goto L13;
        lvb.a.e(r5.e, "[setPlaybackDigitalMute] mute=" + r1);
        r5.s = r1;
        r5.x.m(r1);
    L13:
        setState(new C03032(r1));
        BuildersKt.launch$default(getViewModelScope(), null, null, new C03043(r0, r1, this, null), 3, null);
    }

    private final void onStopClick() {
        MmRecordingSession r0 = (MmRecordingSession) this.sessionProvider.invoke();
        if (r0 != null) goto L6;
        int r1 = bwb.b.a;
        bwb.b.h(MmUiLogScene.StandaloneAIInterpretation, "onStopClick", "skip, session not found", getLogDetail());
        return;
    L6:
        int r2 = bwb.b.a;
        bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "onStopClick", "recordingId=" + lvb.a.d(r0.e()) + ", state=" + getState().c + ", event=RecordingStopEvent", getLogDetail());
        getStandaloneAIInterpretationTracker(r0).b(r0, "stop_record");
        ((tvb.a) r0.b.N().g.getValue()).b(r0.e());
        r0.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(EndRecordingReason.RECORDING_PAGE_CLICK_STOP));
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public g defaultState() {
        return new g(0);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ l defaultState() {
        return defaultState();
    }

    public MmStandaloneAIInterpretationViewModel(Function0<MmRecordingSession> r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionProvider");
        this.sessionProvider = r2;
        this.logDetail$delegate = LazyKt.lazy(new MmStandaloneAIInterpretationViewModel$logDetail$2(this));
        this.pendingLanguageSelection = new c();
    }

    public static final /* synthetic */ boolean access$getLanguageSettingInFlight$p(MmStandaloneAIInterpretationViewModel r0) {
        return r0.languageSettingInFlight;
    }

    public static final /* synthetic */ String access$getLogDetail(MmStandaloneAIInterpretationViewModel r0) {
        return r0.getLogDetail();
    }

    public static final /* synthetic */ MmRecordingSession access$getObservedSession$p(MmStandaloneAIInterpretationViewModel r0) {
        return r0.observedSession;
    }

    public static final /* synthetic */ c access$getPendingLanguageSelection$p(MmStandaloneAIInterpretationViewModel r0) {
        return r0.pendingLanguageSelection;
    }

    private final q getStandaloneAIInterpretationTracker(MmRecordingSession r1) {
        return (q) r1.b.N().m.getValue();
    }

    private final boolean isBidirectional(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r1) {
        return b.a(r1.a);
    }

    private final boolean isBidirectionalActive(g r3) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r4 = r3.g;
        if (r4 != null) goto L5;
        return false;
    L5:
        if (isBidirectional(r4) != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final void observeSession(MmRecordingSession r5) {
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r5.p, new C02941(this, null)), getViewModelScope());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r5.o, new C02952(this, null)), getViewModelScope());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r5.t, new AnonymousClass3(this, null)), getViewModelScope());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r5.i().p, new AnonymousClass4(this, r5, null)), getViewModelScope());
        MmStandaloneAIInterpretationRootRepo r0 = r5.h();
        if (r0 == null) goto L11;
        MmStandaloneAIInterpretationRepo r1 = r0.a();
        if (r1 == null) goto L11;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r2 = r1.t();
        if (r2 == null) goto L11;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b> r3 = r2.b();
        if (r3 == null) goto L11;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r3, new AnonymousClass5(this, r5, null)), getViewModelScope());
    L11:
        MmStandaloneAIInterpretationRootRepo r4 = r5.h();
        if (r4 == null) goto L21;
        MmRecordingLanguageRepo r6 = r4.l();
        if (r6 == null) goto L22;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r7 = r6.l();
        if (r7 == null) goto L23;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f> r8 = r7.b();
        if (r8 == null) goto L24;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r8, new AnonymousClass6(this, r5, null)), getViewModelScope());
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    private final void onSetBilingual(final boolean r4) {
        MmRecordingSession r0 = (MmRecordingSession) this.sessionProvider.invoke();
        if (r0 != null) goto L6;
        return;
    L6:
        if (getState().l != r4) goto L8;
        return;
    L8:
        q r1 = getStandaloneAIInterpretationTracker(r0);
        r1.getClass();
        if (r4 == false) goto L11;
        String r2 = "show_translation_both_on";
    L12:
        r1.b(r0, r2);
        setState(new C02971(r4));
        MmStandaloneAIInterpretationRootRepo r3 = r0.h();
        if (r3 == null) goto L20;
        MmRecordingLanguageRepo r5 = r3.l();
        if (r5 == null) goto L21;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r6 = r5.l();
        if (r6 == null) goto L22;
        r6.Y(r4);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r2 = "show_translation_both_off";
        goto L12
    }

    private final void onSetSaveArtifactType(final boolean r9) {
        g r0 = getState();
        if (r0.p == true) goto L5;
    L18:
        int r1 = bwb.b.a;
        bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "onSetSaveArtifactType", "skip, current=" + r0.o + ", target=" + r9 + ", ready=" + r0.p + ", syncing=" + r0.q, getLogDetail());
        return;
    L5:
        if (r0.q == true) goto L18;
        boolean r2 = r0.o;
        if (r2 == r9) goto L18;
        int r3 = bwb.b.a;
        bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "onSetSaveArtifactType", "start, previous=" + r2 + ", target=" + r9, getLogDetail());
        MmRecordingSession r4 = (MmRecordingSession) this.sessionProvider.invoke();
        if (r4 == null) goto L16;
        q r5 = getStandaloneAIInterpretationTracker(r4);
        r5.getClass();
        if (r9 == false) goto L14;
        String r6 = "save_notes_on";
    L15:
        r5.b(r4, r6);
        goto L16
    L14:
        r6 = "save_notes_off";
    L16:
        setState(new C03012(r9));
        BuildersKt.launch$default(getViewModelScope(), null, null, new C03023(this, r9, r2, null), 3, null);
    }

    private final void onSetSpokenLanguage(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2) {
        onSetLanguage(MmStandaloneAIInterpretationLanguageSide.SPOKEN, r2);
    }

    private final void onSetTargetLanguage(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2) {
        onSetLanguage(MmStandaloneAIInterpretationLanguageSide.TARGET, r2);
    }

    private final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c toStandaloneLanguage(h r4) {
        String r0 = r4.a;
        String r2 = null;
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        String r5 = r4.b;
        if ((!StringsKt.isBlank(r5)) == false) goto L11;
        r2 = r5;
    L11:
        if (r2 != null) goto L14;
        r2 = r0;
    L14:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c(r0, r2);
    }

    private final h toSubtitleLanguage(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r3) {
        return new h(r3.a, r3.b);
    }

    private final p toTrackState(g r9) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r0 = r9.f;
        String r1 = "";
        if (r0 == null) goto L8;
        String r2 = r0.a;
        if (r2 == null) goto L8;
    L7:
        String r3 = r2;
    L12:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r4 = r9.g;
        if (r4 == null) goto L18;
        String r5 = r4.a;
        if (r5 == null) goto L18;
        String r6 = r5;
    L23:
        return new p(r3, r6, r9.l, r9.o, !r9.n);
    L18:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) CollectionsKt.firstOrNull(r9.e);
        if (r7 == null) goto L21;
        r1 = r7.a;
    L21:
        r6 = r1;
    L8:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) CollectionsKt.firstOrNull(r9.d);
        if (r8 == null) goto L11;
        r2 = r8.a;
        goto L7
    L11:
        r3 = "";
        goto L12
    }

    public void dispatchEvent(final e r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if (Intrinsics.areEqual(r8, e.b.a) == false) goto L6;
        bindSession();
        return;
    L6:
        if (Intrinsics.areEqual(r8, e.a.a) == false) goto L9;
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02931(this, null), 3, null);
        return;
    L9:
        if (Intrinsics.areEqual(r8, e.c.a) == false) goto L12;
        onLanguageClick();
        return;
    L12:
        if (Intrinsics.areEqual(r8, e.j.a) == false) goto L15;
        onSpeakerClick();
        return;
    L15:
        if (Intrinsics.areEqual(r8, e.d.a) == false) goto L18;
        onPauseResumeClick();
        return;
    L18:
        if (Intrinsics.areEqual(r8, e.k.a) == false) goto L21;
        onStopClick();
        return;
    L21:
        if ((r8 instanceof e.g) == false) goto L24;
        onSetSaveArtifactType(((e.g) r8).a);
        return;
    L24:
        if ((r8 instanceof e.C0070e) == false) goto L29;
        e.C0070e r1 = (e.C0070e) r8;
        if (getState().k == r1.a) goto L47;
        trackLanguageIconClick((MmRecordingSession) this.sessionProvider.invoke(), r1.a);
        setState(new AnonymousClass2(r8));
        return;
    L47:
        return;
    L29:
        if ((r8 instanceof e.h) == false) goto L32;
        onSetSpokenLanguage(((e.h) r8).a);
        return;
    L32:
        if ((r8 instanceof e.i) == false) goto L35;
        onSetTargetLanguage(((e.i) r8).a);
        return;
    L35:
        if ((r8 instanceof e.f) == false) goto L39;
        onSetBilingual(((e.f) r8).a);
        return;
    L39:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ void dispatchEvent(j r1) {
        dispatchEvent((e) r1);
    }

    public static final /* synthetic */ boolean access$isBidirectional(MmStandaloneAIInterpretationViewModel r0, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r1) {
        return r0.isBidirectional(r1);
    }

    public static final /* synthetic */ boolean access$isBidirectionalActive(MmStandaloneAIInterpretationViewModel r0, g r1) {
        return r0.isBidirectionalActive(r1);
    }

    public static final /* synthetic */ void access$setHasLoadedLanguageSnapshot$p(MmStandaloneAIInterpretationViewModel r0, boolean r1) {
        r0.hasLoadedLanguageSnapshot = r1;
    }

    public static final /* synthetic */ void access$setLanguageSettingInFlight$p(MmStandaloneAIInterpretationViewModel r0, boolean r1) {
        r0.languageSettingInFlight = r1;
    }

    private final Object closePageIfSessionEnded(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof C02921) == false) goto L7;
        C02921 r0 = (C02921) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L47:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        MmStandaloneAIInterpretationViewModel r12 = (MmStandaloneAIInterpretationViewModel) r0.L$3;
        q r4 = (q) r0.L$2;
        MmRecordingSession r5 = (MmRecordingSession) r0.L$1;
        MmStandaloneAIInterpretationViewModel r6 = (MmStandaloneAIInterpretationViewModel) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L29:
        p r13 = r6.toTrackState((g) r11);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r13, "state");
        boolean r14 = r4.c(r5, r13, "end", "normal_window");
        if (r14 == false) goto L42;
        String r7 = r5.e();
        if (StringsKt.isBlank(r7) == true) goto L42;
        Object r8 = r4.b;
        monitor-enter(r8);
        r4.c.remove(r7);     // Catch: Throwable -> L39
        String r15 = r4.d.remove(r7);     // Catch: Throwable -> L39
        monitor-exit(r8);
    L39:
        th = move-exception;
        throw th;
    L42:
        r12.hasTrackedEndView = r14;
    L43:
        f.a r16 = f.a.a;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.label = 2;
        if (sendVMEvent(r16, r0) != r2) goto L47;
        return r2;
    L16:
        ResultKt.throwOnFailure(r11);
        if (r9.a < 8) goto L49;
        if (this.hasRequestedCloseForEndState == true) goto L49;
        this.hasRequestedCloseForEndState = true;
        int r17 = bwb.b.a;
        bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "closePageIfSessionEnded", "close page for standalone ai interpretation end state, state=" + r9, getLogDetail());
        r5 = this.observedSession;
        if (r5 == null) goto L43;
        if (this.hasTrackedEndView == true) goto L43;
        r4 = getStandaloneAIInterpretationTracker(r5);
        r0.L$0 = this;
        r0.L$1 = r5;
        r0.L$2 = r4;
        r0.L$3 = this;
        r0.label = 1;
        r11 = awaitState(r0);
        if (r11 != r2) goto L28;
        return r2;
    L28:
        r12 = this;
        r6 = r12;
    L49:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new C02921(this, r10);
        goto L8
    }

    private final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c findByType(List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r3, String r4) {
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        if (Intrinsics.areEqual(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r0).a, r4) == false) goto L4;
    L10:
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r0;
    L8:
        r0 = null;
        goto L10
    }

    private final boolean isStartViewSnapshotReady(g r1, boolean r2) {
        if (r2 == true) goto L4;
    L6:
        return false;
    L4:
        if (r1.j == true) goto L6;
        return true;
    }

    private final boolean loadSaveArtifactState(MmRecordingSession r6, String r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        MmStandaloneAIInterpretationRootRepo r8 = r6.h();     // Catch: Throwable -> L12
        if (r8 == null) goto L9;
        MmStandaloneAIInterpretationRepo r9 = r8.a();     // Catch: Throwable -> L12
        if (r9 == null) goto L9;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r10 = r9.t();     // Catch: Throwable -> L12
        if (r10 == null) goto L9;
        boolean r11 = r10.s0();     // Catch: Throwable -> L12
    L10:
        Object r12 = Result.constructor-impl(Boolean.valueOf(r11));     // Catch: Throwable -> L12
    L15:
        if (Result.isSuccess-impl(r12) == false) goto L17;
        boolean r1 = ((Boolean) r12).booleanValue();
        int r2 = bwb.b.a;
        bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "loadSaveArtifactState", "recordingId=" + lvb.a.d(r7) + ", enabled=" + r1, getLogDetail());
    L17:
        Throwable r3 = Result.exceptionOrNull-impl(r12);
        if (r3 == null) goto L20;
        int r4 = bwb.b.a;
        bwb.b.d(MmUiLogScene.StandaloneAIInterpretation, "loadSaveArtifactState", "failed, recordingId=" + lvb.a.d(r7) + ", error=" + r3, getLogDetail());
    L20:
        Boolean r13 = Boolean.FALSE;
        if (Result.isFailure-impl(r12) == false) goto L24;
        r12 = r13;
    L24:
        return ((Boolean) r12).booleanValue();
    L9:
        r11 = false;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    private final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> mergeByStableOrder(List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r6, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r7) {
        if (r6.isEmpty() == false) goto L5;
        return r6;
    L5:
        if (r7.isEmpty() == true) goto L42;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r8 = r6;
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
        Iterator<T> r1 = r8.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        r2.put(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r3).a, r3);
        goto L9
    L11:
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r9 = r7;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r0 = r9.iterator();
    L13:
        if (r0.hasNext() == false) goto L15;
        r4.add(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r0.next()).a);
        goto L13
    L15:
        Set r5 = CollectionsKt.toSet(r4);
        List r10 = CollectionsKt.createListBuilder();
        Iterator<T> r11 = r9.iterator();
    L17:
        if (r11.hasNext() == false) goto L21;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r12 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r2.get(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r11.next()).a);
        if (r12 == null) goto L17;
        r10.add(r12);
        goto L17
    L21:
        Iterator<T> r13 = r8.iterator();
    L23:
        if (r13.hasNext() == false) goto L28;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r14 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r13.next();
        if (r5.contains(r14.a) == true) goto L23;
        r10.add(r14);
        goto L23
    L28:
        return CollectionsKt.build(r10);
    L42:
        return r6;
    }

    private final void onSetLanguage(final MmStandaloneAIInterpretationLanguageSide r26, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r27) {
        MmRecordingSession r9 = (MmRecordingSession) this.sessionProvider.invoke();
        if (r9 != null) goto L6;
        int r0 = bwb.b.a;
        bwb.b.h(MmUiLogScene.StandaloneAIInterpretation, "onSetLanguage", "skip, session not found", getLogDetail());
        return;
    L6:
        final g r10 = getState();
        int[] r11 = a.a;
        int r1 = r11[r26.ordinal()];
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L11;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2 = r10.g;
    L14:
        if (this.languageSettingInFlight == false) goto L21;
        c r3 = this.pendingLanguageSelection;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r26, "side");
        Intrinsics.checkNotNullParameter(r27, "language");
        r3.a = TuplesKt.to(r26, r27);
        int r4 = bwb.b.a;
        MmUiLogScene r5 = MmUiLogScene.StandaloneAIInterpretation;
        StringBuilder r6 = new StringBuilder("queue latest, side=");
        r6.append(r26);
        r6.append(", current=");
        if (r2 == null) goto L18;
        String r15 = r2.a;
    L19:
        r6.append(r15);
        r6.append(", target=");
        r6.append(r27.a);
        bwb.b.f(r5, "onSetLanguage", r6.toString(), getLogDetail());
        return;
    L18:
        r15 = null;
        goto L19
    L21:
        if (r2 == null) goto L23;
        String r7 = r2.a;
    L25:
        if (Intrinsics.areEqual(r7, r27.a) == false) goto L28;
        int r8 = bwb.b.a;
        bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "onSetLanguage", "skip current, side=" + r26 + ", current=" + r2.a, getLogDetail());
        return;
    L28:
        int r12 = r11[r26.ordinal()];
        if (r12 == 1) goto L34;
        if (r12 != 2) goto L33;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r13 = r10.e;
    L35:
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r16 = findByType(r13, r27.a);
        if (r16 != null) goto L39;
        int r14 = bwb.b.a;
        bwb.b.h(MmUiLogScene.StandaloneAIInterpretation, "onSetLanguage", "skip unsupported language, side=" + r26 + ", target=" + r27.a, getLogDetail());
        return;
    L39:
        MmStandaloneAIInterpretationRootRepo r17 = r9.h();
        if (r17 == null) goto L48;
        MmStandaloneAIInterpretationRepo r18 = r17.a();
        if (r18 == null) goto L48;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r19 = r18.t();
        if (r19 == null) goto L48;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b> r20 = r19.b();
        if (r20 == null) goto L48;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b r21 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b) r20.getValue();
    L49:
        String r22 = r16.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r23 = r10.f;
        if (r23 == null) goto L52;
        String r24 = r23.a;
    L53:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r25 = r10.g;
        if (r25 == null) goto L56;
        String r110 = r25.a;
    L57:
        if (r21 == null) goto L59;
        Map<String, List<String>> r28 = r21.d;
    L60:
        if (r28 != null) goto L62;
        r28 = MapsKt.emptyMap();
    L62:
        Map<String, List<String>> r111 = r28;
        if (r21 == null) goto L65;
        Map<String, List<String>> r29 = r21.e;
    L66:
        if (r29 != null) goto L68;
        r29 = MapsKt.emptyMap();
    L68:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b r210 = r21;
        MmStandaloneAIInterpretationLanguageDisabledReason r30 = b.d(r26, r22, r24, r110, r111, r29, r10.d);
        if (r30 == null) goto L72;
        int r31 = bwb.b.a;
        bwb.b.h(MmUiLogScene.StandaloneAIInterpretation, "onSetLanguage", "skip disabled language, side=" + r26 + ", target=" + r16.a + ", reason=" + r30, getLogDetail());
        return;
    L72:
        int r32 = r11[r26.ordinal()];
        if (r32 != 1) goto L75;
        q r33 = getStandaloneAIInterpretationTracker(r9);
        r33.getClass();
        Intrinsics.checkNotNullParameter(r16, "language");
        Intrinsics.checkNotNullParameter(r16, "language");
        r33.b(r9, "speak_language_" + r16.a);
    L81:
        if (isBidirectional(r16) == true) goto L83;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r112 = null;
    L98:
        if (isBidirectional(r16) == false) goto L100;
    L110:
        boolean r113 = false;
    L111:
        if (r113 == false) goto L191;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r34 = r10.d;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r35 = r10.e;
        if (r210 == null) goto L115;
        Map<String, List<String>> r36 = r210.d;
    L116:
        if (r36 != null) goto L118;
        r36 = MapsKt.emptyMap();
    L118:
        if (r210 == null) goto L120;
        Map<String, List<String>> r37 = r210.e;
    L121:
        if (r37 != null) goto L123;
        r37 = MapsKt.emptyMap();
    L123:
        Intrinsics.checkNotNullParameter(r26, "side");
        Intrinsics.checkNotNullParameter(r16, "selectedLanguage");
        Intrinsics.checkNotNullParameter(r34, "spokenLanguages");
        Intrinsics.checkNotNullParameter(r35, "targetLanguages");
        Intrinsics.checkNotNullParameter(r36, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r37, "targetToSpokenLanguageTypes");
        int r38 = b.a.a[r26.ordinal()];
        if (r38 != 1) goto L126;
        MmRecordingSession r211 = r9;
        List r39 = CollectionsKt.listOf(r16);
        ArrayList r40 = new ArrayList();
        Iterator r41 = r35.iterator();
        List r42 = r39;
    L142:
        if (r41.hasNext() == false) goto L150;
        Object r43 = r41.next();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r114 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r43;
        List r115 = r42;
        Set<String> r44 = b.b;
        Iterator r212 = r41;
        if (r44.contains(r16.a) == false) goto L146;
        boolean r45 = b.c.contains(r114.a);
    L147:
        if (r45 == false) goto L149;
        r40.add(r43);
    L149:
        r42 = r115;
        r41 = r212;
        goto L142
    L146:
        r45 = r44.contains(r114.a);
        goto L147
    L150:
        List r46 = r40;
        Object r47 = r42;
    L151:
        Iterator r48 = ((Iterable) r47).iterator();
        List r49 = r46;
    L153:
        if (r48.hasNext() == false) goto L189;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r50 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r48.next();
        Iterator r51 = r49.iterator();
        List r52 = r49;
    L156:
        if (r51.hasNext() == false) goto L181;
        Object r116 = r51.next();
        List r117 = r52;
        Iterator r213 = r48;
        String r53 = r50.a;
        String r54 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r116).a;
        Iterator r214 = r51;
        Intrinsics.checkNotNullParameter(r53, "spokenLanguageType");
        Intrinsics.checkNotNullParameter(r54, "targetLanguageType");
        Intrinsics.checkNotNullParameter(r36, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r37, "targetToSpokenLanguageTypes");
        if (b.b(r53, r54) == false) goto L161;
    L176:
        boolean r55 = false;
    L178:
        if (r55 == true) goto L182;
        r52 = r117;
        r48 = r213;
        r51 = r214;
    L182:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r118 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r116;
        if (r118 == null) goto L185;
        Pair r56 = TuplesKt.to(r50, r118);
    L186:
        if (r56 != null) goto L190;
        r49 = r117;
        r48 = r213;
    L190:
        Pair r57 = r56;
    L193:
        if (isBidirectional(r16) == false) goto L195;
        if (r112 != null) goto L195;
    L197:
        int r58 = bwb.b.a;
        MmUiLogScene r59 = MmUiLogScene.StandaloneAIInterpretation;
        StringBuilder r60 = new StringBuilder("skip invalid fallback, side=");
        r60.append(r26);
        r60.append(", target=");
        r60.append(r16.a);
        r60.append(", bidirectionalTarget=");
        if (r112 == null) goto L200;
        String r61 = r112.a;
    L201:
        r60.append(r61);
        bwb.b.d(r59, "onSetLanguage", r60.toString(), getLogDetail());
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02981(this, null), 3, null);
        return;
    L200:
        r61 = null;
    L195:
        if (r113 == false) goto L203;
        if (r57 == null) goto L197;
    L203:
        MmRecordingUILaunchMode r62 = null;
        int r63 = bwb.b.a;
        bwb.b.f(MmUiLogScene.StandaloneAIInterpretation, "onSetLanguage", "start, side=" + r26 + ", target=" + r16.a + ", bidirectionalActive=" + isBidirectionalActive(r10), getLogDetail());
        this.languageSettingInFlight = true;
        MmRecordingSession r119 = r211;
        k r64 = r119.f;
        if (r64 == null) goto L207;
        r62 = r64.c;
    L207:
        if (r62 != MmRecordingUILaunchMode.WITH_DOUBAO_UI) goto L209;
        boolean r120 = true;
    L210:
        final boolean r65 = r120;
        final Pair r66 = r57;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r67 = r112;
        setState(new C02992(r65, r66, r10, r16, r67, this, r26));
        BuildersKt.launch$default(getViewModelScope(), null, null, new C03003(r26, r16, this, r119, r120, r112, r113, r57, r10, r10, null), 3, null);
        return;
    L209:
        r120 = false;
        goto L210
    L185:
        r56 = null;
        goto L186
    L161:
        if ((!r36.isEmpty()) == false) goto L169;
        List<String> r68 = r36.get(r53);
        if (r68 != null) goto L166;
        r68 = CollectionsKt.emptyList();
    L166:
        if (r68.contains(r54) == false) goto L176;
    L169:
        if (r37.isEmpty() == true) goto L177;
        List<String> r69 = r37.get(r54);
        if (r69 != null) goto L174;
        r69 = CollectionsKt.emptyList();
    L174:
        if (r69.contains(r53) == false) goto L176;
    L177:
        r55 = true;
        goto L178
    L181:
        r117 = r52;
        r213 = r48;
        r116 = null;
        goto L182
    L189:
        r56 = null;
        goto L190
    L126:
        if (r38 != 2) goto L139;
        ArrayList r70 = new ArrayList();
        Iterator r71 = r34.iterator();
    L129:
        if (r71.hasNext() == false) goto L137;
        Object r72 = r71.next();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r121 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r72;
        Iterator r122 = r71;
        Set<String> r73 = b.b;
        MmRecordingSession r215 = r9;
        if (r73.contains(r16.a) == false) goto L133;
        boolean r74 = b.c.contains(r121.a);
    L134:
        if (r74 == false) goto L136;
        r70.add(r72);
    L136:
        r71 = r122;
        r9 = r215;
        goto L129
    L133:
        r74 = r73.contains(r121.a);
        goto L134
    L137:
        r211 = r9;
        r46 = CollectionsKt.listOf(r16);
        r47 = r70;
        goto L151
    L139:
        throw new NoWhenBranchMatchedException();
    L120:
        r37 = null;
        goto L121
    L115:
        r36 = null;
        goto L116
    L191:
        r211 = r9;
        r57 = null;
        goto L193
    L100:
        if (isBidirectionalActive(r10) == false) goto L102;
    L109:
        r113 = true;
        goto L111
    L102:
        if (r26 != MmStandaloneAIInterpretationLanguageSide.TARGET) goto L110;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r75 = r10.f;
        if (r75 == null) goto L106;
        String r76 = r75.a;
    L108:
        if (b.c(r76, r10.d) == false) goto L110;
    L106:
        r76 = null;
        goto L108
    L83:
        if (r26 != MmStandaloneAIInterpretationLanguageSide.TARGET) goto L85;
        r112 = r16;
        goto L98
    L85:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r77 = findByType(r10.e, r16.a);
        if (r77 != null) goto L95;
        Iterator<T> r78 = r10.e.iterator();
    L89:
        if (r78.hasNext() == false) goto L93;
        Object r79 = r78.next();
        if (isBidirectional((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r79) == false) goto L89;
    L94:
        r112 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r79;
        goto L98
    L93:
        r79 = null;
        goto L94
    L95:
        r112 = r77;
        goto L98
    L75:
        if (r32 != 2) goto L78;
        q r80 = getStandaloneAIInterpretationTracker(r9);
        r80.getClass();
        Intrinsics.checkNotNullParameter(r16, "language");
        Intrinsics.checkNotNullParameter(r16, "language");
        r80.b(r9, "translation_language_" + r16.a);
        goto L81
    L78:
        throw new NoWhenBranchMatchedException();
    L65:
        r29 = null;
        goto L66
    L59:
        r28 = null;
        goto L60
    L56:
        r110 = null;
        goto L57
    L52:
        r24 = null;
    L48:
        r21 = null;
        goto L49
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        r13 = r10.d;
        goto L35
    L23:
        r7 = null;
        goto L25
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        r2 = r10.f;
        goto L14
    }

    private final void refreshLanguageState(MmRecordingSession r21, final boolean r22) {
        if (this.observedSession == r21) goto L5;
        return;
    L5:
        MmStandaloneAIInterpretationRootRepo r0 = r21.h();
        if (r0 == null) goto L111;
        MmStandaloneAIInterpretationRepo r1 = r0.a();
        if (r1 == null) goto L111;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r2 = r1.t();
        if (r2 == null) goto L111;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b> r3 = r2.b();
        if (r3 == null) goto L111;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b) r3.getValue();
        if (r4 == null) goto L111;
        MmStandaloneAIInterpretationRootRepo r5 = r21.h();
        if (r5 == null) goto L24;
        MmRecordingLanguageRepo r6 = r5.l();
        if (r6 == null) goto L24;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r7 = r6.l();
        if (r7 == null) goto L24;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f> r8 = r7.b();
        if (r8 == null) goto L24;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f r9 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f) r8.getValue();
    L25:
        g r10 = getState();
        final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r11 = r4.b;
        final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r12 = mergeByStableOrder(r4.c, r10.e);
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r13 = r4.g;
        if (r13 == null) goto L31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r14 = findByType(r12, r13.a);
        if (r14 == null) goto L37;
    L30:
        r13 = r14;
    L37:
        if (r9 == null) goto L43;
        h r15 = r9.c;
        if (r15 == null) goto L43;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r16 = toStandaloneLanguage(r15);
        if (r16 == null) goto L43;
    L44:
        if (r16 != null) goto L46;
    L54:
        r16 = null;
    L55:
        boolean r17 = false;
        if (r13 != null) goto L58;
    L60:
        if (r17 == false) goto L73;
        Iterator<T> r18 = r11.iterator();
    L63:
        if (r18.hasNext() == false) goto L67;
        Object r19 = r18.next();
        if (isBidirectional((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r19) == false) goto L63;
    L68:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r20 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r19;
        if (r20 != null) goto L72;
        if (r16 != null) goto L76;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r23 = resolveNormalLanguage(r11, r10.f);
    L75:
        r16 = r23;
    L76:
        ArrayList r24 = new ArrayList();
        Iterator<T> r25 = r11.iterator();
    L78:
        if (r25.hasNext() == false) goto L92;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r26 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r25.next();
        MmStandaloneAIInterpretationLanguageSide r110 = MmStandaloneAIInterpretationLanguageSide.SPOKEN;
        String r111 = r26.a;
        if (r16 == null) goto L82;
        String r112 = r16.a;
    L83:
        if (r13 == null) goto L85;
        String r113 = r13.a;
    L86:
        MmStandaloneAIInterpretationLanguageDisabledReason r27 = b.d(r110, r111, r112, r113, r4.d, r4.e, r11);
        if (r27 == null) goto L89;
        Pair r28 = TuplesKt.to(r26.a, r27);
    L90:
        if (r28 == null) goto L78;
        r24.add(r28);
        goto L78
    L89:
        r28 = null;
        goto L90
    L85:
        r113 = null;
        goto L86
    L82:
        r112 = null;
        goto L83
    L92:
        final Map r29 = MapsKt.toMap(r24);
        ArrayList r30 = new ArrayList();
        Iterator r31 = r12.iterator();
    L94:
        if (r31.hasNext() == false) goto L109;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r32 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r31.next();
        MmStandaloneAIInterpretationLanguageSide r114 = MmStandaloneAIInterpretationLanguageSide.TARGET;
        String r115 = r32.a;
        if (r16 == null) goto L98;
        String r116 = r16.a;
    L99:
        if (r13 == null) goto L101;
        String r117 = r13.a;
    L102:
        Iterator r118 = r31;
        MmStandaloneAIInterpretationLanguageDisabledReason r33 = b.d(r114, r115, r116, r117, r4.d, r4.e, r11);
        if (r33 == null) goto L105;
        Pair r34 = TuplesKt.to(r32.a, r33);
    L106:
        if (r34 == null) goto L108;
        r30.add(r34);
    L108:
        r31 = r118;
        goto L94
    L105:
        r34 = null;
        goto L106
    L101:
        r117 = null;
        goto L102
    L98:
        r116 = null;
        goto L99
    L109:
        final Map r35 = MapsKt.toMap(r30);
        setState(new C03051(this, r13, r12, r4, r9, r11, r16, r29, r35, r22));
        return;
    L72:
        r16 = r20;
        goto L76
    L67:
        r19 = null;
        goto L68
    L73:
        if (r16 != null) goto L76;
        r23 = resolveNormalLanguage(r11, r10.f);
        goto L75
    L58:
        if (isBidirectional(r13) != true) goto L60;
        r17 = true;
        goto L60
    L46:
        if (isBidirectional(r16) == false) goto L49;
        r16 = null;
    L49:
        if (r16 == null) goto L54;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r36 = findByType(r11, r16.a);
        if (r36 == null) goto L55;
        r16 = r36;
    L43:
        r16 = r4.f;
        goto L44
    L31:
        r13 = r10.g;
        if (r13 == null) goto L36;
        r14 = findByType(r12, r13.a);
        if (r14 != null) goto L30;
    L36:
        r13 = null;
    L24:
        r9 = null;
    L111:
        setState(MmStandaloneAIInterpretationViewModel$refreshLanguageState$standaloneEntity$1$1.INSTANCE);
    }

    private final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c resolveNormalLanguage(List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r3, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r4) {
        Object r0 = null;
        if (r4 == null) goto L14;
        String r5 = r4.a;
        if (r5 == null) goto L14;
        if (b.a(r5) == false) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L14;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r6 = findByType(r3, r5);
        if (r6 == null) goto L14;
        return r6;
    L14:
        Iterator<T> r7 = r3.iterator();
    L16:
        if (r7.hasNext() == false) goto L21;
        Object r8 = r7.next();
        if ((!isBidirectional((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r8)) == false) goto L16;
        r0 = r8;
    L21:
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r0;
    }

    private final Object syncSaveArtifactStatus(boolean r6, Continuation<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.f> r7) {
        if ((r7 instanceof C03091) == false) goto L7;
        C03091 r0 = (C03091) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L37
    L31:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.f r9 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.f) r8;     // Catch: Throwable -> L37
        if (r9 != null) goto L35;
    L34:
        r9 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.f(false, false);     // Catch: Throwable -> L37
    L35:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L37
    L40:
        if (Result.exceptionOrNull-impl(r10) != null) goto L43;
        return r10;
    L43:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.f(false, false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        MmRecordingSession r11 = (MmRecordingSession) this.sessionProvider.invoke();
        if (r11 == null) goto L18;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L37
        MmStandaloneAIInterpretationRootRepo r12 = r11.h();     // Catch: Throwable -> L37
        if (r12 == null) goto L34;
        MmStandaloneAIInterpretationRepo r13 = r12.a();     // Catch: Throwable -> L37
        if (r13 == null) goto L34;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r14 = r13.t();     // Catch: Throwable -> L37
        if (r14 == null) goto L34;
        if (r6 == false) goto L27;
        boolean r15 = true;
    L28:
        r0.label = 1;     // Catch: Throwable -> L37
        r8 = r14.z0(r15, r0);     // Catch: Throwable -> L37
        if (r8 != r2) goto L31;
        return r2;
    L27:
        r15 = false;
        goto L28
    L18:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.f(false, false);
    L37:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new C03091(this, r7);
        goto L8
    }

    private final void trackLanguageIconClick(MmRecordingSession r2, MmStandaloneAIInterpretationLanguageSide r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L7;
        getStandaloneAIInterpretationTracker(r2).b(r2, "speak_language_icon");
        return;
    L7:
        if (r4 != 2) goto L10;
        getStandaloneAIInterpretationTracker(r2).b(r2, "translation_language_icon");
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final void trackStartViewIfReady(MmRecordingSession r7, g r8) {
        if (this.hasTrackedStartView == false) goto L5;
        return;
    L5:
        String r1 = null;
        if (isStartViewSnapshotReady(r8, this.hasLoadedLanguageSnapshot) == true) goto L16;
        int r9 = bwb.b.a;
        MmUiLogScene r10 = MmUiLogScene.StandaloneAIInterpretation;
        StringBuilder r2 = new StringBuilder("skip, snapshot not ready, languageSnapshotLoaded=");
        r2.append(this.hasLoadedLanguageSnapshot);
        r2.append(", headerLoading=");
        r2.append(r8.j);
        r2.append(", spoken=");
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r3 = r8.f;
        if (r3 == null) goto L10;
        String r4 = r3.a;
    L11:
        r2.append(r4);
        r2.append(", target=");
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r5 = r8.g;
        if (r5 == null) goto L14;
        r1 = r5.a;
    L14:
        r2.append(r1);
        r2.append(", targetSize=");
        r2.append(r8.e.size());
        bwb.b.f(r10, "trackStartViewIfReady", r2.toString(), getLogDetail());
        return;
    L10:
        r4 = null;
        goto L11
    L16:
        q r0 = getStandaloneAIInterpretationTracker(r7);
        p r11 = toTrackState(r8);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r11, "state");
        String r6 = r7.e();
        Intrinsics.checkNotNullParameter(r6, "recordingId");
        if (StringsKt.isBlank(r6) == false) goto L19;
        r1 = "start";
    L28:
        if (r1 != null) goto L30;
        boolean r12 = true;
    L33:
        this.hasTrackedStartView = r12;
        return;
    L30:
        r12 = r0.c(r7, r11, r1, "normal_window");
        if (r12 == false) goto L33;
        r0.a(r6, "normal_window", r1);
        goto L33
    L19:
        Object r13 = r0.b;
        monitor-enter(r13);
    L35:
        th = move-exception;
        throw th;
    L22:
        if (r0.c.contains(r6) == true) goto L24;
        r1 = "start";
    L27:
        monitor-exit(r13);
        goto L28
    L24:
        if (Intrinsics.areEqual(((LinkedHashMap) r0.d).get(r6), "small_window") == false) goto L27;
        r1 = "in_the_process";
        goto L27
    }

    public static final /* synthetic */ Object access$closePageIfSessionEnded(MmStandaloneAIInterpretationViewModel r0, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r1, Continuation r2) {
        return r0.closePageIfSessionEnded(r1, r2);
    }

    public static final /* synthetic */ boolean access$loadSaveArtifactState(MmStandaloneAIInterpretationViewModel r0, MmRecordingSession r1, String r2) {
        return r0.loadSaveArtifactState(r1, r2);
    }

    public static final /* synthetic */ void access$onSetLanguage(MmStandaloneAIInterpretationViewModel r0, MmStandaloneAIInterpretationLanguageSide r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2) {
        r0.onSetLanguage(r1, r2);
    }

    public static final /* synthetic */ void access$refreshLanguageState(MmStandaloneAIInterpretationViewModel r0, MmRecordingSession r1, boolean r2) {
        r0.refreshLanguageState(r1, r2);
    }

    public static final /* synthetic */ Object access$syncSaveArtifactStatus(MmStandaloneAIInterpretationViewModel r0, boolean r1, Continuation r2) {
        return r0.syncSaveArtifactStatus(r1, r2);
    }

    public static final /* synthetic */ void access$trackStartViewIfReady(MmStandaloneAIInterpretationViewModel r0, MmRecordingSession r1, g r2) {
        r0.trackStartViewIfReady(r1, r2);
    }

    private final Object setSpokenLanguage(MmRecordingSession r6, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r7, Continuation<? super Boolean> r8) {
        if ((r8 instanceof C03061) == false) goto L7;
        C03061 r0 = (C03061) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L30
    L26:
        boolean r10 = ((Boolean) r9).booleanValue();     // Catch: Throwable -> L30
    L28:
        Object r11 = Result.constructor-impl(Boxing.boxBoolean(r10));     // Catch: Throwable -> L30
    L32:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 != null) goto L35;
    L38:
        Boolean r13 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r11) == true) goto L41;
        return r11;
    L41:
        return r13;
    L35:
        if ((r12 instanceof CancellationException) == true) goto L37;
        int r4 = bwb.b.a;
        bwb.b.d(MmUiLogScene.StandaloneAIInterpretation, "setSpokenLanguage", "failed, language=" + r7.a + ", error=" + r12, getLogDetail());
        goto L38
    L37:
        throw r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L30
        MmStandaloneAIInterpretationRootRepo r15 = r6.h();     // Catch: Throwable -> L30
        if (r15 == null) goto L27;
        MmRecordingLanguageRepo r16 = r15.l();     // Catch: Throwable -> L30
        if (r16 == null) goto L27;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r17 = r16.l();     // Catch: Throwable -> L30
        if (r17 == null) goto L27;
        h r18 = toSubtitleLanguage(r7);     // Catch: Throwable -> L30
        r0.L$0 = r7;     // Catch: Throwable -> L30
        r0.label = 1;     // Catch: Throwable -> L30
        r9 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a.C0047a.a(r17, r18, r0);     // Catch: Throwable -> L30
        if (r9 != r2) goto L26;
        return r2;
    L27:
        r10 = false;
    L30:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new C03061(this, r8);
        goto L8
    }

    private final Object switchTargetLanguage(MmRecordingSession r7, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r8, Continuation<? super Boolean> r9) {
        if ((r9 instanceof C03081) == false) goto L7;
        C03081 r0 = (C03081) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r5 = true;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
    L34:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g r11 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g) r10;     // Catch: Throwable -> L14
        if (r11 != null) goto L37;
    L39:
        r5 = false;
    L40:
        Object r12 = Result.constructor-impl(Boxing.boxBoolean(r5));     // Catch: Throwable -> L14
    L43:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 != null) goto L46;
    L49:
        Boolean r14 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r12) == true) goto L52;
        return r12;
    L52:
        return r14;
    L46:
        if ((r13 instanceof CancellationException) == true) goto L48;
        int r4 = bwb.b.a;
        bwb.b.d(MmUiLogScene.StandaloneAIInterpretation, "switchTargetLanguage", "failed, target=" + r8.a + ", error=" + r13, getLogDetail());
        goto L49
    L48:
        throw r13;
    L37:
        if (r11.a() != true) goto L39;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        String r15 = r7.w.a;
        if ((!StringsKt.isBlank(r15)) == true) goto L22;
        r15 = null;
    L22:
        if (r15 != null) goto L25;
        int r16 = bwb.b.a;
        bwb.b.h(MmUiLogScene.StandaloneAIInterpretation, "switchTargetLanguage", "skip, meetingId empty, target=" + r8.a, getLogDetail());
        return Boxing.boxBoolean(false);
    L25:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L14
        MmStandaloneAIInterpretationRootRepo r17 = r7.h();     // Catch: Throwable -> L14
        if (r17 == null) goto L39;
        MmStandaloneAIInterpretationRepo r18 = r17.a();     // Catch: Throwable -> L14
        if (r18 == null) goto L39;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r19 = r18.t();     // Catch: Throwable -> L14
        if (r19 == null) goto L39;
        r0.L$0 = r8;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        r10 = r19.j0(r15, r8, r0);     // Catch: Throwable -> L14
        if (r10 != r2) goto L34;
        return r2;
    L14:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new C03081(this, r9);
        goto L8
    }

    public static final /* synthetic */ Object access$setSpokenLanguage(MmStandaloneAIInterpretationViewModel r0, MmRecordingSession r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2, Continuation r3) {
        return r0.setSpokenLanguage(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$switchTargetLanguage(MmStandaloneAIInterpretationViewModel r0, MmRecordingSession r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2, Continuation r3) {
        return r0.switchTargetLanguage(r1, r2, r3);
    }

    private final boolean shouldShowHeaderLanguageLoading(boolean r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r3, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r4, String r5) {
        if (r2 == true) goto L5;
        return false;
    L5:
        if (r3 == null) goto L7;
        return false;
    L7:
        if (r4.isEmpty() == false) goto L12;
        if (r5 != null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    private final Object switchFromBidirectionalLanguage(MmRecordingSession r6, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r7, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r8, Continuation<? super Boolean> r9) {
        if ((r9 instanceof C03071) == false) goto L7;
        C03071 r0 = (C03071) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L30:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g r11 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g) r10;
        if (r11 != null) goto L33;
    L35:
        r4 = false;
    L37:
        return Boxing.boxBoolean(r4);
    L33:
        if (r11.a() != true) goto L35;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        String r12 = r6.w.a;
        if ((!StringsKt.isBlank(r12)) == true) goto L18;
        r12 = null;
    L18:
        if (r12 != null) goto L21;
        int r13 = bwb.b.a;
        bwb.b.h(MmUiLogScene.StandaloneAIInterpretation, "switchFromBidirectionalLanguage", "skip, meetingId empty, spoken=" + r7.a + ", target=" + r8.a, getLogDetail());
        return Boxing.boxBoolean(false);
    L21:
        MmStandaloneAIInterpretationRootRepo r14 = r6.h();
        if (r14 == null) goto L35;
        MmStandaloneAIInterpretationRepo r15 = r14.a();
        if (r15 == null) goto L35;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r16 = r15.t();
        if (r16 == null) goto L35;
        r0.label = 1;
        r10 = r16.n(r12, r7, r8, r0);
        if (r10 != r2) goto L30;
        return r2;
    L7:
        r0 = new C03071(this, r9);
        goto L8
    }

    public static final /* synthetic */ boolean access$shouldShowHeaderLanguageLoading(MmStandaloneAIInterpretationViewModel r0, boolean r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2, List r3, String r4) {
        return r0.shouldShowHeaderLanguageLoading(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$switchFromBidirectionalLanguage(MmStandaloneAIInterpretationViewModel r0, MmRecordingSession r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r3, Continuation r4) {
        return r0.switchFromBidirectionalLanguage(r1, r2, r3, r4);
    }

    public static void refreshLanguageState$default(MmStandaloneAIInterpretationViewModel r0, MmRecordingSession r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r0.getState().m;
    L5:
        r0.refreshLanguageState(r1, r2);
    }
}
