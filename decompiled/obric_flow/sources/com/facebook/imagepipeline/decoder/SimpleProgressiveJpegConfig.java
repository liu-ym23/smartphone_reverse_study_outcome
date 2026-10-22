package com.facebook.imagepipeline.decoder;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleProgressiveJpegConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DynamicValueConfig f8167a;

    public static class DefaultDynamicValueConfig implements DynamicValueConfig {
        public DefaultDynamicValueConfig() {
        }
    }

    public interface DynamicValueConfig {
    }

    public SimpleProgressiveJpegConfig() {
        this.f8167a = new DefaultDynamicValueConfig();
    }

    public final int a(int r5) {
        ((DefaultDynamicValueConfig) this.f8167a).getClass();
        List r10 = Collections.EMPTY_LIST;
        if (r10 == null) goto L18;
        if (r10.isEmpty() == true) goto L18;
        int r11 = 0;
    L9:
        if (r11 >= r10.size()) goto L15;
        if (((Integer) r10.get(r11)).intValue() > r5) goto L13;
        r11 = r11 + 1;
        goto L9
    L13:
        return ((Integer) r10.get(r11)).intValue();
    L15:
        return Integer.MAX_VALUE;
    L18:
        return r5 + 1;
    }
}
