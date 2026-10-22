package com.tom_roush.pdfbox.pdmodel.font;

import com.tom_roush.fontbox.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class j<T extends com.tom_roush.fontbox.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f16241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16242b;

    public j(T r3, boolean r4) {
        this.f16241a = (T) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.fontbox.b.class, "com.obric.memorydata.plugin");
        this.f16242b = r4;
    }

    public T c() {
        return this.f16241a;
    }

    public boolean d() {
        return this.f16242b;
    }
}
