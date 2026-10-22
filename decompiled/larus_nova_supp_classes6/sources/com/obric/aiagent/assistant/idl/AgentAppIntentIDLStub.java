package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016JI\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000f\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J7\u0010\u0012\u001a\u00020\b2,\u0010\u0013\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016¨\u0006\u00010\u0014¨\u0006\u0001H\u0096\u0001JL\u0010\u0017\u001a\u00020\b2,\u0010\u0018\u001a(\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u001a0\u001a \u000b*\u0014\u0012\u000e\b\u0001\u0012\n \u000b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u00190\u00192\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001¢\u0006\u0002\u0010\u001dJT\u0010\u001e\u001a\u00020\b2,\u0010\u0018\u001a(\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u001f0\u001f \u000b*\u0014\u0012\u000e\b\u0001\u0012\n \u000b*\u0004\u0018\u00010\u001f0\u001f\u0018\u00010\u00190\u00192\u0006\u0010 \u001a\u00020!2\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010\"0\"H\u0096\u0001¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\b2\u000e\u0010%\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001Jm\u0010&\u001a\u00020\b2\u000e\u0010%\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010'\u001a\n \u000b*\u0004\u0018\u00010\n0\n2*\u0010(\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010*0)2\u000e\u0010+\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010,\u001a\u00020!H\u0096\u0001Je\u0010-\u001a\u00020\b2\u000e\u0010%\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010'\u001a\n \u000b*\u0004\u0018\u00010\n0\n2*\u0010(\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010*0)2\u000e\u0010.\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J[\u0010/\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u001a0\u001a \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010*0)2,\u00100\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016¨\u0006\u00010\u0014¨\u0006\u0001H\u0096\u0001J5\u00101\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010*0)2\u0006\u00102\u001a\u000203H\u0096\u0001J!\u00104\u001a\n \u000b*\u0004\u0018\u000105052\u000e\u00106\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J?\u00107\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016¨\u0006\u00010\u0014¨\u0006\u00012\u000e\u0010%\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J=\u00108\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010*0)2\u000e\u0010%\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u00109\u001a\u00020!H\u0096\u0001J\t\u0010:\u001a\u00020!H\u0096\u0001J\t\u0010;\u001a\u00020\bH\u0096\u0001J\t\u0010<\u001a\u00020\bH\u0096\u0001J!\u0010=\u001a\u00020\b2\u000e\u0010>\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010?\u001a\u000203H\u0096\u0001J)\u0010@\u001a\u00020\b2\u000e\u00106\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010A\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010B\u001a\u00020\b2\u000e\u00106\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010C\u001a\u00020\bH\u0096\u0001J\u0011\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020!H\u0096\u0001J\t\u0010F\u001a\u000203H\u0096\u0001J\\\u0010G\u001a\u0002032\u000e\u0010H\u001a\n \u000b*\u0004\u0018\u00010\n0\n2,\u0010I\u001a(\u0012\f\u0012\n \u000b*\u0004\u0018\u00010J0J \u000b*\u0014\u0012\u000e\b\u0001\u0012\n \u000b*\u0004\u0018\u00010J0J\u0018\u00010\u00190\u00192\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010J0JH\u0096\u0001¢\u0006\u0002\u0010LJ\u0019\u0010M\u001a\u00020\b2\u000e\u0010N\u001a\n \u000b*\u0004\u0018\u00010O0OH\u0096\u0001Jg\u0010P\u001a\u00020\b2\u000e\u00106\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010Q\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010R\u001a\n \u000b*\u0004\u0018\u00010\n0\n2,\u0010S\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015 \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016¨\u0006\u00010\u0014¨\u0006\u0001H\u0096\u0001J\u0019\u0010T\u001a\u00020\b2\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010U0UH\u0096\u0001JI\u0010V\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010W\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000f\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010X\u001a\u00020\b2\u000e\u0010Y\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0011\u0010Z\u001a\u00020!2\u0006\u0010[\u001a\u00020!H\u0096\u0001J\u0019\u0010\\\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010]0]H\u0096\u0001J\u0019\u0010^\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010_0_H\u0096\u0001J\u0019\u0010`\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010a0aH\u0096\u0001J\u0019\u0010b\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010c0cH\u0096\u0001J\u0019\u0010d\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0096\u0001J\u0019\u0010e\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010f0fH\u0096\u0001J\u0019\u0010g\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010h0hH\u0096\u0001J\u0019\u0010i\u001a\u00020\b2\u000e\u0010j\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010k\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010l0lH\u0096\u0001J\u0019\u0010m\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010n0nH\u0096\u0001J\t\u0010o\u001a\u00020\bH\u0096\u0001J\u0019\u0010p\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010q0qH\u0096\u0001JD\u0010r\u001a\u00020\b2,\u0010\u0018\u001a(\u0012\f\u0012\n \u000b*\u0004\u0018\u00010s0s \u000b*\u0014\u0012\u000e\b\u0001\u0012\n \u000b*\u0004\u0018\u00010s0s\u0018\u00010\u00190\u00192\u0006\u0010t\u001a\u000203H\u0096\u0001¢\u0006\u0002\u0010uJ\u0019\u0010v\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010w0wH\u0096\u0001J\u0019\u0010x\u001a\u00020\b2\u000e\u0010y\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010z\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\u0019\u0010{\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010|0|H\u0096\u0001J)\u0010}\u001a\u00020\b2\u000e\u0010~\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010\u007f\u001a\u00020\b2\u000e\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010U0UH\u0096\u0001J\n\u0010\u0080\u0001\u001a\u00020\bH\u0096\u0001J#\u0010\u0081\u0001\u001a\u00020\b2\u000e\u0010K\u001a\n \u000b*\u0004\u0018\u00010]0]2\u0007\u0010\u0082\u0001\u001a\u00020!H\u0096\u0001J\u001a\u0010\u0083\u0001\u001a\u00020\b2\u000e\u0010N\u001a\n \u000b*\u0004\u0018\u00010O0OH\u0096\u0001¨\u0006\u0084\u0001"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentAppIntentIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentAppIntentIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentAppIntentIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "callPhone", "", "telephone", "", "kotlin.jvm.PlatformType", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "type", "replyId", "callShortLink", "data", "clearAllOmniTask", "extra", "", "", "", "deleteEntities", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "callback", "Lcom/obric/aiagent/assistant/idl/IEntityDeleteCallbackIDL;", "([Lcom/obric/capabilitykit/entity/app/AppEntity;Lcom/obric/aiagent/assistant/idl/IEntityDeleteCallbackIDL;)V", "deleteRecordings", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "deleteAll", "", "Lcom/obric/aiagent/assistant/idl/IRecordingDeleteCallbackIDL;", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;ZLcom/obric/aiagent/assistant/idl/IRecordingDeleteCallbackIDL;)V", "drainOmniUploadImagesForFeedback", "omniTaskId", "drainOmniUploadImagesForFeedbackWithInfo", "feedbackContent", "feedbackTags", "", "", "score", "needUploadImage", "drainOmniUploadImagesForFeedbackWithType", "feedbackType", "getAppEntityList", "typeAndIdsMap", "getComplexTaskPanelInfoFromPC", "limit", "", "getIntentExecution", "Lcom/obric/aiagent/assistant/idl/bean/IntentDebugReport;", "messageId", "getOmniExtraLog", "getOmniJournalPath", "isAppIntentActive", "isWifiEnabled", "jumpToSystemOtaPage", "notifyCloseAutoGUISwitch", "notifyLarkSendStausChanged", "localMsgId", "status", "notifyStopAutoAction", "reason", "notifyStopComplexTask", "notifyUserAgreePrivacy", "onLoginStateChange", "login", "pauseMusic", "playMusic", "localMessageId", "entitys", "Lcom/obric/capabilitykit/entity/app/MusicEntity;", "entity", "(Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/MusicEntity;Lcom/obric/capabilitykit/entity/app/MusicEntity;)I", "registerMusicStateListener", "listener", "Lcom/obric/aiagent/assistant/idl/IMusicStateListenerIDL;", "replyAskUser", "question", "replyContent", "ext", "screenShot", "Lcom/obric/aiagent/assistant/idl/IScreenshotCallbackIDL;", "sendSms", "text", "setDebugReferImg", "referImg", "setWifiEnabled", "enabled", "showAlarm", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "showAlbum", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "showAuditoryRecording", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "showCallHistory", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "showContact", "showCountdown", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "showFile", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "showLarkUrl", "url", "showMemory", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "showMessage", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "showMusicPage", "showNote", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "showPhoto", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "index", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;I)V", "showProactiveMemory", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "showProxyCallHistory", "uri", "showRecording", "showSchedule", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "showWeather", "location", "takeScreenshot", "terminateService", "turnOnOffAlarm", "on", "unregisterMusicStateListener", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final class AgentAppIntentIDLStub extends IAgentAppIntentIDL.Stub {
    private final /* synthetic */ IAgentAppIntentIDL $$delegate_0;

    public void callPhone(String r2, ContactEntity r3, String r4, String r5) {
        this.$$delegate_0.callPhone(r2, r3, r4, r5);
    }

    public void callShortLink(String r2) {
        this.$$delegate_0.callShortLink(r2);
    }

    public void clearAllOmniTask(Map r2) {
        this.$$delegate_0.clearAllOmniTask(r2);
    }

    public void deleteEntities(AppEntity[] r2, IEntityDeleteCallbackIDL r3) {
        this.$$delegate_0.deleteEntities(r2, r3);
    }

    public void deleteRecordings(RecordingEntity[] r2, boolean r3, IRecordingDeleteCallbackIDL r4) {
        this.$$delegate_0.deleteRecordings(r2, r3, r4);
    }

    public void drainOmniUploadImagesForFeedback(String r2) {
        this.$$delegate_0.drainOmniUploadImagesForFeedback(r2);
    }

    public void drainOmniUploadImagesForFeedbackWithInfo(String r7, String r8, List<String> r9, String r10, boolean r11) {
        this.$$delegate_0.drainOmniUploadImagesForFeedbackWithInfo(r7, r8, r9, r10, r11);
    }

    public void drainOmniUploadImagesForFeedbackWithType(String r2, String r3, List<String> r4, String r5) {
        this.$$delegate_0.drainOmniUploadImagesForFeedbackWithType(r2, r3, r4, r5);
    }

    public List<AppEntity> getAppEntityList(Map r2) {
        return this.$$delegate_0.getAppEntityList(r2);
    }

    public List<String> getComplexTaskPanelInfoFromPC(int r2) {
        return this.$$delegate_0.getComplexTaskPanelInfoFromPC(r2);
    }

    public IntentDebugReport getIntentExecution(String r2) {
        return this.$$delegate_0.getIntentExecution(r2);
    }

    public Map getOmniExtraLog(String r2) {
        return this.$$delegate_0.getOmniExtraLog(r2);
    }

    public List<String> getOmniJournalPath(String r2) {
        return this.$$delegate_0.getOmniJournalPath(r2);
    }

    public boolean isAppIntentActive() {
        return this.$$delegate_0.isAppIntentActive();
    }

    public boolean isWifiEnabled() {
        return this.$$delegate_0.isWifiEnabled();
    }

    public void jumpToSystemOtaPage() {
        this.$$delegate_0.jumpToSystemOtaPage();
    }

    public void notifyCloseAutoGUISwitch() {
        this.$$delegate_0.notifyCloseAutoGUISwitch();
    }

    public void notifyLarkSendStausChanged(String r2, int r3) {
        this.$$delegate_0.notifyLarkSendStausChanged(r2, r3);
    }

    public void notifyStopAutoAction(String r2, String r3) {
        this.$$delegate_0.notifyStopAutoAction(r2, r3);
    }

    public void notifyStopComplexTask(String r2) {
        this.$$delegate_0.notifyStopComplexTask(r2);
    }

    public void notifyUserAgreePrivacy() {
        this.$$delegate_0.notifyUserAgreePrivacy();
    }

    public void onLoginStateChange(boolean r2) {
        this.$$delegate_0.onLoginStateChange(r2);
    }

    public int pauseMusic() {
        return this.$$delegate_0.pauseMusic();
    }

    public int playMusic(String r2, MusicEntity[] r3, MusicEntity r4) {
        return this.$$delegate_0.playMusic(r2, r3, r4);
    }

    public void registerMusicStateListener(IMusicStateListenerIDL r2) {
        this.$$delegate_0.registerMusicStateListener(r2);
    }

    public void replyAskUser(String r2, String r3, String r4, Map r5) {
        this.$$delegate_0.replyAskUser(r2, r3, r4, r5);
    }

    public void screenShot(IScreenshotCallbackIDL r2) {
        this.$$delegate_0.screenShot(r2);
    }

    public void sendSms(String r2, ContactEntity r3, String r4, String r5) {
        this.$$delegate_0.sendSms(r2, r3, r4, r5);
    }

    public void setDebugReferImg(String r2) {
        this.$$delegate_0.setDebugReferImg(r2);
    }

    public boolean setWifiEnabled(boolean r2) {
        return this.$$delegate_0.setWifiEnabled(r2);
    }

    public void showAlarm(AlarmEntity r2) {
        this.$$delegate_0.showAlarm(r2);
    }

    public void showAlbum(AlbumEntity r2) {
        this.$$delegate_0.showAlbum(r2);
    }

    public void showAuditoryRecording(AuditoryRecordingEntity r2) {
        this.$$delegate_0.showAuditoryRecording(r2);
    }

    public void showCallHistory(CallHistoryEntity r2) {
        this.$$delegate_0.showCallHistory(r2);
    }

    public void showContact(ContactEntity r2) {
        this.$$delegate_0.showContact(r2);
    }

    public void showCountdown(CountdownEntity r2) {
        this.$$delegate_0.showCountdown(r2);
    }

    public void showFile(FileEntity r2) {
        this.$$delegate_0.showFile(r2);
    }

    public void showLarkUrl(String r2) {
        this.$$delegate_0.showLarkUrl(r2);
    }

    public void showMemory(MemoryEntity r2) {
        this.$$delegate_0.showMemory(r2);
    }

    public void showMessage(MessageEntity r2) {
        this.$$delegate_0.showMessage(r2);
    }

    public void showMusicPage() {
        this.$$delegate_0.showMusicPage();
    }

    public void showNote(NoteEntity r2) {
        this.$$delegate_0.showNote(r2);
    }

    public void showPhoto(PhotoEntity[] r2, int r3) {
        this.$$delegate_0.showPhoto(r2, r3);
    }

    public void showProactiveMemory(ProactiveMemoryEntity r2) {
        this.$$delegate_0.showProactiveMemory(r2);
    }

    public void showProxyCallHistory(String r2) {
        this.$$delegate_0.showProxyCallHistory(r2);
    }

    public void showRecording(RecordingEntity r2) {
        this.$$delegate_0.showRecording(r2);
    }

    public void showSchedule(ScheduleEntity r2) {
        this.$$delegate_0.showSchedule(r2);
    }

    public void showWeather(String r2, String r3) {
        this.$$delegate_0.showWeather(r2, r3);
    }

    public void takeScreenshot(IScreenshotCallbackIDL r2) {
        this.$$delegate_0.takeScreenshot(r2);
    }

    public void terminateService() {
        this.$$delegate_0.terminateService();
    }

    public void turnOnOffAlarm(AlarmEntity r2, boolean r3) {
        this.$$delegate_0.turnOnOffAlarm(r2, r3);
    }

    public void unregisterMusicStateListener(IMusicStateListenerIDL r2) {
        this.$$delegate_0.unregisterMusicStateListener(r2);
    }

    public AgentAppIntentIDLStub() {
        IAgentAppIntentIDL r0 = (IAgentAppIntentIDLSPI) ServiceManager.get().getService(IAgentAppIntentIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IAgentAppIntentIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
