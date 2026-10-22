package com.larus.platform.spi;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 +2\u00020\u0001:\u0001+J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H&J\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u0006H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H&J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H&J\u001e\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u0006H&J&\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&J \u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0006H&J&\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0006H&J(\u0010$\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H&J$\u0010)\u001a\u0016\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010*2\u0006\u0010\u000e\u001a\u00020\u0006H&¨\u0006,"}, d2 = {"Lcom/larus/platform/spi/IAIChatRenderTraceService;", "", "setSpringTraceDataMap", "", "traceDataMap", "", "", "getSpringTraceDataMap", "clearSpringTraceDataMap", "onRender", "msg", "Lcom/larus/im/bean/message/Message;", "clear", "getTemplatePromptString", "cvsId", "setTemplatePromptString", "string", "getAutoFillPromptString", "setAutoFillPromptString", "getCreationInfo", "Lkotlin/Pair;", "setCreationInfo", "creationId", "creationType", "setTemplateInfo", "templateId", "templateType", "getTemplateInfo", "setSendMessageTrackExtMap", "sendMessageTrackMap", "getSendMessageTrackExtMap", "updateSendMessageTrackExtMap", "removeSendMessageTrackExtMap", "key", "onReceiveAudioData", "taskId", "setActionbarRecommendInfo", "actionBarItemId", "", "recommendRequestID", "actionbarRecommendFrom", "getActionbarRecommendInfo", "Lkotlin/Triple;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IAIChatRenderTraceService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0010H\u0096\u0001J\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\u0019\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0096\u0001J)\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0096\u0001J!\u0010!\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0096\u0001J'\u0010$\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010H\u0096\u0001J\u001f\u0010&\u001a\u00020\u00052\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010H\u0096\u0001J!\u0010(\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0096\u0001J\u0019\u0010+\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0096\u0001J'\u0010,\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010H\u0096\u0001¨\u0006-"}, d2 = {"Lcom/larus/platform/spi/IAIChatRenderTraceService$Companion;", "Lcom/larus/platform/spi/IAIChatRenderTraceService;", "<init>", "()V", "clear", "", "clearSpringTraceDataMap", "getActionbarRecommendInfo", "Lkotlin/Triple;", "", "", "cvsId", "getAutoFillPromptString", "getCreationInfo", "Lkotlin/Pair;", "getSendMessageTrackExtMap", "", "getSpringTraceDataMap", "getTemplateInfo", "getTemplatePromptString", "onReceiveAudioData", "taskId", "onRender", "msg", "Lcom/larus/im/bean/message/Message;", "removeSendMessageTrackExtMap", "key", "setActionbarRecommendInfo", "actionBarItemId", "recommendRequestID", "actionbarRecommendFrom", "setAutoFillPromptString", "string", "setCreationInfo", "creationId", "creationType", "setSendMessageTrackExtMap", "sendMessageTrackMap", "setSpringTraceDataMap", "traceDataMap", "setTemplateInfo", "templateId", "templateType", "setTemplatePromptString", "updateSendMessageTrackExtMap", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IAIChatRenderTraceService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IAIChatRenderTraceService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void c(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            Intrinsics.checkNotNullParameter(r3, "sendMessageTrackMap");
            this.b.c(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final Map<String, String> d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            return this.b.d(r2);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void e(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            Intrinsics.checkNotNullParameter(r3, "sendMessageTrackMap");
            this.b.e(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final String f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            return this.b.f(r2);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void g(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            Intrinsics.checkNotNullParameter(r3, "string");
            this.b.g(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void h(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "traceDataMap");
            this.b.h(r2);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final Map<String, String> i() {
            return this.b.i();
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            this.b.j(r2);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final String k(String r2) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            return this.b.k(r2);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void l() {
            this.b.l();
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void m(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            Intrinsics.checkNotNullParameter(r3, "string");
            this.b.m(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void n(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            Intrinsics.checkNotNullParameter(r3, "key");
            this.b.n(r2, r3);
        }

        private Companion() {
            IAIChatRenderTraceService r0 = (IAIChatRenderTraceService) ServiceManager.get().getService(IAIChatRenderTraceService.class);
            if (r0 != null) goto L5;
            r0 = new AIChatRenderTraceServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    void c(String r1, Map<String, String> r2);

    Map<String, String> d(String r1);

    void e(String r1, Map<String, String> r2);

    String f(String r1);

    void g(String r1, String r2);

    void h(Map<String, String> r1);

    Map<String, String> i();

    void j(String r1);

    String k(String r1);

    void l();

    void m(String r1, String r2);

    void n(String r1, String r2);
}
