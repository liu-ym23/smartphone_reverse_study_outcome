package com.obric.eventkit;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.obric.eventkit.eventstaskmanager.ConditionGroup;
import com.obric.eventkit.eventstaskmanager.ConditionTask;
import com.obric.eventkit.eventstaskmanager.ConditionTaskAction;
import com.obric.eventkit.eventstaskmanager.ConditionTaskRecord;
import com.obric.eventkit.eventstaskmanager.ConditionTaskResult;
import com.obric.eventkit.eventstaskmanager.EventTask;
import com.obric.eventkit.eventstaskmanager.EventTaskExecutionDetailRecord;
import com.obric.eventkit.eventstaskmanager.EventTaskExecutionRecord;
import com.obric.eventkit.eventstaskmanager.EventTaskRecord;
import com.obric.eventkit.eventstaskmanager.EventTaskResult;
import com.obric.eventkit.eventstaskmanager.EventTaskSpec;
import com.obric.eventkit.eventstaskmanager.PeriodicPolicy;
import com.obric.eventkit.eventstaskmanager.ShortcutTask;
import com.obric.eventkit.eventstaskmanager.StateInfo;
import com.obric.eventkit.eventstaskmanager.TaskKnowledge;
import com.obric.eventkit.eventstaskmanager.TimerTask;
import com.obric.eventkit.eventstaskmanager.TimerTaskRecord;
import com.obric.eventkit.eventstaskmanager.TimerTaskResult;
import com.obric.eventkit.eventstaskmanager.TriggerControlPolicy;
import com.obric.eventkit.eventstaskmanager.b;
import com.obric.eventkit.eventstaskmanager.c;
import com.obric.eventkit.eventstaskmanager.d;
import com.obric.eventkit.eventstaskmanager.f;
import com.obric.eventkit.eventstaskmanager.g;
import com.obric.eventkit.eventstaskmanager.i;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\ba\u0018\u00002\u00020\u0001JX\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005H&J\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH&J\"\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H&J(\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010'\u001a\u00020(H&J\u0010\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0005H&J \u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H&J\u0010\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0005H&J\u000f\u0010.\u001a\u0004\u0018\u00010(H&¢\u0006\u0002\u0010/J\u000f\u00100\u001a\u0004\u0018\u00010(H&¢\u0006\u0002\u0010/J\u0014\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\bH&J,\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u00010\bH&J\u0012\u00105\u001a\u0004\u0018\u00010*2\u0006\u00103\u001a\u00020\bH&J\u0012\u00106\u001a\u0004\u0018\u00010\u00162\u0006\u00107\u001a\u00020#H&J \u00108\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052\u0006\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020(H&J(\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052\u0006\u00103\u001a\u00020\b2\u0006\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020(H&J\u0012\u0010<\u001a\u0004\u0018\u00010\u00192\u0006\u00107\u001a\u00020#H&J \u0010=\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00052\u0006\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020(H&J(\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00052\u0006\u00103\u001a\u00020\b2\u0006\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020(H&J(\u0010?\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u00103\u001a\u00020\bH&J(\u0010@\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u00052\u0006\u0010'\u001a\u00020(2\u0006\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020(H&J\u0010\u0010A\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0005H&J\u0017\u0010B\u001a\u0004\u0018\u00010#2\u0006\u00103\u001a\u00020\bH&¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u0005H&J\u0010\u0010F\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0005H&J\u0012\u0010G\u001a\u0004\u0018\u00010\u001d2\u0006\u00103\u001a\u00020\bH&J*\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u00103\u001a\u00020\bH&J\u0018\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH&J\u0018\u0010N\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020M2\u0006\u0010O\u001a\u00020KH&J\u0010\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020RH&J\u0010\u0010S\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020TH&J\u0010\u0010U\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020VH&J\u0010\u0010W\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020XH&J\u0010\u0010Y\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020ZH&J\b\u0010[\u001a\u00020(H&J\u0010\u0010\\\u001a\u00020(2\u0006\u0010'\u001a\u00020(H&J\u000f\u0010]\u001a\u0004\u0018\u00010(H&¢\u0006\u0002\u0010/J\u001f\u0010^\u001a\u0004\u0018\u00010\u00032\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010`H&¢\u0006\u0002\u0010aJ\u0012\u0010b\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010cH&J\u001d\u0010d\u001a\u0004\u0018\u00010\u00122\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\b0`H&¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020(2\u0006\u00107\u001a\u00020cH&J\u0010\u0010g\u001a\u00020(2\u0006\u00103\u001a\u00020\bH&J\u0010\u0010h\u001a\u00020(2\u0006\u00107\u001a\u00020cH&J\u0010\u0010i\u001a\u00020(2\u0006\u00103\u001a\u00020\bH&J\u0018\u0010j\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020cH&J\u001e\u0010k\u001a\u0004\u0018\u00010\u001b2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0010H&J\u001d\u0010m\u001a\u0004\u0018\u00010(2\f\u00107\u001a\b\u0012\u0004\u0012\u00020(0\u0005H&¢\u0006\u0002\u0010nJ\u0018\u0010o\u001a\u0004\u0018\u00010\u001b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H&J.\u0010p\u001a\u00020\u001f2\u0006\u0010q\u001a\u00020\b2\u0006\u0010r\u001a\u00020\b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H&J\u001c\u0010s\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\b2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\bH&J\u0010\u0010u\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020vH&J\u0010\u0010w\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\bH&J \u0010x\u001a\u0004\u0018\u00010\u001b2\u0006\u00103\u001a\u00020\b2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020#0\u0005H&J\u0017\u0010z\u001a\u0004\u0018\u00010K2\u0006\u0010{\u001a\u00020|H&¢\u0006\u0002\u0010}J\u0017\u0010~\u001a\u0004\u0018\u00010K2\u0006\u0010{\u001a\u00020|H&¢\u0006\u0002\u0010}J\u0017\u0010\u007f\u001a\u0004\u0018\u00010K2\u0006\u0010{\u001a\u00020|H&¢\u0006\u0002\u0010}JB\u0010\u0080\u0001\u001a\u00020\u001f2\b\u00103\u001a\u0004\u0018\u00010\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020(2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\bH&J\u0011\u0010\u0084\u0001\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020RH&J\u0011\u0010\u0085\u0001\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020TH&J\u0011\u0010\u0086\u0001\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020VH&J\u0011\u0010\u0087\u0001\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020XH&J\u0011\u0010\u0088\u0001\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020ZH&Jl\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00032\b\u00103\u001a\u0004\u0018\u00010\b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0007\u0010\u008a\u0001\u001a\u00020(2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H&J\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u00103\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0014\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00162\u0007\u0010\u008d\u0001\u001a\u00020\u0016H&J\u0017\u0010\u008e\u0001\u001a\u00020(2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005H&J\u0014\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010\u008d\u0001\u001a\u00020\u0019H&J\u0017\u0010\u0090\u0001\u001a\u00020(2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005H&J\u0013\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&¨\u0006\u0092\u0001"}, d2 = {"Lcom/obric/eventkit/IEventProxy;", "", "addConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "actions", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", ActivityLifecycle.NAME, "", "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "ext", "", "addEventTask", "Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "spec", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "addEventTaskExecutionDetailRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;", "records", "addEventTaskExecutionRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;", "addTimerTask", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskResult;", "task", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "closeAssistantInputPanel", "", "getAllConditionTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskRecord;", "startTime", "", "endTime", "getAllEventTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "type", "", "getAllEventTasks", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "getAllTimerTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "getAllTimerTasks", "getAssistantSessionState", "()Ljava/lang/Integer;", "getAssistantTtsPlayingState", "getConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "taskId", "getConditionTaskRecordsByTaskId", "getEventTask", "getEventTaskExecutionDetailRecordById", OaidModel.KEY_ID, "getEventTaskExecutionDetailRecords", TypedValues.CycleType.S_WAVE_OFFSET, "size", "getEventTaskExecutionDetailRecordsByTaskId", "getEventTaskExecutionRecordById", "getEventTaskExecutionRecords", "getEventTaskExecutionRecordsByTaskId", "getEventTaskRecordsByTaskId", "getEventTasksByType", "getKnowledgeSessionIdNotNullEventTasks", "getNextScheduleTimeStamp", "(Ljava/lang/String;)Ljava/lang/Long;", "getShortInstructNotNullShortcutTasks", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "getTemplateIdNotNullEventTasks", "getTimerTaskByTaskId", "getTimerTaskRecordsByTaskId", "notifyAssistantState", "enter", "", "stateInfo", "Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "openAssistantInputPanel", "force", "registerAssistantSessionState", "listener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantSessionStateListener;", "registerAssistantTtsPlayingState", "Lcom/obric/eventkit/eventstaskmanager/IAssistantTtsStateListener;", "registerEventTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskChangeListener;", "registerEventTaskScheduleListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskScheduleListener;", "registerTimerTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/ITimerTaskChangeListener;", "removeAllConditionTaskRecords", "removeAllEventTaskRecords", "removeAllTimeTaskRecords", "removeConditionTask", "taskIds", "", "([Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "removeConditionTaskRecordsById", "", "removeEventTask", "([Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "removeEventTaskExecutionDetailRecordsById", "removeEventTaskExecutionDetailRecordsByTaskId", "removeEventTaskExecutionRecordsById", "removeEventTaskExecutionRecordsByTaskId", "removeEventTaskRecordsById", "removeTimerTask", "parameters", "removeTimerTaskRecordsById", "(Ljava/util/List;)Ljava/lang/Integer;", "removeTimerTasksByTaskId", "requestSendMessage", Params.CONTENT, MemoryInfoSectionEditActivity.KIND_SCENE, "scheduleShortcutTask", AILabCheckPermissionTask.KEY_SOURCE, "setAssistantInteractionListener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantInteractionListener;", "skipConditionTaskSchedule", "skipTimerTasksByTaskId", "timeStamp", "tryActiveAgent", "event", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "(Lcom/obric/eventkit/eventstaskmanager/AppEvent;)Ljava/lang/Boolean;", "tryInterruptAssistant", "tryOpenMicToRecording", "tryScheduleConditionTask", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskMode", "unRegisterAssistantSessionState", "unRegisterAssistantTtsPlayingState", "unregisterEventTaskChangeListener", "unregisterEventTaskScheduleListener", "unregisterTimerTaskChangeListener", "updateConditionTask", "enableStatus", "updateEventTask", "updateEventTaskExecutionDetailRecord", "record", "updateEventTaskExecutionDetailRecords", "updateEventTaskExecutionRecord", "updateEventTaskExecutionRecords", "updateTimerTask", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IEventProxy {
    ConditionTaskResult addConditionTask(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map<String, String> r6);

    EventTaskResult addEventTask(EventTaskSpec r1);

    List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1);

    List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r1);

    TimerTaskResult addTimerTask(TimerTask r1);

    void closeAssistantInputPanel();

    List<ConditionTaskRecord> getAllConditionTaskRecords(long r1, long r3);

    List<EventTaskRecord> getAllEventTaskRecords(long r1, long r3, int r5);

    List<EventTask> getAllEventTasks();

    List<TimerTaskRecord> getAllTimerTaskRecords(long r1, long r3);

    List<TimerTask> getAllTimerTasks();

    Integer getAssistantSessionState();

    Integer getAssistantTtsPlayingState();

    ConditionTask getConditionTask(String r1);

    List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r1, long r3, String r5);

    EventTask getEventTask(String r1);

    EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1);

    List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2);

    List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsByTaskId(String r1, int r2, int r3);

    EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1);

    List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2);

    List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r1, int r2, int r3);

    List<EventTaskRecord> getEventTaskRecordsByTaskId(long r1, long r3, String r5);

    List<EventTask> getEventTasksByType(int r1, int r2, int r3);

    List<EventTask> getKnowledgeSessionIdNotNullEventTasks();

    Long getNextScheduleTimeStamp(String r1);

    List<ShortcutTask> getShortInstructNotNullShortcutTasks();

    List<EventTask> getTemplateIdNotNullEventTasks();

    TimerTask getTimerTaskByTaskId(String r1);

    List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r1, long r3, String r5);

    void notifyAssistantState(boolean r1, StateInfo r2);

    void openAssistantInputPanel(StateInfo r1, boolean r2);

    void registerAssistantSessionState(c r1);

    void registerAssistantTtsPlayingState(d r1);

    void registerEventTaskChangeListener(f r1);

    void registerEventTaskScheduleListener(g r1);

    void registerTimerTaskChangeListener(i r1);

    int removeAllConditionTaskRecords();

    int removeAllEventTaskRecords(int r1);

    Integer removeAllTimeTaskRecords();

    ConditionTaskResult removeConditionTask(String[] r1);

    int removeConditionTaskRecordsById(long[] r1);

    EventTaskResult removeEventTask(String[] r1);

    int removeEventTaskExecutionDetailRecordsById(long[] r1);

    int removeEventTaskExecutionDetailRecordsByTaskId(String r1);

    int removeEventTaskExecutionRecordsById(long[] r1);

    int removeEventTaskExecutionRecordsByTaskId(String r1);

    int removeEventTaskRecordsById(int r1, long[] r2);

    TimerTaskResult removeTimerTask(Map<String, ? extends Object> r1);

    Integer removeTimerTaskRecordsById(List<Integer> r1);

    TimerTaskResult removeTimerTasksByTaskId(List<String> r1);

    void requestSendMessage(String r1, String r2, Map<String, String> r3);

    void scheduleShortcutTask(String r1, String r2);

    void setAssistantInteractionListener(b r1);

    void skipConditionTaskSchedule(String r1);

    TimerTaskResult skipTimerTasksByTaskId(String r1, List<Long> r2);

    Boolean tryActiveAgent(AppEvent r1);

    Boolean tryInterruptAssistant(AppEvent r1);

    Boolean tryOpenMicToRecording(AppEvent r1);

    void tryScheduleConditionTask(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5);

    void unRegisterAssistantSessionState(c r1);

    void unRegisterAssistantTtsPlayingState(d r1);

    void unregisterEventTaskChangeListener(f r1);

    void unregisterEventTaskScheduleListener(g r1);

    void unregisterTimerTaskChangeListener(i r1);

    ConditionTaskResult updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map<String, String> r8);

    EventTaskResult updateEventTask(String r1, EventTaskSpec r2);

    EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r1);

    int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1);

    EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r1);

    int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r1);

    TimerTaskResult updateTimerTask(TimerTask r1);
}
