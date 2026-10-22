package com.larksuite.component.blockit.service;

import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.base.container.api.entity.OPContainerBundle;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements BlockitService.g<BlockEntity, BlockitService.ErrorResultInBlock> {
    public final /* synthetic */ OPContainerBundle a;
    public final /* synthetic */ z18.a b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ IGetDataCallback d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ BlockitService g;

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void onError(BlockitService.ErrorResultInBlock r6) {
        BlockitService.ErrorResultInBlock r7 = r6;
        Log.e("BlockitService", "handleBlockEntityError:, blockID=" + this.e + ",error=" + r7);
        if (this.c == false) goto L5;
        return;
    L5:
        if (r7.getBizStatus() != 1) goto L7;
        com.larksuite.component.blockit.b r0 = com.larksuite.component.blockit.b.a.a;
        com.larksuite.component.blockit.b.a(ncb.b.b, this.a, null).setResultTypeFail().addCategoryValue("request_id", this.b.a().get("X-BaseRequest-ID")).addCategoryValue("http_code", Integer.valueOf(r7.getCode())).addCategoryValue("log_id", "" + r7.getLogId()).addCategoryValue("net_status", Integer.valueOf(r7.getStatus())).setErrorMessage(r7.getDebugMsg()).flush();
    L8:
        this.d.onError(r7);
        return;
    L7:
        com.larksuite.component.blockit.b r1 = com.larksuite.component.blockit.b.a.a;
        com.larksuite.component.blockit.b.a(ncb.b.c, this.a, null).setResultTypeFail().addCategoryValue("request_id", this.b.a().get("X-BaseRequest-ID")).addCategoryValue("biz_code", Integer.valueOf(r7.getCode())).addCategoryValue("biz_error_code", Integer.valueOf(r7.getBizErrorCode())).setErrorMessage(r7.getDebugMsg()).flush();
        goto L8
    }

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void a(BlockEntity r5, Map r6) {
        BlockEntity r7 = r5;
        if (r6 != null) goto L5;
    L7:
        String r8 = "";
    L8:
        com.larksuite.component.blockit.b r0 = com.larksuite.component.blockit.b.a.a;
        com.larksuite.component.blockit.b.a(ncb.b.e, this.a, r7).setResultTypeSuccess().addCategoryValue("request_id", this.b.a().get("X-BaseRequest-ID")).addCategoryValue("block_infos", new String[]{r7.getBlockTypeID()}).addCategoryValue("log_id", r8).flush();
        if (this.c == true) goto L14;
        IGetDataCallback r9 = this.d;
        if ((r9 instanceof IGetDataCallbackWrapper) == false) goto L13;
        ((IGetDataCallbackWrapper) r9).onSuccess(r7, new IGetDataCallbackWrapper.a(false, 0));
        goto L14
    L13:
        r9.onSuccess(r7);
    L14:
        BlockitService.a(this.g, this.e, this.f, r7);
        return;
    L5:
        if (r6.containsKey("x-tt-logid") == false) goto L7;
        r8 = (String) r6.get("x-tt-logid");
        goto L8
    }

    public e(z18.a r2, boolean r3, IGetDataCallback r4, String r5) {
        this.g = BlockitService.f.a;
        this.a = null;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = false;
    }
}
