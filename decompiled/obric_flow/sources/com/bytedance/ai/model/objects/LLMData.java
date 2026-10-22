package com.bytedance.ai.model.objects;

import android.util.Base64;
import androidx.annotation.Keep;
import com.bytedance.ai.utils.c;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import t0.d;
import y0.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00108\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001c\u0010/\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR(\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/bytedance/ai/model/objects/LLMData;", "", "<init>", "()V", "addtionalContext", "", "getAddtionalContext", "()Ljava/lang/String;", "setAddtionalContext", "(Ljava/lang/String;)V", "data", "Lcom/bytedance/ai/model/objects/RealData;", "getData", "()Lcom/bytedance/ai/model/objects/RealData;", "setData", "(Lcom/bytedance/ai/model/objects/RealData;)V", "finished", "", "getFinished", "()Ljava/lang/Boolean;", "setFinished", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "targetBotId", "getTargetBotId", "setTargetBotId", "msgId", "getMsgId", "setMsgId", "conversationID", "getConversationID", "setConversationID", "realJSONData", "getRealJSONData", "setRealJSONData", "fromBotId", "getFromBotId", "setFromBotId", "createTime", "", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isSystemAgent", "setSystemAgent", "questionId", "getQuestionId", "setQuestionId", "featureMap", "", "getFeatureMap", "()Ljava/util/Map;", "setFeatureMap", "(Ljava/util/Map;)V", "realPluginParams", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLLMData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LLMData.kt\ncom/bytedance/ai/model/objects/LLMData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
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

    public LLMData() {
        String r5 = this.fromBotId;
        if (r5 != null) goto L5;
        Boolean r10 = null;
    L15:
        this.isSystemAgent = r10;
        return;
    L5:
        if (Intrinsics.areEqual(r5, "SYSTEM_CVS_ID") == false) goto L8;
    L11:
        boolean r11 = true;
    L13:
        r10 = Boolean.valueOf(r11);
        goto L15
    L8:
        if (c.l(r5) == true) goto L10;
    L12:
        r11 = false;
        goto L13
    L10:
        if (a.f23228a.contains(r5) == false) goto L12;
        goto L11
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

    public final String realPluginParams() {
        Object r5 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L6
        RealData r11 = this.data;     // Catch: Throwable -> L6
        if (r11 == null) goto L8;
        String r12 = r11.getDecodeType();     // Catch: Throwable -> L6
    L10:
        if (Intrinsics.areEqual(r12, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L33;
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L6
        RealData r14 = this.data;     // Catch: Throwable -> L6
        if (r14 == null) goto L36;
        String r15 = r14.getPluginParams();     // Catch: Throwable -> L6
        if (r15 == null) goto L36;
        byte[] r16 = Base64.decode(r15, 0);     // Catch: Throwable -> L6
        if (r16 == null) goto L36;
        BufferedReader r17 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(r16)), Charsets.UTF_8));     // Catch: Throwable -> L6
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L6
    L46:
        String r19 = r17.readLine();     // Catch: Throwable -> L21
        if (r19 == null) goto L23;
        r18.append(r19);     // Catch: Throwable -> L21
        goto L46
    L23:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L6
        String r21 = "llmData base64+gzip success,  cost=" + (System.currentTimeMillis() - r13);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");     // Catch: Throwable -> L6
        d r22 = c.f2846a;     // Catch: Throwable -> L6
        if (r22 == null) goto L27;
        r22.d("WorkerRuntime", r21);     // Catch: Throwable -> L6
    L27:
        String r23 = r18.toString();     // Catch: Throwable -> L6
    L37:
        Object r24 = Result.m124constructorimpl(r23);     // Catch: Throwable -> L6
    L41:
        if (Result.m130isFailureimpl(r24) == true) goto L45;
        r5 = r24;
    L45:
        return (String) r5;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L36:
        r23 = null;
        goto L37
    L33:
        RealData r25 = this.data;     // Catch: Throwable -> L6
        if (r25 == null) goto L36;
        r23 = r25.getPluginParams();     // Catch: Throwable -> L6
        goto L37
    L8:
        r12 = null;
    L6:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L41
    }

    public final void setAddtionalContext(String r5) {
        this.addtionalContext = r5;
    }

    public final void setConversationID(String r5) {
        this.conversationID = r5;
    }

    public final void setCreateTime(Long r5) {
        this.createTime = r5;
    }

    public final void setData(RealData r5) {
        this.data = r5;
    }

    public final void setFeatureMap(Map<String, String> r5) {
        this.featureMap = r5;
    }

    public final void setFinished(Boolean r5) {
        this.finished = r5;
    }

    public final void setFromBotId(String r5) {
        this.fromBotId = r5;
    }

    public final void setMsgId(String r5) {
        this.msgId = r5;
    }

    public final void setQuestionId(String r5) {
        this.questionId = r5;
    }

    public final void setRealJSONData(String r5) {
        this.realJSONData = r5;
    }

    public final void setSystemAgent(Boolean r5) {
        this.isSystemAgent = r5;
    }

    public final void setTargetBotId(String r5) {
        this.targetBotId = r5;
    }
}
