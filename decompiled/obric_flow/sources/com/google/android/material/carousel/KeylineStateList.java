package com.google.android.material.carousel;

import ai.j0;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private KeylineStateList(@NonNull KeylineState r5, List<KeylineState> r10, List<KeylineState> r11) {
        this.defaultState = r5;
        this.startStateSteps = Collections.unmodifiableList(r10);
        this.endStateSteps = Collections.unmodifiableList(r11);
        float r12 = ((KeylineState) j0.e(r10, 1)).getFirstKeyline().loc - r5.getFirstKeyline().loc;
        this.startShiftRange = r12;
        float r13 = r5.getLastKeyline().loc - ((KeylineState) j0.e(r11, 1)).getLastKeyline().loc;
        this.endShiftRange = r13;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(r12, r10, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(r13, r11, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> r5, float r10, float[] r11) {
        float[] r12 = getStateStepsRange(r5, r10, r11);
        if (r12[0] < 0.5f) goto L7;
        return r5.get((int) r12[2]);
    L7:
        return r5.get((int) r12[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState r5, float r10) {
        int r11 = r5.getLastFocalKeylineIndex();
    L4:
        if (r11 >= r5.getKeylines().size()) goto L10;
        if (r10 == r5.getKeylines().get(r11).mask) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L10:
        return r5.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.getKeylines().size()) goto L9;
        if (r5.getKeylines().get(r10).isAnchor == false) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r10;
    L9:
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState r5, float r10) {
        int r11 = r5.getFirstFocalKeylineIndex() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (r10 == r5.getKeylines().get(r11).mask) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        return r11;
    L8:
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState r5) {
        int r10 = r5.getKeylines().size() - 1;
    L3:
        if (r10 < 0) goto L8;
        if (r5.getKeylines().get(r10).isAnchor == false) goto L6;
        r10 = r10 - 1;
        goto L3
    L6:
        return r10;
    L8:
        return -1;
    }

    public static KeylineStateList from(Carousel r5, KeylineState r10, float r11, float r12, float r13) {
        return new KeylineStateList(r10, getStateStepsStart(r5, r10, r11, r12), getStateStepsEnd(r5, r10, r11, r13));
    }

    private static float[] getStateStepInterpolationPoints(float r10, List<KeylineState> r11, boolean r12) {
        int r5 = r11.size();
        float[] r13 = new float[r5];
        int r14 = 1;
    L3:
        if (r14 >= r5) goto L13;
        int r15 = r14 - 1;
        KeylineState r16 = r11.get(r15);
        KeylineState r17 = r11.get(r14);
        if (r12 == false) goto L7;
        float r18 = r17.getFirstKeyline().loc - r16.getFirstKeyline().loc;
    L8:
        float r19 = r18 / r10;
        if (r14 != (r5 - 1)) goto L11;
        float r20 = 1.0f;
    L12:
        r13[r14] = r20;
        r14 = r14 + 1;
        goto L3
    L11:
        r20 = r13[r15] + r19;
        goto L12
    L7:
        r18 = r16.getLastKeyline().loc - r17.getLastKeyline().loc;
        goto L8
    L13:
        return r13;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel r19, KeylineState r20, float r21, float r22) {
        ArrayList r5 = new ArrayList();
        r5.add(r20);
        int r11 = findLastNonAnchorKeylineIndex(r20);
        if (r19.isHorizontal() == false) goto L6;
        int r10 = r19.getContainerWidth();
    L5:
        float r12 = r10;
        if (isLastFocalItemVisibleAtRightOfContainer(r19, r20) == true) goto L32;
        if (r11 == (-1)) goto L32;
        int r15 = r11 - r20.getLastFocalKeylineIndex();
        float r16 = r20.getFirstKeyline().locOffset - (r20.getFirstKeyline().maskedItemSize / 2.0f);
        if (r15 <= 0) goto L15;
    L18:
        float r13 = 0.0f;
        int r14 = 0;
    L19:
        if (r14 >= r15) goto L30;
        KeylineState r17 = (KeylineState) a.h(r5, 1);
        int r18 = r11 - r14;
        float r110 = r13 + r20.getKeylines().get(r18).cutoff;
        int r23 = r18 + 1;
        if (r23 >= r20.getKeylines().size()) goto L23;
        int r24 = findLastIndexBeforeFirstFocalKeylineWithMask(r17, r20.getKeylines().get(r23).mask) + 1;
    L24:
        int r25 = r24;
        int r111 = r14;
        KeylineState r26 = moveKeylineAndCreateKeylineState(r17, r11, r25, r16 - r110, (r20.getFirstFocalKeylineIndex() + r14) + 1, (r20.getLastFocalKeylineIndex() + r14) + 1, r12);
        if (r111 != (r15 - 1)) goto L29;
        if (r22 <= 0.0f) goto L29;
        r26 = shiftKeylineStateForPadding(r26, r22, r12, false, r21);
    L29:
        r5.add(r26);
        r14 = r111 + 1;
        r13 = r110;
        goto L19
    L23:
        r24 = 0;
        goto L24
    L30:
        return r5;
    L15:
        if (r20.getLastFocalKeyline().cutoff <= 0.0f) goto L18;
        r5.add(shiftKeylinesAndCreateKeylineState(r20, r16 - r20.getLastFocalKeyline().cutoff, r12));
        return r5;
    L32:
        if (r22 <= 0.0f) goto L34;
        r5.add(shiftKeylineStateForPadding(r20, r22, r12, false, r21));
    L34:
        return r5;
    L6:
        r10 = r19.getContainerHeight();
        goto L5
    }

    private static float[] getStateStepsRange(List<KeylineState> r10, float r11, float[] r12) {
        int r13 = r10.size();
        float r5 = r12[0];
        int r14 = 1;
    L4:
        if (r14 >= r13) goto L11;
        float r15 = r12[r14];
        if (r11 <= r15) goto L8;
        r14 = r14 + 1;
        r5 = r15;
        goto L4
    L8:
        return new float[]{AnimationUtils.lerp(0.0f, 1.0f, r5, r15, r11), r14 - 1, r14};
    L11:
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel r18, KeylineState r19, float r20, float r21) {
        ArrayList r5 = new ArrayList();
        r5.add(r19);
        int r11 = findFirstNonAnchorKeylineIndex(r19);
        if (r18.isHorizontal() == false) goto L6;
        int r10 = r18.getContainerWidth();
    L5:
        float r12 = r10;
        int r14 = 1;
        if (isFirstFocalItemAtLeftOfContainer(r19) == true) goto L32;
        if (r11 == (-1)) goto L32;
        int r15 = r19.getFirstFocalKeylineIndex() - r11;
        float r16 = r19.getFirstKeyline().locOffset - (r19.getFirstKeyline().maskedItemSize / 2.0f);
        if (r15 <= 0) goto L15;
    L18:
        int r13 = 0;
        float r17 = 0.0f;
    L19:
        if (r13 >= r15) goto L30;
        KeylineState r22 = (KeylineState) a.h(r5, r14);
        int r23 = r11 + r13;
        int r24 = r19.getKeylines().size() - r14;
        float r110 = r17 + r19.getKeylines().get(r23).cutoff;
        int r25 = r23 - r14;
        if (r25 < 0) goto L23;
        int r26 = findFirstIndexAfterLastFocalKeylineWithMask(r22, r19.getKeylines().get(r25).mask) - r14;
    L24:
        int r111 = r13;
        KeylineState r27 = moveKeylineAndCreateKeylineState(r22, r11, r26, r16 + r110, (r19.getFirstFocalKeylineIndex() - r13) - 1, (r19.getLastFocalKeylineIndex() - r13) - 1, r12);
        if (r111 != (r15 - 1)) goto L29;
        if (r21 <= 0.0f) goto L29;
        r27 = shiftKeylineStateForPadding(r27, r21, r12, true, r20);
    L29:
        r5.add(r27);
        r13 = r111 + 1;
        r17 = r110;
        r14 = 1;
        goto L19
    L23:
        r26 = r24;
        goto L24
    L30:
        return r5;
    L15:
        if (r19.getFirstFocalKeyline().cutoff <= 0.0f) goto L18;
        r5.add(shiftKeylinesAndCreateKeylineState(r19, r16 + r19.getFirstFocalKeyline().cutoff, r12));
        return r5;
    L32:
        if (r21 <= 0.0f) goto L34;
        r5.add(shiftKeylineStateForPadding(r19, r21, r12, true, r20));
    L34:
        return r5;
    L6:
        r10 = r18.getContainerHeight();
        goto L5
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState r5) {
        if ((r5.getFirstFocalKeyline().locOffset - (r5.getFirstFocalKeyline().maskedItemSize / 2.0f)) >= 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (r5.getFirstFocalKeyline() != r5.getFirstNonAnchorKeyline()) goto L7;
        return true;
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel r5, KeylineState r10) {
        int r11 = r5.getContainerHeight();
        if (r5.isHorizontal() == false) goto L6;
        r11 = r5.getContainerWidth();
    L6:
        if (((r10.getLastFocalKeyline().maskedItemSize / 2.0f) + r10.getLastFocalKeyline().locOffset) <= r11) goto L8;
    L10:
        return false;
    L8:
        if (r10.getLastFocalKeyline() != r10.getLastNonAnchorKeyline()) goto L10;
        return true;
    }

    private static KeylineState lerp(List<KeylineState> r5, float r10, float[] r11) {
        float[] r12 = getStateStepsRange(r5, r10, r11);
        return KeylineState.lerp(r5.get((int) r12[1]), r5.get((int) r12[2]), r12[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState r10, int r11, int r12, float r13, int r14, int r15, float r16) {
        ArrayList r5 = new ArrayList(r10.getKeylines());
        r5.add(r12, (KeylineState.Keyline) r5.remove(r11));
        KeylineState.Builder r17 = new KeylineState.Builder(r10.getItemSize(), r16);
        int r18 = 0;
    L4:
        if (r18 >= r5.size()) goto L12;
        KeylineState.Keyline r19 = (KeylineState.Keyline) r5.get(r18);
        float r20 = r19.maskedItemSize;
        float r21 = (r20 / 2.0f) + r13;
        if (r18 < r14) goto L9;
        if (r18 > r15) goto L9;
        boolean r22 = true;
    L10:
        r17.addKeyline(r21, r19.mask, r20, r22, r19.isAnchor, r19.cutoff);
        r13 = r13 + r19.maskedItemSize;
        r18 = r18 + 1;
    L9:
        r22 = false;
        goto L10
    L12:
        return r17.build();
    }

    private static KeylineState shiftKeylineStateForPadding(KeylineState r18, float r19, float r20, boolean r21, float r22) {
        ArrayList r5 = new ArrayList(r18.getKeylines());
        KeylineState.Builder r10 = new KeylineState.Builder(r18.getItemSize(), r20);
        float r11 = r19 / r18.getNumberOfNonAnchorKeylines();
        if (r21 == false) goto L5;
        float r12 = r19;
    L6:
        float r14 = r12;
        int r15 = 0;
    L8:
        if (r15 >= r5.size()) goto L28;
        KeylineState.Keyline r13 = (KeylineState.Keyline) r5.get(r15);
        if (r13.isAnchor == false) goto L13;
        r10.addKeyline(r13.locOffset, r13.mask, r13.maskedItemSize, false, true, r13.cutoff);
    L26:
        r15 = r15 + 1;
        goto L8
    L13:
        if (r15 >= r18.getFirstFocalKeylineIndex()) goto L15;
    L17:
        boolean r16 = false;
    L18:
        float r17 = r13.maskedItemSize - r11;
        float r23 = CarouselStrategy.getChildMaskPercentage(r17, r18.getItemSize(), r22);
        float r24 = (r17 / 2.0f) + r14;
        float r25 = r24 - r13.locOffset;
        float r26 = r13.cutoff;
        if (r21 == false) goto L21;
        float r110 = r25;
    L22:
        if (r21 == false) goto L24;
        float r111 = 0.0f;
    L25:
        r10.addKeyline(r24, r23, r17, r16, false, r26, r110, r111);
        r14 = r14 + r17;
        goto L26
    L24:
        r111 = r25;
        goto L25
    L21:
        r110 = 0.0f;
        goto L22
    L15:
        if (r15 > r18.getLastFocalKeylineIndex()) goto L17;
        r16 = true;
        goto L18
    L28:
        return r10.build();
    L5:
        r12 = 0.0f;
        goto L6
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState r10, float r11, float r12) {
        return moveKeylineAndCreateKeylineState(r10, 0, 0, r11, r10.getFirstFocalKeylineIndex(), r10.getLastFocalKeylineIndex(), r12);
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getEndState() {
        return (KeylineState) j0.e(this.endStateSteps, 1);
    }

    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int r11, int r12, int r13, boolean r14) {
        float r5 = this.defaultState.getItemSize();
        HashMap r10 = new HashMap();
        int r15 = 0;
        int r16 = 0;
    L3:
        int r17 = -1;
        if (r15 >= r11) goto L18;
        if (r14 == false) goto L7;
        int r18 = (r11 - r15) - 1;
    L8:
        float r19 = r18 * r5;
        if (r14 == true) goto L13;
        r17 = 1;
    L13:
        if ((r19 * r17) <= (r13 - this.endShiftRange)) goto L15;
    L16:
        Integer r20 = Integer.valueOf(r18);
        List<KeylineState> r21 = this.endStateSteps;
        r10.put(r20, r21.get(MathUtils.clamp(r16, 0, r21.size() - 1)));
        r16 = r16 + 1;
    L17:
        r15 = r15 + 1;
        goto L3
    L15:
        if (r15 < (r11 - this.endStateSteps.size())) goto L17;
    L7:
        r18 = r15;
        goto L8
    L18:
        int r110 = r11 - 1;
        int r22 = 0;
    L19:
        if (r110 < 0) goto L33;
        if (r14 == false) goto L22;
        int r23 = (r11 - r110) - 1;
    L23:
        float r24 = r23 * r5;
        if (r14 == false) goto L26;
        int r25 = -1;
    L28:
        if ((r24 * r25) >= (r12 + this.startShiftRange)) goto L30;
    L31:
        Integer r26 = Integer.valueOf(r23);
        List<KeylineState> r27 = this.startStateSteps;
        r10.put(r26, r27.get(MathUtils.clamp(r22, 0, r27.size() - 1)));
        r22 = r22 + 1;
    L32:
        r110 = r110 - 1;
        goto L19
    L30:
        if (r110 >= this.startStateSteps.size()) goto L32;
    L26:
        r25 = 1;
        goto L28
    L22:
        r23 = r110;
        goto L23
    L33:
        return r10;
    }

    public KeylineState getShiftedState(float r5, float r10, float r11) {
        return getShiftedState(r5, r10, r11, false);
    }

    public KeylineState getStartState() {
        return (KeylineState) j0.e(this.startStateSteps, 1);
    }

    public KeylineState getShiftedState(float r10, float r11, float r12, boolean r13) {
        float r5 = this.startShiftRange + r11;
        float r14 = r12 - this.endShiftRange;
        float r15 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float r16 = getEndState().getLastFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange != r15) goto L6;
        r5 = r5 + r15;
    L6:
        if (this.endShiftRange != r16) goto L9;
        r14 = r14 - r16;
    L9:
        if (r10 >= r5) goto L12;
        float r17 = AnimationUtils.lerp(1.0f, 0.0f, r11, r5, r10);
        List<KeylineState> r18 = this.startStateSteps;
        float[] r19 = this.startStateStepsInterpolationPoints;
    L14:
        if (r13 == false) goto L18;
        return closestStateStepFromInterpolation(r18, r17, r19);
    L18:
        return lerp(r18, r17, r19);
    L12:
        if (r10 <= r14) goto L20;
        r17 = AnimationUtils.lerp(0.0f, 1.0f, r14, r12, r10);
        r18 = this.endStateSteps;
        r19 = this.endStateStepsInterpolationPoints;
        goto L14
    L20:
        return this.defaultState;
    }
}
