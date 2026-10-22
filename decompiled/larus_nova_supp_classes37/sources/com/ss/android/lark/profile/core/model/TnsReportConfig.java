package com.ss.android.lark.profile.core.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "tns_report_config")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/profile/core/model/TnsReportConfig;", "Ljava/io/Serializable;", "reportPath", "", AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getReportPath", "()Ljava/lang/String;", "setReportPath", "(Ljava/lang/String;)V", "getToken", "setToken", "profile-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class TnsReportConfig implements Serializable {

    @SerializedName("report_path")
    private String reportPath;

    @SerializedName(AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN)
    private String token;

    public TnsReportConfig() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public final String getReportPath() {
        return this.reportPath;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setReportPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reportPath = r2;
    }

    public final void setToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.token = r2;
    }

    public TnsReportConfig(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "reportPath");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN);
        this.reportPath = r2;
        this.token = r3;
    }

    public /* synthetic */ TnsReportConfig(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }
}
