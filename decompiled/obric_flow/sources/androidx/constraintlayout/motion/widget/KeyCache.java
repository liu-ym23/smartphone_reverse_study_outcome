package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map;

    public KeyCache() {
        this.map = new HashMap();
    }

    public float getFloatValue(Object r5, String r10, int r11) {
        if (this.map.containsKey(r5) == true) goto L5;
        return Float.NaN;
    L5:
        HashMap<String, float[]> r12 = this.map.get(r5);
        if (r12.containsKey(r10) == true) goto L8;
        return Float.NaN;
    L8:
        float[] r13 = r12.get(r10);
        if (r13.length > r11) goto L11;
        return Float.NaN;
    L11:
        return r13[r11];
    }

    public void setFloatValue(Object r5, String r10, int r11, float r12) {
        if (this.map.containsKey(r5) == true) goto L5;
        HashMap<String, float[]> r13 = new HashMap();
        float[] r14 = new float[r11 + 1];
        r14[r11] = r12;
        r13.put(r10, r14);
        this.map.put(r5, r13);
        return;
    L5:
        HashMap<String, float[]> r15 = this.map.get(r5);
        if (r15.containsKey(r10) == true) goto L8;
        float[] r16 = new float[r11 + 1];
        r16[r11] = r12;
        r15.put(r10, r16);
        this.map.put(r5, r15);
        return;
    L8:
        float[] r17 = r15.get(r10);
        if (r17.length > r11) goto L11;
        r17 = Arrays.copyOf(r17, r11 + 1);
    L11:
        r17[r11] = r12;
        r15.put(r10, r17);
    }
}
