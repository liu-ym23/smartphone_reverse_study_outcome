package com.larus.business.markdown.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "level", "", "unorderedSymbol", "Lcom/larus/business/markdown/api/model/UnorderedSymbol;", "CommonMarkSymbolStrategy", "FlowSymbolStrategy", "GitHubFlavoredSymbolStrategy", "LarkSymbolStrategy", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface g {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/api/model/ListSymbolStrategy$FlowSymbolStrategy;", "Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "()V", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "level", "", "unorderedSymbol", "Lcom/larus/business/markdown/api/model/UnorderedSymbol;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements g {
        public a() {
        }

        @Override // com.larus.business.markdown.api.model.g
        public UnorderedSymbol a(int r1) {
            if (r1 != 0) goto L5;
            return UnorderedSymbol.DISC;
        L5:
            return UnorderedSymbol.CIRCLE;
        }

        @Override // com.larus.business.markdown.api.model.g
        public OrderedSymbol b(int r1) {
            return OrderedSymbol.DECIMAL;
        }
    }

    UnorderedSymbol a(int r1);

    OrderedSymbol b(int r1);
}
