package rc;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lrc/m;", "", "", AIStateLogRequest.SOURCE_PAGE, "Ljava/lang/String;", "getPage", "()Ljava/lang/String;", "setPage", "(Ljava/lang/String;)V", "", "bstReportEnable", "Z", "getBstReportEnable", "()Z", "setBstReportEnable", "(Z)V", "originReportEnable", "getOriginReportEnable", "setOriginReportEnable", "btm", "getBtm", "setBtm", com.bytedance.android.ec.core.event.a.KEY_PLATFORM, "getPlatform", "setPlatform", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class m {

    @SerializedName("bst_report_enable")
    private boolean bstReportEnable;

    @SerializedName("btm")
    private String btm;

    @SerializedName("origin_report_enable")
    private boolean originReportEnable;

    @SerializedName(AIStateLogRequest.SOURCE_PAGE)
    private String page;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PLATFORM)
    private String platform;

    public final int hashCode() {
        return (this.btm.hashCode() * 31) + this.platform.hashCode();
    }

    public m() {
        this.page = "";
        this.btm = "";
        this.platform = com.bytedance.android.ec.core.event.a.VALUE_NATIVE;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if ((!Intrinsics.areEqual(m.class, r11)) == false) goto L12;
        return false;
    L12:
        if (r10 == null) goto L21;
        m r12 = (m) r10;
        if ((!Intrinsics.areEqual(this.btm, r12.btm)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.platform, r12.platform)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.bst.api.config.PageControl");
    L8:
        r11 = null;
        goto L10
    }
}
