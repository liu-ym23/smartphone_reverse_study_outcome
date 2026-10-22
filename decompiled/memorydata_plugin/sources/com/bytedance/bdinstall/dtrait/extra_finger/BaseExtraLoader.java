package com.bytedance.bdinstall.dtrait.extra_finger;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.DTraitService;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.manager.DTraitNativeManager;
import com.bytedance.bdinstall.dtrait.manager.DTraitServiceManager;
import com.bytedance.bdinstall.dtrait.model.ExtraLoaderInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseExtraLoader implements Callable<ExtraLoaderInfo> {
    protected JSONObject configData;
    protected Context context;
    protected DTraitNativeManager dTraitNativeManager;
    protected String errorMsg;
    protected final ExtraLoaderInfo extraLoaderInfo;

    public BaseExtraLoader(Context r3, JSONObject r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.errorMsg = "";
        this.context = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.configData = r4;
        this.extraLoaderInfo = new ExtraLoaderInfo();
        DTraitService r6 = (DTraitService) ZeusTransformUtils.preCheckCast(DTraitServiceManager.getService(DTraitService.class), DTraitService.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L6;
        this.dTraitNativeManager = r6.getDTraitNativeManager();
        return;
    }

    private String getErrorMsg() {
        return this.errorMsg;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public ExtraLoaderInfo call() {
        return doLoad();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ ExtraLoaderInfo call() {
        return call();
    }

    public ExtraLoaderInfo doLoad() {
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L8
        String r3 = load();     // Catch: Exception -> L8
        long r4 = System.currentTimeMillis();     // Catch: Exception -> L8
        this.extraLoaderInfo.setData(r3);     // Catch: Exception -> L8
        this.extraLoaderInfo.setName(getName());     // Catch: Exception -> L8
        this.extraLoaderInfo.setDuration(r4 - r1);     // Catch: Exception -> L8
        this.extraLoaderInfo.setErrorMsg(getErrorMsg());     // Catch: Exception -> L8
        this.extraLoaderInfo.toJSON();     // Catch: Exception -> L8
        if (this.configData.has("index") == false) goto L6;
        this.extraLoaderInfo.setIndex(this.configData.optInt("index"));     // Catch: Exception -> L8
    L6:
        return this.extraLoaderInfo;
    L8:
        e = move-exception;
        DTLog.e(DTraitConstant.TAG_DTRAIT + getName() + " doLoad# error " + e.getMessage());
        return this.extraLoaderInfo;
    }

    public abstract String getName();

    public abstract String load();
}
