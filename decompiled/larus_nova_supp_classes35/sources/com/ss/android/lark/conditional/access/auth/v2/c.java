package com.ss.android.lark.conditional.access.auth.v2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u00101\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\u0000J\u0010\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0002J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007HÆ\u0003J\u0081\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007HÆ\u0001J\u0013\u0010?\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u000eHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\"\"\u0004\b%\u0010$R\u001e\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\"\"\u0004\b&\u0010$R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R \u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 ¨\u0006C"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/FilePolicyResult;", BuildConfig.FLAVOR, "resultType", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;", "resultSource", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;", "actions", BuildConfig.FLAVOR, "Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;", "needDelete", BuildConfig.FLAVOR, "isValid", "isImShareValid", "pointKey", BuildConfig.FLAVOR, "cacheHitTaskId", "cacheType", "validateLogInfos", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateLogInfo;", "<init>", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;Ljava/util/List;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getResultType", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;", "setResultType", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;)V", "getResultSource", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;", "setResultSource", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getNeedDelete", "()Z", "setNeedDelete", "(Z)V", "setValid", "setImShareValid", "getPointKey", "()Ljava/lang/String;", "setPointKey", "(Ljava/lang/String;)V", "getCacheHitTaskId", "setCacheHitTaskId", "getCacheType", "setCacheType", "getValidateLogInfos", "setValidateLogInfos", "compareTo", "other", "compareWithPriority", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "hashCode", BuildConfig.FLAVOR, "toString", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName(Keys.API_PARAM_KEY_ACTION)
    private List<DecisionData.Action> actions;

    @SerializedName("cacheHitTaskId")
    private String cacheHitTaskId;

    @SerializedName("cacheType")
    private String cacheType;

    @SerializedName("isImShareValid")
    private boolean isImShareValid;

    @SerializedName("isValid")
    private boolean isValid;

    @SerializedName("needDelete")
    private boolean needDelete;

    @SerializedName("pointKey")
    private String pointKey;

    @SerializedName("resultSource")
    private ValidateResultSource resultSource;

    @SerializedName("resultType")
    private ResultType resultType;

    @SerializedName("policySetKeys")
    private List<ValidateLogInfo> validateLogInfos;

    public c() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.resultType == r6.resultType) goto L12;
        return false;
    L12:
        if (this.resultSource == r6.resultSource) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L18;
        return false;
    L18:
        if (this.needDelete == r6.needDelete) goto L21;
        return false;
    L21:
        if (this.isValid == r6.isValid) goto L24;
        return false;
    L24:
        if (this.isImShareValid == r6.isImShareValid) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pointKey, r6.pointKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cacheHitTaskId, r6.cacheHitTaskId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.cacheType, r6.cacheType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.validateLogInfos, r6.validateLogInfos) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.resultType.hashCode() * 31) + this.resultSource.hashCode()) * 31;
        List<DecisionData.Action> r1 = this.actions;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.needDelete == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.isValid == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        if (this.isImShareValid == true) goto L18;
        r5 = 1237;
    L18:
        int r10 = (r9 + r5) * 31;
        String r11 = this.pointKey;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        String r14 = this.cacheHitTaskId;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        String r17 = this.cacheType;
        if (r17 == null) goto L31;
        r2 = r17.hashCode();
    L31:
        return ((r16 + r2) * 31) + this.validateLogInfos.hashCode();
    L25:
        r15 = r14.hashCode();
        goto L26
    L21:
        r12 = r11.hashCode();
        goto L22
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void o() {
        this.isImShareValid = false;
    }

    public final String toString() {
        return "FilePolicyResult(resultType=" + this.resultType + ", resultSource=" + this.resultSource + ", actions=" + this.actions + ", needDelete=" + this.needDelete + ", isValid=" + this.isValid + ", isImShareValid=" + this.isImShareValid + ", pointKey=" + this.pointKey + ", cacheHitTaskId=" + this.cacheHitTaskId + ", cacheType=" + this.cacheType + ", validateLogInfos=" + this.validateLogInfos + ')';
    }

    public final List<DecisionData.Action> b() {
        return this.actions;
    }

    public final String c() {
        return this.cacheHitTaskId;
    }

    public final String d() {
        return this.cacheType;
    }

    public final boolean e() {
        return this.needDelete;
    }

    public final String f() {
        return this.pointKey;
    }

    public final ValidateResultSource g() {
        return this.resultSource;
    }

    public final ResultType h() {
        return this.resultType;
    }

    public final List<ValidateLogInfo> i() {
        return this.validateLogInfos;
    }

    public final boolean j() {
        return this.isImShareValid;
    }

    public final boolean k() {
        return this.isValid;
    }

    public final c a(c r6) {
        if (w4c.c.a().E() == false) goto L11;
        ArrayList r0 = new ArrayList();
        r0.addAll(this.validateLogInfos);
        if (r6 == null) goto L9;
        List<ValidateLogInfo> r1 = r6.validateLogInfos;
        if (r1 == null) goto L9;
    L10:
        r0.addAll(r1);
        List<ValidateLogInfo> r2 = r0;
    L15:
        if (r6 != null) goto L18;
    L16:
        r6 = this;
    L59:
        r6.validateLogInfos = r2;
        return r6;
    L18:
        if (this.resultType.ordinal() < r6.resultType.ordinal()) goto L16;
        if (this.resultType.ordinal() > r6.resultType.ordinal()) goto L59;
        List<DecisionData.Action> r3 = this.actions;
        String r4 = "OTHERS";
        if (r3 == null) goto L29;
        DecisionData.Action r5 = (DecisionData.Action) CollectionsKt.firstOrNull(r3);
        if (r5 == null) goto L29;
        String r7 = r5.getName();
        if (r7 == null) goto L29;
    L30:
        List<DecisionData.Action> r8 = r6.actions;
        if (r8 == null) goto L38;
        DecisionData.Action r9 = (DecisionData.Action) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L38;
        String r10 = r9.getName();
        if (r10 == null) goto L38;
        r4 = r10;
    L38:
        Map<String, Integer> r11 = g.a;
        Integer r12 = r11.get(r7);
        int r13 = 0;
        if (r12 == null) goto L41;
        int r14 = r12.intValue();
    L42:
        Integer r15 = r11.get(r4);
        if (r15 == null) goto L45;
        r13 = r15.intValue();
    L45:
        if (r14 > r13) goto L16;
        if (r14 < r13) goto L59;
        if (this.resultSource.ordinal() < r6.resultSource.ordinal()) goto L59;
        if (this.resultSource.ordinal() > r6.resultSource.ordinal()) goto L16;
        if (g.c(this) == false) goto L16;
        if (g.c(r6) == true) goto L16;
    L41:
        r14 = 0;
    L29:
        r7 = "OTHERS";
    L9:
        r1 = CollectionsKt.emptyList();
        goto L10
    L11:
        if (r6 == null) goto L14;
        List<ValidateLogInfo> r16 = r6.validateLogInfos;
        r2 = r16;
        if (r16 != null) goto L15;
    L14:
        r2 = CollectionsKt.emptyList();
        goto L15
    }

    public final void l(List<DecisionData.Action> r1) {
        this.actions = r1;
    }

    public final void m(String r1) {
        this.cacheHitTaskId = r1;
    }

    public final void n(String r1) {
        this.cacheType = r1;
    }

    public final void p(boolean r1) {
        this.needDelete = r1;
    }

    public final void q(String r1) {
        this.pointKey = r1;
    }

    public final void r(ValidateResultSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resultSource = r2;
    }

    public final void s(ResultType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resultType = r2;
    }

    public final void t(boolean r1) {
        this.isValid = r1;
    }

    public final void u(List<ValidateLogInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.validateLogInfos = r2;
    }

    public c(ResultType r5, ValidateResultSource r6, List r7, List r8, int r9) {
        boolean r1 = true;
        if ((r9 & 16) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r9 & 32) != 0) goto L11;
        r1 = false;
    L11:
        if ((r9 & 512) == 0) goto L13;
        r8 = CollectionsKt.emptyList();
    L13:
        Intrinsics.checkNotNullParameter(r5, "resultType");
        Intrinsics.checkNotNullParameter(r6, "resultSource");
        Intrinsics.checkNotNullParameter(r8, "validateLogInfos");
        this.resultType = r5;
        this.resultSource = r6;
        this.actions = r7;
        this.needDelete = false;
        this.isValid = r0;
        this.isImShareValid = r1;
        this.pointKey = null;
        this.cacheHitTaskId = null;
        this.cacheType = null;
        this.validateLogInfos = r8;
        return;
    L5:
        r0 = false;
        goto L7
    }
}
