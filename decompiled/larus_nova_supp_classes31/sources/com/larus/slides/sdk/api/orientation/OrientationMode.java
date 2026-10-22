package com.larus.slides.sdk.api.orientation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/slides/sdk/api/orientation/OrientationMode;", "", "mode", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMode", "()Ljava/lang/String;", "LANDSCAPE", "PORTRAIT", "AUTO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum OrientationMode extends Enum<OrientationMode> {
    public static final OrientationMode AUTO = null;
    public static final OrientationMode LANDSCAPE = null;
    public static final OrientationMode PORTRAIT = null;
    public static final /* synthetic */ OrientationMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String mode;

    public static EnumEntries<OrientationMode> getEntries() {
        return b;
    }

    static {
        OrientationMode r0 = new OrientationMode("LANDSCAPE", 0, "landscape");
        LANDSCAPE = r0;
        OrientationMode r1 = new OrientationMode("PORTRAIT", 1, "portrait");
        PORTRAIT = r1;
        OrientationMode r2 = new OrientationMode("AUTO", 2, "auto");
        AUTO = r2;
        OrientationMode[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static OrientationMode[] values() {
        return (OrientationMode[]) a.clone();
    }

    public final String getMode() {
        return this.mode;
    }

    public static OrientationMode valueOf(String r1) {
        return (OrientationMode) a.a(OrientationMode.class, r1);
    }

    public OrientationMode(String r1, int r2, String r3) {
        super(r1, r2);
        this.mode = r3;
    }
}
