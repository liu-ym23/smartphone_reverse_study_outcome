package com.ss.android.lark.image.impl.passthrough;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.image.uploader.utils.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.a0;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PassThroughImageDataFetcher extends ResourceImageDataFetcher<PassThroughImage> {
    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "PassThroughImageDataFetcher";
    }

    public PassThroughImageDataFetcher(PassThroughImage r1) {
        super(r1);
    }

    private Resource getPassThroughImage(PassThroughImage r9) {
        e r0 = (e) ApiUtils.getApi(e.class);
        String r3 = a0.g(LarkContext.getApplication());
        return r0.getImageService().getPassThroughImage(r3, r9.getImageKey(), r9.getFsUnit(), r9.getCrypto(), r9.getFileType());
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(PassThroughImage r7) throws FileNotFoundException {
        long r0 = SystemClock.elapsedRealtime();
        Resource r2 = getPassThroughImage(r7);
        String r3 = r2.b;
        long r4 = SystemClock.elapsedRealtime() - r0;
        Log.i("PassThroughImageDataFetcher", "load passThrough image, key is:" + r7.getImageKey() + ", fsUnit:" + r7.getFsUnit() + ", filePath is:" + r3);
        r7.setErrorResult(r2.e);
        Trace r1 = r2.d;
        if (r1 == null) goto L8;
        if (r1.spans == null) goto L8;
        ArrayList r5 = new ArrayList(r1.spans);
        r5.add(new Trace.Span.Builder().name("sdk_cost").duration_millis(Long.valueOf(r4)).build());
        r7.setTrace(new Trace.Builder().spans(r5).build());
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return null;
    L11:
        ImageInfo r6 = b.d(r3, false, false);
        if (r6 == null) goto L15;
        r7.setImageType(r6.h.getValue());
        r7.setResourceSize(r6.c);
    L15:
        return new PolarisFileInputStreamWrapper(r3);
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(PassThroughImage r1) throws FileNotFoundException {
        return getResourceStream2(r1);
    }
}
