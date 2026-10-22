package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import com.bytedance.android.annie.bridge.UploadFileResultModel;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "uploadFile")
public final class t2 extends com.bytedance.android.annie.bridge.f<com.bytedance.android.annie.bridge.u, UploadFileResultModel> {
    public final void onTerminate() {
    }

    public t2() {
    }

    public final void invoke(Object r10, CallContext r11) {
        com.bytedance.android.annie.bridge.u r1 = (com.bytedance.android.annie.bridge.u) r10;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        Context r12 = r11.getContext();
        ae7.a r0 = ae7.a.a;
        String r13 = r1.a();
        r0.getClass();
        if (ae7.a.e(r12, r13) == true) goto L6;
        UploadFileResultModel r14 = new UploadFileResultModel();
        r14.b(UploadFileResultModel.Code.Failed);
        r14.d("File not exists");
        finishWithResult(r14);
        return;
    L6:
        if (ae7.a.d(r12, r1.a()) == false) goto L57;
        s2 r15 = new s2(this);
        if (r1.a().length() <= 0) goto L10;
        boolean r16 = true;
    L11:
        LinkedHashMap r17 = null;
        if (r16 == false) goto L53;
        String r18 = r1.a();
        if (r18 != null) goto L16;
    L19:
        boolean r19 = true;
    L20:
        if (r19 == false) goto L22;
        r15.b(UploadFileResultModel.Code.InvalidParam, "The file path should not be empty.The key is filePath", null);
    L49:
        PolarisFileWrapper r20 = null;
    L50:
        if (r20 == null) goto L54;
        r17 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("file", r20)});
    L54:
        if (r17 == null) goto L61;
        TTExecutors.getNormalExecutor().execute(new r2(r1, this, r11, r17, r15));
        return;
    L61:
        return;
    L22:
        String r110 = ae7.a.a(r12, r18);
        if (r110 != null) goto L25;
    L28:
        boolean r21 = true;
    L30:
        if (r21 == false) goto L32;
        r15.b(UploadFileResultModel.Code.Failed, "File is not exist.The key is filePath", null);
        goto L49
    L32:
        r20 = new PolarisFileWrapper(r110);
        if (r20.exists() == true) goto L36;
        r15.b(UploadFileResultModel.Code.Failed, "File is not exist.The key is filePath", null);
        goto L49
    L36:
        if (r20.isFile() == true) goto L38;
        r15.b(UploadFileResultModel.Code.Failed, "File is not file.The key is filePath", null);
        goto L49
    L38:
        Lazy r22 = ArgusGlobalDelegate.c;
        ArgusGlobalDelegate r23 = ArgusGlobalDelegate.a.a();
        if (r23 == null) goto L41;
        com.bytedance.ies.argus.bean.i r24 = r23.b(new com.bytedance.ies.argus.api.params.b(r110, "uploadFile"));
    L42:
        if (r24 != null) goto L44;
    L46:
        boolean r25 = false;
    L47:
        if (r25 == false) goto L50;
        r15.b(UploadFileResultModel.Code.Failed, "file path " + r110 + " contains sensitive content, can not upload.", null);
        goto L49
    L44:
        if (r24.c() != true) goto L46;
        r25 = true;
        goto L47
    L41:
        r24 = null;
        goto L42
    L25:
        if (r110.length() == 0) goto L28;
        r21 = false;
        goto L30
    L16:
        if (r18.length() == 0) goto L19;
        r19 = false;
        goto L20
    L53:
        r15.b(UploadFileResultModel.Code.InvalidParam, "filePath can not be null.", null);
        goto L54
    L10:
        r16 = false;
        goto L11
    L57:
        UploadFileResultModel r111 = new UploadFileResultModel();
        r111.b(UploadFileResultModel.Code.Failed);
        r111.d("has no permission for file");
        finishWithResult(r111);
    }
}
