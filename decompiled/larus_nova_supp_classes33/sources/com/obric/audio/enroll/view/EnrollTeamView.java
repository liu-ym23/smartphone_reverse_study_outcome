package com.obric.audio.enroll.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SpeechFingerPrintEnrollService;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.audio.enroll.IEnrollService;
import com.obric.audio.enroll.animation.AnimationType;
import com.obric.audio.enroll.model.TeamEnrollState;
import com.obric.audio.enroll.model.TeamMember;
import com.obric.audio.enroll.model.TeamState;
import com.obric.audio.enroll.model.TipsCode;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.w1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ×\u00012\u00020\u00012\u00020\u0002:\u0002×\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\fJ\u000e\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020&J\b\u0010r\u001a\u00020[H\u0014J\b\u0010s\u001a\u00020[H\u0014J\u000e\u0010t\u001a\u00020[2\u0006\u0010u\u001a\u00020vJ\u0010\u0010w\u001a\u00020[2\u0006\u0010x\u001a\u00020yH\u0014J%\u0010z\u001a\u00020[2\u0006\u0010{\u001a\u00020|2\u0015\b\u0002\u0010}\u001a\u000f\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0080\u00010~J8\u0010\u0081\u0001\u001a\u00020[2\u0007\u0010\u0082\u0001\u001a\u00020l2\u0006\u0010{\u001a\u00020|2\u0007\u0010\u0083\u0001\u001a\u00020H2\u0015\b\u0002\u0010}\u001a\u000f\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0080\u00010~J&\u0010\u0084\u0001\u001a\u00020[2\u0006\u0010{\u001a\u00020|2\u0015\b\u0002\u0010}\u001a\u000f\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0080\u00010~J\u0011\u0010\u0088\u0001\u001a\u00020[2\u0006\u0010x\u001a\u00020yH\u0014J\u0010\u0010F\u001a\u00020[2\u0006\u0010x\u001a\u00020yH\u0002J\t\u0010\u0089\u0001\u001a\u00020HH\u0002J\t\u0010\u008a\u0001\u001a\u00020HH\u0002J\u0010\u0010\u008b\u0001\u001a\u00020[2\u0007\u0010\u008c\u0001\u001a\u000203J\t\u0010\u008d\u0001\u001a\u00020[H\u0002J\u0019\u0010\u008e\u0001\u001a\u00020[2\u0007\u0010\u008f\u0001\u001a\u00020\b2\u0007\u0010\u0090\u0001\u001a\u00020\bJ\t\u0010\u0091\u0001\u001a\u00020HH\u0002J\t\u0010\u0092\u0001\u001a\u00020HH\u0002J\u001b\u0010\u0093\u0001\u001a\u00020[2\u0007\u0010\u008f\u0001\u001a\u00020\b2\u0007\u0010\u0090\u0001\u001a\u00020\bH\u0002J-\u0010\u0094\u0001\u001a\u00020[2\u0007\u0010\u0095\u0001\u001a\u00020l2\u0007\u0010\u0083\u0001\u001a\u00020H2\u0007\u0010\u0096\u0001\u001a\u00020H2\u0007\u0010\u0097\u0001\u001a\u00020HH\u0002J-\u0010\u0098\u0001\u001a\u00020[2\u0007\u0010\u0095\u0001\u001a\u00020l2\u0007\u0010\u0083\u0001\u001a\u00020H2\u0007\u0010\u0099\u0001\u001a\u00020H2\u0007\u0010\u009a\u0001\u001a\u00020HH\u0002J\u0010\u0010\u009b\u0001\u001a\u00020H2\u0007\u0010\u0095\u0001\u001a\u00020lJ\u0010\u0010\u009c\u0001\u001a\u00020H2\u0007\u0010\u0095\u0001\u001a\u00020lJ\u0010\u0010\u009d\u0001\u001a\u00020H2\u0007\u0010\u0095\u0001\u001a\u00020lJ\u0010\u0010\u009e\u0001\u001a\u00020H2\u0007\u0010\u009f\u0001\u001a\u00020lJ1\u0010 \u0001\u001a\u00020[2\u0007\u0010\u0095\u0001\u001a\u00020l2\u0007\u0010\u0083\u0001\u001a\u00020H2\t\b\u0002\u0010\u009f\u0001\u001a\u00020H2\t\b\u0002\u0010¡\u0001\u001a\u00020HH\u0002J\u0007\u0010¢\u0001\u001a\u00020[J\u0007\u0010£\u0001\u001a\u00020[J\u0007\u0010¤\u0001\u001a\u00020[J\u0007\u0010¥\u0001\u001a\u00020\u007fJ\u0007\u0010¦\u0001\u001a\u00020\u007fJ\t\u0010§\u0001\u001a\u00020[H\u0002J\t\u0010¨\u0001\u001a\u00020[H\u0002J\u0010\u0010ª\u0001\u001a\u00020[2\u0007\u0010«\u0001\u001a\u00020(J\u001f\u0010¬\u0001\u001a\u00020[2\u0006\u0010]\u001a\u00020/2\f\b\u0002\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J\t\u0010®\u0001\u001a\u00020[H\u0002J\t\u0010¯\u0001\u001a\u00020[H\u0002J\t\u0010°\u0001\u001a\u00020[H\u0002J\t\u0010±\u0001\u001a\u00020[H\u0002J\"\u0010²\u0001\u001a\u00020[2\u0007\u0010³\u0001\u001a\u00020/2\u0007\u0010´\u0001\u001a\u00020/H\u0082@¢\u0006\u0003\u0010µ\u0001J\t\u0010¶\u0001\u001a\u00020[H\u0002J\t\u0010·\u0001\u001a\u00020[H\u0002J\u0010\u0010¸\u0001\u001a\u00020[H\u0082@¢\u0006\u0003\u0010¹\u0001J\r\u0010¼\u0001\u001a\u00020\b*\u00020\u007fH\u0002J\r\u0010½\u0001\u001a\u00020\u007f*\u00020\u007fH\u0002J\t\u0010¾\u0001\u001a\u00020\u007fH\u0002J\u001b\u0010¿\u0001\u001a\u0002032\u0007\u0010À\u0001\u001a\u00020\u007f2\u0007\u0010Á\u0001\u001a\u00020\u007fH\u0002J\u0011\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010\u009f\u0001\u001a\u00020lJ\u001a\u0010Ä\u0001\u001a\u00020[2\b\u0010Å\u0001\u001a\u00030Ã\u00012\u0007\u0010Æ\u0001\u001a\u00020HJ\r\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020m0jJ\u0017\u0010È\u0001\u001a\u00020[2\u000e\u0010É\u0001\u001a\t\u0012\u0004\u0012\u00020[0Ê\u0001J\u0012\u0010Ë\u0001\u001a\u00020[2\u0007\u0010Ì\u0001\u001a\u00020HH\u0002J\u0012\u0010Í\u0001\u001a\u00020[2\u0007\u0010Î\u0001\u001a\u00020\u007fH\u0002J&\u0010Ï\u0001\u001a\u00020[2\u0007\u0010Ð\u0001\u001a\u0002032\u0007\u0010Ñ\u0001\u001a\u00020\u007f2\t\b\u0002\u0010Ò\u0001\u001a\u00020\u007fH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u000e\u0010F\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bP\u0010QR\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u001cR\u0014\u0010X\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u001cR\u001a\u0010]\u001a\u00020^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0011\u0010c\u001a\u00020d¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0011\u0010g\u001a\u00020d¢\u0006\b\n\u0000\u001a\u0004\bh\u0010fR \u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020m0k0jX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0085\u0001\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010S\u001a\u0005\b\u0086\u0001\u0010QR\u000f\u0010©\u0001\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010º\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\b»\u0001\u0010\u001cR\u0018\u0010Ó\u0001\u001a\u00030Ô\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÕ\u0001\u0010Ö\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/obric/audio/enroll/view/EnrollTeamView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "enrollHandleContext", "Lkotlin/coroutines/CoroutineContext;", "enrollHandleScope", "Lkotlinx/coroutines/CoroutineScope;", "enrollProgressContext", "enrollProgressScope", "viewModel", "Lcom/obric/audio/enroll/vm/EnrollViewModel;", "getViewModel", "()Lcom/obric/audio/enroll/vm/EnrollViewModel;", "historyLength", "index", "getIndex", "()I", "setIndex", "(I)V", "uuid", "Ljava/util/UUID;", "getUuid", "()Ljava/util/UUID;", "setUuid", "(Ljava/util/UUID;)V", "team", "Lcom/obric/audio/enroll/model/EnrollTeam;", "asrResponse", "Lcom/obric/audio/enroll/asr/AsrResponse;", "getAsrResponse", "()Lcom/obric/audio/enroll/asr/AsrResponse;", "setAsrResponse", "(Lcom/obric/audio/enroll/asr/AsrResponse;)V", "enrollState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/audio/enroll/model/TeamEnrollState;", "getEnrollState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "shouldRenewAsrTaskUuidOnNextStart", "", "timeoutTimer", "Landroid/os/CountDownTimer;", "getTimeoutTimer", "()Landroid/os/CountDownTimer;", "setTimeoutTimer", "(Landroid/os/CountDownTimer;)V", "sentenceAsrTimer", "getSentenceAsrTimer", "setSentenceAsrTimer", "asrTimerJob", "Lkotlinx/coroutines/Job;", "getAsrTimerJob", "()Lkotlinx/coroutines/Job;", "setAsrTimerJob", "(Lkotlinx/coroutines/Job;)V", "checkingTimerJob", "getCheckingTimerJob", "setCheckingTimerJob", "drawHalo", "haloX", "", "haloY", "mLastHoloX", "mLastHoloY", "handlerThread", "Landroid/os/HandlerThread;", "haloPaint", "Landroid/graphics/Paint;", "getHaloPaint", "()Landroid/graphics/Paint;", "haloPaint$delegate", "Lkotlin/Lazy;", "mHandler", "Landroid/os/Handler;", "totalTravelDistanceX", "getTotalTravelDistanceX", "totalTravelDistanceY", "getTotalTravelDistanceY", "setTeam", "", "t", "state", "Lcom/obric/audio/enroll/model/TeamState;", "getState", "()Lcom/obric/audio/enroll/model/TeamState;", "setState", "(Lcom/obric/audio/enroll/model/TeamState;)V", "haloImage", "Landroid/graphics/Bitmap;", "getHaloImage", "()Landroid/graphics/Bitmap;", "arcImage", "getArcImage", "subTitleViews", "", "Lkotlin/Pair;", "Lcom/obric/audio/enroll/model/TeamMember;", "Landroid/widget/TextView;", "titleView", "subTitleViewLine1", "subTitleViewLine2", "subTitleViewLine3", "onAttachedToWindow", "onDetachedFromWindow", "releaseAsrResource", "callback", "Lcom/obric/audio/enroll/EnrollAsrCallback;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "onAnimationStart", "animatorType", "Lcom/obric/audio/enroll/animation/AnimationType;", "args", "", "", "", "onAnimationUpdate", "member", "fraction", "onAnimationEnd", "arcBitmapPaint", "getArcBitmapPaint", "arcBitmapPaint$delegate", "onDraw", "imageStartX", "imageStartY", "setHoloVisible", "visible", "resetHoloPos", "setHaloProgress", "current", "total", "imageEndX", "imageEndY", "onHaloProgressChanged", "onScale", "teamMember", "fromScale", "targetScale", "onAlpha", "fromAlpha", "targetAlpha", "getOnStagedTranslateStartY", "getOnStagedTranslateEndY", "getOnDoneTranslateEndY", "getOnDoneTranslateStartY", "from", "onBlur", "target", "onCandidateReset", "onStageReset", "prepare", "asrTaskUuid", "asrTaskUuidForStart", "markRenewAsrTaskUuidForRetry", "renewAsrTaskUuidForRetry", "hasNetworkErrorInAsr", "onAsrResponseStream", "resp", "updateEnrollState", "data", "startTimeout", "cancelTimeout", "restartAsrTimer", "cancelAsrTimer", "onEnrollStateChanged", "oldState", "newState", "(Lcom/obric/audio/enroll/model/TeamEnrollState;Lcom/obric/audio/enroll/model/TeamEnrollState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onWholePageTimeout", "onSentenceAsrTimeout", "retry", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textLines", "getTextLines", "validLength", "rawText", "expectedSimilarityText", "checkSimilarity", "text", "given", "findView", "Landroid/view/View;", "updateBlur", "view", "value", "getTextViews", "animateHaloToInvisible", "end", "Lkotlin/Function0;", "updateHaloAlpha", "alpha", "trackEnrollFail", "errorMsg", "trackSentenceResult", WindowEvent.WindowOpenPerfResult.SUCCESS, WindowEvent.Params.REASON, "asr", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollTeamView extends ConstraintLayout implements LifecycleOwner {
    public static final Lazy<List<Integer>> G = null;
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final Lazy E;
    public boolean F;
    public final LifecycleRegistry a;
    public final CoroutineScope b;
    public final CoroutineScope c;
    public final EnrollViewModel d;
    public int e;
    public int f;
    public UUID g;
    public qia.g h;
    public kia.a i;
    public final StateFlowImpl j;
    public boolean k;
    public CountDownTimer l;
    public CountDownTimer m;
    public Job n;
    public Job o;
    public boolean p;
    public float q;
    public float r;
    public float s;
    public float t;
    public final Lazy u;
    public final Handler v;
    public TeamState w;
    public final Bitmap x;
    public final Bitmap y;
    public final List<Pair<TeamMember, TextView>> z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[AnimationType.values().length];
            r0[AnimationType.FADE_IN_TO_CANDIDATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L79:
            r0[AnimationType.FROM_CANDIDATE_TO_STAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L91:
            r0[AnimationType.FROM_STAGE_TO_DONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L8:
            a = r0;
            int[] r1 = new int[TeamMember.values().length];
            r1[TeamMember.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L81:
            r1[TeamMember.TITLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L93:
            r1[TeamMember.UPPER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L55:
            r1[TeamMember.MIDDLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L65:
            r1[TeamMember.LOWER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L16:
            b = r1;
            int[] r2 = new int[TeamEnrollState.values().length];
            r2[TeamEnrollState.BORN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L57:
            r2[TeamEnrollState.ENROLLING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L69:
            r2[TeamEnrollState.OVERSIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L75:
            r2[TeamEnrollState.NOT_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L83:
            r2[TeamEnrollState.CHECKING_SIMILARITY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L59:
            r2[TeamEnrollState.SIMILARITY_FAIL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L77:
            r2[TeamEnrollState.SIMILARITY_PASS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L89:
            r2[TeamEnrollState.CHECKING_ENROLL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L53:
            r2[TeamEnrollState.ENROLL_MATCHED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L67:
            r2[TeamEnrollState.ENROLL_NOT_MATCHED_NETWORK_ERROR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L87:
            r2[TeamEnrollState.ENROLL_NOT_MATCHED_COMMON_ERROR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L61:
            r2[TeamEnrollState.TIMEOUT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L63:
            r2[TeamEnrollState.DONE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L30:
            c = r2;
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ EnrollTeamView a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ CountDownLatch d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            EnrollTeamView r3 = this.a;
            r3.s = this.b.element;
            r3.t = this.c.element;
            this.d.countDown();
        }

        public c(EnrollTeamView r1, Ref.IntRef r2, Ref.IntRef r3, CountDownLatch r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    private final int getTotalTravelDistanceX() {
        return Math.abs(((int) 0.0f) - ((int) c6()));
    }

    private final int getTotalTravelDistanceY() {
        return Math.abs(((int) 0.0f) - ((int) i6()));
    }

    public final void C6() {
        setHoloVisible(false);
        N6(-1, -1);
        this.q = c6();
        this.r = i6();
    }

    static {
        G = LazyKt.lazy(new w());
    }

    private final Paint getArcBitmapPaint() {
        return (Paint) this.E.getValue();
    }

    private final Paint getHaloPaint() {
        return (Paint) this.u.getValue();
    }

    public final String U5() {
        UUID r0 = this.g;
        if (r0 != null) goto L5;
        UUID r1 = UUID.randomUUID();
        this.g = r1;
        return String.valueOf(r1);
    L5:
        return String.valueOf(r0);
    }

    public final void V5() {
        FLogger.a.i("EnrollTeamView", "------ cancelAsrTimer ------");
        Job r0 = this.n;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        CountDownTimer r1 = this.m;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.m = null;
        this.n = null;
    }

    public final void Y5() {
        FLogger.a.i("EnrollTeamView", "------ cancelTimeout ------");
        CountDownTimer r0 = this.l;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.l = null;
    }

    public final float c6() {
        return this.d.getLeftBorderLine() - (this.x.getWidth() / 2);
    }

    public final int getTextLines() {
        qia.g r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r0 = null;
    L6:
        return 1 + r0.d();
    }

    public final List<TextView> getTextViews() {
        ArrayList r0 = new ArrayList();
        r0.add(this.A);
        qia.g r1 = this.h;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r1 = null;
    L5:
        int r2 = r1.d();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L17;
        if (r3 != 0) goto L9;
        r0.add(this.B);
    L16:
        r3 = r3 + 1;
        goto L6
    L9:
        if (r3 != 1) goto L11;
        r0.add(this.C);
        goto L16
    L11:
        if (r3 != 2) goto L16;
        r0.add(this.D);
        goto L16
    L17:
        return r0;
    }

    public final float i6() {
        return ((this.d.getNeckGuideLine() - this.d.getTopGuideLine()) * 2) - this.x.getHeight();
    }

    public final void o6() {
        FLogger r0 = FLogger.a;
        r0.i("EnrollTeamView", "onCandidateReset");
        int r2 = Math.abs(this.d.getTopGuideLine() - this.d.getFootGuideLine());
        r0.i("EnrollTeamView", "onCandidateReset offsetY = " + r2);
        this.A.setTextSize(((Number) mia.h.b.getValue()).floatValue());
        float r1 = (float) r2;
        this.A.setTranslationY(r1);
        Iterator r3 = ((ArrayList) this.z).iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TextView r7 = (TextView) ((Pair) r5).getSecond();
        r7.setTextSize(((Number) mia.h.c.getValue()).floatValue());
        if (r4 != 0) goto L11;
        r7.setTranslationY(((((Number) mia.h.e.getValue()).floatValue() * r6) * 0.9f) + r1);
    L12:
        r4 = r6;
        goto L4
    L11:
        r7.setTranslationY(((((Number) mia.h.e.getValue()).floatValue() * r6) * 0.9f) + r1);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        FLogger.a.i("EnrollTeamView", "onAttachedToWindow");
        this.a.setCurrentState(Lifecycle.State.STARTED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        FLogger.a.i("EnrollTeamView", "onDetachedFromWindow");
        this.a.setCurrentState(Lifecycle.State.CREATED);
        Y5();
        V5();
    }

    public final Bitmap getArcImage() {
        return this.y;
    }

    public final kia.a getAsrResponse() {
        return this.i;
    }

    public final Job getAsrTimerJob() {
        return this.n;
    }

    public final Job getCheckingTimerJob() {
        return this.o;
    }

    public final z0<TeamEnrollState> getEnrollState() {
        return this.j;
    }

    public final Bitmap getHaloImage() {
        return this.x;
    }

    public final int getIndex() {
        return this.f;
    }

    public Lifecycle getLifecycle() {
        return this.a;
    }

    public final CountDownTimer getSentenceAsrTimer() {
        return this.m;
    }

    public final TeamState getState() {
        return this.w;
    }

    public final CountDownTimer getTimeoutTimer() {
        return this.l;
    }

    public final UUID getUuid() {
        return this.g;
    }

    public final EnrollViewModel getViewModel() {
        return this.d;
    }

    public EnrollTeamView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final Object H6(Continuation<? super Unit> r6) {
        if ((r6 instanceof EnrollTeamView$retry$1) == false) goto L7;
        EnrollTeamView$retry$1 r0 = (EnrollTeamView$retry$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L23:
        l7(this, TeamEnrollState.ENROLLING);
        this.d.reportEvent(qia.m.a);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        this.d.reportEvent(qia.n.a);
        C6();
        this.k = true;
        FLogger r8 = FLogger.a;
        StringBuilder r4 = new StringBuilder("markRenewAsrTaskUuidForRetry taskId=");
        UUID r5 = this.g;
        if (r5 == null) goto L17;
        String r9 = r5.toString();
    L18:
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        r4.append(r9);
        r4.append(" index=");
        r4.append(this.f);
        r8.i("EnrollTeamView", r4.toString());
        r0.label = 1;
        if (DelayKt.delay(500, r0) != r2) goto L23;
        return r2;
    L17:
        r9 = null;
    L7:
        r0 = new EnrollTeamView$retry$1(this, r6);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "end");
        setHoloVisible(false);
        getHaloPaint().setAlpha((int) (255 * 1.0f));
        postInvalidate();
        ((g) r4).invoke();
    }

    public final void V6(String r10) {
        int r0 = sia.d.a;
        int r1 = this.f;
        qia.g r2 = this.h;
        qia.g r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r2 = null;
    L5:
        String r4 = r2.f();
        String r5 = "";
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        qia.g r6 = this.h;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("team");
    L12:
        String r7 = r3.c();
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        String r8 = r4.concat(r7);
        kia.a r9 = this.i;
        if (r9 == null) goto L21;
        String r11 = r9.b();
        if (r11 == null) goto L21;
        r5 = r11;
    L21:
        int r12 = this.d.getEnrollDeviceType().getValue();
        Intrinsics.checkNotNullParameter(r10, "errorMsg");
        Intrinsics.checkNotNullParameter(r8, "sentence");
        Intrinsics.checkNotNullParameter(r5, "asr");
        JSONObject r13 = new JSONObject();
        r13.put(WindowEvent.WindowOpenPerfResult.SUCCESS, false);     // Catch: Exception -> L25
        r13.put(WindowEvent.Params.ERROR_MSG, r10);     // Catch: Exception -> L25
        r13.put("index", r1);     // Catch: Exception -> L25
        r13.put("sentence", r8);     // Catch: Exception -> L25
        r13.put("asr", r5);     // Catch: Exception -> L25
        r13.put("enroll_device_type", r12);     // Catch: Exception -> L25
    L23:
        ObricEnrollInteropDelegate.b.e(14, r13.toString());
        return;
    L11:
        r3 = r6;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View Z5(TeamMember r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        int r3 = b.b[r2.ordinal()];
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L23;
        if (r3 == 3) goto L22;
        if (r3 == 4) goto L21;
        if (r3 != 5) goto L14;
        return this.D;
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return this.C;
    L22:
        return this.B;
    L23:
        return this.A;
    L19:
        return this;
    }

    public final float b6(TeamMember r5) {
        Intrinsics.checkNotNullParameter(r5, "teamMember");
        float r0 = this.d.getNeckGuideLine();
        if (r5 != TeamMember.ALL) goto L5;
        return r0;
    L5:
        if (r5 == TeamMember.TITLE) goto L29;
        Iterator r1 = ((ArrayList) this.z).iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        Object r2 = r1.next();
        if (((Pair) r2).getFirst() != r5) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L9;
    L17:
        Pair r4 = (Pair) r2;
        if (r4 != null) goto L22;
        return 0.0f;
    L22:
        return r0 + (((Number) mia.h.f.getValue()).floatValue() * ((TeamMember) r4.getFirst()).getOrder());
    L13:
        r3 = false;
        goto L14
    L16:
        r2 = null;
        goto L17
    L29:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.dispatchDraw(r5);
        if (this.p == true) goto L6;
        return;
    L6:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        getHaloPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
    L12:
        r5.drawBitmap(this.x, this.q, this.r, getHaloPaint());
        return;
    L11:
        getHaloPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        goto L12
    L8:
        r0 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super/*android.view.ViewGroup*/.onDraw(r2);
        setBackgroundResource(2131106564);
        super/*android.view.ViewGroup*/.onDraw(r2);
    }

    public final void setAsrResponse(kia.a r1) {
        this.i = r1;
    }

    public final void setAsrTimerJob(Job r1) {
        this.n = r1;
    }

    public final void setCheckingTimerJob(Job r1) {
        this.o = r1;
    }

    public final void setHoloVisible(boolean r1) {
        this.p = r1;
    }

    public final void setIndex(int r1) {
        this.f = r1;
    }

    public final void setSentenceAsrTimer(CountDownTimer r1) {
        this.m = r1;
    }

    public final void setState(TeamState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.w = r2;
    }

    public final void setTeam(qia.g r4) {
        Intrinsics.checkNotNullParameter(r4, "t");
        this.h = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r4 = null;
    L5:
        int r5 = r4.d();
        if (r5 != 1) goto L8;
        this.B.setVisibility(0);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        return;
    L8:
        if (r5 != 2) goto L10;
        this.B.setVisibility(0);
        this.C.setVisibility(0);
        this.D.setVisibility(8);
        return;
    L10:
        if (r5 != 3) goto L13;
        this.B.setVisibility(0);
        this.C.setVisibility(0);
        this.D.setVisibility(0);
        return;
    L13:
        throw new RuntimeException("invalid subtitleLines");
    }

    public final void setTimeoutTimer(CountDownTimer r1) {
        this.l = r1;
    }

    public final void setUuid(UUID r1) {
        this.g = r1;
    }

    public final String u6(String r13) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r13, "$", "", false, 4, null), ",", "", false, 4, null), " ", "", false, 4, null), "，", "", false, 4, null), "。", "", false, 4, null), "？", "", false, 4, null), "“", "", false, 4, null), "”", "", false, 4, null);
    }

    public EnrollTeamView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void R5(final EnrollTeamView r5, Message r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        if (r6.what != 0) goto L22;
        FLogger r0 = FLogger.a;
        r0.i("EnrollTeamView", "EVENT_UPDATE_HALO got " + r6.arg1 + " / " + r6.arg2);
        int r1 = r6.arg1;
        int r7 = r6.arg2;
        float r3 = ((float) r1) / ((float) r7);
        if (r1 == 0) goto L20;
        if (r1 != r7) goto L11;
        if (r1 == (-1)) goto L20;
    L11:
        if (r3 <= 1.0f) goto L13;
        r3 = 1.0f;
    L13:
        final Ref.IntRef r8 = new Ref.IntRef();
        r8.element = ((int) r5.c6()) + ((int) (r5.getTotalTravelDistanceX() * r3));
        final Ref.IntRef r2 = new Ref.IntRef();
        r2.element = ((int) r5.i6()) + ((int) (r5.getTotalTravelDistanceY() * r3));
        final CountDownLatch r4 = new CountDownLatch(1);
        if (r2.element <= 0) goto L17;
        r2.element = 0;
    L17:
        if (r8.element <= 0) goto L19;
        r8.element = 0;
    L19:
        new Handler(Looper.getMainLooper()).post(new x(r5, r8, r2, r4));
        r4.await();
        return;
    L20:
        r0.i("EnrollTeamView", "EVENT_UPDATE_HALO reset from given -1 , -1");
        r5.s = r5.c6();
        r5.t = r5.i6();
        r5.q = r5.c6();
        r5.r = r5.i6();
        r5.postInvalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k6(EnrollTeamView r2, AnimationType r3) {
        Map r0 = MapsKt.emptyMap();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "animatorType");
        Intrinsics.checkNotNullParameter(r0, "args");
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        r2.w = TeamState.CANDIDATE;
        l7(r2, TeamEnrollState.NOT_START);
        return;
    L5:
        if (r4 != 2) goto L7;
        r2.w = TeamState.ONSTAGE;
        l7(r2, TeamEnrollState.BORN);
        l7(r2, TeamEnrollState.ENROLLING);
        return;
    L7:
        if (r4 != 3) goto L10;
        r2.w = TeamState.DONE;
        r2.setVisibility(8);
        l7(r2, TeamEnrollState.DONE);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static void l7(EnrollTeamView r8, TeamEnrollState r9) {
        TeamEnrollState r0 = (TeamEnrollState) r8.j.getValue();
        FLogger.a.i("EnrollTeamView", "onEnrollStateUpdate to " + r9 + ' ');
        r8.j.setValue(r9);
        BuildersKt.launch$default(r8.b, null, null, new EnrollTeamView$updateEnrollState$1(r8, r0, r9, null), 3, null);
    }

    public final void N6(int r4, int r5) {
        FLogger.a.i("EnrollTeamView", "setHaloProgress [" + r4 + '/' + r5 + ']');
        this.v.obtainMessage(0, r4, r5).sendToTarget();
    }

    public final void f7(View r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if ((r4 instanceof TextView) == false) goto L5;
        TextView r6 = (TextView) r4;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        float r0 = 0.001f;
        if (r5 >= 0.001f) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        int r8 = sia.c.a;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        FLogger.a.i("EnrollFileUtils", "setBlur radius: clear");
        r6.getPaint().setMaskFilter(null);
        r6.postInvalidate();
        return;
    L14:
        sia.c.c(r6, r0);
        return;
    L11:
        r0 = r5;
        r7 = false;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnrollTeamView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new LifecycleRegistry(this);
        this.b = CoroutineScopeKt.CoroutineScope(w1.a(1, "enrollHandleContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.c = CoroutineScopeKt.CoroutineScope(w1.a(1, "enrollProgressContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.d = (EnrollViewModel) new ViewModelProvider((FragmentActivity) r5).get(EnrollViewModel.class);
        this.f = -1;
        this.j = j1.a(TeamEnrollState.NOT_START);
        PthreadHandlerThreadV2 r8 = new PthreadHandlerThreadV2("team-enroll-halo");
        ThreadMethodProxy.start(r8);
        this.u = LazyKt.lazy(new s());
        this.v = new Handler(r8.getLooper(), new t(this));
        this.w = TeamState.NA;
        ArrayList r9 = new ArrayList();
        this.z = r9;
        ViewGroup.inflate(r5, 2131564914, this);
        TextView r0 = (TextView) findViewById(2131387174);
        if (r0 != null) goto L5;
        r0 = new TextView(r5, r6);
    L5:
        this.A = r0;
        TextView r1 = (TextView) findViewById(2131387176);
        if (r1 != null) goto L8;
        r1 = new TextView(r5, r6);
    L8:
        this.B = r1;
        TextView r2 = (TextView) findViewById(2131387177);
        if (r2 != null) goto L11;
        r2 = new TextView(r5, r6);
    L11:
        this.C = r2;
        TextView r3 = (TextView) findViewById(2131387178);
        if (r3 != null) goto L14;
        r3 = new TextView(r5, r6);
    L14:
        this.D = r3;
        r9.add(TuplesKt.to(TeamMember.UPPER, r1));
        r9.add(TuplesKt.to(TeamMember.MIDDLE, r2));
        r9.add(TuplesKt.to(TeamMember.LOWER, r3));
        com.obric.audio.enroll.f.a(this, new u(this));
        r0.setTextSize(((Number) mia.h.b.getValue()).floatValue());
        Iterator r10 = r9.iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        ((TextView) ((Pair) r10.next()).getSecond()).setTextSize(((Number) mia.h.c.getValue()).floatValue());
        goto L16
    L18:
        int r11 = (int) r5.getResources().getDimension(2131168405);
        Drawable r12 = r5.getResources().getDrawable(2131248325);
        Intrinsics.checkNotNull(r12);
        this.x = DrawableKt.toBitmap(r12, r11, r11, Bitmap.Config.ARGB_8888);
        Drawable r13 = r5.getResources().getDrawable(2131248325);
        Intrinsics.checkNotNull(r13);
        int r14 = r11 / 30;
        this.y = DrawableKt.toBitmap(r13, r14, r14, Bitmap.Config.ARGB_8888);
        this.a.setCurrentState(Lifecycle.State.CREATED);
        this.E = LazyKt.lazy(new v());
    }

    public final void W6(boolean r9, String r10, String r11) {
        int r0 = sia.d.a;
        int r1 = this.f;
        qia.g r2 = this.h;
        qia.g r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r2 = null;
    L5:
        String r4 = r2.f();
        String r5 = "";
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        qia.g r6 = this.h;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("team");
    L12:
        String r7 = r3.c();
        if (r7 == null) goto L16;
        r5 = r7;
    L16:
        String r8 = r4.concat(r5);
        int r12 = this.d.getEnrollDeviceType().getValue();
        Intrinsics.checkNotNullParameter(r10, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r8, "sentence");
        Intrinsics.checkNotNullParameter(r11, "asr");
        JSONObject r13 = new JSONObject();
        r13.put(WindowEvent.WindowOpenPerfResult.SUCCESS, r9);     // Catch: Exception -> L20
        r13.put(WindowEvent.Params.REASON, r10);     // Catch: Exception -> L20
        r13.put("index", r1);     // Catch: Exception -> L20
        r13.put("sentence", r8);     // Catch: Exception -> L20
        r13.put("asr", r11);     // Catch: Exception -> L20
        r13.put("enroll_device_type", r12);     // Catch: Exception -> L20
    L18:
        ObricEnrollInteropDelegate.b.e(15, r13.toString());
        return;
    L11:
        r3 = r6;
        goto L12
    }

    public final void s6(TeamMember r5, float r6, float r7) {
        float r0 = 0.6f + ((r7 - 0.6f) * r6);
        int r8 = b.b[r5.ordinal()];
        if (r8 != 1) goto L5;
        this.A.setScaleX(r0);
        this.A.setScaleY(r0);
        Iterator r9 = ((ArrayList) this.z).iterator();
    L31:
        if (r9.hasNext() == false) goto L42;
        TextView r10 = (TextView) ((Pair) r9.next()).getSecond();
        r10.setScaleX(r0);
        r10.setScaleY(r0);
        goto L31
    L42:
        return;
    L5:
        if (r8 != 2) goto L7;
        this.A.setScaleX(r0);
        this.A.setScaleY(r0);
        return;
    L7:
        if (r8 != 3) goto L9;
    L15:
        List<Pair<TeamMember, TextView>> r11 = this.z;
        ArrayList r1 = new ArrayList();
        Iterator r12 = ((ArrayList) r11).iterator();
    L17:
        if (r12.hasNext() == false) goto L24;
        Object r2 = r12.next();
        if (((Pair) r2).getFirst() != r5) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == false) goto L17;
        r1.add(r2);
        goto L17
    L21:
        r3 = false;
        goto L22
    L24:
        Iterator r13 = r1.iterator();
    L26:
        if (r13.hasNext() == false) goto L41;
        TextView r14 = (TextView) ((Pair) r13.next()).getSecond();
        r14.setScaleX(r0);
        r14.setScaleY(r0);
        goto L26
    L41:
        return;
    L9:
        if (r8 == 4) goto L15;
        if (r8 == 5) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public static final Object S5(EnrollTeamView r22, TeamEnrollState r23, TeamEnrollState r24, Continuation r25) {
        r22.getClass();
        if ((r25 instanceof EnrollTeamView$onEnrollStateChanged$1) == false) goto L7;
        EnrollTeamView$onEnrollStateChanged$1 r6 = (EnrollTeamView$onEnrollStateChanged$1) r25;
        int r8 = r6.label;
        if ((r8 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r8 - Integer.MIN_VALUE;
    L8:
        Object r3 = r6.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = r6.label;
        if (r10 == 0) goto L16;
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L14;
        ResultKt.throwOnFailure(r3);
    L205:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r3);
    L125:
        kia.a r0 = r22.i;
        if (r0 == null) goto L131;
        String r1 = r0.b();
        if (r1 == null) goto L131;
        String r13 = r1;
    L132:
        r22.W6(false, "similarity_fail", r13);
        r22.V6("SIMILARITY_FAIL");
    L131:
        r13 = "";
        goto L132
    L16:
        ResultKt.throwOnFailure(r3);
        FLogger r4 = FLogger.a;
        r4.i("EnrollTeamView", "onEnrollStateChanged from " + r23 + " -> " + r24 + " of index " + r22.f);
        if (r23 != r24) goto L20;
        return Unit.INSTANCE;
    L20:
        switch(b.c[r24.ordinal()]) {
            case 1: goto L198;
            case 2: goto L197;
            case 3: goto L196;
            case 4: goto L205;
            case 5: goto L133;
            case 6: goto L122;
            case 7: goto L121;
            case 8: goto L210;
            case 9: goto L37;
            case 10: goto L30;
            case 11: goto L30;
            case 12: goto L29;
            case 13: goto L23;
            default: goto L22;
        };
    L23:
        int r2 = r22.f;
        if (r2 < 2) goto L28;
        if (r2 > 4) goto L28;
        r22.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_FASTER_SAY_it));
    L28:
        r22.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_SAY_it));
        goto L205
    L29:
        r22.d.reportEvent(qia.p.a);
        goto L205
    L30:
        r22.setHoloVisible(false);
        if (r24 != TeamEnrollState.ENROLL_NOT_MATCHED_NETWORK_ERROR) goto L33;
        r22.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_CHECK_SENTENCE_NETWORK));
    L34:
        r6.label = 2;
        if (r22.H6(r6) != r9) goto L205;
        return r9;
    L33:
        r22.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_CHECK_SENTENCE_ERROR));
        goto L34
    L37:
        l7(r22, TeamEnrollState.DONE);
        int r5 = r22.f;
        if (r5 == 4) goto L44;
        if (r5 < 2) goto L43;
        if (r5 > 4) goto L43;
        r22.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_FASTER_SAY_it));
    L43:
        r22.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_SAY_it));
    L44:
        r22.d.reportEvent(new qia.j(r22.f + 1));
        r22.d.reportEvent(new qia.o(r22.f));
        goto L205
    L121:
        l7(r22, TeamEnrollState.CHECKING_ENROLL);
        goto L205
    L122:
        r22.setHoloVisible(false);
        r22.e = 0;
        r22.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_ERROR_TEXT_SIMILARITY));
        r6.label = 1;
        if (r22.H6(r6) != r9) goto L125;
        return r9;
    L133:
        qia.g r7 = r22.h;
        if (r7 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r7 = null;
    L136:
        String r11 = r7.b();
        if (r11 != null) goto L139;
    L143:
        qia.g r12 = r22.h;
        if (r12 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r12 = null;
    L146:
        String r14 = r12.f();
        if (r14 != null) goto L149;
        r14 = "";
    L149:
        qia.g r15 = r22.h;
        if (r15 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r15 = null;
    L152:
        String r16 = r15.c();
        if (r16 != null) goto L155;
        r16 = "";
    L155:
        r11 = r14.concat(r16);
    L156:
        kia.a r17 = r22.i;
        if (r17 == null) goto L162;
        String r18 = r17.b();
        if (r18 == null) goto L162;
        String r19 = r18;
    L163:
        String r20 = r22.u6(r11);
        String r21 = r22.u6(r19);
        int r26 = sia.e.a;
        Intrinsics.checkNotNullParameter(r20, "lhs");
        Intrinsics.checkNotNullParameter(r21, "rhs");
        int r27 = r20.length() + 1;
        int r28 = r21.length() + 1;
        int[] r29 = new int[r27];
        int r30 = 0;
    L164:
        if (r30 >= r27) goto L166;
        r29[r30] = r30;
        r30 = r30 + 1;
        goto L164
    L166:
        int[] r110 = new int[r27];
        int[] r31 = r29;
        int r32 = 1;
    L167:
        if (r32 >= r28) goto L176;
        r110[0] = r32;
        int r111 = 1;
    L169:
        if (r111 >= r27) goto L175;
        int r112 = r111 - 1;
        if (r20.charAt(r112) != r21.charAt(r32 - 1)) goto L173;
        int r113 = 0;
    L174:
        r110[r111] = Math.min(Math.min(r31[r111] + 1, r110[r112] + 1), r31[r112] + r113);
        r111 = r111 + 1;
        goto L169
    L173:
        r113 = 1;
        goto L174
    L175:
        r32 = r32 + 1;
        int[] r210 = r110;
        r110 = r31;
        r31 = r210;
        goto L167
    L176:
        int r33 = r31[r27 - 1];
        FLogger r34 = FLogger.a;
        StringBuilder r35 = new StringBuilder("checkSimilarity diff: [");
        r35.append(r33);
        r35.append(" vs ");
        qia.g r36 = r22.h;
        if (r36 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r36 = null;
    L179:
        r35.append(r36.e());
        r35.append("] from org ");
        r35.append(r22.u6(r11));
        r35.append(" , and given ");
        r35.append(r22.u6(r19));
        r34.i("EnrollTeamView", r35.toString());
        qia.g r37 = r22.h;
        if (r37 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r37 = null;
    L183:
        if (r33 <= r37.e()) goto L185;
        r22.d.getEnrollDeviceType();
        VoicePrintEnrollActivity.Companion.EnrollDeviceType.a r38 = VoicePrintEnrollActivity.Companion.EnrollDeviceType.Companion;
    L185:
        qia.g r39 = r22.h;
        if (r39 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        qia.g r40 = null;
    L190:
        if (r33 > r40.e()) goto L192;
        boolean r114 = true;
    L193:
        if (r114 == false) goto L195;
        l7(r22, TeamEnrollState.SIMILARITY_PASS);
        goto L205
    L195:
        l7(r22, TeamEnrollState.SIMILARITY_FAIL);
        goto L205
    L192:
        r114 = false;
        goto L193
    L188:
        r40 = r39;
    L162:
        r19 = "";
        goto L163
    L139:
        if ((!StringsKt.isBlank(r11)) == true) goto L142;
        r11 = null;
    L142:
        if (r11 != null) goto L156;
    L196:
        r22.d.reportEvent(qia.n.a);
        r22.d.reportEvent(qia.a.a);
        l7(r22, TeamEnrollState.CHECKING_SIMILARITY);
        r22.Y5();
        r22.V5();
        goto L205
    L197:
        r4.i("EnrollTeamView", "onEnrollStateChanged start a timer .............. with team view " + r22.f);
        r4.i("EnrollTeamView", "------ startTimeout ------");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$startTimeout$1(r22, null), 3, null);
        goto L205
    L198:
        int r41 = r22.f;
        if (r41 <= 2) goto L203;
        if (r41 > 4) goto L203;
        r22.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_FASTER_SAY_it));
    L203:
        r22.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_SAY_it));
        goto L205
    L210:
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L51
        Job r43 = r22.o;     // Catch: Throwable -> L51
        if (r43 == null) goto L48;
        JobKt.cancel$default(r43, "oversize", null, 2, null);     // Catch: Throwable -> L51
        Unit r44 = Unit.INSTANCE;     // Catch: Throwable -> L51
    L49:
        Result.constructor-impl(r44);     // Catch: Throwable -> L51
    L53:
        r22.o = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$onEnrollStateChanged$3(r22, null), 3, null);
        String r45 = r22.U5();
        IEnrollService.a.getClass();
        IEnrollService r46 = IEnrollService.a.a();
        if (r46 == null) goto L56;
        r46.a(r45);
    L56:
        FLogger r47 = FLogger.a;
        r47.i("EnrollTeamView", "checkSentence via checkSNR taskId=" + r45 + " index=" + r22.f + " deviceType=" + r22.d.getEnrollDeviceType());
        SamiEnrollEngine.a.getClass();
        Intrinsics.checkNotNullParameter(r45, "taskId");
        r47.i("SamiEnrollEngine", "checkSNR taskId=".concat(r45));
        ReentrantLock r115 = SamiEnrollEngine.e;
        r115.lock();
        SpeechFingerPrintEnrollService r48 = SamiEnrollEngine.d;     // Catch: Throwable -> L118
        if (r48 == null) goto L60;
        int r49 = r48.checkSNR(r45);     // Catch: Throwable -> L118
    L61:
        r47.i("SamiEnrollEngine", "checkSNR ret=" + r49 + " taskId=" + r45);     // Catch: Throwable -> L118
        r115.unlock();
        r47.i("EnrollTeamView", "checkSentence result=" + r49 + " taskId=" + r45 + " index=" + r22.f);
        int r50 = sia.d.a;
        if (r49 != 0) goto L65;
        boolean r51 = true;
    L66:
        int r52 = r22.f;
        String r53 = r22.d.sentence(r52);
        kia.a r116 = r22.i;
        if (r116 == null) goto L70;
        String r117 = r116.b();
        if (r117 == null) goto L70;
    L71:
        Intrinsics.checkNotNullParameter(r53, "sentence");
        Intrinsics.checkNotNullParameter(r117, "asr");
        JSONObject r118 = new JSONObject();
        r118.put(WindowEvent.WindowOpenPerfResult.SUCCESS, r51);     // Catch: Exception -> L74
        r118.put("error", r49);     // Catch: Exception -> L74
        r118.put("index", r52);     // Catch: Exception -> L74
        r118.put("sentence", r53);     // Catch: Exception -> L74
        r118.put("asr", r117);     // Catch: Exception -> L74
    L75:
        ObricEnrollInteropDelegate.b.e(13, r118.toString());
        if (r49 != 0) goto L87;
        SamiEnrollEngine.a.getClass();
        Intrinsics.checkNotNullParameter(r45, "taskId");
        FLogger r54 = FLogger.a;
        r54.i("SamiEnrollEngine", "saveSessionAudio taskId=".concat(r45));
        ReentrantLock r55 = SamiEnrollEngine.e;
        r55.lock();
        SpeechFingerPrintEnrollService r56 = SamiEnrollEngine.d;     // Catch: Throwable -> L84
        if (r56 == null) goto L81;
        int r57 = r56.saveSessionAudio(r45);     // Catch: Throwable -> L84
    L82:
        r54.i("SamiEnrollEngine", "saveSessionAudio ret=" + r57 + " taskId=" + r45);     // Catch: Throwable -> L84
        r55.unlock();
        r54.i("EnrollTeamView", "saveSessionAudio ret=" + r57 + " taskId=" + r45 + " index=" + r22.f);
        goto L87
    L81:
        r57 = Integer.MIN_VALUE;
    L84:
        th = move-exception;
        SamiEnrollEngine.e.unlock();
        throw th;
    L87:
        if (r49 != 0) goto L89;
        kia.a r58 = r22.i;
        if (r58 == null) goto L113;
        String r59 = r58.b();
        if (r59 == null) goto L113;
        String r119 = r59;
    L114:
        int r60 = 1;
        r22.W6(true, "snr_check_pass", r119);
        l7(r22, TeamEnrollState.ENROLL_MATCHED);
    L115:
        r22.Y5();
        r22.V5();
        Job r61 = r22.o;
        if (r61 == null) goto L205;
        Job.DefaultImpls.cancel$default(r61, null, r60, null);
    L113:
        r119 = "";
        goto L114
    L89:
        if (r49 == 100011) goto L98;
        kia.a r62 = r22.i;
        if (r62 == null) goto L96;
        String r63 = r62.b();
        if (r63 == null) goto L96;
        String r120 = r63;
    L97:
        r22.W6(false, "snr_check_failed", r120);
        l7(r22, TeamEnrollState.ENROLL_NOT_MATCHED_COMMON_ERROR);
        r22.V6(String.valueOf(r49));
    L106:
        r60 = 1;
    L96:
        r120 = "";
        goto L97
    L98:
        kia.a r64 = r22.i;
        if (r64 == null) goto L104;
        String r65 = r64.b();
        if (r65 == null) goto L104;
        String r121 = r65;
    L105:
        r22.W6(false, "snr_check_failed", r121);
        l7(r22, TeamEnrollState.ENROLL_NOT_MATCHED_NETWORK_ERROR);
        r22.V6(String.valueOf(r49));
    L104:
        r121 = "";
    L70:
        r117 = "";
        goto L71
    L65:
        r51 = false;
        goto L66
    L60:
        r49 = Integer.MIN_VALUE;
    L118:
        th = move-exception;
        SamiEnrollEngine.e.unlock();
        throw th;
    L48:
        r44 = null;
    L51:
        th = move-exception;
        Result.Companion r66 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L22:
        throw new NoWhenBranchMatchedException();
    L7:
        r6 = new EnrollTeamView$onEnrollStateChanged$1(r22, r25);
        goto L8
    }

    public static void n6(EnrollTeamView r5, TeamMember r6, AnimationType r7, float r8) {
        Map r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r6, "member");
        Intrinsics.checkNotNullParameter(r7, "animatorType");
        Intrinsics.checkNotNullParameter(r0, "args");
        int r9 = b.a[r7.ordinal()];
        if (r9 == 1) goto L11;
        if (r9 != 2) goto L6;
        r5.s6(r6, r8, 1.0f);
        return;
    L6:
        if (r9 != 3) goto L9;
        return;
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        float r10 = (0.15f * r8) + 0.0f;
        int r2 = b.b[r6.ordinal()];
        if (r2 == 1) goto L28;
        if (r2 == 2) goto L27;
        List<Pair<TeamMember, TextView>> r1 = r5.z;
        ArrayList r3 = new ArrayList();
        Iterator r4 = ((ArrayList) r1).iterator();
    L16:
        if (r4.hasNext() == false) goto L23;
        Object r11 = r4.next();
        if (((Pair) r11).getFirst() != r6) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == false) goto L16;
        r3.add(r11);
        goto L16
    L20:
        r12 = false;
        goto L21
    L23:
        Iterator r13 = r3.iterator();
    L25:
        if (r13.hasNext() == false) goto L32;
        ((TextView) ((Pair) r13.next()).getSecond()).setAlpha(r10);
    L32:
        r5.s6(r6, r8, 0.6f);
        return;
    L27:
        r5.A.setAlpha(r10);
        goto L32
    L28:
        r5.A.setAlpha(r10);
        Iterator r14 = ((ArrayList) r5.z).iterator();
    L30:
        if (r14.hasNext() == false) goto L32;
        ((TextView) ((Pair) r14.next()).getSecond()).setAlpha(r10);
        goto L30
    }
}
