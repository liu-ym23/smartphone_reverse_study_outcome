package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/AppletPerformanceResourceInitiatorType;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AUDIO", "COVER_IMAGE", "IMAGE", "OPEN_DATA", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPerformanceResourceInitiatorType extends Enum<AppletPerformanceResourceInitiatorType> {
    public static final AppletPerformanceResourceInitiatorType AUDIO = null;
    public static final AppletPerformanceResourceInitiatorType COVER_IMAGE = null;
    public static final AppletPerformanceResourceInitiatorType IMAGE = null;
    public static final AppletPerformanceResourceInitiatorType OPEN_DATA = null;
    public static final /* synthetic */ AppletPerformanceResourceInitiatorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AppletPerformanceResourceInitiatorType> getEntries() {
        return b;
    }

    static {
        AppletPerformanceResourceInitiatorType r0 = new AppletPerformanceResourceInitiatorType("AUDIO", 0, "audio");
        AUDIO = r0;
        AppletPerformanceResourceInitiatorType r1 = new AppletPerformanceResourceInitiatorType("COVER_IMAGE", 1, "cover-image");
        COVER_IMAGE = r1;
        AppletPerformanceResourceInitiatorType r10 = new AppletPerformanceResourceInitiatorType("IMAGE", 2, "image");
        IMAGE = r10;
        AppletPerformanceResourceInitiatorType r11 = new AppletPerformanceResourceInitiatorType("OPEN_DATA", 3, "open-data");
        OPEN_DATA = r11;
        AppletPerformanceResourceInitiatorType[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static AppletPerformanceResourceInitiatorType[] values() {
        return (AppletPerformanceResourceInitiatorType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletPerformanceResourceInitiatorType valueOf(String r1) {
        return (AppletPerformanceResourceInitiatorType) r27.a.a(AppletPerformanceResourceInitiatorType.class, r1);
    }

    public AppletPerformanceResourceInitiatorType(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
