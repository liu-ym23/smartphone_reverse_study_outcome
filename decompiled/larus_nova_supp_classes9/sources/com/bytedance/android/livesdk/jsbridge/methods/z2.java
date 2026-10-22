package com.bytedance.android.livesdk.jsbridge.methods;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.android.live.browser.jsbridge.base.OpenMultiSelectPhotoLibraryResultModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z2<TTaskResult, TContinuationResult> implements Continuation {
    public final /* synthetic */ w2 a;

    public z2(w2 r1) {
        this.a = r1;
    }

    public final Object then(Task r4) {
        Iterator r0 = ((List) r4.getResult()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((OpenMultiSelectPhotoLibraryResultModel.b) r0.next()).a();
        goto L4
    L6:
        w2 r1 = this.a;
        OpenMultiSelectPhotoLibraryResultModel r2 = new OpenMultiSelectPhotoLibraryResultModel();
        OpenMultiSelectPhotoLibraryResultModel.a r3 = new OpenMultiSelectPhotoLibraryResultModel.a();
        r3.a((List) r4.getResult());
        Unit r5 = Unit.INSTANCE;
        r2.a(r3);
        r1.finishWithResult(r2);
        return Unit.INSTANCE;
    }
}
