package com.obric.eventkit;

import android.app.Application;
import android.content.Context;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
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
import com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener;
import com.obric.eventkit.eventstaskmanager.IAssistantSessionStateListener;
import com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener;
import com.obric.eventkit.eventstaskmanager.IEventBinderListener;
import com.obric.eventkit.eventstaskmanager.IEventTaskChangeListener;
import com.obric.eventkit.eventstaskmanager.IEventTaskScheduleListener;
import com.obric.eventkit.eventstaskmanager.ITimerTaskChangeListener;
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
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import yja.b;
import yja.c;
import zja.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004Ú\u0001Û\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u000e\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u0016J\u001b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J'\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010 2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J'\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010 2\f\u00107\u001a\b\u0012\u0004\u0012\u00020:0 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J\u0010\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u001aH\u0002J\u001b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\r\u0010B\u001a\u00020\u000fH\u0000¢\u0006\u0002\bCJ\u0016\u0010D\u001a\u00020\u000f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0006\u0010F\u001a\u00020\u000fJ\b\u0010G\u001a\u00020\u000fH\u0002J+\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010I\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010MJ1\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010P\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010RJ\u0019\u0010S\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ)\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010MJ\u0019\u0010X\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\b\u0010Y\u001a\u00020ZH\u0002J\u0013\u0010[\u001a\u0004\u0018\u00010QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0013\u0010\\\u001a\u0004\u0018\u00010QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J3\u0010a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010I\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010bJ\u001b\u0010c\u001a\u0004\u0018\u00010T2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u001b\u0010d\u001a\u0004\u0018\u0001062\u0006\u0010e\u001a\u00020KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010fJ)\u0010g\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010 2\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010jJ1\u0010k\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010 2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010lJ\u001b\u0010m\u001a\u0004\u0018\u00010:2\u0006\u0010e\u001a\u00020KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010fJ)\u0010n\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010 2\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010jJ1\u0010o\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010 2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010lJ1\u0010p\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010bJ1\u0010q\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010 2\u0006\u0010P\u001a\u00020Q2\u0006\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010rJ\u0019\u0010s\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010t\u001a\u0004\u0018\u00010K2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u0019\u0010u\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0019\u0010w\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010x\u001a\u0004\u0018\u00010@2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J3\u0010y\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010W\u0018\u00010 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010bJ\u0010\u0010z\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0007J\u0016\u0010{\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\b2\u0006\u0010}\u001a\u00020~J\u000e\u0010\u007f\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0080\u0001J\u000f\u0010\u0081\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0084\u0001J\u0018\u0010\u0085\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u0086\u0001\u001a\u00020\bJ\u0012\u0010\u0087\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u0088\u0001H\u0007J\u0012\u0010\u0089\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008a\u0001H\u0007J\u0010\u0010\u008b\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008c\u0001J\u0010\u0010\u008d\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008e\u0001J\u0012\u0010\u008f\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u0090\u0001H\u0007J\u0012\u0010\u0091\u0001\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010\u0092\u0001\u001a\u00020Q2\u0006\u0010P\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0093\u0001J\u0014\u0010\u0094\u0001\u001a\u0004\u0018\u00010QH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ%\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001e2\u000e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u0097\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0098\u0001J\u001c\u0010\u0099\u0001\u001a\u00020Q2\u0007\u0010e\u001a\u00030\u009a\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001J\u0017\u0010\u009c\u0001\u001a\u00020\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J%\u0010\u009d\u0001\u001a\u0004\u0018\u0001012\u000e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u0097\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0098\u0001J\u001c\u0010\u009e\u0001\u001a\u00020Q2\u0007\u0010e\u001a\u00030\u009a\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001J\u001a\u0010\u009f\u0001\u001a\u00020Q2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u001c\u0010 \u0001\u001a\u00020Q2\u0007\u0010e\u001a\u00030\u009a\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001J\u001a\u0010¡\u0001\u001a\u00020Q2\u0006\u0010_\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J$\u0010¢\u0001\u001a\u00020Q2\u0006\u0010P\u001a\u00020Q2\u0007\u0010e\u001a\u00030\u009a\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010£\u0001J*\u0010¤\u0001\u001a\u0004\u0018\u00010>2\u0013\u0010¥\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010*H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010¦\u0001J\"\u0010§\u0001\u001a\u0004\u0018\u00010Q2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020Q0 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J\"\u0010¨\u0001\u001a\u0004\u0018\u00010>2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J/\u0010©\u0001\u001a\u00020\u000f2\u0007\u0010ª\u0001\u001a\u00020\u00042\u0007\u0010«\u0001\u001a\u00020\u00042\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010*J\u001c\u0010¬\u0001\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020\u00042\u000b\b\u0002\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0004J\u0010\u0010®\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030¯\u0001J\u0017\u0010°\u0001\u001a\u00020\u000f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u0013\u0010±\u0001\u001a\u00020\u000f2\b\u0010²\u0001\u001a\u00030³\u0001H\u0007J\u0018\u0010´\u0001\u001a\u00020\u000f2\u0007\u0010µ\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\b¶\u0001J\u000f\u0010·\u0001\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020\u0004J,\u0010¸\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010_\u001a\u00020\u00042\r\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020K0 H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010º\u0001J\u001f\u0010»\u0001\u001a\u0004\u0018\u00010\b2\b\u0010¼\u0001\u001a\u00030½\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010¾\u0001J\u001f\u0010¿\u0001\u001a\u0004\u0018\u00010\b2\b\u0010¼\u0001\u001a\u00030À\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Á\u0001J\u001f\u0010Â\u0001\u001a\u0004\u0018\u00010\b2\b\u0010¼\u0001\u001a\u00030À\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Á\u0001JM\u0010Ã\u0001\u001a\u00020\u000f2\b\u0010_\u001a\u0004\u0018\u00010\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u00012\u0007\u0010Æ\u0001\u001a\u00020Q2\u000b\b\u0002\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Ç\u0001J\u0012\u0010È\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u0088\u0001H\u0007J\u0012\u0010É\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008a\u0001H\u0007J\u0010\u0010Ê\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008c\u0001J\u0010\u0010Ë\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u008e\u0001J\u0012\u0010Ì\u0001\u001a\u00020\u000f2\u0007\u0010-\u001a\u00030\u0090\u0001H\u0007J\u0082\u0001\u0010Í\u0001\u001a\u0004\u0018\u00010\u001e2\u0006\u0010_\u001a\u00020\u00042\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\t\b\u0002\u0010Î\u0001\u001a\u00020Q2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010*H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Ï\u0001J%\u0010Ð\u0001\u001a\u0004\u0018\u0001012\u0006\u0010_\u001a\u00020\u00042\u0006\u00102\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Ñ\u0001J\u001e\u0010Ò\u0001\u001a\u0004\u0018\u0001062\u0007\u0010Ó\u0001\u001a\u000206H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010Ô\u0001J \u0010Õ\u0001\u001a\u00020Q2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J\u001e\u0010Ö\u0001\u001a\u0004\u0018\u00010:2\u0007\u0010Ó\u0001\u001a\u00020:H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010×\u0001J \u0010Ø\u0001\u001a\u00020Q2\f\u00107\u001a\b\u0012\u0004\u0012\u00020:0 H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J\u001c\u0010Ù\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Ü\u0001"}, d2 = {"Lcom/obric/eventkit/EventsTaskSdk;", "", "()V", "TAG", "", "_config", "Lcom/obric/eventkit/EventsTaskSdk$InitConfig;", "apiInitialized", "", "getApiInitialized$eventstaskkit_release", "()Z", "setApiInitialized$eventstaskkit_release", "(Z)V", "binderDiedCallback", "Lkotlin/Function0;", "", "config", "getConfig", "()Lcom/obric/eventkit/EventsTaskSdk$InitConfig;", "connectionListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mBinderDiedListener", "Lcom/obric/eventkit/eventstaskmanager/IEventBinderListener;", "mPendingCallsExecuted", "mPendingCals", "", "Lcom/obric/eventkit/EventsTaskSdk$ApiCall;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "actions", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", DBDefinition.NAME, "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "ext", "", "(Ljava/util/List;Ljava/lang/String;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addConnectionListener", "listener", "addEventBinderListener", "bl", "addEventTask", "Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "spec", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "(Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addEventTaskExecutionDetailRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;", "records", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addEventTaskExecutionRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;", "addPendingCall", "call", "addTimerTask", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskResult;", "task", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "(Lcom/obric/eventkit/eventstaskmanager/TimerTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "binderDied", "binderDied$eventstaskkit_release", "callOrAddPendingCall", "func", "closeAssistantInputPanel", "execPendingCalls", "getAllConditionTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskRecord;", "startTime", "", "endTime", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEventTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", EffectConfiguration.KEY_TYPE, "", "(JJILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEventTasks", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTimerTaskRecords", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "getAllTimerTasks", "getApi", "Lcom/obric/eventkit/IEventProxy;", "getAssistantSessionState", "getAssistantTtsPlayingState", "getConditionTask", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", DBDefinition.TASK_ID, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConditionTaskRecordsByTaskId", "(JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventTask", "getEventTaskExecutionDetailRecordById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventTaskExecutionDetailRecords", "offset", "size", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventTaskExecutionDetailRecordsByTaskId", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventTaskExecutionRecordById", "getEventTaskExecutionRecords", "getEventTaskExecutionRecordsByTaskId", "getEventTaskRecordsByTaskId", "getEventTasksByType", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKnowledgeSessionIdNotNullEventTasks", "getNextScheduleTimeStamp", "getShortInstructNotNullShortcutTasks", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "getTemplateIdNotNullEventTasks", "getTimerTaskByTaskId", "getTimerTaskRecordsByTaskId", "init", "notifyAssistantState", "enter", "stateInfo", "Lcom/obric/eventkit/eventstaskmanager/StateInfo;", "onApiInitComplete", "onApiInitComplete$eventstaskkit_release", "onConnectionClosed", "onConnectionClosed$eventstaskkit_release", "onServiceDisconnected", "onServiceDisconnected$eventstaskkit_release", "openAssistantInputPanel", DBDefinition.FORCE, "registerAssistantSessionState", "Lcom/obric/eventkit/eventstaskmanager/IAssistantSessionStateListener;", "registerAssistantTtsPlayingState", "Lcom/obric/eventkit/eventstaskmanager/IAssistantTtsStateListener;", "registerEventTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskChangeListener;", "registerEventTaskScheduleListener", "Lcom/obric/eventkit/eventstaskmanager/IEventTaskScheduleListener;", "registerTimerTaskChangeListener", "Lcom/obric/eventkit/eventstaskmanager/ITimerTaskChangeListener;", "removeAllConditionTaskRecords", "removeAllEventTaskRecords", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAllTimeTaskRecords", "removeConditionTask", "taskIds", "", "([Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeConditionTaskRecordsById", "", "([JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeConnectionListener", "removeEventTask", "removeEventTaskExecutionDetailRecordsById", "removeEventTaskExecutionDetailRecordsByTaskId", "removeEventTaskExecutionRecordsById", "removeEventTaskExecutionRecordsByTaskId", "removeEventTaskRecordsById", "(I[JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTimerTask", "parameters", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTimerTaskRecordsById", "removeTimerTasksByTaskId", "requestSendMessage", "content", "scene", "scheduleShortcutTask", "source", "setAssistantInteractionListener", "Lcom/obric/eventkit/eventstaskmanager/IAssistantInteractionListener;", "setBinderDiedCallback", "setLogger", "logger", "Lcom/obric/eventkit/logger/ILogger;", "setPendingCallsExecuted", "isExecuted", "setPendingCallsExecuted$eventstaskkit_release", "skipConditionTaskSchedule", "skipTimerTasksByTaskId", "timeStamp", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryActiveAgent", "event", "Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;", "(Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryInterruptAssistant", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "(Lcom/obric/eventkit/eventstaskmanager/AppEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryOpenMicToRecording", "tryScheduleConditionTask", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskMode", "(Ljava/lang/String;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unRegisterAssistantSessionState", "unRegisterAssistantTtsPlayingState", "unregisterEventTaskChangeListener", "unregisterEventTaskScheduleListener", "unregisterTimerTaskChangeListener", "updateConditionTask", "enableStatus", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;ILjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventTask", "(Ljava/lang/String;Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventTaskExecutionDetailRecord", "record", "(Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventTaskExecutionDetailRecords", "updateEventTaskExecutionRecord", "(Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventTaskExecutionRecords", "updateTimerTask", "ApiCall", "InitConfig", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventsTaskSdk {
    public static final EventsTaskSdk INSTANCE = null;
    private static final String TAG = "EventsTaskSdk";
    private static InitConfig _config;
    private static boolean apiInitialized;
    private static Function0<Unit> binderDiedCallback;
    private static final CopyOnWriteArraySet<Function0<Unit>> connectionListeners = null;
    private static CopyOnWriteArraySet<IEventBinderListener> mBinderDiedListener;
    private static boolean mPendingCallsExecuted;
    private static final List<a> mPendingCals = null;
    private static final CoroutineScope scope = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/eventkit/EventsTaskSdk$InitConfig;", "", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApp", "()Landroid/app/Application;", "component1", "copy", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InitConfig {
        private final Application app;

        public InitConfig(Application r2) {
            Intrinsics.checkNotNullParameter(r2, "app");
            this.app = r2;
        }

        public static /* synthetic */ InitConfig copy$default(InitConfig r0, Application r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.app;
        L6:
            return r0.copy(r1);
        }

        public final Application component1() {
            return this.app;
        }

        public final InitConfig copy(Application r2) {
            Intrinsics.checkNotNullParameter(r2, "app");
            return new InitConfig(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof InitConfig) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.app, ((InitConfig) r4).app) == true) goto L11;
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

    static {
        INSTANCE = new EventsTaskSdk();
        scope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new b())));
        mPendingCals = new ArrayList();
        connectionListeners = new CopyOnWriteArraySet();
        mBinderDiedListener = new CopyOnWriteArraySet();
    }

    private EventsTaskSdk() {
    }

    public static /* synthetic */ Thread a(Runnable r0) {
        return scope$lambda$0(r0);
    }

    public static final /* synthetic */ IEventProxy access$getApi(EventsTaskSdk r0) {
        return r0.getApi();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object addConditionTask$default(EventsTaskSdk r9, List r10, String r11, ConditionGroup r12, PeriodicPolicy r13, TriggerControlPolicy r14, Map r15, Continuation r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L5;
        Map r7 = null;
    L7:
        return r9.addConditionTask(r10, r11, r12, r13, r14, r7, r16);
    L5:
        r7 = r15;
        goto L7
    }

    @JvmStatic
    public static final void addConnectionListener(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        connectionListeners.add(r1);
    }

    private static final void addEventBinderListener$lambda$26(IEventBinderListener r1) {
        Intrinsics.checkNotNullParameter(r1, "$bl");
        mBinderDiedListener.remove(r1);
    }

    private final void addPendingCall(a r5) {
        Logger r0 = Logger.INSTANCE;
        r0.d(TAG, "addPendingCall");
        List<a> r1 = mPendingCals;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mPendingCallsExecuted == false) goto L7;
        r0.w(TAG, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L10
        r5.a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r1);
        return;
    L7:
        r1.add(r5);     // Catch: Throwable -> L10
        goto L8
    }

    public static /* synthetic */ void b(IEventBinderListener r0) {
        addEventBinderListener$lambda$26(r0);
    }

    private final void callOrAddPendingCall(Function0<Unit> r3) {
        if (Intrinsics.areEqual(getApi(), EmptyEventProxy.INSTANCE) == true) goto L5;
        r3.invoke();
        return;
    L5:
        addPendingCall(new g(r3));
    }

    private final void execPendingCalls() {
        Logger.INSTANCE.d(TAG, "execPendingCalls");
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        a r2 = (a) r1.next();     // Catch: Throwable -> L11
        Logger.INSTANCE.d(TAG, "exec foreach call");     // Catch: Throwable -> L11
        r2.a();     // Catch: Throwable -> L11
        goto L6
    L8:
        mPendingCals.clear();     // Catch: Throwable -> L11
        mPendingCallsExecuted = true;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final IEventProxy getApi() {
        return EventServiceConnection.INSTANCE.getApi$eventstaskkit_release();
    }

    private final InitConfig getConfig() {
        InitConfig r0 = _config;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new RuntimeException("you need to invoke EventsTaskSdk.init!");
    }

    @JvmStatic
    public static final void removeConnectionListener(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        connectionListeners.remove(r1);
    }

    public static /* synthetic */ void scheduleShortcutTask$default(EventsTaskSdk r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.scheduleShortcutTask(r1, r2);
    }

    private static final Thread scope$lambda$0(Runnable r2) {
        return new PthreadThreadV2(r2, "events-task-schedule");
    }

    @JvmStatic
    public static final void setLogger(ILogger r2) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        Logger r0 = Logger.INSTANCE;
        r0.setLogger(r2);
        r0.i(TAG, "EventsTaskSdk setLogger");
    }

    public static /* synthetic */ Object tryScheduleConditionTask$default(EventsTaskSdk r7, String r8, List r9, TaskKnowledge r10, int r11, String r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L6;
        r12 = null;
    L6:
        return r7.tryScheduleConditionTask(r8, r9, r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object updateConditionTask$default(EventsTaskSdk r13, String r14, List r15, String r16, ConditionGroup r17, PeriodicPolicy r18, TriggerControlPolicy r19, int r20, Map r21, Continuation r22, int r23, Object r24) {
        if ((r23 & 2) == 0) goto L5;
        List r5 = null;
    L7:
        if ((r23 & 4) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r23 & 8) == 0) goto L13;
        ConditionGroup r7 = null;
    L15:
        if ((r23 & 16) == 0) goto L17;
        PeriodicPolicy r8 = null;
    L19:
        if ((r23 & 32) == 0) goto L21;
        TriggerControlPolicy r9 = null;
    L23:
        if ((r23 & 64) == 0) goto L25;
        int r10 = -1;
    L27:
        if ((r23 & 128) == 0) goto L29;
        Map r11 = null;
    L31:
        return r13.updateConditionTask(r14, r5, r6, r7, r8, r9, r10, r11, r22);
    L29:
        r11 = r21;
        goto L31
    L25:
        r10 = r20;
        goto L27
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    public final Object addConditionTask(List<ConditionTaskAction> r12, String r13, ConditionGroup r14, PeriodicPolicy r15, TriggerControlPolicy r16, Map<String, String> r17, Continuation<? super ConditionTaskResult> r18) {
        SafeContinuation r8 = new SafeContinuation(IntrinsicsKt.intercepted(r18));
        INSTANCE.callOrAddPendingCall(new b(r8, r12, r13, r14, r15, r16, r17));
        Object r0 = r8.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r18);
    L5:
        return r0;
    }

    public final void addEventBinderListener(IEventBinderListener r4) {
        Intrinsics.checkNotNullParameter(r4, "bl");
        r4.asBinder().linkToDeath(new c(r4), 0);
        mBinderDiedListener.add(r4);
    }

    public final Object addEventTask(EventTaskSpec r4, Continuation<? super EventTaskResult> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new c(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r4, Continuation<? super List<EventTaskExecutionDetailRecord>> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new d(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r4, Continuation<? super List<EventTaskExecutionRecord>> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new e(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object addTimerTask(TimerTask r4, Continuation<? super TimerTaskResult> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new f(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final void binderDied$eventstaskkit_release() {
        Logger.INSTANCE.i(TAG, "binderDied");
        apiInitialized = false;
        setPendingCallsExecuted$eventstaskkit_release(false);
        Function0<Unit> r0 = binderDiedCallback;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        Iterator<T> r1 = mBinderDiedListener.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((IEventBinderListener) r1.next()).onBinderDied();
        goto L7
    }

    public final void closeAssistantInputPanel() {
        callOrAddPendingCall(h.a);
    }

    public final Object getAllConditionTaskRecords(long r10, long r12, Continuation<? super List<ConditionTaskRecord>> r14) {
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r14));
        INSTANCE.callOrAddPendingCall(new i(r6, r10, r12));
        Object r11 = r6.getOrThrow();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L5:
        return r11;
    }

    public final Object getAllEventTaskRecords(long r11, long r13, int r15, Continuation<? super List<? extends EventTaskRecord>> r16) {
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r16));
        INSTANCE.callOrAddPendingCall(new j(r7, r11, r13, r15));
        Object r0 = r7.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r16);
    L5:
        return r0;
    }

    public final Object getAllEventTasks(Continuation<? super List<? extends EventTask>> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new k(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final Object getAllTimerTaskRecords(long r10, long r12, Continuation<? super List<TimerTaskRecord>> r14) {
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r14));
        INSTANCE.callOrAddPendingCall(new l(r6, r10, r12));
        Object r11 = r6.getOrThrow();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L5:
        return r11;
    }

    public final Object getAllTimerTasks(Continuation<? super List<TimerTask>> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new m(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final boolean getApiInitialized$eventstaskkit_release() {
        return apiInitialized;
    }

    public final Object getAssistantSessionState(Continuation<? super Integer> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new n(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final Object getAssistantTtsPlayingState(Continuation<? super Integer> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new o(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final Object getConditionTask(String r4, Continuation<? super ConditionTask> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new p(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object getConditionTaskRecordsByTaskId(long r11, long r13, String r15, Continuation<? super List<ConditionTaskRecord>> r16) {
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r16));
        INSTANCE.callOrAddPendingCall(new q(r7, r11, r13, r15));
        Object r0 = r7.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r16);
    L5:
        return r0;
    }

    public final Object getEventTask(String r4, Continuation<? super EventTask> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new r(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object getEventTaskExecutionDetailRecordById(long r4, Continuation<? super EventTaskExecutionDetailRecord> r6) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        INSTANCE.callOrAddPendingCall(new s(r0, r4));
        Object r5 = r0.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r5;
    }

    public final Object getEventTaskExecutionDetailRecords(int r4, int r5, Continuation<? super List<EventTaskExecutionDetailRecord>> r6) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        INSTANCE.callOrAddPendingCall(new t(r0, r4, r5));
        Object r7 = r0.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    public final Object getEventTaskExecutionDetailRecordsByTaskId(String r4, int r5, int r6, Continuation<? super List<EventTaskExecutionDetailRecord>> r7) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r7));
        INSTANCE.callOrAddPendingCall(new u(r0, r4, r5, r6));
        Object r8 = r0.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r8;
    }

    public final Object getEventTaskExecutionRecordById(long r4, Continuation<? super EventTaskExecutionRecord> r6) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        INSTANCE.callOrAddPendingCall(new v(r0, r4));
        Object r5 = r0.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r5;
    }

    public final Object getEventTaskExecutionRecords(int r4, int r5, Continuation<? super List<EventTaskExecutionRecord>> r6) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        INSTANCE.callOrAddPendingCall(new w(r0, r4, r5));
        Object r7 = r0.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    public final Object getEventTaskExecutionRecordsByTaskId(String r4, int r5, int r6, Continuation<? super List<EventTaskExecutionRecord>> r7) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r7));
        INSTANCE.callOrAddPendingCall(new x(r0, r4, r5, r6));
        Object r8 = r0.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r8;
    }

    public final Object getEventTaskRecordsByTaskId(long r11, long r13, String r15, Continuation<? super List<? extends EventTaskRecord>> r16) {
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r16));
        INSTANCE.callOrAddPendingCall(new y(r7, r11, r13, r15));
        Object r0 = r7.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r16);
    L5:
        return r0;
    }

    public final Object getEventTasksByType(int r4, int r5, int r6, Continuation<? super List<? extends EventTask>> r7) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r7));
        INSTANCE.callOrAddPendingCall(new z(r0, r4, r5, r6));
        Object r8 = r0.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r8;
    }

    public final Object getKnowledgeSessionIdNotNullEventTasks(Continuation<? super List<? extends EventTask>> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new a0(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final Object getNextScheduleTimeStamp(String r4, Continuation<? super Long> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new b0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object getShortInstructNotNullShortcutTasks(Continuation<? super List<ShortcutTask>> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new c0(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final Object getTemplateIdNotNullEventTasks(Continuation<? super List<? extends EventTask>> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new d0(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final Object getTimerTaskByTaskId(String r4, Continuation<? super TimerTask> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new e0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object getTimerTaskRecordsByTaskId(long r11, long r13, String r15, Continuation<? super List<TimerTaskRecord>> r16) {
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r16));
        INSTANCE.callOrAddPendingCall(new f0(r7, r11, r13, r15));
        Object r0 = r7.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r16);
    L5:
        return r0;
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
        Iterator<T> r0 = connectionListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ((Function0) r0.next()).invoke();     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L4;
        Logger.INSTANCE.e(TAG, "connectionListener throw exception: " + ExceptionsKt.stackTraceToString(r2));
    L8:
        th = move-exception;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
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
    public final void registerAssistantSessionState(IAssistantSessionStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new i0(r2));
    }

    @Deprecated(message = "助手取消保活后不再依赖长连接监听推送，建议改用 getAssistantTtsPlayingState() 按需查询")
    public final void registerAssistantTtsPlayingState(IAssistantTtsStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new j0(r2));
    }

    public final void registerEventTaskChangeListener(IEventTaskChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new k0(r2));
    }

    public final void registerEventTaskScheduleListener(IEventTaskScheduleListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new l0(r2));
    }

    @Deprecated(message = "use registerEventTaskChangeListener instead")
    public final void registerTimerTaskChangeListener(ITimerTaskChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new m0(r2));
    }

    public final Object removeAllConditionTaskRecords(Continuation<? super Integer> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new n0(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final Object removeAllEventTaskRecords(int r4, Continuation<? super Integer> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new o0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeAllTimeTaskRecords(Continuation<? super Integer> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new p0(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final Object removeConditionTask(String[] r4, Continuation<? super ConditionTaskResult> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new q0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeConditionTaskRecordsById(long[] r4, Continuation<? super Integer> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new r0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeEventTask(String[] r4, Continuation<? super EventTaskResult> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new s0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionDetailRecordsById(long[] r4, Continuation<? super Integer> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new t0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionDetailRecordsByTaskId(String r4, Continuation<? super Integer> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new u0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionRecordsById(long[] r4, Continuation<? super Integer> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new v0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionRecordsByTaskId(String r4, Continuation<? super Integer> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new w0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeEventTaskRecordsById(int r4, long[] r5, Continuation<? super Integer> r6) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        INSTANCE.callOrAddPendingCall(new x0(r0, r4, r5));
        Object r7 = r0.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    public final Object removeTimerTask(Map<String, ? extends Object> r4, Continuation<? super TimerTaskResult> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new y0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeTimerTaskRecordsById(List<Integer> r4, Continuation<? super Integer> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new z0(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object removeTimerTasksByTaskId(List<String> r4, Continuation<? super TimerTaskResult> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new a1(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final void requestSendMessage(String r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "scene");
        callOrAddPendingCall(new b1(r2, r3, r4));
    }

    public final void scheduleShortcutTask(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.TASK_ID);
        callOrAddPendingCall(new c1(r2, r3));
    }

    public final void setApiInitialized$eventstaskkit_release(boolean r1) {
        apiInitialized = r1;
    }

    public final void setAssistantInteractionListener(IAssistantInteractionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new d1(r2));
    }

    @Deprecated(message = "not recommend", replaceWith = @ReplaceWith(expression = "addEventBinderListener", imports = {}))
    public final void setBinderDiedCallback(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "func");
        binderDiedCallback = r2;
    }

    public final void setPendingCallsExecuted$eventstaskkit_release(boolean r2) {
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
        mPendingCallsExecuted = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void skipConditionTaskSchedule(String r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.TASK_ID);
        callOrAddPendingCall(new e1(r2));
    }

    public final Object skipTimerTasksByTaskId(String r4, List<Long> r5, Continuation<? super TimerTaskResult> r6) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        INSTANCE.callOrAddPendingCall(new f1(r0, r4, r5));
        Object r7 = r0.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    public final Object tryActiveAgent(ActiveAgentEvent r4, Continuation<? super Boolean> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new g1(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object tryInterruptAssistant(AppEvent r4, Continuation<? super Boolean> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new h1(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object tryOpenMicToRecording(AppEvent r4, Continuation<? super Boolean> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new i1(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object tryScheduleConditionTask(String r11, List<ConditionTaskAction> r12, TaskKnowledge r13, int r14, String r15, Continuation<? super Unit> r16) {
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r16));
        INSTANCE.callOrAddPendingCall(new j1(r7, r11, r12, r13, r14, r15));
        Object r0 = r7.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r16);
    L6:
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r0;
    L9:
        return Unit.INSTANCE;
    }

    @Deprecated(message = "助手取消保活后不再依赖长连接监听推送，建议改用 getAssistantSessionState() 按需查询")
    public final void unRegisterAssistantSessionState(IAssistantSessionStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new k1(r2));
    }

    @Deprecated(message = "助手取消保活后不再依赖长连接监听推送，建议改用 getAssistantTtsPlayingState() 按需查询")
    public final void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new l1(r2));
    }

    public final void unregisterEventTaskChangeListener(IEventTaskChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new m1(r2));
    }

    public final void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new n1(r2));
    }

    @Deprecated(message = "use unregisterEventTaskChangeListener instead")
    public final void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new o1(r2));
    }

    public final Object updateConditionTask(String r14, List<ConditionTaskAction> r15, String r16, ConditionGroup r17, PeriodicPolicy r18, TriggerControlPolicy r19, int r20, Map<String, String> r21, Continuation<? super ConditionTaskResult> r22) {
        SafeContinuation r10 = new SafeContinuation(IntrinsicsKt.intercepted(r22));
        INSTANCE.callOrAddPendingCall(new p1(r10, r14, r15, r16, r17, r18, r19, r20, r21));
        Object r0 = r10.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r22);
    L5:
        return r0;
    }

    public final Object updateEventTask(String r4, EventTaskSpec r5, Continuation<? super EventTaskResult> r6) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        INSTANCE.callOrAddPendingCall(new q1(r0, r4, r5));
        Object r7 = r0.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    public final Object updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r4, Continuation<? super EventTaskExecutionDetailRecord> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new r1(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r4, Continuation<? super Integer> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new s1(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object updateEventTaskExecutionRecord(EventTaskExecutionRecord r4, Continuation<? super EventTaskExecutionRecord> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new t1(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r4, Continuation<? super Integer> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new u1(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public final Object updateTimerTask(TimerTask r4, Continuation<? super TimerTaskResult> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        INSTANCE.callOrAddPendingCall(new v1(r0, r4));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    @JvmStatic
    public static final void init(InitConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        _config = r3;
        Logger.INSTANCE.i(TAG, "EventsTaskSdk init");
        AppHost.Companion.setAppHost(new d.c(r3.getApp()));
        Context r0 = a.a;
        Application r4 = r3.getApp();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        a.a = r4;
        String r5 = r4.getPackageName();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        a.b = r5;
    }
}
