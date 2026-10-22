package h29;

import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.larus.community.impl.applet.music.MusicGenerationAppletApplication;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean(false);
    }

    public static void a() {
        if (a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        FLogger.a.i("MusicGenerationAppletRegistry", "register music template applet");
        AppletAppManagerService.INSTANCE.getClass();
        AppletAppManagerService.e("db_2c90E66", MusicGenerationAppletApplication.class);
    }
}
