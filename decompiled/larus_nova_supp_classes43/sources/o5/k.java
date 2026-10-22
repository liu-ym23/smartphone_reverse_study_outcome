package o5;

import com.byted.cast.sink.api.IServerListener;
import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.IAIPackageNetService;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageBaseRequest;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.resource.core.bean.AppRequestItem;
import com.bytedance.ai.resource.core.bean.ExtraInfo;
import com.bytedance.ai.resource.core.bean.FetchAppletDownLoadInfoRequest;
import com.bytedance.ai.resource.core.bean.IsInAppWhitelistData;
import com.bytedance.ai.resource.core.bean.IsInAppWhitelistRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformAppletItem;
import com.bytedance.ai.resource.core.bean.OpenPlatformAppletList;
import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformDebugSchemaData;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptResponseData;
import com.bytedance.ai.resource.core.bean.OpenPlatformExtraInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformPackageItem;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppVersionList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPublicKeyListData;
import com.bytedance.ai.resource.core.bean.PackageRequestItem;
import com.bytedance.ai.resource.core.bean.QrCodeRequest;
import com.bytedance.ai.resource.core.net.AIPackageNetApi;
import com.bytedance.ai.resource.core.net.OpenPlatformNetApi;
import com.bytedance.retrofit2.SsResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements IAIPackageNetService {
    public final String a;

    public static final class a {
    }

    public static final class b {
        public int a;
        public String b;

        public b() {
            this(0);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ErrorInfo(code=" + this.a + ", message=" + this.b + ')';
        }

        public b(int r10) {
            Intrinsics.checkNotNullParameter("Unknown error", com.bytedance.android.ec.core.event.a.KEY_MSG);
            this.a = -1;
            this.b = "Unknown error";
        }
    }

    static {
    }

    public static ExtraInfo c() {
        h2.a r0 = f2.b.c;
        if (r0 == null) goto L8;
        String r10 = r0.b;
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        com.bytedance.ai.debug.f.a.getClass();
        return new ExtraInfo(r10, r0.q, r0.h, r0.e);
    L8:
        return null;
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse<AIPackageAppList> requestPreInstallList() {
        return requestPreInstallListByApp(new AIPackageBaseRequest(this.a, null, 2, null));
    }

    public k() {
        AtomicBoolean r0 = f2.b.a;
        h2.a r1 = f2.b.c;
        if (r1 == null) goto L6;
        String r10 = Integer.valueOf(r1.d).toString();
        if (r10 == null) goto L6;
    L7:
        this.a = r10;
        return;
    L6:
        r10 = "";
        goto L7
    }

    public static FetchAppletDownLoadInfoRequest b(AIPackageNetworkRequest r10) {
        List<AppRequestItem> r0 = r10.getAppList();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r11 = r0.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        AppRequestItem r12 = (AppRequestItem) r11.next();
        r1.add(new OpenPlatformPackageItem(r12.getVersionCode(), r12.getAppId(), r12.getPackageName()));
        goto L4
    L6:
        ExtraInfo r13 = r10.getExtraInfo();
        if (r13 == null) goto L9;
        OpenPlatformExtraInfo r14 = new OpenPlatformExtraInfo(r13.getDeviceId(), r13.getLane(), r13.getChannel(), r13.getAppVersion());
    L11:
        return new FetchAppletDownLoadInfoRequest(r10.getAid(), r1, r14);
    L9:
        r14 = null;
        goto L11
    }

    public static void f(String r10) {
        if ((!StringsKt.isBlank(r10)) == false) goto L6;
        com.bytedance.ai.resource.security.h.a.getClass();
        com.bytedance.ai.resource.security.h.b("global_package", r10, false);
        return;
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final OpenPlatformBaseResponse<OpenPlatformDebugSchemaData> getDebugSchema(String r11) {
        Intrinsics.checkNotNullParameter(r11, "shortToken");
        SsResponse r12 = j.a().getDebugSchema(new QrCodeRequest(r11)).execute();     // Catch: Exception -> L11
        if (r12.isSuccessful() == false) goto L8;
        OpenPlatformBaseResponse<OpenPlatformDebugSchemaData> r13 = (OpenPlatformBaseResponse) r12.body();     // Catch: Exception -> L11
        if (r13 == null) goto L19;
        return r13;
    L19:
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, "empty response body", null, null, 12, null);
    L8:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to getDebugSchema：code " + r12.code() + ", message: " + r12.message());     // Catch: Exception -> L11
        return new OpenPlatformBaseResponse(r12.code(), r12.message(), null, null, 8, null);
    L11:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to getDebugSchema.Exception: " + ExceptionsKt.stackTraceToString(e));
        String r14 = e.getMessage();
        if (r14 != null) goto L16;
        r14 = "";
    L16:
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, r14, null, null, 12, null);
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final OpenPlatformBaseResponse<OpenPlatformPublicKeyListData> getSignPublicKeys(String r11) {
        Intrinsics.checkNotNullParameter(r11, "packageName");
        SsResponse r12 = j.a().getSignPublicKeys(r11).execute();     // Catch: Exception -> L9
        if (r12.isSuccessful() == false) goto L6;
        Object r13 = r12.body();     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L9
        return (OpenPlatformBaseResponse) r13;
    L6:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to getSignPublicKeys：code " + r12.code() + ", message: " + r12.message());     // Catch: Exception -> L9
        return new OpenPlatformBaseResponse(r12.code(), r12.message(), null, null, 8, null);
    L9:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to getSignPublicKeys.Exception: " + ExceptionsKt.stackTraceToString(e));
        String r14 = e.getMessage();
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, r14, null, null, 12, null);
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse<AIPackageAppList> requestDeploymentInfoById(AIPackageNetworkRequest r28) {
        Intrinsics.checkNotNullParameter(r28, "request");
        if (StringsKt.isBlank(r28.getAid()) == true) goto L6;
        AIPackageNetworkRequest r0 = AIPackageNetworkRequest.copy$default(r28, null, null, c(), 3, null);     // Catch: Exception -> L89
    L8:
        AIPackageNetworkRequest r11 = r0;
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L89
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L89
        Iterator<T> r1 = r11.getAppList().iterator();     // Catch: Exception -> L89
    L10:
        if (r1.hasNext() == false) goto L15;
        AppRequestItem r13 = (AppRequestItem) r1.next();     // Catch: Exception -> L89
        if ((!AIManager.o.contains(r13.getPackageName())) == true) goto L13;
        r12.add(r13);     // Catch: Exception -> L89
        goto L10
    L13:
        r10.add(r13);     // Catch: Exception -> L89
        goto L10
    L15:
        com.bytedance.ai.utils.g.a.d("DefaultAIPackageNetService", "Deployment request split - OpenPlatform: " + r10.size() + " packages, Original: " + r12.size() + " packages");     // Catch: Exception -> L89
        Iterator r14 = r10.iterator();     // Catch: Exception -> L89
    L17:
        if (r14.hasNext() == false) goto L19;
        AppRequestItem r15 = (AppRequestItem) r14.next();     // Catch: Exception -> L89
        com.bytedance.ai.utils.g.a.d("DefaultAIPackageNetService", "Deployment OpenPlatform package: " + r15.getPackageName());     // Catch: Exception -> L89
        goto L17
    L19:
        Iterator r16 = r12.iterator();     // Catch: Exception -> L89
    L21:
        if (r16.hasNext() == false) goto L23;
        AppRequestItem r17 = (AppRequestItem) r16.next();     // Catch: Exception -> L89
        com.bytedance.ai.utils.g.a.d("DefaultAIPackageNetService", "Deployment Original package: " + r17.getPackageName());     // Catch: Exception -> L89
        goto L21
    L23:
        ArrayList r18 = new ArrayList();     // Catch: Exception -> L89
        boolean[] r19 = {false};     // Catch: Exception -> L89
        b r20 = new b(0);     // Catch: Exception -> L89
        if ((!r10.isEmpty()) == false) goto L69;
        b r110 = r20;
        char r111 = 0;
        SsResponse r21 = j.a().fetchAppletDownLoadInfoById(b(AIPackageNetworkRequest.copy$default(r11, r10, null, null, 6, null))).execute();     // Catch: Exception -> L67
        if (r21.isSuccessful() == false) goto L65;
        OpenPlatformBaseResponse r22 = (OpenPlatformBaseResponse) r21.body();     // Catch: Exception -> L67
        OpenPlatformAppletList r23 = (OpenPlatformAppletList) r22.getData();     // Catch: Exception -> L67
        if (r23 == null) goto L33;
        String r24 = r23.getSignaturePublicKeyVersion();     // Catch: Exception -> L67
        if (r24 == null) goto L33;
    L34:
        OpenPlatformAppletList r25 = (OpenPlatformAppletList) r22.getData();     // Catch: Exception -> L67
        if (r25 == null) goto L71;
        List<OpenPlatformAppletItem> r26 = r25.getAppletList();     // Catch: Exception -> L67
        if (r26 == null) goto L71;
        Iterator<T> r27 = r26.iterator();     // Catch: Exception -> L67
    L40:
        if (r27.hasNext() == false) goto L71;
        OpenPlatformAppletItem r29 = (OpenPlatformAppletItem) r27.next();     // Catch: Exception -> L67
        boolean r30 = Intrinsics.areEqual(r29.getVerifySignature(), Boolean.TRUE);     // Catch: Exception -> L67
        if (r30 == false) goto L44;
        f(r24);     // Catch: Exception -> L67
    L44:
        String r31 = r29.getAppId();     // Catch: Exception -> L67
        if (r31 != null) goto L47;
        String r112 = "";
    L48:
        String r32 = r29.getPackageName();     // Catch: Exception -> L67
        if (r32 != null) goto L51;
        String r210 = "";
    L52:
        String r33 = r29.getVersionCode();     // Catch: Exception -> L67
        if (r33 != null) goto L55;
        String r211 = "";
    L56:
        String r34 = r29.getDigest();     // Catch: Exception -> L67
        if (r34 != null) goto L59;
        String r212 = "";
    L60:
        String r35 = r29.getResourceUrl();     // Catch: Exception -> L67
        if (r35 != null) goto L63;
        String r213 = "";
    L64:
        r18.add(new AIPackageResponseItem(r112, r210, r211, r212, r213, r29.getResourceUrls(), r24, Boolean.valueOf(r30)));     // Catch: Exception -> L67
        goto L40
    L63:
        r213 = r35;
        goto L64
    L59:
        r212 = r34;
        goto L60
    L55:
        r211 = r33;
        goto L56
    L51:
        r210 = r32;
        goto L52
    L47:
        r112 = r31;
    L71:
        if ((!r12.isEmpty()) == true) goto L96;
    L87:
        return a(r18, r19[r111], r110);
    L96:
        SsResponse r36 = ((AIPackageNetApi) j.a.getValue()).requestDeploymentInfoById(AIPackageNetworkRequest.copy$default(r11, r12, null, null, 6, null)).execute();     // Catch: Exception -> L85
        if (r36.isSuccessful() == false) goto L83;
        AIPackageAppList r37 = (AIPackageAppList) ((AIPackageNetworkResponse) r36.body()).getData();     // Catch: Exception -> L85
        if (r37 == null) goto L87;
        List<AIPackageResponseItem> r38 = r37.getAppList();     // Catch: Exception -> L85
        if (r38 == null) goto L87;
        Iterator<T> r39 = r38.iterator();     // Catch: Exception -> L85
    L81:
        if (r39.hasNext() == false) goto L87;
        r18.add((AIPackageResponseItem) r39.next());     // Catch: Exception -> L85
        goto L81
    L83:
        d("Original", Integer.valueOf(r36.code()), r36.message(), r19, r110);     // Catch: Exception -> L85
    L85:
        e = move-exception;
        e("Original", e, r19, r110);     // Catch: Exception -> L89
        Unit r40 = Unit.INSTANCE;     // Catch: Exception -> L89
    L33:
        r24 = "";
        goto L34
    L65:
        d("OpenPlatform", Integer.valueOf(r21.code()), r21.message(), r19, r110);     // Catch: Exception -> L67
    L67:
        e = move-exception;
        e("OpenPlatform", e, r19, r110);     // Catch: Exception -> L89
        Unit r41 = Unit.INSTANCE;     // Catch: Exception -> L89
        goto L71
    L69:
        r110 = r20;
        r111 = 0;
        goto L71
    L6:
        r0 = AIPackageNetworkRequest.copy$default(r28, null, this.a, c(), 1, null);     // Catch: Exception -> L89
    L89:
        e = e;
    L93:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to request the deployment info : " + ExceptionsKt.stackTraceToString(e));
        return new AIPackageNetworkResponse(null, IServerListener.WHAT_BYTELINK_SINK_ERROR, null, 5, null);
    L91:
        e = e;
        goto L93
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse<AIPackageGeckoInfoList> requestGeckoInfo(AIPackageGeckoInfoRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        SsResponse r11 = ((AIPackageNetApi) j.a.getValue()).requestGeckoInfo(r10).execute();     // Catch: Exception -> L9
        if (r11.isSuccessful() == false) goto L6;
        Object r12 = r11.body();     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L9
        return (AIPackageNetworkResponse) r12;
    L6:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to request the gecko info : init error");     // Catch: Exception -> L9
        return new AIPackageNetworkResponse(null, r11.code(), r11.message());
    L9:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to request the gecko info : " + ExceptionsKt.stackTraceToString(e));
        return new AIPackageNetworkResponse(null, IServerListener.WHAT_BYTELINK_SINK_ERROR, null, 5, null);
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse<AIPackageAppList> requestPackageDeploymentInfo(AIPackageInfoRequest r24) {
        Intrinsics.checkNotNullParameter(r24, "request");
        if (StringsKt.isBlank(r24.getAid()) == true) goto L6;
        AIPackageInfoRequest r0 = AIPackageInfoRequest.copy$default(r24, null, null, c(), 3, null);     // Catch: Exception -> L75
    L8:
        AIPackageInfoRequest r10 = r0;
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L75
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L75
        Iterator<T> r12 = r24.getPackageList().iterator();     // Catch: Exception -> L75
    L11:
        if (r12.hasNext() == false) goto L16;
        PackageRequestItem r13 = (PackageRequestItem) r12.next();     // Catch: Exception -> L75
        AppRequestItem r14 = new AppRequestItem("", r13.getPackageName(), r13.getVersionCode());     // Catch: Exception -> L75
        if ((!AIManager.o.contains(r14.getPackageName())) == true) goto L14;
        r11.add(r14);     // Catch: Exception -> L75
        goto L11
    L14:
        r1.add(r14);     // Catch: Exception -> L75
        goto L11
    L16:
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L75
        boolean[] r16 = {false};     // Catch: Exception -> L75
        b r17 = new b(0);     // Catch: Exception -> L75
        if ((!r1.isEmpty()) == false) goto L58;
        SsResponse r18 = j.a().fetchAppletDownLoadInfo(b(new AIPackageNetworkRequest(r1, r10.getAid(), r10.getExtraInfo()))).execute();     // Catch: Exception -> L54
        if (r18.isSuccessful() == false) goto L52;
        OpenPlatformBaseResponse r19 = (OpenPlatformBaseResponse) r18.body();     // Catch: Exception -> L54
        OpenPlatformAppletList r110 = (OpenPlatformAppletList) r19.getData();     // Catch: Exception -> L54
        if (r110 == null) goto L25;
        String r111 = r110.getSignaturePublicKeyVersion();     // Catch: Exception -> L54
        if (r111 == null) goto L25;
    L26:
        OpenPlatformAppletList r20 = (OpenPlatformAppletList) r19.getData();     // Catch: Exception -> L54
        if (r20 == null) goto L58;
        List<OpenPlatformAppletItem> r21 = r20.getAppletList();     // Catch: Exception -> L54
        if (r21 == null) goto L58;
        Iterator<T> r22 = r21.iterator();     // Catch: Exception -> L54
    L32:
        if (r22.hasNext() == false) goto L58;
        OpenPlatformAppletItem r112 = (OpenPlatformAppletItem) r22.next();     // Catch: Exception -> L54
        boolean r113 = Intrinsics.areEqual(r112.getVerifySignature(), Boolean.TRUE);     // Catch: Exception -> L54
        if (r113 == false) goto L36;
        f(r111);     // Catch: Exception -> L54
    L36:
        String r114 = r112.getAppId();     // Catch: Exception -> L54
        if (r114 != null) goto L39;
        r114 = "";
    L39:
        String r115 = r112.getPackageName();     // Catch: Exception -> L54
        if (r115 != null) goto L42;
        r115 = "";
    L42:
        String r116 = r112.getVersionCode();     // Catch: Exception -> L54
        if (r116 != null) goto L45;
        r116 = "";
    L45:
        String r117 = r112.getDigest();     // Catch: Exception -> L54
        if (r117 != null) goto L48;
        r117 = "";
    L48:
        String r23 = r112.getResourceUrl();     // Catch: Exception -> L54
        if (r23 != null) goto L51;
        r23 = "";
    L51:
        r15.add(new AIPackageResponseItem(r114, r115, r116, r117, r23, r112.getResourceUrls(), r111, Boolean.valueOf(r113)));     // Catch: Exception -> L54
    L25:
        r111 = "";
        goto L26
    L52:
        d("OpenPlatform", Integer.valueOf(r18.code()), r18.message(), r16, r17);     // Catch: Exception -> L54
    L54:
        e = move-exception;
        e("OpenPlatform", e, r16, r17);     // Catch: Exception -> L75
        Unit r25 = Unit.INSTANCE;     // Catch: Exception -> L75
    L58:
        if ((!r11.isEmpty()) == true) goto L84;
    L73:
        return a(r15, r16[0], r17);
    L84:
        SsResponse r26 = ((AIPackageNetApi) j.a.getValue()).requestPackageDeploymentInfo(r10).execute();     // Catch: Exception -> L71
        if (r26.isSuccessful() == false) goto L69;
        AIPackageAppList r27 = (AIPackageAppList) ((AIPackageNetworkResponse) r26.body()).getData();     // Catch: Exception -> L71
        if (r27 == null) goto L73;
        List<AIPackageResponseItem> r28 = r27.getAppList();     // Catch: Exception -> L71
        if (r28 == null) goto L73;
        Iterator<T> r29 = r28.iterator();     // Catch: Exception -> L71
    L67:
        if (r29.hasNext() == false) goto L73;
        r15.add((AIPackageResponseItem) r29.next());     // Catch: Exception -> L71
        goto L67
    L69:
        d("Original", Integer.valueOf(r26.code()), r26.message(), r16, r17);     // Catch: Exception -> L71
    L71:
        e = move-exception;
        e("Original", e, r16, r17);     // Catch: Exception -> L75
        goto L73
    L6:
        r0 = AIPackageInfoRequest.copy$default(r24, null, this.a, c(), 1, null);     // Catch: Exception -> L75
    L75:
        e = e;
    L79:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to request the package deployment info : " + ExceptionsKt.stackTraceToString(e));
        return new AIPackageNetworkResponse(null, IServerListener.WHAT_BYTELINK_SINK_ERROR, null, 5, null);
    L77:
        e = e;
        goto L79
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse<AIPackageAppList> requestPreInstallListByApp(AIPackageBaseRequest r11) {
        Intrinsics.checkNotNullParameter(r11, "request");
    L14:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to request the pre-install list with aid: " + r11.getAid() + ": " + ExceptionsKt.stackTraceToString(e));
        return new AIPackageNetworkResponse(null, IServerListener.WHAT_BYTELINK_SINK_ERROR, null, 5, null);
    L4:
        if (r11.getAid() == null) goto L7;
        AIPackageBaseRequest r10 = AIPackageBaseRequest.copy$default(r11, null, c(), 1, null);     // Catch: Exception -> L14
        if (r10 == null) goto L7;
    L8:
        SsResponse r12 = ((AIPackageNetApi) j.a.getValue()).requestPreInstallListByApp(r10).execute();     // Catch: Exception -> L14
        if (r12.isSuccessful() == false) goto L11;
        Object r13 = r12.body();     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L14
        return (AIPackageNetworkResponse) r13;
    L11:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to request the pre-install list with aid: " + r11.getAid() + ": init error");     // Catch: Exception -> L14
        return new AIPackageNetworkResponse(null, r12.code(), r12.message());
    L7:
        r10 = r11.copy(this.a, c());     // Catch: Exception -> L14
        goto L8
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse<AIPackageAppList> requestUpdateInfo(AIPackageNetworkRequest r26) {
        Intrinsics.checkNotNullParameter(r26, "request");
        if (StringsKt.isBlank(r26.getAid()) == true) goto L6;
        AIPackageNetworkRequest r0 = AIPackageNetworkRequest.copy$default(r26, null, null, c(), 3, null);     // Catch: Exception -> L81
    L8:
        AIPackageNetworkRequest r10 = r0;
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L81
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L81
        Iterator<T> r1 = r10.getAppList().iterator();     // Catch: Exception -> L81
    L10:
        if (r1.hasNext() == false) goto L15;
        AppRequestItem r13 = (AppRequestItem) r1.next();     // Catch: Exception -> L81
        if ((!AIManager.o.contains(r13.getPackageName())) == true) goto L13;
        r12.add(r13);     // Catch: Exception -> L81
        goto L10
    L13:
        r11.add(r13);     // Catch: Exception -> L81
        goto L10
    L15:
        ArrayList r14 = new ArrayList();     // Catch: Exception -> L81
        boolean[] r15 = {false};     // Catch: Exception -> L81
        b r16 = new b(0);     // Catch: Exception -> L81
        if ((!r11.isEmpty()) == false) goto L61;
        b r17 = r16;
        SsResponse r18 = j.a().checkAppletUpdate(b(AIPackageNetworkRequest.copy$default(r10, r11, null, null, 6, null))).execute();     // Catch: Exception -> L59
        if (r18.isSuccessful() == false) goto L57;
        OpenPlatformBaseResponse r19 = (OpenPlatformBaseResponse) r18.body();     // Catch: Exception -> L59
        OpenPlatformAppletList r20 = (OpenPlatformAppletList) r19.getData();     // Catch: Exception -> L59
        if (r20 == null) goto L25;
        String r21 = r20.getSignaturePublicKeyVersion();     // Catch: Exception -> L59
        if (r21 == null) goto L25;
    L26:
        OpenPlatformAppletList r22 = (OpenPlatformAppletList) r19.getData();     // Catch: Exception -> L59
        if (r22 == null) goto L63;
        List<OpenPlatformAppletItem> r23 = r22.getAppletList();     // Catch: Exception -> L59
        if (r23 == null) goto L63;
        Iterator<T> r24 = r23.iterator();     // Catch: Exception -> L59
    L32:
        if (r24.hasNext() == false) goto L63;
        OpenPlatformAppletItem r25 = (OpenPlatformAppletItem) r24.next();     // Catch: Exception -> L59
        boolean r27 = Intrinsics.areEqual(r25.getVerifySignature(), Boolean.TRUE);     // Catch: Exception -> L59
        if (r27 == false) goto L36;
        f(r21);     // Catch: Exception -> L59
    L36:
        String r28 = r25.getAppId();     // Catch: Exception -> L59
        if (r28 != null) goto L39;
        String r110 = "";
    L40:
        String r29 = r25.getPackageName();     // Catch: Exception -> L59
        if (r29 != null) goto L43;
        String r111 = "";
    L44:
        String r30 = r25.getVersionCode();     // Catch: Exception -> L59
        if (r30 != null) goto L47;
        String r112 = "";
    L48:
        String r31 = r25.getDigest();     // Catch: Exception -> L59
        if (r31 != null) goto L51;
        String r210 = "";
    L52:
        String r32 = r25.getResourceUrl();     // Catch: Exception -> L59
        if (r32 != null) goto L55;
        String r211 = "";
    L56:
        r14.add(new AIPackageResponseItem(r110, r111, r112, r210, r211, r25.getResourceUrls(), r21, Boolean.valueOf(r27)));     // Catch: Exception -> L59
        goto L32
    L55:
        r211 = r32;
        goto L56
    L51:
        r210 = r31;
        goto L52
    L47:
        r112 = r30;
        goto L48
    L43:
        r111 = r29;
        goto L44
    L39:
        r110 = r28;
    L63:
        if ((!r12.isEmpty()) == true) goto L87;
    L79:
        return a(r14, r15[0], r17);
    L87:
        SsResponse r33 = ((AIPackageNetApi) j.a.getValue()).requestUpdateInfo(AIPackageNetworkRequest.copy$default(r10, r12, null, null, 6, null)).execute();     // Catch: Exception -> L77
        if (r33.isSuccessful() == false) goto L75;
        AIPackageAppList r34 = (AIPackageAppList) ((AIPackageNetworkResponse) r33.body()).getData();     // Catch: Exception -> L77
        if (r34 == null) goto L79;
        List<AIPackageResponseItem> r35 = r34.getAppList();     // Catch: Exception -> L77
        if (r35 == null) goto L79;
        Iterator<T> r36 = r35.iterator();     // Catch: Exception -> L77
    L73:
        if (r36.hasNext() == false) goto L79;
        r14.add((AIPackageResponseItem) r36.next());     // Catch: Exception -> L77
        goto L73
    L75:
        d("Original", Integer.valueOf(r33.code()), r33.message(), r15, r17);     // Catch: Exception -> L77
    L77:
        e = move-exception;
        e("Original", e, r15, r17);     // Catch: Exception -> L81
        Unit r37 = Unit.INSTANCE;     // Catch: Exception -> L81
    L25:
        r21 = "";
        goto L26
    L57:
        d("OpenPlatform", Integer.valueOf(r18.code()), r18.message(), r15, r17);     // Catch: Exception -> L59
    L59:
        e = move-exception;
        e("OpenPlatform", e, r15, r17);     // Catch: Exception -> L81
        Unit r38 = Unit.INSTANCE;     // Catch: Exception -> L81
        goto L63
    L61:
        r17 = r16;
        goto L63
    L6:
        r0 = AIPackageNetworkRequest.copy$default(r26, null, this.a, c(), 1, null);     // Catch: Exception -> L81
    L81:
        e = e;
    L85:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to request the update info : " + ExceptionsKt.stackTraceToString(e));
        return new AIPackageNetworkResponse(null, IServerListener.WHAT_BYTELINK_SINK_ERROR, null, 5, null);
    L83:
        e = e;
        goto L85
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final OpenPlatformBaseResponse<OpenPlatformDekDecryptResponseData> decryptDek(String r10, OpenPlatformDekDecryptRequest r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "request");
        SsResponse r12 = j.a().decryptDek(r10, r11).execute();     // Catch: Exception -> L9
        if (r12.isSuccessful() == false) goto L6;
        Object r13 = r12.body();     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L9
        return (OpenPlatformBaseResponse) r13;
    L6:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to decryptDek：code " + r12.code() + ", message: " + r12.message());     // Catch: Exception -> L9
        return new OpenPlatformBaseResponse(r12.code(), r12.message(), null, null, 8, null);
    L9:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to decryptDek.Exception: " + ExceptionsKt.stackTraceToString(e));
        String r14 = e.getMessage();
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, r14, null, null, 12, null);
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final OpenPlatformBaseResponse<OpenPlatformPreviewAppInfoList> getPreviewAppInfoList(String r12, OpenPlatformPreviewAppInfoRequest r13) {
        Intrinsics.checkNotNullParameter(r12, "xToken");
        Intrinsics.checkNotNullParameter(r13, "request");
        com.bytedance.ai.utils.g r10 = com.bytedance.ai.utils.g.a;     // Catch: Exception -> L11
        r10.i("DefaultAIPackageNetService", "getPreviewAppInfoList. mode: " + r13.getMode() + ", cursor: " + r13.getCursor() + ", limit: " + r13.getLimit());     // Catch: Exception -> L11
        SsResponse r14 = ((OpenPlatformNetApi) j.c.getValue()).getPreviewAppInfoList(r12, 2, "application/json", r13).execute();     // Catch: Exception -> L11
        if (r14.isSuccessful() == false) goto L8;
        OpenPlatformBaseResponse<OpenPlatformPreviewAppInfoList> r15 = (OpenPlatformBaseResponse) r14.body();     // Catch: Exception -> L11
        if (r15 == null) goto L19;
        return r15;
    L19:
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, "empty response body", null, null, 12, null);
    L8:
        r10.e("DefaultAIPackageNetService", "Failed to getPreviewAppInfoList: code " + r14.code() + ", message: " + r14.message());     // Catch: Exception -> L11
        return new OpenPlatformBaseResponse(r14.code(), r14.message(), null, null, 8, null);
    L11:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to getPreviewAppInfoList.Exception: " + ExceptionsKt.stackTraceToString(e));
        String r16 = e.getMessage();
        if (r16 != null) goto L16;
        r16 = "";
    L16:
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, r16, null, null, 12, null);
    }

    public static AIPackageNetworkResponse a(List r10, boolean r11, b r12) {
        if ((!r10.isEmpty()) == false) goto L12;
        AIPackageAppList r1 = new AIPackageAppList(r10);
        if (r11 == false) goto L7;
        int r13 = r12.a;
    L8:
        if (r11 == false) goto L10;
        String r14 = r12.b;
    L16:
        return new AIPackageNetworkResponse(r1, r13, r14);
    L10:
        r14 = "Success";
        goto L16
    L7:
        r13 = 0;
        goto L8
    L12:
        if (r11 == false) goto L15;
        return new AIPackageNetworkResponse(null, r12.a, r12.b);
    L15:
        return new AIPackageNetworkResponse(new AIPackageAppList(CollectionsKt.emptyList()), 0, null, 6, null);
    }

    public static void e(String r1, Exception r10, boolean[] r11, b r12) {
        String r13 = r1 + " API exception: " + r10.getMessage();
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", r13);
        r11[0] = true;
        r12.a = -1;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.b = r13;
    }

    public static void d(String r10, Integer r11, String r12, boolean[] r13, b r14) {
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", r10 + " API failed with code: " + r11 + ", message: " + r12);
        r13[0] = true;
        if (r11 == null) goto L5;
        int r15 = r11.intValue();
    L6:
        r14.a = r15;
        if (r12 != null) goto L9;
        r12 = r10.concat(" API failed");
    L9:
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r14.b = r12;
        return;
    L5:
        r15 = -1;
        goto L6
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final OpenPlatformBaseResponse<OpenPlatformPreviewAppVersionList> getPreviewAppVersionList(String r18, String r19, String r20, String r21, String r22, int r23) {
        String r1 = r22;
        Intrinsics.checkNotNullParameter(r18, "appKey");
        Intrinsics.checkNotNullParameter(r19, "deviceId");
        Intrinsics.checkNotNullParameter(r20, "mode");
        Intrinsics.checkNotNullParameter(r21, "xToken");
        Intrinsics.checkNotNullParameter(r1, "cursor");
        com.bytedance.ai.utils.g r11 = com.bytedance.ai.utils.g.a;     // Catch: Exception -> L15
        r11.i("DefaultAIPackageNetService", "getPreviewAppVersionList. appKey: " + r18 + ", mode: " + r20 + ", cursor: " + r1 + ", limit: " + r23);     // Catch: Exception -> L15
        OpenPlatformNetApi r10 = (OpenPlatformNetApi) j.c.getValue();     // Catch: Exception -> L15
        if ((!StringsKt.isBlank(r22)) == true) goto L7;
        r1 = null;
    L7:
        SsResponse r0 = r10.getPreviewAppVersionList(r21, 2, r18, r19, r20, r1, r23).execute();     // Catch: Exception -> L15
        if (r0.isSuccessful() == false) goto L12;
        OpenPlatformBaseResponse<OpenPlatformPreviewAppVersionList> r12 = (OpenPlatformBaseResponse) r0.body();     // Catch: Exception -> L15
        if (r12 == null) goto L23;
        return r12;
    L23:
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, "empty response body", null, null, 12, null);
    L12:
        r11.e("DefaultAIPackageNetService", "Failed to getPreviewAppVersionList: code " + r0.code() + ", message: " + r0.message());     // Catch: Exception -> L15
        return new OpenPlatformBaseResponse(r0.code(), r0.message(), null, null, 8, null);
    L15:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to getPreviewAppVersionList.Exception: " + ExceptionsKt.stackTraceToString(e));
        String r13 = e.getMessage();
        if (r13 != null) goto L20;
        r13 = "";
    L20:
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, r13, null, null, 12, null);
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final OpenPlatformBaseResponse<IsInAppWhitelistData> requestDebugDeploymentInfo(int r19, String r20, long r21, String r23, String r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r20, "packageName");
        Intrinsics.checkNotNullParameter(r24, "deviceId");
        Intrinsics.checkNotNullParameter(r25, BdpShareBaseInfo.CHANNEL_TOKEN);
        Intrinsics.checkNotNullParameter(r26, "xToken");
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L54
        boolean r12 = true;
        if (r23 != null) goto L6;
    L9:
        boolean r11 = true;
    L11:
        if (r11 == false) goto L13;
        String r13 = String.valueOf(r21);     // Catch: Exception -> L54
    L14:
        r10.add(new OpenPlatformPackageItem(r13, null, r20, 2, null));     // Catch: Exception -> L54
        ExtraInfo r14 = c();     // Catch: Exception -> L54
        if (r14 == null) goto L25;
        OpenPlatformExtraInfo r15 = new OpenPlatformExtraInfo(r14.getDeviceId(), r14.getLane(), r14.getChannel(), r14.getAppVersion());     // Catch: Exception -> L54
        String r16 = r15.getDeviceId();     // Catch: Exception -> L54
        if (r16 != null) goto L19;
    L22:
        if (r12 == false) goto L24;
        r15 = OpenPlatformExtraInfo.copy$default(r15, r24, null, null, null, 14, null);     // Catch: Exception -> L54
    L24:
        OpenPlatformExtraInfo r17 = r15;
    L26:
        SsResponse r0 = j.a().isInAppWhitelist(r26, 2, new IsInAppWhitelistRequest(r19, r24, r20, r23, r25, this.a, r10, r17)).execute();     // Catch: Exception -> L52
        if (r0.isSuccessful() == false) goto L49;
        OpenPlatformBaseResponse<IsInAppWhitelistData> r1 = (OpenPlatformBaseResponse) r0.body();     // Catch: Exception -> L52
        if (r1 == null) goto L33;
        IsInAppWhitelistData r18 = r1.getData();     // Catch: Exception -> L52
        if (r18 == null) goto L38;
        String r22 = r18.getSignaturePublicKeyVersion();     // Catch: Exception -> L52
        if (r22 == null) goto L38;
    L39:
        IsInAppWhitelistData r27 = r1.getData();     // Catch: Exception -> L52
        if (r27 == null) goto L66;
        List<OpenPlatformAppletItem> r28 = r27.getAppletList();     // Catch: Exception -> L52
        if (r28 == null) goto L67;
        Iterator<T> r29 = r28.iterator();     // Catch: Exception -> L52
    L45:
        if (r29.hasNext() == false) goto L68;
        if (Intrinsics.areEqual(((OpenPlatformAppletItem) r29.next()).getVerifySignature(), Boolean.TRUE) == false) goto L45;
        f(r22);     // Catch: Exception -> L52
        goto L45
    L68:
        return r1;
    L67:
        return r1;
    L66:
        return r1;
    L38:
        r22 = "";
        goto L39
    L33:
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, "empty response body", null, null, 12, null);
    L49:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to getRemoteDebugInfo：code " + r0.code() + ", message: " + r0.message());     // Catch: Exception -> L52
        return new OpenPlatformBaseResponse(r0.code(), r0.message(), null, null, 8, null);
    L52:
        e = e;
    L56:
        com.bytedance.ai.utils.g.a.e("DefaultAIPackageNetService", "Failed to getRemoteDebugInfo.Exception: " + ExceptionsKt.stackTraceToString(e));
        return new OpenPlatformBaseResponse(IServerListener.WHAT_BYTELINK_SINK_ERROR, "", null, null, 12, null);
    L19:
        if (StringsKt.isBlank(r16) == true) goto L22;
        r12 = false;
        goto L22
    L25:
        r17 = null;
        goto L26
    L13:
        r13 = null;
        goto L14
    L6:
        if (r23.length() == 0) goto L9;
        r11 = false;
    L54:
        e = e;
        goto L56
    }
}
