package com.larus.chat.job.impl.page;

import androidx.lifecycle.ViewModel;
import com.larus.chat.job.impl.experiment.ChatJobLarkEventSettings;
import com.larus.im.bean.job.AIJob;
import com.larus.im.bean.job.AIJobRequestType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.job.AIJobServiceImpl;
import com.larus.im.service.IAIJobService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\t\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ \u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020\u001aJ8\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u001e\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0(\u0012\u0004\u0012\u00020\u00140'H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+H\u0002J$\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0-2\u0006\u00100\u001a\u00020\u0010H\u0002J4\u00101\u001a\u00020\u00142\f\u00102\u001a\b\u0012\u0004\u0012\u00020.032\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0-H\u0002J\u0010\u00106\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\"\u001a\u0004\u0018\u00010\u001a*\u00020\u001d2\u0006\u0010#\u001a\u00020\u001aH\u0002J\u0010\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u001aH\u0002J\b\u00109\u001a\u00020\u0014H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/chat/job/impl/page/ChatJobListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "aiJobService", "Lcom/larus/im/service/IAIJobService;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/chat/job/impl/page/ChatJobListUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loader", "Lcom/larus/chat/job/impl/page/ChatJobListLoader;", "isCleared", "", "isLarkEventEnabled", "settingsUpdateListener", "Lkotlin/Function0;", "", "retry", "refresh", "refreshByPull", "loadMoreLocalJobs", "reason", "", "pauseJob", "job", "Lcom/larus/im/bean/job/AIJob;", "resumeJob", "runJob", "onSuccess", "deleteJob", "resolveRecommendPrompt", "jobTemplateId", "mutateJob", "action", "request", "Lkotlin/Function2;", "Lcom/larus/im/callback/IIMCallback;", "render", "snapshot", "Lcom/larus/chat/job/impl/page/ChatJobListLoadSnapshot;", "buildItems", "", "Lcom/larus/chat/job/impl/page/ChatJobListItem;", "jobs", "showRecommendJobs", "appendSection", "result", "", "key", "title", "isVisibleRecommendJob", "shouldHandleCallback", "operation", "onCleared", "JobCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobListViewModel extends ViewModel {
    private static final String ACTION_PAUSE = "pause";
    private static final String ACTION_RESUME = "resume";
    private static final a Companion = null;
    private static final int EMPTY_JOB_RESPONSE_CODE = -103;
    private static final String EMPTY_JOB_RESPONSE_TIPS = "data.job is empty";
    private static final int RECOMMEND_STATUS_VISIBLE = 1;
    private static final String TAG = "ChatJobListViewModel";
    private final z0<y> _uiState;
    private final IAIJobService aiJobService;
    private boolean isCleared;
    private boolean isLarkEventEnabled;
    private final ChatJobListLoader loader;
    private final Function0<Unit> settingsUpdateListener;
    private final i1<y> uiState;

    public static final class a {
        public a() {
        }

        public static String c(String r1) {
            String r2 = StringsKt.takeLast(r1, 6);
            if (StringsKt.isBlank(r2) == false) goto L6;
            return "blank";
        L6:
            return r2;
        }

        public static final String a(a r1, AIJob r2) {
            r1.getClass();
            return "id=" + c(r2.getJobId()) + ",type=" + r2.getJobType() + ",status=" + r2.getStatus() + ",contentLength=" + r2.getContent().length() + ",extLength=" + r2.getExt().length();
        }

        public static final String b(a r1, IIMError r2) {
            r1.getClass();
            StringBuilder r3 = new StringBuilder("code=");
            r3.append(r2.getCode());
            r3.append(" tips=");
            r3.append(r2.getTips());
            r3.append(" exception=");
            Throwable r4 = r2.getException();
            if (r4 == null) goto L5;
            String r5 = r4.getClass().getSimpleName();
        L6:
            r3.append(r5);
            return r3.toString();
        L5:
            r5 = null;
            goto L6
        }
    }

    public final class b implements IIMCallback<AIJob> {
        public final String a;
        public final AIJob b;
        public final /* synthetic */ ChatJobListViewModel c;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r8) {
            Intrinsics.checkNotNullParameter(r8, "error");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.c, "mutateJob failure") == true) goto L5;
            return;
        L5:
            FLogger r0 = FLogger.a;
            r0.e(ChatJobListViewModel.TAG, "mutateJob failed action=" + this.a + " source=" + a.a(ChatJobListViewModel.access$getCompanion$p(), this.b) + ' ' + a.b(ChatJobListViewModel.access$getCompanion$p(), r8));
            gz8.h.b(r8);
            ChatJobListViewModel.access$getCompanion$p().getClass();
            boolean r4 = false;
            if (r8.getCode() != ChatJobListViewModel.EMPTY_JOB_RESPONSE_CODE) goto L15;
            String r9 = r8.getTips();
            if (r9 != null) goto L10;
        L12:
            boolean r10 = false;
        L13:
            if (r10 == false) goto L15;
            r4 = true;
            goto L15
        L10:
            if (StringsKt.contains$default(r9, ChatJobListViewModel.EMPTY_JOB_RESPONSE_TIPS, false, 2, null) != true) goto L12;
            r10 = true;
        L15:
            if (r4 == false) goto L18;
            ChatJobListLoader r11 = ChatJobListViewModel.access$getLoader$p(this.c);
            String r1 = this.a;
            AIJob r3 = this.b;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r1, "action");
            Intrinsics.checkNotNullParameter(r3, "sourceJob");
            StringBuilder r5 = new StringBuilder("mutateJob empty job response, sync job chain action=");
            r5.append(r1);
            r5.append(" source=");
            int r2 = ChatJobListLoader.t;
            r5.append(ChatJobListLoader.a.c(r3));
            r0.i("ChatJobListLoader", r5.toString());
            r11.a.pullJobChain(100, new x(r1, r11));
            return;
        }

        public final void onSuccess(Object r10) {
            AIJob r11 = (AIJob) r10;
            Intrinsics.checkNotNullParameter(r11, "result");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.c, "mutateJob success") == false) goto L31;
            FLogger.a.i(ChatJobListViewModel.TAG, "mutateJob success action=" + this.a + " source=" + a.a(ChatJobListViewModel.access$getCompanion$p(), this.b) + " result=" + a.a(ChatJobListViewModel.access$getCompanion$p(), r11));
            ChatJobListLoader r0 = ChatJobListViewModel.access$getLoader$p(this.c);
            StringBuilder r1 = new StringBuilder("mutate:");
            r1.append(this.a);
            String r2 = r1.toString();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r2, "reason");
            Intrinsics.checkNotNullParameter(r11, "job");
            Iterator<T> r3 = r0.f.iterator();
        L6:
            String r4 = null;
            if (r3.hasNext() == false) goto L11;
            Object r5 = r3.next();
            if (Intrinsics.areEqual(((AIJob) r5).getJobId(), r11.getJobId()) == false) goto L6;
        L12:
            AIJob r6 = (AIJob) r5;
            List<AIJob> r7 = r0.f;
            ArrayList r8 = new ArrayList();
            Iterator<T> r9 = r7.iterator();
        L14:
            if (r9.hasNext() == false) goto L18;
            Object r12 = r9.next();
            if (Intrinsics.areEqual(((AIJob) r12).getJobId(), r11.getJobId()) == true) goto L14;
            r8.add(r12);
            goto L14
        L18:
            List<AIJob> r13 = CollectionsKt.plus(r8, r11);
            FLogger r14 = FLogger.a;
            StringBuilder r15 = new StringBuilder("applyLocalJob reason=");
            r15.append(r2);
            r15.append(" old=");
            int r16 = ChatJobListLoader.t;
            if (r6 == null) goto L21;
            r4 = ChatJobListLoader.a.c(r6);
        L21:
            r15.append(r4);
            r15.append(" new=");
            r15.append(ChatJobListLoader.a.c(r11));
            r15.append(" before=");
            r15.append(ChatJobListLoader.a.b(r0.f));
            r15.append(" after=");
            r15.append(ChatJobListLoader.a.b(r13));
            r14.i("ChatJobListLoader", r15.toString());
            r0.f = r13;
            r0.d();
            return;
        L11:
            r5 = null;
            goto L12
        }

        public b(ChatJobListViewModel r2, String r3, AIJob r4) {
            Intrinsics.checkNotNullParameter(r3, "action");
            Intrinsics.checkNotNullParameter(r4, "sourceJob");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((AIJob) r4).getCreateTime()), Long.valueOf(((AIJob) r3).getCreateTime()));
        }
    }

    public static final class d implements IIMCallback<Boolean> {
        public final /* synthetic */ ChatJobListViewModel a;
        public final /* synthetic */ AIJob b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.a, "deleteJob failure") == true) goto L5;
            return;
        L5:
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("deleteJob failed jobId=");
            a r2 = ChatJobListViewModel.access$getCompanion$p();
            String r3 = this.b.getJobId();
            r2.getClass();
            r1.append(a.c(r3));
            r1.append(' ');
            r1.append(a.b(ChatJobListViewModel.access$getCompanion$p(), r5));
            r0.e(ChatJobListViewModel.TAG, r1.toString());
            gz8.h.b(r5);
        }

        public final void onSuccess(Object r5) {
            boolean r6 = ((Boolean) r5).booleanValue();
            if (ChatJobListViewModel.access$shouldHandleCallback(this.a, "deleteJob success") == false) goto L10;
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("deleteJob success result=");
            r1.append(r6);
            r1.append(" jobId=");
            a r2 = ChatJobListViewModel.access$getCompanion$p();
            String r3 = this.b.getJobId();
            r2.getClass();
            r1.append(a.c(r3));
            r0.i(ChatJobListViewModel.TAG, r1.toString());
            if (r6 == true) goto L9;
            gz8.h.a();
            return;
        L9:
            return;
        }

        public d(ChatJobListViewModel r1, AIJob r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements IIMCallback<AIJob> {
        public final /* synthetic */ ChatJobListViewModel a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ AIJob c;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.a, "runJob failure") == true) goto L5;
            return;
        L5:
            FLogger.a.e(ChatJobListViewModel.TAG, "runJob failed job=" + a.a(ChatJobListViewModel.access$getCompanion$p(), this.c) + ' ' + a.b(ChatJobListViewModel.access$getCompanion$p(), r5));
            gz8.h.b(r5);
        }

        public final void onSuccess(Object r4) {
            AIJob r5 = (AIJob) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.a, "runJob success") == false) goto L10;
            FLogger.a.i(ChatJobListViewModel.TAG, "runJob success job=" + a.a(ChatJobListViewModel.access$getCompanion$p(), r5));
            Function0<Unit> r6 = this.b;
            if (r6 == null) goto L9;
            r6.invoke();
            return;
        L9:
            return;
        }

        public e(ChatJobListViewModel r1, Function0<Unit> r2, AIJob r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(ChatJobListViewModel r0, AIJob r1, String r2, IIMCallback r3) {
        return pauseJob$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ String No(ChatJobListViewModel r0, String r1, i.a r2) {
        return resolveRecommendPrompt$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ boolean Oo(i.a r0) {
        return resolveRecommendPrompt$lambda$4(r0);
    }

    public static /* synthetic */ Unit Po(ChatJobListViewModel r0) {
        return settingsUpdateListener$lambda$0(r0);
    }

    public static /* synthetic */ Unit yo(ChatJobListViewModel r0, AIJob r1, String r2, IIMCallback r3) {
        return resumeJob$lambda$2(r0, r1, r2, r3);
    }

    public void onCleared() {
        this.isCleared = true;
        z2.a.p3(this.settingsUpdateListener);
        this.aiJobService.unregisterObserver(this.loader);
        super.onCleared();
    }

    public final void refresh() {
        this.loader.k(false);
    }

    public final void refreshByPull() {
        ChatJobListLoader r0 = this.loader;
        if (r0.c().b == false) goto L5;
    L8:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("pull refresh skipped loading=");
        r2.append(r0.c().b);
        r2.append(" pullRefreshRequests=");
        Set<? extends AIJobRequestType> r3 = r0.k;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.add(((AIJobRequestType) r5.next()).name());
        goto L10
    L12:
        r2.append(r4);
        r1.i("ChatJobListLoader", r2.toString());
        return;
    L5:
        if ((!r0.k.isEmpty()) == true) goto L8;
        r0.k(true);
    }

    public final void retry() {
        this.loader.k(false);
    }

    public ChatJobListViewModel() {
        int r0 = com.larus.im.d.a;
        AIJobServiceImpl r1 = AIJobServiceImpl.INSTANCE;
        this.aiJobService = r1;
        StateFlowImpl r2 = j1.a(new y(0));
        this._uiState = r2;
        this.uiState = r2;
        ChatJobListLoader r3 = new ChatJobListLoader(r1, new ChatJobListViewModel$loader$1(this));
        this.loader = r3;
        int r4 = g0.a;
        ChatJobLarkEventSettings.a.getClass();
        this.isLarkEventEnabled = ChatJobLarkEventSettings.a();
        Function0<Unit> r5 = new c0(this);
        this.settingsUpdateListener = r5;
        r1.registerObserver(r3);
        z2.a.i2(r5);
        r3.k(false);
    }

    public static final /* synthetic */ a access$getCompanion$p() {
        return Companion;
    }

    public final i1<y> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ ChatJobListLoader access$getLoader$p(ChatJobListViewModel r0) {
        return r0.loader;
    }

    private final boolean isVisibleRecommendJob(AIJob r2) {
        if (r2.getStatus() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final void render(j r9) {
        if (this.isCleared == false) goto L5;
        return;
    L5:
        List<i> r3 = buildItems(r9.a, r9.e);
        z0<y> r0 = this._uiState;
        boolean r4 = r9.b;
        boolean r5 = r9.c;
        if (r4 == true) goto L11;
        if (r5 == true) goto L11;
        if (r3.isEmpty() == false) goto L11;
        boolean r6 = true;
    L12:
        r0.setValue(new y(r3, r4, r5, r6, r9.d));
        return;
    L11:
        r6 = false;
        goto L12
    }

    private static final boolean resolveRecommendPrompt$lambda$4(i.a r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.b;
    }

    private static final Unit settingsUpdateListener$lambda$0(ChatJobListViewModel r4) {
        if (r4.isCleared == true) goto L8;
        int r0 = g0.a;
        ChatJobLarkEventSettings.a.getClass();
        boolean r1 = ChatJobLarkEventSettings.a();
        if (r4.isLarkEventEnabled == r1) goto L8;
        r4.isLarkEventEnabled = r1;
        FLogger.a.i(TAG, "lark event settings changed enabled=" + r1);
        r4.loader.d();
    L8:
        return Unit.INSTANCE;
    }

    private final boolean shouldHandleCallback(String r4) {
        if (this.isCleared == true) goto L6;
        return true;
    L6:
        FLogger.a.i(TAG, "skip " + r4 + " callback after onCleared");
        return false;
    }

    public final void deleteJob(AIJob r5) {
        Intrinsics.checkNotNullParameter(r5, "job");
        if (g0.c(r5) == true) goto L6;
        FLogger.a.i(TAG, "deleteJob skipped: unavailable task type=" + r5.getJobType());
        return;
    L6:
        FLogger.a.i(TAG, "deleteJob job=" + a.a(Companion, r5));
        this.aiJobService.deleteJob(r5.getJobId(), r5.getJobType(), new d(this, r5));
    }

    public final void loadMoreLocalJobs(String r11) {
        Intrinsics.checkNotNullParameter(r11, "reason");
        ChatJobListLoader r1 = this.loader;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "reason");
        boolean r0 = r1.c;
        if (r0 == true) goto L5;
    L20:
        boolean r4 = false;
    L21:
        if (r4 == false) goto L23;
        r1.i(r11);
        return;
    L23:
        if (r0 == true) goto L25;
        return;
    L25:
        if (r1.d == false) goto L27;
        return;
    L27:
        if (r1.i == true) goto L29;
        return;
    L29:
        if (r1.g == true) goto L47;
        ChatJobListLoader.b r2 = r1.j;
        String r5 = null;
        if (r2 == null) goto L37;
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("loadMoreLocalJobs query jobType=");
        r7.append(r2.a);
        r7.append(" status=");
        r7.append(r2.b);
        r7.append(" anchorCreateTime=");
        r7.append(r2.c);
        r7.append(" anchorJobId=");
        String r8 = r2.d;
        if (r8 == null) goto L36;
        int r9 = ChatJobListLoader.t;
        r5 = ChatJobListLoader.a.e(r8);
    L36:
        r7.append(r5);
        r6.i("ChatJobListLoader", r7.toString());
    L38:
        if (r2 != null) goto L40;
        r1.i = false;
        FLogger.a.i("ChatJobListLoader", "loadMoreLocalJobs skipped, no anchor reason=" + r11);
        return;
    L40:
        r1.g = true;
        r1.h(r11, r2, true, true, true, null);
        return;
    L37:
        r2 = null;
        goto L38
    L47:
        return;
    L5:
        if (r1.d == true) goto L20;
        if (r1.i == true) goto L20;
        if (r1.g == true) goto L20;
        if (r1.n == true) goto L13;
    L17:
        boolean r10 = false;
    L18:
        if (r10 == false) goto L20;
        r4 = true;
        goto L21
    L13:
        if (r1.o == true) goto L17;
        if (r1.p == true) goto L17;
        r10 = true;
        goto L18
    }

    public final void pauseJob(final AIJob r3) {
        Intrinsics.checkNotNullParameter(r3, "job");
        mutateJob(ACTION_PAUSE, r3, new z(this, r3));
    }

    public final String resolveRecommendPrompt(String r3) {
        Intrinsics.checkNotNullParameter(r3, "jobTemplateId");
        final String r4 = StringsKt.trim(r3).toString();
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r4 = null;
    L10:
        if (r4 != null) goto L12;
        return null;
    L12:
        Sequence r1 = SequencesKt.filter(CollectionsKt.asSequence(((y) this._uiState.getValue()).a), ChatJobListViewModel$resolveRecommendPrompt$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(r1, new a0()), new b0(this, r4)));
    L5:
        r0 = false;
        goto L7
    }

    public final void resumeJob(final AIJob r3) {
        Intrinsics.checkNotNullParameter(r3, "job");
        mutateJob(ACTION_RESUME, r3, new d0(this, r3));
    }

    public static final /* synthetic */ void access$render(ChatJobListViewModel r0, j r1) {
        r0.render(r1);
    }

    public static final /* synthetic */ boolean access$shouldHandleCallback(ChatJobListViewModel r0, String r1) {
        return r0.shouldHandleCallback(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.chat.job.impl.page.ChatJobListViewModel] */
    private final List<i> buildItems(List<AIJob> r10, boolean r11) {
        List<AIJob> r12 = r10;
        int r0 = g0.a;
        ArrayList r1 = new ArrayList();
        Iterator r2 = r12.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (g0.c((AIJob) r3) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList();
        Iterator r13 = r12.iterator();
    L9:
        boolean r5 = false;
        if (r13.hasNext() == false) goto L16;
        Object r6 = r13.next();
        if (((AIJob) r6).getJobType() != 2) goto L14;
        r5 = true;
    L14:
        if (r5 == false) goto L9;
        r4.add(r6);
        goto L9
    L16:
        if (r11 == false) goto L23;
        ?? r14 = new ArrayList();
        Iterator r15 = r4.iterator();
    L19:
        if (r15.hasNext() == false) goto L24;
        Object r7 = r15.next();
        if (isVisibleRecommendJob((AIJob) r7) == false) goto L19;
        r14.add(r7);
    L24:
        ArrayList r16 = new ArrayList();
        ArrayList r8 = new ArrayList();
        Iterator r9 = r1.iterator();
    L26:
        if (r9.hasNext() == false) goto L36;
        Object r17 = r9.next();
        AIJob r18 = (AIJob) r17;
        if (r18.getStatus() != 1) goto L30;
    L33:
        boolean r19 = true;
    L34:
        if (r19 == false) goto L26;
        r8.add(r17);
        goto L26
    L30:
        if (r18.getStatus() == (-1)) goto L33;
        r19 = false;
        goto L34
    L36:
        ArrayList r20 = new ArrayList();
        Iterator r21 = r1.iterator();
    L38:
        if (r21.hasNext() == false) goto L45;
        Object r22 = r21.next();
        if (((AIJob) r22).getStatus() != 2) goto L42;
        boolean r23 = true;
    L43:
        if (r23 == false) goto L38;
        r20.add(r22);
        goto L38
    L42:
        r23 = false;
        goto L43
    L45:
        ArrayList r24 = new ArrayList();
        Iterator r25 = r1.iterator();
    L47:
        if (r25.hasNext() == false) goto L54;
        Object r26 = r25.next();
        if (((AIJob) r26).getStatus() != 3) goto L51;
        boolean r27 = true;
    L52:
        if (r27 == false) goto L47;
        r24.add(r26);
        goto L47
    L51:
        r27 = false;
        goto L52
    L54:
        appendSection(r16, "running", gz8.f.b("scheduledTasks_header_ongoing"), r8);
        appendSection(r16, "paused", gz8.f.b("scheduledTasks_header_paused"), r20);
        appendSection(r16, "completed", gz8.f.b("scheduledTasks_header_completed"), r24);
        appendSection(r16, "recommend", gz8.f.b("scheduledTasks_header_recommended"), r14);
        return r16;
    L23:
        r14 = CollectionsKt.emptyList();
        goto L24
    }

    private final String resolveRecommendPrompt(AIJob r6, String r7) {
        boolean r2 = true;
        if (r6.getStatus() == 1) goto L29;
        return null;
    L29:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(new JSONObject(r6.getContent()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = null;
    L12:
        JSONObject r3 = (JSONObject) r1;
        if (r3 == null) goto L31;
        JSONObject r4 = r3.optJSONObject("recommend_job");
        if (r4 == null) goto L32;
        String r5 = r4.optString("job_id");
        if (StringsKt.isBlank(r5) == false) goto L20;
        r5 = r6.getJobId();
    L20:
        if (Intrinsics.areEqual(r5, r7) == true) goto L22;
        return null;
    L22:
        String r8 = StringsKt.trim(r4.optString("prompt")).toString();
        if (r8.length() > 0) goto L26;
        r2 = false;
    L26:
        if (r2 == true) goto L28;
        return null;
    L28:
        return r8;
    L32:
        return null;
    L31:
        return null;
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void runJob(AIJob r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "job");
        if (r5.getJobType() == 1) goto L6;
        FLogger.a.i(TAG, "runJob skipped: unsupported type=" + r5.getJobType());
        return;
    L6:
        FLogger.a.i(TAG, "runJob request job=" + a.a(Companion, r5) + " currentStatuses=" + ChatJobListLoader.a.b(this.loader.f));
        this.aiJobService.runJob(r5.getJobId(), new e(this, r6, r5));
    }

    private final void mutateJob(String r5, AIJob r6, Function2<? super String, ? super IIMCallback<AIJob>, Unit> r7) {
        if (g0.c(r6) == true) goto L6;
        FLogger.a.i(TAG, "mutateJob skipped: unavailable task type=" + r6.getJobType());
        return;
    L6:
        FLogger.a.i(TAG, "mutateJob request action=" + r5 + " job=" + a.a(Companion, r6) + " currentStatuses=" + ChatJobListLoader.a.b(this.loader.f));
        r7.invoke(r6.getJobId(), new b(this, r5, r6));
    }

    private static final String resolveRecommendPrompt$lambda$5(ChatJobListViewModel r1, String r2, i.a r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return r1.resolveRecommendPrompt(r3.a, r2);
    }

    private final void appendSection(List<i> r4, String r5, String r6, List<AIJob> r7) {
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        List<i> r8 = r4;
        r8.add(new i.b(r5, r6));
        List r9 = CollectionsKt.sortedWith(r7, new c());
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r10.add(new i.a((AIJob) r11.next(), Intrinsics.areEqual(r5, "recommend")));
        goto L7
    L9:
        CollectionsKt.addAll(r8, r10);
    }

    private static final Unit pauseJob$lambda$1(ChatJobListViewModel r1, AIJob r2, String r3, IIMCallback r4) {
        Intrinsics.checkNotNullParameter(r3, "jobId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r1.aiJobService.pauseJob(r3, r2.getJobType(), r4);
        return Unit.INSTANCE;
    }

    private static final Unit resumeJob$lambda$2(ChatJobListViewModel r1, AIJob r2, String r3, IIMCallback r4) {
        Intrinsics.checkNotNullParameter(r3, "jobId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r1.aiJobService.resumeJob(r3, r2.getJobType(), r4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void runJob$default(ChatJobListViewModel r0, AIJob r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.runJob(r1, r2);
    }
}
