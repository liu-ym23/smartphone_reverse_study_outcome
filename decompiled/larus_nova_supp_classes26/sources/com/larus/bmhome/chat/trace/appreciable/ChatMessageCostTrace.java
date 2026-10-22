package com.larus.bmhome.chat.trace.appreciable;

import android.os.Handler;
import android.os.SystemClock;
import androidx.collection.LruCache;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.trace.imspan.IMSpanManager;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageCostTrace {
    public static final ChatMessageCostTrace a = null;
    public static final Set<String> b = null;
    public static final LruCache<String, StepRecord> c = null;
    public static final ThreadLocal<List<Function1<Long, Unit>>> d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\"\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$AllCompleteStep;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$StepRecord;", "sendMsgId", "", "durationWithoutSuggest", "", "intention", "firstLoadingDuration", "firstCotDuration", "firstAnswerDuration", "taskFinishDuration", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getSendMsgId", "()Ljava/lang/String;", "setSendMsgId", "(Ljava/lang/String;)V", "getDurationWithoutSuggest", "()Ljava/lang/Long;", "setDurationWithoutSuggest", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getIntention", "setIntention", "getFirstLoadingDuration", "setFirstLoadingDuration", "getFirstCotDuration", "setFirstCotDuration", "getFirstAnswerDuration", "setFirstAnswerDuration", "getTaskFinishDuration", "setTaskFinishDuration", "report", "", "getEventKey", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AllCompleteStep extends StepRecord {

        @SerializedName("duration_without_suggest")
        private Long durationWithoutSuggest;

        @SerializedName("first_answer_duration")
        private Long firstAnswerDuration;

        @SerializedName("first_cot_duration")
        private Long firstCotDuration;

        @SerializedName("first_loading_duration")
        private Long firstLoadingDuration;

        @SerializedName("intention")
        private String intention;

        @SerializedName("reply_id")
        private String sendMsgId;

        @SerializedName("task_finish_duration")
        private Long taskFinishDuration;

        public AllCompleteStep() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public String getEventKey() {
            return "message_all_complete_shown";
        }

        public final Long getDurationWithoutSuggest() {
            return this.durationWithoutSuggest;
        }

        public final Long getFirstAnswerDuration() {
            return this.firstAnswerDuration;
        }

        public final Long getFirstCotDuration() {
            return this.firstCotDuration;
        }

        public final Long getFirstLoadingDuration() {
            return this.firstLoadingDuration;
        }

        public final String getIntention() {
            return this.intention;
        }

        public final String getSendMsgId() {
            return this.sendMsgId;
        }

        public final Long getTaskFinishDuration() {
            return this.taskFinishDuration;
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public void report(String r3) {
            Intrinsics.checkNotNullParameter(r3, "sendMsgId");
            CommonParamManager.CommonParam r0 = CommonParamManager.c(r3);
            if (r0 == null) goto L7;
            ConcurrentHashMap<String, Long> r1 = r0.getPerfMarkDurations();
            if (r1 == null) goto L7;
            this.firstLoadingDuration = r1.get("loading_first_token");
            this.firstCotDuration = r1.get("cot_first_token");
            this.firstAnswerDuration = r1.get("answer_first_token");
            this.taskFinishDuration = r1.get("task_finish");
        L7:
            super.report(r3);
        }

        public final void setDurationWithoutSuggest(Long r1) {
            this.durationWithoutSuggest = r1;
        }

        public final void setFirstAnswerDuration(Long r1) {
            this.firstAnswerDuration = r1;
        }

        public final void setFirstCotDuration(Long r1) {
            this.firstCotDuration = r1;
        }

        public final void setFirstLoadingDuration(Long r1) {
            this.firstLoadingDuration = r1;
        }

        public final void setIntention(String r1) {
            this.intention = r1;
        }

        public final void setSendMsgId(String r1) {
            this.sendMsgId = r1;
        }

        public final void setTaskFinishDuration(Long r1) {
            this.taskFinishDuration = r1;
        }

        public AllCompleteStep(String r9, Long r10, String r11, Long r12, Long r13, Long r14, Long r15) {
            super(0, null, null, null, 15, null);
            this.sendMsgId = r9;
            this.durationWithoutSuggest = r10;
            this.intention = r11;
            this.firstLoadingDuration = r12;
            this.firstCotDuration = r13;
            this.firstAnswerDuration = r14;
            this.taskFinishDuration = r15;
        }

        public /* synthetic */ AllCompleteStep(String r7, Long r8, String r9, Long r10, Long r11, Long r12, Long r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L5;
            String r16 = null;
        L7:
            if ((r14 & 2) == 0) goto L9;
            Long r1 = null;
        L11:
            if ((r14 & 4) == 0) goto L13;
            String r2 = null;
        L15:
            if ((r14 & 8) == 0) goto L17;
            Long r3 = null;
        L19:
            if ((r14 & 16) == 0) goto L21;
            Long r4 = null;
        L23:
            if ((r14 & 32) == 0) goto L25;
            Long r5 = null;
        L27:
            if ((r14 & 64) == 0) goto L29;
            Long r17 = null;
        L30:
            this(r16, r1, r2, r3, r4, r5, r17);
            return;
        L29:
            r17 = r13;
            goto L30
        L25:
            r5 = r12;
            goto L27
        L21:
            r4 = r11;
            goto L23
        L17:
            r3 = r10;
            goto L19
        L13:
            r2 = r9;
            goto L15
        L9:
            r1 = r8;
            goto L11
        L5:
            r16 = r7;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0099\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020&0%\u0012\b\b\u0002\u0010'\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0010\u0010s\u001a\u00020t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010u\u001a\u00020\u0005H\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\"\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b;\u00105\"\u0004\b<\u00107R\"\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b=\u00105\"\u0004\b>\u00107R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b?\u00105\"\u0004\b@\u00107R\"\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bA\u00105\"\u0004\bB\u00107R\"\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bC\u00105\"\u0004\bD\u00107R \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00101\"\u0004\bF\u00103R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00101\"\u0004\bL\u00103R \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00101\"\u0004\bN\u00103R \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u00101\"\u0004\bO\u00103R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00101\"\u0004\bP\u00103R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bQ\u00105\"\u0004\bR\u00107R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bS\u00105\"\u0004\bT\u00107R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bU\u00105\"\u0004\bV\u00107R,\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b[\u00105\"\u0004\b\\\u00107R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b]\u00105\"\u0004\b^\u00107R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b_\u00105\"\u0004\b`\u00107R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\ba\u00105\"\u0004\bb\u00107R \u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u00101\"\u0004\bc\u00103R \u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u00101\"\u0004\bd\u00103R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\be\u00105\"\u0004\bf\u00107R\"\u0010 \u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bg\u00105\"\u0004\bh\u00107R\"\u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bi\u00105\"\u0004\bj\u00107R\"\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bk\u00105\"\u0004\bl\u00107R \u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00101\"\u0004\bn\u00103R\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020&0%¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bq\u0010r¨\u0006v"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$AllFirstStep;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$StepRecord;", "contentType", "", "sendMsgId", "", "durationSdkToCallback", "", "durationFromCallback", "durationFromSdk", "totalTimeDiffWithSdk", "sendStartToSdkDuration", "sdkDuration", "businessDuration", "receiveMsgId", "status", "intention", "llmModelType", "isWebSearch", "isFromCache", "startSendTimeInMillSec", "sendEndTimeInMillSec", "firstTokenTimeMillSec", "detailTimelines", "", "deepthinkingDuration", "deepthinkingDurationFromSdk", "mainTextDuration", "mainTextDurationFromSdk", "isReferMessage", "isSubMessage", "firstLoadingDuration", "firstCotDuration", "firstAnswerDuration", "taskFinishDuration", "hasEnterBackground", "childSteps", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$ChildStepRecord;", "hasReported", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;Ljava/util/concurrent/atomic/AtomicBoolean;)V", "getContentType", "()Ljava/lang/Integer;", "setContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSendMsgId", "()Ljava/lang/String;", "setSendMsgId", "(Ljava/lang/String;)V", "getDurationSdkToCallback", "()Ljava/lang/Long;", "setDurationSdkToCallback", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDurationFromCallback", "setDurationFromCallback", "getDurationFromSdk", "setDurationFromSdk", "getTotalTimeDiffWithSdk", "setTotalTimeDiffWithSdk", "getSendStartToSdkDuration", "setSendStartToSdkDuration", "getSdkDuration", "setSdkDuration", "getBusinessDuration", "setBusinessDuration", "getReceiveMsgId", "setReceiveMsgId", "getStatus", "()I", "setStatus", "(I)V", "getIntention", "setIntention", "getLlmModelType", "setLlmModelType", "setWebSearch", "setFromCache", "getStartSendTimeInMillSec", "setStartSendTimeInMillSec", "getSendEndTimeInMillSec", "setSendEndTimeInMillSec", "getFirstTokenTimeMillSec", "setFirstTokenTimeMillSec", "getDetailTimelines", "()Ljava/util/Map;", "setDetailTimelines", "(Ljava/util/Map;)V", "getDeepthinkingDuration", "setDeepthinkingDuration", "getDeepthinkingDurationFromSdk", "setDeepthinkingDurationFromSdk", "getMainTextDuration", "setMainTextDuration", "getMainTextDurationFromSdk", "setMainTextDurationFromSdk", "setReferMessage", "setSubMessage", "getFirstLoadingDuration", "setFirstLoadingDuration", "getFirstCotDuration", "setFirstCotDuration", "getFirstAnswerDuration", "setFirstAnswerDuration", "getTaskFinishDuration", "setTaskFinishDuration", "getHasEnterBackground", "setHasEnterBackground", "getChildSteps", "()Ljava/util/concurrent/ConcurrentHashMap;", "getHasReported", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "report", "", "getEventKey", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AllFirstStep extends StepRecord {

        @SerializedName("business_duration")
        private Long businessDuration;
        private final transient ConcurrentHashMap<String, ChildStepRecord> childSteps;

        @SerializedName("content_type")
        private Integer contentType;

        @SerializedName("deepthinking_duration")
        private Long deepthinkingDuration;

        @SerializedName("deepthinking_duration_from_sdk")
        private Long deepthinkingDurationFromSdk;

        @SerializedName("received_detail_timelines")
        private Map<String, Long> detailTimelines;

        @SerializedName("duration_from_callback")
        private Long durationFromCallback;

        @SerializedName("duration_from_sdk")
        private Long durationFromSdk;

        @SerializedName("duration_sdk_to_callback")
        private Long durationSdkToCallback;

        @SerializedName("first_answer_duration")
        private Long firstAnswerDuration;

        @SerializedName("first_cot_duration")
        private Long firstCotDuration;

        @SerializedName("first_loading_duration")
        private Long firstLoadingDuration;

        @SerializedName("first_token_time_mill_sec")
        private Long firstTokenTimeMillSec;

        @SerializedName("has_enter_background")
        private String hasEnterBackground;
        private final transient AtomicBoolean hasReported;

        @SerializedName("intention")
        private String intention;

        @SerializedName("is_from_cache")
        private String isFromCache;

        @SerializedName("is_refer_message")
        private String isReferMessage;

        @SerializedName("is_sub_message")
        private String isSubMessage;

        @SerializedName("is_web_search")
        private String isWebSearch;

        @SerializedName("llm_model_type")
        private String llmModelType;

        @SerializedName("main_text_duration")
        private Long mainTextDuration;

        @SerializedName("main_text_duration_from_sdk")
        private Long mainTextDurationFromSdk;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String receiveMsgId;

        @SerializedName("sdk_duration")
        private Long sdkDuration;

        @SerializedName("end_time_mill_sec")
        private Long sendEndTimeInMillSec;

        @SerializedName("reply_id")
        private String sendMsgId;

        @SerializedName("send_start_to_sdk_duration")
        private Long sendStartToSdkDuration;

        @SerializedName("start_time_mill_sec")
        private Long startSendTimeInMillSec;

        @SerializedName("status")
        private int status;

        @SerializedName("task_finish_duration")
        private Long taskFinishDuration;

        @SerializedName("total_time_diff_with_sdk")
        private Long totalTimeDiffWithSdk;

        public AllFirstStep() {
            this(null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, null);
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public String getEventKey() {
            return "message_all_first_shown";
        }

        public final Long getBusinessDuration() {
            return this.businessDuration;
        }

        public final ConcurrentHashMap<String, ChildStepRecord> getChildSteps() {
            return this.childSteps;
        }

        public final Integer getContentType() {
            return this.contentType;
        }

        public final Long getDeepthinkingDuration() {
            return this.deepthinkingDuration;
        }

        public final Long getDeepthinkingDurationFromSdk() {
            return this.deepthinkingDurationFromSdk;
        }

        public final Map<String, Long> getDetailTimelines() {
            return this.detailTimelines;
        }

        public final Long getDurationFromCallback() {
            return this.durationFromCallback;
        }

        public final Long getDurationFromSdk() {
            return this.durationFromSdk;
        }

        public final Long getDurationSdkToCallback() {
            return this.durationSdkToCallback;
        }

        public final Long getFirstAnswerDuration() {
            return this.firstAnswerDuration;
        }

        public final Long getFirstCotDuration() {
            return this.firstCotDuration;
        }

        public final Long getFirstLoadingDuration() {
            return this.firstLoadingDuration;
        }

        public final Long getFirstTokenTimeMillSec() {
            return this.firstTokenTimeMillSec;
        }

        public final String getHasEnterBackground() {
            return this.hasEnterBackground;
        }

        public final AtomicBoolean getHasReported() {
            return this.hasReported;
        }

        public final String getIntention() {
            return this.intention;
        }

        public final String getLlmModelType() {
            return this.llmModelType;
        }

        public final Long getMainTextDuration() {
            return this.mainTextDuration;
        }

        public final Long getMainTextDurationFromSdk() {
            return this.mainTextDurationFromSdk;
        }

        public final String getReceiveMsgId() {
            return this.receiveMsgId;
        }

        public final Long getSdkDuration() {
            return this.sdkDuration;
        }

        public final Long getSendEndTimeInMillSec() {
            return this.sendEndTimeInMillSec;
        }

        public final String getSendMsgId() {
            return this.sendMsgId;
        }

        public final Long getSendStartToSdkDuration() {
            return this.sendStartToSdkDuration;
        }

        public final Long getStartSendTimeInMillSec() {
            return this.startSendTimeInMillSec;
        }

        public final int getStatus() {
            return this.status;
        }

        public final Long getTaskFinishDuration() {
            return this.taskFinishDuration;
        }

        public final Long getTotalTimeDiffWithSdk() {
            return this.totalTimeDiffWithSdk;
        }

        public final String isFromCache() {
            return this.isFromCache;
        }

        public final String isReferMessage() {
            return this.isReferMessage;
        }

        public final String isSubMessage() {
            return this.isSubMessage;
        }

        public final String isWebSearch() {
            return this.isWebSearch;
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public void report(String r10) {
            Intrinsics.checkNotNullParameter(r10, "sendMsgId");
            boolean r2 = true;
            if (this.hasReported.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            CommonParamManager.CommonParam r0 = CommonParamManager.c(r10);
            if (r0 != null) goto L8;
        L10:
            boolean r1 = false;
        L11:
            if (r1 == false) goto L13;
            String r3 = "1";
        L14:
            this.hasEnterBackground = r3;
            CommonParamManager.CommonParam r4 = CommonParamManager.c(r10);
            if (r4 == null) goto L17;
            Long r5 = r4.getSendToSdkTimeDuration();
        L18:
            this.sendStartToSdkDuration = r5;
            CommonParamManager.CommonParam r6 = CommonParamManager.c(r10);
            if (r6 == null) goto L22;
            String r7 = r6.isFromCache();
            if (r7 == null) goto L22;
        L23:
            this.isFromCache = r7;
            CommonParamManager.CommonParam r8 = CommonParamManager.c(r10);
            if (r8 == null) goto L28;
            ConcurrentHashMap<String, Long> r9 = r8.getPerfMarkDurations();
            if (r9 == null) goto L28;
            this.firstLoadingDuration = r9.get("loading_first_token");
            this.firstCotDuration = r9.get("cot_first_token");
            this.firstAnswerDuration = r9.get("answer_first_token");
            this.taskFinishDuration = r9.get("task_finish");
        L28:
            Long r11 = getDuration(r10);
            if (r11 == null) goto L44;
            long r12 = r11.longValue();
            Long r13 = this.totalTimeDiffWithSdk;
            if (r13 != null) goto L33;
        L35:
            ChatMessageCostTrace.a.getClass();
            if (1 <= r12) goto L38;
        L40:
            r2 = false;
        L41:
            if (r2 == false) goto L43;
            this.status = 0;
            goto L44
        L43:
            this.status = -999;
            goto L44
        L38:
            if (r12 >= 300000) goto L40;
        L33:
            if (r13.longValue() > 0) goto L35;
            this.status = -10;
        L44:
            super.report(r10);
            return;
        L22:
            r7 = "";
            goto L23
        L17:
            r5 = null;
            goto L18
        L13:
            r3 = TriggerSendLoading.NO_LOADING;
            goto L14
        L8:
            if (r0.getHasEnterBackground() != true) goto L10;
            r1 = true;
            goto L11
        }

        public final void setBusinessDuration(Long r1) {
            this.businessDuration = r1;
        }

        public final void setContentType(Integer r1) {
            this.contentType = r1;
        }

        public final void setDeepthinkingDuration(Long r1) {
            this.deepthinkingDuration = r1;
        }

        public final void setDeepthinkingDurationFromSdk(Long r1) {
            this.deepthinkingDurationFromSdk = r1;
        }

        public final void setDetailTimelines(Map<String, Long> r1) {
            this.detailTimelines = r1;
        }

        public final void setDurationFromCallback(Long r1) {
            this.durationFromCallback = r1;
        }

        public final void setDurationFromSdk(Long r1) {
            this.durationFromSdk = r1;
        }

        public final void setDurationSdkToCallback(Long r1) {
            this.durationSdkToCallback = r1;
        }

        public final void setFirstAnswerDuration(Long r1) {
            this.firstAnswerDuration = r1;
        }

        public final void setFirstCotDuration(Long r1) {
            this.firstCotDuration = r1;
        }

        public final void setFirstLoadingDuration(Long r1) {
            this.firstLoadingDuration = r1;
        }

        public final void setFirstTokenTimeMillSec(Long r1) {
            this.firstTokenTimeMillSec = r1;
        }

        public final void setFromCache(String r1) {
            this.isFromCache = r1;
        }

        public final void setHasEnterBackground(String r1) {
            this.hasEnterBackground = r1;
        }

        public final void setIntention(String r1) {
            this.intention = r1;
        }

        public final void setLlmModelType(String r1) {
            this.llmModelType = r1;
        }

        public final void setMainTextDuration(Long r1) {
            this.mainTextDuration = r1;
        }

        public final void setMainTextDurationFromSdk(Long r1) {
            this.mainTextDurationFromSdk = r1;
        }

        public final void setReceiveMsgId(String r1) {
            this.receiveMsgId = r1;
        }

        public final void setReferMessage(String r1) {
            this.isReferMessage = r1;
        }

        public final void setSdkDuration(Long r1) {
            this.sdkDuration = r1;
        }

        public final void setSendEndTimeInMillSec(Long r1) {
            this.sendEndTimeInMillSec = r1;
        }

        public final void setSendMsgId(String r1) {
            this.sendMsgId = r1;
        }

        public final void setSendStartToSdkDuration(Long r1) {
            this.sendStartToSdkDuration = r1;
        }

        public final void setStartSendTimeInMillSec(Long r1) {
            this.startSendTimeInMillSec = r1;
        }

        public final void setStatus(int r1) {
            this.status = r1;
        }

        public final void setSubMessage(String r1) {
            this.isSubMessage = r1;
        }

        public final void setTaskFinishDuration(Long r1) {
            this.taskFinishDuration = r1;
        }

        public final void setTotalTimeDiffWithSdk(Long r1) {
            this.totalTimeDiffWithSdk = r1;
        }

        public final void setWebSearch(String r1) {
            this.isWebSearch = r1;
        }

        public AllFirstStep(Integer r12, String r13, Long r14, Long r15, Long r16, Long r17, Long r18, Long r19, Long r20, String r21, int r22, String r23, String r24, String r25, String r26, Long r27, Long r28, Long r29, Map<String, Long> r30, Long r31, Long r32, Long r33, Long r34, String r35, String r36, Long r37, Long r38, Long r39, Long r40, String r41, ConcurrentHashMap<String, ChildStepRecord> r42, AtomicBoolean r43) {
            Intrinsics.checkNotNullParameter(r42, "childSteps");
            Intrinsics.checkNotNullParameter(r43, "hasReported");
            super(0, null, null, null, 15, null);
            this.contentType = r12;
            this.sendMsgId = r13;
            this.durationSdkToCallback = r14;
            this.durationFromCallback = r15;
            this.durationFromSdk = r16;
            this.totalTimeDiffWithSdk = r17;
            this.sendStartToSdkDuration = r18;
            this.sdkDuration = r19;
            this.businessDuration = r20;
            this.receiveMsgId = r21;
            this.status = r22;
            this.intention = r23;
            this.llmModelType = r24;
            this.isWebSearch = r25;
            this.isFromCache = r26;
            this.startSendTimeInMillSec = r27;
            this.sendEndTimeInMillSec = r28;
            this.firstTokenTimeMillSec = r29;
            this.detailTimelines = r30;
            this.deepthinkingDuration = r31;
            this.deepthinkingDurationFromSdk = r32;
            this.mainTextDuration = r33;
            this.mainTextDurationFromSdk = r34;
            this.isReferMessage = r35;
            this.isSubMessage = r36;
            this.firstLoadingDuration = r37;
            this.firstCotDuration = r38;
            this.firstAnswerDuration = r39;
            this.taskFinishDuration = r40;
            this.hasEnterBackground = r41;
            this.childSteps = r42;
            this.hasReported = r43;
        }

        public /* synthetic */ AllFirstStep(Integer r34, String r35, Long r36, Long r37, Long r38, Long r39, Long r40, Long r41, Long r42, String r43, int r44, String r45, String r46, String r47, String r48, Long r49, Long r50, Long r51, Map r52, Long r53, Long r54, Long r55, Long r56, String r57, String r58, Long r59, Long r60, Long r61, Long r62, String r63, ConcurrentHashMap r64, AtomicBoolean r65, int r66, DefaultConstructorMarker r67) {
            if ((r66 & 1) == 0) goto L5;
            Integer r1 = null;
        L7:
            if ((r66 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r66 & 4) == 0) goto L13;
            Long r4 = null;
        L15:
            if ((r66 & 8) == 0) goto L17;
            Long r5 = null;
        L19:
            if ((r66 & 16) == 0) goto L21;
            Long r6 = null;
        L23:
            if ((r66 & 32) == 0) goto L25;
            Long r7 = null;
        L27:
            if ((r66 & 64) == 0) goto L29;
            Long r8 = null;
        L31:
            if ((r66 & 128) == 0) goto L33;
            Long r9 = null;
        L35:
            if ((r66 & 256) == 0) goto L37;
            Long r10 = null;
        L39:
            if ((r66 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r66 & 1024) == 0) goto L45;
            int r12 = -1;
        L47:
            if ((r66 & 2048) == 0) goto L49;
            String r13 = "";
        L51:
            if ((r66 & 4096) == 0) goto L53;
            String r15 = "";
        L55:
            if ((r66 & 8192) == 0) goto L57;
            String r2 = "";
        L59:
            if ((r66 & 16384) == 0) goto L61;
            String r14 = "";
        L63:
            if ((r66 & 32768) == 0) goto L65;
            Long r16 = null;
        L67:
            if ((r66 & 65536) == 0) goto L69;
            Long r17 = null;
        L71:
            if ((r66 & 131072) == 0) goto L73;
            Long r18 = null;
        L75:
            if ((r66 & 262144) == 0) goto L77;
            Map r19 = null;
        L79:
            if ((r66 & 524288) == 0) goto L81;
            Long r20 = null;
        L83:
            if ((r66 & 1048576) == 0) goto L85;
            Long r21 = null;
        L87:
            if ((r66 & 2097152) == 0) goto L89;
            Long r22 = null;
        L91:
            if ((r66 & 4194304) == 0) goto L93;
            Long r23 = null;
        L95:
            if ((r66 & 8388608) == 0) goto L97;
            String r24 = null;
        L99:
            if ((r66 & 16777216) == 0) goto L101;
            String r25 = null;
        L103:
            if ((r66 & 33554432) == 0) goto L105;
            Long r26 = null;
        L107:
            if ((r66 & 67108864) == 0) goto L109;
            Long r27 = null;
        L111:
            if ((r66 & 134217728) == 0) goto L113;
            Long r28 = null;
        L115:
            if ((r66 & 268435456) == 0) goto L117;
            Long r29 = null;
        L119:
            if ((r66 & 536870912) == 0) goto L121;
            String r30 = null;
        L123:
            if ((r66 & 1073741824) == 0) goto L125;
            ConcurrentHashMap r31 = new ConcurrentHashMap();
        L127:
            if ((r66 & Integer.MIN_VALUE) == 0) goto L129;
            AtomicBoolean r0 = new AtomicBoolean(false);
        L130:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r2, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r0);
            return;
        L129:
            r0 = r65;
            goto L130
        L125:
            r31 = r64;
            goto L127
        L121:
            r30 = r63;
            goto L123
        L117:
            r29 = r62;
            goto L119
        L113:
            r28 = r61;
            goto L115
        L109:
            r27 = r60;
            goto L111
        L105:
            r26 = r59;
            goto L107
        L101:
            r25 = r58;
            goto L103
        L97:
            r24 = r57;
            goto L99
        L93:
            r23 = r56;
            goto L95
        L89:
            r22 = r55;
            goto L91
        L85:
            r21 = r54;
            goto L87
        L81:
            r20 = r53;
            goto L83
        L77:
            r19 = r52;
            goto L79
        L73:
            r18 = r51;
            goto L75
        L69:
            r17 = r50;
            goto L71
        L65:
            r16 = r49;
            goto L67
        L61:
            r14 = r48;
            goto L63
        L57:
            r2 = r47;
            goto L59
        L53:
            r15 = r46;
            goto L55
        L49:
            r13 = r45;
            goto L51
        L45:
            r12 = r44;
            goto L47
        L41:
            r11 = r43;
            goto L43
        L37:
            r10 = r42;
            goto L39
        L33:
            r9 = r41;
            goto L35
        L29:
            r8 = r40;
            goto L31
        L25:
            r7 = r39;
            goto L27
        L21:
            r6 = r38;
            goto L23
        L17:
            r5 = r37;
            goto L19
        L13:
            r4 = r36;
            goto L15
        L9:
            r3 = r35;
            goto L11
        L5:
            r1 = r34;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$ChildStepRecord;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$StepRecord;", "index", "", "<init>", "(I)V", "getIndex", "()I", "setIndex", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class ChildStepRecord extends StepRecord {

        @SerializedName("index")
        private int index;

        public ChildStepRecord() {
            int r2 = 0;
            this(r2, 1, null);
        }

        public final int getIndex() {
            return this.index;
        }

        public ChildStepRecord(int r9) {
            super(0, null, null, null, 15, null);
            this.index = r9;
        }

        public final void setIndex(int r1) {
            this.index = r1;
        }

        public /* synthetic */ ChildStepRecord(int r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR\"\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001c¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$ContentCompleteStep;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$ChildStepRecord;", "sendMsgId", "", "receiveMsgId", "receiveContentType", "", "firstLoadingDuration", "", "firstCotDuration", "firstAnswerDuration", "taskFinishDuration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getSendMsgId", "()Ljava/lang/String;", "setSendMsgId", "(Ljava/lang/String;)V", "getReceiveMsgId", "setReceiveMsgId", "getReceiveContentType", "()Ljava/lang/Integer;", "setReceiveContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFirstLoadingDuration", "()Ljava/lang/Long;", "setFirstLoadingDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFirstCotDuration", "setFirstCotDuration", "getFirstAnswerDuration", "setFirstAnswerDuration", "getTaskFinishDuration", "setTaskFinishDuration", "report", "", "getEventKey", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContentCompleteStep extends ChildStepRecord {

        @SerializedName("first_answer_duration")
        private Long firstAnswerDuration;

        @SerializedName("first_cot_duration")
        private Long firstCotDuration;

        @SerializedName("first_loading_duration")
        private Long firstLoadingDuration;

        @SerializedName("content_type")
        private Integer receiveContentType;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String receiveMsgId;

        @SerializedName("reply_id")
        private String sendMsgId;

        @SerializedName("task_finish_duration")
        private Long taskFinishDuration;

        public ContentCompleteStep() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public String getEventKey() {
            return "message_content_complete_shown";
        }

        public final Long getFirstAnswerDuration() {
            return this.firstAnswerDuration;
        }

        public final Long getFirstCotDuration() {
            return this.firstCotDuration;
        }

        public final Long getFirstLoadingDuration() {
            return this.firstLoadingDuration;
        }

        public final Integer getReceiveContentType() {
            return this.receiveContentType;
        }

        public final String getReceiveMsgId() {
            return this.receiveMsgId;
        }

        public final String getSendMsgId() {
            return this.sendMsgId;
        }

        public final Long getTaskFinishDuration() {
            return this.taskFinishDuration;
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public void report(String r3) {
            Intrinsics.checkNotNullParameter(r3, "sendMsgId");
            CommonParamManager.CommonParam r0 = CommonParamManager.c(r3);
            if (r0 == null) goto L7;
            ConcurrentHashMap<String, Long> r1 = r0.getPerfMarkDurations();
            if (r1 == null) goto L7;
            this.firstLoadingDuration = r1.get("loading_first_token");
            this.firstCotDuration = r1.get("cot_first_token");
            this.firstAnswerDuration = r1.get("answer_first_token");
            this.taskFinishDuration = r1.get("task_finish");
        L7:
            super.report(r3);
        }

        public final void setFirstAnswerDuration(Long r1) {
            this.firstAnswerDuration = r1;
        }

        public final void setFirstCotDuration(Long r1) {
            this.firstCotDuration = r1;
        }

        public final void setFirstLoadingDuration(Long r1) {
            this.firstLoadingDuration = r1;
        }

        public final void setReceiveContentType(Integer r1) {
            this.receiveContentType = r1;
        }

        public final void setReceiveMsgId(String r1) {
            this.receiveMsgId = r1;
        }

        public final void setSendMsgId(String r1) {
            this.sendMsgId = r1;
        }

        public final void setTaskFinishDuration(Long r1) {
            this.taskFinishDuration = r1;
        }

        public ContentCompleteStep(String r4, String r5, Integer r6, Long r7, Long r8, Long r9, Long r10) {
            int r2 = 0;
            super(r2, 1, null);
            this.sendMsgId = r4;
            this.receiveMsgId = r5;
            this.receiveContentType = r6;
            this.firstLoadingDuration = r7;
            this.firstCotDuration = r8;
            this.firstAnswerDuration = r9;
            this.taskFinishDuration = r10;
        }

        public /* synthetic */ ContentCompleteStep(String r7, String r8, Integer r9, Long r10, Long r11, Long r12, Long r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L5;
            String r16 = null;
        L7:
            if ((r14 & 2) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r14 & 4) == 0) goto L13;
            Integer r2 = null;
        L15:
            if ((r14 & 8) == 0) goto L17;
            Long r3 = null;
        L19:
            if ((r14 & 16) == 0) goto L21;
            Long r4 = null;
        L23:
            if ((r14 & 32) == 0) goto L25;
            Long r5 = null;
        L27:
            if ((r14 & 64) == 0) goto L29;
            Long r17 = null;
        L30:
            this(r16, r1, r2, r3, r4, r5, r17);
            return;
        L29:
            r17 = r13;
            goto L30
        L25:
            r5 = r12;
            goto L27
        L21:
            r4 = r11;
            goto L23
        L17:
            r3 = r10;
            goto L19
        L13:
            r2 = r9;
            goto L15
        L9:
            r1 = r8;
            goto L11
        L5:
            r16 = r7;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000e\"\u0004\b\u001c\u0010\u0010R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$ContentFirstStep;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$ChildStepRecord;", "sendMsgId", "", "receiveMsgId", "receiveContentType", "", "intention", "llmModelType", "isWebSearch", "hasEnterBackground", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSendMsgId", "()Ljava/lang/String;", "setSendMsgId", "(Ljava/lang/String;)V", "getReceiveMsgId", "setReceiveMsgId", "getReceiveContentType", "()Ljava/lang/Integer;", "setReceiveContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIntention", "setIntention", "getLlmModelType", "setLlmModelType", "setWebSearch", "getHasEnterBackground", "setHasEnterBackground", "report", "", "getEventKey", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContentFirstStep extends ChildStepRecord {

        @SerializedName("has_enter_background")
        private String hasEnterBackground;

        @SerializedName("intention")
        private String intention;

        @SerializedName("is_web_search")
        private String isWebSearch;

        @SerializedName("llm_model_type")
        private String llmModelType;

        @SerializedName("content_type")
        private Integer receiveContentType;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String receiveMsgId;

        @SerializedName("reply_id")
        private String sendMsgId;

        public ContentFirstStep() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public String getEventKey() {
            return "message_content_first_shown";
        }

        public final String getHasEnterBackground() {
            return this.hasEnterBackground;
        }

        public final String getIntention() {
            return this.intention;
        }

        public final String getLlmModelType() {
            return this.llmModelType;
        }

        public final Integer getReceiveContentType() {
            return this.receiveContentType;
        }

        public final String getReceiveMsgId() {
            return this.receiveMsgId;
        }

        public final String getSendMsgId() {
            return this.sendMsgId;
        }

        public final String isWebSearch() {
            return this.isWebSearch;
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public void report(String r3) {
            Intrinsics.checkNotNullParameter(r3, "sendMsgId");
            CommonParamManager.CommonParam r0 = CommonParamManager.c(r3);
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.getHasEnterBackground() != true) goto L7;
        L8:
            if (r1 == false) goto L10;
            String r2 = "1";
        L11:
            this.hasEnterBackground = r2;
            super.report(r3);
            return;
        L10:
            r2 = TriggerSendLoading.NO_LOADING;
        L7:
            r1 = false;
            goto L8
        }

        public final void setHasEnterBackground(String r1) {
            this.hasEnterBackground = r1;
        }

        public final void setIntention(String r1) {
            this.intention = r1;
        }

        public final void setLlmModelType(String r1) {
            this.llmModelType = r1;
        }

        public final void setReceiveContentType(Integer r1) {
            this.receiveContentType = r1;
        }

        public final void setReceiveMsgId(String r1) {
            this.receiveMsgId = r1;
        }

        public final void setSendMsgId(String r1) {
            this.sendMsgId = r1;
        }

        public final void setWebSearch(String r1) {
            this.isWebSearch = r1;
        }

        public ContentFirstStep(String r4, String r5, Integer r6, String r7, String r8, String r9, String r10) {
            int r2 = 0;
            super(r2, 1, null);
            this.sendMsgId = r4;
            this.receiveMsgId = r5;
            this.receiveContentType = r6;
            this.intention = r7;
            this.llmModelType = r8;
            this.isWebSearch = r9;
            this.hasEnterBackground = r10;
        }

        public /* synthetic */ ContentFirstStep(String r7, String r8, Integer r9, String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L5;
            String r16 = null;
        L7:
            if ((r14 & 2) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r14 & 4) == 0) goto L13;
            Integer r2 = null;
        L15:
            if ((r14 & 8) == 0) goto L17;
            String r3 = "";
        L19:
            if ((r14 & 16) == 0) goto L21;
            String r4 = "";
        L23:
            if ((r14 & 32) == 0) goto L25;
            String r5 = null;
        L27:
            if ((r14 & 64) == 0) goto L29;
            String r17 = null;
        L30:
            this(r16, r1, r2, r3, r4, r5, r17);
            return;
        L29:
            r17 = r13;
            goto L30
        L25:
            r5 = r12;
            goto L27
        L21:
            r4 = r11;
            goto L23
        L17:
            r3 = r10;
            goto L19
        L13:
            r2 = r9;
            goto L15
        L9:
            r1 = r8;
            goto L11
        L5:
            r16 = r7;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0003\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010 \u001a\u00020\bH\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$SdkSendStep;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$StepRecord;", "sendContentType", "", "startSendTimeInMillSec", "", "sendEndTimeInMillSec", "queryType", "", "textLength", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;I)V", "getSendContentType", "()Ljava/lang/Integer;", "setSendContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStartSendTimeInMillSec", "()Ljava/lang/Long;", "setStartSendTimeInMillSec", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSendEndTimeInMillSec", "setSendEndTimeInMillSec", "getQueryType", "()Ljava/lang/String;", "setQueryType", "(Ljava/lang/String;)V", "getTextLength", "()I", "setTextLength", "(I)V", "getEventKey", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SdkSendStep extends StepRecord {

        @SerializedName("query_type")
        private String queryType;

        @SerializedName("content_type")
        private Integer sendContentType;

        @SerializedName("end_time_mill_sec")
        private Long sendEndTimeInMillSec;

        @SerializedName("start_time_mill_sec")
        private Long startSendTimeInMillSec;

        @SerializedName("text_length")
        private int textLength;

        public SdkSendStep() {
            this(null, null, null, null, 0, 31, null);
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public String getEventKey() {
            return "message_sent_start_to_sdk";
        }

        public final String getQueryType() {
            return this.queryType;
        }

        public final Integer getSendContentType() {
            return this.sendContentType;
        }

        public final Long getSendEndTimeInMillSec() {
            return this.sendEndTimeInMillSec;
        }

        public final Long getStartSendTimeInMillSec() {
            return this.startSendTimeInMillSec;
        }

        public final int getTextLength() {
            return this.textLength;
        }

        public final void setQueryType(String r1) {
            this.queryType = r1;
        }

        public final void setSendContentType(Integer r1) {
            this.sendContentType = r1;
        }

        public final void setSendEndTimeInMillSec(Long r1) {
            this.sendEndTimeInMillSec = r1;
        }

        public final void setStartSendTimeInMillSec(Long r1) {
            this.startSendTimeInMillSec = r1;
        }

        public final void setTextLength(int r1) {
            this.textLength = r1;
        }

        public SdkSendStep(Integer r9, Long r10, Long r11, String r12, int r13) {
            super(0, null, null, null, 15, null);
            this.sendContentType = r9;
            this.startSendTimeInMillSec = r10;
            this.sendEndTimeInMillSec = r11;
            this.queryType = r12;
            this.textLength = r13;
        }

        public /* synthetic */ SdkSendStep(Integer r4, Long r5, Long r6, String r7, int r8, int r9, DefaultConstructorMarker r10) {
            Long r0 = null;
            if ((r9 & 1) == 0) goto L5;
            Integer r11 = null;
        L7:
            if ((r9 & 2) == 0) goto L9;
            Long r1 = null;
        L11:
            if ((r9 & 4) != 0) goto L15;
            r0 = r6;
        L15:
            if ((r9 & 8) == 0) goto L17;
            r7 = "normal";
        L17:
            String r2 = r7;
            if ((r9 & 16) == 0) goto L20;
            int r12 = 0;
        L21:
            this(r11, r1, r0, r2, r12);
            return;
        L20:
            r12 = r8;
            goto L21
        L9:
            r1 = r5;
            goto L11
        L5:
            r11 = r4;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\b\u0003\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$SendLoadingHideStep;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$StepRecord;", "sendMsgId", "", "sendContentType", "", "startToSdkDuration", "", "useSdkToSdkRealSendTime", "startToSdkRealSendTime", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getSendMsgId", "()Ljava/lang/String;", "setSendMsgId", "(Ljava/lang/String;)V", "getSendContentType", "()Ljava/lang/Integer;", "setSendContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStartToSdkDuration", "()Ljava/lang/Long;", "setStartToSdkDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUseSdkToSdkRealSendTime", "setUseSdkToSdkRealSendTime", "getStartToSdkRealSendTime", "setStartToSdkRealSendTime", "getEventKey", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SendLoadingHideStep extends StepRecord {

        @SerializedName("content_type")
        private Integer sendContentType;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String sendMsgId;

        @SerializedName("start_to_use_sdk_duration")
        private Long startToSdkDuration;

        @SerializedName("start_to_sdk_real_send_duration")
        private Long startToSdkRealSendTime;

        @SerializedName("use_sdk_to_sdk_real_send_duration")
        private Long useSdkToSdkRealSendTime;

        public SendLoadingHideStep() {
            this(null, null, null, null, null, 31, null);
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public String getEventKey() {
            return "message_send_loading_hide";
        }

        public final Integer getSendContentType() {
            return this.sendContentType;
        }

        public final String getSendMsgId() {
            return this.sendMsgId;
        }

        public final Long getStartToSdkDuration() {
            return this.startToSdkDuration;
        }

        public final Long getStartToSdkRealSendTime() {
            return this.startToSdkRealSendTime;
        }

        public final Long getUseSdkToSdkRealSendTime() {
            return this.useSdkToSdkRealSendTime;
        }

        public final void setSendContentType(Integer r1) {
            this.sendContentType = r1;
        }

        public final void setSendMsgId(String r1) {
            this.sendMsgId = r1;
        }

        public final void setStartToSdkDuration(Long r1) {
            this.startToSdkDuration = r1;
        }

        public final void setStartToSdkRealSendTime(Long r1) {
            this.startToSdkRealSendTime = r1;
        }

        public final void setUseSdkToSdkRealSendTime(Long r1) {
            this.useSdkToSdkRealSendTime = r1;
        }

        public SendLoadingHideStep(String r9, Integer r10, Long r11, Long r12, Long r13) {
            super(0, null, null, null, 15, null);
            this.sendMsgId = r9;
            this.sendContentType = r10;
            this.startToSdkDuration = r11;
            this.useSdkToSdkRealSendTime = r12;
            this.startToSdkRealSendTime = r13;
        }

        public /* synthetic */ SendLoadingHideStep(String r5, Integer r6, Long r7, Long r8, Long r9, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            String r12 = null;
        L7:
            if ((r10 & 2) == 0) goto L9;
            Integer r1 = null;
        L11:
            if ((r10 & 4) == 0) goto L13;
            Long r2 = null;
        L15:
            if ((r10 & 8) == 0) goto L17;
            Long r3 = null;
        L19:
            if ((r10 & 16) == 0) goto L21;
            Long r13 = null;
        L22:
            this(r12, r1, r2, r3, r13);
            return;
        L21:
            r13 = r9;
            goto L22
        L17:
            r3 = r8;
            goto L19
        L13:
            r2 = r7;
            goto L15
        L9:
            r1 = r6;
            goto L11
        L5:
            r12 = r5;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$SendMsgOnScreenStep;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$StepRecord;", "sendContentType", "", "<init>", "(Ljava/lang/Integer;)V", "getSendContentType", "()Ljava/lang/Integer;", "setSendContentType", "Ljava/lang/Integer;", "getEventKey", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SendMsgOnScreenStep extends StepRecord {

        @SerializedName("content_type")
        private Integer sendContentType;

        public SendMsgOnScreenStep() {
            Integer r0 = null;
            this(r0, 1, r0);
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public String getEventKey() {
            return "message_send_by_user_shown";
        }

        public final Integer getSendContentType() {
            return this.sendContentType;
        }

        public SendMsgOnScreenStep(Integer r9) {
            super(0, null, null, null, 15, null);
            this.sendContentType = r9;
        }

        public final void setSendContentType(Integer r1) {
            this.sendContentType = r1;
        }

        public /* synthetic */ SendMsgOnScreenStep(Integer r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$SendStartStep;", "Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$StepRecord;", "sendContentType", "", "triggerToSendStartDuration", "", "agentMode", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "getSendContentType", "()Ljava/lang/Integer;", "setSendContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTriggerToSendStartDuration", "()Ljava/lang/Long;", "setTriggerToSendStartDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAgentMode", "setAgentMode", "getEventKey", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SendStartStep extends StepRecord {

        @SerializedName("agent_mode")
        private Integer agentMode;

        @SerializedName("content_type")
        private Integer sendContentType;

        @SerializedName("trigger_to_send_start_duration")
        private Long triggerToSendStartDuration;

        public SendStartStep() {
            this(null, null, null, 7, null);
        }

        @Override // com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace.StepRecord
        public String getEventKey() {
            return "message_send_by_user";
        }

        public final Integer getAgentMode() {
            return this.agentMode;
        }

        public final Integer getSendContentType() {
            return this.sendContentType;
        }

        public final Long getTriggerToSendStartDuration() {
            return this.triggerToSendStartDuration;
        }

        public final void setAgentMode(Integer r1) {
            this.agentMode = r1;
        }

        public final void setSendContentType(Integer r1) {
            this.sendContentType = r1;
        }

        public final void setTriggerToSendStartDuration(Long r1) {
            this.triggerToSendStartDuration = r1;
        }

        public SendStartStep(Integer r9, Long r10, Integer r11) {
            super(0, null, null, null, 15, null);
            this.sendContentType = r9;
            this.triggerToSendStartDuration = r10;
            this.agentMode = r11;
        }

        public /* synthetic */ SendStartStep(Integer r2, Long r3, Integer r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0015\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0002\u0010 J\b\u0010\"\u001a\u00020\u001fH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$StepRecord;", "", "stepTime", "", "duration", "durationInternal", "durationRender", "<init>", "(JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getStepTime", "()J", "setStepTime", "(J)V", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDurationInternal", "setDurationInternal", "getDurationRender", "setDurationRender", "renderTimingResolved", "", "getRenderTimingResolved", "()Z", "setRenderTimingResolved", "(Z)V", "report", "", "sendMsgId", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getDurationInterval", "getEventKey", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class StepRecord {

        @SerializedName("duration")
        private Long duration;

        @SerializedName("duration_internal")
        private Long durationInternal;

        @SerializedName("duration_render")
        private volatile Long durationRender;
        private volatile transient boolean renderTimingResolved;
        private transient long stepTime;

        public StepRecord() {
            this(0, null, null, null, 15, null);
        }

        public static /* synthetic */ Unit a(StepRecord r0, String r1) {
            return report$lambda$10$lambda$9(r0, r1);
        }

        public static /* synthetic */ Unit b(StepRecord r0, String r1, Long r2) {
            return report$lambda$10(r0, r1, r2);
        }

        public abstract String getEventKey();

        public final Long getDuration() {
            return this.duration;
        }

        public final Long getDurationInternal() {
            return this.durationInternal;
        }

        public final Long getDurationRender() {
            return this.durationRender;
        }

        public final boolean getRenderTimingResolved() {
            return this.renderTimingResolved;
        }

        public final long getStepTime() {
            return this.stepTime;
        }

        public final Long getDuration(String r5) {
            Intrinsics.checkNotNullParameter(r5, "sendMsgId");
            CommonParamManager.CommonParam r6 = CommonParamManager.c(r5);
            if (r6 == null) goto L7;
            Long r7 = r6.getSendStartTime();
            if (r7 == null) goto L7;
            long r0 = r7.longValue();
            return Long.valueOf(this.stepTime - r0);
        L7:
            return null;
        }

        public Long getDurationInterval(String r5) {
            Intrinsics.checkNotNullParameter(r5, "sendMsgId");
            CommonParamManager.CommonParam r6 = CommonParamManager.c(r5);
            if (r6 == null) goto L7;
            Long r7 = r6.getSendLoadingHideTime();
            if (r7 == null) goto L7;
            long r0 = r7.longValue();
            return Long.valueOf(this.stepTime - r0);
        L7:
            return null;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.trace.appreciable.o, java.lang.Object] */
        public void report(final String r2) {
            Intrinsics.checkNotNullParameter(r2, "sendMsgId");
            ?? r0 = new o(this, r2);
            ChatMessageCostTrace.a.getClass();
            List r3 = ChatMessageCostTrace.d.get();
            if (r3 == null) goto L5;
            r3.add(r0);
            return;
        L5:
            r0.invoke(null);
        }

        public final void setDuration(Long r1) {
            this.duration = r1;
        }

        public final void setDurationInternal(Long r1) {
            this.durationInternal = r1;
        }

        public final void setDurationRender(Long r1) {
            this.durationRender = r1;
        }

        public final void setRenderTimingResolved(boolean r1) {
            this.renderTimingResolved = r1;
        }

        public final void setStepTime(long r1) {
            this.stepTime = r1;
        }

        private static final Unit report$lambda$10$lambda$9(StepRecord r9, String r10) {
            Long r0 = r9.getDuration(r10);
            String r3 = null;
            boolean r5 = false;
            if (r0 != null) goto L5;
        L13:
            Long r1 = r9.getDurationInterval(r10);
            if (r1 != null) goto L16;
        L24:
            String r2 = r9.getEventKey();
            CommonParamManager.CommonParam r11 = CommonParamManager.c(r10);
            JSONObject r12 = com.larus.bmhome.chat.trace.appreciable.a.b(r11, r9);
            if (r11 == null) goto L39;
            Map<String, String> r4 = r11.getMessageTrackCommonTags();
            if (r4 == null) goto L39;
            Iterator<Map.Entry<String, String>> r6 = r4.entrySet().iterator();
        L30:
            if (r6.hasNext() == false) goto L39;
            Map.Entry<String, String> r7 = r6.next();
            String r8 = r7.getKey();
            String r13 = r7.getValue();
            if (r12 != null) goto L34;
        L36:
            boolean r14 = false;
        L37:
            if (r14 == false) goto L30;
            r12.put(r8, r13);
            goto L30
        L34:
            if (r12.has(r8) == true) goto L36;
            r14 = true;
        L39:
            if (r11 == null) goto L48;
            Map<String, String> r15 = r11.getIntentionMap();
            if (r15 == null) goto L48;
            Iterator<Map.Entry<String, String>> r16 = r15.entrySet().iterator();
        L44:
            if (r16.hasNext() == false) goto L48;
            Map.Entry<String, String> r17 = r16.next();
            if (r12 == null) goto L44;
            r12.put(r17.getKey(), r17.getValue());
        L48:
            FLogger.a.i("ChatMessageCostTrace", "reportEvent, event=" + r2 + ", param=" + r12);
            LruCache<String, String> r18 = IMSpanManager.a;
            if (r11 == null) goto L51;
            String r19 = r11.getLocalSendMsgId();
        L52:
            String r20 = "";
            if (r19 != null) goto L55;
            r19 = "";
        L55:
            IMSpanManager.b(r19, r2, r12);
            if (r11 == null) goto L58;
            r3 = r11.getTraceId();
        L58:
            if (r3 == null) goto L62;
            r20 = r3;
        L62:
            if (r20.length() != 0) goto L64;
            r5 = true;
        L64:
            if (r5 == false) goto L67;
            if (r11 == null) goto L67;
            r11.setTraceId(IMSpanManager.a(r11.getLocalSendMsgId()));
        L67:
            if (r12 == null) goto L70;
            com.larus.platform.service.o.a.reportEvent(r2, r12);
            com.larus.bmhome.utils.c.a(r2, r12, true);
        L70:
            return Unit.INSTANCE;
        L51:
            r19 = null;
            goto L52
        L16:
            if (r1.longValue() <= 0) goto L18;
            boolean r21 = true;
        L19:
            if (r21 == true) goto L22;
            r1 = null;
        L22:
            if (r1 == null) goto L24;
            r9.durationInternal = Long.valueOf(r1.longValue());
            goto L24
        L18:
            r21 = false;
            goto L19
        L5:
            if (r0.longValue() <= 0) goto L7;
            boolean r22 = true;
        L8:
            if (r22 == true) goto L11;
            r0 = null;
        L11:
            if (r0 == null) goto L13;
            r9.duration = Long.valueOf(r0.longValue());
            goto L13
        L7:
            r22 = false;
            goto L8
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.trace.appreciable.n, java.lang.Object] */
        private static final Unit report$lambda$10(final StepRecord r4, final String r5, Long r6) {
            if (r4.renderTimingResolved == true) goto L11;
            if (r6 == null) goto L10;
            long r0 = r6.longValue();
            CommonParamManager.CommonParam r7 = CommonParamManager.c(r5);
            if (r7 == null) goto L10;
            Long r8 = r7.getSendStartTime();
            if (r8 == null) goto L10;
            r4.durationRender = Long.valueOf(r0 - r8.longValue());
        L10:
            r4.renderTimingResolved = true;
        L11:
            ChatMessageCostTrace r9 = ChatMessageCostTrace.a;
            final ?? r1 = new n(r4, r5);
            r9.getClass();
            Intrinsics.checkNotNullParameter(r1, "block");
            ((Handler) ChatMessageCostTrace.e.getValue()).post(new k(r1));
            return Unit.INSTANCE;
        }

        public StepRecord(long r1, Long r3, Long r4, Long r5) {
            this.stepTime = r1;
            this.duration = r3;
            this.durationInternal = r4;
            this.durationRender = r5;
        }

        public /* synthetic */ StepRecord(long r7, Long r9, Long r10, Long r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L5;
            r7 = SystemClock.elapsedRealtime();
        L5:
            long r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            Long r3 = null;
        L10:
            if ((r12 & 4) == 0) goto L12;
            Long r4 = null;
        L14:
            if ((r12 & 8) == 0) goto L16;
            Long r5 = null;
        L17:
            this(r1, r3, r4, r5);
            return;
        L16:
            r5 = r11;
            goto L17
        L12:
            r4 = r10;
            goto L14
        L8:
            r3 = r9;
            goto L10
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/larus/bmhome/chat/trace/appreciable/ChatMessageCostTrace$jsonToDict$1$mapType$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends Object>> {
        public a() {
        }
    }

    public ChatMessageCostTrace() {
    }

    static {
        a = new ChatMessageCostTrace();
        b = SetsKt.setOf(new String[]{"loading_first_token", "cot_first_token", "answer_first_token", "task_finish"});
        c = new LruCache(10);
        d = new ThreadLocal();
        e = LazyKt.lazy(new h());
        f = LazyKt.lazy(new i());
        g = LazyKt.lazy(new j());
    }

    public static boolean a(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        StepRecord r3 = (StepRecord) c.get(r2);
        if ((r3 instanceof SendLoadingHideStep) == false) goto L8;
    L9:
        return true;
    L8:
        if ((r3 instanceof AllFirstStep) == true) goto L9;
        return false;
    }

    public static Map b(String r3) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r3.length() != 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        return null;
    L9:
        Type r4 = new a().getType();     // Catch: Throwable -> L11
        a.getClass();     // Catch: Throwable -> L11
        return (Map) ((Gson) g.getValue()).fromJson(r3, r4);
    L6:
        r2 = false;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L17;
        r0 = r6;
    L17:
        return (Map) r0;
    }

    public static long g(Long r5) {
        if (r5 == null) goto L5;
        r5.longValue();
        Pair r0 = AppHost.a.getAppStartTime();
        return (r5.longValue() - ((Number) r0.getFirst()).longValue()) + ((Number) r0.getSecond()).longValue();
    L5:
        return -1;
    }

    public static void e(String r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r8, "sendMsgId");
        Intrinsics.checkNotNullParameter(r9, "thinkingConfig");
        long r0 = SystemClock.elapsedRealtime();
        Object r2 = c.get(r8);
        if ((r2 instanceof AllFirstStep) == false) goto L5;
        AllFirstStep r3 = (AllFirstStep) r2;
    L6:
        if (r3 == null) goto L16;
        long r6 = r9.optLong("total_duration", 0);
        if (r6 <= 0) goto L14;
        r3.setDeepthinkingDuration(r3.getMainTextDuration());
        r3.setDeepthinkingDurationFromSdk(r3.getMainTextDurationFromSdk());
        r3.setMainTextDuration(Long.valueOf(r6));
        CommonParamManager.CommonParam r10 = CommonParamManager.c(r8);
        if (r10 == null) goto L14;
        Long r11 = r10.getSdkReceiveTime();
        if (r11 == null) goto L14;
        r3.setMainTextDurationFromSdk(Long.valueOf(r0 - r11.longValue()));
    L14:
        r3.report(r8);
        return;
    L16:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static void f(String r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "sendMsgId");
        CommonParamManager.CommonParam r0 = CommonParamManager.c(r11);
        if (r0 == null) goto L5;
        String r2 = r0.getLocalSendMsgId();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        LruCache<String, StepRecord> r3 = c;
        Object r4 = r3.get(r2);
        if ((r4 instanceof SendMsgOnScreenStep) == false) goto L11;
        SendMsgOnScreenStep r5 = (SendMsgOnScreenStep) r4;
    L12:
        if (r5 == null) goto L33;
        r3.remove(r2);
        if (r0 == null) goto L16;
        Long r6 = r0.getSendStartTime();
    L17:
        if (r0 == null) goto L19;
        Long r7 = r0.getSendMsgOnBusinessTime();
    L20:
        if (r0 == null) goto L22;
        Long r8 = r0.getSendMsgOnSDKInternalTime();
    L23:
        if (r6 == null) goto L27;
        if (r7 == null) goto L27;
        if (r8 == null) goto L27;
        Long r1 = Long.valueOf(r7.longValue() - r6.longValue());
        Long r9 = Long.valueOf(r8.longValue() - r7.longValue());
        Long r10 = r1;
        Long r13 = Long.valueOf(r8.longValue() - r6.longValue());
        Long r14 = r9;
    L28:
        SendLoadingHideStep r15 = new SendLoadingHideStep(r11, Integer.valueOf(r12), r10, r14, r13);
        r3.put(r11, r15);
        if (r0 == null) goto L31;
        r0.setSendLoadingHideTime(Long.valueOf(r15.getStepTime()));
    L31:
        r15.report(r11);
        return;
    L27:
        r10 = null;
        r14 = null;
        r13 = null;
        goto L28
    L22:
        r8 = null;
        goto L23
    L19:
        r7 = null;
        goto L20
    L16:
        r6 = null;
        goto L17
    L33:
        return;
    L11:
        r5 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static void h(String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "localMsgId");
        Intrinsics.checkNotNullParameter(r5, "point");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r4) == true) goto L23;
        Lazy r1 = f;
        Map r3 = (Map) ((Map) r1.getValue()).get(r4);
        if (r3 == null) goto L16;
        if (r3.containsKey(r5) == true) goto L20;
        r3.put(r5, Long.valueOf(r6));
        return;
    L20:
        return;
    L16:
        if (Intrinsics.areEqual(r5, "on_receive_msg") == false) goto L22;
        ((Map) r1.getValue()).put(r4, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r5, Long.valueOf(r6))}));
        return;
    L22:
        return;
    L23:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void c(String r15, String r16, Long r17, Long r18) {
        LruCache<String, StepRecord> r0 = c;
        Object r1 = r0.get(r15);
        if ((r1 instanceof AllFirstStep) == false) goto L5;
        AllFirstStep r13 = (AllFirstStep) r1;
    L6:
        if (r13 == null) goto L29;
        r0.remove(r15);
        AllCompleteStep r14 = new AllCompleteStep(r15, null, null, null, null, null, null, 126, null);
        if (r17 == null) goto L10;
        r14.setStepTime(r17.longValue());
    L10:
        r14.setDurationRender(r18);
        Intrinsics.checkNotNullParameter(r16, "<this>");
        if (StringsKt.contains$default(r16, "1", false, 2, null) == false) goto L16;
        ChildStepRecord r2 = r13.getChildSteps().get(com.larus.bmhome.social.userchat.model.b0.d(r16));
        if (r2 == null) goto L15;
        Long r3 = r2.getDuration(r15);
    L17:
        r14.setDurationWithoutSuggest(r3);
        CommonParamManager.CommonParam r4 = CommonParamManager.c(r15);
        if (r4 == null) goto L20;
        String r5 = r4.getIntention();
    L21:
        r14.setIntention(r5);
        r14.report(r15);
        CommonParamManager.CommonParam r6 = CommonParamManager.c(r15);
        if (r6 == null) goto L24;
        String r7 = r6.getLocalSendMsgId();
    L25:
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        IMSpanManager.c(r7, null, null);
        return;
    L24:
        r7 = null;
        goto L25
    L20:
        r5 = null;
        goto L21
    L15:
        r3 = null;
        goto L17
    L16:
        r3 = r14.getDuration(r15);
        goto L17
    L29:
        return;
    L5:
        r13 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(ChatMessageCostTrace r51, String r52, String r53, int r54, Long r55, Message r56, boolean r57, int r58) {
        AllFirstStep r35 = null;
        if ((r58 & 8) == 0) goto L5;
        Long r0 = null;
    L6:
        boolean r36 = true;
        if ((r58 & 32) == 0) goto L9;
        boolean r37 = true;
    L10:
        r51.getClass();
        Intrinsics.checkNotNullParameter(r52, "sendMsgId");
        Intrinsics.checkNotNullParameter(r53, "receiveMsgId");
        Intrinsics.checkNotNullParameter(r56, "msg");
        if (r0 == null) goto L13;
        long r1 = r0.longValue();
    L14:
        long r12 = r1;
        LruCache<String, StepRecord> r11 = c;
        if ((r11.get(r52) instanceof SendLoadingHideStep) == false) goto L104;
        Object r2 = r11.get(r52);
        if ((r2 instanceof SendLoadingHideStep) == false) goto L19;
        SendLoadingHideStep r38 = (SendLoadingHideStep) r2;
    L20:
        if (r38 == null) goto L104;
        CommonParamManager.CommonParam r3 = CommonParamManager.c(r52);
        if (r3 == null) goto L32;
        Map r4 = r56.getExt();
        if (r4 == null) goto L26;
        String r5 = (String) r4.get("intention");
    L27:
        r3.setIntention(r5);
        Map r6 = r56.getExt();
        if (r6 == null) goto L30;
        String r7 = (String) r6.get("is_from_cache");
    L31:
        r3.setFromCache(r7);
        goto L32
    L30:
        r7 = null;
        goto L31
    L26:
        r5 = null;
    L32:
        Map r8 = r56.getExt();
        if (r8 == null) goto L35;
        String r9 = (String) r8.get("tea_tags_time_cost");
    L37:
        if (r9 != null) goto L39;
    L42:
        boolean r10 = true;
    L44:
        if (r10 == false) goto L46;
        Map<String, String> r13 = new LinkedHashMap();
    L47:
        CommonParamManager.CommonParam r14 = CommonParamManager.c(r52);
        if (r14 == null) goto L50;
        r14.setIntentionMap(r13);
    L50:
        AllFirstStep r15 = new AllFirstStep(Integer.valueOf(r54), r52, null, null, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -4, null);
        Map r16 = r56.getExt();
        if (r16 == null) goto L53;
        Object r17 = "llm_model_type";
        final AllFirstStep r18 = r15;
        r18.setLlmModelType((String) r16.get(r17));
        Object r19 = "intention";
        r18.setIntention((String) r16.get(r19));
        Object r110 = "is_web_search";
        r18.setWebSearch((String) r16.get(r110));
    L54:
        ChatMessageCostTrace r20 = a;
        String r21 = r56.getLocalMessageId();
        if (r21 != null) goto L57;
        r21 = "";
    L57:
        long r22 = SystemClock.elapsedRealtime();
        r20.getClass();
        h(r21, "report_all_first_shown", r22);
        Lazy r23 = f;
        r18.setDetailTimelines((Map) ((Map) r23.getValue()).get(r56.getLocalMessageId()));
        Map r24 = (Map) r23.getValue();
        TypeIntrinsics.asMutableMap(r24).remove(r56.getLocalMessageId());
        String r111 = r53;
        r18.setReceiveMsgId(r111);
        Intrinsics.checkNotNullParameter(r56, "<this>");
        if (com.larus.im.bean.message.a.j0(r56) == false) goto L60;
    L63:
        String r25 = "1";
        if (r36 == false) goto L66;
        String r26 = "1";
    L67:
        r18.setReferMessage(r26);
        if (com.larus.im.bean.message.a.y0(r56) == false) goto L70;
    L73:
        r18.setSubMessage(r25);
        long r27 = r12;
        r18.setStepTime(r27);
        CommonParamManager.CommonParam r28 = CommonParamManager.c(r52);
        if (r28 == null) goto L76;
        Long r29 = r28.getSdkReceiveTime();
    L77:
        if (r28 == null) goto L79;
        Long r30 = r28.getBusinessReceiveMsgCallbackTime();
    L80:
        if (r29 == null) goto L83;
        if (r30 == null) goto L83;
        r18.setDurationSdkToCallback(Long.valueOf(r30.longValue() - r29.longValue()));
        r18.setDurationFromCallback(Long.valueOf(r27 - r30.longValue()));
        r18.setDurationFromSdk(Long.valueOf(r27 - r29.longValue()));
        r18.setMainTextDurationFromSdk(r18.getDurationFromSdk());
        r18.setStartSendTimeInMillSec(Long.valueOf(g(r28.getSendStartTime())));
        r18.setSendEndTimeInMillSec(Long.valueOf(g(r28.getSendMsgOnSDKInternalTime())));
        r18.setFirstTokenTimeMillSec(Long.valueOf(g(r29)));
    L83:
        final String r112 = r52;
        Long r31 = r18.getDuration(r112);
        if (r31 == null) goto L94;
        r18.setBusinessDuration(r31);
        r18.setMainTextDuration(r31);
        if (r28 == null) goto L94;
        Long r32 = r28.getSdkTotalTimeFromSendToReceive();
        if (r32 == null) goto L94;
        long r33 = r32.longValue();
        r18.setSdkDuration(Long.valueOf(r33));
        long r113 = r31.longValue() - r33;
        if (r33 <= 0) goto L94;
        if (r113 < 0) goto L94;
        r18.setTotalTimeDiffWithSdk(Long.valueOf(r113));
    L94:
        long r34 = SystemClock.elapsedRealtime();
        FLogger r39 = FLogger.a;
        StringBuilder r40 = new StringBuilder("onAllFirst commonParam=");
        if (r28 == null) goto L97;
        int r41 = r28.hashCode();
    L98:
        r40.append(r41);
        r40.append(" callbackTime=");
        r40.append(r30);
        r40.append(" sdkReceiveTime=");
        r40.append(r29);
        r40.append(" receiveMsgId=");
        r40.append(r111);
        r40.append(" sendMsgId=");
        r40.append(r112);
        r40.append(" stepTime=");
        r40.append(r27);
        r40.append(" curTime=");
        r40.append(r34);
        r40.append(" receiveReplyFromSdkStep.stepTime=");
        r40.append(r38.getStepTime());
        r40.append(" receiveContentType=");
        r40.append(r54);
        r39.i("ChatMessageCostTrace", r40.toString());
        LruCache<String, StepRecord> r42 = r11;
        r42.put(r112, r18);
        if (r37 == false) goto L101;
        r18.report(r112);
    L105:
        Object r43 = r42.get(r112);
        if ((r43 instanceof AllFirstStep) == false) goto L108;
        r35 = (AllFirstStep) r43;
    L108:
        if (r35 == null) goto L115;
        ConcurrentHashMap<String, ChildStepRecord> r114 = r35.getChildSteps();
        long r49 = r27;
        ContentFirstStep r44 = new ContentFirstStep(r52, r53, Integer.valueOf(r54), null, null, null, null, 120, null);
        Map r45 = r56.getExt();
        if (r45 == null) goto L112;
        ContentFirstStep r46 = r44;
        r46.setLlmModelType((String) r45.get(r17));
        r46.setIntention((String) r45.get(r19));
        r46.setWebSearch((String) r45.get(r110));
    L113:
        r46.setStepTime(r49);
        r46.setIndex(r114.size());
        r114.put(r111, r46);
        r46.report(r112);
        return;
    L112:
        r46 = r44;
        goto L113
    L115:
        return;
    L101:
        List<Function1<Long, Unit>> r47 = d.get();
        if (r47 == null) goto L105;
        r47.add(new m(r18, r112));
        goto L105
    L97:
        r41 = 0;
        goto L98
    L79:
        r30 = null;
        goto L80
    L76:
        r29 = null;
        goto L77
    L70:
        if (com.larus.im.bean.message.a.x0(r56) == true) goto L73;
        r25 = TriggerSendLoading.NO_LOADING;
        goto L73
    L66:
        r26 = TriggerSendLoading.NO_LOADING;
        goto L67
    L60:
        if (com.larus.im.bean.message.a.E0(r56) == true) goto L63;
        r36 = false;
        goto L63
    L53:
        r18 = r15;
        r19 = "intention";
        r17 = "llm_model_type";
        r110 = "is_web_search";
        goto L54
    L46:
        r13 = z.a(r9, "ChatMessageCostTrace");
        goto L47
    L39:
        if (r9.length() == 0) goto L42;
        r10 = false;
        goto L44
    L35:
        r9 = null;
        goto L37
    L19:
        r38 = null;
    L104:
        r42 = r11;
        r27 = r12;
        r111 = r53;
        r112 = r52;
        r110 = "is_web_search";
        r19 = "intention";
        r17 = "llm_model_type";
        goto L105
    L13:
        r1 = SystemClock.elapsedRealtime();
        goto L14
    L9:
        r37 = r57;
        goto L10
    L5:
        r0 = r55;
        goto L6
    }
}
