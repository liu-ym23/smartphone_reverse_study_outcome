package com.obric.aiagent.assistant.idl;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0011\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J)\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u000b2\u000e\u0010\u0015\u001a\n \t*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u000bH\u0096\u0001J)\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u0019\u001a\n \t*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n \t*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096\u0001¨\u0006 "}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentVoiceInteractionIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentVoiceInteractionIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentVoiceInteractionIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getUserRecentData", "Lcom/obric/aiagent/assistant/idl/bean/PersonalContextInfo;", "kotlin.jvm.PlatformType", "onAsrEnd", "", "onAsrStart", "localMsgId", "", "onHandleAssist", "structure", "Landroid/app/assist/AssistStructure;", "content", "Landroid/app/assist/AssistContent;", "onHandleScreenshot", "screenshot", "Landroid/graphics/Bitmap;", "onHide", "onQueryAudioFile", "fileUri", "onShow", "args", "Landroid/os/Bundle;", "onStartChatWindow", "state", "", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final class AgentVoiceInteractionIDLStub extends IAgentVoiceInteractionIDL.Stub {
    private final /* synthetic */ IAgentVoiceInteractionIDL $$delegate_0;

    public PersonalContextInfo getUserRecentData() {
        return this.$$delegate_0.getUserRecentData();
    }

    public void onAsrEnd() {
        this.$$delegate_0.onAsrEnd();
    }

    public void onAsrStart(String r2) {
        this.$$delegate_0.onAsrStart(r2);
    }

    public void onHandleAssist(AssistStructure r2, AssistContent r3) {
        this.$$delegate_0.onHandleAssist(r2, r3);
    }

    public void onHandleScreenshot(Bitmap r2) {
        this.$$delegate_0.onHandleScreenshot(r2);
    }

    public void onHide() {
        this.$$delegate_0.onHide();
    }

    public void onQueryAudioFile(String r2, String r3) {
        this.$$delegate_0.onQueryAudioFile(r2, r3);
    }

    public void onShow(Bundle r2) {
        this.$$delegate_0.onShow(r2);
    }

    public void onStartChatWindow(int r2) {
        this.$$delegate_0.onStartChatWindow(r2);
    }

    public AgentVoiceInteractionIDLStub() {
        IAgentVoiceInteractionIDL r0 = (IAgentVoiceInteractionIDLSPI) ServiceManager.get().getService(IAgentVoiceInteractionIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IAgentVoiceInteractionIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
