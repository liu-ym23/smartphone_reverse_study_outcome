package com.tom_roush.pdfbox.pdmodel.font;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f16251a;

    public u(byte[] r1) {
        this.f16251a = r1;
    }

    public v a() {
        return new v(Arrays.copyOfRange(this.f16251a, 2, 12));
    }
}
