package com.ss.android.lark.jsruntime;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/jsruntime/EngineType;", "", "<init>", "(Ljava/lang/String;I)V", "VMSDK_QUICKJS", "VMSDK_V8", "AHA_V8", "jsruntime_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum EngineType extends Enum<EngineType> {
    public static final EngineType AHA_V8 = null;
    public static final EngineType VMSDK_QUICKJS = null;
    public static final EngineType VMSDK_V8 = null;
    public static final /* synthetic */ EngineType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<EngineType> getEntries() {
        return b;
    }

    static {
        EngineType r0 = new EngineType("VMSDK_QUICKJS", 0);
        VMSDK_QUICKJS = r0;
        EngineType r1 = new EngineType("VMSDK_V8", 1);
        VMSDK_V8 = r1;
        EngineType r3 = new EngineType("AHA_V8", 2);
        AHA_V8 = r3;
        EngineType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static EngineType[] values() {
        return (EngineType[]) a.clone();
    }

    public static EngineType valueOf(String r1) {
        return (EngineType) a.a(EngineType.class, r1);
    }

    public EngineType(String r1, int r2) {
        super(r1, r2);
    }
}
