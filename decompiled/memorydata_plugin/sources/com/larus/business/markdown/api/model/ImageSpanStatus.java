package com.larus.business.markdown.api.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/business/markdown/api/model/ImageSpanStatus;", "", "(Ljava/lang/String;I)V", "IDLE", "LOADING", "SUCC", "FAIL", "FAIL_NO_RETRY", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ImageSpanStatus extends Enum<ImageSpanStatus> {
    private static final /* synthetic */ ImageSpanStatus[] $VALUES = null;
    public static final ImageSpanStatus FAIL = null;
    public static final ImageSpanStatus FAIL_NO_RETRY = null;
    public static final ImageSpanStatus IDLE = null;
    public static final ImageSpanStatus LOADING = null;
    public static final ImageSpanStatus SUCC = null;

    private static final /* synthetic */ ImageSpanStatus[] $values() {
        return new ImageSpanStatus[]{IDLE, LOADING, SUCC, FAIL, FAIL_NO_RETRY};
    }

    static {
        IDLE = new ImageSpanStatus("IDLE", 0);
        LOADING = new ImageSpanStatus("LOADING", 1);
        SUCC = new ImageSpanStatus("SUCC", 2);
        FAIL = new ImageSpanStatus("FAIL", 3);
        FAIL_NO_RETRY = new ImageSpanStatus("FAIL_NO_RETRY", 4);
        $VALUES = $values();
    }

    private ImageSpanStatus(String r1, int r2) {
        super(r1, r2);
    }

    public static ImageSpanStatus valueOf(String r2) {
        return (ImageSpanStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(ImageSpanStatus.class, r2), ImageSpanStatus.class, "com.obric.memorydata.plugin");
    }

    public static ImageSpanStatus[] values() {
        return (ImageSpanStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ImageSpanStatus[].class, "com.obric.memorydata.plugin");
    }
}
