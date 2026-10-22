package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowNetworkIDL$Default implements IFlowNetworkIDL {
    public IFlowNetworkIDL$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public void clearOmniTasks(Map r1, IFlowNetworkResultCallbackIDL r2) throws RemoteException {
    }

    public void createConditionalTask(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, Map r15, IFlowNetworkResultCallbackIDL r16) throws RemoteException {
    }

    public void deleteConditionalTask(String r1, Map r2, IFlowNetworkResultCallbackIDL r3) throws RemoteException {
    }

    public int getCurrentNetworkStatus() throws RemoteException {
        return 0;
    }

    public void notifyStopComplexTaskByHttp(long r1) throws RemoteException {
    }

    public void notifyStopComplexTaskByHttpWithScene(long r1, String r3) throws RemoteException {
    }

    public void notifyStopOmniTaskByHttp(String r1, Map r2, IFlowNetworkResultCallbackIDL r3) throws RemoteException {
    }

    public void notifyUserOperateQueue(String r1, IFlowNetworkResultCallbackIDL r2) throws RemoteException {
    }

    public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r1, boolean r2, IFlowNetworkResultCallbackIDL r3) throws RemoteException {
    }

    public void sendIntentResultForCompensationByHttp(List<OPushEvent> r1, boolean r2, IFlowNetworkResultCallbackIDL r3) throws RemoteException {
    }

    public void sendNormalRouterByHttp(String r1, String r2, IFlowNetworkResultCallbackIDL r3) throws RemoteException {
    }

    public void sendReplyAskUserByHttp(String r1, String r2, String r3, Map r4, IFlowNetworkResultCallbackIDL r5) throws RemoteException {
    }

    public void sweepConditionalTask(ObricConditionalTaskSweepRequest r1, IFlowNetworkResultCallbackIDL r2) throws RemoteException {
    }

    public void uploadOmniDataFeedbackByHttp(String r1, String r2, int r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, List<String> r12, String r13, String r14, IFlowNetworkResultCallbackIDL r15) throws RemoteException {
    }

    public void uploadOmniDataFeedbackByHttpV2(String r1, String r2, int r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, List<String> r12, String r13, String r14, boolean r15, IFlowNetworkResultCallbackIDL r16) throws RemoteException {
    }

    public void uploadOmniScreenshotByHttp(String r1, String r2, int r3, String r4, String r5, String r6, String r7, List<String> r8, String r9, String r10, IFlowNetworkResultCallbackIDL r11) throws RemoteException {
    }

    public void uploadOmniScreenshotByHttpV2(String r1, String r2, int r3, String r4, String r5, String r6, String r7, List<String> r8, String r9, String r10, boolean r11, IFlowNetworkResultCallbackIDL r12) throws RemoteException {
    }

    public void uploadUserTakeOverByHttp(String r1, String r2, String r3, long r4, Map r6, IFlowNetworkResultCallbackIDL r7) throws RemoteException {
    }
}
