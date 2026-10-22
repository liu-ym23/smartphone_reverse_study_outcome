package com.larksuite.component.blockit.service;

import com.google.gson.Gson;
import com.larksuite.component.blockit.entity.MGetBlockResponseWrap;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements BlockitService.g<String, ErrorResult> {
    public final /* synthetic */ String a;
    public final /* synthetic */ IGetDataCallback b;

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void onError(ErrorResult r3) {
        Log.e("BlockitService", "get block entity error: " + r3.getMessage());
        this.b.onSuccess(null);
    }

    public b(String r1, IGetDataCallback r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void a(String r5, Map r6) {
        MGetBlockResponseWrap r7 = (MGetBlockResponseWrap) new Gson().fromJson(r5, MGetBlockResponseWrap.class);     // Catch: Exception -> L8
        if (r7.code != 0) goto L6;
        this.b.onSuccess(r7.data.blocks.get(this.a));     // Catch: Exception -> L8
    L11:
        return;
    L6:
        Log.e("BlockitService", "get block entity error: responseWrap.code is " + r7.code);     // Catch: Exception -> L8
        this.b.onSuccess(null);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.e("BlockitService", "parse body error:" + e.getMessage());
        this.b.onSuccess(null);
    }
}
