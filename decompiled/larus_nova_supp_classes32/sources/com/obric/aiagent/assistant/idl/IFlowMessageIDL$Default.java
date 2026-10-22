package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowMessageIDL$Default implements IFlowMessageIDL {
    public IFlowMessageIDL$Default() {
    }

    public void addMessage(IMMessage r1, String r2, String r3) throws RemoteException {
    }

    public void appendMessageExt(String r1, Map r2) throws RemoteException {
    }

    public IBinder asBinder() {
        return null;
    }

    public void deleteMessage(String r1, IFlowDeleteMessageCallbackIDL r2) throws RemoteException {
    }

    public void deleteRemoteResource(List<String> r1) throws RemoteException {
    }

    public void fetchLatestMessages(int r1, IFlowFindMessagesCallbackIDL r2) throws RemoteException {
    }

    public void findAnswersbyQueryId(String r1, IFlowFindMessagesCallbackIDL r2) throws RemoteException {
    }

    public void findMessagebyId(String r1, IFlowFindMessageCallbackIDL r2) throws RemoteException {
    }

    public String generateLocalMessageId() throws RemoteException {
        return null;
    }

    public void getMainTxtContentForMessage(String r1, IFlowMessageMainTextBlockCallbackIDL r2) throws RemoteException {
    }

    public String getMainTxtContentFromMessage(IMMessage r1) throws RemoteException {
        return null;
    }

    public void imageXUpload(String r1, IImageXUploadCallbackIDL r2) throws RemoteException {
    }

    public boolean isConversationTtsEnabled(String r1) throws RemoteException {
        return false;
    }

    public void isMessageLocalInterrupted(String r1, IFlowIsMessageInterruptedCallbackIDL r2) throws RemoteException {
    }

    public void notifySemanticUserEditEvent(String r1, String r2, Map r3, IFlowSemanticEditCallbackIDL r4) throws RemoteException {
    }

    public void notifySemanticUserEditEventWithIdentifier(String r1, String r2, String r3, Map r4, IFlowSemanticEditCallbackIDL r5) throws RemoteException {
    }

    public void notifySemanticUserEditEventWithUri(String r1, String r2, String r3, Map r4, IFlowSemanticEditCallbackIDL r5) throws RemoteException {
    }

    public void refreshLatestMessages(String r1, int r2) throws RemoteException {
    }

    public void registerCallback(IFlowMessageCallbackIDL r1) throws RemoteException {
    }

    public void registerCallbackWithEvents(IFlowMessageCallbackIDL r1, int r2) throws RemoteException {
    }

    public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r1) throws RemoteException {
    }

    public void registerStreamObserver(IFlowStreamObserverIDL r1) throws RemoteException {
    }

    public void retryFetchMessage(IMMessage r1) throws RemoteException {
    }

    public void sendMessage(String r1, String r2, String r3, String r4) throws RemoteException {
    }

    public void sendMessageWithExtra(String r1, String r2, String r3, String r4, Map r5) throws RemoteException {
    }

    public void unregisterCallback(IFlowMessageCallbackIDL r1) throws RemoteException {
    }

    public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r1) throws RemoteException {
    }

    public void unregisterStreamObserver(IFlowStreamObserverIDL r1) throws RemoteException {
    }

    public void updateMessageExt(String r1, Map r2) throws RemoteException {
    }

    public void updateMutableMessageContent(String r1, String r2) throws RemoteException {
    }

    public void updateMutableWidgetRenderData(String r1, String r2, String r3) throws RemoteException {
    }

    public void uploadImage(String r1, String r2, IImageXUploadCallbackIDL r3) throws RemoteException {
    }
}
