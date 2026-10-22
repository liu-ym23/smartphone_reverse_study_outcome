package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/repo/receiver/ChangeReceiverSource;", BuildConfig.FLAVOR, "ReceiverPanel", "Other", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChangeReceiverSource extends Enum<ChangeReceiverSource> {
    public static final ChangeReceiverSource Other = null;
    public static final ChangeReceiverSource ReceiverPanel = null;
    public static final /* synthetic */ ChangeReceiverSource[] a = null;

    static {
        ChangeReceiverSource r1 = new ChangeReceiverSource("ReceiverPanel", 0);
        ReceiverPanel = r1;
        ChangeReceiverSource r2 = new ChangeReceiverSource("Other", 1);
        Other = r2;
        a = new ChangeReceiverSource[]{r1, r2};
    }

    public static ChangeReceiverSource valueOf(String r1) {
        return (ChangeReceiverSource) r27.a.a(ChangeReceiverSource.class, r1);
    }

    public static ChangeReceiverSource[] values() {
        return (ChangeReceiverSource[]) a.clone();
    }

    public ChangeReceiverSource(String r1, int r2) {
        super(r1, r2);
    }
}
