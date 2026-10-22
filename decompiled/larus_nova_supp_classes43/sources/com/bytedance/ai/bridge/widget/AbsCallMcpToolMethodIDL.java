package com.bytedance.ai.bridge.widget;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/widget/AbsCallMcpToolMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/widget/AbsCallMcpToolMethodIDL$CallMcpToolRequestModel;", "Lcom/bytedance/ai/bridge/widget/AbsCallMcpToolMethodIDL$CallMcpToolResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "CallMcpToolRequestModel", "CallMcpToolResultModel", "CallMcpToolError", "CallMcpToolBusinessError", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCallMcpToolMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/bridge/widget/AbsCallMcpToolMethodIDL$CallMcpToolBusinessError;", "", "code", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "<init>", "(JLjava/lang/String;)V", "getCode", "()J", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CallMcpToolBusinessError {

        @SerializedName("code")
        private final long code;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MSG)
        private final String message;

        public static /* synthetic */ CallMcpToolBusinessError copy$default(CallMcpToolBusinessError r0, long r1, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = r0.code;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r0.message;
        L9:
            return r0.copy(r1, r10);
        }

        public final long component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final CallMcpToolBusinessError copy(long r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
            return new CallMcpToolBusinessError(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof CallMcpToolBusinessError) == true) goto L8;
            return false;
        L8:
            CallMcpToolBusinessError r11 = (CallMcpToolBusinessError) r10;
            if (this.code == r11.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.message, r11.message) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            long r0 = this.code;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "CallMcpToolBusinessError(code=" + this.code + ", message=" + this.message + ')';
        }

        public final long getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public CallMcpToolBusinessError(long r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
            this.code = r10;
            this.message = r11;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/widget/AbsCallMcpToolMethodIDL$CallMcpToolError;", "", "code", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "phase", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "getPhase", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CallMcpToolError {

        @SerializedName("code")
        private final String code;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MSG)
        private final String message;

        @SerializedName("phase")
        private final String phase;

        public static /* synthetic */ CallMcpToolError copy$default(CallMcpToolError r0, String r1, String r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r1 = r0.code;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r10 = r0.message;
        L9:
            if ((r12 & 4) == 0) goto L12;
            r11 = r0.phase;
        L12:
            return r0.copy(r1, r10, r11);
        }

        public final String component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final String component3() {
            return this.phase;
        }

        public final CallMcpToolError copy(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "code");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
            Intrinsics.checkNotNullParameter(r12, "phase");
            return new CallMcpToolError(r10, r11, r12);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof CallMcpToolError) == true) goto L8;
            return false;
        L8:
            CallMcpToolError r11 = (CallMcpToolError) r10;
            if (Intrinsics.areEqual(this.code, r11.code) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.message, r11.message) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.phase, r11.phase) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.code.hashCode() * 31) + this.message.hashCode()) * 31) + this.phase.hashCode();
        }

        public String toString() {
            return "CallMcpToolError(code=" + this.code + ", message=" + this.message + ", phase=" + this.phase + ')';
        }

        public final String getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getPhase() {
            return this.phase;
        }

        public CallMcpToolError(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "code");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
            Intrinsics.checkNotNullParameter(r12, "phase");
            this.code = r10;
            this.message = r11;
            this.phase = r12;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), keyPath = "skipWidgetUpdate", required = false)
        boolean getSkipWidgetUpdate();

        @AIBridgeParamField(keyPath = "toolArgs", required = true)
        Map<String, Object> getToolArgs();

        @AIBridgeParamField(keyPath = "toolName", required = true)
        String getToolName();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "cardUpdateError", required = false)
        void setCardUpdateError(CallMcpToolError r1);

        @AIBridgeParamField(keyPath = "toolError", required = false)
        void setToolError(CallMcpToolBusinessError r1);

        @AIBridgeParamField(keyPath = "toolResult", required = false)
        void setToolResult(Map<String, ? extends Object> r1);
    }

    public AbsCallMcpToolMethodIDL() {
        this.a = "doubao.callMcpTool";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
