package com.larus.audio.flow.client;

import android.os.Build;
import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.s2;
import com.larus.asr.t2;
import com.larus.asr.u2;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.asr.i;
import com.larus.audio.asr.r;
import com.larus.audio.asr.r0;
import com.larus.audio.asr.t0;
import com.larus.audio.audiov3.asr.AsrCallBackType;
import com.larus.audio.audiov3.audio.record.AsrClientStatus;
import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.reporter.asr.AsrStep;
import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrStopType;
import com.larus.audio.flow.client.mob.FlowAudioAsrAndTTSCostMobHelper;
import com.larus.audio.report.h;
import com.larus.audio.utils.g0;
import com.larus.audio.utils.g1;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.core.ExemptThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.NewThreadPoolHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import g78.a0;
import g78.j;
import g78.m;
import g78.n;
import g78.q;
import g78.s;
import g78.t;
import g78.u;
import g78.v;
import g78.w;
import g78.x;
import g78.y;
import gw5.g;
import h68.c;
import h68.d;
import h68.e;
import h68.f;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m58.h$a;
import m58.k;
import m58.l;
import m58.u$a;
import y58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0093\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001c\b\u0007\u0018\u0000 Ö\u00012\u00020\u0001:\u0002Ö\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00106\u001a\u00020\u0005H\u0002J\u0096\u0001\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020$28\u0010N\u001a4\u0012\u0013\u0012\u00110\u0017¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110$¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020B\u0018\u00010O28\u0010S\u001a4\u0012\u0013\u0012\u00110\u0017¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110$¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020T\u0018\u00010O2\b\u0010U\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010V\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00172\u0006\u0010M\u001a\u00020$H\u0002J\b\u0010W\u001a\u00020FH\u0002J\u0018\u0010X\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020$H\u0002J\u0012\u0010Y\u001a\u00020F2\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010Z\u001a\u00020D2\u0006\u0010L\u001a\u00020\u0017H\u0002J\u0018\u0010[\u001a\u00020K2\u0006\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0017H\u0002J\u0018\u0010^\u001a\u00020K2\u0006\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0017H\u0002J\u0018\u0010_\u001a\u00020F2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u0017H\u0002J\u0018\u0010`\u001a\u00020K2\u0006\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0017H\u0002J\u0012\u0010a\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0002J\r\u0010b\u001a\u00020cH\u0002¢\u0006\u0002\u0010dJR\u0010e\u001a\u00020F2\b\u0010L\u001a\u0004\u0018\u00010\u00172\u0006\u0010R\u001a\u00020$26\u0010N\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110$¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020B0OH\u0002J\u0010\u0010f\u001a\u00020K2\u0006\u0010\\\u001a\u00020DH\u0002J\u0010\u0010g\u001a\u00020K2\u0006\u0010\\\u001a\u00020DH\u0002J\u0012\u0010h\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0002J \u0010i\u001a\u00020K2\u0006\u0010j\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010k\u001a\u00020\u000eH\u0002J\u0010\u0010l\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0017H\u0002J8\u0010m\u001a\u00020F2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020\u001a2\u0006\u0010q\u001a\u00020\u000e2\u0006\u0010j\u001a\u00020\u001a2\u0006\u0010k\u001a\u00020\u000eH\u0002J3\u0010r\u001a\u0004\u0018\u00010\u001a2\b\u0010L\u001a\u0004\u0018\u00010\u00172\b\u0010\\\u001a\u0004\u0018\u00010\u001a2\u0006\u0010s\u001a\u00020o2\u0006\u0010t\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010uJ\u0012\u0010v\u001a\u00020F2\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010w\u001a\u00020K2\b\u0010x\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010y\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010z\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010{\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00170}H\u0016J\u000e\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00170}H\u0016J\u0012\u0010\u007f\u001a\u0004\u0018\u00010$2\u0006\u0010L\u001a\u00020\u0017H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\u0017H\u0016J\t\u0010\u0081\u0001\u001a\u00020\nH\u0016J\u0011\u0010\u0082\u0001\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0017H\u0002J\t\u0010\u0083\u0001\u001a\u00020KH\u0002J\t\u0010\u0084\u0001\u001a\u00020KH\u0002J\t\u0010\u0085\u0001\u001a\u00020KH\u0016J\t\u0010\u0086\u0001\u001a\u00020KH\u0002J1\u0010\u0087\u0001\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00172\b\u0010x\u001a\u0004\u0018\u00010\u00172\u0012\b\u0002\u0010\u0088\u0001\u001a\u000b\u0012\u0004\u0012\u00020K\u0018\u00010\u0089\u0001H\u0002J\u001d\u0010\u008a\u0001\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00172\b\u0010x\u001a\u0004\u0018\u00010\u0017H\u0002J\u0015\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00172\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0002J\u001d\u0010\u008c\u0001\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00172\b\u0010M\u001a\u0004\u0018\u00010$H\u0016J\u0013\u0010\u008d\u0001\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0002J\u0013\u0010\u008e\u0001\u001a\u00020\u001a2\b\u0010L\u001a\u0004\u0018\u00010\u0017H\u0002J\t\u0010\u008f\u0001\u001a\u00020\u000eH\u0002J7\u0010\u0090\u0001\u001a\u00020K2\b\u0010\\\u001a\u0004\u0018\u00010D2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010]\u001a\u00020\u0017H\u0002¢\u0006\u0003\u0010\u0093\u0001J\u0013\u0010\u0094\u0001\u001a\u00020F2\b\u0010\\\u001a\u0004\u0018\u00010DH\u0002J8\u0010\u0095\u0001\u001a\u00020K2\u0007\u0010\u0096\u0001\u001a\u00020\u000e2\b\u0010\\\u001a\u0004\u0018\u00010D2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0003\u0010\u0097\u0001JU\u0010\u0098\u0001\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00172\b\u0010x\u001a\u0004\u0018\u00010\u00172\u0007\u0010\u0096\u0001\u001a\u00020\u000e2\b\u0010\\\u001a\u0004\u0018\u00010D2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010\u0099\u0001\u001a\u00020\u0017H\u0002¢\u0006\u0003\u0010\u009a\u0001J\u0019\u0010\u009b\u0001\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u0017H\u0002J\u0012\u0010\u009c\u0001\u001a\u00020K2\u0007\u0010\u009d\u0001\u001a\u00020&H\u0016J=\u0010\u009e\u0001\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00172\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010\u0087\u0001\u001a\u00020\u001a2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010¢\u0001\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00172\u0007\u0010£\u0001\u001a\u00020\u001eH\u0016J\u0012\u0010¤\u0001\u001a\u00020K2\u0007\u0010¥\u0001\u001a\u00020\u0010H\u0016J\u0012\u0010¦\u0001\u001a\u00020K2\u0007\u0010§\u0001\u001a\u00020\u0012H\u0016J>\u0010¨\u0001\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00172\u0007\u0010©\u0001\u001a\u00020\u00172\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\n\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00012\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J\u0019\u0010®\u0001\u001a\u00020K2\u000e\u0010¯\u0001\u001a\t\u0012\u0004\u0012\u00020K0\u0089\u0001H\u0002Js\u0010°\u0001\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00172\b\u0010±\u0001\u001a\u00030²\u00012\u0006\u0010\\\u001a\u00020\u00172\u0006\u0010x\u001a\u00020\u00172\t\b\u0002\u0010³\u0001\u001a\u00020\u000e2\t\b\u0002\u0010´\u0001\u001a\u00020\u00172\t\b\u0002\u0010µ\u0001\u001a\u00020\u001a2\u000b\b\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010\u00172\u000b\b\u0002\u0010·\u0001\u001a\u0004\u0018\u00010\u00172\u000b\b\u0002\u0010¸\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010¹\u0001\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00172\u0007\u0010º\u0001\u001a\u00020\u0017H\u0002J\u0013\u0010À\u0001\u001a\u00020K2\b\u0010Á\u0001\u001a\u00030½\u0001H\u0016J\u0019\u0010Â\u0001\u001a\u00020T2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010R\u001a\u00020$H\u0016J\u001b\u0010Ã\u0001\u001a\u0004\u0018\u00010T2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010R\u001a\u00020$H\u0016J\u001b\u0010Ä\u0001\u001a\u00020K2\u0007\u0010Å\u0001\u001a\u00020T2\u0007\u0010Æ\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010Ç\u0001\u001a\u00020K2\u0007\u0010Å\u0001\u001a\u00020TH\u0016J\u0019\u0010È\u0001\u001a\u00020B2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010R\u001a\u00020$H\u0016JO\u0010É\u0001\u001a\u00030Ê\u00012\u0006\u0010L\u001a\u00020\u00172\b\u0010Ë\u0001\u001a\u00030Ì\u00012\t\u0010Í\u0001\u001a\u0004\u0018\u00010\u00122&\u0010Î\u0001\u001a!\u0012\u0014\u0012\u00120o¢\u0006\r\bP\u0012\t\bQ\u0012\u0005\b\b(Ð\u0001\u0012\u0004\u0012\u00020K\u0018\u00010Ï\u0001H\u0016Jw\u0010É\u0001\u001a\u00030Ê\u00012\u0006\u0010L\u001a\u00020\u00172\b\u0010Ë\u0001\u001a\u00030Ì\u00012\t\u0010Í\u0001\u001a\u0004\u0018\u00010\u00122&\u0010Î\u0001\u001a!\u0012\u0014\u0012\u00120o¢\u0006\r\bP\u0012\t\bQ\u0012\u0005\b\b(Ð\u0001\u0012\u0004\u0012\u00020K\u0018\u00010Ï\u00012&\u0010Ñ\u0001\u001a!\u0012\u0014\u0012\u00120F¢\u0006\r\bP\u0012\t\bQ\u0012\u0005\b\b(Ò\u0001\u0012\u0004\u0012\u00020K\u0018\u00010Ï\u0001H\u0016J\t\u0010Ó\u0001\u001a\u00020FH\u0002J\u000f\u0010Ô\u0001\u001a\u00020KH\u0001¢\u0006\u0003\bÕ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001e0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020$0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b(\u0010)R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\"\u001a\u0004\b-\u0010.R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u0017018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\"\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\"\u001a\u0004\b:\u0010;R\u001b\u0010=\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\"\u001a\u0004\b>\u0010?R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020D0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020F0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020D0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020I0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010»\u0001\u001a\n\u0012\u0005\u0012\u00030½\u00010¼\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¾\u0001\u001a\u00030¿\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006×\u0001"}, d2 = {"Lcom/larus/audio/flow/client/FlowAsrClientImpl;", "Lcom/larus/audio/IFlowAsrClientService;", "<init>", "()V", "mSingleTaskExecutor", "Ljava/util/concurrent/ExecutorService;", "mByteArrayOutputStream", "Ljava/io/ByteArrayOutputStream;", "mByteArrayExtraSaveStream", "mAsrClientStatus", "Lcom/larus/audio/audiov3/audio/record/AsrClientStatus;", "mIAsrCallback", "Lcom/larus/audio/audiov3/task/asr/IAsrListener;", "mMinDurationTime", "", "mAsrStateListener", "Lcom/larus/audio/audiov3/asr/AsrStateListener;", "mAsrAudioDataListener", "Lcom/larus/audio/audiov3/asr/AsrAudioDataListener;", "mReentrantLock", "Ljava/util/concurrent/locks/ReentrantLock;", "mTimeoutRunnableMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/Runnable;", "mRetryTimesMap", "", "mAsrReporterMap", "Lcom/larus/audio/flow/client/report/AsrReporter;", "asrTracer", "Lcom/larus/audio/report/IAsrTracer;", "getAsrTracer", "()Ljava/util/concurrent/ConcurrentHashMap;", "asrTracer$delegate", "Lkotlin/Lazy;", "asrConfigMap", "Lcom/larus/audio/audiov3/config/task/sami/asr/AsrConfig;", "mAsrRetryStrategy", "Lcom/larus/audio/audiov3/asr/strategy/AsrRetryStrategy;", "asrDetectionReporter", "getAsrDetectionReporter", "()Lcom/larus/audio/flow/client/report/AsrReporter;", "asrDetectionReporter$delegate", "startAsrTaskQueue", "Ljava/util/Queue;", "getStartAsrTaskQueue", "()Ljava/util/Queue;", "startAsrTaskQueue$delegate", "bigAudioFileReportedList", "", "getBigAudioFileReportedList", "()Ljava/util/List;", "bigAudioFileReportedList$delegate", "audioRecordTimeInterval", "getExecutorService", "mRetryExecutor", "releaseAudioRecordHandler", "Landroid/os/Handler;", "getReleaseAudioRecordHandler", "()Landroid/os/Handler;", "releaseAudioRecordHandler$delegate", "releaseAudioRecordRunnable", "getReleaseAudioRecordRunnable", "()Ljava/lang/Runnable;", "releaseAudioRecordRunnable$delegate", "asrDataSource", "Lcom/larus/audio/audiov3/task/asr/IAsrDataSource;", "pendingFailTaskIdToResult", "Lcom/larus/audio/audiov3/config/task/sami/asr/AsrResultData;", "samiNotReadyTaskIds", "", "pendingSamiNotReadyTaskIdToResult", "samiNotReadyInitTaskMap", "Lcom/larus/audio/audiov3/AudioSdk$InitTask;", "startAsr", "", "taskId", "asrData", "dataSourceProvider", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "asrConfig", "taskProvider", "Lcom/larus/audio/audiov3/task/asr/IAsrTask;", "asrListener", "logAsrMessage", "isSamiNotReadyOptEnabled", "prepareSamiConfigBeforeStart", "tryFillSamiCommonConfig", "buildSamiNotReadyFailResult", "handlePendingFailAfterAudioSaved", "result", "caller", "waitSamiReadyThenHandleFail", "tryHandleSamiReadyPendingFail", "handleSamiNotReadyWaitTimeout", "clearSamiNotReadyTask", "creatAsrCallback", "com/larus/audio/flow/client/FlowAsrClientImpl$creatAsrCallback$1", "()Lcom/larus/audio/flow/client/FlowAsrClientImpl$creatAsrCallback$1;", "tryPrepareDataSource", "handleAsrStream", "handleAsrSuccess", "startReadLoop", "loopRead", "bufferSizeInBytes", "startTime", "handleAudioRecordSilenced", "execWrite", "audioData", "", "readSize", "totalSize", "retryProcess", "buffer", "sizeInBytes", "(Ljava/lang/String;Ljava/lang/Integer;[BI)Ljava/lang/Integer;", "stopAsr", "removeFile", "filePath", "cancelAsr", "cancelCurrentTaskAndRelease", "releaseAsrTask", "getTaskIds", "", "getRunningTaskIds", "getAsrConfig", "getRecordAudioDuration", "getRecordStatus", "removeAsrTask", "checkLeakAndReleaseAudioRecord", "releaseAudioRecordAsync", "releaseAudioRecordFinal", "releaseAudioRecordInternal", "saveAudioFile", "onComplete", "Lkotlin/Function0;", "saveAudioFileForObric", "getAudioFilePathForObric", "handleResend", "addRetryTime", "getRetryTime", "getMaxTimeoutDuration", "handleAsrFail", "errCode", "errorMessage", "(Lcom/larus/audio/audiov3/config/task/sami/asr/AsrResultData;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "shouldRetry", "initTimeoutTask", "timeoutDuration", "(JLcom/larus/audio/audiov3/config/task/sami/asr/AsrResultData;Ljava/lang/Integer;Ljava/lang/String;)V", "createTimeoutTask", "from", "(Ljava/lang/String;Ljava/lang/String;JLcom/larus/audio/audiov3/config/task/sami/asr/AsrResultData;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "cancelTimeoutTask", "setAsrRetryStrategy", "asrStrategy", "configAsrSenseReporter", "languageModel", "asrLanguage", "botId", "configTracer", "tracer", "addAsrStateListener", "asrStateListener", "addAsrAudioDataListener", "asrAudioDataListener", "updateScreenshotForAsr", "context", "id", "", "type", "param", "postToMainThread", "functionToExecute", "report", "asrCallbackType", "Lcom/larus/audio/audiov3/asr/AsrCallBackType;", "audioDuration", "vid", "errorCode", "audioDataTosUri", "audioEventResp", "logId", "onStartAsrRecog", "convId", "asrTaskFactories", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/audio/audiov3/task/asr/IAsrTaskFactory;", "fallbackAsrTaskFactory", "Lcom/larus/audio/audiov3/task/asr/factory/ImSamiAsrTaskFactory;", "registerAsrTaskFactory", "factory", "createAsrTask", "createManagedAsrTask", "releaseUnmanagedAsrTask", "task", "reason", "releaseManagedAsrTask", "createDefaultAsrDataSource", "createAudioRecord", "Lcom/bytedance/flow_audio/api/foundation/record/IAudioRecord;", "config", "Lcom/bytedance/flow_audio/api/config/session/FlowAudioSessionConfig;", "audioDataListener", "firstAudioDataListener", "Lkotlin/Function1;", "data", "audioFileSaveResultListener", "success", "canHook", "clearAsrTaskFactoriesForTest", "clearAsrTaskFactoriesForTest$audiosdk_release", "Companion", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FlowAsrClientImpl implements IFlowAsrClientService {
    public static final /* synthetic */ int E = 0;
    public final ConcurrentHashMap<String, b> A;
    public final ConcurrentHashMap<String, h$a> B;
    public final CopyOnWriteArrayList<f> C;
    public final i68.a D;
    public final ExecutorService b;
    public final ByteArrayOutputStream c;
    public final ByteArrayOutputStream d;
    public volatile AsrClientStatus e;
    public d f;
    public long g;
    public n58.b h;
    public n58.a i;
    public final ReentrantLock j;
    public final ConcurrentHashMap<String, Runnable> k;
    public final ConcurrentHashMap<String, Integer> l;
    public final ConcurrentHashMap<String, k78.a> m;
    public final Lazy n;
    public final ConcurrentHashMap<String, y58.a> o;
    public o58.b p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public long t;
    public final PThreadPoolExecutor u;
    public final Lazy v;
    public final Lazy w;
    public c x;
    public final ConcurrentHashMap<String, b> y;
    public final ConcurrentHashMap<String, Boolean> z;

    public static final class a {
    }

    static {
    }

    public final ConcurrentHashMap<String, h> B() {
        return (ConcurrentHashMap) this.n.getValue();
    }

    public final long D() {
        int[] r0 = this.p.b;
        if (r0.length != 0) goto L5;
        boolean r1 = true;
    L7:
        if ((!r1) == true) goto L11;
        return 25000;
    L11:
        return r0[0];
    L5:
        r1 = false;
        goto L7
    }

    public final Queue<String> F() {
        return (Queue) this.r.getValue();
    }

    public final void J() {
        int r0 = c68.b.a;
        c68.b.a("FlowAsrClient", "releaseAudioRecord asrDataSource=" + this.x);
        this.e = AsrClientStatus.STATE_IDLE;
        ((Handler) this.v.getValue()).postDelayed((Runnable) this.w.getValue(), 5000);
        c68.b.d("FlowAsrClient", "releaseAudioRecordHandler startCheckRunnable releaseAudioRecordAsync");
        this.b.submit(new n(this));
    }

    public final void K() {
        c r0 = this.x;
        if (r0 == null) goto L14;
        h68.a r1 = r0.stop();
        if ((r1 instanceof h68.a.b) == false) goto L7;
        r1 = r0.release();
        String r2 = "release";
    L9:
        if ((r1 instanceof h68.a.b) == false) goto L11;
        ((Handler) this.v.getValue()).removeCallbacks((Runnable) this.w.getValue());
        c68.b.d("FlowAsrClient", "releaseAudioRecordHandler removeCallbacks releaseAudioRecordInternal");
        c68.b.a("FlowAsrClient", "releaseAudioRecord => success");
    L12:
        this.x = null;
        return;
    L11:
        int r3 = c68.b.a;
        c68.b.b("FlowAsrClient", "releaseAudioRecord => fail, " + r1 + ", stage: " + r2);
        goto L12
    L7:
        r2 = "stop";
        goto L9
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void m() {
        c68.b.a("FlowAsrClient", "releaseAudioRecordFinal");
        this.e = AsrClientStatus.STATE_IDLE;
        K();
        ((List) this.s.getValue()).clear();
        F().clear();
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final List<String> o() {
        ConcurrentHashMap<String, e> r0 = g68.a.a;
        return CollectionsKt.toList(g68.a.a.keySet());
    }

    public FlowAsrClientImpl() {
        m58.b r0 = m58.h.k;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
        ExecutorService r2 = NewThreadPoolHelper.INSTANCE.newThreadPool(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ExemptThreadFactory("flow-asr-serial", false, false), new ThreadPoolExecutor.AbortPolicy());
    L12:
        this.b = r2;
        this.c = new ByteArrayOutputStream();
        this.d = new ByteArrayOutputStream();
        this.e = AsrClientStatus.STATE_IDLE;
        this.j = new ReentrantLock();
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new ConcurrentHashMap();
        this.n = LazyKt.lazy(new s());
        this.o = new ConcurrentHashMap();
        this.p = new o58.b(1, new int[]{25000});
        this.q = LazyKt.lazy(new t());
        this.r = LazyKt.lazy(new u());
        this.s = LazyKt.lazy(new v());
        this.u = new PThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("FlowAsrClientImpl"), new ThreadPoolExecutor.AbortPolicy());
        this.v = LazyKt.lazy(new w());
        this.w = LazyKt.lazy(new x(this));
        this.y = new ConcurrentHashMap();
        this.z = new ConcurrentHashMap();
        this.A = new ConcurrentHashMap();
        this.B = new ConcurrentHashMap();
        this.C = new CopyOnWriteArrayList();
        this.D = new i68.a();
        return;
    L11:
        r2 = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("FlowAsrClientImpl"));
        Intrinsics.checkNotNull(r2);
        goto L12
    L5:
        if (r0.a() != true) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final List<String> n() {
        return g68.a.d();
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final AsrClientStatus t() {
        return this.e;
    }

    public static String C(String r1) {
        String r2 = r1 + "_long";
        b68.b.a.getClass();
        return b68.b.c("/record/asr/pcm_o/", r2);
    }

    public static boolean S(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        y58.a r5 = g68.a.c(r4);
        x58.a r3 = null;
        if (r5 == null) goto L14;
        x58.a r6 = r5.C;
    L15:
        if (r6 != null) goto L18;
        if (r5 == null) goto L18;
        r5.C = m58.h.a;
    L18:
        if (r5 == null) goto L20;
        r3 = r5.C;
    L20:
        if (r3 != null) goto L22;
    L24:
        return false;
    L22:
        if (Intrinsics.areEqual(m58.h.p.getValue(), Boolean.TRUE) == false) goto L24;
        return true;
    L14:
        r6 = null;
        goto L15
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static b w(String r13) {
        AsrEventEnum r9 = AsrEventEnum.ASR_SAMI_NOT_READY_ERROR;
        int r0 = r9.getCode();
        String r3 = r9.getText();
        AsrResultState r8 = AsrResultState.FAIL;
        long r6 = g68.a.g(r13);
        return new b(r13, Integer.valueOf(r0), r3, "", null, r6, r8, r9, null, 272);
    }

    public static void x(String r2) {
        int r0 = c68.b.a;
        c68.b.a("FlowAsrClient", "cancelCurrentTaskAndRelease => taskId:" + r2);
        if (r2 == null) goto L14;
        ConcurrentHashMap<String, e> r1 = g68.a.a;
        Intrinsics.checkNotNullParameter(r2, "taskId");
        if (r2.length() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L16;
        e r4 = g68.a.a.get(r2);
        if (r4 == null) goto L15;
        r4.cancel();
        return;
    L15:
        return;
    L16:
        return;
    L7:
        r3 = false;
        goto L8
    }

    public final int E(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return 0;
    L11:
        Integer r4 = this.l.get(r3);
        if (r4 != null) goto L14;
        return 0;
    L14:
        return r4.intValue();
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void H(String r14) {
        O(this, r14, AsrCallBackType.ASR_FAILED, "", "", 0, null, AsrEventEnum.ASR_RECORDER_SILENCED.getCode(), null, null, null, 928);
        f(r14);
    }

    public final void M(String r7) {
        k r0 = c68.a.c("remove asr task");
        if (r0 == null) goto L38;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("task_id", r7);
        y58.a r3 = this.o.get(r7);
        if (r3 == null) goto L7;
        String r4 = r3.y;
    L8:
        String r5 = "";
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r2.put("bot_id", r4);
        y58.a r6 = this.o.get(r7);
        if (r6 == null) goto L14;
        String r8 = r6.c;
    L15:
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r2.put("conversation_id", r8);
        y58.a r9 = this.o.get(r7);
        if (r9 == null) goto L20;
        String r10 = r9.e;
    L21:
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        r2.put("file_path", r10);
        r2.put("asr_task_map_size", String.valueOf(g68.a.e()));
        r2.put("timeout_runnable_map_size", String.valueOf(this.k.size()));
        r2.put("asr_task_queue_size", String.valueOf(F().size()));
        r2.put("has_timeout_task", String.valueOf(this.k.contains(r7)));
        com.larus.audio.utils.b r1 = (com.larus.audio.utils.b) r0;
        r1.c(r2);
        r1.d("FlowAsrClient.removeAsrTask");
        y58.a r11 = this.o.get(r7);
        if (r11 == null) goto L31;
        y58.d r12 = r11.z;
        if (r12 == null) goto L31;
        String r13 = r12.a;
        if (r13 == null) goto L31;
        r5 = r13;
    L31:
        r1.b(CollectionsKt.listOf(r5));
        y58.a r14 = this.o.get(r7);
        if (r14 == null) goto L36;
        y58.d r15 = r14.z;
        if (r15 == null) goto L36;
        String r16 = r15.b;
    L37:
        r1.e(r16);
        k.a.a(r1);
    L36:
        r16 = null;
        goto L37
    L20:
        r10 = null;
        goto L21
    L14:
        r8 = null;
        goto L15
    L7:
        r4 = null;
    L38:
        g68.a.a(r7, null);
        Intrinsics.checkNotNullParameter(r7, "taskId");
        if (r7.length() != 0) goto L41;
        boolean r17 = true;
    L42:
        if (r17 == true) goto L45;
        ConcurrentHashMap<String, e> r19 = g68.a.a;
        r19.remove(r7);
        int r20 = c68.b.a;
        c68.b.a("AsrManager", "#removeAsrTask => taskId:" + r7 + ", task size:" + r19.size());
    L45:
        this.l.remove(r7);
        this.m.remove(r7);
        B().remove(r7);
        Runnable r21 = this.k.get(r7);
        if (r21 == null) goto L48;
        g1.a.removeCallbacks(r21);
    L48:
        this.k.remove(r7);
        z(r7);
        this.o.remove(r7);
        return;
    L41:
        r17 = false;
        goto L42
    }

    public final void N(final String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        c68.b.b("FlowAsrClient", "removeFile => file path is null or empty");
        return;
    L11:
        ThreadMethodProxy.start(new PthreadThreadV2(new g78.c(r3, this), "FlowAsrClientImpl"));
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void d(n58.a r2) {
        Intrinsics.checkNotNullParameter(r2, "asrAudioDataListener");
        this.i = r2;
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void f(String r19) {
        k r0 = c68.a.c("try cancelAsr");
        if (r0 == null) goto L48;
        LinkedHashMap r15 = new LinkedHashMap();
        if (r19 != null) goto L7;
        String r3 = "";
    L8:
        r15.put("task_id", r3);
        y58.a r4 = this.o.get(r19);
        if (r4 == null) goto L11;
        String r5 = r4.y;
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r15.put("bot_id", r5);
        y58.a r6 = this.o.get(r19);
        if (r6 == null) goto L17;
        String r7 = r6.c;
    L18:
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r15.put("conversation_id", r7);
        y58.a r8 = this.o.get(r19);
        if (r8 == null) goto L23;
        String r9 = r8.e;
    L24:
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r15.put("file_path", r9);
        r15.put("audio_recorder_status", this.e.name());
        c r10 = this.x;
        if (r10 == null) goto L31;
        AsrDataSourceState r11 = r10.a();
        if (r11 == null) goto L31;
        String r12 = r11.name();
    L32:
        if (r12 != null) goto L34;
        r12 = "";
    L34:
        r15.put("audio_record_status", r12);
        r15.put("asr_task_map_size", String.valueOf(g68.a.e()));
        r15.put("timeout_runnable_map_size", String.valueOf(this.k.size()));
        r15.put("asr_task_queue_size", String.valueOf(F().size()));
        com.larus.audio.utils.b r1 = (com.larus.audio.utils.b) r0;
        r1.c(r15);
        r1.d("FlowAsrClient.cancelAsr");
        y58.a r13 = this.o.get(r19);
        if (r13 == null) goto L40;
        y58.d r14 = r13.z;
        if (r14 == null) goto L40;
        String r16 = r14.a;
        if (r16 == null) goto L40;
    L41:
        r1.b(CollectionsKt.listOf(r16));
        y58.a r17 = this.o.get(r19);
        if (r17 == null) goto L46;
        y58.d r20 = r17.z;
        if (r20 == null) goto L46;
        String r21 = r20.b;
    L47:
        r1.e(r21);
        k.a.a(r1);
    L46:
        r21 = null;
    L40:
        r16 = "";
    L31:
        r12 = null;
        goto L32
    L23:
        r9 = null;
        goto L24
    L17:
        r7 = null;
        goto L18
    L11:
        r5 = null;
        goto L12
    L7:
        r3 = r19;
    L48:
        d r2 = this.f;
        if (r2 == null) goto L53;
        AsrLifeState r22 = AsrLifeState.ASR_STOP;
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("scene_from", AsrStopType.USER_CANCEL.getType());
        Unit r23 = Unit.INSTANCE;
        r2.d(r22, r19, r110);
    L53:
        if (this.x == null) goto L130;
        if (r19 != null) goto L56;
    L59:
        boolean r24 = true;
    L179:
        if (r24 == true) goto L130;
        x(r19);     // Catch: Exception -> L66 Throwable -> L116
        J();
        y58.a r25 = g68.a.c(r19);
        if (r25 != null) goto L120;
    L121:
        String r26 = null;
    L122:
        N(r26);
        this.y.remove(r19);
        z(r19);
        return;
    L120:
        r26 = r25.e;
        goto L122
    L66:
        e = move-exception;
        l r27 = c68.a.a;     // Catch: Throwable -> L116
        k r29 = c68.a.b("cancelAsr error");     // Catch: Throwable -> L116
        if (r29 == null) goto L118;
        LinkedHashMap r30 = new LinkedHashMap();     // Catch: Throwable -> L116
        r30.put("task_id", r19);     // Catch: Throwable -> L116
        y58.a r111 = this.o.get(r19);     // Catch: Throwable -> L116
        if (r111 == null) goto L73;
        String r112 = r111.y;     // Catch: Throwable -> L116
    L74:
        if (r112 != null) goto L76;
        r112 = "";
    L76:
        r30.put("bot_id", r112);     // Catch: Throwable -> L116
        y58.a r113 = this.o.get(r19);     // Catch: Throwable -> L116
        if (r113 == null) goto L79;
        String r114 = r113.c;     // Catch: Throwable -> L116
    L80:
        if (r114 != null) goto L82;
        r114 = r14;
    L82:
        r30.put("conversation_id", r114);     // Catch: Throwable -> L116
        y58.a r115 = this.o.get(r19);     // Catch: Throwable -> L116
        if (r115 == null) goto L85;
        String r116 = r115.e;     // Catch: Throwable -> L116
    L86:
        if (r116 != null) goto L88;
        r116 = r14;
    L88:
        r30.put("file_path", r116);     // Catch: Throwable -> L116
        r30.put("audio_recorder_status", this.e.name());     // Catch: Throwable -> L116
        c r31 = this.x;     // Catch: Throwable -> L116
        if (r31 == null) goto L93;
        AsrDataSourceState r32 = r31.a();     // Catch: Throwable -> L116
        if (r32 == null) goto L93;
        String r33 = r32.name();     // Catch: Throwable -> L116
    L94:
        if (r33 != null) goto L96;
        r33 = r14;
    L96:
        r30.put("audio_record_status", r33);     // Catch: Throwable -> L116
        r30.put("asr_task_map_size", String.valueOf(g68.a.e()));     // Catch: Throwable -> L116
        r30.put("timeout_runnable_map_size", String.valueOf(this.k.size()));     // Catch: Throwable -> L116
        r30.put("asr_task_queue_size", String.valueOf(F().size()));     // Catch: Throwable -> L116
        String r34 = e.getMessage();     // Catch: Throwable -> L116
        if (r34 != null) goto L99;
        r34 = r14;
    L99:
        r30.put("error_message", r34);     // Catch: Throwable -> L116
        com.larus.audio.utils.b r35 = (com.larus.audio.utils.b) r29;     // Catch: Throwable -> L116
        r35.c(r30);     // Catch: Throwable -> L116
        r35.d("FlowAsrClient.cancelAsr");     // Catch: Throwable -> L116
        y58.a r36 = this.o.get(r19);     // Catch: Throwable -> L116
        if (r36 == null) goto L107;
        y58.d r37 = r36.z;     // Catch: Throwable -> L116
        if (r37 == null) goto L107;
        String r38 = r37.a;     // Catch: Throwable -> L116
        if (r38 == null) goto L107;
        String r117 = r38;
    L108:
        r35.b(CollectionsKt.listOf(r117));     // Catch: Throwable -> L116
        y58.a r39 = this.o.get(r19);     // Catch: Throwable -> L116
        if (r39 == null) goto L113;
        y58.d r40 = r39.z;     // Catch: Throwable -> L116
        if (r40 == null) goto L113;
        String r41 = r40.b;     // Catch: Throwable -> L116
    L114:
        r35.e(r41);     // Catch: Throwable -> L116
        k.a.a(r35);     // Catch: Throwable -> L116
    L113:
        r41 = null;
    L107:
        r117 = r14;
    L93:
        r33 = null;
        goto L94
    L85:
        r116 = null;
        goto L86
    L79:
        r114 = null;
        goto L80
    L73:
        r112 = null;
    L118:
        J();
        r25 = g68.a.c(r19);
        if (r25 == null) goto L121;
    L116:
        th = move-exception;
        J();
        y58.a r42 = g68.a.c(r19);
        if (r42 == null) goto L127;
        String r43 = r42.e;
    L128:
        N(r43);
        this.y.remove(r19);
        z(r19);
        throw th;
    L127:
        r43 = null;
        goto L128
    L56:
        if (r19.length() == 0) goto L59;
        r24 = false;
    L130:
        J();
        k r44 = c68.a.b("cancelAsr failed taskId or mAudioRecord is null");
        if (r44 == null) goto L182;
        LinkedHashMap r45 = new LinkedHashMap();
        if (r19 != null) goto L135;
        String r118 = r14;
    L136:
        r45.put("task_id", r118);
        y58.a r119 = this.o.get(r19);
        if (r119 == null) goto L139;
        String r120 = r119.y;
    L140:
        if (r120 != null) goto L142;
        r120 = r14;
    L142:
        r45.put("bot_id", r120);
        y58.a r121 = this.o.get(r19);
        if (r121 == null) goto L145;
        String r122 = r121.c;
    L146:
        if (r122 != null) goto L148;
        r122 = r14;
    L148:
        r45.put("conversation_id", r122);
        y58.a r123 = this.o.get(r19);
        if (r123 == null) goto L151;
        String r124 = r123.e;
    L152:
        if (r124 != null) goto L154;
        r124 = r14;
    L154:
        r45.put("file_path", r124);
        r45.put("audio_recorder_status", this.e.name());
        c r46 = this.x;
        if (r46 == null) goto L159;
        AsrDataSourceState r47 = r46.a();
        if (r47 == null) goto L159;
        String r48 = r47.name();
    L160:
        if (r48 != null) goto L162;
        r48 = r14;
    L162:
        r45.put("audio_record_status", r48);
        r45.put("asr_task_map_size", String.valueOf(g68.a.e()));
        r45.put("timeout_runnable_map_size", String.valueOf(this.k.size()));
        r45.put("asr_task_queue_size", String.valueOf(F().size()));
        com.larus.audio.utils.b r49 = (com.larus.audio.utils.b) r44;
        r49.c(r45);
        r49.d("FlowAsrClient.cancelAsr");
        y58.a r50 = this.o.get(r19);
        if (r50 == null) goto L170;
        y58.d r51 = r50.z;
        if (r51 == null) goto L170;
        String r52 = r51.a;
        if (r52 == null) goto L170;
        String r125 = r52;
    L171:
        r49.b(CollectionsKt.listOf(r125));
        y58.a r53 = this.o.get(r19);
        if (r53 == null) goto L176;
        y58.d r54 = r53.z;
        if (r54 == null) goto L176;
        String r55 = r54.b;
    L177:
        r49.e(r55);
        k.a.a(r49);
        return;
    L176:
        r55 = null;
    L170:
        r125 = r14;
    L159:
        r48 = null;
        goto L160
    L151:
        r124 = null;
        goto L152
    L145:
        r122 = null;
        goto L146
    L139:
        r120 = null;
        goto L140
    L135:
        r118 = r19;
        goto L136
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final y58.a g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return g68.a.c(r2);
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void h(o58.b r2) {
        Intrinsics.checkNotNullParameter(r2, "asrStrategy");
        this.p = r2;
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void j(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        int r2 = c68.b.a;
        c68.b.a("FlowAsrClient", "releaseAsrTask => taskId:" + r10);
        y58.a r3 = g68.a.c(r10);
        String r4 = null;
        if (r3 == null) goto L14;
        String r5 = r3.e;
    L119:
        g68.a.h(r10);     // Catch: Exception -> L33 Throwable -> L80
        J();     // Catch: Exception -> L33 Throwable -> L80
    L121:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L18
        y(r10, "releaseAsrTask");     // Catch: Throwable -> L18
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L128:
        J();     // Catch: Throwable -> L22
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L134:
        M(r10);     // Catch: Throwable -> L26
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        N(r5);     // Catch: Throwable -> L31
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        Result.constructor-impl(r0);     // Catch: Throwable -> L31
    L97:
        this.y.remove(r10);
        z(r10);
        return;
    L26:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L33:
        e = move-exception;
        k r11 = c68.a.b("releaseAsrTask error");     // Catch: Throwable -> L80
        if (r11 == null) goto L117;
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L80
        r12.put("task_id", r10);     // Catch: Throwable -> L80
        y58.a r13 = this.o.get(r10);     // Catch: Throwable -> L80
        if (r13 == null) goto L40;
        String r14 = r13.y;     // Catch: Throwable -> L80
    L41:
        String r15 = "";
        if (r14 != null) goto L44;
        r14 = "";
    L44:
        r12.put("bot_id", r14);     // Catch: Throwable -> L80
        y58.a r16 = this.o.get(r10);     // Catch: Throwable -> L80
        if (r16 == null) goto L47;
        String r17 = r16.c;     // Catch: Throwable -> L80
    L48:
        if (r17 != null) goto L50;
        r17 = "";
    L50:
        r12.put("conversation_id", r17);     // Catch: Throwable -> L80
        if (r5 != null) goto L53;
        String r19 = "";
    L54:
        r12.put("file_path", r19);     // Catch: Throwable -> L80
        r12.put("audio_recorder_status", this.e.name());     // Catch: Throwable -> L80
        c r20 = this.x;     // Catch: Throwable -> L80
        if (r20 == null) goto L59;
        AsrDataSourceState r21 = r20.a();     // Catch: Throwable -> L80
        if (r21 == null) goto L59;
        String r22 = r21.name();     // Catch: Throwable -> L80
    L60:
        if (r22 != null) goto L62;
        r22 = "";
    L62:
        r12.put("audio_record_status", r22);     // Catch: Throwable -> L80
        r12.put("asr_task_map_size", String.valueOf(g68.a.e()));     // Catch: Throwable -> L80
        r12.put("timeout_runnable_map_size", String.valueOf(this.k.size()));     // Catch: Throwable -> L80
        r12.put("asr_task_queue_size", String.valueOf(F().size()));     // Catch: Throwable -> L80
        String r23 = e.getMessage();     // Catch: Throwable -> L80
        if (r23 != null) goto L65;
        r23 = "";
    L65:
        r12.put("error_message", r23);     // Catch: Throwable -> L80
        com.larus.audio.utils.b r24 = (com.larus.audio.utils.b) r11;     // Catch: Throwable -> L80
        r24.c(r12);     // Catch: Throwable -> L80
        r24.d("FlowAsrClient.releaseAsrTask");     // Catch: Throwable -> L80
        y58.a r25 = this.o.get(r10);     // Catch: Throwable -> L80
        if (r25 == null) goto L73;
        y58.d r26 = r25.z;     // Catch: Throwable -> L80
        if (r26 == null) goto L73;
        String r27 = r26.a;     // Catch: Throwable -> L80
        if (r27 == null) goto L73;
        r15 = r27;
    L73:
        r24.b(CollectionsKt.listOf(r15));     // Catch: Throwable -> L80
        y58.a r29 = this.o.get(r10);     // Catch: Throwable -> L80
        if (r29 == null) goto L78;
        y58.d r30 = r29.z;     // Catch: Throwable -> L80
        if (r30 == null) goto L78;
        r4 = r30.b;     // Catch: Throwable -> L80
    L78:
        r24.e(r4);     // Catch: Throwable -> L80
        k.a.a(r24);     // Catch: Throwable -> L80
    L59:
        r22 = null;
        goto L60
    L53:
        r19 = r5;
        goto L54
    L47:
        r17 = null;
        goto L48
    L40:
        r14 = null;
    L117:
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L84
        y(r10, "releaseAsrTask");     // Catch: Throwable -> L84
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L84
    L123:
        J();     // Catch: Throwable -> L88
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L88
    L130:
        M(r10);     // Catch: Throwable -> L92
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L94:
        N(r5);     // Catch: Throwable -> L31
        r0 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L92:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L88:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L84:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L80:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L101
        y(r10, "releaseAsrTask");     // Catch: Throwable -> L101
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L132:
        J();     // Catch: Throwable -> L105
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L105
    L136:
        M(r10);     // Catch: Throwable -> L109
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L109
    L139:
        N(r5);     // Catch: Throwable -> L113
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L113
    L115:
        this.y.remove(r10);
        z(r10);
        throw th;
    L113:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L109:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L105:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L101:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L31:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L97
    L14:
        r5 = null;
        goto L119
    L5:
        if (r10.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final long p(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        return g68.a.g(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.larus.audio.utils.b, m58.k] */
    /* JADX WARN: Type inference failed for: r0v65, types: [com.larus.audio.utils.b, m58.k] */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v48 */
    /* JADX WARN: Type inference failed for: r11v49, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v56 */
    /* JADX WARN: Type inference failed for: r11v57 */
    /* JADX WARN: Type inference failed for: r11v59 */
    /* JADX WARN: Type inference failed for: r11v60 */
    /* JADX WARN: Type inference failed for: r11v61, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v62 */
    /* JADX WARN: Type inference failed for: r11v63 */
    /* JADX WARN: Type inference failed for: r11v64, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v65 */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r11v67, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v68 */
    /* JADX WARN: Type inference failed for: r11v69, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v71 */
    /* JADX WARN: Type inference failed for: r11v73 */
    /* JADX WARN: Type inference failed for: r11v75 */
    /* JADX WARN: Type inference failed for: r11v83 */
    /* JADX WARN: Type inference failed for: r11v84 */
    /* JADX WARN: Type inference failed for: r11v85 */
    /* JADX WARN: Type inference failed for: r11v86 */
    /* JADX WARN: Type inference failed for: r11v87 */
    /* JADX WARN: Type inference failed for: r11v88 */
    /* JADX WARN: Type inference failed for: r11v89 */
    /* JADX WARN: Type inference failed for: r11v90 */
    /* JADX WARN: Type inference failed for: r11v91 */
    /* JADX WARN: Type inference failed for: r11v92 */
    /* JADX WARN: Type inference failed for: r11v93 */
    /* JADX WARN: Type inference failed for: r11v94 */
    /* JADX WARN: Type inference failed for: r11v95 */
    /* JADX WARN: Type inference failed for: r11v96 */
    /* JADX WARN: Type inference failed for: r11v97 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v35, types: [com.larus.audio.utils.b, m58.k] */
    /* JADX WARN: Type inference failed for: r1v52, types: [com.larus.audio.utils.b, m58.k] */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v17 */
    /* JADX WARN: Type inference failed for: r22v18 */
    /* JADX WARN: Type inference failed for: r22v19 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v21 */
    /* JADX WARN: Type inference failed for: r22v22 */
    /* JADX WARN: Type inference failed for: r22v24 */
    /* JADX WARN: Type inference failed for: r22v25 */
    /* JADX WARN: Type inference failed for: r22v26 */
    /* JADX WARN: Type inference failed for: r22v27 */
    /* JADX WARN: Type inference failed for: r22v28 */
    /* JADX WARN: Type inference failed for: r22v29 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v30 */
    /* JADX WARN: Type inference failed for: r22v31 */
    /* JADX WARN: Type inference failed for: r22v32 */
    /* JADX WARN: Type inference failed for: r22v33 */
    /* JADX WARN: Type inference failed for: r22v34 */
    /* JADX WARN: Type inference failed for: r22v35 */
    /* JADX WARN: Type inference failed for: r22v36 */
    /* JADX WARN: Type inference failed for: r22v37 */
    /* JADX WARN: Type inference failed for: r22v38 */
    /* JADX WARN: Type inference failed for: r22v39 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v40 */
    /* JADX WARN: Type inference failed for: r22v41 */
    /* JADX WARN: Type inference failed for: r22v42 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r2v184 */
    /* JADX WARN: Type inference failed for: r2v188 */
    /* JADX WARN: Type inference failed for: r2v191 */
    /* JADX WARN: Type inference failed for: r2v192 */
    /* JADX WARN: Type inference failed for: r2v193 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r2v99 */
    /* JADX WARN: Type inference failed for: r36v0 */
    /* JADX WARN: Type inference failed for: r36v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r36v2 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r49v0, types: [com.larus.audio.flow.client.FlowAsrClientImpl] */
    @Override // com.larus.audio.IFlowAsrClientService
    public final boolean r(String r50) {
        k r1 = c68.a.c("try stopAsr start");
        String r10 = "FlowAsrClient.stopAsr";
        String r19 = "";
        if (r1 == null) goto L49;
        LinkedHashMap r2 = new LinkedHashMap();
        if (r50 != null) goto L7;
        String r3 = "";
    L8:
        r2.put("task_id", r3);
        y58.a r4 = this.o.get(r50);
        if (r4 == null) goto L11;
        String r5 = r4.y;
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r2.put("bot_id", r5);
        y58.a r6 = this.o.get(r50);
        if (r6 == null) goto L17;
        String r7 = r6.c;
    L18:
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r2.put("conversation_id", r7);
        y58.a r8 = this.o.get(r50);
        if (r8 == null) goto L23;
        String r9 = r8.e;
    L24:
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r2.put("file_path", r9);
        r2.put("audio_recorder_status", this.e.name());
        c r11 = this.x;
        if (r11 == null) goto L31;
        AsrDataSourceState r12 = r11.a();
        if (r12 == null) goto L31;
        String r13 = r12.name();
    L32:
        if (r13 != null) goto L34;
        r13 = "";
    L34:
        r2.put("audio_record_status", r13);
        r2.put("asr_task_map_size", String.valueOf(g68.a.e()));
        r2.put("timeout_runnable_map_size", String.valueOf(this.k.size()));
        r2.put("asr_task_queue_size", String.valueOf(F().size()));
        com.larus.audio.utils.b r14 = (com.larus.audio.utils.b) r1;
        r14.c(r2);
        r14.d("FlowAsrClient.stopAsr");
        y58.a r15 = this.o.get(r50);
        if (r15 == null) goto L40;
        y58.d r16 = r15.z;
        if (r16 == null) goto L40;
        String r17 = r16.a;
        if (r17 == null) goto L40;
    L41:
        r14.b(CollectionsKt.listOf(r17));
        y58.a r20 = this.o.get(r50);
        if (r20 == null) goto L46;
        y58.d r21 = r20.z;
        if (r21 == null) goto L46;
        String r22 = r21.b;
    L47:
        r14.e(r22);
        k.a.a(r14);
        Unit r23 = Unit.INSTANCE;
    L46:
        r22 = null;
    L40:
        r17 = "";
    L31:
        r13 = null;
        goto L32
    L23:
        r9 = null;
        goto L24
    L17:
        r7 = null;
        goto L18
    L11:
        r5 = null;
        goto L12
    L7:
        r3 = r50;
    L49:
        if (this.x != null) goto L52;
        this.e = AsrClientStatus.STATE_IDLE;
    L52:
        if (r50 != null) goto L54;
    L57:
        boolean r24 = true;
    L58:
        if (r24 == false) goto L60;
    L426:
        k r0 = c68.a.d("try stopAsr fail");
        if (r0 == null) goto L465;
        LinkedHashMap r25 = new LinkedHashMap();
        if (r50 != null) goto L431;
        String r26 = "";
    L432:
        r25.put("task_id", r26);
        y58.a r27 = this.o.get(r50);
        if (r27 == null) goto L435;
        String r110 = r27.y;
    L436:
        if (r110 != null) goto L438;
        r110 = "";
    L438:
        r25.put("bot_id", r110);
        y58.a r29 = this.o.get(r50);
        if (r29 == null) goto L441;
        String r111 = r29.c;
    L442:
        if (r111 != null) goto L444;
        r111 = "";
    L444:
        r25.put("conversation_id", r111);
        y58.a r30 = this.o.get(r50);
        if (r30 == null) goto L447;
        String r112 = r30.e;
    L448:
        if (r112 != null) goto L450;
        r112 = "";
    L450:
        r25.put("file_path", r112);
        com.larus.audio.utils.b r31 = (com.larus.audio.utils.b) r0;
        r31.c(r25);
        r31.d("FlowAsrClient.stopAsr");
        y58.a r32 = this.o.get(r50);
        if (r32 == null) goto L458;
        y58.d r33 = r32.z;
        if (r33 == null) goto L458;
        String r34 = r33.a;
        if (r34 == null) goto L458;
        r19 = r34;
    L458:
        r31.b(CollectionsKt.listOf(r19));
        y58.a r35 = this.o.get(r50);
        if (r35 == null) goto L463;
        y58.d r36 = r35.z;
        if (r36 == null) goto L463;
        String r113 = r36.b;
    L464:
        r31.e(r113);
        k.a.a(r31);
        Unit r37 = Unit.INSTANCE;
    L463:
        r113 = null;
        goto L464
    L447:
        r112 = null;
        goto L448
    L441:
        r111 = null;
        goto L442
    L435:
        r110 = null;
        goto L436
    L431:
        r26 = r50;
    L465:
        J();
        return false;
    L60:
        if (this.x == null) goto L426;
        h r38 = B().get(r50);
        if (r38 == null) goto L65;
        r38.s();
        Unit r39 = Unit.INSTANCE;
    L65:
        k78.a r40 = this.m.get(r50);
        if (r40 == null) goto L73;
        r40.e(AsrStep.ASR_RECOGNITION_DELAY.getTraceName(), null);
        FlowAudioAsrAndTTSCostMobHelper.d(r50, "stopAsr");
        y58.a r41 = g68.a.c(r50);
        if (r41 == null) goto L71;
        String r42 = r41.c;
        if (r42 == null) goto L71;
    L72:
        g1.a.post(new m(new g78.f(this, r50, r42)));
        Unit r43 = Unit.INSTANCE;
    L71:
        r42 = "";
    L73:
        x58.a r44 = m58.h.a;
        m58.u r45 = m58.h.l;
        if (r45 == null) goto L76;
        r45.f(r50, "asr_touch_up_to_recognize_last_pkg", null);
        Unit r46 = Unit.INSTANCE;
    L76:
        m58.u r47 = m58.h.l;
        if (r47 == null) goto L79;
        r47.f(r50, "asr_touch_up_to_stream_pkg", null);
        Unit r48 = Unit.INSTANCE;
    L79:
        y58.a r49 = g68.a.c(r50);
        if (r49 != null) goto L82;
    L84:
        boolean r51 = false;
    L85:
        if (r51 == false) goto L89;
        k78.a r52 = this.m.get(r50);
        if (r52 == null) goto L89;
        r52.e(AsrStep.ASR_AUDIO_UPLOAD.getTraceName(), null);
        Unit r53 = Unit.INSTANCE;
    L89:
        k78.a r54 = this.m.get(r50);
        if (r54 == null) goto L92;
        r54.f(AsrStep.ASR_AUDIO_RECORD.getTraceName(), null);
        Unit r55 = Unit.INSTANCE;
    L92:
        m58.u r56 = m58.h.l;
        if (r56 == null) goto L95;
        ?? r210 = 28;
        r210 = 28;
        boolean r114 = true;
        u$a.b(r56, r50, "asr_start_record_to_touch_up", null, null, null, 28);
        Unit r57 = Unit.INSTANCE;
    L96:
        m58.u r59 = m58.h.l;
        if (r59 == null) goto L99;
        r59.f(r50, "asr_touch_up_to_send_end_asr", null);
        Unit r60 = Unit.INSTANCE;
    L99:
        m58.u r61 = m58.h.l;
        if (r61 == null) goto L102;
        r61.f(r50, "tts_touch_up_to_chat_first_pkg", null);
        Unit r62 = Unit.INSTANCE;
    L102:
        k r63 = c68.a.c("try stopAsr before release audio recorder");
        if (r63 == null) goto L474;
        LinkedHashMap r64 = new LinkedHashMap();
        r64.put("task_id", r50);
        y58.a r65 = this.o.get(r50);
        if (r65 == null) goto L107;
        String r66 = r65.y;
    L108:
        if (r66 != null) goto L110;
        r66 = "";
    L110:
        r64.put("bot_id", r66);
        y58.a r67 = this.o.get(r50);
        if (r67 == null) goto L113;
        String r68 = r67.c;
    L114:
        if (r68 != null) goto L116;
        r68 = "";
    L116:
        r64.put("conversation_id", r68);
        y58.a r69 = this.o.get(r50);
        if (r69 == null) goto L119;
        String r70 = r69.e;
    L120:
        if (r70 != null) goto L122;
        r70 = "";
    L122:
        r64.put("file_path", r70);
        r64.put("min_duration_time", String.valueOf(this.g));
        com.larus.audio.utils.b r71 = (com.larus.audio.utils.b) r63;
        r71.c(r64);
        r71.d("FlowAsrClient.stopAsr");
        y58.a r72 = this.o.get(r50);
        if (r72 == null) goto L128;
        y58.d r73 = r72.z;
        if (r73 == null) goto L128;
        String r74 = r73.a;
        if (r74 == null) goto L128;
    L129:
        r71.b(CollectionsKt.listOf(r74));
        y58.a r75 = this.o.get(r50);
        if (r75 == null) goto L134;
        y58.d r76 = r75.z;
        if (r76 == null) goto L134;
        String r77 = r76.b;
    L135:
        r71.e(r77);
        k.a.a(r71);
        Unit r79 = Unit.INSTANCE;
    L134:
        r77 = null;
    L128:
        r74 = "";
        goto L129
    L119:
        r70 = null;
        goto L120
    L113:
        r68 = null;
        goto L114
    L107:
        r66 = null;
    L474:
        J();     // Catch: Throwable -> L280 Exception -> L285
        long r80 = System.currentTimeMillis() - this.g;     // Catch: Throwable -> L280 Exception -> L285
        y58.a r81 = this.o.get(r50);     // Catch: Throwable -> L280 Exception -> L285
        if (r81 != null) goto L481;
        long r82 = 500;
    L469:
        if (r80 < r82) goto L478;
        Object r211 = "conversation_id";
        Object r212 = "file_path";
        String r310 = "FlowAsrClient.stopAsr";
        Object r213 = null;
        Object r311 = r7;
        Object r312 = r6;
        Object r313 = "is_cancel";
        Object r314 = "record_duration";
        b r83 = this.y.remove(r50);     // Catch: Throwable -> L276 Exception -> L278
        if (r83 == null) goto L182;
    L185:
        b r115 = null;
    L186:
        if (r83 != null) goto L188;
        r83 = r115;
    L188:
        if (r83 != null) goto L483;
        y r116 = null;
        boolean r84 = false;
    L480:
        y58.a r85 = g68.a.c(r50);     // Catch: Throwable -> L272 Exception -> L274
        if (r85 == null) goto L199;
        String r86 = r85.e;     // Catch: Throwable -> L272 Exception -> L274
    L200:
        if (r86 != null) goto L202;
    L205:
        boolean r87 = true;
    L206:
        if (r87 == true) goto L220;
        y58.a r88 = g68.a.c(r50);     // Catch: Throwable -> L272 Exception -> L274
        if (r88 == null) goto L210;
        String r89 = r88.d();     // Catch: Throwable -> L272 Exception -> L274
    L211:
        Q(r50, r89, r116);     // Catch: Throwable -> L272 Exception -> L274
        y58.a r90 = this.o.get(r50);     // Catch: Throwable -> L272 Exception -> L274
        if (r90 != null) goto L214;
    L216:
        r114 = false;
    L217:
        if (r114 == false) goto L219;
        String r91 = C(r50);     // Catch: Throwable -> L272 Exception -> L274
        int r92 = c68.b.a;     // Catch: Throwable -> L272 Exception -> L274
        c68.b.d("FlowAsrClient", "obric business, taskId: " + r50 + ", write audio data to obric path: " + r91);     // Catch: Throwable -> L272 Exception -> L274
        R(r50, r91);     // Catch: Throwable -> L272 Exception -> L274
    L219:
        Unit r93 = Unit.INSTANCE;     // Catch: Throwable -> L272 Exception -> L274
    L224:
        boolean r94 = r84;
        boolean r95 = false;
        ?? r214 = r213;
        Object r215 = r211;
        Object r216 = r212;
        Object r315 = r314;
        Object r316 = r311;
        Object r317 = r313;
        Object r318 = r312;
    L225:
        long r410 = g68.a.g(r50);
        k r96 = c68.a.c("stopAsr audio recorder finished");
        if (r96 == null) goto L259;
        LinkedHashMap r97 = new LinkedHashMap();
        r97.put(r318, r50);
        y58.a r98 = this.o.get(r50);
        if (r98 == null) goto L230;
        ?? r117 = r98.a();
    L231:
        if (r117 != 0) goto L233;
        r117 = "";
    L233:
        r97.put(r316, r117);
        y58.a r99 = this.o.get(r50);
        if (r99 == null) goto L236;
        ?? r118 = r99.c();
    L237:
        if (r118 != 0) goto L239;
        r118 = "";
    L239:
        r97.put(r215, r118);
        y58.a r100 = this.o.get(r50);
        if (r100 == null) goto L242;
        ?? r119 = r100.d();
    L243:
        if (r119 != 0) goto L245;
        r119 = "";
    L245:
        r97.put(r216, r119);
        r97.put(r315, String.valueOf(r410));
        r97.put(r317, String.valueOf(r95));
        ?? r101 = (com.larus.audio.utils.b) r96;
        r101.c(r97);
        r101.d(r310);
        y58.a r102 = this.o.get(r50);
        if (r102 == null) goto L251;
        y58.d r103 = r102.f();
        if (r103 == null) goto L251;
        String r104 = r103.b();
        if (r104 == null) goto L251;
    L252:
        r101.b(CollectionsKt.listOf(r104));
        y58.a r105 = this.o.get(r50);
        if (r105 == null) goto L257;
        y58.d r106 = r105.f();
        if (r106 == null) goto L257;
        ?? r120 = r106.a();
    L258:
        r101.e(r120);
        k.a.a(r101);
        Unit r107 = Unit.INSTANCE;
    L257:
        r120 = r214;
    L251:
        r104 = "";
        goto L252
    L242:
        r119 = r214;
        goto L243
    L236:
        r118 = r214;
        goto L237
    L230:
        r117 = r214;
    L259:
        if (r94 == true) goto L485;
        y58.a r108 = g68.a.c(r50);
        if (r108 == null) goto L263;
        ?? r121 = r108.d();
    L264:
        long r109 = D();
        y58.a r122 = g68.a.c(r50);
        if (r122 == null) goto L267;
        ?? r123 = r122.e();
    L268:
        if (r123 != 0) goto L270;
        ?? r319 = "";
    L271:
        AsrEventEnum r124 = AsrEventEnum.ASR_TIMEOUT;
        int r125 = r124.getCode();
        b r126 = new b(r319, Integer.valueOf(r125), r124.getText(), "", null, r410, AsrResultState.FAIL, r124, null, 272);
        ?? r127 = r121;
    L376:
        ?? r128 = r127;
        long r411 = r109;
        boolean r129 = r95;
        A(r50, r128, r411, r126, Integer.valueOf(r124.getCode()), r124.getText(), "stopAsr()");
        return r129;
    L270:
        r319 = r123;
        goto L271
    L267:
        r123 = r214;
        goto L268
    L263:
        r121 = r214;
        goto L264
    L485:
        return r95;
    L214:
        if (r90.b() != 2) goto L216;
    L210:
        r89 = null;
        goto L211
    L220:
        if (r116 == null) goto L224;
        r116.invoke();     // Catch: Throwable -> L272 Exception -> L274
        Unit r130 = Unit.INSTANCE;     // Catch: Throwable -> L272 Exception -> L274
        goto L224
    L202:
        if (r86.length() == 0) goto L205;
        r87 = false;
        goto L206
    L199:
        r86 = null;
    L274:
        e = e;
        Object r131 = r211;
        Object r132 = r212;
        r10 = r310;
        Object r133 = r314;
        Object r134 = r311;
        Object r135 = r313;
        Object r136 = r312;
        ?? r217 = r213;
    L288:
        boolean r137 = r84;
        Object r138 = r136;
        Object r139 = r134;
        Object r140 = r131;
        Object r141 = r132;
        Object r142 = r133;
        Object r143 = r135;
        ?? r218 = r217;
    L289:
        r95 = false;
        Object r144 = r138;
        Object r145 = r139;
        Object r146 = r140;
        Object r147 = r141;
        Object r148 = r142;
        Object r149 = r143;
        ?? r219 = r218;
    L467:
        k r150 = c68.a.b("stopAsr audio recorder error");     // Catch: Throwable -> L295
        if (r150 == null) goto L329;
        LinkedHashMap r151 = new LinkedHashMap();     // Catch: Throwable -> L295
        r151.put(r144, r50);     // Catch: Throwable -> L295
        y58.a r152 = this.o.get(r50);     // Catch: Throwable -> L295
        if (r152 == null) goto L297;
        ?? r153 = r152.y;     // Catch: Throwable -> L295
    L298:
        if (r153 != 0) goto L300;
        r153 = "";
    L300:
        r151.put(r145, r153);     // Catch: Throwable -> L295
        y58.a r154 = this.o.get(r50);     // Catch: Throwable -> L295
        if (r154 == null) goto L303;
        ?? r155 = r154.c();     // Catch: Throwable -> L295
    L304:
        if (r155 != 0) goto L306;
        r155 = "";
    L306:
        r151.put(r146, r155);     // Catch: Throwable -> L295
        y58.a r156 = this.o.get(r50);     // Catch: Throwable -> L295
        if (r156 == null) goto L309;
        ?? r157 = r156.d();     // Catch: Throwable -> L295
    L310:
        if (r157 != 0) goto L312;
        r157 = "";
    L312:
        r151.put(r147, r157);     // Catch: Throwable -> L295
        String r158 = e.getMessage();     // Catch: Throwable -> L295
        if (r158 != null) goto L315;
        r158 = "";
    L315:
        r151.put("error_msg", r158);     // Catch: Throwable -> L295
        ?? r159 = (com.larus.audio.utils.b) r150;     // Catch: Throwable -> L295
        r159.c(r151);     // Catch: Throwable -> L295
        r159.d(r10);     // Catch: Throwable -> L295
        y58.a r160 = this.o.get(r50);     // Catch: Throwable -> L295
        if (r160 == null) goto L321;
        y58.d r161 = r160.f();     // Catch: Throwable -> L295
        if (r161 == null) goto L321;
        String r162 = r161.b();     // Catch: Throwable -> L295
        if (r162 == null) goto L321;
    L322:
        r159.b(CollectionsKt.listOf(r162));     // Catch: Throwable -> L295
        y58.a r163 = this.o.get(r50);     // Catch: Throwable -> L295
        if (r163 == null) goto L327;
        y58.d r164 = r163.f();     // Catch: Throwable -> L295
        if (r164 == null) goto L327;
        ?? r165 = r164.a();     // Catch: Throwable -> L295
    L328:
        r159.e(r165);     // Catch: Throwable -> L295
        k.a.a(r159);     // Catch: Throwable -> L295
        Unit r166 = Unit.INSTANCE;     // Catch: Throwable -> L295
    L327:
        r165 = r219;
    L321:
        r162 = "";
        goto L322
    L309:
        r157 = r219;
        goto L310
    L303:
        r155 = r219;
        goto L304
    L297:
        r153 = r219;
    L329:
        long r220 = g68.a.g(r50);
        k r167 = c68.a.c("stopAsr audio recorder finished");
        if (r167 == null) goto L363;
        LinkedHashMap r168 = new LinkedHashMap();
        r168.put(r144, r50);
        y58.a r169 = this.o.get(r50);
        if (r169 == null) goto L334;
        ?? r170 = r169.y;
    L335:
        if (r170 != 0) goto L337;
        r170 = "";
    L337:
        r168.put(r145, r170);
        y58.a r171 = this.o.get(r50);
        if (r171 == null) goto L340;
        ?? r172 = r171.c;
    L341:
        if (r172 != 0) goto L343;
        r172 = "";
    L343:
        r168.put(r146, r172);
        y58.a r173 = this.o.get(r50);
        if (r173 == null) goto L346;
        ?? r174 = r173.e;
    L347:
        if (r174 != 0) goto L349;
        r174 = "";
    L349:
        r168.put(r147, r174);
        r168.put(r148, String.valueOf(r220));
        r168.put(r149, String.valueOf(r95));
        ?? r175 = (com.larus.audio.utils.b) r167;
        r175.c(r168);
        r175.d(r10);
        y58.a r176 = this.o.get(r50);
        if (r176 == null) goto L355;
        y58.d r177 = r176.z;
        if (r177 == null) goto L355;
        String r178 = r177.a;
        if (r178 == null) goto L355;
    L356:
        r175.b(CollectionsKt.listOf(r178));
        y58.a r179 = this.o.get(r50);
        if (r179 == null) goto L361;
        y58.d r180 = r179.f();
        if (r180 == null) goto L361;
        ?? r181 = r180.a();
    L362:
        r175.e(r181);
        k.a.a(r175);
        Unit r182 = Unit.INSTANCE;
    L361:
        r181 = r219;
    L355:
        r178 = "";
        goto L356
    L346:
        r174 = r219;
        goto L347
    L340:
        r172 = r219;
        goto L341
    L334:
        r170 = r219;
    L363:
        if (r137 == true) goto L486;
        y58.a r183 = g68.a.c(r50);
        if (r183 == null) goto L367;
        ?? r184 = r183.e;
    L368:
        r109 = D();
        y58.a r185 = g68.a.c(r50);
        if (r185 == null) goto L371;
        ?? r186 = r185.b;
    L372:
        if (r186 != 0) goto L374;
        ?? r221 = "";
    L375:
        r124 = AsrEventEnum.ASR_TIMEOUT;
        int r187 = r124.getCode();
        r126 = new b(r221, Integer.valueOf(r187), r124.getText(), "", null, r220, AsrResultState.FAIL, r124, null, 272);
        r127 = r184;
        goto L376
    L374:
        r221 = r186;
        goto L375
    L371:
        r186 = r219;
        goto L372
    L367:
        r184 = r219;
        goto L368
    L486:
        return r95;
    L295:
        th = th;
        Object r188 = r144;
        Object r189 = r145;
        Object r190 = r146;
        Object r191 = r147;
        Object r192 = r148;
        Object r193 = r149;
        ?? r222 = r219;
    L378:
        long r223 = g68.a.g(r50);
        k r194 = c68.a.c("stopAsr audio recorder finished");
        if (r194 == null) goto L412;
        LinkedHashMap r195 = new LinkedHashMap();
        r195.put(r188, r50);
        y58.a r196 = this.o.get(r50);
        if (r196 == null) goto L383;
        ?? r197 = r196.y;
    L384:
        if (r197 != 0) goto L386;
        r197 = "";
    L386:
        r195.put(r189, r197);
        y58.a r198 = this.o.get(r50);
        if (r198 == null) goto L389;
        ?? r199 = r198.c;
    L390:
        if (r199 != 0) goto L392;
        r199 = "";
    L392:
        r195.put(r190, r199);
        y58.a r200 = this.o.get(r50);
        if (r200 == null) goto L395;
        ?? r201 = r200.e;
    L396:
        if (r201 != 0) goto L398;
        r201 = "";
    L398:
        r195.put(r191, r201);
        r195.put(r192, String.valueOf(r223));
        r195.put(r193, String.valueOf(r95));
        ?? r202 = (com.larus.audio.utils.b) r194;
        r202.c(r195);
        r202.d(r10);
        y58.a r203 = this.o.get(r50);
        if (r203 == null) goto L404;
        y58.d r204 = r203.z;
        if (r204 == null) goto L404;
        String r205 = r204.a;
        if (r205 == null) goto L404;
    L405:
        r202.b(CollectionsKt.listOf(r205));
        y58.a r206 = this.o.get(r50);
        if (r206 == null) goto L410;
        y58.d r207 = r206.z;
        if (r207 == null) goto L410;
        ?? r1100 = r207.b;
    L411:
        r202.e(r1100);
        k.a.a(r202);
        Unit r208 = Unit.INSTANCE;
    L410:
        r1100 = r222;
    L404:
        r205 = "";
        goto L405
    L395:
        r201 = r222;
        goto L396
    L389:
        r199 = r222;
        goto L390
    L383:
        r197 = r222;
    L412:
        if (r137 == true) goto L425;
        y58.a r209 = g68.a.c(r50);
        if (r209 == null) goto L416;
        ?? r224 = r209.e;
    L417:
        long r225 = D();
        y58.a r226 = g68.a.c(r50);
        if (r226 == null) goto L420;
        ?? r1101 = r226.b;
    L421:
        if (r1101 != 0) goto L423;
        ?? r227 = "";
    L424:
        AsrEventEnum r228 = AsrEventEnum.ASR_TIMEOUT;
        int r229 = r228.getCode();
        A(r50, r224, r225, new b(r227, Integer.valueOf(r229), r228.getText(), "", null, r223, AsrResultState.FAIL, r228, null, 272), Integer.valueOf(r228.getCode()), r228.getText(), "stopAsr()");
        goto L425
    L423:
        r227 = r1101;
        goto L424
    L420:
        r1101 = r222;
        goto L421
    L416:
        r224 = r222;
    L425:
        throw th;
    L272:
        th = th;
        Object r230 = r211;
        Object r231 = r212;
        r10 = r310;
        Object r232 = r314;
        Object r233 = r311;
        Object r234 = r313;
        Object r235 = r312;
        ?? r236 = r213;
    L283:
        r137 = r84;
        Object r237 = r235;
        Object r238 = r233;
        Object r239 = r230;
        Object r240 = r231;
        Object r241 = r232;
        Object r242 = r234;
        ?? r243 = r236;
    L284:
        r95 = false;
        r188 = r237;
        r189 = r238;
        r190 = r239;
        r191 = r240;
        r192 = r241;
        r193 = r242;
        r222 = r243;
        goto L378
    L483:
        r116 = new y(this, r83);     // Catch: Throwable -> L191 Exception -> L193
        r84 = true;
        goto L480
    L193:
        e = e;
        r131 = r211;
        r132 = r212;
        r10 = r310;
        r133 = r314;
        r134 = r311;
        r135 = r313;
        r136 = r312;
        r84 = true;
        r217 = r213;
    L191:
        th = th;
        r230 = r211;
        r231 = r212;
        r10 = r310;
        r232 = r314;
        r233 = r311;
        r234 = r313;
        r235 = r312;
        r84 = true;
        r236 = r213;
        goto L283
    L182:
        if (this.z.containsKey(r50) == false) goto L185;
        r115 = w(r50);     // Catch: Throwable -> L276 Exception -> L278
        goto L186
    L478:
        Object r244 = "conversation_id";
        Object r245 = "file_path";
        r310 = "FlowAsrClient.stopAsr";
        r210 = 0;
        Object r320 = r7;
        Object r321 = r12;
        Object r322 = r6;
        Object r323 = r13;
        O(this, r50, AsrCallBackType.ASR_CANCEL, "", "", 0, null, 0, null, null, null, 1008);     // Catch: Throwable -> L167 Exception -> L169
        h r246 = B().get(r50);     // Catch: Throwable -> L167 Exception -> L169
    L151:
        if (r246 != null) goto L470;
    L153:
        x(r50);     // Catch: Throwable -> L165 Exception -> L278
        y58.a r247 = g68.a.c(r50);     // Catch: Throwable -> L165 Exception -> L278
        if (r247 == null) goto L157;
        String r1102 = r247.e;     // Catch: Throwable -> L165 Exception -> L278
    L158:
        N(r1102);     // Catch: Throwable -> L276 Exception -> L278
        M(r50);     // Catch: Throwable -> L276 Exception -> L278
        this.y.remove(r50);     // Catch: Throwable -> L161 Exception -> L163
        z(r50);     // Catch: Throwable -> L161 Exception -> L163
        Unit r248 = Unit.INSTANCE;     // Catch: Throwable -> L161 Exception -> L163
        r94 = false;
        r95 = true;
        r214 = r210;
        r215 = r244;
        r216 = r245;
        r315 = r321;
        r316 = r320;
        r317 = r323;
        r318 = r322;
        goto L225
    L163:
        e = e;
        r146 = r244;
        r147 = r245;
        r10 = r310;
        r148 = r321;
        r145 = r320;
        r149 = r323;
        r144 = r322;
        r137 = false;
        r95 = true;
        r219 = r210;
    L161:
        th = th;
        r190 = r244;
        r191 = r245;
        r10 = r310;
        r192 = r321;
        r189 = r320;
        r193 = r323;
        r188 = r322;
        r137 = false;
        r95 = true;
        r222 = r210;
    L165:
        th = th;
    L174:
        Object r249 = r244;
        Object r250 = r245;
        r10 = r310;
        Object r251 = r321;
        Object r252 = r320;
        Object r253 = r323;
        Object r254 = r322;
        ?? r255 = r210;
    L282:
        r84 = false;
        r235 = r254;
        r233 = r252;
        r230 = r249;
        r231 = r250;
        r232 = r251;
        r234 = r253;
        r236 = r255;
        goto L283
    L157:
        r1102 = null;
        goto L158
    L470:
        r246.o(false);     // Catch: Throwable -> L165 Exception -> L278
        Unit r256 = Unit.INSTANCE;     // Catch: Throwable -> L165 Exception -> L278
    L169:
        e = e;
    L177:
        Object r257 = r244;
        Object r258 = r245;
        r10 = r310;
        Object r259 = r321;
        Object r260 = r320;
        Object r261 = r323;
        Object r262 = r322;
        ?? r263 = r210;
    L287:
        r84 = false;
        r136 = r262;
        r134 = r260;
        r131 = r257;
        r132 = r258;
        r133 = r259;
        r135 = r261;
        r217 = r263;
    L167:
        th = th;
        goto L174
    L175:
        e = e;
        r244 = "conversation_id";
        r245 = "file_path";
        r310 = "FlowAsrClient.stopAsr";
        r210 = 0;
        r320 = r7;
        r322 = r6;
        r323 = r13;
        r321 = r12;
    L171:
        th = th;
        r244 = "conversation_id";
        r245 = "file_path";
        r310 = "FlowAsrClient.stopAsr";
        r210 = 0;
        r320 = r7;
        r322 = r6;
        r323 = r13;
        r321 = r12;
    L278:
        e = e;
    L276:
        th = th;
        goto L174
    L481:
        r82 = r81.A;     // Catch: Throwable -> L140 Exception -> L142
    L142:
        e = e;
        r140 = "conversation_id";
        r141 = "file_path";
        r218 = 0;
        r139 = r7;
        r138 = r6;
        r143 = r13;
        r142 = r12;
        r137 = false;
    L140:
        th = th;
        r239 = "conversation_id";
        r240 = "file_path";
        r243 = 0;
        r238 = r7;
        r237 = r6;
        r242 = r13;
        r241 = r12;
        r137 = false;
        goto L284
    L285:
        e = e;
        r257 = "conversation_id";
        r258 = "file_path";
        r263 = 0;
        r260 = r7;
        r262 = r6;
        r261 = r13;
        r259 = r12;
    L280:
        th = th;
        r249 = "conversation_id";
        r250 = "file_path";
        r255 = 0;
        r252 = r7;
        r254 = r6;
        r253 = r13;
        r251 = r12;
        goto L282
    L95:
        r114 = true;
        goto L96
    L82:
        if (r49.i != true) goto L84;
        r51 = true;
        goto L85
    L54:
        if (r50.length() == 0) goto L57;
        r24 = false;
        goto L58
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void u(com.larus.audio.asr.w r2) {
        Intrinsics.checkNotNullParameter(r2, "asrStateListener");
        this.h = r2;
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void v(e r5) {
        Intrinsics.checkNotNullParameter(r5, "task");
        String r0 = r5.getTaskId();
        ConcurrentHashMap<String, e> r1 = g68.a.a;
        Intrinsics.checkNotNullParameter(r0, "taskId");
        Intrinsics.checkNotNullParameter(r5, "asrTask");
        if (r0.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L28;
        ConcurrentHashMap<String, e> r3 = g68.a.a;
        if (r3.remove(r0, r5) == false) goto L28;
        int r4 = c68.b.a;
        c68.b.a("AsrManager", "#removeAsrTask => taskId:" + r0 + ", task size:" + r3.size());
    L28:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
        r5.f(null);     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L26;
        int r9 = c68.b.a;
        c68.b.c("FlowAsrClient", "Failed to clear managed ASR task callback: ".concat(r0), r8);
    L26:
        r5.release();     // Catch: Throwable -> L20
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L30;
        int r12 = c68.b.a;
        c68.b.c("FlowAsrClient", "Failed to release managed ASR task: ".concat(r0), r11);
        return;
    L30:
        return;
    L20:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r2 = false;
        goto L6
    }

    public final void z(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        this.z.remove(r2);
        this.A.remove(r2);
        h$a r3 = this.B.remove(r2);
        if (r3 == null) goto L14;
        r3.a();
        return;
    L14:
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void L(e r3, String r4) {
        c68.b.b("FlowAsrClient", r4);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        r3.release();     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L13;
        int r1 = c68.b.a;
        c68.b.c("FlowAsrClient", "Failed to release unmanaged ASR task: " + r3.getTaskId(), r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void I(b r20, String r21) {
        String r15 = r20.a;
        if (r15.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        boolean r1 = g68.a.f(r15);
        k r2 = c68.a.b("wait sami init timeout");
        String r3 = null;
        if (r2 == null) goto L42;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("task_id", r15);
        y58.a r5 = this.o.get(r15);
        if (r5 == null) goto L13;
        String r6 = r5.y;
    L14:
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r4.put("bot_id", r6);
        y58.a r7 = this.o.get(r15);
        if (r7 == null) goto L19;
        String r8 = r7.c;
    L20:
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        r4.put("conversation_id", r8);
        y58.a r9 = this.o.get(r15);
        if (r9 == null) goto L25;
        String r10 = r9.e;
    L26:
        if (r10 != null) goto L28;
        r10 = "";
    L28:
        r4.put("file_path", r10);
        r4.put("is_sami_init", String.valueOf(m58.h.p.getValue()));
        r4.put("has_asr_stream_result", String.valueOf(r1));
        r4.put("caller", r21);
        com.larus.audio.utils.b r11 = (com.larus.audio.utils.b) r2;
        r11.c(r4);
        r11.d("FlowAsrClient.handleSamiNotReadyWaitTimeout");
        y58.a r12 = this.o.get(r15);
        if (r12 == null) goto L34;
        y58.d r13 = r12.z;
        if (r13 == null) goto L34;
        String r14 = r13.a;
        if (r14 == null) goto L34;
    L35:
        r11.b(CollectionsKt.listOf(r14));
        y58.a r16 = this.o.get(r15);
        if (r16 == null) goto L40;
        y58.d r17 = r16.z;
        if (r17 == null) goto L40;
        String r19 = r17.b;
    L41:
        r11.e(r19);
        k.a.a(r11);
    L40:
        r19 = null;
    L34:
        r14 = "";
        goto L35
    L25:
        r10 = null;
        goto L26
    L19:
        r8 = null;
        goto L20
    L13:
        r6 = null;
    L42:
        if (r1 == true) goto L55;
        AsrCallBackType r22 = AsrCallBackType.ASR_FAILED;
        y58.a r23 = g68.a.c(r15);
        if (r23 == null) goto L46;
        r3 = r23.e;
    L46:
        if (r3 != null) goto L48;
        String r24 = "";
    L49:
        long r25 = r20.f;
        AsrEventEnum r110 = AsrEventEnum.ASR_SAMI_NOT_READY_ERROR;
        O(this, r15, r22, "", r24, r25, null, r110.getCode(), null, null, null, 928);
        h r26 = B().get(r15);
        if (r26 == null) goto L55;
        String r27 = r20.c;
        if (r27 != null) goto L54;
        r27 = "";
    L54:
        r26.r(2, r27, r110.getCode());
        goto L55
    L48:
        r24 = r3;
    L55:
        M(r15);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void R(final String r3, final String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        c68.b.b("FlowAsrClient", "saveAudioFileForObric => file path is null or empty");
        return;
    L11:
        ThreadMethodProxy.start(new PthreadThreadV2(new g78.h(this, r4, r3), "FlowAsrClientImpl"));
        return;
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final synchronized void b(final String r14, final y58.a r15) {
        monitor-enter(this);
        boolean r0 = true;
        if (r14 != null) goto L189;
    L9:
        boolean r2 = true;
    L10:
        String r3 = null;
        if (r2 == true) goto L144;
        if (r15 == null) goto L144;
        if (r15.e.length() != 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L144;
        if (r15.b.length() != 0) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L144;
        ConcurrentHashMap<String, e> r6 = g68.a.a;     // Catch: Throwable -> L51
        Intrinsics.checkNotNullParameter(r14, "taskId");     // Catch: Throwable -> L51
        if (r14.length() != 0) goto L27;
        boolean r7 = true;
    L28:
        if (r7 == false) goto L30;
        boolean r8 = false;
    L31:
        if (r8 == true) goto L55;
        k r9 = c68.a.d("handle resend asr init a new task");     // Catch: Throwable -> L51
        if (r9 == null) goto L53;
        LinkedHashMap r10 = new LinkedHashMap();     // Catch: Throwable -> L51
        r10.put("task_id", r14);     // Catch: Throwable -> L51
        String r11 = r15.y;     // Catch: Throwable -> L51
        if (r11 != null) goto L37;
        r11 = "";
    L37:
        r10.put("bot_id", r11);     // Catch: Throwable -> L51
        r10.put("conversation_id", r15.c);     // Catch: Throwable -> L51
        r10.put("file_path", r15.e);     // Catch: Throwable -> L51
        r10.put("asr_task_map_size", String.valueOf(g68.a.e()));     // Catch: Throwable -> L51
        r10.put("timeout_runnable_map_size", String.valueOf(this.k.size()));     // Catch: Throwable -> L51
        r10.put("asr_task_queue_size", String.valueOf(F().size()));     // Catch: Throwable -> L51
        com.larus.audio.utils.b r12 = (com.larus.audio.utils.b) r9;     // Catch: Throwable -> L51
        r12.c(r10);     // Catch: Throwable -> L51
        r12.d("FlowAsrClient.handleResend");     // Catch: Throwable -> L51
        y58.a r13 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r13 == null) goto L43;
        y58.d r16 = r13.z;     // Catch: Throwable -> L51
        if (r16 == null) goto L43;
        String r17 = r16.a;     // Catch: Throwable -> L51
        if (r17 == null) goto L43;
    L44:
        r12.b(CollectionsKt.listOf(r17));     // Catch: Throwable -> L51
        y58.a r19 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r19 == null) goto L49;
        y58.d r20 = r19.z;     // Catch: Throwable -> L51
        if (r20 == null) goto L49;
        String r21 = r20.b;     // Catch: Throwable -> L51
    L50:
        r12.e(r21);     // Catch: Throwable -> L51
        k.a.a(r12);     // Catch: Throwable -> L51
    L49:
        r21 = null;
    L43:
        r17 = "";
    L53:
        g68.a.b(r14, r15, B().get(r14));     // Catch: Throwable -> L51
        g68.a.a(r14, new a0(this));     // Catch: Throwable -> L51
        this.l.put(r14, 0);     // Catch: Throwable -> L51
    L55:
        if (new PolarisFileWrapper(r15.e).exists() == true) goto L92;
        k r1 = c68.a.b("handle resend asr but file not exists");     // Catch: Throwable -> L51
        if (r1 == null) goto L89;
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Throwable -> L51
        r22.put("task_id", r14);     // Catch: Throwable -> L51
        y58.a r23 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r23 == null) goto L61;
        String r24 = r23.y;     // Catch: Throwable -> L51
    L62:
        if (r24 != null) goto L64;
        r24 = "";
    L64:
        r22.put("bot_id", r24);     // Catch: Throwable -> L51
        y58.a r25 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r25 == null) goto L67;
        String r26 = r25.c;     // Catch: Throwable -> L51
    L68:
        if (r26 != null) goto L70;
        r26 = "";
    L70:
        r22.put("conversation_id", r26);     // Catch: Throwable -> L51
        y58.a r27 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r27 == null) goto L73;
        String r29 = r27.e;     // Catch: Throwable -> L51
    L74:
        if (r29 != null) goto L76;
        r29 = "";
    L76:
        r22.put("file_path", r29);     // Catch: Throwable -> L51
        r22.put("asr_task_map_size", String.valueOf(g68.a.e()));     // Catch: Throwable -> L51
        r22.put("timeout_runnable_map_size", String.valueOf(this.k.size()));     // Catch: Throwable -> L51
        r22.put("asr_task_queue_size", String.valueOf(F().size()));     // Catch: Throwable -> L51
        r22.put("retry_time", String.valueOf(E(r14)));     // Catch: Throwable -> L51
        com.larus.audio.utils.b r30 = (com.larus.audio.utils.b) r1;     // Catch: Throwable -> L51
        r30.c(r22);     // Catch: Throwable -> L51
        r30.d("FlowAsrClient.handleResend");     // Catch: Throwable -> L51
        y58.a r31 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r31 == null) goto L82;
        y58.d r32 = r31.z;     // Catch: Throwable -> L51
        if (r32 == null) goto L82;
        String r33 = r32.a;     // Catch: Throwable -> L51
        if (r33 == null) goto L82;
    L83:
        r30.b(CollectionsKt.listOf(r33));     // Catch: Throwable -> L51
        y58.a r34 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r34 == null) goto L88;
        y58.d r35 = r34.z;     // Catch: Throwable -> L51
        if (r35 == null) goto L88;
        r3 = r35.b;     // Catch: Throwable -> L51
    L88:
        r30.e(r3);     // Catch: Throwable -> L51
        k.a.a(r30);     // Catch: Throwable -> L51
    L82:
        r33 = "";
        goto L83
    L73:
        r29 = null;
        goto L74
    L67:
        r26 = null;
        goto L68
    L61:
        r24 = null;
    L89:
        O(this, r14, AsrCallBackType.ASR_FAILED, "", r15.e, 0, null, AsrEventEnum.ASR_RESEND_FILE_NOT_EXIST.getCode(), null, null, null, 944);     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L92:
        k r36 = c68.a.c("try handle resend asr");     // Catch: Throwable -> L51
        if (r36 == null) goto L126;
        LinkedHashMap r37 = new LinkedHashMap();     // Catch: Throwable -> L51
        r37.put("task_id", r14);     // Catch: Throwable -> L51
        y58.a r38 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r38 == null) goto L97;
        String r39 = r38.y;     // Catch: Throwable -> L51
    L98:
        if (r39 != null) goto L100;
        r39 = "";
    L100:
        r37.put("bot_id", r39);     // Catch: Throwable -> L51
        y58.a r40 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r40 == null) goto L103;
        String r41 = r40.c;     // Catch: Throwable -> L51
    L104:
        if (r41 != null) goto L106;
        r41 = "";
    L106:
        r37.put("conversation_id", r41);     // Catch: Throwable -> L51
        y58.a r42 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r42 == null) goto L109;
        String r43 = r42.e;     // Catch: Throwable -> L51
    L110:
        if (r43 != null) goto L112;
        r43 = "";
    L112:
        r37.put("file_path", r43);     // Catch: Throwable -> L51
        r37.put("asr_task_map_size", String.valueOf(g68.a.e()));     // Catch: Throwable -> L51
        r37.put("timeout_runnable_map_size", String.valueOf(this.k.size()));     // Catch: Throwable -> L51
        r37.put("asr_task_queue_size", String.valueOf(F().size()));     // Catch: Throwable -> L51
        r37.put("retry_time", String.valueOf(E(r14)));     // Catch: Throwable -> L51
        com.larus.audio.utils.b r44 = (com.larus.audio.utils.b) r36;     // Catch: Throwable -> L51
        r44.c(r37);     // Catch: Throwable -> L51
        r44.d("FlowAsrClient.handleResend");     // Catch: Throwable -> L51
        y58.a r45 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r45 == null) goto L118;
        y58.d r46 = r45.z;     // Catch: Throwable -> L51
        if (r46 == null) goto L118;
        String r47 = r46.a;     // Catch: Throwable -> L51
        if (r47 == null) goto L118;
    L119:
        r44.b(CollectionsKt.listOf(r47));     // Catch: Throwable -> L51
        y58.a r48 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r48 == null) goto L124;
        y58.d r49 = r48.z;     // Catch: Throwable -> L51
        if (r49 == null) goto L124;
        String r50 = r49.b;     // Catch: Throwable -> L51
    L125:
        r44.e(r50);     // Catch: Throwable -> L51
        k.a.a(r44);     // Catch: Throwable -> L51
    L124:
        r50 = null;
    L118:
        r47 = "";
        goto L119
    L109:
        r43 = null;
        goto L110
    L103:
        r41 = null;
        goto L104
    L97:
        r39 = null;
    L126:
        y58.a r51 = g68.a.c(r14);     // Catch: Throwable -> L51
        if (r51 == null) goto L129;
        r51.l = 2;     // Catch: Throwable -> L51
    L129:
        if (r51 == null) goto L131;
        r3 = r51.C;     // Catch: Throwable -> L51
    L131:
        if (r3 != null) goto L141;
        m58.t r52 = m58.h.m;     // Catch: Throwable -> L51
        if (r52 != null) goto L135;
    L137:
        r0 = false;
    L138:
        if (r0 == false) goto L141;
        if (r51 == null) goto L141;
        r51.C = m58.h.a;     // Catch: Throwable -> L51
        goto L141
    L135:
        if (r52.enableOptAsrSamiNotReady() != true) goto L137;
    L141:
        this.u.submit(new q(r14, this, r15));     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L30:
        r8 = g68.a.a.containsKey(r14);     // Catch: Throwable -> L51
        goto L31
    L27:
        r7 = false;
        goto L28
    L21:
        r5 = false;
        goto L22
    L16:
        r4 = false;
    L144:
        k r53 = c68.a.b("handle resend asr with invalid params");     // Catch: Throwable -> L51
        if (r53 == null) goto L185;
        LinkedHashMap r54 = new LinkedHashMap();     // Catch: Throwable -> L51
        if (r14 != null) goto L149;
        String r55 = "";
    L150:
        r54.put("task_id", r55);     // Catch: Throwable -> L51
        if (r15 == null) goto L153;
        String r56 = r15.y;     // Catch: Throwable -> L51
    L154:
        if (r56 != null) goto L156;
        r56 = "";
    L156:
        r54.put("bot_id", r56);     // Catch: Throwable -> L51
        if (r15 != null) goto L159;
        String r57 = "true";
    L160:
        r54.put("asr_data_nullable", r57);     // Catch: Throwable -> L51
        if (r15 == null) goto L163;
        String r59 = r15.c;     // Catch: Throwable -> L51
    L164:
        if (r59 != null) goto L166;
        r59 = "";
    L166:
        r54.put("conversation_id", r59);     // Catch: Throwable -> L51
        if (r15 == null) goto L169;
        String r110 = r15.e;     // Catch: Throwable -> L51
    L170:
        if (r110 != null) goto L172;
        r110 = "";
    L172:
        r54.put("file_path", r110);     // Catch: Throwable -> L51
        r54.put("asr_task_map_size", String.valueOf(g68.a.e()));     // Catch: Throwable -> L51
        r54.put("timeout_runnable_map_size", String.valueOf(this.k.size()));     // Catch: Throwable -> L51
        r54.put("asr_task_queue_size", String.valueOf(F().size()));     // Catch: Throwable -> L51
        com.larus.audio.utils.b r60 = (com.larus.audio.utils.b) r53;     // Catch: Throwable -> L51
        r60.c(r54);     // Catch: Throwable -> L51
        r60.d("FlowAsrClient.handleResend");     // Catch: Throwable -> L51
        y58.a r111 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r111 == null) goto L178;
        y58.d r112 = r111.z;     // Catch: Throwable -> L51
        if (r112 == null) goto L178;
        String r113 = r112.a;     // Catch: Throwable -> L51
        if (r113 == null) goto L178;
    L179:
        r60.b(CollectionsKt.listOf(r113));     // Catch: Throwable -> L51
        y58.a r114 = this.o.get(r14);     // Catch: Throwable -> L51
        if (r114 == null) goto L184;
        y58.d r115 = r114.z;     // Catch: Throwable -> L51
        if (r115 == null) goto L184;
        r3 = r115.b;     // Catch: Throwable -> L51
    L184:
        r60.e(r3);     // Catch: Throwable -> L51
        k.a.a(r60);     // Catch: Throwable -> L51
    L178:
        r113 = "";
        goto L179
    L169:
        r110 = null;
        goto L170
    L163:
        r59 = null;
        goto L164
    L159:
        r57 = "false";
        goto L160
    L153:
        r56 = null;
        goto L154
    L149:
        r55 = r14;
    L185:
        monitor-exit(this);
        return;
    L189:
    L51:
        th = move-exception;
        throw th;
    L6:
        if (r14.length() == 0) goto L9;
        r2 = false;
        goto L10
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final e c(String r3, y58.a r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "asrConfig");
        Iterator<f> r0 = this.C.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.larus.audio.audiov3.task.sami.v2.x r1 = r0.next().a(r3, r4);
        if (r1 == null) goto L4;
    L9:
        if (r1 == null) goto L11;
        return r1;
    L11:
        return this.D.a(r3, r4);
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final e e(String r6, y58.a r7) {
        Intrinsics.checkNotNullParameter(r6, "taskId");
        Intrinsics.checkNotNullParameter(r7, "asrConfig");
        if (StringsKt.isBlank(r6) == false) goto L6;
        c68.b.b("FlowAsrClient", "createManagedAsrTask failed: taskId is empty");
        return null;
    L6:
        e r8 = c(r6, r7);
        com.larus.audio.audiov3.task.sami.v2.x r1 = (com.larus.audio.audiov3.task.sami.v2.x) r8;
        if (Intrinsics.areEqual(r1.a, r6) == true) goto L10;
        L(r8, "ASR task id does not match: expected=" + r6 + ", actual=" + r1.a);
        return null;
    L10:
        ConcurrentHashMap<String, e> r4 = g68.a.a;
        Intrinsics.checkNotNullParameter(r6, "taskId");
        Intrinsics.checkNotNullParameter(r8, "asrTask");
        if (StringsKt.isBlank(r6) == false) goto L13;
    L19:
        Object r0 = g68.c.a;
    L21:
        if (Intrinsics.areEqual(r0, g68.d.a) == false) goto L24;
        return r8;
    L24:
        if (Intrinsics.areEqual(r0, g68.c.a) == false) goto L27;
        L(r8, "Invalid ASR task: ".concat(r6));
        return null;
    L27:
        if ((r0 instanceof g68.b) == false) goto L34;
        if (((g68.b) r0).a == r8) goto L31;
        L(r8, "An ASR task already exists: ".concat(r6));
        return null;
    L31:
        int r9 = c68.b.a;
        c68.b.b("FlowAsrClient", "ASR factory returned an already registered task: ".concat(r6));
        return null;
    L34:
        throw new NoWhenBranchMatchedException();
    L13:
        if (Intrinsics.areEqual(r1.a, r6) == false) goto L19;
        ConcurrentHashMap<String, e> r2 = g68.a.a;
        e r3 = r2.putIfAbsent(r6, r8);
        if (r3 != null) goto L18;
        int r5 = c68.b.a;
        c68.b.a("AsrManager", "registerTaskIfAbsent taskId: " + r6 + ", task size: " + r2.size());
        r0 = g68.d.a;
        goto L21
    L18:
        r0 = new g68.b(r3);
        goto L21
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void i(String r2, h r3) {
        Intrinsics.checkNotNullParameter(r3, "tracer");
        if (B().contains(r2) == false) goto L5;
        return;
    L5:
        B().put(r2, r3);
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final r0 k(String r2, y58.a r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "asrConfig");
        return new r0(r2, r3);
    }

    public final void y(String r7, String r8) {
        k r0 = c68.a.c("cancelTimeoutTask");
        if (r0 == null) goto L37;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("task_id", r7);
        y58.a r2 = this.o.get(r7);
        String r3 = null;
        if (r2 == null) goto L7;
        String r4 = r2.y;
    L8:
        String r5 = "";
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r1.put("bot_id", r4);
        y58.a r6 = this.o.get(r7);
        if (r6 == null) goto L14;
        String r9 = r6.c;
    L15:
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        r1.put("conversation_id", r9);
        y58.a r10 = this.o.get(r7);
        if (r10 == null) goto L20;
        String r11 = r10.e;
    L21:
        if (r11 != null) goto L23;
        r11 = "";
    L23:
        r1.put("file_path", r11);
        r1.put("retry_time", String.valueOf(E(r7)));
        r1.put("has_timeout_task", String.valueOf(this.k.contains(r7)));
        r1.put("caller", r8);
        com.larus.audio.utils.b r12 = (com.larus.audio.utils.b) r0;
        r12.c(r1);
        r12.d("FlowAsrClient.cancelTimeoutTask");
        y58.a r13 = this.o.get(r7);
        if (r13 == null) goto L31;
        y58.d r14 = r13.z;
        if (r14 == null) goto L31;
        String r15 = r14.a;
        if (r15 == null) goto L31;
        r5 = r15;
    L31:
        r12.b(CollectionsKt.listOf(r5));
        y58.a r16 = this.o.get(r7);
        if (r16 == null) goto L36;
        y58.d r17 = r16.z;
        if (r17 == null) goto L36;
        r3 = r17.b;
    L36:
        r12.e(r3);
        k.a.a(r12);
        goto L37
    L20:
        r11 = null;
        goto L21
    L14:
        r9 = null;
        goto L15
    L7:
        r4 = null;
    L37:
        Runnable r19 = this.k.get(r7);
        if (r19 == null) goto L41;
        g1.a.removeCallbacks(r19);
        return;
    }

    public final void Q(final String r3, final String r4, final y r5) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L13;
        c68.b.b("FlowAsrClient", "saveAudioFile => file path is null or empty");
        if (r5 == null) goto L15;
        r5.invoke();
        return;
    L15:
        return;
    L13:
        ThreadMethodProxy.start(new PthreadThreadV2(new g78.l(this, r4, r3, r5), "FlowAsrClientImpl"));
        return;
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void G(b r29, Integer r210, String r30, String r31) {
        String r12 = r30;
        if (r29 == null) goto L5;
        String r2 = r29.a;
    L6:
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        return;
    L14:
        boolean r4 = ((ArrayList) g68.a.d()).contains(r29.a);
        String r17 = "";
        if (this.e != AsrClientStatus.STATE_TOUCH) goto L64;
        if (r4 == false) goto L64;
        m58.t r5 = m58.h.m;
        if (r5 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L64;
        k r7 = c68.a.c("AsrTask failed but current record status is recording, pending handle fail later");
        if (r7 == null) goto L62;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("task_id", r29.a);
        y58.a r9 = this.o.get(r29.a);
        if (r9 == null) goto L29;
        String r10 = r9.y;
    L30:
        if (r10 != null) goto L32;
        r10 = "";
    L32:
        r8.put("bot_id", r10);
        y58.a r11 = this.o.get(r29.a);
        if (r11 == null) goto L35;
        String r13 = r11.c;
    L36:
        if (r13 != null) goto L38;
        r13 = "";
    L38:
        r8.put("conversation_id", r13);
        y58.a r14 = this.o.get(r29.a);
        if (r14 == null) goto L41;
        String r15 = r14.e;
    L42:
        if (r15 != null) goto L44;
        r15 = "";
    L44:
        r8.put("file_path", r15);
        r8.put("retry_time", String.valueOf(E(r29.a)));
        r8.put("err_code", String.valueOf(r210));
        if (r12 != null) goto L47;
        r12 = "";
    L47:
        r8.put("error_message", r12);
        r8.put("running_task_ids", CollectionsKt.joinToString$default(g68.a.d(), null, null, null, 0, null, null, 63, null));
        r8.put("caller", r31);
        com.larus.audio.utils.b r16 = (com.larus.audio.utils.b) r7;
        r16.c(r8);
        r16.d("FlowAsrClient.handleAsrFail");
        y58.a r0 = this.o.get(r29.a);
        if (r0 == null) goto L55;
        y58.d r1 = r0.z;
        if (r1 == null) goto L55;
        String r19 = r1.a;
        if (r19 == null) goto L55;
        r17 = r19;
    L55:
        r16.b(CollectionsKt.listOf(r17));
        y58.a r20 = this.o.get(r29.a);
        if (r20 == null) goto L60;
        y58.d r21 = r20.z;
        if (r21 == null) goto L60;
        String r22 = r21.b;
    L61:
        r16.e(r22);
        k.a.a(r16);
    L60:
        r22 = null;
        goto L61
    L41:
        r15 = null;
        goto L42
    L35:
        r13 = null;
        goto L36
    L29:
        r10 = null;
    L62:
        this.y.put(r29.a, r29);
        return;
    L20:
        if (r5.enableOptAsrRetry() != true) goto L22;
        r6 = true;
    L64:
        String r23 = r29.a;
        if (r23 != null) goto L67;
        r23 = "";
    L67:
        y(r23, "handleAsrFail");
        boolean r24 = g68.a.f(r29.a);
        k r25 = c68.a.c("handleAsrFail");
        if (r25 == null) goto L105;
        LinkedHashMap r26 = new LinkedHashMap();
        r26.put("task_id", r29.a);
        y58.a r27 = this.o.get(r29.a);
        if (r27 == null) goto L72;
        String r32 = r27.y;
    L73:
        if (r32 != null) goto L75;
        r32 = "";
    L75:
        r26.put("bot_id", r32);
        y58.a r33 = this.o.get(r29.a);
        if (r33 == null) goto L78;
        String r34 = r33.c;
    L79:
        if (r34 != null) goto L81;
        r34 = "";
    L81:
        r26.put("conversation_id", r34);
        y58.a r35 = this.o.get(r29.a);
        if (r35 == null) goto L84;
        String r36 = r35.e;
    L85:
        if (r36 != null) goto L87;
        r36 = "";
    L87:
        r26.put("file_path", r36);
        r26.put("retry_time", String.valueOf(E(r29.a)));
        r26.put("err_code", String.valueOf(r210));
        if (r12 != null) goto L90;
        String r37 = "";
    L91:
        r26.put("error_message", r37);
        boolean r38 = false;
        r26.put("max_time_out_duration", String.valueOf(this.p.b[0]));
        r26.put("has_asr_stream_result", String.valueOf(r24));
        r26.put("caller", r31);
        com.larus.audio.utils.b r39 = (com.larus.audio.utils.b) r25;
        r39.c(r26);
        r39.d("FlowAsrClient.handleAsrFail");
        y58.a r40 = this.o.get(r29.a);
        if (r40 == null) goto L97;
        y58.d r41 = r40.z;
        if (r41 == null) goto L97;
        String r42 = r41.a;
        if (r42 == null) goto L97;
    L98:
        r39.b(CollectionsKt.listOf(r42));
        y58.a r43 = this.o.get(r29.a);
        if (r43 == null) goto L103;
        y58.d r44 = r43.z;
        if (r44 == null) goto L103;
        String r45 = r44.b;
    L104:
        r39.e(r45);
        k.a.a(r39);
    L107:
        if (E(r29.a) < this.p.a) goto L109;
    L148:
        boolean r46 = false;
    L150:
        if (r46 == false) goto L167;
        int r47 = c68.b.a;
        c68.b.d("FlowAsrClient", "handleAsrFail retry taskId : " + r29.a + ", retryTime:" + E(r29.a) + ", maxRetryTime:" + this.p.a);
        ConcurrentHashMap<String, e> r48 = g68.a.a;
        y58.a r49 = g68.a.c(r29.a);
        if (r49 == null) goto L154;
        r49.j = Long.valueOf(r29.f);
    L154:
        String r50 = r29.a;
        b(r50, g68.a.c(r50));
        String r51 = r29.a;
        if (r51 != null) goto L157;
    L158:
        r38 = true;
    L159:
        if (r38 == true) goto L219;
        c68.b.a("FlowAsrClient", "addRetryTime " + (E(r51) + 1));
        Integer r52 = this.l.get(r51);
        if (r52 == null) goto L164;
        this.l.put(r51, Integer.valueOf(r52.intValue() + 1));
    L164:
        k78.a r53 = this.m.get(r51);
        if (r53 == null) goto L217;
        r53.e++;
        return;
    L217:
        return;
    L219:
        return;
    L157:
        if (r51.length() != 0) goto L159;
    L167:
        int r54 = c68.b.a;
        StringBuilder r55 = new StringBuilder("handleAsrFail no need retry taskId :");
        String r56 = r29.a;
        if (r56 != null) goto L170;
        r56 = "";
    L170:
        r55.append(r56);
        r55.append(", retryTime:");
        r55.append(E(r29.a));
        r55.append(", maxRetryTime:");
        r55.append(this.p.a);
        r55.append(" ,errCode:");
        r55.append(r210);
        r55.append(", errorMessage:");
        r55.append(r12);
        r55.append(' ');
        c68.b.a("FlowAsrClient", r55.toString());
        if (r24 == true) goto L206;
        String r57 = r29.a;
        if (r57 != null) goto L175;
        String r59 = "";
    L176:
        AsrCallBackType r60 = AsrCallBackType.ASR_FAILED;
        y58.a r61 = g68.a.c(r57);
        if (r61 == null) goto L179;
        String r110 = r61.e;
    L180:
        if (r110 != null) goto L182;
        String r62 = "";
    L183:
        O(this, r59, r60, "", r62, r29.f, null, 0, null, null, null, 992);
        ConcurrentHashMap<String, k78.a> r63 = this.m;
        String r64 = r29.a;
        if (r64 != null) goto L186;
        r64 = "";
    L186:
        k78.a r65 = r63.get(r64);
        int r66 = -1;
        if (r65 == null) goto L195;
        if (r210 == null) goto L190;
        int r67 = r210.intValue();
    L191:
        if (r30 != null) goto L193;
        String r111 = "";
    L194:
        r65.a(r67, r111);
        goto L195
    L193:
        r111 = r30;
        goto L194
    L190:
        r67 = -1;
    L195:
        ConcurrentHashMap<String, h> r68 = B();
        String r69 = r29.a;
        if (r69 != null) goto L198;
        r69 = "";
    L198:
        h r70 = r68.get(r69);
        if (r70 == null) goto L206;
        if (r30 != null) goto L202;
        String r71 = "";
    L203:
        if (r210 == null) goto L205;
        r66 = r210.intValue();
    L205:
        r70.r(2, r71, r66);
        goto L206
    L202:
        r71 = r30;
        goto L203
    L182:
        r62 = r110;
        goto L183
    L179:
        r110 = null;
        goto L180
    L175:
        r59 = r57;
    L206:
        String r72 = r29.a;
        if (r72 != null) goto L209;
        r72 = "";
    L209:
        M(r72);
        return;
    L109:
        if (g68.a.f(r29.a) == true) goto L148;
        List<h78.b> r73 = h78.a.a;
        String r74 = String.valueOf(r29.b);
        if (r74.length() != 0) goto L113;
        boolean r75 = true;
    L114:
        if (r75 == true) goto L145;
        List<h78.b> r76 = h78.a.b;
        if ((r76 instanceof Collection) == true) goto L119;
    L121:
        Iterator r77 = ((ArrayList) r76).iterator();
    L123:
        if (r77.hasNext() == false) goto L127;
        if (((h78.b) r77.next()).a(r74) == false) goto L123;
        boolean r79 = true;
    L129:
        if (r79 == false) goto L131;
        int r80 = c68.b.a;
        c68.b.d("AsrClientRetryStrategyManager", "[shouldRetry] errorCode:" + r74 + ", follow allow rules");
        goto L145
    L131:
        List<h78.b> r81 = h78.a.a;
        if ((r81 instanceof Collection) == true) goto L134;
    L136:
        Iterator r82 = ((ArrayList) r81).iterator();
    L138:
        if (r82.hasNext() == false) goto L142;
        if (((h78.b) r82.next()).a(r74) == false) goto L138;
        boolean r83 = true;
    L143:
        if (r83 == false) goto L145;
        int r84 = c68.b.a;
        c68.b.d("AsrClientRetryStrategyManager", "[shouldRetry] errorCode:" + r74 + ", follow block rules");
        boolean r85 = false;
    L146:
        if (r85 == false) goto L148;
        r46 = true;
    L142:
        r83 = false;
        goto L143
    L134:
        if (((ArrayList) r81).isEmpty() == false) goto L136;
    L127:
        r79 = false;
        goto L129
    L119:
        if (((ArrayList) r76).isEmpty() == false) goto L121;
    L145:
        r85 = true;
        goto L146
    L113:
        r75 = false;
    L103:
        r45 = null;
    L97:
        r42 = "";
        goto L98
    L90:
        r37 = r12;
        goto L91
    L84:
        r36 = null;
        goto L85
    L78:
        r34 = null;
        goto L79
    L72:
        r32 = null;
        goto L73
    L105:
        r38 = false;
        goto L107
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final Integer P(String r10, Integer r11, byte[] r12, int r13) {
        int r0 = 0;
        if (r11 == null) goto L8;
        if (r11.intValue() != 0) goto L8;
    L80:
        return 0;
    L8:
        if (r10.length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L80;
        k r3 = c68.a.c("retryProcess write audio failed");
        if (r3 == null) goto L49;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("task_id", r10);
        y58.a r5 = this.o.get(r10);
        String r6 = null;
        if (r5 == null) goto L18;
        String r7 = r5.y;
    L19:
        String r8 = "";
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        r4.put("bot_id", r7);
        y58.a r9 = this.o.get(r10);
        if (r9 == null) goto L25;
        String r14 = r9.c;
    L26:
        if (r14 != null) goto L28;
        r14 = "";
    L28:
        r4.put("conversation_id", r14);
        y58.a r15 = this.o.get(r10);
        if (r15 == null) goto L31;
        String r16 = r15.e;
    L32:
        if (r16 != null) goto L34;
        r16 = "";
    L34:
        r4.put("file_path", r16);
        r4.put("result", String.valueOf(r11));
        com.larus.audio.utils.b r17 = (com.larus.audio.utils.b) r3;
        r17.c(r4);
        r17.d("FlowAsrClient.retryProcess");
        y58.a r19 = this.o.get(r10);
        if (r19 == null) goto L42;
        y58.d r20 = r19.z;
        if (r20 == null) goto L42;
        String r21 = r20.a;
        if (r21 == null) goto L42;
        r8 = r21;
    L42:
        r17.b(CollectionsKt.listOf(r8));
        y58.a r22 = this.o.get(r10);
        if (r22 == null) goto L47;
        y58.d r23 = r22.z;
        if (r23 == null) goto L47;
        r6 = r23.b;
    L47:
        r17.e(r6);
        k.a.a(r17);
        goto L49
    L31:
        r16 = null;
        goto L32
    L25:
        r14 = null;
        goto L26
    L18:
        r7 = null;
    L49:
        if (r11 != null) goto L52;
    L63:
        Integer r24 = r11;
    L64:
        if (r24 != null) goto L67;
    L68:
        k78.a r25 = this.m.get(r10);
        if (r25 == null) goto L74;
        String r26 = AsrStep.ASR_DATA_TRANSMISSION.getTraceName();
        if (r11 == null) goto L73;
        r0 = r11.intValue();
    L73:
        r25.d(r26, r0, "asr sami process error");
    L74:
        m58.u r1 = m58.h.l;
        if (r1 == null) goto L77;
        u$a.b(r1, r10, "asr_start_record_to_transfer_fail", 1, "retry_fail", null, 16);
    L77:
        int r27 = c68.b.a;
        c68.b.b("FlowAsrClient", "retryProcess => send audio to asr failed, ret " + r11);
    L78:
        return r24;
    L67:
        if (r24.intValue() == 0) goto L78;
    L52:
        if (r11.intValue() != 100013) goto L63;
        c68.b.a("FlowAsrClient", "retryProcess => sami not enough buffer error");
        Integer r29 = r11;
        int r30 = 0;
    L55:
        if (r30 >= 3) goto L62;
        Thread.sleep(100);
        r29 = Integer.valueOf(g68.a.k(r10, r12, r13));
        if (r29.intValue() == 0) goto L58;
        r30 = r30 + 1;
        goto L55
    L58:
        h r31 = B().get(r10);
        if (r31 == null) goto L62;
        r31.p(r30 + 1);
    L62:
        int r32 = c68.b.a;
        c68.b.a("FlowAsrClient", "retryProcess => sami buffer enough, retry ret: " + r11);
        r24 = r29;
        goto L64
    L10:
        r2 = false;
        goto L11
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void a(final String r17, final y58.a r19, Function2 r110, Function2 r20, i r21) {
        Intrinsics.checkNotNullParameter(r17, "taskId");
        Intrinsics.checkNotNullParameter(r19, "asrData");
        if (r17.length() != 0) goto L5;
        boolean r5 = true;
    L6:
        String r9 = "";
        if (r5 == false) goto L9;
    L94:
        k r3 = c68.a.b("startAsr with invalid params");
        if (r3 == null) goto L103;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("task_id", r17);
        r4.put("file_path", r19.e);
        String r1 = r19.y;
        if (r1 == null) goto L100;
        r9 = r1;
    L100:
        r4.put("bot_id", r9);
        r4.put("conversation_id", r19.c);
        com.larus.audio.utils.b r6 = (com.larus.audio.utils.b) r3;
        r6.c(r4);
        r6.d("FlowAsrClient.startAsr");
        r6.b(CollectionsKt.listOf(r19.z.a));
        r6.e(r19.z.b);
        k.a.a(r6);
        return;
    L103:
        return;
    L9:
        if (r19.e.length() != 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L94;
        if (r110 != null) goto L16;
        final Function2 r8 = new g78.d(r17, r19);
    L17:
        z(r17);
        m58.t r14 = m58.h.m;
        if (r14 != null) goto L20;
    L22:
        boolean r15 = false;
    L23:
        if (r15 == false) goto L40;
        MutableLiveData r16 = m58.h.p;
        Object r111 = r16.getValue();
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r111, r10) == false) goto L30;
        x58.a r112 = m58.h.a;
        if (r112 == null) goto L30;
        r19.C = r112;
        this.z.remove(r17);
    L30:
        this.z.put(r17, r10);
        k r11 = c68.a.d("start ASR while sami config is not ready");
        if (r11 == null) goto L40;
        LinkedHashMap r113 = new LinkedHashMap();
        r113.put("task_id", r17);
        String r12 = r19.y;
        if (r12 != null) goto L35;
        r12 = "";
    L35:
        r113.put("bot_id", r12);
        r113.put("conversation_id", r19.c);
        r113.put("file_path", r19.e);
        r113.put("is_sami_init", String.valueOf(r16.getValue()));
        if (m58.h.a != null) goto L38;
        boolean r13 = true;
    L39:
        r113.put("audio_common_config_null", String.valueOf(r13));
        com.larus.audio.utils.b r22 = (com.larus.audio.utils.b) r11;
        r22.c(r113);
        r22.d("FlowAsrClient.prepareSamiConfigBeforeStart");
        r22.b(CollectionsKt.listOf(r19.z.a));
        r22.e(r19.z.b);
        k.a.a(r22);
        goto L40
    L38:
        r13 = false;
    L40:
        k78.a r23 = this.m.get(r17);
        if (r23 == null) goto L43;
        r23.b(null);
    L43:
        this.f = r21;
        if (r20 == null) goto L55;
        e r24 = (e) r20.invoke(r17, r19);
        r24.g(B().get(r17));
        ConcurrentHashMap<String, e> r25 = g68.a.a;
        Intrinsics.checkNotNullParameter(r17, "taskId");
        Intrinsics.checkNotNullParameter(r24, "asrTask");
        if (r17.length() != 0) goto L48;
        boolean r26 = true;
    L49:
        if (r26 == true) goto L56;
        ConcurrentHashMap<String, e> r27 = g68.a.a;
        if (r27.containsKey(r17) == true) goto L56;
        int r29 = c68.b.a;
        c68.b.a("AsrManager", "registerTask taskId: " + r17 + ", task size: " + r27.size());
        r27.put(r17, r24);
    L56:
        g68.a.a(r17, new a0(this));
        this.l.put(r17, 0);
        k r30 = c68.a.c("start ASR");
        if (r30 == null) goto L73;
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put("task_id", r17);
        r31.put("asr_task_map_size", String.valueOf(g68.a.e()));
        r31.put("asr_reporter_map_size", String.valueOf(this.m.size()));
        r31.put("timeout_runnable_map_size", String.valueOf(this.k.size()));
        r31.put("asr_task_queue_size", String.valueOf(F().size()));
        r31.put("file_path", r19.e);
        r31.put("audio_recorder_status", this.e.name());
        c r32 = this.x;
        if (r32 == null) goto L63;
        AsrDataSourceState r33 = r32.a();
        if (r33 == null) goto L63;
        String r34 = r33.name();
    L64:
        if (r34 != null) goto L66;
        r34 = "";
    L66:
        r31.put("audio_record_record_state", r34);
        if (Build.VERSION.SDK_INT < 29) goto L69;
        r31.put("has_release_audio_record_async", String.valueOf(((Handler) this.v.getValue()).hasCallbacks((Runnable) this.w.getValue())));
    L69:
        String r35 = r19.y;
        if (r35 != null) goto L72;
        r35 = "";
    L72:
        r31.put("bot_id", r35);
        r31.put("conversation_id", r19.c);
        r31.put("is_sami_inited", String.valueOf(m58.h.p.getValue()));
        com.larus.audio.utils.b r36 = (com.larus.audio.utils.b) r30;
        r36.c(r31);
        r36.d("FlowAsrClient.startAsr");
        r36.b(CollectionsKt.listOf(r19.z.a));
        r36.e(r19.z.b);
        k.a.a(r36);
    L63:
        r34 = null;
    L73:
        AsrClientStatus r37 = this.e;
        AsrClientStatus r38 = AsrClientStatus.STATE_TOUCH;
        if (r37 == r38) goto L79;
        c r39 = this.x;
        if (r39 == null) goto L79;
        if (r39.a() == AsrDataSourceState.STARTED) goto L79;
    L80:
        this.e = r38;
        ((Handler) this.v.getValue()).removeCallbacks((Runnable) this.w.getValue());
        this.o.put(r17, r19);
        m58.u r40 = m58.h.l;
        if (r40 == null) goto L83;
        r40.f(r17, "asr_touch_down_to_start_record", null);
    L83:
        m58.u r41 = m58.h.l;
        if (r41 == null) goto L86;
        r41.f(r17, "asr_touch_down_to_finish_session", null);
    L86:
        this.b.submit(new g78.e(this, r19, r17, r8));
        k r42 = c68.a.c("startAsr after submit task");
        if (r42 == null) goto L102;
        LinkedHashMap r43 = new LinkedHashMap();
        r43.put("task_id", r17);
        String r2 = r19.y;
        if (r2 == null) goto L92;
        r9 = r2;
    L92:
        r43.put("bot_id", r9);
        r43.put("conversation_id", r19.c);
        r43.put("file_path", r19.e);
        com.larus.audio.utils.b r44 = (com.larus.audio.utils.b) r42;
        r44.c(r43);
        r44.d("FlowAsrClient.startAsr");
        r44.b(CollectionsKt.listOf(r19.z.a));
        r44.e(r19.z.b);
        k.a.a(r44);
        return;
    L102:
        return;
    L79:
        J();
        goto L80
    L48:
        r26 = false;
        goto L49
    L55:
        ConcurrentHashMap<String, e> r45 = g68.a.a;
        g68.a.b(r17, r19, B().get(r17));
        goto L56
    L20:
        if (r14.enableOptAsrSamiNotReady() != true) goto L22;
        r15 = true;
        goto L23
    L16:
        r8 = r110;
        goto L17
    L11:
        r7 = false;
        goto L12
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final r l(String r6, qw5.a r7, s2 r8, t2 r9, u2 r10) {
        Intrinsics.checkNotNullParameter(r6, "taskId");
        Intrinsics.checkNotNullParameter(r7, "config");
        m58.i r0 = m58.h.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L17:
        String r2 = "";
        String r3 = null;
        if (r1 == false) goto L32;
        m58.i r4 = m58.h.e;
        if (r4 == null) goto L22;
        String r5 = r4.c();
    L23:
        if (r5 != null) goto L25;
        r5 = "";
    L25:
        m58.i r11 = m58.h.e;
        if (r11 == null) goto L28;
        String r12 = r11.b();
    L29:
        if (r12 != null) goto L31;
        r12 = "";
    L31:
        c r13 = new n58.c(r12, r5);
    L33:
        gw5.i r14 = r7.j;
        if (r14 == null) goto L38;
        g r15 = r14.f;
        if (r15 == null) goto L38;
        r3 = r15.a;
    L38:
        if (r3 == null) goto L42;
        r2 = r3;
    L42:
        return new r(r6, new t0(r6, r13, r2, r10), r8, r9);
    L28:
        r12 = null;
        goto L29
    L22:
        r5 = null;
        goto L23
    L32:
        r13 = new r0(r6, null);
        goto L33
    L5:
        if (r0.a() == false) goto L17;
        if (r0.b().length() <= 0) goto L9;
        boolean r16 = true;
    L10:
        if (r16 == false) goto L17;
        if (r0.c().length() <= 0) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == false) goto L17;
        r1 = true;
        goto L17
    L14:
        r17 = false;
        goto L15
    L9:
        r16 = false;
        goto L10
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void q(String r4, String r5, Object r6, Object r7, Object r8) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "context");
        ConcurrentHashMap<String, e> r2 = g68.a.a;
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "context");
        e r9 = g68.a.a.get(r4);
        if (r9 == null) goto L6;
        r9.c(r5, r6, r7, r8);
        return;
    }

    @Override // com.larus.audio.IFlowAsrClientService
    public final void s(String r10, String r11, String r12, int r13, String r14) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.m.contains(r10) == false) goto L7;
        return;
    L7:
        k78.a r0 = (k78.a) this.q.getValue();
        if (r14 != null) goto L10;
        String r2 = "";
    L11:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.b = r2;
        ConcurrentHashMap<String, k78.a> r1 = this.m;
        if (r14 != null) goto L14;
        String r7 = "";
    L15:
        r1.put(r10, new k78.a(r10, r11, r12, r13, r7));
        return;
    L14:
        r7 = r14;
        goto L15
    L10:
        r2 = r14;
        goto L11
    }

    public final void A(String r6, String r7, long r8, final b r10, final Integer r11, final String r12, String r13) {
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L29;
        if (r7 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L30;
        int r4 = c68.b.a;
        c68.b.d("FlowAsrClient", "timeoutTask taskId=" + r6 + ", createTimeoutTask ,filePath:" + r7 + " timeoutDuration=" + r8 + " from=" + r13);
        y(r6, "createTimeoutTask");
        if (this.p.b.length == 0) goto L22;
        r0 = false;
    L22:
        if (r0 == true) goto L31;
        c68.b.d("FlowAsrClient", "timeoutTask taskId=" + r10.a + " => initTimeoutTask timeoutDuration=" + r8 + " errCode=" + r11 + " errorMessage=" + r12);
        Runnable r9 = new j(this, r10, r11, r12);
        ConcurrentHashMap<String, Runnable> r14 = this.k;
        String r15 = r10.a;
        if (r15 != null) goto L27;
        r15 = "";
    L27:
        r14.put(r15, r9);
        g1.a.postDelayed(r9, r8);
        return;
    L31:
        return;
    L30:
        return;
    L12:
        if (r7.length() == 0) goto L15;
        r3 = false;
        goto L16
    L29:
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static void O(final FlowAsrClientImpl r16, final String r17, final AsrCallBackType r19, final String r110, final String r20, long r21, String r23, int r24, String r25, String r26, String r27, int r29) {
        if ((r29 & 16) == 0) goto L5;
        final long r7 = 0;
    L7:
        if ((r29 & 32) == 0) goto L9;
        final String r9 = "";
    L11:
        if ((r29 & 64) == 0) goto L13;
        final int r10 = 0;
    L14:
        String r3 = null;
        if ((r29 & 128) == 0) goto L17;
        final String r11 = null;
    L19:
        if ((r29 & 256) == 0) goto L21;
        final String r12 = null;
    L23:
        if ((r29 & 512) == 0) goto L25;
        final String r13 = null;
    L27:
        monitor-enter(r16);
        int r2 = c68.b.a;     // Catch: Throwable -> L70
        c68.b.a("FlowAsrClient", "report taskId :" + r17 + ", asrCallbackType:" + r19 + ", result:" + g0.a(r110) + " ,filePath: " + r20);     // Catch: Throwable -> L70
        k r1 = c68.a.c("onResultState");     // Catch: Throwable -> L70
        if (r1 == null) goto L67;
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L70
        r4.put("task_id", r17);     // Catch: Throwable -> L70
        y58.a r15 = r16.o.get(r17);     // Catch: Throwable -> L70
        if (r15 == null) goto L33;
        String r111 = r15.y;     // Catch: Throwable -> L70
    L34:
        if (r111 != null) goto L36;
        r111 = "";
    L36:
        r4.put("bot_id", r111);     // Catch: Throwable -> L70
        y58.a r112 = r16.o.get(r17);     // Catch: Throwable -> L70
        if (r112 == null) goto L39;
        String r113 = r112.c;     // Catch: Throwable -> L70
    L40:
        if (r113 != null) goto L42;
        r113 = "";
    L42:
        r4.put("conversation_id", r113);     // Catch: Throwable -> L70
        r4.put("file_path", r20);     // Catch: Throwable -> L70
        r4.put("asr_callback_type", r19.name());     // Catch: Throwable -> L70
        r4.put("empty_result", String.valueOf(StringsKt.isBlank(r110)));     // Catch: Throwable -> L70
        r4.put("audio_duration", String.valueOf(r7));     // Catch: Throwable -> L70
        r4.put("error_code", String.valueOf(r10));     // Catch: Throwable -> L70
        r4.put("vid", r9);     // Catch: Throwable -> L70
        if (r11 != null) goto L45;
        String r114 = "";
    L46:
        r4.put("audio_data_tos_uri", r114);     // Catch: Throwable -> L70
        if (r12 != null) goto L49;
        String r115 = "";
    L50:
        r4.put("audio_event_resp", r115);     // Catch: Throwable -> L70
        if (r13 != null) goto L53;
        String r116 = "";
    L54:
        r4.put("log_id", r116);     // Catch: Throwable -> L70
        com.larus.audio.utils.b r5 = (com.larus.audio.utils.b) r1;     // Catch: Throwable -> L70
        r5.c(r4);     // Catch: Throwable -> L70
        r5.d("FlowAsrClient.report");     // Catch: Throwable -> L70
        y58.a r6 = r16.o.get(r17);     // Catch: Throwable -> L70
        if (r6 == null) goto L60;
        y58.d r8 = r6.z;     // Catch: Throwable -> L70
        if (r8 == null) goto L60;
        String r14 = r8.a;     // Catch: Throwable -> L70
        if (r14 == null) goto L60;
    L61:
        r5.b(CollectionsKt.listOf(r14));     // Catch: Throwable -> L70
        y58.a r22 = r16.o.get(r17);     // Catch: Throwable -> L70
        if (r22 == null) goto L66;
        y58.d r30 = r22.z;     // Catch: Throwable -> L70
        if (r30 == null) goto L66;
        r3 = r30.b;     // Catch: Throwable -> L70
    L66:
        r5.e(r3);     // Catch: Throwable -> L70
        k.a.a(r5);     // Catch: Throwable -> L70
    L60:
        r14 = "";
        goto L61
    L53:
        r116 = r13;
        goto L54
    L49:
        r115 = r12;
        goto L50
    L45:
        r114 = r11;
        goto L46
    L39:
        r113 = null;
        goto L40
    L33:
        r111 = null;
    L67:
        g1.a.post(new m(new g78.i(r16, r17, r19, r110, r20, r7, r9, r10, r11, r12, r13)));     // Catch: Throwable -> L70
        monitor-exit(r16);
        return;
    L70:
        th = move-exception;
        throw th;
    L25:
        r13 = r27;
        goto L27
    L21:
        r12 = r26;
        goto L23
    L17:
        r11 = r25;
        goto L19
    L13:
        r10 = r24;
        goto L14
    L9:
        r9 = r23;
        goto L11
    L5:
        r7 = r21;
        goto L7
    }
}
