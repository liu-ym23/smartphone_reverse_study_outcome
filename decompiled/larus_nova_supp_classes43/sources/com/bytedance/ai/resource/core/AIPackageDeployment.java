package com.bytedance.ai.resource.core;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIPackageDeployment {
    public static final ConcurrentHashMap<String, AIPackageDeploymentItem> a = null;
    public static final ConcurrentHashMap<a, FutureTask<AIPackageDeploymentItem>> b = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u0012\u0010*\u001a\u00020\f8Æ\u0002¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0012\u0010+\u001a\u00020\f8Æ\u0002¢\u0006\u0006\u001a\u0004\b+\u0010 ¨\u0006,"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackageDeployment$AIPackageDeploymentItem;", "Lcom/bytedance/ai/resource/AIPackageManager$AIPackageItem;", BdpAwemeConstant.KEY_APP_ID, "", "packageName", "versionCode", "", "resourceUrl", "digest", "resourceUrls", "", "buildInPackage", "", "verifySignature", "versionTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/Boolean;Ljava/lang/String;)V", "getVersionCode", "()J", "setVersionCode", "(J)V", "getResourceUrl", "()Ljava/lang/String;", "setResourceUrl", "(Ljava/lang/String;)V", "getDigest", "setDigest", "getResourceUrls", "()Ljava/util/List;", "setResourceUrls", "(Ljava/util/List;)V", "getBuildInPackage", "()Z", "setBuildInPackage", "(Z)V", "getVerifySignature", "()Ljava/lang/Boolean;", "setVerifySignature", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getVersionTag", "setVersionTag", "isDefaultVersionCode", "isUninstall", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AIPackageDeploymentItem extends AIPackageManager.a {
        private boolean buildInPackage;
        private String digest;
        private String resourceUrl;
        private List<String> resourceUrls;
        private Boolean verifySignature;
        private long versionCode;
        private String versionTag;

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

        public final Boolean getVerifySignature() {
            return this.verifySignature;
        }

        public final long getVersionCode() {
            return this.versionCode;
        }

        public final String getVersionTag() {
            return this.versionTag;
        }

        public final void setBuildInPackage(boolean r1) {
            this.buildInPackage = r1;
        }

        public final void setDigest(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.digest = r10;
        }

        public final void setResourceUrl(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.resourceUrl = r10;
        }

        public final void setResourceUrls(List<String> r1) {
            this.resourceUrls = r1;
        }

        public final void setVerifySignature(Boolean r1) {
            this.verifySignature = r1;
        }

        public final void setVersionCode(long r1) {
            this.versionCode = r1;
        }

        public final void setVersionTag(String r1) {
            this.versionTag = r1;
        }

        public AIPackageDeploymentItem(String r10, String r11, long r12, String r13, String r14, List<String> r15, boolean r16, Boolean r17, String r18) {
            Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r11, "packageName");
            Intrinsics.checkNotNullParameter(r13, "resourceUrl");
            Intrinsics.checkNotNullParameter(r14, "digest");
            super(r10, r11);
            this.versionCode = r12;
            this.resourceUrl = r13;
            this.digest = r14;
            this.resourceUrls = r15;
            this.buildInPackage = r16;
            this.verifySignature = r17;
            this.versionTag = r18;
        }

        public /* synthetic */ AIPackageDeploymentItem(String r15, String r16, long r17, String r19, String r20, List r21, boolean r22, Boolean r23, String r24, int r25, DefaultConstructorMarker r26) {
            if ((r25 & 4) == 0) goto L5;
            long r10 = 0;
        L7:
            if ((r25 & 8) == 0) goto L9;
            String r11 = "";
        L11:
            if ((r25 & 16) == 0) goto L13;
            String r12 = "";
        L15:
            if ((r25 & 32) == 0) goto L17;
            List r13 = null;
        L19:
            if ((r25 & 64) == 0) goto L21;
            boolean r14 = false;
        L23:
            if ((r25 & 128) == 0) goto L25;
            Boolean r18 = Boolean.FALSE;
        L27:
            if ((r25 & 256) == 0) goto L29;
            String r110 = null;
        L30:
            this(r15, r16, r10, r11, r12, r13, r14, r18, r110);
            return;
        L29:
            r110 = r24;
            goto L30
        L25:
            r18 = r23;
            goto L27
        L21:
            r14 = r22;
            goto L23
        L17:
            r13 = r21;
            goto L19
        L13:
            r12 = r20;
            goto L15
        L9:
            r11 = r19;
            goto L11
        L5:
            r10 = r17;
            goto L7
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "DeploymentInfoTaskKey(appId=" + this.a + ", packageName=" + this.b + ", versionCode=" + this.c + ')';
        }

        public a(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r11, "packageName");
            Intrinsics.checkNotNullParameter(r12, "versionCode");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static AIPackageDeploymentItem b(AIPackageDeploymentItem r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        if (r10.getBuildInPackage() == false) goto L5;
        return r10;
    L5:
        List<String> r0 = r10.getResourceUrls();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == false) goto L13;
        return r10;
    L13:
        if (r10.getResourceUrl().length() <= 0) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L18;
        return r10;
    L18:
        if (r10.getVersionCode() > 0) goto L26;
        ConcurrentHashMap<String, AIPackageDeploymentItem> r12 = a;
        String r13 = r10.getAppId();
        String r14 = r10.getPackageName();
        int r15 = AIPackage.J;
        AIPackageDeploymentItem r16 = r12.get(AIPackage.a.a(r14, r13));
        if (r16 == null) goto L24;
        return r16;
    L24:
        return a(r10.getAppId(), r10.getPackageName(), "");
    L26:
        return a(r10.getAppId(), r10.getPackageName(), String.valueOf(r10.getVersionCode()));
    L8:
        if ((!r0.isEmpty()) != true) goto L10;
        r11 = true;
        goto L11
    }

    public static AIPackageDeploymentItem c(AIPackageResponseItem r14) {
        Intrinsics.checkNotNullParameter(r14, "item");
        return new AIPackageDeploymentItem(r14.getAppId(), r14.getPackageName(), CastLongProtector.parseLong(r14.getVersionCode()), r14.getResourceUrl(), r14.getDigest(), r14.getResourceUrls(), false, r14.getVerifySignature(), null, 320, null);
    L5:
        e = move-exception;
        g.a.e("AIPackageManager", "packageName: " + r14.getPackageName() + ", appId: " + r14.getAppId() + " ===> responseItemBeanToDeploymentItem failed : " + ExceptionsKt.stackTraceToString(e));
        return null;
    }

    public static AIPackageDeploymentItem a(final String r11, final String r12, final String r13) {
        a r0 = new a(r11, r12, r13);
        FutureTask<AIPackageDeploymentItem> r1 = new FutureTask(new b(r12, r11, r13));
        ConcurrentHashMap<a, FutureTask<AIPackageDeploymentItem>> r10 = b;
        FutureTask<AIPackageDeploymentItem> r14 = r10.putIfAbsent(r0, r1);
        if (r14 != null) goto L5;
        r1.run();
    L7:
        if (r14 == null) goto L27;
        g.a.i("AIPackageManager", "packageName: " + r12 + ", appId: " + r11 + ", versionCode: " + r13 + " ===> reuse in-flight deployment information request");
    L27:
        AIPackageDeploymentItem r15 = r1.get();     // Catch: Throwable -> L12 ExecutionException -> L14 InterruptedException -> L18
        if (r14 != null) goto L29;
        r10.remove(r0, r1);
        return r15;
    L29:
        return r15;
    L12:
        th = move-exception;
        if (r14 != null) goto L26;
        b.remove(r0, r1);
    L26:
        throw th;
    L18:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L12
        g.a.e("AIPackageManager", "packageName: " + r12 + ", appId: " + r11 + ", versionCode: " + r13 + " ===> wait deployment information request interrupted: " + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L12
        if (r14 != null) goto L22;
    L21:
        b.remove(r0, r1);
    L22:
        return null;
    L14:
        e = move-exception;
        g.a.e("AIPackageManager", "packageName: " + r12 + ", appId: " + r11 + ", versionCode: " + r13 + " ===> request deployment information exception: " + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L12
        if (r14 != null) goto L22;
    L5:
        r1 = r14;
        goto L7
    }
}
