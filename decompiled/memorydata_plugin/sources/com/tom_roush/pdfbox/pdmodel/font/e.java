package com.tom_roush.pdfbox.pdmodel.font;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<f, SoftReference<com.tom_roush.fontbox.b>> f16233a;

    public e() {
        this.f16233a = new ConcurrentHashMap();
    }

    public com.tom_roush.fontbox.b a(f r2) {
        SoftReference r1 = (SoftReference) ZeusTransformUtils.preCheckCast(this.f16233a.get(r2), SoftReference.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return (com.tom_roush.fontbox.b) ZeusTransformUtils.preCheckCast(r1.get(), com.tom_roush.fontbox.b.class, "com.obric.memorydata.plugin");
    }

    public void a(f r3, com.tom_roush.fontbox.b r4) {
        com.tom_roush.fontbox.b r5 = (com.tom_roush.fontbox.b) ZeusTransformUtils.wrapperContextForParams(r4, com.tom_roush.fontbox.b.class, "com.obric.memorydata.plugin");
        this.f16233a.put(r3, new SoftReference(r5));
    }
}
