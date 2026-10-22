package com.bytedance.android.live.liveinteract.plantform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/x0;", "", "", "rtcRoomId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "rtcUserId", "b", "e", "", "needMixStream", "Z", "getNeedMixStream", "()Z", "c", "(Z)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class x0 {

    @SerializedName("need_mix_stream")
    private boolean needMixStream;

    @SerializedName("rtc_room_id")
    private String rtcRoomId;

    @SerializedName("rtc_user_id")
    private String rtcUserId;

    public x0() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof x0) == false) goto L12;
        x0 r4 = (x0) r3;
        if (Intrinsics.areEqual(this.rtcRoomId, r4.rtcRoomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rtcUserId, r4.rtcUserId) == true) goto L10;
        return false;
    L10:
        if (this.needMixStream == r4.needMixStream) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r0 = this.rtcRoomId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.rtcUserId;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.needMixStream;
        ?? r7 = r6;
        if (r6 == false) goto L13;
        r7 = 1;
    L13:
        return r5 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSingAvatarCloudGameRtcInfo(rtcRoomId=" + this.rtcRoomId + ", rtcUserId=" + this.rtcUserId + ", needMixStream=" + this.needMixStream + ")";
    }

    public final String a() {
        return this.rtcRoomId;
    }

    public final String b() {
        return this.rtcUserId;
    }

    public x0(int r1) {
        this.rtcRoomId = null;
        this.rtcUserId = null;
        this.needMixStream = false;
    }

    public final void c(boolean r1) {
        this.needMixStream = r1;
    }

    public final void d(String r1) {
        this.rtcRoomId = r1;
    }

    public final void e(String r1) {
        this.rtcUserId = r1;
    }
}
