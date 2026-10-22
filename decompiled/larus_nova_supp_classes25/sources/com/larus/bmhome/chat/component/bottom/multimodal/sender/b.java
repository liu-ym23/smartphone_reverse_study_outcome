package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1 b;

    public /* synthetic */ b(String r1, CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1 r1 = this.b;
        NestedFileCacheManagerService.b.g(r0).observeForever(r1);
    }
}
