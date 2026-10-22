package com.obric.assistant.network.impl;

import android.os.SystemClock;
import android.provider.Settings;
import android.util.Base64;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.cloudtrans.CloudTransCryptoManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.network.FlowHttpConnection;
import com.larus.network.NetQualityManager;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskCreateRequest;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.network.api.INetworkInterceptorService;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.network.api.bean.IntentShortLinkType;
import com.obric.assistant.network.api.bean.ObricClearTaskRequest;
import com.obric.assistant.network.api.bean.ObricConditionalTaskDeleteRequest;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import com.obric.assistant.network.api.bean.ObricOperateQueueRequest;
import com.obric.assistant.network.api.bean.ObricRestoreImageResponse;
import com.obric.assistant.network.api.bean.ObricStopTaskRequest;
import com.obric.assistant.network.api.bean.ObricUserTakeOverRequest;
import com.obric.assistant.settings.v;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.json.JSONObject;
import vea.c;
import vea.i;
import vea.l;
import vea.m;
import vea.n;
import vea.p;
import vea.q;
import vea.r;
import vea.s;
import wea.b;
import xea.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u009b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0017\b\u0007\u0018\u0000 Ú\u00012\u00020\u0001:\n×\u0001Ø\u0001Ù\u0001Ú\u0001Û\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\u001c\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0(H\u0096@¢\u0006\u0002\u0010)J@\u0010*\u001a\u00020\u001f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0(2\u0006\u0010-\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0016J\"\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J@\u00104\u001a\u00020\u001f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0(2\u0006\u0010-\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0016J:\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0016J\u0016\u00107\u001a\u00020\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0(H\u0002JF\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020\u001a2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140=2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\fH\u0002JR\u0010?\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\f2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010/2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010=2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\fH\u0002J@\u0010E\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010@\u001a\u00020A2\b\u0010.\u001a\u0004\u0018\u00010/2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010=2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010F\u001a\u00020\u001f*\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00140G2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\fH\u0002J2\u0010K\u001a\u00020\u001f2\b\u0010;\u001a\u0004\u0018\u00010\f2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140G2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\fH\u0002J \u0010M\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\u0006\u0010;\u001a\u00020\fH\u0002J2\u0010N\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\f2\u0006\u0010O\u001a\u00020A2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010=H\u0002J0\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020I2\u0006\u0010S\u001a\u00020I2\u0006\u0010T\u001a\u00020I2\u0006\u0010U\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010VJ\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020X0(H\u0096@¢\u0006\u0002\u0010YJ\u0010\u0010Z\u001a\u0004\u0018\u00010[H\u0096@¢\u0006\u0002\u0010YJ(\u0010\\\u001a\u00020\u001f2\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J,\u0010^\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\f2\u0010\u0010]\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u0010`\u001a\u00020\u001f2\u0006\u0010a\u001a\u00020I2\u0006\u00102\u001a\u00020\fH\u0016J<\u0010b\u001a\u00020\u001f2\u0006\u0010a\u001a\u00020I2\u0006\u0010c\u001a\u00020\f2\u0006\u0010d\u001a\u00020\f2\u0010\u0010]\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J8\u0010e\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J®\u0001\u0010g\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\f2\b\u0010h\u001a\u0004\u0018\u00010\f2\b\u0010i\u001a\u0004\u0018\u00010\f2\b\u0010j\u001a\u0004\u0018\u00010\f2\b\u0010k\u001a\u0004\u0018\u00010\f2\b\u0010l\u001a\u0004\u0018\u00010\f2\b\u0010m\u001a\u0004\u0018\u00010\f2\b\u0010n\u001a\u0004\u0018\u00010\f2\b\u0010o\u001a\u0004\u0018\u00010\f2\b\u0010p\u001a\u0004\u0018\u00010\f2\b\u0010q\u001a\u0004\u0018\u00010\f2\b\u0010r\u001a\u0004\u0018\u00010\f2\b\u0010s\u001a\u0004\u0018\u00010\f2\b\u0010t\u001a\u0004\u0018\u00010\f2\u0010\u0010]\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u0010u\u001a\u00020\u001f2\u0006\u0010v\u001a\u00020w2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J,\u0010x\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\f2\u0010\u0010]\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J6\u0010y\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\f2\u0010\u0010]\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J}\u0010z\u001a\u00020\u001f2\b\u0010_\u001a\u0004\u0018\u00010\f2\b\u0010{\u001a\u0004\u0018\u00010\f2\u0006\u0010|\u001a\u00020A2\b\u0010}\u001a\u0004\u0018\u00010\f2\b\u0010~\u001a\u0004\u0018\u00010\f2\b\u0010\u007f\u001a\u0004\u0018\u00010\f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(2\b\u00109\u001a\u0004\u0018\u00010\f2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0087\u0001\u0010\u0083\u0001\u001a\u00020\u001f2\b\u0010_\u001a\u0004\u0018\u00010\f2\b\u0010{\u001a\u0004\u0018\u00010\f2\u0006\u0010|\u001a\u00020A2\b\u0010}\u001a\u0004\u0018\u00010\f2\b\u0010~\u001a\u0004\u0018\u00010\f2\b\u0010\u007f\u001a\u0004\u0018\u00010\f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(2\b\u00109\u001a\u0004\u0018\u00010\f2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0084\u0001\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J«\u0001\u0010\u0085\u0001\u001a\u00020\u001f2\b\u0010_\u001a\u0004\u0018\u00010\f2\b\u0010{\u001a\u0004\u0018\u00010\f2\u0006\u0010|\u001a\u00020A2\b\u0010}\u001a\u0004\u0018\u00010\f2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\f2\b\u0010\u007f\u001a\u0004\u0018\u00010\f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(2\b\u00109\u001a\u0004\u0018\u00010\f2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J´\u0001\u0010\u008b\u0001\u001a\u00020\u001f2\b\u0010_\u001a\u0004\u0018\u00010\f2\b\u0010{\u001a\u0004\u0018\u00010\f2\u0006\u0010|\u001a\u00020A2\b\u0010}\u001a\u0004\u0018\u00010\f2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\f2\b\u0010\u007f\u001a\u0004\u0018\u00010\f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(2\b\u00109\u001a\u0004\u0018\u00010\f2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0084\u0001\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0094\u0001\u0010\u008c\u0001\u001a\u00020\u001f2\u0007\u0010\u008d\u0001\u001a\u00020\f2\b\u0010_\u001a\u0004\u0018\u00010\f2\b\u0010{\u001a\u0004\u0018\u00010\f2\u0006\u0010|\u001a\u00020A2\u000e\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010(2\b\u0010\u007f\u001a\u0004\u0018\u00010\f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(2\b\u00109\u001a\u0004\u0018\u00010\f2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001a2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0003\u0010\u0091\u0001J%\u0010\u0092\u0001\u001a\u00020\u001f2\u0007\u0010\u008d\u0001\u001a\u00020\f2\u0007\u0010\u0093\u0001\u001a\u00020\f2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002J\u000e\u0010\u0096\u0001\u001a\u00020\f*\u00030\u0097\u0001H\u0002J.\u0010\u0098\u0001\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010/2\u0007\u0010\u0099\u0001\u001a\u00020\f2\u0007\u0010\u009a\u0001\u001a\u00020\f2\u0007\u0010\u009b\u0001\u001a\u00020\fH\u0002J\u0014\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u008f\u0001H\u0002J)\u0010\u009f\u0001\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00132\u000e\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u00010(H\u0002J\u0014\u0010¡\u0001\u001a\u00020\f*\t\u0012\u0005\u0012\u00030\u009d\u00010(H\u0002J\u0014\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0014\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u00012\u0006\u0010}\u001a\u00020\fH\u0002J\u0018\u0010§\u0001\u001a\u00020\u001a*\u00030¥\u00012\b\u0010¨\u0001\u001a\u00030¥\u0001H\u0002J%\u0010©\u0001\u001a\u00020\u001a2\b\u0010¤\u0001\u001a\u00030¥\u00012\u0006\u0010_\u001a\u00020\f2\b\u0010\u0093\u0001\u001a\u00030£\u0001H\u0002J\u001f\u0010ª\u0001\u001a\u0004\u0018\u00010\f2\b\u0010¤\u0001\u001a\u00030¥\u00012\b\u0010\u0093\u0001\u001a\u00030£\u0001H\u0002J'\u0010«\u0001\u001a\u00020\u001a2\b\u0010¬\u0001\u001a\u00030¥\u00012\b\u0010\u00ad\u0001\u001a\u00030¥\u00012\b\u0010\u0093\u0001\u001a\u00030£\u0001H\u0002J\u001d\u0010®\u0001\u001a\u00020A2\b\u0010¤\u0001\u001a\u00030¥\u00012\b\u0010\u0093\u0001\u001a\u00030£\u0001H\u0002J\u0012\u0010¯\u0001\u001a\u00020\f2\u0007\u0010°\u0001\u001a\u00020\fH\u0002J\u0014\u0010±\u0001\u001a\u00030²\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0011\u0010³\u0001\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\fH\u0002J\u001c\u0010´\u0001\u001a\u00020\u001f2\u0007\u0010µ\u0001\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001c\u0010´\u0001\u001a\u00020\u001f2\u0007\u0010v\u001a\u00030¶\u00012\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J4\u0010·\u0001\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020\f2\u0007\u0010¸\u0001\u001a\u00020\f2\u0010\u0010]\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010/J*\u0010¹\u0001\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020\f2\u0007\u0010º\u0001\u001a\u00020\f2\u0007\u0010»\u0001\u001a\u00020\fH\u0096@¢\u0006\u0003\u0010¼\u0001J\u0012\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0096@¢\u0006\u0002\u0010YJ\"\u0010¿\u0001\u001a\u00020\u001a2\u0007\u0010À\u0001\u001a\u00020\f2\u0007\u0010Á\u0001\u001a\u00020\fH\u0096@¢\u0006\u0003\u0010Â\u0001J\t\u0010Ã\u0001\u001a\u00020IH\u0002J\t\u0010Ä\u0001\u001a\u00020IH\u0002J\t\u0010Å\u0001\u001a\u00020AH\u0016J\u0012\u0010Æ\u0001\u001a\u00020\u001f2\u0007\u0010Ç\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010È\u0001\u001a\u00020\u001f2\u0007\u0010Ç\u0001\u001a\u00020\u001aH\u0016J\u0014\u0010É\u0001\u001a\u00020\u001a2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0096@¢\u0006\u0002\u0010YJ\u0019\u0010Í\u0001\u001a\u00020\u001a2\u0007\u0010Î\u0001\u001a\u00020\u001aH\u0096@¢\u0006\u0003\u0010Ï\u0001J\u0010\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0096@¢\u0006\u0002\u0010YJ\u0019\u0010Ò\u0001\u001a\u00020\u001a2\u0007\u0010Ç\u0001\u001a\u00020\u001aH\u0096@¢\u0006\u0003\u0010Ï\u0001J\u0012\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001H\u0096@¢\u0006\u0002\u0010YJ\u0019\u0010Õ\u0001\u001a\u00020\u001a2\u0007\u0010!\u001a\u00030Ô\u0001H\u0096@¢\u0006\u0003\u0010Ö\u0001R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ü\u0001"}, d2 = {"Lcom/obric/assistant/network/impl/ObricNetworkServiceImpl;", "Lcom/obric/assistant/network/api/IObricNetworkService;", "<init>", "()V", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "getIoScope", "()Lkotlinx/coroutines/CoroutineScope;", "ioScope$delegate", "Lkotlin/Lazy;", "uplinkingIntentRequest", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/network/api/bean/ObricIntentUplinkRequest;", "getUplinkingIntentRequest", "()Ljava/util/concurrent/ConcurrentHashMap;", "optimizedUplinkingNotifyBody", "", "performanceExtrasMap", "", "", "omniUploadCryptoInitKey", "omniUploadCryptoEnvBridge", "com/obric/assistant/network/impl/ObricNetworkServiceImpl$omniUploadCryptoEnvBridge$1", "Lcom/obric/assistant/network/impl/ObricNetworkServiceImpl$omniUploadCryptoEnvBridge$1;", "isTTNetBgcpEnabled", "", "bgcpDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "bgcpWorkScope", "init", "", "initNetworkRestrict", "config", "Lcom/larus/network/config/BackgroundControlConfig;", "triggerBackgroundNetworkRestrictIfNeeded", "isNetworkAvailable", "restoreImage", "Lcom/obric/assistant/network/api/bean/ObricRestoreImageResult;", "uriList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadIntentResultForCompensationByHttp", "intentResult", "Lcom/obric/aiagent/assistant/idl/bean/OPushEvent;", "needRetry", "callback", "Lcom/obric/aiagent/assistant/idl/IFlowNetworkResultCallbackIDL;", "performanceExtras", "uploadNormalRouterByHttp", "scene", "passThrough", "uploadIntentResultForAsyncNotifyByHttp", "uploadIntentResultForAsyncNotifyByHttpOptimized", "bodyBytes", "createIntentUplinkRequest", "handleUplinkResponseInternal", EffectConfiguration.KEY_TYPE, "Lcom/obric/assistant/network/api/bean/IntentShortLinkType;", "seqId", "response", "Lcom/larus/network/bean/HttpDataResult;", "responseLogId", "pendingRetry", "index", "", "immediateRetry", "lastRetryResult", "lastResponseLogId", "pendingOptimizedNotifyRetry", "appendOmniNetworkRequestStarted", "", "requestBuildDurationMs", "", "recordOmniNetworkRetry", "appendOmniNetworkPerformanceExtras", "retParams", "removeAndBuildExtras", "handleRetryReportInternal", "repeatTime", "getComplexTaskPanelInfo", "Lcom/obric/assistant/network/api/bean/ObricComplexTaskData;", "uid", "did", "updateVersionCode", "infoType", "(JJJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOperationInstructions", "Lcom/obric/assistant/network/api/bean/OperationInstruction;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOmniModelConfig", "Lcom/obric/assistant/network/api/bean/ObricOmniModelConfig;", "clearOmniTasks", DBDefinition.EXTRA, "notifyStopOmniTaskByHttp", DBDefinition.TASK_ID, "notifyStopComplexTaskByHttp", "msgId", "replyAskUser", "askContent", "userAnswer", "inUserAdditionState", "id", "createConditionalTask", "oOmniInstructionType", "createType", "instruction", "originQuery", "shortQuery", "createTime", "updateTime", "knowledge", "automaticFields", "operateType", "discoveryId", "discoveryQuery", "userSelectModel", "sweepConditionalTask", "request", "Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskSweepRequest;", "deleteConditionalTask", "takeOverChanged", "uploadOmniScreenshotByHttp", "toolId", "imageCount", "imagePath", "mime", "source", "feedbackContent", "feedbackTags", "score", "uploadOmniScreenshotByHttpV2", "isFinish", "uploadOmniDataFeedbackByHttp", "imageMime", "viewTreePath", "viewTreeMime", "reactViewTreePath", "reactViewTreeMime", "uploadOmniDataFeedbackByHttpV2", "uploadOmniDataFeedbackInternal", "logName", "payloadInputs", "Lcom/obric/assistant/network/impl/ObricNetworkServiceImpl$OmniUploadPayloadInput;", "explicitIsFinish", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/aiagent/assistant/idl/IFlowNetworkResultCallbackIDL;)V", "logOmniUploadPrepareFailure", "payloadKind", "throwable", "Lcom/obric/assistant/network/impl/ObricNetworkServiceImpl$OmniUploadPrepareException;", "toReleaseLogSummary", "", "notifyOmniUploadFailure", "msg", "failureStage", "reasonCode", "prepareOmniUploadPayload", "Lcom/obric/assistant/network/impl/ObricNetworkServiceImpl$OmniUploadPreparedPayload;", "input", "buildOmniUploadExtra", "preparedPayloads", "describeFiles", "resolveOmniUploadPayloadKind", "Lcom/obric/assistant/network/impl/ObricNetworkServiceImpl$OmniUploadPayloadKind;", "file", "Ljava/io/File;", "resolveSafeOmniScreenshotFile", "isUnderDirectory", "rootCanonical", "isLastOmniUploadFileForTask", "parseOmniUploadTaskId", "isOmniUploadFileAfter", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "current", "omniUploadStepIndex", "toOmniUploadFileNamePart", "value", "encryptOmniUploadFile", "Lcom/obric/assistant/network/impl/OmniScreenshotEncryptedPayload;", "ensureOmniUploadCryptoInitialized", "operateQueue", "data", "Lcom/obric/assistant/network/api/bean/ObricOperateQueueRequest;", "additionTask", "content", "checkRomVersionCompatible", DBDefinition.APP_VERSION_CODE, "romVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoActionAppBlacklist", "Lcom/obric/assistant/settings/ObricGetAppBlacklistResponse;", "reportODidRelation", "appId", "attCertChain", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUid", "getDid", "getCurrentNetworkStatus", "setPreconnectEnabled", "enabled", "setTTNetBgcpEnabled", "allowedToDisplayPrivateUrl", "openUrl", "getPrivacyConversationContentConfig", "Lcom/obric/assistant/network/api/bean/ObricPrivacyConversationContentConfig;", "setPrivacyConversationContentConfig", "conversationContentModelTrainingEnable", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVoiceWakeupImprovementConfig", "Lcom/obric/assistant/network/api/bean/ObricVoiceWakeupImprovementConfigResult;", "setVoiceWakeupImprovementConfig", "getReferenceMemoryConfig", "Lcom/obric/assistant/network/api/bean/ObricReferenceMemoryConfig;", "setReferenceMemoryConfig", "(Lcom/obric/assistant/network/api/bean/ObricReferenceMemoryConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "OmniUploadPayloadInput", "OmniUploadPreparedPayload", "OmniUploadPrepareException", "Companion", "OmniUploadPayloadKind", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricNetworkServiceImpl implements IObricNetworkService {
    public static final List<String> i = null;
    public final Lazy a;
    public final ConcurrentHashMap<String, i> b;
    public final ConcurrentHashMap<String, byte[]> c;
    public final ConcurrentHashMap<String, Map<String, Object>> d;
    public volatile String e;
    public final e f;
    public volatile boolean g;
    public final CoroutineScope h;

    /* JADX INFO: renamed from: com.obric.assistant.network.impl.ObricNetworkServiceImpl$clearOmniTasks$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$clearOmniTasks$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {842}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
        final /* synthetic */ Map<String, String> $extra;
        final /* synthetic */ ObricClearTaskRequest $request;
        int label;

        public AnonymousClass1(Map<String, String> r1, IFlowNetworkResultCallbackIDL r2, ObricClearTaskRequest r3, Continuation<? super AnonymousClass1> r4) {
            this.$extra = r1;
            this.$callback = r2;
            this.$request = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$extra, this.$callback, this.$request, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            dm9.a.a r8 = (dm9.a) r7;
            if ((r8 instanceof dm9.a.b) == false) goto L20;
            IAgentAppIntentIDL r9 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
            if (r9 == null) goto L16;
            r9.clearAllOmniTask(this.$extra);
        L16:
            FLogger.a.i("[ObricNetworkServiceImpl]", "clearOmniTasks: success");
            IFlowNetworkResultCallbackIDL r10 = this.$callback;
            if (r10 == null) goto L25;
            r10.onResult(true, MapsKt.emptyMap());
        L25:
            return Unit.INSTANCE;
        L20:
            if ((r8 instanceof dm9.a.a) == false) goto L27;
            FLogger.a.i("[ObricNetworkServiceImpl]", "clearOmniTasks: error");
            IFlowNetworkResultCallbackIDL r2 = this.$callback;
            if (r2 == null) goto L25;
            dm9.a.a r11 = r8;
            r2.onResult(false, MapsKt.mapOf(new Pair[]{TuplesKt.to("code", String.valueOf(r11.a)), TuplesKt.to("msg", r11.b)}));
            goto L25
        L27:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            FLogger.a.i("[ObricNetworkServiceImpl]", "clearOmniTasks: start, extra=" + this.$extra);
            ObricProtocolApi.a r12 = ObricProtocolApi.a;
            ObricNetworkServiceImpl$clearOmniTasks$1$response$1 r3 = new ObricNetworkServiceImpl$clearOmniTasks$1$response$1(this.$request, null);
            this.label = 1;
            r12.getClass();
            r7 = ObricProtocolApi.a.a(r3, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public static final class e implements IEnvBridge {
        public e() {
        }

        public final boolean onIsBoeEnv() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
            boolean r2 = false;
            if (Settings.Global.getInt(AppHost.a.getApplication().getContentResolver(), "matrix_env_status_is_boe", 0) != 1) goto L5;
            r2 = true;
        L5:
            Object r1 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L7
        L9:
            Boolean r3 = Boolean.FALSE;
            if (Result.isFailure-impl(r1) == false) goto L13;
            r1 = r3;
        L13:
            return ((Boolean) r1).booleanValue();
        L7:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.network.impl.ObricNetworkServiceImpl$getOmniModelConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl", f = "ObricNetworkServiceImpl.kt", i = {}, l = {818}, m = "getOmniModelConfig", n = {}, s = {})
    public static final class C00381 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricNetworkServiceImpl this$0;

        public C00381(ObricNetworkServiceImpl r1, Continuation<? super C00381> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= IntCompanionObject.MIN_VALUE;
            return this.this$0.getOmniModelConfig(this);
        }
    }

    static {
        i = CollectionsKt.listOf(new String[]{"https://os.obriccloud.com/agreement/enhance_wakeup", "https://os.obriccloud.com/agreement/enhance_asr", "https://os.oceancloudapi.com/agreement/fingerprint_declaration", "https://os.obriccloud.com/agreement/voiceprint_declaration", "https://www.doubao.com/ocean_legal/terms", "https://os.obriccloud.com/agreement/AudioRecordingUsageRules"});
    }

    public static long F() {
        String r0 = AccountService.a.getUserId();
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L10;
        return 0;
    L10:
        return CastLongProtector.parseLong(r0);
    L5:
        r1 = false;
        goto L6
    }

    public final CoroutineScope E() {
        return (CoroutineScope) this.a.getValue();
    }

    public final int getCurrentNetworkStatus() {
        NetQualityManager.NetworkStatus r0 = NetQualityManager.a;
        return NetQualityManager.a.getValue();
    }

    public final void init() {
        d.a r0 = d.a;
        FLogger.a.i("ObricTTNetReport", "init");
        INetworkInterceptorService r1 = (INetworkInterceptorService) ServiceManager.get().getService(INetworkInterceptorService.class);
        if (r1 == null) goto L5;
        r1.b(d.h);
    L5:
        List<WeakReference<wea.a>> r2 = b.a;
        d.b r3 = d.j;
        Intrinsics.checkNotNullParameter(r3, "hook");
        Iterator<T> r4 = b.a.iterator();     // Catch: Throwable -> L18
    L8:
        if (r4.hasNext() == false) goto L16;
        WeakReference r5 = (WeakReference) r4.next();     // Catch: Throwable -> L18
        if (r5 == null) goto L12;
        wea.a r6 = (wea.a) r5.get();     // Catch: Throwable -> L18
    L14:
        if (Intrinsics.areEqual(r3, r6) == false) goto L8;
        return;
    L12:
        r6 = null;
        goto L14
    L16:
        b.a.add(new WeakReference(r3));     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        FLogger.a.w("TTNetMonitorHook", "registerMonitorHook failed：" + th.getMessage());
    }

    public final boolean isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailable(AppHost.a.getApplication());
    }

    public ObricNetworkServiceImpl() {
        this.a = LazyKt.lazy(new a());
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.f = new e();
        this.h = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new b())));
    }

    public final k D(File r7) {
        String r0 = StringsKt.trim(o.a.getDeviceId()).toString();
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L23;
        String r2 = "obric_doubao_assistant@".concat(r0);
        if (Intrinsics.areEqual(this.e, r2) == true) goto L17;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L12:
        if (Intrinsics.areEqual(this.e, r2) == false) goto L15;
        monitor-exit(this);
        goto L17
    L15:
        CloudTransCryptoManager.getInstance().init(AppHost.a.getApplication(), "obric_doubao_assistant", r0, this.f);     // Catch: Throwable -> L19
        this.e = r2;     // Catch: Throwable -> L19
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
    L17:
        byte[] r8 = FilesKt.readBytes(r7);
        String r4 = Base64.encodeToString(CloudTransCryptoManager.getInstance().dataEncrypt(r8), 2);
        Intrinsics.checkNotNull(r4);
        return new k(r4, r8.length);
    L23:
        throw new IllegalArgumentException("did is empty".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final Map<String, Object> K(String r6) {
        Map<String, Object> r7 = this.d.remove(r6);
        Long r0 = null;
        if (r7 == null) goto L13;
        Map<String, Object> r8 = MapsKt.toMutableMap(r7);
        if (r8 == null) goto L14;
        Object r1 = r8.remove("network_start_time");
        if ((r1 instanceof Long) == false) goto L9;
        r0 = (Long) r1;
    L9:
        if (r0 == null) goto L12;
        r8.put("network_cost_ms", Long.valueOf(SystemClock.elapsedRealtime() - r0.longValue()));
    L12:
        return r8;
    L14:
        return null;
    L13:
        return null;
    }

    public final boolean a(String r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (i.contains(r2) == false) goto L6;
        return true;
    }

    public final void f(boolean r7) {
        BuildersKt.launch$default(this.h, null, null, new ObricNetworkServiceImpl$setTTNetBgcpEnabled$1(r7, this, null), 3, null);
    }

    public final Object getOmniModelConfig(Continuation<? super ObricOmniModelConfig> r6) {
        if ((r6 instanceof C00381) == false) goto L7;
        C00381 r0 = (C00381) r6;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        dm9.a.b r8 = (dm9.a) r7;
        if ((r8 instanceof dm9.a.b) == false) goto L21;
        FLogger.a.i("[ObricNetworkServiceImpl]", "getOmniModelConfig success");
        return (ObricOmniModelConfig) r8.a.getData();
    L21:
        if ((r8 instanceof dm9.a.a) == false) goto L25;
        FLogger.a.i("[ObricNetworkServiceImpl]", "getOmniModelConfig transport error");
        return null;
    L25:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        ObricProtocolApi.a r9 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$getOmniModelConfig$response$1 r4 = new ObricNetworkServiceImpl$getOmniModelConfig$response$1(null);
        r0.label = 1;
        r9.getClass();
        r7 = ObricProtocolApi.a.a(r4, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new C00381(this, r6);
        goto L8
    }

    public final Object getOperationInstructions(Continuation<? super List<q>> r7) {
        if ((r7 instanceof getOperationInstructions.1) == false) goto L7;
        getOperationInstructions.1 r0 = (getOperationInstructions.1) r7;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        List r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        if ((r9 instanceof dm9.a.b) == false) goto L27;
        FLogger.a.i("[ObricNetworkServiceImpl]", "getOperationInstructions success");
        r r10 = (r) r9.a.getData();
        if (r10 == null) goto L24;
        List r11 = r10.a();
        if (r11 == null) goto L24;
        r4 = CollectionsKt.filterNotNull(r11);
    L24:
        if (r4 == null) goto L33;
        return r4;
    L33:
        return CollectionsKt.emptyList();
    L27:
        if ((r9 instanceof dm9.a.a) == false) goto L31;
        FLogger.a.i("[ObricNetworkServiceImpl]", "getOperationInstructions error");
        return CollectionsKt.emptyList();
    L31:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("[ObricNetworkServiceImpl]", "getOperationInstructions");
        ObricProtocolApi.a r12 = ObricProtocolApi.a;
        getOperationInstructions.response.1 r5 = new getOperationInstructions.response.1(null);
        r0.label = 1;
        r12.getClass();
        r8 = ObricProtocolApi.a.a(r5, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new getOperationInstructions.1(this, r7);
        goto L8
    }

    public final Object i(Continuation<? super m> r6) {
        if ((r6 instanceof ObricNetworkServiceImpl$getReferenceMemoryConfig$1) == false) goto L7;
        ObricNetworkServiceImpl$getReferenceMemoryConfig$1 r0 = (ObricNetworkServiceImpl$getReferenceMemoryConfig$1) r6;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        dm9.a.b r8 = (dm9.a) r7;
        if ((r8 instanceof dm9.a.b) == false) goto L37;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L26
        Gson r9 = new Gson();     // Catch: Throwable -> L26
        ConfigQueryResponse r10 = (ConfigQueryResponse) r8.a.getData();     // Catch: Throwable -> L26
        if (r10 == null) goto L23;
        String r11 = r10.getValue();     // Catch: Throwable -> L26
        if (r11 == null) goto L23;
    L24:
        Object r12 = Result.constructor-impl((m) r9.fromJson(r11, m.class));     // Catch: Throwable -> L26
    L28:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L32;
        FLogger.a.e("[ObricNetworkServiceImpl]", "getReferenceMemoryConfig json parse failed", r13);
    L32:
        if (Result.isFailure-impl(r12) == true) goto L38;
        r4 = r12;
    L38:
        return (m) r4;
    L23:
        r11 = "{}";
    L26:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L37:
        if ((r8 instanceof dm9.a.a) == false) goto L40;
        return null;
    L40:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        ObricUserExperiencePlanConfigApi.a r15 = ObricUserExperiencePlanConfigApi.a;
        ObricNetworkServiceImpl$getReferenceMemoryConfig$response$1 r16 = new ObricNetworkServiceImpl$getReferenceMemoryConfig$response$1(null);
        r0.label = 1;
        r15.getClass();
        r7 = ObricUserExperiencePlanConfigApi.a.a(r16, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new ObricNetworkServiceImpl$getReferenceMemoryConfig$1(this, r6);
        goto L8
    }

    public final void m(boolean r8) {
        FLogger r1 = FLogger.a;
        r1.i("[ObricNetworkServiceImpl]", "===>>> start Preconnect enabled set to: " + r8);
        HashMap r5 = new HashMap();     // Catch: Exception -> L9
        if (r8 == false) goto L6;
        String r6 = "1";
    L7:
        r5.put("x-ttnet-action-preconnect-on", r6);     // Catch: Exception -> L9
        TTNetProtocolUtil.sendTTNetProtocolRequest("preconnect", "", null, r5);     // Catch: Exception -> L9
        r1.i("[ObricNetworkServiceImpl]", "<<<=== end Preconnect enabled set to: " + r8);     // Catch: Exception -> L9
        return;
    L6:
        r6 = "0";
    L9:
        e = move-exception;
        e.printStackTrace();
        if (AppHost.a.isDebug() == true) goto L14;
        FLogger.a.e("[ObricNetworkServiceImpl]", "Preconnect enabled set failed: enabled=" + r8, e);
        return;
    L14:
        throw e;
    }

    public final Object p(Continuation<? super p> r6) {
        if ((r6 instanceof ObricNetworkServiceImpl$getVoiceWakeupImprovementConfig$1) == false) goto L7;
        ObricNetworkServiceImpl$getVoiceWakeupImprovementConfig$1 r0 = (ObricNetworkServiceImpl$getVoiceWakeupImprovementConfig$1) r6;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        dm9.a.b r8 = (dm9.a) r7;
        FLogger.a.i("[ObricNetworkServiceImpl]", "getVoiceWakeupImprovementConfig response, " + r8);
        if ((r8 instanceof dm9.a.b) == false) goto L53;
        dm9.a.b r9 = r8;
        if (r9.a.isSuccess() == false) goto L53;
        ConfigQueryResponse r10 = (ConfigQueryResponse) r9.a.getData();
        if (r10 == null) goto L25;
        String r11 = r10.getValue();
    L26:
        if (r11 != null) goto L28;
    L31:
        boolean r4 = true;
    L32:
        if (r4 == true) goto L34;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L37
        Object r12 = Result.constructor-impl((vea.o) new Gson().fromJson(r11, vea.o.class));     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r12) == false) goto L42;
        r12 = null;
    L42:
        vea.o r13 = (vea.o) r12;
        if (r13 != null) goto L47;
        return new p(false, true, null);
    L47:
        if (r13.a() != null) goto L51;
        return new p(true, false, null);
    L51:
        return new p(true, true, r13.a());
    L37:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L34:
        return new p(true, false, null);
    L28:
        if (StringsKt.isBlank(r11) == true) goto L31;
        r4 = false;
        goto L32
    L25:
        r11 = null;
    L53:
        return new p(false, false, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        ObricUserExperiencePlanConfigApi.a r15 = ObricUserExperiencePlanConfigApi.a;
        ObricNetworkServiceImpl$getVoiceWakeupImprovementConfig$response$1 r16 = new ObricNetworkServiceImpl$getVoiceWakeupImprovementConfig$response$1(null);
        r0.label = 1;
        r15.getClass();
        r7 = ObricUserExperiencePlanConfigApi.a.a(r16, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new ObricNetworkServiceImpl$getVoiceWakeupImprovementConfig$1(this, r6);
        goto L8
    }

    public final Object s(Continuation<? super v> r14) {
        if ((r14 instanceof getAutoActionAppBlacklist.1) == false) goto L7;
        getAutoActionAppBlacklist.1 r0 = (getAutoActionAppBlacklist.1) r14;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        String r7 = r4;
    L18:
        dm9.a.b r16 = (dm9.a) r15;
        if ((r16 instanceof dm9.a.b) == false) goto L22;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("getAutoActionAppBlacklist success, ");
        dm9.a.b r17 = r16;
        r6.append(r17.a.getData());
        r5.i("[ObricNetworkServiceImpl]", r6.toString());
        int r8 = xea.a.a;
        xea.a.a("/auto_action/api/task/app_blacklist", r7, Boxing.boxInt(isNetworkAvailable() ? 1 : 0), Boxing.boxInt(0), Boxing.boxInt((int) r17.a.getCode()), r17.a.getMsg(), null);
        return (v) r17.a.getData();
    L22:
        if ((r16 instanceof dm9.a.a) == false) goto L26;
        FLogger.a.i("[ObricNetworkServiceImpl]", "getAutoActionAppBlacklist error, " + r16);
        int r9 = xea.a.a;
        dm9.a.a r18 = (dm9.a.a) r16;
        xea.a.a("/auto_action/api/task/app_blacklist", r7, Boxing.boxInt(isNetworkAvailable() ? 1 : 0), Boxing.boxInt(0), Boxing.boxInt(r18.a), r18.b, null);
        return null;
    L26:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        FLogger.a.i("[ObricNetworkServiceImpl]", "getAutoActionAppBlacklist");
        String r19 = UUID.randomUUID().toString();
        int r10 = xea.a.a;
        xea.a.b("/auto_action/api/task/app_blacklist", r19, Boxing.boxInt(isNetworkAvailable() ? 1 : 0));
        ObricProtocolApi.a r11 = ObricProtocolApi.a;
        getAutoActionAppBlacklist.response.1 r12 = new getAutoActionAppBlacklist.response.1(null);
        r0.L$0 = r19;
        r0.label = 1;
        r11.getClass();
        Object r13 = ObricProtocolApi.a.a(r12, r0);
        if (r13 != r2) goto L17;
        return r2;
    L17:
        r7 = r19;
        r15 = r13;
    L7:
        r0 = new getAutoActionAppBlacklist.1(this, r14);
        goto L8
    }

    public final void v(String r3) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.TASK_ID);
        FLogger.a.i("[ObricNetworkServiceImpl]", "notifyStopOmniTaskByHttp not impl");
    }

    public final Object w(Continuation<? super l> r6) {
        if ((r6 instanceof ObricNetworkServiceImpl$getPrivacyConversationContentConfig$1) == false) goto L7;
        ObricNetworkServiceImpl$getPrivacyConversationContentConfig$1 r0 = (ObricNetworkServiceImpl$getPrivacyConversationContentConfig$1) r6;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        dm9.a.b r8 = (dm9.a) r7;
        FLogger.a.i("[ObricNetworkServiceImpl]", "getPrivacyConversationContentConfig response, " + r8);
        if ((r8 instanceof dm9.a.b) == false) goto L36;
        if (r8.a.isSuccess() == true) goto L40;
        return null;
    L40:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L28
        Gson r9 = new Gson();     // Catch: Throwable -> L28
        ConfigQueryResponse r10 = (ConfigQueryResponse) r8.a.getData();     // Catch: Throwable -> L28
        if (r10 == null) goto L25;
        String r11 = r10.getValue();     // Catch: Throwable -> L28
        if (r11 == null) goto L25;
    L26:
        Object r12 = Result.constructor-impl((l) r9.fromJson(r11, l.class));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r12) == true) goto L42;
        r4 = r12;
    L42:
        return (l) r4;
    L25:
        r11 = "{}";
    L28:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L36:
        if ((r8 instanceof dm9.a.a) == false) goto L39;
        return null;
    L39:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        ObricUserExperiencePlanConfigApi.a r14 = ObricUserExperiencePlanConfigApi.a;
        ObricNetworkServiceImpl$getPrivacyConversationContentConfig$response$1 r15 = new ObricNetworkServiceImpl$getPrivacyConversationContentConfig$response$1(null);
        r0.label = 1;
        r14.getClass();
        r7 = ObricUserExperiencePlanConfigApi.a.a(r15, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new ObricNetworkServiceImpl$getPrivacyConversationContentConfig$1(this, r6);
        goto L8
    }

    public static final c A(ObricNetworkServiceImpl r11, b r12) {
        r11.getClass();
        String r0 = r12.b;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(new PolarisFileWrapper(r0).getCanonicalFile());     // Catch: Throwable -> L5
    L7:
        String r3 = null;
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        File r4 = (File) r2;
        if (r4 == null) goto L44;
        AppHost.Companion r5 = AppHost.a;
        boolean r7 = false;
        List r6 = CollectionsKt.listOfNotNull(new File[]{r5.getApplication().getFilesDir(), r5.getApplication().getCacheDir()});
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L15:
        if (r9.hasNext() == false) goto L28;
        File r10 = (File) r9.next();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L19
        Object r14 = Result.constructor-impl(r10.getCanonicalFile());     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r14) == false) goto L24;
        r14 = null;
    L24:
        File r15 = (File) r14;
        if (r15 == null) goto L15;
        r8.add(r15);
    L19:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L28:
        if (r8.isEmpty() == true) goto L42;
        Iterator r17 = r8.iterator();
    L32:
        if (r17.hasNext() == false) goto L42;
        File r18 = (File) r17.next();
        String r19 = r18.getPath() + File.separator;
        if (Intrinsics.areEqual(r4, r18) == false) goto L36;
    L39:
        boolean r20 = true;
    L40:
        if (r20 == false) goto L32;
        r7 = true;
        goto L42
    L36:
        if (StringsKt.startsWith$default(r4.getPath(), r19, false, 2, null) == true) goto L39;
        r20 = false;
    L42:
        if (r7 == false) goto L44;
    L45:
        if (r4 == null) goto L79;
        if (r4.isFile() == false) goto L79;
        OmniUploadPayloadKind r21 = r12.a;
        if (r21 != null) goto L82;
        File r22 = r4.getParentFile();
        if (r22 == null) goto L53;
        String r23 = r22.getName();
    L55:
        if (Intrinsics.areEqual(r23, "omni_upload_viewtrees") == false) goto L58;
        r21 = OmniUploadPayloadKind.VIEW_TREE;
        goto L82
    L58:
        if (Intrinsics.areEqual(r23, "omni_upload_react_view_tree") == false) goto L60;
        r21 = OmniUploadPayloadKind.REACT_VIEW_TREE;
        goto L82
    L60:
        r21 = OmniUploadPayloadKind.IMAGE;
        goto L82
    L53:
        r23 = null;
    L82:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L63
        Object r110 = Result.constructor-impl(r11.D(r4));     // Catch: Throwable -> L63
    L65:
        Throwable r25 = Result.exceptionOrNull-impl(r110);
        if (r25 != null) goto L77;
        k r111 = (k) r110;
        String r112 = r12.c;
        if (r112 != null) goto L70;
    L73:
        r3 = r21.getDefaultMime();
    L75:
        return new c(r21, r4, r111, r3);
    L70:
        if ((true ^ StringsKt.isBlank(r112)) == false) goto L72;
        r3 = r112;
    L72:
        if (r3 != null) goto L75;
    L77:
        throw new OmniUploadPrepareException("host_encrypt_failed", "encrypt upload file failed", r25);
    L63:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
    L79:
        throw new OmniUploadPrepareException("host_file_unavailable", "upload file not found", null, 4, null);
    L44:
        r4 = null;
    L5:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void B(ObricNetworkServiceImpl r1, String r2) {
        r1.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L22
        Map<String, Object> r3 = r1.d.get(r2);     // Catch: Throwable -> L22
        JSONObject r4 = null;
        if (r3 == null) goto L6;
        Object r5 = r3.get("__omni_network_trace_payload");     // Catch: Throwable -> L22
    L8:
        if ((r5 instanceof JSONObject) == false) goto L10;
        r4 = (JSONObject) r5;     // Catch: Throwable -> L22
    L10:
        if (r4 == null) goto L18;
        monitor-enter(r4);     // Catch: Throwable -> L22
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L14:
        if (r4.optBoolean("__finished") == true) goto L16;
        r4.put("retry_count", r4.optInt("retry_count") + 1);     // Catch: Throwable -> L19
    L16:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r4);     // Catch: Throwable -> L22
        goto L18
    L18:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
        return;
    L6:
        r5 = null;
    L22:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static int I(File r6, OmniUploadPayloadKind r7) {
        String r8 = r6.getName();
        Intrinsics.checkNotNull(r8);
        int r9 = StringsKt.indexOf$default(r8, r7.getTaskMarker(), 0, false, 6, null);
        if (r9 > 0) goto L5;
        return Integer.MAX_VALUE;
    L5:
        Integer r10 = StringsKt.toIntOrNull(r8.substring(0, r9));
        if (r10 != null) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return r10.intValue();
    }

    public static final i y(ObricNetworkServiceImpl r2, List r3) {
        r2.getClass();
        List r4 = r3;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        OPushEvent r0 = (OPushEvent) r6.next();
        r5.add(GsonProtectorUtils.toJson(new Gson(), r0));
        goto L4
    L7:
        return new i(r5);
    }

    public final void clearOmniTasks(Map<String, String> r9, IFlowNetworkResultCallbackIDL r10) {
        ObricClearTaskRequest r0 = new ObricClearTaskRequest(String.valueOf(F()), r9);
        BuildersKt.launch$default(E(), null, null, new AnonymousClass1(r9, r10, r0, null), 3, null);
    }

    public final void h(String r7, IFlowNetworkResultCallbackIDL r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ObricOperateQueueRequest r9 = (ObricOperateQueueRequest) new Gson().fromJson(r7, ObricOperateQueueRequest.class);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L5
        BuildersKt.launch$default(E(), null, null, new operateQueue.3(r8, r9, null), 3, null);     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L15;
        FLogger.a.e("[ObricNetworkServiceImpl]", "operateQueue error with " + r11.getMessage());
        if (r8 == null) goto L16;
        r8.onResult(false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg", r11.getMessage())}));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final Object j(m r6, Continuation<? super Boolean> r7) {
        if ((r7 instanceof setReferenceMemoryConfig.1) == false) goto L7;
        setReferenceMemoryConfig.1 r0 = (setReferenceMemoryConfig.1) r7;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        if ((r9 instanceof dm9.a.b) == true) goto L20;
    L22:
        r4 = false;
    L24:
        return Boxing.boxBoolean(r4);
    L20:
        if (r9.a.isSuccess() == false) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ObricUserExperiencePlanConfigApi.a r10 = ObricUserExperiencePlanConfigApi.a;
        setReferenceMemoryConfig.response.1 r5 = new setReferenceMemoryConfig.response.1(r6, null);
        r0.label = 1;
        r10.getClass();
        r8 = ObricUserExperiencePlanConfigApi.a.a(r5, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new setReferenceMemoryConfig.1(this, r7);
        goto L8
    }

    public final Object n(List<String> r6, Continuation<? super n> r7) {
        if ((r7 instanceof restoreImage.1) == false) goto L7;
        restoreImage.1 r0 = (restoreImage.1) r7;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        List r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L21:
        dm9.a.a r9 = (dm9.a) r8;
        FLogger.a.i("[ObricNetworkServiceImpl]", "restoreImage: " + r9);
        if ((r9 instanceof dm9.a.a) == false) goto L25;
        dm9.a.a r10 = r9;
        return new n(false, Boxing.boxInt(r10.a), r10.b, 2);
    L25:
        if ((r9 instanceof dm9.a.b) == false) goto L37;
        dm9.a.b r11 = (dm9.a.b) r9;
        int r12 = (int) r11.a.getCode();
        if (r12 != 0) goto L39;
        ObricRestoreImageResponse r5 = (ObricRestoreImageResponse) r11.a.getData();
        if (r5 == null) goto L32;
        r4 = r5.getFailUris();
    L32:
        if (r4 != null) goto L35;
        r4 = CollectionsKt.emptyList();
    L35:
        return new n(r4.isEmpty(), r4, Boxing.boxInt(r12), r11.a.getMsg());
    L39:
        return new n(false, Boxing.boxInt(r12), r11.a.getMsg(), 2);
    L37:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r6.isEmpty() == true) goto L17;
        ObricProtocolApi.a r13 = ObricProtocolApi.a;
        restoreImage.response.1 r14 = new restoreImage.response.1(r6, null);
        r0.label = 1;
        r13.getClass();
        r8 = ObricProtocolApi.a.a(r14, r0);
        if (r8 != r2) goto L21;
        return r2;
    L17:
        return new n(true, null, null, 14);
    L7:
        r0 = new restoreImage.1(this, r7);
        goto L8
    }

    public final void q(long r10, String r12) {
        Intrinsics.checkNotNullParameter(r12, "scene");
        FLogger.a.i("[ObricNetworkServiceImpl]", "notifyStopComplexTaskByHttp: msgId = " + r10 + ", scene=" + r12);
        Long r1 = Long.valueOf(F());
        String r2 = o.a.getDeviceId();
        if (r2.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        long r4 = CastLongProtector.parseLong(r2);
    L9:
        vea.a r0 = new vea.a(r1, Long.valueOf(r4), Long.valueOf(AppHost.a.getUpdateVersionCode()));
        BuildersKt.launch$default(E(), null, null, new notifyStopComplexTaskByHttp.1(new ObricStopTaskRequest(Long.valueOf(r10), MapsKt.mapOf(TuplesKt.to("stop_scene", r12)), r0), r10, null), 3, null);
        return;
    L8:
        r4 = 0;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    public final Object r(boolean r6, Continuation<? super Boolean> r7) {
        if ((r7 instanceof setPrivacyConversationContentConfig.1) == false) goto L7;
        setPrivacyConversationContentConfig.1 r0 = (setPrivacyConversationContentConfig.1) r7;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        FLogger.a.i("[ObricNetworkServiceImpl]", "setPrivacyConversationContentConfig response, " + r9);
        if ((r9 instanceof dm9.a.b) == true) goto L20;
    L22:
        r4 = false;
    L24:
        return Boxing.boxBoolean(r4);
    L20:
        if (r9.a.isSuccess() == false) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ObricUserExperiencePlanConfigApi.a r10 = ObricUserExperiencePlanConfigApi.a;
        setPrivacyConversationContentConfig.response.1 r5 = new setPrivacyConversationContentConfig.response.1(r6, null);
        r0.label = 1;
        r10.getClass();
        r8 = ObricUserExperiencePlanConfigApi.a.a(r5, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new setPrivacyConversationContentConfig.1(this, r7);
        goto L8
    }

    public final void sweepConditionalTask(ObricConditionalTaskSweepRequest r8, IFlowNetworkResultCallbackIDL r9) {
        Intrinsics.checkNotNullParameter(r8, "request");
        BuildersKt.launch$default(E(), null, null, new sweepConditionalTask.1(r8, r9, null), 3, null);
    }

    public final Object t(boolean r6, Continuation<? super Boolean> r7) {
        if ((r7 instanceof setVoiceWakeupImprovementConfig.1) == false) goto L7;
        setVoiceWakeupImprovementConfig.1 r0 = (setVoiceWakeupImprovementConfig.1) r7;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        FLogger.a.i("[ObricNetworkServiceImpl]", "setVoiceWakeupImprovementConfig response, " + r9);
        if ((r9 instanceof dm9.a.b) == true) goto L20;
    L22:
        r4 = false;
    L24:
        return Boxing.boxBoolean(r4);
    L20:
        if (r9.a.isSuccess() == false) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ObricUserExperiencePlanConfigApi.a r10 = ObricUserExperiencePlanConfigApi.a;
        setVoiceWakeupImprovementConfig.response.1 r5 = new setVoiceWakeupImprovementConfig.response.1(r6, null);
        r0.label = 1;
        r10.getClass();
        r8 = ObricUserExperiencePlanConfigApi.a.a(r5, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new setVoiceWakeupImprovementConfig.1(this, r7);
        goto L8
    }

    public static final void x(ObricNetworkServiceImpl r2, Map r3, long r4) {
        r2.getClass();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r6 = new JSONObject(r3);     // Catch: Throwable -> L5
        r6.put("request_build_duration_ms", r4);     // Catch: Throwable -> L5
        r6.put("request_started_elapsed_ms", SystemClock.elapsedRealtime());     // Catch: Throwable -> L5
        r6.put("retry_count", 0);     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r7) == false) goto L10;
        r7 = null;
    L10:
        JSONObject r8 = (JSONObject) r7;
        if (r8 == null) goto L17;
        r3.remove("flow_received_elapsed_ms");
        r3.put("__omni_network_trace_payload", r8);
        return;
    L17:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void C(String r7, Map<String, Object> r8, String r9) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L34
        if (r7 == null) goto L14;
        Map<String, Object> r2 = this.d.get(r7);     // Catch: Throwable -> L34
        if (r2 == null) goto L14;
        Object r3 = r2.get("__omni_network_trace_payload");     // Catch: Throwable -> L34
        if ((r3 instanceof JSONObject) == false) goto L12;
        JSONObject r4 = (JSONObject) r3;     // Catch: Throwable -> L34
    L13:
        if (r4 == null) goto L14;
        monitor-enter(r4);     // Catch: Throwable -> L34
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L17:
        if (r4.optBoolean("__finished") == false) goto L20;
        String r10 = null;
    L28:
        monitor-exit(r4);     // Catch: Throwable -> L34
        this.d.put(r7, MapsKt.minus(r2, "__omni_network_trace_payload"));     // Catch: Throwable -> L34
    L30:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r11) == true) goto L40;
        r0 = r11;
    L40:
        String r5 = (String) r0;
        if (r5 != null) goto L43;
        return;
    L43:
        r8.put("__omni_network_trace_payload", r5);
        return;
    L20:
        if (r9 != null) goto L22;
    L27:
        r4.put("response_finished_elapsed_ms", SystemClock.elapsedRealtime());     // Catch: Throwable -> L31
        r10 = r4.toString();     // Catch: Throwable -> L31
        r4.put("__finished", true);     // Catch: Throwable -> L31
    L22:
        if ((!StringsKt.isBlank(r9)) == true) goto L25;
        r9 = null;
    L25:
        if (r9 == null) goto L27;
        r4.put("log_id", r9);     // Catch: Throwable -> L31
        goto L27
    L12:
        r4 = null;
    L14:
        r10 = null;
    L34:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    }

    public final void d(String r11, String r12, IFlowNetworkResultCallbackIDL r13) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "passThrough");
        BuildersKt.launch$default(E(), null, null, new uploadNormalRouterByHttp.1(r11, r12, this, r13, null), 3, null);
    }

    public final void deleteConditionalTask(String r8, Map<?, ?> r9, IFlowNetworkResultCallbackIDL r10) {
        Intrinsics.checkNotNullParameter(r8, DBDefinition.TASK_ID);
        LinkedHashMap r0 = new LinkedHashMap();
        if (r9 == null) goto L8;
        Iterator<Map.Entry<?, ?>> r11 = r9.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<?, ?> r1 = r11.next();
        r0.put(String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));
    L8:
        ObricConditionalTaskDeleteRequest r12 = new ObricConditionalTaskDeleteRequest(r8, r0);
        BuildersKt.launch$default(E(), null, null, new deleteConditionalTask.2(r10, r12, null), 3, null);
    }

    public final Object k(String r12, String r13, Continuation<? super Boolean> r14) {
        if ((r14 instanceof reportODidRelation.1) == false) goto L7;
        reportODidRelation.1 r0 = (reportODidRelation.1) r14;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        reportODidRelation.1 r8 = r0;
        Object r15 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        boolean r10 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L17:
        dm9.a.b r16 = (dm9.a) r15;
        if ((r16 instanceof dm9.a.b) == true) goto L20;
    L22:
        r10 = false;
    L24:
        return Boxing.boxBoolean(r10);
    L20:
        if (((int) r16.a.getCode()) != 0) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        s r17 = new s(r12, r13);
        ObricProtocolApi.a r18 = ObricProtocolApi.a;
        reportODidRelation.response.1 r4 = new reportODidRelation.response.1(r17, null);
        r8.label = 1;
        r18.getClass();
        FlowHttpConnection r19 = FlowHttpConnection.a;
        r15 = FlowHttpConnection.g("OBRIC", ObricProtocolApi.class, r4, true, null, null, null, r8, 240);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new reportODidRelation.1(this, r14);
        goto L8
    }

    public static void H(IFlowNetworkResultCallbackIDL r3, String r4, String r5, String r6) {
        if (r3 == null) goto L5;
        r3.onResult(false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", "-1"), TuplesKt.to("msg", r4), TuplesKt.to("failure_stage", r5), TuplesKt.to("reason_code", r6)}));
        return;
    }

    public final void b(String r2, String r3, Map<String, String> r4, IFlowNetworkResultCallbackIDL r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "scene");
        c(r2, r3, r4, r5);
    }

    public final void c(String r8, String r9, Map<?, ?> r10, IFlowNetworkResultCallbackIDL r11) {
        Intrinsics.checkNotNullParameter(r8, "id");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r10 == null) goto L8;
        Iterator<Map.Entry<?, ?>> r12 = r10.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<?, ?> r1 = r12.next();
        r0.put(String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));
    L8:
        ObricUserTakeOverRequest r13 = new ObricUserTakeOverRequest(r8, r9, r0);
        BuildersKt.launch$default(E(), null, null, new takeOverChanged.2(r11, r13, null), 3, null);
    }

    public final void e(List<OPushEvent> r12, boolean r13, IFlowNetworkResultCallbackIDL r14, Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r12, "intentResult");
        BuildersKt.launch$default(E(), null, null, new uploadIntentResultForCompensationByHttp.1(this, r12, r13, r15, r14, null), 3, null);
    }

    public final void g(byte[] r12, boolean r13, IFlowNetworkResultCallbackIDL r14, Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r12, "bodyBytes");
        BuildersKt.launch$default(E(), null, null, new uploadIntentResultForAsyncNotifyByHttpOptimized.1(r12, r13, this, r15, r14, null), 3, null);
    }

    public final void l(List<OPushEvent> r12, boolean r13, IFlowNetworkResultCallbackIDL r14, Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r12, "intentResult");
        BuildersKt.launch$default(E(), null, null, new uploadIntentResultForAsyncNotifyByHttp.1(this, r12, r13, r15, r14, null), 3, null);
    }

    public final Object u(String r8, String r9, String r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof checkRomVersionCompatible.1) == false) goto L7;
        checkRomVersionCompatible.1 r0 = (checkRomVersionCompatible.1) r11;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L17:
        dm9.a.b r13 = (dm9.a) r12;
        if ((r13 instanceof dm9.a.b) == false) goto L23;
        dm9.a.b r14 = r13;
        vea.d r15 = (vea.d) r14.a.getData();
        FLogger.a.i("[ObricNetworkServiceImpl]", "checkRomVersionCompatible success, resp: " + r15 + ", raw_data: " + r14.a);
        if (r15 == null) goto L26;
        r4 = r15.a();
    L26:
        return Boxing.boxBoolean(r4);
    L23:
        if ((r13 instanceof dm9.a.a) == false) goto L28;
        FLogger.a.i("[ObricNetworkServiceImpl]", "checkRomVersionCompatible error");
        goto L26
    L28:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        c r16 = new c(r8, r9, r10);
        FLogger.a.i("[ObricNetworkServiceImpl]", "checkRomVersionCompatible: start, updateVersionCode: " + r8 + ", appVersionCode: " + r9 + ", romVersion: " + r10);
        ObricProtocolApi.a r17 = ObricProtocolApi.a;
        checkRomVersionCompatible.response.1 r18 = new checkRomVersionCompatible.response.1(r16, null);
        r0.label = 1;
        r17.getClass();
        r12 = ObricProtocolApi.a.a(r18, r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new checkRomVersionCompatible.1(this, r11);
        goto L8
    }

    public static final void z(ObricNetworkServiceImpl r7, IntentShortLinkType r8, String r9, int r10, dm9.a r11) {
        r7.getClass();
        int r12 = d.a[r8.ordinal()];
        if (r12 != 1) goto L5;
        String r13 = "/assistant/func_call/callback";
    L13:
        String r0 = r13;
        boolean r14 = r11 instanceof dm9.a.a;
        if (r14 == false) goto L17;
        int r1 = ((dm9.a.a) r11).a;
    L20:
        if (r14 == false) goto L24;
        String r15 = ((dm9.a.a) r11).b;
    L22:
        String r5 = r15;
        Map<String, Object> r16 = r7.K(r9);
        if (r16 == null) goto L32;
        Map r17 = MapsKt.toMutableMap(r16);
        if (r17 == null) goto L32;
        r17.put("retry_count", Integer.valueOf(r10));
    L33:
        Map r6 = r17;
        int r18 = xea.a.a;
        xea.a.a(r0, r9, Integer.valueOf(r7.isNetworkAvailable() ? 1 : 0), Integer.valueOf(r10), Integer.valueOf(r1), r5, r6);
        return;
    L32:
        r17 = null;
        goto L33
    L24:
        if ((r11 instanceof dm9.a.b) == false) goto L26;
        r15 = ((dm9.a.b) r11).a.getMsg();
        goto L22
    L26:
        r15 = "";
        goto L22
    L17:
        if ((r11 instanceof dm9.a.b) == false) goto L19;
        r1 = (int) ((dm9.a.b) r11).a.getCode();
        goto L20
    L19:
        r1 = -1;
        goto L20
    L5:
        if (r12 != 2) goto L7;
        r13 = "/assistant/func_call/notify";
        goto L13
    L7:
        if (r12 != 3) goto L10;
        r13 = "/assistant/normal/router";
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void o(long r11, String r13, String r14, Map<?, ?> r15, IFlowNetworkResultCallbackIDL r16) {
        Intrinsics.checkNotNullParameter(r13, "askContent");
        Intrinsics.checkNotNullParameter(r14, "userAnswer");
        LinkedHashMap r5 = new LinkedHashMap();
        if (r15 == null) goto L8;
        Iterator<Map.Entry<?, ?>> r0 = r15.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<?, ?> r1 = r0.next();
        r5.put(String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));
    L8:
        Long r2 = Long.valueOf(r11);
        Long r3 = Long.valueOf(F());
        String r7 = o.a.getDeviceId();
        if (r7.length() <= 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L14;
        long r9 = CastLongProtector.parseLong(r7);
    L15:
        BuildersKt.launch$default(E(), null, null, new replyAskUser.2(r16, new vea.b(r2, r13, r14, r5, new vea.a(r3, Long.valueOf(r9), Long.valueOf(AppHost.a.getUpdateVersionCode()))), null), 3, null);
        return;
    L14:
        r9 = 0;
        goto L15
    L11:
        r8 = false;
        goto L12
    }

    public final void G(IntentShortLinkType r21, String r22, boolean r23, dm9.a<? extends Object> r24, IFlowNetworkResultCallbackIDL r25, String r26) {
        LinkedHashMap r6 = new LinkedHashMap();
        if ((r24 instanceof dm9.a.a) == false) goto L27;
        dm9.a.a r3 = (dm9.a.a) r24;
        FLogger.a.e("[ObricNetworkServiceImpl]", "tryUploadIntentResultByHttp: needRetry: " + r23 + ", api error:", r3.c);
        if (r23 == true) goto L75;
        r6.put("code", Integer.valueOf(r3.a));
        r6.put("msg", r3.b);
        C(r22, r6, r26);
        if (r22 == null) goto L9;
        i r1 = this.b.remove(r22);
    L9:
        if (r25 == null) goto L11;
        r25.onResult(false, r6);
    L11:
        int r2 = d.a[r21.ordinal()];
        if (r2 != 1) goto L14;
        String r4 = "/assistant/func_call/callback";
    L22:
        if (r22 == null) goto L24;
        Map<String, Object> r7 = K(r22);
    L25:
        int r5 = xea.a.a;
        xea.a.a(r4, r22, Integer.valueOf(isNetworkAvailable() ? 1 : 0), 0, Integer.valueOf(r3.a), r3.b, r7);
        return;
    L24:
        r7 = null;
        goto L25
    L14:
        if (r2 != 2) goto L16;
        r4 = "/assistant/func_call/notify";
        goto L22
    L16:
        if (r2 != 3) goto L19;
        r4 = "/assistant/normal/router";
        goto L22
    L19:
        throw new NoWhenBranchMatchedException();
    L75:
        return;
    L27:
        if ((r24 instanceof dm9.a.b) == false) goto L74;
        dm9.a.b r8 = (dm9.a.b) r24;
        if (((int) r8.a.getCode()) == 0) goto L52;
        FLogger.a.e("[ObricNetworkServiceImpl]", "tryUploadIntentResultByHttp: needRetry: " + r23 + ", api code error: " + r8.a, r8.b);
        if (r23 == true) goto L77;
        r6.put("code", Long.valueOf(r8.a.getCode()));
        r6.put("msg", String.valueOf(r8.a.getMsg()));
        C(r22, r6, r26);
        if (r22 == null) goto L35;
        i r9 = this.b.remove(r22);
    L35:
        if (r25 == null) goto L37;
        r25.onResult(false, r6);
    L37:
        int r10 = d.a[r21.ordinal()];
        if (r10 != 1) goto L40;
        String r11 = "/assistant/func_call/callback";
    L48:
        if (r22 == null) goto L50;
        Map<String, Object> r17 = K(r22);
    L51:
        int r12 = xea.a.a;
        xea.a.a(r11, r22, Integer.valueOf(isNetworkAvailable() ? 1 : 0), 0, Integer.valueOf((int) r8.a.getCode()), r8.a.getMsg(), r17);
        return;
    L50:
        r17 = null;
        goto L51
    L40:
        if (r10 != 2) goto L42;
        r11 = "/assistant/func_call/notify";
        goto L48
    L42:
        if (r10 != 3) goto L45;
        r11 = "/assistant/normal/router";
        goto L48
    L45:
        throw new NoWhenBranchMatchedException();
    L77:
        return;
    L52:
        if (r22 == null) goto L54;
        i r13 = this.b.remove(r22);
    L54:
        r6.put("code", Long.valueOf(r8.a.getCode()));
        r6.put("msg", String.valueOf(r8.a.getMsg()));
        C(r22, r6, r26);
        if (r25 == null) goto L57;
        r25.onResult(true, r6);
    L57:
        FLogger.a.i("[ObricNetworkServiceImpl]", "tryUploadIntentResultByHttp: needRetry: " + r23 + ", success, response = " + r24);
        int r14 = d.a[r21.ordinal()];
        if (r14 != 1) goto L60;
        String r15 = "/assistant/func_call/callback";
    L68:
        if (r22 == null) goto L70;
        Map<String, Object> r18 = K(r22);
    L71:
        int r16 = xea.a.a;
        xea.a.a(r15, r22, Integer.valueOf(isNetworkAvailable() ? 1 : 0), 0, Integer.valueOf((int) r8.a.getCode()), r8.a.getMsg(), r18);
        return;
    L70:
        r18 = null;
        goto L71
    L60:
        if (r14 != 2) goto L62;
        r15 = "/assistant/func_call/notify";
        goto L68
    L62:
        if (r14 != 3) goto L65;
        r15 = "/assistant/normal/router";
        goto L68
    L65:
        throw new NoWhenBranchMatchedException();
    L74:
        throw new NoWhenBranchMatchedException();
    }

    public final void J(IntentShortLinkType r14, String r15, int r16, IFlowNetworkResultCallbackIDL r17, dm9.a r18, String r19) {
        if (r15 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(E(), null, null, new pendingRetry.1(this, r15, r14, r16, r18, r19, r17, null), 3, null);
    }

    public final void uploadOmniScreenshotByHttp(String r14, String r15, int r16, String r17, String r18, String r19, String r20, List<String> r21, String r22, String r23, IFlowNetworkResultCallbackIDL r24) {
        b r0 = null;
        if (r17 != null) goto L5;
    L10:
        L("uploadOmniScreenshotByHttp", r14, r15, r16, CollectionsKt.listOfNotNull(r0), r19, r20, r21, r22, r23, null, r24);
        return;
    L5:
        if ((!StringsKt.isBlank(r17)) == false) goto L7;
        String r2 = r17;
    L8:
        if (r2 == null) goto L10;
        r0 = new b(null, r2, r18);
        goto L10
    L7:
        r2 = null;
        goto L8
    }

    public final void L(String r21, String r22, String r23, int r24, List<b> r25, String r26, String r27, List<String> r28, String r29, String r30, Boolean r31, IFlowNetworkResultCallbackIDL r32) {
        if (r22 != null) goto L5;
        String r7 = "";
    L6:
        if (r23 != null) goto L8;
        String r8 = "";
    L9:
        boolean r9 = r25.isEmpty();
        if (StringsKt.isBlank(r7) == true) goto L17;
        if (r9 == false) goto L13;
    L15:
        BuildersKt.launch$default(E(), null, null, new uploadOmniDataFeedbackInternal.1(r25, this, r21, r32, r31, r7, r8, r9, r24, r26, r27, r28, r29, r30, null), 3, null);
        return;
    L13:
        if (StringsKt.isBlank(r8) == false) goto L15;
    L17:
        H(r32, "taskId is blank or toolId is blank for data feedback upload", "host_validate", "host_invalid_argument");
        return;
    L8:
        r8 = r23;
        goto L9
    L5:
        r7 = r22;
        goto L6
    }

    public final void uploadOmniScreenshotByHttpV2(String r14, String r15, int r16, String r17, String r18, String r19, String r20, List<String> r21, String r22, String r23, boolean r24, IFlowNetworkResultCallbackIDL r25) {
        b r0 = null;
        if (r17 != null) goto L5;
    L10:
        L("uploadOmniScreenshotByHttpV2", r14, r15, r16, CollectionsKt.listOfNotNull(r0), r19, r20, r21, r22, r23, Boolean.valueOf(r24), r25);
        return;
    L5:
        if ((!StringsKt.isBlank(r17)) == false) goto L7;
        String r2 = r17;
    L8:
        if (r2 == null) goto L10;
        r0 = new b(null, r2, r18);
        goto L10
    L7:
        r2 = null;
        goto L8
    }

    public final void uploadOmniDataFeedbackByHttp(String r14, String r15, int r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, List<String> r25, String r26, String r27, IFlowNetworkResultCallbackIDL r28) {
        ArrayList r5 = new ArrayList();
        String r0 = null;
        if (r17 != null) goto L5;
    L10:
        if (r19 != null) goto L12;
    L17:
        if (r21 != null) goto L19;
    L23:
        L("uploadOmniDataFeedbackByHttp", r14, r15, r16, r5, r23, r24, r25, r26, r27, null, r28);
        return;
    L19:
        if ((!StringsKt.isBlank(r21)) == false) goto L21;
        r0 = r21;
    L21:
        if (r0 == null) goto L23;
        r5.add(new b(OmniUploadPayloadKind.REACT_VIEW_TREE, r0, r22));
        goto L23
    L12:
        if ((!StringsKt.isBlank(r19)) == false) goto L14;
        String r1 = r19;
    L15:
        if (r1 == null) goto L17;
        r5.add(new b(OmniUploadPayloadKind.VIEW_TREE, r1, r20));
        goto L17
    L14:
        r1 = null;
        goto L15
    L5:
        if ((!StringsKt.isBlank(r17)) == false) goto L7;
        String r2 = r17;
    L8:
        if (r2 == null) goto L10;
        r5.add(new b(OmniUploadPayloadKind.IMAGE, r2, r18));
        goto L10
    L7:
        r2 = null;
        goto L8
    }

    public final void createConditionalTask(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, Map<?, ?> r32, IFlowNetworkResultCallbackIDL r33) {
        Intrinsics.checkNotNullParameter(r18, DBDefinition.TASK_ID);
        LinkedHashMap r13 = new LinkedHashMap();
        if (r32 == null) goto L8;
        Iterator<Map.Entry<?, ?>> r0 = r32.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<?, ?> r1 = r0.next();
        r13.put(String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));
    L8:
        ObricConditionalTaskCreateRequest r2 = new ObricConditionalTaskCreateRequest(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r13, r29, r30, r31);
        BuildersKt.launch$default(E(), null, null, new createConditionalTask.2(r33, r2, null), 3, null);
    }

    public final void uploadOmniDataFeedbackByHttpV2(String r14, String r15, int r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, List<String> r25, String r26, String r27, boolean r28, IFlowNetworkResultCallbackIDL r29) {
        ArrayList r5 = new ArrayList();
        String r0 = null;
        if (r17 != null) goto L5;
    L10:
        if (r19 != null) goto L12;
    L17:
        if (r21 != null) goto L19;
    L23:
        L("uploadOmniDataFeedbackByHttpV2", r14, r15, r16, r5, r23, r24, r25, r26, r27, Boolean.valueOf(r28), r29);
        return;
    L19:
        if ((!StringsKt.isBlank(r21)) == false) goto L21;
        r0 = r21;
    L21:
        if (r0 == null) goto L23;
        r5.add(new b(OmniUploadPayloadKind.REACT_VIEW_TREE, r0, r22));
        goto L23
    L12:
        if ((!StringsKt.isBlank(r19)) == false) goto L14;
        String r1 = r19;
    L15:
        if (r1 == null) goto L17;
        r5.add(new b(OmniUploadPayloadKind.VIEW_TREE, r1, r20));
        goto L17
    L14:
        r1 = null;
        goto L15
    L5:
        if ((!StringsKt.isBlank(r17)) == false) goto L7;
        String r2 = r17;
    L8:
        if (r2 == null) goto L10;
        r5.add(new b(OmniUploadPayloadKind.IMAGE, r2, r18));
        goto L10
    L7:
        r2 = null;
        goto L8
    }
}
