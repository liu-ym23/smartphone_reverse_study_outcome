package com.byted.mgl.merge.service.api.location;

import android.app.Activity;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpHostMapNativeService extends IBdpService {
    boolean chooseLocation(Activity r1, BdpGetLocationCallback r10);

    boolean openLocation(Activity r1, String r10, String r11, double r12, double r13, int r14, String r15);
}
