package com.ss.android.lark.inline.ai.logic;

import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.AbsInlineAIViewModel;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.api.Template;
import com.ss.android.lark.inline.ai.api.Templates;
import com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter;
import com.ss.android.lark.inline.ai.utils.StringUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;
import slb.k;
import slb.l;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t*\u0001\u000f\u0018\u0000 Z2\u00020\u0001:\u0002Z[B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0016J\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f0\u0019J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u001d\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0006\u0010!\u001a\u00020\u0017J\u0014\u0010\"\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\nJ \u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\nJ2\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020\u0017J\u0006\u00101\u001a\u00020\u0017J\u0016\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\nJ\u0012\u00106\u001a\u000207*\u0002072\u0006\u00108\u001a\u00020\nJ\u0018\u00109\u001a\u0002072\u0006\u0010:\u001a\u0002072\u0006\u00108\u001a\u00020\nH\u0002J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u001fH\u0002J\u0016\u0010=\u001a\u00020\u00172\f\u0010>\u001a\b\u0012\u0004\u0012\u00020<0?H\u0002J\u000e\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\nJ\u000e\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\rJB\u0010D\u001a\u00020\u00172\u0006\u0010C\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'2\u000e\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0F2\u0018\u0010G\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00170HJ,\u0010I\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020J\u0018\u00010\f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010C\u001a\u00020KH\u0002J&\u0010L\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020J\u0018\u00010\f2\u0006\u0010&\u001a\u00020'2\u0006\u0010C\u001a\u00020KH\u0002J\u000e\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020OJ\"\u0010P\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\r2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020S0RJ\u000e\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\nJ\u0010\u0010V\u001a\u00020\u00172\u0006\u0010W\u001a\u00020\bH\u0002J\b\u0010X\u001a\u000207H\u0014J\u0006\u0010Y\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/ss/android/lark/inline/ai/logic/InlineAIViewModel;", "Lcom/ss/android/lark/inline/ai/AbsInlineAIViewModel;", "inlineAIParams", "Lcom/ss/android/lark/inline/ai/api/InlineAIParams;", "<init>", "(Lcom/ss/android/lark/inline/ai/api/InlineAIParams;)V", "errorCodeFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "cancelFlow", "", "debugCodeFlow", "Lkotlin/Pair;", "", "pushListener", "com/ss/android/lark/inline/ai/logic/InlineAIViewModel$pushListener$1", "Lcom/ss/android/lark/inline/ai/logic/InlineAIViewModel$pushListener$1;", "scenario", "Lcom/ss/android/lark/inline/ai/api/ScenarioType;", "pushHandler", "Lcom/ss/android/lark/inline/ai/logic/push/InlineAIPushHandler;", "compatPushListener", "init", "", "getErrorCodeFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getCancelFlow", "getDebugCodeFlow", "updateScenario", "showPanel", "promptGroups", "", "Lcom/ss/android/lark/inline/ai/api/PromptGroup;", "hidePanel", "updatePromptGroups", "onFeedbackChange", "like", "startNewTask", "prompt", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "userInputText", "Lcom/ss/android/lark/inline/ai/logic/UserInputText;", "isClickSend", "sendPromptInternal", "conversationId", "taskId", "promptConfirmOptions", "Lcom/ss/android/lark/inline/ai/api/PromptConfirmOptions;", "cancelCurrentTask", "retryCurrentTask", "onTaskPush", "data", "Lcom/bytedance/lark/pb/space/doc/v1/InlineAITaskStatus;", "forceUpdate", "nextStateOnCancel", "Lcom/ss/android/lark/inline/ai/logic/InlineAIState;", "isError", "testState", "state", "getTnsBlockButtons", "Lcom/ss/android/lark/inline/ai/api/OperateButton;", "addDebugButton", "operateButtons", "", "switchHistory", "isNext", "updateUserInput", "text", "clickSend", "userPromptGetter", "Lkotlin/Function0;", "sendCallback", "Lkotlin/Function2;", "findTemplatePromptByUserPrompt", "Lcom/ss/android/lark/inline/ai/logic/UserInputText$TemplateText;", "Lcom/ss/android/lark/inline/ai/logic/UserInputText$NormalText;", "checkUserPromptIsMatchTemplatePrompt", "fillTemplateList", "templates", "Lcom/ss/android/lark/inline/ai/api/Templates;", "updateDocsMeta", "metaMap", "", "", "onKeyboardChange", "show", "emitErrorCode", "errorCode", "defaultState", "onDestroy", "Companion", "TaskStatus", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InlineAIViewModel extends AbsInlineAIViewModel {
    public static final a Companion = null;
    public static final String DEBUG_BUTTON_KEY = "debug";
    private static final String EXIT_BUTTON_KEY = "exit";
    private static final String LINK_TO_MENTION = "linkToMention";
    private static final String TAG = "InlineAIViewModel";
    private final MutableSharedFlow<Boolean> cancelFlow;
    private final com.ss.android.lark.inline.ai.logic.push.a compatPushListener;
    private final MutableSharedFlow<Pair<Integer, String>> debugCodeFlow;
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
        public final /* synthetic */ InlineAIViewModel a;

        public b(InlineAIViewModel r1) {
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

    private final List<slb.h> getTnsBlockButtons() {
        StringUtils.a.getClass();
        return CollectionsKt.listOf(new slb.h(EXIT_BUTTON_KEY, StringUtils.d(2131889161), new C03981(this)));
    }

    public final void cancelCurrentTask() {
        Log.i(TAG, "cancelCurrentTask()...");
        setState(new C03951(this));
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public f m848defaultState() {
        return new f(null, 127);
    }

    @Override // com.ss.android.lark.inline.ai.AbsInlineAIViewModel
    public d1<Boolean> getCancelFlow() {
        return kotlinx.coroutines.flow.e.a(this.cancelFlow);
    }

    public final d1<Pair<Integer, String>> getDebugCodeFlow() {
        return kotlinx.coroutines.flow.e.a(this.debugCodeFlow);
    }

    public final d1<Integer> getErrorCodeFlow() {
        return kotlinx.coroutines.flow.e.a(this.errorCodeFlow);
    }

    public final void hidePanel() {
        Log.i(TAG, "hidePanel()...");
        setState(C03991.INSTANCE);
    }

    public final void init() {
        List<slb.d.a> r0 = InlineAIRustPbWrapper.a;
        com.ss.android.lark.inline.ai.logic.push.a r1 = this.compatPushListener;
        Intrinsics.checkNotNullParameter(r1, "listener");
        ArrayList r2 = (ArrayList) InlineAIRustPbWrapper.a;
        if (r2.contains(r1) == true) goto L6;
        r2.add(r1);
        return;
    }

    public final void onDestroy() {
        setState(C04001.INSTANCE);
        List<slb.d.a> r0 = InlineAIRustPbWrapper.a;
        com.ss.android.lark.inline.ai.logic.push.a r1 = this.compatPushListener;
        Intrinsics.checkNotNullParameter(r1, "listener");
        ((ArrayList) InlineAIRustPbWrapper.a).remove(r1);
    }

    public final void retryCurrentTask() {
        Log.i(TAG, "retryCurrentTask()...");
        withState(new C04031(this));
    }

    public /* bridge */ /* synthetic */ com.larksuite.arch.jack.j defaultState() {
        return m848defaultState();
    }

    public InlineAIViewModel(slb.g r6) {
        Intrinsics.checkNotNullParameter(r6, "inlineAIParams");
        this.inlineAIParams = r6;
        this.errorCodeFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.cancelFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.debugCodeFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        b r0 = new b(this);
        this.pushListener = r0;
        this.scenario = ScenarioType.Doc;
        com.ss.android.lark.inline.ai.logic.push.a r1 = new com.ss.android.lark.inline.ai.logic.push.a(r0);
        r1.b(new com.ss.android.lark.inline.ai.logic.push.b(this));
        if (idb.f.a().isCurrentEnable(AbsInlineAIViewModel.ENABLE_SMOOTH_PRINT) == false) goto L5;
        r1.b(new SmoothOutputFilter(this));
    L5:
        this.pushHandler = r1;
        this.compatPushListener = r1;
        this.scenario = r6.e;
    }

    public static final /* synthetic */ MutableSharedFlow access$getCancelFlow$p(InlineAIViewModel r0) {
        return r0.cancelFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$getDebugCodeFlow$p(InlineAIViewModel r0) {
        return r0.debugCodeFlow;
    }

    public static final /* synthetic */ List access$getTnsBlockButtons(InlineAIViewModel r0) {
        return r0.getTnsBlockButtons();
    }

    private final void addDebugButton(List<slb.h> r6) {
        if (this.inlineAIParams.n == true) goto L8;
        boolean r4 = false;
        if (LarkKVStorage.f(com.ss.android.lark.inline.ai.logic.b.a, "debug_config", new n6c.b(LarkContext.getApplication().getSharedPreferences("debug_config", 0))).getBoolean("ai_roadster_debug", false) != true) goto L7;
        r4 = true;
    L7:
        if (r4 == true) goto L8;
        return;
    L8:
        Log.i(TAG, "addDebugButton()... ");
        StringUtils.a.getClass();
        r6.add(new slb.h("debug", StringUtils.d(2131889151), new AnonymousClass1(this)));
    }

    private final void emitErrorCode(int r2) {
        this.errorCodeFlow.tryEmit(Integer.valueOf(r2));
    }

    public final void fillTemplateList(final Templates r3) {
        Intrinsics.checkNotNullParameter(r3, "templates");
        Log.i(TAG, "fillTemplateList()...");
        setState(new C03971(r3));
    }

    public final void onFeedbackChange(final boolean r3) {
        Log.i(TAG, "onFeedbackChange()... like = " + r3);
        withState(new C04011(r3));
    }

    public final void onKeyboardChange(boolean r3) {
        Log.i(TAG, "onKeyboardChange()... show = " + r3);
    }

    public final void showPanel(final List<m> r3) {
        Intrinsics.checkNotNullParameter(r3, "promptGroups");
        Log.i(TAG, "showPanel()...");
        setState(new C04051(r3));
    }

    public final void switchHistory(final boolean r3) {
        Log.i(TAG, "switchHistory()... isNext = " + r3);
        setState(new C04071(r3));
    }

    public final void updatePromptGroups(final List<m> r2) {
        Intrinsics.checkNotNullParameter(r2, "promptGroups");
        setState(new C04091(r2));
    }

    public final void updateScenario(ScenarioType r2) {
        Intrinsics.checkNotNullParameter(r2, "scenario");
        this.scenario = r2;
    }

    public final void updateUserInput(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        Log.i(TAG, "updateUserInput()... text length = " + r3.length());
        setState(new C04101(r3));
    }

    public static final /* synthetic */ void access$addDebugButton(InlineAIViewModel r0, List r1) {
        r0.addDebugButton(r1);
    }

    public static final /* synthetic */ void access$emitErrorCode(InlineAIViewModel r0, int r1) {
        r0.emitErrorCode(r1);
    }

    public static final /* synthetic */ void access$setState(InlineAIViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    private final Pair<slb.j, j.b> checkUserPromptIsMatchTemplatePrompt(slb.j r12, j.a r13) {
        Templates r0 = r12.e;
        if (r0 != null) goto L5;
    L10:
        return null;
    L5:
        if (r0.getTemplateList().size() != 1) goto L10;
        if (StringsKt.startsWith$default(r13.a, r0.getTemplatePrefix() + ((Template) ListProtector.get(r0.getTemplateList(), 0)).getTemplateName(), false, 2, null) == false) goto L10;
        return new Pair(r12, new j.b(r0.getTemplatePrefix(), CollectionsKt.mutableListOf(new j.b.a[]{new j.b.a(((Template) ListProtector.get(r0.getTemplateList(), 0)).getKey(), ((Template) ListProtector.get(r0.getTemplateList(), 0)).getTemplateName(), ((Template) ListProtector.get(r0.getTemplateList(), 0)).getPlaceHolder(), r13.a.substring(r0.getTemplatePrefix().length() + ((Template) ListProtector.get(r0.getTemplateList(), 0)).getTemplateName().length()))}), r13.a));
    }

    private final Pair<slb.j, j.b> findTemplatePromptByUserPrompt(List<m> r4, j.a r5) {
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        m r0 = (m) r6.next();
        ArrayList r1 = new ArrayList();
        r1.addAll(r0.b);
    L7:
        if ((!r1.isEmpty()) == false) goto L4;
        slb.j r2 = (slb.j) ListProtector.remove(r1, 0);
        Pair<slb.j, j.b> r3 = checkUserPromptIsMatchTemplatePrompt(r2, r5);
        if (r3 != null) goto L10;
        ArrayList<slb.j> r7 = r2.g;
        if (r7 == null) goto L7;
        r1.addAll(r7);
        goto L7
    L10:
        return r3;
    L14:
        return null;
    }

    private final f testState(f r1, boolean r2) {
        return nextStateOnCancel(r1, r2);
    }

    public final f nextStateOnCancel(f r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r4 = new ArrayList();
        Iterator<T> r0 = r10.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r4.add(h.a((h) r0.next()));
        goto L4
    L6:
        h r1 = (h) CollectionsKt.lastOrNull(r4);
        j r2 = null;
        if (r1 == null) goto L9;
        String r3 = r1.d;
    L11:
        if (r3 != null) goto L13;
    L16:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L43;
        h r6 = (h) CollectionsKt.removeLastOrNull(r4);
        if (r4.isEmpty() == true) goto L22;
        InlineAIStatus r7 = InlineAIStatus.Finished;
        int r8 = CollectionsKt.getLastIndex(r4);
        if (r6 != null) goto L36;
    L41:
        j r9 = new j.a("");
    L58:
        return f.a(r10, r7, null, r4, r8, r9, null, 6);
    L36:
        if (r6.e == false) goto L38;
        r2 = r6.b;
    L38:
        if (r2 == null) goto L41;
        r9 = r2;
        goto L58
    L22:
        if (r11 == false) goto L25;
        return new f(InlineAIStatus.Closed, 126);
    L25:
        if ((!r10.c.isEmpty()) == false) goto L57;
        InlineAIStatus r12 = InlineAIStatus.Waiting;
        if (r6 == null) goto L30;
        j r13 = r6.b;
        if (r13 == null) goto L30;
    L56:
        return f.a(r10, r12, null, r4, 0, r13, null, 22);
    L30:
        r13 = new j.a("");
        goto L56
    L57:
        return new f(InlineAIStatus.Closed, 126);
    L43:
        InlineAIStatus r14 = InlineAIStatus.Finished;
        j.a r15 = new j.a("");
        h r16 = (h) CollectionsKt.lastOrNull(r4);
        if (r16 == null) goto L53;
        ArrayList r17 = new ArrayList();
        k r18 = r16.f.h;
        if (r18 == null) goto L50;
        List<slb.h> r19 = r18.onFinish();
        if (r19 == null) goto L50;
    L51:
        r17.addAll(r19);
        addDebugButton(r17);
        r16.h = r17;
    L50:
        r19 = CollectionsKt.emptyList();
    L53:
        return f.a(r10, r14, null, r4, 0, r15, null, 22);
    L13:
        if (r3.length() == 0) goto L16;
        r5 = false;
        goto L18
    L9:
        r3 = null;
        goto L11
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
        Log.d(TAG, r0.toString());
        setState(new C04021(r3, r4, this));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void updateDocsMeta(final String r4, final Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "metaMap");
        Set<String> r0 = r5.keySet();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(((String) r2.next()).hashCode()));
        goto L4
    L6:
        Log.i(TAG, "updateDocsMeta, taskId = " + r4 + ", metaMap.keys = " + String.valueOf(r1));
        setState(new C04081(r5, r4));
    }

    public static final /* synthetic */ Pair access$checkUserPromptIsMatchTemplatePrompt(InlineAIViewModel r0, slb.j r1, j.a r2) {
        return r0.checkUserPromptIsMatchTemplatePrompt(r1, r2);
    }

    public static final /* synthetic */ Pair access$findTemplatePromptByUserPrompt(InlineAIViewModel r0, List r1, j.a r2) {
        return r0.findTemplatePromptByUserPrompt(r1, r2);
    }

    public final String startNewTask(final slb.j r10, final j r11, final boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "prompt");
        Log.i(TAG, "startNewTask()... prompt text = " + r10.d);
        final k r3 = r10.h;
        if (r3 != null) goto L6;
        Log.e(TAG, "startNewTask, callback is null!");
        return "";
    L6:
        StringUtils.a.getClass();
        final String r0 = StringUtils.a();
        setState(new C04061(r3, r0, r11, r12, r10, this));
        return r0;
    }

    public final void clickSend(final j r9, final slb.j r10, final Function0<slb.j> r11, final Function2<? super String, ? super slb.j, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "text");
        Intrinsics.checkNotNullParameter(r11, "userPromptGetter");
        Intrinsics.checkNotNullParameter(r12, "sendCallback");
        StringBuilder r0 = new StringBuilder("clickSend()... isTemplateText = ");
        r0.append(r9 instanceof j.b);
        r0.append(", text length = ");
        r0.append(g.d(r9).length());
        r0.append(", prompt text = ");
        if (r10 == null) goto L5;
        String r1 = r10.d;
    L6:
        r0.append(r1);
        Log.i(TAG, r0.toString());
        withState(new C03961(r10, r9, this, r11, r12));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void sendPromptInternal(String r9, final String r10, slb.j r11, j r12, l r13) {
        List<slb.d.a> r0 = InlineAIRustPbWrapper.a;
        InlineAIRustPbWrapper.d(this.scenario, r9, r10, r11, r12, r13, new C04041(this, r10));
    }

    public static final /* synthetic */ void access$sendPromptInternal(InlineAIViewModel r0, String r1, String r2, slb.j r3, j r4, l r5) {
        r0.sendPromptInternal(r1, r2, r3, r4, r5);
    }
}
