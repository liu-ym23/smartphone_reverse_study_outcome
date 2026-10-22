package gd0;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface n extends IService {
    String getLinkConnectionType();

    com.bytedance.android.live.liveinteract.plantform.base.i<? extends ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    boolean isAudienceLinkEngineOn();

    boolean isCPositionOpen();
}
