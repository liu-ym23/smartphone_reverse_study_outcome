package bga;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static final ISessionMaintaining b() {
        return (ISessionMaintaining) ServiceManager.get().getService(ISessionMaintaining.class);
    }

    public static final String a() {
        ISessionMaintaining r0 = b();
        if (r0 == null) goto L6;
        String r1 = r0.w();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
    }

    public static final String c() {
        ISessionMaintaining r0 = b();
        if (r0 == null) goto L6;
        String r1 = r0.o();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }
}
