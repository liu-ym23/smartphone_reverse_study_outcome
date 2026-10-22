package com.bytedance.ai.resource.core.net;

import ai.j0;
import com.bytedance.ai.resource.IAIPackageNetService;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageBaseRequest;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.AppRequestItem;
import com.bytedance.ai.resource.core.bean.ExtraInfo;
import com.bytedance.ai.resource.core.bean.FetchAppletDownLoadInfoRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformExtraInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformPackageItem;
import com.bytedance.ai.resource.core.bean.PackageRequestItem;
import com.bytedance.ai.utils.c;
import com.lynx.tasm.ui.image.f0;
import com.lynx.tasm.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/resource/core/net/DefaultAIPackageNetService;", "Lcom/bytedance/ai/resource/IAIPackageNetService;", "ErrorInfo", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultAIPackageNetService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultAIPackageNetService.kt\ncom/bytedance/ai/resource/core/net/DefaultAIPackageNetService\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,402:1\n1557#2:403\n1628#2,3:404\n1863#2,2:407\n1863#2,2:409\n1863#2,2:411\n1863#2,2:413\n1863#2,2:415\n1863#2,2:417\n1863#2,2:419\n1863#2,2:421\n1863#2,2:423\n1863#2,2:425\n1863#2,2:427\n*S KotlinDebug\n*F\n+ 1 DefaultAIPackageNetService.kt\ncom/bytedance/ai/resource/core/net/DefaultAIPackageNetService\n*L\n66#1:403\n66#1:404,3\n138#1:407,2\n147#1:409,2\n148#1:411,2\n162#1:413,2\n191#1:415,2\n225#1:417,2\n245#1:419,2\n273#1:421,2\n324#1:423,2\n354#1:425,2\n381#1:427,2\n*E\n"})
public final class DefaultAIPackageNetService implements IAIPackageNetService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2672a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/net/DefaultAIPackageNetService$ErrorInfo;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ErrorInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2674b;

        public ErrorInfo() {
            Intrinsics.checkNotNullParameter("Unknown error", "message");
            this.f2673a = -1;
            this.f2674b = "Unknown error";
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ErrorInfo) == true) goto L8;
            return false;
        L8:
            ErrorInfo r10 = (ErrorInfo) r5;
            if (this.f2673a == r10.f2673a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f2674b, r10.f2674b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r5 = Integer.hashCode(this.f2673a) * 31;
            return this.f2674b.hashCode() + r5;
        }

        public final String toString() {
            StringBuilder r5 = new StringBuilder("ErrorInfo(code=");
            r5.append(this.f2673a);
            r5.append(", message=");
            return j0.p(r5, this.f2674b, ')');
        }
    }

    public DefaultAIPackageNetService() {
        u0.a r5 = s0.a.f21800c;
        if (r5 == null) goto L6;
        String r10 = Integer.valueOf(r5.d).toString();
        if (r10 == null) goto L6;
    L7:
        this.f2672a = r10;
        return;
    L6:
        r10 = "";
        goto L7
    }

    public static void a(String r5, Exception r10, boolean[] r11, ErrorInfo r12) {
        String r13 = f0.d(r10, j.d(r5, " API exception: "), "DefaultAIPackageNetService");
        d r14 = c.f2846a;
        if (r14 == null) goto L5;
        r14.e("DefaultAIPackageNetService", r13);
    L5:
        r11[0] = true;
        r12.f2673a = -1;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.f2674b = r13;
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse requestDeploymentInfoById(AIPackageNetworkRequest r13) {
        Intrinsics.checkNotNullParameter(r13, "request");
    L6:
        e = move-exception;
        String r12 = i.a.h(e, new StringBuilder("Failed to request the deployment info : "), "DefaultAIPackageNetService");
        d r14 = c.f2846a;
        if (r14 == null) goto L61;
        r14.e("DefaultAIPackageNetService", r12);
    L61:
        return new AIPackageNetworkResponse(null, 0, null, 7, null);
    L4:
        if (StringsKt.isBlank(r13.getAid()) == false) goto L8;
        AIPackageNetworkRequest r15 = AIPackageNetworkRequest.copy$default(r13, null, this.f2672a, a(), 1, null);     // Catch: Exception -> L6
    L9:
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L6
        ArrayList r16 = new ArrayList();     // Catch: Exception -> L6
        Iterator<T> r10 = r15.getAppList().iterator();     // Catch: Exception -> L6
    L11:
        if (r10.hasNext() == false) goto L16;
        AppRequestItem r11 = (AppRequestItem) r10.next();     // Catch: Exception -> L6
        if (com.bytedance.ai.resource.j.f2741l.contains(r11.getPackageName()) == false) goto L14;
        r16.add(r11);     // Catch: Exception -> L6
        goto L11
    L14:
        r5.add(r11);     // Catch: Exception -> L6
        goto L11
    L16:
        String r17 = "Deployment request split - OpenPlatform: " + r5.size() + " packages, Original: " + r16.size() + " packages";     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter("DefaultAIPackageNetService", "tag");     // Catch: Exception -> L6
        d r18 = c.f2846a;     // Catch: Exception -> L6
        if (r18 == null) goto L19;
        r18.d("DefaultAIPackageNetService", r17);     // Catch: Exception -> L6
    L19:
        Iterator r19 = r5.iterator();     // Catch: Exception -> L6
    L21:
        if (r19.hasNext() == false) goto L25;
        String r20 = "Deployment OpenPlatform package: " + ((AppRequestItem) r19.next()).getPackageName();     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter("DefaultAIPackageNetService", "tag");     // Catch: Exception -> L6
        d r21 = c.f2846a;     // Catch: Exception -> L6
        if (r21 == null) goto L21;
        r21.d("DefaultAIPackageNetService", r20);     // Catch: Exception -> L6
        goto L21
    L25:
        Iterator r22 = r16.iterator();     // Catch: Exception -> L6
    L27:
        if (r22.hasNext() == false) goto L31;
        String r23 = "Deployment Original package: " + ((AppRequestItem) r22.next()).getPackageName();     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter("DefaultAIPackageNetService", "tag");     // Catch: Exception -> L6
        d r24 = c.f2846a;     // Catch: Exception -> L6
        if (r24 == null) goto L27;
        r24.d("DefaultAIPackageNetService", r23);     // Catch: Exception -> L6
        goto L27
    L31:
        ArrayList r25 = new ArrayList();     // Catch: Exception -> L6
        boolean[] r26 = {false};     // Catch: Exception -> L6
        ErrorInfo r110 = new ErrorInfo();     // Catch: Exception -> L6
        if (r5.isEmpty() == true) goto L44;
        a(AIPackageNetworkRequest.copy$default(r15, r5, null, null, 6, null));     // Catch: Exception -> L6
    L38:
        e = move-exception;
        a("OpenPlatform", e, r26, r110);     // Catch: Exception -> L6
        Unit r27 = Unit.INSTANCE;     // Catch: Exception -> L6
        goto L44
    L36:
        if (AISDKApiManager.f2671b.getValue() != null) goto L41;
        throw null;     // Catch: Exception -> L38
    L41:
        throw new ClassCastException();     // Catch: Exception -> L38
    L44:
        if (r16.isEmpty() == true) goto L56;
        AIPackageNetworkRequest.copy$default(r15, r16, null, null, 6, null);     // Catch: Exception -> L6
    L50:
        e = move-exception;
        a("Original", e, r26, r110);     // Catch: Exception -> L6
        Unit r111 = Unit.INSTANCE;     // Catch: Exception -> L6
        goto L56
    L48:
        if (AISDKApiManager.f2670a.getValue() != null) goto L53;
        throw null;     // Catch: Exception -> L50
    L53:
        throw new ClassCastException();     // Catch: Exception -> L50
    L56:
        return a(r25, r26[0], r110);
    L8:
        r15 = AIPackageNetworkRequest.copy$default(r13, null, null, a(), 3, null);     // Catch: Exception -> L6
        goto L9
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse requestGeckoInfo(AIPackageGeckoInfoRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
    L7:
        e = move-exception;
        String r11 = i.a.h(e, new StringBuilder("Failed to request the gecko info : "), "DefaultAIPackageNetService");
        d r12 = c.f2846a;
        if (r12 == null) goto L15;
        r12.e("DefaultAIPackageNetService", r11);
    L15:
        return new AIPackageNetworkResponse(null, 0, null, 7, null);
    L4:
        if (AISDKApiManager.f2670a.getValue() != null) goto L10;
        throw null;     // Catch: Exception -> L7
    L10:
        throw new ClassCastException();     // Catch: Exception -> L7
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse requestPackageDeploymentInfo(AIPackageInfoRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
    L6:
        e = move-exception;
        String r11 = i.a.h(e, new StringBuilder("Failed to request the package deployment info : "), "DefaultAIPackageNetService");
        d r12 = c.f2846a;
        if (r12 == null) goto L45;
        r12.e("DefaultAIPackageNetService", r11);
    L45:
        return new AIPackageNetworkResponse(null, 0, null, 7, null);
    L4:
        if (StringsKt.isBlank(r10.getAid()) == false) goto L8;
        AIPackageInfoRequest r13 = AIPackageInfoRequest.copy$default(r10, null, this.f2672a, a(), 1, null);     // Catch: Exception -> L6
    L9:
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L6
        ArrayList r14 = new ArrayList();     // Catch: Exception -> L6
        Iterator<T> r15 = r10.getPackageList().iterator();     // Catch: Exception -> L6
    L11:
        if (r15.hasNext() == false) goto L16;
        PackageRequestItem r16 = (PackageRequestItem) r15.next();     // Catch: Exception -> L6
        AppRequestItem r17 = new AppRequestItem("", r16.getPackageName(), r16.getVersionCode());     // Catch: Exception -> L6
        if (com.bytedance.ai.resource.j.f2741l.contains(r17.getPackageName()) == false) goto L14;
        r14.add(r17);     // Catch: Exception -> L6
        goto L11
    L14:
        r5.add(r17);     // Catch: Exception -> L6
        goto L11
    L16:
        ArrayList r18 = new ArrayList();     // Catch: Exception -> L6
        boolean[] r19 = {false};     // Catch: Exception -> L6
        ErrorInfo r20 = new ErrorInfo();     // Catch: Exception -> L6
        if (r5.isEmpty() == true) goto L29;
        a(new AIPackageNetworkRequest(r5, r13.getAid(), r13.getExtraInfo()));     // Catch: Exception -> L6
    L23:
        e = move-exception;
        a("OpenPlatform", e, r19, r20);     // Catch: Exception -> L6
        Unit r21 = Unit.INSTANCE;     // Catch: Exception -> L6
        goto L29
    L21:
        if (AISDKApiManager.f2671b.getValue() != null) goto L26;
        throw null;     // Catch: Exception -> L23
    L26:
        throw new ClassCastException();     // Catch: Exception -> L23
    L29:
        if (r14.isEmpty() == true) goto L40;
    L34:
        e = move-exception;
        a("Original", e, r19, r20);     // Catch: Exception -> L6
        goto L40
    L32:
        if (AISDKApiManager.f2670a.getValue() != null) goto L37;
        throw null;     // Catch: Exception -> L34
    L37:
        throw new ClassCastException();     // Catch: Exception -> L34
    L40:
        return a(r18, r19[0], r20);
    L8:
        r13 = AIPackageInfoRequest.copy$default(r10, null, null, a(), 3, null);     // Catch: Exception -> L6
        goto L9
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse requestPreInstallList() {
        return requestPreInstallListByApp(new AIPackageBaseRequest(this.f2672a, null, 2, null));
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse requestPreInstallListByApp(AIPackageBaseRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
    L8:
        e = move-exception;
        StringBuilder r5 = new StringBuilder("Failed to request the pre-install list with aid: ");
        r5.append(r10.getAid());
        r5.append(": ");
        String r11 = i.a.h(e, r5, "DefaultAIPackageNetService");
        d r12 = c.f2846a;
        if (r12 == null) goto L20;
        r12.e("DefaultAIPackageNetService", r11);
    L20:
        return new AIPackageNetworkResponse(null, 0, null, 7, null);
    L4:
        if (r10.getAid() != null) goto L6;
    L10:
        r10.copy(this.f2672a, a());     // Catch: Exception -> L8
    L12:
        if (AISDKApiManager.f2670a.getValue() != null) goto L15;
        throw null;     // Catch: Exception -> L8
    L15:
        throw new ClassCastException();     // Catch: Exception -> L8
    L6:
        if (AIPackageBaseRequest.copy$default(r10, null, a(), 1, null) != null) goto L12;
        goto L10
    }

    @Override // com.bytedance.ai.resource.IAIPackageNetService
    public final AIPackageNetworkResponse requestUpdateInfo(AIPackageNetworkRequest r12) {
        Intrinsics.checkNotNullParameter(r12, "request");
    L6:
        e = move-exception;
        String r11 = i.a.h(e, new StringBuilder("Failed to request the update info : "), "DefaultAIPackageNetService");
        d r13 = c.f2846a;
        if (r13 == null) goto L46;
        r13.e("DefaultAIPackageNetService", r11);
    L46:
        return new AIPackageNetworkResponse(null, 0, null, 7, null);
    L4:
        if (StringsKt.isBlank(r12.getAid()) == false) goto L8;
        AIPackageNetworkRequest r14 = AIPackageNetworkRequest.copy$default(r12, null, this.f2672a, a(), 1, null);     // Catch: Exception -> L6
    L9:
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L6
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L6
        Iterator<T> r10 = r14.getAppList().iterator();     // Catch: Exception -> L6
    L11:
        if (r10.hasNext() == false) goto L16;
        AppRequestItem r16 = (AppRequestItem) r10.next();     // Catch: Exception -> L6
        if (com.bytedance.ai.resource.j.f2741l.contains(r16.getPackageName()) == false) goto L14;
        r15.add(r16);     // Catch: Exception -> L6
        goto L11
    L14:
        r5.add(r16);     // Catch: Exception -> L6
        goto L11
    L16:
        ArrayList r17 = new ArrayList();     // Catch: Exception -> L6
        boolean[] r18 = {false};     // Catch: Exception -> L6
        ErrorInfo r19 = new ErrorInfo();     // Catch: Exception -> L6
        if (r5.isEmpty() == true) goto L29;
        a(AIPackageNetworkRequest.copy$default(r14, r5, null, null, 6, null));     // Catch: Exception -> L6
    L23:
        e = move-exception;
        a("OpenPlatform", e, r18, r19);     // Catch: Exception -> L6
        Unit r20 = Unit.INSTANCE;     // Catch: Exception -> L6
        goto L29
    L21:
        if (AISDKApiManager.f2671b.getValue() != null) goto L26;
        throw null;     // Catch: Exception -> L23
    L26:
        throw new ClassCastException();     // Catch: Exception -> L23
    L29:
        if (r15.isEmpty() == true) goto L41;
        AIPackageNetworkRequest.copy$default(r14, r15, null, null, 6, null);     // Catch: Exception -> L6
    L35:
        e = move-exception;
        a("Original", e, r18, r19);     // Catch: Exception -> L6
        Unit r110 = Unit.INSTANCE;     // Catch: Exception -> L6
        goto L41
    L33:
        if (AISDKApiManager.f2670a.getValue() != null) goto L38;
        throw null;     // Catch: Exception -> L35
    L38:
        throw new ClassCastException();     // Catch: Exception -> L35
    L41:
        return a(r17, r18[0], r19);
    L8:
        r14 = AIPackageNetworkRequest.copy$default(r12, null, null, a(), 3, null);     // Catch: Exception -> L6
        goto L9
    }

    public static ExtraInfo a() {
        u0.a r5 = s0.a.f21800c;
        if (r5 == null) goto L9;
        String r10 = r5.f22195b;
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        String r11 = r5.f22197h;
        String r12 = r5.e;
        return new ExtraInfo(r10, r5.f22206q, r11, r12);
    L9:
        return null;
    }

    public static AIPackageNetworkResponse a(ArrayList r10, boolean r11, ErrorInfo r12) {
        if (r10.isEmpty() == true) goto L13;
        AIPackageAppList r5 = new AIPackageAppList(r10);
        if (r11 == false) goto L7;
        int r13 = r12.f2673a;
    L8:
        if (r11 == false) goto L10;
        String r14 = r12.f2674b;
    L12:
        return new AIPackageNetworkResponse(r5, r13, r14);
    L10:
        r14 = "Success";
        goto L12
    L7:
        r13 = 0;
        goto L8
    L13:
        if (r11 == false) goto L17;
        return new AIPackageNetworkResponse(null, r12.f2673a, r12.f2674b);
    L17:
        return new AIPackageNetworkResponse(new AIPackageAppList(CollectionsKt.emptyList()), 0, null, 6, null);
    }

    public static void a(AIPackageNetworkRequest r10) {
        List<AppRequestItem> r5 = r10.getAppList();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        AppRequestItem r13 = (AppRequestItem) r12.next();
        r11.add(new OpenPlatformPackageItem(r13.getVersionCode(), r13.getAppId(), r13.getPackageName()));
        goto L4
    L6:
        ExtraInfo r14 = r10.getExtraInfo();
        if (r14 == null) goto L9;
        OpenPlatformExtraInfo r15 = new OpenPlatformExtraInfo(r14.getDeviceId(), r14.getLane(), r14.getChannel(), r14.getAppVersion());
    L10:
        new FetchAppletDownLoadInfoRequest(r10.getAid(), r11, r15);
        return;
    L9:
        r15 = null;
        goto L10
    }
}
