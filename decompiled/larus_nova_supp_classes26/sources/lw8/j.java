package lw8;

import com.larus.business.markdown.api.model.OrderedSymbol;
import com.larus.business.markdown.api.model.UnorderedSymbol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface j {

    public static final class a implements j {
        public a() {
        }

        @Override // lw8.j
        public final OrderedSymbol a() {
            return OrderedSymbol.DECIMAL;
        }

        @Override // lw8.j
        public final UnorderedSymbol b(int r1) {
            if (r1 != 0) goto L5;
            return UnorderedSymbol.DISC;
        L5:
            return UnorderedSymbol.CIRCLE;
        }
    }

    OrderedSymbol a();

    UnorderedSymbol b(int r1);
}
