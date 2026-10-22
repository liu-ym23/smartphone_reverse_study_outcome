package com.bytedance.ai.bridge.system.appBaseInfo;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL$GetAppBaseInfoResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "EmptyMessageModel", "GetAppBaseInfoResultModel", "AppBaseInfoHost", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetAppBaseInfoMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL$AppBaseInfoHost;", "", BdpAwemeConstant.KEY_APP_ID, "", "<init>", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppBaseInfoHost {

        @SerializedName(BdpAwemeConstant.KEY_APP_ID)
        private final String appId;

        public static /* synthetic */ AppBaseInfoHost copy$default(AppBaseInfoHost r0, String r1, int r10, Object r11) {
            if ((r10 & 1) == 0) goto L6;
            r1 = r0.appId;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.appId;
        }

        public final AppBaseInfoHost copy(String r10) {
            Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
            return new AppBaseInfoHost(r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof AppBaseInfoHost) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.appId, ((AppBaseInfoHost) r10).appId) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.appId.hashCode();
        }

        public String toString() {
            return "AppBaseInfoHost(appId=" + this.appId + ')';
        }

        public final String getAppId() {
            return this.appId;
        }

        public AppBaseInfoHost(String r10) {
            Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
            this.appId = r10;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "enableDebug", required = false)
        void setEnableDebug(Boolean r1);

        @AIBridgeParamField(keyPath = "host", required = false)
        void setHost(AppBaseInfoHost r1);

        @AIBridgeParamField(keyPath = "language", required = true)
        void setLanguage(String r1);

        @AIBridgeParamField(keyPath = "SDKVersion", required = false)
        void setSDKVersion(String r1);

        @AIBridgeParamField(keyPath = "theme", required = false)
        void setTheme(String r1);

        @AIBridgeParamField(keyPath = "version", required = false)
        void setVersion(String r1);
    }

    public AbsGetAppBaseInfoMethodIDL() {
        this.a = "doubao.getAppBaseInfo";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
