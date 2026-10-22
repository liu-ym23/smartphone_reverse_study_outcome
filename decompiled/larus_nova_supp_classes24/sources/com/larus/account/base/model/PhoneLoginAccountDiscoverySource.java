package com.larus.account.base.model;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "", "<init>", "(Ljava/lang/String;I)V", "VERIFICATION_CODE", "CARRIER_ONE_KEY", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum PhoneLoginAccountDiscoverySource extends Enum<PhoneLoginAccountDiscoverySource> {
    public static final PhoneLoginAccountDiscoverySource CARRIER_ONE_KEY = null;
    public static final PhoneLoginAccountDiscoverySource VERIFICATION_CODE = null;
    public static final /* synthetic */ PhoneLoginAccountDiscoverySource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PhoneLoginAccountDiscoverySource> getEntries() {
        return b;
    }

    static {
        PhoneLoginAccountDiscoverySource r0 = new PhoneLoginAccountDiscoverySource("VERIFICATION_CODE", 0);
        VERIFICATION_CODE = r0;
        PhoneLoginAccountDiscoverySource r1 = new PhoneLoginAccountDiscoverySource("CARRIER_ONE_KEY", 1);
        CARRIER_ONE_KEY = r1;
        PhoneLoginAccountDiscoverySource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PhoneLoginAccountDiscoverySource[] values() {
        return (PhoneLoginAccountDiscoverySource[]) a.clone();
    }

    public static PhoneLoginAccountDiscoverySource valueOf(String r1) {
        return (PhoneLoginAccountDiscoverySource) a.a(PhoneLoginAccountDiscoverySource.class, r1);
    }

    public PhoneLoginAccountDiscoverySource(String r1, int r2) {
        super(r1, r2);
    }
}
