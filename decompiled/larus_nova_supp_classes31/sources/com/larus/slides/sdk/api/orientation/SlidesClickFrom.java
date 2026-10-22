package com.larus.slides.sdk.api.orientation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/slides/sdk/api/orientation/SlidesClickFrom;", "", "clickFrom", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getClickFrom", "()Ljava/lang/String;", "NORMAL", "PRESENTATION", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum SlidesClickFrom extends Enum<SlidesClickFrom> {
    public static final SlidesClickFrom NORMAL = null;
    public static final SlidesClickFrom PRESENTATION = null;
    public static final /* synthetic */ SlidesClickFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String clickFrom;

    public static EnumEntries<SlidesClickFrom> getEntries() {
        return b;
    }

    static {
        SlidesClickFrom r0 = new SlidesClickFrom("NORMAL", 0, "normal");
        NORMAL = r0;
        SlidesClickFrom r1 = new SlidesClickFrom("PRESENTATION", 1, "presentation");
        PRESENTATION = r1;
        SlidesClickFrom[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static SlidesClickFrom[] values() {
        return (SlidesClickFrom[]) a.clone();
    }

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public static SlidesClickFrom valueOf(String r1) {
        return (SlidesClickFrom) a.a(SlidesClickFrom.class, r1);
    }

    public SlidesClickFrom(String r1, int r2, String r3) {
        super(r1, r2);
        this.clickFrom = r3;
    }
}
