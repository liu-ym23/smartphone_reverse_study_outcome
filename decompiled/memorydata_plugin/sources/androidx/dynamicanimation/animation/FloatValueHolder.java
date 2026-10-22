package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
public final class FloatValueHolder {
    private float mValue;

    public FloatValueHolder() {
        this.mValue = 0.0f;
    }

    public FloatValueHolder(float r2) {
        this.mValue = 0.0f;
        setValue(r2);
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float r1) {
        this.mValue = r1;
    }
}
