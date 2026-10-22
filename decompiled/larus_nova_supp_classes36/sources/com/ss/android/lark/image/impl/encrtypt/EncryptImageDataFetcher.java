package com.ss.android.lark.image.impl.encrtypt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.image.uploader.utils.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import javax.annotation.Nullable;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class EncryptImageDataFetcher extends ResourceImageDataFetcher<EncryptImage> {
    private boolean hasFetchedAgain;

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "EncryptImageDataFetcher";
    }

    public EncryptImageDataFetcher(EncryptImage r1) {
        super(r1);
    }

    @Nullable
    private byte[] decryptResource(String r2) {
        e r0 = (e) ApiUtils.getApi(e.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.decryptResource(r2);
    }

    private Resource getEncryptImage(EncryptImage r9) {
        return ImageModule.a.getEncryptImage(null, r9.getEncryptKey(), r9.getFsUnit(), r9.getCrypto(), r9.getContextId(), r9.isNeedCollectTrace(), r9.getDraftResourceSource());
    }

    private static String getFileCRC32(String r6) {
        CRC32 r0 = new CRC32();
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r6));     // Catch: IOException -> L9
        CheckedInputStream r7 = new CheckedInputStream(r1, r0);     // Catch: IOException -> L9
        byte[] r3 = new byte[1024];     // Catch: IOException -> L9
        int r4 = 1024;
    L5:
        if (r4 == (-1)) goto L7;
        r4 = r7.read(r3, 0, 1024);     // Catch: IOException -> L9
        goto L5
    L7:
        r7.close();     // Catch: IOException -> L9
        r1.close();     // Catch: IOException -> L9
        return Long.toHexString(r0.getValue());
    L9:
        e = move-exception;
        e.printStackTrace();
        Log.i("EncryptImageDataFetcher", "get file crc32 failed : " + e.getMessage());
        return "";
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(EncryptImage r13) throws FileNotFoundException {
        long r0 = r13.getCreateTime();
        long r2 = 0;
        if (r0 == 0) goto L5;
        r13.setWaitTime(System.currentTimeMillis() - r0);
    L5:
        long r1 = SystemClock.elapsedRealtime();
        Resource r4 = getEncryptImage(r13);
        r13.setDecodeStartTime(System.currentTimeMillis());
        long r5 = SystemClock.elapsedRealtime() - r1;
        if (r4 == null) goto L13;
        String r3 = r4.b;
        Trace r7 = r4.d;
        if (r7 != null) goto L10;
    L12:
        r13.setTrace(r7);
        r13.setErrorResult(r4.e);
    L14:
        boolean r6 = FileUtils.r(r3);
        Log.i("EncryptImageDataFetcher", "load encrypt image, key is:" + r13.getEncryptKey() + ", filePath is:" + r3 + ", isFileExits, " + r6 + ", collect_trace:" + r13.isNeedCollectTrace() + ", contextId:" + r13.getContextId());
        if (TextUtils.isEmpty(r3) == true) goto L17;
        boolean r8 = true;
        if (r6 == false) goto L26;
        ImageInfo r9 = b.d(r3, false, false);
        if (r9 == null) goto L33;
        String r10 = r9.h.getValue();
        r13.setResourceSize(r9.c);
    L35:
        if (TextUtils.isEmpty(r10) == false) goto L37;
    L38:
        r10 = ImageUtils.c(VFSFiles.b.i(r3)).getValue();
    L39:
        r13.setImageType(r10);
        if (r9 != null) goto L42;
    L48:
        r13.setResourceHash(getFileCRC32(r3));
        r13.setFormatHeader(ImageUtils.a(new PolarisFileWrapper(r3)));
        String r11 = r13.getContextId();
        String r12 = r13.getEncryptKey();
        if (r9 == null) goto L51;
        r2 = r9.c;
    L51:
        Log.e("EncryptImageDataFetcher", "image decode failed , context_id:" + r11 + ",resource_key:" + r12 + ",size:" + r2 + ",hash:" + r13.getResourceHash());
    L52:
        if (r4 == null) goto L65;
        String r14 = r4.b;
        if (r4.c.booleanValue() == false) goto L65;
        long r15 = System.currentTimeMillis();
        Log.d("EncryptImageDataFetcher", "start decrypt resource = " + r14);
        Log.i("EncryptImageDataFetcher", "start decrypt resource = " + r14.hashCode());
        byte[] r16 = decryptResource(r14);
        if (r16 != null) goto L58;
    L62:
        Log.e("EncryptImageDataFetcher", "decrypt image resource failed = " + r14.hashCode() + "result length = 0");
        return null;
    L58:
        if (r16.length == 0) goto L62;
        Log.i("EncryptImageDataFetcher", "decrypt image resource success = " + r14.hashCode() + "result length = " + r16.length);
        long r17 = System.currentTimeMillis() - r15;
        r13.setDecryptTime(r17);
        Log.d("EncryptImageDataFetcher", "decrypt image resource cost :" + r17);
        return new ByteArrayInputStream(r16);
    L65:
        return new PolarisFileInputStreamWrapper(r3);
    L42:
        if (r9.a > 0) goto L44;
    L46:
        r8 = false;
    L47:
        if (r8 == true) goto L52;
    L44:
        if (r9.b <= 0) goto L46;
    L37:
        if (Objects.equals(r10, ImageUtils.ImageType.TYPE_UNKNOWN.getValue()) == false) goto L39;
    L33:
        r10 = "";
        goto L35
    L26:
        if (this.hasFetchedAgain == true) goto L29;
        this.hasFetchedAgain = true;
        Log.i("EncryptImageDataFetcher", "resource file not exist, retry get");
        return getResourceStream2(r13);
    L29:
        r13.setErrorResult(new ErrorResult(701003, "file no exist"));
        Log.i("EncryptImageDataFetcher", "resource file not exist, " + r3);
        goto L52
    L17:
        if (r13.getErrorResult() != null) goto L19;
    L20:
        r13.setErrorResult(new ErrorResult(701002, "file path is empty"));
    L21:
        Log.i("EncryptImageDataFetcher", "resource path is empty, " + r3);
        return null;
    L19:
        if (r13.getErrorResult().getCode() != 0) goto L21;
    L10:
        if (r7.spans == null) goto L12;
        ArrayList r18 = new ArrayList(r7.spans);
        r18.add(new Trace.Span.Builder().name("sdk_cost").duration_millis(Long.valueOf(r5)).build());
        r7 = new Trace.Builder().spans(r18).build();
        goto L12
    L13:
        r3 = null;
        goto L14
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(EncryptImage r1) throws FileNotFoundException {
        return getResourceStream2(r1);
    }
}
