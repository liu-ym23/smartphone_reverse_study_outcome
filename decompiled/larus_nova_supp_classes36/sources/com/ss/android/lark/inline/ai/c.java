package com.ss.android.lark.inline.ai;

import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIPageMode;
import com.ss.android.lark.inline.ai.api.knowledgeai.e;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.inline.ai.api.knowledgeai.d {
    public static final c a = null;
    public static final StateFlowImpl b = null;
    public static final MutableSharedFlow c = null;
    public static final StateFlowImpl d = null;
    public static final CoroutineScope e = null;

    public c() {
    }

    static {
        a = new c();
        b = j1.a(null);
        c = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        d = j1.a(KnowledgeAIPageMode.HIDE);
        e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.d
    public final void setup() {
        Log.w("OfficeSdkKnowledgePageFlowStub", "setup is no-op in OfficeSDK");
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.d
    public final CoroutineScope c() {
        return e;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.d
    public final MutableSharedFlow d() {
        return c;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.d
    public final StateFlowImpl f() {
        return b;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.d
    public final StateFlowImpl g() {
        return d;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.d
    public final void e(e r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Log.w("OfficeSdkKnowledgePageFlowStub", "sendEvent is no-op in OfficeSDK, event: " + r3);
    }
}
