package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import android.content.Context;
import android.os.Parcelable;
import android.provider.Settings;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BasePCGlobalSearchIntentIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCGlobalSearchIntentParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantIntentSearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/GlobalSearchForAppIntentIntent;", "Lcom/obric/capabilitykit/common/intent/BasePCGlobalSearchIntentIntent;", "<init>", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/PCGlobalSearchIntentParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/PCGlobalSearchIntentParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBlock", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalSearchForAppIntentIntent extends BasePCGlobalSearchIntentIntent {
    public static final a Companion = null;
    private static final String KEY_DEEP_SEARCH = "memory.global.deepsearch";
    private static final String TAG = "GlobalSearchForAppIntentIntent";
    private static final long TIMEOUT_MS = 180000;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/GlobalSearchForAppIntentIntent$Companion;", "", "<init>", "()V", "TAG", "", "KEY_DEEP_SEARCH", "TIMEOUT_MS", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public GlobalSearchForAppIntentIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCGlobalSearchIntentIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, Continuation<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Continuation<? super IntentResult<Empty>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return doAction((PCGlobalSearchIntentParams) ZeusTransformUtils.preCheckCast(r6, PCGlobalSearchIntentParams.class, "com.obric.memorydata.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCGlobalSearchIntentIntent
    public Object doAction(PCGlobalSearchIntentParams r17, DispatchContext r18, Continuation<? super IntentResult<Empty>> r19) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        String r1 = r17.getQuResult();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "receive query: " + r1, false, 4, null);
        String r2 = r17.getMeta();
        String r3 = "";
        if (r2 == null) goto L9;
        Matcher r4 = Pattern.compile("\"LogID\"\\s*:\\s*\"([^\"]+)\"").matcher((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r4.find() == false) goto L7;
        String r5 = r4.group(1);
    L8:
        if (r5 == null) goto L9;
    L10:
        int r7 = 0;
        if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), KEY_DEEP_SEARCH, 0) != 1) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        GlobalAssistantIntentSearchResponse r8 = (GlobalAssistantIntentSearchResponse) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new GlobalSearchForAppIntentIntent$doAction$response$1(r1, r5, r17, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), GlobalAssistantIntentSearchResponse.class, "com.obric.memorydata.plugin");
    L27:
        String r9 = EntityExtKt.getEntityGson().toJson(r8);
        RunLog.INSTANCE.debug(TAG, "logId: " + r5 + " return detail: " + r9);
        return new IntentResult(0, null, null, r9, false, false, 256, null, null, null, 950, null);
    L19:
        Integer r10 = r17.getLimitCount();
        if (r10 == null) goto L22;
        r7 = r10.intValue();
    L22:
        com.obric.memorydata.personalcontext.search.global.f r11 = com.obric.memorydata.personalcontext.search.global.f.f12331a;
        String r12 = r17.getMeta();
        if (r12 == null) goto L26;
        r3 = r12;
    L26:
        r8 = r11.a(r1, r5, r7, r3);
        goto L27
    L13:
        if (Intrinsics.areEqual(r17.getNeedDeepSearch(), Boxing.boxBoolean(true)) == true) goto L16;
        r6 = false;
        goto L17
    L7:
        r5 = "";
    L9:
        r5 = "";
        goto L10
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCGlobalSearchIntentIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }
}
