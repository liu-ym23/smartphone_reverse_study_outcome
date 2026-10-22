package com.byted.mgl.merge.service.api.location;

import android.content.Context;
import com.byted.mgl.merge.service.model.BdpLocator;
import com.byted.mgl.merge.service.model.BdpMap;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpMapService extends IBdpService {
    BdpLocator createLocateInstance(Context r1);

    BdpMap createMapInstance();
}
