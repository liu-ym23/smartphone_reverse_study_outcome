package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OAppAction$OMpParams;", NameKeys.UnloadStrategy_No_Strategy, "id", NameKeys.UnloadStrategy_No_Strategy, "questionId", "actionParameters", NameKeys.UnloadStrategy_No_Strategy, "actionResultData", "ext", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getId", "()J", "getQuestionId", "getActionParameters", "()Ljava/lang/String;", "getActionResultData", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OAppAction$c {

    @SerializedName("action_parameters")
    private final String actionParameters;

    @SerializedName("action_result_data")
    private final String actionResultData;

    @SerializedName("ext")
    private final Map<String, String> ext;

    @SerializedName("id")
    private final long id;

    @SerializedName("question_id")
    private final long questionId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OAppAction$c) == true) goto L8;
        return false;
    L8:
        OAppAction$c r9 = (OAppAction$c) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (this.questionId == r9.questionId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionParameters, r9.actionParameters) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionResultData, r9.actionResultData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ext, r9.ext) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = this.id;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.questionId;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.actionParameters;
        int r5 = 0;
        if (r4 != null) goto L5;
        int r6 = 0;
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.actionResultData;
        if (r8 != null) goto L9;
        int r9 = 0;
    L10:
        int r10 = (r7 + r9) * 31;
        Map<String, String> r11 = this.ext;
        if (r11 == null) goto L15;
        r5 = r11.hashCode();
    L15:
        return r10 + r5;
    L9:
        r9 = r8.hashCode();
        goto L10
    L5:
        r6 = r4.hashCode();
        goto L6
    }

    public final String toString() {
        return "OMpParams(id=" + this.id + ", questionId=" + this.questionId + ", actionParameters=" + this.actionParameters + ", actionResultData=" + this.actionResultData + ", ext=" + this.ext + ')';
    }

    public OAppAction$c() {
        this.id = -1;
        this.questionId = -1;
        this.actionParameters = NameKeys.UnloadStrategy_No_Strategy;
        this.actionResultData = NameKeys.UnloadStrategy_No_Strategy;
        this.ext = null;
    }
}
