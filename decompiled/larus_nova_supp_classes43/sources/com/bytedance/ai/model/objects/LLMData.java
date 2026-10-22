package com.bytedance.ai.model.objects;

import android.util.Base64;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import m2.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00108\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001c\u0010/\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR(\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/bytedance/ai/model/objects/LLMData;", "", "<init>", "()V", "addtionalContext", "", "getAddtionalContext", "()Ljava/lang/String;", "setAddtionalContext", "(Ljava/lang/String;)V", "data", "Lcom/bytedance/ai/model/objects/RealData;", "getData", "()Lcom/bytedance/ai/model/objects/RealData;", "setData", "(Lcom/bytedance/ai/model/objects/RealData;)V", "finished", "", "getFinished", "()Ljava/lang/Boolean;", "setFinished", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "targetBotId", "getTargetBotId", "setTargetBotId", "msgId", "getMsgId", "setMsgId", "conversationID", "getConversationID", "setConversationID", "realJSONData", "getRealJSONData", "setRealJSONData", "fromBotId", "getFromBotId", "setFromBotId", "createTime", "", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isSystemAgent", "setSystemAgent", "questionId", "getQuestionId", "setQuestionId", "featureMap", "", "getFeatureMap", "()Ljava/util/Map;", "setFeatureMap", "(Ljava/util/Map;)V", "realPluginParams", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LLMData {
    private String addtionalContext;
    private String conversationID;
    private Long createTime;
    private RealData data;
    private Map<String, String> featureMap;
    private Boolean finished;
    private String fromBotId;
    private Boolean isSystemAgent;
    private String msgId;
    private String questionId;
    private String realJSONData;
    private String targetBotId;

    public final String realPluginParams() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L33
        RealData r10 = this.data;     // Catch: Throwable -> L33
        if (r10 == null) goto L6;
        String r11 = r10.getDecodeType();     // Catch: Throwable -> L33
    L8:
        if (Intrinsics.areEqual(r11, "1") == false) goto L27;
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L33
        RealData r13 = this.data;     // Catch: Throwable -> L33
        if (r13 == null) goto L30;
        String r14 = r13.getPluginParams();     // Catch: Throwable -> L33
        if (r14 == null) goto L30;
        byte[] r15 = Base64.decode(r14, 0);     // Catch: Throwable -> L33
        if (r15 == null) goto L30;
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(r15)), Charsets.UTF_8));     // Catch: Throwable -> L33
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L33
    L41:
        String r18 = r16.readLine();     // Catch: Throwable -> L22
        if (r18 == null) goto L19;
        r17.append(r18);     // Catch: Throwable -> L22
        goto L41
    L19:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L33
        g.a.d("WorkerRuntime", "llmData base64+gzip success,  cost=" + (System.currentTimeMillis() - r12));     // Catch: Throwable -> L33
        String r20 = r17.toString();     // Catch: Throwable -> L33
    L31:
        Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r21) == true) goto L40;
        r0 = r21;
    L40:
        return (String) r0;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L30:
        r20 = null;
        goto L31
    L27:
        RealData r22 = this.data;     // Catch: Throwable -> L33
        if (r22 == null) goto L30;
        r20 = r22.getPluginParams();     // Catch: Throwable -> L33
        goto L31
    L6:
        r11 = null;
    L33:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    }

    public LLMData() {
        String r0 = this.fromBotId;
        if (r0 == null) goto L14;
        boolean r10 = true;
        if (Intrinsics.areEqual(r0, "SYSTEM_CVS_ID") == false) goto L8;
    L13:
        Boolean r1 = Boolean.valueOf(r10);
    L15:
        this.isSystemAgent = r1;
        return;
    L8:
        if (f.g(r0) == true) goto L10;
    L12:
        r10 = false;
        goto L13
    L10:
        if (a.a.contains(r0) == false) goto L12;
    L14:
        r1 = null;
        goto L15
    }

    public final String getAddtionalContext() {
        return this.addtionalContext;
    }

    public final String getConversationID() {
        return this.conversationID;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final RealData getData() {
        return this.data;
    }

    public final Map<String, String> getFeatureMap() {
        return this.featureMap;
    }

    public final Boolean getFinished() {
        return this.finished;
    }

    public final String getFromBotId() {
        return this.fromBotId;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final String getRealJSONData() {
        return this.realJSONData;
    }

    public final String getTargetBotId() {
        return this.targetBotId;
    }

    public final Boolean isSystemAgent() {
        return this.isSystemAgent;
    }

    public final void setAddtionalContext(String r1) {
        this.addtionalContext = r1;
    }

    public final void setConversationID(String r1) {
        this.conversationID = r1;
    }

    public final void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    public final void setData(RealData r1) {
        this.data = r1;
    }

    public final void setFeatureMap(Map<String, String> r1) {
        this.featureMap = r1;
    }

    public final void setFinished(Boolean r1) {
        this.finished = r1;
    }

    public final void setFromBotId(String r1) {
        this.fromBotId = r1;
    }

    public final void setMsgId(String r1) {
        this.msgId = r1;
    }

    public final void setQuestionId(String r1) {
        this.questionId = r1;
    }

    public final void setRealJSONData(String r1) {
        this.realJSONData = r1;
    }

    public final void setSystemAgent(Boolean r1) {
        this.isSystemAgent = r1;
    }

    public final void setTargetBotId(String r1) {
        this.targetBotId = r1;
    }
}
