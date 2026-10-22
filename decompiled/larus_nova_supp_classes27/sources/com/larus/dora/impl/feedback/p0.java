package com.larus.dora.impl.feedback;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.upload.ResourceUploadTokenProvider;
import com.larus.bmhome.upload.sdk.ResourceUploadEngine;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b4;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.service.z2;
import com.larus.uploader.api.IUploaderService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import com.ss.bduploader.BDMediaDataReader;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p0 implements b4 {
    public final String a;
    public BDImageXUploader b;
    public b4.a c;

    public static final class a {
    }

    public final class b implements BDImageXUploaderListener {
        public final mr9.j a;
        public final /* synthetic */ p0 b;

        public b(p0 r2, mr9.j r3) {
            Intrinsics.checkNotNullParameter(r3, "param");
            this.b = r2;
            this.a = r3;
        }

        public final int imageXUploadCheckNetState(int r1, int r2) {
            return NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) ? 1 : 0;
        }

        public final void onLog(int r5, int r6, String r7) {
            FLogger.a.i(this.b.a, "[onLog] what:" + r5 + ", code:" + r6 + ", info" + r7);
        }

        public final void onNotify(int r20, long r21, BDImageXInfo r23) {
            FLogger r5 = FLogger.a;
            r5.i(this.b.a, "[onNotify] what:" + r20 + ", parameter:" + r21);
            int r8 = 0;
            if (r21 == 0) goto L8;
            b4.a r6 = this.b.c;
            if (r6 == null) goto L8;
            r6.b(new mr9.k(Long.valueOf(r21), false));
        L8:
            if (r20 != 2) goto L10;
        L37:
            ResourceUploadTokenProvider r2 = ResourceUploadTokenProvider.a;
            String r7 = null;
            if (r23 == null) goto L40;
            Long r9 = Long.valueOf(r23.mErrorCode);
        L41:
            r2.getClass();
            if (ResourceUploadTokenProvider.c(r9) == false) goto L44;
            ResourceUploadTokenProvider.b(this.a);
        L44:
            StringBuilder r3 = new StringBuilder("upload failed, what:");
            r3.append(r20);
            r3.append(", error code(");
            if (r23 == null) goto L47;
            Long r0 = Long.valueOf(r23.mErrorCode);
        L48:
            r3.append(r0);
            r3.append("), error msg(");
            if (r23 == null) goto L51;
            r7 = r23.mErrorMsg;
        L51:
            r3.append(r7);
            r3.append(')');
            String r1 = r3.toString();
            r5.e("ImageXUploaderImpl", "[handleOnUploadFailed] " + r1);
            b4.a r4 = this.b.c;
            if (r4 == null) goto L65;
            r4.a(new ResourceUploadError("upload_imagex_error", r1));
            return;
        L65:
            return;
        L47:
            r0 = null;
            goto L48
        L40:
            r9 = null;
            goto L41
        L10:
            if (r20 != 3) goto L12;
            b4.a r10 = this.b.c;
            if (r10 == null) goto L63;
            r10.a(new ResourceUploadError("upload_imagex_error", "upload canceled"));
            return;
        L63:
            return;
        L12:
            if (r20 != 6) goto L14;
            if (r23 != null) goto L55;
            b4.a r11 = this.b.c;
            if (r11 == null) goto L61;
            r11.a(new ResourceUploadError("upload_imagex_error", "upload response tos key is null"));
            return;
        L61:
            return;
        L55:
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L22
            JSONObject r13 = new JSONObject(r23.mMetaInfo);     // Catch: Throwable -> L22
            int r14 = r13.optInt("ImageHeight");     // Catch: Throwable -> L22
            r8 = r13.optInt("ImageWidth");     // Catch: Throwable -> L20
            Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
        L25:
            p0 r16 = this.b;
            Throwable r17 = Result.exceptionOrNull-impl(r15);
            if (r17 == null) goto L28;
            FLogger r18 = FLogger.a;
            r18.e(r16.a, "[handleOnUploadSuccess] parse mMetaInfo failed, " + r17);
            r18.e(r16.a, "[handleOnUploadSuccess] mMetaInfo:" + r23.mMetaInfo);
        L28:
            FLogger.a.i(this.b.a, "[handleOnUploadSuccess] success, uri:" + r23.mImageTosKey);
            b4.a r22 = this.b.c;
            if (r22 == null) goto L59;
            r22.c(new mr9.l(r23.mImageTosKey, null, null, new mr9.d(r14, r8), null, false, null, 118));
            return;
        L59:
            return;
        L20:
            th = th;
            int r110 = r8;
            r8 = r14;
            int r24 = r110;
        L24:
            Result.Companion r25 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            int r111 = r8;
            r8 = r24;
            r14 = r111;
        L22:
            th = th;
            r24 = 0;
            goto L24
        L14:
            if (r20 == 7) goto L37;
        }
    }

    static {
    }

    public final void a() {
        FLogger.a.i(this.a, "[doUpload] start");
        BDImageXUploader r0 = this.b;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }

    public p0(mr9.j r11) {
        Intrinsics.checkNotNullParameter(r11, "uploadParam");
        String r0 = "ImageXUploaderImpl_" + r11.l;
        this.a = r0;
        com.larus.platform.model.chat.d r1 = z2.a.getBDImageXUploaderConfig();
        FLogger.a.i(r0, "[createBDImageXUploader], params:" + r11);
        BDImageXUploader r2 = new BDImageXUploader();
        String r4 = null;
        if (r11.g == false) goto L13;
        IUploaderService r3 = (IUploaderService) ServiceManager.get().getService(IUploaderService.class);
        if (r3 == null) goto L7;
        com.larus.uploader.impl.a r5 = r3.c(r11.getContext(), r11.a);
    L9:
        if ((r5 instanceof BDMediaDataReader) == true) goto L12;
        r5 = null;
    L12:
        r2.setMediaDataReader(r5, r11.i);
    L14:
        mr9.m r6 = r11.h;
        if (r6 == null) goto L28;
        r2.setFilePrefix(r6.d());
        r2.setUploadDomain(r6.c());
        mr9.b r7 = r6.a();
        if (r7 == null) goto L19;
        String r8 = r7.a();
    L20:
        r2.setTopAccessKey(r8);
        mr9.b r9 = r6.a();
        if (r9 == null) goto L23;
        String r10 = r9.c();
    L24:
        r2.setTopSecretKey(r10);
        mr9.b r12 = r6.a();
        if (r12 == null) goto L27;
        r4 = r12.d();
    L27:
        r2.setTopSessionToken(r4);
        r2.setServiceID(r6.b());
        goto L28
    L23:
        r10 = null;
        goto L24
    L19:
        r8 = null;
    L28:
        String r13 = r11.k;
        if (r13 != null) goto L31;
    L33:
        r2.setSocketNum(r1.h());
        r2.setSliceRetryCount(r1.g());
        r2.setFileRetryCount(r1.e());
        r2.setSDKMaxRetryTimeout(20);
        r2.setCustomNetworkTimeoutParams(10, 10, 15, 15, 0);
        if (ArraysKt.contains(new String[]{"html", "xml", "svg+xml"}, r11.k) == false) goto L36;
        r2.setSpecifiedContentType(1, new String[]{"text/plain"});
    L36:
        r2.setOpenBoe(HttpExtKt.e().a);
        this.b = r2;
        r2.setListener(new b(this, r11));
        return;
    L31:
        if (com.larus.utils.o0.d(r13) == false) goto L33;
        r2.setFileExtension(".".concat(r13));
        goto L33
    L7:
        r5 = null;
        goto L9
    L13:
        r2.setFilePath(r11.i, new String[]{r11.a});
        goto L14
    }

    public final void b(ResourceUploadEngine.upload.2.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public final void cancel(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        FLogger.a.i(this.a, "[cancel]");
        BDImageXUploader r4 = this.b;
        if (r4 == null) goto L5;
        r4.cancelUpload();
    L5:
        this.c = null;
    }
}
