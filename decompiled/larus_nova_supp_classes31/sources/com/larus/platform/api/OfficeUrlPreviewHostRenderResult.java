package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/api/OfficeUrlPreviewHostRenderResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "RENDER_FAILED", "NO_DATA", "NO_RENDER", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum OfficeUrlPreviewHostRenderResult extends Enum<OfficeUrlPreviewHostRenderResult> {
    public static final OfficeUrlPreviewHostRenderResult NO_DATA = null;
    public static final OfficeUrlPreviewHostRenderResult NO_RENDER = null;
    public static final OfficeUrlPreviewHostRenderResult RENDER_FAILED = null;
    public static final OfficeUrlPreviewHostRenderResult SUCCESS = null;
    public static final /* synthetic */ OfficeUrlPreviewHostRenderResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeUrlPreviewHostRenderResult> getEntries() {
        return b;
    }

    static {
        OfficeUrlPreviewHostRenderResult r0 = new OfficeUrlPreviewHostRenderResult("SUCCESS", 0);
        SUCCESS = r0;
        OfficeUrlPreviewHostRenderResult r1 = new OfficeUrlPreviewHostRenderResult("RENDER_FAILED", 1);
        RENDER_FAILED = r1;
        OfficeUrlPreviewHostRenderResult r3 = new OfficeUrlPreviewHostRenderResult("NO_DATA", 2);
        NO_DATA = r3;
        OfficeUrlPreviewHostRenderResult r5 = new OfficeUrlPreviewHostRenderResult("NO_RENDER", 3);
        NO_RENDER = r5;
        OfficeUrlPreviewHostRenderResult[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static OfficeUrlPreviewHostRenderResult[] values() {
        return (OfficeUrlPreviewHostRenderResult[]) a.clone();
    }

    public static OfficeUrlPreviewHostRenderResult valueOf(String r1) {
        return (OfficeUrlPreviewHostRenderResult) r27.a.a(OfficeUrlPreviewHostRenderResult.class, r1);
    }

    public OfficeUrlPreviewHostRenderResult(String r1, int r2) {
        super(r1, r2);
    }
}
