package com.obric.eventkit;

import android.app.Application;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.eventkit.apphost.AppHost;
import com.obric.eventkit.eventstaskmanager.ActiveAgentEvent;
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
import com.obric.eventkit.logger.ILogger;
import com.obric.eventkit.logger.Logger;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bo;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004Ú\u0001Û\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u000e\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u0016J\u001b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J'\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010 2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J'\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010 2\f\u00107\u001a\b\u0012\u0004\u0012\u00020:0 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J\u0010\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u001aH\u0002J\u001b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\r\u0010B\u001a\u00020\u000fH\u0000¢\u0006\u0002\bCJ\u0016\u0010D\u001a\u00020\u000f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0006\u0010F\u001a\u00020\u000fJ\b\u0010G\u001a\u00020\u000fH\u0002J+\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010I\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010MJ1\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010P\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010RJ\u0019\u0010S\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ)\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010MJ\u0019\u0010X\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\b\u0010Y\u001a\u00020ZH\u0002J\u0013\u0010[\u001a\u0004\u0018\u00010QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0013\u0010\\\u001a\u0004\u0018\u00010QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J3\u0010a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010I\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010bJ\u001b\u0010c\u001a\u0004\u0018\u00010T2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u001b\u0010d\u001a\u0004\u0018\u0001062\u0006\u0010e\u001a\u00020KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010fJ)\u0010g\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010 2\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010jJ1\u0010k\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010 2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010lJ\u001b\u0010m\u001a\u0004\u0018\u00010:2\u0006\u0010e\u001a\u00020KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010fJ)\u0010n\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010 2\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010jJ1\u0010o\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010 2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010lJ1\u0010p\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010bJ1\u0010q\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010 2\u0006\u0010P\u001a\u00020Q2\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010rJ\u0019\u0010s\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010t\u001a\u0004\u0018\u00010K2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u0019\u0010u\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0019\u0010w\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010x\u001a\u0004\u0018\u00010@2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J3\u0010y\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010W\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010bJ\u0010\u0010z\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0007J\u0016\u0010{\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\b2\u0006\u0010}\u001a\u00020~J\u000e\u0010\u007f\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0080\u0001J\u000f\u0010\u0081\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0084\u0001J\u0018\u0010\u0085\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u0086\u0001\u001a\u00020\bJ\u0012\u0010\u0087\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u0088\u0001H\u0007J\u0012\u0010\u0089\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008a\u0001H\u0007J\u0010\u0010\u008b\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008c\u0001J\u0010\u0010\u008d\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008e\u0001J\u0012\u0010\u008f\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u0090\u0001H\u0007J\u0012\u0010\u0091\u0001\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010\u0092\u0001\u001a\u00020Q2\u0006\u0010P\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0093\u0001J\u0014\u0010\u0094\u0001\u001a\u0004\u0018\u00010QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ%\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001e2\u000e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u0097\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0098\u0001J\u001c\u0010\u0099\u0001\u001a\u00020Q2\u0007\u0010e\u001a\u00030\u009a\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001J\u0017\u0010\u009c\u0001\u001a\u00020\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J%\u0010\u009d\u0001\u001a\u0004\u0018\u0001012\u000e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u0097\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0098\u0001J\u001c\u0010\u009e\u0001\u001a\u00020Q2\u0007\u0010e\u001a\u00030\u009a\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001J\u001a\u0010\u009f\u0001\u001a\u00020Q2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u001c\u0010 \u0001\u001a\u00020Q2\u0007\u0010e\u001a\u00030\u009a\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001J\u001a\u0010¡\u0001\u001a\u00020Q2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J$\u0010¢\u0001\u001a\u00020Q2\u0006\u0010P\u001a\u00020Q2\u0007\u0010e\u001a\u00030\u009a\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010£\u0001J*\u0010¤\u0001\u001a\u0004\u0018\u00010>2\u0013\u0010¥\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010*H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010¦\u0001J\"\u0010§\u0001\u001a\u0004\u0018\u00010Q2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020Q0 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J\"\u0010¨\u0001\u001a\u0004\u0018\u00010>2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J/\u0010©\u0001\u001a\u00020\u000f2\u0007\u0010ª\u0001\u001a\u00020\u00042\u0007\u0010«\u0001\u001a\u00020\u00042\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010*J\u001c\u0010¬\u0001\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020\u00042\u000b\b\u0002\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0004J\u0010\u0010®\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030¯\u0001J\u0017\u0010°\u0001\u001a\u00020\u000f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u0013\u0010±\u0001\u001a\u00020\u000f2\b\u0010²\u0001\u001a\u00030³\u0001H\u0007J\u0018\u0010´\u0001\u001a\u00020\u000f2\u0007\u0010µ\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\b¶\u0001J\u000f\u0010·\u0001\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020\u0004J,\u0010¸\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010_\u001a\u00020\u00042\r\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020K0 H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010º\u0001J\u001f\u0010»\u0001\u001a\u0004\u0018\u00010\b2\b\u0010¼\u0001\u001a\u00030½\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010¾\u0001J\u001f\u0010¿\u0001\u001a\u0004\u0018\u00010\b2\b\u0010¼\u0001\u001a\u00030À\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Á\u0001J\u001f\u0010Â\u0001\u001a\u0004\u0018\u00010\b2\b\u0010¼\u0001\u001a\u00030À\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Á\u0001JM\u0010Ã\u0001\u001a\u00020\u000f2\b\u0010_\u001a\u0004\u0018\u00010\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u00012\u0007\u0010Æ\u0001\u001a\u00020Q2\u000b\b\u0002\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Ç\u0001J\u0012\u0010È\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u0088\u0001H\u0007J\u0012\u0010É\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008a\u0001H\u0007J\u0010\u0010Ê\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008c\u0001J\u0010\u0010Ë\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008e\u0001J\u0012\u0010Ì\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u0090\u0001H\u0007J\u0082\u0001\u0010Í\u0001\u001a\u0004\u0018\u00010\u001e2\u0006\u0010_\u001a\u00020\u00042\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\t\b\u0002\u0010Î\u0001\u001a\u00020Q2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010*H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Ï\u0001J%\u0010Ð\u0001\u001a\u0004\u0018\u0001012\u0006\u0010_\u001a\u00020\u00042\u0006\u00102\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Ñ\u0001J\u001e\u0010Ò\u0001\u001a\u0004\u0018\u0001062\u0007\u0010Ó\u0001\u001a\u000206H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Ô\u0001J \u0010Õ\u0001\u001a\u00020Q2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J\u001e\u0010Ö\u0001\u001a\u0004\u0018\u00010:2\u0007\u0010Ó\u0001\u001a\u00020:H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010×\u0001J \u0010Ø\u0001\u001a\u00020Q2\f\u00107\u001a\b\u0012\u0004\u0012\u00020:0 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J\u001c\u0010Ù\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Ü\u0001"}, d2 = {"Lcom/obric/eventkit/EventsTaskSdk;", "", "()V", "TAG", "", "_config", "Lcom/obric/eventkit/EventsTaskSdk$InitConfig;", "apiInitialized", "", "getApiInitialized$eventstaskkit_release", "()Z", "setApiInitialized$eventstaskkit_release", "(Z)V", "binderDiedCallback", "Lkotlin/Function0;", "", "config", "getConfig", "()Lcom/obric/eventkit/EventsTaskSdk$InitConfig;", "connectionListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mBinderDiedListener", "Lcom/obric/eventkit/eventstaskmanager/IEventBinderListener;", "mPendingCallsExecuted", "mPendingCals", "", "Lcom/obric/eventkit/EventsTaskSdk$ApiCall;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "actions", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", ActivityLifecycle.NAME, "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "ext", "", "(Ljava/util/List;Ljava/lang/String;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addConnectionListener", "listener", "addEventBinderListener", "bl", "addEventTask", "Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "spec", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "(Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addEventTaskExecutionDetailRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;", "records", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addEventTaskExecutionRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;", "addPendingCall", NotificationCompat.CATEGORY_CALL, "addTimerTask", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskResult;", "task", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "(Lcom/obric/eventkit/eventstaskmanager/TimerTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "binderDied", "binderDied$eventstaskkit_release", "callOrAddPendingCall", "func", "closeAssistantInputPanel", "execPendingCalls", "getAllConditionTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskRecord;", "startTime", "", "endTime", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEventTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "type", "", "(JJILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEventTasks", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTimerTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "getAllTimerTasks", "getApi", "Lcom/obric/eventkit/IEventProxy;", "getAssistantSessionState", "getAssistantTtsPlayingState", "getConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "taskId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConditionTaskRecordsByTaskId", "(JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventTask", "getEventTaskExecutionDetailRecordById", OaidModel.KEY_ID, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventTaskExecutionDetailRecords", TypedValues.CycleType.S_WAVE_OFFSET, "size", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventTaskExecutionDetailRecordsByTaskId", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventTaskExecutionRecordById", "getEventTaskExecutionRecords", "getEventTaskExecutionRecordsByTaskId", "getEventTaskRecordsByTaskId", "getEventTasksByType", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKnowledgeSessionIdNotNullEventTasks", "getNextScheduleTimeStamp", "getShortInstructNotNullShortcutTasks", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "getTemplateIdNotNullEventTasks", "getTimerTaskByTaskId", "getTimerTaskRecordsByTaskId", CommonConsts.APM_INNER_EVENT_COST_INIT, "notifyAssistantState", "enter", "stateInfo", "Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "onApiInitComplete", "onApiInitComplete$eventstaskkit_release", "onConnectionClosed", "onConnectionClosed$eventstaskkit_release", "onServiceDisconnected", "onServiceDisconnected$eventstaskkit_release", "openAssistantInputPanel", "force", "registerAssistantSessionState", "Lcom/obric/eventkit/eventstaskmanager/IAssistantSessionStateListener;", "registerAssistantTtsPlayingState", "Lcom/obric/eventkit/eventstaskmanager/IAssistantTtsStateListener;", "registerEventTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskChangeListener;", "registerEventTaskScheduleListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskScheduleListener;", "registerTimerTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/ITimerTaskChangeListener;", "removeAllConditionTaskRecords", "removeAllEventTaskRecords", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAllTimeTaskRecords", "removeConditionTask", "taskIds", "", "([Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeConditionTaskRecordsById", "", "([JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeConnectionListener", "removeEventTask", "removeEventTaskExecutionDetailRecordsById", "removeEventTaskExecutionDetailRecordsByTaskId", "removeEventTaskExecutionRecordsById", "removeEventTaskExecutionRecordsByTaskId", "removeEventTaskRecordsById", "(I[JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTimerTask", "parameters", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTimerTaskRecordsById", "removeTimerTasksByTaskId", "requestSendMessage", Params.CONTENT, MemoryInfoSectionEditActivity.KIND_SCENE, "scheduleShortcutTask", AILabCheckPermissionTask.KEY_SOURCE, "setAssistantInteractionListener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantInteractionListener;", "setBinderDiedCallback", "setLogger", "logger", "Lcom/obric/eventkit/logger/ILogger;", "setPendingCallsExecuted", "isExecuted", "setPendingCallsExecuted$eventstaskkit_release", "skipConditionTaskSchedule", "skipTimerTasksByTaskId", "timeStamp", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryActiveAgent", "event", "Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;", "(Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryInterruptAssistant", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "(Lcom/obric/eventkit/eventstaskmanager/AppEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryOpenMicToRecording", "tryScheduleConditionTask", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskMode", "(Ljava/lang/String;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unRegisterAssistantSessionState", "unRegisterAssistantTtsPlayingState", "unregisterEventTaskChangeListener", "unregisterEventTaskScheduleListener", "unregisterTimerTaskChangeListener", "updateConditionTask", "enableStatus", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;ILjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventTask", "(Ljava/lang/String;Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventTaskExecutionDetailRecord", "record", "(Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventTaskExecutionDetailRecords", "updateEventTaskExecutionRecord", "(Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventTaskExecutionRecords", "updateTimerTask", "ApiCall", "InitConfig", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventsTaskSdk {
    public static final EventsTaskSdk INSTANCE = null;
    private static final String TAG = "EventsTaskSdk";
    private static InitConfig _config;
    private static boolean apiInitialized;
    private static Function0<Unit> binderDiedCallback;
    private static final CopyOnWriteArraySet<Function0<Unit>> connectionListeners = null;
    private static CopyOnWriteArraySet<com.obric.eventkit.eventstaskmanager.e> mBinderDiedListener;
    private static boolean mPendingCallsExecuted;
    private static final List<a> mPendingCals = null;
    private static final al scope = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/eventkit/EventsTaskSdk$InitConfig;", "", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApp", "()Landroid/app/Application;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InitConfig {
        private final Application app;

        public InitConfig(Application r3) {
            Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "app");
            this.app = r4;
        }

        public static /* synthetic */ InitConfig copy$default(InitConfig r1, Application r2, int r3, Object r4) {
            Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
            if ((r3 & 1) == 0) goto L6;
            r5 = r1.app;
        L6:
            return r1.copy(r5);
        }

        public final Application component1() {
            return this.app;
        }

        public final InitConfig copy(Application r2) {
            Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "app");
            return new InitConfig(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, InitConfig.class) == true) goto L8;
            return false;
        L8:
            InitConfig r6 = (InitConfig) ZeusTransformUtils.preCheckCast(r5, InitConfig.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.app, r6.app) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final Application getApp() {
            return this.app;
        }

        public int hashCode() {
            return this.app.hashCode();
        }

        public String toString() {
            return "InitConfig(app=" + this.app + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/eventkit/EventsTaskSdk$ApiCall;", "", NotificationCompat.CATEGORY_CALL, "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<? extends EventTask>> f7895a;

        public a0(Continuation<? super List<? extends EventTask>> r3) {
            this.f7895a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getKnowledgeSessionIdNotNullEventTasks");
            this.f7895a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getKnowledgeSessionIdNotNullEventTasks()));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<TimerTaskResult> f7896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<String> f7897b;

        public a1(Continuation<? super TimerTaskResult> r3, List<String> r4) {
            Continuation<TimerTaskResult> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f7896a = r5;
            this.f7897b = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7896a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeTimerTasksByTaskId(this.f7897b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<ConditionTaskResult> f7898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<ConditionTaskAction> f7899b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ConditionGroup d;
        public final /* synthetic */ PeriodicPolicy e;
        public final /* synthetic */ TriggerControlPolicy f;
        public final /* synthetic */ Map<String, String> g;

        public b(Continuation<? super ConditionTaskResult> r3, List<ConditionTaskAction> r4, String r5, ConditionGroup r6, PeriodicPolicy r7, TriggerControlPolicy r8, Map<String, String> r9) {
            Continuation<ConditionTaskResult> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<ConditionTaskAction> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
            this.f7898a = r10;
            this.f7899b = r11;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r12;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "addConditionTask");
            this.f7898a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addConditionTask(this.f7899b, this.c, this.d, this.e, this.f, this.g)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Long> f7900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7901b;

        public b0(Continuation<? super Long> r3, String r4) {
            this.f7900a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7901b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7900a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getNextScheduleTimeStamp(this.f7901b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7903b;
        public final /* synthetic */ Map<String, String> c;

        public b1(String r3, String r4, Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            this.f7902a = r3;
            this.f7903b = r4;
            this.c = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "requestSendMessage");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).requestSendMessage(this.f7902a, this.f7903b, this.c);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<EventTaskResult> f7904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EventTaskSpec f7905b;

        public c(Continuation<? super EventTaskResult> r3, EventTaskSpec r4) {
            this.f7904a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7905b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "addEventTask");
            this.f7904a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addEventTask(this.f7905b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<ShortcutTask>> f7906a;

        public c0(Continuation<? super List<ShortcutTask>> r3) {
            this.f7906a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getShortInstructNotNullShortcutTasks");
            this.f7906a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getShortInstructNotNullShortcutTasks()));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7908b;

        public c1(String r1, String r2) {
            this.f7907a = r1;
            this.f7908b = r2;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "scheduleShortcutTask");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).scheduleShortcutTask(this.f7907a, this.f7908b);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<EventTaskExecutionDetailRecord>> f7909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<EventTaskExecutionDetailRecord> f7910b;

        public d(Continuation<? super List<EventTaskExecutionDetailRecord>> r3, List<EventTaskExecutionDetailRecord> r4) {
            Continuation<List<EventTaskExecutionDetailRecord>> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f7909a = r5;
            this.f7910b = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "addEventTaskExecutionDetailRecords");
            this.f7909a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addEventTaskExecutionDetailRecords(this.f7910b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<? extends EventTask>> f7911a;

        public d0(Continuation<? super List<? extends EventTask>> r3) {
            this.f7911a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getTemplateIdNotNullEventTasks");
            this.f7911a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getTemplateIdNotNullEventTasks()));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.b f7912a;

        public d1(com.obric.eventkit.eventstaskmanager.b r3) {
            this.f7912a = (com.obric.eventkit.eventstaskmanager.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.b.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "setAssistantInteractionListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).setAssistantInteractionListener(this.f7912a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<EventTaskExecutionRecord>> f7913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<EventTaskExecutionRecord> f7914b;

        public e(Continuation<? super List<EventTaskExecutionRecord>> r3, List<EventTaskExecutionRecord> r4) {
            Continuation<List<EventTaskExecutionRecord>> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f7913a = r5;
            this.f7914b = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "addEventTaskExecutionRecords");
            this.f7913a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addEventTaskExecutionRecords(this.f7914b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<TimerTask> f7915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7916b;

        public e0(Continuation<? super TimerTask> r3, String r4) {
            this.f7915a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7916b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7915a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getTimerTaskByTaskId(this.f7916b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7917a;

        public e1(String r1) {
            this.f7917a = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "skipConditionTaskSchedule");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).skipConditionTaskSchedule(this.f7917a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<TimerTaskResult> f7918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TimerTask f7919b;

        public f(Continuation<? super TimerTaskResult> r3, TimerTask r4) {
            this.f7918a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7919b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7918a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addTimerTask(this.f7919b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<TimerTaskRecord>> f7920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7921b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public f0(Continuation<? super List<TimerTaskRecord>> r3, long r4, long r6, String r8) {
            this.f7920a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7921b = r4;
            this.c = r6;
            this.d = r8;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7920a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getTimerTaskRecordsByTaskId(this.f7921b, this.c, this.d)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<TimerTaskResult> f7922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7923b;
        public final /* synthetic */ List<Long> c;

        public f1(Continuation<? super TimerTaskResult> r3, String r4, List<Long> r5) {
            Continuation<TimerTaskResult> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            this.f7922a = r6;
            this.f7923b = r4;
            this.c = r7;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7922a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).skipTimerTasksByTaskId(this.f7923b, this.c)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/eventkit/EventsTaskSdk$callOrAddPendingCall$1", "Lcom/obric/eventkit/EventsTaskSdk$ApiCall;", NotificationCompat.CATEGORY_CALL, "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f7924a;

        public g(Function0<Unit> r3) {
            this.f7924a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.eventkit.EventsTaskSdk.a
        public void a() {
            this.f7924a.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StateInfo f7926b;

        public g0(boolean r1, StateInfo r2) {
            this.f7925a = r1;
            this.f7926b = r2;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "notifyAssistantState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).notifyAssistantState(this.f7925a, this.f7926b);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Boolean> f7927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActiveAgentEvent f7928b;

        public g1(Continuation<? super Boolean> r3, ActiveAgentEvent r4) {
            this.f7927a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7928b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7927a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).tryActiveAgent(this.f7928b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f7929a = null;

        static {
            f7929a = new h();
        }

        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "closeAssistantInputPanel");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).closeAssistantInputPanel();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StateInfo f7930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f7931b;

        public h0(StateInfo r1, boolean r2) {
            this.f7930a = r1;
            this.f7931b = r2;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "openAssistantInputPanel");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).openAssistantInputPanel(this.f7930a, this.f7931b);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Boolean> f7932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppEvent f7933b;

        public h1(Continuation<? super Boolean> r3, AppEvent r4) {
            this.f7932a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7933b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7932a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).tryInterruptAssistant(this.f7933b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<ConditionTaskRecord>> f7934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7935b;
        public final /* synthetic */ long c;

        public i(Continuation<? super List<ConditionTaskRecord>> r3, long r4, long r6) {
            this.f7934a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7935b = r4;
            this.c = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getAllConditionTaskRecords");
            this.f7934a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllConditionTaskRecords(this.f7935b, this.c)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.c f7936a;

        public i0(com.obric.eventkit.eventstaskmanager.c r3) {
            this.f7936a = (com.obric.eventkit.eventstaskmanager.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.c.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerAssistantSessionState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerAssistantSessionState(this.f7936a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Boolean> f7937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppEvent f7938b;

        public i1(Continuation<? super Boolean> r3, AppEvent r4) {
            this.f7937a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7938b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7937a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).tryOpenMicToRecording(this.f7938b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<? extends EventTaskRecord>> f7939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7940b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;

        public j(Continuation<? super List<? extends EventTaskRecord>> r3, long r4, long r6, int r8) {
            this.f7939a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7940b = r4;
            this.c = r6;
            this.d = r8;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getAllEventTaskRecords");
            this.f7939a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllEventTaskRecords(this.f7940b, this.c, this.d)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.d f7941a;

        public j0(com.obric.eventkit.eventstaskmanager.d r3) {
            this.f7941a = (com.obric.eventkit.eventstaskmanager.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.d.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerAssistantTtsPlayingState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerAssistantTtsPlayingState(this.f7941a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Unit> f7942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7943b;
        public final /* synthetic */ List<ConditionTaskAction> c;
        public final /* synthetic */ TaskKnowledge d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;

        public j1(Continuation<? super Unit> r3, String r4, List<ConditionTaskAction> r5, TaskKnowledge r6, int r7, String r8) {
            Continuation<Unit> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<ConditionTaskAction> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            this.f7942a = r9;
            this.f7943b = r4;
            this.c = r10;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "tryScheduleConditionTask");
            Continuation<Unit> r0 = this.f7942a;
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).tryScheduleConditionTask(this.f7943b, this.c, this.d, this.e, this.f);
            r0.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<? extends EventTask>> f7944a;

        public k(Continuation<? super List<? extends EventTask>> r3) {
            this.f7944a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getAllEventTasks");
            this.f7944a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllEventTasks()));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.f f7945a;

        public k0(com.obric.eventkit.eventstaskmanager.f r3) {
            this.f7945a = (com.obric.eventkit.eventstaskmanager.f) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.f.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerEventTaskChangeListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerEventTaskChangeListener(this.f7945a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.c f7946a;

        public k1(com.obric.eventkit.eventstaskmanager.c r3) {
            this.f7946a = (com.obric.eventkit.eventstaskmanager.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.c.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unRegisterAssistantSessionState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unRegisterAssistantSessionState(this.f7946a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<TimerTaskRecord>> f7947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7948b;
        public final /* synthetic */ long c;

        public l(Continuation<? super List<TimerTaskRecord>> r3, long r4, long r6) {
            this.f7947a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7948b = r4;
            this.c = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7947a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllTimerTaskRecords(this.f7948b, this.c)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.g f7949a;

        public l0(com.obric.eventkit.eventstaskmanager.g r3) {
            this.f7949a = (com.obric.eventkit.eventstaskmanager.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.g.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerEventTaskScheduleListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerEventTaskScheduleListener(this.f7949a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.d f7950a;

        public l1(com.obric.eventkit.eventstaskmanager.d r3) {
            this.f7950a = (com.obric.eventkit.eventstaskmanager.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.d.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unRegisterAssistantTtsPlayingState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unRegisterAssistantTtsPlayingState(this.f7950a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<TimerTask>> f7951a;

        public m(Continuation<? super List<TimerTask>> r3) {
            this.f7951a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7951a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllTimerTasks()));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.i f7952a;

        public m0(com.obric.eventkit.eventstaskmanager.i r3) {
            this.f7952a = (com.obric.eventkit.eventstaskmanager.i) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.i.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerTimerTaskChangeListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerTimerTaskChangeListener(this.f7952a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.f f7953a;

        public m1(com.obric.eventkit.eventstaskmanager.f r3) {
            this.f7953a = (com.obric.eventkit.eventstaskmanager.f) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.f.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unregisterEventTaskChangeListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unregisterEventTaskChangeListener(this.f7953a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7954a;

        public n(Continuation<? super Integer> r3) {
            this.f7954a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7954a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAssistantSessionState()));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7955a;

        public n0(Continuation<? super Integer> r3) {
            this.f7955a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeAllConditionTaskRecords");
            this.f7955a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeAllConditionTaskRecords())));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.g f7956a;

        public n1(com.obric.eventkit.eventstaskmanager.g r3) {
            this.f7956a = (com.obric.eventkit.eventstaskmanager.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.g.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unregisterEventTaskScheduleListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unregisterEventTaskScheduleListener(this.f7956a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7957a;

        public o(Continuation<? super Integer> r3) {
            this.f7957a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7957a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAssistantTtsPlayingState()));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7959b;

        public o0(Continuation<? super Integer> r3, int r4) {
            this.f7958a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7959b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeAllEventTaskRecords");
            this.f7958a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeAllEventTaskRecords(this.f7959b))));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.obric.eventkit.eventstaskmanager.i f7960a;

        public o1(com.obric.eventkit.eventstaskmanager.i r3) {
            this.f7960a = (com.obric.eventkit.eventstaskmanager.i) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.i.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unregisterTimerTaskChangeListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unregisterTimerTaskChangeListener(this.f7960a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<ConditionTask> f7961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7962b;

        public p(Continuation<? super ConditionTask> r3, String r4) {
            this.f7961a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7962b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getConditionTask");
            this.f7961a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getConditionTask(this.f7962b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7963a;

        public p0(Continuation<? super Integer> r3) {
            this.f7963a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f7963a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeAllTimeTaskRecords()));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<ConditionTaskResult> f7964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7965b;
        public final /* synthetic */ List<ConditionTaskAction> c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ConditionGroup e;
        public final /* synthetic */ PeriodicPolicy f;
        public final /* synthetic */ TriggerControlPolicy g;
        public final /* synthetic */ int h;
        public final /* synthetic */ Map<String, String> i;

        public p1(Continuation<? super ConditionTaskResult> r3, String r4, List<ConditionTaskAction> r5, String r6, ConditionGroup r7, PeriodicPolicy r8, TriggerControlPolicy r9, int r10, Map<String, String> r11) {
            Continuation<ConditionTaskResult> r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<ConditionTaskAction> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
            this.f7964a = r12;
            this.f7965b = r4;
            this.c = r13;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r14;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateConditionTask");
            this.f7964a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateConditionTask(this.f7965b, this.c, this.d, this.e, this.f, this.g, this.h, this.i)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<ConditionTaskRecord>> f7966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7967b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public q(Continuation<? super List<ConditionTaskRecord>> r3, long r4, long r6, String r8) {
            this.f7966a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7967b = r4;
            this.c = r6;
            this.d = r8;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getConditionTaskRecordsByTaskId");
            this.f7966a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getConditionTaskRecordsByTaskId(this.f7967b, this.c, this.d)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<ConditionTaskResult> f7968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f7969b;

        public q0(Continuation<? super ConditionTaskResult> r3, String[] r4) {
            this.f7968a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7969b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeConditionTask");
            this.f7968a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeConditionTask(this.f7969b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<EventTaskResult> f7970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7971b;
        public final /* synthetic */ EventTaskSpec c;

        public q1(Continuation<? super EventTaskResult> r3, String r4, EventTaskSpec r5) {
            this.f7970a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7971b = r4;
            this.c = r5;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTask");
            this.f7970a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTask(this.f7971b, this.c)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<EventTask> f7972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7973b;

        public r(Continuation<? super EventTask> r3, String r4) {
            this.f7972a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7973b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTask");
            this.f7972a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTask(this.f7973b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f7975b;

        public r0(Continuation<? super Integer> r3, long[] r4) {
            this.f7974a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7975b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeConditionTaskRecordsById");
            this.f7974a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeConditionTaskRecordsById(this.f7975b))));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<EventTaskExecutionDetailRecord> f7976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EventTaskExecutionDetailRecord f7977b;

        public r1(Continuation<? super EventTaskExecutionDetailRecord> r3, EventTaskExecutionDetailRecord r4) {
            this.f7976a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7977b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTaskExecutionDetailRecord");
            this.f7976a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTaskExecutionDetailRecord(this.f7977b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<EventTaskExecutionDetailRecord> f7978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7979b;

        public s(Continuation<? super EventTaskExecutionDetailRecord> r3, long r4) {
            this.f7978a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7979b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionDetailRecordById");
            this.f7978a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionDetailRecordById(this.f7979b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<EventTaskResult> f7980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f7981b;

        public s0(Continuation<? super EventTaskResult> r3, String[] r4) {
            this.f7980a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7981b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTask");
            this.f7980a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTask(this.f7981b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<EventTaskExecutionDetailRecord> f7983b;

        public s1(Continuation<? super Integer> r3, List<EventTaskExecutionDetailRecord> r4) {
            Continuation<Integer> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f7982a = r5;
            this.f7983b = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTaskExecutionDetailRecords");
            this.f7982a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTaskExecutionDetailRecords(this.f7983b))));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<EventTaskExecutionDetailRecord>> f7984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7985b;
        public final /* synthetic */ int c;

        public t(Continuation<? super List<EventTaskExecutionDetailRecord>> r3, int r4, int r5) {
            this.f7984a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7985b = r4;
            this.c = r5;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionDetailRecords");
            this.f7984a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionDetailRecords(this.f7985b, this.c)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f7987b;

        public t0(Continuation<? super Integer> r3, long[] r4) {
            this.f7986a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7987b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskExecutionDetailRecordsById");
            this.f7986a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskExecutionDetailRecordsById(this.f7987b))));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<EventTaskExecutionRecord> f7988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EventTaskExecutionRecord f7989b;

        public t1(Continuation<? super EventTaskExecutionRecord> r3, EventTaskExecutionRecord r4) {
            this.f7988a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7989b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTaskExecutionRecord");
            this.f7988a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTaskExecutionRecord(this.f7989b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<EventTaskExecutionDetailRecord>> f7990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7991b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public u(Continuation<? super List<EventTaskExecutionDetailRecord>> r3, String r4, int r5, int r6) {
            this.f7990a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7991b = r4;
            this.c = r5;
            this.d = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionDetailRecordsByTaskId");
            this.f7990a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionDetailRecordsByTaskId(this.f7991b, this.c, this.d)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7993b;

        public u0(Continuation<? super Integer> r3, String r4) {
            this.f7992a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7993b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskExecutionDetailRecordsByTaskId");
            this.f7992a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskExecutionDetailRecordsByTaskId(this.f7993b))));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<EventTaskExecutionRecord> f7995b;

        public u1(Continuation<? super Integer> r3, List<EventTaskExecutionRecord> r4) {
            Continuation<Integer> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f7994a = r5;
            this.f7995b = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTaskExecutionRecords");
            this.f7994a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTaskExecutionRecords(this.f7995b))));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<EventTaskExecutionRecord> f7996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7997b;

        public v(Continuation<? super EventTaskExecutionRecord> r3, long r4) {
            this.f7996a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7997b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionRecordById");
            this.f7996a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionRecordById(this.f7997b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f7998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f7999b;

        public v0(Continuation<? super Integer> r3, long[] r4) {
            this.f7998a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7999b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskExecutionRecordsById");
            this.f7998a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskExecutionRecordsById(this.f7999b))));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<TimerTaskResult> f8000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TimerTask f8001b;

        public v1(Continuation<? super TimerTaskResult> r3, TimerTask r4) {
            this.f8000a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f8001b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f8000a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateTimerTask(this.f8001b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<EventTaskExecutionRecord>> f8002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f8003b;
        public final /* synthetic */ int c;

        public w(Continuation<? super List<EventTaskExecutionRecord>> r3, int r4, int r5) {
            this.f8002a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f8003b = r4;
            this.c = r5;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionRecords");
            this.f8002a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionRecords(this.f8003b, this.c)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f8004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f8005b;

        public w0(Continuation<? super Integer> r3, String r4) {
            this.f8004a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f8005b = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskExecutionRecordsByTaskId");
            this.f8004a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskExecutionRecordsByTaskId(this.f8005b))));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<EventTaskExecutionRecord>> f8006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f8007b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public x(Continuation<? super List<EventTaskExecutionRecord>> r3, String r4, int r5, int r6) {
            this.f8006a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f8007b = r4;
            this.c = r5;
            this.d = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionRecordsByTaskId");
            this.f8006a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionRecordsByTaskId(this.f8007b, this.c, this.d)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f8008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f8009b;
        public final /* synthetic */ long[] c;

        public x0(Continuation<? super Integer> r3, int r4, long[] r5) {
            this.f8008a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f8009b = r4;
            this.c = r5;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskRecordsById");
            this.f8008a.resumeWith(Result.m1421constructorimpl(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskRecordsById(this.f8009b, this.c))));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<? extends EventTaskRecord>> f8010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f8011b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public y(Continuation<? super List<? extends EventTaskRecord>> r3, long r4, long r6, String r8) {
            this.f8010a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f8011b = r4;
            this.c = r6;
            this.d = r8;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskRecordsByTaskId");
            this.f8010a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskRecordsByTaskId(this.f8011b, this.c, this.d)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<TimerTaskResult> f8012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f8013b;

        public y0(Continuation<? super TimerTaskResult> r3, Map<String, ? extends Object> r4) {
            Continuation<TimerTaskResult> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            this.f8012a = r5;
            this.f8013b = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f8012a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeTimerTask(this.f8013b)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<? extends EventTask>> f8014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f8015b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public z(Continuation<? super List<? extends EventTask>> r3, int r4, int r5, int r6) {
            this.f8014a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f8015b = r4;
            this.c = r5;
            this.d = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTasksByType");
            this.f8014a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTasksByType(this.f8015b, this.c, this.d)));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z0 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f8016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<Integer> f8017b;

        public z0(Continuation<? super Integer> r3, List<Integer> r4) {
            Continuation<Integer> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f8016a = r5;
            this.f8017b = r6;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f8016a.resumeWith(Result.m1421constructorimpl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeTimerTaskRecordsById(this.f8017b)));
            return Unit.INSTANCE;
        }
    }

    static {
        INSTANCE = new EventsTaskSdk();
        ExecutorService r2 = Executors.newSingleThreadExecutor($$Lambda$EventsTaskSdk$9ctp7AYvB6rUnMBomunVZKyWU.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r2, "newSingleThreadExecutor …nts-task-schedule\")\n    }");
        scope = am.a(bo.a(r2));
        mPendingCals = new ArrayList();
        connectionListeners = new CopyOnWriteArraySet();
        mBinderDiedListener = new CopyOnWriteArraySet();
    }

    private EventsTaskSdk() {
    }

    public static final /* synthetic */ IEventProxy access$getApi(EventsTaskSdk r2) {
        return r2.getApi();
    }

    public static /* synthetic */ Object addConditionTask$default(EventsTaskSdk r10, List r11, String r12, ConditionGroup r13, PeriodicPolicy r14, TriggerControlPolicy r15, Map r16, Continuation r17, int r18, Object r19) {
        List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.memorydata.plugin");
        Continuation<? super ConditionTaskResult> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
        if ((r18 & 32) == 0) goto L6;
        r2 = null;
    L6:
        return r10.addConditionTask(r3, r12, r13, r14, r15, r2, r9);
    }

    @JvmStatic
    public static final void addConnectionListener(Function0<Unit> r2) {
        Function0<Unit> r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listener");
        connectionListeners.add(r3);
    }

    private static final void addEventBinderListener$lambda$26(com.obric.eventkit.eventstaskmanager.e r2) {
        com.obric.eventkit.eventstaskmanager.e r3 = (com.obric.eventkit.eventstaskmanager.e) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.eventkit.eventstaskmanager.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$bl");
        mBinderDiedListener.remove(r3);
    }

    private final void addPendingCall(a r4) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Logger r5 = Logger.INSTANCE;
        r5.d(TAG, "addPendingCall");
        List<a> r2 = mPendingCals;
        monitor-enter(r2);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mPendingCallsExecuted == false) goto L7;
        r5.w(TAG, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L10
        r3.a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r2);
        return;
    L7:
        r2.add(r3);     // Catch: Throwable -> L10
        goto L8
    }

    private final void callOrAddPendingCall(Function0<Unit> r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(getApi(), EmptyEventProxy.INSTANCE) == true) goto L5;
        r4.invoke();
        return;
    L5:
        addPendingCall(new g(r4));
    }

    private final void execPendingCalls() {
        Logger.INSTANCE.d(TAG, "execPendingCalls");
        List<a> r5 = mPendingCals;
        monitor-enter(r5);
        Iterator<T> r2 = r5.iterator();     // Catch: Throwable -> L11
    L6:
        if (r2.hasNext() == false) goto L8;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Logger.INSTANCE.d(TAG, "exec foreach call");     // Catch: Throwable -> L11
        r3.a();     // Catch: Throwable -> L11
        goto L6
    L8:
        mPendingCals.clear();     // Catch: Throwable -> L11
        mPendingCallsExecuted = true;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final IEventProxy getApi() {
        return EventServiceConnection.INSTANCE.getApi$eventstaskkit_release();
    }

    private final InitConfig getConfig() {
        InitConfig r2 = _config;
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new RuntimeException("you need to invoke EventsTaskSdk.init!");
    }

    @JvmStatic
    public static final void init(InitConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        _config = r5;
        Logger.INSTANCE.i(TAG, "EventsTaskSdk init");
        AppHost.Companion.setAppHost(new b.a.a.a.c((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApp(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")));
        com.obric.eventkit.eventstaskmanager.a.f8018a.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApp(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$9ctp7AYvB6rUnMBomunVZKy--WU, reason: not valid java name */
    public static /* synthetic */ Thread m418lambda$9ctp7AYvB6rUnMBomunVZKyWU(Runnable r2) {
        return scope$lambda$0(r2);
    }

    /* JADX INFO: renamed from: lambda$TJ2LJuxnPnLdcbeuHC5-80A4Ggc, reason: not valid java name */
    public static /* synthetic */ void m419lambda$TJ2LJuxnPnLdcbeuHC580A4Ggc(com.obric.eventkit.eventstaskmanager.e r2) {
        addEventBinderListener$lambda$26(r2);
    }

    @JvmStatic
    public static final void removeConnectionListener(Function0<Unit> r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listener");
        connectionListeners.remove(r3);
    }

    public static /* synthetic */ void scheduleShortcutTask$default(EventsTaskSdk r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = null;
    L5:
        r2.scheduleShortcutTask(r3, r4);
    }

    private static final Thread scope$lambda$0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "events-task-schedule");
    }

    @JvmStatic
    public static final void setLogger(ILogger r2) {
        ILogger r3 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Logger r4 = Logger.INSTANCE;
        r4.setLogger(r3);
        r4.i(TAG, "EventsTaskSdk setLogger");
    }

    public static /* synthetic */ Object tryScheduleConditionTask$default(EventsTaskSdk r9, String r10, List r11, TaskKnowledge r12, int r13, String r14, Continuation r15, int r16, Object r17) {
        List<ConditionTaskAction> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if ((r16 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        return r9.tryScheduleConditionTask(r10, r4, r12, r13, r7, r8);
    L5:
        r7 = r14;
        goto L7
    }

    public static /* synthetic */ Object updateConditionTask$default(EventsTaskSdk r10, String r11, List r12, String r13, ConditionGroup r14, PeriodicPolicy r15, TriggerControlPolicy r16, int r17, Map r18, Continuation r19, int r20, Object r21) {
        List<ConditionTaskAction> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        Continuation<? super ConditionTaskResult> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        Map<String, String> r5 = null;
        if ((r20 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r20 & 4) == 0) goto L8;
        String r6 = null;
    L10:
        if ((r20 & 8) == 0) goto L12;
        ConditionGroup r7 = null;
    L14:
        if ((r20 & 16) == 0) goto L16;
        PeriodicPolicy r8 = null;
    L18:
        if ((r20 & 32) == 0) goto L20;
        TriggerControlPolicy r9 = null;
    L22:
        if ((r20 & 64) == 0) goto L24;
        int r22 = -1;
    L26:
        if ((r20 & 128) != 0) goto L30;
        r5 = r3;
    L30:
        return r10.updateConditionTask(r11, r2, r6, r7, r8, r9, r22, r5, r4);
    L24:
        r22 = r17;
        goto L26
    L20:
        r9 = r16;
        goto L22
    L16:
        r8 = r15;
        goto L18
    L12:
        r7 = r14;
        goto L14
    L8:
        r6 = r13;
        goto L10
    }

    public final Object addConditionTask(List<ConditionTaskAction> r13, String r14, ConditionGroup r15, PeriodicPolicy r16, TriggerControlPolicy r17, Map<String, String> r18, Continuation<? super ConditionTaskResult> r19) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r3 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new b(r3, r4, r14, r15, r16, r17, r9));
        Object r5 = r3.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final void addEventBinderListener(com.obric.eventkit.eventstaskmanager.e r3) {
        final com.obric.eventkit.eventstaskmanager.e r2 = (com.obric.eventkit.eventstaskmanager.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "bl");
        r2.asBinder().linkToDeath(new $$Lambda$EventsTaskSdk$TJ2LJuxnPnLdcbeuHC580A4Ggc(r2), 0);
        mBinderDiedListener.add(r2);
    }

    public final Object addEventTask(EventTaskSpec r3, Continuation<? super EventTaskResult> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new c(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r3, Continuation<? super List<EventTaskExecutionDetailRecord>> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new d(r6, r2));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r7;
    }

    public final Object addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r3, Continuation<? super List<EventTaskExecutionRecord>> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new e(r6, r2));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r7;
    }

    public final Object addTimerTask(TimerTask r3, Continuation<? super TimerTaskResult> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new f(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final void binderDied$eventstaskkit_release() {
        Logger.INSTANCE.i(TAG, "binderDied");
        apiInitialized = false;
        setPendingCallsExecuted$eventstaskkit_release(false);
        Function0<Unit> r3 = binderDiedCallback;
        if (r3 == null) goto L5;
        r3.invoke();
    L5:
        Iterator<T> r4 = mBinderDiedListener.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        ((com.obric.eventkit.eventstaskmanager.e) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.eventkit.eventstaskmanager.e.class, "com.obric.memorydata.plugin")).a();
        goto L7
    }

    public final void closeAssistantInputPanel() {
        callOrAddPendingCall(h.f7929a);
    }

    public final Object getAllConditionTaskRecords(long r9, long r11, Continuation<? super List<ConditionTaskRecord>> r13) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r14 = new SafeContinuation(IntrinsicsKt.intercepted(r8));
        INSTANCE.callOrAddPendingCall(new i(r14, r9, r11));
        Object r10 = r14.getOrThrow();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L5:
        return r10;
    }

    public final Object getAllEventTaskRecords(long r10, long r12, int r14, Continuation<? super List<? extends EventTaskRecord>> r15) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r16 = new SafeContinuation(IntrinsicsKt.intercepted(r9));
        INSTANCE.callOrAddPendingCall(new j(r16, r10, r12, r14));
        Object r11 = r16.getOrThrow();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L5:
        return r11;
    }

    public final Object getAllEventTasks(Continuation<? super List<? extends EventTask>> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new k(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final Object getAllTimerTaskRecords(long r9, long r11, Continuation<? super List<TimerTaskRecord>> r13) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r14 = new SafeContinuation(IntrinsicsKt.intercepted(r8));
        INSTANCE.callOrAddPendingCall(new l(r14, r9, r11));
        Object r10 = r14.getOrThrow();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L5:
        return r10;
    }

    public final Object getAllTimerTasks(Continuation<? super List<TimerTask>> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new m(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final boolean getApiInitialized$eventstaskkit_release() {
        return apiInitialized;
    }

    public final Object getAssistantSessionState(Continuation<? super Integer> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new n(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final Object getAssistantTtsPlayingState(Continuation<? super Integer> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new o(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final Object getConditionTask(String r3, Continuation<? super ConditionTask> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new p(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object getConditionTaskRecordsByTaskId(long r10, long r12, String r14, Continuation<? super List<ConditionTaskRecord>> r15) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r16 = new SafeContinuation(IntrinsicsKt.intercepted(r9));
        INSTANCE.callOrAddPendingCall(new q(r16, r10, r12, r14));
        Object r11 = r16.getOrThrow();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L5:
        return r11;
    }

    public final Object getEventTask(String r3, Continuation<? super EventTask> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new r(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object getEventTaskExecutionDetailRecordById(long r3, Continuation<? super EventTaskExecutionDetailRecord> r5) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new s(r6, r3));
        Object r4 = r6.getOrThrow();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r4;
    }

    public final Object getEventTaskExecutionDetailRecords(int r3, int r4, Continuation<? super List<EventTaskExecutionDetailRecord>> r5) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new t(r6, r3, r4));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r7;
    }

    public final Object getEventTaskExecutionDetailRecordsByTaskId(String r3, int r4, int r5, Continuation<? super List<EventTaskExecutionDetailRecord>> r6) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new u(r7, r3, r4, r5));
        Object r8 = r7.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r8;
    }

    public final Object getEventTaskExecutionRecordById(long r3, Continuation<? super EventTaskExecutionRecord> r5) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new v(r6, r3));
        Object r4 = r6.getOrThrow();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r4;
    }

    public final Object getEventTaskExecutionRecords(int r3, int r4, Continuation<? super List<EventTaskExecutionRecord>> r5) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new w(r6, r3, r4));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r7;
    }

    public final Object getEventTaskExecutionRecordsByTaskId(String r3, int r4, int r5, Continuation<? super List<EventTaskExecutionRecord>> r6) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new x(r7, r3, r4, r5));
        Object r8 = r7.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r8;
    }

    public final Object getEventTaskRecordsByTaskId(long r10, long r12, String r14, Continuation<? super List<? extends EventTaskRecord>> r15) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r16 = new SafeContinuation(IntrinsicsKt.intercepted(r9));
        INSTANCE.callOrAddPendingCall(new y(r16, r10, r12, r14));
        Object r11 = r16.getOrThrow();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L5:
        return r11;
    }

    public final Object getEventTasksByType(int r3, int r4, int r5, Continuation<? super List<? extends EventTask>> r6) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new z(r7, r3, r4, r5));
        Object r8 = r7.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r8;
    }

    public final Object getKnowledgeSessionIdNotNullEventTasks(Continuation<? super List<? extends EventTask>> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new a0(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final Object getNextScheduleTimeStamp(String r3, Continuation<? super Long> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new b0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object getShortInstructNotNullShortcutTasks(Continuation<? super List<ShortcutTask>> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new c0(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final Object getTemplateIdNotNullEventTasks(Continuation<? super List<? extends EventTask>> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new d0(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final Object getTimerTaskByTaskId(String r3, Continuation<? super TimerTask> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new e0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object getTimerTaskRecordsByTaskId(long r10, long r12, String r14, Continuation<? super List<TimerTaskRecord>> r15) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r16 = new SafeContinuation(IntrinsicsKt.intercepted(r9));
        INSTANCE.callOrAddPendingCall(new f0(r16, r10, r12, r14));
        Object r11 = r16.getOrThrow();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L5:
        return r11;
    }

    public final void notifyAssistantState(boolean r2, StateInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "stateInfo");
        callOrAddPendingCall(new g0(r2, r3));
    }

    public final void onApiInitComplete$eventstaskkit_release() {
        apiInitialized = true;
        execPendingCalls();
    }

    public final void onConnectionClosed$eventstaskkit_release() {
        Iterator<T> r4 = connectionListeners.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        ((Function0) ZeusTransformUtils.preCheckCast(r4.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();     // Catch: Throwable -> L8
        Object r2 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r2);
        if (r3 == null) goto L4;
        Logger.INSTANCE.e(TAG, "connectionListener throw exception: " + ExceptionsKt.stackTraceToString(r3));
    L8:
        th = move-exception;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void onServiceDisconnected$eventstaskkit_release() {
        Logger.INSTANCE.i(TAG, "onServiceDisconnected");
        apiInitialized = false;
    }

    public final void openAssistantInputPanel(StateInfo r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "stateInfo");
        callOrAddPendingCall(new h0(r2, r3));
    }

    @Deprecated(message = "助手取消保活后不再依赖长连接监听推送，建议改用 getAssistantSessionState() 按需查询")
    public final void registerAssistantSessionState(com.obric.eventkit.eventstaskmanager.c r3) {
        com.obric.eventkit.eventstaskmanager.c r4 = (com.obric.eventkit.eventstaskmanager.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new i0(r4));
    }

    @Deprecated(message = "助手取消保活后不再依赖长连接监听推送，建议改用 getAssistantTtsPlayingState() 按需查询")
    public final void registerAssistantTtsPlayingState(com.obric.eventkit.eventstaskmanager.d r3) {
        com.obric.eventkit.eventstaskmanager.d r4 = (com.obric.eventkit.eventstaskmanager.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new j0(r4));
    }

    public final void registerEventTaskChangeListener(com.obric.eventkit.eventstaskmanager.f r3) {
        com.obric.eventkit.eventstaskmanager.f r4 = (com.obric.eventkit.eventstaskmanager.f) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new k0(r4));
    }

    public final void registerEventTaskScheduleListener(com.obric.eventkit.eventstaskmanager.g r3) {
        com.obric.eventkit.eventstaskmanager.g r4 = (com.obric.eventkit.eventstaskmanager.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new l0(r4));
    }

    @Deprecated(message = "use registerEventTaskChangeListener instead")
    public final void registerTimerTaskChangeListener(com.obric.eventkit.eventstaskmanager.i r3) {
        com.obric.eventkit.eventstaskmanager.i r4 = (com.obric.eventkit.eventstaskmanager.i) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.i.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new m0(r4));
    }

    public final Object removeAllConditionTaskRecords(Continuation<? super Integer> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new n0(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final Object removeAllEventTaskRecords(int r3, Continuation<? super Integer> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new o0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object removeAllTimeTaskRecords(Continuation<? super Integer> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new p0(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final Object removeConditionTask(String[] r3, Continuation<? super ConditionTaskResult> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new q0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object removeConditionTaskRecordsById(long[] r3, Continuation<? super Integer> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new r0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object removeEventTask(String[] r3, Continuation<? super EventTaskResult> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new s0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionDetailRecordsById(long[] r3, Continuation<? super Integer> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new t0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionDetailRecordsByTaskId(String r3, Continuation<? super Integer> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new u0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionRecordsById(long[] r3, Continuation<? super Integer> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new v0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionRecordsByTaskId(String r3, Continuation<? super Integer> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new w0(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskRecordsById(int r3, long[] r4, Continuation<? super Integer> r5) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new x0(r6, r3, r4));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r7;
    }

    public final Object removeTimerTask(Map<String, ? extends Object> r3, Continuation<? super TimerTaskResult> r4) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new y0(r6, r2));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r7;
    }

    public final Object removeTimerTaskRecordsById(List<Integer> r3, Continuation<? super Integer> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new z0(r6, r2));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r7;
    }

    public final Object removeTimerTasksByTaskId(List<String> r3, Continuation<? super TimerTaskResult> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new a1(r6, r2));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r7;
    }

    public final void requestSendMessage(String r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r4, MemoryInfoSectionEditActivity.KIND_SCENE);
        callOrAddPendingCall(new b1(r3, r4, r6));
    }

    public final void scheduleShortcutTask(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        callOrAddPendingCall(new c1(r2, r3));
    }

    public final void setApiInitialized$eventstaskkit_release(boolean r2) {
        apiInitialized = r2;
    }

    public final void setAssistantInteractionListener(com.obric.eventkit.eventstaskmanager.b r3) {
        com.obric.eventkit.eventstaskmanager.b r4 = (com.obric.eventkit.eventstaskmanager.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new d1(r4));
    }

    @Deprecated(message = "not recommend", replaceWith = @ReplaceWith(expression = "addEventBinderListener", imports = {}))
    public final void setBinderDiedCallback(Function0<Unit> r2) {
        Function0<Unit> r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "func");
        binderDiedCallback = r3;
    }

    public final void setPendingCallsExecuted$eventstaskkit_release(boolean r2) {
        List<a> r3 = mPendingCals;
        monitor-enter(r3);
        mPendingCallsExecuted = r2;     // Catch: Throwable -> L7
        monitor-exit(r3);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void skipConditionTaskSchedule(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        callOrAddPendingCall(new e1(r2));
    }

    public final Object skipTimerTasksByTaskId(String r3, List<Long> r4, Continuation<? super TimerTaskResult> r5) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        INSTANCE.callOrAddPendingCall(new f1(r7, r3, r2));
        Object r8 = r7.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r8;
    }

    public final Object tryActiveAgent(ActiveAgentEvent r3, Continuation<? super Boolean> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new g1(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object tryInterruptAssistant(AppEvent r3, Continuation<? super Boolean> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new h1(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object tryOpenMicToRecording(AppEvent r3, Continuation<? super Boolean> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new i1(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object tryScheduleConditionTask(String r9, List<ConditionTaskAction> r10, TaskKnowledge r11, int r12, String r13, Continuation<? super Unit> r14) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r15 = new SafeContinuation(IntrinsicsKt.intercepted(r8));
        INSTANCE.callOrAddPendingCall(new j1(r15, r9, r4, r11, r12, r13));
        Object r16 = r15.getOrThrow();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L6:
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r16;
    L9:
        return Unit.INSTANCE;
    }

    @Deprecated(message = "助手取消保活后不再依赖长连接监听推送，建议改用 getAssistantSessionState() 按需查询")
    public final void unRegisterAssistantSessionState(com.obric.eventkit.eventstaskmanager.c r3) {
        com.obric.eventkit.eventstaskmanager.c r4 = (com.obric.eventkit.eventstaskmanager.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new k1(r4));
    }

    @Deprecated(message = "助手取消保活后不再依赖长连接监听推送，建议改用 getAssistantTtsPlayingState() 按需查询")
    public final void unRegisterAssistantTtsPlayingState(com.obric.eventkit.eventstaskmanager.d r3) {
        com.obric.eventkit.eventstaskmanager.d r4 = (com.obric.eventkit.eventstaskmanager.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new l1(r4));
    }

    public final void unregisterEventTaskChangeListener(com.obric.eventkit.eventstaskmanager.f r3) {
        com.obric.eventkit.eventstaskmanager.f r4 = (com.obric.eventkit.eventstaskmanager.f) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new m1(r4));
    }

    public final void unregisterEventTaskScheduleListener(com.obric.eventkit.eventstaskmanager.g r3) {
        com.obric.eventkit.eventstaskmanager.g r4 = (com.obric.eventkit.eventstaskmanager.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new n1(r4));
    }

    @Deprecated(message = "use unregisterEventTaskChangeListener instead")
    public final void unregisterTimerTaskChangeListener(com.obric.eventkit.eventstaskmanager.i r3) {
        com.obric.eventkit.eventstaskmanager.i r4 = (com.obric.eventkit.eventstaskmanager.i) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.eventstaskmanager.i.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        callOrAddPendingCall(new o1(r4));
    }

    public final Object updateConditionTask(String r15, List<ConditionTaskAction> r16, String r17, ConditionGroup r18, PeriodicPolicy r19, TriggerControlPolicy r20, int r21, Map<String, String> r22, Continuation<? super ConditionTaskResult> r23) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r3 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new p1(r3, r15, r5, r17, r18, r19, r20, r21, r11));
        Object r4 = r3.getOrThrow();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r4;
    }

    public final Object updateEventTask(String r3, EventTaskSpec r4, Continuation<? super EventTaskResult> r5) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new q1(r6, r3, r4));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r7;
    }

    public final Object updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r3, Continuation<? super EventTaskExecutionDetailRecord> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new r1(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r3, Continuation<? super Integer> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new s1(r6, r2));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r7;
    }

    public final Object updateEventTaskExecutionRecord(EventTaskExecutionRecord r3, Continuation<? super EventTaskExecutionRecord> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new t1(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }

    public final Object updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r3, Continuation<? super Integer> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new u1(r6, r2));
        Object r7 = r6.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r7;
    }

    public final Object updateTimerTask(TimerTask r3, Continuation<? super TimerTaskResult> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new v1(r5, r3));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r6;
    }
}
