package com.larus.avlink.env.diary.detail;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.account.base.api.ILoginService;
import com.larus.avlink.api.DoraGResourceServiceDelegate;
import com.larus.avlink.env.diary.feedback.api.DoraEnvObserveDiaryFeedbackApi;
import com.larus.avlink.env.diary.feedback.model.DiaryFeedbackToastType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u000200J\u0016\u00103\u001a\u0002002\u0006\u00104\u001a\u00020%2\u0006\u00101\u001a\u00020\u0005J\u000e\u00105\u001a\u0002002\u0006\u00104\u001a\u00020%J\u000e\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020%J\u0014\u00108\u001a\u0002002\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050#J\u000e\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\u0005J\u0006\u0010<\u001a\u000200J\u0006\u0010=\u001a\u000200J\u0006\u0010>\u001a\u000200J\u000e\u0010?\u001a\u0002002\u0006\u0010@\u001a\u00020AJ&\u0010B\u001a\u0002002\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u00101\u001a\u00020\u00052\f\u0010E\u001a\b\u0012\u0004\u0012\u0002000FJ\u0006\u0010G\u001a\u00020\u000fJ\u0006\u0010H\u001a\u00020\u000fJ\b\u0010I\u001a\u000200H\u0002J\u0010\u0010J\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0002J\u0018\u0010K\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\u0006\u00104\u001a\u00020%H\u0002J\u0010\u0010L\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0002J\u0010\u0010M\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0005H\u0002J\u0010\u0010N\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0002J\b\u0010O\u001a\u000200H\u0002J\b\u0010P\u001a\u000200H\u0002J\u0010\u0010Q\u001a\u0002002\u0006\u00104\u001a\u00020%H\u0002J\b\u0010R\u001a\u000200H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,¨\u0006T"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DoraEnvObserveDiaryDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "userId", "getUserId", "()Ljava/lang/String;", "diaryDetailLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/avlink/env/diary/detail/model/DiaryDetail;", "getDiaryDetailLiveData", "()Landroidx/lifecycle/MutableLiveData;", "_isLoading", "", "isLoading", "Landroidx/lifecycle/LiveData;", "isLoading$dora_avlink_impl_release", "()Landroidx/lifecycle/LiveData;", "_feedbackSheetState", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackSheetUiState;", "feedbackSheetState", "getFeedbackSheetState", "_toastEffect", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackToastEffect;", "toastEffect", "getToastEffect", "feedbackDraftCache", "", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackDraft;", "feedbackDraftDiaryIds", "Ljava/util/LinkedHashSet;", "feedbackConfigMap", "", "", "pendingFeedbackActionType", "", "Ljava/lang/Integer;", "currentDiaryId", "isFeedbackRequestInFlight", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "fetchDiaryDetail", "", "diaryId", "loadFeedbackConfigIfNeeded", "openFeedbackSheet", "actionType", "previewFeedbackActionType", "getDisplayedFeedbackActionType", "committedActionType", "updateSelectedReasons", "selectedReasons", "updateInputText", "inputText", "saveDraft", "submitFeedback", "cancelFeedback", "onFeedbackSheetDismissed", "sessionId", "", "deleteDiary", "context", "Landroid/content/Context;", "onSuccess", "Lkotlin/Function0;", "isEnvObserveEnable", "inEnvObserveScene", "refreshSheetReasonOptions", "clearFeedbackStateForNewDiary", "clearDraft", "syncDraftDiaryState", "hasDraftForDiary", "touchDraftDiary", "trimDraftDiaryCacheIfNeeded", "refreshFeedbackActionTypeDisplay", "updateDiaryFeedbackActionType", "syncDiaryFeedbackActionType", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveDiaryDetailViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final int MAX_CACHED_DRAFT_DIARY_COUNT = 10;
    private final String TAG;
    private final MutableLiveData<j98.f> _feedbackSheetState;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<j98.g> _toastEffect;
    private String currentDiaryId;
    private final MutableLiveData<i98.a> diaryDetailLiveData;
    private final Lazy doraPageConfig$delegate;
    private Map<String, ? extends List<String>> feedbackConfigMap;
    private final Map<String, j98.b> feedbackDraftCache;
    private final LinkedHashSet<String> feedbackDraftDiaryIds;
    private final LiveData<j98.f> feedbackSheetState;
    private boolean isFeedbackRequestInFlight;
    private final LiveData<Boolean> isLoading;
    private Integer pendingFeedbackActionType;
    private final LiveData<j98.g> toastEffect;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$cancelFeedback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$cancelFeedback$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $diaryId;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public AnonymousClass1(DoraEnvObserveDiaryDetailViewModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$diaryId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$diaryId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L8;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L21 Exception -> L23
        L13:
            dm9.a.a r10 = (dm9.a) r9;     // Catch: Throwable -> L21 Exception -> L23
            if ((r10 instanceof dm9.a.b) == false) goto L17;
            DoraEnvObserveDiaryDetailViewModel.access$updateDiaryFeedbackActionType(this.this$0, 0);     // Catch: Throwable -> L21 Exception -> L23
        L25:
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackRequestInFlight$p(this.this$0, false);
            return Unit.INSTANCE;
        L17:
            if ((r10 instanceof dm9.a.a) == false) goto L20;
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "cancelFeedback error: " + r10.b);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$syncDiaryFeedbackActionType(this.this$0);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(2131903889, DiaryFeedbackToastType.FAILURE));     // Catch: Throwable -> L21 Exception -> L23
            goto L25
        L20:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L21 Exception -> L23
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
            DoraEnvObserveDiaryFeedbackApi.a r11 = DoraEnvObserveDiaryFeedbackApi.a;     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel$cancelFeedback$1$result$1 r3 = new DoraEnvObserveDiaryDetailViewModel$cancelFeedback$1$result$1(this.$diaryId, null);     // Catch: Throwable -> L21 Exception -> L23
            this.label = 1;     // Catch: Throwable -> L21 Exception -> L23
            r11.getClass();     // Catch: Throwable -> L21 Exception -> L23
            r9 = DoraEnvObserveDiaryFeedbackApi.a.a(r3, this);     // Catch: Throwable -> L21 Exception -> L23
            if (r9 != r1) goto L13;
            return r1;
        L23:
            e = move-exception;
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "cancelFeedback error", e);     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$syncDiaryFeedbackActionType(this.this$0);     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(2131903889, DiaryFeedbackToastType.FAILURE));     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackRequestInFlight$p(this.this$0, false);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$deleteDiary$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$deleteDiary$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $diaryId;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public C01011(DoraEnvObserveDiaryDetailViewModel r1, String r2, Function0<Unit> r3, Context r4, Continuation<? super C01011> r5) {
            this.this$0 = r1;
            this.$diaryId = r2;
            this.$onSuccess = r3;
            this.$context = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01011(this.this$0, this.$diaryId, this.$onSuccess, this.$context, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r13);     // Catch: Exception -> L20
        L13:
            com.larus.network.http.f r14 = (com.larus.network.http.a) r13;     // Catch: Exception -> L20
            if ((r14 instanceof com.larus.network.http.y) == false) goto L17;
            FLogger.a.i(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "deleteDiary success");     // Catch: Exception -> L20
            DoraGResourceServiceDelegate.b.f(this.$diaryId);     // Catch: Exception -> L20
            this.$onSuccess.invoke();     // Catch: Exception -> L20
        L23:
            return Unit.INSTANCE;
        L17:
            if ((r14 instanceof com.larus.network.http.f) == false) goto L23;
            t19.s r2 = t19.s.a;     // Catch: Exception -> L20
            Context r3 = this.$context;     // Catch: Exception -> L20
            r2.getClass();     // Catch: Exception -> L20
            t19.s.b(r3, 2131904086, false);     // Catch: Exception -> L20
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error deleting diary", r14.d);     // Catch: Exception -> L20
            goto L23
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
            JSONObject r8 = new JSONObject();     // Catch: Exception -> L20
            String r15 = this.$diaryId;     // Catch: Exception -> L20
            r8.put("diary_ids", new JSONArray().put(r15));     // Catch: Exception -> L20
            com.larus.dora.api.network.a r16 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L20
            this.label = 1;     // Catch: Exception -> L20
            r13 = com.larus.dora.api.network.a.c(r16, Object.class, "/alice/wearable/diary/delete_user_diary", r8, null, this, 248);     // Catch: Exception -> L20
            if (r13 != r0) goto L13;
            return r0;
        L20:
            e = move-exception;
            t19.s r4 = t19.s.a;
            Context r5 = this.$context;
            r4.getClass();
            t19.s.b(r5, 2131904086, false);
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error deleting diary", e);
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$fetchDiaryDetail$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$fetchDiaryDetail$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $diaryId;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public C01021(DoraEnvObserveDiaryDetailViewModel r1, String r2, Continuation<? super C01021> r3) {
            this.this$0 = r1;
            this.$diaryId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01021(this.this$0, this.$diaryId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r26) {
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L33 Exception -> L35
            Object r2 = r26;
        L13:
            com.larus.network.http.y r3 = (com.larus.network.http.a) r2;     // Catch: Throwable -> L33 Exception -> L35
            if ((r3 instanceof com.larus.network.http.y) == false) goto L30;
            i98.b r4 = (i98.b) ((com.larus.network.http.a) r3).b;     // Catch: Throwable -> L33 Exception -> L35
            if (r4 == null) goto L28;
            i98.a r5 = r4.a();     // Catch: Throwable -> L33 Exception -> L35
            if (r5 == null) goto L37;
            DoraEnvObserveDiaryDetailViewModel r6 = this.this$0;     // Catch: Throwable -> L33 Exception -> L35
            FLogger r7 = FLogger.a;     // Catch: Throwable -> L33 Exception -> L35
            String r8 = DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(r6);     // Catch: Throwable -> L33 Exception -> L35
            StringBuilder r10 = new StringBuilder("Received diary detail: id=");     // Catch: Throwable -> L33 Exception -> L35
            r10.append(r5.i());     // Catch: Throwable -> L33 Exception -> L35
            r10.append(", tempField size=");     // Catch: Throwable -> L33 Exception -> L35
            List<String> r0 = r5.d();     // Catch: Throwable -> L33 Exception -> L35
            if (r0 == null) goto L22;
            Integer r11 = Boxing.boxInt(r0.size());     // Catch: Throwable -> L33 Exception -> L35
        L23:
            r10.append(r11);     // Catch: Throwable -> L33 Exception -> L35
            r7.d(r8, r10.toString());     // Catch: Throwable -> L33 Exception -> L35
            String r13 = String.valueOf(r5.i());     // Catch: Throwable -> L33 Exception -> L35
            String r14 = r5.e();     // Catch: Throwable -> L33 Exception -> L35
            String r15 = r5.m();     // Catch: Throwable -> L33 Exception -> L35
            String r16 = r5.k();     // Catch: Throwable -> L33 Exception -> L35
            List<String> r17 = r5.d();     // Catch: Throwable -> L33 Exception -> L35
            l98.b r18 = r5.g();     // Catch: Throwable -> L33 Exception -> L35
            String r19 = r5.l();     // Catch: Throwable -> L33 Exception -> L35
            String r20 = r5.j();     // Catch: Throwable -> L33 Exception -> L35
            Boolean r22 = r5.h();     // Catch: Throwable -> L33 Exception -> L35
            m98.b r21 = r5.f();     // Catch: Throwable -> L33 Exception -> L35
            Integer r12 = r5.b();     // Catch: Throwable -> L33 Exception -> L35
            if (r12 == null) goto L26;
            int r23 = r12.intValue();     // Catch: Throwable -> L33 Exception -> L35
        L27:
            i98.a r24 = new i98.a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, Boxing.boxInt(r23), 8);     // Catch: Throwable -> L33 Exception -> L35
            r6.getDiaryDetailLiveData().postValue(r24);     // Catch: Throwable -> L33 Exception -> L35
            goto L37
        L26:
            r23 = 0;
            goto L27
        L22:
            r11 = null;
        L37:
            DoraEnvObserveDiaryDetailViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L28:
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error loading diary detail: responseBody is null.");     // Catch: Throwable -> L33 Exception -> L35
            goto L37
        L30:
            if ((r3 instanceof com.larus.network.http.f) == false) goto L37;
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error loading diary detail", ((com.larus.network.http.f) r3).d);     // Catch: Throwable -> L33 Exception -> L35
            goto L37
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r26);
            DoraEnvObserveDiaryDetailViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(true));
            JSONObject r25 = new JSONObject();     // Catch: Throwable -> L33 Exception -> L35
            DoraEnvObserveDiaryDetailViewModel r27 = this.this$0;     // Catch: Throwable -> L33 Exception -> L35
            String r28 = this.$diaryId;     // Catch: Throwable -> L33 Exception -> L35
            r25.put("user_id", DoraEnvObserveDiaryDetailViewModel.access$getUserId(r27));     // Catch: Throwable -> L33 Exception -> L35
            r25.put("diary_id", r28);     // Catch: Throwable -> L33 Exception -> L35
            com.larus.dora.api.network.a r29 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L33 Exception -> L35
            this.label = 1;     // Catch: Throwable -> L33 Exception -> L35
            r2 = com.larus.dora.api.network.a.c(r29, i98.b.class, "/alice/wearable/diary/get_diary_detail_v2", r25, null, this, 248);     // Catch: Throwable -> L33 Exception -> L35
            if (r2 != r9) goto L13;
            return r9;
        L33:
            th = move-exception;
            DoraEnvObserveDiaryDetailViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
            throw th;
        L35:
            e = move-exception;
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error loading diary detail", e);     // Catch: Throwable -> L33
            goto L37
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$loadFeedbackConfigIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$loadFeedbackConfigIfNeeded$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public C01031(DoraEnvObserveDiaryDetailViewModel r1, Continuation<? super C01031> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01031(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            Map<String, List<String>> r3 = null;
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L8;
            ResultKt.throwOnFailure(r6);     // Catch: Exception -> L24
        L13:
            dm9.a.b r7 = (dm9.a) r6;     // Catch: Exception -> L24
            if ((r7 instanceof dm9.a.b) == false) goto L20;
            DoraEnvObserveDiaryDetailViewModel r0 = this.this$0;     // Catch: Exception -> L24
            j98.a r8 = (j98.a) r7.a.getData();     // Catch: Exception -> L24
            if (r8 == null) goto L18;
            r3 = r8.a();     // Catch: Exception -> L24
        L18:
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackConfigMap$p(r0, r3);     // Catch: Exception -> L24
            DoraEnvObserveDiaryDetailViewModel.access$refreshSheetReasonOptions(this.this$0);     // Catch: Exception -> L24
        L27:
            return Unit.INSTANCE;
        L20:
            if ((r7 instanceof dm9.a.a) == false) goto L23;
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "loadFeedbackConfigIfNeeded error: " + ((dm9.a.a) r7).b);     // Catch: Exception -> L24
            DoraEnvObserveDiaryDetailViewModel.access$refreshSheetReasonOptions(this.this$0);     // Catch: Exception -> L24
            goto L27
        L23:
            throw new NoWhenBranchMatchedException();     // Catch: Exception -> L24
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
            DoraEnvObserveDiaryFeedbackApi.a r9 = DoraEnvObserveDiaryFeedbackApi.a;     // Catch: Exception -> L24
            DoraEnvObserveDiaryDetailViewModel$loadFeedbackConfigIfNeeded$1$result$1 r4 = new DoraEnvObserveDiaryDetailViewModel$loadFeedbackConfigIfNeeded$1$result$1(null);     // Catch: Exception -> L24
            this.label = 1;     // Catch: Exception -> L24
            r9.getClass();     // Catch: Exception -> L24
            r6 = DoraEnvObserveDiaryFeedbackApi.a.a(r4, this);     // Catch: Exception -> L24
            if (r6 != r1) goto L13;
            return r1;
        L24:
            e = move-exception;
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "loadFeedbackConfigIfNeeded error", e);
            DoraEnvObserveDiaryDetailViewModel.access$refreshSheetReasonOptions(this.this$0);
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$submitFeedback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$submitFeedback$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ String $diaryId;
        final /* synthetic */ j98.f $state;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public C01041(DoraEnvObserveDiaryDetailViewModel r1, String r2, j98.f r3, String r4, Continuation<? super C01041> r5) {
            this.this$0 = r1;
            this.$diaryId = r2;
            this.$state = r3;
            this.$content = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01041(this.this$0, this.$diaryId, this.$state, this.$content, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L8;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L21 Exception -> L23
        L13:
            dm9.a.a r15 = (dm9.a) r14;     // Catch: Throwable -> L21 Exception -> L23
            if ((r15 instanceof dm9.a.b) == false) goto L17;
            DoraEnvObserveDiaryDetailViewModel.access$clearDraft(this.this$0, this.$diaryId, this.$state.b);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$updateDiaryFeedbackActionType(this.this$0, this.$state.b);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_feedbackSheetState$p(this.this$0).setValue(null);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(2131903890, DiaryFeedbackToastType.SUCCESS));     // Catch: Throwable -> L21 Exception -> L23
        L25:
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackRequestInFlight$p(this.this$0, false);
            return Unit.INSTANCE;
        L17:
            if ((r15 instanceof dm9.a.a) == false) goto L20;
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "submitFeedback error: " + r15.b);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_feedbackSheetState$p(this.this$0).setValue(j98.f.a(this.$state, null, null, null, false, 31));     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$syncDiaryFeedbackActionType(this.this$0);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(2131903889, DiaryFeedbackToastType.FAILURE));     // Catch: Throwable -> L21 Exception -> L23
            goto L25
        L20:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L21 Exception -> L23
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
            DoraEnvObserveDiaryFeedbackApi.a r16 = DoraEnvObserveDiaryFeedbackApi.a;     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1 r3 = new DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1(this.$diaryId, this.$state, this.$content, null);     // Catch: Throwable -> L21 Exception -> L23
            this.label = 1;     // Catch: Throwable -> L21 Exception -> L23
            r16.getClass();     // Catch: Throwable -> L21 Exception -> L23
            r14 = DoraEnvObserveDiaryFeedbackApi.a.a(r3, this);     // Catch: Throwable -> L21 Exception -> L23
            if (r14 != r1) goto L13;
            return r1;
        L21:
            th = move-exception;
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackRequestInFlight$p(this.this$0, false);
            throw th;
        L23:
            e = move-exception;
            FLogger.a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "submitFeedback error", e);     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$get_feedbackSheetState$p(this.this$0).setValue(j98.f.a(this.$state, null, null, null, false, 31));     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$syncDiaryFeedbackActionType(this.this$0);     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(2131903889, DiaryFeedbackToastType.FAILURE));     // Catch: Throwable -> L21
            goto L25
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public static /* synthetic */ IDoraPageConfig yo() {
        return doraPageConfig_delegate$lambda$0();
    }

    public final boolean inEnvObserveScene() {
        return b98.b.b(2);
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$0() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    private final String getUserId() {
        String r0 = ILoginService.a.getAccountInfo().d;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    private final void refreshFeedbackActionTypeDisplay() {
        i98.a r0 = (i98.a) this.diaryDetailLiveData.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        this.diaryDetailLiveData.setValue(i98.a.a(r0, null, 4095));
    }

    private final void refreshSheetReasonOptions() {
        j98.f r1 = (j98.f) this._feedbackSheetState.getValue();
        if (r1 != null) goto L5;
        return;
    L5:
        List<String> r2 = j98.d.b(this.feedbackConfigMap, r1.b);
        List<String> r0 = r1.d;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r0.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        if (r2.contains((String) r5) == false) goto L7;
        r3.add(r5);
        goto L7
    L11:
        this._feedbackSheetState.setValue(j98.f.a(r1, r2, r3, null, false, 51));
    }

    private final void syncDiaryFeedbackActionType() {
        i98.a r0 = (i98.a) this.diaryDetailLiveData.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        this.pendingFeedbackActionType = null;
        MutableLiveData<i98.a> r1 = this.diaryDetailLiveData;
        Integer r2 = r0.b();
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        r1.setValue(i98.a.a(r0, Integer.valueOf(r3), 2047));
        return;
    L8:
        r3 = 0;
        goto L9
    }

    private final void trimDraftDiaryCacheIfNeeded() {
    L3:
        if (this.feedbackDraftDiaryIds.size() <= 10) goto L8;
        String r0 = (String) CollectionsKt.firstOrNull(this.feedbackDraftDiaryIds);
        if (r0 == null) goto L6;
        this.feedbackDraftDiaryIds.remove(r0);
        this.feedbackDraftCache.remove(j98.d.a(getUserId(), r0, 1));
        this.feedbackDraftCache.remove(j98.d.a(getUserId(), r0, 2));
        goto L3
    L6:
        return;
    }

    public final void cancelFeedback() {
        String r0 = this.currentDiaryId;
        if (r0 != null) goto L5;
        return;
    L5:
        i98.a r1 = (i98.a) this.diaryDetailLiveData.getValue();
        if (r1 == null) goto L10;
        Integer r2 = r1.b();
        if (r2 == null) goto L10;
        int r3 = r2.intValue();
    L11:
        if (r3 != 0) goto L13;
        return;
    L13:
        if (this.isFeedbackRequestInFlight == true) goto L18;
        this.isFeedbackRequestInFlight = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r0, null), 3, null);
        return;
    L18:
        return;
    L10:
        r3 = 0;
        goto L11
    }

    public final void loadFeedbackConfigIfNeeded() {
        if (this.feedbackConfigMap == null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01031(this, null), 3, null);
    }

    public final void saveDraft() {
        String r0 = this.currentDiaryId;
        if (r0 != null) goto L5;
        return;
    L5:
        j98.f r1 = (j98.f) this._feedbackSheetState.getValue();
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = r1.b;
        if (r2 != 1) goto L11;
    L13:
        String r3 = j98.d.a(getUserId(), r0, r1.b);
        if (r1.d.isEmpty() == true) goto L16;
    L18:
        this.feedbackDraftCache.put(r3, new j98.b(r1.d, r1.e));
    L19:
        syncDraftDiaryState(r0);
        return;
    L16:
        if (StringsKt.isBlank(r1.e) == false) goto L18;
        this.feedbackDraftCache.remove(r3);
        goto L19
    L11:
        if (r2 == 2) goto L13;
    }

    public final void submitFeedback() {
        String r2 = this.currentDiaryId;
        if (r2 != null) goto L5;
        return;
    L5:
        j98.f r9 = (j98.f) this._feedbackSheetState.getValue();
        if (r9 != null) goto L9;
        return;
    L9:
        if (r9.b() == true) goto L12;
        return;
    L12:
        if (this.isFeedbackRequestInFlight == false) goto L14;
        return;
    L14:
        String r0 = r9.e;
        List<String> r1 = j98.d.a;
        Intrinsics.checkNotNullParameter(r0, ChatDraftItem.TYPE_TEXT);
        String r10 = StringsKt.take(StringsKt.trim(r0).toString(), 1000);
        this._feedbackSheetState.setValue(j98.f.a(r9, null, null, null, true, 31));
        this.isFeedbackRequestInFlight = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01041(this, r2, r9, r10, null), 3, null);
    }

    public DoraEnvObserveDiaryDetailViewModel() {
        this.TAG = "DoraEnvObserveDiary";
        this.diaryDetailLiveData = new MutableLiveData();
        MutableLiveData<Boolean> r0 = new MutableLiveData();
        this._isLoading = r0;
        this.isLoading = r0;
        MutableLiveData<j98.f> r1 = new MutableLiveData(null);
        this._feedbackSheetState = r1;
        this.feedbackSheetState = r1;
        MutableLiveData<j98.g> r2 = new MutableLiveData();
        this._toastEffect = r2;
        this.toastEffect = r2;
        this.feedbackDraftCache = new LinkedHashMap();
        this.feedbackDraftDiaryIds = new LinkedHashSet();
        this.doraPageConfig$delegate = LazyKt.lazy(new l0());
    }

    public final boolean isEnvObserveEnable() {
        IDoraPageConfig r0 = getDoraPageConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.d("dora_g_config_key_env_observe_enable", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final MutableLiveData<i98.a> getDiaryDetailLiveData() {
        return this.diaryDetailLiveData;
    }

    public final LiveData<j98.f> getFeedbackSheetState() {
        return this.feedbackSheetState;
    }

    public final LiveData<j98.g> getToastEffect() {
        return this.toastEffect;
    }

    public final LiveData<Boolean> isLoading$dora_avlink_impl_release() {
        return this.isLoading;
    }

    public static final /* synthetic */ String access$getTAG$p(DoraEnvObserveDiaryDetailViewModel r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ String access$getUserId(DoraEnvObserveDiaryDetailViewModel r0) {
        return r0.getUserId();
    }

    public static final /* synthetic */ MutableLiveData access$get_feedbackSheetState$p(DoraEnvObserveDiaryDetailViewModel r0) {
        return r0._feedbackSheetState;
    }

    public static final /* synthetic */ MutableLiveData access$get_isLoading$p(DoraEnvObserveDiaryDetailViewModel r0) {
        return r0._isLoading;
    }

    public static final /* synthetic */ MutableLiveData access$get_toastEffect$p(DoraEnvObserveDiaryDetailViewModel r0) {
        return r0._toastEffect;
    }

    public static final /* synthetic */ void access$refreshSheetReasonOptions(DoraEnvObserveDiaryDetailViewModel r0) {
        r0.refreshSheetReasonOptions();
    }

    public static final /* synthetic */ void access$syncDiaryFeedbackActionType(DoraEnvObserveDiaryDetailViewModel r0) {
        r0.syncDiaryFeedbackActionType();
    }

    private final void clearFeedbackStateForNewDiary(String r2) {
        this.currentDiaryId = r2;
        this.pendingFeedbackActionType = null;
        this._feedbackSheetState.postValue(null);
        this.isFeedbackRequestInFlight = false;
    }

    private final boolean hasDraftForDiary(String r5) {
        if (this.feedbackDraftCache.containsKey(j98.d.a(getUserId(), r5, 1)) == false) goto L5;
        return true;
    L5:
        if (this.feedbackDraftCache.containsKey(j98.d.a(getUserId(), r5, 2)) == true) goto L10;
        return false;
    L10:
        return true;
    }

    private final void syncDraftDiaryState(String r2) {
        if (hasDraftForDiary(r2) == false) goto L5;
        touchDraftDiary(r2);
        return;
    L5:
        this.feedbackDraftDiaryIds.remove(r2);
    }

    private final void touchDraftDiary(String r2) {
        this.feedbackDraftDiaryIds.remove(r2);
        this.feedbackDraftDiaryIds.add(r2);
        trimDraftDiaryCacheIfNeeded();
    }

    private final void updateDiaryFeedbackActionType(int r4) {
        i98.a r0 = (i98.a) this.diaryDetailLiveData.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        this.pendingFeedbackActionType = null;
        this.diaryDetailLiveData.setValue(i98.a.a(r0, Integer.valueOf(r4), 2047));
    }

    public final void fetchDiaryDetail(String r8) {
        Intrinsics.checkNotNullParameter(r8, "diaryId");
        if (Intrinsics.areEqual(this.currentDiaryId, r8) == true) goto L5;
        clearFeedbackStateForNewDiary(r8);
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01021(this, r8, null), 2, null);
    }

    public final int getDisplayedFeedbackActionType(int r2) {
        Integer r0 = this.pendingFeedbackActionType;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0.intValue();
    }

    public final void onFeedbackSheetDismissed(long r7) {
        j98.f r0 = (j98.f) this._feedbackSheetState.getValue();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == true) goto L10;
        return;
    L10:
        saveDraft();
        if (r0 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == true) goto L19;
        this._feedbackSheetState.setValue(null);
        syncDiaryFeedbackActionType();
        return;
    L19:
        return;
    L13:
        if (r0.f != true) goto L15;
    L5:
        if (r0.a != r7) goto L7;
        r8 = true;
        goto L8
    }

    public final void previewFeedbackActionType(int r1) {
        this.pendingFeedbackActionType = Integer.valueOf(r1);
        refreshFeedbackActionTypeDisplay();
    }

    public final void updateInputText(String r8) {
        Intrinsics.checkNotNullParameter(r8, "inputText");
        j98.f r1 = (j98.f) this._feedbackSheetState.getValue();
        if (r1 != null) goto L5;
        return;
    L5:
        this._feedbackSheetState.setValue(j98.f.a(r1, null, null, r8, false, 47));
    }

    public final void updateSelectedReasons(List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "selectedReasons");
        j98.f r1 = (j98.f) this._feedbackSheetState.getValue();
        if (r1 != null) goto L5;
        return;
    L5:
        this._feedbackSheetState.setValue(j98.f.a(r1, null, CollectionsKt.distinct(r8), null, false, 55));
    }

    public static final /* synthetic */ void access$setFeedbackConfigMap$p(DoraEnvObserveDiaryDetailViewModel r0, Map r1) {
        r0.feedbackConfigMap = r1;
    }

    public static final /* synthetic */ void access$setFeedbackRequestInFlight$p(DoraEnvObserveDiaryDetailViewModel r0, boolean r1) {
        r0.isFeedbackRequestInFlight = r1;
    }

    public static final /* synthetic */ void access$updateDiaryFeedbackActionType(DoraEnvObserveDiaryDetailViewModel r0, int r1) {
        r0.updateDiaryFeedbackActionType(r1);
    }

    private final void clearDraft(String r3, int r4) {
        this.feedbackDraftCache.remove(j98.d.a(getUserId(), r3, r4));
        syncDraftDiaryState(r3);
    }

    public final void openFeedbackSheet(int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "diaryId");
        if (r11 != 1) goto L5;
    L7:
        this.currentDiaryId = r12;
        j98.b r1 = this.feedbackDraftCache.get(j98.d.a(getUserId(), r12, r11));
        if (r1 != null) goto L11;
        r1 = new j98.b(0);
    L11:
        if ((!r1.a.isEmpty()) == false) goto L13;
    L14:
        touchDraftDiary(r12);
    L15:
        this._feedbackSheetState.setValue(new j98.f(System.nanoTime(), r11, j98.d.b(this.feedbackConfigMap, r11), r1.a, r1.b, false));
        loadFeedbackConfigIfNeeded();
        return;
    L13:
        if ((true ^ StringsKt.isBlank(r1.b)) == false) goto L15;
    L5:
        if (r11 == 2) goto L7;
    }

    public static final /* synthetic */ void access$clearDraft(DoraEnvObserveDiaryDetailViewModel r0, String r1, int r2) {
        r0.clearDraft(r1, r2);
    }

    public final void deleteDiary(Context r13, String r14, Function0<Unit> r15) {
        Intrinsics.checkNotNullParameter(r14, "diaryId");
        Intrinsics.checkNotNullParameter(r15, "onSuccess");
        FLogger.a.i(this.TAG, "deleteDiary from detail: " + r14);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01011(this, r14, r15, r13, null), 2, null);
    }
}
