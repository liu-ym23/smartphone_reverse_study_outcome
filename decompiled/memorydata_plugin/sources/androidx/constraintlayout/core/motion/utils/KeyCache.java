package androidx.constraintlayout.core.motion.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map;

    public KeyCache() {
        this.map = new HashMap();
    }

    public float getFloatValue(Object r3, String r4, int r5) {
        if (this.map.containsKey(r3) == true) goto L5;
        return Float.NaN;
    L5:
        HashMap r2 = (HashMap) ZeusTransformUtils.preCheckCast(this.map.get(r3), HashMap.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
    L17:
        return Float.NaN;
    L8:
        if (r2.containsKey(r4) == false) goto L17;
        float[] r6 = (float[]) ZeusTransformUtils.preCheckCast(r2.get(r4), float[].class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L14;
        return Float.NaN;
    L14:
        if (r6.length <= r5) goto L17;
        return r6[r5];
    }

    public void setFloatValue(Object r4, String r5, int r6, float r7) {
        if (this.map.containsKey(r4) == true) goto L6;
        HashMap<String, float[]> r0 = new HashMap();
        float[] r1 = new float[r6 + 1];
        r1[r6] = r7;
        r0.put(r5, r1);
    L5:
        this.map.put(r4, r0);
        return;
    L6:
        r0 = (HashMap) ZeusTransformUtils.preCheckCast(this.map.get(r4), HashMap.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        r0 = new HashMap();
    L10:
        if (r0.containsKey(r5) == true) goto L12;
        float[] r2 = new float[r6 + 1];
        r2[r6] = r7;
        r0.put(r5, r2);
        goto L5
    L12:
        float[] r3 = (float[]) ZeusTransformUtils.preCheckCast(r0.get(r5), float[].class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L16;
        r3 = new float[0];
    L16:
        if (r3.length > r6) goto L18;
        r3 = Arrays.copyOf(r3, r6 + 1);
    L18:
        r3[r6] = r7;
        r0.put(r5, r3);
    }
}
