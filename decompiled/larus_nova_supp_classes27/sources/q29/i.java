package q29;

import com.larus.home.impl.sdk.l1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    static {
    }

    public static boolean a() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L9;
        r0.H();
        VideoPortraitConfig r1 = l1.a.a();
        if (r1 == null) goto L9;
        if (r1.getEnableEditVideo() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
