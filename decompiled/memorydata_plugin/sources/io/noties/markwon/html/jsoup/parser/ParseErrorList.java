package io.noties.markwon.html.jsoup.parser;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ParseErrorList extends ArrayList<b> {
    private static final int INITIAL_CAPACITY = 16;
    private final int maxSize;

    ParseErrorList(int r1, int r2) {
        super(r1);
        this.maxSize = r2;
    }

    public static ParseErrorList noTracking() {
        return new ParseErrorList(0, 0);
    }

    public static ParseErrorList tracking(int r2) {
        return new ParseErrorList(16, r2);
    }

    boolean canAddError() {
        if (size() >= this.maxSize) goto L5;
        return true;
    L5:
        return false;
    }

    int getMaxSize() {
        return this.maxSize;
    }
}
