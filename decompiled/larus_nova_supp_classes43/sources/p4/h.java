package p4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CallMcpToolResponseResult;", "", "outputKind", "", "toolResultJson", "", "cardUpdateError", "Lcom/bytedance/ai/bridge/remote/model/CallMcpToolCardUpdateError;", "toolError", "Lcom/bytedance/ai/bridge/remote/model/CallMcpToolBusinessError;", "baseResp", "Lcom/bytedance/ai/bridge/remote/model/CallMcpToolBaseResponse;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/CallMcpToolCardUpdateError;Lcom/bytedance/ai/bridge/remote/model/CallMcpToolBusinessError;Lcom/bytedance/ai/bridge/remote/model/CallMcpToolBaseResponse;)V", "getOutputKind", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getToolResultJson", "()Ljava/lang/String;", "getCardUpdateError", "()Lcom/bytedance/ai/bridge/remote/model/CallMcpToolCardUpdateError;", "getToolError", "()Lcom/bytedance/ai/bridge/remote/model/CallMcpToolBusinessError;", "getBaseResp", "()Lcom/bytedance/ai/bridge/remote/model/CallMcpToolBaseResponse;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/CallMcpToolCardUpdateError;Lcom/bytedance/ai/bridge/remote/model/CallMcpToolBusinessError;Lcom/bytedance/ai/bridge/remote/model/CallMcpToolBaseResponse;)Lcom/bytedance/ai/bridge/remote/model/CallMcpToolResponseResult;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("BaseResp")
    private final c baseResp;

    @SerializedName("card_update_error")
    private final e cardUpdateError;

    @SerializedName("output_kind")
    private final Integer outputKind;

    @SerializedName("tool_error")
    private final d toolError;

    @SerializedName("tool_result_json")
    private final String toolResultJson;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L8;
        return false;
    L8:
        h r11 = (h) r10;
        if (Intrinsics.areEqual(this.outputKind, r11.outputKind) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toolResultJson, r11.toolResultJson) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardUpdateError, r11.cardUpdateError) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.toolError, r11.toolError) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.baseResp, r11.baseResp) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.outputKind;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.toolResultJson;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        e r15 = this.cardUpdateError;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        d r18 = this.toolError;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        c r21 = this.baseResp;
        if (r21 == null) goto L23;
        r1 = r21.hashCode();
    L23:
        return r20 + r1;
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CallMcpToolResponseResult(outputKind=" + this.outputKind + ", toolResultJson=" + this.toolResultJson + ", cardUpdateError=" + this.cardUpdateError + ", toolError=" + this.toolError + ", baseResp=" + this.baseResp + ')';
    }

    public h() {
        this.outputKind = null;
        this.toolResultJson = null;
        this.cardUpdateError = null;
        this.toolError = null;
        this.baseResp = null;
    }

    public final e a() {
        return this.cardUpdateError;
    }

    public final Integer b() {
        return this.outputKind;
    }

    public final d c() {
        return this.toolError;
    }

    public final String d() {
        return this.toolResultJson;
    }
}
