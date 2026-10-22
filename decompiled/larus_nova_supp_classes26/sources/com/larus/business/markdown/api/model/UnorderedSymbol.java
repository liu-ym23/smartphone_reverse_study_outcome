package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/markdown/api/model/UnorderedSymbol;", "", "(Ljava/lang/String;I)V", "CIRCLE", "DISC", "SQUARE", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum UnorderedSymbol extends Enum<UnorderedSymbol> {
    private static final /* synthetic */ UnorderedSymbol[] $VALUES = null;
    public static final UnorderedSymbol CIRCLE = null;
    public static final UnorderedSymbol DISC = null;
    public static final UnorderedSymbol SQUARE = null;

    private static final /* synthetic */ UnorderedSymbol[] $values() {
        return new UnorderedSymbol[]{CIRCLE, DISC, SQUARE};
    }

    public static UnorderedSymbol valueOf(String r1) {
        return (UnorderedSymbol) a.a(UnorderedSymbol.class, r1);
    }

    public static UnorderedSymbol[] values() {
        return (UnorderedSymbol[]) $VALUES.clone();
    }

    static {
        CIRCLE = new UnorderedSymbol("CIRCLE", 0);
        DISC = new UnorderedSymbol("DISC", 1);
        SQUARE = new UnorderedSymbol("SQUARE", 2);
        $VALUES = $values();
    }

    private UnorderedSymbol(String r1, int r2) {
        super(r1, r2);
    }
}
