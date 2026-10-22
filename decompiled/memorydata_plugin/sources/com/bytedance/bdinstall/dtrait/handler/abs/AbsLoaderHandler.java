package com.bytedance.bdinstall.dtrait.handler.abs;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader;
import com.bytedance.bdinstall.dtrait.extra_finger.ExtraLoaderConfigHandler;
import com.bytedance.bdinstall.dtrait.extra_finger.impl.DA0Loader;
import com.bytedance.bdinstall.dtrait.extra_finger.impl.DB0Loader;
import com.bytedance.bdinstall.dtrait.extra_finger.impl.DI0Loader;
import com.bytedance.bdinstall.dtrait.extra_finger.impl.DM0Loader;
import com.bytedance.bdinstall.dtrait.extra_finger.impl.DR0Loader;
import com.bytedance.bdinstall.dtrait.manager.DTraitCacheManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsLoaderHandler {
    protected final DTraitCacheManager cacheHandler;
    protected final ExtraLoaderConfigHandler configHandler;
    protected final Context context;
    protected final boolean hasLocalDid;
    protected final List<BaseExtraLoader> loaderList;

    public AbsLoaderHandler(Context r3, ExtraLoaderConfigHandler r4, DTraitCacheManager r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.configHandler = r4;
        this.cacheHandler = r5;
        this.context = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.loaderList = new ArrayList();
        this.hasLocalDid = r6;
    }

    public abstract void addCollectors(long r1);

    public void addLoader(Map<String, JSONObject> r11) {
        Iterator r12 = ((Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L45;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        if (getLoaderWhiteList().contains(r0.getKey()) == false) goto L9;
        BaseExtraLoader r3 = null;
        byte r4 = -1;
        switch(r2.hashCode()) {
            case 3073450: goto L27;
            case 3073481: goto L24;
            case 3073698: goto L21;
            case 3073822: goto L18;
            case 3073977: goto L15;
            default: goto L29;
        };     // Catch: Exception -> L43
    L29:
        if (r4 == 0) goto L39;
        if (r4 == 1) goto L38;
        if (r4 == 2) goto L37;
        if (r4 == 3) goto L36;
        if (r4 != 4) goto L40;
        r3 = new DM0Loader(this.context, (JSONObject) ZeusTransformUtils.preCheckCast(r0.getValue(), JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L43
    L40:
        if (r3 == null) goto L4;
        this.loaderList.add(r3);     // Catch: Exception -> L43
        goto L4
    L36:
        r3 = new DI0Loader(this.context, (JSONObject) ZeusTransformUtils.preCheckCast(r0.getValue(), JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L43
        goto L40
    L37:
        r3 = new DR0Loader(this.context, (JSONObject) ZeusTransformUtils.preCheckCast(r0.getValue(), JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L43
        goto L40
    L38:
        r3 = new DB0Loader(this.context, (JSONObject) ZeusTransformUtils.preCheckCast(r0.getValue(), JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L43
        goto L40
    L39:
        r3 = new DA0Loader(this.context, (JSONObject) ZeusTransformUtils.preCheckCast(r0.getValue(), JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L43
        goto L40
    L15:
        if (r2.equals(DTraitConstant.D_R0) == false) goto L29;
        r4 = 2;
        goto L29
    L18:
        if (r2.equals(DTraitConstant.D_M0) == false) goto L29;
        r4 = 4;
        goto L29
    L21:
        if (r2.equals(DTraitConstant.D_I0) == false) goto L29;
        r4 = 3;
        goto L29
    L24:
        if (r2.equals(DTraitConstant.D_B0) == false) goto L29;
        r4 = 1;
        goto L29
    L27:
        if (r2.equals(DTraitConstant.D_A0) == false) goto L29;
        r4 = 0;
        goto L29
    L9:
        if (DTLog.debug() == false) goto L4;
        DTLog.d("[dt] addLoader# whiteList not contain key: " + r2);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        DTLog.e(DTraitConstant.TAG_DTRAIT + getTAG() + "addLoader# error " + e.getMessage());
        goto L4
    }

    public abstract void collect();

    public abstract List<String> getLoaderWhiteList();

    public abstract String getTAG();
}
