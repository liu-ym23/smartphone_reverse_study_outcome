package com.ss.android.lark.floating.enums;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/floating/enums/SideHideDirection;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NONE", "LEFT", "RIGHT", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideHideDirection extends Enum<SideHideDirection> {
    public static final SideHideDirection LEFT = null;
    public static final SideHideDirection NONE = null;
    public static final SideHideDirection RIGHT = null;
    public static final /* synthetic */ SideHideDirection[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SideHideDirection> getEntries() {
        return b;
    }

    static {
        SideHideDirection r0 = new SideHideDirection("NONE", 0);
        NONE = r0;
        SideHideDirection r1 = new SideHideDirection("LEFT", 1);
        LEFT = r1;
        SideHideDirection r3 = new SideHideDirection("RIGHT", 2);
        RIGHT = r3;
        SideHideDirection[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SideHideDirection[] values() {
        return (SideHideDirection[]) a.clone();
    }

    public static SideHideDirection valueOf(String r1) {
        return (SideHideDirection) a.a(SideHideDirection.class, r1);
    }

    public SideHideDirection(String r1, int r2) {
        super(r1, r2);
    }
}
