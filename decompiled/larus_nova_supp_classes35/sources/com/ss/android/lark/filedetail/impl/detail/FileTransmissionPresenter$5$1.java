package com.ss.android.lark.filedetail.impl.detail;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class FileTransmissionPresenter$5$1 implements IGetDataCallback<List<wbb.d.c>> {
    final /* synthetic */ s this$1;

    public FileTransmissionPresenter$5$1(s r1) {
        this.this$1 = r1;
    }

    public void onError(ErrorResult r2) {
        Log.i("FileTransmissionPresenter", "download file: IMFileRiskTag list is null or empty, allows download file.");
        throw null;
    }

    public void onSuccess(List<wbb.d.c> r3) {
        Log.i("FileTransmissionPresenter", "download file: getIMFileRiskTagByKeys success.");
        if (r3 != null) goto L5;
        return;
    L5:
        if (CollectionUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        if (r3.size() > 0) goto L9;
        return;
    L9:
        if (((wbb.d.c) ListProtector.get(r3, 0)).a == false) goto L12;
        Log.i("FileTransmissionPresenter", "restrictOperation is true, ready to check if user can download risk file.");
        wbb.d r4 = vbb.a.a();
        com.ss.android.lark.download.service.impl.j r5 = (com.ss.android.lark.download.service.impl.j) r4;
        r5.c(new AnonymousClass1(this));
        return;
    L12:
        Log.i("FileTransmissionPresenter", "restrictOperation is false, allows download file.");
        throw null;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((List) r1);
    }
}
