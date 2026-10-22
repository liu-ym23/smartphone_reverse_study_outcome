package com.obric.assistant.spi.audio;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0096\u0001J-\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricEnrollTraceParamDelegate;", "Lcom/obric/assistant/spi/audio/IObricEnrollTraceParamService;", "<init>", "()V", "putClickPageEventPara", "", "jsonObject", "Lorg/json/JSONObject;", "currentPage", "", "actionType", "enterFrom", "putEnterPageEventPara", "previousPage", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrollTraceParamDelegate implements IObricEnrollTraceParamService {
    public static final ObricEnrollTraceParamDelegate b = null;
    public final /* synthetic */ IObricEnrollTraceParamService a;

    static {
        b = new ObricEnrollTraceParamDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollTraceParamService
    public final void a(JSONObject r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        this.a.a(r2, r3, r4, r5);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollTraceParamService
    public final void b(JSONObject r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        this.a.b(r2, r3, r4, r5);
    }

    private ObricEnrollTraceParamDelegate() {
        IObricEnrollTraceParamService r0 = (IObricEnrollTraceParamService) ServiceManager.get().getService(IObricEnrollTraceParamService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricEnrollTraceParamServiceImpl();
    L5:
        this.a = r0;
    }
}
