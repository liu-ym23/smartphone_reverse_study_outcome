package com.bytedance.byted_bach_sdk.finder;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.byted_bach_sdk.BachResourceFinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AssetResourceFinder extends BachResourceFinder {
    private AssetManager m_assetMgr;
    private Context m_context;
    private ArrayList<String> m_models;

    public AssetResourceFinder(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.m_models = new ArrayList();
        this.m_assetMgr = r4.getAssets();
        this.m_context = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        init();
    }

    private void addModelFile(String r5) {
        String[] r0 = {".model", ".dat", ".bytenn", ".bytennllm"};
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L9;
        if (r5.endsWith(r0[r1]) == false) goto L8;
        this.m_models.add(r5);
    L8:
        r1 = r1 + 1;
        goto L4
    }

    private void init() {
        this.m_nativePtr = nativeCreate(new File(this.m_context.getCacheDir(), "bach_private_cache").getAbsolutePath(), this.m_assetMgr);
        scanDir("model");
        String[] r0 = new String[this.m_models.size()];
        this.m_models.toArray(r0);
        nativeSetModels(this.m_nativePtr, r0);
    }

    private native long nativeCreate(String r1, AssetManager r2);

    private native void nativeDestroy(long r1);

    private native void nativeSetModels(long r1, String[] r3);

    private void scanDir(String r7) {
        String[] r0 = this.m_assetMgr.list(r7);     // Catch: IOException -> L9
        if (r0.length <= 0) goto L7;
        int r1 = r0.length;     // Catch: IOException -> L9
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L15;
        scanDir(r7 + "/" + r0[r2]);     // Catch: IOException -> L9
        r2 = r2 + 1;     // Catch: IOException -> L9
        goto L5
    L15:
        return;
    L7:
        addModelFile(r7);     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.byted_bach_sdk.BachResourceFinder
    public void doDestroy() {
        super.doDestroy();
        nativeDestroy(this.m_nativePtr);
        this.m_nativePtr = 0;
    }

    public void finalize() {
        super.finalize();
        destroy();
    }
}
