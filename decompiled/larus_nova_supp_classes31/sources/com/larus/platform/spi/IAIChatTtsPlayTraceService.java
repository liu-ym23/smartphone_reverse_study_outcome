package com.larus.platform.spi;

import by7.e;
import com.larus.bmhome.chat.component.list.h0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wq8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000  2\u00020\u0001:\u0001 J.\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u0007H&J\u001a\u0010\n\u001a\u00020\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007H&J\u001a\u0010\r\u001a\u00020\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007H&JH\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\fH&J \u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J.\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH&¨\u0006!"}, d2 = {"Lcom/larus/platform/spi/IAIChatTtsPlayTraceService;", "", "bindSocialMessageListSource", "", "iTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "getter", "Lkotlin/Function0;", "", "Lcom/larus/im/bean/message/Message;", "setChatTypeFetcher", "chatTypeGetter", "", "setExtraCommonParams", "commonParamsGetter", "Lorg/json/JSONObject;", "startTTS", "taskId", "startTTSReason", "messageID", "voiceID", "ttsSpeaker", "traceInfo", "stopTTS", "stopTTSReason", "bindPageMessageListSource", "adapter", "Lcom/larus/bmhome/list/ICoreMessageListAdapter;", "onSentenceStart", "sentenceTxt", "sentenceInst", "sentenceRes", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IAIChatTtsPlayTraceService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J+\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u000b\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0018\u00010\fH\u0096\u0001J/\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\u00052\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fH\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\fH\u0096\u0001JC\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0096\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0096\u0001¨\u0006\""}, d2 = {"Lcom/larus/platform/spi/IAIChatTtsPlayTraceService$Companion;", "Lcom/larus/platform/spi/IAIChatTtsPlayTraceService;", "<init>", "()V", "bindPageMessageListSource", "", "iTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "adapter", "Lcom/larus/bmhome/list/ICoreMessageListAdapter;", "bindSocialMessageListSource", "getter", "Lkotlin/Function0;", "", "Lcom/larus/im/bean/message/Message;", "onSentenceStart", "taskId", "", "sentenceTxt", "sentenceInst", "sentenceRes", "setChatTypeFetcher", "chatTypeGetter", "setExtraCommonParams", "commonParamsGetter", "Lorg/json/JSONObject;", "startTTS", "startTTSReason", "messageID", "voiceID", "ttsSpeaker", "traceInfo", "stopTTS", "stopTTSReason", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IAIChatTtsPlayTraceService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IAIChatTtsPlayTraceService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
        public final void a(String r2) {
            this.b.a(r2);
        }

        @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
        public final void b(h0 r2) {
            this.b.b(r2);
        }

        @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
        public final void c(e r2, b r3) {
            this.b.c(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
        public final void d(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            this.b.d(r2, r3, r4, r5);
        }

        private Companion() {
            IAIChatTtsPlayTraceService r0 = (IAIChatTtsPlayTraceService) ServiceManager.get().getService(IAIChatTtsPlayTraceService.class);
            if (r0 != null) goto L5;
            r0 = new AIChatTtsPlayTraceServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    void a(String r1);

    void b(h0 r1);

    void c(e r1, b r2);

    void d(String r1, String r2, String r3, String r4);
}
