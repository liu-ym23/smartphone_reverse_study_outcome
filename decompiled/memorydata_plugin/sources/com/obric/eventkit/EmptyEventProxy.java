package com.obric.eventkit;

import android.util.Log;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JX\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\bH\u0016J\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\"\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J(\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\bH\u0016J \u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\bH\u0016J\u000f\u00100\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0002\u00101J\u000f\u00102\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0002\u00101J\u0014\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0004H\u0016J,\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\b\u00105\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00107\u001a\u0004\u0018\u00010,2\u0006\u00105\u001a\u00020\u0004H\u0016J\u0012\u00108\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020%H\u0016J \u0010:\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\b2\u0006\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020*H\u0016J(\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\b2\u0006\u00105\u001a\u00020\u00042\u0006\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020*H\u0016J\u0012\u0010>\u001a\u0004\u0018\u00010\u001b2\u0006\u00109\u001a\u00020%H\u0016J \u0010?\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\b2\u0006\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020*H\u0016J(\u0010@\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\b2\u0006\u00105\u001a\u00020\u00042\u0006\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020*H\u0016J(\u0010A\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u00105\u001a\u00020\u0004H\u0016J(\u0010B\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020*H\u0016J\u0010\u0010C\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\bH\u0016J\u0017\u0010D\u001a\u0004\u0018\u00010%2\u0006\u00105\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010EJ\u0010\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\bH\u0016J\u0010\u0010H\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\bH\u0016J\u0012\u0010I\u001a\u0004\u0018\u00010\u001f2\u0006\u00105\u001a\u00020\u0004H\u0016J*\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u00105\u001a\u00020\u0004H\u0016J\u0018\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0016J\u0018\u0010P\u001a\u00020!2\u0006\u0010N\u001a\u00020O2\u0006\u0010Q\u001a\u00020MH\u0016J\u0010\u0010R\u001a\u00020!2\u0006\u0010S\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u00020!2\u0006\u0010S\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020!2\u0006\u0010S\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020!2\u0006\u0010S\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020!2\u0006\u0010S\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020*H\u0016J\u0010\u0010^\u001a\u00020*2\u0006\u0010)\u001a\u00020*H\u0016J\u000f\u0010_\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0002\u00101J\u001f\u0010`\u001a\u0004\u0018\u00010\u00062\u000e\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010bH\u0016¢\u0006\u0002\u0010cJ\u0012\u0010d\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010eH\u0016J\u001d\u0010f\u001a\u0004\u0018\u00010\u00142\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00040bH\u0016¢\u0006\u0002\u0010gJ\u0010\u0010h\u001a\u00020*2\u0006\u00109\u001a\u00020eH\u0016J\u0010\u0010i\u001a\u00020*2\u0006\u00105\u001a\u00020\u0004H\u0016J\u0010\u0010j\u001a\u00020*2\u0006\u00109\u001a\u00020eH\u0016J\u0010\u0010k\u001a\u00020*2\u0006\u00105\u001a\u00020\u0004H\u0016J\u0018\u0010l\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u0006\u00109\u001a\u00020eH\u0016J\u001e\u0010m\u001a\u0004\u0018\u00010\u001d2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020o0\u0012H\u0016J\u001d\u0010p\u001a\u0004\u0018\u00010*2\f\u00109\u001a\b\u0012\u0004\u0012\u00020*0\bH\u0016¢\u0006\u0002\u0010qJ\u0018\u0010r\u001a\u0004\u0018\u00010\u001d2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J.\u0010s\u001a\u00020!2\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010v\u001a\u00020!2\u0006\u00105\u001a\u00020\u00042\b\u0010w\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010x\u001a\u00020!2\u0006\u0010S\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020!2\u0006\u00105\u001a\u00020\u0004H\u0016J \u0010{\u001a\u0004\u0018\u00010\u001d2\u0006\u00105\u001a\u00020\u00042\f\u0010|\u001a\b\u0012\u0004\u0012\u00020%0\bH\u0016J\u0018\u0010}\u001a\u0004\u0018\u00010M2\u0006\u0010~\u001a\u00020\u007fH\u0016¢\u0006\u0003\u0010\u0080\u0001J\u0019\u0010\u0081\u0001\u001a\u0004\u0018\u00010M2\u0006\u0010~\u001a\u00020\u007fH\u0016¢\u0006\u0003\u0010\u0080\u0001J\u0019\u0010\u0082\u0001\u001a\u0004\u0018\u00010M2\u0006\u0010~\u001a\u00020\u007fH\u0016¢\u0006\u0003\u0010\u0080\u0001J@\u0010\u0083\u0001\u001a\u00020!2\b\u00105\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020*2\b\u0010w\u001a\u0004\u0018\u00010\u0004H\u0016J\u0011\u0010\u0087\u0001\u001a\u00020!2\u0006\u0010S\u001a\u00020TH\u0016J\u0011\u0010\u0088\u0001\u001a\u00020!2\u0006\u0010S\u001a\u00020VH\u0016J\u0011\u0010\u0089\u0001\u001a\u00020!2\u0006\u0010S\u001a\u00020XH\u0016J\u0011\u0010\u008a\u0001\u001a\u00020!2\u0006\u0010S\u001a\u00020ZH\u0016J\u0011\u0010\u008b\u0001\u001a\u00020!2\u0006\u0010S\u001a\u00020\\H\u0016Jl\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00062\b\u00105\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0007\u0010\u008d\u0001\u001a\u00020*2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0016J\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00142\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u0090\u0001\u001a\u00020\u0018H\u0016J\u0017\u0010\u0091\u0001\u001a\u00020*2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\bH\u0016J\u0014\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010\u0090\u0001\u001a\u00020\u001bH\u0016J\u0017\u0010\u0093\u0001\u001a\u00020*2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\bH\u0016J\u0013\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0095\u0001"}, d2 = {"Lcom/obric/eventkit/EmptyEventProxy;", "Lcom/obric/eventkit/IEventProxy;", "()V", "TAG", "", "addConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "actions", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", ActivityLifecycle.NAME, "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "ext", "", "addEventTask", "Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "spec", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "addEventTaskExecutionDetailRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;", "records", "addEventTaskExecutionRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;", "addTimerTask", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskResult;", "task", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "closeAssistantInputPanel", "", "getAllConditionTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskRecord;", "startTime", "", "endTime", "getAllEventTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "type", "", "getAllEventTasks", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "getAllTimerTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "getAllTimerTasks", "getAssistantSessionState", "()Ljava/lang/Integer;", "getAssistantTtsPlayingState", "getConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "taskId", "getConditionTaskRecordsByTaskId", "getEventTask", "getEventTaskExecutionDetailRecordById", OaidModel.KEY_ID, "getEventTaskExecutionDetailRecords", TypedValues.CycleType.S_WAVE_OFFSET, "size", "getEventTaskExecutionDetailRecordsByTaskId", "getEventTaskExecutionRecordById", "getEventTaskExecutionRecords", "getEventTaskExecutionRecordsByTaskId", "getEventTaskRecordsByTaskId", "getEventTasksByType", "getKnowledgeSessionIdNotNullEventTasks", "getNextScheduleTimeStamp", "(Ljava/lang/String;)Ljava/lang/Long;", "getShortInstructNotNullShortcutTasks", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "getTemplateIdNotNullEventTasks", "getTimerTaskByTaskId", "getTimerTaskRecordsByTaskId", "notifyAssistantState", "enter", "", "stateInfo", "Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "openAssistantInputPanel", "force", "registerAssistantSessionState", "listener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantSessionStateListener;", "registerAssistantTtsPlayingState", "Lcom/obric/eventkit/eventstaskmanager/IAssistantTtsStateListener;", "registerEventTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskChangeListener;", "registerEventTaskScheduleListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskScheduleListener;", "registerTimerTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/ITimerTaskChangeListener;", "removeAllConditionTaskRecords", "removeAllEventTaskRecords", "removeAllTimeTaskRecords", "removeConditionTask", "taskIds", "", "([Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "removeConditionTaskRecordsById", "", "removeEventTask", "([Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "removeEventTaskExecutionDetailRecordsById", "removeEventTaskExecutionDetailRecordsByTaskId", "removeEventTaskExecutionRecordsById", "removeEventTaskExecutionRecordsByTaskId", "removeEventTaskRecordsById", "removeTimerTask", "parameters", "", "removeTimerTaskRecordsById", "(Ljava/util/List;)Ljava/lang/Integer;", "removeTimerTasksByTaskId", "requestSendMessage", Params.CONTENT, MemoryInfoSectionEditActivity.KIND_SCENE, "scheduleShortcutTask", AILabCheckPermissionTask.KEY_SOURCE, "setAssistantInteractionListener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantInteractionListener;", "skipConditionTaskSchedule", "skipTimerTasksByTaskId", "timeStamp", "tryActiveAgent", "event", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "(Lcom/obric/eventkit/eventstaskmanager/AppEvent;)Ljava/lang/Boolean;", "tryInterruptAssistant", "tryOpenMicToRecording", "tryScheduleConditionTask", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskMode", "unRegisterAssistantSessionState", "unRegisterAssistantTtsPlayingState", "unregisterEventTaskChangeListener", "unregisterEventTaskScheduleListener", "unregisterTimerTaskChangeListener", "updateConditionTask", "enableStatus", "updateEventTask", "updateEventTaskExecutionDetailRecord", "record", "updateEventTaskExecutionDetailRecords", "updateEventTaskExecutionRecord", "updateEventTaskExecutionRecords", "updateTimerTask", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmptyEventProxy implements IEventProxy {
    public static final EmptyEventProxy INSTANCE = null;
    private static final String TAG = "EmptyEventProxy";

    static {
        INSTANCE = new EmptyEventProxy();
    }

    private EmptyEventProxy() {
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult addConditionTask(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map<String, String> r6) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Log.e(TAG, "addConditionTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult addEventTask(EventTaskSpec r1) {
        Intrinsics.checkNotNullParameter(r1, "spec");
        Log.e(TAG, "addEventTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "records");
        Log.e(TAG, "addEventTaskExecutionDetailRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "records");
        Log.e(TAG, "addEventTaskExecutionRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult addTimerTask(TimerTask r1) {
        Intrinsics.checkNotNullParameter(r1, "task");
        Log.e(TAG, "addTimerTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public void closeAssistantInputPanel() {
        Log.e(TAG, "closeAssistantInputPanel no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getAllConditionTaskRecords(long r1, long r3) {
        Log.e(TAG, "getAllConditionTaskRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getAllEventTaskRecords(long r1, long r3, int r5) {
        Log.e(TAG, "getAllEventTaskRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getAllEventTasks() {
        Log.e(TAG, "getAllEventTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getAllTimerTaskRecords(long r1, long r3) {
        Log.e(TAG, "getAllTimerTaskRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTask> getAllTimerTasks() {
        Log.e(TAG, "getAllTimerTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantSessionState() {
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantTtsPlayingState() {
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTask getConditionTask(String r1) {
        Log.e(TAG, "getConditionTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r1, long r3, String r5) {
        Log.e(TAG, "getConditionTaskRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTask getEventTask(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Log.e(TAG, "getEventTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1) {
        Log.e(TAG, "getEventTaskExecutionDetailRecordById no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2) {
        Log.e(TAG, "getEventTaskExecutionDetailRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsByTaskId(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Log.e(TAG, "getEventTaskExecutionDetailRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1) {
        Log.e(TAG, "getEventTaskExecutionRecordById no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2) {
        Log.e(TAG, "getEventTaskExecutionRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Log.e(TAG, "getEventTaskExecutionRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getEventTaskRecordsByTaskId(long r1, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Log.e(TAG, "getEventTaskRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getEventTasksByType(int r1, int r2, int r3) {
        Log.e(TAG, "getEventTasksByType no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getKnowledgeSessionIdNotNullEventTasks() {
        Log.e(TAG, "getKnowledgeSessionIdNotNullEventTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Long getNextScheduleTimeStamp(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Log.e(TAG, "getNextScheduleTimeStamp no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ShortcutTask> getShortInstructNotNullShortcutTasks() {
        Log.e(TAG, "getShortInstructNotNullShortcutTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getTemplateIdNotNullEventTasks() {
        Log.e(TAG, "getTemplateIdNotNullEventTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTask getTimerTaskByTaskId(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Log.e(TAG, "getTimerTaskByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r1, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Log.e(TAG, "getTimerTaskRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public void notifyAssistantState(boolean r1, StateInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "stateInfo");
        Log.e(TAG, "notifyAssistantState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void openAssistantInputPanel(StateInfo r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "stateInfo");
        Log.e(TAG, "openAssistantInputPanel no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantSessionState(c r2) {
        Intrinsics.checkNotNullParameter((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "registerAssistantSessionState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantTtsPlayingState(d r2) {
        Intrinsics.checkNotNullParameter((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "registerAssistantTtsPlayingState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskChangeListener(f r2) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "registerEventTaskChangeListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskScheduleListener(g r2) {
        Intrinsics.checkNotNullParameter((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "registerEventTaskScheduleListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerTimerTaskChangeListener(i r2) {
        Intrinsics.checkNotNullParameter((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "registerTimerTaskChangeListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllConditionTaskRecords() {
        Log.e(TAG, "removeAllConditionTaskRecords no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllEventTaskRecords(int r1) {
        Log.e(TAG, "removeAllEventTaskRecords no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeAllTimeTaskRecords() {
        Log.e(TAG, "removeAllTimeTaskRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult removeConditionTask(String[] r1) {
        Log.e(TAG, "removeConditionTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeConditionTaskRecordsById(long[] r1) {
        Log.e(TAG, "removeConditionTaskRecordsById no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult removeEventTask(String[] r1) {
        Intrinsics.checkNotNullParameter(r1, "taskIds");
        Log.e(TAG, "removeEventTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsById(long[] r1) {
        Intrinsics.checkNotNullParameter(r1, OaidModel.KEY_ID);
        Log.e(TAG, "removeEventTaskExecutionDetailRecordsById no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsByTaskId(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Log.e(TAG, "removeEventTaskExecutionDetailRecordsByTaskId no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsById(long[] r1) {
        Intrinsics.checkNotNullParameter(r1, OaidModel.KEY_ID);
        Log.e(TAG, "removeEventTaskExecutionRecordsById no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsByTaskId(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Log.e(TAG, "removeEventTaskExecutionRecordsByTaskId no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskRecordsById(int r1, long[] r2) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Log.e(TAG, "removeEventTaskRecordsById no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTask(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), "parameters");
        Log.e(TAG, "removeTimerTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeTimerTaskRecordsById(List<Integer> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), OaidModel.KEY_ID);
        Log.e(TAG, "removeTimerTaskRecordsById no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTasksByTaskId(List<String> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "taskId");
        Log.e(TAG, "removeTimerTasksByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public void requestSendMessage(String r2, String r3, Map<String, String> r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r3, MemoryInfoSectionEditActivity.KIND_SCENE);
        Log.e(TAG, "requestSendMessage no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void scheduleShortcutTask(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Log.e(TAG, "scheduleShortcutTask no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void setAssistantInteractionListener(b r2) {
        Intrinsics.checkNotNullParameter((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "setAssistantInteractionListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void skipConditionTaskSchedule(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Log.e(TAG, "scheduleShortcutTask no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult skipTimerTasksByTaskId(String r2, List<Long> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r1, "timeStamp");
        Log.e(TAG, "skipTimerTasksByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryActiveAgent(AppEvent r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryInterruptAssistant(AppEvent r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryOpenMicToRecording(AppEvent r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public void tryScheduleConditionTask(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "actions");
        Log.e(TAG, "tryScheduleConditionTask no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantSessionState(c r2) {
        Intrinsics.checkNotNullParameter((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "unRegisterAssistantSessionState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantTtsPlayingState(d r2) {
        Intrinsics.checkNotNullParameter((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "unRegisterAssistantTtsPlayingState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskChangeListener(f r2) {
        Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "unregisterEventTaskChangeListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskScheduleListener(g r2) {
        Intrinsics.checkNotNullParameter((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "unregisterEventTaskScheduleListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterTimerTaskChangeListener(i r2) {
        Intrinsics.checkNotNullParameter((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), "listener");
        Log.e(TAG, "unregisterTimerTaskChangeListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map<String, String> r8) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Log.e(TAG, "updateConditionTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult updateEventTask(String r1, EventTaskSpec r2) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r2, "spec");
        Log.e(TAG, "updateEventTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r1) {
        Intrinsics.checkNotNullParameter(r1, "record");
        Log.e(TAG, "updateEventTaskExecutionDetailRecord no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "records");
        Log.e(TAG, "updateEventTaskExecutionDetailRecords no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r1) {
        Intrinsics.checkNotNullParameter(r1, "record");
        Log.e(TAG, "updateEventTaskExecutionRecord no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "records");
        Log.e(TAG, "updateEventTaskExecutionRecords no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult updateTimerTask(TimerTask r1) {
        Intrinsics.checkNotNullParameter(r1, "task");
        Log.e(TAG, "updateTimerTask no impl");
        return null;
    }
}
