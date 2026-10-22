package com.larus.doc.impl;

import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x0 implements vm9.a {
    public final /* synthetic */ DocFragment a;

    public final void hidePhotoPickerFragment() {
        IDocSdkBaseService r0 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r0 == null) goto L6;
        r0.hidePhotoPickerFragment();
        return;
    }

    public final void showPhotoPickerFragment() {
        IDocSdkBaseService r0 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r0 == null) goto L6;
        r0.showPhotoPickerFragment();
        return;
    }

    public x0(DocFragment r1) {
        this.a = r1;
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        IDocSdkBaseService r0 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r0 == null) goto L6;
        r0.reportToolbarItemClicked(r3, this.a.Y90());
        return;
    }

    public final void reportToolbarItemShow(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        IDocSdkBaseService r0 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r0 == null) goto L6;
        r0.reportToolbarItemShow(r3, this.a.Y90());
        return;
    }
}
