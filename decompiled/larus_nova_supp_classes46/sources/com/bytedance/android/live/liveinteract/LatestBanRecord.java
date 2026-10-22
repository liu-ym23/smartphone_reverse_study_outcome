package com.bytedance.android.live.liveinteract;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.review.GetLatestBanRecordResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R$\u0010#\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R$\u0010&\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/liveinteract/LatestBanRecord;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lbf2/a;", "", "banTime", "J", "getBanTime", "()J", "setBanTime", "(J)V", "banDuration", "getBanDuration", "setBanDuration", "", "isBannedForever", "Z", "()Z", "setBannedForever", "(Z)V", "", "banReason", "Ljava/lang/String;", "getBanReason", "()Ljava/lang/String;", "setBanReason", "(Ljava/lang/String;)V", "detailUrl", "getDetailUrl", "setDetailUrl", "appealUrl", "getAppealUrl", "setAppealUrl", "banDetailSchema", "getBanDetailSchema", "setBanDetailSchema", "banDetailText", "getBanDetailText", "setBanDetailText", "popupWindowUrl", "getPopupWindowUrl", "setPopupWindowUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LatestBanRecord extends FlexModelBase<bf2.a> implements bf2.a, h {

    @SerializedName("appeal_url")
    protected String appealUrl;

    @SerializedName("ban_detail_schema")
    protected String banDetailSchema;

    @SerializedName("ban_detail_text")
    protected String banDetailText;

    @SerializedName("ban_duration")
    protected long banDuration;

    @SerializedName("ban_reason")
    protected String banReason;

    @SerializedName("ban_time")
    protected long banTime;

    @SerializedName("detail_url")
    protected String detailUrl;

    @SerializedName("is_banned_forever")
    protected boolean isBannedForever;

    @SerializedName("popup_window_url")
    protected String popupWindowUrl;

    public LatestBanRecord() {
        super(bf2.a.class);
    }

    public String getAppealUrl() {
        return this.appealUrl;
    }

    public String getBanDetailSchema() {
        return this.banDetailSchema;
    }

    public String getBanDetailText() {
        return this.banDetailText;
    }

    public long getBanDuration() {
        return this.banDuration;
    }

    public String getBanReason() {
        return this.banReason;
    }

    public long getBanTime() {
        return this.banTime;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public String getPopupWindowUrl() {
        return this.popupWindowUrl;
    }

    public boolean isBannedForever() {
        return this.isBannedForever;
    }

    public LatestBanRecord(g r6) {
        super(bf2.a.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L26;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.banTime = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.banDuration = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.isBannedForever = am3.h.a(r6);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.banReason = am3.h.c(r6);
        goto L3
    L14:
        if (r2 != 12) goto L15;
        this.detailUrl = am3.h.c(r6);
        goto L3
    L15:
        switch(r2) {
            case 17: goto L20;
            case 18: goto L19;
            case 19: goto L18;
            case 20: goto L17;
            default: goto L16;
        };
    L17:
        this.popupWindowUrl = am3.h.c(r6);
        goto L3
    L18:
        this.banDetailText = am3.h.c(r6);
        goto L3
    L19:
        this.banDetailSchema = am3.h.c(r6);
        goto L3
    L20:
        this.appealUrl = am3.h.c(r6);
        goto L3
    L16:
        am3.h.d(r3, r6);
        goto L3
    L26:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setAppealUrl(String r1) {
        this.appealUrl = r1;
    }

    public void setBanDetailSchema(String r1) {
        this.banDetailSchema = r1;
    }

    public void setBanDetailText(String r1) {
        this.banDetailText = r1;
    }

    public void setBanDuration(long r1) {
        this.banDuration = r1;
    }

    public void setBanReason(String r1) {
        this.banReason = r1;
    }

    public void setBanTime(long r1) {
        this.banTime = r1;
    }

    public void setBannedForever(boolean r1) {
        this.isBannedForever = r1;
    }

    public void setDetailUrl(String r1) {
        this.detailUrl = r1;
    }

    public void setPopupWindowUrl(String r1) {
        this.popupWindowUrl = r1;
    }
}
