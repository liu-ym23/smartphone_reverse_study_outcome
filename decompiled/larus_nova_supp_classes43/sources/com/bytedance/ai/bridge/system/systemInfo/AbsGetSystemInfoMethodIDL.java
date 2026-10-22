package com.bytedance.ai.bridge.system.systemInfo;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL$GetSystemInfoResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "EmptyMessageModel", "GetSystemInfoResultModel", "SystemInfoSafeArea", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetSystemInfoMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL$SystemInfoSafeArea;", "", "left", "", "right", "top", "bottom", "width", "height", "<init>", "(IIIIII)V", "getLeft", "()I", "getRight", "getTop", "getBottom", "getWidth", "getHeight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SystemInfoSafeArea {

        @SerializedName("bottom")
        private final int bottom;

        @SerializedName("height")
        private final int height;

        @SerializedName("left")
        private final int left;

        @SerializedName("right")
        private final int right;

        @SerializedName("top")
        private final int top;

        @SerializedName("width")
        private final int width;

        public static /* synthetic */ SystemInfoSafeArea copy$default(SystemInfoSafeArea r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Object r18) {
            if ((r17 & 1) == 0) goto L6;
            r11 = r10.left;
        L6:
            if ((r17 & 2) == 0) goto L8;
            r12 = r10.right;
        L8:
            int r19 = r12;
            if ((r17 & 4) == 0) goto L11;
            r13 = r10.top;
        L11:
            int r0 = r13;
            if ((r17 & 8) == 0) goto L14;
            r14 = r10.bottom;
        L14:
            int r1 = r14;
            if ((r17 & 16) == 0) goto L17;
            r15 = r10.width;
        L17:
            int r20 = r15;
            if ((r17 & 32) == 0) goto L20;
            r16 = r10.height;
        L20:
            int r21 = r11;
            return r10.copy(r21, r19, r0, r1, r20, r16);
        }

        public final int component1() {
            return this.left;
        }

        public final int component2() {
            return this.right;
        }

        public final int component3() {
            return this.top;
        }

        public final int component4() {
            return this.bottom;
        }

        public final int component5() {
            return this.width;
        }

        public final int component6() {
            return this.height;
        }

        public final SystemInfoSafeArea copy(int r10, int r11, int r12, int r13, int r14, int r15) {
            return new SystemInfoSafeArea(r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof SystemInfoSafeArea) == true) goto L8;
            return false;
        L8:
            SystemInfoSafeArea r11 = (SystemInfoSafeArea) r10;
            if (this.left == r11.left) goto L12;
            return false;
        L12:
            if (this.right == r11.right) goto L15;
            return false;
        L15:
            if (this.top == r11.top) goto L18;
            return false;
        L18:
            if (this.bottom == r11.bottom) goto L21;
            return false;
        L21:
            if (this.width == r11.width) goto L24;
            return false;
        L24:
            if (this.height == r11.height) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((this.left * 31) + this.right) * 31) + this.top) * 31) + this.bottom) * 31) + this.width) * 31) + this.height;
        }

        public String toString() {
            return "SystemInfoSafeArea(left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + ", width=" + this.width + ", height=" + this.height + ')';
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getRight() {
            return this.right;
        }

        public final int getTop() {
            return this.top;
        }

        public final int getWidth() {
            return this.width;
        }

        public SystemInfoSafeArea(int r1, int r10, int r11, int r12, int r13, int r14) {
            this.left = r1;
            this.right = r10;
            this.top = r11;
            this.bottom = r12;
            this.width = r13;
            this.height = r14;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "abi", required = false)
        void setAbi(String r1);

        @AIBridgeParamField(keyPath = "benchmarkLevel", required = false)
        void setBenchmarkLevel(Double r1);

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.VALUE_BRAND, required = true)
        void setBrand(String r1);

        @AIBridgeParamField(keyPath = "deviceOrientation", required = false)
        void setDeviceOrientation(String r1);

        @AIBridgeParamField(keyPath = "enableDebug", required = false)
        void setEnableDebug(Boolean r1);

        @AIBridgeParamField(keyPath = "language", required = true)
        void setLanguage(String r1);

        @AIBridgeParamField(keyPath = "model", required = true)
        void setModel(String r1);

        @AIBridgeParamField(keyPath = "pixelRatio", required = true)
        void setPixelRatio(double r1);

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_PLATFORM, required = true)
        void setPlatform(String r1);

        @AIBridgeParamField(keyPath = "SDKVersion", required = false)
        void setSDKVersion(String r1);

        @AIBridgeParamField(keyPath = "safeArea", required = false)
        void setSafeArea(SystemInfoSafeArea r1);

        @AIBridgeParamField(keyPath = "screenHeight", required = true)
        void setScreenHeight(int r1);

        @AIBridgeParamField(keyPath = "screenWidth", required = true)
        void setScreenWidth(int r1);

        @AIBridgeParamField(keyPath = "statusBarHeight", required = true)
        void setStatusBarHeight(int r1);

        @AIBridgeParamField(keyPath = "system", required = true)
        void setSystem(String r1);

        @AIBridgeParamField(keyPath = "theme", required = false)
        void setTheme(String r1);

        @AIBridgeParamField(keyPath = "version", required = false)
        void setVersion(String r1);

        @AIBridgeParamField(keyPath = "windowHeight", required = true)
        void setWindowHeight(int r1);

        @AIBridgeParamField(keyPath = "windowWidth", required = true)
        void setWindowWidth(int r1);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetSystemInfoMethodIDL() {
        this.a = "doubao.getSystemInfo";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
