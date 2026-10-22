package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.RCSearchParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.api.controller.ApiController;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/RCSearchIntentExecutor;", "Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;", "Lcom/obric/capabilitykit/common/intent/RCSearchParams;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "<init>", "()V", "RINGING_ALARM_EVENT", "", "ASSISTANT_QUERY_RINGING_ALARM", "ASSISTANT_QUERY_RECORDING_AUDIOS", "ASSISTANT_QUERY_SIM_CARDS", "ASSISTANT_QUERY", "NAME_KEY", "SUB_KEY_RING_ALARMS", "SUB_KEY_RECORDING_AUDIOS", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", TrackerImpl.PARAMS, "questionId", "", "(Lcom/obric/capabilitykit/common/intent/RCSearchParams;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/IntentResult;", "handleAssistantQuery", "featureParamsObject", "Lorg/json/JSONObject;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j implements d<RCSearchParams, AppEntity[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f12092a = null;

    static {
        f12092a = new j();
    }

    private j() {
    }

    private final IntentResult<AppEntity[]> a(JSONObject r20) {
        boolean r1 = r20.optBoolean("ringAlarms", false);
        boolean r0 = r20.optBoolean("recordingAudios", false);
        List r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L7;
        AppEntity[] r2 = (AppEntity[]) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.realcontext.b.f12260a.a().getEntity(), AppEntity[].class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"), r2);
    L7:
        if (r1 == false) goto L12;
        AppEntity[] r4 = (AppEntity[]) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.realcontext.a.f12258a.a().getEntity(), AppEntity[].class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"), r4);
    L12:
        return new IntentResult(0, ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), null, null, false, false, 256, null, null, null, 956, null);
    }

    @Override // com.obric.memorydata.personalcontext.datausage.plugin.action.manager.d
    public /* synthetic */ IntentResult<AppEntity[]> a(IntentParams r3, Long r4) {
        return a((RCSearchParams) ZeusTransformUtils.preCheckCast((IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.memorydata.plugin"), RCSearchParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public IntentResult<AppEntity[]> a(RCSearchParams r28, Long r29) {
        if (ApiController.INSTANCE.isEnable() == false) goto L5;
        if (r28 == null) goto L52;
        String r0 = r28.getFeatureParam();
        if (r0 == null) goto L52;
        JSONObject r1 = new JSONObject(r0);
        String r2 = r1.optString(ActivityLifecycle.NAME);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        if (r2 == null) goto L50;
        switch(r2.hashCode()) {
            case -1536856215: goto L45;
            case 113226614: goto L40;
            case 241029258: goto L35;
            case 668125631: goto L30;
            case 1273746116: goto L25;
            default: goto L50;
        };
    L25:
        if (r2.equals("assistantQueryRecordingAudios") == false) goto L50;
        return com.obric.memorydata.personalcontext.realcontext.b.f12260a.a();
    L30:
        if (r2.equals("ringingAlarm") == false) goto L50;
        return com.obric.memorydata.personalcontext.realcontext.a.f12258a.b();
    L35:
        if (r2.equals("assistantQuery") == false) goto L50;
        return a(r1);
    L40:
        if (r2.equals("assistantQuerySimCards") == false) goto L50;
        return com.obric.memorydata.personalcontext.realcontext.d.f12264a.a();
    L45:
        if (r2.equals("assistantQueryRingingAlarm") == false) goto L50;
        return com.obric.memorydata.personalcontext.realcontext.a.f12258a.a();
    L50:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L19:
        return new IntentResult(100, null, null, null, false, false, 0, null, null, null, 1022, null);
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
    L52:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L5:
        return new IntentResult(100, null, null, null, false, false, 0, null, null, null, 1022, null);
    }
}
