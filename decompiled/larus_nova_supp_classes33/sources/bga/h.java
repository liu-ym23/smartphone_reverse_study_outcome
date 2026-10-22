package bga;

import com.obric.assistant.session.model.IOAutoOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h {
    public static final IOAutoOperation a() {
        return (IOAutoOperation) ServiceManager.get().getService(IOAutoOperation.class);
    }
}
