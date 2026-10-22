package com.obric.memorydata.personalcontext.log;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u000eJ\u0006\u0010+\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u0005J\u0010\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u000100JB\u00101\u001a\u00020'2:\u00102\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'0\"J\u0006\u00103\u001a\u00020'J\u001f\u00104\u001a\u00020'2\b\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u00105R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000RH\u0010 \u001a<\u00128\u00126\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'0\"0!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/memorydata/personalcontext/log/EvaluatorRecorder;", "", "<init>", "()V", "GLOBAL_SEARCH_INTENT_SCRIPT_NAME", "", "GLOBAL_SEARCH_BOT_SCRIPT_NAME", "recorder", "Lcom/obric/memorydata/personalcontext/log/EvaluationResult;", "getRecorder", "()Lcom/obric/memorydata/personalcontext/log/EvaluationResult;", "setRecorder", "(Lcom/obric/memorydata/personalcontext/log/EvaluationResult;)V", "isEvaluating", "", "()Z", "setEvaluating", "(Z)V", "queryTime", "", "getQueryTime", "()J", "setQueryTime", "(J)V", "isSearchToolMode", "setSearchToolMode", "isComplexEvaluation", "setComplexEvaluation", "done", "getDone", "setDone", "scriptMode", "queryFinishCallbackList", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, ChatMessage.TYPE_QUERY, "isFinished", "", "newRecorder", "isComplexEvaluating", "isGlobalSearchIntentEvaluating", "isGlobalSearchBotEvaluating", "setEvaluatorScriptMode", "mode", "setResponse", "res", "Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "addEvaluationQueryFinishCallback", "callback", "removeEvaluationQueryFinishCallback", "notifyEvaluationQueryFinish", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12229a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static EvaluationResult f12230b;
    private static boolean c;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    private static String g;
    private static List<Function2<String, Boolean, Unit>> h;

    static {
        f12229a = new a();
        g = "";
        h = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private a() {
    }

    public final EvaluationResult a() {
        return f12230b;
    }

    public final void a(SearchResponse r1) {
        f = true;
        EvaluationResult r0 = f12230b;
        if (r0 == null) goto L6;
        r0.setResponse(r1);
        return;
    }

    public final void a(String r4, Boolean r5) {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(h, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Function2) ZeusTransformUtils.preCheckCast(r3.next(), Function2.class, "com.obric.memorydata.plugin")).invoke(r4, r5);
        goto L4
    }

    public final void a(boolean r1) {
        f = r1;
    }

    public final boolean b() {
        return c;
    }

    public final boolean c() {
        return d;
    }

    public final boolean d() {
        return e;
    }

    public final boolean e() {
        return Intrinsics.areEqual(g, "GlobalSearchIntent");
    }

    public final boolean f() {
        return Intrinsics.areEqual(g, "GlobalSearchBot");
    }
}
