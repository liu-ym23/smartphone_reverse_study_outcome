package com.larksuite.component.blockit.service;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.request.HttpMethod;
import com.larksuite.framework.http.request.RequestBody;
import com.larksuite.framework.http.response.BaseResponse;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@ClaymoreImpl(singleton = false, value = h.class)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J&\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/blockit/service/BlockitApiServiceImpl;", "Lcom/larksuite/component/blockit/service/IBlockitApiService;", "<init>", "()V", "getBlockByID", "", "blockId", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/blockit/entity/BlockEntity;", "createBlockEntity", "blockEntity", "extra", "Lcom/google/gson/JsonObject;", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class BlockitApiServiceImpl implements h {
    public BlockitApiServiceImpl() {
    }

    public void getBlockByID(String r13, IGetDataCallback<BlockEntity> r14) {
        Intrinsics.checkNotNullParameter(r13, "blockId");
        Intrinsics.checkNotNullParameter(r14, "callback");
        BlockitService r0 = BlockitService.f.a;
        Log.i("BlockitService", "getBlock: " + r13);
        if (r14 != null) goto L5;
        Log.i("BlockitService", "callback: null");
        return;
    L5:
        com.larksuite.component.blockit.b r1 = com.larksuite.component.blockit.b.a.a;
        BlockitService.BlockEntityCacheModel r3 = null;
        boolean r6 = false;
        com.larksuite.component.blockit.b.a(ncb.b.d, null, null).addCategoryValue("blocks", new String[]{r13}).flush();
        BlockitService.BlockCacheMGetBlockEntityV2ConfigModel r2 = (BlockitService.BlockCacheMGetBlockEntityV2ConfigModel) SettingManager.getInstance().get(BlockitService.BlockCacheMGetBlockEntityV2ConfigModel.class);
        z18.a<BaseResponse> r5 = BlockitService.d(r13);
        Log.i("BlockitService", "getBlockByID config:BlockCacheMGetBlockEntityV2ConfigModel = {enable=" + r2.enable + "}");
        if (r2.enable == true) goto L32;
        r0.c(r5, r13, new f(r5, r14, r13));
        return;
    L32:
        String r10 = BlockitService.b(r13);     // Catch: Exception -> L11
        if (r10 != null) goto L13;
        Log.w("BlockitService", "getBlockEntityFromCache:no blockEntity cache because userId is empty,blockID=" + r13);     // Catch: Exception -> L11
    L31:
    L19:
        if (r3 != null) goto L21;
    L23:
        if (r6 == true) goto L25;
    L28:
        r0.c(r5, r13, new e(r5, r6, r14, r13));
        return;
    L25:
        if ((r14 instanceof IGetDataCallbackWrapper) == false) goto L27;
        ((IGetDataCallbackWrapper) r14).onSuccess(r3.blockEntity, new IGetDataCallbackWrapper.a(true, r3.timeStamp));
        goto L28
    L27:
        r14.onSuccess(r3.blockEntity);
        goto L28
    L21:
        if (r3.blockEntity == null) goto L23;
        r6 = true;
        goto L23
    L13:
        String r9 = ((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).c();     // Catch: Exception -> L11
        Log.i("BlockitService", "getBlockEntityFromCache:cache key: ".concat(r10));     // Catch: Exception -> L11
        BlockitService.BlockEntityCacheModel r8 = (BlockitService.BlockEntityCacheModel) new Gson().fromJson(r9, BlockitService.BlockEntityCacheModel.class);     // Catch: Exception -> L11
        if (r8 == null) goto L16;
        Log.i("BlockitService", "getBlockEntityFromCache:use cache,blockID=" + r13 + ",cacheLength=" + r9.length());     // Catch: Exception -> L11
        r3 = r8;
        goto L31
    L16:
        Log.w("BlockitService", "getBlockEntityFromCache:no blockEntity cache,blockID=" + r13 + ",cache=" + r9);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.e("BlockitService", "getBlockEntityFromCache:unhandled error!!!" + e + ",blockID=" + r13);
        goto L19
    }

    public void createBlockEntity(BlockEntity r9, JsonObject r10, IGetDataCallback<BlockEntity> r11) {
        Intrinsics.checkNotNullParameter(r9, "blockEntity");
        Intrinsics.checkNotNullParameter(r10, "extra");
        Intrinsics.checkNotNullParameter(r11, "callback");
        BlockitService r1 = BlockitService.f.a;
        String r0 = "https://" + BlockitService.f() + "/open-apis/block/server/api/CreateBlockEntity";
        JsonObject r2 = new JsonObject();
        r2.addProperty("blockTypeID", r9.getBlockTypeID());
        r2.addProperty("sourceMeta", r9.getSourceMeta());
        r2.addProperty("sourceData", r9.getSourceData());
        JsonObject r3 = new JsonObject();
        r3.add("Entity", r2);
        if (r10 == null) goto L8;
        Iterator r4 = r10.keySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        String r5 = (String) r4.next();
        r3.add(r5, r10.get(r5));
    L8:
        z18.a r12 = new z18.a(HttpMethod.POST, r0);
        r12.e = RequestBody.create("application/json", r3.toString());
        r12.b = ry7.a.a();
        c r7 = new c(r9, r11);
        if (((BlockitService.BlockRequestTTnetEnableConfigModel) SettingManager.getInstance().get(BlockitService.BlockRequestTTnetEnableConfigModel.class)).createBlockEntity == false) goto L11;
        r1.e(r12.b(), SendHttpRequest.Method.POST, r12.a().headersMap, r12.a().get("X-BaseRequest-ID"), r12.e.getContent(), r7);
        return;
    L11:
        r12.c(new d(r7, r11));
    }
}
