package com.bytedance.bdinstall.dtrait.manager;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.DTraitProcessor;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.bdinstall.dtrait.executor.ExecutorUtil;
import com.bytedance.bdinstall.dtrait.model.DTraitTimeMonitorEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitManager {
    private final DTraitProcessor dTraitProcessor;

    public DTraitManager(Context r3, DTraitNativeManager r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.dTraitProcessor = new DTraitProcessor(r6, new DTraitCacheManager(r6), r4, r5);
    }

    static /* synthetic */ DTraitProcessor access$000(DTraitManager r0) {
        return r0.dTraitProcessor;
    }

    public void collectLoaderReport(JSONObject r1) {
        this.dTraitProcessor.doDTraitCollectReport(r1);
    }

    public Map<String, String> getDTrait(String r1, DTraitRiskType r2, int r3) {
        return this.dTraitProcessor.getDTrait(r1, r2, r3);
    }

    public void handleDTrait(JSONObject r1, String r2) {
        DTraitTimeMonitorEvent.setSdkInitFinish();
        this.dTraitProcessor.handleDTrait(r1, r2);
    }

    public void parseDTraitInfo(final JSONObject r2, final JSONObject r3) {
        if (DTraitConfig.isEnableDTrait() == true) goto L6;
        DTLog.d("[dt] isEnableDTrait = false, return...");
        return;
    L6:
        ExecutorUtil.runOnIOExecutor(new AnonymousClass1(this, r2, r3));
    }

    public void preHandleConfigForDTrait() {
        this.dTraitProcessor.preHandleConfigForDTrait();
    }
}
