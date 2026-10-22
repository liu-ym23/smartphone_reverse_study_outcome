package j8b;

import com.bytedance.lark.policy.model.ResponseType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR>\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPResultModel;", BuildConfig.FLAVOR, "<init>", "()V", ChameleonOpenTracker.OpenResult.TIMEOUT, BuildConfig.FLAVOR, "getTimeout", "()J", "setTimeout", "(J)V", "resultMap", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPResultModel$OperateResult;", "Lkotlin/collections/HashMap;", "getResultMap", "()Ljava/util/HashMap;", "setResultMap", "(Ljava/util/HashMap;)V", IPortraitService.TYPE, "Lcom/bytedance/lark/policy/model/ResponseType;", "getType", "()Lcom/bytedance/lark/policy/model/ResponseType;", "setType", "(Lcom/bytedance/lark/policy/model/ResponseType;)V", "OperateResult", "AppliedPolicySetResult", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {
    public ResponseType a;

    @SerializedName("resultMap")
    private HashMap<String, b> resultMap;

    @SerializedName(ChameleonOpenTracker.OpenResult.TIMEOUT)
    private long timeout;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPResultModel$AppliedPolicySetResult;", BuildConfig.FLAVOR, "<init>", "()V", "policySetKey", BuildConfig.FLAVOR, "getPolicySetKey", "()Ljava/lang/String;", "isEvaluated", BuildConfig.FLAVOR, "()Z", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("isEvaluated")
        private final boolean isEvaluated;

        @SerializedName("policySetKey")
        private final String policySetKey;

        public a() {
            this.policySetKey = BuildConfig.FLAVOR;
        }

        public final String a() {
            return this.policySetKey;
        }

        public final boolean b() {
            return this.isEvaluated;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPResultModel$OperateResult;", BuildConfig.FLAVOR, "<init>", "()V", "isAllow", BuildConfig.FLAVOR, "()Z", "bizAction", BuildConfig.FLAVOR, "getBizAction", "()Ljava/lang/String;", "isFallback", "enforcementID", "getEnforcementID", "appliedPolicySetResultList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPResultModel$AppliedPolicySetResult;", "getAppliedPolicySetResultList", "()Ljava/util/List;", "actionExtra", "getActionExtra", "parseActionExtra", "Lcom/ss/android/lark/conditional/access/network/model/response/FixedDecisionData$FixedAction;", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("actionExtra")
        private final String actionExtra;

        @SerializedName("appliedPolicySetResultList")
        private final List<a> appliedPolicySetResultList;

        @SerializedName("bizAction")
        private final String bizAction;

        @SerializedName("enforcementID")
        private final String enforcementID;

        @SerializedName("isAllow")
        private final boolean isAllow;

        @SerializedName("isFallback")
        private final boolean isFallback;

        public final List<m8b.b.a> f() {
            LinkedList r0 = new LinkedList();
            String r1 = this.actionExtra;
            if (r1 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            String r3 = "TT_BLOCK";
            if (r2 == true) goto L31;
            LinkedList<m8b.b.a> r4 = ((m8b.b) com.ss.android.lark.security.compliance.infra.util.f.a(this.actionExtra, m8b.b.class)).a();     // Catch: Exception -> L28
            if (r4 == null) goto L22;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Exception -> L28
            Iterator<T> r6 = r4.iterator();     // Catch: Exception -> L28
        L15:
            if (r6.hasNext() == false) goto L23;
            m8b.b.a r7 = (m8b.b.a) r6.next();     // Catch: Exception -> L28
            if (Intrinsics.areEqual(r7.a(), "FILE_BLOCK_COMMON") == false) goto L21;
            if (Intrinsics.areEqual(this.bizAction, "FILE_BLOCK_COMMON") == false) goto L21;
            m8b.b.a r8 = new m8b.b.a();     // Catch: Exception -> L28
            r8.c("TT_BLOCK");     // Catch: Exception -> L28
            r8.d(r7.b());     // Catch: Exception -> L28
            r7 = r8;
        L21:
            r5.add(r7);     // Catch: Exception -> L28
        L23:
            if (r5 == null) goto L25;
            List r9 = r5;
        L26:
            r0.addAll(r9);     // Catch: Exception -> L28
            goto L31
        L25:
            r9 = CollectionsKt.emptyList();     // Catch: Exception -> L28
            goto L26
        L22:
            r5 = null;
        L28:
            e = move-exception;
            int r10 = ScsLogger.a;
            ScsLogger.c("SecurityPolicy_DLPModels", "parseActionExtra error, e: " + e);
        L31:
            if (r0.isEmpty() == false) goto L39;
            String r11 = this.bizAction;
            if (r11 == null) goto L39;
            if (Intrinsics.areEqual(r11, "FILE_BLOCK_COMMON") == true) goto L38;
            r3 = this.bizAction;
        L38:
            m8b.b.a r12 = new m8b.b.a();
            r12.c(r3);
            r0.add(r12);
        L39:
            return r0;
        L5:
            if (r1.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public b() {
            this.isAllow = true;
            this.enforcementID = BuildConfig.FLAVOR;
            this.appliedPolicySetResultList = CollectionsKt.emptyList();
        }

        public final List<a> a() {
            return this.appliedPolicySetResultList;
        }

        public final String b() {
            return this.bizAction;
        }

        public final String c() {
            return this.enforcementID;
        }

        public final boolean d() {
            return this.isAllow;
        }

        public final boolean e() {
            return this.isFallback;
        }
    }

    public j() {
        this.timeout = 600;
        this.resultMap = new HashMap();
        this.a = ResponseType.FAST_PASS;
    }

    public final HashMap<String, b> a() {
        return this.resultMap;
    }

    public final ResponseType getType() {
        return this.a;
    }
}
