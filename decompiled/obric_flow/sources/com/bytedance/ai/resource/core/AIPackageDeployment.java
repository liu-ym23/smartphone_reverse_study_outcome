package com.bytedance.ai.resource.core;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.resource.IAIPackageNetService;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.resource.core.bean.AppRequestItem;
import com.bytedance.ai.resource.core.net.AIPackageTTNET;
import com.bytedance.ai.resource.k;
import com.bytedance.ai.utils.c;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import t0.d;
import ym.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackageDeployment;", "", "AIPackageDeploymentItem", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAIPackageDeployment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageDeployment.kt\ncom/bytedance/ai/resource/core/AIPackageDeployment\n+ 2 AIPackageNetworkResponse.kt\ncom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n60#2:168\n60#2:172\n1863#3:169\n1864#3:171\n1#4:170\n*S KotlinDebug\n*F\n+ 1 AIPackageDeployment.kt\ncom/bytedance/ai/resource/core/AIPackageDeployment\n*L\n81#1:168\n102#1:172\n85#1:169\n85#1:171\n*E\n"})
public abstract class AIPackageDeployment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f2573a = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020\u000b8Æ\u0002¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u0012\u0010&\u001a\u00020\u000b8Æ\u0002¢\u0006\u0006\u001a\u0004\b&\u0010\"¨\u0006'"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackageDeployment$AIPackageDeploymentItem;", "Lcom/bytedance/ai/resource/k;", "", Constant.APPID, "packageName", "", "versionCode", "resourceUrl", "digest", "", "resourceUrls", "", "buildInPackage", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "J", "getVersionCode", "()J", "setVersionCode", "(J)V", "Ljava/lang/String;", "getResourceUrl", "()Ljava/lang/String;", "setResourceUrl", "(Ljava/lang/String;)V", "getDigest", "setDigest", "Ljava/util/List;", "getResourceUrls", "()Ljava/util/List;", "setResourceUrls", "(Ljava/util/List;)V", "Z", "getBuildInPackage", "()Z", "setBuildInPackage", "(Z)V", "isDefaultVersionCode", "isUninstall", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AIPackageDeploymentItem extends k {
        private boolean buildInPackage;
        private String digest;
        private String resourceUrl;
        private List<String> resourceUrls;
        private long versionCode;

        public /* synthetic */ AIPackageDeploymentItem(String r12, String r13, long r14, String r16, String r17, List r18, boolean r19, int r20, DefaultConstructorMarker r21) {
            if ((r20 & 4) == 0) goto L5;
            long r5 = 0;
        L7:
            if ((r20 & 8) == 0) goto L9;
            String r10 = "";
        L11:
            if ((r20 & 16) == 0) goto L13;
            String r11 = "";
        L15:
            if ((r20 & 32) == 0) goto L17;
            List r15 = null;
        L19:
            if ((r20 & 64) == 0) goto L21;
            boolean r110 = false;
        L22:
            this(r12, r13, r5, r10, r11, r15, r110);
            return;
        L21:
            r110 = r19;
            goto L22
        L17:
            r15 = r18;
            goto L19
        L13:
            r11 = r17;
            goto L15
        L9:
            r10 = r16;
            goto L11
        L5:
            r5 = r14;
            goto L7
        }

        public final boolean getBuildInPackage() {
            return this.buildInPackage;
        }

        public final String getDigest() {
            return this.digest;
        }

        public final String getResourceUrl() {
            return this.resourceUrl;
        }

        public final List<String> getResourceUrls() {
            return this.resourceUrls;
        }

        public final long getVersionCode() {
            return this.versionCode;
        }

        public final boolean isDefaultVersionCode() {
            if (getVersionCode() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isUninstall() {
            if (getVersionCode() != (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public final void setBuildInPackage(boolean r5) {
            this.buildInPackage = r5;
        }

        public final void setDigest(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.digest = r5;
        }

        public final void setResourceUrl(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.resourceUrl = r5;
        }

        public final void setResourceUrls(List<String> r5) {
            this.resourceUrls = r5;
        }

        public final void setVersionCode(long r5) {
            this.versionCode = r5;
        }

        public AIPackageDeploymentItem(String r5, String r10, long r11, String r12, String r13, List<String> r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r5, Constant.APPID);
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r12, "resourceUrl");
            Intrinsics.checkNotNullParameter(r13, "digest");
            super(r5, r10);
            this.versionCode = r11;
            this.resourceUrl = r12;
            this.digest = r13;
            this.resourceUrls = r14;
            this.buildInPackage = r15;
        }
    }

    static {
        f2573a = new ConcurrentHashMap();
    }

    public static AIPackageDeploymentItem a(AIPackageDeploymentItem r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        if (r5.getBuildInPackage() == false) goto L6;
        return r5;
    L6:
        if (r5.getVersionCode() > 0) goto L8;
        ConcurrentHashMap r10 = f2573a;
        String r11 = r5.getAppId();
        AIPackageDeploymentItem r12 = (AIPackageDeploymentItem) r10.get(a.b(r5.getPackageName(), r11));
        if (r12 == null) goto L13;
        return r12;
    L13:
        return a(r5.getAppId(), r5.getPackageName(), "");
    L8:
        return a(r5.getAppId(), r5.getPackageName(), String.valueOf(r5.getVersionCode()));
    }

    public static AIPackageDeploymentItem a(String r10, String r11, String r12) {
        AIPackageNetworkRequest r13 = new AIPackageNetworkRequest(CollectionsKt.mutableListOf(new AppRequestItem[]{new AppRequestItem(r10, r11, r12)}), null, null, 6, null);
        Lazy r5 = AIPackageTTNET.f2669a;
        Intrinsics.checkNotNullParameter(r13, "request");
        AIPackageNetworkResponse<AIPackageAppList> r14 = ((IAIPackageNetService) AIPackageTTNET.f2669a.getValue()).requestDeploymentInfoById(r13);
        if (r14.getCode() != 0) goto L17;
        AIPackageAppList r15 = r14.getData();
        StringBuilder r16 = com.lynx.tasm.base.a.e("packageName: ", r11, ", appId: ", r10, " ===> get deployment Information success : ");
        r16.append(r15);
        String r17 = r16.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r18 = c.f2846a;
        if (r18 == null) goto L7;
        r18.i("AIPackageManager", r17);
    L7:
        if (r15 == null) goto L9;
        List<AIPackageResponseItem> r19 = r15.getAppList();
    L10:
        if (r19 != null) goto L12;
    L16:
        return null;
    L12:
        if (r19.isEmpty() == true) goto L16;
        return a(r19.get(0));
    L9:
        r19 = null;
        goto L10
    L17:
        StringBuilder r20 = com.lynx.tasm.base.a.e("packageName: ", r11, ", appId: ", r10, " ===> get deployment Information failed : code = ");
        r20.append(r14.getCode());
        r20.append(", msg = ");
        r20.append(r14.getMsg());
        String r21 = r20.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r22 = c.f2846a;
        if (r22 == null) goto L20;
        r22.e("AIPackageManager", r21);
    L20:
        return null;
    }

    public static AIPackageDeploymentItem a(AIPackageResponseItem r12) {
        Intrinsics.checkNotNullParameter(r12, "item");
        boolean r10 = false;
        int r11 = 64;
        return new AIPackageDeploymentItem(r12.getAppId(), r12.getPackageName(), Long.parseLong(r12.getVersionCode()), r12.getResourceUrl(), r12.getDigest(), r12.getResourceUrls(), r10, r11, null);
    L5:
        e = move-exception;
        StringBuilder r5 = new StringBuilder("packageName: ");
        r5.append(r12.getPackageName());
        r5.append(", appId: ");
        r5.append(r12.getAppId());
        r5.append(" ===> responseItemBeanToDeploymentItem failed : ");
        String r13 = i.a.h(e, r5, "AIPackageManager");
        d r14 = c.f2846a;
        if (r14 == null) goto L13;
        r14.e("AIPackageManager", r13);
        return null;
    L13:
        return null;
    }
}
