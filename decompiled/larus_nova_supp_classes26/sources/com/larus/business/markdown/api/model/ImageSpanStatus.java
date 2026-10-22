package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/business/markdown/api/model/ImageSpanStatus;", "", "IDLE", "LOADING", "SUCC", "FAIL", "FAIL_NO_RETRY", "markdown-api_release"}, k = 1, mv = {1, 7, 1})
public final enum ImageSpanStatus extends Enum<ImageSpanStatus> {
    public static final ImageSpanStatus FAIL = null;
    public static final ImageSpanStatus FAIL_NO_RETRY = null;
    public static final ImageSpanStatus IDLE = null;
    public static final ImageSpanStatus LOADING = null;
    public static final ImageSpanStatus SUCC = null;
    public static final /* synthetic */ ImageSpanStatus[] a = null;

    public static ImageSpanStatus valueOf(String r1) {
        return (ImageSpanStatus) a.a(ImageSpanStatus.class, r1);
    }

    public static ImageSpanStatus[] values() {
        return (ImageSpanStatus[]) a.clone();
    }

    static {
        ImageSpanStatus r0 = new ImageSpanStatus("IDLE", 0);
        IDLE = r0;
        ImageSpanStatus r1 = new ImageSpanStatus("LOADING", 1);
        LOADING = r1;
        ImageSpanStatus r3 = new ImageSpanStatus("SUCC", 2);
        SUCC = r3;
        ImageSpanStatus r5 = new ImageSpanStatus("FAIL", 3);
        FAIL = r5;
        ImageSpanStatus r7 = new ImageSpanStatus("FAIL_NO_RETRY", 4);
        FAIL_NO_RETRY = r7;
        a = new ImageSpanStatus[]{r0, r1, r3, r5, r7};
    }

    public ImageSpanStatus(String r1, int r2) {
        super(r1, r2);
    }
}
