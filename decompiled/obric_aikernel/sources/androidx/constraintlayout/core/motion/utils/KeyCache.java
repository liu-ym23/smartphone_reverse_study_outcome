package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map;

    public KeyCache() {
        this.map = new HashMap();
    }

    public float getFloatValue(Object r10, String r11, int r12) {
        if (this.map.containsKey(r10) == true) goto L5;
        return Float.NaN;
    L5:
        HashMap<String, float[]> r13 = this.map.get(r10);
        if (r13 != null) goto L8;
    L17:
        return Float.NaN;
    L8:
        if (r13.containsKey(r11) == false) goto L17;
        float[] r14 = r13.get(r11);
        if (r14 != null) goto L14;
        return Float.NaN;
    L14:
        if (r14.length <= r12) goto L17;
        return r14[r12];
    }

    public void setFloatValue(Object r10, String r11, int r12, float r13) {
        if (this.map.containsKey(r10) == true) goto L6;
        HashMap<String, float[]> r14 = new HashMap();
        float[] r15 = new float[r12 + 1];
        r15[r12] = r13;
        r14.put(r11, r15);
    L5:
        this.map.put(r10, r14);
        return;
    L6:
        r14 = this.map.get(r10);
        if (r14 != null) goto L10;
        r14 = new HashMap();
    L10:
        if (r14.containsKey(r11) == true) goto L12;
        float[] r16 = new float[r12 + 1];
        r16[r12] = r13;
        r14.put(r11, r16);
        goto L5
    L12:
        float[] r17 = r14.get(r11);
        if (r17 != null) goto L16;
        r17 = new float[0];
    L16:
        if (r17.length > r12) goto L18;
        r17 = Arrays.copyOf(r17, r12 + 1);
    L18:
        r17[r12] = r13;
        r14.put(r11, r17);
    }
}
