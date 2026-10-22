package com.bytedance.ai.bridge.system.setting;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/system/setting/AbsGetAppAuthorizeSettingMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/setting/AbsGetAppAuthorizeSettingMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/system/setting/AbsGetAppAuthorizeSettingMethodIDL$GetAppAuthorizeSettingResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "EmptyMessageModel", "GetAppAuthorizeSettingResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetAppAuthorizeSettingMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "albumAuthorizationDetail", required = false)
        void setAlbumAuthorizationDetail(String r1);

        @AIBridgeParamField(keyPath = "albumAuthorized", required = true)
        void setAlbumAuthorized(String r1);

        @AIBridgeParamField(keyPath = "bluetoothAuthorizationDetail", required = false)
        void setBluetoothAuthorizationDetail(String r1);

        @AIBridgeParamField(keyPath = "bluetoothAuthorized", required = true)
        void setBluetoothAuthorized(String r1);

        @AIBridgeParamField(keyPath = "cameraAuthorizationDetail", required = false)
        void setCameraAuthorizationDetail(String r1);

        @AIBridgeParamField(keyPath = "cameraAuthorized", required = true)
        void setCameraAuthorized(String r1);

        @AIBridgeParamField(keyPath = "healthDataAuthorizationDetail", required = false)
        void setHealthDataAuthorizationDetail(Object r1);

        @AIBridgeParamField(keyPath = "locationAuthorizationDetail", required = false)
        void setLocationAuthorizationDetail(String r1);

        @AIBridgeParamField(keyPath = "locationAuthorized", required = true)
        void setLocationAuthorized(String r1);

        @AIBridgeParamField(keyPath = "locationReducedAccuracy", required = true)
        void setLocationReducedAccuracy(boolean r1);

        @AIBridgeParamField(keyPath = "microphoneAuthorizationDetail", required = false)
        void setMicrophoneAuthorizationDetail(String r1);

        @AIBridgeParamField(keyPath = "microphoneAuthorized", required = true)
        void setMicrophoneAuthorized(String r1);

        @AIBridgeParamField(keyPath = "notificationAlertAuthorized", required = true)
        void setNotificationAlertAuthorized(String r1);

        @AIBridgeParamField(keyPath = "notificationAuthorizationDetail", required = false)
        void setNotificationAuthorizationDetail(String r1);

        @AIBridgeParamField(keyPath = "notificationAuthorized", required = true)
        void setNotificationAuthorized(String r1);

        @AIBridgeParamField(keyPath = "notificationBadgeAuthorized", required = true)
        void setNotificationBadgeAuthorized(String r1);

        @AIBridgeParamField(keyPath = "notificationSoundAuthorized", required = true)
        void setNotificationSoundAuthorized(String r1);

        @AIBridgeParamField(keyPath = "phoneCalendarAuthorizationDetail", required = false)
        void setPhoneCalendarAuthorizationDetail(String r1);

        @AIBridgeParamField(keyPath = "phoneCalendarAuthorized", required = true)
        void setPhoneCalendarAuthorized(String r1);
    }

    public AbsGetAppAuthorizeSettingMethodIDL() {
        this.a = "doubao.getAppAuthorizeSetting";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
