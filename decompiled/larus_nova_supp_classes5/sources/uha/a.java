package uha;

import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final CoWakeupApi a() {
        return (CoWakeupApi) ServiceManager.get().getService(CoWakeupApi.class);
    }
}
