package com.bytedance.android.live.revlink.impl.multianchor.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/WindowLayoutType;", "", "Normal", "EnlargeBig", "EnlargeSmall", "FullBig", "FullSmall", "FullRecordBig", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WindowLayoutType extends Enum<WindowLayoutType> {
    public static final WindowLayoutType EnlargeBig = null;
    public static final WindowLayoutType EnlargeSmall = null;
    public static final WindowLayoutType FullBig = null;
    public static final WindowLayoutType FullRecordBig = null;
    public static final WindowLayoutType FullSmall = null;
    public static final WindowLayoutType Normal = null;
    public static final /* synthetic */ WindowLayoutType[] a = null;

    static {
        WindowLayoutType r1 = new WindowLayoutType("Normal", 0);
        Normal = r1;
        WindowLayoutType r2 = new WindowLayoutType("EnlargeBig", 1);
        EnlargeBig = r2;
        WindowLayoutType r3 = new WindowLayoutType("EnlargeSmall", 2);
        EnlargeSmall = r3;
        WindowLayoutType r4 = new WindowLayoutType("FullBig", 3);
        FullBig = r4;
        WindowLayoutType r5 = new WindowLayoutType("FullSmall", 4);
        FullSmall = r5;
        WindowLayoutType r6 = new WindowLayoutType("FullRecordBig", 5);
        FullRecordBig = r6;
        a = new WindowLayoutType[]{r1, r2, r3, r4, r5, r6};
    }

    public static WindowLayoutType valueOf(String r1) {
        return (WindowLayoutType) r27.a.a(WindowLayoutType.class, r1);
    }

    public static WindowLayoutType[] values() {
        return (WindowLayoutType[]) a.clone();
    }

    public WindowLayoutType(String r1, int r2) {
        super(r1, r2);
    }
}
