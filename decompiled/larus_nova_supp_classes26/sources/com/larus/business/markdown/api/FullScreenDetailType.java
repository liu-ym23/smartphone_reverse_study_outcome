package com.larus.business.markdown.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/business/markdown/api/FullScreenDetailType;", "", "CODE_BLOCK", "TABLE_BLOCK", "markdown-api_release"}, k = 1, mv = {1, 7, 1})
public final enum FullScreenDetailType extends Enum<FullScreenDetailType> {
    public static final FullScreenDetailType CODE_BLOCK = null;
    public static final FullScreenDetailType TABLE_BLOCK = null;
    public static final /* synthetic */ FullScreenDetailType[] a = null;

    public static FullScreenDetailType valueOf(String r1) {
        return (FullScreenDetailType) a.a(FullScreenDetailType.class, r1);
    }

    public static FullScreenDetailType[] values() {
        return (FullScreenDetailType[]) a.clone();
    }

    static {
        FullScreenDetailType r0 = new FullScreenDetailType("CODE_BLOCK", 0);
        CODE_BLOCK = r0;
        FullScreenDetailType r1 = new FullScreenDetailType("TABLE_BLOCK", 1);
        TABLE_BLOCK = r1;
        a = new FullScreenDetailType[]{r0, r1};
    }

    public FullScreenDetailType(String r1, int r2) {
        super(r1, r2);
    }
}
