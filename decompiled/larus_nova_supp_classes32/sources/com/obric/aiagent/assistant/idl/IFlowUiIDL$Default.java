package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowUiIDL$Default implements IFlowUiIDL {
    public IFlowUiIDL$Default() {
    }

    public void addCustomBarAction(String r1, String r2, String r3, long r4) throws RemoteException {
    }

    public IBinder asBinder() {
        return null;
    }

    public void closeAssistantInputPanel(String r1) throws RemoteException {
    }

    public void dismissKeyguard() throws RemoteException {
    }

    public void finishChatPage() throws RemoteException {
    }

    public String getCurrentDisplayModel() throws RemoteException {
        return null;
    }

    public String getTaskSkillModelJson() throws RemoteException {
        return null;
    }

    public int getWindowState() throws RemoteException {
        return 0;
    }

    public void handleObricAction(String r1, String r2, IObricActionResultCallbackIDL r3) throws RemoteException {
    }

    public boolean isAssistantRequestFromAIKey() throws RemoteException {
        return false;
    }

    public boolean isAudioMessage(String r1) throws RemoteException {
        return false;
    }

    public boolean isAuthenticationPass() throws RemoteException {
        return false;
    }

    public boolean isAuthenticationPassV2(String r1) throws RemoteException {
        return false;
    }

    public Authentication isAuthenticationPassV3(String r1) throws RemoteException {
        return null;
    }

    public boolean isWindowMode() throws RemoteException {
        return false;
    }

    public boolean isWindowShowing() throws RemoteException {
        return false;
    }

    public void notifyAssistantState(String r1, boolean r2, StateInfo r3) throws RemoteException {
    }

    public void notifyMessageInAutoGui(String r1) throws RemoteException {
    }

    public void notifyOAutoDied() throws RemoteException {
    }

    public void openAssistantInputPanel(String r1, StateInfo r2, boolean r3) throws RemoteException {
    }

    public void openChatActivity(int r1) throws RemoteException {
    }

    public void openRealtimeCall(int r1, IOpenRealTimeCallCallbackIDL r2) throws RemoteException {
    }

    public void popWindow() throws RemoteException {
    }

    public void processRequiresAuthentication() throws RemoteException {
    }

    public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r1, boolean r2, Bundle r3) throws RemoteException {
    }

    public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r1, Bundle r2) throws RemoteException {
    }

    public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r1, Bundle r2) throws RemoteException {
    }

    public void setAssistantInteractionListener(String r1, IAssistantInteractionListenerIDL r2) throws RemoteException {
    }

    public void setAutoIncreaseWindow(boolean r1) throws RemoteException {
    }

    public void shouldDowngradeAuthForDora(int r1, IDowngradeAuthForDoraCallbackIDL r2) throws RemoteException {
    }

    public void showToast(String r1) throws RemoteException {
    }

    public void showWindow() throws RemoteException {
    }

    public void suspendDismissKeyguard(String r1, String[] r2, IDismissKeyguardCallbackIDL r3, boolean r4, Bundle r5) throws RemoteException {
    }
}
