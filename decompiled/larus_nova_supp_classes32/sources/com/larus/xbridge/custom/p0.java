package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.login.api.AccountTrackService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.assistant.spi.feedback.FeedbackServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p0 extends bx7.c {
    public final c b;
    public final b c;

    public static final class a {
    }

    public static final class b implements t39.u {
        public final /* synthetic */ p0 a;

        public final void b() {
        }

        public b(p0 r1) {
            this.a = r1;
        }

        public final void a(boolean r3, String r4, String r5, boolean r6, int r7) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            Intrinsics.checkNotNullParameter(r5, "filePath");
            FLogger r8 = FLogger.a;
            r8.i("AppUploadLogMethod", "onGetLogResult success is " + r3 + ", msg is " + r4);
            if (r7 == 2) goto L8;
            r8.d("AppUploadLogMethod", "onGetLogResult ban startUploadLog " + r5 + ". success: " + r3 + ", curLogType: " + r7);
            IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r9 == null) goto L9;
            r9.k0(r5, r7, this.a.b);
            return;
        L9:
            return;
        }
    }

    public static final class c implements t39.w {
        public c() {
        }

        public final void a(boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            FLogger.a.i("AppUploadLogMethod", "onUploadLogResult success is " + r4 + ", msg is " + r5);
        }
    }

    static {
    }

    public final String getName() {
        return "app.uploadLog";
    }

    public p0() {
        this.b = new c();
        this.c = new b(this);
    }

    public final void a(dx7.b r8, ux7.d.d r9, IvyBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "type");
        int r11 = cx7.a.c(r8, "scene");
        FLogger.a.d("AppUploadLogMethod", "AppUploadLogMethod, scene=" + r11);
        JSONObject r12 = AccountTrackService.a.getLoginInfo();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r1 = new LinkedHashMap();
        if (r12 == null) goto L5;
        r1.put("login_info", r12.toString());
    L5:
        IDoraAVLinkService r13 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r13 == null) goto L10;
        String r14 = r13.q();
        if (r14 == null) goto L10;
        r1.put("dora_wake_history", r14);
    L10:
        r0.put(LynxResourceModule.DATA_KEY, r1);
        r9.invoke(r0);
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L13;
        IDoraService.c.a(r2, 3, this.c, true, true, false, 16);
    L13:
        FeedbackServiceDelegate.b.e(r8);
    }
}
