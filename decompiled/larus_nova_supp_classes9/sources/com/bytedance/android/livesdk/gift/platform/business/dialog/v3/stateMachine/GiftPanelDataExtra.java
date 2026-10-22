package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelDataExtra;", BuildConfig.FLAVOR, "pageDataFrom", BuildConfig.FLAVOR, "pageDataUpdateTime", BuildConfig.FLAVOR, "pageDataForRoomId", "logId", BuildConfig.FLAVOR, "(IJJLjava/lang/String;)V", "getLogId", "()Ljava/lang/String;", "getPageDataForRoomId", "()J", "getPageDataFrom", "()I", "getPageDataUpdateTime", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPanelDataExtra {
    private final String logId;
    private final long pageDataForRoomId;
    private final int pageDataFrom;
    private final long pageDataUpdateTime;

    public GiftPanelDataExtra() {
        this(0, 0, 0, null, 15, null);
    }

    public final String getLogId() {
        return this.logId;
    }

    public final long getPageDataForRoomId() {
        return this.pageDataForRoomId;
    }

    public final int getPageDataFrom() {
        return this.pageDataFrom;
    }

    public final long getPageDataUpdateTime() {
        return this.pageDataUpdateTime;
    }

    public GiftPanelDataExtra(int r2, long r3, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "logId");
        this.pageDataFrom = r2;
        this.pageDataUpdateTime = r3;
        this.pageDataForRoomId = r5;
        this.logId = r7;
    }

    public /* synthetic */ GiftPanelDataExtra(int r5, long r6, long r8, String r10, int r11, DefaultConstructorMarker r13) {
        if ((r11 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = 0;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = -1;
    L11:
        long r2 = r8;
        if ((r11 & 8) == 0) goto L14;
        r10 = BuildConfig.FLAVOR;
    L14:
        int r7 = r5;
        this(r7, r0, r2, r10);
    }
}
