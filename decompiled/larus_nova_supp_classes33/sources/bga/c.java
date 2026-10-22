package bga;

import com.obric.assistant.session.model.IApplicationActivityOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final IApplicationActivityOperation a() {
        return (IApplicationActivityOperation) ServiceManager.get().getService(IApplicationActivityOperation.class);
    }
}
