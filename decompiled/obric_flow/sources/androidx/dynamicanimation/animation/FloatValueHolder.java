package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
public final class FloatValueHolder {
    private float mValue;

    public FloatValueHolder() {
        this.mValue = 0.0f;
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float r5) {
        this.mValue = r5;
    }

    public FloatValueHolder(float r5) {
        this.mValue = 0.0f;
        setValue(r5);
    }
}
