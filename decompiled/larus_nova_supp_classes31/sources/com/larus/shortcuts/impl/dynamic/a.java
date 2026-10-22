package com.larus.shortcuts.impl.dynamic;

import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.b;
import com.larus.platform.api.c;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static volatile List<tw9.a> e;
    public static boolean f;

    /* JADX INFO: renamed from: com.larus.shortcuts.impl.dynamic.a$a, reason: collision with other inner class name */
    public static final class C0030a implements b {
        public C0030a() {
        }

        public final void a(c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void b(c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            DynamicShortcutsManager.a();
            a.f = false;
        }
    }

    static {
        a = AppHost.a.getAppName() + "_dynamic_";
        b = "camera";
        c = "call";
        d = "scan";
        AccountService.a.E(new C0030a());
    }

    public static List b(boolean r12, String r13) {
        ArrayList r0 = new ArrayList();
        if (r12 == false) goto L8;
        if (r13 != null) goto L6;
        String r14 = "";
    L7:
        Intrinsics.checkNotNullParameter(r14, "cvsID");
        String r4 = a + b;
        AppHost.Companion r15 = AppHost.a;
        r0.add(new tw9.a(r4, r15.getApplication().getString(2131900535), r15.getApplication().getString(2131900535), 1, "sslocal://flow/chat?is_from_outer=true&auto_open_plus_camera=1&open_method=long_press_icon_camera", 2131240690, null, 192));
        goto L8
    L6:
        r14 = r13;
    L8:
        if (r13 == null) goto L10;
        Intrinsics.checkNotNullParameter(r13, "cvsID");
        String r3 = a + c;
        AppHost.Companion r16 = AppHost.a;
        r0.add(new tw9.a(r3, r16.getApplication().getString(2131900478), r16.getApplication().getString(2131900478), 1, "sslocal://flow/realtime_chat?is_from_outer=true&conversation_id=" + r13 + "&open_method=long_press_icon_call&previous_page=landing&enter_from=landing&enter_method=landing", 2131240691, null, 192));
    L10:
        String r2 = a + d;
        AppHost.Companion r17 = AppHost.a;
        r0.add(new tw9.a(r2, r17.getApplication().getString(2131898395), r17.getApplication().getString(2131898395), 1, "sslocal://flow/chat?is_from_outer=true&auto_open_plus_camera=1&capture_scene=scan_qr_code&open_method=long_press_icon_scan", 2131240692, null, 192));
        return r0;
    }

    public static void a(boolean r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "cvsID");
        if (f == false) goto L5;
        return;
    L5:
        if (AppHost.a.isPlugin() == true) goto L27;
        boolean r1 = false;
        if (r9.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L30;
        f = true;
        int r2 = DynamicShortcutsManager.a;
        if (r8 == true) goto L16;
        r9 = null;
    L16:
        List r10 = b(r7, r9);
        Intrinsics.checkNotNullParameter(r10, "shortcutInfoList");
        if (Build.VERSION.SDK_INT < 25) goto L19;
        r1 = true;
    L19:
        if (r1 == true) goto L22;
        FLogger.a.e("DynamicShortcutsManager", "the os version is not support");
        return;
    L22:
        if (((ArrayList) r10).isEmpty() == false) goto L24;
        DynamicShortcutsManager.a();
        return;
    L24:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DynamicShortcutsManager$tryAddShortcut$1(r10, null), 3, null);
        return;
    L30:
        return;
    L9:
        r0 = false;
        goto L10
    }
}
