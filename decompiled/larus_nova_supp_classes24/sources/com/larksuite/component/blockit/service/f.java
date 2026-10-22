package com.larksuite.component.blockit.service;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.base.container.api.entity.OPContainerBundle;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements BlockitService.g<BlockEntity, BlockitService.ErrorResultInBlock> {
    public final /* synthetic */ OPContainerBundle a;
    public final /* synthetic */ z18.a b;
    public final /* synthetic */ IGetDataCallback c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ BlockitService f;

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void onError(BlockitService.ErrorResultInBlock r11) {
        BlockitService.ErrorResultInBlock r12 = r11;
        if (r12.getBizStatus() != 1) goto L5;
        com.larksuite.component.blockit.b r0 = com.larksuite.component.blockit.b.a.a;
        com.larksuite.component.blockit.b.a(ncb.b.b, this.a, null).setResultTypeFail().addCategoryValue("request_id", this.b.a().get("X-BaseRequest-ID")).addCategoryValue("http_code", Integer.valueOf(r12.getCode())).addCategoryValue("log_id", "" + r12.getLogId()).addCategoryValue("net_status", Integer.valueOf(r12.getStatus())).setErrorMessage(r12.getDebugMsg()).flush();
    L6:
        BlockitService r1 = this.f;
        String r2 = this.d;
        boolean r3 = this.e;
        IGetDataCallback r4 = this.c;
        r1.getClass();
        if (r4 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        return;
    L12:
        if (r3 == true) goto L28;
        Log.w("BlockitService", "handleBlockEntityError:cache fg closed,blockID=" + r2 + ",error=" + r12);
        r4.onError(r12);
        return;
    L28:
        String r5 = BlockitService.b(r2);     // Catch: Exception -> L24
        Log.i("BlockitService", "handleBlockEntityError:cacheKey=" + r5);     // Catch: Exception -> L24
        if (r5 != null) goto L17;
        Log.e("BlockitService", "handleBlockEntityError:userId is empty,blockID=" + r2 + ",error=" + r12);     // Catch: Exception -> L24
        r4.onError(r12);     // Catch: Exception -> L24
    L27:
        return;
    L17:
        com.larksuite.component.blockit.b r6 = com.larksuite.component.blockit.b.a.a;     // Catch: Exception -> L24
        String r7 = ((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).c();     // Catch: Exception -> L24
        BlockitService.BlockEntityCacheModel r8 = (BlockitService.BlockEntityCacheModel) new Gson().fromJson(r7, BlockitService.BlockEntityCacheModel.class);     // Catch: Exception -> L24
        if (r8 != null) goto L20;
    L22:
        Log.e("BlockitService", "handleBlockEntityError:no cache,blockID=" + r2 + ",error=" + r12);     // Catch: Exception -> L24
        r4.onError(r12);     // Catch: Exception -> L24
        goto L27
    L20:
        if (r8.blockEntity == null) goto L22;
        Log.i("BlockitService", "handleBlockEntityError:use cache,blockID=" + r2 + ",cache=" + r7);     // Catch: Exception -> L24
        r4.onSuccess(r8.blockEntity);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.e("BlockitService", "handleBlockEntityError:unhandled error!!!" + e + ",blockID=" + r2);
        r4.onError(r12);
        return;
    L5:
        com.larksuite.component.blockit.b r9 = com.larksuite.component.blockit.b.a.a;
        com.larksuite.component.blockit.b.a(ncb.b.c, this.a, null).setResultTypeFail().addCategoryValue("request_id", this.b.a().get("X-BaseRequest-ID")).addCategoryValue("biz_code", Integer.valueOf(r12.getCode())).addCategoryValue("biz_error_code", Integer.valueOf(r12.getBizErrorCode())).setErrorMessage(r12.getDebugMsg()).flush();
        goto L6
    }

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void a(BlockEntity r6, Map r7) {
        BlockEntity r8 = r6;
        com.larksuite.component.blockit.b r9 = com.larksuite.component.blockit.b.a.a;
        com.larksuite.component.blockit.b.a(ncb.b.e, this.a, r8).setResultTypeSuccess().addCategoryValue("block_infos", new String[]{r8.getBlockTypeID()}).addCategoryValue("request_id", this.b.a().get("X-BaseRequest-ID")).flush();
        IGetDataCallback r10 = this.c;
        if ((r10 instanceof IGetDataCallbackWrapper) == false) goto L5;
        ((IGetDataCallbackWrapper) r10).onSuccess(r8, new IGetDataCallbackWrapper.a(false, 0));
    L6:
        BlockitService.a(this.f, this.d, this.e, r8);
        return;
    L5:
        r10.onSuccess(r8);
        goto L6
    }

    public f(z18.a r2, IGetDataCallback r3, String r4) {
        this.f = BlockitService.f.a;
        this.a = null;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = false;
    }
}
