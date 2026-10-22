package com.larus.business.markdown.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/business/markdown/api/FullScreenDetailType;", "", "(Ljava/lang/String;I)V", "CODE_BLOCK", "TABLE_BLOCK", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum FullScreenDetailType extends Enum<FullScreenDetailType> {
    private static final /* synthetic */ FullScreenDetailType[] $VALUES = null;
    public static final FullScreenDetailType CODE_BLOCK = null;
    public static final FullScreenDetailType TABLE_BLOCK = null;

    private static final /* synthetic */ FullScreenDetailType[] $values() {
        return new FullScreenDetailType[]{CODE_BLOCK, TABLE_BLOCK};
    }

    static {
        CODE_BLOCK = new FullScreenDetailType("CODE_BLOCK", 0);
        TABLE_BLOCK = new FullScreenDetailType("TABLE_BLOCK", 1);
        $VALUES = $values();
    }

    private FullScreenDetailType(String r1, int r2) {
        super(r1, r2);
    }

    public static FullScreenDetailType valueOf(String r2) {
        return (FullScreenDetailType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FullScreenDetailType.class, r2), FullScreenDetailType.class, "com.obric.memorydata.plugin");
    }

    public static FullScreenDetailType[] values() {
        return (FullScreenDetailType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FullScreenDetailType[].class, "com.obric.memorydata.plugin");
    }
}
