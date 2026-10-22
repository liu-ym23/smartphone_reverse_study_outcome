package com.bytedance.iesgurd.model;

import androidx.annotation.Keep;
import com.bytedance.iesgurd.core.ReqType;
import com.google.gson.annotations.SerializedName;
import df.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0003R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR.\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00100\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodyBase;", "", "reqType", "Lcom/bytedance/iesgurd/core/ReqType;", "(Lcom/bytedance/iesgurd/core/ReqType;)V", "auth", "Lcom/bytedance/iesgurd/model/RequestBodyBase$Auth;", "getAuth", "()Lcom/bytedance/iesgurd/model/RequestBodyBase$Auth;", "common", "Lcom/bytedance/iesgurd/model/Common;", "getCommon", "()Lcom/bytedance/iesgurd/model/Common;", "custom", "", "", "", "getCustom", "()Ljava/util/Map;", "reqInfo", "Lcom/bytedance/iesgurd/model/RequestBodyBase$ReqInfo;", "getReqInfo", "()Lcom/bytedance/iesgurd/model/RequestBodyBase$ReqInfo;", "getReqType", "Auth", "ReqInfo", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public class RequestBodyBase {

    @SerializedName("auth")
    private final Auth auth;

    @SerializedName("common")
    private final Common common;

    @SerializedName("custom")
    private final Map<String, Map<String, String>> custom;

    @SerializedName("req_info")
    private final ReqInfo reqInfo;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodyBase$Auth;", "", "()V", "random", "", "getRandom", "()Ljava/lang/String;", "sign", "getSign", "setSign", "(Ljava/lang/String;)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class Auth {

        @SerializedName("random")
        private final String random;

        @SerializedName("sign")
        private String sign;

        public Auth() {
            this.random = String.valueOf(System.currentTimeMillis() / ((long) 1000));
            this.sign = "x_gecko_sign_placeholder";
        }

        public final String getRandom() {
            return this.random;
        }

        public final String getSign() {
            return this.sign;
        }

        public final void setSign(String r5) {
            this.sign = r5;
        }
    }

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodyBase$ReqInfo;", "", "()V", "isRetry", "", "()Z", "setRetry", "(Z)V", "reqType", "Lcom/bytedance/iesgurd/core/ReqType;", "getReqType", "()Lcom/bytedance/iesgurd/core/ReqType;", "setReqType", "(Lcom/bytedance/iesgurd/core/ReqType;)V", "syncTaskId", "", "getSyncTaskId", "()I", "setSyncTaskId", "(I)V", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class ReqInfo {

        @SerializedName("is_retry")
        private boolean isRetry;

        @SerializedName("req_type")
        private ReqType reqType;

        @SerializedName("sync_task_id")
        private int syncTaskId;

        @SerializedName("business_tag")
        private String tag;

        public ReqInfo() {
            this.reqType = ReqType.NORMAL;
        }

        public final ReqType getReqType() {
            return this.reqType;
        }

        public final int getSyncTaskId() {
            return this.syncTaskId;
        }

        public final String getTag() {
            return this.tag;
        }

        public final boolean isRetry() {
            return this.isRetry;
        }

        public final void setReqType(ReqType r5) {
            this.reqType = r5;
        }

        public final void setRetry(boolean r5) {
            this.isRetry = r5;
        }

        public final void setSyncTaskId(int r5) {
            this.syncTaskId = r5;
        }

        public final void setTag(String r5) {
            this.tag = r5;
        }
    }

    public RequestBodyBase(ReqType r5) {
        this.common = c.e;
        ReqInfo r10 = new ReqInfo();
        this.reqInfo = r10;
        this.custom = new HashMap();
        this.auth = new Auth();
        r10.setReqType(r5);
    }

    public final Auth getAuth() {
        return this.auth;
    }

    public final Common getCommon() {
        return this.common;
    }

    public final Map<String, Map<String, String>> getCustom() {
        return this.custom;
    }

    public final ReqInfo getReqInfo() {
        return this.reqInfo;
    }

    public final ReqType getReqType() {
        return this.reqInfo.getReqType();
    }
}
