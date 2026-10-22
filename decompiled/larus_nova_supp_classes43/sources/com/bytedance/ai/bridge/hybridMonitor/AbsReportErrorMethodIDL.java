package com.bytedance.ai.bridge.hybridMonitor;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$ErrorInfoModel;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$EmptyMessageModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "ErrorInfoModel", "EmptyMessageModel", "ErrorData", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsReportErrorMethodIDL extends CoreAIBridgeMethod<b, a> {
    public final String a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$ErrorData;", "", "error_message", "", "fileName", "lineNumber", "", "columnNumber", "stack", "sourcemap_release", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getError_message", "()Ljava/lang/String;", "getFileName", "getLineNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColumnNumber", "getStack", "getSourcemap_release", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$ErrorData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ErrorData {

        @SerializedName("columnNumber")
        private final Integer columnNumber;

        @SerializedName("error_message")
        private final String error_message;

        @SerializedName("fileName")
        private final String fileName;

        @SerializedName("lineNumber")
        private final Integer lineNumber;

        @SerializedName("sourcemap_release")
        private final String sourcemap_release;

        @SerializedName("stack")
        private final String stack;

        public ErrorData() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ ErrorData copy$default(ErrorData r10, String r11, String r12, Integer r13, Integer r14, String r15, String r16, int r17, Object r18) {
            if ((r17 & 1) == 0) goto L6;
            r11 = r10.error_message;
        L6:
            if ((r17 & 2) == 0) goto L8;
            r12 = r10.fileName;
        L8:
            String r19 = r12;
            if ((r17 & 4) == 0) goto L11;
            r13 = r10.lineNumber;
        L11:
            Integer r0 = r13;
            if ((r17 & 8) == 0) goto L14;
            r14 = r10.columnNumber;
        L14:
            Integer r1 = r14;
            if ((r17 & 16) == 0) goto L17;
            r15 = r10.stack;
        L17:
            String r20 = r15;
            if ((r17 & 32) == 0) goto L20;
            r16 = r10.sourcemap_release;
        L20:
            String r21 = r11;
            return r10.copy(r21, r19, r0, r1, r20, r16);
        }

        public final String component1() {
            return this.error_message;
        }

        public final String component2() {
            return this.fileName;
        }

        public final Integer component3() {
            return this.lineNumber;
        }

        public final Integer component4() {
            return this.columnNumber;
        }

        public final String component5() {
            return this.stack;
        }

        public final String component6() {
            return this.sourcemap_release;
        }

        public final ErrorData copy(String r10, String r11, Integer r12, Integer r13, String r14, String r15) {
            return new ErrorData(r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ErrorData) == true) goto L8;
            return false;
        L8:
            ErrorData r11 = (ErrorData) r10;
            if (Intrinsics.areEqual(this.error_message, r11.error_message) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.fileName, r11.fileName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.lineNumber, r11.lineNumber) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.columnNumber, r11.columnNumber) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.stack, r11.stack) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.sourcemap_release, r11.sourcemap_release) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            String r0 = this.error_message;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.fileName;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            Integer r15 = this.lineNumber;
            if (r15 != null) goto L13;
            int r16 = 0;
        L14:
            int r17 = (r14 + r16) * 31;
            Integer r18 = this.columnNumber;
            if (r18 != null) goto L17;
            int r19 = 0;
        L18:
            int r20 = (r17 + r19) * 31;
            String r21 = this.stack;
            if (r21 != null) goto L21;
            int r22 = 0;
        L22:
            int r23 = (r20 + r22) * 31;
            String r24 = this.sourcemap_release;
            if (r24 == null) goto L27;
            r1 = r24.hashCode();
        L27:
            return r23 + r1;
        L21:
            r22 = r21.hashCode();
            goto L22
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

        public String toString() {
            return "ErrorData(error_message=" + this.error_message + ", fileName=" + this.fileName + ", lineNumber=" + this.lineNumber + ", columnNumber=" + this.columnNumber + ", stack=" + this.stack + ", sourcemap_release=" + this.sourcemap_release + ')';
        }

        public final Integer getColumnNumber() {
            return this.columnNumber;
        }

        public final String getError_message() {
            return this.error_message;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final Integer getLineNumber() {
            return this.lineNumber;
        }

        public final String getSourcemap_release() {
            return this.sourcemap_release;
        }

        public final String getStack() {
            return this.stack;
        }

        public ErrorData(String r1, String r10, Integer r11, Integer r12, String r13, String r14) {
            this.error_message = r1;
            this.fileName = r10;
            this.lineNumber = r11;
            this.columnNumber = r12;
            this.stack = r13;
            this.sourcemap_release = r14;
        }

        public /* synthetic */ ErrorData(String r10, String r11, Integer r12, Integer r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
            if ((r16 & 1) == 0) goto L5;
            String r18 = null;
        L7:
            if ((r16 & 2) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r16 & 4) == 0) goto L13;
            Integer r19 = null;
        L15:
            if ((r16 & 8) == 0) goto L17;
            Integer r20 = null;
        L19:
            if ((r16 & 16) == 0) goto L21;
            String r21 = null;
        L23:
            if ((r16 & 32) == 0) goto L25;
            String r110 = null;
        L26:
            this(r18, r1, r19, r20, r21, r110);
            return;
        L25:
            r110 = r15;
            goto L26
        L21:
            r21 = r14;
            goto L23
        L17:
            r20 = r13;
            goto L19
        L13:
            r19 = r12;
            goto L15
        L9:
            r1 = r11;
            goto L11
        L5:
            r18 = r10;
            goto L7
        }
    }

    @AIBridgeResultModel
    public interface a extends ResultModel {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "context", required = false)
        Map<String, Object> getContext();

        @AIBridgeParamField(keyPath = "data", required = false)
        ErrorData getData();
    }

    public AbsReportErrorMethodIDL() {
        this.a = "hybridMonitor.reportError";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
