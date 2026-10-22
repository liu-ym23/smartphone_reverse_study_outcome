package com.google.android.material.carousel;

import ai.j0;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class KeylineState {
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;

    /* JADX INFO: renamed from: com.google.android.material.carousel.KeylineState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final float availableSpace;
        private int firstFocalKeylineIndex;
        private final float itemSize;
        private int lastFocalKeylineIndex;
        private float lastKeylineMaskedSize;
        private int latestAnchorKeylineIndex;
        private Keyline tmpFirstFocalKeyline;
        private final List<Keyline> tmpKeylines;
        private Keyline tmpLastFocalKeyline;

        public Builder(float r5, float r10) {
            this.tmpKeylines = new ArrayList();
            this.firstFocalKeylineIndex = -1;
            this.lastFocalKeylineIndex = -1;
            this.lastKeylineMaskedSize = 0.0f;
            this.latestAnchorKeylineIndex = -1;
            this.itemSize = r5;
            this.availableSpace = r10;
        }

        private static float calculateKeylineLocationForItemPosition(float r5, float r10, int r11, int r12) {
            return (r12 * r10) + (r5 - (r11 * r10));
        }

        @NonNull
        public Builder addAnchorKeyline(float r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, float r12) {
            return addKeyline(r10, r11, r12, false, true);
        }

        @NonNull
        public Builder addKeyline(float r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, float r12, boolean r13) {
            return addKeyline(r10, r11, r12, r13, false);
        }

        @NonNull
        public Builder addKeylineRange(float r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, float r12, int r13) {
            return addKeylineRange(r10, r11, r12, r13, false);
        }

        @NonNull
        public KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) goto L11;
            ArrayList r5 = new ArrayList();
            int r10 = 0;
        L6:
            if (r10 >= this.tmpKeylines.size()) goto L9;
            Keyline r11 = this.tmpKeylines.get(r10);
            r5.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, r10), r11.locOffset, r11.mask, r11.maskedItemSize, r11.isAnchor, r11.cutoff, r11.leftOrTopPaddingShift, r11.rightOrBottomPaddingShift));
            r10 = r10 + 1;
            goto L6
        L9:
            return new KeylineState(this.itemSize, r5, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex, null);
        L11:
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }

        @NonNull
        public Builder addKeyline(float r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10, float r11) {
            return addKeyline(r5, r10, r11, false);
        }

        @NonNull
        public Builder addKeylineRange(float r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10, float r11, int r12, boolean r13) {
            if (r12 > 0) goto L4;
        L9:
            return this;
        L4:
            if (r11 <= 0.0f) goto L9;
            int r14 = 0;
        L7:
            if (r14 >= r12) goto L9;
            addKeyline((r14 * r11) + r5, r10, r11, r13);
            r14 = r14 + 1;
            goto L7
        }

        @NonNull
        public Builder addKeyline(float r13, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r14, float r15, boolean r16, boolean r17, float r18, float r19, float r20) {
            if (r15 > 0.0f) goto L6;
            return this;
        L6:
            if (r17 == false) goto L17;
            if (r16 == true) goto L16;
            int r5 = this.latestAnchorKeylineIndex;
            if (r5 == (-1)) goto L14;
            if (r5 == 0) goto L14;
            throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
        L14:
            this.latestAnchorKeylineIndex = this.tmpKeylines.size();
            goto L17
        L16:
            throw new IllegalArgumentException("Anchor keylines cannot be focal.");
        L17:
            Keyline r11 = new Keyline(Float.MIN_VALUE, r13, r14, r15, r17, r18, r19, r20);
            if (r16 == false) goto L35;
            if (this.tmpFirstFocalKeyline != null) goto L23;
            this.tmpFirstFocalKeyline = r11;
            this.firstFocalKeylineIndex = this.tmpKeylines.size();
        L23:
            if (this.lastFocalKeylineIndex == (-1)) goto L30;
            if ((this.tmpKeylines.size() - this.lastFocalKeylineIndex) <= 1) goto L30;
            throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
        L30:
            if (r15 != this.tmpFirstFocalKeyline.maskedItemSize) goto L33;
            this.tmpLastFocalKeyline = r11;
            this.lastFocalKeylineIndex = this.tmpKeylines.size();
        L48:
            this.lastKeylineMaskedSize = r11.maskedItemSize;
            this.tmpKeylines.add(r11);
            return this;
        L33:
            throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
        L35:
            if (this.tmpFirstFocalKeyline != null) goto L42;
            if (r11.maskedItemSize >= this.lastKeylineMaskedSize) goto L42;
            throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
        L42:
            if (this.tmpLastFocalKeyline == null) goto L48;
            if (r11.maskedItemSize <= this.lastKeylineMaskedSize) goto L48;
            throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
        }

        @NonNull
        public Builder addKeyline(float r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, float r12, boolean r13, boolean r14, float r15) {
            return addKeyline(r10, r11, r12, r13, r14, r15, 0.0f, 0.0f);
        }

        @NonNull
        public Builder addKeyline(float r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, float r12, boolean r13, boolean r14) {
            float r5 = r12 / 2.0f;
            float r15 = r10 - r5;
            float r16 = r5 + r10;
            float r17 = this.availableSpace;
            if (r16 <= r17) goto L6;
            float r18 = Math.abs(r16 - Math.max(r16 - r12, r17));
        L10:
            return addKeyline(r10, r11, r12, r13, r14, r18);
        L6:
            r18 = 0.0f;
            if (r15 >= 0.0f) goto L10;
            r18 = Math.abs(r15 - Math.min(r15 + r12, 0.0f));
            goto L10
        }
    }

    public static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;

        public Keyline(float r10, float r11, float r12, float r13) {
            this(r10, r11, r12, r13, false, 0.0f, 0.0f, 0.0f);
        }

        public static Keyline lerp(Keyline r5, Keyline r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11) {
            return new Keyline(AnimationUtils.lerp(r5.loc, r10.loc, r11), AnimationUtils.lerp(r5.locOffset, r10.locOffset, r11), AnimationUtils.lerp(r5.mask, r10.mask, r11), AnimationUtils.lerp(r5.maskedItemSize, r10.maskedItemSize, r11));
        }

        public Keyline(float r5, float r10, float r11, float r12, boolean r13, float r14, float r15, float r16) {
            this.loc = r5;
            this.locOffset = r10;
            this.mask = r11;
            this.maskedItemSize = r12;
            this.isAnchor = r13;
            this.cutoff = r14;
            this.leftOrTopPaddingShift = r15;
            this.rightOrBottomPaddingShift = r16;
        }
    }

    public /* synthetic */ KeylineState(float r5, List r10, int r11, int r12, AnonymousClass1 r13) {
        this(r5, r10, r11, r12);
    }

    public static KeylineState lerp(KeylineState r10, KeylineState r11, float r12) {
        if (r10.getItemSize() != r11.getItemSize()) goto L15;
        List<Keyline> r5 = r10.getKeylines();
        List<Keyline> r13 = r11.getKeylines();
        if (r5.size() != r13.size()) goto L13;
        ArrayList r14 = new ArrayList();
        int r15 = 0;
    L8:
        if (r15 >= r10.getKeylines().size()) goto L10;
        r14.add(Keyline.lerp(r5.get(r15), r13.get(r15), r12));
        r15 = r15 + 1;
        goto L8
    L10:
        int r16 = AnimationUtils.lerp(r10.getFirstFocalKeylineIndex(), r11.getFirstFocalKeylineIndex(), r12);
        int r17 = AnimationUtils.lerp(r10.getLastFocalKeylineIndex(), r11.getLastFocalKeylineIndex(), r12);
        return new KeylineState(r10.getItemSize(), r14, r16, r17);
    L13:
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
    L15:
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }

    public static KeylineState reverse(KeylineState r11, float r12) {
        Builder r10 = new Builder(r11.getItemSize(), r12);
        float r13 = (r12 - r11.getLastKeyline().locOffset) - (r11.getLastKeyline().maskedItemSize / 2.0f);
        int r14 = r11.getKeylines().size() - 1;
    L3:
        if (r14 < 0) goto L12;
        Keyline r15 = r11.getKeylines().get(r14);
        float r5 = (r15.maskedItemSize / 2.0f) + r13;
        if (r14 >= r11.getFirstFocalKeylineIndex()) goto L7;
    L9:
        boolean r16 = false;
    L10:
        r10.addKeyline(r5, r15.mask, r15.maskedItemSize, r16, r15.isAnchor);
        r13 = r13 + r15.maskedItemSize;
        r14 = r14 - 1;
        goto L3
    L7:
        if (r14 > r11.getLastFocalKeylineIndex()) goto L9;
        r16 = true;
        goto L10
    L12:
        return r10.build();
    }

    public Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    public int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    public Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    @Nullable
    public Keyline getFirstNonAnchorKeyline() {
        int r5 = 0;
    L4:
        if (r5 >= this.keylines.size()) goto L9;
        Keyline r10 = this.keylines.get(r5);
        if (r10.isAnchor == false) goto L7;
        r5 = r5 + 1;
        goto L4
    L7:
        return r10;
    L9:
        return null;
    }

    public List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    public float getItemSize() {
        return this.itemSize;
    }

    public List<Keyline> getKeylines() {
        return this.keylines;
    }

    public Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    public int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    public Keyline getLastKeyline() {
        return (Keyline) j0.e(this.keylines, 1);
    }

    @Nullable
    public Keyline getLastNonAnchorKeyline() {
        int r5 = this.keylines.size() - 1;
    L3:
        if (r5 < 0) goto L8;
        Keyline r10 = this.keylines.get(r5);
        if (r10.isAnchor == false) goto L6;
        r5 = r5 - 1;
        goto L3
    L6:
        return r10;
    L8:
        return null;
    }

    public int getNumberOfNonAnchorKeylines() {
        Iterator<Keyline> r5 = this.keylines.iterator();
        int r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L9;
        if (r5.next().isAnchor == false) goto L4;
        r10 = r10 + 1;
        goto L4
    L9:
        return this.keylines.size() - r10;
    }

    private KeylineState(float r5, List<Keyline> r10, int r11, int r12) {
        this.itemSize = r5;
        this.keylines = Collections.unmodifiableList(r10);
        this.firstFocalKeylineIndex = r11;
        this.lastFocalKeylineIndex = r12;
    }
}
