package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
interface ProxyInterface {
    int designAccess(int r10, String r11, Object r12, float[] r13, int r14, float[] r15, int r16);

    float getKeyFramePosition(Object r10, int r11, float r12, float r13);

    Object getKeyframeAtLocation(Object r10, float r11, float r12);

    Boolean getPositionKeyframe(Object r10, Object r11, float r12, float r13, String[] r14, float[] r15);

    long getTransitionTimeMs();

    void setAttributes(int r10, String r11, Object r12, Object r13);

    void setKeyFrame(Object r10, int r11, String r12, Object r13);

    boolean setKeyFramePosition(Object r10, int r11, int r12, float r13, float r14);

    void setToolPosition(float r10);
}
