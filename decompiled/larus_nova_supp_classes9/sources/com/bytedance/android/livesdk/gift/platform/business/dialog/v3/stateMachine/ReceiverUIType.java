package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ReceiverUIType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "AllMic", "MultiReceiver", "SingleReceiver", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReceiverUIType extends Enum<ReceiverUIType> {
    private static final /* synthetic */ ReceiverUIType[] $VALUES = null;
    public static final ReceiverUIType AllMic = null;
    public static final ReceiverUIType MultiReceiver = null;
    public static final ReceiverUIType SingleReceiver = null;

    static {
        ReceiverUIType r1 = new ReceiverUIType("AllMic", 0);
        AllMic = r1;
        ReceiverUIType r2 = new ReceiverUIType("MultiReceiver", 1);
        MultiReceiver = r2;
        ReceiverUIType r3 = new ReceiverUIType("SingleReceiver", 2);
        SingleReceiver = r3;
        $VALUES = new ReceiverUIType[]{r1, r2, r3};
    }

    public static ReceiverUIType valueOf(String r1) {
        return (ReceiverUIType) a.a(ReceiverUIType.class, r1);
    }

    public static ReceiverUIType[] values() {
        return (ReceiverUIType[]) $VALUES.clone();
    }

    private ReceiverUIType(String r1, int r2) {
        super(r1, r2);
    }
}
