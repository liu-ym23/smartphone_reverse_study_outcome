package com.bytedance.android.livesdk.config.link;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/link/MultiLinkReqABParamConfig;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "Lcom/bytedance/android/livesdk/config/link/MultiLinkReqABParamConfig$a;", "configList", "Ljava/util/List;", "getConfigList", "()Ljava/util/List;", "setConfigList", "(Ljava/util/List;)V", "<init>", "()V", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkReqABParamConfig {

    @SerializedName("config_list")
    private List<a> configList;

    @SerializedName("enable")
    private boolean enable;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/link/MultiLinkReqABParamConfig$a;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "", "activePath", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setActivePath", "(Ljava/lang/String;)V", "paramKey", "d", "setParamKey", "paramValue", "e", "setParamValue", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        public Regex a;

        @SerializedName("active_path")
        private String activePath;

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("common_param_key")
        private String paramKey;

        @SerializedName("common_param_value")
        private String paramValue;

        public final Regex b() {
            Regex r0 = this.a;
            if (r0 == null) goto L5;
        L8:
            this.a = r0;
            return r0;
        L5:
            if ((!StringsKt.isBlank(this.activePath)) == false) goto L7;
            r0 = new Regex(this.activePath);
            goto L8
        L7:
            r0 = null;
            goto L8
        }

        public a() {
            this.activePath = "";
            this.paramKey = "";
            this.paramValue = "";
        }

        public final String a() {
            return this.activePath;
        }

        public final boolean c() {
            return this.enable;
        }

        public final String d() {
            return this.paramKey;
        }

        public final String e() {
            return this.paramValue;
        }
    }

    public MultiLinkReqABParamConfig() {
        this.configList = CollectionsKt.emptyList();
    }

    public final List<a> getConfigList() {
        return this.configList;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setConfigList(List<a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.configList = r2;
    }

    public final void setEnable(boolean r1) {
        this.enable = r1;
    }
}
