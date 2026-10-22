package com.obric.sva.sdk.controller;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.data.ISmModel;
import com.obric.sva.sdk.effectplatform.EffectConstant;
import com.obric.sva.sdk.utils.FileKt;
import com.obric.sva.sdk.utils.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import rna.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AssetsFileMgr {
    private final String[] MODEL_ASSETS_FOLDER;
    private final String TAG;

    public AssetsFileMgr() {
        this.TAG = "AssetsFileMgr";
        this.MODEL_ASSETS_FOLDER = new String[]{"sa_qcom_model", "speech_kws_model"};
    }

    private void copyAssets(Context r19, String r20) {
        String r2 = r20;
        String r3 = "/";
        int r4 = 0;
        if (r2 != null) goto L5;
    L57:
        LogUtils.e(this.TAG, "copyAssets: invalid param", new Object[0]);
        return;
    L5:
        if (c.c(r20) == false) goto L57;
        AssetManager r5 = r19.getAssets();
        String[] r6 = null;
        int r7 = 0;
    L8:
        String[] r0 = this.MODEL_ASSETS_FOLDER;
        if (r7 >= r0.length) goto L56;
        String r8 = r0[r7];
        r6 = r5.list(r8);     // Catch: IOException -> L13
    L15:
        if (r6 != null) goto L17;
    L54:
        String r16 = r3;
        AssetManager r17 = r5;
    L55:
        r7 = r7 + 1;
        r2 = r20;
        r3 = r16;
        r5 = r17;
        r4 = 0;
        goto L8
    L17:
        if (r6.length == 0) goto L54;
        String[] r1 = new String[r6.length];
        int r9 = r6.length;     // Catch: IOException -> L50
        int r10 = 0;
        int r11 = 0;
    L21:
        if (r10 >= r9) goto L46;
        String r12 = r6[r10];     // Catch: IOException -> L50
        String r13 = r8 + r3 + r12;     // Catch: IOException -> L50
        String r14 = r2 + r3 + r12;     // Catch: IOException -> L50
        InputStream r15 = r5.open(r13);     // Catch: IOException -> L50
        String r18 = this.TAG;     // Catch: IOException -> L50
        StringBuilder r21 = new StringBuilder();     // Catch: IOException -> L50
        r16 = r3;
        r21.append("copyAssets: outputFilePath = ");     // Catch: IOException -> L44
        r21.append(r14);     // Catch: IOException -> L44
        r21.append(" and sourceFile =");     // Catch: IOException -> L44
        r21.append(r13);     // Catch: IOException -> L44
        r17 = r5;
        LogUtils.d(r18, r21.toString(), new Object[0]);     // Catch: IOException -> L42
        PolarisFileWrapper r22 = new PolarisFileWrapper(r14);     // Catch: IOException -> L42
        if (r12.equals(EffectConstant.CURRENT_CONFIG_JSON) == false) goto L32;
        if (r22.exists() == false) goto L32;
        LogUtils.d(this.TAG, "copyAssets: current.json file , do not overwrite if exist,  just ignore", new Object[0]);     // Catch: IOException -> L42
    L59:
        r10 = r10 + 1;     // Catch: IOException -> L48
        r2 = r20;
        r3 = r16;
        r5 = r17;
    L48:
        e = e;
    L53:
        e.printStackTrace();
    L32:
        if (FileKt.isSameMD5(r15, r14) == false) goto L36;
        LogUtils.d(this.TAG, "copyAssets: exists yet and same md5, just ignore", new Object[0]);     // Catch: IOException -> L42
        goto L59
    L36:
        if (r22.exists() == false) goto L38;
        LogUtils.d(this.TAG, "copyAssets: delete the file due to copy again , caused by the different md5 ", new Object[0]);     // Catch: IOException -> L42
        r22.delete();     // Catch: IOException -> L42
    L38:
        LogUtils.d(this.TAG, "copyAssets: copy filename =  " + r12 + " from " + r13 + " to destDir :" + r14, new Object[0]);     // Catch: IOException -> L42
        copySingleAssetFile(r19, r13, r14);     // Catch: IOException -> L48
        r1[r11] = r14;     // Catch: IOException -> L48
        r11 = r11 + 1;     // Catch: IOException -> L48
    L42:
        e = e;
    L44:
        e = e;
    L52:
        r17 = r5;
        goto L53
    L46:
        r16 = r3;
        r17 = r5;
        LogUtils.d(this.TAG, "copyAssets: copy file number = " + r11, new Object[0]);     // Catch: IOException -> L48
    L50:
        e = e;
        r16 = r3;
    L13:
        e = move-exception;
        LogUtils.e(this.TAG, e.getMessage(), new Object[r4]);
        goto L15
    }

    public void copyAssetsIfNotExists(Context r5, String r6) {
        LogUtils.d(this.TAG, "copyAssetsIfNotExists: destDir = " + r6, new Object[0]);
        if (r6 != null) goto L6;
        LogUtils.e(this.TAG, "copyAssetsIfNotExists: invalid param", new Object[0]);
        return;
    L6:
        c.a(r6);
        if (c.c(r6) == false) goto L9;
        copyAssets(r5, r6);
        return;
    L9:
        LogUtils.e(this.TAG, "copyAssetsIfNotExists: create destDir failure", new Object[0]);
    }

    private void copySingleAssetFile(Context r3, String r4, String r5) throws IOException {
        InputStream r6 = r3.getAssets().open(r4);
        PolarisFileOutputStreamWrapper r7 = new PolarisFileOutputStreamWrapper(r5);
        byte[] r8 = new byte[ISmModel.VERSION_0400];
    L3:
        int r0 = r6.read(r8);
        if (r0 == (-1)) goto L6;
        r7.write(r8, 0, r0);
        goto L3
    L6:
        r6.close();
        r7.flush();
        r7.close();
    }
}
