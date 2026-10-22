package androidx.core.view;

/* JADX INFO: loaded from: classes.dex */
public interface DifferentialMotionFlingTarget {
    float getScaledScrollFactor();

    boolean startDifferentialMotionFling(float r5);

    void stopDifferentialMotionFling();
}
