package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCPersonalContextSearchParams;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/PersonalContextSearchIntentExecutor;", "Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;", "Lcom/obric/capabilitykit/common/intent/PCPersonalContextSearchParams;", "Lcom/obric/capabilitykit/common/intent/Empty;", "<init>", "()V", "TAG", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", TrackerImpl.PARAMS, "questionId", "", "(Lcom/obric/capabilitykit/common/intent/PCPersonalContextSearchParams;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/IntentResult;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i implements d<PCPersonalContextSearchParams, Empty> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12091a = null;

    static {
        f12091a = new i();
    }

    private i() {
    }

    @Override // com.obric.memorydata.personalcontext.datausage.plugin.action.manager.d
    public /* synthetic */ IntentResult<Empty> a(IntentParams r3, Long r4) {
        return a((PCPersonalContextSearchParams) ZeusTransformUtils.preCheckCast((IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.memorydata.plugin"), PCPersonalContextSearchParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public IntentResult<Empty> a(PCPersonalContextSearchParams r36, Long r37) {
        if (ApiController.INSTANCE.isEnable() == false) goto L5;
        if (r36 == null) goto L8;
        String r0 = r36.getSearchParams();
        if (r0 == null) goto L12;
        String r15 = r36.getOriginQuery();
        if (r15 == null) goto L16;
        String r1 = r36.getInteractionType();
        if (r1 != null) goto L20;
        r1 = com.obric.memorydata.personalcontext.search.d.f12308a.h();
    L20:
        String r18 = r1;
        String r2 = r36.getMemoryScene();
        if (r2 != null) goto L23;
        r2 = "";
    L23:
        RunLog.INSTANCE.debug("PersonalContextSearchIntent", "memoryScene: " + r2);
        if (r37 == null) goto L29;
        String r3 = r37.toString();
        if (r3 == null) goto L29;
        String r17 = r3;
    L30:
        GlobalAssistantSearchResponse r4 = com.obric.memorydata.personalcontext.search.global.f.a(com.obric.memorydata.personalcontext.search.global.f.f12331a, r15, r0, r17, r18, "personal_context_search", r2, false, 64, null);
        ApiController r5 = ApiController.INSTANCE;
        if (r5.needLog() == true) goto L34;
        r5 = null;
    L34:
        if (r5 == null) goto L37;
        r5.log("PersonalContextSearchIntent", PCPersonalContextSearchParams.copy$default(r36, q.f13259a.b(r0), null, null, null, 14, null), GlobalAssistantSearchResponse.copy$default(r4, 0, null, null, null, null, null, null, null, 227, null));
    L37:
        if (r4.getCode() != 1003) goto L41;
        Resources r6 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        int r7 = R.string.qu_search_error;
        String r8 = "qu_search_error";
    L39:
        String r9 = r6.getString(ZeusTransformUtils.mapRes(r7, TypedValues.Custom.S_STRING, r8));
        Intrinsics.checkNotNull(r9);
        if (r4.getCode() == 0) goto L56;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalContextSearchIntent", "doAction failed, code: " + r4.getCode() + ", msg: " + r4.getMessage(), null, 4, null);
        return new IntentResult(1, null, null, r9, false, false, 1, null, null, null, 950, null);
    L56:
        return new IntentResult(0, null, null, EntityExtKt.getEntityGson().toJson(r4), false, false, 256, null, null, null, 950, null);
    L41:
        if (AppContext.INSTANCE.isDebug() == false) goto L46;
        if (r4.getCode() != 1004) goto L46;
        r6 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        r7 = R.string.internal_search_error;
        r8 = "internal_search_error";
    L46:
        if (AppContext.INSTANCE.isDebug() == true) goto L48;
    L50:
        r6 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        r7 = R.string.intent_search_error;
        r8 = "intent_search_error";
        goto L39
    L48:
        if (r4.getCode() != 1005) goto L50;
        r6 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        r7 = R.string.model_not_ready_search_error;
        r8 = "model_not_ready_search_error";
    L29:
        r17 = "";
        goto L30
    L16:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L12:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L8:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L5:
        return new IntentResult(100, null, null, null, false, false, 0, null, null, null, 1022, null);
    }
}
