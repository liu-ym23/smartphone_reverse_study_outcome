package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OpenBuffGroupConfirmDialog;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelEffect;", "totalDiamond", BuildConfig.FLAVOR, "groupCount", BuildConfig.FLAVOR, "giftId", "position", "hintText", BuildConfig.FLAVOR, "sendCheck", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/FirstSendType;", "(JIJILjava/lang/String;Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/FirstSendType;)V", "getGiftId", "()J", "getGroupCount", "()I", "getHintText", "()Ljava/lang/String;", "getPosition", "getSendCheck", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/FirstSendType;", "getTotalDiamond", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenBuffGroupConfirmDialog implements GiftPanelEffect {
    private final long giftId;
    private final int groupCount;
    private final String hintText;
    private final int position;
    private final FirstSendType sendCheck;
    private final long totalDiamond;

    public final long getGiftId() {
        return this.giftId;
    }

    public final int getGroupCount() {
        return this.groupCount;
    }

    public final String getHintText() {
        return this.hintText;
    }

    public final int getPosition() {
        return this.position;
    }

    public final FirstSendType getSendCheck() {
        return this.sendCheck;
    }

    public final long getTotalDiamond() {
        return this.totalDiamond;
    }

    public OpenBuffGroupConfirmDialog(long r2, int r4, long r5, int r7, String r8, FirstSendType r9) {
        Intrinsics.checkNotNullParameter(r9, "sendCheck");
        this.totalDiamond = r2;
        this.groupCount = r4;
        this.giftId = r5;
        this.position = r7;
        this.hintText = r8;
        this.sendCheck = r9;
    }
}
