package com.bytedance.android.live.liveinteract.banner;

import am3.g;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.multilink.base.model.o;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000b\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/liveinteract/banner/LabelBannerUrl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/o;", "", "toString", "", PbRequest.SwitchType.OTHER, "", "equals", "", "hashCode", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "fail_back_url", "getFail_back_url", "Lcom/bytedance/android/live/liveinteract/banner/ActivityContent;", "activityContent", "Lcom/bytedance/android/live/liveinteract/banner/ActivityContent;", "getActivityContent", "()Lcom/bytedance/android/live/liveinteract/banner/ActivityContent;", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LabelBannerUrl extends FlexModelBase<o> implements o, h {

    @SerializedName("activity_content")
    protected ActivityContent activityContent;

    @SerializedName("fail_back_url")
    protected String fail_back_url;

    @SerializedName("url")
    protected String url;

    public LabelBannerUrl() {
        super(o.class);
        this.url = "";
        this.fail_back_url = "";
        this.activityContent = new ActivityContent();
    }

    public String toString() {
        return "LabelBannerUrl(url='" + getUrl() + "', fail_back_url='" + getFail_back_url() + "', activityContent=" + getActivityContent() + ')';
    }

    /* JADX INFO: renamed from: getActivityContent, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.multilink.base.model.b m32getActivityContent() {
        return getActivityContent();
    }

    public int hashCode() {
        int r0 = ((getUrl().hashCode() * 31) + getFail_back_url().hashCode()) * 31;
        ActivityContent r1 = getActivityContent();
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public String getFail_back_url() {
        return this.fail_back_url;
    }

    public String getUrl() {
        return this.url;
    }

    public ActivityContent getActivityContent() {
        return this.activityContent;
    }

    public LabelBannerUrl(g r6) {
        super(o.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.url = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.fail_back_url = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 5) goto L11;
        this.activityContent = new ActivityContent(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this.url != null) goto L19;
        this.url = "";
    L19:
        if (this.fail_back_url != null) goto L22;
        this.fail_back_url = "";
    L22:
        if (this.activityContent != null) goto L37;
        this.activityContent = new ActivityContent();
        return;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(LabelBannerUrl.class, r5.getClass())) == false) goto L11;
        return false;
    L11:
        LabelBannerUrl r6 = (LabelBannerUrl) r5;
        if ((!Intrinsics.areEqual(getUrl(), r6.getUrl())) == false) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(getFail_back_url(), r6.getFail_back_url())) == false) goto L18;
        return false;
    L18:
        if ((!Intrinsics.areEqual(getActivityContent(), r6.getActivityContent())) == false) goto L20;
        return false;
    L20:
        return true;
    }
}
