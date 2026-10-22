package com.bytedance.byted_bach_sdk.finder;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.byted_bach_sdk.BachResourceFinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DownloadableResourceFinder extends BachResourceFinder {
    private AssetManager m_assetMgr;
    private Context m_context;
    private HashMap<String, String> m_params;

    public DownloadableResourceFinder(Context r3, HashMap<String, String> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.m_assetMgr = r5.getAssets();
        this.m_context = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.m_params = r4;
        init();
    }

    private void init() {
        File r0 = new File(this.m_context.getCacheDir(), "model");
        String[] r1 = new String[this.m_params.size() * 2];
        Iterator<String> r2 = this.m_params.keySet().iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        int r5 = r3 * 2;
        r1[r5] = r4;
        r1[r5 + 1] = (String) ZeusTransformUtils.preCheckCast(this.m_params.get(r4), String.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L4
    L6:
        this.m_nativePtr = nativeCreate(r0.getAbsolutePath(), r1, this.m_assetMgr);
    }

    private native long nativeCreate(String r1, String[] r2, AssetManager r3);

    private native void nativeDestroy(long r1);

    private native void nativeDownloadModels(long r1, String[] r3, ModelDownloadListener r4);

    @Override // com.bytedance.byted_bach_sdk.BachResourceFinder
    public void doDestroy() {
        super.doDestroy();
        nativeDestroy(this.m_nativePtr);
        this.m_nativePtr = 0;
    }

    public void downloadModels(List<String> r4, ModelDownloadListener r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        String[] r0 = new String[r6.size()];
        r6.toArray(r0);
        nativeDownloadModels(this.m_nativePtr, r0, r5);
    }

    public void finalize() {
        super.finalize();
        destroy();
    }
}
