package com.larus.platform.spi;

import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J\u0018\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J \u0010!\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016J \u0010$\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0016J\u001e\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J&\u0010(\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J \u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J&\u0010+\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0006H\u0016J(\u00100\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006H\u0016J$\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/platform/spi/AIChatRenderTraceServiceNoop;", "Lcom/larus/platform/spi/IAIChatRenderTraceService;", "<init>", "()V", "springTraceDataMap", "", "", "templatePromptMap", "", "autoFillPromptMap", "creationInfoMap", "Lkotlin/Pair;", "templateInfoMap", "sendMessageTrackExtMap", "actionbarRecommendInfoMap", "Lkotlin/Triple;", "", "setSpringTraceDataMap", "", "traceDataMap", "getSpringTraceDataMap", "clearSpringTraceDataMap", "onRender", "msg", "Lcom/larus/im/bean/message/Message;", "clear", "getTemplatePromptString", "cvsId", "setTemplatePromptString", "string", "getAutoFillPromptString", "setAutoFillPromptString", "getCreationInfo", "setCreationInfo", "creationId", "creationType", "setTemplateInfo", "templateId", "templateType", "getTemplateInfo", "setSendMessageTrackExtMap", "sendMessageTrackMap", "getSendMessageTrackExtMap", "updateSendMessageTrackExtMap", "removeSendMessageTrackExtMap", "key", "onReceiveAudioData", "taskId", "setActionbarRecommendInfo", "actionBarItemId", "recommendRequestID", "actionbarRecommendFrom", "getActionbarRecommendInfo", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AIChatRenderTraceServiceNoop implements IAIChatRenderTraceService {
    public Map<String, String> b;
    public final Map<String, String> c;
    public final Map<String, String> d;
    public final Map<String, Map<String, String>> e;

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void l() {
        this.b = null;
    }

    public AIChatRenderTraceServiceNoop() {
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        new LinkedHashMap();
        new LinkedHashMap();
        this.e = new LinkedHashMap();
        new LinkedHashMap();
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final Map<String, String> i() {
        return this.b;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final Map<String, String> d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        return (Map) ((LinkedHashMap) this.e).get(r2);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        String r3 = (String) ((LinkedHashMap) this.c).get(r2);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void h(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "traceDataMap");
        this.b = r2;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final String k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        String r3 = (String) ((LinkedHashMap) this.d).get(r2);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void c(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "sendMessageTrackMap");
        this.e.put(r2, r3);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void e(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "cvsId");
        Intrinsics.checkNotNullParameter(r4, "sendMessageTrackMap");
        Map<String, Map<String, String>> r0 = this.e;
        Map r1 = (Map) ((LinkedHashMap) r0).get(r3);
        if (r1 != null) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        r0.put(r3, MapsKt.plus(r1, r4));
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "string");
        this.c.put(r2, r3);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void m(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "string");
        this.d.put(r2, r3);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void n(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "cvsId");
        Intrinsics.checkNotNullParameter(r4, "key");
        Map<String, Map<String, String>> r0 = this.e;
        Map r1 = (Map) ((LinkedHashMap) r0).get(r3);
        if (r1 != null) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        r0.put(r3, MapsKt.minus(r1, r4));
    }
}
