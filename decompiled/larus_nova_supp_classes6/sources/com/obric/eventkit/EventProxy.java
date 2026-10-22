package com.obric.eventkit;

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
import com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener;
import com.obric.eventkit.eventstaskmanager.IAssistantSessionStateListener;
import com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener;
import com.obric.eventkit.eventstaskmanager.IEventTaskChangeListener;
import com.obric.eventkit.eventstaskmanager.IEventTaskScheduleListener;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.eventkit.eventstaskmanager.ITimerTaskChangeListener;
import com.obric.eventkit.eventstaskmanager.PeriodicPolicy;
import com.obric.eventkit.eventstaskmanager.ShortcutTask;
import com.obric.eventkit.eventstaskmanager.StateInfo;
import com.obric.eventkit.eventstaskmanager.TaskKnowledge;
import com.obric.eventkit.eventstaskmanager.TimerTask;
import com.obric.eventkit.eventstaskmanager.TimerTaskRecord;
import com.obric.eventkit.eventstaskmanager.TimerTaskResult;
import com.obric.eventkit.eventstaskmanager.TriggerControlPolicy;
import com.ss.android.common.applog.EventVerify;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 \u0099\u00012\u00020\u0001:\u0002\u0099\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JX\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000bH\u0016J\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000bH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\"\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J(\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000bH\u0016J \u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u00103\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000bH\u0016J\u000f\u00104\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0002\u00105J\u000f\u00106\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0002\u00105J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010;\u001a\u0004\u0018\u0001002\u0006\u00109\u001a\u00020\u000eH\u0016J\u0012\u0010<\u001a\u0004\u0018\u00010\u001c2\u0006\u0010=\u001a\u00020)H\u0016J \u0010>\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J(\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J\u0012\u0010B\u001a\u0004\u0018\u00010\u001f2\u0006\u0010=\u001a\u00020)H\u0016J \u0010C\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000b2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J(\u0010D\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000b2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J(\u0010E\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u00109\u001a\u00020\u000eH\u0016J(\u0010F\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J\u0010\u0010G\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000bH\u0016J\u0017\u0010H\u001a\u0004\u0018\u00010)2\u0006\u00109\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u000bH\u0016J\u0010\u0010L\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000bH\u0016J\u0012\u0010M\u001a\u0004\u0018\u00010#2\u0006\u00109\u001a\u00020\u000eH\u0016J*\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u00109\u001a\u00020\u000eH\u0016J\u0018\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0016J\u0018\u0010T\u001a\u00020%2\u0006\u0010R\u001a\u00020S2\u0006\u0010U\u001a\u00020QH\u0016J\u0010\u0010V\u001a\u00020%2\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020%2\u0006\u0010W\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020%2\u0006\u0010W\u001a\u00020\\H\u0016J\u0010\u0010]\u001a\u00020%2\u0006\u0010W\u001a\u00020^H\u0016J\u0010\u0010_\u001a\u00020%2\u0006\u0010W\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020.H\u0016J\u0010\u0010b\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0016J\r\u0010c\u001a\u00020.H\u0016¢\u0006\u0002\u00105J\u001f\u0010d\u001a\u0004\u0018\u00010\t2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010fH\u0016¢\u0006\u0002\u0010gJ\u0012\u0010h\u001a\u00020.2\b\u0010=\u001a\u0004\u0018\u00010iH\u0016J\u001d\u0010j\u001a\u0004\u0018\u00010\u00182\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000e0fH\u0016¢\u0006\u0002\u0010kJ\u0010\u0010l\u001a\u00020.2\u0006\u0010=\u001a\u00020iH\u0016J\u0010\u0010m\u001a\u00020.2\u0006\u00109\u001a\u00020\u000eH\u0016J\u0010\u0010n\u001a\u00020.2\u0006\u0010=\u001a\u00020iH\u0016J\u0010\u0010o\u001a\u00020.2\u0006\u00109\u001a\u00020\u000eH\u0016J\u0018\u0010p\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010=\u001a\u00020iH\u0016J\u001e\u0010q\u001a\u0004\u0018\u00010!2\u0012\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020s0\u0016H\u0016J\u001b\u0010t\u001a\u00020.2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020.0\u000bH\u0016¢\u0006\u0002\u0010uJ\u0018\u0010v\u001a\u0004\u0018\u00010!2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0016J.\u0010w\u001a\u00020%2\u0006\u0010x\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0016J\u001a\u0010z\u001a\u00020%2\u0006\u00109\u001a\u00020\u000e2\b\u0010{\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010|\u001a\u00020%2\u0006\u0010W\u001a\u00020}H\u0016J\u0010\u0010~\u001a\u00020%2\u0006\u00109\u001a\u00020\u000eH\u0016J!\u0010\u007f\u001a\u0004\u0018\u00010!2\u0006\u00109\u001a\u00020\u000e2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020)0\u000bH\u0016J\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010Q2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016¢\u0006\u0003\u0010\u0084\u0001J\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010Q2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016¢\u0006\u0003\u0010\u0084\u0001J\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010Q2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016¢\u0006\u0003\u0010\u0084\u0001J@\u0010\u0087\u0001\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020.2\b\u0010{\u001a\u0004\u0018\u00010\u000eH\u0016J\u0011\u0010\u008b\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020XH\u0016J\u0011\u0010\u008c\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020ZH\u0016J\u0011\u0010\u008d\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020\\H\u0016J\u0011\u0010\u008e\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020^H\u0016J\u0011\u0010\u008f\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020`H\u0016Jl\u0010\u0090\u0001\u001a\u0004\u0018\u00010\t2\b\u00109\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0091\u0001\u001a\u00020.2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0016J\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001c2\u0007\u0010\u0094\u0001\u001a\u00020\u001cH\u0016J\u0017\u0010\u0095\u0001\u001a\u00020.2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000bH\u0016J\u0014\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001f2\u0007\u0010\u0094\u0001\u001a\u00020\u001fH\u0016J\u0017\u0010\u0097\u0001\u001a\u00020.2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000bH\u0016J\u0013\u0010\u0098\u0001\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009a\u0001"}, d2 = {"Lcom/obric/eventkit/EventProxy;", "Lcom/obric/eventkit/IEventProxy;", "api", "Lcom/obric/eventkit/eventstaskmanager/ITaskManager;", "(Lcom/obric/eventkit/eventstaskmanager/ITaskManager;)V", "getApi", "()Lcom/obric/eventkit/eventstaskmanager/ITaskManager;", "mApi", "addConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "actions", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", "name", "", "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "ext", "", "addEventTask", "Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "spec", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "addEventTaskExecutionDetailRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;", "records", "addEventTaskExecutionRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;", "addTimerTask", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskResult;", "task", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "closeAssistantInputPanel", "", "getAllConditionTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskRecord;", "startTime", "", "endTime", "getAllEventTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "type", "", "getAllEventTasks", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "getAllTimerTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "getAllTimerTasks", "getAssistantSessionState", "()Ljava/lang/Integer;", "getAssistantTtsPlayingState", "getConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "taskId", "getConditionTaskRecordsByTaskId", "getEventTask", "getEventTaskExecutionDetailRecordById", "id", "getEventTaskExecutionDetailRecords", "offset", "size", "getEventTaskExecutionDetailRecordsByTaskId", "getEventTaskExecutionRecordById", "getEventTaskExecutionRecords", "getEventTaskExecutionRecordsByTaskId", "getEventTaskRecordsByTaskId", "getEventTasksByType", "getKnowledgeSessionIdNotNullEventTasks", "getNextScheduleTimeStamp", "(Ljava/lang/String;)Ljava/lang/Long;", "getShortInstructNotNullShortcutTasks", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "getTemplateIdNotNullEventTasks", "getTimerTaskByTaskId", "getTimerTaskRecordsByTaskId", "notifyAssistantState", "enter", "", "stateInfo", "Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "openAssistantInputPanel", "force", "registerAssistantSessionState", "listener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantSessionStateListener;", "registerAssistantTtsPlayingState", "Lcom/obric/eventkit/eventstaskmanager/IAssistantTtsStateListener;", "registerEventTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskChangeListener;", "registerEventTaskScheduleListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskScheduleListener;", "registerTimerTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/ITimerTaskChangeListener;", "removeAllConditionTaskRecords", "removeAllEventTaskRecords", "removeAllTimeTaskRecords", "removeConditionTask", "taskIds", "", "([Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "removeConditionTaskRecordsById", "", "removeEventTask", "([Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "removeEventTaskExecutionDetailRecordsById", "removeEventTaskExecutionDetailRecordsByTaskId", "removeEventTaskExecutionRecordsById", "removeEventTaskExecutionRecordsByTaskId", "removeEventTaskRecordsById", "removeTimerTask", "parameters", "", "removeTimerTaskRecordsById", "(Ljava/util/List;)Ljava/lang/Integer;", "removeTimerTasksByTaskId", "requestSendMessage", "content", "scene", "scheduleShortcutTask", "source", "setAssistantInteractionListener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantInteractionListener;", "skipConditionTaskSchedule", "skipTimerTasksByTaskId", "timeStamp", "tryActiveAgent", EventVerify.TYPE_EVENT_V1, "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "(Lcom/obric/eventkit/eventstaskmanager/AppEvent;)Ljava/lang/Boolean;", "tryInterruptAssistant", "tryOpenMicToRecording", "tryScheduleConditionTask", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskMode", "unRegisterAssistantSessionState", "unRegisterAssistantTtsPlayingState", "unregisterEventTaskChangeListener", "unregisterEventTaskScheduleListener", "unregisterTimerTaskChangeListener", "updateConditionTask", "enableStatus", "updateEventTask", "updateEventTaskExecutionDetailRecord", "record", "updateEventTaskExecutionDetailRecords", "updateEventTaskExecutionRecord", "updateEventTaskExecutionRecords", "updateTimerTask", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EventProxy implements IEventProxy {
    public static final a Companion = null;
    private static final String TAG = "EventProxy";
    private final ITaskManager api;
    private final ITaskManager mApi;

    public static final class a {
        public a() {
        }
    }

    public EventProxy(ITaskManager r6) {
        Intrinsics.checkNotNullParameter(r6, "api");
        this.api = r6;
        BinderExceptionHandlerProxy.Companion r0 = BinderExceptionHandlerProxy.Companion;
        Object r1 = Proxy.newProxyInstance(ITaskManager.class.getClassLoader(), new Class[]{ITaskManager.class}, new BinderExceptionHandlerProxy(r6, TAG, ITaskManager.class));     // Catch: Throwable -> L8
        if (r1 == null) goto L7;
        r6 = (ITaskManager) r1;     // Catch: Throwable -> L8
    L12:
        this.mApi = r6;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) == null) goto L12;
        r6.getClass().toString();
        goto L12
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult addConditionTask(List<ConditionTaskAction> r8, String r9, ConditionGroup r10, PeriodicPolicy r11, TriggerControlPolicy r12, Map<String, String> r13) {
        return this.mApi.addConditionTask(r8, r9, r10, r11, r12, r13);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult addEventTask(EventTaskSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        return this.mApi.addEventTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r2) {
        Intrinsics.checkNotNullParameter(r2, "records");
        return this.mApi.addEventTaskExecutionDetailRecords(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r2) {
        Intrinsics.checkNotNullParameter(r2, "records");
        return this.mApi.addEventTaskExecutionRecords(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult addTimerTask(TimerTask r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        return this.mApi.addTimerTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void closeAssistantInputPanel() {
        this.mApi.closeAssistantInputPanel();
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getAllConditionTaskRecords(long r2, long r4) {
        return this.mApi.getAllConditionTaskRecords(r2, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getAllEventTaskRecords(long r7, long r9, int r11) {
        return this.mApi.getAllEventTaskRecords(r7, r9, r11);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getAllEventTasks() {
        return this.mApi.getAllEventTasks();
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getAllTimerTaskRecords(long r2, long r4) {
        return this.mApi.getAllTimerTaskRecords(r2, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTask> getAllTimerTasks() {
        return this.mApi.getAllTimerTasks();
    }

    public final ITaskManager getApi() {
        return this.api;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantSessionState() {
        return Integer.valueOf(this.mApi.getAssistantSessionState());
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantTtsPlayingState() {
        return Integer.valueOf(this.mApi.getAssistantTtsPlayingState());
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTask getConditionTask(String r2) {
        return this.mApi.getConditionTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r7, long r9, String r11) {
        return this.mApi.getConditionTaskRecordsByTaskId(r7, r9, r11);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTask getEventTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.getEventTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r2) {
        return this.mApi.getEventTaskExecutionDetailRecordById(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r2, int r3) {
        return this.mApi.getEventTaskExecutionDetailRecords(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsByTaskId(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.getEventTaskExecutionDetailRecordsBySessionId(r2, r3, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord getEventTaskExecutionRecordById(long r2) {
        return this.mApi.getEventTaskExecutionRecordById(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r2, int r3) {
        return this.mApi.getEventTaskExecutionRecords(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.getEventTaskExecutionRecordsByTaskId(r2, r3, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getEventTaskRecordsByTaskId(long r8, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r12, "taskId");
        return this.mApi.getEventTaskRecordsByTaskId(r8, r10, r12);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getEventTasksByType(int r2, int r3, int r4) {
        return this.mApi.getEventTasksByType(r2, r3, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getKnowledgeSessionIdNotNullEventTasks() {
        return this.mApi.getKnowledgeSessionIdNotNullEventTasks();
    }

    @Override // com.obric.eventkit.IEventProxy
    public Long getNextScheduleTimeStamp(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        ITaskManager r0 = this.mApi;
        Integer r4 = StringsKt.toIntOrNull(r3);
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L7:
        return Long.valueOf(r0.getNextScheduleTimeStamp(r5));
    L5:
        r5 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ShortcutTask> getShortInstructNotNullShortcutTasks() {
        return this.mApi.getShortInstructNotNullShortcutTasks();
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getTemplateIdNotNullEventTasks() {
        return this.mApi.getTemplateIdNotNullEventTasks();
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTask getTimerTaskByTaskId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        ITaskManager r0 = this.mApi;
        Integer r3 = StringsKt.toIntOrNull(r2);
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        return r0.getTimerTaskByTaskId(r4);
    L5:
        r4 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r8, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r12, "taskId");
        ITaskManager r1 = this.mApi;
        Integer r13 = StringsKt.toIntOrNull(r12);
        if (r13 == null) goto L5;
        int r6 = r13.intValue();
    L7:
        return r1.getTimerTaskRecordsByTaskId(r8, r10, r6);
    L5:
        r6 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public void notifyAssistantState(boolean r2, StateInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "stateInfo");
        this.mApi.notifyAssistantState(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void openAssistantInputPanel(StateInfo r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "stateInfo");
        this.mApi.openAssistantInputPanel(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantSessionState(IAssistantSessionStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.registerAssistantSessionState(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantTtsPlayingState(IAssistantTtsStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.registerAssistantTtsPlayingState(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskChangeListener(IEventTaskChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.registerEventTaskChangeListener(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskScheduleListener(IEventTaskScheduleListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.registerEventTaskScheduleListener(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerTimerTaskChangeListener(ITimerTaskChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.registerTimerTaskChangeListener(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllConditionTaskRecords() {
        return this.mApi.removeAllTimeTaskRecords();
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllEventTaskRecords(int r2) {
        return this.mApi.removeAllEventTaskRecords(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeAllTimeTaskRecords() {
        return Integer.valueOf(this.mApi.removeAllTimeTaskRecords());
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult removeConditionTask(String[] r2) {
        return this.mApi.removeConditionTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeConditionTaskRecordsById(long[] r2) {
        return this.mApi.removeConditionTaskRecordsById(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult removeEventTask(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "taskIds");
        return this.mApi.removeEventTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsById(long[] r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return this.mApi.removeEventTaskExecutionDetailRecordsById(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsByTaskId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.removeEventTaskExecutionDetailRecordsBySessionId(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsById(long[] r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return this.mApi.removeEventTaskExecutionRecordsById(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsByTaskId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.removeEventTaskExecutionRecordsByTaskId(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskRecordsById(int r2, long[] r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        return this.mApi.removeEventTaskRecordsById(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTask(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "parameters");
        return this.mApi.removeTimerTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeTimerTaskRecordsById(List<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return Integer.valueOf(this.mApi.removeTimerTaskRecordsById(CollectionsKt.toIntArray(r2)));
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTasksByTaskId(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        ITaskManager r0 = this.mApi;
        ArrayList r1 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Integer r2 = StringsKt.toIntOrNull((String) r5.next());
        if (r2 == null) goto L4;
        r1.add(r2);
        goto L4
    L9:
        return r0.removeTimerTasksByTaskId(CollectionsKt.toIntArray(r1));
    }

    @Override // com.obric.eventkit.IEventProxy
    public void requestSendMessage(String r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.mApi.requestSendMessage(r2, r3, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void scheduleShortcutTask(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.mApi.scheduleShortcutTask(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void setAssistantInteractionListener(IAssistantInteractionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.setAssistantInteractionListener(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void skipConditionTaskSchedule(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.mApi.skipConditionTaskSchedule(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult skipTimerTasksByTaskId(String r2, List<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "timeStamp");
        ITaskManager r0 = this.mApi;
        Integer r4 = StringsKt.toIntOrNull(r2);
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L7:
        return r0.skipTimerTasksByTaskId(r5, CollectionsKt.toLongArray(r3));
    L5:
        r5 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryActiveAgent(AppEvent r2) {
        Intrinsics.checkNotNullParameter(r2, EventVerify.TYPE_EVENT_V1);
        return Boolean.valueOf(this.mApi.tryActiveAgent(r2));
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryInterruptAssistant(AppEvent r2) {
        Intrinsics.checkNotNullParameter(r2, EventVerify.TYPE_EVENT_V1);
        return Boolean.valueOf(this.mApi.tryInterruptAssistant(r2));
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryOpenMicToRecording(AppEvent r2) {
        Intrinsics.checkNotNullParameter(r2, EventVerify.TYPE_EVENT_V1);
        return Boolean.valueOf(this.mApi.tryOpenMicToRecording(r2));
    }

    @Override // com.obric.eventkit.IEventProxy
    public void tryScheduleConditionTask(String r8, List<ConditionTaskAction> r9, TaskKnowledge r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "actions");
        this.mApi.tryScheduleConditionTask(r8, r9, r10, r11, r12);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantSessionState(IAssistantSessionStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.unRegisterAssistantSessionState(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.unRegisterAssistantTtsPlayingState(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskChangeListener(IEventTaskChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.unregisterEventTaskChangeListener(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.unregisterEventTaskScheduleListener(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mApi.unregisterTimerTaskChangeListener(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult updateConditionTask(String r11, List<ConditionTaskAction> r12, String r13, ConditionGroup r14, PeriodicPolicy r15, TriggerControlPolicy r16, int r17, Map<String, String> r18) {
        return this.mApi.updateConditionTask(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult updateEventTask(String r2, EventTaskSpec r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "spec");
        return this.mApi.updateEventTask(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return this.mApi.updateEventTaskExecutionDetailRecord(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r2) {
        Intrinsics.checkNotNullParameter(r2, "records");
        return this.mApi.updateEventTaskExecutionDetailRecords(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return this.mApi.updateEventTaskExecutionRecord(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r2) {
        Intrinsics.checkNotNullParameter(r2, "records");
        return this.mApi.updateEventTaskExecutionRecords(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult updateTimerTask(TimerTask r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        return this.mApi.updateTimerTask(r2);
    }

    static {
        Companion = new a();
    }
}
