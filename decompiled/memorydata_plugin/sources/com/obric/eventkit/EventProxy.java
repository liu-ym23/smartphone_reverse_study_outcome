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
import com.obric.eventkit.eventstaskmanager.h;
import com.obric.eventkit.eventstaskmanager.i;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 \u0099\u00012\u00020\u0001:\u0002\u0099\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JX\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000bH\u0016J\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000bH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\"\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J(\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000bH\u0016J \u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u00103\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000bH\u0016J\u000f\u00104\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0002\u00105J\u000f\u00106\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0002\u00105J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010;\u001a\u0004\u0018\u0001002\u0006\u00109\u001a\u00020\u000eH\u0016J\u0012\u0010<\u001a\u0004\u0018\u00010\u001c2\u0006\u0010=\u001a\u00020)H\u0016J \u0010>\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J(\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J\u0012\u0010B\u001a\u0004\u0018\u00010\u001f2\u0006\u0010=\u001a\u00020)H\u0016J \u0010C\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000b2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J(\u0010D\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000b2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J(\u0010E\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u00109\u001a\u00020\u000eH\u0016J(\u0010F\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J\u0010\u0010G\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000bH\u0016J\u0017\u0010H\u001a\u0004\u0018\u00010)2\u0006\u00109\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u000bH\u0016J\u0010\u0010L\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000bH\u0016J\u0012\u0010M\u001a\u0004\u0018\u00010#2\u0006\u00109\u001a\u00020\u000eH\u0016J*\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u00109\u001a\u00020\u000eH\u0016J\u0018\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0016J\u0018\u0010T\u001a\u00020%2\u0006\u0010R\u001a\u00020S2\u0006\u0010U\u001a\u00020QH\u0016J\u0010\u0010V\u001a\u00020%2\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020%2\u0006\u0010W\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020%2\u0006\u0010W\u001a\u00020\\H\u0016J\u0010\u0010]\u001a\u00020%2\u0006\u0010W\u001a\u00020^H\u0016J\u0010\u0010_\u001a\u00020%2\u0006\u0010W\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020.H\u0016J\u0010\u0010b\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0016J\r\u0010c\u001a\u00020.H\u0016¢\u0006\u0002\u00105J\u001f\u0010d\u001a\u0004\u0018\u00010\t2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010fH\u0016¢\u0006\u0002\u0010gJ\u0012\u0010h\u001a\u00020.2\b\u0010=\u001a\u0004\u0018\u00010iH\u0016J\u001d\u0010j\u001a\u0004\u0018\u00010\u00182\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000e0fH\u0016¢\u0006\u0002\u0010kJ\u0010\u0010l\u001a\u00020.2\u0006\u0010=\u001a\u00020iH\u0016J\u0010\u0010m\u001a\u00020.2\u0006\u00109\u001a\u00020\u000eH\u0016J\u0010\u0010n\u001a\u00020.2\u0006\u0010=\u001a\u00020iH\u0016J\u0010\u0010o\u001a\u00020.2\u0006\u00109\u001a\u00020\u000eH\u0016J\u0018\u0010p\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010=\u001a\u00020iH\u0016J\u001e\u0010q\u001a\u0004\u0018\u00010!2\u0012\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020s0\u0016H\u0016J\u001b\u0010t\u001a\u00020.2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020.0\u000bH\u0016¢\u0006\u0002\u0010uJ\u0018\u0010v\u001a\u0004\u0018\u00010!2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0016J.\u0010w\u001a\u00020%2\u0006\u0010x\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0016J\u001a\u0010z\u001a\u00020%2\u0006\u00109\u001a\u00020\u000e2\b\u0010{\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010|\u001a\u00020%2\u0006\u0010W\u001a\u00020}H\u0016J\u0010\u0010~\u001a\u00020%2\u0006\u00109\u001a\u00020\u000eH\u0016J!\u0010\u007f\u001a\u0004\u0018\u00010!2\u0006\u00109\u001a\u00020\u000e2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020)0\u000bH\u0016J\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010Q2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016¢\u0006\u0003\u0010\u0084\u0001J\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010Q2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016¢\u0006\u0003\u0010\u0084\u0001J\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010Q2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016¢\u0006\u0003\u0010\u0084\u0001J@\u0010\u0087\u0001\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020.2\b\u0010{\u001a\u0004\u0018\u00010\u000eH\u0016J\u0011\u0010\u008b\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020XH\u0016J\u0011\u0010\u008c\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020ZH\u0016J\u0011\u0010\u008d\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020\\H\u0016J\u0011\u0010\u008e\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020^H\u0016J\u0011\u0010\u008f\u0001\u001a\u00020%2\u0006\u0010W\u001a\u00020`H\u0016Jl\u0010\u0090\u0001\u001a\u0004\u0018\u00010\t2\b\u00109\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0091\u0001\u001a\u00020.2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0016J\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001c2\u0007\u0010\u0094\u0001\u001a\u00020\u001cH\u0016J\u0017\u0010\u0095\u0001\u001a\u00020.2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000bH\u0016J\u0014\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001f2\u0007\u0010\u0094\u0001\u001a\u00020\u001fH\u0016J\u0017\u0010\u0097\u0001\u001a\u00020.2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000bH\u0016J\u0013\u0010\u0098\u0001\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009a\u0001"}, d2 = {"Lcom/obric/eventkit/EventProxy;", "Lcom/obric/eventkit/IEventProxy;", "api", "Lcom/obric/eventkit/eventstaskmanager/ITaskManager;", "(Lcom/obric/eventkit/eventstaskmanager/ITaskManager;)V", "getApi", "()Lcom/obric/eventkit/eventstaskmanager/ITaskManager;", "mApi", "addConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "actions", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", ActivityLifecycle.NAME, "", "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "ext", "", "addEventTask", "Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "spec", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "addEventTaskExecutionDetailRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;", "records", "addEventTaskExecutionRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;", "addTimerTask", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskResult;", "task", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "closeAssistantInputPanel", "", "getAllConditionTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskRecord;", "startTime", "", "endTime", "getAllEventTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "type", "", "getAllEventTasks", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "getAllTimerTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "getAllTimerTasks", "getAssistantSessionState", "()Ljava/lang/Integer;", "getAssistantTtsPlayingState", "getConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "taskId", "getConditionTaskRecordsByTaskId", "getEventTask", "getEventTaskExecutionDetailRecordById", OaidModel.KEY_ID, "getEventTaskExecutionDetailRecords", TypedValues.CycleType.S_WAVE_OFFSET, "size", "getEventTaskExecutionDetailRecordsByTaskId", "getEventTaskExecutionRecordById", "getEventTaskExecutionRecords", "getEventTaskExecutionRecordsByTaskId", "getEventTaskRecordsByTaskId", "getEventTasksByType", "getKnowledgeSessionIdNotNullEventTasks", "getNextScheduleTimeStamp", "(Ljava/lang/String;)Ljava/lang/Long;", "getShortInstructNotNullShortcutTasks", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "getTemplateIdNotNullEventTasks", "getTimerTaskByTaskId", "getTimerTaskRecordsByTaskId", "notifyAssistantState", "enter", "", "stateInfo", "Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "openAssistantInputPanel", "force", "registerAssistantSessionState", "listener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantSessionStateListener;", "registerAssistantTtsPlayingState", "Lcom/obric/eventkit/eventstaskmanager/IAssistantTtsStateListener;", "registerEventTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskChangeListener;", "registerEventTaskScheduleListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskScheduleListener;", "registerTimerTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/ITimerTaskChangeListener;", "removeAllConditionTaskRecords", "removeAllEventTaskRecords", "removeAllTimeTaskRecords", "removeConditionTask", "taskIds", "", "([Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "removeConditionTaskRecordsById", "", "removeEventTask", "([Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "removeEventTaskExecutionDetailRecordsById", "removeEventTaskExecutionDetailRecordsByTaskId", "removeEventTaskExecutionRecordsById", "removeEventTaskExecutionRecordsByTaskId", "removeEventTaskRecordsById", "removeTimerTask", "parameters", "", "removeTimerTaskRecordsById", "(Ljava/util/List;)Ljava/lang/Integer;", "removeTimerTasksByTaskId", "requestSendMessage", Params.CONTENT, MemoryInfoSectionEditActivity.KIND_SCENE, "scheduleShortcutTask", AILabCheckPermissionTask.KEY_SOURCE, "setAssistantInteractionListener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantInteractionListener;", "skipConditionTaskSchedule", "skipTimerTasksByTaskId", "timeStamp", "tryActiveAgent", "event", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "(Lcom/obric/eventkit/eventstaskmanager/AppEvent;)Ljava/lang/Boolean;", "tryInterruptAssistant", "tryOpenMicToRecording", "tryScheduleConditionTask", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskMode", "unRegisterAssistantSessionState", "unRegisterAssistantTtsPlayingState", "unregisterEventTaskChangeListener", "unregisterEventTaskScheduleListener", "unregisterTimerTaskChangeListener", "updateConditionTask", "enableStatus", "updateEventTask", "updateEventTaskExecutionDetailRecord", "record", "updateEventTaskExecutionDetailRecords", "updateEventTaskExecutionRecord", "updateEventTaskExecutionRecords", "updateTimerTask", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventProxy implements IEventProxy {
    public static final a Companion = null;
    private static final String TAG = "EventProxy";
    private final h api;
    private final h mApi;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/eventkit/EventProxy$Companion;", "", "()V", "TAG", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public EventProxy(h r7) {
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "api");
        this.api = r8;
        BinderExceptionHandlerProxy.Companion r0 = BinderExceptionHandlerProxy.Companion;
        Object r2 = Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{h.class}, new BinderExceptionHandlerProxy(r8, TAG, h.class));     // Catch: Throwable -> L8
        if (r2 == null) goto L7;
        r8 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L12:
        this.mApi = (h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Throwable r3 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
        if (r3 == null) goto L12;
        Log.e(TAG, "BinderExceptionHandlerProxy createProxyInstance for " + r8.getClass() + " fail", r3);
        goto L12
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult addConditionTask(List<ConditionTaskAction> r10, String r11, ConditionGroup r12, PeriodicPolicy r13, TriggerControlPolicy r14, Map<String, String> r15) {
        List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        return this.mApi.a(r3, r11, r12, r13, r14, r8);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult addEventTask(EventTaskSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        return this.mApi.a(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r3) {
        List<EventTaskExecutionDetailRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "records");
        return this.mApi.c(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r3) {
        List<EventTaskExecutionRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "records");
        return this.mApi.a(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult addTimerTask(TimerTask r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        return this.mApi.a(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void closeAssistantInputPanel() {
        this.mApi.c();
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getAllConditionTaskRecords(long r1, long r3) {
        return this.mApi.b(r1, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getAllEventTaskRecords(long r7, long r9, int r11) {
        return this.mApi.b(r7, r9, r11);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getAllEventTasks() {
        return this.mApi.g();
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getAllTimerTaskRecords(long r1, long r3) {
        return this.mApi.a(r1, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTask> getAllTimerTasks() {
        return this.mApi.a();
    }

    public final h getApi() {
        return this.api;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantSessionState() {
        return Integer.valueOf(this.mApi.d());
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantTtsPlayingState() {
        return Integer.valueOf(this.mApi.e());
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTask getConditionTask(String r1) {
        return this.mApi.a(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r7, long r9, String r11) {
        return this.mApi.a(r7, r9, r11);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTask getEventTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.b(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1) {
        return this.mApi.b(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2) {
        return this.mApi.b(r1, r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsByTaskId(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.b(r2, r3, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1) {
        return this.mApi.a(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2) {
        return this.mApi.a(r1, r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.a(r2, r3, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getEventTaskRecordsByTaskId(long r8, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r12, "taskId");
        return this.mApi.b(r8, r10, r12);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getEventTasksByType(int r1, int r2, int r3) {
        return this.mApi.a(r1, r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getKnowledgeSessionIdNotNullEventTasks() {
        return this.mApi.h();
    }

    @Override // com.obric.eventkit.IEventProxy
    public Long getNextScheduleTimeStamp(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        h r1 = this.mApi;
        Integer r3 = StringsKt.toIntOrNull(r2);
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        return Long.valueOf(r1.b(r4));
    L5:
        r4 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ShortcutTask> getShortInstructNotNullShortcutTasks() {
        return this.mApi.j();
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getTemplateIdNotNullEventTasks() {
        return this.mApi.i();
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTask getTimerTaskByTaskId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        h r1 = this.mApi;
        Integer r3 = StringsKt.toIntOrNull(r2);
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        return r1.a(r4);
    L5:
        r4 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r8, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r12, "taskId");
        h r1 = this.mApi;
        Integer r7 = StringsKt.toIntOrNull(r12);
        if (r7 == null) goto L5;
        int r9 = r7.intValue();
    L7:
        return r1.a(r8, r10, r9);
    L5:
        r9 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public void notifyAssistantState(boolean r2, StateInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "stateInfo");
        this.mApi.a(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void openAssistantInputPanel(StateInfo r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "stateInfo");
        this.mApi.a(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantSessionState(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.a(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantTtsPlayingState(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.a(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskChangeListener(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.a(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskScheduleListener(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.a(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerTimerTaskChangeListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.a(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllConditionTaskRecords() {
        return this.mApi.b();
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllEventTaskRecords(int r1) {
        return this.mApi.c(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeAllTimeTaskRecords() {
        return Integer.valueOf(this.mApi.b());
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult removeConditionTask(String[] r1) {
        return this.mApi.a(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeConditionTaskRecordsById(long[] r1) {
        return this.mApi.a(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult removeEventTask(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "taskIds");
        return this.mApi.b(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsById(long[] r2) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        return this.mApi.c(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsByTaskId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.e(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsById(long[] r2) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        return this.mApi.b(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsByTaskId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.mApi.d(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskRecordsById(int r2, long[] r3) {
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        return this.mApi.b(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTask(Map<String, ? extends Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "parameters");
        return this.mApi.a(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeTimerTaskRecordsById(List<Integer> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, OaidModel.KEY_ID);
        return Integer.valueOf(this.mApi.b(CollectionsKt.toIntArray(r4)));
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTasksByTaskId(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "taskId");
        h r4 = this.mApi;
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Integer r2 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return r4.a(CollectionsKt.toIntArray(r0));
    }

    @Override // com.obric.eventkit.IEventProxy
    public void requestSendMessage(String r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r4, MemoryInfoSectionEditActivity.KIND_SCENE);
        this.mApi.a(r3, r4, r6);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void scheduleShortcutTask(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.mApi.a(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void setAssistantInteractionListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.a(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void skipConditionTaskSchedule(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.mApi.c(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult skipTimerTasksByTaskId(String r3, List<Long> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r5, "timeStamp");
        h r2 = this.mApi;
        Integer r6 = StringsKt.toIntOrNull(r3);
        if (r6 == null) goto L5;
        int r7 = r6.intValue();
    L7:
        return r2.a(r7, CollectionsKt.toLongArray(r5));
    L5:
        r7 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryActiveAgent(AppEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return Boolean.valueOf(this.mApi.c(r2));
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryInterruptAssistant(AppEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return Boolean.valueOf(this.mApi.a(r2));
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryOpenMicToRecording(AppEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return Boolean.valueOf(this.mApi.b(r2));
    }

    @Override // com.obric.eventkit.IEventProxy
    public void tryScheduleConditionTask(String r7, List<ConditionTaskAction> r8, TaskKnowledge r9, int r10, String r11) {
        List<ConditionTaskAction> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "actions");
        this.mApi.a(r7, r2, r9, r10, r11);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantSessionState(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.b(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantTtsPlayingState(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.b(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskChangeListener(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.b(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskScheduleListener(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.b(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterTimerTaskChangeListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.mApi.b(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult updateConditionTask(String r12, List<ConditionTaskAction> r13, String r14, ConditionGroup r15, PeriodicPolicy r16, TriggerControlPolicy r17, int r18, Map<String, String> r19) {
        List<ConditionTaskAction> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        return this.mApi.a(r12, r4, r14, r15, r16, r17, r18, r10);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult updateEventTask(String r2, EventTaskSpec r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "spec");
        return this.mApi.a(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return this.mApi.a(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r3) {
        List<EventTaskExecutionDetailRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "records");
        return this.mApi.d(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return this.mApi.a(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r3) {
        List<EventTaskExecutionRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "records");
        return this.mApi.b(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult updateTimerTask(TimerTask r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        return this.mApi.b(r2);
    }
}
