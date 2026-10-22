package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.OComplexTaskConfig;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowSettingsIDL$Default implements IFlowSettingsIDL {
    public IFlowSettingsIDL$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public int getAuthenticationTypeOnLockScreen(String r1) throws RemoteException {
        return 0;
    }

    public Map getAutoExecuteAuthorizationStatusMap() throws RemoteException {
        return null;
    }

    public int getAutoGuiEnabledScene() throws RemoteException {
        return 0;
    }

    public String getAutoGuiFastModeUseSettings() throws RemoteException {
        return null;
    }

    public boolean getAutoImageUploadEnabled() throws RemoteException {
        return false;
    }

    public FeatureConfigMap getFeatureConfigMap() throws RemoteException {
        return null;
    }

    public int getIntentAuthStatus(String r1) throws RemoteException {
        return 0;
    }

    public int getIntentUploadStrategyForDebug() throws RemoteException {
        return 0;
    }

    public boolean getOAutoUseClipboardEnabled() throws RemoteException {
        return false;
    }

    public boolean getOUseMemoryEnabled() throws RemoteException {
        return false;
    }

    public String getObricCloudConfig(String r1) throws RemoteException {
        return null;
    }

    public OComplexTaskConfig getObricComplexTaskConfig() throws RemoteException {
        return null;
    }

    public String getObricFlowSettingsJson(String r1) throws RemoteException {
        return null;
    }

    public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() throws RemoteException {
        return null;
    }

    public OModelConfig getObricModelConfig() throws RemoteException {
        return null;
    }

    public int getObricPowerLockTimeoutInSeconds() throws RemoteException {
        return 0;
    }

    public boolean getPersonalContextEnabled() throws RemoteException {
        return false;
    }

    public boolean getSemanticeScreenShotEnabled() throws RemoteException {
        return false;
    }

    public boolean isLarkKnowledgeAuthorizationEnable() throws RemoteException {
        return false;
    }

    public boolean isLarkSendConfirmEnabled() throws RemoteException {
        return false;
    }

    public boolean isTtsPlayBackgroundEnabled() throws RemoteException {
        return false;
    }

    public boolean isVoicePrintAuthenticateAutoGuiEnabled() throws RemoteException {
        return false;
    }

    public void setAutoGuiEnabledScene(int r1) throws RemoteException {
    }

    public void setAutoImageUploadEnabled(boolean r1) throws RemoteException {
    }

    public void setLarkKnowledgeAuthorizationEnabled(boolean r1) throws RemoteException {
    }

    public void setOUseMemoryEnabled(boolean r1) throws RemoteException {
    }

    public void setSemanticScreenShotEnabled(boolean r1) throws RemoteException {
    }

    public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r1) throws RemoteException {
    }
}
