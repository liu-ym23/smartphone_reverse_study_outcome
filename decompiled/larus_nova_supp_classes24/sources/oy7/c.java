package oy7;

import com.alibaba.fastjson.JSON;
import com.larksuite.component.blockit.entity.SearchTagsResponseWrap;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.http.response.ErrorResult;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends z18.b<BaseResponse> {
    public final /* synthetic */ IGetDataCallback a;

    public c(IGetDataCallback r1) {
        this.a = r1;
    }

    @Override // z18.b
    public final void a(ErrorResult r4) {
        Log.w("HashTagService", r4.toString());
        IGetDataCallback r0 = this.a;
        if (r0 == null) goto L6;
        r0.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r4.getHttpStatusCode(), r4.getErrorMessage()));
        return;
    }

    @Override // z18.c
    public final void onSuccess(Object r6) {
        BaseResponse r7 = (BaseResponse) r6;
        if (r7 == null) goto L28;
        String r8 = r7.message();     // Catch: Exception -> L16
        SearchTagsResponseWrap r2 = (SearchTagsResponseWrap) JSON.parseObject(r8, SearchTagsResponseWrap.class);     // Catch: Exception -> L14
        if (r2.code != 0) goto L10;
        IGetDataCallback r1 = this.a;     // Catch: Exception -> L14
        if (r1 == null) goto L24;
        r1.onSuccess(r2.data);     // Catch: Exception -> L14
    L24:
        return;
    L10:
        Log.w("HashTagService", "result:" + r8);     // Catch: Exception -> L14
        IGetDataCallback r3 = this.a;     // Catch: Exception -> L14
        if (r3 == null) goto L24;
        r3.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r2.code, r2.msg));     // Catch: Exception -> L14
    L14:
        e = e;
    L18:
        Log.w("HashTagService", "searchTags result:" + r8, e);
        IGetDataCallback r9 = this.a;
        if (r9 == null) goto L29;
        r9.onError(new com.larksuite.framework.callback.Entity.ErrorResult("Error"));
        return;
    L29:
        return;
    L16:
        e = e;
        r8 = null;
        goto L18
    }
}
