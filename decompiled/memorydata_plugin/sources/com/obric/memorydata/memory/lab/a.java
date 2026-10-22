package com.obric.memorydata.memory.lab;

import android.content.Context;
import android.os.Build;
import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.attestation.AttestationConfig;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.utils.v;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.network.rpc.GlobalRpcInterceptor;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.cu;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0003\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002cdB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\b\u0010%\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u0004\u0018\u00010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u001b\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010.\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b/\u00100J\"\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010'H\u0002J\u0010\u00107\u001a\u0002022\u0006\u00108\u001a\u00020\u0005H\u0002J\u001e\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020\u00052\f\u0010;\u001a\b\u0012\u0004\u0012\u0002020<H\u0002J\u0010\u0010=\u001a\u0002022\b\u0010>\u001a\u0004\u0018\u00010,J\u0012\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\u0005H\u0002J\u000f\u0010A\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010D\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0005J\u0018\u0010F\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010G\u001a\u00020\u0005J\u0018\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020 2\u0006\u0010G\u001a\u00020\u0005H\u0002J\u001c\u0010J\u001a\u0002022\u0006\u0010G\u001a\u00020\u00052\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0005H\u0002J)\u0010L\u001a\u00020M2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010G\u001a\u00020\u00052\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bNJ\b\u0010O\u001a\u00020\bH\u0002J&\u0010P\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u000204J(\u0010T\u001a\u00020M2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010U\u001a\u00020'2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005H\u0002J\u0018\u0010V\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010W\u001a\u00020'H\u0002J\u0018\u0010X\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010Y\u001a\u00020'H\u0002J@\u0010Z\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010U\u001a\u00020'2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u0002042\u0006\u0010[\u001a\u0002042\u0006\u0010K\u001a\u00020\u0005H\u0002J\u0019\u0010\\\u001a\u0004\u0018\u0001042\u0006\u0010S\u001a\u000204H\u0000¢\u0006\u0004\b]\u0010^J\u0010\u0010_\u001a\u0002022\u0006\u00108\u001a\u00020`H\u0002J \u0010a\u001a\u00020M2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010K\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0002J\u000e\u0010b\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabAccessControlLogic;", "", "<init>", "()V", "TAG", "", "PERMISSION_HOST", "TIMEOUT_CONNECT_MS", "", "TIMEOUT_READ_WRITE_MS", "PRIVACY_SDK_APP_ID", "ATTEST_HEADER_APP_ID", "ATTEST_HEADER_CERT_CHAIN", "ATTEST_KEY_ALIAS", "SOURCE_SCREEN_UNLOCK_WAITING_PERMISSION", "permissionTaskScope", "Lkotlinx/coroutines/CoroutineScope;", "permissionTaskChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/obric/memorydata/memory/lab/AILabAccessControlLogic$PermissionTask;", "permissionApi", "Lcom/obric/memorydata/memory/lab/AILabPermissionApi;", "getPermissionApi", "()Lcom/obric/memorydata/memory/lab/AILabPermissionApi;", "permissionApi$delegate", "Lkotlin/Lazy;", "createRequestContext", "Lcom/bytedance/ttnet/http/RequestContext;", "buildPermissionHeaders", "", "Lcom/bytedance/retrofit2/client/Header;", "context", "Landroid/content/Context;", "customInfo", "readAccountTokenMap", "", "buildAttestationCertChain", "buildPermissionCustomInfo", "executeJsonCall", "Lorg/json/JSONObject;", NotificationCompat.CATEGORY_CALL, "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "permissionCallback", "Lcom/obric/memorydata/memory/lab/AILabAccessControlLogic$PermissionStatusCallback;", "parseLongIdOrNull", EventBody.KEY_VALUE, "parseLongIdOrNull$memory_obricRelease", "(Ljava/lang/String;)Ljava/lang/Long;", "postPermissionStatusChanged", "", "status", "", "message", "permissionData", "postPermissionNetworkError", "error", "executePermissionTask", AnnotatedPrivateKey.LABEL, "block", "Lkotlin/Function0;", "setPermissionCallback", "callback", "resolveReadyUid", InfoRequestQPSOptTraceLogger.REASON, "resolveOsDeviceIdLongOrNull", "()Ljava/lang/Long;", "onInfoUpdate", "onUserLogout", "lastUserId", "initPermissionCheck", AILabCheckPermissionTask.KEY_SOURCE, "doInitPermissionCheck", "appContext", "enqueueCheckPermissionTask", "uid", "executeCheckPermission", "", "executeCheckPermission$memory_obricRelease", "getFlowDeviceId", "requestPermission", ObricMemoryConstants.KEY_PACKAGE_NAME, "permissionName", "requestType", "handlePermissionResponse", ChatMessage.TYPE_RESPONSE, "parseAndApplyPermissions", "labObject", "publishCachedPermissionState", "cachedPermission", "handleRequestResponse", "targetPermissionStatus", "mapRequestTypeToPermissionStatus", "mapRequestTypeToPermissionStatus$memory_obricRelease", "(I)Ljava/lang/Integer;", "handleRequestError", "", "applyBestCachedPermission", "onOwnPackageReplaced", "PermissionTask", "PermissionStatusCallback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10241a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f10242b = null;
    private static final i<b> c = null;
    private static final Lazy d = null;
    private static InterfaceC0503a e;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.lab.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabAccessControlLogic$PermissionStatusCallback;", "", "onPermissionStatusChanged", "", "status", "", "message", "", "permissionData", "Lorg/json/JSONObject;", "onNetworkError", "error", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface InterfaceC0503a {
        void onNetworkError(String r1);

        void onPermissionStatusChanged(int r1, String r2, JSONObject r3);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabAccessControlLogic$PermissionTask;", "", AnnotatedPrivateKey.LABEL, "", "block", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getLabel", "()Ljava/lang/String;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function0<Unit> f10244b;

        public b(String r3, Function0<Unit> r4) {
            Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, AnnotatedPrivateKey.LABEL);
            Intrinsics.checkNotNullParameter(r5, "block");
            this.f10243a = r3;
            this.f10244b = r5;
        }

        public final String a() {
            return this.f10243a;
        }

        public final Function0<Unit> b() {
            return this.f10244b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10243a, r6.f10243a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10244b, r6.f10244b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10243a.hashCode() * 31) + this.f10244b.hashCode();
        }

        public String toString() {
            return "PermissionTask(label=" + this.f10243a + ", block=" + this.f10244b + ')';
        }
    }

    static {
        f10241a = new a();
        al r5 = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        f10242b = r5;
        c = l.a(Integer.MAX_VALUE, null, null, 6, null);
        kotlinx.coroutines.i.a(r5, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AILabAccessControlLogic$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        d = LazyKt.lazy($$Lambda$a$jRcliGfrsL2EILg_PlAwbTKBPlc.INSTANCE);
    }

    private a() {
    }

    private static final Unit a(int r19, String r20, String r21, Context r22) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r22, Context.class, "com.obric.memorydata.plugin");
        a r4 = f10241a;
        Integer r7 = r4.a(r19);
        if (r7 != null) goto L8;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "Request permission failed: invalid requestType=" + r19, null, 4, null);
        String r0 = "Invalid request type";
    L5:
        r4.b(r0);
    L7:
        return Unit.INSTANCE;
    L8:
        String r8 = r4.c("apply_v4 request permissionName=" + r20);
        if (r8 != null) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "Request permission failed: cannot get user info", null, 4, null);
        r0 = "Cannot get user info, please login first";
        goto L5
    L11:
        JSONObject r10 = new JSONObject();
        Long r11 = r4.a(r8);
        Long r12 = r4.f();
        if (r11 == null) goto L40;
        if (r12 == null) goto L40;
        r10.put("device_id", r4.g());     // Catch: JSONException -> L38
        r10.put(Header.KEY_USER_ID, r11.longValue());     // Catch: JSONException -> L38
        r10.put("remark", "IMEI-" + r12);     // Catch: JSONException -> L38
        r10.put("imei", r12.toString());     // Catch: JSONException -> L38
        r10.put("resource_key", "O_LAB");     // Catch: JSONException -> L38
        r10.put("package_name", r21);     // Catch: JSONException -> L38
        r10.put(ObricSecurityGuardStub.PermissionInfoKey.PER_NAME, r20);     // Catch: JSONException -> L38
        r10.put("permission_value", r19);     // Catch: JSONException -> L38
        r10.put("request_type", r19);     // Catch: JSONException -> L38
        r10.put("push_token", SharedState.INSTANCE.getString("doubao_push_token", ""));     // Catch: JSONException -> L38
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L38
        r13.put("assistant_version", AppContext.INSTANCE.getVersionName());     // Catch: JSONException -> L38
        r13.put("phone_type", Build.BRAND + '-' + Build.MODEL + '-' + Build.DEVICE);     // Catch: JSONException -> L38
        r13.put("system_version", com.obric.aiagent.product.b.f5974a.a().romInfo().getDeviceModel());     // Catch: JSONException -> L38
        r10.put("client_info", r13);     // Catch: JSONException -> L38
        String r14 = r4.e();     // Catch: Exception -> L34
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L34
        StringBuilder r16 = new StringBuilder().append("apply_v4 request start packageName=").append(r21).append(" permissionName=").append(r20).append(" requestType=").append(r19).append(" targetStatus=").append(r7).append(" customInfoEmpty=");     // Catch: Exception -> L34
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L20;
        boolean r17 = true;
    L21:
        IRunLog.a.a(r15, "AILabAccessControlLogic", r16.append(r17).append(" customInfoLength=").append(r14.length()).toString(), false, 4, null);     // Catch: Exception -> L34
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L34
        List<com.bytedance.retrofit2.client.Header> r18 = r4.c(r3, r14);     // Catch: Exception -> L34
        if (r18 == null) goto L24;
        JsonObject r110 = JsonParser.parseString(r10.toString()).getAsJsonObject();     // Catch: Exception -> L34
        AILabPermissionApi r111 = r4.b();     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L31
        JSONObject r112 = r4.a(r111.applyPermission(r110, r18, r4.c()));     // Catch: Throwable -> L31
        if (r112 != null) goto L30;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "apply_v4 response invalid permissionName=" + r20 + " requestType=" + r19, null, 4, null);     // Catch: Exception -> L34
        r4.b("invalid response");     // Catch: Exception -> L34
        return Unit.INSTANCE;
    L30:
        r4.a(r3, r112, r21, r20, r19, r7.intValue(), r8);     // Catch: Exception -> L34
    L37:
        return Unit.INSTANCE;
    L31:
        th = move-exception;
        RunLog.INSTANCE.error("AILabAccessControlLogic", "apply_v4 request failed permissionName=" + r20 + " requestType=" + r19 + ": " + th.getMessage(), th);     // Catch: Exception -> L34
        f10241a.b("invalid response");     // Catch: Exception -> L34
        return Unit.INSTANCE;
    L24:
        return Unit.INSTANCE;
    L20:
        r17 = false;
    L34:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "Request permission failed: " + e.getMessage(), null, 4, null);
        f10241a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L38:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "Request permission jsonBody error: " + e.getMessage(), null, 4, null);
        f10241a.b("Invalid request body");
    L40:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "Request permission failed: ID conversion failed", null, 4, null);
        r0 = "ID conversion failed";
        goto L5
    }

    public static final /* synthetic */ i a() {
        return c;
    }

    private final JSONObject a(Call<TypedInput> r10) {
        SsResponse r11 = ((Call) ZeusTransformUtils.wrapperContextForParams(r10, Call.class, "com.obric.memorydata.plugin")).execute();
        Intrinsics.checkNotNullExpressionValue(r11, "execute(...)");
        Object r2 = null;
        if (r11.isSuccessful() == true) goto L7;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r5 = "http failed: " + r11.code() + ' ' + r11.message();
        Throwable r6 = null;
        int r7 = 4;
        Object r8 = null;
        String r4 = "AILabAccessControlLogic";
    L5:
        IRunLog.a.b(r3, r4, r5, r6, r7, r8);
        return null;
    L7:
        TypedInput r12 = (TypedInput) ZeusTransformUtils.preCheckCast(r11.body(), TypedInput.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L10;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "AILabAccessControlLogic";
        r5 = "http response body is null";
        goto L5
    L10:
        InputStream r13 = r12.in();
        if (r13 == null) goto L24;
        Reader r14 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r13, Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, BufferedReader.class) == false) goto L15;
        BufferedReader r15 = (BufferedReader) ZeusTransformUtils.preCheckCast(r14, BufferedReader.class, "com.obric.memorydata.plugin");
    L16:
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");
        String r0 = TextStreamsKt.readText((Reader) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast(r16, BufferedReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r16, null);
    L25:
        if (r0 != null) goto L28;
        r0 = "";
    L28:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L44;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "AILabAccessControlLogic";
        r5 = "http response body empty";
        goto L5
    L44:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L32
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Object r18 = Result.m1421constructorimpl(new JSONObject(r0));     // Catch: Throwable -> L32
    L34:
        Throwable r19 = Result.m1424exceptionOrNullimpl(r18);
        if (r19 != null) goto L37;
        r2 = r18;
    L39:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
    L37:
        RunLog.INSTANCE.error("AILabAccessControlLogic", "parse json response failed rawLength=" + r0.length(), r19);
    L32:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);
        throw th;
    L15:
        r15 = new BufferedReader(r14, 8192);
        goto L16
    L24:
        r0 = null;
        goto L25
    }

    private final void a(final int r1, final String r2, final JSONObject r3) {
        j.a(new $$Lambda$a$9Rnd9LCb4ZCppp0KR1uV6GER7jY(r1, r2, r3));
    }

    private final void a(Context r4, JSONObject r5) {
        AILabPermissionRepository.f10236a.a((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("AILabAccessControlLogic", "Parse and apply permissions failed: " + e.getMessage() + ", " + AILabPermissionRepository.f10236a.b(r5), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(Context r24, JSONObject r25, String r26, String r27, int r28, int r29, String r30) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.memorydata.plugin");
        int r14 = r25.getInt("code");     // Catch: Exception -> L22
        String r15 = r25.optString("message");     // Catch: Exception -> L22
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "apply_v4 response packageName=" + r26 + " permissionName=" + r27 + " requestType=" + r28 + " targetStatus=" + r29 + " code=" + r14 + " message=" + r15, false, 4, null);     // Catch: Exception -> L20
        if (r14 != 0) goto L18;
        if (r28 != 0) goto L9;
        AILabPermissionRepository.f10236a.c(r27);     // Catch: Exception -> L20
    L10:
        AILabPermissionRepository.a r2 = AILabPermissionRepository.f10236a.a(r12, r30);     // Catch: Exception -> L20
        if (r2 == null) goto L13;
        AILabPermissionRepository.PermissionSchema r9 = r2.b();     // Catch: Exception -> L20
    L15:
        if (r9 != AILabPermissionRepository.PermissionSchema.V4) goto L17;
        AILabPermissionRepository.f10236a.a(r2.a(), r26, r27, r29);     // Catch: Exception -> L20
        AILabPermissionRepository.f10236a.f(r2.a());     // Catch: Exception -> L20
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "apply_v4 success update local V4 cache permissionName=" + r27 + " targetStatus=" + r29 + ' ' + AILabPermissionRepository.f10236a.b(r2.a()), false, 4, null);     // Catch: Exception -> L20
        AILabPermissionRepository.f10236a.a(r12, r2.a());     // Catch: Exception -> L20
        a(r29, "Permission request applied", r2.a());     // Catch: Exception -> L20
        return;
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "apply_v4 success but no V4 cached permission found, refresh get_v4 immediately permissionName=" + r27 + " requestType=" + r28, false, 4, null);     // Catch: Exception -> L20
        a("apply_v4_success_no_cache", r30);     // Catch: Exception -> L20
        return;
    L13:
        r9 = null;
        goto L15
    L9:
        AILabPermissionRepository.f10236a.e(r27);     // Catch: Exception -> L20
        goto L10
    L18:
        String r0 = "Request failed: code=" + r14 + ", message=" + r15;     // Catch: Exception -> L20
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", r0, null, 4, null);     // Catch: Exception -> L20
        b(r0);     // Catch: Exception -> L20
        return;
    L20:
        e = e;
    L24:
        String r3 = "Parse request response failed: " + e.getMessage();
        RunLog.INSTANCE.error("AILabAccessControlLogic", r3 + ", code=" + r25.optInt("code", Integer.MIN_VALUE) + " message=" + r25.optString("message"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        b(r3);
        return;
    L22:
        e = e;
        goto L24
    }

    public static /* synthetic */ void a(a r1, Context r2, String r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = "init_permission_check";
    L5:
        r1.b(r6, r3);
    }

    private final void a(String r11, String r12) {
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("enqueue check permission task source=").append(r11).append(" uidPresent=");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r8 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        IRunLog.a.a(r2, "AILabAccessControlLogic", r10.append(!r1).toString(), false, 4, null);
        TaskRequest.Builder r13 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(AILabCheckPermissionTask.NAME).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r3 = new JSONObject();
        r3.put(AILabCheckPermissionTask.KEY_SOURCE, r11);
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L12;
    L13:
        r8 = true;
    L14:
        if (r8 == true) goto L16;
        r3.put("uid", r12);
    L16:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r13.setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        return;
    L12:
        if (r14.length() != 0) goto L14;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final void a(String r7, Function0<Unit> r8) {
        if (m.b(c.mo54trySendJP2dKIU(new b(r7, (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin")))) == false) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "permission task enqueue failed label=" + r7, null, 4, null);
        return;
    }

    private final void a(Throwable r9) {
        String r10 = r9.getMessage();
        if (r10 != null) goto L5;
        r10 = "Request permission network failed";
    L5:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "Request permission failed: " + r10, null, 4, null);
        b("Request permission failed: " + r10);
    }

    private final boolean a(Context r18, JSONObject r19, String r20, String r21) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        int r9 = r19.getInt("code");     // Catch: Exception -> L21
        String r10 = r19.optString("message");     // Catch: Exception -> L21
        if (r9 != 0) goto L19;
        JSONObject r11 = r19.getJSONObject("data");     // Catch: Exception -> L21
        if (r11.has("O_LAB") == false) goto L17;
        JSONObject r0 = r11.getJSONObject("O_LAB");     // Catch: Exception -> L21
        if (AILabPermissionRepository.f10236a.c(r0) == true) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "Response O_LAB missing valid V4 permissions, " + AILabPermissionRepository.f10236a.b(r0) + ", rawResponse=" + r19, null, 4, null);     // Catch: Exception -> L21
        b(r6, r20, "Response O_LAB missing valid V4 permissions");     // Catch: Exception -> L21
        return false;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "get_v4 success save global cache " + AILabPermissionRepository.f10236a.b(r0), false, 4, null);     // Catch: Exception -> L21
        AILabPermissionRepository r12 = AILabPermissionRepository.f10236a;     // Catch: Exception -> L21
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L21
        r12.f(r0);     // Catch: Exception -> L21
        if (Intrinsics.areEqual(r21, "screen_unlock_waiting_permission") == false) goto L14;
        AILabPermissionRepository.f10236a.a(System.currentTimeMillis());     // Catch: Exception -> L21
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "save unlock last get permission time after get_v4 success", false, 4, null);     // Catch: Exception -> L21
    L14:
        a(r6, r0);     // Catch: Exception -> L21
        a(AILabPermissionRepository.f10236a.e(r0), "", r0);     // Catch: Exception -> L21
        if (AILabPermissionRepository.f10236a.a(r0, BuildConfig.LIBRARY_PACKAGE_NAME, "ai_proactive_agent") == 2) goto L26;
        return false;
    L26:
        return true;
    L17:
        String r1 = "Response missing O_LAB field";
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "Response missing O_LAB field", null, 4, null);     // Catch: Exception -> L21
    L18:
        b(r6, r20, r1);     // Catch: Exception -> L21
        return false;
    L19:
        r1 = "Request failed: code=" + r9 + ", message=" + r10;     // Catch: Exception -> L21
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", r1, null, 4, null);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        String r13 = "Parse permission response failed: " + e.getMessage();
        RunLog.INSTANCE.error("AILabAccessControlLogic", r13 + ", code=" + r19.optInt("code", Integer.MIN_VALUE) + " message=" + r19.optString("message"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        b(r6, r20, r13);
        return false;
    }

    private final AILabPermissionApi b() {
        Object r2 = d.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "getValue(...)");
        return (AILabPermissionApi) ZeusTransformUtils.preCheckCast(r2, AILabPermissionApi.class, "com.obric.memorydata.plugin");
    }

    private static final Unit b(int r1, String r2, JSONObject r3) {
        InterfaceC0503a r0 = e;
        if (r0 == null) goto L6;
        r0.onPermissionStatusChanged(r1, r2, r3);
    L6:
        return Unit.INSTANCE;
    }

    private final void b(Context r8, JSONObject r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (v.f11566a.b() == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "publish cached permission state " + AILabPermissionRepository.f10236a.b(r9), false, 4, null);
        a(r10, r9);
        a(AILabPermissionRepository.f10236a.e(r9), "Applied cached permission config", r9);
    }

    private final void b(final String r1) {
        j.a(new $$Lambda$a$IbO6Oma4KSKKss33cr0Djdssr0s(r1));
    }

    private final boolean b(Context r8, String r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        JSONObject r12 = AILabPermissionRepository.f10236a.b(r11, r9);
        if (r12 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "cache fallback miss reason=" + r10, null, 4, null);
        return false;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "cache fallback hit reason=" + r10 + ' ' + AILabPermissionRepository.f10236a.b(r12), false, 4, null);
        a(r11, r12);
        a(AILabPermissionRepository.f10236a.e(r12), r10, r12);
        return true;
    }

    private final com.bytedance.ttnet.b.d c() {
        com.bytedance.ttnet.b.d r2 = new com.bytedance.ttnet.b.d();
        r2.c = SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        r2.d = SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        r2.e = SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        return r2;
    }

    private final String c(String r8) {
        String r0 = null;
        if (AppContext.INSTANCE.isLogin() == false) goto L7;
        String r7 = AppContext.INSTANCE.getUserId();
        if (AILabPermissionRepository.f10236a.a(r7) == false) goto L7;
        r0 = r7;
    L7:
        if (r0 != null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", r8 + " skipped: account not ready", false, 4, null);
    L9:
        return r0;
    }

    private final List<com.bytedance.retrofit2.client.Header> c(Context r19, String r20) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r3 = d();
        List<com.bytedance.retrofit2.client.Header> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, String>> r5 = r3.entrySet().iterator();
    L3:
        boolean r7 = false;
        if (r5.hasNext() == false) goto L15;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == false) goto L3;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L13;
        r7 = true;
    L13:
        if (r7 == false) goto L3;
        r4.add(new com.bytedance.retrofit2.client.Header(r9, r8));
        goto L3
    L8:
        r10 = false;
        goto L9
    L15:
        r4.add(new com.bytedance.retrofit2.client.Header("x-att-app-id", "obric_doubao_assistant"));
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L18
        Object r1 = Result.m1421constructorimpl(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).d(r0, r20));     // Catch: Throwable -> L18
    L21:
        if (Result.m1427isFailureimpl(r1) == false) goto L23;
        r1 = null;
    L23:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L26;
    L29:
        boolean r13 = true;
    L31:
        if (r13 == false) goto L37;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "attestation certChain empty, customInfoLength=" + r20.length(), null, 4, null);
        IRunLog r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r15 = new StringBuilder().append("permission header summary tokenPresent=").append(!r3.isEmpty()).append(" tokenCount=").append(r3.size()).append(" certChainPresent=false customInfoEmpty=");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L35;
        r7 = true;
    L35:
        IRunLog.a.a(r14, "AILabAccessControlLogic", r15.append(r7).append(" customInfoLength=").append(r20.length()).toString(), false, 4, null);
        return null;
    L37:
        r4.add(new com.bytedance.retrofit2.client.Header("x-att-certchain", r2));
        IRunLog r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r17 = new StringBuilder().append("permission header summary tokenPresent=").append(!r3.isEmpty()).append(" tokenCount=").append(r3.size()).append(" certChainPresent=true customInfoEmpty=");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L40;
        r7 = true;
    L40:
        IRunLog.a.a(r16, "AILabAccessControlLogic", r17.append(r7).append(" customInfoLength=").append(r20.length()).toString(), false, 4, null);
        return r4;
    L26:
        if (r12.length() == 0) goto L29;
        r13 = false;
    L18:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private static final Unit c(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "User info update", false, 4, null);
        a r0 = f10241a;
        Intrinsics.checkNotNull(r8);
        r0.e(r8, "account_info_update");
        return Unit.INSTANCE;
    }

    private final String d(Context r3, String r4) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        AttestationConfig.a r5 = new AttestationConfig.a();
        r5.a(AttestationConfig.IdType.RPDID);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r5.a(r4);
    L8:
        AttestationConfig r6 = r5.a();
        return PrivacySdk.getIdAttestationManager().a(r2, "obric_doubao_assistant", "o_lab_permission_attest_key", r6);
    L5:
        r0 = false;
        goto L6
    }

    private final Map<String, String> d() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        String r7 = SharedState.INSTANCE.getString("doubao_account_token_map", "");     // Catch: Throwable -> L16
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        r7 = null;
    L7:
        if (r7 != null) goto L9;
        Map r8 = MapsKt.emptyMap();     // Catch: Throwable -> L16
    L14:
        Object r9 = Result.m1421constructorimpl(r8);     // Catch: Throwable -> L16
    L19:
        if (Result.m1424exceptionOrNullimpl(r9) == null) goto L23;
        r9 = MapsKt.emptyMap();
    L23:
        return (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin");
    L9:
        JSONObject r2 = new JSONObject(r7);     // Catch: Throwable -> L16
        Iterator<String> r10 = r2.keys();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r10, "keys(...)");     // Catch: Throwable -> L16
        Sequence r11 = SequencesKt.asSequence(r10);     // Catch: Throwable -> L16
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L16
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L16
    L11:
        if (r12.hasNext() == false) goto L13;
        Object r4 = r12.next();     // Catch: Throwable -> L16
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(r4, r2.optString((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L16
        goto L11
    L13:
        r8 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    private static final Unit d(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "user logout remove V4, V3, legacy provider snapshot and unlock refresh time", false, 4, null);
        AILabPermissionRepository.f10236a.e();
        AILabPermissionRepository r0 = AILabPermissionRepository.f10236a;
        Intrinsics.checkNotNull(r9);
        r0.d(r9);
        AILabPermissionRepository.f10236a.c(r9);
        AILabPermissionRepository.f10236a.c();
        AILabPermissionRepository.f10236a.d();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "user logout publish default permission state", false, 4, null);
        JSONObject r10 = AILabPermissionRepository.f10236a.b(r9);
        f10241a.a(0, "Account logged out, permission reset", r10);
        return Unit.INSTANCE;
    }

    private static final Unit d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        return Unit.INSTANCE;
    }

    private final String e() {
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getServerDeviceId(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r0 = AppContext.INSTANCE.getOsDeviceId($$Lambda$a$CXyNOk98C9toSeJCXfbHUWKOy6g.INSTANCE);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        JSONObject r2 = new JSONObject();
        r2.put("doubao_did", r3);
        r2.put("system_did", r1);
        String r4 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        return r4;
    }

    private static final Unit e(String r1) {
        InterfaceC0503a r0 = e;
        if (r0 == null) goto L6;
        r0.onNetworkError(r1);
    L6:
        return Unit.INSTANCE;
    }

    private final void e(Context r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "init permission check start source=" + r12, false, 4, null);
        String r0 = c("init permission check source=" + r12);
        if (r0 != null) goto L5;
        return;
    L5:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("init permission check cache lookup start source=").append(r12).append(" uidPresent=");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        IRunLog.a.a(r3, "AILabAccessControlLogic", r2.append(r4).toString(), false, 4, null);
        JSONObject r5 = AILabPermissionRepository.f10236a.b(r13, r0);
        if (r5 == null) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "init permission check cache hit source=" + r12 + ' ' + AILabPermissionRepository.f10236a.b(r5), false, 4, null);
        b(r13, r5);
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "init permission check network refresh start source=" + r12, false, 4, null);
        a(r12, r0);
        return;
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "init permission check cache miss source=" + r12, false, 4, null);
        goto L13
    L8:
        r4 = false;
        goto L9
    }

    private final Long f() {
        return a(AppContext.INSTANCE.getOsDeviceId($$Lambda$a$cHb7soEqrARO3zvIG1AdCkarf4I.INSTANCE));
    }

    private static final Unit f(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        a r0 = f10241a;
        Intrinsics.checkNotNull(r4);
        r0.e(r4, r3);
        return Unit.INSTANCE;
    }

    private static final Unit f(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        return Unit.INSTANCE;
    }

    private final long g() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(AppContext.INSTANCE.getServerDeviceId());     // Catch: Throwable -> L5
    L7:
        String r2 = null;
        if (Result.m1427isFailureimpl(r4) == false) goto L10;
        r4 = null;
    L10:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L24;
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r6 == null) goto L24;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        boolean r0 = true;
    L18:
        if (r0 == false) goto L20;
        r2 = r6;
    L20:
        if (r2 == null) goto L24;
        Long r7 = StringsKt.toLongOrNull(r2);
        if (r7 == null) goto L24;
        return r7.longValue();
    L17:
        r0 = false;
    L24:
        return 0;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit g(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        return Unit.INSTANCE;
    }

    private static final AILabPermissionApi h() {
        Retrofit r0 = RetrofitUtils.b("https://os.oceancloudapi.com");
        r0.interceptors().add(new GlobalRpcInterceptor());
        return (AILabPermissionApi) ZeusTransformUtils.preCheckCast(r0.create(AILabPermissionApi.class), AILabPermissionApi.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Unit lambda$9Rnd9LCb4ZCppp0KR1uV6GER7jY(int r0, String r1, JSONObject r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$CXyNOk98C9toSeJCXfbHUWKOy6g(String r0) {
        return d(r0);
    }

    public static /* synthetic */ Unit lambda$IbO6Oma4KSKKss33cr0Djdssr0s(String r0) {
        return e(r0);
    }

    /* JADX INFO: renamed from: lambda$M7-tlJ7n9_qa74hT61aYpA06E30, reason: not valid java name */
    public static /* synthetic */ Unit m729lambda$M7tlJ7n9_qa74hT61aYpA06E30(Context r0) {
        return d(r0);
    }

    public static /* synthetic */ Unit lambda$adDLCMclKjsraBqUMcY_vC7060M(String r0) {
        return g(r0);
    }

    public static /* synthetic */ Unit lambda$cHb7soEqrARO3zvIG1AdCkarf4I(String r0) {
        return f(r0);
    }

    public static /* synthetic */ Unit lambda$eEToABntQiEaPpOqeZUzND_O63E(Context r0) {
        return c(r0);
    }

    public static /* synthetic */ AILabPermissionApi lambda$jRcliGfrsL2EILg_PlAwbTKBPlc() {
        return h();
    }

    /* JADX INFO: renamed from: lambda$l9u1J2ILwROw-eFPJV8wkLvr7ow, reason: not valid java name */
    public static /* synthetic */ Unit m730lambda$l9u1J2ILwROweFPJV8wkLvr7ow(int r0, String r1, String r2, Context r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$uju0RotO5B0eN6MLw3vC9qUaU0M(Context r0, String r1) {
        return f(r0, r1);
    }

    public final Integer a(int r1) {
        int r0 = 1;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L6;
        r0 = 0;
        goto L11
    L6:
        if (r1 == 2) goto L8;
        return null;
    L8:
        r0 = 5;
    L11:
        return Integer.valueOf(r0);
    }

    public final Long a(String r3) {
        if (r3 == null) goto L16;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r4 != null) goto L7;
        return null;
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r4 = null;
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        return StringsKt.toLongOrNull(r4);
    L9:
        r0 = false;
        goto L10
    L16:
        return null;
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (v.f11566a.b() == true) goto L5;
        return;
    L5:
        final Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        a("account_info_update", new $$Lambda$a$eEToABntQiEaPpOqeZUzND_O63E(r5));
    }

    public final void a(Context r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        if (v.f11566a.b() == true) goto L5;
        return;
    L5:
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("user logout start lastUserIdPresent=");
        if (r10 == null) goto L8;
        boolean r12 = true;
    L9:
        IRunLog.a.a(r2, "AILabAccessControlLogic", r0.append(r12).toString(), false, 4, null);
        final Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        a("user_logout", new $$Lambda$a$M7tlJ7n9_qa74hT61aYpA06E30(r13));
        return;
    L8:
        r12 = false;
        goto L9
    }

    public final void a(Context r3, final String r4, final String r5, final int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r5, "permissionName");
        if (v.f11566a.b() == true) goto L5;
        return;
    L5:
        final Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        a("request_permission:" + r5 + ':' + r6, new $$Lambda$a$l9u1J2ILwROweFPJV8wkLvr7ow(r6, r5, r4, r8));
    }

    public final void a(InterfaceC0503a r2) {
        e = (InterfaceC0503a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0503a.class, "com.obric.memorydata.plugin");
    }

    public final boolean a(Context r21, String r22, String r23) {
        String r2 = r23;
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r22, AILabCheckPermissionTask.KEY_SOURCE);
        if (v.f11566a.b() == true) goto L5;
        return false;
    L5:
        if (r2 != null) goto L7;
    L11:
        r2 = c("get_v4 request source=" + r22);
        if (r2 != null) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(r2, AppContext.INSTANCE.getUserId()) == true) goto L18;
        return false;
    L18:
        if (a(r2) != null) goto L21;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "get_v4 request skip source=" + r22 + ", user id conversion failed", null, 4, null);
        return false;
    L21:
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getServerDeviceId(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r8 = AppContext.INSTANCE.getOsDeviceId($$Lambda$a$adDLCMclKjsraBqUMcY_vC7060M.INSTANCE);
        if (r8 != null) goto L24;
        r8 = "";
    L24:
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r10 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L30;
    L54:
        IRunLog r12 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("get_v4 request skip source=").append(r22).append(", device id not ready serverDeviceIdEmpty=");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L57;
        boolean r1 = true;
    L58:
        StringBuilder r4 = r0.append(r1).append(" osDeviceIdEmpty=");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L62;
        r10 = false;
    L62:
        IRunLog.a.b(r12, "AILabAccessControlLogic", r4.append(r10).toString(), null, 4, null);
        return false;
    L57:
        r1 = false;
        goto L58
    L30:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L32;
        boolean r13 = true;
    L33:
        if (r13 == true) goto L54;
        String r6 = e();
        String r14 = AppContext.INSTANCE.getVersionName();
        String r15 = Build.BRAND + '-' + Build.MODEL + '-' + Build.DEVICE;
        String r16 = com.obric.aiagent.product.b.f5974a.a().romInfo().getShortOSVersion();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "get_v4 request prepare source=" + r22, false, 4, null);
        List<com.bytedance.retrofit2.client.Header> r17 = c(r3, r6);
        if (r17 != null) goto L38;
        return false;
    L38:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "get_v4 request start source=" + r22, false, 4, null);
        JSONObject r7 = a(b().getPermission("O_LAB", r14, r15, r16, r17, c()));     // Catch: Throwable -> L51
        if (r7 != null) goto L44;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "get_v4 response invalid source=" + r22, null, 4, null);
        return false;
    L44:
        if (Intrinsics.areEqual(r2, AppContext.INSTANCE.getUserId()) == true) goto L46;
    L50:
        return false;
    L46:
        if (v.f11566a.b() == false) goto L50;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "get_v4 response received source=" + r22 + " code=" + r7.optInt("code", Integer.MIN_VALUE) + " message=" + r7.optString("message"), false, 4, null);
        return a(r3, r7, r2, r22);
    L51:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "get_v4 request failed source=" + r22 + ", errorType=" + th.getClass().getSimpleName(), null, 4, null);
        return false;
    L32:
        r13 = false;
        goto L33
    L27:
        r11 = false;
        goto L28
    L7:
        if (AILabPermissionRepository.f10236a.a(r2) == true) goto L10;
        r2 = null;
    L10:
        if (r2 != null) goto L15;
        goto L11
    }

    public final void b(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        if (v.f11566a.b() == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabAccessControlLogic", "Settings app updated, reinitialize permission check", false, 4, null);
        b(r9, "own_package_replaced");
    }

    public final void b(Context r3, final String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
        if (v.f11566a.b() == true) goto L5;
        return;
    L5:
        final Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        a("init_permission_check:" + r4, new $$Lambda$a$uju0RotO5B0eN6MLw3vC9qUaU0M(r6, r4));
    }
}
