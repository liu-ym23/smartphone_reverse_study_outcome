package com.obric.aiproactive.impl;

import android.app.Application;
import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.InvalidationTracker;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.AiProactivePreferenceExampleDto;
import com.obric.aiproactive.api.AiRuleItemDto;
import com.obric.aiproactive.api.AlgorithmTaskInvokeResult;
import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.obric.aiproactive.api.ProactiveDayPageResult;
import com.obric.aiproactive.api.ProactiveInspirationDto;
import com.obric.aiproactive.api.ProactiveNowPageSnapshot;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.ProactiveSubscriptionTaskDto;
import com.obric.aiproactive.api.ProactiveUserSubscriptionDto;
import com.obric.aiproactive.api.ToggleUserSubscriptionRequest;
import com.obric.aiproactive.api.aa;
import com.obric.aiproactive.api.ac;
import com.obric.aiproactive.api.ad;
import com.obric.aiproactive.api.h;
import com.obric.aiproactive.api.j;
import com.obric.aiproactive.api.s;
import com.obric.aiproactive.api.t;
import com.obric.aiproactive.api.u;
import com.obric.aiproactive.api.v;
import com.obric.aiproactive.api.x;
import com.obric.aiproactive.api.z;
import com.obric.aiproactive.impl.aidb.AiProactiveDb;
import com.obric.aiproactive.impl.bridge.AiProactiveAgentBridgeImpl;
import com.obric.aiproactive.impl.livecard.n;
import com.obric.aiproactive.impl.runtime.ProactiveRecommendationEnabledStoreImpl;
import com.obric.aiproactive.impl.trigger.e;
import com.obric.capabilitykit.common.Ext;
import com.obric.eventkit.EventsTaskSdk;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.database.dao.ProactiveInspirationDao;
import com.obric.memorydata.database.dao.ProactiveRecommendationsDao;
import com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.et;
import com.obric.memorydata.database.entity.ey;
import com.obric.memorydata.database.entity.ez;
import com.obric.memorydata.database.entity.fc;
import com.obric.memorydata.database.entity.fd;
import com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb;
import com.obric.memorydata.memory.api.MemoryServiceApi;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ë\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001&\u0018\u0000 Ì\u00012\u00020\u0001:\u0002Ì\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\n\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020.H\u0002J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\"H\u0002J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u00020.H\u0082@¢\u0006\u0002\u00107J$\u00108\u001a\u0002092\u0006\u00106\u001a\u00020.2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020)0;H\u0082@¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020.2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020)0;H\u0002J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\u0006\u00106\u001a\u00020.H\u0002J\b\u0010C\u001a\u00020\"H\u0016J\b\u0010D\u001a\u00020)H\u0016J\b\u0010E\u001a\u00020)H\u0016J\u0010\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020\"H\u0016J\b\u0010J\u001a\u00020\"H\u0016J\u0010\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020\"H\u0016J\u0018\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020.H\u0016J\b\u0010P\u001a\u00020)H\u0002J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020.H\u0002J\b\u0010T\u001a\u00020\"H\u0016J\u0010\u0010U\u001a\u00020\"2\u0006\u0010V\u001a\u00020.H\u0016J\u000e\u0010W\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010XJ\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020\"0$H\u0002J\b\u0010Z\u001a\u00020)H\u0002J\u0015\u0010[\u001a\u00020)2\u0006\u0010\\\u001a\u00020.H\u0000¢\u0006\u0002\b]J\u0014\u0010^\u001a\u0004\u0018\u00010.2\b\u0010_\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010`\u001a\u00020)2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0012\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010.H\u0016J\b\u0010f\u001a\u00020dH\u0016J\u0010\u0010g\u001a\u00020)2\u0006\u0010h\u001a\u00020iH\u0016J\u000e\u0010j\u001a\b\u0012\u0004\u0012\u00020i0kH\u0016J\u0010\u0010l\u001a\u00020)2\u0006\u0010h\u001a\u00020mH\u0016J\"\u0010n\u001a\b\u0012\u0004\u0012\u00020m0k2\b\u0010o\u001a\u0004\u0018\u00010.2\b\u0010p\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010q\u001a\u00020)2\u0006\u0010h\u001a\u00020rH\u0016J\u0018\u0010s\u001a\u00020)2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\bH\u0016J\u0010\u0010w\u001a\u00020)2\u0006\u0010v\u001a\u00020\bH\u0016J\u0010\u0010x\u001a\u00020)2\u0006\u0010v\u001a\u00020\u000bH\u0016J\u0010\u0010y\u001a\u00020)2\u0006\u0010v\u001a\u00020\u000bH\u0016J\u0010\u0010z\u001a\u00020)2\u0006\u0010v\u001a\u00020\u000eH\u0016J\u0010\u0010{\u001a\u00020)2\u0006\u0010v\u001a\u00020\u000eH\u0016J\u0010\u0010|\u001a\u00020)2\u0006\u0010v\u001a\u00020}H\u0016J\u0010\u0010~\u001a\u00020)2\u0006\u0010v\u001a\u00020}H\u0016J\u000b\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0015\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\u0082\u0001\u001a\u00020.H\u0016J\u0014\u0010\u0083\u0001\u001a\u00030\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0080\u0001H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020\"2\u0007\u0010\u0082\u0001\u001a\u00020.H\u0016J\u0011\u0010\u0087\u0001\u001a\u00020)2\u0006\u0010v\u001a\u00020\u0011H\u0016J\u0011\u0010\u0088\u0001\u001a\u00020)2\u0006\u0010v\u001a\u00020\u0011H\u0016J \u0010\u0089\u0001\u001a\u00020)2\u0007\u0010\u008a\u0001\u001a\u00020H2\u0006\u0010\\\u001a\u00020.H\u0000¢\u0006\u0003\b\u008b\u0001J\u001c\u0010\u008c\u0001\u001a\u00020)2\u0007\u0010\u008a\u0001\u001a\u00020H2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0016J\u001d\u0010\u008f\u0001\u001a\u00020)2\u0007\u0010\u008a\u0001\u001a\u00020H2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010\u0091\u0001\u001a\u00020)2\u0007\u0010\u008a\u0001\u001a\u00020HH\u0016J%\u0010\u0092\u0001\u001a\u00020)2\u0007\u0010\u008a\u0001\u001a\u00020H2\u0007\u0010\u0093\u0001\u001a\u00020u2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020)2\u0007\u0010a\u001a\u00030\u0095\u0001H\u0016J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\t\u0010\u0098\u0001\u001a\u000205H\u0016J\u001b\u0010\u0099\u0001\u001a\u0002052\u0007\u0010\u009a\u0001\u001a\u00020H2\u0007\u0010\u009b\u0001\u001a\u00020HH\u0016J\u0012\u0010\u009c\u0001\u001a\u00020)2\u0007\u0010a\u001a\u00030\u009d\u0001H\u0016J\u0013\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0007\u0010a\u001a\u00030 \u0001H\u0016J\u0018\u0010¡\u0001\u001a\u00020)2\r\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020.0AH\u0016J/\u0010£\u0001\u001a\u00030¤\u00012\u0007\u0010¥\u0001\u001a\u00020H2\t\u0010¦\u0001\u001a\u0004\u0018\u00010.2\u0007\u0010§\u0001\u001a\u00020u2\u0006\u0010t\u001a\u00020uH\u0016J6\u0010¨\u0001\u001a\u00030¤\u00012\u0007\u0010¥\u0001\u001a\u00020H2\u0007\u0010\u009a\u0001\u001a\u00020H2\u0007\u0010\u009b\u0001\u001a\u00020H2\u0007\u0010§\u0001\u001a\u00020u2\u0006\u0010t\u001a\u00020uH\u0016J\u0011\u0010©\u0001\u001a\u0002052\u0006\u0010\\\u001a\u00020.H\u0002J5\u0010ª\u0001\u001a\u00030¤\u00012\u0007\u0010¥\u0001\u001a\u00020H2\u0007\u0010¦\u0001\u001a\u00020.2\u0007\u0010§\u0001\u001a\u00020u2\u0006\u0010t\u001a\u00020u2\u0006\u0010\\\u001a\u00020.H\u0002J!\u0010«\u0001\u001a\u0002052\u000e\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010A2\u0006\u0010\\\u001a\u00020.H\u0002J0\u0010«\u0001\u001a\u0002052\u000e\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010A2\r\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020B0A2\u0006\u0010\\\u001a\u00020.H\u0002JE\u0010¯\u0001\u001a\u00030¤\u00012\u000e\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010A2\u0007\u0010¥\u0001\u001a\u00020H2\u0007\u0010¦\u0001\u001a\u00020.2\u0007\u0010§\u0001\u001a\u00020u2\u0006\u0010t\u001a\u00020u2\u0006\u0010\\\u001a\u00020.H\u0002J3\u0010°\u0001\u001a\u0002052\u000e\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010A2\u0007\u0010\u009a\u0001\u001a\u00020H2\u0007\u0010\u009b\u0001\u001a\u00020H2\u0006\u0010\\\u001a\u00020.H\u0002JN\u0010±\u0001\u001a\u00030¤\u00012\u000e\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010A2\u0007\u0010¥\u0001\u001a\u00020H2\u0007\u0010\u009a\u0001\u001a\u00020H2\u0007\u0010\u009b\u0001\u001a\u00020H2\u0007\u0010§\u0001\u001a\u00020u2\u0006\u0010t\u001a\u00020u2\u0006\u0010\\\u001a\u00020.H\u0002J\u0017\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020r0A2\u0006\u0010\\\u001a\u00020.H\u0002J\u001e\u0010³\u0001\u001a\u00020)2\b\u0010_\u001a\u0004\u0018\u00010.2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010´\u0001\u001a\u00020)2\u0007\u0010h\u001a\u00030µ\u0001H\u0016J\n\u0010¶\u0001\u001a\u00030·\u0001H\u0002J\t\u0010¸\u0001\u001a\u000205H\u0002J\u001c\u0010¹\u0001\u001a\u00030¤\u00012\u0007\u0010¥\u0001\u001a\u00020H2\u0007\u0010¦\u0001\u001a\u00020.H\u0002J\t\u0010º\u0001\u001a\u00020.H\u0002J\u0010\u0010»\u0001\u001a\t\u0012\u0005\u0012\u00030¼\u00010AH\u0016J\u0010\u0010½\u0001\u001a\t\u0012\u0005\u0012\u00030¾\u00010AH\u0016J\n\u0010¿\u0001\u001a\u00030À\u0001H\u0016J\u0015\u0010Á\u0001\u001a\u0005\u0018\u00010¾\u00012\u0007\u0010Â\u0001\u001a\u00020.H\u0016J\u001f\u0010Ã\u0001\u001a\t\u0012\u0005\u0012\u00030¾\u00010A2\r\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020.0AH\u0016J\u001f\u0010Å\u0001\u001a\t\u0012\u0005\u0012\u00030¾\u00010A2\r\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020.0AH\u0016J(\u0010Æ\u0001\u001a\u0005\u0018\u00010¾\u00012\u0007\u0010Ç\u0001\u001a\u00020.2\u0007\u0010Â\u0001\u001a\u00020.2\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u0012\u0010Ê\u0001\u001a\u00020\"2\u0007\u0010Ç\u0001\u001a\u00020.H\u0016J\t\u0010Ë\u0001\u001a\u00020HH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006Í\u0001"}, d2 = {"Lcom/obric/aiproactive/impl/ProactiveService;", "Lcom/obric/aiproactive/api/IProactiveService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "nowRecommendationListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/aiproactive/api/IProactiveNowRecommendationsListener;", "Lcom/obric/aiproactive/impl/RegisteredNowListener;", "allRecommendationListeners", "Lcom/obric/aiproactive/api/IProactiveAllRecommendationsListener;", "Lcom/obric/aiproactive/impl/all/AllRecommendationsSnapshotListener;", "todayEventRecordJobs", "Lcom/obric/aiproactive/api/AiProactiveTodayEventRecordsListener;", "Lkotlinx/coroutines/Job;", "aiRecommendationJobs", "Lcom/obric/aiproactive/api/AiProactiveRecommendationsListener;", "aiProactiveDbReadyLock", "", "aiDbRepository", "Lcom/obric/aiproactive/impl/aidb/AiProactiveDbRepository;", "getAiDbRepository", "()Lcom/obric/aiproactive/impl/aidb/AiProactiveDbRepository;", "aiDbRepository$delegate", "Lkotlin/Lazy;", "logger", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "allRecommendationsCoordinator", "Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator;", "getAllRecommendationsCoordinator", "()Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator;", "allRecommendationsCoordinator$delegate", "aiProactiveDbReady", "", "aiProactiveDbReadyDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "accountChangeListener", "com/obric/aiproactive/impl/ProactiveService$accountChangeListener$1", "Lcom/obric/aiproactive/impl/ProactiveService$accountChangeListener$1;", "onCreate", "", "onDestroy", "proactiveDb", "Lcom/obric/memorydata/database/manager/proactive/ProactiveRecommendationDb;", "prepareArtifactOpenLocator", "", "artifact", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "currentNormalizedUid", "requestAllRecommendationsRefreshAfterClientWrite", "wrote", "loadCoordinatorAllRecommendations", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "uid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindAllRecommendationsInvalidation", "Lcom/obric/aiproactive/impl/all/AllRecommendationsInvalidationRegistration;", "onInvalidated", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "allRecommendationsObserver", "Landroidx/room/InvalidationTracker$Observer;", "tableName", "loadLegacyLabelingRows", "", "Lcom/obric/memorydata/database/entity/ProactiveRecommendationEntity;", "ensureAgreePrivacyAndLogin", "initDefaultSubscriptions", "ensureAiProactiveDbReady", "awaitAiProactiveDbReady", "timeoutMs", "", "isAiProactiveEntryReady", "isAiProactiveWakeUpEnabled", "updateAiProactiveWakeUpEnabled", "enabled", "notifyDoubaoGlassesState", "key", EventBody.KEY_VALUE, "markContextAwarenessConfiguredFromGlasses", "glassesStateContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "stage", "tryActiveAiProactiveAssistantVoiceEntry", "tryActiveAiProactiveAssistantQuery", ChatMessage.TYPE_QUERY, "isAssistantSessionIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureAiProactiveDbReadyInternal", "resetAiProactiveDbReady", "refreshRegisteredRecommendationListeners", InfoRequestQPSOptTraceLogger.REASON, "refreshRegisteredRecommendationListeners$ai_proactive_impl_obricRelease", "findLatestDebugLogIdByRecommendId", "recommendId", "toggleUserSubscription", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;", "invokeAlgorithmTask", "Lcom/obric/aiproactive/api/AlgorithmTaskInvokeResult;", "jsonString", "triggerHiddenProactiveEntryFromAvatarFiveTap", "upsertUserSubscription", "dto", "Lcom/obric/aiproactive/api/ProactiveUserSubscriptionDto;", "listUserSubscriptions", "", "upsertSubscriptionTask", "Lcom/obric/aiproactive/api/ProactiveSubscriptionTaskDto;", "listSubscriptionTasks", "subscriptionId", "taskState", "upsertRecommendation", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "registerNowRecommendationsListener", "limit", "", "listener", "unregisterNowRecommendationsListener", "registerAllRecommendationsListener", "unregisterAllRecommendationsListener", "registerTodayEventRecordsListener", "unregisterTodayEventRecordsListener", "registerAgentRunListener", "Lcom/obric/aiproactive/api/AiProactiveAgentRunListener;", "unregisterAgentRunListener", "getLatestAgentRun", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "getAgentRun", "executionId", "getLocalAgentRunControlState", "Lcom/obric/aiproactive/api/AiProactiveAgentRunControlState;", "run", "cancelLocalAgentRun", "registerAiProactiveRecommendationsListener", "unregisterAiProactiveRecommendationsListener", "notifyAiProactiveRecommendationChangedFromLockScreen", "recommendationId", "notifyAiProactiveRecommendationChangedFromLockScreen$ai_proactive_impl_obricRelease", "updateAiProactiveRecommendationCardStatus", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "updateAiProactiveRecommendationActionExecuteInstruction", "actionExecuteInstruction", "markAiProactiveRecommendationCurrentActionExecuted", "markAiProactiveRecommendationActionExecuted", "actionIndex", "updateAiProactiveRecommendationFeedback", "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "getAiProactiveLabelingFeedbackConfig", "Lcom/obric/aiproactive/api/AiProactiveLabelingFeedbackConfigDto;", "loadAllRecommendationsSnapshot", "loadRecommendationsSnapshot", "earliestTimeMillis", "latestTimeMillis", "submitAiProactiveDirectFeedback", "Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;", "submitAiProactiveUserRequirement", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementResult;", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementRequest;", "refreshAiProactive", "refreshTypes", "loadDayRecommendationsPage", "Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "batchId", "dayKey", TypedValues.CycleType.S_WAVE_OFFSET, "loadRecommendationsPage", "loadLegacyAllRecommendationsSnapshot", "loadLegacyDayRecommendationsPage", "buildLabelingAllRecommendationsSnapshot", "recommendations", "Lcom/obric/aiproactive/api/AiProactiveRecommendationDto;", "legacyRows", "buildLabelingDayRecommendationsPage", "buildLabelingWindowRecommendationsSnapshot", "buildLabelingWindowRecommendationsPage", "loadLegacyLabelingCompatRows", "updateRecommendationActionExecuteInstruction", "updateInspiration", "Lcom/obric/aiproactive/api/ProactiveInspirationDto;", "emptyNowSnapshot", "Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", "emptyAllSnapshot", "emptyDayPageResult", "currentDayKey", "getProactivePreferenceExamples", "Lcom/obric/aiproactive/api/AiProactivePreferenceExampleDto;", "getAiRules", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "getAiRuleFollowupCounts", "Lcom/obric/aiproactive/api/AiRuleFollowupCountDto;", "addAiRule", Params.CONTENT, "addAiGeneratedRules", "contents", "addInterviewGeneratedRules", "updateAiRule", "ruleId", "type", "Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;", "deleteAiRule", "getLatestAiRuleUpdateTimestamp", "Companion", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveService implements IProactiveService {
    private static final int ALL_FIRST_PAGE_LIMIT = 50;
    public static final a Companion = null;
    private static final DateTimeFormatter DAY_KEY_FORMATTER = null;
    private static final List<Integer> DEFAULT_PAGE_STATUSES = null;
    private static volatile ProactiveService INSTANCE = null;
    private static final long LABELING_DB_READY_TIMEOUT_MS = 15000;
    private static final String LABELING_WINDOW_PAGE_KEY = "window";
    private static final int LEGACY_LABELING_FALLBACK_LIMIT = 200;
    private static final int NOW_LIVE_CARD_LIMIT = 10;
    private static final String TAG = "ProactiveService";
    private final b accountChangeListener;
    private final Lazy aiDbRepository$delegate;
    private volatile boolean aiProactiveDbReady;
    private volatile w<Boolean> aiProactiveDbReadyDeferred;
    private final Object aiProactiveDbReadyLock;
    private final ConcurrentHashMap<v, bx> aiRecommendationJobs;
    private final ConcurrentHashMap<ac, com.obric.aiproactive.impl.all.d> allRecommendationListeners;
    private final Lazy allRecommendationsCoordinator$delegate;
    private final o logger;
    private final ConcurrentHashMap<ad, d> nowRecommendationListeners;
    private final al scope;
    private final ConcurrentHashMap<com.obric.aiproactive.api.w, bx> todayEventRecordJobs;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/aiproactive/impl/ProactiveService$Companion;", "", "<init>", "()V", "TAG", "", "ALL_FIRST_PAGE_LIMIT", "", "LABELING_DB_READY_TIMEOUT_MS", "", "LEGACY_LABELING_FALLBACK_LIMIT", "LABELING_WINDOW_PAGE_KEY", "NOW_LIVE_CARD_LIMIT", "DEFAULT_PAGE_STATUSES", "", "DAY_KEY_FORMATTER", "Ljava/time/format/DateTimeFormatter;", EventBody.KEY_VALUE, "Lcom/obric/aiproactive/impl/ProactiveService;", "INSTANCE", "getINSTANCE", "()Lcom/obric/aiproactive/impl/ProactiveService;", "getInst", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ProactiveService a() {
            return ProactiveService.access$getINSTANCE$cp();
        }

        @JvmStatic
        public final ProactiveService b() {
            ProactiveService r0 = a();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = ProactiveService.Companion.a();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new ProactiveService(null);     // Catch: Throwable -> L10
            r0.onCreate();     // Catch: Throwable -> L10
            a r1 = ProactiveService.Companion;     // Catch: Throwable -> L10
            ProactiveService.access$setINSTANCE$cp(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$addAiGeneratedRules$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$addAiGeneratedRules$1", f = "ProactiveService.kt", i = {}, l = {1493}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends AiRuleItemDto>>, Object> {
        final /* synthetic */ List<String> $contents;
        int label;
        final /* synthetic */ ProactiveService this$0;

        AnonymousClass1(ProactiveService r3, List<String> r4, Continuation<? super AnonymousClass1> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$contents = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$contents, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends AiRuleItemDto>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super List<AiRuleItemDto>> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            com.obric.aiproactive.impl.aidb.d r3 = ProactiveService.access$getAiDbRepository(this.this$0);
            List<String> r4 = this.$contents;
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r11 = com.obric.aiproactive.impl.aidb.d.a(r3, r4, 0, r7, 2, null);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$addAiRule$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$addAiRule$1", f = "ProactiveService.kt", i = {}, l = {1487}, m = "invokeSuspend", n = {}, s = {})
    static final class C10221 extends SuspendLambda implements Function2<al, Continuation<? super AiRuleItemDto>, Object> {
        final /* synthetic */ String $content;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10221(ProactiveService r3, String r4, Continuation<? super C10221> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$content = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10221(this.this$0, this.$content, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super AiRuleItemDto> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super AiRuleItemDto> r4) {
            return ((C10221) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10221.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            com.obric.aiproactive.impl.aidb.d r3 = ProactiveService.access$getAiDbRepository(this.this$0);
            String r4 = this.$content;
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r11 = com.obric.aiproactive.impl.aidb.d.a(r3, r4, 0, r7, 2, null);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$addInterviewGeneratedRules$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$addInterviewGeneratedRules$1", f = "ProactiveService.kt", i = {}, l = {1499}, m = "invokeSuspend", n = {}, s = {})
    static final class C10231 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends AiRuleItemDto>>, Object> {
        final /* synthetic */ List<String> $contents;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10231(ProactiveService r3, List<String> r4, Continuation<? super C10231> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$contents = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10231(this.this$0, this.$contents, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends AiRuleItemDto>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super List<AiRuleItemDto>> r4) {
            return ((C10231) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10231.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            com.obric.aiproactive.impl.aidb.d r3 = ProactiveService.access$getAiDbRepository(this.this$0);
            List<String> r4 = this.$contents;
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r11 = com.obric.aiproactive.impl.aidb.d.b(r3, r4, 0, r7, 2, null);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/aiproactive/impl/ProactiveService$accountChangeListener$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.middleware.api.app.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProactiveService f6284a;

        b(ProactiveService r1) {
            this.f6284a = r1;
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r8) {
            Intrinsics.checkNotNullParameter(r8, "userId");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveService.TAG, "[Account] onLogin userId=" + r8, false, 4, null);
            ProactiveService.access$resetAiProactiveDbReady(this.f6284a);
            this.f6284a.refreshRegisteredRecommendationListeners$ai_proactive_impl_obricRelease("login");
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r8) {
            Intrinsics.checkNotNullParameter(r8, "lastUserId");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveService.TAG, "[Account] onLogout lastUserId=" + r8, false, 4, null);
            ProactiveService.access$resetAiProactiveDbReady(this.f6284a);
            this.f6284a.refreshRegisteredRecommendationListeners$ai_proactive_impl_obricRelease("logout");
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$bindAllRecommendationsInvalidation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService", f = "ProactiveService.kt", i = {0, 0, 0}, l = {246}, m = "bindAllRecommendationsInvalidation", n = {"this", "uid", "onInvalidated"}, s = {"L$0", "L$1", "L$2"})
    static final class C10251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProactiveService this$0;

        C10251(ProactiveService r3, Continuation<? super C10251> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ProactiveService.access$bindAllRecommendationsInvalidation(this.this$0, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$deleteAiRule$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$deleteAiRule$1", f = "ProactiveService.kt", i = {}, l = {1519}, m = "invokeSuspend", n = {}, s = {})
    static final class C10261 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $ruleId;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10261(ProactiveService r3, String r4, Continuation<? super C10261> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$ruleId = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10261(this.this$0, this.$ruleId, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
            return ((C10261) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10261.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            com.obric.aiproactive.impl.aidb.d r7 = ProactiveService.access$getAiDbRepository(this.this$0);
            String r2 = this.$ruleId;
            Continuation<? super Boolean> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$getAiRuleFollowupCounts$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiproactive/api/AiRuleFollowupCountDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$getAiRuleFollowupCounts$1", f = "ProactiveService.kt", i = {}, l = {1481}, m = "invokeSuspend", n = {}, s = {})
    static final class C10271 extends SuspendLambda implements Function2<al, Continuation<? super aa>, Object> {
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10271(ProactiveService r3, Continuation<? super C10271> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10271(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super aa> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super aa> r4) {
            return ((C10271) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10271.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            com.obric.aiproactive.impl.aidb.d r6 = ProactiveService.access$getAiDbRepository(this.this$0);
            Continuation<? super aa> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r6.d(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$getAiRules$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$getAiRules$1", f = "ProactiveService.kt", i = {}, l = {1475}, m = "invokeSuspend", n = {}, s = {})
    static final class C10281 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends AiRuleItemDto>>, Object> {
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10281(ProactiveService r3, Continuation<? super C10281> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10281(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends AiRuleItemDto>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super List<AiRuleItemDto>> r4) {
            return ((C10281) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10281.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            com.obric.aiproactive.impl.aidb.d r6 = ProactiveService.access$getAiDbRepository(this.this$0);
            Continuation<? super List<AiRuleItemDto>> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r6.c(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$getLatestAiRuleUpdateTimestamp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$getLatestAiRuleUpdateTimestamp$1", f = "ProactiveService.kt", i = {}, l = {1525}, m = "invokeSuspend", n = {}, s = {})
    static final class C10291 extends SuspendLambda implements Function2<al, Continuation<? super Long>, Object> {
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10291(ProactiveService r3, Continuation<? super C10291> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10291(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Long> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Long> r4) {
            return ((C10291) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10291.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            com.obric.aiproactive.impl.aidb.d r6 = ProactiveService.access$getAiDbRepository(this.this$0);
            Continuation<? super Long> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r6.e(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$initDefaultSubscriptions$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$initDefaultSubscriptions$1", f = "ProactiveService.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
    static final class C10301 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        C10301(Continuation<? super C10301> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10301((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10301) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10301.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            e r6 = e.f6532a;
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$isAssistantSessionIdle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService", f = "ProactiveService.kt", i = {}, l = {466}, m = "isAssistantSessionIdle", n = {}, s = {})
    static final class C10311 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProactiveService this$0;

        C10311(ProactiveService r3, Continuation<? super C10311> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.isAssistantSessionIdle((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$loadCoordinatorAllRecommendations$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService", f = "ProactiveService.kt", i = {0, 0, 1}, l = {224, 234}, m = "loadCoordinatorAllRecommendations", n = {"this", "legacyRows", "legacyRows"}, s = {"L$0", "L$1", "L$0"})
    static final class C10321 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProactiveService this$0;

        C10321(ProactiveService r3, Continuation<? super C10321> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ProactiveService.access$loadCoordinatorAllRecommendations(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$markAiProactiveRecommendationActionExecuted$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$markAiProactiveRecommendationActionExecuted$1", f = "ProactiveService.kt", i = {}, l = {940}, m = "invokeSuspend", n = {}, s = {})
    static final class C10331 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $actionIndex;
        final /* synthetic */ AiProactiveCardStatus $cardStatus;
        final /* synthetic */ long $recommendationId;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10331(ProactiveService r3, long r4, int r6, AiProactiveCardStatus r7, Continuation<? super C10331> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$recommendationId = r4;
            this.$actionIndex = r6;
            this.$cardStatus = r7;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10331(this.this$0, this.$recommendationId, this.$actionIndex, this.$cardStatus, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10331) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10331.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
        L11:
            t r16 = (t) ZeusTransformUtils.preCheckCast(r15, t.class, "com.obric.memorydata.plugin");
            ProactiveService r2 = this.this$0;
            if (r16 != null) goto L15;
            r3 = false;
        L15:
            ProactiveService.access$requestAllRecommendationsRefreshAfterClientWrite(r2, r3);
            String r17 = c.a(this.$cardStatus);
            if (r17 == null) goto L19;
            long r4 = this.$recommendationId;
            n.f6478a.b(String.valueOf(r4), r17);
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            com.obric.aiproactive.impl.aidb.d r5 = ProactiveService.access$getAiDbRepository(this.this$0);
            long r6 = this.$recommendationId;
            int r7 = this.$actionIndex;
            AiProactiveCardStatus r8 = this.$cardStatus;
            Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r15 = com.obric.aiproactive.impl.aidb.d.a(r5, r6, r7, r8, 0, r11, 8, null);
            if (r15 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$markAiProactiveRecommendationCurrentActionExecuted$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$markAiProactiveRecommendationCurrentActionExecuted$1", f = "ProactiveService.kt", i = {}, l = {920}, m = "invokeSuspend", n = {}, s = {})
    static final class C10341 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $recommendationId;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10341(ProactiveService r3, long r4, Continuation<? super C10341> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$recommendationId = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10341(this.this$0, this.$recommendationId, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10341) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10341.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L11:
            t r14 = (t) ZeusTransformUtils.preCheckCast(r13, t.class, "com.obric.memorydata.plugin");
            ProactiveService r2 = this.this$0;
            if (r14 != null) goto L15;
            r3 = false;
        L15:
            ProactiveService.access$requestAllRecommendationsRefreshAfterClientWrite(r2, r3);
            n.f6478a.b(String.valueOf(this.$recommendationId), "execute_now");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            com.obric.aiproactive.impl.aidb.d r4 = ProactiveService.access$getAiDbRepository(this.this$0);
            long r5 = this.$recommendationId;
            Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r13 = com.obric.aiproactive.impl.aidb.d.a(r4, r5, 0, r9, 2, null);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$notifyDoubaoGlassesState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C10351 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        C10351(Object r8) {
            super(1, r8, com.obric.aiproactive.impl.runtime.c.class, "onEnvironmentMemoryChanged", "onEnvironmentMemoryChanged(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Boolean r3) {
            invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r3) {
            ((com.obric.aiproactive.impl.runtime.c) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiproactive.impl.runtime.c.class, "com.obric.memorydata.plugin")).c(r3);
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$notifyDoubaoGlassesState$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass2(Object r8) {
            super(0, r8, ProactiveService.class, "markContextAwarenessConfiguredFromGlasses", "markContextAwarenessConfiguredFromGlasses()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ProactiveService.access$markContextAwarenessConfiguredFromGlasses((ProactiveService) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveService.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$submitAiProactiveDirectFeedback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$submitAiProactiveDirectFeedback$1", f = "ProactiveService.kt", i = {}, l = {1051}, m = "invokeSuspend", n = {}, s = {})
    static final class C10361 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.obric.aiproactive.api.o $request;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10361(ProactiveService r3, com.obric.aiproactive.api.o r4, Continuation<? super C10361> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$request = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10361(this.this$0, this.$request, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10361) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10361.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            com.obric.aiproactive.impl.aidb.d r3 = ProactiveService.access$getAiDbRepository(this.this$0);
            com.obric.aiproactive.api.o r4 = this.$request;
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (com.obric.aiproactive.impl.aidb.d.a(r3, r4, 0, r7, 2, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$toggleUserSubscription$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$toggleUserSubscription$1", f = "ProactiveService.kt", i = {}, l = {582}, m = "invokeSuspend", n = {}, s = {})
    static final class C10371 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ToggleUserSubscriptionRequest $request;
        int label;

        C10371(ToggleUserSubscriptionRequest r3, Continuation<? super C10371> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$request = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10371(this.$request, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10371) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10371.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            e r7 = e.f6532a;
            ToggleUserSubscriptionRequest r2 = this.$request;
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.a(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$triggerHiddenProactiveEntryFromAvatarFiveTap$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiproactive/api/AlgorithmTaskInvokeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$triggerHiddenProactiveEntryFromAvatarFiveTap$1", f = "ProactiveService.kt", i = {}, l = {TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE}, m = "invokeSuspend", n = {}, s = {})
    static final class C10381 extends SuspendLambda implements Function2<al, Continuation<? super AlgorithmTaskInvokeResult>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C10381(Continuation<? super C10381> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            C10381 r4 = new C10381((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            r4.L$0 = r2;
            return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super AlgorithmTaskInvokeResult> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super AlgorithmTaskInvokeResult> r4) {
            return ((C10381) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10381.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
        L13:
            Object r11 = Result.m1421constructorimpl((TaskResult) ZeusTransformUtils.preCheckCast(r12, TaskResult.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        L17:
            Throwable r13 = Result.m1424exceptionOrNullimpl(r11);
            if (r13 == null) goto L24;
            RunLog.INSTANCE.warn(ProactiveService.TAG, "[HiddenEntry] run ai_proactive_agent failed", r13);
            String r14 = r13.getMessage();
            if (r14 != null) goto L23;
            r14 = "invoke failed";
        L23:
            r11 = new TaskResult(-1, r14, null, null, 12, null);
        L24:
            TaskResult r15 = (TaskResult) ZeusTransformUtils.preCheckCast(r11, TaskResult.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveService.TAG, "[HiddenEntry] ai_proactive_agent finished code=" + r15.getCode() + " msg=" + r15.getMsg(), false, 4, null);
            int r2 = r15.getCode();
            String r3 = r15.getMsg();
            String r16 = r15.getOutput().toString();
            Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
            return new AlgorithmTaskInvokeResult(r2, r3, r16);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);
            al r17 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveService.TAG, "[HiddenEntry] avatar five tap matched, start proactive hidden entry", false, 4, null);
            Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L15
            com.obric.aiproactive.impl.recording.b r19 = com.obric.aiproactive.impl.recording.b.f6506a;     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            r12 = r19.a("avatar_five_tap", this);     // Catch: Throwable -> L15
            if (r12 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$tryActiveAiProactiveAssistantQuery$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$tryActiveAiProactiveAssistantQuery$1", f = "ProactiveService.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
    static final class C10391 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $normalizedQuery;
        int label;

        C10391(String r3, Continuation<? super C10391> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$normalizedQuery = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10391(this.$normalizedQuery, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
            return ((C10391) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10391.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L11:
            return r9;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            com.obric.aiproactive.impl.assistant.a r2 = com.obric.aiproactive.impl.assistant.a.f6389a;
            String r10 = this.$normalizedQuery;
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r9 = com.obric.aiproactive.impl.assistant.a.a(r2, r10, 0, r5, 2, null);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$tryActiveAiProactiveAssistantVoiceEntry$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$tryActiveAiProactiveAssistantVoiceEntry$1", f = "ProactiveService.kt", i = {}, l = {UploadKeys.KeyIsSkipMeta}, m = "invokeSuspend", n = {}, s = {})
    static final class C10401 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
        int label;

        C10401(Continuation<? super C10401> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10401((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
            return ((C10401) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10401.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            com.obric.aiproactive.impl.assistant.a r2 = com.obric.aiproactive.impl.assistant.a.f6389a;
            Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r8 = com.obric.aiproactive.impl.assistant.a.a(r2, 0, r9, 1, null);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$updateAiProactiveRecommendationActionExecuteInstruction$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$updateAiProactiveRecommendationActionExecuteInstruction$1", f = "ProactiveService.kt", i = {}, l = {TypedValues.Custom.TYPE_DIMENSION}, m = "invokeSuspend", n = {}, s = {})
    static final class C10411 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $actionExecuteInstruction;
        final /* synthetic */ long $recommendationId;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10411(ProactiveService r3, long r4, String r6, Continuation<? super C10411> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$recommendationId = r4;
            this.$actionExecuteInstruction = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10411(this.this$0, this.$recommendationId, this.$actionExecuteInstruction, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10411) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10411.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            t r15 = (t) ZeusTransformUtils.preCheckCast(r14, t.class, "com.obric.memorydata.plugin");
            ProactiveService r13 = this.this$0;
            if (r15 != null) goto L15;
            r3 = false;
        L15:
            ProactiveService.access$requestAllRecommendationsRefreshAfterClientWrite(r13, r3);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            com.obric.aiproactive.impl.aidb.d r4 = ProactiveService.access$getAiDbRepository(this.this$0);
            long r5 = this.$recommendationId;
            String r7 = this.$actionExecuteInstruction;
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r14 = com.obric.aiproactive.impl.aidb.d.a(r4, r5, r7, 0, r10, 4, null);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$updateAiProactiveRecommendationCardStatus$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$updateAiProactiveRecommendationCardStatus$1", f = "ProactiveService.kt", i = {}, l = {881}, m = "invokeSuspend", n = {}, s = {})
    static final class C10421 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ AiProactiveCardStatus $cardStatus;
        final /* synthetic */ long $recommendationId;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10421(ProactiveService r3, long r4, AiProactiveCardStatus r6, Continuation<? super C10421> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$recommendationId = r4;
            this.$cardStatus = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10421(this.this$0, this.$recommendationId, this.$cardStatus, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10421) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10421.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            ProactiveService.access$requestAllRecommendationsRefreshAfterClientWrite(this.this$0, r15);
            String r16 = c.a(this.$cardStatus);
            if (r16 == null) goto L15;
            long r2 = this.$recommendationId;
            n.f6478a.b(String.valueOf(r2), r16);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            com.obric.aiproactive.impl.aidb.d r4 = ProactiveService.access$getAiDbRepository(this.this$0);
            long r5 = this.$recommendationId;
            AiProactiveCardStatus r7 = this.$cardStatus;
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r14 = com.obric.aiproactive.impl.aidb.d.a(r4, r5, r7, 0, r10, 4, null);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$updateAiProactiveRecommendationFeedback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$updateAiProactiveRecommendationFeedback$1", f = "ProactiveService.kt", i = {}, l = {963}, m = "invokeSuspend", n = {}, s = {})
    static final class C10431 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ u $request;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10431(ProactiveService r3, u r4, Continuation<? super C10431> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$request = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10431(this.this$0, this.$request, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10431) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10431.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            ProactiveService.access$requestAllRecommendationsRefreshAfterClientWrite(this.this$0, r13);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            com.obric.aiproactive.impl.aidb.d r4 = ProactiveService.access$getAiDbRepository(this.this$0);
            u r5 = this.$request;
            Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r12 = com.obric.aiproactive.impl.aidb.d.a(r4, r5, 0, r8, 2, null);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$updateAiRule$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$updateAiRule$1", f = "ProactiveService.kt", i = {}, l = {1509}, m = "invokeSuspend", n = {}, s = {})
    static final class C10441 extends SuspendLambda implements Function2<al, Continuation<? super AiRuleItemDto>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ String $ruleId;
        final /* synthetic */ AiRuleItemDto.RuleType $type;
        int label;
        final /* synthetic */ ProactiveService this$0;

        C10441(ProactiveService r3, String r4, String r5, AiRuleItemDto.RuleType r6, Continuation<? super C10441> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$ruleId = r4;
            this.$content = r5;
            this.$type = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10441(this.this$0, this.$ruleId, this.$content, this.$type, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super AiRuleItemDto> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super AiRuleItemDto> r4) {
            return ((C10441) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10441.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L11:
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            com.obric.aiproactive.impl.aidb.d r3 = ProactiveService.access$getAiDbRepository(this.this$0);
            String r4 = this.$ruleId;
            String r5 = this.$content;
            AiRuleItemDto.RuleType r6 = this.$type;
            Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r13 = com.obric.aiproactive.impl.aidb.d.a(r3, r4, r5, r6, 0, r9, 8, null);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
        DEFAULT_PAGE_STATUSES = CollectionsKt.listOf(new Integer[]{0, 1, 2});
        DateTimeFormatter r0 = DateTimeFormatter.ISO_LOCAL_DATE;
        Intrinsics.checkNotNullExpressionValue(r0, "ISO_LOCAL_DATE");
        DAY_KEY_FORMATTER = r0;
    }

    private ProactiveService() {
        this.scope = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.nowRecommendationListeners = new ConcurrentHashMap();
        this.allRecommendationListeners = new ConcurrentHashMap();
        this.todayEventRecordJobs = new ConcurrentHashMap();
        this.aiRecommendationJobs = new ConcurrentHashMap();
        this.aiProactiveDbReadyLock = new Object();
        this.aiDbRepository$delegate = LazyKt.lazy($$Lambda$ProactiveService$wldSxBpeBbKKHomC0oRju5nVVwo.INSTANCE);
        this.logger = com.obric.memorydata.middleware.api.logging.d.f11613a.a(TAG);
        this.allRecommendationsCoordinator$delegate = LazyKt.lazy(new $$Lambda$ProactiveService$CEG6ZPHxNrUUy6sQHd5HbaY98(this));
        this.accountChangeListener = new b(this);
    }

    public /* synthetic */ ProactiveService(DefaultConstructorMarker r1) {
        this();
    }

    public static final /* synthetic */ Object access$bindAllRecommendationsInvalidation(ProactiveService r2, String r3, Function0 r4, Continuation r5) {
        return r2.bindAllRecommendationsInvalidation(r3, (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ String access$currentNormalizedUid(ProactiveService r0) {
        return r0.currentNormalizedUid();
    }

    public static final /* synthetic */ w access$ensureAiProactiveDbReadyInternal(ProactiveService r0) {
        return r0.ensureAiProactiveDbReadyInternal();
    }

    public static final /* synthetic */ com.obric.aiproactive.impl.aidb.d access$getAiDbRepository(ProactiveService r0) {
        return r0.getAiDbRepository();
    }

    public static final /* synthetic */ w access$getAiProactiveDbReadyDeferred$p(ProactiveService r0) {
        return r0.aiProactiveDbReadyDeferred;
    }

    public static final /* synthetic */ Object access$getAiProactiveDbReadyLock$p(ProactiveService r0) {
        return r0.aiProactiveDbReadyLock;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getAiRecommendationJobs$p(ProactiveService r0) {
        return r0.aiRecommendationJobs;
    }

    public static final /* synthetic */ ProactiveService access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ Object access$loadCoordinatorAllRecommendations(ProactiveService r2, String r3, Continuation r4) {
        return r2.loadCoordinatorAllRecommendations(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$markContextAwarenessConfiguredFromGlasses(ProactiveService r0) {
        r0.markContextAwarenessConfiguredFromGlasses();
    }

    public static final /* synthetic */ void access$requestAllRecommendationsRefreshAfterClientWrite(ProactiveService r0, boolean r1) {
        r0.requestAllRecommendationsRefreshAfterClientWrite(r1);
    }

    public static final /* synthetic */ void access$resetAiProactiveDbReady(ProactiveService r0) {
        r0.resetAiProactiveDbReady();
    }

    public static final /* synthetic */ void access$setAiProactiveDbReady$p(ProactiveService r0, boolean r1) {
        r0.aiProactiveDbReady = r1;
    }

    public static final /* synthetic */ void access$setAiProactiveDbReadyDeferred$p(ProactiveService r2, w r3) {
        r2.aiProactiveDbReadyDeferred = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(ProactiveService r0) {
        INSTANCE = r0;
    }

    private static final com.obric.aiproactive.impl.aidb.d aiDbRepository_delegate$lambda$0() {
        return new com.obric.aiproactive.impl.aidb.d(null, null, null, null, null, 31, null);
    }

    private static final com.obric.aiproactive.impl.all.b allRecommendationsCoordinator_delegate$lambda$1(ProactiveService r19) {
        return new com.obric.aiproactive.impl.all.b(r19.scope, (Function0) ZeusTransformUtils.preCheckCast(new ProactiveService$allRecommendationsCoordinator$2$1(r19), Function0.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$allRecommendationsCoordinator$2$2(r19), Function2.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new ProactiveService$allRecommendationsCoordinator$2$3(r19), Function3.class, "com.obric.memorydata.plugin"), null, null, 0, 0, 0, null, null, 2032, null);
    }

    private final InvalidationTracker.Observer allRecommendationsObserver(final String r3, Function0<Unit> r4) {
        final Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        final String[] r5 = new String[0];
        return (InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(new C10241(r3, r2, r5), InvalidationTracker.Observer.class, "com.obric.memorydata.plugin");
    }

    private final Object bindAllRecommendationsInvalidation(final String r7, Function0<Unit> r8, Continuation<? super com.obric.aiproactive.impl.all.a> r9) {
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C10251.class) == false) goto L7;
        C10251 r0 = (C10251) ZeusTransformUtils.preCheckCast(r11, C10251.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(r0.L$2, Function0.class, "com.obric.memorydata.plugin");
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.memorydata.plugin");
        ProactiveService r13 = (ProactiveService) ZeusTransformUtils.preCheckCast(r0.L$0, ProactiveService.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
        r10 = r6;
        final ProactiveService this = r13;
    L20:
        return com.obric.aiproactive.impl.all.c.a(r10, CollectionsKt.listOf(new Function1[]{new $$Lambda$ProactiveService$KbXw2akJSz_FtfHtsw3cMka5M(r7, this), new $$Lambda$ProactiveService$h8jr25OEcwQzeVbR3sCVVNY54(r7, this)}));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        if (Intrinsics.areEqual(r7, currentNormalizedUid()) == false) goto L20;
        w<Boolean> r14 = ensureAiProactiveDbReadyInternal();
        r0.L$0 = this;
        r0.L$1 = r7;
        r0.L$2 = r10;
        r0.label = 1;
        if (r14.a(r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new C10251(this, r11);
        goto L8
    }

    private static final Function0 bindAllRecommendationsInvalidation$lambda$6(String r4, ProactiveService r5, Function0 r6) {
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "callback");
        final AiProactiveDb r8 = com.obric.aiproactive.impl.aidb.b.f6306a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        if (r8 == null) goto L5;
        final InvalidationTracker.Observer r9 = r5.allRecommendationsObserver("ProactiveRecommendation", r7);
        r8.getInvalidationTracker().addObserver(r9);
        return new $$Lambda$ProactiveService$xFm_t4XPvnB1I7VKhZrQYUJrU8U(r8, r9);
    L5:
        return null;
    }

    private static final Unit bindAllRecommendationsInvalidation$lambda$6$lambda$5$lambda$4(AiProactiveDb r0, InvalidationTracker.Observer r1) {
        r0.getInvalidationTracker().removeObserver(r1);
        return Unit.INSTANCE;
    }

    private static final Function0 bindAllRecommendationsInvalidation$lambda$9(String r4, ProactiveService r5, Function0 r6) {
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "callback");
        final ProactiveRecommendationDb r8 = com.obric.memorydata.database.manager.proactive.a.f9590a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        if (r8 == null) goto L5;
        final InvalidationTracker.Observer r9 = r5.allRecommendationsObserver("ProactiveRecommendations", r7);
        r8.getInvalidationTracker().addObserver(r9);
        return new $$Lambda$ProactiveService$eUpq2SZpTO7k_Z2jtsPJNjNmrc(r8, r9);
    L5:
        return null;
    }

    private static final Unit bindAllRecommendationsInvalidation$lambda$9$lambda$8$lambda$7(ProactiveRecommendationDb r0, InvalidationTracker.Observer r1) {
        r0.getInvalidationTracker().removeObserver(r1);
        return Unit.INSTANCE;
    }

    private final ProactiveAllPageSnapshot buildLabelingAllRecommendationsSnapshot(List<t> r3, String r4) {
        List<t> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ProactiveRecommendationDb r0 = proactiveDb();
        if (r0 == null) goto L7;
        ProactiveRecommendationsDao r1 = r0.proactiveRecommendationsDao();
        if (r1 == null) goto L7;
        List<ez> r2 = r1.listTopAll(200);
    L8:
        if (r2 != null) goto L11;
        r2 = CollectionsKt.emptyList();
    L11:
        return buildLabelingAllRecommendationsSnapshot(r5, r2, r4);
    L7:
        r2 = null;
        goto L8
    }

    private final ProactiveAllPageSnapshot buildLabelingAllRecommendationsSnapshot(List<t> r8, List<ez> r9, String r10) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(c.a((t) ZeusTransformUtils.preCheckCast(r14.next(), t.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        List<ProactiveRecommendationDto> r16 = c.c(r11);
        List<ProactiveRecommendationDto> r17 = c.a(r15, r16);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadAllRecommendationsSnapshot combined reason=" + r10 + " ai=" + r15.size() + " legacy=" + r16.size() + " merged=" + r17.size(), false, 4, null);
        long r18 = System.currentTimeMillis();
        ZoneId r19 = ZoneId.systemDefault();
        Intrinsics.checkNotNullExpressionValue(r19, "systemDefault(...)");
        return c.b(r17, r18, r19, 50);
    }

    private final ProactiveDayPageResult buildLabelingDayRecommendationsPage(List<t> r14, long r15, String r17, int r18, int r19, String r20) {
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r3.add(c.a((t) ZeusTransformUtils.preCheckCast(r2.next(), t.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        List<ProactiveRecommendationDto> r5 = loadLegacyLabelingCompatRows(r20);
        List<ProactiveRecommendationDto> r6 = c.a(r4, r5);
        long r7 = c.d(c.e(r6));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadDayRecommendationsPage combined reason=" + r20 + " dayKey=" + r17 + " requestedBatch=" + r15 + " mergedBatch=" + r7 + " ai=" + r4.size() + " legacy=" + r5.size() + " merged=" + r6.size(), false, 4, null);
        ZoneId r10 = ZoneId.systemDefault();
        Intrinsics.checkNotNullExpressionValue(r10, "systemDefault(...)");
        return c.a(r6, r7, r17, r18, r19, r10);
    }

    private final ProactiveDayPageResult buildLabelingWindowRecommendationsPage(List<t> r5, long r6, long r8, long r10, int r12, int r13, String r14) {
        List<t> r4 = c.a((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), r8, r10);
        long r1 = c.a(c.f(r4));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadRecommendationsPage window reason=" + r14 + " requestedBatch=" + r6 + " windowBatch=" + r1 + " earliest=" + r8 + " latest=" + r10 + " offset=" + r12 + " limit=" + r13 + " rows=" + r4.size(), false, 4, null);
        return c.a(r4, r1, r12, r13);
    }

    private final ProactiveAllPageSnapshot buildLabelingWindowRecommendationsSnapshot(List<t> r7, long r8, long r10, String r12) {
        List<t> r6 = c.a((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), r8, r10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadRecommendationsSnapshot window reason=" + r12 + " earliest=" + r8 + " latest=" + r10 + " rows=" + r6.size(), false, 4, null);
        long r9 = System.currentTimeMillis();
        ZoneId r11 = ZoneId.systemDefault();
        Intrinsics.checkNotNullExpressionValue(r11, "systemDefault(...)");
        return c.a(r6, r9, r11, 50);
    }

    private final String currentDayKey() {
        String r1 = LocalDate.now(ZoneId.systemDefault()).format(DAY_KEY_FORMATTER);
        Intrinsics.checkNotNullExpressionValue(r1, "format(...)");
        return r1;
    }

    private final String currentNormalizedUid() {
        String r0 = com.obric.aiproactive.impl.a.a(AppContext.INSTANCE.getUserId());
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    private final ProactiveAllPageSnapshot emptyAllSnapshot() {
        return new ProactiveAllPageSnapshot(0, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false);
    }

    private final ProactiveDayPageResult emptyDayPageResult(long r7, String r9) {
        return new ProactiveDayPageResult(r7, r9, false, CollectionsKt.emptyList());
    }

    private final ProactiveNowPageSnapshot emptyNowSnapshot() {
        return new ProactiveNowPageSnapshot(0, false, CollectionsKt.emptyList());
    }

    private final w<Boolean> ensureAiProactiveDbReadyInternal() {
        String r0 = AppContext.INSTANCE.getUserId();
        if (com.obric.aiproactive.impl.a.b(r0) == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] ensureAiProactiveDbReady ignored invalidUid raw=" + r0, null, 4, null);
        boolean r9 = false;
    L6:
        return y.a(r9);
    L8:
        if (this.aiProactiveDbReady == false) goto L10;
        r9 = true;
        goto L6
    L10:
        Object r1 = this.aiProactiveDbReadyLock;
        monitor-enter(r1);
    L25:
        th = move-exception;
        throw th;
    L13:
        if (this.aiProactiveDbReady == false) goto L17;
        w<Boolean> r10 = y.a(true);     // Catch: Throwable -> L25
        monitor-exit(r1);
        return r10;
    L17:
        w<Boolean> r2 = this.aiProactiveDbReadyDeferred;     // Catch: Throwable -> L25
        if (r2 == null) goto L22;
        monitor-exit(r1);
        return r2;
    L22:
        w<Boolean> r3 = y.a(null, 1, null);     // Catch: Throwable -> L25
        this.aiProactiveDbReadyDeferred = r3;     // Catch: Throwable -> L25
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$ensureAiProactiveDbReadyInternal$1$2$1(this, r3, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L25
        monitor-exit(r1);
        return r3;
    }

    private final com.obric.aiproactive.impl.aidb.d getAiDbRepository() {
        return (com.obric.aiproactive.impl.aidb.d) ZeusTransformUtils.preCheckCast(this.aiDbRepository$delegate.getValue(), com.obric.aiproactive.impl.aidb.d.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.aiproactive.impl.all.b getAllRecommendationsCoordinator() {
        return (com.obric.aiproactive.impl.all.b) ZeusTransformUtils.preCheckCast(this.allRecommendationsCoordinator$delegate.getValue(), com.obric.aiproactive.impl.all.b.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final ProactiveService getInst() {
        return Companion.b();
    }

    private final com.obric.memorydata.middleware.api.logging.e glassesStateContext(String r9) {
        return new com.obric.memorydata.middleware.api.logging.e(null, "connection_" + DoubaoGlassesConnectionState.INSTANCE.currentSnapshot().getGeneration(), r9, 1, null);
    }

    /* JADX INFO: renamed from: lambda$1RTs3JuXmcTNb-pvy0qNoLNeg_o, reason: not valid java name */
    public static /* synthetic */ Unit m206lambda$1RTs3JuXmcTNbpvy0qNoLNeg_o(ProactiveService r0, String r1) {
        return requestAllRecommendationsRefreshAfterClientWrite$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit lambda$2r2SPGzTYVW_UtQtsS5wYiF79Co(Throwable r0, g r1) {
        return markContextAwarenessConfiguredFromGlasses$lambda$14$lambda$13(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$B5YEjmX-jMRDDEfJ9r0QP1MeCI8, reason: not valid java name */
    public static /* synthetic */ String m207lambda$B5YEjmXjMRDDEfJ9r0QP1MeCI8(ProactiveRecommendationDb r0, fd r1, long r2, Ref.BooleanRef r4) {
        return upsertUserSubscription$lambda$32(r0, r1, r2, r4);
    }

    /* JADX INFO: renamed from: lambda$CEG6ZPHxNrUUy6sQHd5Hb-aY-98, reason: not valid java name */
    public static /* synthetic */ com.obric.aiproactive.impl.all.b m208lambda$CEG6ZPHxNrUUy6sQHd5HbaY98(ProactiveService r0) {
        return allRecommendationsCoordinator_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$CY-xItweYjqKXVa8-_vrCbOU1pA, reason: not valid java name */
    public static /* synthetic */ Unit m209lambda$CYxItweYjqKXVa8_vrCbOU1pA(String r0, g r1) {
        return notifyDoubaoGlassesState$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$KbXw2akJSz-_-FtfHtsw3cMka5M, reason: not valid java name */
    public static /* synthetic */ Function0 m210lambda$KbXw2akJSz_FtfHtsw3cMka5M(String r0, ProactiveService r1, Function0 r2) {
        return bindAllRecommendationsInvalidation$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$KlLDJegaiTJfiJ1A4MoDxaWG0ik(boolean r0, g r1) {
        return notifyDoubaoGlassesState$lambda$11(r0, r1);
    }

    public static /* synthetic */ com.obric.aiproactive.impl.all.d lambda$YxUsmyfHO9CHZlRePJ885ye_vek(Function1 r0, Object r1) {
        return registerAllRecommendationsListener$lambda$42(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$eUpq2SZpTO7k_Z2jtsPJNjNm-rc, reason: not valid java name */
    public static /* synthetic */ Unit m211lambda$eUpq2SZpTO7k_Z2jtsPJNjNmrc(ProactiveRecommendationDb r0, InvalidationTracker.Observer r1) {
        return bindAllRecommendationsInvalidation$lambda$9$lambda$8$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$h8jr-25OEcwQ-zeVbR3sCVVNY54, reason: not valid java name */
    public static /* synthetic */ Function0 m212lambda$h8jr25OEcwQzeVbR3sCVVNY54(String r0, ProactiveService r1, Function0 r2) {
        return bindAllRecommendationsInvalidation$lambda$9(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$jQuI8amgD-DTsMKDmWlEMtzIKro, reason: not valid java name */
    public static /* synthetic */ com.obric.aiproactive.impl.all.d m213lambda$jQuI8amgDDTsMKDmWlEMtzIKro(ac r0, ac r1) {
        return registerAllRecommendationsListener$lambda$41(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$q-zAE5_Su-LuIHdLA06BnVByFVg, reason: not valid java name */
    public static /* synthetic */ void m214lambda$qzAE5_SuLuIHdLA06BnVByFVg(ac r0, ProactiveAllPageSnapshot r1) {
        registerAllRecommendationsListener$lambda$41$lambda$40(r0, r1);
    }

    public static /* synthetic */ void lambda$q_nGYoPFal3okGi_HEGofWopHek(ProactiveRecommendationDb r0, ProactiveInspirationDto r1, long r2) {
        updateInspiration$lambda$59(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$r1KNZN-0pMrSUSLfaxhsmpQg9qg, reason: not valid java name */
    public static /* synthetic */ boolean m215lambda$r1KNZN0pMrSUSLfaxhsmpQg9qg(String r0) {
        return submitAiProactiveUserRequirement$lambda$51(r0);
    }

    public static /* synthetic */ com.obric.aiproactive.impl.aidb.d lambda$wldSxBpeBbKKHomC0oRju5nVVwo() {
        return aiDbRepository_delegate$lambda$0();
    }

    public static /* synthetic */ Unit lambda$xFm_t4XPvnB1I7VKhZrQYUJrU8U(AiProactiveDb r0, InvalidationTracker.Observer r1) {
        return bindAllRecommendationsInvalidation$lambda$6$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ void lambda$z_qrJPJA0lS_l8TsFrI3v2CTxzw(ad r0, ProactiveNowPageSnapshot r1) {
        registerNowRecommendationsListener$lambda$38(r0, r1);
    }

    private final Object loadCoordinatorAllRecommendations(String r9, Continuation<? super ProactiveAllPageSnapshot> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C10321.class) == false) goto L7;
        C10321 r1 = (C10321) ZeusTransformUtils.preCheckCast(r11, C10321.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ProactiveService this = (ProactiveService) ZeusTransformUtils.preCheckCast(r1.L$1, ProactiveService.class, "com.obric.memorydata.plugin");
        List<ez> r13 = (List) ZeusTransformUtils.preCheckCast(r1.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L29:
        return this.buildLabelingAllRecommendationsSnapshot((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), r13, "listener");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List<ez> r8 = (List) ZeusTransformUtils.preCheckCast(r1.L$1, List.class, "com.obric.memorydata.plugin");
        ProactiveService r14 = (ProactiveService) ZeusTransformUtils.preCheckCast(r1.L$0, ProactiveService.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
        r13 = r8;
        this = r14;
    L22:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L25;
        List<ProactiveRecommendationDto> r15 = c.c(r13);
        long r16 = System.currentTimeMillis();
        ZoneId r0 = ZoneId.systemDefault();
        Intrinsics.checkNotNullExpressionValue(r0, "systemDefault(...)");
        return c.b(r15, r16, r0, 50);
    L25:
        com.obric.aiproactive.impl.aidb.d r17 = this.getAiDbRepository();
        r1.L$0 = r13;
        r1.L$1 = this;
        r1.label = 2;
        r12 = r17.b(r1);
        if (r12 != r3) goto L29;
        return r3;
    L16:
        ResultKt.throwOnFailure(r12);
        if (Intrinsics.areEqual(r9, currentNormalizedUid()) == false) goto L31;
        r13 = loadLegacyLabelingRows(r9);
        w<Boolean> r18 = ensureAiProactiveDbReadyInternal();
        r1.L$0 = this;
        r1.L$1 = r13;
        r1.label = 1;
        r12 = r18.a(r1);
        if (r12 != r3) goto L22;
        return r3;
    L31:
        throw new IllegalStateException("account changed before ALL load".toString());
    L7:
        r1 = new C10321(this, r11);
        goto L8
    }

    private final ProactiveAllPageSnapshot loadLegacyAllRecommendationsSnapshot(String r8) {
        List<ProactiveRecommendationDto> r0 = loadLegacyLabelingCompatRows(r8);
        if (r0.isEmpty() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadAllRecommendationsSnapshot legacyFallbackEmpty reason=" + r8, null, 4, null);
        return emptyAllSnapshot();
    L6:
        long r7 = System.currentTimeMillis();
        ZoneId r1 = ZoneId.systemDefault();
        Intrinsics.checkNotNullExpressionValue(r1, "systemDefault(...)");
        return c.b(r0, r7, r1, 50);
    }

    private final ProactiveDayPageResult loadLegacyDayRecommendationsPage(long r8, String r10, int r11, int r12, String r13) {
        List<ProactiveRecommendationDto> r0 = loadLegacyLabelingCompatRows(r13);
        if (r0.isEmpty() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadDayRecommendationsPage legacyFallbackEmpty reason=" + r13 + " dayKey=" + r10, null, 4, null);
        return emptyDayPageResult(r8, r10);
    L6:
        ZoneId r6 = ZoneId.systemDefault();
        Intrinsics.checkNotNullExpressionValue(r6, "systemDefault(...)");
        return c.a(r0, r8, r10, r11, r12, r6);
    }

    private final List<ProactiveRecommendationDto> loadLegacyLabelingCompatRows(String r9) {
        ProactiveRecommendationDb r8 = proactiveDb();
        if (r8 == null) goto L7;
        ProactiveRecommendationsDao r10 = r8.proactiveRecommendationsDao();
        if (r10 == null) goto L7;
        List<ez> r11 = r10.listTopAll(200);
    L8:
        if (r11 != null) goto L10;
        r11 = CollectionsKt.emptyList();
    L10:
        List<ProactiveRecommendationDto> r0 = c.c(r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] legacyLabelingRows reason=" + r9 + " rows=" + r11.size() + " compat=" + r0.size(), false, 4, null);
        return r0;
    L7:
        r11 = null;
        goto L8
    }

    private final List<ez> loadLegacyLabelingRows(String r4) {
        ProactiveRecommendationDb r3 = com.obric.memorydata.database.manager.proactive.a.f9590a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        if (r3 == null) goto L7;
        ProactiveRecommendationsDao r5 = r3.proactiveRecommendationsDao();
        if (r5 == null) goto L7;
        List<ez> r6 = r5.listTopAll(200);
    L8:
        if (r6 == null) goto L10;
        return r6;
    L10:
        return CollectionsKt.emptyList();
    L7:
        r6 = null;
        goto L8
    }

    private final void markContextAwarenessConfiguredFromGlasses() {
        MemoryServiceApi r0 = (MemoryServiceApi) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(MemoryServiceApi.class)), MemoryServiceApi.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L15;
        o.a(this.logger, "眼镜环境记忆配置写入失败", "glasses_environment_configuration_failed", "memory_service_unavailable", null, glassesStateContext("environment_memory"), null, 40, null);
        return;
    L15:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        ProactiveService r2 = (ProactiveService) ZeusTransformUtils.preCheckCast(this, ProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r0.markContextAwarenessConfigured();     // Catch: Throwable -> L8
        Object r1 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        final Throwable r4 = Result.m1424exceptionOrNullimpl(r1);
        if (r4 == null) goto L13;
        o.a(this.logger, "眼镜环境记忆配置写入失败", "glasses_environment_configuration_failed", "configuration_write_failed", null, glassesStateContext("environment_memory"), new $$Lambda$ProactiveService$2r2SPGzTYVW_UtQtsS5wYiF79Co(r4), 8, null);
    L13:
        ResultKt.throwOnFailure(r1);
        return;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private static final Unit markContextAwarenessConfiguredFromGlasses$lambda$14$lambda$13(Throwable r1, g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("error_type", r1.getClass().getSimpleName());
        return Unit.INSTANCE;
    }

    private static final Unit notifyDoubaoGlassesState$lambda$10(String r1, g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        if (Intrinsics.areEqual(r1, "glasses_connected_state") == false) goto L5;
    L10:
        boolean r3 = true;
    L11:
        r2.a("state_key_supported", Boolean.valueOf(r3));
        return Unit.INSTANCE;
    L5:
        if (Intrinsics.areEqual(r1, "glasses_physical_connection_state") == true) goto L10;
        if (Intrinsics.areEqual(r1, "glasses_environment_memory_enabled") == true) goto L10;
        r3 = false;
        goto L11
    }

    private static final Unit notifyDoubaoGlassesState$lambda$11(boolean r1, g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("enabled", Boolean.valueOf(r1));
        return Unit.INSTANCE;
    }

    private final ProactiveRecommendationDb proactiveDb() {
        return com.obric.memorydata.database.manager.proactive.a.a(com.obric.memorydata.database.manager.proactive.a.f9590a, null, 1, null);
    }

    private static final com.obric.aiproactive.impl.all.d registerAllRecommendationsListener$lambda$41(ac r2, ac r3) {
        final ac r4 = (ac) ZeusTransformUtils.wrapperContextForParams(r2, ac.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter((ac) ZeusTransformUtils.wrapperContextForParams(r3, ac.class, "com.obric.memorydata.plugin"), "it");
        return new $$Lambda$ProactiveService$qzAE5_SuLuIHdLA06BnVByFVg(r4);
    }

    private static final void registerAllRecommendationsListener$lambda$41$lambda$40(ac r7, ProactiveAllPageSnapshot r8) {
        ac r9 = (ac) ZeusTransformUtils.wrapperContextForParams(r7, ac.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "snapshot");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] allRecommendationsListener onChanged batchId=" + r8.getBatchId() + " days=" + r8.getDayHeaders().size() + " todaySize=" + r8.getTodayFirstPage().size() + " todayHasNext=" + r8.getTodayHasNext(), false, 4, null);
        r9.a(r8);
    }

    private static final com.obric.aiproactive.impl.all.d registerAllRecommendationsListener$lambda$42(Function1 r2, Object r3) {
        return (com.obric.aiproactive.impl.all.d) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), com.obric.aiproactive.impl.all.d.class, "com.obric.memorydata.plugin");
    }

    private static final void registerNowRecommendationsListener$lambda$38(ad r8, ProactiveNowPageSnapshot r9) {
        ad r10 = (ad) ZeusTransformUtils.wrapperContextForParams(r8, ad.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "snapshot");
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("[Runtime] nowRecommendationsListener onChanged batchId=").append(r9.getBatchId()).append(" size=").append(r9.getList().size()).append(" hasNext=").append(r9.getHasNext()).append(" recommendIds=");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r9.getList(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendId());
        goto L4
    L6:
        StringBuilder r1 = r0.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 3)).append(" inspirationIds=");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r9.getList(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r6.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r7.add(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r11.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getInspirationId());
        goto L8
    L10:
        IRunLog.a.a(r2, TAG, r1.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 3)).toString(), false, 4, null);
        r10.a(r9);
    }

    private final void requestAllRecommendationsRefreshAfterClientWrite(boolean r2) {
        c.a(r2, new $$Lambda$ProactiveService$1RTs3JuXmcTNbpvy0qNoLNeg_o(this));
    }

    private static final Unit requestAllRecommendationsRefreshAfterClientWrite$lambda$2(ProactiveService r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
        r1.getAllRecommendationsCoordinator().a(r2);
        return Unit.INSTANCE;
    }

    private final void resetAiProactiveDbReady() {
        Object r0 = this.aiProactiveDbReadyLock;
        monitor-enter(r0);
        this.aiProactiveDbReady = false;     // Catch: Throwable -> L11
        w<Boolean> r2 = this.aiProactiveDbReadyDeferred;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        r2.a(false);     // Catch: Throwable -> L11
    L8:
        this.aiProactiveDbReadyDeferred = null;     // Catch: Throwable -> L11
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static final boolean submitAiProactiveUserRequirement$lambda$51(String r2) {
        AwarenessManager.INSTANCE.dispatchAwarenessEvent("ai_proactive_user_requirement_submitted", com.obric.aiproactive.impl.recording.a.f6505a.a(r2));
        return true;
    }

    private static final void updateInspiration$lambda$59(ProactiveRecommendationDb r9, ProactiveInspirationDto r10, long r11) {
        ProactiveInspirationDao r12 = r9.proactiveInspirationDao();
        et r0 = r12.getById(r10.getInspirationId());
        com.obric.aiproactive.impl.b r1 = null;
        if (r0 == null) goto L5;
        com.obric.aiproactive.impl.b r2 = c.a(r0);
    L6:
        if (r2 != null) goto L10;
        et r3 = (et) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r12.listByRecommendId(r10.getRecommendId())), et.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        r1 = c.a(r3);
    L10:
        com.obric.aiproactive.impl.b r4 = c.a(r2, r1, r10.getCreated());
        r12.upsert(c.a(r10, r4.a(), r11, r11, r4.b()));
        return;
    L5:
        r2 = null;
        goto L6
    }

    private static final String upsertUserSubscription$lambda$32(ProactiveRecommendationDb r5, fd r6, long r7, Ref.BooleanRef r9) {
        String r0 = String.valueOf(r5.proactiveUserSubscriptionsDao().upsert(r6));
        if (r6.g() == false) goto L13;
        List<String> r1 = r5.proactiveSubscriptionTasksDao().updateIsDeleteBySubscriptionId(r6.a(), true, r7);
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        r1 = r5.proactiveSubscriptionTasksDao().updateIsDeleteBySourceTaskIds(r1, true, r7);
        goto L6
    L9:
        if (r5.proactiveRecommendationsDao().updateIsDeleteBySubscriptionId(r6.a(), true, r7) <= 0) goto L11;
        boolean r2 = true;
    L12:
        r9.element = r2;
        r5.proactiveInspirationDao().updateIsDeleteBySubscriptionId(r6.a(), true, r7);
        r5.proactiveEcaConditionDao().updateIsDeleteBySubscriptionId(r6.a(), true, r7);
        goto L13
    L11:
        r2 = false;
    L13:
        return r0;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public List<AiRuleItemDto> addAiGeneratedRules(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "contents");
        return (List) ZeusTransformUtils.preCheckCast(i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r6, null), Function2.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public AiRuleItemDto addAiRule(String r5) {
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        return (AiRuleItemDto) ZeusTransformUtils.preCheckCast(i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C10221(this, r5, null), Function2.class, "com.obric.memorydata.plugin")), AiRuleItemDto.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public List<AiRuleItemDto> addInterviewGeneratedRules(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "contents");
        return (List) ZeusTransformUtils.preCheckCast(i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C10231(this, r6, null), Function2.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public boolean awaitAiProactiveDbReady(long r9) {
        if (this.aiProactiveDbReady == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] awaitAiProactiveDbReady hitReadyCache=true", false, 4, null);
        return true;
    L6:
        long r10 = RangesKt.coerceAtLeast(r9, 1);
        boolean r8 = ((Boolean) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$awaitAiProactiveDbReady$result$1(r10, ensureAiProactiveDbReadyInternal(), null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] awaitAiProactiveDbReady timeoutMs=" + r10 + " result=" + r8, false, 4, null);
        return r8;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public boolean cancelLocalAgentRun(String r1) {
        Intrinsics.checkNotNullParameter(r1, "executionId");
        return com.obric.aiproactive.impl.progress.e.f6504a.a(r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public boolean deleteAiRule(String r5) {
        Intrinsics.checkNotNullParameter(r5, "ruleId");
        return ((Boolean) ZeusTransformUtils.preCheckCast(i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C10261(this, r5, null), Function2.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public boolean ensureAgreePrivacyAndLogin() {
        boolean r7 = com.obric.aiproactive.impl.runtime.d.f6511a.a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] ensureAgreePrivacyAndLogin result=" + r7, false, 4, null);
        return r7;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void ensureAiProactiveDbReady() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] ensureAiProactiveDbReady", false, 4, null);
        ensureAiProactiveDbReadyInternal();
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public String findLatestDebugLogIdByRecommendId(String r13) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        Long r3 = StringsKt.toLongOrNull(r13);
        if (r3 == null) goto L26;
        long r5 = r3.longValue();
        AiProactiveDb r12 = getAiDbRepository().a();
        if (r12 != null) goto L17;
        return null;
    L17:
        Long r4 = r12.recommendationDao().findTraceIdByIdSync(r5);
        if (r4 == null) goto L26;
        long r6 = r4.longValue();
        String r14 = r12.traceDao().findLogIdByIdSync(r6);
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r15 = new StringBuilder().append("[Runtime] findLatestDebugLogIdByRecommendId id=").append(r13).append(" traceId=").append(r6).append(" found=");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L22;
    L23:
        r2 = true;
    L24:
        IRunLog.a.a(r7, TAG, r15.append(!r2).toString(), false, 4, null);
        return r14;
    L22:
        if (StringsKt.isBlank(r8) == false) goto L24;
    L26:
        return null;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public com.obric.aiproactive.api.g getAgentRun(String r1) {
        Intrinsics.checkNotNullParameter(r1, "executionId");
        return com.obric.aiproactive.impl.progress.c.f6499a.a(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.aiproactive.api.IProactiveService
    public s getAiProactiveLabelingFeedbackConfig() {
        String r0 = SettingsManager.INSTANCE.getSettingsStr(SettingsManager.KEY_AI_PROACTIVE_FEEDBACK_SETTINGS);
        Object r1 = null;
        if (r0 != null) goto L5;
    L18:
        if (r1 != null) goto L20;
        s r8 = c.a(CollectionsKt.emptyList(), CollectionsKt.emptyList(), "");
    L21:
        if (r1 != null) goto L23;
        String r2 = "fallback";
    L24:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] getAiProactiveLabelingFeedbackConfig source=" + r2 + " positive=" + r8.a() + " negative=" + r8.b(), false, 4, null);
        return r8;
    L23:
        r2 = "settings";
        goto L24
    L20:
        r8 = r1;
        goto L21
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L18;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        ProactiveService r9 = (ProactiveService) ZeusTransformUtils.preCheckCast(this, ProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Object r10 = Result.m1421constructorimpl(c.a(r0));     // Catch: Throwable -> L11
    L13:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r10);
        if (r4 != null) goto L16;
        r1 = r10;
    L17:
        r1 = (s) ZeusTransformUtils.preCheckCast(r1, s.class, "com.obric.memorydata.plugin");
        goto L18
    L16:
        RunLog.INSTANCE.error(TAG, "[Runtime] parse ai proactive feedback settings failed", r4);
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public aa getAiRuleFollowupCounts() {
        return (aa) ZeusTransformUtils.preCheckCast(i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C10271(this, null), Function2.class, "com.obric.memorydata.plugin")), aa.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public List<AiRuleItemDto> getAiRules() {
        return (List) ZeusTransformUtils.preCheckCast(i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C10281(this, null), Function2.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public com.obric.aiproactive.api.g getLatestAgentRun() {
        return com.obric.aiproactive.impl.progress.c.f6499a.b();
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public long getLatestAiRuleUpdateTimestamp() {
        return ((Number) ZeusTransformUtils.preCheckCast(i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C10291(this, null), Function2.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public com.obric.aiproactive.api.e getLocalAgentRunControlState(com.obric.aiproactive.api.g r1) {
        Intrinsics.checkNotNullParameter(r1, "run");
        return com.obric.aiproactive.impl.progress.e.f6504a.a(r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public List<AiProactivePreferenceExampleDto> getProactivePreferenceExamples() {
        return CollectionsKt.listOf(new AiProactivePreferenceExampleDto[]{new AiProactivePreferenceExampleDto("1", "这里是主动内容主标题，在遇到重点内容时需要加字重，其他描述保持正常字重，但是一旦有模型认为重要的字眼就必须加字重，这是层次感和易读性的关键。", "star", CollectionsKt.listOf(new String[]{"这里是第一个行动推荐，超出一行就打点吧啊", "这是第二个推荐", "这是第三个推荐，最多三个"})), new AiProactivePreferenceExampleDto("2", "今天下午深圳发布了红色暴雨警告，你记得带伞出门，不出门最好。", "weather", CollectionsKt.listOf(new String[]{"知道了", "这是第三个推荐，最多三个"}))});
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void initDefaultSubscriptions() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] initDefaultSubscriptions", false, 4, null);
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10301(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public AlgorithmTaskInvokeResult invokeAlgorithmTask(String r6) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        ProactiveService r4 = (ProactiveService) ZeusTransformUtils.preCheckCast(this, ProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Object r7 = Result.m1421constructorimpl(c.b(r6));     // Catch: Throwable -> L15
    L17:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r7);
        if (r5 != null) goto L36;
        JSONObject r8 = (JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.memorydata.plugin");
        String r9 = r8.optString(ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L22;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L25
        ProactiveService r11 = (ProactiveService) ZeusTransformUtils.preCheckCast(this, ProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        TaskResult r12 = TaskRequest.Companion.a(r8).execute();     // Catch: Throwable -> L25
        int r0 = r12.getCode();     // Catch: Throwable -> L25
        String r13 = r12.getMsg();     // Catch: Throwable -> L25
        String r14 = r12.getOutput().toString();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");     // Catch: Throwable -> L25
        Object r15 = Result.m1421constructorimpl(new AlgorithmTaskInvokeResult(r0, r13, r14));     // Catch: Throwable -> L25
    L27:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L35;
        String r17 = r16.getMessage();
        if (r17 != null) goto L33;
        r17 = "invoke failed";
    L33:
        r15 = new AlgorithmTaskInvokeResult(-3, r17, "");
    L35:
        return (AlgorithmTaskInvokeResult) ZeusTransformUtils.preCheckCast(r15, AlgorithmTaskInvokeResult.class, "com.obric.memorydata.plugin");
    L25:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L27
    L22:
        return new AlgorithmTaskInvokeResult(-2, "task name is blank", "");
    L36:
        String r19 = r5.getMessage();
        if (r19 != null) goto L40;
        r19 = "invalid jsonString";
    L40:
        return new AlgorithmTaskInvokeResult(-1, r19, "");
    L15:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L12:
        return new AlgorithmTaskInvokeResult(-1, "jsonString is blank", "");
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public boolean isAiProactiveEntryReady() {
        String r0 = AppContext.INSTANCE.getUserId();
        boolean r2 = false;
        if (com.obric.aiproactive.impl.a.b(r0) == true) goto L8;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("[Runtime] isAiProactiveEntryReady result=false reason=invalidUid raw=");
    L5:
        IRunLog.a.a(r3, TAG, r9.append(r0).toString(), false, 4, null);
        return r2;
    L8:
        if (this.aiProactiveDbReady == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] isAiProactiveEntryReady result=true source=cache", false, 4, null);
        return true;
    L12:
        if (getAiDbRepository().a() == null) goto L14;
        r2 = true;
    L14:
        if (r2 == false) goto L16;
        this.aiProactiveDbReady = true;
    L16:
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder().append("[Runtime] isAiProactiveEntryReady result=").append(r2);
        r0 = " source=dbProvider";
        goto L5
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public boolean isAiProactiveWakeUpEnabled() {
        boolean r7 = com.obric.aiproactive.impl.runtime.a.f6507a.a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] isAiProactiveWakeUpEnabled result=" + r7, false, 4, null);
        return r7;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public Object isAssistantSessionIdle(Continuation<? super Boolean> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, C10311.class) == false) goto L7;
        C10311 r0 = (C10311) ZeusTransformUtils.preCheckCast(r13, C10311.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L13
    L24:
        Object r11 = Result.m1421constructorimpl((Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
    L27:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r11);
        if (r15 == null) goto L31;
        RunLog.INSTANCE.warn(TAG, "[Runtime] isAssistantSessionIdle getState failed", r15);
    L31:
        if (Result.m1427isFailureimpl(r11) == false) goto L33;
        r11 = null;
    L33:
        Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L37;
    L39:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] isAssistantSessionIdle state=" + r16 + " result=" + r4, false, 4, null);
        return Boxing.boxBoolean(r4);
    L37:
        if (r16.intValue() != 0) goto L39;
        r4 = true;
        goto L39
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r14);
        if (com.obric.aiproactive.impl.assistant.a.f6389a.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) == true) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] isAssistantSessionIdle initSdk failed", null, 4, null);
        return Boxing.boxBoolean(false);
    L21:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L13
        ProactiveService r18 = (ProactiveService) ZeusTransformUtils.preCheckCast(this, ProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        EventsTaskSdk r19 = EventsTaskSdk.INSTANCE;     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r14 = r19.getAssistantSessionState(r0);     // Catch: Throwable -> L13
        if (r14 != r2) goto L24;
        return r2;
    L13:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new C10311(this, r13);
        goto L8
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public List<ProactiveSubscriptionTaskDto> listSubscriptionTasks(String r8, String r9) {
        ProactiveRecommendationDb r7 = proactiveDb();
        if (r7 == null) goto L5;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        List<fc> r10 = r7.proactiveSubscriptionTasksDao().listBySubscriptionId(r8);
    L24:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L26:
        if (r12.hasNext() == false) goto L28;
        r4.add(c.a((fc) ZeusTransformUtils.preCheckCast(r12.next(), fc.class, "com.obric.memorydata.plugin")));
        goto L26
    L28:
        List<ProactiveSubscriptionTaskDto> r13 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] listSubscriptionTasks subscriptionId=" + r8 + " taskState=" + r9 + " size=" + r13.size(), false, 4, null);
        return r13;
    L15:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L18;
    L19:
        r2 = true;
    L20:
        ProactiveSubscriptionTasksDao r14 = r7.proactiveSubscriptionTasksDao();
        if (r2 == true) goto L23;
        r10 = r14.listByState(r9);
        goto L24
    L23:
        r10 = r14.listAll();
        goto L24
    L18:
        if (StringsKt.isBlank(r5) == false) goto L20;
    L9:
        if (StringsKt.isBlank(r1) == true) goto L12;
        r3 = false;
        goto L13
    L5:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public List<ProactiveUserSubscriptionDto> listUserSubscriptions() {
        ProactiveRecommendationDb r7 = proactiveDb();
        if (r7 == null) goto L5;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7.proactiveUserSubscriptionsDao().listAll(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        r1.add(c.a((fd) ZeusTransformUtils.preCheckCast(r9.next(), fd.class, "com.obric.memorydata.plugin")));
        goto L8
    L10:
        List<ProactiveUserSubscriptionDto> r10 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] listUserSubscriptions size=" + r10.size(), false, 4, null);
        return r10;
    L5:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public ProactiveAllPageSnapshot loadAllRecommendationsSnapshot() {
        if (awaitAiProactiveDbReady(15000) == true) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadAllRecommendationsSnapshot dbNotReady", null, 4, null);
        return loadLegacyAllRecommendationsSnapshot("db_not_ready");
    L16:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        ProactiveService r1 = (ProactiveService) ZeusTransformUtils.preCheckCast(this, ProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r2 = Result.m1421constructorimpl(r1.buildLabelingAllRecommendationsSnapshot((List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$loadAllRecommendationsSnapshot$1$recommendations$1(r1, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin"), "load_all"));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r2);
        if (r3 == null) goto L15;
        RunLog.INSTANCE.error(TAG, "[Runtime] loadAllRecommendationsSnapshot failed", r3);
        r2 = loadLegacyAllRecommendationsSnapshot("ai_db_error");
    L15:
        return (ProactiveAllPageSnapshot) ZeusTransformUtils.preCheckCast(r2, ProactiveAllPageSnapshot.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public ProactiveDayPageResult loadDayRecommendationsPage(long r16, String r18, int r19, int r20) {
        if (r18 == null) goto L5;
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        String r6 = r0;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L28;
        if (r20 <= 0) goto L28;
        if (r19 < 0) goto L28;
        if (awaitAiProactiveDbReady(15000) == true) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadDayRecommendationsPage dbNotReady dayKey=" + r6 + " offset=" + r19 + " limit=" + r20, null, 4, null);
        return loadLegacyDayRecommendationsPage(r16, r6, r19, r20, "db_not_ready");
    L17:
        int r8 = RangesKt.coerceAtLeast(r19, 0);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        Object r2 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$loadDayRecommendationsPage$recommendations$1$1((ProactiveService) ZeusTransformUtils.preCheckCast(this, ProactiveService.class, "com.obric.memorydata.plugin"), null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
    L22:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r2);
        if (r3 == null) goto L25;
        RunLog.INSTANCE.error(TAG, "[Runtime] loadDayRecommendationsPage loadAiDb failed", r3);
        return loadLegacyDayRecommendationsPage(r16, r6, r8, r20, "ai_db_error");
    L25:
        return buildLabelingDayRecommendationsPage((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), r16, r6, r8, r20, "load_day");
    L20:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L28:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadDayRecommendationsPage invalid dayKey=" + r6 + " offset=" + r19 + " limit=" + r20, null, 4, null);
        return emptyDayPageResult(r16, r6);
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public ProactiveDayPageResult loadRecommendationsPage(long r19, long r21, long r23, int r25, int r26) {
        if (c.a(r21, r23) == false) goto L27;
        if (r25 < 0) goto L27;
        if (r26 <= 0) goto L27;
        if (awaitAiProactiveDbReady(15000) == true) goto L31;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadRecommendationsPage dbNotReady earliest=" + r21 + " latest=" + r23 + " offset=" + r25 + " limit=" + r26, null, 4, null);
        return emptyDayPageResult(r19, LABELING_WINDOW_PAGE_KEY);
    L31:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        ProactiveService r6 = (ProactiveService) ZeusTransformUtils.preCheckCast(this, ProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        String r2 = LABELING_WINDOW_PAGE_KEY;
        String r14 = "com.obric.memorydata.plugin";
        Object r1 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$loadRecommendationsPage$recommendations$1$1(r6, r21, r23, null), Function2.class, r14), 1, null), List.class, r14));     // Catch: Throwable -> L16
    L21:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r1);
        if (r5 == null) goto L24;
        RunLog.INSTANCE.error(TAG, "[Runtime] loadRecommendationsPage loadAiDb failed", r5);
        return emptyDayPageResult(r19, r2);
    L24:
        return buildLabelingWindowRecommendationsPage((List) ZeusTransformUtils.preCheckCast(r1, List.class, r14), r19, r21, r23, r25, r26, "load_window_page");
    L16:
        th = th;
    L20:
        Result.Companion r7 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L18:
        th = th;
        r2 = LABELING_WINDOW_PAGE_KEY;
        r14 = "com.obric.memorydata.plugin";
    L27:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadRecommendationsPage invalid earliest=" + r21 + " latest=" + r23 + " offset=" + r25 + " limit=" + r26, null, 4, null);
        return emptyDayPageResult(r19, LABELING_WINDOW_PAGE_KEY);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public ProactiveAllPageSnapshot loadRecommendationsSnapshot(long r11, long r13) {
        if (c.a(r11, r13) == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadRecommendationsSnapshot invalid earliest=" + r11 + " latest=" + r13, null, 4, null);
        return emptyAllSnapshot();
    L7:
        if (awaitAiProactiveDbReady(15000) == true) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] loadRecommendationsSnapshot dbNotReady earliest=" + r11 + " latest=" + r13, null, 4, null);
        return emptyAllSnapshot();
    L20:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        ProactiveService r1 = (ProactiveService) ZeusTransformUtils.preCheckCast(this, ProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Object r12 = Result.m1421constructorimpl(r1.buildLabelingWindowRecommendationsSnapshot((List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$loadRecommendationsSnapshot$1$recommendations$1(r1, r11, r13, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin"), r11, r13, "load_window"));     // Catch: Throwable -> L12
    L14:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r12);
        if (r14 == null) goto L19;
        RunLog.INSTANCE.error(TAG, "[Runtime] loadRecommendationsSnapshot failed", r14);
        r12 = emptyAllSnapshot();
    L19:
        return (ProactiveAllPageSnapshot) ZeusTransformUtils.preCheckCast(r12, ProactiveAllPageSnapshot.class, "com.obric.memorydata.plugin");
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void markAiProactiveRecommendationActionExecuted(long r15, int r17, AiProactiveCardStatus r18) {
        Intrinsics.checkNotNullParameter(r18, "cardStatus");
        if (r15 > 0) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] markAiProactiveRecommendationActionExecuted id=" + r15 + " actionIndex=" + r17 + " cardStatus=" + r18, false, 4, null);
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10331(this, r15, r17, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void markAiProactiveRecommendationCurrentActionExecuted(long r19) {
        if (r19 > 0) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] markAiProactiveRecommendationCurrentActionExecuted id=" + r19, false, 4, null);
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10341(this, r19, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void notifyAiProactiveRecommendationChangedFromLockScreen$ai_proactive_impl_obricRelease(long r11, String r13) {
        Intrinsics.checkNotNullParameter(r13, InfoRequestQPSOptTraceLogger.REASON);
        if (r11 > 0) goto L5;
        return;
    L5:
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$notifyAiProactiveRecommendationChangedFromLockScreen$1(this, r11, r13, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void notifyDoubaoGlassesState(final String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "key");
        Intrinsics.checkNotNullParameter(r13, EventBody.KEY_VALUE);
        if (Intrinsics.areEqual(r13, "connected") == false) goto L6;
        final boolean r14 = true;
    L8:
        int r0 = r12.hashCode();
        if (r0 == (-699175037)) goto L24;
        if (r0 == 971307492) goto L20;
        if (r0 == 2118571718) goto L16;
    L25:
        o.a(this.logger, "宿主眼镜状态通知被拒绝", "glasses_state_notification_rejected", "unsupported_state_key", null, glassesStateContext("host_state"), new $$Lambda$ProactiveService$KlLDJegaiTJfiJ1A4MoDxaWG0ik(r14), 8, null);
        return;
    L16:
        if (r12.equals("glasses_connected_state") == false) goto L25;
        com.obric.aiproactive.impl.runtime.c.f6509a.b(r14);
        return;
    L20:
        if (r12.equals("glasses_environment_memory_enabled") == false) goto L25;
        c.a(r14, (Function1) ZeusTransformUtils.preCheckCast(new C10351(com.obric.aiproactive.impl.runtime.c.f6509a), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L24:
        if (r12.equals("glasses_physical_connection_state") == false) goto L25;
        com.obric.aiproactive.impl.runtime.c.f6509a.a(r14);
        return;
    L6:
        if (Intrinsics.areEqual(r13, "disconnected") == false) goto L28;
        r14 = false;
        goto L8
    L28:
        o.a(this.logger, "宿主眼镜状态通知被拒绝", "glasses_state_notification_rejected", "unsupported_state_value", null, glassesStateContext("host_state"), new $$Lambda$ProactiveService$CYxItweYjqKXVa8_vrCbOU1pA(r12), 8, null);
    }

    public final void onCreate() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreate", false, 4, null);
        INSTANCE = this;
        com.obric.aiproactive.impl.progress.c.f6499a.a();
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(this.accountChangeListener, com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
    }

    public final void onDestroy() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onDestroy", false, 4, null);
        UserSettings.INSTANCE.unregisterLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(this.accountChangeListener, com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        getAllRecommendationsCoordinator().a();
        INSTANCE = null;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public String prepareArtifactOpenLocator(j r1) {
        Intrinsics.checkNotNullParameter(r1, "artifact");
        return AiProactiveAgentBridgeImpl.INSTANCE.prepareArtifactOpenLocator$ai_proactive_impl_obricRelease(r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void refreshAiProactive(List<String> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "refreshTypes");
        if (r11.isEmpty() == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] refreshAiProactive ignored emptyTypes", false, 4, null);
        return;
    L7:
        if (awaitAiProactiveDbReady(15000) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] refreshAiProactive dbNotReady", null, 4, null);
        return;
    L10:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L11:
        String r4 = "ProactiveRecommendation";
        if (r1.hasNext() == false) goto L22;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r3, "event_records") == false) goto L17;
        r4 = "ProactiveEventRecords";
    L20:
        if (r4 == null) goto L11;
        r2.add(r4);
        goto L11
    L17:
        if (Intrinsics.areEqual(r3, "recommendations") == true) goto L20;
        r4 = null;
        goto L20
    L22:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] refreshAiProactive no matched tables for types=" + r11, false, 4, null);
        return;
    L26:
        boolean r6 = com.obric.aiproactive.impl.aidb.b.f6306a.a((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        if (r5.contains("ProactiveRecommendation") == false) goto L29;
        getAllRecommendationsCoordinator().a("explicit");
    L29:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] refreshAiProactive types=" + r11 + " tables=" + r5 + " notified=" + r6, false, 4, null);
    }

    public final void refreshRegisteredRecommendationListeners$ai_proactive_impl_obricRelease(String r10) {
        Intrinsics.checkNotNullParameter(r10, InfoRequestQPSOptTraceLogger.REASON);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Account] refreshRegisteredRecommendationListeners reason=" + r10 + " now=" + this.nowRecommendationListeners.size() + " all=" + this.allRecommendationListeners.size() + " today=" + this.todayEventRecordJobs.size() + " ai=" + this.aiRecommendationJobs.size(), false, 4, null);
        Set<Map.Entry<ad, d>> r11 = this.nowRecommendationListeners.entrySet();
        Intrinsics.checkNotNullExpressionValue(r11, "<get-entries>(...)");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.add(TuplesKt.to(r1.getKey(), Integer.valueOf(((d) ZeusTransformUtils.preCheckCast(r1.getValue(), d.class, "com.obric.memorydata.plugin")).a())));
        goto L4
    L6:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        Collection<d> r2 = this.nowRecommendationListeners.values();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-values>(...)");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        com.obric.aiproactive.impl.now.a.f6490a.b(((d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.memorydata.plugin")).b());
        goto L8
    L10:
        this.nowRecommendationListeners.clear();
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r15.hasNext() == false) goto L15;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r15.next(), Pair.class, "com.obric.memorydata.plugin");
        Object r5 = r4.component1();
        Intrinsics.checkNotNullExpressionValue(r5, "component1(...)");
        ad r6 = (ad) ZeusTransformUtils.preCheckCast(r5, ad.class, "com.obric.memorydata.plugin");
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r4.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        r6.a(emptyNowSnapshot());
        registerNowRecommendationsListener(r7, r6);
        goto L12
    L15:
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.allRecommendationListeners, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        getAllRecommendationsCoordinator().a(currentNormalizedUid(), emptyAllSnapshot());
    L17:
        Set<com.obric.aiproactive.api.w> r16 = this.todayEventRecordJobs.keySet();
        Intrinsics.checkNotNullExpressionValue(r16, "<get-keys>(...)");
        List r17 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"));
        Collection<bx> r8 = this.todayEventRecordJobs.values();
        Intrinsics.checkNotNullExpressionValue(r8, "<get-values>(...)");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        bx.a.a((bx) ZeusTransformUtils.preCheckCast(r9.next(), bx.class, "com.obric.memorydata.plugin"), null, 1, null);
        goto L19
    L21:
        this.todayEventRecordJobs.clear();
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r18.hasNext() == false) goto L25;
        com.obric.aiproactive.api.w r19 = (com.obric.aiproactive.api.w) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.aiproactive.api.w.class, "com.obric.memorydata.plugin");
        r19.a(CollectionsKt.emptyList(), 0);
        Intrinsics.checkNotNull(r19);
        registerTodayEventRecordsListener(r19);
        goto L23
    L25:
        Set<v> r110 = this.aiRecommendationJobs.keySet();
        Intrinsics.checkNotNullExpressionValue(r110, "<get-keys>(...)");
        List r111 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin"));
        Collection<bx> r20 = this.aiRecommendationJobs.values();
        Intrinsics.checkNotNullExpressionValue(r20, "<get-values>(...)");
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r21.hasNext() == false) goto L29;
        bx.a.a((bx) ZeusTransformUtils.preCheckCast(r21.next(), bx.class, "com.obric.memorydata.plugin"), null, 1, null);
        goto L27
    L29:
        this.aiRecommendationJobs.clear();
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L31:
        if (r112.hasNext() == false) goto L33;
        v r22 = (v) ZeusTransformUtils.preCheckCast(r112.next(), v.class, "com.obric.memorydata.plugin");
        r22.a(CollectionsKt.emptyList());
        Intrinsics.checkNotNull(r22);
        registerAiProactiveRecommendationsListener(r22);
        goto L31
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void registerAgentRunListener(h r7) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "listener");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] registerAgentRunListener", false, 4, null);
        com.obric.aiproactive.impl.progress.c.f6499a.a(r6);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void registerAiProactiveRecommendationsListener(v r11) {
        v r12 = (v) ZeusTransformUtils.wrapperContextForParams(r11, v.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "listener");
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(this.aiRecommendationJobs.remove(r12), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        bx r1 = i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$registerAiProactiveRecommendationsListener$job$1(this, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        ((Map) ZeusTransformUtils.preCheckCast(this.aiRecommendationJobs, Map.class, "com.obric.memorydata.plugin")).put(r12, r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void registerAllRecommendationsListener(ac r9) {
        final ac r10 = (ac) ZeusTransformUtils.wrapperContextForParams(r9, ac.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "listener");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] registerAllRecommendationsListener firstPageLimit=50", false, 4, null);
        ConcurrentHashMap<ac, com.obric.aiproactive.impl.all.d> r0 = this.allRecommendationListeners;
        final Function1 r2 = new $$Lambda$ProactiveService$jQuI8amgDDTsMKDmWlEMtzIKro(r10);
        com.obric.aiproactive.impl.all.d r11 = r0.computeIfAbsent(r10, new $$Lambda$ProactiveService$YxUsmyfHO9CHZlRePJ885ye_vek(r2));
        Intrinsics.checkNotNullExpressionValue(r11, "computeIfAbsent(...)");
        com.obric.aiproactive.impl.all.d r12 = (com.obric.aiproactive.impl.all.d) ZeusTransformUtils.preCheckCast(r11, com.obric.aiproactive.impl.all.d.class, "com.obric.memorydata.plugin");
        getAllRecommendationsCoordinator().a(r12);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void registerNowRecommendationsListener(int r10, ad r11) {
        final ad r12 = (ad) ZeusTransformUtils.wrapperContextForParams(r11, ad.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (r10 > 0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] registerNowRecommendationsListener invalidLimit=" + r10, null, 4, null);
        r12.a(emptyNowSnapshot());
        return;
    L6:
        d r0 = (d) ZeusTransformUtils.preCheckCast(this.nowRecommendationListeners.remove(r12), d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        com.obric.aiproactive.impl.now.a.f6490a.b(r0.b());
    L9:
        com.obric.aiproactive.impl.now.c r1 = new $$Lambda$ProactiveService$z_qrJPJA0lS_l8TsFrI3v2CTxzw(r12);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] registerNowRecommendationsListener limit=" + r10, false, 4, null);
        ((Map) ZeusTransformUtils.preCheckCast(this.nowRecommendationListeners, Map.class, "com.obric.memorydata.plugin")).put(r12, new d(r10, r1));
        com.obric.aiproactive.impl.now.a.f6490a.a(r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void registerTodayEventRecordsListener(com.obric.aiproactive.api.w r11) {
        com.obric.aiproactive.api.w r12 = (com.obric.aiproactive.api.w) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.aiproactive.api.w.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "listener");
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(this.todayEventRecordJobs.remove(r12), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        bx r1 = i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveService$registerTodayEventRecordsListener$job$1(this, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        ((Map) ZeusTransformUtils.preCheckCast(this.todayEventRecordJobs, Map.class, "com.obric.memorydata.plugin")).put(r12, r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void submitAiProactiveDirectFeedback(com.obric.aiproactive.api.o r18) {
        Intrinsics.checkNotNullParameter(r18, Ext.KEY_REQUEST);
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("[Runtime] submitAiProactiveDirectFeedback type=").append(r18.a()).append(" related=");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r18.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        IRunLog.a.a(r5, TAG, r2.append(!r4).toString(), false, 4, null);
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10361(this, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L9
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public z submitAiProactiveUserRequirement(x r29) {
        Intrinsics.checkNotNullParameter(r29, Ext.KEY_REQUEST);
        long r1 = System.currentTimeMillis();
        final String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r29.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r9 = c.a(r29, r3);
        if (r9 == null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[UserRequirement] rejected requestId=" + r29.b() + " contentLength=" + r3.codePointCount(0, r3.length()) + " reason=" + r9, null, 4, null);
        return new z(false, 1, r9, r29.b(), null, false, 48, null);
    L6:
        Boolean r7 = (Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a(null, new $$Lambda$ProactiveService$r1KNZN0pMrSUSLfaxhsmpQg9qg(r3), 1, null), Boolean.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L9;
        boolean r8 = r7.booleanValue();
    L10:
        if (r8 == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[UserRequirement] dispatch failed requestId=" + r29.b(), null, 4, null);
        return new z(false, TaskResult.EXCEPTION, "dispatch_exception", r29.b(), null, false, 48, null);
    L13:
        z r10 = new z(true, 0, "dispatched", r29.b(), null, false, 48, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[UserRequirement] finished requestId=" + r29.b() + " contentLength=" + r3.codePointCount(0, r3.length()) + " code=" + r10.b() + " deduplicated=" + r10.d() + " durationMs=" + (System.currentTimeMillis() - r1), false, 4, null);
        return r10;
    L9:
        r8 = false;
        goto L10
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void toggleUserSubscription(ToggleUserSubscriptionRequest r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.getSubscriptionId(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] toggleUserSubscription id=" + r11.getSubscriptionId() + " active=" + r11.isActive(), false, 4, null);
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10371(r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public AlgorithmTaskInvokeResult triggerHiddenProactiveEntryFromAvatarFiveTap() {
        return (AlgorithmTaskInvokeResult) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C10381(null), Function2.class, "com.obric.memorydata.plugin"), 1, null), AlgorithmTaskInvokeResult.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public boolean tryActiveAiProactiveAssistantQuery(String r9) {
        Intrinsics.checkNotNullParameter(r9, ChatMessage.TYPE_QUERY);
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] tryActiveAiProactiveAssistantQuery queryLen=" + r8.length() + " preview=" + StringsKt.take(r8, 30), false, 4, null);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r5 = null;
        int r6 = 4;
        Object r7 = null;
        String r3 = TAG;
        String r4 = "[Runtime] tryActiveAiProactiveAssistantQuery ignored blank query";
    L5:
        IRunLog.a.a(r2, r3, r4, r5, r6, r7);
        return false;
    L8:
        if (com.obric.aiproactive.impl.assistant.a.f6389a.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) == true) goto L11;
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = null;
        r6 = 4;
        r7 = null;
        r3 = TAG;
        r4 = "[Runtime] tryActiveAiProactiveAssistantQuery initSdk failed";
        goto L5
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C10391(r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public boolean tryActiveAiProactiveAssistantVoiceEntry() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] tryActiveAiProactiveAssistantVoiceEntry", false, 4, null);
        if (com.obric.aiproactive.impl.assistant.a.f6389a.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] tryActiveAiProactiveAssistantVoiceEntry initSdk failed", null, 4, null);
        return false;
    L7:
        return ((Boolean) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C10401(null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void unregisterAgentRunListener(h r7) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "listener");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] unregisterAgentRunListener", false, 4, null);
        com.obric.aiproactive.impl.progress.c.f6499a.b(r6);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void unregisterAiProactiveRecommendationsListener(v r9) {
        v r10 = (v) ZeusTransformUtils.wrapperContextForParams(r9, v.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "listener");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] unregisterAiProactiveRecommendationsListener", false, 4, null);
        bx r8 = (bx) ZeusTransformUtils.preCheckCast(this.aiRecommendationJobs.remove(r10), bx.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L6;
        bx.a.a(r8, null, 1, null);
        return;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void unregisterAllRecommendationsListener(ac r9) {
        ac r10 = (ac) ZeusTransformUtils.wrapperContextForParams(r9, ac.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "listener");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] unregisterAllRecommendationsListener", false, 4, null);
        com.obric.aiproactive.impl.all.d r11 = (com.obric.aiproactive.impl.all.d) ZeusTransformUtils.preCheckCast(this.allRecommendationListeners.remove(r10), com.obric.aiproactive.impl.all.d.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L6;
        getAllRecommendationsCoordinator().b(r11);
        return;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void unregisterNowRecommendationsListener(ad r9) {
        ad r10 = (ad) ZeusTransformUtils.wrapperContextForParams(r9, ad.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "listener");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] unregisterNowRecommendationsListener", false, 4, null);
        d r8 = (d) ZeusTransformUtils.preCheckCast(this.nowRecommendationListeners.remove(r10), d.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L6;
        com.obric.aiproactive.impl.now.a.f6490a.b(r8.b());
        return;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void unregisterTodayEventRecordsListener(com.obric.aiproactive.api.w r9) {
        com.obric.aiproactive.api.w r10 = (com.obric.aiproactive.api.w) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.aiproactive.api.w.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "listener");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] unregisterTodayEventRecordsListener", false, 4, null);
        bx r8 = (bx) ZeusTransformUtils.preCheckCast(this.todayEventRecordJobs.remove(r10), bx.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L6;
        bx.a.a(r8, null, 1, null);
        return;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void updateAiProactiveRecommendationActionExecuteInstruction(long r14, String r16) {
        if (r14 > 0) goto L5;
        return;
    L5:
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("[Runtime] updateAiProactiveRecommendationActionExecuteInstruction id=").append(r14).append(" len=");
        if (r16 == null) goto L8;
        int r1 = r16.length();
    L9:
        IRunLog.a.a(r7, TAG, r0.append(r1).toString(), false, 4, null);
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10411(this, r14, r16, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L8:
        r1 = 0;
        goto L9
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void updateAiProactiveRecommendationCardStatus(long r14, AiProactiveCardStatus r16) {
        Intrinsics.checkNotNullParameter(r16, "cardStatus");
        if (r14 > 0) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] updateAiProactiveRecommendationCardStatus id=" + r14 + " cardStatus=" + r16, false, 4, null);
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10421(this, r14, r16, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void updateAiProactiveRecommendationFeedback(u r18) {
        Intrinsics.checkNotNullParameter(r18, Ext.KEY_REQUEST);
        if (r18.a() > 0) goto L5;
        return;
    L5:
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("[Runtime] updateAiProactiveRecommendationFeedback valueOnly=").append(r18.i()).append(" hasType=");
        if (r18.b() == null) goto L8;
        boolean r3 = true;
    L9:
        IRunLog.a.a(r5, TAG, r2.append(r3).toString(), false, 4, null);
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10431(this, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L8:
        r3 = false;
        goto L9
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void updateAiProactiveWakeUpEnabled(boolean r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] updateAiProactiveWakeUpEnabled enabled=" + r7, false, 4, null);
        com.obric.aiproactive.impl.runtime.a.f6507a.a(r7);
        ProactiveRecommendationEnabledStoreImpl.INSTANCE.onWakeUpPreferenceChanged();
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public AiRuleItemDto updateAiRule(String r10, String r11, AiRuleItemDto.RuleType r12) {
        Intrinsics.checkNotNullParameter(r10, "ruleId");
        Intrinsics.checkNotNullParameter(r11, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r12, "type");
        return (AiRuleItemDto) ZeusTransformUtils.preCheckCast(i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C10441(this, r10, r11, r12, null), Function2.class, "com.obric.memorydata.plugin")), AiRuleItemDto.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void updateInspiration(final ProactiveInspirationDto r8) {
        Intrinsics.checkNotNullParameter(r8, "dto");
        final ProactiveRecommendationDb r7 = proactiveDb();
        if (r7 != null) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] updateInspiration recommendId=" + r8.getRecommendId() + " inspirationId=" + r8.getInspirationId() + " status=" + r8.getRecommendStatus() + " action=" + r8.getFeedbackAction(), false, 4, null);
        final long r0 = System.currentTimeMillis();
        r7.runInTransaction(new $$Lambda$ProactiveService$q_nGYoPFal3okGi_HEGofWopHek(r7, r8, r0));
        if (r8.getRecommendStatus() != 2) goto L9;
        n.f6478a.b(r8.getRecommendId(), r8.getFeedbackAction());
        return;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void updateRecommendationActionExecuteInstruction(String r10, String r11) {
        ProactiveRecommendationDb r0 = proactiveDb();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r10 == null) goto L8;
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L9:
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L14;
        return;
    L14:
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder().append("[Runtime] updateRecommendationActionExecuteInstruction id=").append(r12).append(" len=");
        boolean r8 = false;
        if (r11 == null) goto L17;
        int r3 = r11.length();
    L18:
        IRunLog.a.a(r2, TAG, r1.append(r3).toString(), false, 4, null);
        if (r0.proactiveRecommendationsDao().updateActionExecuteInstruction(r12, r11, System.currentTimeMillis()) <= 0) goto L21;
        r8 = true;
    L21:
        requestAllRecommendationsRefreshAfterClientWrite(r8);
        return;
    L17:
        r3 = 0;
        goto L18
    L8:
        r12 = null;
        goto L9
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void upsertRecommendation(ProactiveRecommendationDto r9) {
        Intrinsics.checkNotNullParameter(r9, "dto");
        ProactiveRecommendationDb r0 = proactiveDb();
        if (r0 != null) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] upsertRecommendation id=" + r9.getRecommendId() + " status=" + r9.getStatus() + " score=" + r9.getScore(), false, 4, null);
        r0.proactiveRecommendationsDao().upsert(c.a(r9, System.currentTimeMillis()));
        requestAllRecommendationsRefreshAfterClientWrite(true);
        if (r9.getRecommendStatus() != 2) goto L9;
        n.f6478a.b(r9.getRecommendId(), r9.getInspirationFeedbackAction());
        return;
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void upsertSubscriptionTask(ProactiveSubscriptionTaskDto r3) {
        Intrinsics.checkNotNullParameter(r3, "dto");
        ProactiveRecommendationDb r2 = proactiveDb();
        if (r2 != null) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        r2.proactiveSubscriptionTasksDao().upsert(c.a(r3, r0));
    }

    @Override // com.obric.aiproactive.api.IProactiveService
    public void upsertUserSubscription(ProactiveUserSubscriptionDto r35) {
        Intrinsics.checkNotNullParameter(r35, "dto");
        final ProactiveRecommendationDb r1 = proactiveDb();
        if (r1 != null) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[Runtime] upsertUserSubscription id=" + r35.getSubscriptionId() + " active=" + r35.isActive(), false, 4, null);
        final long r5 = System.currentTimeMillis();
        final fd r4 = c.a(r35, r5);
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        String r20 = (String) ZeusTransformUtils.preCheckCast(r1.runInTransaction(new $$Lambda$ProactiveService$B5YEjmXjMRDDEfJ9r0QP1MeCI8(r1, r4, r5, r0)), String.class, "com.obric.memorydata.plugin");
        requestAllRecommendationsRefreshAfterClientWrite(r0.element);
        r1.proactivePhoneEventDao().insert(new ey(r5, 0, "ProactiveUserSubscriptions", r20, null, "pending", 0, r5, r5, null, null, 0, 2112, null));
    }
}
