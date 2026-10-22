package com.larus.security.api;

import apa.a;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.privacy.azerothprivacy.AzerothPrivacy;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xoa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class AzerothUtils {
    public static final AzerothUtils a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/security/api/AzerothUtils$BatchTokenItem;", "", "log_Id", "", "token", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLog_Id", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class BatchTokenItem {
        private final String log_Id;
        private final String token;

        public static /* synthetic */ BatchTokenItem copy$default(BatchTokenItem r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.log_Id;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.token;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.log_Id;
        }

        public final String component2() {
            return this.token;
        }

        public final BatchTokenItem copy(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "log_Id");
            Intrinsics.checkNotNullParameter(r3, "token");
            return new BatchTokenItem(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof BatchTokenItem) == true) goto L8;
            return false;
        L8:
            BatchTokenItem r6 = (BatchTokenItem) r5;
            if (Intrinsics.areEqual(this.log_Id, r6.log_Id) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.token, r6.token) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.log_Id.hashCode() * 31) + this.token.hashCode();
        }

        public String toString() {
            return "BatchTokenItem(log_Id=" + this.log_Id + ", token=" + this.token + ')';
        }

        public final String getLog_Id() {
            return this.log_Id;
        }

        public final String getToken() {
            return this.token;
        }

        public BatchTokenItem(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "log_Id");
            Intrinsics.checkNotNullParameter(r3, "token");
            this.log_Id = r2;
            this.token = r3;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J^\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006%"}, d2 = {"Lcom/larus/security/api/AzerothUtils$SaveTokenObject;", "", "logID", "", "token", "batchData", "", "Lcom/larus/security/api/AzerothUtils$BatchTokenItem;", "feedbackContent", "feedbackSource", "", "feedbackType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getLogID", "()Ljava/lang/String;", "getToken", "getBatchData", "()Ljava/util/List;", "getFeedbackContent", "getFeedbackSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFeedbackType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/security/api/AzerothUtils$SaveTokenObject;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class SaveTokenObject {

        @SerializedName("batch_data")
        private final List<BatchTokenItem> batchData;

        @SerializedName("feedback_content")
        private final String feedbackContent;

        @SerializedName("feedback_source")
        private final Integer feedbackSource;

        @SerializedName("feedback_type")
        private final Integer feedbackType;

        @SerializedName("log_id")
        private final String logID;

        @SerializedName("token")
        private final String token;

        public SaveTokenObject() {
            this(null, null, null, null, null, null, 63, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SaveTokenObject copy$default(SaveTokenObject r4, String r5, String r6, List r7, String r8, Integer r9, Integer r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.logID;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.token;
        L8:
            String r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.batchData;
        L11:
            List r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.feedbackContent;
        L14:
            String r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.feedbackSource;
        L17:
            Integer r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.feedbackType;
        L20:
            String r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final String component1() {
            return this.logID;
        }

        public final String component2() {
            return this.token;
        }

        public final List<BatchTokenItem> component3() {
            return this.batchData;
        }

        public final String component4() {
            return this.feedbackContent;
        }

        public final Integer component5() {
            return this.feedbackSource;
        }

        public final Integer component6() {
            return this.feedbackType;
        }

        public final SaveTokenObject copy(String r9, String r10, List<BatchTokenItem> r11, String r12, Integer r13, Integer r14) {
            return new SaveTokenObject(r9, r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SaveTokenObject) == true) goto L8;
            return false;
        L8:
            SaveTokenObject r6 = (SaveTokenObject) r5;
            if (Intrinsics.areEqual(this.logID, r6.logID) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.token, r6.token) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.batchData, r6.batchData) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.feedbackContent, r6.feedbackContent) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.feedbackSource, r6.feedbackSource) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.feedbackType, r6.feedbackType) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            String r0 = this.logID;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.token;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            List<BatchTokenItem> r7 = this.batchData;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.feedbackContent;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Integer r13 = this.feedbackSource;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Integer r16 = this.feedbackType;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SaveTokenObject(logID=" + this.logID + ", token=" + this.token + ", batchData=" + this.batchData + ", feedbackContent=" + this.feedbackContent + ", feedbackSource=" + this.feedbackSource + ", feedbackType=" + this.feedbackType + ')';
        }

        public final List<BatchTokenItem> getBatchData() {
            return this.batchData;
        }

        public final String getFeedbackContent() {
            return this.feedbackContent;
        }

        public final Integer getFeedbackSource() {
            return this.feedbackSource;
        }

        public final Integer getFeedbackType() {
            return this.feedbackType;
        }

        public final String getLogID() {
            return this.logID;
        }

        public final String getToken() {
            return this.token;
        }

        public SaveTokenObject(String r1, String r2, List<BatchTokenItem> r3, String r4, Integer r5, Integer r6) {
            this.logID = r1;
            this.token = r2;
            this.batchData = r3;
            this.feedbackContent = r4;
            this.feedbackSource = r5;
            this.feedbackType = r6;
        }

        public /* synthetic */ SaveTokenObject(String r5, String r6, List r7, String r8, Integer r9, Integer r10, int r11, DefaultConstructorMarker r12) {
            String r0 = "";
            if ((r11 & 1) == 0) goto L5;
            String r13 = "";
        L7:
            if ((r11 & 2) != 0) goto L11;
            r0 = r6;
        L11:
            if ((r11 & 4) == 0) goto L13;
            List r1 = null;
        L15:
            if ((r11 & 8) == 0) goto L17;
            String r2 = null;
        L19:
            if ((r11 & 16) == 0) goto L21;
            Integer r3 = null;
        L23:
            if ((r11 & 32) == 0) goto L25;
            r10 = 0;
        L25:
            this(r13, r0, r1, r2, r3, r10);
            return;
        L21:
            r3 = r9;
            goto L23
        L17:
            r2 = r8;
            goto L19
        L13:
            r1 = r7;
            goto L15
        L5:
            r13 = r5;
            goto L7
        }
    }

    static {
        a = new AzerothUtils();
    }

    public AzerothUtils() {
    }

    public static String b(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "logId");
        Intrinsics.checkNotNullParameter(r4, "sectionId");
        Intrinsics.checkNotNullParameter(r5, "messageId");
        boolean r1 = false;
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return null;
    L8:
        if (r4.length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        return null;
    L13:
        if (r5.length() != 0) goto L15;
        r1 = true;
    L15:
        if (r1 == true) goto L35;
        return toa.e.a(r3, r4, r5);
    L19:
        e = move-exception;
        a.c("TraceAuthToken", "generate TraceAuthToken error", e);
        return toa.e.b(r3, r4, r5);
    L23:
        e = move-exception;
        a.c("TraceAuthToken", "generate downgraded TraceAuthToken error", e);
        HashMap r6 = new HashMap();
        r6.put("user_id", AzerothPrivacy.getAppInfo().e);
        r6.put("sdk_version", AzerothPrivacy.getVersion());
        b r7 = xoa.a.a;
        b r8 = xoa.a.a;
        xoa.a.a(e, "generate downgraded TraceAuthToken error", r6);
        return "";
    L35:
        return null;
    L10:
        r2 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x018b -> B:75:0x0196). Please report as a decompilation issue!!! */
    public final Object a(Message r29, int r30, Integer r31, String r32, Continuation<? super Unit> r33) {
        if ((r33 instanceof AzerothUtils$generateAndUploadFornaxToken$1) == false) goto L7;
        AzerothUtils$generateAndUploadFornaxToken$1 r2 = (AzerothUtils$generateAndUploadFornaxToken$1) r33;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        int r6 = 0;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r0 = r2.I$0;
        Iterator r7 = (Iterator) r2.L$5;
        String r8 = (String) r2.L$4;
        String r9 = (String) r2.L$3;
        String r10 = (String) r2.L$2;
        Integer r11 = (Integer) r2.L$1;
        Message r12 = (Message) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L75:
        int r13 = r0;
        Object r15 = r4;
        Iterator r14 = r7;
        String r16 = r8;
        String r17 = r10;
        Message r18 = r12;
        AzerothUtils$generateAndUploadFornaxToken$1 r19 = r2;
        String r110 = r9;
        Integer r20 = r11;
    L77:
        r6 = 0;
    L41:
        if (r14.hasNext() == false) goto L79;
        String r21 = (String) r14.next();
        Map r22 = r18.getExt();
        if (r22 == null) goto L45;
        String r23 = (String) r22.get(r21);
    L46:
        if (r23 != null) goto L48;
    L51:
        boolean r24 = true;
    L52:
        if (r24 == true) goto L76;
        String r25 = b(r23, r16, r110);
        if (r25 != null) goto L56;
    L59:
        boolean r111 = true;
    L60:
        if (r111 == true) goto L76;
        JSONObject r26 = new JSONObject();
        r26.put("log_id", r23);
        r26.put("token", r25);
        r26.put("message_id", r18.getMessageId());
        r26.put("feedback_source", r13);
        Map r27 = r18.getExt();
        if (r27 == null) goto L64;
        String r112 = (String) r27.get("dora_vision_ext");
    L65:
        if (r112 == null) goto L67;
        r26.put("section_id", r18.getSectionId());
        r26.put("mode", r6);
    L67:
        if (r20 == null) goto L69;
        r20.intValue();
        r26.put("feedback_type", r20.intValue());
    L69:
        if (r17 == null) goto L71;
        r26.put("feedback_content", r17);
    L71:
        Unit r28 = Unit.INSTANCE;
        r19.L$0 = r18;
        r19.L$1 = r20;
        r19.L$2 = r17;
        r19.L$3 = r110;
        r19.L$4 = r16;
        r19.L$5 = r14;
        r19.I$0 = r13;
        r19.label = 1;
        String r34 = r110;
        String r210 = r16;
        Iterator r211 = r14;
        Object r35 = r15;
        if (HttpExtKt.k("Basic", SaveTokenObject.class, "/alice/debug/save_token", r26, null, null, false, null, null, null, r19, 1008) != r35) goto L74;
        return r35;
    L74:
        r12 = r18;
        r0 = r13;
        r11 = r20;
        r10 = r17;
        r2 = r19;
        r4 = r35;
        r9 = r34;
        r8 = r210;
        r7 = r211;
        goto L75
    L64:
        r112 = null;
        goto L65
    L76:
        r15 = r15;
        r110 = r110;
        r16 = r16;
        r14 = r14;
        goto L77
    L56:
        if (r25.length() == 0) goto L59;
        r111 = false;
        goto L60
    L80:
        r15 = r15;
        r110 = r110;
        r16 = r16;
        r14 = r14;
        goto L77
    L48:
        if (r23.length() == 0) goto L51;
        r24 = false;
        goto L52
    L45:
        r23 = null;
    L79:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (z2.a.L1() == true) goto L20;
        if (r30 != 1) goto L18;
    L19:
        boolean r36 = true;
    L21:
        if (r36 == true) goto L23;
        String r37 = r29.getMessageId();
        String r38 = r29.getSectionId();
        if (r37 != null) goto L27;
    L30:
        boolean r39 = true;
    L31:
        if (r39 == true) goto L79;
        if (r38 != null) goto L34;
    L37:
        boolean r40 = true;
    L38:
        if (r40 == true) goto L79;
        r110 = r37;
        r15 = r4;
        r16 = r38;
        r14 = CollectionsKt.listOf(new String[]{"inner_log_id", "asr_log_id"}).iterator();
        r17 = r32;
        r13 = r30;
        r19 = r2;
        r18 = r29;
        r20 = r31;
        goto L41
    L34:
        if (r38.length() == 0) goto L37;
        r40 = false;
        goto L38
    L27:
        if (r37.length() == 0) goto L30;
        r39 = false;
        goto L31
    L23:
        return Unit.INSTANCE;
    L18:
        if (r30 == 3) goto L19;
    L20:
        r36 = false;
    L7:
        r2 = new AzerothUtils$generateAndUploadFornaxToken$1(this, r33);
        goto L8
    }
}
