package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
interface ProxyInterface {
    int designAccess(int r5, String r10, Object r11, float[] r12, int r13, float[] r14, int r15);

    float getKeyFramePosition(Object r5, int r10, float r11, float r12);

    Object getKeyframeAtLocation(Object r5, float r10, float r11);

    Boolean getPositionKeyframe(Object r5, Object r10, float r11, float r12, String[] r13, float[] r14);

    long getTransitionTimeMs();

    void setAttributes(int r5, String r10, Object r11, Object r12);

    void setKeyFrame(Object r5, int r10, String r11, Object r12);

    boolean setKeyFramePosition(Object r5, int r10, int r11, float r12, float r13);

    void setToolPosition(float r5);
}
