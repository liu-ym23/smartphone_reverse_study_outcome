package com.byted.mgl.merge.service.api.collect;

import android.app.Activity;
import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpGameCollectService extends IBdpService {
    BdpGameCollectShowInfo getBdpCollectShowInfo(Context r1, boolean r10);

    boolean handleCollectResult(boolean r1, boolean r10, String r11, boolean r12, Activity r13, String r14, String r15, String r16, String r17, JSONObject r18);
}
