package com.larus.business.markdown.api.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/markdown/api/model/OrderedSymbol;", "", "(Ljava/lang/String;I)V", "DECIMAL", "LOWERCASE_ALPHABET", "LOWERCASE_ROMAN", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum OrderedSymbol extends Enum<OrderedSymbol> {
    private static final /* synthetic */ OrderedSymbol[] $VALUES = null;
    public static final OrderedSymbol DECIMAL = null;
    public static final OrderedSymbol LOWERCASE_ALPHABET = null;
    public static final OrderedSymbol LOWERCASE_ROMAN = null;

    private static final /* synthetic */ OrderedSymbol[] $values() {
        return new OrderedSymbol[]{DECIMAL, LOWERCASE_ALPHABET, LOWERCASE_ROMAN};
    }

    static {
        DECIMAL = new OrderedSymbol("DECIMAL", 0);
        LOWERCASE_ALPHABET = new OrderedSymbol("LOWERCASE_ALPHABET", 1);
        LOWERCASE_ROMAN = new OrderedSymbol("LOWERCASE_ROMAN", 2);
        $VALUES = $values();
    }

    private OrderedSymbol(String r1, int r2) {
        super(r1, r2);
    }

    public static OrderedSymbol valueOf(String r2) {
        return (OrderedSymbol) ZeusTransformUtils.preCheckCast(Enum.valueOf(OrderedSymbol.class, r2), OrderedSymbol.class, "com.obric.memorydata.plugin");
    }

    public static OrderedSymbol[] values() {
        return (OrderedSymbol[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OrderedSymbol[].class, "com.obric.memorydata.plugin");
    }
}
