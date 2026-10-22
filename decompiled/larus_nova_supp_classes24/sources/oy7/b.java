package oy7;

import com.alibaba.fastjson.JSON;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.entity.CreateTagAndAddItemResponseWrap;
import com.larksuite.component.blockit.entity.ItemTags;
import com.larksuite.component.blockit.props.i;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.http.response.ErrorResult;
import com.ss.android.lark.log.Log;
import java.util.Collections;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends z18.b<BaseResponse> {
    public final /* synthetic */ BlockEntity a;
    public final /* synthetic */ IGetDataCallback b;

    @Override // z18.b
    public final void a(ErrorResult r4) {
        Log.w("HashTagService", r4.toString());
        IGetDataCallback r0 = this.b;
        if (r0 == null) goto L6;
        r0.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r4.getHttpStatusCode(), r4.getErrorMessage()));
        return;
    }

    @Override // z18.c
    public final void onSuccess(Object r7) {
        BaseResponse r8 = (BaseResponse) r7;
        if (r8 == null) goto L28;
        String r9 = r8.message();     // Catch: Exception -> L16
        CreateTagAndAddItemResponseWrap r2 = (CreateTagAndAddItemResponseWrap) JSON.parseObject(r9, CreateTagAndAddItemResponseWrap.class);     // Catch: Exception -> L14
        if (r2.code != 0) goto L10;
        i r1 = i.b.a;     // Catch: Exception -> L14
        String r3 = this.a.getBlockID();     // Catch: Exception -> L14
        ItemTags r4 = r2.data.latestItemTags;     // Catch: Exception -> L14
        r1.a(r3, Collections.singletonMap(r4.uniqId, r4));     // Catch: Exception -> L14
        IGetDataCallback r5 = this.b;     // Catch: Exception -> L14
        if (r5 == null) goto L24;
        r5.onSuccess(r2.data);     // Catch: Exception -> L14
    L24:
        return;
    L10:
        Log.w("HashTagService", "result:" + r9);     // Catch: Exception -> L14
        IGetDataCallback r6 = this.b;     // Catch: Exception -> L14
        if (r6 == null) goto L24;
        r6.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r2.code, r2.msg));     // Catch: Exception -> L14
    L14:
        e = e;
    L18:
        Log.w("HashTagService", "createTag result:" + r9, e);
        IGetDataCallback r10 = this.b;
        if (r10 == null) goto L29;
        r10.onError(new com.larksuite.framework.callback.Entity.ErrorResult("Error"));
        return;
    L29:
        return;
    L16:
        e = e;
        r9 = null;
        goto L18
    }

    public b(BlockEntity r1, IGetDataCallback r2) {
        this.a = r1;
        this.b = r2;
    }
}
