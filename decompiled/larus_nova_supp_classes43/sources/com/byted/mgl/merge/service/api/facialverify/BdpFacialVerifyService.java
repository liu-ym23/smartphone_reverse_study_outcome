package com.byted.mgl.merge.service.api.facialverify;

import android.app.Activity;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpFacialVerifyService extends IBdpService {
    void startFaceLive(Activity r1, HashMap<String, String> r10, FaceLiveCallback r11);
}
