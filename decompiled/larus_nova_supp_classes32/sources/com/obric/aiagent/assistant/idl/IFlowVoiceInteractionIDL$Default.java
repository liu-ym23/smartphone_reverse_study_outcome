package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowVoiceInteractionIDL$Default implements IFlowVoiceInteractionIDL {
    public IFlowVoiceInteractionIDL$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public boolean closeContinuousTalk() throws RemoteException {
        return false;
    }

    public boolean isInRealtimeCalling() throws RemoteException {
        return false;
    }

    public boolean isInteractionSessionStateListening() throws RemoteException {
        return false;
    }

    public void readContent(String r1) throws RemoteException {
    }

    public void readContentByMessage(IMMessage r1) throws RemoteException {
    }

    public void replayMessageTts(String r1) throws RemoteException {
    }

    public void requireSyncData(IFlowSyncDataResultIDL r1) throws RemoteException {
    }

    public boolean tryInterruptAssistant(AppEvent r1) throws RemoteException {
        return false;
    }

    public void tryOpenClickTalk(int r1) throws RemoteException {
    }

    public boolean tryOpenMicToRecording(AppEvent r1) throws RemoteException {
        return false;
    }

    public void updateIntentExt(Map r1) throws RemoteException {
    }

    public void updateScreenshotForAsr(String r1) throws RemoteException {
    }

    public void wakeupAssistant(String r1) throws RemoteException {
    }
}
