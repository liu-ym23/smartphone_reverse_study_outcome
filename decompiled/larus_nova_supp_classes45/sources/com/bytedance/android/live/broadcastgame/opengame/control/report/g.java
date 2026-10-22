package com.bytedance.android.live.broadcastgame.opengame.control.report;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.config.bd1;
import com.bytedance.android.livesdk.config.he0;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public final int a;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/broadcastgame/opengame/control/report/g$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/base/model/user/UploadResult;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Response<UploadResult>> {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ g a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;

        public b(g r1, String r2, JSONObject r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r13) {
            String r14 = (String) r13;
            Intrinsics.checkNotNullParameter(r14, LiveSlardarConstants.EXTRA_KEY_URL);
            g r1 = this.a;
            PolarisFileWrapper r2 = new PolarisFileWrapper(this.b);
            JSONObject r3 = this.c;
            if (r1.a > 0) goto L5;
        L13:
            Intrinsics.checkNotNullParameter(r14, LiveSlardarConstants.EXTRA_KEY_URL);
            Intrinsics.checkNotNullParameter(r2, "file");
            MultipartTypedOutput r0 = new MultipartTypedOutput();
            r0.addPart("data", new TypedFile("multipart/form-data", r2));
            Response r15 = g.a(r14, r0, r3);
        L14:
            UploadResult r4 = (UploadResult) ((BaseResponse) r15).data;
            if (r4 == null) goto L17;
            r4.setPath(r2.getAbsolutePath());
        L17:
            return r15;
        L5:
            if ((r2.length() / ((long) RomUtils.SZ)) <= r1.a) goto L13;
            ByteArrayOutputStream r7 = new ByteArrayOutputStream();
            Bitmap r8 = BitmapFactory.decodeFile(r2.getAbsolutePath());
            int r11 = 80;
            r8.compress(Bitmap.CompressFormat.JPEG, 80, r7);
        L8:
            if (r11 <= 10) goto L12;
            if ((r7.size() / RomUtils.SZ) <= r1.a) goto L12;
            r7.reset();
            r11 = r11 - 10;
            r8.compress(Bitmap.CompressFormat.JPEG, r11, r7);
        L12:
            byte[] r5 = r7.toByteArray();
            Intrinsics.checkNotNullParameter(r14, LiveSlardarConstants.EXTRA_KEY_URL);
            Intrinsics.checkNotNullParameter(r5, "byteArray");
            MultipartTypedOutput r6 = new MultipartTypedOutput();
            r6.addPart("data", new TypedByteArray("multipart/form-data", r5, new String[0]));
            r15 = g.a(r14, r6, r3);
            goto L14
        }
    }

    public g() {
        this.a = ((bd1) he0.a.getValue()).permitUploadSizeForAndroid * RomUtils.SZ;
    }

    public final Single<Response<UploadResult>> b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "filePath");
        JSONObject r0 = new JSONObject();
        r0.put("scene", "webcast_report");
        r0.put("encrypt", 0);
        return Single.just("https://webcast.amemv.com/webcast/resource/upload/?scene=webcast_report").subscribeOn(Schedulers.io()).map(new b(this, r4, r0)).observeOn(AndroidSchedulers.mainThread());
    }

    public static Response a(String r12, MultipartTypedOutput r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r12, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r13, "multipartTypedOutput");
        IHostNetwork r3 = k.n(INetworkService.class);
        Uri.Builder r15 = UriProtector.parse(r12).buildUpon();
        if (r14 == null) goto L8;
        Iterator<String> r2 = r14.keys();
    L6:
        if (r2.hasNext() == false) goto L8;
        String r4 = r2.next();
        r15.appendQueryParameter(r4, r14.opt(r4).toString());
    L8:
        ByteArrayOutputStream r16 = new ByteArrayOutputStream();
        r13.writeTo(r16);     // Catch: IOException -> L11
    L13:
        String r5 = r15.build().toString();
        ALogger.d("upload", r5);
        String r17 = new String(((HttpResponse) r3.uploadFile(-1, r5, new ArrayList(1), r13.mimeType(), r16.toByteArray(), r13.length(), r13.md5Stub()).execute()).getBody(), Charsets.UTF_8);
        Response r18 = (Response) GsonProtectorUtils.fromJson(GsonHelper.get(), r17, new a().getType());
        if (r18 == null) goto L16;
    L21:
        e = move-exception;
        Logger.e("upload", "uploadFile", e);
    L23:
        return r18;
    L18:
        if (((BaseResponse) r18).statusCode == 0) goto L23;
        JSONObject r19 = new JSONObject(r17);     // Catch: JSONException -> L21
        ((BaseResponse) r18).error = (RequestError) GsonProtectorUtils.fromJson(GsonHelper.get(), JSONObjectProtectorUtils.getJSONObject(r19, "data").toString(), RequestError.class);     // Catch: JSONException -> L21
        goto L23
    L16:
        return new Response();
    L11:
        e = move-exception;
        Logger.e("upload", "uploadFile", e);
        goto L13
    }
}
