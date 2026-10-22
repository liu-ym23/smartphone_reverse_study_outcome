package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PredictionContextCache {
    protected final Map<PredictionContext, PredictionContext> cache;

    public PredictionContextCache() {
        this.cache = new HashMap();
    }

    public PredictionContext add(PredictionContext r5) {
        EmptyPredictionContext r10 = PredictionContext.EMPTY;
        if (r5 != r10) goto L5;
        return r10;
    L5:
        PredictionContext r11 = this.cache.get(r5);
        if (r11 == null) goto L8;
        return r11;
    L8:
        this.cache.put(r5, r5);
        return r5;
    }

    public PredictionContext get(PredictionContext r5) {
        return this.cache.get(r5);
    }

    public int size() {
        return this.cache.size();
    }
}
