package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ForMain
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/w;", "", "", "userType", "I", "e", "()I", "setUserType", "(I)V", "", "rtcExtInfo", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "liveCoreExtInfo", "b", "setLiveCoreExtInfo", "subRtcExtInfo", "d", "setSubRtcExtInfo", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "chorusCDNInfo", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "a", "()Lcom/bytedance/android/livesdk/chatroom/model/v;", "setChorusCDNInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/v;)V", "", "concertVolume", "D", "getConcertVolume", "()D", "setConcertVolume", "(D)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class w implements vh7.h {

    @SerializedName("chorus_cdn_info")
    protected com.bytedance.android.livesdk.chatroom.model.v chorusCDNInfo;

    @SerializedName("concert_volume")
    protected double concertVolume;

    @SerializedName("live_core_ext_info")
    protected String liveCoreExtInfo;

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    @SerializedName("sub_rtc_ext_info")
    protected String subRtcExtInfo;

    @SerializedName("user_type")
    protected int userType;

    public w() {
        this.rtcExtInfo = "";
        this.liveCoreExtInfo = "";
        this.subRtcExtInfo = "";
    }

    public final com.bytedance.android.livesdk.chatroom.model.v a() {
        return this.chorusCDNInfo;
    }

    public final String b() {
        return this.liveCoreExtInfo;
    }

    public final String c() {
        return this.rtcExtInfo;
    }

    public final String d() {
        return this.subRtcExtInfo;
    }

    public final int e() {
        return this.userType;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.chatroom.model.v, java.lang.Object] */
    public w(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L24;
        if (r2 != 1) goto L8;
        this.userType = r5.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.rtcExtInfo = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.subRtcExtInfo = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.liveCoreExtInfo = am3.h.c(r5);
        goto L3
    L14:
        if (r2 != 5) goto L16;
        this.chorusCDNInfo = vh7.f.a(r5, com.bytedance.android.livesdk.chatroom.model.v.class);
        goto L3
    L16:
        if (r2 != 8) goto L17;
        this.concertVolume = Double.longBitsToDouble(r5.h());
        goto L3
    L17:
        am3.h.e(r5);
        goto L3
    L24:
        r5.d(r0);
        if (this.rtcExtInfo != null) goto L28;
        this.rtcExtInfo = "";
    L28:
        if (this.liveCoreExtInfo != null) goto L31;
        this.liveCoreExtInfo = "";
    L31:
        if (this.subRtcExtInfo != null) goto L55;
        this.subRtcExtInfo = "";
        return;
    }
}
