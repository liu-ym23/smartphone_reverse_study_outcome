package com.obric.assistant.audio;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.audio.IObricEnrollTraceParamService;
import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J,\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/audio/ObricEnrollTraceParamServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricEnrollTraceParamService;", "<init>", "()V", "putEnterPageEventPara", NameKeys.UnloadStrategy_No_Strategy, "jsonObject", "Lorg/json/JSONObject;", "currentPage", NameKeys.UnloadStrategy_No_Strategy, "previousPage", "enterFrom", "putClickPageEventPara", "actionType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrollTraceParamServiceImpl implements IObricEnrollTraceParamService {
    public ObricEnrollTraceParamServiceImpl() {
    }

    public final void a(JSONObject r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "jsonObject");
        Intrinsics.checkNotNullParameter(r4, "currentPage");
        IObricTraceParam r0 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r0 == null) goto L6;
        r0.a(r3, r4, r5, r6);
        return;
    }

    public final void b(JSONObject r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "jsonObject");
        Intrinsics.checkNotNullParameter(r4, "currentPage");
        IObricTraceParam r0 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r0 == null) goto L6;
        r0.b(r3, r4, r5, r6);
        return;
    }
}
