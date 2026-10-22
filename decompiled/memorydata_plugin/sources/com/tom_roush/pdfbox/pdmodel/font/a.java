package com.tom_roush.pdfbox.pdmodel.font;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends j<com.tom_roush.fontbox.f.x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.fontbox.b f16214a;

    public a(com.tom_roush.fontbox.f.x r3, com.tom_roush.fontbox.b r4, boolean r5) {
        com.tom_roush.fontbox.b r6 = (com.tom_roush.fontbox.b) ZeusTransformUtils.wrapperContextForParams(r4, com.tom_roush.fontbox.b.class, "com.obric.memorydata.plugin");
        super(r3, r5);
        this.f16214a = r6;
    }

    public com.tom_roush.fontbox.b a() {
        return this.f16214a;
    }

    public boolean b() {
        if (c() == null) goto L5;
        return true;
    L5:
        return false;
    }
}
