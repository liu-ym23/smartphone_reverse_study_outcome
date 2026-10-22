package com.larus.bmhome.chat.trace.container;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static a a;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b=\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B¡\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010Z\u001a\u00020[R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010!\"\u0004\b0\u0010#R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\"\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b:\u00104\"\u0004\b;\u00106R\"\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b<\u00104\"\u0004\b=\u00106R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010!\"\u0004\b>\u0010#R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010!\"\u0004\b?\u0010#R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#R\u001a\u0010\u0013\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER\u001a\u0010\u0015\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER\u001a\u0010\u0016\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010C\"\u0004\bM\u0010ER\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010C\"\u0004\bO\u0010ER\u001a\u0010\u0019\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010C\"\u0004\bQ\u0010ER\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010C\"\u0004\bS\u0010ER\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010C\"\u0004\bU\u0010ER(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006\\"}, d2 = {"Lcom/larus/bmhome/chat/trace/container/EndToEndRenderTrace$EndToEndRenderRecord;", "Lcom/larus/bmhome/chat/trace/container/AppreciableRecord;", "sendMessageId", "", "messageId", "contentType", "", "lynxCardType", "lynxCardId", "lynxCardIntention", "lynxCardIntentionDetail", "endToEndDuration", "", "createCellDuration", "bindCellDuration", "lynxRenderDuration", "isDeepThinking", "isDeepThinkingShow", "localMessageId", "sendMessageTime", "sendMessageAckTime", "receiveFirstTokenTime", "createStartTime", "createEndTime", "bindStartTime", "bindEndTime", "renderStartTime", "renderEndTime", "intentionMap", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJJJJJLjava/util/Map;)V", "getSendMessageId", "()Ljava/lang/String;", "setSendMessageId", "(Ljava/lang/String;)V", "getMessageId", "setMessageId", "getContentType", "()Ljava/lang/Integer;", "setContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLynxCardType", "setLynxCardType", "getLynxCardId", "setLynxCardId", "getLynxCardIntention", "setLynxCardIntention", "getLynxCardIntentionDetail", "setLynxCardIntentionDetail", "getEndToEndDuration", "()Ljava/lang/Long;", "setEndToEndDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCreateCellDuration", "setCreateCellDuration", "getBindCellDuration", "setBindCellDuration", "getLynxRenderDuration", "setLynxRenderDuration", "setDeepThinking", "setDeepThinkingShow", "getLocalMessageId", "setLocalMessageId", "getSendMessageTime", "()J", "setSendMessageTime", "(J)V", "getSendMessageAckTime", "setSendMessageAckTime", "getReceiveFirstTokenTime", "setReceiveFirstTokenTime", "getCreateStartTime", "setCreateStartTime", "getCreateEndTime", "setCreateEndTime", "getBindStartTime", "setBindStartTime", "getBindEndTime", "setBindEndTime", "getRenderStartTime", "setRenderStartTime", "getRenderEndTime", "setRenderEndTime", "getIntentionMap", "()Ljava/util/Map;", "setIntentionMap", "(Ljava/util/Map;)V", "tryReport", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends com.larus.bmhome.chat.trace.container.a {
        public transient String a;
        public transient long b;

        @SerializedName("bind_cell_duration")
        private Long bindCellDuration;
        public transient long c;

        @SerializedName("content_type")
        private Integer contentType;

        @SerializedName("create_cell_duration")
        private Long createCellDuration;
        public transient long d;
        public transient long e;

        @SerializedName("end_to_end_duration")
        private Long endToEndDuration;
        public transient long f;
        public transient long g;
        public transient long h;
        public transient long i;

        @SerializedName("is_deep_thinking")
        private String isDeepThinking;

        @SerializedName("is_deep_thinking_show")
        private String isDeepThinkingShow;
        public transient long j;
        public transient Map<String, String> k;

        @SerializedName("lynx_card_id")
        private String lynxCardId;

        @SerializedName("lynx_card_intention")
        private String lynxCardIntention;

        @SerializedName("lynx_card_intention_detail")
        private String lynxCardIntentionDetail;

        @SerializedName("lynx_card_type")
        private Integer lynxCardType;

        @SerializedName("lynx_render_duration")
        private Long lynxRenderDuration;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageId;

        @SerializedName("send_message_id")
        private String sendMessageId;

        public a() {
            this(null);
        }

        public final void r() {
            long r0 = this.j;
            if (r0 <= 0) goto L5;
        L6:
            long r4 = this.b;
            if (r4 > 0) goto L9;
            return;
        L9:
            if (r0 <= 0) goto L11;
            Long r1 = Long.valueOf(r0 - r4);
        L12:
            d(r1);
            this.endToEndDuration = Long.valueOf(this.d - this.b);
            this.createCellDuration = Long.valueOf(this.f - this.e);
            this.bindCellDuration = Long.valueOf(this.h - this.g);
            this.lynxRenderDuration = Long.valueOf(this.j - this.i);
            a("EndToEndRenderTrace", this.k);
            return;
        L11:
            r1 = Long.valueOf(this.h - r4);
            goto L12
        L5:
            if (this.h > 0) goto L6;
        }

        public final Integer e() {
            return this.contentType;
        }

        public final Integer f() {
            return this.lynxCardType;
        }

        public final String g() {
            return this.messageId;
        }

        public final String h() {
            return this.sendMessageId;
        }

        public a(Object r3) {
            super(0);
            this.sendMessageId = null;
            this.messageId = null;
            this.contentType = null;
            this.lynxCardType = null;
            this.lynxCardId = null;
            this.lynxCardIntention = null;
            this.lynxCardIntentionDetail = null;
            this.endToEndDuration = null;
            this.createCellDuration = null;
            this.bindCellDuration = null;
            this.lynxRenderDuration = null;
            this.isDeepThinking = null;
            this.isDeepThinkingShow = null;
            this.a = null;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = null;
        }

        public final void i(Integer r1) {
            this.contentType = r1;
        }

        public final void j(String r1) {
            this.isDeepThinking = r1;
        }

        public final void k(String r1) {
            this.isDeepThinkingShow = r1;
        }

        public final void l(String r1) {
            this.lynxCardId = r1;
        }

        public final void m(String r1) {
            this.lynxCardIntention = r1;
        }

        public final void n(String r1) {
            this.lynxCardIntentionDetail = r1;
        }

        public final void o(Integer r1) {
            this.lynxCardType = r1;
        }

        public final void p(String r1) {
            this.messageId = r1;
        }

        public final void q(String r1) {
            this.sendMessageId = r1;
        }
    }

    static {
    }
}
