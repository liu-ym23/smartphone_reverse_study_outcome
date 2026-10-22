package androidx.constraintlayout.core.motion;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class CustomVariable {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private int mType;

    public CustomVariable(CustomVariable r10) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r10.mName;
        this.mType = r10.mType;
        this.mIntegerValue = r10.mIntegerValue;
        this.mFloatValue = r10.mFloatValue;
        this.mStringValue = r10.mStringValue;
        this.mBooleanValue = r10.mBooleanValue;
    }

    public CustomVariable(CustomVariable r10, Object r11) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r10.mName;
        this.mType = r10.mType;
        setValue(r11);
    }

    public CustomVariable(String r10, int r11) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r10;
        this.mType = r11;
    }

    public CustomVariable(String r10, int r11, float r12) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r10;
        this.mType = r11;
        this.mFloatValue = r12;
    }

    public CustomVariable(String r10, int r11, int r12) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r10;
        this.mType = r11;
        if (r11 != 901) goto L5;
        this.mFloatValue = r12;
        return;
    L5:
        this.mIntegerValue = r12;
    }

    public CustomVariable(String r10, int r11, Object r12) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r10;
        this.mType = r11;
        setValue(r12);
    }

    public CustomVariable(String r10, int r11, String r12) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r10;
        this.mType = r11;
        this.mStringValue = r12;
    }

    public CustomVariable(String r10, int r11, boolean r12) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r10;
        this.mType = r11;
        this.mBooleanValue = r12;
    }

    private static int clamp(int r10) {
        int r11 = (r10 & (~(r10 >> 31))) - 255;
        return (r11 & (r11 >> 31)) + 255;
    }

    public static String colorString(int r10) {
        String r11 = "00000000" + Integer.toHexString(r10);
        return "#" + r11.substring(r11.length() - 8);
    }

    public static int hsvToRgb(float r10, float r11, float r12) {
        float r13 = r10 * 6.0f;
        int r14 = (int) r13;
        float r15 = r13 - r14;
        float r16 = r12 * 255.0f;
        int r17 = (int) (((1.0f - r11) * r16) + 0.5f);
        int r18 = (int) (((1.0f - (r15 * r11)) * r16) + 0.5f);
        int r19 = (int) (((1.0f - ((1.0f - r15) * r11)) * r16) + 0.5f);
        int r20 = (int) (r16 + 0.5f);
        if (r14 == 0) goto L27;
        if (r14 == 1) goto L25;
        if (r14 == 2) goto L23;
        if (r14 == 3) goto L21;
        if (r14 == 4) goto L19;
        if (r14 == 5) goto L17;
        return 0;
    L17:
        return (((r20 << 16) + (r17 << 8)) + r18) | ViewCompat.MEASURED_STATE_MASK;
    L19:
        return (((r19 << 16) + (r17 << 8)) + r20) | ViewCompat.MEASURED_STATE_MASK;
    L21:
        return (((r17 << 16) + (r18 << 8)) + r20) | ViewCompat.MEASURED_STATE_MASK;
    L23:
        return (((r17 << 16) + (r20 << 8)) + r19) | ViewCompat.MEASURED_STATE_MASK;
    L25:
        return (((r18 << 16) + (r20 << 8)) + r17) | ViewCompat.MEASURED_STATE_MASK;
    L27:
        return (((r20 << 16) + (r19 << 8)) + r17) | ViewCompat.MEASURED_STATE_MASK;
    }

    public static int rgbaTocColor(float r10, float r11, float r12, float r13) {
        int r14 = clamp((int) (r10 * 255.0f));
        int r15 = clamp((int) (r11 * 255.0f));
        int r16 = clamp((int) (r12 * 255.0f));
        int r17 = r14 << 16;
        return ((r17 | (clamp((int) (r13 * 255.0f)) << 24)) | (r15 << 8)) | r16;
    }

    public void applyToWidget(MotionWidget r10) {
        int r11 = this.mType;
        switch(r11) {
            case 900: goto L8;
            case 901: goto L7;
            case 902: goto L8;
            case 903: goto L6;
            case 904: goto L5;
            case 905: goto L7;
            case 906: goto L8;
            default: goto L13;
        };
    L5:
        r10.setCustomAttribute(this.mName, r11, this.mBooleanValue);
        return;
    L6:
        r10.setCustomAttribute(this.mName, r11, this.mStringValue);
        return;
    L7:
        r10.setCustomAttribute(this.mName, r11, this.mFloatValue);
        return;
    L8:
        r10.setCustomAttribute(this.mName, r11, this.mIntegerValue);
        return;
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public boolean diff(CustomVariable r10) {
        if (r10 == null) goto L39;
        int r11 = this.mType;
        if (r11 == r10.mType) goto L8;
        return false;
    L8:
        switch(r11) {
            case 900: goto L31;
            case 901: goto L27;
            case 902: goto L23;
            case 903: goto L19;
            case 904: goto L15;
            case 905: goto L11;
            case 906: goto L31;
            default: goto L9;
        };
    L9:
        return false;
    L11:
        if (this.mFloatValue == r10.mFloatValue) goto L13;
        return false;
    L13:
        return true;
    L15:
        if (this.mBooleanValue == r10.mBooleanValue) goto L17;
        return false;
    L17:
        return true;
    L19:
        if (this.mIntegerValue == r10.mIntegerValue) goto L21;
        return false;
    L21:
        return true;
    L23:
        if (this.mIntegerValue == r10.mIntegerValue) goto L25;
        return false;
    L25:
        return true;
    L27:
        if (this.mFloatValue == r10.mFloatValue) goto L29;
        return false;
    L29:
        return true;
    L31:
        if (this.mIntegerValue == r10.mIntegerValue) goto L33;
        return false;
    L33:
        return true;
    L39:
        return false;
    }

    public boolean getBooleanValue() {
        return this.mBooleanValue;
    }

    public int getColorValue() {
        return this.mIntegerValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public int getInterpolatedColor(float[] r10) {
        int r11 = clamp((int) (((float) Math.pow(r10[0], 0.45454545454545453d)) * 255.0f));
        int r12 = clamp((int) (((float) Math.pow(r10[1], 0.45454545454545453d)) * 255.0f));
        return (((r11 << 16) | (clamp((int) (r10[3] * 255.0f)) << 24)) | (r12 << 8)) | clamp((int) (((float) Math.pow(r10[2], 0.45454545454545453d)) * 255.0f));
    }

    public String getName() {
        return this.mName;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public int getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch(this.mType) {
            case 900: goto L20;
            case 901: goto L18;
            case 902: goto L16;
            case 903: goto L14;
            case 904: goto L9;
            case 905: goto L7;
            default: goto L4;
        };
    L4:
        return Float.NaN;
    L7:
        return this.mFloatValue;
    L9:
        if (this.mBooleanValue == false) goto L11;
        return 1.0f;
    L11:
        return 0.0f;
    L14:
        throw new RuntimeException("Cannot interpolate String");
    L16:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L18:
        return this.mFloatValue;
    L20:
        return this.mIntegerValue;
    }

    public void getValuesToInterpolate(float[] r10) {
        switch(this.mType) {
            case 900: goto L15;
            case 901: goto L14;
            case 902: goto L13;
            case 903: goto L12;
            case 904: goto L7;
            case 905: goto L5;
            default: goto L21;
        };
    L5:
        r10[0] = this.mFloatValue;
        return;
    L13:
        int r11 = this.mIntegerValue;
        int r12 = (r11 >> 24) & 255;
        float r13 = (float) Math.pow(((r11 >> 16) & 255) / 255.0f, 2.2d);
        float r14 = (float) Math.pow(((r11 >> 8) & 255) / 255.0f, 2.2d);
        float r15 = (float) Math.pow((r11 & 255) / 255.0f, 2.2d);
        r10[0] = r13;
        r10[1] = r14;
        r10[2] = r15;
        r10[3] = r12 / 255.0f;
        return;
    L14:
        r10[0] = this.mFloatValue;
        return;
    L15:
        r10[0] = this.mIntegerValue;
        return;
    L21:
        return;
    L7:
        if (this.mBooleanValue == false) goto L9;
        float r16 = 1.0f;
    L10:
        r10[0] = r16;
        return;
    L9:
        r16 = 0.0f;
        goto L10
    L12:
        throw new RuntimeException("Cannot interpolate String");
    }

    public boolean isContinuous() {
        int r10 = this.mType;
        if (r10 != 903) goto L5;
        return false;
    L5:
        if (r10 != 904) goto L7;
        return false;
    L7:
        if (r10 == 906) goto L13;
        return true;
    L13:
        return false;
    }

    public int numberOfInterpolatedValues() {
        if (this.mType == 902) goto L6;
        return 1;
    L6:
        return 4;
    }

    public void setBooleanValue(boolean r10) {
        this.mBooleanValue = r10;
    }

    public void setFloatValue(float r10) {
        this.mFloatValue = r10;
    }

    public void setIntValue(int r10) {
        this.mIntegerValue = r10;
    }

    public void setInterpolatedValue(MotionWidget r10, float[] r11) {
        int r12 = this.mType;
        boolean r13 = true;
        switch(r12) {
            case 900: goto L14;
            case 901: goto L13;
            case 902: goto L12;
            case 903: goto L11;
            case 904: goto L5;
            case 905: goto L13;
            case 906: goto L11;
            default: goto L19;
        };
    L5:
        String r14 = this.mName;
        if (r11[0] > 0.5f) goto L9;
        r13 = false;
    L9:
        r10.setCustomAttribute(r14, r12, r13);
        return;
    L12:
        int r15 = clamp((int) (((float) Math.pow(r11[0], 0.45454545454545453d)) * 255.0f));
        int r16 = clamp((int) (((float) Math.pow(r11[1], 0.45454545454545453d)) * 255.0f));
        r10.setCustomAttribute(this.mName, this.mType, (((clamp((int) (r11[3] * 255.0f)) << 24) | (r15 << 16)) | (r16 << 8)) | clamp((int) (((float) Math.pow(r11[2], 0.45454545454545453d)) * 255.0f)));
        return;
    L13:
        r10.setCustomAttribute(this.mName, r12, r11[0]);
        return;
    L14:
        r10.setCustomAttribute(this.mName, r12, (int) r11[0]);
        return;
    L19:
        return;
    L11:
        throw new RuntimeException("unable to interpolate " + this.mName);
    }

    public void setStringValue(String r10) {
        this.mStringValue = r10;
    }

    public void setValue(Object r10) {
        switch(this.mType) {
            case 900: goto L8;
            case 901: goto L7;
            case 902: goto L8;
            case 903: goto L6;
            case 904: goto L5;
            case 905: goto L7;
            case 906: goto L8;
            default: goto L13;
        };
    L5:
        this.mBooleanValue = ((Boolean) r10).booleanValue();
        return;
    L6:
        this.mStringValue = (String) r10;
        return;
    L7:
        this.mFloatValue = ((Float) r10).floatValue();
        return;
    L8:
        this.mIntegerValue = ((Integer) r10).intValue();
        return;
    }

    public void setValue(float[] r10) {
        boolean r11 = true;
        switch(this.mType) {
            case 900: goto L14;
            case 901: goto L13;
            case 902: goto L12;
            case 903: goto L11;
            case 904: goto L6;
            case 905: goto L13;
            case 906: goto L14;
            default: goto L19;
        };
    L12:
        float r12 = r10[0];
        float r13 = r10[1];
        float r14 = r10[2];
        int r15 = Math.round(((float) Math.pow(r12, 0.5d)) * 255.0f) & 255;
        int r16 = Math.round(((float) Math.pow(r13, 0.5d)) * 255.0f) & 255;
        int r17 = ((((Math.round(r10[3] * 255.0f) & 255) << 24) | (r15 << 16)) | (r16 << 8)) | (Math.round(((float) Math.pow(r14, 0.5d)) * 255.0f) & 255);
    L15:
        this.mIntegerValue = r17;
        return;
    L13:
        this.mFloatValue = r10[0];
        return;
    L14:
        r17 = (int) r10[0];
        goto L15
    L19:
        return;
    L6:
        if (r10[0] > 0.5d) goto L9;
        r11 = false;
    L9:
        this.mBooleanValue = r11;
        return;
    L11:
        throw new RuntimeException("Cannot interpolate String");
    }

    public String toString() {
        String r10 = this.mName + ':';
        switch(this.mType) {
            case 900: goto L17;
            case 901: goto L15;
            case 902: goto L13;
            case 903: goto L11;
            case 904: goto L9;
            case 905: goto L7;
            default: goto L5;
        };
    L5:
        return r10 + "????";
    L7:
        return r10 + this.mFloatValue;
    L9:
        return r10 + Boolean.valueOf(this.mBooleanValue);
    L11:
        return r10 + this.mStringValue;
    L13:
        return r10 + colorString(this.mIntegerValue);
    L15:
        return r10 + this.mFloatValue;
    L17:
        return r10 + this.mIntegerValue;
    }
}
