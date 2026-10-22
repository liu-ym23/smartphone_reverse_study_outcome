package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/api/AppletBottomSheetCancelSource;", "", "<init>", "(Ljava/lang/String;I)V", "MASK", "GESTURE", "HOST_UNAVAILABLE", "UNKNOWN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletBottomSheetCancelSource extends Enum<AppletBottomSheetCancelSource> {
    public static final AppletBottomSheetCancelSource GESTURE = null;
    public static final AppletBottomSheetCancelSource HOST_UNAVAILABLE = null;
    public static final AppletBottomSheetCancelSource MASK = null;
    public static final AppletBottomSheetCancelSource UNKNOWN = null;
    public static final /* synthetic */ AppletBottomSheetCancelSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AppletBottomSheetCancelSource> getEntries() {
        return b;
    }

    static {
        AppletBottomSheetCancelSource r0 = new AppletBottomSheetCancelSource("MASK", 0);
        MASK = r0;
        AppletBottomSheetCancelSource r1 = new AppletBottomSheetCancelSource("GESTURE", 1);
        GESTURE = r1;
        AppletBottomSheetCancelSource r10 = new AppletBottomSheetCancelSource("HOST_UNAVAILABLE", 2);
        HOST_UNAVAILABLE = r10;
        AppletBottomSheetCancelSource r11 = new AppletBottomSheetCancelSource("UNKNOWN", 3);
        UNKNOWN = r11;
        AppletBottomSheetCancelSource[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static AppletBottomSheetCancelSource[] values() {
        return (AppletBottomSheetCancelSource[]) a.clone();
    }

    public static AppletBottomSheetCancelSource valueOf(String r1) {
        return (AppletBottomSheetCancelSource) r27.a.a(AppletBottomSheetCancelSource.class, r1);
    }

    public AppletBottomSheetCancelSource(String r1, int r10) {
        super(r1, r10);
    }
}
