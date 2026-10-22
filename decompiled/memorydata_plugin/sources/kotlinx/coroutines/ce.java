package kotlinx.coroutines;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\nµ\u0001¶\u0001·\u0001¸\u0001¹\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u001e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00112\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010L\u001a\u00020H2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0002J\u0010\u0010O\u001a\u0004\u0018\u00010\u000bH\u0084@¢\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u000bH\u0082@¢\u0006\u0002\u0010PJ\u0012\u0010R\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0017J\u0018\u0010R\u001a\u00020H2\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UH\u0016J\u0010\u0010V\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0011J\u0017\u0010W\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\bXJ\u0010\u0010Y\u001a\u00020H2\u0006\u0010S\u001a\u00020\u0011H\u0016J\u0014\u0010Z\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0002J\b\u0010\\\u001a\u00020]H\u0014J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0016J\u001a\u0010_\u001a\u00020H2\u0006\u00108\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010a\u001a\u00020H2\u0006\u00108\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010f\u001a\u00020\u00112\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010g\u001a\u00020h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010]2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0011H\u0080\b¢\u0006\u0002\bjJ\u001c\u0010k\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010l\u001a\u0004\u0018\u00010d2\u0006\u00108\u001a\u00020?H\u0002J\n\u0010m\u001a\u00060Tj\u0002`UJ\f\u0010n\u001a\u00060Tj\u0002`UH\u0016J\u000f\u0010o\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\bpJ\b\u0010q\u001a\u0004\u0018\u00010\u0011J \u0010r\u001a\u0004\u0018\u00010\u00112\u0006\u00108\u001a\u00020b2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010D2\u0006\u00108\u001a\u00020?H\u0002J\u0010\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0011H\u0014J\u0015\u0010v\u001a\u00020H2\u0006\u0010u\u001a\u00020\u0011H\u0010¢\u0006\u0002\bwJ\u0012\u0010x\u001a\u00020H2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0004JA\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00052)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J1\u0010y\u001a\u00020z2)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J(\u0010\u0082\u0001\u001a\u00020z2\u0006\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00052\u0007\u0010}\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020HH\u0086@¢\u0006\u0002\u0010PJ\t\u0010\u0086\u0001\u001a\u00020\u0005H\u0002J\u000f\u0010\u0087\u0001\u001a\u00020HH\u0082@¢\u0006\u0002\u0010PJ\"\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0015\u0010\u008a\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020H0~H\u0082\bJ\u0015\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u008c\u0001\u001a\u00020\u00052\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0003\b\u008d\u0001J\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0003\b\u008f\u0001J\u001a\u0010\u0090\u0001\u001a\u00020F2\u0007\u0010}\u001a\u00030\u0083\u00012\u0006\u0010{\u001a\u00020\u0005H\u0002J\u000f\u0010\u0091\u0001\u001a\u00020]H\u0010¢\u0006\u0003\b\u0092\u0001J\u0019\u0010\u0093\u0001\u001a\u00020H2\u0006\u0010C\u001a\u00020D2\u0006\u0010S\u001a\u00020\u0011H\u0002J)\u0010\u0094\u0001\u001a\u00020H\"\u000b\b\u0000\u0010\u0095\u0001\u0018\u0001*\u00020F2\u0006\u0010C\u001a\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0082\bJ!\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0099\u0001\u001a\u00020H2\f\u0010\u009a\u0001\u001a\u0007\u0012\u0002\b\u00030\u009b\u00012\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010{\u001a\u00020H2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0014J\u0013\u0010\u009c\u0001\u001a\u00020H2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\t\u0010\u009d\u0001\u001a\u00020HH\u0014J\u0010\u0010\u009e\u0001\u001a\u00020H2\u0007\u0010\u009f\u0001\u001a\u00020\u0003J\u0012\u0010 \u0001\u001a\u00020H2\u0007\u00108\u001a\u00030¡\u0001H\u0002J\u0011\u0010¢\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020FH\u0002J\"\u0010£\u0001\u001a\u00020H2\f\u0010\u009a\u0001\u001a\u0007\u0012\u0002\b\u00030\u009b\u00012\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0017\u0010¤\u0001\u001a\u00020H2\u0006\u0010E\u001a\u00020FH\u0000¢\u0006\u0003\b¥\u0001J\u0007\u0010¦\u0001\u001a\u00020\u0005J\u0014\u0010§\u0001\u001a\u00030¨\u00012\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\u0013\u0010©\u0001\u001a\u00020]2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\t\u0010ª\u0001\u001a\u00020]H\u0007J\t\u0010«\u0001\u001a\u00020]H\u0016J\u001b\u0010¬\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u00ad\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u001f\u0010®\u0001\u001a\u0004\u0018\u00010\u000b2\b\u00108\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u001d\u0010¯\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020?2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010°\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020b2\u0006\u0010N\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0082\u0010J\u0010\u0010±\u0001\u001a\u0004\u0018\u00010d*\u00030²\u0001H\u0002J\u0017\u0010³\u0001\u001a\u00020H*\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0002J\u001d\u0010´\u0001\u001a\u00060Tj\u0002`U*\u00020\u00112\n\b\u0002\u0010i\u001a\u0004\u0018\u00010]H\u0004R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0015\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u0006\u0012\u0002\b\u00030#8DX\u0084\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0016R\u0017\u0010*\u001a\u00020+8F¢\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R(\u00103\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\t8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00108\u001a\u0004\u0018\u00010\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0018\u0010>\u001a\u00020\u0005*\u00020?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010@¨\u0006º\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "active", "", "(Z)V", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/ChildHandle;", "_state", "", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "completionCause", "", "getCompletionCause", "()Ljava/lang/Throwable;", "completionCauseHandled", "getCompletionCauseHandled", "()Z", "handlesException", "getHandlesException$kotlinx_coroutines_core", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onAwaitInternal", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "()V", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent", "()Lkotlinx/coroutines/Job;", EventBody.KEY_VALUE, "parentHandle", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)Z", "addLastAtomic", "expect", Constants.KEY_LIST, "Lkotlinx/coroutines/NodeList;", "node", "Lkotlinx/coroutines/JobNode;", "addSuppressedExceptions", "", "rootCause", "exceptions", "", "afterCompletion", "attachChild", "child", "awaitInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelCoroutine", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelInternal", "cancelMakeCompleting", "cancelParent", "cancellationExceptionMessage", "", "childCancelled", "completeStateFinalization", BuildConfig.CHANNEL, "continueCompleting", "Lkotlinx/coroutines/JobSupport$Finishing;", "lastChild", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "createCauseException", "defaultCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "message", "defaultCancellationException$kotlinx_coroutines_core", "finalizeFinishingState", "firstChild", "getCancellationException", "getChildJobCancellationCause", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionExceptionOrNull", "getFinalRootCause", "getOrPromoteCancellingList", "handleJobException", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "handleOnCompletionException", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "Lkotlinx/coroutines/CompletionHandler;", "invokeOnCompletionInternal", "Lkotlinx/coroutines/InternalCompletionHandler;", "invokeOnCompletionInternal$kotlinx_coroutines_core", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "nameString$kotlinx_coroutines_core", "notifyCancelling", "notifyHandlers", ExifInterface.GPS_DIRECTION_TRUE, "onAwaitInternalProcessResFunc", "ignoredParam", "result", "onAwaitInternalRegFunc", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onCompletionInternal", "onStart", "parentCancelled", "parentJob", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "registerSelectForOnJoin", "removeNode", "removeNode$kotlinx_coroutines_core", CommonConsts.APM_INNER_EVENT_COST_START, "startInternal", "", "stateString", "toDebugString", "toString", "tryFinalizeSimpleState", "tryMakeCancelling", "tryMakeCompleting", "tryMakeCompletingSlowPath", "tryWaitForChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "AwaitContinuation", "ChildCompletion", "Finishing", "SelectOnAwaitCompletionHandler", "SelectOnJoinCompletionHandler", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ce implements cn, v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17256b = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = null;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class a<T> extends o<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ce f17257b;

        public a(Continuation<? super T> r3, ce r4) {
            super((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"), 1);
            this.f17257b = r4;
        }

        @Override // kotlinx.coroutines.o
        public Throwable a(bx r3) {
            bx r4 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
            Object r2 = this.f17257b.o();
            if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L8;
            Throwable r0 = ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).d();
            if (r0 == null) goto L8;
            return r0;
        L8:
            if (ZeusTransformUtils.instanceOf(r2, ab.class) == false) goto L12;
            return ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.memorydata.plugin")).f17205a;
        L12:
            return (Throwable) ZeusTransformUtils.preCheckCast(r4.t_(), Throwable.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.o
        public String k() {
            return "AwaitContinuation";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class b extends cd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ce f17258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f17259b;
        private final u d;
        private final Object e;

        public b(ce r1, c r2, u r3, Object r4) {
            this.f17258a = r1;
            this.f17259b = r2;
            this.d = r3;
            this.e = r4;
        }

        @Override // kotlinx.coroutines.bt
        public void a(Throwable r3) {
            ce.a(this.f17258a, this.f17259b, this.d, this.e);
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tJ\u0018\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0&j\b\u0012\u0004\u0012\u00020\t`'H\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0)2\b\u0010*\u001a\u0004\u0018\u00010\tJ\b\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fX\u0082\u0004R(\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0017\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", Constants.KEY_LIST, "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "Lkotlinx/atomicfu/AtomicRef;", "_isCompleting", "Lkotlinx/atomicfu/AtomicBoolean;", "_rootCause", EventBody.KEY_VALUE, "exceptionsHolder", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "(Ljava/lang/Throwable;)V", "addExceptionLocked", "", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class c implements br {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f17260b = null;
        private static final /* synthetic */ AtomicReferenceFieldUpdater c = null;
        private static final /* synthetic */ AtomicReferenceFieldUpdater d = null;
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final cj f17261a;

        static {
            f17260b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");
            c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");
            d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        }

        public c(cj r1, boolean r2, Throwable r3) {
            this.f17261a = r1;
            this._isCompleting$volatile = r2 ? 1 : 0;
            this._rootCause$volatile = r3;
        }

        private final void a(Object r2) {
            k().set(this, r2);
        }

        private final Object g() {
            return k().get(this);
        }

        private final ArrayList<Throwable> h() {
            return new ArrayList(4);
        }

        private static final /* synthetic */ AtomicIntegerFieldUpdater i() {
            return f17260b;
        }

        private static final /* synthetic */ AtomicReferenceFieldUpdater j() {
            return c;
        }

        private static final /* synthetic */ AtomicReferenceFieldUpdater k() {
            return d;
        }

        public final void a(Throwable r2) {
            j().set(this, r2);
        }

        public final void a(boolean r2) {
            i().set(this, r2 ? 1 : 0);
        }

        public final List<Throwable> b(Throwable r5) {
            Object r0 = g();
            if (r0 != null) goto L6;
            ArrayList<Throwable> r1 = h();
        L11:
            Throwable r2 = d();
            if (r2 == null) goto L14;
            r1.add(0, r2);
        L14:
            if (r5 != null) goto L16;
        L18:
            a(cf.f());
            return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        L16:
            if (Intrinsics.areEqual(r5, r2) == true) goto L18;
            r1.add(r5);
            goto L18
        L6:
            if (ZeusTransformUtils.instanceOf(r0, Throwable.class) == false) goto L9;
            ArrayList<Throwable> r3 = h();
            r3.add(r0);
            r1 = r3;
            goto L11
        L9:
            if (ZeusTransformUtils.instanceOf(r0, ArrayList.class) == false) goto L21;
            r1 = (ArrayList) ZeusTransformUtils.preCheckCast(r0, ArrayList.class, "com.obric.memorydata.plugin");
            goto L11
        L21:
            throw new IllegalStateException(("State is " + r0).toString());
        }

        public final void c(Throwable r3) {
            Throwable r0 = d();
            if (r0 != null) goto L6;
            a(r3);
            return;
        L6:
            if (r3 != r0) goto L8;
            return;
        L8:
            Object r1 = g();
            if (r1 != null) goto L12;
            a(r3);
            return;
        L12:
            if (ZeusTransformUtils.instanceOf(r1, Throwable.class) == false) goto L17;
            if (r3 != r1) goto L15;
            return;
        L15:
            ArrayList<Throwable> r2 = h();
            r2.add(r1);
            r2.add(r3);
            a(r2);
            return;
        L17:
            if (ZeusTransformUtils.instanceOf(r1, ArrayList.class) == false) goto L21;
            ((ArrayList) ZeusTransformUtils.preCheckCast(r1, ArrayList.class, "com.obric.memorydata.plugin")).add(r3);
            return;
        L21:
            throw new IllegalStateException(("State is " + r1).toString());
        }

        public final boolean c() {
            if (i().get(this) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final Throwable d() {
            return (Throwable) ZeusTransformUtils.preCheckCast(j().get(this), Throwable.class, "com.obric.memorydata.plugin");
        }

        public final boolean e() {
            if (g() != cf.f()) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean f() {
            if (d() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.br
        public boolean m_() {
            if (d() != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.br
        public cj n_() {
            return this.f17261a;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + c() + ", rootCause=" + d() + ", exceptions=" + g() + ", list=" + n_() + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class d extends cd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ce f17262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlinx.coroutines.selects.m<?> f17263b;

        public d(ce r3, kotlinx.coroutines.selects.m<?> r4) {
            kotlinx.coroutines.selects.m<?> r5 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
            this.f17262a = r3;
            this.f17263b = r5;
        }

        @Override // kotlinx.coroutines.bt
        public void a(Throwable r2) {
            Object r3 = this.f17262a.o();
            if (ZeusTransformUtils.instanceOf(r3, ab.class) == true) goto L6;
            r3 = cf.b(r3);
        L6:
            this.f17263b.a(this.f17262a, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class e extends cd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ce f17264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlinx.coroutines.selects.m<?> f17265b;

        public e(ce r3, kotlinx.coroutines.selects.m<?> r4) {
            kotlinx.coroutines.selects.m<?> r5 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
            this.f17264a = r3;
            this.f17265b = r5;
        }

        @Override // kotlinx.coroutines.bt
        public void a(Throwable r2) {
            this.f17265b.a(this.f17264a, Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", LBSLightLocationTraceLogger.PREPARE, "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class f extends kotlinx.coroutines.internal.v.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ce f17266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f17267b;

        public f(kotlinx.coroutines.internal.v r1, ce r2, Object r3) {
            this.f17266a = r2;
            this.f17267b = r3;
            super(r1);
        }

        @Override // kotlinx.coroutines.internal.b
        public /* synthetic */ Object a(kotlinx.coroutines.internal.v r3) {
            return a2((kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public Object a2(kotlinx.coroutines.internal.v r1) {
            if (this.f17266a.o() != this.f17267b) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return null;
        L9:
            return kotlinx.coroutines.internal.u.a();
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
        f17256b = AtomicReferenceFieldUpdater.newUpdater(ce.class, Object.class, "_state$volatile");
        c = AtomicReferenceFieldUpdater.newUpdater(ce.class, Object.class, "_parentHandle$volatile");
    }

    public ce(boolean r1) {
        if (r1 == false) goto L5;
        bf r2 = cf.a();
    L6:
        this._state$volatile = r2;
        return;
    L5:
        r2 = cf.b();
        goto L6
    }

    private final int a(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, bf.class) == false) goto L13;
        if (((bf) ZeusTransformUtils.preCheckCast(r6, bf.class, "com.obric.memorydata.plugin")).m_() == false) goto L8;
        return 0;
    L8:
        if (t().compareAndSet(this, r6, cf.a()) == true) goto L10;
        return -1;
    L10:
        p();
        return 1;
    L13:
        if (ZeusTransformUtils.instanceOf(r6, bq.class) == true) goto L15;
        return 0;
    L15:
        if (t().compareAndSet(this, r6, ((bq) ZeusTransformUtils.preCheckCast(r6, bq.class, "com.obric.memorydata.plugin")).n_()) == true) goto L17;
        return -1;
    L17:
        p();
        return 1;
    }

    private final Object a(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r3, br.class) == true) goto L7;
        return cf.c();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, bf.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r3, cd.class) == true) goto L11;
    L20:
        return c((br) ZeusTransformUtils.preCheckCast(r3, br.class, "com.obric.memorydata.plugin"), r4);
    L11:
        if (ZeusTransformUtils.instanceOf(r3, u.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, ab.class) == true) goto L20;
        if (a((br) ZeusTransformUtils.preCheckCast(r3, br.class, "com.obric.memorydata.plugin"), r4) == false) goto L18;
        return r4;
    L18:
        return cf.e();
    }

    private final Object a(Continuation<? super Unit> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r11), 1);
        r0.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        q.a(r2, ca.a((bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin"), false, false, (bt) ZeusTransformUtils.preCheckCast(new cp((Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin")), bt.class, "com.obric.memorydata.plugin"), 3, null));
        Object r9 = r0.h();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L6:
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r9;
    L9:
        return Unit.INSTANCE;
    }

    private final Object a(c r8, Object r9) {
        boolean r1 = true;
        if (an.a() == false) goto L13;
        if (o() != r8) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (an.a() == false) goto L20;
        if ((!r8.e()) == true) goto L20;
        throw new AssertionError();
    L20:
        if (an.a() == false) goto L27;
        if (r8.c() == true) goto L27;
        throw new AssertionError();
    L27:
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == false) goto L29;
        ab r2 = (ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.memorydata.plugin");
    L30:
        if (r2 == null) goto L32;
        Throwable r3 = r2.f17205a;
    L33:
        monitor-enter(r8);
        boolean r4 = r8.f();     // Catch: Throwable -> L62
        List<Throwable> r5 = r8.b(r3);     // Catch: Throwable -> L62
        Throwable r6 = a(r8, r5);     // Catch: Throwable -> L62
        if (r6 == null) goto L37;
        a(r6, r5);     // Catch: Throwable -> L62
    L37:
        monitor-exit(r8);
        if (r6 == null) goto L43;
        if (r6 == r3) goto L43;
        r9 = new ab(r6, false, 2, null);
    L43:
        if (r6 != null) goto L45;
    L52:
        if (r4 == true) goto L54;
        e(r6);
    L54:
        b(r9);
        boolean r7 = t().compareAndSet(this, r8, cf.a(r9));
        if (an.a() == false) goto L60;
        if (r7 == true) goto L60;
        throw new AssertionError();
    L60:
        b((br) ZeusTransformUtils.preCheckCast(r8, br.class, "com.obric.memorydata.plugin"), r9);
        return r9;
    L45:
        if (g(r6) == false) goto L47;
    L50:
        if (r1 == false) goto L52;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.memorydata.plugin")).c();
        goto L52
    L47:
        if (f(r6) == true) goto L50;
        r1 = false;
    L62:
        th = move-exception;
        throw th;
    L32:
        r3 = null;
        goto L33
    L29:
        r2 = null;
        goto L30
    }

    public static final /* synthetic */ Object a(ce r0, Object r1, Object r2) {
        return r0.b(r1, r2);
    }

    public static final /* synthetic */ String a(ce r0) {
        return r0.b();
    }

    private final Throwable a(c r7, List<? extends Throwable> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Object r2 = null;
        if (r9.isEmpty() == true) goto L5;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        Object r10 = r6.next();
        if ((!ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.memorydata.plugin"), CancellationException.class)) == false) goto L11;
    L16:
        Throwable r11 = (Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L19;
        return r11;
    L19:
        Throwable r12 = (Throwable) ZeusTransformUtils.preCheckCast(r9.get(0), Throwable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, TimeoutCancellationException.class) == false) goto L35;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r13.hasNext() == false) goto L32;
        Object r3 = r13.next();
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin");
        if (r4 != r12) goto L27;
    L29:
        boolean r5 = false;
    L30:
        if (r5 == false) goto L23;
        r2 = r3;
        goto L32
    L27:
        if (ZeusTransformUtils.instanceOf(r4, TimeoutCancellationException.class) == false) goto L29;
        r5 = true;
    L32:
        Throwable r14 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L35;
        return r14;
    L35:
        return r12;
    L15:
        r10 = null;
        goto L16
    L5:
        if (r7.f() == true) goto L7;
        return null;
    L7:
        return (Throwable) ZeusTransformUtils.preCheckCast(new JobCancellationException(a(this), null, (bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CancellationException a(ce r0, Throwable r1, String r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = null;
    L7:
        return r0.a(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final cd a(bt r3, boolean r4) {
        bt r5 = (bt) ZeusTransformUtils.wrapperContextForParams(r3, bt.class, "com.obric.memorydata.plugin");
        cd r0 = null;
        if (r4 == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r5, by.class) == false) goto L7;
        r0 = (by) ZeusTransformUtils.preCheckCast(r5, by.class, "com.obric.memorydata.plugin");
    L7:
        if (r0 != null) goto L9;
        r0 = (by) ZeusTransformUtils.preCheckCast(new bv(r5), by.class, "com.obric.memorydata.plugin");
    L9:
        Object r6 = ZeusTransformUtils.preCheckCast(r0, cd.class, "com.obric.memorydata.plugin");
    L23:
        cd r7 = (cd) r6;
    L24:
        r7.a(this);
        return r7;
    L11:
        if (ZeusTransformUtils.instanceOf(r5, cd.class) == false) goto L13;
        r0 = (cd) ZeusTransformUtils.preCheckCast(r5, cd.class, "com.obric.memorydata.plugin");
    L13:
        if (r0 != null) goto L15;
        r6 = ZeusTransformUtils.preCheckCast(new bw(r5), cd.class, "com.obric.memorydata.plugin");
        goto L23
    L15:
        if (an.a() == true) goto L17;
    L21:
        r7 = r0;
        goto L24
    L17:
        if ((!ZeusTransformUtils.instanceOf(r0, by.class)) == true) goto L21;
        throw new AssertionError();
    }

    private final cj a(br r3) {
        br r4 = (br) ZeusTransformUtils.wrapperContextForParams(r3, br.class, "com.obric.memorydata.plugin");
        cj r0 = r4.n_();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, bf.class) == false) goto L8;
        return new cj();
    L8:
        if (ZeusTransformUtils.instanceOf(r4, cd.class) == false) goto L11;
        b((cd) ZeusTransformUtils.preCheckCast(r4, cd.class, "com.obric.memorydata.plugin"));
        return null;
    L11:
        throw new IllegalStateException(("State should have list: " + r4).toString());
    }

    private final u a(kotlinx.coroutines.internal.v r2) {
    L3:
        if (r2.d() == false) goto L5;
        r2 = r2.h();
    L5:
        r2 = r2.g();
        if (r2.d() == true) goto L5;
        if (ZeusTransformUtils.instanceOf(r2, u.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, cj.class) == false) goto L5;
        return null;
    L10:
        return (u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.memorydata.plugin");
    }

    private final void a(Throwable r5, List<? extends Throwable> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r4.size() > 1) goto L5;
        return;
    L5:
        Set r7 = Collections.newSetFromMap((Map) ZeusTransformUtils.preCheckCast(new IdentityHashMap(r4.size()), Map.class, "com.obric.memorydata.plugin"));
        if (an.c() == true) goto L8;
        Throwable r1 = r5;
    L9:
        Iterator r8 = r4.iterator();
    L11:
        if (r8.hasNext() == false) goto L23;
        Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(r8.next(), Throwable.class, "com.obric.memorydata.plugin");
        if (an.c() == false) goto L16;
        r2 = kotlinx.coroutines.internal.ai.b(r2);
    L16:
        if (r2 == r5) goto L11;
        if (r2 == r1) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, CancellationException.class) == true) goto L11;
        if (r7.add(r2) == false) goto L11;
        ExceptionsKt.addSuppressed(r5, r2);
        goto L11
    L23:
        return;
    L8:
        r1 = kotlinx.coroutines.internal.ai.b(r5);
        goto L9
    }

    private final void a(bf r4) {
        cj r0 = new cj();
        if (r4.m_() == false) goto L5;
        Object r1 = ZeusTransformUtils.preCheckCast(r0, br.class, "com.obric.memorydata.plugin");
    L6:
        AtomicReferenceFieldUpdater r2 = t();
        r2.compareAndSet(this, r4, (br) r1);
        return;
    L5:
        r1 = ZeusTransformUtils.preCheckCast(new bq(r0), br.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public static final /* synthetic */ void a(ce r0, c r1, u r2, Object r3) {
        r0.b(r1, r2, r3);
    }

    public static final /* synthetic */ void a(ce r2, kotlinx.coroutines.selects.m r3, Object r4) {
        r2.a((kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void a(cj r8, Throwable r9) {
        e(r9);
        kotlinx.coroutines.internal.t r10 = (kotlinx.coroutines.internal.t) ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.internal.t.class, "com.obric.memorydata.plugin");
        Object r0 = r10.f();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        kotlinx.coroutines.internal.v r1 = (kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin");
        CompletionHandlerException r2 = null;
    L4:
        if (Intrinsics.areEqual(r1, r10) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r1, by.class) == false) goto L16;
        cd r3 = (cd) ZeusTransformUtils.preCheckCast(r1, cd.class, "com.obric.memorydata.plugin");
        r3.a(r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        ExceptionsKt.addSuppressed(r5, th);
        if (r5 != null) goto L16;
    L15:
        r2 = new CompletionHandlerException("Exception in completion handler " + r3 + " for " + this, th);
        Unit r4 = Unit.INSTANCE;
    L16:
        r1 = r1.g();
        goto L4
    L17:
        Throwable r11 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L20;
        a_(r11);
    L20:
        g(r9);
    }

    private final void a(kotlinx.coroutines.selects.m<?> r8, Object r9) {
        kotlinx.coroutines.selects.m r10 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
        if (g() == true) goto L6;
        r10.a(Unit.INSTANCE);
        return;
    L6:
        r10.a(ca.a((bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin"), false, false, (bt) ZeusTransformUtils.preCheckCast(new e(this, r10), bt.class, "com.obric.memorydata.plugin"), 3, null));
    }

    private final boolean a(Object r4, cj r5, cd r6) {
        kotlinx.coroutines.internal.v r7 = (kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.internal.v.a r3 = (kotlinx.coroutines.internal.v.a) ZeusTransformUtils.preCheckCast(new f((kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin"), this, r4), kotlinx.coroutines.internal.v.a.class, "com.obric.memorydata.plugin");
    L3:
        int r8 = r7.h().a((kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin"), r7, r3);
        if (r8 == 1) goto L13;
        if (r8 != 2) goto L3;
        return false;
    L13:
        return true;
    }

    private final boolean a(br r5, Object r6) {
        br r7 = (br) ZeusTransformUtils.wrapperContextForParams(r5, br.class, "com.obric.memorydata.plugin");
        if (an.a() == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r7, bf.class) == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L16;
        throw new AssertionError();
    L7:
        if (ZeusTransformUtils.instanceOf(r7, cd.class) == true) goto L10;
        r0 = false;
    L16:
        if (an.a() == false) goto L23;
        if ((!ZeusTransformUtils.instanceOf(r6, ab.class)) == true) goto L23;
        throw new AssertionError();
    L23:
        if (t().compareAndSet(this, r7, cf.a(r6)) == true) goto L25;
        return false;
    L25:
        e(null);
        b(r6);
        b(r7, r6);
        return true;
    }

    private final boolean a(br r6, Throwable r7) {
        br r8 = (br) ZeusTransformUtils.wrapperContextForParams(r6, br.class, "com.obric.memorydata.plugin");
        if (an.a() == false) goto L10;
        if ((!ZeusTransformUtils.instanceOf(r8, c.class)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (an.a() == true) goto L12;
    L16:
        cj r0 = a(r8);
        if (r0 != null) goto L20;
        return false;
    L20:
        if (t().compareAndSet(this, r8, new c(r0, false, r7)) == true) goto L22;
        return false;
    L22:
        a(r0, r7);
        return true;
    L12:
        if (r8.m_() == true) goto L16;
        throw new AssertionError();
    }

    private final boolean a(c r10, u r11, Object r12) {
    L3:
        if (ca.a((bx) ZeusTransformUtils.preCheckCast(r11.f17661a, bx.class, "com.obric.memorydata.plugin"), false, false, (bt) ZeusTransformUtils.preCheckCast(new b(this, r10, r11, r12), bt.class, "com.obric.memorydata.plugin"), 1, null) != cl.f17297a) goto L4;
        r11 = a((kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r11, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin"));
        if (r11 != null) goto L3;
        return false;
    L4:
        return true;
    }

    private final Object b(Object r1, Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == true) goto L6;
        return r2;
    L6:
        throw ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.memorydata.plugin")).f17205a;
    }

    private final u b(br r4) {
        br r5 = (br) ZeusTransformUtils.wrapperContextForParams(r4, br.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, u.class) == false) goto L5;
        u r0 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 != null) goto L11;
        cj r6 = r5.n_();
        if (r6 != null) goto L13;
        return null;
    L13:
        return a((kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin"));
    L11:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    private final void b(br r5, Object r6) {
        br r7 = (br) ZeusTransformUtils.wrapperContextForParams(r5, br.class, "com.obric.memorydata.plugin");
        t r0 = n();
        if (r0 == null) goto L5;
        r0.dispose();
        a((t) ZeusTransformUtils.preCheckCast(cl.f17297a, t.class, "com.obric.memorydata.plugin"));
    L5:
        Throwable r2 = null;
        if (ZeusTransformUtils.instanceOf(r6, ab.class) == false) goto L8;
        ab r8 = (ab) ZeusTransformUtils.preCheckCast(r6, ab.class, "com.obric.memorydata.plugin");
    L9:
        if (r8 == null) goto L12;
        r2 = r8.f17205a;
    L12:
        if (ZeusTransformUtils.instanceOf(r7, cd.class) == true) goto L21;
        cj r9 = r7.n_();
        if (r9 == null) goto L24;
        b(r9, r2);
        return;
    L24:
        return;
    L21:
        ((cd) ZeusTransformUtils.preCheckCast(r7, cd.class, "com.obric.memorydata.plugin")).a(r2);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        a_((Throwable) ZeusTransformUtils.preCheckCast(new CompletionHandlerException("Exception in completion handler " + r7 + " for " + this, th), Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        r8 = null;
        goto L9
    }

    private final void b(cd r4) {
        r4.a((kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(new cj(), kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.internal.v r0 = r4.g();
        t().compareAndSet(this, r4, r0);
    }

    private final void b(c r3, u r4, Object r5) {
        if (an.a() == true) goto L5;
    L12:
        u r6 = a((kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin"));
        if (r6 != null) goto L15;
    L17:
        d(a(r3, r5));
        return;
    L15:
        if (a(r3, r6, r5) == false) goto L17;
        return;
    L5:
        if (o() != r3) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    public static final /* synthetic */ void b(ce r2, kotlinx.coroutines.selects.m r3, Object r4) {
        r2.b((kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void b(cj r8, Throwable r9) {
        kotlinx.coroutines.internal.t r10 = (kotlinx.coroutines.internal.t) ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.internal.t.class, "com.obric.memorydata.plugin");
        Object r0 = r10.f();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        kotlinx.coroutines.internal.v r1 = (kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin");
        CompletionHandlerException r2 = null;
    L4:
        if (Intrinsics.areEqual(r1, r10) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r1, cd.class) == false) goto L16;
        cd r3 = (cd) ZeusTransformUtils.preCheckCast(r1, cd.class, "com.obric.memorydata.plugin");
        r3.a(r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        ExceptionsKt.addSuppressed(r5, th);
        if (r5 != null) goto L16;
    L15:
        r2 = new CompletionHandlerException("Exception in completion handler " + r3 + " for " + this, th);
        Unit r4 = Unit.INSTANCE;
    L16:
        r1 = r1.g();
        goto L4
    L17:
        Throwable r11 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L28;
        a_(r11);
        return;
    }

    private final void b(kotlinx.coroutines.selects.m<?> r8, Object r9) {
        kotlinx.coroutines.selects.m r10 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
    L3:
        Object r11 = o();
        if (ZeusTransformUtils.instanceOf(r11, br.class) == false) goto L6;
        if (a(r11) < 0) goto L3;
        r10.a(ca.a((bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin"), false, false, (bt) ZeusTransformUtils.preCheckCast(new d(this, r10), bt.class, "com.obric.memorydata.plugin"), 3, null));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r11, ab.class) == true) goto L9;
        r11 = cf.b(r11);
    L9:
        r10.a(r11);
    }

    private final Object c(Object r7) {
    L2:
        Object r0 = o();
        if (ZeusTransformUtils.instanceOf(r0, br.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r0, c.class) == true) goto L7;
    L9:
        Object r1 = a(r0, new ab(h(r7), false, 2, null));
        if (r1 == cf.e()) goto L2;
        return r1;
    L7:
        if (((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin")).c() == false) goto L9;
    L13:
        return cf.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object c(br r10, Object r11) {
        br r12 = (br) ZeusTransformUtils.wrapperContextForParams(r10, br.class, "com.obric.memorydata.plugin");
        cj r0 = a(r12);
        if (r0 == null) goto L5;
        T r2 = 0;
        if (ZeusTransformUtils.instanceOf(r12, c.class) == false) goto L9;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.memorydata.plugin");
    L10:
        boolean r3 = false;
        if (r1 != null) goto L13;
        r1 = new c(r0, false, null);
    L13:
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        monitor-enter(r1);
    L60:
        th = move-exception;
        throw th;
    L16:
        if (r1.c() == false) goto L21;
        kotlinx.coroutines.internal.aj r9 = cf.c();     // Catch: Throwable -> L60
        monitor-exit(r1);
        return r9;
    L21:
        r1.a(true);     // Catch: Throwable -> L60
        if (r1 == r12) goto L29;
        if (t().compareAndSet(this, r12, r1) == true) goto L29;
        kotlinx.coroutines.internal.aj r13 = cf.e();     // Catch: Throwable -> L60
        monitor-exit(r1);
        return r13;
    L29:
        if (an.a() == true) goto L31;
    L35:
        boolean r6 = r1.f();     // Catch: Throwable -> L60
        if (ZeusTransformUtils.instanceOf(r11, ab.class) == false) goto L38;
        ab r7 = (ab) ZeusTransformUtils.preCheckCast(r11, ab.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
    L39:
        if (r7 == null) goto L41;
        r1.c(r7.f17205a);     // Catch: Throwable -> L60
    L41:
        Throwable r8 = r1.d();     // Catch: Throwable -> L60
        if (r6 == true) goto L45;
        r3 = true;
    L45:
        if (Boolean.valueOf(r3).booleanValue() == false) goto L47;
        r2 = r8;
    L47:
        r4.element = r2;     // Catch: Throwable -> L60
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L60
        monitor-exit(r1);
        Throwable r14 = (Throwable) ZeusTransformUtils.preCheckCast(r4.element, Throwable.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L52;
        a(r0, r14);
    L52:
        u r15 = b(r12);
        if (r15 == null) goto L59;
        if (a(r1, r15, r11) == false) goto L59;
        return cf.f17268a;
    L59:
        return a(r1, r11);
    L38:
        r7 = null;
        goto L39
    L31:
        if ((!r1.e()) == true) goto L35;
        throw new AssertionError();     // Catch: Throwable -> L60
    L9:
        r1 = null;
        goto L10
    L5:
        return cf.e();
    }

    private final Object d(Continuation<Object> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        a r0 = new a(IntrinsicsKt.intercepted(r11), this);
        r0.e();
        q.a((n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin"), ca.a((bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin"), false, false, (bt) ZeusTransformUtils.preCheckCast(new co((o) ZeusTransformUtils.preCheckCast(r0, o.class, "com.obric.memorydata.plugin")), bt.class, "com.obric.memorydata.plugin"), 3, null));
        Object r9 = r0.h();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L5:
        return r9;
    }

    private final boolean g() {
    L2:
        Object r0 = o();
        if (ZeusTransformUtils.instanceOf(r0, br.class) == false) goto L4;
        if (a(r0) < 0) goto L2;
        return true;
    L4:
        return false;
    }

    private final boolean g(Throwable r4) {
        if (d() == false) goto L5;
        return true;
    L5:
        boolean r0 = ZeusTransformUtils.instanceOf(r4, CancellationException.class);
        t r3 = n();
        if (r3 != null) goto L8;
    L16:
        return r0;
    L8:
        if (r3 == cl.f17297a) goto L16;
        if (r3.b(r4) == true) goto L17;
        if (r0 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    private final Throwable h(Object r5) {
        if (r5 != null) goto L4;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L13;
        Object r4 = ZeusTransformUtils.preCheckCast(new JobCancellationException(a(this), null, (bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin");
    L12:
        return (Throwable) r4;
    L13:
        return r6;
    L10:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        r4 = ZeusTransformUtils.preCheckCast(((cn) ZeusTransformUtils.preCheckCast(r5, cn.class, "com.obric.memorydata.plugin")).u_(), Throwable.class, "com.obric.memorydata.plugin");
        goto L12
    L4:
        r0 = ZeusTransformUtils.instanceOf(r5, Throwable.class);
        goto L6
    }

    private final Object i(Object r7) {
        Throwable r0 = null;
        Throwable r1 = null;
    L3:
        Object r2 = o();
        if (ZeusTransformUtils.instanceOf(r2, c.class) == true) goto L5;
        if (ZeusTransformUtils.instanceOf(r2, br.class) == false) goto L47;
        if (r1 != null) goto L34;
        r1 = h(r7);
    L34:
        if (((br) ZeusTransformUtils.preCheckCast(r2, br.class, "com.obric.memorydata.plugin")).m_() == true) goto L36;
        Object r3 = a(r2, new ab(r1, false, 2, null));
        if (r3 == cf.c()) goto L45;
        if (r3 == cf.e()) goto L3;
        return r3;
    L45:
        throw new IllegalStateException(("Cannot happen in " + r2).toString());
    L36:
        if (a((br) ZeusTransformUtils.preCheckCast(r2, br.class, "com.obric.memorydata.plugin"), r1) == false) goto L3;
        return cf.c();
    L47:
        return cf.d();
    L5:
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L7:
        if (((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).e() == false) goto L11;
        kotlinx.coroutines.internal.aj r6 = cf.d();     // Catch: Throwable -> L26
        monitor-exit(r2);
        return r6;
    L11:
        boolean r4 = ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).f();     // Catch: Throwable -> L26
        if (r7 != null) goto L14;
        if (r4 == false) goto L14;
    L17:
        Throwable r8 = ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).d();     // Catch: Throwable -> L26
        if ((!r4) == false) goto L21;
        r0 = r8;
    L21:
        monitor-exit(r2);
        if (r0 == null) goto L25;
        a(((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).n_(), r0);
    L25:
        return cf.c();
    L14:
        if (r1 != null) goto L16;
        r1 = h(r7);     // Catch: Throwable -> L26
    L16:
        ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).c(r1);     // Catch: Throwable -> L26
        goto L17
    }

    private final Throwable j(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ab.class) == false) goto L5;
        ab r2 = (ab) ZeusTransformUtils.preCheckCast(r3, ab.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.f17205a;
    L5:
        r2 = null;
        goto L6
    }

    private final String k(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L11;
        if (((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin")).f() == false) goto L8;
        return "Cancelling";
    L8:
        if (((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin")).c() == false) goto L22;
        return "Completing";
    L22:
        return "Active";
    L11:
        if (ZeusTransformUtils.instanceOf(r3, br.class) == false) goto L17;
        if (((br) ZeusTransformUtils.preCheckCast(r3, br.class, "com.obric.memorydata.plugin")).m_() == true) goto L26;
        return "New";
    L26:
        return "Active";
    L17:
        if (ZeusTransformUtils.instanceOf(r3, ab.class) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater t() {
        return f17256b;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater u() {
        return c;
    }

    public final CancellationException a(Throwable r4, String r5) {
        if (ZeusTransformUtils.instanceOf(r4, CancellationException.class) == false) goto L5;
        CancellationException r0 = (CancellationException) ZeusTransformUtils.preCheckCast(r4, CancellationException.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (r5 != null) goto L11;
        r5 = a(this);
    L11:
        return (CancellationException) ZeusTransformUtils.preCheckCast(new JobCancellationException(r5, r4, (bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin")), CancellationException.class, "com.obric.memorydata.plugin");
    L5:
        r0 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.bx
    public final bc a(Function1<? super Throwable, Unit> r3) {
        return a(false, true, (bt) ZeusTransformUtils.preCheckCast(new bt.a((Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin")), bt.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.bx
    public final bc a(boolean r3, boolean r4, Function1<? super Throwable, Unit> r5) {
        return a(r3, r4, (bt) ZeusTransformUtils.preCheckCast(new bt.a((Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin")), bt.class, "com.obric.memorydata.plugin"));
    }

    public final bc a(boolean r8, boolean r9, bt r10) {
        bt r11 = (bt) ZeusTransformUtils.wrapperContextForParams(r10, bt.class, "com.obric.memorydata.plugin");
        cd r0 = a(r11, r8);
    L3:
        Object r1 = o();
        if (ZeusTransformUtils.instanceOf(r1, bf.class) == true) goto L6;
        Throwable r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, br.class) == false) goto L51;
        cj r2 = ((br) ZeusTransformUtils.preCheckCast(r1, br.class, "com.obric.memorydata.plugin")).n_();
        if (r2 == null) goto L17;
        Object r4 = cl.f17297a;
        if (r8 == false) goto L44;
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L44;
        monitor-enter(r1);
        r3 = ((c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin")).d();     // Catch: Throwable -> L41
        if (r3 == null) goto L30;
        if (ZeusTransformUtils.instanceOf(r11, u.class) == false) goto L38;
        if (((c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin")).c() == false) goto L30;
    L38:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r1);
    L30:
        if (a(r1, r2, r0) == false) goto L31;
        if (r3 == null) goto L34;
        r4 = r0;
        goto L38
    L34:
        bc r7 = (bc) ZeusTransformUtils.preCheckCast(r0, bc.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        monitor-exit(r1);
        return r7;
    L31:
        monitor-exit(r1);
    L41:
        th = move-exception;
        throw th;
    L44:
        if (r3 != null) goto L45;
        if (a(r1, r2, r0) == false) goto L3;
    L9:
        Object r12 = ZeusTransformUtils.preCheckCast(r0, bc.class, "com.obric.memorydata.plugin");
    L11:
        return (bc) r12;
    L45:
        if (r9 == false) goto L47;
        r11.a(r3);
    L47:
        r12 = ZeusTransformUtils.preCheckCast(r4, bc.class, "com.obric.memorydata.plugin");
        goto L11
    L17:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        b((cd) ZeusTransformUtils.preCheckCast(r1, cd.class, "com.obric.memorydata.plugin"));
        goto L3
    L51:
        if (r9 == true) goto L53;
    L59:
        r12 = ZeusTransformUtils.preCheckCast(cl.f17297a, bc.class, "com.obric.memorydata.plugin");
        goto L11
    L53:
        if (ZeusTransformUtils.instanceOf(r1, ab.class) == false) goto L55;
        ab r13 = (ab) ZeusTransformUtils.preCheckCast(r1, ab.class, "com.obric.memorydata.plugin");
    L56:
        if (r13 == null) goto L58;
        r3 = r13.f17205a;
    L58:
        r11.a(r3);
        goto L59
    L55:
        r13 = null;
        goto L56
    L6:
        if (((bf) ZeusTransformUtils.preCheckCast(r1, bf.class, "com.obric.memorydata.plugin")).m_() == true) goto L8;
        a((bf) ZeusTransformUtils.preCheckCast(r1, bf.class, "com.obric.memorydata.plugin"));
        goto L3
    L8:
        if (t().compareAndSet(this, r1, r0) == false) goto L3;
        goto L9
    }

    @Override // kotlinx.coroutines.bx
    public final t a(v r9) {
        v r10 = (v) ZeusTransformUtils.wrapperContextForParams(r9, v.class, "com.obric.memorydata.plugin");
        bc r8 = ca.a((bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin"), true, false, (bt) ZeusTransformUtils.preCheckCast(new u(r10), bt.class, "com.obric.memorydata.plugin"), 2, null);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (t) ZeusTransformUtils.preCheckCast(r8, t.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.bx
    public void a(CancellationException r5) {
        if (r5 != null) goto L5;
        r5 = (CancellationException) ZeusTransformUtils.preCheckCast(new JobCancellationException(a(this), null, (bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin")), CancellationException.class, "com.obric.memorydata.plugin");
    L5:
        b((Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(bx r3) {
        bx r4 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        if (an.a() == true) goto L5;
    L12:
        if (r4 != null) goto L15;
        a((t) ZeusTransformUtils.preCheckCast(cl.f17297a, t.class, "com.obric.memorydata.plugin"));
        return;
    L15:
        r4.s_();
        t r5 = r4.a((v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.memorydata.plugin"));
        a(r5);
        if (q_() == false) goto L19;
        r5.dispose();
        a((t) ZeusTransformUtils.preCheckCast(cl.f17297a, t.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        return;
    L5:
        if (n() != null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    public final void a(cd r4) {
    L2:
        Object r0 = o();
        if (ZeusTransformUtils.instanceOf(r0, cd.class) == false) goto L10;
        if (r0 != r4) goto L5;
        if (t().compareAndSet(this, r0, cf.a()) == false) goto L2;
        return;
    L5:
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r0, br.class) == true) goto L12;
        return;
    L12:
        if (((br) ZeusTransformUtils.preCheckCast(r0, br.class, "com.obric.memorydata.plugin")).n_() == null) goto L20;
        r4.e();
        return;
    }

    @Override // kotlinx.coroutines.v
    public final void a(cn r3) {
        e((cn) ZeusTransformUtils.wrapperContextForParams(r3, cn.class, "com.obric.memorydata.plugin"));
    }

    public final void a(t r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        u().set(this, r4);
    }

    @Override // kotlinx.coroutines.bx
    public boolean a() {
        Object r2 = o();
        if (ZeusTransformUtils.instanceOf(r2, br.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((br) ZeusTransformUtils.preCheckCast(r2, br.class, "com.obric.memorydata.plugin")).m_() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.bx
    public final Object a_(Continuation<? super Unit> r3) {
        Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if (g() == true) goto L6;
        ca.a(r4.getContext());
        return Unit.INSTANCE;
    L6:
        Object r2 = a(r4);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r2;
    L10:
        return Unit.INSTANCE;
    }

    public void a_(Throwable r1) {
        throw r1;
    }

    public String b() {
        return "Job was cancelled";
    }

    public void b(Object r1) {
    }

    public void b(Throwable r1) {
        e(r1);
    }

    public final Object c(Continuation<Object> r4) {
        Continuation<Object> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
    L3:
        Object r0 = o();
        if (ZeusTransformUtils.instanceOf(r0, br.class) == false) goto L6;
        if (a(r0) < 0) goto L3;
        return d(r5);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, ab.class) == false) goto L16;
        Throwable r3 = ((ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.memorydata.plugin")).f17205a;
        if (an.c() == true) goto L10;
        throw r3;
    L10:
        if (ZeusTransformUtils.instanceOf(r5, CoroutineStackFrame.class) == true) goto L13;
        throw r3;
    L13:
        throw kotlinx.coroutines.internal.ai.a(r3, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r5, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    L16:
        return cf.b(r0);
    }

    public String c() {
        return ao.b(this);
    }

    public boolean c(Throwable r3) {
        if (ZeusTransformUtils.instanceOf(r3, CancellationException.class) == false) goto L6;
        return true;
    L6:
        if (e(r3) == true) goto L8;
    L10:
        return false;
    L8:
        if (p_() == false) goto L10;
        return true;
    }

    public void d(Object r1) {
    }

    public boolean d() {
        return false;
    }

    public final boolean d(Throwable r1) {
        return e(r1);
    }

    public void e(Throwable r1) {
    }

    public final boolean e(Object r4) {
        Object r0 = cf.c();
        if (o_() == false) goto L8;
        r0 = c(r4);
        if (r0 != cf.f17268a) goto L8;
        return true;
    L8:
        if (r0 != cf.c()) goto L11;
        r0 = i(r4);
    L11:
        if (r0 != cf.c()) goto L14;
        return true;
    L14:
        if (r0 != cf.f17268a) goto L17;
        return true;
    L17:
        if (r0 != cf.d()) goto L19;
        return false;
    L19:
        d(r0);
        return true;
    }

    public final boolean f(Object r4) {
    L2:
        Object r0 = a(o(), r4);
        if (r0 == cf.c()) goto L4;
        if (r0 == cf.f17268a) goto L8;
        if (r0 == cf.e()) goto L2;
        d(r0);
        return true;
    L8:
        return true;
    L4:
        return false;
    }

    public boolean f(Throwable r1) {
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r3, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r4) {
        return (R) bx.a.a(this, r3, (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin"));
    }

    public final Object g(Object r4) {
    L2:
        Object r0 = a(o(), r4);
        if (r0 == cf.c()) goto L8;
        if (r0 == cf.e()) goto L2;
        return r0;
    L8:
        throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + r4, j(r4));
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r3) {
        return (E) bx.a.a(this, (CoroutineContext.Key) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return (CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.bx
    public bx h() {
        t r0 = n();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // kotlinx.coroutines.bx
    public final Sequence<bx> m() {
        return SequencesKt.sequence((Function2) ZeusTransformUtils.preCheckCast(new JobSupport$children$1(this, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r3) {
        return bx.a.b(this, (CoroutineContext.Key) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
    }

    public final t n() {
        return (t) ZeusTransformUtils.preCheckCast(u().get(this), t.class, "com.obric.memorydata.plugin");
    }

    public final Object o() {
        AtomicReferenceFieldUpdater r0 = t();
    L3:
        Object r1 = r0.get(this);
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.internal.ac.class) == false) goto L5;
        ((kotlinx.coroutines.internal.ac) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.ac.class, "com.obric.memorydata.plugin")).b(this);
        goto L3
    L5:
        return r1;
    }

    public boolean o_() {
        return false;
    }

    public void p() {
    }

    public boolean p_() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r3) {
        return bx.a.a(this, (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.bx
    public final boolean q_() {
        return !ZeusTransformUtils.instanceOf(o(), br.class);
    }

    public final String r() {
        return c() + '{' + k(o()) + '}';
    }

    @Override // kotlinx.coroutines.bx
    public final boolean r_() {
        Object r2 = o();
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == false) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, c.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).f() == false) goto L9;
        goto L9
    }

    public final Object s() {
        Object r2 = o();
        if ((!ZeusTransformUtils.instanceOf(r2, br.class)) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == true) goto L9;
        return cf.b(r2);
    L9:
        throw ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.memorydata.plugin")).f17205a;
    L11:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlinx.coroutines.bx
    public final boolean s_() {
    L2:
        int r0 = a(o());
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    @Override // kotlinx.coroutines.bx
    public final CancellationException t_() {
        Object r0 = o();
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L12;
        Throwable r1 = ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin")).d();
        if (r1 == null) goto L10;
        CancellationException r2 = a(r1, ao.b(this) + " is cancelling");
        if (r2 == null) goto L10;
        return r2;
    L10:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L12:
        if (ZeusTransformUtils.instanceOf(r0, br.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r0, ab.class) == false) goto L17;
        return a(this, ((ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.memorydata.plugin")).f17205a, null, 1, null);
    L17:
        return (CancellationException) ZeusTransformUtils.preCheckCast(new JobCancellationException(ao.b(this) + " has completed normally", null, (bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin")), CancellationException.class, "com.obric.memorydata.plugin");
    L19:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public String toString() {
        return r() + '@' + ao.a(this);
    }

    @Override // kotlinx.coroutines.cn
    public CancellationException u_() {
        Object r0 = o();
        CancellationException r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L6;
        Throwable r1 = ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin")).d();
    L12:
        if (ZeusTransformUtils.instanceOf(r1, CancellationException.class) == false) goto L14;
        r2 = (CancellationException) ZeusTransformUtils.preCheckCast(r1, CancellationException.class, "com.obric.memorydata.plugin");
    L14:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return (CancellationException) ZeusTransformUtils.preCheckCast(new JobCancellationException("Parent job is " + k(r0), r1, (bx) ZeusTransformUtils.preCheckCast(this, bx.class, "com.obric.memorydata.plugin")), CancellationException.class, "com.obric.memorydata.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r0, ab.class) == false) goto L9;
        r1 = ((ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.memorydata.plugin")).f17205a;
        goto L12
    L9:
        if (ZeusTransformUtils.instanceOf(r0, br.class) == true) goto L18;
        r1 = null;
        goto L12
    L18:
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + r0).toString());
    }
}
