package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCSearchAppEntityParams;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/SearchAppEntityIntentExecutor;", "Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;", "Lcom/obric/capabilitykit/common/intent/PCSearchAppEntityParams;", "Lcom/obric/capabilitykit/common/intent/Empty;", "<init>", "()V", "TAG", "", "SS_SUPPORT_SEARCH_ACTION", "", "getSS_SUPPORT_SEARCH_ACTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", TrackerImpl.PARAMS, "questionId", "", "(Lcom/obric/capabilitykit/common/intent/PCSearchAppEntityParams;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/IntentResult;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k implements d<PCSearchAppEntityParams, Empty> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f12093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f12094b = null;

    static {
        f12093a = new k();
        f12094b = new String[]{"SearchContact", "SearchCallHistory"};
    }

    private k() {
    }

    @Override // com.obric.memorydata.personalcontext.datausage.plugin.action.manager.d
    public /* synthetic */ IntentResult<Empty> a(IntentParams r3, Long r4) {
        return a((PCSearchAppEntityParams) ZeusTransformUtils.preCheckCast((IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.memorydata.plugin"), PCSearchAppEntityParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public IntentResult<Empty> a(PCSearchAppEntityParams r29, Long r30) {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SearchAppEntityIntent", "user not agree privacy", false, 4, null);
        return new IntentResult(0, null, null, "", false, false, 1, null, null, null, 950, null);
    L7:
        if (ApiController.INSTANCE.isEnable() == false) goto L9;
        if (r29 == null) goto L12;
        String r0 = r29.getQuResult();
        String r2 = r29.getInteractionType();
        if (r2 != null) goto L16;
        r2 = "VOICE";
    L16:
        String r18 = r2;
        if (r30 == null) goto L20;
        String r3 = r30.toString();
        if (r3 == null) goto L20;
    L21:
        SearchResponse r8 = com.obric.memorydata.personalcontext.search.b.a(com.obric.memorydata.personalcontext.search.b.f12278a, r0, r3, r18, false, 8, null);
        ApiController r4 = ApiController.INSTANCE;
        if (r4.needLog() == false) goto L24;
        ApiController r9 = r4;
    L25:
        if (r9 == null) goto L35;
        if (r0 == null) goto L28;
        String r16 = q.f13259a.b(r0);
    L29:
        PCSearchAppEntityParams r1 = PCSearchAppEntityParams.copy$default(r29, r16, null, null, 6, null);
        SearchResult r5 = r8.getData();
        if (r5 == null) goto L32;
        SearchResult r6 = r5.copy(CollectionsKt.emptyList(), null);
    L33:
        r9.log("SearchAppEntityIntent", r1, SearchResponse.copy$default(r8, 0, null, r6, 3, null));
        goto L35
    L32:
        r6 = null;
        goto L33
    L28:
        r16 = null;
    L35:
        if (r8.getCode() != 1003) goto L37;
        int r7 = R.string.qu_search_error;
        String r10 = "qu_search_error";
    L38:
        int r11 = ZeusTransformUtils.mapRes(r7, TypedValues.Custom.S_STRING, r10);
        if (r8.getCode() == 0) goto L41;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SearchAppEntityIntent", "doAction failed, code: " + r8.getCode() + ", msg: " + r8.getMessage(), null, 4, null);
        return new IntentResult(1, null, null, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getString(r11), false, false, 1, null, null, null, 950, null);
    L41:
        return new IntentResult(0, null, null, EntityExtKt.getEntityGson().toJson(r8), false, false, 256, null, null, null, 950, null);
    L37:
        r7 = R.string.intent_search_error;
        r10 = "intent_search_error";
        goto L38
    L24:
        r9 = null;
    L20:
        r3 = "";
        goto L21
    L12:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L9:
        return new IntentResult(100, null, null, null, false, false, 0, null, null, null, 1022, null);
    }

    public final String[] a() {
        return f12094b;
    }
}
