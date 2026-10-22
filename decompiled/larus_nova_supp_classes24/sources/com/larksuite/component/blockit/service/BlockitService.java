package com.larksuite.component.blockit.service;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.entity.BlockEntityResp;
import com.larksuite.component.blockit.entity.BlockitEnv;
import com.larksuite.component.blockit.entity.MGetBlockRequest;
import com.larksuite.component.blockit.entity.MGetBlockResponseWrap;
import com.larksuite.component.blockit.entity.MGetOpenMessageResponseWrap;
import com.larksuite.component.blockit.entity.OpenMessageResp;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.request.HttpMethod;
import com.larksuite.framework.http.request.RequestBody;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.utils.s;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.ApiUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class BlockitService {

    @AppConfig(key = "block_cache_MGetBlockEntityV2")
    public static class BlockCacheMGetBlockEntityV2ConfigModel {

        @SerializedName("enable")
        public boolean enable;

        public BlockCacheMGetBlockEntityV2ConfigModel() {
        }

        public final String toString() {
            return "BlockCacheMGetBlockEntityV2ConfigModel{enable=" + this.enable + "}";
        }
    }

    public static class BlockEntityCacheModel implements Serializable {
        public BlockEntity blockEntity;
        public long timeStamp;

        public BlockEntityCacheModel() {
        }

        public BlockEntityCacheModel(BlockEntity r1, long r2) {
            this.blockEntity = r1;
            this.timeStamp = r2;
        }
    }

    @AppConfig(key = "block_request_ttnet_enable")
    public static class BlockRequestTTnetEnableConfigModel {

        @SerializedName("createBlockEntity")
        boolean createBlockEntity;

        @SerializedName("generateBlockID")
        boolean generateBlockID;

        @SerializedName("getBlockTemplateList")
        boolean getBlockTemplateList;

        @SerializedName("mGetOpenMessage")
        boolean mGetOpenMessage;

        public BlockRequestTTnetEnableConfigModel() {
        }

        public final String toString() {
            return "BlockRequestTTnetEnableConfigModel{generateBlockID=" + this.generateBlockID + ", createBlockEntity" + this.createBlockEntity + ", getBlockTemplateList" + this.getBlockTemplateList + ", mGetOpenMessage" + this.mGetOpenMessage + "}";
        }
    }

    public static class ErrorResultInBlock extends ErrorResult {
        static final int BIZ_ERROR_INVALIDATE_CODE = 1;
        static final int BIZ_ERROR_UNPACK_FAILURE = 2;
        private int bizErrorCode;
        private int bizStatus;

        public int getBizErrorCode() {
            return this.bizErrorCode;
        }

        public int getBizStatus() {
            return this.bizStatus;
        }

        public ErrorResultInBlock(ErrorResult.a r2) {
            super(0);
            super.copyFrom(r2.a());
        }

        public void setBizErrorCode(int r1) {
            this.bizErrorCode = r1;
        }

        public void setBizStatus(int r1) {
            this.bizStatus = r1;
        }
    }

    public class a implements g<String, ErrorResult> {
        public final /* synthetic */ IGetDataCallback a;
        public final /* synthetic */ String b;

        @Override // com.larksuite.component.blockit.service.BlockitService.g
        public final void onError(ErrorResult r3) {
            Log.e("BlockitService", "getOpenMessageVersion error: " + r3.toString());
            this.a.onSuccess(null);
        }

        public a(IGetDataCallback r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.larksuite.component.blockit.service.BlockitService.g
        public final void a(String r4, Map r5) {
            MGetOpenMessageResponseWrap r6 = (MGetOpenMessageResponseWrap) JSON.parseObject(r4, MGetOpenMessageResponseWrap.class);     // Catch: JSONException -> L5
        L7:
            if (r6 != null) goto L9;
        L14:
            this.a.onSuccess(null);
            return;
        L9:
            if (r6.code != 0) goto L14;
            Map<String, OpenMessageResp> r7 = r6.data.messages;
            if (r7 == null) goto L13;
            this.a.onSuccess(r7.get(this.b));
            return;
        L13:
            Log.e("BlockitService", "getOpenMessageVersion onSuccess，but messages is null");
            this.a.onSuccess(null);
            return;
        L5:
            e = move-exception;
            Log.e("BlockitService", "getOpenMessageVersion exception:" + e.getMessage());
            r6 = null;
            goto L7
        }
    }

    public class b extends z18.b<BaseResponse> {
        public final /* synthetic */ g a;
        public final /* synthetic */ IGetDataCallback b;

        @Override // z18.b
        public final void a(com.larksuite.framework.http.response.ErrorResult r4) {
            this.a.onError(new ErrorResult(r4.getErrorType(), r4.getErrorMessage()));
        }

        @Override // z18.c
        public final void onSuccess(Object r3) {
            BaseResponse r4 = (BaseResponse) r3;
            if (r4 == null) goto L10;
            String r0 = r4.message();     // Catch: Exception -> L6
            this.a.a(r0, r4.headers());     // Catch: Exception -> L6
            return;
        L6:
            this.b.onSuccess(null);
            return;
        }

        public b(a r1, IGetDataCallback r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public class c implements SdkSender.IParser<SendHttpResponse> {
        public final /* synthetic */ String a;

        public c(String r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r6) throws IOException {
            SendHttpResponse r7 = (SendHttpResponse) SendHttpResponse.ADAPTER.decode(r6);
            if (r7 == null) goto L9;
            Map r0 = r7.headers;
            if (r0 == null) goto L9;
            if (r0.containsKey("x-tt-logid") == false) goto L9;
            String r1 = (String) r7.headers.get("x-tt-logid");
        L10:
            AppBrandLogger.i("BlockitService", new Object[]{"request path: " + UriProtector.parse(this.a).getPath() + " log_id:" + r1});
            return r7;
        L9:
            r1 = "";
            goto L10
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BlockitEnv.values().length];
            a = r0;
            r0[BlockitEnv.BOE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[BlockitEnv.STAGING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[BlockitEnv.ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class e implements g<String, ErrorResult> {
        public final /* synthetic */ String a;
        public final /* synthetic */ g b;
        public final /* synthetic */ BlockitService c;

        @Override // com.larksuite.component.blockit.service.BlockitService.g
        public final void onError(ErrorResult r3) {
            ErrorResult r4 = r3;
            ErrorResult.a r0 = new ErrorResult.a();
            r0.a = r4.getStatus();
            r0.g = r4.getLogId();
            r0.b = r4.getCode();
            r0.c = r4.getDebugMsg();
            ErrorResultInBlock r5 = new ErrorResultInBlock(r0);
            r5.setBizStatus(1);
            this.b.onError(r5);
        }

        @Override // com.larksuite.component.blockit.service.BlockitService.g
        public final void a(String r14, Map r15) {
            String r16 = r14;
            BlockitService r0 = this.c;
            String r1 = this.a;
            g r2 = this.b;
            r0.getClass();
            ErrorResult.a r7 = new ErrorResult.a();
            if (r15 == null) goto L26;
            if (r15.containsKey("log_id") == false) goto L26;
            r7.g = (String) r15.get("x-tt-logid");
        L26:
            MGetBlockResponseWrap r9 = (MGetBlockResponseWrap) new Gson().fromJson(r16, MGetBlockResponseWrap.class);     // Catch: Exception -> L22
            if (r9.code != 0) goto L20;
            BlockEntityResp r3 = r9.data.blocks.get(r1);     // Catch: Exception -> L22
            if (r3 != null) goto L14;
            Log.e("BlockitService", "resp is null, body: " + r16);     // Catch: Exception -> L22
            r7.b = -1;     // Catch: Exception -> L22
            r7.c = "no entity this block ";     // Catch: Exception -> L22
            ErrorResultInBlock r17 = new ErrorResultInBlock(r7);     // Catch: Exception -> L22
            r17.setBizErrorCode(2);     // Catch: Exception -> L22
            r17.setBizStatus(2);     // Catch: Exception -> L22
            r2.onError(r17);     // Catch: Exception -> L22
        L25:
            return;
        L14:
            if (r3.status == 0) goto L16;
            Log.e("BlockitService", "resp.status is " + r3.status);     // Catch: Exception -> L22
            r7.b = (int) r3.status;     // Catch: Exception -> L22
            r7.c = r3.errMessage;     // Catch: Exception -> L22
            ErrorResultInBlock r19 = new ErrorResultInBlock(r7);     // Catch: Exception -> L22
            r19.setBizErrorCode(2);     // Catch: Exception -> L22
            r19.setBizStatus(2);     // Catch: Exception -> L22
            r2.onError(r19);     // Catch: Exception -> L22
            goto L25
        L16:
            BlockEntity r4 = r3.entity;     // Catch: Exception -> L22
            if (r4 == null) goto L19;
            r2.a(r4, r15);     // Catch: Exception -> L22
            goto L25
        L19:
            Log.e("BlockitService", "blockEntity is null, body: " + r16);     // Catch: Exception -> L22
            r7.b = r9.code;     // Catch: Exception -> L22
            r7.c = r9.msg;     // Catch: Exception -> L22
            ErrorResultInBlock r110 = new ErrorResultInBlock(r7);     // Catch: Exception -> L22
            r110.setBizErrorCode(2);     // Catch: Exception -> L22
            r110.setBizStatus(2);     // Catch: Exception -> L22
            r2.onError(r110);     // Catch: Exception -> L22
            goto L25
        L20:
            Log.e("BlockitService", "responseWrap.code is " + r9.code);     // Catch: Exception -> L22
            r7.b = r9.code;     // Catch: Exception -> L22
            r7.c = r9.msg;     // Catch: Exception -> L22
            ErrorResultInBlock r111 = new ErrorResultInBlock(r7);     // Catch: Exception -> L22
            r111.setBizErrorCode(1);     // Catch: Exception -> L22
            r111.setBizStatus(2);     // Catch: Exception -> L22
            r2.onError(r111);     // Catch: Exception -> L22
        L22:
            e = move-exception;
            Log.e("BlockitService", "parse body error:" + e.getMessage());
            r7.b = 100;
            r7.c = e.toString();
            ErrorResultInBlock r112 = new ErrorResultInBlock(r7);
            r112.setBizErrorCode(2);
            r112.setBizStatus(2);
            r2.onError(r112);
        }

        public e(BlockitService r1, String r2, g r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class f {
        public static final BlockitService a = null;

        static {
            a = new BlockitService();
        }
    }

    public interface g<DataT, ErrorT> {
        void a(DataT r1, Map<String, String> r2);

        void onError(ErrorT r1);
    }

    public BlockitService() {
    }

    public static String f() {
        String r2 = jcb.b.c().a("open");     // Catch: Exception -> L5
    L8:
        if (TextUtils.isEmpty(r2) == false) goto L17;
        int r3 = d.a[((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).getEnv().ordinal()];
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L16;
        return String.format("open.%s.cn", new Object[]{"feishu"});
    L16:
        return String.format("open.%s.cn", new Object[]{"feishu-boe"});
    L17:
        return r2;
    L5:
        e = move-exception;
        AppBrandLogger.e("BlockitService", new Object[]{e});
        r2 = null;
        goto L8
    }

    public static String b(String r2) {
        com.larksuite.component.blockit.b r0 = com.larksuite.component.blockit.b.a.a;
        r0.b();
        String r1 = s.b(r0.a.getUserId());
        if (TextUtils.isEmpty(r1) == false) goto L7;
        Log.i("BlockitService", "getBlockCacheKey fail,userId is empty");
        return null;
    L7:
        return r1 + "_BlocKEntity_Timestamp_" + s.b(r2);
    }

    public static z18.a d(String r3) {
        MGetBlockRequest r0 = new MGetBlockRequest();
        r0.blockIDs = Collections.singletonList(r3);
        r0.locale = ry7.a.b();
        String r4 = JSON.toJSONString(r0);
        z18.a r1 = new z18.a(HttpMethod.POST, "https://" + f() + "/open-apis/block/server/api/MGetBlockEntityV2");
        r1.e = RequestBody.create("application/json", r4);
        r1.b = ry7.a.a();
        return r1;
    }

    public final void g(String r11, IGetDataCallback<OpenMessageResp> r12) {
        MGetBlockRequest r0 = new MGetBlockRequest();
        r0.blockIDs = Collections.singletonList(r11);
        r0.locale = ry7.a.b();
        String r1 = JSON.toJSONString(r0);
        z18.a r2 = new z18.a(HttpMethod.POST, "https://" + f() + "/open-apis/block/server/api/MGetOpenMessage");
        r2.e = RequestBody.create("application/json", r1);
        r2.b = ry7.a.a();
        a r9 = new a(r12, r11);
        if (((BlockRequestTTnetEnableConfigModel) SettingManager.getInstance().get(BlockRequestTTnetEnableConfigModel.class)).mGetOpenMessage == false) goto L5;
        e(r2.b(), SendHttpRequest.Method.POST, r2.a().headersMap, r2.a().get("X-BaseRequest-ID"), r2.e.getContent(), r9);
        return;
    L5:
        r2.c(new b(r9, r12));
    }

    public final void c(z18.a<BaseResponse> r8, String r9, g<BlockEntity, ErrorResultInBlock> r10) {
        e(r8.b(), SendHttpRequest.Method.POST, r8.a().headersMap, r8.a().get("X-BaseRequest-ID"), r8.e.getContent(), new e(this, r9, r10));
    }

    public static void a(BlockitService r2, String r3, boolean r4, BlockEntity r5) {
        r2.getClass();
        if (r5 == null) goto L11;
        if (r4 == false) goto L13;
        String r6 = GsonProtectorUtils.toJson(new Gson(), new BlockEntityCacheModel(r5, System.currentTimeMillis()));
        String r7 = b(r3);
        Log.i("BlockitService", "cacheBlockEntity:cacheKey=" + r7);
        if (r7 != null) goto L9;
        Log.w("BlockitService", "cacheBlockEntity fail: userId is empty,blockID=" + r3);
        return;
    L9:
        com.larksuite.component.blockit.b r8 = com.larksuite.component.blockit.b.a.a;
        ((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).a();
        Log.i("BlockitService", "cacheBlockEntity:blockID=" + r3 + ",cacheLength=" + r6.length());
        return;
    L13:
        return;
    }

    public final void e(String r2, SendHttpRequest.Method r3, Map<String, String> r4, String r5, String r6, final g<String, ErrorResult> r7) {
        SendHttpRequest.Builder r8 = new SendHttpRequest.Builder().url(r2).method(r3).headers(r4).request_id(r5).json_body(r6);
        SdkSender.asynSendRequestNonWrap(Command.SEND_HTTP, r8, new AnonymousClass13(this, r7), new c(r2));
    }
}
