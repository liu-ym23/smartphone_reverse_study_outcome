package bga;

import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public static final ILaunchMethodOperation a() {
        return (ILaunchMethodOperation) ServiceManager.get().getService(ILaunchMethodOperation.class);
    }
}
