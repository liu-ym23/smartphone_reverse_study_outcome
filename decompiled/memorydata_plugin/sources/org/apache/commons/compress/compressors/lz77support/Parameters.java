package org.apache.commons.compress.compressors.lz77support;

/* JADX INFO: loaded from: classes6.dex */
public final class Parameters {
    private final boolean lazyMatching;
    private final int lazyThreshold;
    private final int maxBackReferenceLength;
    private final int maxCandidates;
    private final int maxLiteralLength;
    private final int maxOffset;
    private final int minBackReferenceLength;
    private final int niceBackReferenceLength;
    private final int windowSize;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.lz77support.Parameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Boolean lazyMatches;
        private Integer lazyThreshold;
        private int maxBackReferenceLength;
        private Integer maxCandidates;
        private int maxLiteralLength;
        private int maxOffset;
        private int minBackReferenceLength;
        private Integer niceBackReferenceLength;
        private final int windowSize;

        private Builder(int r2) {
            if (r2 < 2) goto L9;
            if (Parameters.access$100(r2) == false) goto L9;
            this.windowSize = r2;
            this.minBackReferenceLength = 3;
            int r0 = r2 - 1;
            this.maxBackReferenceLength = r0;
            this.maxOffset = r0;
            this.maxLiteralLength = r2;
            return;
        L9:
            throw new IllegalArgumentException("windowSize must be a power of two");
        }

        /* synthetic */ Builder(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        public Parameters build() {
            Integer r0 = this.niceBackReferenceLength;
            if (r0 == null) goto L5;
            int r1 = r0.intValue();
        L6:
            int r7 = r1;
            Integer r2 = this.maxCandidates;
            if (r2 == null) goto L9;
            int r3 = r2.intValue();
        L10:
            int r8 = r3;
            Boolean r4 = this.lazyMatches;
            if (r4 != null) goto L13;
        L16:
            boolean r5 = true;
        L17:
            boolean r9 = r5;
            if (r9 == false) goto L23;
            Integer r6 = this.lazyThreshold;
            if (r6 == null) goto L22;
            int r10 = r6.intValue();
        L24:
            int r11 = r10;
        L26:
            return new Parameters(this.windowSize, this.minBackReferenceLength, this.maxBackReferenceLength, this.maxOffset, this.maxLiteralLength, r7, r8, r9, r11, null);
        L22:
            r11 = r7;
            goto L26
        L23:
            r10 = this.minBackReferenceLength;
            goto L24
        L13:
            if (r4.booleanValue() == true) goto L16;
            r5 = false;
            goto L17
        L9:
            r3 = Math.max(256, this.windowSize / 128);
            goto L10
        L5:
            r1 = Math.max(this.minBackReferenceLength, this.maxBackReferenceLength / 2);
            goto L6
        }

        public Builder withMaxBackReferenceLength(int r2) {
            int r0 = this.minBackReferenceLength;
            if (r2 < r0) goto L6;
            r0 = Math.min(r2, this.windowSize - 1);
        L6:
            this.maxBackReferenceLength = r0;
            return this;
        }

        public Builder withMaxLiteralLength(int r2) {
            if (r2 >= 1) goto L5;
            int r3 = this.windowSize;
        L6:
            this.maxLiteralLength = r3;
            return this;
        L5:
            r3 = Math.min(r2, this.windowSize);
            goto L6
        }

        public Builder withMaxOffset(int r3) {
            if (r3 >= 1) goto L5;
            int r4 = this.windowSize - 1;
        L6:
            this.maxOffset = r4;
            return this;
        L5:
            r4 = Math.min(r3, this.windowSize - 1);
            goto L6
        }

        public Builder withMinBackReferenceLength(int r2) {
            int r3 = Math.max(3, r2);
            this.minBackReferenceLength = r3;
            if (this.windowSize < r3) goto L9;
            if (this.maxBackReferenceLength >= r3) goto L7;
            this.maxBackReferenceLength = r3;
        L7:
            return this;
        L9:
            throw new IllegalArgumentException("minBackReferenceLength can't be bigger than windowSize");
        }
    }

    private Parameters(int r1, int r2, int r3, int r4, int r5, int r6, int r7, boolean r8, int r9) {
        this.windowSize = r1;
        this.minBackReferenceLength = r2;
        this.maxBackReferenceLength = r3;
        this.maxOffset = r4;
        this.maxLiteralLength = r5;
        this.niceBackReferenceLength = r6;
        this.maxCandidates = r7;
        this.lazyMatching = r8;
        this.lazyThreshold = r9;
    }

    /* synthetic */ Parameters(int r1, int r2, int r3, int r4, int r5, int r6, int r7, boolean r8, int r9, AnonymousClass1 r10) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    static /* synthetic */ boolean access$100(int r0) {
        return isPowerOfTwo(r0);
    }

    public static Builder builder(int r2) {
        return new Builder(r2, null);
    }

    private static boolean isPowerOfTwo(int r1) {
        if ((r1 & (r1 - 1)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean getLazyMatching() {
        return this.lazyMatching;
    }

    public int getLazyMatchingThreshold() {
        return this.lazyThreshold;
    }

    public int getMaxBackReferenceLength() {
        return this.maxBackReferenceLength;
    }

    public int getMaxCandidates() {
        return this.maxCandidates;
    }

    public int getMaxLiteralLength() {
        return this.maxLiteralLength;
    }

    public int getMaxOffset() {
        return this.maxOffset;
    }

    public int getMinBackReferenceLength() {
        return this.minBackReferenceLength;
    }

    public int getNiceBackReferenceLength() {
        return this.niceBackReferenceLength;
    }

    public int getWindowSize() {
        return this.windowSize;
    }
}
