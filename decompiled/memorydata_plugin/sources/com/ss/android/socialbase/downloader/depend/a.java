package com.ss.android.socialbase.downloader.depend;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15365a;

    public a() {
        this.f15365a = false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.w
    public void a(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L10;
        this.f15365a = true;
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.w
    public boolean a() {
        return this.f15365a;
    }
}
