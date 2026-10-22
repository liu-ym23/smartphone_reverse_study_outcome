package com.obric.memorydata.middleware.impl.network;

import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.Ensure;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.HttpMethod;
import com.obric.memorydata.middleware.api.bridge.HttpRequest;
import com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.Response;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.rpc.AppNetConfig;
import com.obric.memorydata.middleware.impl.image.ImageUploadEntity;
import com.obric.memorydata.middleware.impl.image.ImageXBizType;
import com.obric.memorydata.middleware.impl.image.m;
import com.obric.memorydata.middleware.impl.network.rpc.GlobalRpcInterceptor;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.u;
import com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001TB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0000H\u0007J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0017J$\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J3\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0016J\"\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050/H\u0002J\u0016\u00100\u001a\u00020\u001a2\f\u00101\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010\u001a2\u0006\u00103\u001a\u00020\u0005H\u0002J\u0018\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0016J\u0010\u00107\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u00107\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0005H\u0016J\u000e\u00108\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u00108\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014H\u0002J\u0018\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0016\u0010?\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0007J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005H\u0016J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0016J\u0018\u0010B\u001a\u00020:2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010E\u001a\u00020:2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010F\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0016J\u0010\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020JH\u0002J\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00020M0L2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020OH\u0002J\u0016\u0010P\u001a\u00020\u001c2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020M0LH\u0002J\u0012\u0010R\u001a\u0004\u0018\u00010\u001a2\u0006\u0010S\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/NetworkBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/INetworkBridgeAPI;", "<init>", "()V", "TAG", "", "ERROR_NETWORK", "", "ERROR_INVALID_RESPONSE", "ERROR_JSON_PARSE_ERROR", "ERROR_CRONET_IO_EXCEPTION", "ERROR_INVALID_REQUEST", "ERROR_IO_EXCEPTION", "ERROR_CONTENT_FILTER", "ERROR_STREAM_CANCELLED", "ERROR_FORNAX", "STATUS_RUNNING", "STATUS_FINISHED", "sseSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/middleware/impl/network/NetworkBridgeAPIImpl$StreamSession;", "sseTaskBindings", "Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry;", "getInst", "send", "requestJson", "Lorg/json/JSONObject;", "sendRequest", "Lcom/obric/memorydata/middleware/api/bridge/Response;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/middleware/api/bridge/HttpRequest;", "uploadImageX", "uri", "sourcePackage", "bizName", "resize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "uploadAuditoryWavImageX", "taskId", "accountScope", "AUDITORY_UPLOAD_DIRECTORY", "AUDITORY_TASK_ID_REGEX", "Lkotlin/text/Regex;", "mapToHeaderList", "", "Lcom/bytedance/retrofit2/client/Header;", "headerMap", "", "header2JsonObject", "headers", "buildLogIdExtras", "logId", "getImageBase64", "entityId", "imageUri", "startSSE", "startSSEInternal", "readSseLoop", "", "session", "readSSENext", "streamId", "timeoutMs", "readSSENextInternal", "abortSSE", "abortSSEByTaskId", "beginSSETaskInvocation", "invocationId", "", "endSSETaskInvocation", "abortSSEByTaskInvocationTimeout", "abortSSEByTaskTimeout", "abortSseTargets", "targets", "Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry$CancellationTargets;", "createApiCall", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "forceAcceptSse", "", "executeCall", NotificationCompat.CATEGORY_CALL, "parseEscapedJson", "input", "StreamSession", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkBridgeAPIImpl implements INetworkBridgeAPI {
    private static final Regex AUDITORY_TASK_ID_REGEX = null;
    private static final String AUDITORY_UPLOAD_DIRECTORY = "auditory_memory";
    private static final int ERROR_CONTENT_FILTER = -7;
    private static final int ERROR_CRONET_IO_EXCEPTION = -4;
    private static final int ERROR_FORNAX = -10;
    private static final int ERROR_INVALID_REQUEST = -5;
    private static final int ERROR_INVALID_RESPONSE = -2;
    private static final int ERROR_IO_EXCEPTION = -6;
    private static final int ERROR_JSON_PARSE_ERROR = -3;
    private static final int ERROR_NETWORK = -1;
    private static final int ERROR_STREAM_CANCELLED = -8;
    public static final NetworkBridgeAPIImpl INSTANCE = null;
    private static final String STATUS_FINISHED = "finished";
    private static final String STATUS_RUNNING = "running";
    private static final String TAG = "NetworkBridgeAPIImpl";
    private static final ConcurrentHashMap<String, a> sseSessions = null;
    private static final f sseTaskBindings = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/NetworkBridgeAPIImpl$StreamSession;", "", NotificationCompat.CATEGORY_CALL, "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "reader", "Ljava/io/BufferedReader;", "<init>", "(Lcom/bytedance/retrofit2/Call;Ljava/io/BufferedReader;)V", "getCall", "()Lcom/bytedance/retrofit2/Call;", "getReader", "()Ljava/io/BufferedReader;", "queue", "Ljava/util/concurrent/LinkedBlockingQueue;", "", "getQueue", "()Ljava/util/concurrent/LinkedBlockingQueue;", NetworkBridgeAPIImpl.STATUS_FINISHED, "", "getFinished", "()Z", "setFinished", "(Z)V", "code", "", "getCode", "()I", "setCode", "(I)V", NotificationCompat.CATEGORY_MESSAGE, "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Call<TypedInput> f11756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BufferedReader f11757b;
        private final LinkedBlockingQueue<String> c;
        private volatile boolean d;
        private volatile int e;
        private volatile String f;

        public a(Call<TypedInput> r3, BufferedReader r4) {
            Call<TypedInput> r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r4, "reader");
            this.f11756a = r5;
            this.f11757b = r4;
            this.c = new LinkedBlockingQueue();
        }

        public final Call<TypedInput> a() {
            return this.f11756a;
        }

        public final void a(int r1) {
            this.e = r1;
        }

        public final void a(String r1) {
            this.f = r1;
        }

        public final void a(boolean r1) {
            this.d = r1;
        }

        public final BufferedReader b() {
            return this.f11757b;
        }

        public final LinkedBlockingQueue<String> c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public final String f() {
            return this.f;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11758a = null;

        static {
            int[] r0 = new int[HttpMethod.values().length];
            r0[HttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[HttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11758a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.network.NetworkBridgeAPIImpl$uploadImageX$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.middleware.impl.network.NetworkBridgeAPIImpl$uploadImageX$1", f = "NetworkBridgeAPIImpl.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
        final /* synthetic */ ImageXBizType $bizType;
        final /* synthetic */ Integer $resize;
        final /* synthetic */ String $sourcePackage;
        final /* synthetic */ String $uri;
        int label;

        AnonymousClass1(ImageXBizType r3, String r4, String r5, Integer r6, Continuation<? super AnonymousClass1> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$bizType = r3;
            this.$uri = r4;
            this.$sourcePackage = r5;
            this.$resize = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$bizType, this.$uri, this.$sourcePackage, this.$resize, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super String> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            m.a r2 = m.f11745a;
            ImageXBizType r10 = this.$bizType;
            Uri r3 = Uri.parse(this.$uri);
            String r4 = this.$sourcePackage;
            Integer r5 = this.$resize;
            Continuation<? super String> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r9 = r2.a(r10, r3, r4, r5, r6);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    static {
        INSTANCE = new NetworkBridgeAPIImpl();
        RetrofitUtils.b(AppNetConfig.INSTANCE.getBaseUrl()).interceptors().add(new GlobalRpcInterceptor());
        sseSessions = new ConcurrentHashMap();
        sseTaskBindings = new f(0, 1, null);
        AUDITORY_TASK_ID_REGEX = new Regex("[A-Za-z0-9_-]{1,80}");
    }

    private NetworkBridgeAPIImpl() {
    }

    private final void abortSseTargets(f.a r4) {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Function0) ZeusTransformUtils.preCheckCast(r3.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
        goto L4
    L6:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        INSTANCE.abortSSE(r6);
        goto L8
    }

    private final JSONObject buildLogIdExtras(String r3) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return null;
    L6:
        JSONObject r2 = new JSONObject();
        JSONObject r0 = new JSONObject();
        r0.put("x-tt-logid", r3);
        Unit r4 = Unit.INSTANCE;
        r2.put("headers", r0);
        return r2;
    }

    private final Call<TypedInput> createApiCall(HttpRequest r15, boolean r16) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r15.getHost(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = AppNetConfig.INSTANCE.getBaseUrl();
    L5:
        Retrofit r1 = RetrofitUtils.b((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L59;
        List<Interceptor> r2 = r1.interceptors();
        Intrinsics.checkNotNull(r2);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        boolean r5 = false;
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L10;
    L12:
        Iterator r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L11;
        if (ZeusTransformUtils.instanceOf((Interceptor) ZeusTransformUtils.preCheckCast(r4.next(), Interceptor.class, "com.obric.memorydata.plugin"), GlobalRpcInterceptor.class) == false) goto L14;
        boolean r6 = true;
    L19:
        if (r15.getAddAuthHeader() == false) goto L23;
        if (r6 == true) goto L23;
        r2.add(new GlobalRpcInterceptor());
    L23:
        if (r15.getAddAuthHeader() == true) goto L26;
        if (r6 == false) goto L26;
        final $$Lambda$NetworkBridgeAPIImpl$bZon3BA_EISJakS_2CFVp1UBuo r7 = $$Lambda$NetworkBridgeAPIImpl$bZon3BA_EISJakS_2CFVp1UBuo.INSTANCE;
        r2.removeIf(new $$Lambda$NetworkBridgeAPIImpl$r4HHUY6UdrCSXK1vQREEIyejqvY(r7));
    L26:
        List<Header> r10 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(mapToHeaderList(r15.getHeaders()), Collection.class, "com.obric.memorydata.plugin"));
        if (r16 == false) goto L40;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L31;
    L33:
        Iterator r9 = r8.iterator();
    L35:
        if (r9.hasNext() == false) goto L32;
        if (StringsKt.equals(((Header) ZeusTransformUtils.preCheckCast(r9.next(), Header.class, "com.obric.memorydata.plugin")).getName(), "Accept", true) == false) goto L35;
    L38:
        if (r5 == false) goto L40;
        r10.add(new Header("Accept", "text/event-stream"));
    L32:
        r5 = true;
        goto L38
    L31:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L33;
    L40:
        com.bytedance.ttnet.b.d r11 = new com.bytedance.ttnet.b.d();
        r11.c = r15.getConnectTimeout();
        r11.d = r15.getReadTimeout();
        r11.e = r15.getWriteTimeout();
        RetrofitApi r12 = (RetrofitApi) ZeusTransformUtils.preCheckCast(r1.create(RetrofitApi.class), RetrofitApi.class, "com.obric.memorydata.plugin");
        HttpMethod r13 = r15.getMethod();
        int[] r14 = b.f11758a;
        int r17 = r13.ordinal();
        if (r16 == false) goto L50;
        int r18 = r14[r17];
        if (r18 == 1) goto L49;
        if (r18 != 2) goto L47;
        boolean r19 = r15.getAddAuthHeader();
        String r20 = r15.getPath();
        Map<String, String> r110 = r15.getQueryParams();
        JsonObject r111 = JsonParser.parseString(r15.getPostBody().toString()).getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r111, "getAsJsonObject(...)");
        return r12.postWithStreaming(r19, r20, r10, r110, r111, r11);
    L47:
        throw new NoWhenBranchMatchedException();
    L49:
        return r12.getWithStreaming(r15.getAddAuthHeader(), r15.getPath(), r10, r15.getQueryParams(), r11);
    L50:
        int r21 = r14[r17];
        if (r21 == 1) goto L57;
        if (r21 != 2) goto L55;
        boolean r22 = r15.getAddAuthHeader();
        String r23 = r15.getPath();
        Map<String, String> r112 = r15.getQueryParams();
        JsonObject r113 = JsonParser.parseString(r15.getPostBody().toString()).getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r113, "getAsJsonObject(...)");
        return r12.post(r22, r23, r10, r112, r113, r11);
    L55:
        throw new NoWhenBranchMatchedException();
    L57:
        return r12.get(r15.getAddAuthHeader(), r15.getPath(), r10, r15.getQueryParams(), r11);
    L11:
        r6 = false;
        goto L19
    L10:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L12;
    L59:
        throw new IllegalStateException("network retrofit is not initialized");
    }

    private static final boolean createApiCall$lambda$17(Interceptor r2) {
        return ZeusTransformUtils.instanceOf((Interceptor) ZeusTransformUtils.wrapperContextForParams(r2, Interceptor.class, "com.obric.memorydata.plugin"), GlobalRpcInterceptor.class);
    }

    private static final boolean createApiCall$lambda$18(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final Response executeCall(Call<TypedInput> r18) {
        SsResponse r0 = ((Call) ZeusTransformUtils.wrapperContextForParams(r18, Call.class, "com.obric.memorydata.plugin")).execute();     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        List<Header> r3 = r0.headers();     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        Intrinsics.checkNotNull(r3);     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        JSONObject r4 = header2JsonObject(r3);     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        JSONObject r8 = new JSONObject();     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        r8.put("headers", r4);     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        if (r0.isSuccessful() == false) goto L23;
        InputStream r1 = ((TypedInput) ZeusTransformUtils.preCheckCast(r0.body(), TypedInput.class, "com.obric.memorydata.plugin")).in();     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        Intrinsics.checkNotNullExpressionValue(r1, "in(...)");     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        String r2 = TextStreamsKt.readText((Reader) ZeusTransformUtils.preCheckCast(new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r1, Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin")), Reader.class, "com.obric.memorydata.plugin"));     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        JSONObject r5 = parseEscapedJson(r2);     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        if (r5 != null) goto L9;
        Ensure.ensureNotReachHere("HttpRequest return invalid response " + r2);     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        return new Response(-2, "invalid response " + r2, null, r8, 4, null);
    L9:
        int r6 = r5.optInt("code");     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        String r7 = r5.optString(NotificationCompat.CATEGORY_MESSAGE);     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        JSONObject r9 = r5.optJSONObject("data");     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        if (r9 != null) goto L21;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        if (r10 != null) goto L14;
    L17:
        boolean r11 = true;
    L18:
        if (r11 == false) goto L21;
        return new Response(0, "success", r5, r8);
    L14:
        if (r10.length() == 0) goto L17;
        r11 = false;
    L21:
        Intrinsics.checkNotNull(r7);     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        return new Response(r6, r7, r9, r8);
    L23:
        int r12 = r0.raw().getStatus();     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        String r13 = r0.raw().getReason();     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        Intrinsics.checkNotNullExpressionValue(r13, "getReason(...)");     // Catch: NetworkNotAvailabeException -> L25 CronetIOException -> L28
        return new Response(r12, r13, null, r8, 4, null);
    L28:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.frameworks.baselib.network.http.b r14 = e.getRequestInfo();
        HttpResponseException r15 = null;
        if (r14 == null) goto L32;
        String r16 = r14.P;
    L34:
        if (r16 != null) goto L36;
        r16 = "";
    L36:
        JSONObject r17 = buildLogIdExtras(r16);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "cronet exception: status code = " + e.getStatusCode() + ", cronet error code = " + e.getCronetInternalErrorCode() + ", logid=" + r16 + ", error = " + e.getMessage(), null, 4, null);
        if (e.getCronetInternalErrorCode() == 0) goto L39;
        int r19 = e.getCronetInternalErrorCode();
    L40:
        int r20 = r19;
        Throwable r21 = e.getCause();
        if (ZeusTransformUtils.instanceOf(r21, HttpResponseException.class) == false) goto L43;
        r15 = (HttpResponseException) ZeusTransformUtils.preCheckCast(r21, HttpResponseException.class, "com.obric.memorydata.plugin");
    L43:
        if (r15 == null) goto L53;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "http response exception: status code = " + r15.getStatusCode() + ", error = " + r15.getErrorResponse(), null, 4, null);
        int r22 = r15.getStatusCode();
        String r23 = r15.getErrorResponse();
        if (r23 != null) goto L49;
        r23 = r15.getMessage();
        if (r23 != null) goto L49;
        String r24 = "";
    L51:
        return new Response(r22, r24, null, r17, 4, null);
    L49:
        r24 = r23;
        goto L51
    L53:
        return new Response(r20, "invalid response cronet error code: " + e.getCronetInternalErrorCode() + " error: " + e.getCause(), null, r17, 4, null);
    L39:
        r19 = -4;
        goto L40
    L32:
        r16 = null;
    L25:
        e = move-exception;
        e.printStackTrace();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "http exception: " + e.getMessage(), null, 4, null);
        return new Response(-1, "network not available", null, null, 12, null);
    }

    @JvmStatic
    public static final NetworkBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    private final JSONObject header2JsonObject(List<Header> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        JSONObject r7 = new JSONObject();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        Header r1 = (Header) ZeusTransformUtils.preCheckCast(r8.next(), Header.class, "com.obric.memorydata.plugin");
        if (StringsKt.equals(r1.getName(), "X-Tt-Logid", true) == false) goto L8;
        String r2 = "x-tt-logid";
    L9:
        r7.put(r2, r1.getValue());
        goto L4
    L8:
        r2 = r1.getName();
        goto L9
    L10:
        return r7;
    }

    /* JADX INFO: renamed from: lambda$Ku6-zKdVH3AW6IkcriXlKAdfnCQ, reason: not valid java name */
    public static /* synthetic */ Response m1022lambda$Ku6zKdVH3AW6IkcriXlKAdfnCQ(JSONObject r0, String r1, e.b r2) {
        return startSSEInternal$lambda$10(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$bZon3BA_EI-SJakS_2CFVp1UBuo, reason: not valid java name */
    public static /* synthetic */ boolean m1023lambda$bZon3BA_EISJakS_2CFVp1UBuo(Interceptor r0) {
        return createApiCall$lambda$17(r0);
    }

    public static /* synthetic */ Unit lambda$mlHXk7dG_yF_vG8YSpadUxNRdJE(a r0) {
        return startSSEInternal$lambda$10$lambda$6(r0);
    }

    public static /* synthetic */ boolean lambda$r4HHUY6UdrCSXK1vQREEIyejqvY(Function1 r0, Object r1) {
        return createApiCall$lambda$18(r0, r1);
    }

    private final List<Header> mapToHeaderList(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        List<Header> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r7 = r4.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r6.add(new Header((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        return r6;
    }

    private final JSONObject parseEscapedJson(String r4) {
        int r3 = 0;
        Object r5 = r4;
    L4:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L12;
        if (r3 >= 20) goto L12;
        r3 = r3 + 1;
        Object r0 = new JSONTokener((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")).nextValue();
        if (Intrinsics.areEqual(r0, r5) == true) goto L12;
        Intrinsics.checkNotNull(r0);
        r5 = r0;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == true) goto L14;
        return null;
    L14:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin");
    }

    private final void readSseLoop(a r9) {
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L34 IOException -> L36 TTRequestCanceledException -> L38
    L5:
        if (r9.e() != 0) goto L47;
        String r3 = r9.b().readLine();     // Catch: Throwable -> L34 IOException -> L36 TTRequestCanceledException -> L38
        boolean r4 = true;
        boolean r5 = false;
        if (r3 == null) goto L9;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L20;
        if (StringsKt.startsWith$default(r3, ParameterizedMessage.ERROR_MSG_SEPARATOR, false, 2, null) == true) goto L5;
        if (StringsKt.startsWith$default(r3, "data:", false, 2, null) == false) goto L5;
        RunLog.INSTANCE.debug(TAG, "====== read line " + r3);     // Catch: Throwable -> L34 IOException -> L36 TTRequestCanceledException -> L38
        r2.append(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.removePrefix(r3, (CharSequence) ZeusTransformUtils.preCheckCast("data:", CharSequence.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin")).toString()).append('\n');     // Catch: Throwable -> L34 IOException -> L36 TTRequestCanceledException -> L38
        goto L5
    L20:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L23;
        r4 = false;
    L23:
        if (r4 == false) goto L5;
        r9.c().offer(r2.toString());     // Catch: Throwable -> L34 IOException -> L36 TTRequestCanceledException -> L38
        StringsKt.clear(r2);     // Catch: Throwable -> L34 IOException -> L36 TTRequestCanceledException -> L38
        goto L5
    L17:
        r6 = false;
        goto L18
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        r5 = true;
    L11:
        if (r5 == false) goto L13;
        r9.c().offer(r2.toString());     // Catch: Throwable -> L34 IOException -> L36 TTRequestCanceledException -> L38
        StringsKt.clear(r2);     // Catch: Throwable -> L34 IOException -> L36 TTRequestCanceledException -> L38
    L13:
        r9.a(true);     // Catch: Throwable -> L34 IOException -> L36 TTRequestCanceledException -> L38
    L47:
        r9.b().close();     // Catch: Exception -> L43
        return;
    L64:
        return;
    L34:
        th = move-exception;
        r9.b().close();     // Catch: Exception -> L44
    L42:
        throw th;
    L38:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "readSseLoop canceled", false, 4, null);     // Catch: Throwable -> L34
        r9.a(-8);     // Catch: Throwable -> L34
        r9.a("sse stream cancelled");     // Catch: Throwable -> L34
    L36:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "readSseLoop error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L34
        e.printStackTrace();     // Catch: Throwable -> L34
        r9.a(-6);     // Catch: Throwable -> L34
        r9.a("io exception: " + e.getMessage());     // Catch: Throwable -> L34
        goto L47
    }

    private final Response startSSEInternal(final JSONObject r9, final String r10) {
        RunLog.INSTANCE.debug(TAG, "startSSE request: " + r9);
        return (Response) ZeusTransformUtils.preCheckCast(e.a(e.f11767a, 0, new $$Lambda$NetworkBridgeAPIImpl$Ku6zKdVH3AW6IkcriXlKAdfnCQ(r9, r10), 1, null), Response.class, "com.obric.memorydata.plugin");
    }

    private static final Response startSSEInternal$lambda$10(JSONObject r25, String r26, e.b r27) {
        e.b r2 = (e.b) ZeusTransformUtils.wrapperContextForParams(r27, e.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$this$call");
        GsonUtil r4 = GsonUtil.INSTANCE;
        String r5 = r25.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        Object r6 = r4.getGSON().fromJson(r5, HttpRequest.class);     // Catch: Exception -> L5
    L7:
        HttpRequest r7 = (HttpRequest) ZeusTransformUtils.preCheckCast(r6, HttpRequest.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "invalid request " + r25, null, 4, null);
        return new Response(-5, "invalid request", null, null, 12, null);
    L10:
        NetworkBridgeAPIImpl r8 = INSTANCE;
        boolean r9 = true;
        Call<TypedInput> r10 = r8.createApiCall(r7, true);
        KFunction r11 = (KFunction) ZeusTransformUtils.preCheckCast(new NetworkBridgeAPIImpl$startSSEInternal$1$cancelCall$1(r10), KFunction.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L13;
        f.b r12 = sseTaskBindings.a(r26, (Function0) ZeusTransformUtils.preCheckCast(r11, Function0.class, "com.obric.memorydata.plugin"));
    L15:
        if (r26 == null) goto L106;
        if (r12 != null) goto L106;
        r10.cancel();
        return new Response(-8, "task " + r26 + " cancelled", null, null, 12, null);
    L106:
        SsResponse<TypedInput> r13 = r10.execute();     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        List<Header> r14 = r13.headers();     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        JSONObject r15 = r8.header2JsonObject(r14);     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        r16.put("headers", r15);     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        if (r13.isSuccessful() == true) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startSSE failed, code: " + r13.raw().getStatus() + ", reason: " + r13.raw().getReason(), null, 4, null);     // Catch: IOException -> L23 CronetIOException -> L25 Throwable -> L49 NetworkNotAvailabeException -> L69
        int r17 = r13.raw().getStatus();     // Catch: IOException -> L23 CronetIOException -> L25 Throwable -> L49 NetworkNotAvailabeException -> L69
        String r18 = r13.raw().getReason();     // Catch: IOException -> L23 CronetIOException -> L25 Throwable -> L49 NetworkNotAvailabeException -> L69
        Intrinsics.checkNotNullExpressionValue(r18, "getReason(...)");     // Catch: IOException -> L23 CronetIOException -> L25 Throwable -> L49 NetworkNotAvailabeException -> L69
        Response r3 = new Response(r17, r18, null, r16, 4, null);     // Catch: IOException -> L23 CronetIOException -> L25 Throwable -> L49 NetworkNotAvailabeException -> L69
    L22:
        Response r1 = r3;
    L43:
        if (r12 == null) goto L113;
    L44:
        sseTaskBindings.a(r12);
        return r1;
    L113:
        return r1;
    L28:
        InputStream r19 = ((TypedInput) ZeusTransformUtils.preCheckCast(r13.body(), TypedInput.class, "com.obric.memorydata.plugin")).in();     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        Intrinsics.checkNotNullExpressionValue(r19, "in(...)");     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        BufferedReader r110 = new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r19, Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        String r20 = new StringBuilder().append(System.currentTimeMillis()).append('_').append(r10.hashCode()).toString();     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        final a r111 = new a(r10, r110);     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        ((Map) ZeusTransformUtils.preCheckCast(sseSessions, Map.class, "com.obric.memorydata.plugin")).put(r20, r111);     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        if (r12 != null) goto L31;
    L34:
        boolean r21 = true;
    L35:
        if (r21 == true) goto L37;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "abort late stream " + r20 + " for cancelled task " + r26, false, 4, null);     // Catch: IOException -> L23 CronetIOException -> L25 Throwable -> L49 NetworkNotAvailabeException -> L69
        r8.abortSSE(r20);     // Catch: IOException -> L23 CronetIOException -> L25 Throwable -> L49 NetworkNotAvailabeException -> L69
        r3 = new Response(-8, "task " + r26 + " cancelled", null, r16, 4, null);     // Catch: IOException -> L23 CronetIOException -> L25 Throwable -> L49 NetworkNotAvailabeException -> L69
        goto L22
    L37:
        if (r26 == null) goto L39;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "bind stream " + r20 + " to task " + r26, false, 4, null);     // Catch: IOException -> L23 CronetIOException -> L25 Throwable -> L49 NetworkNotAvailabeException -> L69
    L39:
        r2.a(new $$Lambda$NetworkBridgeAPIImpl$mlHXk7dG_yF_vG8YSpadUxNRdJE(r111));     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        JSONObject r22 = new JSONObject();     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        r22.put("streamId", r20);     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startSSE success, sessionId: " + r20, false, 4, null);     // Catch: Throwable -> L49 IOException -> L51 NetworkNotAvailabeException -> L69 CronetIOException -> L73
        boolean r23 = false;
        r1 = new Response(0, "success", r22, r16);     // Catch: IOException -> L45 CronetIOException -> L47 Throwable -> L49 NetworkNotAvailabeException -> L69
        goto L43
    L47:
        e = e;
    L75:
        CronetIOException r24 = e;
    L76:
        r24.printStackTrace();     // Catch: Throwable -> L49
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startSSE failed, cronet io exception: " + r24.getMessage(), null, 4, null);     // Catch: Throwable -> L49
        if (r12 != null) goto L79;
    L81:
        boolean r28 = r23;
    L82:
        if (r28 == true) goto L99;
        if (r26 != null) goto L85;
    L87:
        Integer r29 = Integer.valueOf(r24.getCronetInternalErrorCode());     // Catch: Throwable -> L49
        if (((Number) ZeusTransformUtils.preCheckCast(r29, Number.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L91;
        r9 = r23;
    L91:
        if (r9 == false) goto L93;
        Integer r30 = r29;
    L94:
        if (r30 == null) goto L96;
        int r31 = r30.intValue();     // Catch: Throwable -> L49
    L97:
        r1 = new Response(r31, "cronet io exception: " + r24.getMessage(), null, null, 12, null);     // Catch: Throwable -> L49
    L100:
        if (r12 != null) goto L44;
        return r1;
    L96:
        r31 = -4;
        goto L97
    L93:
        r30 = null;
        goto L94
    L85:
        if (sseTaskBindings.b(r26) == false) goto L87;
    L99:
        r1 = new Response(-8, "task " + r26 + " cancelled", null, null, 12, null);     // Catch: Throwable -> L49
        goto L100
    L79:
        if (sseTaskBindings.b(r12) != true) goto L81;
        r28 = true;
    L45:
        e = e;
    L53:
        IOException r32 = e;
    L54:
        r32.printStackTrace();     // Catch: Throwable -> L49
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startSSE failed, io exception: " + r32.getMessage(), null, 4, null);     // Catch: Throwable -> L49
        if (r12 != null) goto L57;
    L59:
        r9 = r23;
    L60:
        if (r9 == true) goto L66;
        if (r26 != null) goto L63;
    L65:
        r1 = new Response(-6, "io exception: " + r32.getMessage(), null, null, 12, null);     // Catch: Throwable -> L49
    L67:
        if (r12 != null) goto L44;
        return r1;
    L63:
        if (sseTaskBindings.b(r26) == false) goto L65;
    L66:
        r1 = new Response(-8, "task " + r26 + " cancelled", null, null, 12, null);     // Catch: Throwable -> L49
        goto L67
    L57:
        if (sseTaskBindings.b(r12) != true) goto L59;
    L31:
        if (sseTaskBindings.a(r20, r12) == true) goto L34;
        r21 = false;
    L25:
        e = move-exception;
        r24 = e;
        r23 = false;
    L23:
        e = move-exception;
        r32 = e;
        r23 = false;
    L49:
        th = move-exception;
        if (r12 == null) goto L118;
        sseTaskBindings.a(r12);
        throw th;
    L118:
        throw th;
    L69:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L49
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startSSE failed, network not available", null, 4, null);     // Catch: Throwable -> L49
        r1 = new Response(-1, "network not available", null, null, 12, null);     // Catch: Throwable -> L49
        if (r12 != null) goto L44;
        return r1;
    L73:
        e = e;
        r23 = false;
    L51:
        e = e;
        r23 = false;
        goto L53
    L13:
        r12 = null;
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        r6 = null;
        goto L7
    }

    private static final Unit startSSEInternal$lambda$10$lambda$6(a r1) {
        INSTANCE.readSseLoop(r1);
        return Unit.INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String abortSSE(String r10) {
        Intrinsics.checkNotNullParameter(r10, "streamId");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "abortSSE streamId " + r10, false, 4, null);
        a r9 = (a) ZeusTransformUtils.preCheckCast(sseSessions.remove(r10), a.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L12;
        Response r11 = new Response(0, "success", null, null, 12, null);
    L6:
        return u.a(r11);
    L12:
        r9.a().cancel();     // Catch: IOException -> L9
        r9.b().close();     // Catch: IOException -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "abort SSE streamId " + r10 + " success", false, 4, null);     // Catch: IOException -> L9
    L11:
        r9.a(true);
        r9.a(-8);
        r9.a("aborted stream " + r10);
        sseTaskBindings.a(r10);
        r11 = new Response(0, "success", null, null, 12, null);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String abortSSEByTaskId(String r8) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        abortSseTargets(sseTaskBindings.c(r8));
        return u.a(new Response(0, "success", null, null, 12, null));
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String abortSSEByTaskInvocationTimeout(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        abortSseTargets(sseTaskBindings.c(r8, r9));
        return u.a(new Response(0, "success", null, null, 12, null));
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String abortSSEByTaskTimeout(String r8) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        abortSseTargets(sseTaskBindings.d(r8));
        return u.a(new Response(0, "success", null, null, 12, null));
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public void beginSSETaskInvocation(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        sseTaskBindings.a(r1, r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public void endSSETaskInvocation(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        sseTaskBindings.b(r1, r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String getImageBase64(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "entityId");
        Intrinsics.checkNotNullParameter(r11, "imageUri");
        ImageUploadEntity r9 = new ImageUploadEntity(301, r10, r11, "com.android.gallery3d", false, null, 48, null);
        return com.obric.memorydata.middleware.impl.image.a.f11712a.a(r9);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String readSSENext(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "streamId");
        return u.a(readSSENextInternal(r2, r3));
    }

    public final Response readSSENextInternal(String r22, int r23) {
        Intrinsics.checkNotNullParameter(r22, "streamId");
        a r1 = (a) ZeusTransformUtils.preCheckCast(sseSessions.get(r22), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "readSSENextInternal stream " + r22 + " not found", null, 4, null);
        return new Response(-8, "stream " + r22 + " not found", null, null, 12, null);
    L7:
        if (r1.e() == 0) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "readSSENextInternal stream " + r22 + " error: " + r1.f(), null, 4, null);
        int r15 = r1.e();
        String r2 = r1.f();
        if (r2 != null) goto L11;
        String r16 = "stream " + r22 + " error";
    L13:
        return new Response(r15, r16, null, null, 12, null);
    L11:
        r16 = r2;
        goto L13
    L14:
        List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r1.c().poll(r23, TimeUnit.MILLISECONDS), String.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L40
        if (r8 == null) goto L21;
    L17:
        r5.add(r8);     // Catch: InterruptedException -> L40
        r8 = (String) ZeusTransformUtils.preCheckCast(r1.c().poll(10, TimeUnit.MILLISECONDS), String.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L40
        if (r8 != null) goto L17;
    L21:
        if (r1.e() == 0) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "readSSENextInternal stream " + r22 + " error: " + r1.f(), null, 4, null);
        int r17 = r1.e();
        String r3 = r1.f();
        if (r3 != null) goto L25;
        String r18 = "stream " + r22 + " error";
    L27:
        return new Response(r17, r18, null, null, 12, null);
    L25:
        r18 = r3;
        goto L27
    L29:
        if (r1.d() == true) goto L31;
    L33:
        String r0 = STATUS_RUNNING;
    L34:
        JSONObject r9 = new JSONObject();
        JSONArray r4 = new JSONArray();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L36:
        if (r6.hasNext() == false) goto L38;
        r4.put((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        goto L36
    L38:
        r9.put("lines", r4);
        r9.put("status", r0);
        return new Response(0, "success", r9, null, 8, null);
    L31:
        if (r1.c().isEmpty() == false) goto L33;
        r0 = STATUS_FINISHED;
        goto L34
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String send(JSONObject r14) {
        Intrinsics.checkNotNullParameter(r14, "requestJson");
        GsonUtil r1 = GsonUtil.INSTANCE;
        String r2 = r14.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        Object r3 = r1.getGSON().fromJson(r2, HttpRequest.class);     // Catch: Exception -> L5
    L7:
        HttpRequest r4 = (HttpRequest) ZeusTransformUtils.preCheckCast(r3, HttpRequest.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L12;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "invalid request " + r14, null, 4, null);
        Response r13 = new Response(-5, "invalid request", null, null, 12, null);
    L11:
        return u.a(r13);
    L12:
        r13 = sendRequest(r4);
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        r3 = null;
        goto L7
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public Response sendRequest(HttpRequest r8) {
        Intrinsics.checkNotNullParameter(r8, Ext.KEY_REQUEST);
        RunLog.INSTANCE.debug(TAG, "request: " + r8);
        Response r7 = executeCall(createApiCall(r8, false));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "response recall: " + r8, false, 4, null);
        return r7;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String startSSE(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "requestJson");
        String r2 = u.a(startSSEInternal(r3));
        RunLog.INSTANCE.debug(TAG, "startSSE response: " + r2);
        return r2;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String startSSE(JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "requestJson");
        Intrinsics.checkNotNullParameter(r4, "taskId");
        String r2 = u.a(startSSEInternal(r3, r4));
        RunLog.INSTANCE.debug(TAG, "startSSE(task) " + r4 + ", response: " + r2);
        return r2;
    }

    public final Response startSSEInternal(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "requestJson");
        return startSSEInternal(r2, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String uploadAuditoryWavImageX(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        Intrinsics.checkNotNullParameter(r9, "accountScope");
        if (AUDITORY_TASK_ID_REGEX.matches((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "invalid auditory upload task id", null, 4, null);
        return null;
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L9;
    L32:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "auditory upload blocked by account gate", null, 4, null);
        return null;
    L9:
        if (Intrinsics.areEqual(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(UserSettings.INSTANCE.getUserId(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), r9) == false) goto L32;
        File r7 = new File(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), AUDITORY_UPLOAD_DIRECTORY), r8 + ".wav");
        if (r7.isFile() == true) goto L14;
    L30:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "auditory upload bundle unavailable", null, 4, null);
        return null;
    L14:
        if (r7.canRead() == false) goto L30;
        boolean r10 = true;
        com.obric.memorydata.middleware.impl.image.d r11 = (com.obric.memorydata.middleware.impl.image.d) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new NetworkBridgeAPIImpl$uploadAuditoryWavImageX$result$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), com.obric.memorydata.middleware.impl.image.d.class, "com.obric.memorydata.plugin");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L19;
    L22:
        if (r10 == false) goto L29;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r13 = new StringBuilder().append("ImageX file upload failed, code=");
        Long r14 = r11.b();
        if (r14 == null) goto L26;
        long r1 = r14.longValue();
    L27:
        IRunLog.a.b(r0, TAG, r13.append(r1).toString(), null, 4, null);
        goto L29
    L26:
        r1 = 0;
    L29:
        return r11.a();
    L19:
        if (StringsKt.isBlank(r12) == true) goto L22;
        r10 = false;
        goto L22
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    @Deprecated(message = "兼容老的算法包，后续删掉")
    public String uploadImageX(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return uploadImageX("DOUBAO", r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String uploadImageX(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "bizName");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return uploadImageX(r2, r3, r4, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String uploadImageX(String r17, String r18, String r19, Integer r20) {
        Intrinsics.checkNotNullParameter(r17, "bizName");
        Intrinsics.checkNotNullParameter(r18, "uri");
        ImageXBizType r4 = ImageXBizType.valueOf(r17);     // Catch: IllegalArgumentException -> L5
    L7:
        if (r4 != null) goto L10;
        return null;
    L10:
        return (String) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, r18, r19, r20, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), String.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        e.printStackTrace();
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "invalid ImageXBizType " + r17, null, 4, null);
        r4 = null;
        goto L7
    }
}
