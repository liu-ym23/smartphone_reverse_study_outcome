package com.larus.bmhome.chat.trace.imspan.bean;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.trace.tracespan.span.b;
import com.larus.utils.logger.FLogger;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mo8.a;
import mo8.c;
import mo8.d;
import mo8.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/trace/imspan/bean/SpanRecord;", "Ljava/io/Serializable;", "localMessageId", "", "botId", "conversationId", "rootSpan", "Lcom/larus/trace/tracespan/span/ITraceSpanWrap;", "middleSpans", "", "Lcom/larus/bmhome/chat/trace/imspan/middlespan/BaseMsgMiddleSpan;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/trace/tracespan/span/ITraceSpanWrap;Ljava/util/List;)V", "getLocalMessageId", "()Ljava/lang/String;", "getBotId", "setBotId", "(Ljava/lang/String;)V", "getConversationId", "setConversationId", "getRootSpan", "()Lcom/larus/trace/tracespan/span/ITraceSpanWrap;", "getMiddleSpans", "()Ljava/util/List;", "getTraceKey", "getTrackParams", "Lorg/json/JSONObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpanRecord implements Serializable {
    private String botId;
    private String conversationId;
    private final String localMessageId;
    private final List<a> middleSpans;
    private final b rootSpan;

    public final String getTraceKey() {
        return this.rootSpan.f();
    }

    public final JSONObject getTrackParams() {
        return new JSONObject().put("bot_id", this.botId).put(MusicAppletPage.KEY_CONVERSATION_ID, this.conversationId);
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final List<a> getMiddleSpans() {
        return this.middleSpans;
    }

    public final b getRootSpan() {
        return this.rootSpan;
    }

    public final void setBotId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.botId = r2;
    }

    public final void setConversationId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.conversationId = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpanRecord(String r2, String r3, String r4, b r5, List<? extends a> r6) {
        Intrinsics.checkNotNullParameter(r2, "localMessageId");
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "rootSpan");
        Intrinsics.checkNotNullParameter(r6, "middleSpans");
        this.localMessageId = r2;
        this.botId = r3;
        this.conversationId = r4;
        this.rootSpan = r5;
        this.middleSpans = r6;
    }

    public SpanRecord(String r8, String r9, String r10, b r11, List r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r13 & 8) == 0) goto L13;
        int r15 = no8.b.a;
        Intrinsics.checkNotNullParameter(r8, "localMessageId");
        vx9.b.a r16 = new vx9.b.a();
        Intrinsics.checkNotNullParameter("im_message", "spanName");
        r16.a = "im_message";
        Intrinsics.checkNotNullParameter("message", "spanEventName");
        r16.c = "message";
        Intrinsics.checkNotNullParameter("message", "scene");
        r16.b = "message";
        r16.e = 300000;
        r11 = r16.a();
        r11.setTag("im_message");
        FLogger.a.i("IM_SPAN_TRACING", "startRootSpan, msg:" + r8 + ", name:im_message, spanId:" + r11.a());
    L13:
        b r5 = r11;
        if ((r13 & 16) == 0) goto L16;
        r12 = CollectionsKt.mutableListOf(new a[]{new e(r5), new c(r5), new mo8.b(r5), new d(r5)});
    L16:
        this(r8, r3, r4, r5, r12);
        return;
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
