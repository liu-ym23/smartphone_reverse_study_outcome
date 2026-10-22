package com.larus.avlink.gallery.plugin;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final AtomicBoolean a = null;
    public static final AtomicBoolean b = null;
    public static final CoroutineScope c = null;
    public static final C0008a d = null;
    public static final b e = null;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.plugin.a$a, reason: collision with other inner class name */
    public static final class C0008a implements f09.a.b {
        public C0008a() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
        }

        public final void onAppForeground() {
            AtomicBoolean r0 = a.a;
            IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            boolean r2 = false;
            if (r1 != null) goto L5;
        L7:
            boolean r3 = false;
        L9:
            if (r3 == true) goto L12;
            FLogger.a.i("DoraPluginInitiator", "App foreground, skip handleInit, because DoraLink is not connected");
            return;
        L12:
            IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r4 == null) goto L19;
            DeviceService r5 = r4.device();
            if (r5 == null) goto L19;
            if (r5.C() != true) goto L19;
            r2 = true;
        L19:
            if (r2 == true) goto L22;
            FLogger.a.i("DoraPluginInitiator", "App foreground, skip handleInit because device has no vision");
            return;
        L22:
            FLogger.a.i("DoraPluginInitiator", "App foreground with DoraLink connected, try handleInit");
            BuildersKt.launch$default(a.c, null, null, new DoraPluginInitiator$handleInit$1(null), 3, null);
            return;
        L5:
            if (r1.getLinkState() != 2) goto L7;
            r3 = true;
            goto L9
        }
    }

    public static final class b implements h49.e {
        public b() {
        }

        public final void b(int r1) {
        }

        public final void a(int r9) {
            if (r9 == 2) goto L6;
            FLogger.a.i("DoraPluginInitiator", "Skip handleInit, because DoraLink is not connected");
            return;
        L6:
            IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r10 == null) goto L13;
            DeviceService r11 = r10.device();
            if (r11 == null) goto L13;
            boolean r0 = true;
            if (r11.C() != true) goto L13;
        L14:
            if (r0 == true) goto L17;
            FLogger.a.i("DoraPluginInitiator", "Skip handleInit, because device has no vision");
            return;
        L17:
            FLogger.a.i("DoraPluginInitiator", "DoraLink connected, try handleInit");
            BuildersKt.launch$default(a.c, null, null, new DoraPluginInitiator$handleInit$1(null), 3, null);
            return;
        L13:
            r0 = false;
            goto L14
        }
    }

    public a() {
    }

    static {
        a = new AtomicBoolean(false);
        b = new AtomicBoolean(false);
        c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        d = new C0008a();
        e = new b();
    }
}
