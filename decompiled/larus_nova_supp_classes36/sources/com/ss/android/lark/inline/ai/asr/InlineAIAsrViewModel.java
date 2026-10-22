package com.ss.android.lark.inline.ai.asr;

import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.larksuite.arch.jack.j;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.AbsInlineAIViewModel;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.api.Templates;
import com.ss.android.lark.inline.ai.logic.InlineAIRustPbWrapper;
import com.ss.android.lark.inline.ai.logic.InlineAIStatus;
import com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter;
import com.ss.android.lark.inline.ai.utils.StringUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;
import slb.h;
import slb.k;
import slb.l;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\f\u0018\u0000 =2\u00020\u0001:\u0002=>B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H\u0016J\u0014\u0010\u0019\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$J2\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020\u0015J\u0016\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nJ\u0012\u0010/\u001a\u000200*\u0002002\u0006\u00101\u001a\u00020\nJ\u0018\u00102\u001a\u0002002\u0006\u00103\u001a\u0002002\u0006\u00101\u001a\u00020\nH\u0002J\u000e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001bH\u0002J\u000e\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\bH\u0002J\b\u0010;\u001a\u000200H\u0014J\u0006\u0010<\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/InlineAIAsrViewModel;", "Lcom/ss/android/lark/inline/ai/AbsInlineAIViewModel;", "inlineAIParams", "Lcom/ss/android/lark/inline/ai/api/InlineAIParams;", "<init>", "(Lcom/ss/android/lark/inline/ai/api/InlineAIParams;)V", "errorCodeFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "cancelFlow", "", "pushListener", "com/ss/android/lark/inline/ai/asr/InlineAIAsrViewModel$pushListener$1", "Lcom/ss/android/lark/inline/ai/asr/InlineAIAsrViewModel$pushListener$1;", "pushHandler", "Lcom/ss/android/lark/inline/ai/logic/push/InlineAIPushHandler;", "compatPushListener", "Lcom/ss/android/lark/inline/ai/api/IInlineAIRustInterface$IInlineAIPushListener;", "scenario", "Lcom/ss/android/lark/inline/ai/api/ScenarioType;", "init", "", "getErrorCodeFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getCancelFlow", "showPanel", "promptGroups", "", "Lcom/ss/android/lark/inline/ai/api/PromptGroup;", "hidePanel", "startNewTaskForSubPrompt", "prompt", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "startNewTask", "", "userInputText", "Lcom/ss/android/lark/inline/ai/logic/UserInputText;", "sendPromptInternal", "conversationId", "taskId", "promptConfirmOptions", "Lcom/ss/android/lark/inline/ai/api/PromptConfirmOptions;", "cancelCurrentTask", "onTaskPush", "data", "Lcom/bytedance/lark/pb/space/doc/v1/InlineAITaskStatus;", "forceUpdate", "nextStateOnCancel", "Lcom/ss/android/lark/inline/ai/logic/InlineAIState;", "isError", "testState", "state", "getTnsBlockButtons", "Lcom/ss/android/lark/inline/ai/api/OperateButton;", "fillTemplateList", "templates", "Lcom/ss/android/lark/inline/ai/api/Templates;", "emitErrorCode", "errorCode", "defaultState", "onDestroy", "Companion", "TaskStatus", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InlineAIAsrViewModel extends AbsInlineAIViewModel {
    public static final a Companion = null;
    public static final String DEBUG_BUTTON_KEY = "debug";
    private static final String EXIT_BUTTON_KEY = "exit";
    public static final String REPLACE_BUTTON_KEY = "replace";
    private static final String TAG = "InlineAIAsrViewModel";
    private final MutableSharedFlow<Boolean> cancelFlow;
    private final slb.d.a compatPushListener;
    private final MutableSharedFlow<Integer> errorCodeFlow;
    private final slb.g inlineAIParams;
    private final com.ss.android.lark.inline.ai.logic.push.a pushHandler;
    private final b pushListener;
    private ScenarioType scenario;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements slb.d.a {
        public final /* synthetic */ InlineAIAsrViewModel a;

        public b(InlineAIAsrViewModel r1) {
            this.a = r1;
        }

        @Override // slb.d.a
        public final void a(InlineAITaskStatus r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a.onTaskPush(r2, r3);
        }
    }

    static {
        Companion = new a();
    }

    private final List<h> getTnsBlockButtons() {
        StringUtils.a.getClass();
        return CollectionsKt.listOf(new h(EXIT_BUTTON_KEY, StringUtils.d(2131889161), new C03871(this)));
    }

    public final void cancelCurrentTask() {
        Log.i(TAG, "cancelCurrentTask()...");
        setState(new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public com.ss.android.lark.inline.ai.logic.f m833defaultState() {
        return new com.ss.android.lark.inline.ai.logic.f(null, 127);
    }

    @Override // com.ss.android.lark.inline.ai.AbsInlineAIViewModel
    public d1<Boolean> getCancelFlow() {
        return kotlinx.coroutines.flow.e.a(this.cancelFlow);
    }

    public final d1<Integer> getErrorCodeFlow() {
        return kotlinx.coroutines.flow.e.a(this.errorCodeFlow);
    }

    public final void hidePanel() {
        Log.i(TAG, "hidePanel()...");
        setState(C03881.INSTANCE);
    }

    public final void init() {
        List<slb.d.a> r0 = InlineAIRustPbWrapper.a;
        slb.d.a r1 = this.compatPushListener;
        Intrinsics.checkNotNullParameter(r1, "listener");
        ArrayList r2 = (ArrayList) InlineAIRustPbWrapper.a;
        if (r2.contains(r1) == true) goto L6;
        r2.add(r1);
        return;
    }

    public final void onDestroy() {
        setState(C03891.INSTANCE);
        List<slb.d.a> r0 = InlineAIRustPbWrapper.a;
        b r1 = this.pushListener;
        Intrinsics.checkNotNullParameter(r1, "listener");
        ((ArrayList) InlineAIRustPbWrapper.a).remove(r1);
    }

    public /* bridge */ /* synthetic */ j defaultState() {
        return m833defaultState();
    }

    public InlineAIAsrViewModel(slb.g r5) {
        Intrinsics.checkNotNullParameter(r5, "inlineAIParams");
        this.inlineAIParams = r5;
        this.errorCodeFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.cancelFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        b r6 = new b(this);
        this.pushListener = r6;
        com.ss.android.lark.inline.ai.logic.push.a r0 = new com.ss.android.lark.inline.ai.logic.push.a(r6);
        if (idb.f.a().isCurrentEnable(AbsInlineAIViewModel.ENABLE_SMOOTH_PRINT) == false) goto L5;
        r0.b(new SmoothOutputFilter(this));
    L5:
        this.pushHandler = r0;
        slb.d.a r7 = r6;
        if (idb.f.a().isCurrentEnable(AbsInlineAIViewModel.ENABLE_SMOOTH_PRINT) == false) goto L8;
        r7 = r0;
    L8:
        this.compatPushListener = r7;
        ScenarioType r8 = InlineAIAsrController.k;
        this.scenario = InlineAIAsrController.k;
    }

    public static final /* synthetic */ MutableSharedFlow access$getCancelFlow$p(InlineAIAsrViewModel r0) {
        return r0.cancelFlow;
    }

    public static final /* synthetic */ List access$getTnsBlockButtons(InlineAIAsrViewModel r0) {
        return r0.getTnsBlockButtons();
    }

    private final void emitErrorCode(int r2) {
        this.errorCodeFlow.tryEmit(Integer.valueOf(r2));
    }

    public final void fillTemplateList(final Templates r3) {
        Intrinsics.checkNotNullParameter(r3, "templates");
        Log.i(TAG, "fillTemplateList()...");
        setState(new C03861(r3));
    }

    public final void showPanel(final List<m> r3) {
        Intrinsics.checkNotNullParameter(r3, "promptGroups");
        Log.i(TAG, "showPanel()...");
        setState(new C03921(r3));
    }

    public final void startNewTaskForSubPrompt(final slb.j r3) {
        Intrinsics.checkNotNullParameter(r3, "prompt");
        Log.i(TAG, "startNewTaskForSubPrompt()...");
        setState(new C03941(this, r3));
    }

    public static final /* synthetic */ void access$emitErrorCode(InlineAIAsrViewModel r0, int r1) {
        r0.emitErrorCode(r1);
    }

    public static final /* synthetic */ void access$setState(InlineAIAsrViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    private final com.ss.android.lark.inline.ai.logic.f testState(com.ss.android.lark.inline.ai.logic.f r1, boolean r2) {
        return nextStateOnCancel(r1, r2);
    }

    public final com.ss.android.lark.inline.ai.logic.f nextStateOnCancel(com.ss.android.lark.inline.ai.logic.f r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        ArrayList r4 = new ArrayList();
        Iterator<T> r0 = r12.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r4.add(com.ss.android.lark.inline.ai.logic.h.a((com.ss.android.lark.inline.ai.logic.h) r0.next()));
        goto L4
    L6:
        com.ss.android.lark.inline.ai.logic.h r1 = (com.ss.android.lark.inline.ai.logic.h) CollectionsKt.lastOrNull(r4);
        if (r1 == null) goto L9;
        String r2 = r1.d;
    L10:
        int r3 = 1;
        if (r2 != null) goto L13;
    L16:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L52;
        com.ss.android.lark.inline.ai.logic.h r6 = (com.ss.android.lark.inline.ai.logic.h) CollectionsKt.removeLastOrNull(r4);
        if (r4.isEmpty() == true) goto L22;
        InlineAIStatus r7 = InlineAIStatus.Finished;
        List<com.ss.android.lark.inline.ai.logic.h> r8 = r12.d;
        com.ss.android.lark.inline.ai.logic.h r9 = (com.ss.android.lark.inline.ai.logic.h) CollectionsKt.lastOrNull(r8);
        if (r9 == null) goto L46;
        ArrayList r10 = new ArrayList();
        k r11 = r9.f.h;
        if (r11 == null) goto L40;
        List<h> r14 = r11.onFinish();
        if (r14 == null) goto L40;
    L41:
        r10.addAll(r14);
        r9.h = r10;
        if (r13 == true) goto L45;
        r3 = 2;
    L45:
        r9.k = r3;
    L40:
        r14 = CollectionsKt.emptyList();
    L46:
        Unit r15 = Unit.INSTANCE;
        if (r6 == null) goto L50;
        com.ss.android.lark.inline.ai.logic.j r16 = r6.b;
        if (r16 == null) goto L50;
    L71:
        return com.ss.android.lark.inline.ai.logic.f.a(r12, r7, null, r8, 0, r16, null, 22);
    L50:
        r16 = new com.ss.android.lark.inline.ai.logic.j.a("");
        goto L71
    L22:
        if (r13 == false) goto L25;
        return new com.ss.android.lark.inline.ai.logic.f(InlineAIStatus.Closed, 126);
    L25:
        if ((!r12.c.isEmpty()) == false) goto L70;
        InlineAIStatus r17 = InlineAIStatus.Waiting;
        if (r6 == null) goto L30;
        com.ss.android.lark.inline.ai.logic.j r18 = r6.b;
        if (r18 == null) goto L30;
    L69:
        return com.ss.android.lark.inline.ai.logic.f.a(r12, r17, null, r4, 0, r18, null, 22);
    L30:
        r18 = new com.ss.android.lark.inline.ai.logic.j.a("");
        goto L69
    L70:
        return new com.ss.android.lark.inline.ai.logic.f(InlineAIStatus.Closed, 126);
    L52:
        InlineAIStatus r19 = InlineAIStatus.Finished;
        com.ss.android.lark.inline.ai.logic.j.a r20 = new com.ss.android.lark.inline.ai.logic.j.a("");
        com.ss.android.lark.inline.ai.logic.h r21 = (com.ss.android.lark.inline.ai.logic.h) CollectionsKt.lastOrNull(r4);
        if (r21 == null) goto L66;
        ArrayList r22 = new ArrayList();
        k r23 = r21.f.h;
        if (r23 == null) goto L59;
        List<h> r24 = r23.onFinish();
        if (r24 == null) goto L59;
    L60:
        r22.addAll(r24);
        r21.h = r22;
        if (r13 == true) goto L64;
        r3 = 2;
    L64:
        r21.k = r3;
    L59:
        r24 = CollectionsKt.emptyList();
    L66:
        return com.ss.android.lark.inline.ai.logic.f.a(r12, r19, null, r4, 0, r20, null, 22);
    L13:
        if (r2.length() == 0) goto L16;
        r5 = false;
        goto L18
    L9:
        r2 = null;
        goto L10
    }

    public final void onTaskPush(final InlineAITaskStatus r3, final boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        StringBuilder r0 = new StringBuilder("onTaskPush()... taskId = ");
        r0.append(r3.unique_task_id);
        r0.append(", status = ");
        r0.append(r3.task_status);
        r0.append(", code = ");
        r0.append(r3.status_code);
        r0.append(", content length = ");
        String r1 = r3.content;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        Log.i(TAG, r0.toString());
        setState(new C03901(r3, r4, this));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final String startNewTask(final slb.j r9, final com.ss.android.lark.inline.ai.logic.j r10) {
        Intrinsics.checkNotNullParameter(r9, "prompt");
        Log.i(TAG, "startNewTask()... prompt text = " + r9.d);
        final k r3 = r9.h;
        if (r3 != null) goto L6;
        Log.e(TAG, "startNewTask, callback is null!");
        return "";
    L6:
        StringUtils.a.getClass();
        final String r0 = StringUtils.a();
        setState(new C03931(r3, r0, r10, r9, this));
        return r0;
    }

    private final void sendPromptInternal(String r9, final String r10, slb.j r11, com.ss.android.lark.inline.ai.logic.j r12, l r13) {
        List<slb.d.a> r0 = InlineAIRustPbWrapper.a;
        InlineAIRustPbWrapper.d(this.scenario, r9, r10, r11, r12, r13, new C03911(this, r10));
    }

    public static final /* synthetic */ void access$sendPromptInternal(InlineAIAsrViewModel r0, String r1, String r2, slb.j r3, com.ss.android.lark.inline.ai.logic.j r4, l r5) {
        r0.sendPromptInternal(r1, r2, r3, r4, r5);
    }
}
