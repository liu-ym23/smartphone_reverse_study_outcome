package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/pkTray/TrayActionType;", BuildConfig.FLAVOR, "DEFAULT", "Enter", "Exit", "Update", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TrayActionType extends Enum<TrayActionType> {
    public static final TrayActionType DEFAULT = null;
    public static final TrayActionType Enter = null;
    public static final TrayActionType Exit = null;
    public static final TrayActionType Update = null;
    public static final /* synthetic */ TrayActionType[] a = null;

    static {
        TrayActionType r1 = new TrayActionType("DEFAULT", 0);
        DEFAULT = r1;
        TrayActionType r2 = new TrayActionType("Enter", 1);
        Enter = r2;
        TrayActionType r3 = new TrayActionType("Exit", 2);
        Exit = r3;
        TrayActionType r4 = new TrayActionType("Update", 3);
        Update = r4;
        a = new TrayActionType[]{r1, r2, r3, r4};
    }

    public static TrayActionType valueOf(String r1) {
        return (TrayActionType) r27.a.a(TrayActionType.class, r1);
    }

    public static TrayActionType[] values() {
        return (TrayActionType[]) a.clone();
    }

    public TrayActionType(String r1, int r2) {
        super(r1, r2);
    }
}
