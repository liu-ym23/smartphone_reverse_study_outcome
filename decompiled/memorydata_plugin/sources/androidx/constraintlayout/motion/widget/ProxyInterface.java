package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
interface ProxyInterface {
    int designAccess(int r1, String r2, Object r3, float[] r4, int r5, float[] r6, int r7);

    float getKeyFramePosition(Object r1, int r2, float r3, float r4);

    Object getKeyframeAtLocation(Object r1, float r2, float r3);

    Boolean getPositionKeyframe(Object r1, Object r2, float r3, float r4, String[] r5, float[] r6);

    long getTransitionTimeMs();

    void setAttributes(int r1, String r2, Object r3, Object r4);

    void setKeyFrame(Object r1, int r2, String r3, Object r4);

    boolean setKeyFramePosition(Object r1, int r2, int r3, float r4, float r5);

    void setToolPosition(float r1);
}
