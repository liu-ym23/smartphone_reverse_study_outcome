package com.bytedance.geckox;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends BaseGeckoConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f4755b;

    public j(i r5) {
        super(r5);
        List r10 = r5.f4752a;
        this.f4754a = r10;
        File r11 = r5.f4753b;
        if (r11 != null) goto L5;
        this.f4755b = new File(getContext().getFilesDir(), "gecko_offline_res_x");
    L6:
        if (r10 == null) goto L11;
        if (r10.isEmpty() == true) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("accessKey is empty");
    L5:
        this.f4755b = r11;
        goto L6
    }
}
