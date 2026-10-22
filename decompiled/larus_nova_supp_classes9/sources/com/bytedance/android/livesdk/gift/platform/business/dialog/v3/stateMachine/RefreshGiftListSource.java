package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RefreshGiftListSource;", BuildConfig.FLAVOR, "source", BuildConfig.FLAVOR, "(Ljava/lang/String;ILjava/lang/String;)V", "getSource", "()Ljava/lang/String;", "NONE", "OPEN_DIALOG", "CHANGE_RECEIVER", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RefreshGiftListSource extends Enum<RefreshGiftListSource> {
    private static final /* synthetic */ RefreshGiftListSource[] $VALUES = null;
    public static final RefreshGiftListSource CHANGE_RECEIVER = null;
    public static final RefreshGiftListSource NONE = null;
    public static final RefreshGiftListSource OPEN_DIALOG = null;
    private final String source;

    static {
        RefreshGiftListSource r1 = new RefreshGiftListSource("NONE", 0, "none");
        NONE = r1;
        RefreshGiftListSource r2 = new RefreshGiftListSource("OPEN_DIALOG", 1, "open_panel");
        OPEN_DIALOG = r2;
        RefreshGiftListSource r3 = new RefreshGiftListSource("CHANGE_RECEIVER", 2, "change_recipient");
        CHANGE_RECEIVER = r3;
        $VALUES = new RefreshGiftListSource[]{r1, r2, r3};
    }

    public static RefreshGiftListSource valueOf(String r1) {
        return (RefreshGiftListSource) a.a(RefreshGiftListSource.class, r1);
    }

    public static RefreshGiftListSource[] values() {
        return (RefreshGiftListSource[]) $VALUES.clone();
    }

    public final String getSource() {
        return this.source;
    }

    private RefreshGiftListSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.source = r3;
    }
}
