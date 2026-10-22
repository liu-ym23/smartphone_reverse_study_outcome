package com.ss.android.lark.passport.signinsdk_api.env;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/env/EnvironmentType;", "", "<init>", "(Ljava/lang/String;I)V", "RELEASE", "STAGING", "PRE_RELEASE", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum EnvironmentType extends Enum<EnvironmentType> {
    public static final EnvironmentType PRE_RELEASE = null;
    public static final EnvironmentType RELEASE = null;
    public static final EnvironmentType STAGING = null;
    public static final /* synthetic */ EnvironmentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<EnvironmentType> getEntries() {
        return b;
    }

    static {
        EnvironmentType r0 = new EnvironmentType("RELEASE", 0);
        RELEASE = r0;
        EnvironmentType r1 = new EnvironmentType("STAGING", 1);
        STAGING = r1;
        EnvironmentType r3 = new EnvironmentType("PRE_RELEASE", 2);
        PRE_RELEASE = r3;
        EnvironmentType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static EnvironmentType[] values() {
        return (EnvironmentType[]) a.clone();
    }

    public static EnvironmentType valueOf(String r1) {
        return (EnvironmentType) a.a(EnvironmentType.class, r1);
    }

    public EnvironmentType(String r1, int r2) {
        super(r1, r2);
    }
}
