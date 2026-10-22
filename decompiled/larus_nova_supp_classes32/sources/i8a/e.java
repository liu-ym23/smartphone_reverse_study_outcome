package i8a;

import com.lynx.tasm.service.IServiceProvider;
import com.lynx.tasm.service.LynxResourceServiceRequestParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface e extends IServiceProvider {

    public interface a {
    }

    void cancelPreloadMedia(String r1, String r2);

    f fetchResourceAsync(String r1, LynxResourceServiceRequestParams r2, m r3);

    int isLocalResource(String r1);

    boolean isReady();

    void preloadMedia(String r1, String r2, String r3, long r4, a r6);
}
