package com.ss.android.lark.officesdk.minutes.ui.record.speaker;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.d;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerCandidateType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.e;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.g;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.videochat.CreateSpeakerInfoResponse;
import com.ss.android.lark.pb.videochat.GetSpeakerInfoListResponse;
import com.ss.android.lark.pb.videochat.Image;
import com.ss.android.lark.pb.videochat.LarkSpeakerInfo;
import com.ss.android.lark.pb.videochat.SetSpeakerInfoResponse;
import com.ss.android.lark.pb.videochat.SpeakerInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 72\u00020\u0001:\u00017B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJN\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020\u00180\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u001eJ0\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180%2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u001eJ\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020 0'2\u0006\u0010(\u001a\u00020\u0005H\u0082@¢\u0006\u0004\b)\u0010*J6\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\bH\u0082@¢\u0006\u0004\b/\u00100J\b\u00101\u001a\u00020\u0018H\u0014J\u0012\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/speaker/MmSpeakerMarkViewModel;", "Landroidx/lifecycle/ViewModel;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "meetingId", "", "clusterId", "segId", "", "oldSpeaker", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;", "callback", "Lcom/ss/android/lark/officesdk/minutes/ui/record/speaker/IMmSpeakerMarkListener;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;Ljava/lang/String;Ljava/lang/String;JLcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;Lcom/ss/android/lark/officesdk/minutes/ui/record/speaker/IMmSpeakerMarkListener;)V", "getMmUccApi$officesdk_minutes_base_ui_release", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "getMeetingId$officesdk_minutes_base_ui_release", "()Ljava/lang/String;", "searchJob", "Lkotlinx/coroutines/Job;", "submitJob", "currentQuery", "searchSpeakerCandidates", "", AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "from", "force", "", "onResult", "Lkotlin/Function1;", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmRecordingSpeakerCandidate;", "onError", "handleSpeakerClick", "candidate", "onSuccess", "Lkotlin/Function0;", "createSpeaker", "Lkotlin/Result;", AppbrandHostConstants.Schema_Meta.NAME, "createSpeaker-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markSpeaker", MmEndWindowAvatar.TYPE_SPEAKER, "normalizedClusterId", "actualSegId", "markSpeaker-yxL6bBk", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "normalizeSpeakerError", "errorMessage", "isSameSpeaker", "old", "new", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSpeakerMarkViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String ERROR_CODE_SET_SPEAKER_INFO_FAILED = "set_speaker_info_failed";
    public static final String ERROR_CODE_SPEAKER_NAME_DUPLICATED_OR_INVALID = "speaker_name_duplicated_or_invalid";
    private static final long SEARCH_TIMEOUT_MS = 10000;
    private final com.ss.android.lark.officesdk.minutes.ui.record.speaker.a callback;
    private final String clusterId;
    private String currentQuery;
    private final String meetingId;
    private final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a mmUccApi;
    private final c oldSpeaker;
    private Job searchJob;
    private final long segId;
    private Job submitJob;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel$handleSpeakerClick$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel$handleSpeakerClick$1", f = "MmSpeakerMarkViewModel.kt", i = {1, 1}, l = {125, 140}, m = "invokeSuspend", n = {"normalizedClusterId", "newSpeaker"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e $candidate;
        final /* synthetic */ Function1<String, Unit> $onError;
        final /* synthetic */ Function0<Unit> $onSuccess;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MmSpeakerMarkViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(e r1, MmSpeakerMarkViewModel r2, Function1<? super String, Unit> r3, Function0<Unit> r4, Continuation<? super AnonymousClass1> r5) {
            this.$candidate = r1;
            this.this$0 = r2;
            this.$onError = r3;
            this.$onSuccess = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$candidate, this.this$0, this.$onError, this.$onSuccess, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            c r1 = (c) this.L$1;
            String r2 = (String) this.L$0;
            ResultKt.throwOnFailure(r23);
            Object r3 = ((Result) r23).unbox-impl();
        L41:
            Function0<Unit> r4 = this.$onSuccess;
            MmSpeakerMarkViewModel r5 = this.this$0;
            Function1<String, Unit> r6 = this.$onError;
            if (Result.isSuccess-impl(r3) == true) goto L44;
        L51:
            Function1<String, Unit> r7 = this.$onError;
            MmSpeakerMarkViewModel r9 = this.this$0;
            Throwable r10 = Result.exceptionOrNull-impl(r3);
            if (r10 == null) goto L57;
            int r11 = bwb.b.a;
            bwb.b.d(MmUiLogScene.SPEAKER, "markSpeaker", "error=" + r10, null);
            r7.invoke(MmSpeakerMarkViewModel.access$normalizeSpeakerError(r9, r10.getMessage()));
            com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r12 = MmSpeakerMarkViewModel.access$getCallback$p(r9);
            if (r12 == null) goto L57;
            r12.h(new g(r2, MmSpeakerMarkViewModel.access$getOldSpeaker$p(r9)));
        L57:
            return Unit.INSTANCE;
        L44:
            if (((Boolean) r3).booleanValue() == false) goto L48;
            int r13 = bwb.b.a;
            bwb.b.g(MmUiLogScene.SPEAKER, "handleSpeakerClick", "markSpeaker success", null, 8);
            r4.invoke();
            com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r14 = MmSpeakerMarkViewModel.access$getCallback$p(r5);
            if (r14 == null) goto L51;
            r14.h(new g(true, r2, MmSpeakerMarkViewModel.access$getOldSpeaker$p(r5), r1));
            goto L51
        L48:
            int r15 = bwb.b.a;
            bwb.b.d(MmUiLogScene.SPEAKER, "markSpeaker", "mis_set_success is false", null);
            r6.invoke(MmSpeakerMarkViewModel.ERROR_CODE_SET_SPEAKER_INFO_FAILED);
            com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r16 = MmSpeakerMarkViewModel.access$getCallback$p(r5);
            if (r16 == null) goto L51;
            r16.h(new g(r2, MmSpeakerMarkViewModel.access$getOldSpeaker$p(r5)));
            goto L51
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r23);
            Object r17 = ((Result) r23).unbox-impl();
        L15:
            Function1<String, Unit> r18 = this.$onError;
            MmSpeakerMarkViewModel r19 = this.this$0;
            Throwable r20 = Result.exceptionOrNull-impl(r17);
            if (r20 != null) goto L18;
            e r21 = (e) r17;
        L21:
            Long r22 = Boxing.boxLong(MmSpeakerMarkViewModel.access$getSegId$p(this.this$0));
            if (r22.longValue() <= 0) goto L24;
            boolean r24 = true;
        L25:
            if (r24 == true) goto L28;
            r22 = null;
        L28:
            if (r22 == null) goto L30;
            long r25 = r22.longValue();
        L31:
            long r26 = r25;
            String r27 = MmSpeakerMarkViewModel.access$getClusterId$p(this.this$0);
            if (StringsKt.isBlank(r27) == false) goto L34;
            r27 = "-" + r26;
        L34:
            String r110 = r27;
            int r28 = c.g;
            Intrinsics.checkNotNullParameter(r21, "candidate");
            c r29 = new c(r21.b, r21.c, r21.d, r21.e, r21.f, r21.g);
            com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r30 = MmSpeakerMarkViewModel.access$getCallback$p(this.this$0);
            if (r30 == null) goto L37;
            r30.a(r110, MmSpeakerMarkViewModel.access$getOldSpeaker$p(this.this$0), r29);
        L37:
            MmSpeakerMarkViewModel r31 = this.this$0;
            c r32 = MmSpeakerMarkViewModel.access$getOldSpeaker$p(r31);
            this.L$0 = r110;
            this.L$1 = r29;
            this.label = 2;
            r3 = MmSpeakerMarkViewModel.m515access$markSpeakeryxL6bBk(r31, r32, r29, r110, r26, this);
            if (r3 != r8) goto L40;
            return r8;
        L40:
            r1 = r29;
            r2 = r110;
            goto L41
        L30:
            r25 = System.currentTimeMillis();
            goto L31
        L24:
            r24 = false;
            goto L25
        L18:
            int r33 = bwb.b.a;
            bwb.b.d(MmUiLogScene.SPEAKER, "createSpeaker", "error=" + r20, null);
            r18.invoke(MmSpeakerMarkViewModel.access$normalizeSpeakerError(r19, r20.getMessage()));
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r23);
            if (this.$candidate.getType() != MmRecordingSpeakerCandidateType.ADD_NEW) goto L20;
            int r34 = bwb.b.a;
            bwb.b.g(MmUiLogScene.SPEAKER, "handleSpeakerClick", "creating new speaker: " + this.$candidate.c, null, 8);
            MmSpeakerMarkViewModel r35 = this.this$0;
            String r36 = this.$candidate.c;
            this.label = 1;
            r17 = MmSpeakerMarkViewModel.m514access$createSpeakergIAlus(r35, r36, this);
            if (r17 != r8) goto L15;
            return r8;
        L20:
            r21 = this.$candidate;
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel$searchSpeakerCandidates$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel$searchSpeakerCandidates$1", f = "MmSpeakerMarkViewModel.kt", i = {}, l = {53, 58}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $force;
        final /* synthetic */ String $from;
        final /* synthetic */ Function1<String, Unit> $onError;
        final /* synthetic */ Function1<List<e>, Unit> $onResult;
        final /* synthetic */ String $query;
        int label;
        final /* synthetic */ MmSpeakerMarkViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C02861(MmSpeakerMarkViewModel r1, String r2, boolean r3, String r4, Function1<? super String, Unit> r5, Function1<? super List<e>, Unit> r6, Continuation<? super C02861> r7) {
            this.this$0 = r1;
            this.$from = r2;
            this.$force = r3;
            this.$query = r4;
            this.$onError = r5;
            this.$onResult = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new C02861(this.this$0, this.$from, this.$force, this.$query, this.$onError, this.$onResult, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r21) {
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = this.label;
            String r9 = "";
            if (r4 == 0) goto L12;
            if (r4 == 1) goto L10;
            if (r4 != 2) goto L9;
            ResultKt.throwOnFailure(r21);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Object r2 = r21;
        L19:
            Object r5 = ((Result) r2).unbox-impl();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (Intrinsics.areEqual(this.$query, MmSpeakerMarkViewModel.access$getCurrentQuery$p(this.this$0)) == true) goto L23;
            int r6 = bwb.b.a;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            bwb.b.g(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "ignore stale result, query=" + this.$query + ", currentQuery=" + MmSpeakerMarkViewModel.access$getCurrentQuery$p(this.this$0), null, 8);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            return Unit.INSTANCE;
        L23:
            String r13 = this.$query;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Function1<List<e>, Unit> r0 = this.$onResult;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (Result.isSuccess-impl(r5) == false) goto L57;
            GetSpeakerInfoListResponse r7 = (GetSpeakerInfoListResponse) r5;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            int r8 = r7.mspeaker_info_list.size() + r7.mlark_speaker_info_list.size();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            List<SpeakerInfo> r10 = r7.mspeaker_info_list;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Iterator<T> r12 = r10.iterator();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L27:
            if (r12.hasNext() == false) goto L29;
            SpeakerInfo r14 = (SpeakerInfo) r12.next();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            int r15 = e.h;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            r11.add(e.a.b(r14));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            goto L27
        L29:
            List r16 = CollectionsKt.toMutableList(r11);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            List<LarkSpeakerInfo> r17 = r7.mlark_speaker_info_list;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Iterator<T> r19 = r17.iterator();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L31:
            if (r19.hasNext() == false) goto L33;
            LarkSpeakerInfo r110 = (LarkSpeakerInfo) r19.next();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            int r111 = e.h;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            r18.add(e.a.a(r110));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            goto L31
        L33:
            r16.addAll(r18);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            List r20 = r16;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if ((r20 instanceof Collection) == true) goto L36;
        L38:
            Iterator r22 = r20.iterator();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L40:
            if (r22.hasNext() == false) goto L51;
            e r112 = (e) r22.next();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (r112.getType() == MmRecordingSpeakerCandidateType.NORMAL) goto L44;
        L48:
            boolean r113 = false;
        L49:
            if (r113 == false) goto L40;
            boolean r23 = true;
        L53:
            if ((true ^ StringsKt.isBlank(r13)) == false) goto L56;
            if (r23 == true) goto L56;
            int r24 = e.h;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Intrinsics.checkNotNullParameter(r13, AppbrandHostConstants.Schema_Meta.NAME);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            ListProtector.add(r16, 0, new e(MmRecordingSpeakerCandidateType.ADD_NEW, null, r13, null, null, null, MmMarkedSpeakerType.TEMPORARY, 58));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L56:
            int r25 = bwb.b.a;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            bwb.b.g(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "size=" + r8 + ", result=" + r16, null, 8);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            r0.invoke(r16);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            goto L57
        L44:
            if (r112.g.isLarkUser() == true) goto L48;
            if (Intrinsics.areEqual(r112.c, r13) == false) goto L48;
            r113 = true;
        L51:
            r23 = false;
            goto L53
        L36:
            if (r20.isEmpty() == false) goto L38;
        L57:
            Function1<String, Unit> r1 = this.$onError;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Throwable r26 = Result.exceptionOrNull-impl(r5);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (r26 == null) goto L86;
            int r27 = bwb.b.a;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            bwb.b.d(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "error=" + r26, null);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            String r28 = r26.getMessage();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (r28 != null) goto L62;
            r28 = "";
        L62:
            r1.invoke(r28);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L86:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r21);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L16:
            String r114 = this.this$0.getMmUccApi$officesdk_minutes_base_ui_release().getCurrentUserId();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            String r115 = this.this$0.getMmUccApi$officesdk_minutes_base_ui_release().getTenantId();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            int r29 = bwb.b.a;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            bwb.b.g(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "from=" + this.$from + ", force=" + this.$force + ", query=" + this.$query + ", , operatorId=" + r114 + ", tenantId=" + r115, null, 8);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            MmSpeakerMarkViewModel$searchSpeakerCandidates$1$result$1 r30 = new MmSpeakerMarkViewModel$searchSpeakerCandidates$1$result$1(this.this$0, r114, r115, this.$query, null);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            this.label = 2;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            r2 = TimeoutKt.b(MmSpeakerMarkViewModel.SEARCH_TIMEOUT_MS, r30, this);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (r2 != r3) goto L19;
            return r3;
        L12:
            ResultKt.throwOnFailure(r21);
            this.label = 1;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (DelayKt.delay(180, this) != r3) goto L16;
            return r3;
        L66:
            e = move-exception;
            int r31 = bwb.b.a;
            bwb.b.d(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "timeout=" + e, null);
            if (Intrinsics.areEqual(this.$query, MmSpeakerMarkViewModel.access$getCurrentQuery$p(this.this$0)) == false) goto L86;
            Function1<String, Unit> r32 = this.$onError;
            String r33 = e.getMessage();
            if (r33 == null) goto L84;
            r9 = r33;
        L84:
            r32.invoke(r9);
        L64:
            e = move-exception;
            if ((e instanceof CancellationException) == true) goto L77;
            int r34 = bwb.b.a;
            bwb.b.d(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "exception=" + e, null);
            if (Intrinsics.areEqual(this.$query, MmSpeakerMarkViewModel.access$getCurrentQuery$p(this.this$0)) == false) goto L86;
            Function1<String, Unit> r35 = this.$onError;
            String r36 = e.getMessage();
            if (r36 == null) goto L76;
            r9 = r36;
        L76:
            r35.invoke(r9);
            goto L86
        L77:
            throw e;
        }
    }

    static {
        Companion = new a();
    }

    public void onCleared() {
        super.onCleared();
        Job r0 = this.searchJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = this.submitJob;
        if (r1 == null) goto L9;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
        return;
    }

    public final String getMeetingId$officesdk_minutes_base_ui_release() {
        return this.meetingId;
    }

    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a getMmUccApi$officesdk_minutes_base_ui_release() {
        return this.mmUccApi;
    }

    public static final /* synthetic */ com.ss.android.lark.officesdk.minutes.ui.record.speaker.a access$getCallback$p(MmSpeakerMarkViewModel r0) {
        return r0.callback;
    }

    public static final /* synthetic */ String access$getClusterId$p(MmSpeakerMarkViewModel r0) {
        return r0.clusterId;
    }

    public static final /* synthetic */ String access$getCurrentQuery$p(MmSpeakerMarkViewModel r0) {
        return r0.currentQuery;
    }

    public static final /* synthetic */ c access$getOldSpeaker$p(MmSpeakerMarkViewModel r0) {
        return r0.oldSpeaker;
    }

    public static final /* synthetic */ long access$getSegId$p(MmSpeakerMarkViewModel r2) {
        return r2.segId;
    }

    private final String normalizeSpeakerError(String r2) {
        if (Intrinsics.areEqual(r2, ERROR_CODE_SPEAKER_NAME_DUPLICATED_OR_INVALID) == true) goto L7;
        return ERROR_CODE_SET_SPEAKER_INFO_FAILED;
    L7:
        return ERROR_CODE_SPEAKER_NAME_DUPLICATED_OR_INVALID;
    }

    public static final /* synthetic */ String access$normalizeSpeakerError(MmSpeakerMarkViewModel r0, String r1) {
        return r0.normalizeSpeakerError(r1);
    }

    /* JADX INFO: renamed from: createSpeaker-gIAlu-s, reason: not valid java name */
    private final Object m516createSpeakergIAlus(String r6, Continuation<? super Result<e>> r7) {
        if ((r7 instanceof MmSpeakerMarkViewModel$createSpeaker$1) == false) goto L7;
        MmSpeakerMarkViewModel$createSpeaker$1 r0 = (MmSpeakerMarkViewModel$createSpeaker$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L18:
        if (Result.isSuccess-impl(r9) == false) goto L27;
        CreateSpeakerInfoResponse r10 = (CreateSpeakerInfoResponse) r9;     // Catch: Throwable -> L24
        if (Intrinsics.areEqual(r10.mis_speaker_name_duplicated, Boxing.boxBoolean(true)) == true) goto L23;
        int r11 = e.h;     // Catch: Throwable -> L24
        return Result.constructor-impl(e.a.b(r10.mspeaker_info));
    L23:
        throw new IllegalStateException(ERROR_CODE_SPEAKER_NAME_DUPLICATED_OR_INVALID);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = ResultKt.createFailure(th);
    L27:
        return Result.constructor-impl(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        String r13 = this.mmUccApi.getCurrentUserId();
        MmRecordingNetHelper r4 = this.mmUccApi.G();
        String r5 = this.meetingId;
        r0.label = 1;
        r9 = r4.k(r5, r13, r6, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new MmSpeakerMarkViewModel$createSpeaker$1(this, r7);
        goto L8
    }

    private final boolean isSameSpeaker(c r5, c r6) {
        if (r5.a.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L12:
        return false;
    L8:
        if (Intrinsics.areEqual(r5.a, r6.a) == false) goto L12;
        if (r5.f != r6.f) goto L12;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: access$createSpeaker-gIAlu-s, reason: not valid java name */
    public static final /* synthetic */ Object m514access$createSpeakergIAlus(MmSpeakerMarkViewModel r0, String r1, Continuation r2) {
        return r0.m516createSpeakergIAlus(r1, r2);
    }

    public final void handleSpeakerClick(e r16, Function0<Unit> r17, Function1<? super String, Unit> r18) {
        Intrinsics.checkNotNullParameter(r16, "candidate");
        Intrinsics.checkNotNullParameter(r17, "onSuccess");
        Intrinsics.checkNotNullParameter(r18, "onError");
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.SPEAKER, "handleSpeakerClick", "clusterId=" + this.clusterId + ", segId=" + this.segId + ", oldSpeaker=" + this.oldSpeaker + ", candidate=" + r16, null, 8);
        Job r1 = this.searchJob;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        Job r2 = this.submitJob;
        if (r2 == null) goto L8;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L8:
        this.submitJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r16, this, r18, r17, null), 3, null);
    }

    /* JADX INFO: renamed from: markSpeaker-yxL6bBk, reason: not valid java name */
    private final Object m517markSpeakeryxL6bBk(c r20, c r21, String r22, long r23, Continuation<? super Result<Boolean>> r25) {
        if ((r25 instanceof MmSpeakerMarkViewModel$markSpeaker$1) == false) goto L7;
        MmSpeakerMarkViewModel$markSpeaker$1 r3 = (MmSpeakerMarkViewModel$markSpeaker$1) r25;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        MmSpeakerMarkViewModel$markSpeaker$1 r11 = r3;
        Object r2 = r11.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r11.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        ResultKt.throwOnFailure(r2);
        Object r0 = ((Result) r2).unbox-impl();
    L38:
        if (Result.isSuccess-impl(r0) == false) goto L44;
        return Result.constructor-impl(Boxing.boxBoolean(Intrinsics.areEqual(((SetSpeakerInfoResponse) r0).mis_set_success, Boxing.boxBoolean(true))));
    L41:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r0 = ResultKt.createFailure(th);
    L44:
        return Result.constructor-impl(r0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        Image r8 = null;
        if (isSameSpeaker(r20, r21) == false) goto L19;
        int r1 = bwb.b.a;
        bwb.b.g(MmUiLogScene.SPEAKER, "markSpeaker", "same speaker, skip network request", null, 8);
        Result.Companion r9 = Result.Companion;
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L19:
        if (StringsKt.startsWith$default(r22, "-", false, 2, null) == false) goto L22;
        int r10 = bwb.b.a;
        bwb.b.g(MmUiLogScene.SPEAKER, "markSpeaker", "clusterId starts with '-', treating as segId, skipping network request", null, 8);
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L22:
        String r13 = this.mmUccApi.getCurrentUserId();
        MmRecordingNetHelper r14 = this.mmUccApi.G();
        String r15 = this.meetingId;
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r21, MmEndWindowAvatar.TYPE_SPEAKER);
        if (r21.f.isLarkUser() == false) goto L33;
        String r16 = r21.a;
        String r17 = r21.b;
        String r18 = r21.c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.d r19 = r21.e;
        if (r19 == null) goto L28;
        String r110 = r19.a;
        if (r110 == null) goto L28;
    L29:
        String r111 = r110;
        if (r19 == null) goto L32;
        r8 = new Image(r19.a, r19.b);
    L32:
        d r112 = new d.b(r16, r17, r18, r111, r8);
    L34:
        r11.label = 1;
        r0 = r14.x(r15, r13, r22, r23, r112, r11);
        if (r0 != r5) goto L38;
        return r5;
    L28:
        r110 = "";
        goto L29
    L33:
        r112 = new d.c(r21.a, r21.b, r21.d);
    L7:
        r3 = new MmSpeakerMarkViewModel$markSpeaker$1(this, r25);
        goto L8
    }

    public final void searchSpeakerCandidates(String r16, String r17, boolean r18, Function1<? super List<e>, Unit> r19, Function1<? super String, Unit> r20) {
        Intrinsics.checkNotNullParameter(r16, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
        Intrinsics.checkNotNullParameter(r17, "from");
        Intrinsics.checkNotNullParameter(r19, "onResult");
        Intrinsics.checkNotNullParameter(r20, "onError");
        if (r18 == false) goto L5;
    L7:
        this.currentQuery = r16;
        Job r0 = this.searchJob;
        if (r0 == null) goto L10;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L10:
        this.searchJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02861(this, r17, r18, r16, r20, r19, null), 3, null);
        return;
    L5:
        if (Intrinsics.areEqual(r16, this.currentQuery) == false) goto L7;
    }

    public MmSpeakerMarkViewModel(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, String r3, String r4, long r5, c r7, com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r8) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        Intrinsics.checkNotNullParameter(r3, "meetingId");
        Intrinsics.checkNotNullParameter(r4, "clusterId");
        Intrinsics.checkNotNullParameter(r7, "oldSpeaker");
        this.mmUccApi = r2;
        this.meetingId = r3;
        this.clusterId = r4;
        this.segId = r5;
        this.oldSpeaker = r7;
        this.callback = r8;
    }

    /* JADX INFO: renamed from: access$markSpeaker-yxL6bBk, reason: not valid java name */
    public static final /* synthetic */ Object m515access$markSpeakeryxL6bBk(MmSpeakerMarkViewModel r0, c r1, c r2, String r3, long r4, Continuation r6) {
        return r0.m517markSpeakeryxL6bBk(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void searchSpeakerCandidates$default(MmSpeakerMarkViewModel r6, String r7, String r8, boolean r9, Function1 r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        boolean r3 = false;
    L6:
        r6.searchSpeakerCandidates(r7, r8, r3, r10, r11);
        return;
    L5:
        r3 = r9;
        goto L6
    }
}
