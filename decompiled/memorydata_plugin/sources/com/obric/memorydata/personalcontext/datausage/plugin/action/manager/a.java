package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCAppFcEntitySearchParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.controller.ApiController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.obric.memorydata.sdk.entity.search.SearchResult;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/AppFuncEntitySearchIntentExecutor;", "Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;", "Lcom/obric/capabilitykit/common/intent/PCAppFcEntitySearchParams;", "Lcom/obric/capabilitykit/common/intent/Empty;", "<init>", "()V", "TAG", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", TrackerImpl.PARAMS, "questionId", "", "(Lcom/obric/capabilitykit/common/intent/PCAppFcEntitySearchParams;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/IntentResult;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements d<PCAppFcEntitySearchParams, Empty> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12082a = null;

    static {
        f12082a = new a();
    }

    private a() {
    }

    @Override // com.obric.memorydata.personalcontext.datausage.plugin.action.manager.d
    public /* synthetic */ IntentResult<Empty> a(IntentParams r3, Long r4) {
        return a((PCAppFcEntitySearchParams) ZeusTransformUtils.preCheckCast((IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.memorydata.plugin"), PCAppFcEntitySearchParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public IntentResult<Empty> a(PCAppFcEntitySearchParams r24, Long r25) {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppFuncEntitySearchIntent", "user not agree privacy", false, 4, null);
        return new IntentResult(0, null, null, "", false, false, 1, null, null, null, 950, null);
    L7:
        if (ApiController.INSTANCE.isEnable() == false) goto L9;
        if (r24 == null) goto L12;
        String r0 = r24.getQuResult();
        String r2 = r24.getInteractionType();
        if (r2 != null) goto L16;
        r2 = "VOICE";
    L16:
        if (r25 == null) goto L19;
        String r3 = r25.toString();
        if (r3 == null) goto L19;
    L20:
        SearchResponse r4 = com.obric.memorydata.personalcontext.search.b.f12278a.a(r0, r3, r2, true);
        ApiController r5 = ApiController.INSTANCE;
        if (r5.needLog() == true) goto L24;
        r5 = null;
    L24:
        if (r5 == null) goto L34;
        if (r0 == null) goto L27;
        String r16 = q.f13259a.b(r0);
    L28:
        PCAppFcEntitySearchParams r1 = PCAppFcEntitySearchParams.copy$default(r24, r16, null, null, 6, null);
        SearchResult r6 = r4.getData();
        if (r6 == null) goto L31;
        SearchResult r9 = r6.copy(CollectionsKt.emptyList(), null);
    L32:
        r5.log("AppFuncEntitySearchIntent", r1, SearchResponse.copy$default(r4, 0, null, r9, 3, null));
        goto L34
    L31:
        r9 = null;
        goto L32
    L27:
        r16 = null;
    L34:
        if (r4.getCode() != 1003) goto L36;
        int r7 = R.string.qu_search_error;
        String r8 = "qu_search_error";
    L37:
        int r10 = ZeusTransformUtils.mapRes(r7, TypedValues.Custom.S_STRING, r8);
        if (r4.getCode() == 0) goto L40;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppFuncEntitySearchIntent", "doAction failed, code: " + r4.getCode() + ", msg: " + r4.getMessage(), null, 4, null);
        return new IntentResult(1, null, null, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getString(r10), false, false, 1, null, null, null, 950, null);
    L40:
        return new IntentResult(0, null, null, EntityExtKt.getEntityGson().toJson(r4), false, false, 256, null, null, null, 950, null);
    L36:
        r7 = R.string.intent_search_error;
        r8 = "intent_search_error";
    L19:
        r3 = "";
        goto L20
    L12:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L9:
        return new IntentResult(100, null, null, null, false, false, 0, null, null, null, 1022, null);
    }
}
