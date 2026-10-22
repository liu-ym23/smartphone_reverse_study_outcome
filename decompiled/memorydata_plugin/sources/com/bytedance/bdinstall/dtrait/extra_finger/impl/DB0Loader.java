package com.bytedance.bdinstall.dtrait.extra_finger.impl;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DB0Loader extends BaseExtraLoader {
    public DB0Loader(Context r3, JSONObject r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String getName() {
        return DTraitConstant.D_B0;
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String load() {
        return String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }
}
