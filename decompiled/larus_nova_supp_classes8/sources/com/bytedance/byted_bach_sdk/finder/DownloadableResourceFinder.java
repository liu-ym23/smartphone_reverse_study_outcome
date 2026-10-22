package com.bytedance.byted_bach_sdk.finder;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DownloadableResourceFinder extends BachResourceFinder {
    private AssetManager m_assetMgr;
    private Context m_context;
    private HashMap<String, String> m_params;

    private native long nativeCreate(String r1, String[] r2, AssetManager r3);

    private native void nativeDestroy(long r1);

    private native void nativeDownloadModels(long r1, String[] r3, ModelDownloadListener r4);

    private void init() {
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.m_context.getCacheDir(), "model");
        String[] r1 = new String[this.m_params.size() * 2];
        Iterator<String> r2 = this.m_params.keySet().iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        String r4 = r2.next();
        int r5 = r3 * 2;
        r1[r5] = r4;
        r1[r5 + 1] = this.m_params.get(r4);
        r3 = r3 + 1;
        goto L4
    L6:
        this.m_nativePtr = nativeCreate(r0.getAbsolutePath(), r1, this.m_assetMgr);
    }

    @Override // com.bytedance.byted_bach_sdk.finder.BachResourceFinder
    public void destroy() {
        if (this.isDestroyed == false) goto L5;
        return;
    L5:
        this.isDestroyed = true;
        nativeDestroy(this.m_nativePtr);
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public DownloadableResourceFinder(Context r2, HashMap<String, String> r3) {
        this.m_assetMgr = r2.getAssets();
        this.m_context = r2;
        this.m_params = r3;
        init();
    }

    public void downloadModels(List<String> r4, ModelDownloadListener r5) {
        String[] r0 = new String[r4.size()];
        r4.toArray(r0);
        nativeDownloadModels(this.m_nativePtr, r0, r5);
    }
}
