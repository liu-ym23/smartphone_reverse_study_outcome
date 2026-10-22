package com.ss.android.lark.conditional.access.auth.v2;

import com.bytedance.lark.policy.model.ResponseType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003Jp\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u001cR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010$R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010'¨\u00067"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/OnceValidateResult;", BuildConfig.FLAVOR, "allow", BuildConfig.FLAVOR, "uuid", BuildConfig.FLAVOR, IPortraitService.TYPE, "Lcom/bytedance/lark/policy/model/ResponseType;", "actions", BuildConfig.FLAVOR, "Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;", "needDelete", "validTime", BuildConfig.FLAVOR, "policySetKeys", "traceId", "<init>", "(ZLjava/lang/String;Lcom/bytedance/lark/policy/model/ResponseType;Ljava/util/List;ZLjava/lang/Long;Ljava/util/List;Ljava/lang/String;)V", "getAllow", "()Z", "getUuid", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/lark/policy/model/ResponseType;", "getActions", "()Ljava/util/List;", "getNeedDelete", "setNeedDelete", "(Z)V", "getValidTime", "()Ljava/lang/Long;", "setValidTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPolicySetKeys", "setPolicySetKeys", "(Ljava/util/List;)V", "getTraceId", "setTraceId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLjava/lang/String;Lcom/bytedance/lark/policy/model/ResponseType;Ljava/util/List;ZLjava/lang/Long;Ljava/util/List;Ljava/lang/String;)Lcom/ss/android/lark/conditional/access/auth/v2/OnceValidateResult;", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName(Keys.API_PARAM_KEY_ACTION)
    private final List<DecisionData.Action> actions;

    @SerializedName("allow")
    private final boolean allow;

    @SerializedName("needDelete")
    private boolean needDelete;

    @SerializedName("policySetKeys")
    private List<String> policySetKeys;

    @SerializedName("traceId")
    private String traceId;

    @SerializedName(IPortraitService.TYPE)
    private final ResponseType type;

    @SerializedName("uuid")
    private final String uuid;

    @SerializedName("validTime")
    private Long validTime;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.allow == r6.allow) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uuid, r6.uuid) == true) goto L15;
        return false;
    L15:
        if (this.type == r6.type) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L21;
        return false;
    L21:
        if (this.needDelete == r6.needDelete) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.validTime, r6.validTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.policySetKeys, r6.policySetKeys) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.traceId, r6.traceId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.allow == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((r0 * 31) + this.uuid.hashCode()) * 31) + this.type.hashCode()) * 31;
        List<DecisionData.Action> r3 = this.actions;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        if (this.needDelete == true) goto L14;
        r1 = 1237;
    L14:
        int r7 = (r6 + r1) * 31;
        Long r8 = this.validTime;
        if (r8 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (r7 + r9) * 31;
        List<String> r11 = this.policySetKeys;
        if (r11 == null) goto L23;
        r4 = r11.hashCode();
    L23:
        return ((r10 + r4) * 31) + this.traceId.hashCode();
    L17:
        r9 = r8.hashCode();
        goto L18
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "OnceValidateResult(allow=" + this.allow + ", uuid=" + this.uuid + ", type=" + this.type + ", actions=" + this.actions + ", needDelete=" + this.needDelete + ", validTime=" + this.validTime + ", policySetKeys=" + this.policySetKeys + ", traceId=" + this.traceId + ')';
    }

    public final List<DecisionData.Action> a() {
        return this.actions;
    }

    public final boolean b() {
        return this.allow;
    }

    public final boolean c() {
        return this.needDelete;
    }

    public final List<String> d() {
        return this.policySetKeys;
    }

    public final String e() {
        return this.traceId;
    }

    public final String f() {
        return this.uuid;
    }

    public final Long g() {
        return this.validTime;
    }

    public final ResponseType getType() {
        return this.type;
    }

    public final void h(Long r1) {
        this.validTime = r1;
    }

    public d(boolean r2, String r3, ResponseType r4, List r5, List r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r7, "traceId");
        this.allow = r2;
        this.uuid = r3;
        this.type = r4;
        this.actions = r5;
        this.needDelete = false;
        this.validTime = null;
        this.policySetKeys = r6;
        this.traceId = r7;
    }
}
