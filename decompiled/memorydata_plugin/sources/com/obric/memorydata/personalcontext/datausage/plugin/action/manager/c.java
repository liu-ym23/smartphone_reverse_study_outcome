package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCGlobalSearchParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.controller.ApiController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/GlobalSearchIntentExecutor;", "Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;", "Lcom/obric/capabilitykit/common/intent/PCGlobalSearchParams;", "Lcom/obric/capabilitykit/common/intent/Empty;", "<init>", "()V", "TAG", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", TrackerImpl.PARAMS, "questionId", "", "(Lcom/obric/capabilitykit/common/intent/PCGlobalSearchParams;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/IntentResult;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements d<PCGlobalSearchParams, Empty> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12084a = null;

    static {
        f12084a = new c();
    }

    private c() {
    }

    @Override // com.obric.memorydata.personalcontext.datausage.plugin.action.manager.d
    public /* synthetic */ IntentResult<Empty> a(IntentParams r3, Long r4) {
        return a((PCGlobalSearchParams) ZeusTransformUtils.preCheckCast((IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.memorydata.plugin"), PCGlobalSearchParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public IntentResult<Empty> a(PCGlobalSearchParams r29, Long r30) {
        if (ApiController.INSTANCE.isEnable() == false) goto L5;
        if (r29 == null) goto L8;
        String r1 = r29.getQuResult();
        String r2 = r29.getInteractionType();
        if (r2 != null) goto L12;
        r2 = "VOICE";
    L12:
        if (r30 == null) goto L15;
        String r3 = r30.toString();
        if (r3 == null) goto L15;
    L16:
        GlobalAssistantSearchResponse r4 = com.obric.memorydata.personalcontext.search.global.f.f12331a.b(r1, r3, r2);
        ApiController r5 = ApiController.INSTANCE;
        if (r5.needLog() == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L26;
        if (r1 == null) goto L23;
        String r6 = q.f13259a.b(r1);
    L24:
        r5.log("GlobalSearchIntent", PCGlobalSearchParams.copy$default(r29, r6, null, 2, null), GlobalAssistantSearchResponse.copy$default(r4, 0, null, null, null, null, null, null, null, 227, null));
        goto L26
    L23:
        r6 = null;
    L26:
        if (r4.getCode() != 1003) goto L28;
        int r0 = R.string.qu_search_error;
        String r7 = "qu_search_error";
    L29:
        int r8 = ZeusTransformUtils.mapRes(r0, TypedValues.Custom.S_STRING, r7);
        if (r4.getCode() == 0) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalSearchIntent", "doAction failed, code: " + r4.getCode() + ", msg: " + r4.getMessage(), null, 4, null);
        return new IntentResult(1, null, null, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getString(r8), false, false, 1, null, null, null, 950, null);
    L34:
        return new IntentResult(0, null, null, EntityExtKt.getEntityGson().toJson(r4), false, false, 256, null, null, null, 950, null);
    L28:
        r0 = R.string.intent_search_error;
        r7 = "intent_search_error";
    L15:
        r3 = "";
        goto L16
    L8:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L5:
        return new IntentResult(100, null, null, null, false, false, 0, null, null, null, 1022, null);
    }
}
